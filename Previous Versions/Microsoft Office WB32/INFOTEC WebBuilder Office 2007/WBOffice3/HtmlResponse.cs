/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Xml;
using System.Text;
using System.IO;
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>Clase que representa una respuesta a una petición HTTP</summary>
	public class HtmlResponse
	{
		String html="";
		System.Xml.XmlDocument xml;
		HeaderCollection headers= new HeaderCollection();
		int state=404;
		/// <summary>HTML de respuesta</summary>
		/// <value>HTML de respuesta</value>
		public String Html
		{
			get
			{
				return html;
			}
			set
			{
				html=value;
			}
		}
		/// <summary>Headers asociados a la respuesta</summary>
		/// <value>Headers asociados a la respuesta</value>
		public HeaderCollection Headers
		{
			get
			{
				return headers;
			}
		}
		/// <summary>Estado de la respuesta</summary>
		/// <value>Estado de la respuesta, 200 (OK), 404 (Not Found), etc.</value>
		public int State
		{
			get
			{
				return this.state;
			}
			set
			{
				this.state=value;
			}
		}
		/// <summary>En caso de regresar XML, esta propiedad regresa ese XML</summary>
		/// <value>XML de respuesta, null en caso de que la respuesta no sea un XML.</value>
		public System.Xml.XmlDocument XML
		{
			get
			{
				return xml;
			}
			set
			{
				xml=value;
			}
		}
		
		
		/// <summary>Crea un HtmlResponse</summary>
		/// <param name="resp">String obtenido de respuesta, puede ser XML o HTML</param>
		public HtmlResponse(String resp)
		{
			if(resp!=null)
			{				
				String contresp=resp;
				//GetHeaders(ref resp);
			}
			
		}
		
		/// <summary>Crea un objeto HtmlResponse vácio</summary>
		public HtmlResponse()
		{
			this.state=404; // no se encontro el recurso
		}
		/// <summary>
		/// Crea un Html
		/// </summary>
		/// <param name="xml">Xml de respuesta</param>
		/// <param name="headers">Headers que contiene la respuesta</param>
		public HtmlResponse(System.Xml.XmlDocument xml,HeaderCollection headers)
		{
			//
			// TODO: Add constructor logic here
			//
			this.xml=xml;
			this.headers=headers;

		}
	}
}
