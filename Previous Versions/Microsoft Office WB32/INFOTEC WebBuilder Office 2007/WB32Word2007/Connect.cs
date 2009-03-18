/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;	

using System.Runtime.InteropServices;
using Word = Microsoft.Office.Interop.Word;
using Office = Microsoft.Office.Core;
using System.Diagnostics;
using System.Windows.Forms;
using System.Drawing;
using WBOffice3;
using System.Threading;
using System.Globalization;
using System.Net;
using System.IO;
using System.Configuration;
using System.Xml;
namespace WBWord
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
	
	


	public class Connect 
	{
		/// <summary>
		///		Implements the constructor for the Add-in object.
		///		Place your initialization code within this method.
		/// </summary>
		/// 
		System.Resources.ResourceManager resword = new System.Resources.ResourceManager("WBWord.wordres",System.Reflection.Assembly.GetExecutingAssembly());		
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));		

		
		//bool addlogout=true;
		//bool addlogin=true;
		
		
		public static CWebBuilder wb;
		/// <summary>Contruye el objeto que maneja la conexión a Word</summary>
		public Connect()
		{

			
			#if(DEBUG)
			try
			{
				Trace.AutoFlush=true;
				String path=(new FileInfo( this.GetType().Assembly.Location)).DirectoryName+@"\errWB.txt";
				FileInfo flog=new FileInfo(path);
				if(flog.Exists)
				{
					flog.Delete();
				}
				flog.Create();
				Trace.Listeners.Add(new TextWriterTraceListener(path));
				Trace.WriteLine(DateTime.Now.ToString());
				Trace.WriteLine("");				
				Trace.Flush();
			}
			catch
			{

			}
			#endif

			#if(INGLES)
				try
				{
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("en",false);													
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message+"\r\n"+e.StackTrace);
				}
#elif(DEBUG)
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
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("",false);
                    
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message+"\r\n"+e.StackTrace);
				}
			#endif
			
			this.confLang();
			
			
			
		}
		/// <summary>
		/// Condigura idioma de la aplicación en base a archivo de condiguración si existe
		/// </summary>
		public void confLang()
		{
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
		/// Función para agregar un nuevo contenido
		/// </summary>
		/// <param name="button">Boton asociado</param>
		/// <param name="target"></param>
		public void New(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.New(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				MessageBox.Show(err.StackTrace);
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función para mostrar cuadro de dialogo para paginación
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void menuPag(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.menuPag(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				MessageBox.Show(err.StackTrace);
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función para mostrar las propiedades del contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Properties(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.Properties(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				MessageBox.Show(err.StackTrace);
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función para presentar la pantalla de presentación preeliminar
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Preview(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.Preview(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función para mostrar el detalle de un contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Detalle(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.ResumenArchivos(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función para borrar un contenido del sitio
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Delete(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.Delete(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función para agregar una liga a una sección
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void AddLink(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.AddLink(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		
		/// <summary>
		/// Función que muestra el listado de reglas para asociar una regla(s) a un contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Reglas(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.CreateRule(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}	
		/// <summary>
		/// Función que muestra el asistente para crear una sección
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Seccion(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.CreateTopic(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}	
		/// <summary>
		/// Función que muestra la pantalla de dialogo para cambiar password
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Password(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.ChangePassword(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función que muestra la pantalla de abrir sessión
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Login(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.Login(this.applicationObject);												
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función que permite cerrar una sesión
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Logout(Office.CommandBarButton button,ref bool target)
		{			
			
			try
			{				
				CWebBuilder.user=wb.Logout(this.applicationObject,CWebBuilder.user);				
			}
			catch(Exception err)
			{
				MessageBox.Show(err.Message);
				Debug.WriteLine(err.Message);
				return;
			}
			
		}
		/// <summary>
		/// Función que muestra el acer de, de la herramienta
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void About(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				FrmAbout frm=new FrmAbout();
				frm.ShowDialog();
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función que muestra la ayuda de INFOTEC WebBuilder
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Help(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				//String path=(new System.IO.FileInfo(System.Reflection.Assembly.GetExecutingAssembly().Location)).DirectoryName;
				//System.Diagnostics.Process.Start(path+"\\help.chm");
				System.Diagnostics.Process.Start("explorer.exe","\"http://wb3help.infotec.com.mx/wb/WB3H/WB3H_wb_word\"");

			}
			catch(Exception err)
			{				
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Función que permite mostrar el asistente para apertura de contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Open(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.Open(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{			
				Debug.WriteLine(err.Message);
			}
		}			
			
		/// <summary>
		/// Función que muestra la bitacora de cambios de un contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void ShowBitacora(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.Bitacora(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{			
				Debug.WriteLine(err.Message);
			}
		}	
		/// <summary>
		/// Función que muestra los documentos por autorizar
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void ShowFlujos(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CWebBuilder.user=wb.MuestraFlujo(this.applicationObject,CWebBuilder.user);
			}
			catch(Exception err)
			{			
				Debug.WriteLine(err.Message);
			}
		}		
		/// <summary>
		/// Función que permite borrar la asociación de un contenido con una sección
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void DeleteAsociation(Office.CommandBarButton button,ref bool target)
		{
			if(MessageBox.Show(resources.GetString("CWebBuilder.askquitaasocia"),resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.Cancel)
			{
				return;
			}
			try
			{
				bool delete=false;
                CWebBuilder.doc = (Word.DocumentClass)applicationObject.ActiveDocument;
                Office.DocumentProperties props2 = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;						
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("confpag"))
					{
						prop.Delete();		
						delete=true;
						continue;
					}
					if(prop.Name.Equals("content"))
					{
						prop.Delete();		
						delete=true;
						continue;
					}
					if(prop.Name.Equals("topicid"))
					{
						prop.Delete();
						delete=true;
						continue;
					}
					if(prop.Name.Equals("topicmap"))
					{
						prop.Delete();			
						delete=true;
						continue;
					}
				}
				if(delete)
				{
                    if (!CWebBuilder.doc.Saved)
                    {
                        CWebBuilder.doc.Save();
                    }
				}
			}
			catch(Exception e)
			{
				Debug.WriteLine(e.Message);
			}
			MessageBox.Show(resources.GetString("CWebBuilder.deleteasociation"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
		}
		
		/// <summary>
		/// Variable que apunta a la aplicación Word
		/// </summary>
		public Word.Application applicationObject;		
	}
	
}