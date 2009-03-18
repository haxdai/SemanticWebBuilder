/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.IO;
using System.Collections;
using System.Text;
using System.Diagnostics;
using System.Drawing;
using System.Net;
using System.Windows.Forms;
using System.Net.Security;
using System.Security.Cryptography.X509Certificates;

namespace WBOffice3
{
	/// <summary>Evento asociado al envio de un conjunto de bytes de un archivo</summary>
	/// <param name="bytessend">Número de bytes enviados</param>
	/// <param name="file">Archivo que se esta enviando</param>
	
	public delegate void SendDataEvent(long bytessend,FileInfo file);   // delegate declaration
	/// <summary>Evento asociado a la descarga de un archivo</summary>
	/// <param name="bytesdosnloaded">Número de bytes recibidos</param>
	/// <param name="totalbytes">Número total de bytes a recibir</param>
	/// <param name="file">Archivo donde se esta almacenando la descarga</param>
	public delegate void DownloadDataEvent(long bytesdosnloaded,long totalbytes,FileInfo file);   // delegate declaration
	/// <summary>Evento asociado a la terminación de una carga o descarga de archivo</summary>
	public delegate void EndSendDataEvent();
	/// <summary>Clase asociada a la "subida" de un archivo al servidor</summary>
	public class CFileUpload
	{
		private String separator=null;
		private String separatorheader=null;

