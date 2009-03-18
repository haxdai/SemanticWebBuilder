/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
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
		/// <value>Regresa el string de ordenación del valor</value>
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
		/// <summary>Contruye un valor para un combo de presentación en interfaz de usuario</summary>
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
