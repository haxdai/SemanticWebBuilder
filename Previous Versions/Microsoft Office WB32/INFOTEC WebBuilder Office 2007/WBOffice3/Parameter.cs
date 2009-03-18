/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;

namespace WBOffice3
{
	/// <summary>Parametro para generar XML de petición de servicio a servidor</summary>
	public class Parameter : IParameter
	{
		ParameterCollection parametros=new ParameterCollection();
		/// <summary>Sub parametros asociados</summary>
		/// <value>Sub parametros asociados</value>
		public ParameterCollection Parametros
		{
			get
			{
				return parametros;
			}
			set
			{
				parametros=value;
			}
		}
		private String myvalue;
		private String name;
		private Attributes atts=new Attributes();
		/// <summary>Atributos asociados</summary>
		/// <value>Atributos asociados</value>
		public Attributes Attributes
		{
			get
			{
				return atts;
			}
			set
			{
				atts=value;
			}
		}
		/// <summary>Indica si es archivo</summary>
		/// <value>false siempre</value>
		public bool IsFile
		{
			get
			{
				return false;
			}
		}
		/// <summary>Nombre del parametro</summary>
		/// <value>Nombre del parametro</value>
		public String Name
		{
			get
			{
				return name;
			}
			set
			{
				name=value;
			}
		}
		/// <summary>Valor del parámetro</summary>
		/// <value>Valor del parámetro</value>
		public String Value
		{
			get
			{
				return myvalue;
			}
			set
			{
				myvalue=value;
			}
		}
		/// <summary>
		/// Crea un parametro simple
		/// </summary>
		/// <param name="name">Nombre del parametro</param>
		/// <param name="value">Valor del parametro</param>
		public Parameter(String name,String value)
		{
			//
			// TODO: Add constructor logic here
			//
			this.myvalue=value;
			this.name=name;
		}
	}
}
