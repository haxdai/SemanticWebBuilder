/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.IO;
using System.Text;
using System.Net;
using System.Net.Sockets;
using System.Security.Cryptography; 
using System.Diagnostics;
using System.Xml;
using System.Collections;
using System.Net.Security;
using System.Security.Cryptography.X509Certificates;

namespace WBOffice3
{

	/// <summary>
	/// Summary description for CHttpClient.
	/// </summary>
	class CHttpClient
	{
		
		
		CUserAdmin user;
		/// <summary>Clase encargada de la comunicación con el servidor</summary>
		/// <param name="user">Usuario que esta haciendo la conexión</param>
		public CHttpClient(CUserAdmin user)
		{	
			this.user=user;
			Debug.AutoFlush=true;			
			/*foreach(System.Diagnostics.TraceListener tl in Debug.Listeners)
			{
				if(tl.Name!=null && tl.Name=="wb.log")
				{
					return;
				}
			}
			TextWriterTraceListener currentTL=new System.Diagnostics.TextWriterTraceListener(@"c:\wb.log");
			currentTL.Name="wb.log";
			Debug.Listeners.Add(currentTL);*/
			
			
		}		
		/// <summary>
		/// Indica si lo tiene que hacer enviando paquete por paquete o usando modo
		/// avanzado
		/// </summary>
		/// <value>true debe enviar paquete por paquete, false modo avanzado</value>
		public static bool oldmode=false;
		
