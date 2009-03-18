/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;

namespace WBOffice3
{
	/// <summary>Parametro para generar XML de petici�n de servicio a servidor</summary>
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
		/// <summary>Valor del par�metro</summary>
		/// <value>Valor del par�metro</value>
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
