/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;

namespace WBOffice3
{
	/// <summary>Topico que un usuario tiene permiso</summary>
	public class CTopicUser
	{
		private String idtopicmap;
		/// <summary>TopicMap al que pertenece</summary>
		/// <value>TopicMap al que pertenece</value>
		public String TopicMap
		{
			get
			{
				return idtopicmap;
			}
			set
			{
				idtopicmap=value;
			}
		}
		private bool permisochildren=false;
		/// <summary>Indica si tiene permisos sobre subsecciones</summary>
		/// <value>Indica si tiene permisos sobre subsecciones</value>
		public bool PermisoChildren
		{
			get
			{
				return permisochildren;
			}
			set
			{
				permisochildren=value;
			}
		}
		private bool permisoworkflow=false;
		/// <summary>Indica si tiene permiso de asociar un flujo de trabajo a la seccion</summary>
		/// <value>Indica si tiene permiso de asociar un flujo de trabajo a la seccion</value>
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

		private bool permisocamp=false;
		/// <summary>Indica si tiene permisos de asociar campa�as a una secci�n.</summary>
		/// <value>Indica si tiene permisos de asociar campa�as a una secci�n.</value>
		public bool PermisoCampa�as
		{
			get
			{
				return permisocamp;
			}
			set
			{
				permisocamp=value;
			}
		}
		private bool permisotemplate=false;
		/// <summary>Indica si tiene permisos de asociar templates a una secc�n (deprecated)</summary>
		/// <value>Indica si tiene permisos de asociar templates a una secc�n (deprecated)</value>
		public bool PermisoTemplate
		{
			get
			{
				return permisotemplate;
			}
			set
			{
				permisotemplate=value;
			}
		}
		private bool permisocontenido=false;
		/// <summary>Indica si tiene permiso de crear contenido en la secci�n</summary>
		/// <value>Indica si tiene permiso de crear contenido en la secci�n</value>
		public bool PermisoContenido
		{
			get
			{
				return permisocontenido;
			}
			set
			{
				permisocontenido=value;
			}
		}
		private bool permisoreglas=false;
		/// <summary>Indica si tiene permisos de asociar reglas a una secci�n</summary>
		/// <value>Indica si tiene permisos de asociar reglas a una secci�n</value>
		public bool PermisoReglas
		{
			get
			{
				return permisoreglas;
			}
			set
			{
				permisoreglas=value;
			}
		}
		bool permisopublish=false;
		/// <summary>Indica si tiene permiso de publicar contenido en la secci�n</summary>
		/// <value>Indica si tiene permiso de publicar contenido en la secci�n</value>
		public bool PermisoPublish
		{
			get
			{
				return permisopublish;
			}
			set
			{
				permisopublish=value;
			}
		}
		bool permisodeletecontent=false;
		/// <summary>Indica si tiene permiso de borrar contenidos en la secci�n</summary>
		/// <value>Indica si tiene permiso de borrar contenidos en la secci�n</value>
		public bool PermisoDeleteContent
		{
			get
			{
				return permisodeletecontent;
			}
			set
			{
				permisodeletecontent=value;
			}
		}
		private bool permisocreartopicos=false;
		/// <summary>Indica si tiene permisos de crear sub secciones</summary>
		/// <value>Indica si tiene permisos de crear sub secciones</value>
		public bool CrearTopicos
		{
			get
			{
				return permisocreartopicos;
			}
			set
			{
				permisocreartopicos=value;
			}
		}
		private String id;
		/// <summary>Id de la secci�n</summary>
		/// <value>Id de la secci�n</value>
		public String Id
		{
			get
			{
				return id;
			}
		}
		/// <summary>Contruye un topico de permisos</summary>
		/// <param name="id">Id del topico</param>
		/// <param name="topicmap">Topicmap al que pertenecela topic o secci�n.</param>
		public CTopicUser(String id,String topicmap)
		{
			//
			// TODO: Add constructor logic here
			//
			this.id=id;
			this.idtopicmap= topicmap;
		}
	}
}