		/// <summary>Envia una petición al servidor</summary>
		/// <returns>Respuesta de la petición</returns>
		/// <param name="url">URL de conexión</param>
		/// <param name="doc">Documento a enviar en formato XML</param>
		/// <param name="headers">Headers asociados</param>
		/// <param name="length">Longitud del documento XML</param>
		/// <param name="relogin">Indica si tiene que volver a "loguearse" al servidor</param>
		public HtmlResponse doPost(String url,ref System.Xml.XmlDocument doc,HeaderCollection headers,int length,bool relogin)
		{
			//ServicePointManager.CertificatePolicy = new AcceptAllCertificatePolicy();
            ServicePointManager.ServerCertificateValidationCallback += new System.Net.Security.RemoteCertificateValidationCallback(this.CheckValidationResult);

			HtmlResponse resp=new HtmlResponse();
			System.Text.StringBuilder sresp= new StringBuilder();
			try
			{
				
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
				request.ContentLength=length;
				foreach(HtmlHeader h in headers)
				{
					//sheaders+=h.Header +": "+h.Value+"\r\n";				
					if(h.Header.ToLower().Equals("content-type"))
					{
						request.ContentType=h.Value;
					}
					else
					{
						request.Headers.Add(h.Header,h.Value);
					}
				}
				
				Stream ns=request.GetRequestStream();

				System.Xml.XmlTextWriter txt=new XmlTextWriter(ns,Encoding.Default);															
				doc.WriteTo(txt);
				txt.Flush();
				
				ns.Close();
				byte[] buffer = new byte[8192];		
				try
				{
					HttpWebResponse response=(HttpWebResponse)request.GetResponse();
					ns=response.GetResponseStream();

					int ret = ns.Read(buffer, 0, buffer.Length);				

					
					System.Xml.XmlDocument docxml=new System.Xml.XmlDocument();
					System.IO.StreamReader readstream= new StreamReader(ns,Encoding.UTF8);
					if(oldmode)
					{
						while(ret != 0) 
						{					
							sresp.Append(Encoding.UTF8.GetString(buffer, 0, ret));
							ret = ns.Read(buffer, 0, buffer.Length);
						}	
					}
					else
					{
						try
						{
							docxml.Load(readstream);
						}
						catch(Exception exml)
						{
							oldmode=true;
							Debug.WriteLine(exml.Message); 
							ns.Close();						
							request=(HttpWebRequest)HttpWebRequest.CreateDefault(new Uri(url));
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
							request.ContentLength=length;
							request.ContentType="application/x-www-form-urlencoded";
							foreach(HtmlHeader h in headers)
							{
								//sheaders+=h.Header +": "+h.Value+"\r\n";				
								if(h.Header.ToLower().Equals("content-type"))
								{
									request.ContentType=h.Value;
								}
								else
								{
									request.Headers.Add(h.Header,h.Value);
								}
							}
							ns=request.GetRequestStream();						

							txt=new XmlTextWriter(ns,Encoding.Default);															
							doc.WriteTo(txt);
							txt.Flush();


							ns.Close();
							buffer = new byte[8192];	
							response=(HttpWebResponse)request.GetResponse();
							ns=response.GetResponseStream();
							ret = ns.Read(buffer, 0, buffer.Length);	
							while(ret != 0) 
							{					
								sresp.Append(Encoding.UTF8.GetString(buffer, 0, ret));
								ret = ns.Read(buffer, 0, buffer.Length);
							}	
						}
					}
					while(ret != 0) 
					{					
						sresp.Append(Encoding.UTF8.GetString(buffer, 0, ret));
						ret = ns.Read(buffer, 0, buffer.Length);
					}								 				
						
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
						Debug.WriteLine(ues.StackTrace); 
					}				
					resp=new HtmlResponse();
					try
					{
					
						docxml=new XmlDocument();
						docxml.LoadXml(sresp.ToString());
						resp.XML=docxml;					
					}
					catch(Exception e)
					{
						Debug.WriteLine(e.Message);
						Debug.WriteLine(e.StackTrace);
						resp.Html=sresp.ToString();
					}	
					foreach(String key in response.Headers.Keys)
					{
						String hvalue=response.Headers[key];
						resp.Headers.Add(new HtmlHeader(key,hvalue));
					}
					if(response.Cookies.Count>0)
					{					
						foreach(Cookie cookie in response.Cookies)
						{
							String svalue=cookie.Name+"="+cookie.Value+";";
							resp.Headers.Add(new HtmlHeader("Set-Cookie",svalue));
						}					
					}
					if(response.StatusCode==HttpStatusCode.OK)
						resp.State=200;	
					if(response.StatusCode==HttpStatusCode.Unauthorized)
						resp.State=401;	
					if(response.StatusCode==HttpStatusCode.InternalServerError)
						resp.State=500;	
					VerificaTexto(resp);
				}
				catch(Exception e)
				{
					if(e!=null && e.Message!=null && (e.Message.IndexOf("(401)")>0 || e.StackTrace.IndexOf("(401)")>0))
					{
						resp.State=401;
					}
				}
							
				

				
			}
			catch(Exception e)
			{
				Debug.WriteLine(e.Message);  
				Debug.WriteLine(e.StackTrace);  
				resp=new HtmlResponse(); 
			}
			Debug.WriteLine("resp.State: "+resp.State);
			Debug.WriteLine("resp.Html: "+resp.Html);
			if(resp.XML!=null)
			{
				Debug.WriteLine("resp.Html: "+resp.XML.InnerXml);
			}
			else
			{
				Debug.WriteLine("resp.Html (nulo): ");
			}
			if(resp.State==401 && relogin)
			{
				CRequest.cookies=new ArrayList();				
				CRequest.sesion=null;
				CRequest.idsesion=null;
				Servicios s=new Servicios(this.user);
				s.login();
				headers=new HeaderCollection(); 
				if(CRequest.sesion!=null)
				{				
					
					if(CRequest.cookies!=null)
					{
						foreach(String cookie in CRequest.cookies)
						{
							headers.Add(new HtmlHeader("Cookie",cookie));
						}
					}
				}	
				return doPost(url,ref doc,headers,length,false);
			}
			return 	resp;
		}

