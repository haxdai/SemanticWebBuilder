/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.IO;

namespace WBOffice3
{
	/// <summary>
	/// Indica que en una petición, un parametro de la petición al servidor, pueda ser un
	/// archivo (deprecated)
	/// </summary>
	public class FileParameter : IParameter
	{
		private String myvalue;
		private String name;
		private FileInfo finfo;
		private byte[] content;
		private Attributes atts=new Attributes();
		/// <summary>
		/// Regresa los atributos asociados
		/// </summary>
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
		/// <summary>
		/// Regresa el Archivo que es parametro
		/// </summary>
		public FileInfo FileInfo
		{
			get
			{
				return finfo;
			}
		}
		/// <summary>
		/// indica si el parametro es un archivo
		/// </summary>
		public bool IsFile
		{
			get
			{
				return true;
			}
		}
		/// <summary>
		/// Contenido del archivo
		/// </summary>
		public byte[] Content
		{
			get
			{
				return content;
			}
		}
		/// <summary>
		/// Nombre del parametro
		/// </summary>
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
		/// <summary>
		/// Valor del parametro
		/// </summary>
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
		/// Constructor de un parametro que permite indicar un archivo
		/// </summary>
		/// <param name="name">Nombre a llevar</param>
		/// <param name="path">Ruta del archivo</param>
		public FileParameter(String name,String path)
		{
			//
			// TODO: Add constructor logic here
			//
			this.myvalue=path;
			this.name=name;
			this.finfo=new FileInfo(path); 
			if(finfo.Exists)
			{
				content=new byte[finfo.Length];                
				FileStream fin=finfo.Open(FileMode.Open,FileAccess.Read,FileShare.ReadWrite);
				fin.Read(content,0,content.Length);
                fin.Close();                
			}
		}
	}
}
