/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.IO;
using System.Xml; 
using System.Windows.Forms;

namespace WBOffice3
{
	/// <summary>Clase encargada de almacenar la configuración existente en el plug-in</summary>
	public class CConfig
	{
		private String path="";
		private String dirweb="";
		System.Xml.XmlDocument doc;
		private String user="";
		private String pass="";
		private String serverproxy;
		private int portproxy=80;
		/// <summary>Propiedad que indica cual el la direción del servidor proxy</summary>
		/// <value>
		/// La direción del servidor proxy, puede ser nula si no existe configuración de
		/// proxy
		/// </value>
		public String ServerProxy
		{
			get
			{
				return serverproxy;
			}
			set
			{
				serverproxy=value;
				doc.ChildNodes[0].ChildNodes[4].InnerText=this.serverproxy;
			}
		}
		/// <summary>Indica el puerto del servidor proxy</summary>
		/// <value>
		/// El puerto de configuración del servidor proxy, 0 si no existe
		/// configuración
		/// </value>
		public int PortProxy
		{
			get
			{
				return portproxy;
			}
			set
			{
				portproxy=value;
				doc.ChildNodes[0].ChildNodes[5].InnerText=""+this.portproxy;
			}
		}
		/// <summary>Dirección de conexión con el servidor</summary>
		/// <value>Dirección de conexión con el servidor</value>
		public String Web
		{
			get
			{
				return dirweb;
			}
			set
			{
				dirweb=value;
				doc.ChildNodes[0].ChildNodes[0].InnerText=this.dirweb;
			}
		}
		/// <summary>Indica la información del usuario actual</summary>
		/// <value>Regresa el usuario actual que esta utilizando la aplicación</value>
		public String User
		{
			get
			{
				return user;
			}
			set
			{
				user=value;
				doc.ChildNodes[0].ChildNodes[1].InnerText=this.user;
			}
		}
		private string startup="0";
		/// <summary>
		/// Indica si se debe presentar la pantalla de loggin al momento de iniciar la
		/// aplicación que contiene el plug-in, ya sea en Word, Excel o PowerPoint
		/// </summary>
		/// <value>1 si se debe iniciar, 0 si no</value>
		public String Startup
		{
			get
			{
				return startup;
			}
			set
			{
				startup=value;
				if(doc.GetElementsByTagName("startup").Count>0)
				{
					doc.GetElementsByTagName("startup")[0].InnerText=this.startup;
				}
				else
				{
					System.Xml.XmlElement elestartup=doc.CreateElement("startup"); 
					doc.ChildNodes[0].AppendChild(elestartup);
				}
			}
		}
		/// <summary>Propiedad que almacena el password actual del usuario</summary>
		public String Password
		{
			get
			{
				return pass;
			}
			set
			{
				pass=value;
				doc.ChildNodes[0].ChildNodes[2].InnerText=this.pass;
			}
		}
		/// <summary>
		/// Contruye uel objeto CConfig, y si existe el archivo de configuración, lo
		/// lee
		/// </summary>
		public CConfig()
		{
			//
			// TODO: Add constructor logic here
			//			
			
			//this.path=@"c:\conf.xml";

			
			this.path =Application.StartupPath+@"\configwb2.xml"; 
			FileInfo file=new FileInfo(this.path);
			if(!file.Exists || file.Length==0)
			{
				this.path =Application.LocalUserAppDataPath+@"\configwb2.xml"; 
			}
			try
			{	
				OpenConfigFile(path);							
			}
			catch
			{
				this.path =Application.LocalUserAppDataPath+@"\configwb2.xml"; 
                OpenConfigFile(path);				
			}
		}
		
		/// <summary>Path</summary>
		public String Path
		{
			get
			{
				return path;
			}
			set
			{
				if(OpenConfigFile(value))
				{
					path=value;
				}
			}

		}
		/// <summary>Almacena los cambio realizados en la configuración en archivo.</summary>
		public void Save()
		{
			
			doc.Save(path);
			
		}
		private bool OpenConfigFile(String path)
		{
			doc=new  System.Xml.XmlDocument();			
			if(System.IO.File.Exists(path))
			{
				try
				{
					doc.Load(path); 
					this.Web=doc.GetElementsByTagName("DirWeb")[0].InnerText;
					this.user=doc.GetElementsByTagName("user")[0].InnerText;
					this.pass =doc.GetElementsByTagName("password")[0].InnerText;
					if(doc.GetElementsByTagName("startup").Count>0)
					{
						this.startup=doc.GetElementsByTagName("startup")[0].InnerText;
					}
					this.serverproxy=doc.ChildNodes[0].ChildNodes[4].InnerText;  
					this.portproxy=Int32.Parse(doc.ChildNodes[0].ChildNodes[5].InnerText); 
				}
				catch(Exception e)
				{
					System.Console.Write(e.Message);   
					return false;
				}
			}
			else
			{
				try
				{
					System.Xml.XmlElement root=doc.CreateElement("Configuracion");					
					System.Xml.XmlElement odirweb=doc.CreateElement("DirWeb");
					System.Xml.XmlElement xmluser=doc.CreateElement("user");
					System.Xml.XmlElement xmlpass=doc.CreateElement("password");
					System.Xml.XmlElement xmlstarup=doc.CreateElement("startup");
					System.Xml.XmlElement xmlserverproxy=doc.CreateElement("proxyserver");
					System.Xml.XmlElement xmlportserver=doc.CreateElement("portproxyserver");
					odirweb.InnerText=this.dirweb;
					xmlserverproxy.InnerText=this.serverproxy; 
					xmlportserver.InnerText=""+this.portproxy; 
					doc.AppendChild(root);
					root.AppendChild(odirweb);
					root.AppendChild(xmluser);
					root.AppendChild(xmlpass);
					root.AppendChild(xmlstarup);
					root.AppendChild(xmlserverproxy);
					root.AppendChild(xmlportserver);
					doc.Save(path); 							
				}
				catch(Exception e)
				{
					System.Console.Write(e.Message);   
					return false;
				}
			}
			
			return true;
		}
	}
}