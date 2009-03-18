/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Windows.Forms;
namespace WBOffice3
{
	/// <summary>Nodo en el arbol de Secciones</summary>
	public class WBNode : TreeNode
	{
		bool willExpand=false;
		String reloadPath;
		String id;		
		/// <summary>Contruye un nodo para el �rbol de secciones</summary>
		/// <param name="id">Id del nodo</param>
		/// <param name="name">Nombre del nodo</param>
		/// <param name="reloadPath">Path para cargar hijos</param>
		public WBNode(String id,String name,String reloadPath)
		{
			this.Text=name;
			this.reloadPath=reloadPath;
			this.id=id;
		}
		/// <summary>Regresa al ID del nodo</summary>
		/// <returns>ID del nodo</returns>
		public String getID()
		{
			return id;
		}
		/// <summary>Path para cargar hijos</summary>
		/// <value>Path para cargar hijos</value>
		public String ReloadPath
		{
			get
			{
				return reloadPath;
			}
		}
		/// <summary>
		/// Indica si se puede expandir el nodo
		/// </summary>
		public bool WillExpand
		{
			get
			{
				return willExpand;
			}
			set
			{
				willExpand=value;
			}
		}
	}
}