		/// <summary>Evento de envio de datos</summary>
		public event SendDataEvent Send;
		/// <summary>Evento de descarga de archivos</summary>
		public event DownloadDataEvent Download;
		/// <summary>Evento en caso de fin de transmisión o recepción</summary>
		public event EndSendDataEvent EndSendData;
		/// <summary>
		/// Archivo a enviar al servidor
		/// </summary>
		protected FileInfo file;
		/// <summary>
		/// Parametros de envio
		/// </summary>
		protected ParameterCollection parameters;		
		CUserAdmin user;
		/// <summary>Contruye un archivo para subir al servidor</summary>
		/// <param name="file">Archivo a enviar</param>
		/// <param name="parameters">Parametros asociados</param>
		/// <param name="user">Usuario que lo esta subiendo</param>
		public CFileUpload(FileInfo file,ParameterCollection parameters,CUserAdmin user)
		{
			
			//
			// TODO: Add constructor logic here
			//			
			this.user=user;
			this.file=file;	
			this.parameters=parameters;
			separator="-----------------------------";
			separatorheader="---------------------------";
			Random r= new Random();
			for(int i=1;i<=14;i++)
			{
				int randomnumber=r.Next(29);
				String character=randomnumber.ToString("x");
				separator+=character;
				separatorheader+=character;
			}			
			parameters.Add(new Parameter("filenames","1"));
		}
        public bool CheckValidationResult(object sender, X509Certificate certificate, X509Chain chain, SslPolicyErrors sslPolicyErrors)
        {
            // Always accept
            return true;
        }
		/// <summary>Función que realiza la operación de obtener un archivo</summary>
		/// <param name="url">url de conexión con el servidor</param>
		public void doGetFile(String url)
		{
			//ServicePointManager.CertificatePolicy = new AcceptAllCertificatePolicy();
            ServicePointManager.ServerCertificateValidationCallback += new System.Net.Security.RemoteCertificateValidationCallback(this.CheckValidationResult);

			FileStream fout=null;

			HeaderCollection headers=new HeaderCollection();					
			
			System.Uri uri=null;				
			uri=new Uri(url+"work"+parameters[0].Value);			
			
			HttpWebRequest wreq=(HttpWebRequest)HttpWebRequest.CreateDefault(uri);
            
			try
			{
				if(user.ServerProxy!=null && user.ServerProxy!="")
				{					
					wreq.Proxy=new WebProxy(user.ServerProxy+":"+user.PortServerProxy);
				}	
				else
				{
                    wreq.Proxy = HttpWebRequest.DefaultWebProxy;
					/*if(WebProxy.GetDefaultProxy()!=null && WebProxy.GetDefaultProxy().Address!=null)
					{
						wreq.Proxy=WebProxy.GetDefaultProxy();
					}*/
				}
				HttpWebResponse wresponse=(HttpWebResponse)wreq.GetResponse();
				
				if(wresponse.StatusCode==HttpStatusCode.OK)
				{
					long length=wresponse.ContentLength;						
					Stream  ns=wresponse.GetResponseStream();					
					try
					{
						fout=file.Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);
						byte[] buffer = new byte[8192];
						int ret = ns.Read(buffer, 0, buffer.Length);
						int totalread=0;				
						while(ret != 0) 
						{		
							totalread+=ret;
							this.OnDownload(totalread,length,file);
							fout.Write(buffer,0,ret);					
							ret = ns.Read(buffer, 0, buffer.Length);						
						}									
						fout.Flush();	
						fout.Close();						
						fout=null;	
					}
					catch(IOException ioe)
					{
						Debug.WriteLine(ioe.Message);
						Debug.WriteLine(ioe.StackTrace);
						if(fout!=null)
						{
							try
							{
								fout.Close();
							}
							catch
							{
							}
						}
					}	
					finally
					{
						try
						{
							ns.Close();
						}
						catch{}
					}
				}
				else
				{
					MessageBox.Show("Error: File not found or server Error "+wresponse.StatusCode,"Error",MessageBoxButtons.OK,MessageBoxIcon.Error);
					Debug.WriteLine("Metodo: doGetFile(String url) Error en petición de archivo: "+url+ " Error Code sent: "+wresponse.StatusCode);
				}					
				wresponse.Close();
				
			}
			catch(Exception e)
			{
				uri=new Uri(url+"work"+parameters[1].Value);		
				wreq=(HttpWebRequest)HttpWebRequest.CreateDefault(uri);
				try
				{
					if(user.ServerProxy!=null && user.ServerProxy!="")
					{					
						wreq.Proxy=new WebProxy(user.ServerProxy+":"+user.PortServerProxy);
					}	
					else
					{
                        wreq.Proxy = HttpWebRequest.DefaultWebProxy;
						/*if(WebProxy.GetDefaultProxy()!=null && WebProxy.GetDefaultProxy().Address!=null)
						{
							wreq.Proxy=WebProxy.GetDefaultProxy();
						}*/
					}
					HttpWebResponse wresponse=(HttpWebResponse)wreq.GetResponse();
				
					if(wresponse.StatusCode==HttpStatusCode.OK)
					{
						long length=wresponse.ContentLength;						
						Stream  ns=wresponse.GetResponseStream();					
						try
						{
							fout=file.Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);
							byte[] buffer = new byte[8192];
							int ret = ns.Read(buffer, 0, buffer.Length);
							int totalread=0;				
							while(ret != 0) 
							{		
								totalread+=ret;
								this.OnDownload(totalread,length,file);
								fout.Write(buffer,0,ret);					
								ret = ns.Read(buffer, 0, buffer.Length);						
							}									
							fout.Flush();	
							fout.Close();						
							fout=null;	
						}
						catch(IOException ioe)
						{
							Debug.WriteLine(ioe.Message);
							Debug.WriteLine(ioe.StackTrace);
							if(fout!=null)
							{
								try
								{
									fout.Close();
								}
								catch
								{
								}
							}
						}	
						finally
						{
							try
							{
								ns.Close();
							}
							catch{}
						}
					}
					else
					{
						MessageBox.Show("Error: File not found or server Error "+wresponse.StatusCode,"Error",MessageBoxButtons.OK,MessageBoxIcon.Error);
						Debug.WriteLine("Metodo: doGetFile(String url) Error en petición de archivo: "+url+ " Error Code sent: "+wresponse.StatusCode);
					}					
					wresponse.Close();
				
				}
				catch
				{
					MessageBox.Show("Error: "+e.Message+"\r\n"+e.StackTrace,"Error",MessageBoxButtons.OK,MessageBoxIcon.Error);
				}
				
			}
			return;			
				
		}
		
		/// <summary>
		/// Convierte una cadena de caracteres a formato Hexadecimal en base a código
		/// ascii
		/// </summary>
		/// <returns>La cadena convertida en formato hexadecimal</returns>
		/// <param name="dato">String a convertir</param>
		public static String StringToHex(String dato)
		{			
			byte[] b=Encoding.Default.GetBytes(dato);
			String hits = "0123456789ABCDEF";
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < b.Length; i++)
			{
				int j = ((int) b[i]) & 0xFF;

				char first = hits[j / 16];
				char second = hits[j % 16];

				sb.Append(first);
				sb.Append(second);
			}

			return sb.ToString();

		}
		/// <summary>Sube un archivo al servidor</summary>
		public HtmlResponse doPost(String url)
		{
			
            ServicePointManager.ServerCertificateValidationCallback += new System.Net.Security.RemoteCertificateValidationCallback(this.CheckValidationResult);
			HtmlResponse resp=new HtmlResponse();
			int totalprotocol=0;
			try
			{
				FileStream fout=null;
				HttpWebRequest request=(HttpWebRequest)HttpWebRequest.CreateDefault(new Uri(url));
				if(user.ServerProxy!=null && user.ServerProxy!="")
				{					
					request.Proxy=new WebProxy(user.ServerProxy+":"+user.PortServerProxy);
				}
				else
				{
                    request.Proxy = HttpWebRequest.DefaultWebProxy;
					/*if(WebProxy.GetDefaultProxy()!=null && WebProxy.GetDefaultProxy().Address!=null)
					{
						request.Proxy=WebProxy.GetDefaultProxy();
					}*/
				}
				request.Method="POST";
				request.ContentType="uploadfile";
				
				foreach(Parameter p in parameters)
				{
					//headers.Add(new HtmlHeader(p.Name,p.Value)); 						
					request.Headers.Add(p.Name,p.Value);
				}
				String contentdisp="Content-Disposition: form-data; name=\"file\"; filename=\""+ file.FullName +"\"\r\n\r\n";

				request.Headers.Add("Content-Disposition","form-data; name=\"file\"; filename=\""+ file.FullName +"\"");

				long totalbytes=separator.Length+2+contentdisp.Length+file.Length+2+separator.Length+2;
				foreach(Parameter p in parameters)
				{
					String data="Content-Disposition: form-data; name=\""+ p.Name +"\"\r\n\r\n"+p.Value+"\r\n";
					totalbytes+=data.Length+separator.Length+2;
				}					
				if(CRequest.sesion!=null)
				{					
					if(CRequest.cookies!=null)
					{
						foreach(String cookie in CRequest.cookies)
						{							
							request.Headers.Add("Cookie",cookie);
						}
					}
				}	
				//String filename=StringToHex(this.file.Name);
				String filename=StringToHex(this.file.Name);
				//request.Headers.Add("Connection","Keep-Alive"); 			
				request.Headers.Add("file",filename); 			
				request.Headers.Add("codename", Encoding.Default.BodyName); 			
				
				String datasubmit="Content-Disposition: form-data; name=\"submit\"\r\n\r\nsend\r\n";
				totalbytes+=datasubmit.Length+separator.Length+4;
				request.ContentLength=file.Length;
				
				byte[] buffer = new byte[8192];
				Stream ns=request.GetRequestStream();

                fout = file.Open(FileMode.Open, FileAccess.Read, FileShare.ReadWrite);
				int totalsend=0;
				int iread=fout.Read(buffer,0,buffer.Length);								
				while(iread>0)
				{
					ns.Write(buffer,0,iread);
					totalsend+=iread;
					totalprotocol+=iread;
					this.OnSend(totalsend,file);
					buffer = new byte[8192];
					iread=fout.Read(buffer,0,buffer.Length);
				}
                fout.Close();

				ns.Flush();
				//recibe la llamada
				buffer = new byte[8192];
				ns.Close();
				HttpWebResponse response=(HttpWebResponse)request.GetResponse();
				ns=response.GetResponseStream();
				int ret = ns.Read(buffer, 0, buffer.Length);
				
				StringBuilder sresp=new StringBuilder();
				while(ret != 0) 
				{				
		
					sresp.Append(Encoding.UTF8.GetString(buffer, 0, ret));					
					ret = ns.Read(buffer, 0, buffer.Length);
						
				}			
				//ns.Close(); 
				ns.Close();	

				//Entrega la respuesta
				try
				{
					if(sresp.Length>0)
					{
						if(sresp[sresp.Length-1]==' ')
						{
							sresp.Remove(sresp.Length-1,1);
						}
					}
				}
				catch(Exception ues)
				{
					Debug.WriteLine(ues.Message); 
					//CConfig.GuardaMensaje(ues.Message);
				}
				resp=new HtmlResponse(sresp.ToString()); 
				return resp;
			}
			catch(Exception e)
			{
				Debug.WriteLine(e.Message);
				Debug.WriteLine(e.StackTrace);
			}
			resp=new HtmlResponse(); 
			return resp;
			
			
		}		
		/// <summary>Función que realiza la operación de obtener un archivo</summary>
		public void getFile()
		{
			doGetFile(user.Uri);
			if(EndSendData!=null)
			{
				EndSendData();
			}
		}
		/// <summary>Envia un archivo al servidor</summary>
		public void send()
		{
			try
			{
				if(file.Exists && file.Length>0)
				{
					this.doPost(user.Uri+"gtwoffice");
				}
			}			
			catch(Exception e)
			{				
				Debug.WriteLine(e.StackTrace);				
			}
			finally
			{
				if(EndSendData!=null)
				{
					EndSendData();
				}
			}
		}
		
		/// <summary>Archivo a descargar o descargar</summary>
		/// <value>Regresa el archivo a subir o a descargar</value>
		public FileInfo File
		{
			get
			{
				return this.file;
			}
		}
		/// <summary>
		/// Evento de envio de archivo als ervidor
		/// </summary>
		/// <param name="bytessend">Bytes enviados</param>
		/// <param name="file">Archivo que se esta transmitiendo</param>
		protected virtual void OnSend(long bytessend,FileInfo file) 
		{
			if (Send != null)
				Send(bytessend, file);
		}
		/// <summary>
		/// Evento de descarga de archivo
		/// </summary>
		/// <param name="bytesdosnloaded">Bytes recibidos</param>
		/// <param name="totalbytes">Total de bites a recibir</param>
		/// <param name="file">Archivo que se esta recibiendo</param>
		protected virtual void OnDownload(long bytesdosnloaded,long totalbytes,FileInfo file) 
		{
			if (Download != null)
				Download(bytesdosnloaded,totalbytes, file);
		}
	}
}
