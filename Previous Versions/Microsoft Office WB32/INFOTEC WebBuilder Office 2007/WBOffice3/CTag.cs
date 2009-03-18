/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
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