        public bool CheckValidationResult(object sender, X509Certificate certificate, X509Chain chain, SslPolicyErrors sslPolicyErrors)
        {
            // Always accept
            return true;
        }
		public HtmlResponse doPostLogin(String url,String login,String password,HeaderCollection headers)
		{
			
            ServicePointManager.ServerCertificateValidationCallback += new System.Net.Security.RemoteCertificateValidationCallback(this.CheckValidationResult);
			HtmlResponse resp=new HtmlResponse();
			System.Text.StringBuilder sresp= new StringBuilder();
			try
			{
				String paramuser="_wb_username="+login+"&_wb_password="+password;
				int tam=paramuser.Length;
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
				request.ContentLength=tam;
				request.ContentType="application/x-www-form-urlencoded";
				Stream ns=request.GetRequestStream();
				byte[] bcont=System.Text.Encoding.Default.GetBytes(paramuser);
				ns.Write(bcont,0,bcont.Length);
				ns.Close();
				byte[] buffer = new byte[8192];								
				HttpWebResponse response=null;
				try
				{
					response=(HttpWebResponse)request.GetResponse();
					ns=response.GetResponseStream();

					int ret = ns.Read(buffer, 0, buffer.Length);				
					System.Xml.XmlDocument docxml=new System.Xml.XmlDocument();
					System.IO.StreamReader readstream= new StreamReader(ns,Encoding.UTF8);
					if(oldmode)
					{
						while(ret != 0) 
						{					
							sresp.Append(Encoding.UTF8.GetString(buffer, 0, ret));
							ret = ns.Read(buffer, 0, buffer.Length);
						}	
					}
					else
					{
						try
						{
							docxml.Load(readstream);
						}
						catch(Exception exml)
						{
							oldmode=true;
							Debug.WriteLine(exml.Message); 
							ns.Close();						
							request=(HttpWebRequest)HttpWebRequest.CreateDefault(new Uri(url));
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
							request.ContentLength=tam;
							request.ContentType="application/x-www-form-urlencoded";
							
							ns=request.GetRequestStream();						
							bcont=System.Text.Encoding.Default.GetBytes(paramuser);
							ns.Write(bcont,0,bcont.Length);
							ns.Close();
							buffer = new byte[8192];	
							response=(HttpWebResponse)request.GetResponse();
							ns=response.GetResponseStream();
							ret = ns.Read(buffer, 0, buffer.Length);	
							while(ret != 0) 
							{					
								sresp.Append(Encoding.UTF8.GetString(buffer, 0, ret));
								ret = ns.Read(buffer, 0, buffer.Length);
							}	
						}
					}
					while(ret != 0) 
					{					
						sresp.Append(Encoding.UTF8.GetString(buffer, 0, ret));
						ret = ns.Read(buffer, 0, buffer.Length);
					}								 
					//client.Close();	
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
						Debug.WriteLine(ues.StackTrace); 
					}
					resp=new HtmlResponse(); 
					try
					{
						
						docxml=new XmlDocument();
						docxml.LoadXml(sresp.ToString());
						resp.XML=docxml;					
					}
					catch(Exception e)
					{
						Debug.WriteLine(e.Message);
						Debug.WriteLine(e.StackTrace);
						resp.Html=sresp.ToString();
					}				
					foreach(String key in response.Headers.Keys)
					{
						String hvalue=response.Headers[key];
						resp.Headers.Add(new HtmlHeader(key,hvalue));
					}				
					if(response.Cookies.Count>0)
					{					
						foreach(Cookie cookie in response.Cookies)
						{
							String svalue=cookie.Name+"="+cookie.Value+";";
							resp.Headers.Add(new HtmlHeader("Set-Cookie",svalue));
						}					
					}
					if(response.StatusCode==HttpStatusCode.OK)
						resp.State=200;	
					if(response.StatusCode==HttpStatusCode.Unauthorized)
						resp.State=401;	
					if(response.StatusCode==HttpStatusCode.InternalServerError)
						resp.State=500;						
					response.Close();
					response=null;
				}
				catch(Exception ue)
				{
					Debug.WriteLine(ue.Message);  
					Debug.WriteLine(ue.StackTrace);  
					resp=new HtmlResponse();
					resp.State=401;	
				}
				finally
				{
					if(response!=null)
					{
						try
						{
							response.Close();
						}
						catch{}
					}
				}
						
				VerificaTexto(resp);
			}
			catch(Exception e)
			{
				Debug.WriteLine(e.Message);  
				Debug.WriteLine(e.StackTrace);  
				resp=new HtmlResponse(); 
			}
			return 	resp;
		}
		
		private static void VerificaTexto(HtmlResponse resp)
		{
			if(resp.XML==null)
			{
				return;
			}
			String xml=resp.XML.OuterXml;
			int pos=xml.IndexOf("&amp;#");
			if(pos!=-1)
			{
				String newxml="";
				while(pos!=-1)
				{
					int pos2=xml.IndexOf(";",pos+6);
					int l=pos2-pos-6;
					String number=xml.Substring(pos+6,l);										
					try
					{
						int iNumber=Int32.Parse(number);
						if(iNumber==0)
						{
							char character=' ';
							newxml+=xml.Substring(0,pos)+character;
						}
						else
						{
							char character=(char)Int32.Parse(number);
							newxml+=xml.Substring(0,pos)+character;
						}						
						xml=xml.Substring(pos2+1);
						pos=xml.IndexOf("&amp;#");
					}
					catch
					{
						
						xml=xml.Substring(pos2+1);
						pos=xml.IndexOf("&amp;#");
					}
					
				}
				newxml+=xml;
				resp.XML=new XmlDocument();
				resp.XML.LoadXml(newxml);
			}
		}
		
		
		
		
	}
}