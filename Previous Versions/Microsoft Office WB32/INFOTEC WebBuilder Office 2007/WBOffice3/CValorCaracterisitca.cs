/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;

namespace WBOffice3
{
	/// <summary>
	/// Clase utileria para indicar un valor, etiqueta, orden para mostrar en un combo en
	/// interfaz de usuario
	/// </summary>
	public class CValorCaracterisitca
	{
		bool selected=false;
		/// <summary>Indica si el valor fue seleccionado</summary>
		/// <value>Indica si el valor fue seleccionado</value>
		public bool Selected
		{
			get
			{
				return selected;
			}
			set
			{
				selected=value;
			}
		}
		String label;
		/// <summary>Etiqueta a mostrar</summary>
		/// <value>Etiqueta a mostrar</value>
		public String Label
		{
			get
			{
				return label;
			}
			set
			{
				label=value;
			}
		}
		/// <summary>Nombre del valor</summary>
		/// <value>Nombre del valor</value>
		/// <remarks>Este se usa de manera interna, puede ser un ID</remarks>
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
		private String orden="0";
		/// <summary>Orden en el que se muestra</summary>
		/// <value>Regresa el string de ordenaci�n del valor</value>
		public String Orden
		{
			get
			{
				return orden;
			}
			set
			{
				orden=value;
			}
		}
		/// <summary>Regresa la Etiqueta del valor</summary>
		/// <returns>Regresa la Etiqueta del valor</returns>
		public override String ToString()
		{
			return label;
		}
		String name;
		/// <summary>Contruye un valor para un combo de presentaci�n en interfaz de usuario</summary>
		/// <param name="label">Etiqueta a usar</param>
		/// <param name="name">Nombre del valor</param>
		public CValorCaracterisitca(String label,String name)
		{
			//
			// TODO: Add constructor logic here
			//
			this.label=label;
			this.name=name;
		}
	}
}
