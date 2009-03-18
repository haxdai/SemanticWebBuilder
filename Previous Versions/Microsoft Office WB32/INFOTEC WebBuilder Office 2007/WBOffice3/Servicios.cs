/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Xml;
using System.Windows.Forms;  
using System.Drawing; 
using System.Collections;
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>Clase que contiene todos los servicios del gateway</summary>
	public class Servicios
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		CUserAdmin admin=new CUserAdmin("","",-1);
		/// <summary>Usuario Administrador</summary>
		/// <value>Usuario Administrador</value>
		public CUserAdmin Admin
		{
			get
			{
				return admin;
			}
			set
			{
				admin=value;
			}
		}
		int err=-1;
		bool berror=false;
		private Form frm=null;
		/// <summary>Indica si hubo un error</summary>
		/// <value>true hubo error, false no hubo error</value>
		public bool IsError
		{
			get
			{
				return berror;
			}
		}
		/// <summary>Error</summary>
		/// <value>Número de error</value>
		public int Error
		{
			get
			{
				return err;
			}
		}
		/// <summary>Forma que lo llama</summary>
		/// <value>Forma que lo llama</value>
		public Form Form
		{

			set
			{
				this.frm=value;
			}
		}

		/// <summary>Contruye un objeto Servicios</summary>
		/// <param name="admin">Usuario que va a pedir el servicio</param>
		public Servicios(CUserAdmin admin)
		{
			//
			// TODO: Add constructor logic here
			//
			this.admin=admin; 
		}
		/// <summary>
		/// Regresa si un usuario tiene acceso a una sección del aparatado menu, indicando la
		/// sección
		/// </summary>
		/// <returns>XML con la definción de permisos sobre la sección</returns>
		/// <param name="topic">Sección para verificar si hay permisos</param>
		public XmlDocument haveAccess2Menu(String topic)
		{
			err=-1;
			berror=false;			
			CRequest r=new CRequest("haveAccess2Menu",admin);									
			r.Parameters.Add(new Parameter("topic",topic));  
			System.Xml.XmlDocument resp = r.Request();
			return resp;
		}
		/// <summary>Regresa si un usuario tiene permiso a un topico en la sección system</summary>
		/// <returns>Regresa XML indicando si tiene permiso o no</returns>
		/// <param name="topic">Id de la sección</param>
		public XmlDocument haveAccess2System(String topic)
		{
			err=-1;
			berror=false;			
			CRequest r=new CRequest("haveAccess2System",admin);									
			r.Parameters.Add(new Parameter("topic",topic));  
			System.Xml.XmlDocument resp = r.Request();
			return resp;
		}
		/// <summary>
		/// Regresa si un usuario tiene permisos a un tipo de recurso en un cierto
		/// sitio
		/// </summary>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="type">Nombre de recurso</param>
		public XmlDocument haveAccess2ResourceType(String topicmap,String type)
		{
			err=-1;
			berror=false;			
			CRequest r=new CRequest("haveAccess2ResourceType",admin);									
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			r.Parameters.Add(new Parameter("type",type));  
			System.Xml.XmlDocument resp = r.Request();
			return resp;
		}
		/// <summary>Indica si se necesita enviar a utorizar un contenido</summary>
		/// <returns>true si requiere enviarlo a flujo, false si no</returns>
		/// <param name="topicmap">Id del sitio donde se encuentra el contenido</param>
		/// <param name="topic">Id de la sección donde se encuentra el contenido</param>
		/// <param name="contentid">Id del contenido</param>
		public bool needAutorization(String topicmap,String topic,String contentid)
		{
			err=-1;
			berror=false;			
			CRequest r=new CRequest("needAutorization",admin);						
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			r.Parameters.Add(new Parameter("topic",topic));  
			r.Parameters.Add(new Parameter("contentid",contentid));  
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			foreach(XmlElement eresp in resp.GetElementsByTagName("needAutorization"))
			{
				if(eresp.InnerText.Equals("true"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			return false;
		}
		/// <summary>Regresa los flujo de contenido a los cuales se puede envíar un contenido</summary>
		/// <returns>Regresa XML con los flujos a los que puede ser enviado el contenido</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="contentid">Id del contenido</param>
		public XmlDocument getFlowsToSendContent(String topicmap,String topic,String contentid)
		{
			err=-1;
			berror=false;			
			CRequest r=new CRequest("getFlowsToSendContent",admin);						
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			r.Parameters.Add(new Parameter("topic",topic));  
			r.Parameters.Add(new Parameter("contentid",contentid));  
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}			
			return resp;
		}
		/// <summary>Regresa el titulo de un sitio</summary>
		/// <returns>El título del sitio</returns>
		/// <param name="topicmap">Id del sitio</param>
		public String getTopicMapTitle(String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r=new CRequest(206,admin);						
			CRequest r=new CRequest("getTopicMapTitle",admin);						
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			foreach(XmlElement etitle in resp.GetElementsByTagName("title"))
			{
				return etitle.InnerText;
			}
			return "";
		}
		/// <summary>Regresa todos los sitios para un usuario</summary>
		/// <returns>Regresa un XML con todos los sitio que tiene acceso el usuario</returns>
		public XmlDocument getTopicMaps()
		{
			err=-1;
			berror=false;			
			CRequest r=new CRequest("getTopicMaps",admin);									
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
			
		}
		/// <summary>Regresa el título por defecto de una sección</summary>
		/// <returns>Regresa el título por defecto del sitio</returns>
		/// <param name="topicid">Id de la sección</param>
		/// <param name="topicmap">Id del sitio</param>
		public String getTitleTopic(String topicid,String topicmap)
		{
			
			err=-1;
			berror=false;
			//CRequest r=new CRequest(206,admin);						
			CRequest r=new CRequest("getTitleTopic",admin);						
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			r.Parameters.Add(new Parameter("topic",topicid));  
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			foreach(XmlElement etitle in resp.GetElementsByTagName("title"))
			{
				return etitle.InnerText;
			}
			return "";
		}
			
		/// <summary>Regresa información de la sección</summary>
		/// <returns>XML con la información de la sección</returns>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="topicmap">Id del sitio</param>
		public System.Xml.XmlDocument getTopicInfo(String idtopic,String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(2,admin);
			CRequest r= new CRequest("getTopicInfo",admin);
			r.Parameters.Add(new Parameter("topicid",idtopic));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			System.Xml.XmlDocument resp=r.Request(); 
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Indica si se puede editar un contenido</summary>
		/// <returns>true se puede modificar, false, no se puede modificar</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="occurrenceid">Id de la ocurrencia asociada al contenido</param>
		public bool canEdit(String topicmap,String topic,String occurrenceid)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(110,admin); 				 				
			CRequest r= new CRequest("canEdit",admin); 				 				
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topic",topic));
			r.Parameters.Add(new Parameter("occurrenceid",occurrenceid));
			
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 					
				}
				ErroHandle(errores);
			}
			foreach(XmlElement eresp in resp.GetElementsByTagName("canEdit"))
			{
				if(eresp.InnerText.Equals("true"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			return false;
		}
		/// <summary>Regresa si un usuario es un revisor del contenido</summary>
		/// <returns>true si es revisor, false si no</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="occurrenceid">Id de la ocurrencia</param>
		public bool isReviewer(String topicmap,String topic,String occurrenceid)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(110,admin); 				 				
			CRequest r= new CRequest("isReviewer",admin); 				 				
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topic",topic));
			r.Parameters.Add(new Parameter("occurrenceid",occurrenceid));
			
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 					
				}
				ErroHandle(errores);
			}
			foreach(XmlElement eresp in resp.GetElementsByTagName("isReviewer"))
			{
				if(eresp.InnerText.Equals("true"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			return false;
		}
		/// <summary>Envía un contenido a autorizar</summary>
		/// <returns>XML con respuesta de confirmación de estado de envío</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="contentid">Id del contenido</param>
		/// <param name="flowid">Id del flujo a donde se enviará a autorizar</param>
		/// <param name="flowTopicMap">Id del sitio donde se encuentra el flujo</param>
		/// <param name="message">Mensaje a envíar al revisor</param>
		public System.Xml.XmlDocument sendContenttoAutorize(String topicmap,String topic,String contentid,String flowid,String flowTopicMap,String message)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(110,admin); 				 				
			CRequest r= new CRequest("sendContenttoAutorize",admin); 				 				
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topic",topic));
			r.Parameters.Add(new Parameter("contentid",contentid));
			r.Parameters.Add(new Parameter("flowid",flowid));
			r.Parameters.Add(new Parameter("flowTopicMap",flowTopicMap));
			r.Parameters.Add(new Parameter("message",message));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 					
				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Envía un contenido a autorizar</summary>
		/// <returns>XML con respuesta de confirmación de estado de envío</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="contentid">Id del flujo a donde se enviará a autorizar</param>
		/// <param name="flowid">Id del flujo</param>
		/// <param name="flowTopicMap">Id del sitio donde se encuentra el flujo</param>
		public System.Xml.XmlDocument sendContenttoAutorize(String topicmap,String topic,String contentid,String flowid,String flowTopicMap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(110,admin); 				 				
			CRequest r= new CRequest("sendContenttoAutorize",admin); 				 				
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topic",topic));
			r.Parameters.Add(new Parameter("contentid",contentid));
			r.Parameters.Add(new Parameter("flowid",flowid));
			r.Parameters.Add(new Parameter("flowTopicMap",flowTopicMap));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 					
				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Autoriza en un paso el contenido</summary>
		/// <returns>XML con la confirmación de cambio de estado</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="occurrenceid">Id de la ocurrencia</param>
		/// <param name="message">Mensaje en caso de autorización</param>
		public System.Xml.XmlDocument acceptFlow(String topicmap,String topic,String occurrenceid,String message)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(110,admin); 				 				
			CRequest r= new CRequest("acceptFlow",admin); 		
		 	r.Parameters.Add(new Parameter("message",message));			
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topic",topic));
			r.Parameters.Add(new Parameter("occurrenceid",occurrenceid));
			
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 					
				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Autoriza en un paso el contenido</summary>
		/// <returns>XML con la confirmación de cambio de estado</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="occurrenceid">Id de la ocurrencia</param>
		public System.Xml.XmlDocument acceptFlow(String topicmap,String topic,String occurrenceid)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(110,admin); 				 				
			CRequest r= new CRequest("acceptFlow",admin); 				 				
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topic",topic));
			r.Parameters.Add(new Parameter("occurrenceid",occurrenceid));
			
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 					
				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Rechaza un contenido en un paso</summary>
		/// <returns>XML con confirmación de rechazo de contenido</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topic">Id de la sección</param>
		/// <param name="occurrenceid">Id de la ocurrencia</param>
		/// <param name="msg">Mensaje al revisor o al generador de contenido segun sea el caso</param>
		public System.Xml.XmlDocument rejectFlow(String topicmap,String topic,String occurrenceid,String msg)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(111,admin); 				 				
			CRequest r= new CRequest("rejectFlow",admin); 
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topic",topic));
			r.Parameters.Add(new Parameter("occurrenceid",occurrenceid));
			r.Parameters.Add(new Parameter("msg",msg));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Cambia el estado de una sección a activo o inactivo</summary>
		/// <returns>XML con confirmación de cambio de estado</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topicid">Id de la sección</param>
		/// <param name="status">Nuevo estado</param>
		public System.Xml.XmlDocument  setStatusTopic(String topicmap,String topicid,String status) 
		{
			err=-1;
			berror=false;
			//CRequest r=new CRequest(74,admin); 				
			CRequest r=new CRequest("setStatusTopic",admin); 				
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			r.Parameters.Add(new Parameter("topicid",topicid));  
			r.Parameters.Add(new Parameter("status",status));  
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Regresa el estado que gusrad el contenido en un flujo</summary>
		/// <returns>XML con información del estado del contenido en el flujo</returns>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="flowid">Id del flujo en el que se encuentra el contenido</param>
		/// <param name="idcont">Id del contenido</param>
		public System.Xml.XmlDocument getStateContentFlow(String idtopic,String topicmap,String flowid,String idcont)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(132,admin); 				
			CRequest r= new CRequest("getStateContentFlow",admin); 				
			r.Parameters.Add(new Parameter("topicid",idtopic));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			r.Parameters.Add(new Parameter("flow",flowid));  
			r.Parameters.Add(new Parameter("id",idcont));  
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		
		/// <summary>Regresa la lista de contenidos en Flujo para un sitio</summary>
		/// <returns>Regresa un listado en formato XML con los contenidos en flujo</returns>
		/// <param name="topicmap">Id del sitio</param>
		public System.Xml.XmlDocument  getContentinFlow(String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(109,admin); 					
			CRequest r= new CRequest("getContentinFlow",admin); 					
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Regresa la bitácora de cambio de un contenido</summary>
		/// <param name="idContent">Id del contenido</param>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topicid">Id de la sección</param>
		public System.Xml.XmlDocument  getBitacora(String idContent,String topicmap,String topicid)
		{
			err=-1;
			berror=false;			
			//CRequest r= new CRequest(96,admin); 					
			CRequest r= new CRequest("getBitacora",admin); 					
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topicid",topicid));
			r.Parameters.Add(new Parameter("contentid",idContent));
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Activa un contenido que ya ha pasado por el flujo.</summary>
		/// <param name="pupdate">
		/// 	<para><font size="2">Colección de parametros para publicar un contenido, estos
		///     parametros deberan llevar los sigueintes nombres:</font></para>
		/// 	<para><font size="2">topicmap = ID del sitio</font></para>
		/// 	<para><font size="2"><font size="2">topicid = Id de la sección del
		///     contenido</font></font></para>
		/// 	<para><font size="2"><font size="2">id = id de contenido</font></font></para>
		/// 	<para><font size="2"><font size="2">action= "1" publicar (activo) | "0" no publicar
		///     (no activo)</font></font></para>
		/// </param>
		public System.Xml.XmlDocument PublishFlow(ParameterCollection pupdate)
		{

			err=-1;
			berror=false;			
			CRequest r= new CRequest("PublishFlow",admin); 									
			r.Parameters=pupdate;
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 
				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Obtiene los contenidos a revisar por el usuario actual</summary>
		/// <returns>XML con la lista de contenidos</returns>
		/// <param name="topicmap">Id del sitio del cual será la lista</param>
		public System.Xml.XmlDocument getContentReview(String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(174,admin); 	
			CRequest r= new CRequest("getContentReview",admin); 	
			r.Parameters.Add(new Parameter("topicmap",topicmap)); 	
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>
		/// Obtiene la lista de contenidos del usuario que estan en proceso de
		/// autorización
		/// </summary>
		/// <param name="topicmap">Id del sitio del que se quiere sacar la lista</param>
		public System.Xml.XmlDocument  getContentinFlowUser(String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(107,admin); 	
			CRequest r= new CRequest("getContentinFlowUser",admin); 				
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Función de logueo a WB</summary>
		public void login()
		{
			err=-1;
			berror=false;
			String url=admin.Uri+"gtwoffice";
			CRequest.cookies=new ArrayList();			
			HeaderCollection headers=new HeaderCollection();								
			headers.Add(new HtmlHeader("Content-Type","application/x-www-form-urlencoded"));
			HtmlResponse resp=new CHttpClient(this.admin).doPostLogin(url,admin.User,admin.Password,headers);
			
			if(resp.State==200)
			{

				CRequest.getHeaders(resp);
				if(resp.XML!=null)
				{

					XmlDocument docres=resp.XML;	

					if(docres.GetElementsByTagName("err").Count>0)
					{						
						foreach(XmlElement Eerr in docres.GetElementsByTagName("err"))
						{
							if(Eerr.GetElementsByTagName("id")[0].InnerText=="0")
							{
								this.berror=true;
								this.err=0;
							}
							else
							{
								this.berror=true;
								this.err=Int32.Parse(Eerr.GetElementsByTagName("id")[0].InnerText);
								foreach(XmlElement emsg in Eerr.GetElementsByTagName("message"))
								{
									MessageBox.Show(emsg.InnerText,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
								}
									
							}
							
						}
					}
					else if(docres.GetElementsByTagName("admtype").Count>0)
					{
						String stype=docres.GetElementsByTagName("admtype")[0].InnerText ;
						this.admin.Type=Int32.Parse(stype); 
						String sid=docres.GetElementsByTagName("id")[0].InnerText ;

						if(sid.Equals("0"))
						{							
							berror=true;
							this.err=0;
						}
						admin.ID=Int32.Parse(sid); 					
						
						if(docres.GetElementsByTagName("err").Count>0)
						{
							ErroHandle(docres.GetElementsByTagName("err"));
						}
					}
					else
					{
						admin.ID=-1;
						admin=null;						
						berror=true;
						this.err=0;						

					}
					
				}
				else
				{					
					this.err=404;						
					berror=true;
				}
			}		
			else
			{		
				if(resp.State==401)
					this.err=0;						
				else
					this.err=resp.State;						
				berror=true;
			}			
		}		
		/// <summary>Obtiene los atributos de un contenido</summary>
		/// <returns>
		/// XML con los atributos del contenido, entre los atributos puede estar, fecha de
		/// creación, numero de versiones, si esta activo o no, etc.
		/// </returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topicid">Id de la sección</param>
		/// <param name="idContent">Id del contenido</param>
		public System.Xml.XmlDocument getContentAtt(String topicmap,String topicid,String idContent)
		{

			err=-1;
			berror=false;
			//CRequest rc = new CRequest(61,admin); 
			CRequest rc = new CRequest("getContentAtt",admin); 
			rc.Parameters.Add(new Parameter("topicmap",topicmap));
			rc.Parameters.Add(new Parameter("topicid",topicid));
			rc.Parameters.Add(new Parameter("contentid",idContent));
			System.Xml.XmlDocument respc=rc.Request();		
			System.Xml.XmlNodeList errores=respc.GetElementsByTagName("err");		
			if(errores.Count>0)
			{		
				berror=true;
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.InnerText); 
				}
				ErroHandle(errores);
				
			}
			return respc;
			
			
		}
		/// <summary>Agrega una paginación a un contenido</summary>
		/// <returns>Regresa XML de confirmación de procesamiento de solicitud</returns>
		/// <param name="parameters">
		/// 	<para>Parametros necesarios para la paginación:</para>
		/// 	<para><font size="2">createPages = "true" crea paginación | "false no la
		///     crea"</font></para>
		/// 	<para><font size="2">topicmap = ID del sitio</font></para>
		/// 	<para><font size="2">topicid = Id de la sección</font></para>
		/// 	<para><font size="2">contentid= ID del contenido</font></para>
		/// 	<para><font size="2">pages = número de paginas a mostrar en la parte inferior del
		///     contenido y/o en la parte superior.</font></para>
		/// 	<para><font size="2">stxtsig = texto a mostrar para navegación entre paginas
		///     (Siguiente)</font></para>
		/// 	<para><font size="2">stxtant = texto a mostrar para navegación entre paginas
		///     (Anterior)</font></para>
		/// 	<para><font size="2">position= posición a mostrar 1 arriba, 2 abajo, 3
		///     ambos</font></para>
		/// </param>
		public System.Xml.XmlDocument addPaginations2Content(ParameterCollection parameters)
		{

			err=-1;
			berror=false;			
			CRequest rc = new CRequest("addPaginations2Content",admin); 
			rc.Parameters=parameters;			
			System.Xml.XmlDocument respc=rc.Request();		
			System.Xml.XmlNodeList errores=respc.GetElementsByTagName("err");		
			if(errores.Count>0)
			{		
				berror=true;
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.InnerText); 
				}
				ErroHandle(errores);
				
			}
			return respc;
			
			
		}

		/// <summary>
		/// Agrega una liga a un PPT
		/// </summary>
		/// <param name="parameters"></param>
		/// <returns></returns>
		public System.Xml.XmlDocument addLinkToPPT(ParameterCollection parameters)
		{

			err=-1;
			berror=false;			
			CRequest rc = new CRequest("addLinkToPPT",admin); 
			rc.Parameters=parameters;			
			System.Xml.XmlDocument respc=rc.Request();		
			System.Xml.XmlNodeList errores=respc.GetElementsByTagName("err");		
			if(errores.Count>0)
			{		
				berror=true;
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.InnerText); 
				}
				ErroHandle(errores);
				
			}
			return respc;
			
			
		}

		/// <summary>Mueve un contenido de sección y/o sitio</summary>
		/// <returns>Regresa XML con confirmación de cambio</returns>
		/// <param name="parametros">
		/// 	<para>Parametros para mover un contenido</para>
		/// 	<para><font size="2">id=Id del contenido</font></para>
		/// 	<para><font size="2">topicidcurrent=Id de sección actual</font></para>
		/// 	<para><font size="2">topicmapcurrent=Id de sitio actual</font></para>
		/// 	<para><font size="2">topicidnew=Id de sección nuevo</font></para>
		/// 	<para><font size="2">topicmapnew=ID de sitio nuevo</font></para>
		/// </param>
		public System.Xml.XmlDocument moveContenido(ParameterCollection parametros)  
		{
			//CRequest r=new CRequest(182,admin); 			
			CRequest r=new CRequest("moveContenido",admin); 			
			r.Parameters=parametros;			
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Obtiene listado de sitios</summary>
		/// <returns>Un XML con el listado sitios de WB</returns>
		public System.Xml.XmlDocument getVersiones()
		{
			err=-1;
			berror=false;						
			CRequest r= new CRequest("getVersiones",admin);											
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{				
				ErroHandle(errores);				
			}
			return resp;
		}	
		/// <summary>Obtiene los hijos de una sección dada por el path indicado</summary>
		/// <returns>
		/// XML con los hijos del nodo, puede ser una sección, o un sitio, etc, dentro del
		/// árbol de secciones.
		/// </returns>
		/// <param name="path">Path del nodo del cual se quiere obtener sus hijos</param>
		public System.Xml.XmlDocument getPath(String path)
		{
			err=-1;
			berror=false;			
			//CRequest r= new CRequest(1,admin); 						
			CRequest r= new CRequest("getPath",admin);						
			r.Parameters.Add(new Parameter("path",path));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{				
				ErroHandle(errores);				
			}
			return resp;
		}	
		/// <summary>Manejador de Errores de comunicación</summary>
		/// <param name="errores">Errores encontrados en un XML de respuesta de servicio</param>
		public void ErroHandle(System.Xml.XmlNodeList errores)
		{
			berror=true;
			String id=errores[0].ChildNodes[0].InnerText;
			String message=errores[0].ChildNodes[1].InnerText;
			this.err=Int32.Parse(id); 
			if(id.Equals("0")) // login o password incorrecto
			{
				
			
			}			
			if(id.Equals("1")) // usuario no se encuentra registrado
			{
				CRequest.sesion=null;
			}
			if(id.Equals("2")) // servicio no válido
			{
				
			}
			if(id.Equals("3")) // consulta no válida
			{
				
			}
			if(id.Equals("7")) // el usuario no tiene permiso para esta operación
			{
				
			}
		}
		/// <summary>Regresa los atributos de una regla</summary>
		/// <returns>XML con los atributos de una regla</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="ruleid">Id de la regla</param>
		public System.Xml.XmlDocument getRuleAttr(String topicmap,int ruleid)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(32,admin); 						
			CRequest r= new CRequest("getRuleAttr",admin); 						
			r.Parameters.Add(new Parameter("ruleid",""+ruleid));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;			
		}		
		/// <summary>Llena un listview con las reglas de una sección</summary>
		/// <param name="listview">Listview a llenar</param>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="topicmap">Id del sitio</param>
		public void GetRuleTopic(System.Windows.Forms.ListView listview,String idtopic,String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(6,admin); 			
			CRequest r= new CRequest("GetRuleTopic",admin); 			
			r.Parameters.Add(new Parameter("topicid",idtopic));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			else
			{
				listview.Items.Clear(); 
				System.Xml.XmlNodeList nodos=resp.GetElementsByTagName("RuleRelated");
				for(int i=0;i<nodos.Count;i++)
				{
					System.Xml.XmlElement  xmltemplate=(XmlElement)nodos[i];
					System.Windows.Forms.ListViewItem item=listview.Items.Add(xmltemplate.InnerText);
					item.ImageIndex=3;
					item.Tag=xmltemplate;
					
				}
			}
		}
		/// <summary>Llena un nodo con las reglas existentes en una sección</summary>
		/// <param name="node">Nodo a llenar</param>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="topicmap">Id del sitio</param>
		public void GetRuleTopic(System.Windows.Forms.TreeNode node,String idtopic,String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(6,admin); 			
			CRequest r= new CRequest("GetRuleTopic",admin); 			
			r.Parameters.Add(new Parameter("topicid",idtopic));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			else
			{
				node.Nodes.Clear(); 
				System.Xml.XmlNodeList nodos=resp.GetElementsByTagName("RuleRelated");
				for(int i=0;i<nodos.Count;i++)
				{
					System.Xml.XmlElement  xmltemplate=(XmlElement)nodos[i];
					TreeNode templatenode=node.Nodes.Add(xmltemplate.InnerText); 
					templatenode.ImageIndex=11;
					templatenode.SelectedImageIndex=11;
				}
			}
		}
		/// <summary>
		/// Actualizar o crear una preriodicidad o un conjunto de ellas en un
		/// contenido
		/// </summary>
		/// <param name="paramopen">
		/// 	<para>Parametros para actualizar la periodicidad</para>
		/// 	<para><font size="2">topicmap=ID del asección</font></para>
		/// 	<para><font size="2">subtype = sub tipo de recurso</font></para>
		/// 	<para><font size="2">priority=prioridad del contenido, asignado 3 por defecto a
		///     contenidos</font></para>
		/// 	<para><font size="2">camp=Capaña a la que pertenece, vácio para
		///     contenidos</font></para>
		/// 	<para><font size="2">xmlconf=xml donde se almacena la calendarización</font></para>
		/// 	<para><font size="2">title=titulo del contenido</font></para>
		/// 	<para><font size="2">id=Id del contenido</font></para>
		/// 	<para><font size="2">description=descripción del contenido</font></para>
		/// </param>
		public void updatePeriodicidad(ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(85,admin); 			
			CRequest r= new CRequest("updatePeriodicidad",admin); 			
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}			
		}
		/// <summary>Regresa los contenido de una sección</summary>
		/// <returns>XML con el listado de contenidos en la sección</returns>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="topicmap">Id del sitio</param>
		public System.Xml.XmlDocument getContentTopic(String idtopic,String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(4,admin); 			
			CRequest r= new CRequest("getContentTopic",admin); 			
			r.Parameters.Add(new Parameter("topicid",idtopic));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}		
		/// <summary>Obtiene las reglas exietntes en un sitio</summary>
		/// <returns>XML con la lista de reglas en el catálogo del sitio</returns>
		/// <param name="topicmap">Id del sitio</param>
		public System.Xml.XmlDocument getRules(String topicmap)
		{
			   
			err=-1;
			berror=false;
			//CRequest r= new CRequest(31,admin);
			CRequest r= new CRequest("getRules",admin);
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Obtiene los roles existentes en el sitio</summary>
		/// <returns>XML con el listado de roles en el catálogo de roles, en el sitio</returns>
		/// <param name="topicmap">Id del sitio</param>
		public System.Xml.XmlDocument getRoles(String topicmap)
		{
			   
			err=-1;
			berror=false;			
			CRequest r= new CRequest("getRoles",admin);
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Obtiene el lenguajes de un sitio</summary>
		/// <returns>XML con el lenguajes del sitio</returns>
		/// <param name="topicmap">Id del sitio</param>
		public System.Xml.XmlDocument getLanguage(String topicmap)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(41,admin);
			CRequest r= new CRequest("getLanguage",admin);
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;			
		}
		
		
		/// <summary>Agrega un contenido</summary>
		/// <returns>
		/// XML con la conformación de alta de contenido, contiene el Id del contenido
		/// creado
		/// </returns>
		/// <param name="paramalta">Parametros para alta de contenido</param>
		public XmlDocument altaContenido(ParameterCollection paramalta)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(62,admin); 	
			CRequest r= new CRequest("altaContenido",admin); 	
			r.Parameters=paramalta;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 
				}
				ErroHandle(errores);
			}			
			return resp;

		}
		/// <summary>Borra un contenido</summary>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topicid">Id de la sección</param>
		/// <param name="idcontent">ID del contenido</param>
		public void deleteContent(String topicmap,String topicid,String idcontent) 
		{

			//CRequest r=new CRequest(63,admin); 	
			CRequest r=new CRequest("deleteContent",admin); 	
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topicid",topicid));  
			r.Parameters.Add(new Parameter("contentid",idcontent));
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
			}
			else
			{
				System.Xml.XmlNodeList contentresp=resp.GetElementsByTagName("ContentDeleted");
				foreach(System.Xml.XmlNode node in contentresp)
				{
					if(!node.InnerText.Equals("1"))					
					{
						Parameter perr=new Parameter("error","No se puede borrar el contenido"); 

					}
				}
			}
		}
		/// <summary>Cambia el password a un usuario</summary>
		/// <param name="userid">Id del usuario</param>
		/// <param name="user">Login del usuario</param>
		/// <param name="oldpwd">Password anterior</param>
		/// <param name="newpwd">Nuevo password</param>
		public void changePassword(int userid, String user, String oldpwd,String newpwd) 
		{
			CConfig c = new CConfig();
			//CRequest r=new CRequest(13,admin); 	
			CRequest r=new CRequest("changePassword",admin); 							
			r.Parameters.Add(new Parameter("newpwd",newpwd));
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			else
			{
				System.Xml.XmlNodeList upuser=resp.GetElementsByTagName("CodeResult"); 
				if (upuser.Count>0)
				{
					System.Xml.XmlElement  xmlupdate=(XmlElement)upuser[0];
					if (xmlupdate.InnerText.Equals("1"))
					{
						admin.Password = newpwd;						
						if(!c.Password.Equals("")) // es password esta guardado con anterioridad
						{
							c.Password = newpwd;						
							c.Save(); 
						}
						MessageBox.Show(resources.GetString("Servicios.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  	
					}
					else
					{
						MessageBox.Show(resources.GetString("Servicios.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  	
					}
				}
			}
		}
		/// <summary>Regresa si existe un contenido o no</summary>
		/// <returns>true si existe el contenido, false si no existe el contenido</returns>
		/// <param name="id">Id del contenido</param>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topicid">Id de la sección</param>
		public bool existsCont(String id,String topicmap,String topicid)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(204,admin); 	 	 			
			CRequest r= new CRequest("existsCont",admin); 	 	 			
			r.Parameters.Add(new Parameter("topicid",topicid));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("id",id));  
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);

			}
			if(resp.GetElementsByTagName("ContentNotActive").Count>0)
			{
				MessageBox.Show(resources.GetString("Servicios.msg3"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);  
				return false;
			}
			else if(resp.GetElementsByTagName("ContentRemoved").Count>0)
			{
				MessageBox.Show(resources.GetString("Servicios.msg4"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);  
				return false;
			}
			else
			{
				return true;
			}			
		}
		/// <summary>
		/// Inidca si es modo Web la presentación
		/// </summary>
		/// <param name="id">Identificador de contenido</param>
		/// <param name="topicmap">Sitio</param>
		/// <param name="topicid">Sección</param>
		/// <returns>True en caso de que el contenido este en modo web, False en modo embebido</returns>
		public bool isModeWeb(String id,String topicmap,String topicid)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(204,admin); 	 	 			
			CRequest r= new CRequest("getMode",admin); 	 	 			
			r.Parameters.Add(new Parameter("topicid",topicid));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("id",id));  			
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);

			}
			if(resp.GetElementsByTagName("mode").Count>0)
			{
				XmlElement emode=(XmlElement)resp.GetElementsByTagName("mode")[0];
				String mode=emode.GetAttribute("mode");
				if(mode!=null && mode=="office")
				{
					return false;
				}
			}
			return true;
			/*if(resp.GetElementsByTagName("ContentNotActive").Count>0)
			{
				MessageBox.Show(resources.GetString("Servicios.msg3"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);  
				return false;
			}
			else if(resp.GetElementsByTagName("ContentRemoved").Count>0)
			{
				MessageBox.Show(resources.GetString("Servicios.msg4"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);  
				return false;
			}
			else
			{
				if(resp.GetElementsByTagName("mode").Count>0)
				{
					XmlElement emode=(XmlElement)resp.GetElementsByTagName("mode")[0];
					String mode=emode.GetAttribute("mode");
					if(mode!=null && mode=="office")
					{
						return false;
					}
				}
				return true;
			}*/	
		}
		/// <summary>
		/// Cambia un modo de visualización de un contenido
		/// </summary>
		/// <param name="id">Identificador de contenido</param>
		/// <param name="topicmap">Sitio</param>
		/// <param name="topicid">Sección</param>
		/// <param name="mode">Modo, puede ser web o embebido(office)</param>
		/// <returns></returns>
		public bool changeMode(String id,String topicmap,String topicid,String mode)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(204,admin); 	 	 			
			CRequest r= new CRequest("changeMode",admin); 	 	 			
			r.Parameters.Add(new Parameter("topicid",topicid));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("id",id));  
			r.Parameters.Add(new Parameter("mode",mode));  
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);

			}
			if(resp.GetElementsByTagName("ContentNotActive").Count>0)
			{
				MessageBox.Show(resources.GetString("Servicios.msg3"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);  
				return false;
			}
			else if(resp.GetElementsByTagName("ContentRemoved").Count>0)
			{
				MessageBox.Show(resources.GetString("Servicios.msg4"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);  
				return false;
			}
			else
			{
				return true;
			}			
		}
		/// <summary>Actualiza el contenido</summary>
		/// <param name="paramopen">Parametros para actualizar un contenido</param>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topicid">Id de la sección</param>
		public XmlDocument updateCont(ParameterCollection paramopen,String topicmap,String topicid)
		{
			paramopen.Add(new Parameter("topicmap",topicmap));
			paramopen.Add(new Parameter("topicid",topicid));
			
			err=-1;
			berror=false;
			//CRequest r= new CRequest(65,admin); 	
			CRequest r= new CRequest("updateCont",admin); 	
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			return resp;
		}		
		/// <summary>Activa o desactiva un contenido</summary>
		/// <returns>XML con la confirmación del cambio</returns>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="idtopicmap">Id del sitio</param>
		/// <param name="id">Id del contenido</param>
		/// <param name="action">Acción "1" activar, "2" Historico, "0" desactivar</param>
		public void changeStatusContentFromTopic(String idtopic,String idtopicmap,String id,String action)
		{		
			err=-1;
			berror=false;
			//CRequest r= new CRequest(135,admin); 	 	
			CRequest r= new CRequest("changeStatusContentFromTopic",admin); 	 	
			r.Parameters.Add(new Parameter("topicid",idtopic));
			r.Parameters.Add(new Parameter("topicmap",idtopicmap));
			r.Parameters.Add(new Parameter("id",id));
			r.Parameters.Add(new Parameter("action",action));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{			
				ErroHandle(errores);
			}
			else
			{			
				MessageBox.Show(resources.GetString("Servicios.msg5"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information); 
			}
		}
		/// <summary>Actualiza las propiedades de cun contenido</summary>
		/// <param name="paramopen">
		/// Parametros para actualizar propiedades de un contenido, como su ´titulo,
		/// descripción, etc.
		/// </param>
		public XmlDocument updateProps(ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(66,admin); 	
			CRequest r= new CRequest("updateProps",admin); 	
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Crea una nueva sección</summary>
		/// <returns>XML de confirmación de creación de contenido</returns>
		/// <param name="paramopen">Parametros para crear una nueva sección</param>
		public void newTopic(ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(71,admin); 	
			CRequest r= new CRequest("newTopic",admin); 	
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

					MessageBox.Show(errres.ChildNodes[1].InnerText,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				}
				ErroHandle(errores);
			}			
		}
		/// <summary>Abre un contenido</summary>
		/// <param name="topicmap">ID del sitio</param>
		/// <param name="paramopen">Parametros para apertura</param>
		public XmlDocument openCont(String topicmap,ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(64,admin); 	
			CRequest r= new CRequest("openCont",admin); 	
			paramopen.Add(new Parameter("topicmap",topicmap));
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}

			return resp;

		}
		/// <summary>Agrega una regla al contenido</summary>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="paramopen">Parametros paara signar una regla a un contenido</param>
		public void addRule(String topicmap,ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(67,admin); 	
			CRequest r= new CRequest("addRule",admin); 	
			paramopen.Add(new Parameter("topicmap",topicmap));
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}			

		}
		/// <summary>Agrega un role al contenido</summary>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="paramopen">Parametros de asignación de role a contenido</param>
		public void addRole(String topicmap,ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(67,admin); 	
			CRequest r= new CRequest("addRole",admin); 	
			paramopen.Add(new Parameter("topicmap",topicmap));
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}			

		}
		/// <summary>Regresa las reglas asignadas a un contenido</summary>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="idcont">Id del contenido</param>
		/// <param name="listview">Lista a llenar con las reglas del contenido</param>
		public System.Xml.XmlDocument  getRulesContent(String topicmap,String idcont,System.Windows.Forms.ListView listview )
		{
			
			err=-1;
			berror=false;
			//CRequest r= new CRequest(69,admin); 	
			CRequest r= new CRequest("getRulesContent",admin); 	
			r.Parameters.Add(new Parameter("id",""+idcont));
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			else
			{
				listview.Items.Clear();
				System.Xml.XmlNodeList rules=resp.GetElementsByTagName("Rule");			
				foreach(System.Xml.XmlNode ruleid in rules)
				{
					String id=ruleid.InnerText;
					Servicios s= new Servicios(admin);
					System.Xml.XmlDocument docrule=s.getRuleAttr(topicmap,Int32.Parse(id)); 					
					System.Xml.XmlNode ruleatt=docrule.GetElementsByTagName("Rule")[0]; 
					string[] sitem= new string[4];
					foreach(System.Xml.XmlNode att in ruleatt.ChildNodes)
					{
						if(att.Name.Equals("id"))
						{
							sitem[0]=att.InnerText; 
						}
						if(att.Name.Equals("title"))
						{
							sitem[1]=att.InnerText; 
						}
						if(att.Name.Equals("descrition"))
						{
							sitem[2]=att.InnerText; 
						}
						if(att.Name.Equals("lastupdate"))
						{
							System.DateTime lastupdate=System.DateTime.Parse(att.InnerText);
							sitem[3]=lastupdate.ToLongDateString(); 
						}
					}
					listview.Items.Add(new ListViewItem(sitem));   

				}
				

			}
			return resp;
		}
		/// <summary>LLena un Listview con los roles asignados a un contenido</summary>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="idcont">Id del contenido</param>
		/// <param name="listview">Lista a llenar</param>
		public System.Xml.XmlDocument  getRolesContent(String topicmap,String idcont,System.Windows.Forms.ListView listview )
		{
			
			err=-1;
			berror=false;			
			CRequest r= new CRequest("getRolesContent",admin); 	
			r.Parameters.Add(new Parameter("id",""+idcont));
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			else
			{
				listview.Items.Clear();
				System.Xml.XmlNodeList roles=resp.GetElementsByTagName("Role");			
				foreach(System.Xml.XmlElement role in roles)
				{
					String id=role.GetAttribute("id");
					String name=role.GetAttribute("name");					
					string[] sitem= new string[2];
					sitem[0]=id; 					
					sitem[1]=name; 					
					listview.Items.Add(new ListViewItem(sitem));   
				}
			}
			return resp;
		}
		/// <summary>Obtiene la versión del core</summary>
		/// <returns>XML con la versión del core</returns>
		public System.Xml.XmlDocument getVersionCore()
		{
			err=-1;
			berror=false;
			//CRequest r=new CRequest(198,admin); 	
			CRequest r=new CRequest("getVersionCore",admin); 	
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Obtiene la licencia de WB que esta en el servidor</summary>
		/// <returns>XML con los datos de la licencia</returns>
		public System.Xml.XmlDocument getLicencia()
		{
			err=-1;
			berror=false;
			//CRequest r=new CRequest(197,admin); 	
			CRequest r=new CRequest("getLicencia",admin); 	
			System.Xml.XmlDocument resp = r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if (errores.Count>0)
			{
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Obtiene los atributos de un sitio</summary>
		/// <returns>XML con los atributos del sitio</returns>
		/// <param name="idtopicmap">Id del sitio</param>
		public System.Xml.XmlNode getTopicMapAtt(String idtopicmap)
		{
			err=-1;
			berror=false;			
			System.Xml.XmlNode node=null;			
			CRequest r= new CRequest("getTopicMapAtt",admin); 			
			r.Parameters.Add(new Parameter("topicmap",idtopicmap));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{				
				ErroHandle(errores);				
			}
			else
			{				
				System.Xml.XmlNodeList nodos=resp.GetElementsByTagName("res");
				if(nodos.Count>0)
				{
					System.Xml.XmlNode xmlresp=nodos[0];
					for(int i=0;i<xmlresp.ChildNodes.Count;i++)
					{						
						String id=xmlresp.ChildNodes[i].ChildNodes[0].InnerText; 
						if(id.Equals(idtopicmap))
							node=xmlresp.ChildNodes[i];
					}
					
				}				
			}
			return node;
		}
		
		/// <summary>Obtiene los titulos de una sección, y llena un listview con esos datos</summary>
		/// <param name="listview">Listview a llenar</param>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="txtsortname">Nombre de ordenación que se va allenar</param>
		/// <param name="idiomadefecto">Idioma por defecto del sitio</param>
		public void getTopicTitles(System.Windows.Forms.ListView listview,String idtopic,String topicmap,TextBox txtsortname,String idiomadefecto)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(2,this.admin);
			CRequest r= new CRequest("getTopicTitles",this.admin);
			r.Parameters.Add(new Parameter("topicid",idtopic));  
			r.Parameters.Add(new Parameter("topicmap",topicmap));  
			System.Xml.XmlDocument resp=r.Request();			
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			else
			{
				Servicios s= new Servicios(this.admin);				
				System.Xml.XmlNodeList nodos=resp.GetElementsByTagName("Topic");				
				if (nodos.Count>0)
				{
					System.Xml.XmlElement  xmltopic=(XmlElement)nodos[0];					
					XmlNodeList names=xmltopic.GetElementsByTagName("name");
					foreach(System.Xml.XmlElement name in names)
					{					
						String idioma=name.GetAttribute("scope"); 
						if(idioma=="CNF_WBSortName")
						{
							txtsortname.Text=name.GetAttribute("value");
						}
						else
						{
							if(idioma.Equals(""))
							{
								idioma=idiomadefecto;
							}
							if(idioma.Length>6)
							{
								idioma=idioma.Substring(6);
							}
							foreach(ListViewItem item in listview.Items)
							{
								CCaracteristica cvalue=(CCaracteristica)item.Tag;
								if(idioma==cvalue.Name)
								{		
									cvalue.Label=name.GetAttribute("value");
									item.SubItems[0].Text=name.GetAttribute("value");
								
								
									
									foreach(System.Xml.XmlElement variant in name.ChildNodes)
									{
										cvalue.Valores.Add(new CValorCaracterisitca(variant.InnerText,""));
									}
								}
							}													
						}		
						
					}
				}
			}
		}
		/// <summary>Actualiza la información de una sección</summary>
		/// <param name="paramopen">Parametros de ordenación</param>
		/// <param name="title">Título de la sección</param>
		public void updateTopic(ParameterCollection paramopen,String title)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(72,admin);
			CRequest r= new CRequest("updateTopic",admin);
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");
			if(errores.Count>0)
			{
				ErroHandle(errores);
			}
			else
			{
				MessageBox.Show(resources.GetString("Servicios.msg22"),title,MessageBoxButtons.OK,MessageBoxIcon.Information); 
			}
		}
		/*public String getURLPreview(String topicmap,String topicid,String contentid)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(68,admin); 	
			CRequest r= new CRequest("getURLPreview",admin); 	
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topicid",topicid));
			r.Parameters.Add(new Parameter("contentid",contentid));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			else
			{
				foreach(System.Xml.XmlElement eurl in resp.GetElementsByTagName("previewURL"))
				{
					return eurl.InnerText;
				}

			}
			return null;
		}*/
		/// <summary>Obtiene el XML definición de un flujo de publicación</summary>
		/// <returns>XML con la definición de flujo asociado al contenido</returns>
		/// <param name="topicmap">Id del sitio</param>
		/// <param name="topicid">Id de la sección</param>
		/// <param name="occurrence">Id de la ocurrencia del contenido</param>
		public XmlDocument getWorkflowXML(String topicmap,String topicid,String occurrence)
		{
			err=-1;
			berror=false;
			//CRequest r= new CRequest(68,admin); 	
			CRequest r= new CRequest("getWorkflowXML",admin); 	
			r.Parameters.Add(new Parameter("topicmap",topicmap));
			r.Parameters.Add(new Parameter("topicid",topicid));
			r.Parameters.Add(new Parameter("occurrence",occurrence));
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			return resp;
		}
		/// <summary>Elimina la asociaicón de una regla a un contenido</summary>
		/// <param name="paramopen">Parametros para eliminanción de regla a contenido</param>
		public void removeRules(ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(68,admin); 	
			CRequest r= new CRequest("removeRules",admin); 	
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}
			else
			{
				

			}

		}
		/// <summary>
		/// Remive los roles
		/// </summary>
		/// <param name="paramopen"></param>
		public void removeRoles(ParameterCollection paramopen)
		{

			err=-1;
			berror=false;
			//CRequest r= new CRequest(68,admin); 	
			CRequest r= new CRequest("removeRoles",admin); 	
			r.Parameters=paramopen;
			System.Xml.XmlDocument resp=r.Request();
			System.Xml.XmlNodeList errores=resp.GetElementsByTagName("err");			
			if(errores.Count>0)
			{
				foreach(System.Xml.XmlNode errres in errores)
				{
					Parameter perr=new Parameter("error",errres.ChildNodes[1].InnerText); 

				}
				ErroHandle(errores);
			}			

		}
		
	}
}
