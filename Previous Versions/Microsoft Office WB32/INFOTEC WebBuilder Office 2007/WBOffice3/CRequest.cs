/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Xml;
using System.IO;
using System.Text;
using System.Collections;
namespace WBOffice3
{
	/// <summary>Clase que se encarga de las peticiones al servidor</summary>
	public class CRequest
	{
		/// <summary>Propiedad que contiene las cookies que ha enviado el servidor</summary>
		/// <value>Regresa un ArrayList de cookies que el servidor ha enviado</value>
		public static ArrayList cookies=new ArrayList();
		CUserAdmin user;
		private String Transforma(String dato)
		{
			byte[] text=System.Text.Encoding.Default.GetBytes(dato); 
			String newatt=Encoding.Default.GetString(Encoding.Convert(Encoding.Default,Encoding.UTF8,text));						
			return newatt;
		}
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>Propiedad que contiene la sesi�n actual de comunicaci�n</summary>
		/// <value>Regresa la session de comunicaci�n</value>
		public static String sesion=null;
		/// <summary>Propiedad que contiene el ID sesi�n actual de comunicaci�n</summary>
		/// <value>Propiedad que contiene el ID sesi�n actual de comunicaci�n</value>
		public static String idsesion=null;
		private XmlDocument req=new XmlDocument();  		
		ParameterCollection parameters=new ParameterCollection();
		XmlElement xmlcmd;
		XmlElement xmlusr;
		XmlElement xmlreq;
		XmlElement xmlpwd;
		XmlElement xmlprm;
		private String op;
		/// <summary>Parametros que contiene la petici�n, para generar XML</summary>
		/// <value>Parametros que contiene la petici�n, para generar XML</value>
		public ParameterCollection Parameters
		{
			get
			{
				return parameters;
			}
			set
			{
				parameters=value;
			}
		}
		/// <summary>Operaci�n que esta ejecutando</summary>
		/// <value>Nombre de la operaci�n a ejecutar</value>
		public String Operation
		{
			get
			{
				return op;
			}
			set
			{
				op=value;
				xmlcmd.InnerText=Transforma(op); 
				
			}
		}
		
