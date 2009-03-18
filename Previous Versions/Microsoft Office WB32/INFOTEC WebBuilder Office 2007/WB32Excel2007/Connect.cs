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
using Excel = Microsoft.Office.Interop.Excel;
using Office = Microsoft.Office.Core;
namespace WBExcel
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
	/// <seealso class='IDTExtensibility2' />
	
	public class Connect 
	{
		/// <summary>
		///		Implements the constructor for the Add-in object.
		///		Place your initialization code within this method.
		/// </summary>
		/// 
		System.Resources.ResourceManager resexcel = new System.Resources.ResourceManager("WBExcel.resexcel",System.Reflection.Assembly.GetExecutingAssembly());		
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));		
		
		
        		
		/// <summary>
		/// Variable que maneja las funciones de WebBuilder
		/// </summary>
		public static CExcel wbe;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public Connect()
		{
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
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("",false);													
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
		/// Crea contenido o actualiza
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void New(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.New((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}

		}
		/// <summary>
		/// Muestra propiedades de documento
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Properties(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.Properties((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Muestra presentación preeliminar de contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Preview(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.Preview((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/*public void Detalle(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.ResumenArchivos((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}*/
		/// <summary>
		/// Borra contenido almacenado en el sitio
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Delete(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.Delete((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Agrega reglas al contenido
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Reglas(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.CreateRule((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}	
		/// <summary>
		/// Crea sección
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Seccion(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.CreateTopic((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}	
		/// <summary>
		/// Cambia password de usuario
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Password(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.ChangePassword((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Muestra pantalla de abrir sesión
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Login(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.Login((Excel.Application)this.applicationObject);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Muestra pantalla de cierre de sessión
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Logout(Office.CommandBarButton button,ref bool target)
		{
			
			try
			{
				CExcel.user=wbe.Logout((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
				return;
			}
			/*try
			{
				this.mLogin.Enabled=true;
				this.mLogout.Enabled=false;
			}
			catch{}*/
		}
		
		/// <summary>
		/// Abre un contenido almacenado en el sitio
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Open(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.Open((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}			
		
		/// <summary>
		/// Borra asociación de documento con sección y sitio
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
				CExcel.doc=this.applicationObject.ActiveWorkbook;
                Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props2)
				{
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
                    if (!CExcel.doc.Saved)
                    {
                        CExcel.doc.Save();
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
		/// Muestra pantalla de acerca de
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
		/// Muestra la bitacora de cambios
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void ShowBitacora(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				CExcel.user=wbe.Bitacora((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{			
				Debug.WriteLine(err.Message);
			}
		}	
		/// <summary>
		/// Muestra documentos por autorizar
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
        public void ShowFlujos(Office.CommandBarButton button, ref bool target)
		{
			try
			{
				CExcel.user=wbe.MuestraFlujo((Excel.Application)this.applicationObject,CExcel.user);
			}
			catch(Exception err)
			{			
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Muestra ayuda
		/// </summary>
		/// <param name="button"></param>
		/// <param name="target"></param>
		public void Help(Office.CommandBarButton button,ref bool target)
		{
			try
			{
				System.Diagnostics.Process.Start("explorer.exe","\"http://wb3help.infotec.com.mx/wb/WB3H/WB3H_wb_excel\"");

			}
			catch(Exception err)
			{
				Debug.WriteLine(err.Message);
			}
		}
		/// <summary>
		/// Objeto a aplicación Excel
		/// </summary>
		public Excel._Application applicationObject;
		
		
		
	}
}