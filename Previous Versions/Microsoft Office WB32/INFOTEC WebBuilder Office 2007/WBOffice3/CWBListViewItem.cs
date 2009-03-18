/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Xml;
using System.Windows.Forms; 

namespace WBOffice3
{
	/// <summary>
	/// Clase que permite mostar un elemento en un ListView, utilizado para mostrar
	/// flujos de contenido, este elemento se asocia a un contenido en flujo.
	/// </summary>
	public class CWBListViewItem 
	{
		String id;
		/// <summary>Id del elemento</summary>
		/// <value>Id del elemento</value>
		public String ID
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
		String occurrence;
		/// <summary>Ocurrencia del contenido</summary>
		/// <value>Ocurrencia del contenido</value>
		public String Occurrence
		{
			get
			{
				return occurrence;
			}
			set
			{
				occurrence=value;
			}
		}
		String paso="";	
	
		/// <summary>Paso en el que se encuentra el contenido</summary>
		/// <value>Paso en el que se encuentra el contenido</value>
		public String Paso
		{
			get
			{
				return paso;
			}
			set
			{
				paso=value;
			}
		}
		String topicmap;
		/// <summary>TopicMap (sitio) en el que se encuentra el contenido</summary>
		/// <value>TopicMap (sitio) en el que se encuentra el contenido</value>
		public String TopicMap
		{
			get
			{
				return topicmap;
			}
			set
			{
				topicmap=value;
			}
		}
		String topic;
		/// <summary>Topic (seccion) en el que se encuentra el contenido</summary>
		/// <value>ID del topic (seccion) en el que se encuentra el contenido</value>
		public String Topic
		{
			get
			{
				return topic;
			}
			set
			{
				topic=value;
			}
		}
		String flow;
		/// <summary>ID del flujo en el que se encuentra el contenido</summary>
		/// <value>ID del flujo en el que se encuentra el contenido</value>
		public String Flow
		{
			get
			{
				return flow;
			}
			set
			{
				flow=value;
			}
		}
		System.Xml.XmlElement xmlcontent;
		/// <summary>
		/// Regresa el contenido xml de una petici�n
		/// </summary>
		public System.Xml.XmlElement XMLContent
		{
			get
			{
				return xmlcontent;
			}
			set
			{
				xmlcontent=value;
			}
		}
		/// <summary>
		/// Consturctor por defecto
		/// </summary>
		public CWBListViewItem()
		{
			//
			// TODO: Add constructor logic here
			//
		}
	}
}
