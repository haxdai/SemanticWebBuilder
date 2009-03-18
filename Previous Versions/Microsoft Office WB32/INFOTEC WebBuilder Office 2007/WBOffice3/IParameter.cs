/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;

namespace WBOffice3
{
	/// <summary>Interface que define como es una parametro para generar el XML de petici�n</summary>
	public interface IParameter
	{
		
		/// <summary>
		/// Atrubutos que contiene el parametro, se concider�n atributos de un tag para
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
