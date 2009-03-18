/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;

namespace CHtmlParser
{
	/// <summary>Tag asociado a un archivo HTML</summary>
	public class CTag
	{
		AttibuteCollection atts= new AttibuteCollection(); 
		/// <summary>Propiedad que contiene los atributos del tag</summary>
		/// <value>Regresa los atributos del tag</value>
		public AttibuteCollection Attibutes
		{
			get
			{
				return atts;
			}
		}
		String name=null;
		/// <summary>Nombre del tag</summary>
		/// <value>Regresa el nombre del tag</value>
		public String Name
		{
			get
			{
				return name;
			}
		}
		String tag=null;
		/// <summary>Contiene el tag como fue originalmente almacenado</summary>
		/// <value>Regresa el tag como fue originalmente almacenado</value>
		public String Tag
		{
			get
			{
				return tag;
			}
		}
		/// <summary>Contruye un tag en base al string tag asociado</summary>
		/// <example>
		/// CTag tag=new CTag("&lt;a href="demo.html"&gt;");
		/// </example>
		/// <param name="tag">Tag asociado en formato string</param>
		public CTag(String tag)
		{
			//
			// TODO: Add constructor logic here
			//
			this.tag=tag;
			tag=tag.Remove(0,1);
			tag=tag.Remove(tag.Length -1,1);
			tag=tag.Replace("\r\n"," ");
			char[] sep={' '};
			String[] valores=tag.Split(sep);
			this.name=valores[0];
			for(int i=1;i<valores.Length;i++)
			{
				if(!valores[i].Equals(""))
				{
					if(valores[i].IndexOf("=")!=-1)
					{
						CHtmlParser.CAttibute patt= new CAttibute(valores[i]);
						this.atts.Add(patt); 
					}
				}
			}
		}
	}
}
