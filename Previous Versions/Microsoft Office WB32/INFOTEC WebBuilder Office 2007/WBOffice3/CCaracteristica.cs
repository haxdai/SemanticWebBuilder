/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;

namespace WBOffice3
{
	/// <summary>Clase para mostar un conjunto de opciones dentro de un combo</summary>
	public class CCaracteristica
	{
		private String orden="0";
		/// <summary>Ordenaci�n del elemento</summary>
		/// <value>Ordenaci�n del elemento</value>
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
		private bool mreadonly=false;
		/// <summary>Si es de solo lectura</summary>
		/// <value>true es solo lectura, no, se puede modificar</value>
		public bool ReadOnly
		{
			get
			{
				return mreadonly;
			}
			set
			{
				mreadonly=value;
			}
		}
		CValoresCollection valores= new CValoresCollection();
		/// <summary>Valores asociados</summary>
		/// <value>Valores asociados</value>
		public CValoresCollection Valores
		{
			get
			{
				return valores;
			}
			set
			{
				valores=value;
			}
		}
		String name;
		/// <summary>Nombre de la caracteristica a mostrar</summary>
		/// <value>Nombre de la caracteristica a mostrar</value>
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
		/// <summary>Regresa la Etiqueta a mostrar</summary>
		/// <returns>Regresa la Etiqueta a mostrar</returns>
		public override String ToString()
		{
			return label;
		}
		/// <summary>
		/// Constructor de una caracterisitca
		/// </summary>
		/// <param name="label">Texto a mostrar</param>
		/// <param name="name">Nombre con el que se identifica</param>
		public CCaracteristica(String label,String name)
		{
			//
			// TODO: Add constructor logic here
			//
			this.label=label;
			this.name=name;
		}

	}
}
