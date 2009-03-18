/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;

namespace WBOffice3
{
	/// <summary>Interface que define como es una parametro para generar el XML de petición</summary>
	public interface IParameter
	{
		
		/// <summary>
		/// Atrubutos que contiene el parametro, se conciderán atributos de un tag para
		/// XML
		/// </summary>
		/// <value>Atrubutos que contiene el parametro</value>
		Attributes Attributes
		{
			get;		
			set;			
		}
		/// <summary>Indica si el parametro es de tipo archivo o no</summary>
		/// <value>true es archivo, false es un parametro normal</value>
		bool IsFile
		{
			get;
		}
		/// <summary>Nombre del parametro</summary>
		/// <value>Nombre del parametro</value>
		String Name
		{
			get;
			set;
		}
		/// <summary>
		/// Valor del parametro
		/// </summary>
		String Value
		{
			get;
			set;
		}

	}
}
