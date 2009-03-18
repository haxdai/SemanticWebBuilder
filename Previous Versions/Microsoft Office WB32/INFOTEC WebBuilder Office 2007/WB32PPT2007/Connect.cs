/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Runtime.InteropServices;
using System.Diagnostics;
using System.Windows.Forms;
using WBOffice3;
using System.Threading;
using System.Globalization;
using System.IO;
using System.Configuration;
using System.Xml;
using PowerPoint = Microsoft.Office.Interop.PowerPoint;
using Office = Microsoft.Office.Core;

namespace WBPowerPoint
{
	
	

	#region Read me for Add-in installation and setup information.
	// When run, the Add-in wizard prepared the registry for the Add-in.
	// At a later time, if the Add-in becomes unavailable for reasons such as:
	//   1) You moved this project to a computer other than which is was originally created on.
	//   2) You chose 'Yes' when presented with a message asking if you wish to remove the Add-in.
	//   3) Registry corruption.
	// you will need to re-register the Add-in by building the MyAddin21Setup project 
	// by right clicking the project in the Solution Explorer, then choosing install.
	#endregion
	
	/// <summary>
	///   The object for implementing an Add-in.
	/// </summary>	
	public class Connect  
	{
		/// <summary>
		///		Implements the constructor for the Add-in object.
		///		Place your initialization code within this method.
		/// </summary>
		/// 
		System.Resources.ResourceManager resppt = new System.Resources.ResourceManager("WBPowerPoint.respp",System.Reflection.Assembly.GetExecutingAssembly());		
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));

        public static CPowerPoint wbe;
		
		public Connect()
		{
            WBPowerPoint.Connect.wbe = new WBPowerPoint.CPowerPoint();
			#if(INGLES)
				try
				{
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("en",false);													
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message+"\r\n"+e.StackTrace);
				}
			#elif (DEBUG) 
				try
				{
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("es",false);													
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message+"\r\n"+e.StackTrace);
				}
			#else
				try
				{
                    Thread.CurrentThread.CurrentUICulture = new CultureInfo("", false);													
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message+"\r\n"+e.StackTrace);
				}
			#endif			
			try
			{
				String lang=null;
				FileInfo f=new FileInfo(new FileInfo(this.GetType().Assembly.Location).DirectoryName+"/wb.config");
				if(f.Exists)
				{
					ConfigXmlDocument doc=new  ConfigXmlDocument();				
					doc.Load(f.FullName);
					foreach(XmlElement e in  doc.SelectNodes("/configuration/key"))
					{
						if(e.GetAttribute("name")=="lang")
						{
							lang=e.GetAttribute("value");
						}
					}
				}			
				if(lang!=null)
				{
					Thread.CurrentThread.CurrentUICulture=new CultureInfo(lang,false);													
				}
			}
			catch{}
		}

		

		
		/// <summary>
		/// Publica o actualiza un contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		
		public PowerPoint.Application applicationObject;
		
	}
}