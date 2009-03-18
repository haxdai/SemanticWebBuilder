/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Text.RegularExpressions;
using System.Diagnostics;
using WBOffice3;
namespace CHtmlParser
{
	/// <summary>Clase encargada de manejar y parser un HTML</summary>
	public class CHTMLDcoument
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private String html=null;
		private TagCollection tags= new TagCollection();
		/// <summary>Conjunto de Tags asociados al archivo HTML</summary>
		public TagCollection Tags
		{
			get
			{
				return tags;
			}
		}
		private String InnerHtml
		{
			
			get
			{
				return html;
			}
		}
		/// <summary>Contruye el Objeto v�cio</summary>
		public CHTMLDcoument()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>Borra tags con condiciones</summary>
		/// <returns>HTML sin los tags borrados</returns>
		/// <param name="html">Html a parsear</param>
		/// <param name="valor">String incial para borrar</param>
		/// <param name="valorfin">String final para borrar</param>
		/// <param name="condicion">Condici�n para borrar</param>
		public String BorrarCondicionado(String html,String valor,String valorfin,String condicion)
		{
			String shtml=html;
			int pos;
			pos=shtml.ToLower().IndexOf(valor.ToLower());
			while(pos!=-1)
			{
				int pos2=shtml.ToLower().IndexOf(valorfin,pos);
				String htmltest=shtml.Substring(pos,pos2+valorfin.Length-pos);
				if(htmltest.IndexOf(condicion)!=-1)
				{
					pos=shtml.ToLower().IndexOf(shtml,pos2+valorfin.Length);
				}
				else
				{
					if(pos2!=-1)
					{
						shtml=shtml.Substring(0,pos)+shtml.Substring(pos2+valorfin.Length);
					}			
					else
					{
						shtml=shtml.Substring(0,pos);
						throw new Exception(resources.GetString("CHTMLDcoument.err1")+ valor +resources.GetString("CHTMLDcoument.err2"));
					}
					pos=shtml.ToLower().IndexOf(valor);
				}
			}
			return shtml;
			
		}
		/// <summary>Borra tags</summary>
		/// <param name="html">Html a parsear</param>
		/// <param name="valor">String incial para borrar</param>
		/// <param name="valorfin">Condici�n para borrar</param>
		public String Borrar(String html,String valor,String valorfin)
		{
			String shtml=html;
			int pos;
			pos=shtml.ToLower().IndexOf(valor.ToLower());
			while(pos!=-1)
			{
				int pos2=shtml.ToLower().IndexOf(valorfin,pos);
				if(pos2!=-1)
				{
					shtml=shtml.Substring(0,pos)+shtml.Substring(pos2+valorfin.Length);
				}			
				else
				{
					shtml=shtml.Substring(0,pos);
					throw new Exception(resources.GetString("CHTMLDcoument.err1")+ valor +resources.GetString("CHTMLDcoument.err2"));
				}
				pos=shtml.ToLower().IndexOf(valor);
			}
			return shtml;
			
		}
		/// <summary>Lee un HTML y lo parsea en tags</summary>
		/// <param name="html">Html a parserar</param>
		public void LoadHml(String html)
		{
			html=BorrarCondicionado(html,"<!--","-->","<![endif]");
			html=Borrar(html,"<script","</script>");			
			html=html.Replace("\r\n"," "); 
			html=html.Replace("\r"," "); 
			html=html.Replace("\n"," "); 
			
			try
			{
				string RE_HTMLTag = @"\<.*?>";	
				Regex HTMLTagRE = new Regex(RE_HTMLTag, RegexOptions.Compiled | RegexOptions.IgnoreCase | RegexOptions.Singleline);
				MatchCollection  mtags=HTMLTagRE.Matches(html); 
				foreach(System.Text.RegularExpressions.Match m in mtags)
				{
					foreach(System.Text.RegularExpressions.Capture cap in m.Captures)   
					{
						CTag tag= new CTag(cap.Value);
						tags.Add(tag); 
					}
				}
			}
			catch(Exception e)
			{
				Debug.WriteLine(e.Message); 
			}
		}
	}
}
