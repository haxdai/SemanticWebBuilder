/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Xml;
using System.Text;
using System.IO;
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>Clase que representa una respuesta a una petici�n HTTP</summary>
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
		
		/// <summary>Crea un objeto HtmlResponse v�cio</summary>
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
