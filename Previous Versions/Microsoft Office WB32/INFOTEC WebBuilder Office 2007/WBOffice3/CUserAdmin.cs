/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Runtime.InteropServices;
using System.Xml;
using System.Windows.Forms;
using System.Collections;
namespace WBOffice3
{
	/// <summary>Clase que contiene la informaci�n del usuario actual</summary>

	
	
	public class CUserAdmin
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		ArrayList permisos=new ArrayList();
		ArrayList secciones=new ArrayList();
		/// <summary>Regresa las secciones a las que tiene permisos</summary>
		/// <returns>Regresa un ArrayList con las secciones a las que tiene acceso</returns>
		public ArrayList getSecciones()
		{
			return secciones;
		}
		
		
		private String serverproxy;
		/// <summary>Contiene la configuraci�n del proxy a utilizar en conexiones</summary>
		/// <value>La configuraci�n del proxy a utilizar en conexiones</value>
		public String ServerProxy
		{
			get
			{
				return serverproxy;
			}
			set
			{
				serverproxy=value;
			}
		}

		private int portserverproxy;
		/// <summary>Puerto de acceso mediante servidor proxy</summary>
		/// <value>Puerto de acceso mediante servidor proxy</value>
		public int PortServerProxy
		{
			get
			{
				return portserverproxy;
			}
			set
			{
				portserverproxy=value;
			}
		}
		private String uri;
		/// <summary>Direcci�n web de acceso al servidor</summary>
		/// <value>Direcci�n web de acceso al servidor</value>
		public String Uri
		{
			get
			{
				return uri;
			}
			set
			{
				uri=value;
			}
		}		
		bool permisotemplates=false;
		/// <summary>Templates a los que tiene permiso</summary>
		/// <value>Templates a los que tiene permiso</value>
		public bool PermisoTemplate
		{
			get
			{
				return permisotemplates;
			}
			set
			{
				permisotemplates=value;
			}
		}
		bool permisoworkflow=false;
		/// <summary>Indica si tiene permisos a crear flujos de publicaci�n (deprecated)</summary>
		/// <value>Indica si tiene permisos a crear flujos de publicaci�n</value>
		public bool PermisoWorkFlow
		{
			get
			{
				return permisoworkflow;
			}
			set
			{
				permisoworkflow=value;
			}
		}
		bool permisomap=false;
		/// <summary>Sitios a los que tiene permiso</summary>
		/// <value>Sitios a los que tiene permiso</value>
		public bool PermisoMap
		{
			get
			{
				return permisomap;
			}
			set
			{
				permisomap=value;
			}
		}
		bool permisorules=false;
		/// <summary>Indica si tiene permiso de crear reglas (deprecated)</summary>
		/// <value>Indica si tiene permiso de crear reglas</value>
		public bool PermisoRules
		{
			get
			{
				return permisorules;
			}
			set
			{
				permisorules=value;
			}
		}
		bool permisorecursos=false;
		/// <summary>Indica si tiene permiso de crear recursos (deprecated)</summary>
		/// <value>Indica si tiene permiso de crear recursos</value>
		public bool PermisoRecurso
		{
			get
			{
				return permisorecursos;
			}
			set
			{
				permisorecursos=value;
			}
		}
		
		private int id;
		/// <summary>ID del usuario</summary>
		/// <value>ID del usuario</value>
		public int ID
		{
			get
			{
				return id;
			}
			set
			{
				id=value;
			}
		}
		private String user;
		/// <summary>Loggin del usuario</summary>
		/// <value>Loggin del usuario</value>
		public String User
		{
			get
			{
				return user;
			}
			set
			{
				user=value;
			}
		}
		private String pass;
		/// <summary>Password del usuario</summary>
		/// <value>Password del usuario</value>
		public String Password
		{
			get
			{
				return pass;
			}
			set
			{
				pass=value;
			}
		}
		private int admtype;
		/// <summary>Tipo de administrador</summary>
		/// <value>Tipo de administrador</value>
		public int Type
		{
			get
			{
				return admtype;
			}
			set
			{
				admtype=value;
			}
		}
		/// <summary>Genera un usuario</summary>
		/// <param name="user">loggin del usuario</param>
		/// <param name="pass">Password del usuario</param>
		/// <param name="admtype">Tipo de administrador</param>
		public CUserAdmin(String user,String pass,int admtype)
		{
			//
			// TODO: Add constructor logic here
			//
			this.user=user;
			this.pass=pass;
			this.admtype=admtype;
			

		}
		
		/// <summary>Optiene los permisos que tiene un usuario</summary>
		/// <returns>true si tiene permisos, false si no tiene permisos.</returns>
		/// <param name="idtopicmap">Topicmap o sitio</param>
		/// <param name="contentType">Tipo de contenido que se quiere probar si tiene permisos</param>
		public bool GetPermiso(String idtopicmap,String contentType)
		{
			Servicios s=new Servicios(this);
			XmlDocument doc_permiso=s.haveAccess2Menu("WBAd_mnui_ContentAdd");
			if(doc_permiso.GetElementsByTagName("haveAccess2Menu").Count>0 && doc_permiso.GetElementsByTagName("haveAccess2Menu")[0].InnerText=="true")
			{
				s=new Servicios(this);
				XmlDocument doc_type=s.haveAccess2ResourceType(idtopicmap,contentType);
				if(doc_type.GetElementsByTagName("haveAccess2ResourceType").Count>0 && int.Parse(doc_type.GetElementsByTagName("haveAccess2ResourceType")[0].InnerText)>0)
				{
					return true;
				}
				else
				{
					MessageBox.Show(resources.GetString("FrmProp.msg3"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
					return false;
				}

			}
			else
			{
				MessageBox.Show(resources.GetString("FrmProp.msg3"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
				return false;
			}
			
		}
		

	}
}
