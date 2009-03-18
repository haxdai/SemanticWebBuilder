/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
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
		/// <summary>Indica si tiene permisos de asociar campañas a una sección.</summary>
		/// <value>Indica si tiene permisos de asociar campañas a una sección.</value>
		public bool PermisoCampañas
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
		/// <summary>Indica si tiene permisos de asociar templates a una seccón (deprecated)</summary>
		/// <value>Indica si tiene permisos de asociar templates a una seccón (deprecated)</value>
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
		/// <summary>Indica si tiene permiso de crear contenido en la sección</summary>
		/// <value>Indica si tiene permiso de crear contenido en la sección</value>
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
		/// <summary>Indica si tiene permisos de asociar reglas a una sección</summary>
		/// <value>Indica si tiene permisos de asociar reglas a una sección</value>
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
		/// <summary>Indica si tiene permiso de publicar contenido en la sección</summary>
		/// <value>Indica si tiene permiso de publicar contenido en la sección</value>
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
		/// <summary>Indica si tiene permiso de borrar contenidos en la sección</summary>
		/// <value>Indica si tiene permiso de borrar contenidos en la sección</value>
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
		/// <summary>Id de la sección</summary>
		/// <value>Id de la sección</value>
		public String Id
		{
			get
			{
				return id;
			}
		}
		/// <summary>Contruye un topico de permisos</summary>
		/// <param name="id">Id del topico</param>
		/// <param name="topicmap">Topicmap al que pertenecela topic o sección.</param>
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