		/// <summary>Contruye una petici�n al servidor</summary>
		/// <param name="op">Operaci�n a ejecutar</param>
		/// <param name="admin">Usuario que ejecuta la operaci�n</param>
		public CRequest(String op,CUserAdmin admin)
		{
			//
			// TODO: Add constructor logic here
			//
			this.user=admin;
			this.op=op; 			
			req.AppendChild(req.CreateXmlDeclaration("1.0","UTF-8",null));						
			xmlreq=req.CreateElement("req");
			req.AppendChild(xmlreq); 
			if(CRequest.sesion==null)
			{
				xmlusr=req.CreateElement("usr");  		
				xmlusr.AppendChild(req.CreateTextNode(Transforma(admin.User)));
				xmlreq.AppendChild(xmlusr);
				xmlpwd=req.CreateElement("pwd");
				xmlpwd.InnerText=Transforma(admin.Password) ; 
				xmlreq.AppendChild(xmlpwd);
			}
			xmlprm=req.CreateElement("prm");
			xmlprm.InnerText=""; 
			xmlreq.AppendChild(xmlprm);
			xmlcmd=req.CreateElement("cmd");
			xmlcmd.InnerText=Transforma(""+op);
			xmlreq.AppendChild(xmlcmd);
		}
		/// <summary>Obtiene los Headers de la respuesta</summary>
		/// <param name="resp">La respuesta de la petici�n</param>
		public static void getHeaders(HtmlResponse resp)
		{
			foreach(HtmlHeader h in resp.Headers)
			{					
				if(h.Header.ToLower().Equals("set-cookie") && h.Value.ToLower().IndexOf("jsession")!=-1)
				{
				{
					String sheader=h.Header;
					char[] separator={';'};
					String[] values=h.Value.Split(separator);
					if(values!=null)
					{
						if(values.Length>=1)
						{
							CRequest.sesion=values[0];
							char[] separator2={'='};
							String[] datos=values[0].Split(separator2);
							CRequest.idsesion= datos[1];
						}								
					}
				}
					cookies=new ArrayList();
					foreach(HtmlHeader header in resp.Headers)
					{					
						if(header.Header.ToLower().Equals("set-cookie"))
						{
							String sheader=header.Header;							
							char[] separator={';'};
							String[] values=header.Value.Split(separator);
							if(values!=null)
							{
								if(values.Length>1)
								{										
									cookies.Add(values[0]);
								}
							}
						}
					}
				}

			}
		}
		/// <summary>Realiza la petici�n</summary>
		/// <returns>Obtiene el XML resultado de la petici�n</returns>
		public System.Xml.XmlDocument Request()
		{
			String url=user.Uri+"gtwoffice";											
			int tam=req.OuterXml.Length;										
			foreach(IParameter p in this.parameters)
			{				
				System.Xml.XmlElement e=req.CreateElement(p.Name);				
				if(p.IsFile)
				{
					FileParameter filep=(FileParameter)p;					
					String filename=filep.FileInfo.Name;									
					String archivo=System.Convert.ToBase64String(filep.Content);
					e.AppendChild(req.CreateCDataSection(archivo));					
				}
				else
				{
					String newtext="";
					char[] texto=p.Value.ToCharArray(0,p.Value.Length);
					foreach(char c in texto)
					{
						if((int)c>256)
						{
							newtext+="&#"+(int)c+";";
						}
						else
						{
							newtext+=c;
						}
					}
					p.Value=newtext; 
					e.InnerText=Transforma(p.Value); 
				}
				foreach(Attribute att in p.Attributes)
				{
					String newtext="";
					char[] texto=att.Value.ToCharArray(0,att.Value.Length);
					foreach(char c in texto)
					{
						if((int)c>256)
						{
							newtext+="&#"+(int)c+";";
						}
						else
						{
							newtext+=c;
						}
					}
					att.Value=newtext; 
					e.SetAttribute(att.Name,Transforma(att.Value));  
				}
				tam+=e.OuterXml.Length; 
				xmlprm.AppendChild(e);				
			}			
			HeaderCollection headers=new HeaderCollection(); 
			if(sesion!=null)
			{				
				//headers.Add(new HtmlHeader("Cookie",sesion));
				if(cookies!=null)
				{
					foreach(String cookie in cookies)
					{
						headers.Add(new HtmlHeader("Cookie",cookie));
					}
				}
			}			
			HtmlResponse resp=new CHttpClient(user).doPost(url,ref req,headers,tam,true);
			if(resp.State==200)
			{
				getHeaders(resp);
			}
			XmlDocument doc = new XmlDocument();			
			if(resp.State==200)
			{				
				
				try
				{
					doc=resp.XML;
					System.Xml.XmlNodeList  errores=doc.GetElementsByTagName("err");
					foreach(System.Xml.XmlElement error in errores)
					{
						if(error.GetElementsByTagName("id").Count>0)
						{
							String iderror=error.GetElementsByTagName("id")[0].InnerText;
							if(iderror.Equals("1"))
							{
								// error de usuario no conectado, trata de reconectarse
								CRequest.idsesion=null;
								CRequest.sesion=null;
								Servicios s= new Servicios(user); 
								s.login();
								if(!s.IsError)
								{
									headers=new HeaderCollection(); 
									if(sesion!=null)
									{				
										headers.Add(new HtmlHeader("Cookie",sesion));
									}
									resp=(new CHttpClient(user).doPost(url,ref req,headers,tam,true));								
									try
									{
										doc=resp.XML;
										return doc;
									}
									catch(System.Xml.XmlException  xmle)
									{
										Console.Write(xmle.Message);
										System.Xml.XmlElement xmlerr=doc.CreateElement("err");				
										System.Xml.XmlElement xmlid=doc.CreateElement("id");
										xmlid.InnerText="-1000";				
										System.Xml.XmlElement xmlmessage=doc.CreateElement("message");
										xmlmessage.InnerText=resources.GetString("CRequest.msg5");
										xmlerr.AppendChild(xmlid); 
										xmlerr.AppendChild(xmlmessage); 					
										doc.AppendChild(xmlerr);
									}

								}
							}
						}
						else
						{
							System.Windows.Forms.MessageBox.Show("Unknown error in the server",resources.GetString("Global.title"),System.Windows.Forms.MessageBoxButtons.OK,System.Windows.Forms.MessageBoxIcon.Error);
						}
					}
				}
				catch(System.Xml.XmlException  xmle)
				{
					Console.Write(xmle.Message);
					System.Xml.XmlElement xmlerr=doc.CreateElement("err");				
					System.Xml.XmlElement xmlid=doc.CreateElement("id");
					xmlid.InnerText="-1000";				
					System.Xml.XmlElement xmlmessage=doc.CreateElement("message");
					xmlmessage.InnerText=resources.GetString("CRequest.msg5");
					xmlerr.AppendChild(xmlid); 
					xmlerr.AppendChild(xmlmessage); 					
					doc.AppendChild(xmlerr);
				}
				
				
			}
			else
			{
				if(resp.State==500)
				{
					System.Xml.XmlElement xmlerr=doc.CreateElement("err");				
					System.Xml.XmlElement xmlid=doc.CreateElement("id");
					xmlid.InnerText="-500";				
					System.Xml.XmlElement xmlmessage=doc.CreateElement("message");
					xmlmessage.InnerText=resources.GetString("CRequest.msg5");
					xmlerr.AppendChild(xmlid); 
					xmlerr.AppendChild(xmlmessage); 					
					doc.AppendChild(xmlerr);
					/*if(resp.Html.Trim()!="")
					{
						FrmError fx=new FrmError(resp.Html);
						fx.ShowDialog();	
					}*/
				}
				else if(resp.State==404)
				{
					System.Xml.XmlElement xmlerr=doc.CreateElement("err");				
					System.Xml.XmlElement xmlid=doc.CreateElement("id");
					xmlid.InnerText="-404";				
					System.Xml.XmlElement xmlmessage=doc.CreateElement("message");
					xmlmessage.InnerText=resources.GetString("CRequest.msg6");
					xmlerr.AppendChild(xmlid); 
					xmlerr.AppendChild(xmlmessage); 					
					doc.AppendChild(xmlerr);
					/*if(resp.Html.Trim()!="")
					{
						FrmError fx=new FrmError(resp.Html);
						fx.ShowDialog();	
					}*/
				}
				else
				{
					System.Xml.XmlElement xmlerr=doc.CreateElement("err");				
					System.Xml.XmlElement xmlid=doc.CreateElement("id");
					xmlid.InnerText="-404";				
					System.Xml.XmlElement xmlmessage=doc.CreateElement("message");
					xmlmessage.InnerText=resources.GetString("CRequest.msg5");
					xmlerr.AppendChild(xmlid); 
					xmlerr.AppendChild(xmlmessage); 					
					doc.AppendChild(xmlerr);
					/*if(resp.Html.Trim()!="")
					{
						FrmError fx=new FrmError(resp.Html);
						fx.ShowDialog();	
					}*/
				}
			}
			return doc;
		}
		
	}
}
