/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using WBOffice3;
using CHtmlParser;
using System.Collections;
using System.IO;
using System.Windows.Forms;
using System.Diagnostics;
using System.Xml;
using Excel = Microsoft.Office.Interop.Excel;
using Office = Microsoft.Office.Core;
namespace WBExcel
{
	/// <summary>
	/// Summary description for CExcel.
	/// </summary>
	public class CExcel
	{
		/// <summary>
		/// Tipo de contenido
		/// </summary>
		public static readonly String TYPE="ExcelContent";
		/// <summary>
		/// Guarda las propiedades de un contenido
		/// </summary>
		/// <param name="topicmap">Sitio</param>
		/// <param name="topicid">Sección</param>
		/// <param name="idcont">Contenido</param>
		public void Save(String topicmap,String topicid,String idcont)
		{
			bool save=false;
            Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
			foreach(Office.DocumentProperty prop in props)
			{
				if(prop.Name.Equals("topicid"))
				{
					if(!topicid.Equals(prop.Value))
						save=true;
					prop.Value=topicid;						
				}
				else if(prop.Name.Equals("topicmap"))
				{
					if(!topicmap.Equals(prop.Value))
						save=true;
					prop.Value=topicmap;							
				}
				else if(prop.Name.Equals("content"))
				{
					if(!idcont.Equals(prop.Value))
						save=true;
					prop.Value=idcont;							
				}
			}
			if(save)
			{
                if (!doc.Saved)
                {
                    doc.Save();
                }
				
			}
		}
		
		
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));		
		/// <summary>
		/// Documento Excel
		/// </summary>
		public static Excel.Workbook doc=null;
		/// <summary>
		/// Aplicación Excel
		/// </summary>
		public static Excel._Application  app=null;
		/// <summary>
		/// Usuario que accedio
		/// </summary>
		public static CUserAdmin user;
		/// <summary>
		/// Parametros para envío
		/// </summary>
		public static ParameterCollection parametros=new ParameterCollection(); 
		/// <summary>
		/// Parametros de resultado
		/// </summary>
		
		public static ParameterCollection resultados=new ParameterCollection(); 				
		/// <summary>
		/// Imagenes asociadas
		/// </summary>
		public static ArrayList imagenes=new ArrayList();
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public CExcel()
		{
			
#if(ING)
				System.Threading.Thread.CurrentThread.CurrentUICulture =new  System.Globalization.CultureInfo("en",false) ;														
#endif	
		}
		/// <summary>
		/// Resumen de archivos
		/// </summary>
		/// <param name="app">Aplicación Excel</param>
		/// <param name="user">Usuario</param>
		/// <returns></returns>
		public CUserAdmin ResumenArchivos(Excel._Application app,CUserAdmin user)
		{
			CExcel.app=app;
			CExcel.user=user;
			 
			if(isDocumentoNull())
			{
				return user;
			}
			CExcel.doc=app.ActiveWorkbook;
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			FileInfo f= new FileInfo(CExcel.doc.FullName);
			if(!f.Exists)
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}
			try
			{
				long l=f.Length;
			}
			catch(Exception fe)
			{
				Console.WriteLine(fe.Message);  
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}			
			FrmDetalleDoc frm=new FrmDetalleDoc(); 			
			frm.ShowDialog(); 
			return CExcel.user;

		}
		/// <summary>
		/// Cambia el password de un usuario
		/// </summary>
		/// <param name="app">Aplicación Excel</param>
		/// <param name="user">Usuario</param>
		/// <returns></returns>
		public CUserAdmin ChangePassword(Excel._Application app,CUserAdmin user)
		{
			CExcel.app=app;
			CExcel.user=user;
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			FrmPassword frm=new FrmPassword(CExcel.user); 
			frm.ShowDialog();
			return CExcel.user;
		}
		/// <summary>
		/// Muestra forma acerca de
		/// </summary>
		public void About()
		{
			FrmAbout frm =new FrmAbout();
			frm.ShowDialog(); 
		}
		/// <summary>
		/// Muestra la forma de preview
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Preview(Excel._Application app,CUserAdmin user)
		{
			CExcel.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
            CExcel.doc = app.ActiveWorkbook;
			CExcel.user=user; 
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
            Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
			String topicmap="";
			String topicid="";
			String idcont="";
			foreach(Office.DocumentProperty prop in props)
			{
				if(prop.Name.Equals("content"))
				{
					idcont=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicid"))
				{
					topicid=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicmap"))
				{
					topicmap=(String)prop.Value;					
				}
			}
			if(idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}
			Servicios servicio= new Servicios(CExcel.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("content"))
					{
						prop.Delete();		
						continue;
					}
					if(prop.Name.Equals("topicid"))
					{
						prop.Delete();
						continue;
					}
					if(prop.Name.Equals("topicmap"))
					{
						prop.Delete();			
						continue;
					}
				}
                if (!doc.Saved)
                {
                    doc.Save();
                }
				return CExcel.user;
			}
			try
			{
				servicio= new Servicios(CExcel.user);
				XmlDocument resp=servicio.getContentAtt(topicmap,topicid,idcont);
				if(resp.GetElementsByTagName("lastversion").Count>0)
				{
					FrmPreview frm =new FrmPreview(topicmap,topicid,idcont,resp.GetElementsByTagName("lastversion")[0].InnerText,CExcel.user);
					frm.Text=resources.GetString("CWebBuilder.t1");
					frm.ShowDialog(); 
				}
				else
				{
					FrmPreview frm =new FrmPreview(topicmap,topicid,idcont,CExcel.user);
					frm.Text=resources.GetString("CWebBuilder.t1");
					frm.ShowDialog(); 
				}			
				
			}
			catch(Exception ue)
			{
				Debug.WriteLine(ue.Message);
			}
			return CExcel.user;
		}
		/// <summary>
		/// Muestra la página de infotec
		/// </summary>
		public void PagWeb()
		{
			FrmPreview frm =new FrmPreview("http://www.infotec.com.mx");
			frm.Text=resources.GetString("CWebBuilder.t2");						
			frm.ShowDialog(); 
			
		}
		/// <summary>
		/// Crea un nuevo contenido o actualiza
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin New(Excel._Application app,CUserAdmin user)
		{	
			ParameterCollection parametros=new ParameterCollection();
			ArrayList imagenes=new ArrayList();
			imagenes=new ArrayList();
			CExcel.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			object missing = System.Reflection.Missing.Value;
			resultados=new ParameterCollection(); 				
			parametros=new ParameterCollection();
            CExcel.doc = app.ActiveWorkbook;
			CExcel.app=doc.Application;  
			CExcel.user=user; 
			 
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			FileInfo fname=new FileInfo(doc.FullName);
			String ext=fname.Extension;
			if(ext.ToLower().Equals(""))
			{
                
				try
				{					
					FrmSave frm=new FrmSave();
					
					if(frm.saveFileDialog2.ShowDialog()==DialogResult.OK)
					{
                        doc.SaveAs(frm.saveFileDialog2.FileName, Excel.XlFileFormat.xlExcel7, missing, missing, missing, missing, Excel.XlSaveAsAccessMode.xlNoChange, missing, missing, missing, missing, missing);
					}
					else
					{
						return user;
					}
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
					return user;
				}
			}
			fname=new FileInfo(doc.FullName);
			ext=fname.Extension;
			
			if(ext.ToLower().Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg4")+" .xls",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				try
				{
                    
					FrmSave frm=new FrmSave();
					if(frm.saveFileDialog2.ShowDialog()==DialogResult.OK)
					{
                        doc.SaveAs(frm.saveFileDialog2.FileName, Excel.XlFileFormat.xlExcel7, missing, missing, missing, missing, Excel.XlSaveAsAccessMode.xlNoChange, missing, missing, missing, missing, missing);
					}
					else
					{
						return user;
					}
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
					return user;
				}
			}
			if(ext.ToLower().Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				return CExcel.user;
			}			
			if(!doc.Saved && ext.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg4")+" .xls",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);
                
				try
				{					
					FrmSave frm=new FrmSave();
					if(frm.saveFileDialog2.ShowDialog()==DialogResult.OK)
					{
                        doc.SaveAs(frm.saveFileDialog2.FileName, Excel.XlFileFormat.xlExcel7, missing, missing, missing, missing, Excel.XlSaveAsAccessMode.xlNoChange, missing, missing, missing, missing, missing);
					}
					else
					{
						return user;
					}
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
					return user;
				}
			}
			fname=new FileInfo(doc.FullName);
			ext=fname.Extension;
			if(!doc.Saved && ext.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				return CExcel.user;
			}
			// esta salvado
			
			if(!(ext.ToLower().Equals(".xls") || ext.ToLower().Equals(".xlsx")))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg4")+" .xls",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}			
			/*int SaveFormat=doc.SaveFormat;
			 
			if(SaveFormat!=0) 
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg4"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}*/			
			//valida nombre
			
			if(ValidaNombre(fname))
			{
				CUserAdmin usertemp=CExcel.user;
				int pos=fname.Name.IndexOf(fname.Extension);
				String name=fname.Name.Substring(0,pos);
                if (!doc.Saved)
                {
                    doc.Save();
                }							
				object strpathHtml=fname.Directory.FullName+"\\"+name+".html";												
				object objtrue=true;
				object objfalse=false;
                Excel.Workbook book = app.ActiveWorkbook;
				try
				{
					
					System.Array links=(System.Array)book.LinkSources(Excel.XlLink.xlExcelLinks);
					if(links!=null)
					{
						foreach(String link in links)
						{
							FileInfo f=new FileInfo(link);
							if(f.Exists && f.Length>0)
							{
								imagenes.Add(f);	
							}
						}
					}
				}
				catch{}
				try
				{
					WBOffice3.DialogResultEx valueres=WBOffice3.DialogResultEx.YES;
					foreach(Excel.Worksheet worksheet in book.Worksheets)
					{
						
						Excel.Hyperlinks links=worksheet.Hyperlinks;
						for(int i=1;i<=links.Count;i++)						
						{
							Excel.Hyperlink link=(Excel.Hyperlink)links.get_Item(i);
							try
							{
								String archivo=link.Address; 					
								if(archivo!=null)
								{
									
									try
									{
										System.Uri basepath=new System.Uri(doc.Path+"\\");
										System.Uri filepath=new System.Uri(basepath, archivo);
					
										if(filepath.IsFile) 
										{
											
											FileInfo farchivo= new FileInfo(filepath.LocalPath);						
											if(farchivo.Extension.IndexOf(".")!=-1)
											{
												if(farchivo.Exists)
												{	
													
													if(this.ValidaNombre(farchivo))
													{
														imagenes.Add(farchivo);												
													}
													else
													{
														
														FrmDetalleDoc frmresumen=new FrmDetalleDoc();
														frmresumen.ShowDialog(); 
														return CExcel.user;
													}
												}
												else
												{
//													if(MessageBox.Show(resources.GetString("CWebBuilder.msg5") +" "+ farchivo.FullName +" "+ resources.GetString("CWebBuilder.msg6") +"",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error)==DialogResult.No)
//													{
//														return CExcel.user;
//													}
													if(valueres!=DialogResultEx.YESALL)
													{
														valueres=WBOffice3.MessageBoxWB3.Show(resources.GetString("Global.title"),resources.GetString("CWebBuilder.msg5") +" "+ farchivo.FullName +" "+ resources.GetString("CWebBuilder.msg6") +"");
														//if(MessageBox.Show(resources.GetString("CWebBuilder.msg5") +" "+ farchivo.FullName +" "+ resources.GetString("CWebBuilder.msg6") +"",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error)==DialogResult.No)
														if(valueres==DialogResultEx.CANCEL)
														{
															return CExcel.user;
														}
													}
												}
											}
										}
									}
									catch(Exception ue)
									{
										Debug.WriteLine(ue.Message); 
									}
								}
							}
							catch{}
						}	
					}				
				}
				catch(Exception e)
				{
					//MessageBox.Show(e.StackTrace);
					Debug.WriteLine(e.StackTrace);
				}				
				/*FormSelect frm2=new FormSelect();
				frm2.ShowDialog();
				if(frm2.DialogResult==DialogResult.Cancel)
				{
					return CPowerPoint.user;
				}*/
				try
				{
					FileInfo f=new FileInfo((String)strpathHtml);
					if(f.Exists)
					{
						f.Delete();
					}
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);					
					return CExcel.user;
				}	
				try
				{
                    FileInfo fileExcelX = new FileInfo(doc.FullName);
                    if (fileExcelX.Extension.Equals(".xlsx",StringComparison.CurrentCultureIgnoreCase))
                    {
                        string pathExcel = fileExcelX.FullName.Substring(0, fileExcelX.FullName.Length - 1);
                        doc.SaveAs(pathExcel, Excel.XlFileFormat.xlExcel7, missing, missing, missing, missing, Excel.XlSaveAsAccessMode.xlNoChange, missing, missing, missing, missing, missing);
                        doc.Close(objtrue, missing, missing);
                        string pathDocX = fileExcelX.FullName;
                        doc = (Excel.Workbook)CExcel.app.Workbooks.Open((string)pathDocX, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing);
                    }

                    doc.SaveAs(strpathHtml, Excel.XlFileFormat.xlHtml, missing, missing, missing, missing, Excel.XlSaveAsAccessMode.xlNoChange, missing, missing, missing, missing, missing);
					doc.Close(objtrue,missing,missing);
					object docfile=fname.FullName;

                    doc = (Excel.Workbook)CExcel.app.Workbooks.Open((string)docfile, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing);

                    doc.Save();

					FileInfo fhtmltemp= new FileInfo((String) strpathHtml);

					FileStream finhtml=fhtmltemp.OpenRead();
					byte[] bnew= new byte[fhtmltemp.Length];
					finhtml.Read(bnew,0,bnew.Length);
					finhtml.Close();
					String htmlnew=System.Text.Encoding.Default.GetString(bnew,0,bnew.Length); 
  				
					if(isFrame(htmlnew))
					{
						htmlnew=CreateHtml(imagenes,fhtmltemp,htmlnew,parametros);
					}
				
					char[] chars=htmlnew.ToCharArray(); 
					int index=0;
					foreach(char cChar in chars)
					{
						int ichar=(int)cChar;
						if(ichar==8220 || ichar==8221)
						{
							//Debug.WriteLine(cChar); 
							chars[index]='\"';
						
						}
						index++;
					}
					htmlnew=new String(chars);

					finhtml=fhtmltemp.Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);
					byte[] bnew2= System.Text.Encoding.Default.GetBytes(htmlnew);
					finhtml.Write(bnew2,0,bnew2.Length);
					finhtml.Close();		
							
					finhtml=fhtmltemp.OpenRead();
					byte[] b= new byte[fhtmltemp.Length];
					finhtml.Read(b,0,b.Length);
					finhtml.Close();

					String html=System.Text.Encoding.Default.GetString(b,0,b.Length);   
					CHtmlParser.CHTMLDcoument dochtml=new CHTMLDcoument();
					dochtml.LoadHml(html);
				
					
					CExcel.app=doc.Application;  
					CExcel.user=usertemp;
					// agrega el parametro					
					FileParameter phtml= new FileParameter("content",(String)strpathHtml);				
					WBOffice3.Attribute atthtml= new WBOffice3.Attribute("filename",name+".html"); 
					phtml.Attributes.Add(atthtml);  
					parametros.Add(phtml);
					FileInfo fhtml=new FileInfo((String)strpathHtml);
					if(fhtml.Exists)
					{
						try
						{
							fhtml.Delete(); 
						}
						catch{}
					}

					// busca el archivo de lista de archivos
					String pathfiles=name+doc.WebOptions.FolderSuffix;  				
					pathfiles=fname.Directory.FullName+"\\"+ pathfiles+"\\filelist.xml"; 
					FileInfo fxml=new FileInfo(pathfiles); 
					if(fxml.Exists && fxml.Length>0)
					{
						FileStream finxml=fxml.OpenRead(); 
						byte[] bxmlfilelist=new byte[fxml.Length];
						finxml.Read(bxmlfilelist,0,bxmlfilelist.Length);
						finxml.Close();

						String xmllistfiles=System.Text.Encoding.ASCII.GetString(bxmlfilelist,0,bxmlfilelist.Length);   
						System.Xml.XmlDocument xmlfilelist=new XmlDocument();
						if(!xmllistfiles.Equals(""))
						{
							xmlfilelist.LoadXml( xmllistfiles);
							System.Xml.XmlNodeList tags=xmlfilelist.GetElementsByTagName("o:File"); 
							foreach(System.Xml.XmlNode node in tags)
							{
								foreach(System.Xml.XmlAttribute  att in node.Attributes )
								{
									if(att.Name.ToLower().Equals("href"))
									{
										String nameparameter=att.Value; 
										String pathfileparameter=fxml.Directory.FullName+"\\"+att.Value;  
										FileInfo fimagen=new FileInfo(pathfileparameter);
										if(fimagen.Exists )
										{
											imagenes.Add(fimagen);										
										}
									}								
								}
							}
						}					
					}
                    string pathDocx = fileExcelX.FullName;
                    if (fileExcelX.Extension.Equals(".xlsx",StringComparison.CurrentCultureIgnoreCase))
                    {
                        pathDocx = pathDocx.Substring(0, pathDocx.Length - 1);
                    }
					// fin de busqueda de archivos
                    FileInfo fExcel = new FileInfo(pathDocx);
					if(fExcel.Exists )
					{
						imagenes.Add(fExcel);
					}
			
					bool actualiza=false;
					String idcontent=null;
                    Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
					foreach(Office.DocumentProperty prop in props)
					{
						if(prop.Name.Equals("content"))
						{
							idcontent=(String)prop.Value;
							actualiza=true;
						}
					}
					if(idcontent==null)
					{
						actualiza=false;
					}
					else
					{
						if(idcontent.Trim().Equals(""))
						{
							foreach(Office.DocumentProperty prop in props)
							{
								if(prop.Name.Equals("content"))
								{
									prop.Delete();
                                    if (!doc.Saved)
                                    {
                                        doc.Save();
                                    }
								}
							}
							actualiza=false;					
						}
					}

					if(actualiza)
					{
						String topicmap="";
						String topicid="";
						foreach(Office.DocumentProperty prop in props)
						{
							if(prop.Name.Equals("topicmap"))
							{
								topicmap=(String)prop.Value;
								actualiza=true;
							}
							if(prop.Name.Equals("topicid"))
							{
								topicid=(String)prop.Value;
								actualiza=true;
							}
						}

						Servicios s= new Servicios(CExcel.user);
						if(!s.existsCont(idcontent,topicmap,topicid))
						{
							MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
							if(MessageBox.Show(resources.GetString("CWebBuilder.askquitaasocia"),resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.OK)
							{
								this.deleteAsociation();
							}						
							return CExcel.user;
						}
						s= new Servicios(CExcel.user);
						System.Xml.XmlDocument docxmlinfo=s.getContentAtt(topicmap,topicid,idcontent);
						String status="0";
						status=docxmlinfo.GetElementsByTagName("status")[0].InnerText;
						Servicios srevisor=new Servicios(CExcel.user);
						String occID=idcontent;
						if(docxmlinfo.GetElementsByTagName("occurrence").Count>0)
						{
							occID=docxmlinfo.GetElementsByTagName("occurrence")[0].InnerText;
						}
						if(!(docxmlinfo.GetElementsByTagName("activityName").Count==1 && docxmlinfo.GetElementsByTagName("activityName")[0].InnerText=="Terminar flujo"))
						{
							if(status=="1" || status=="3")
							{
								bool isReviewver=srevisor.isReviewer(topicmap,topicid,occID);
								if(isReviewver)
								{
									Servicios canEdit=new Servicios(CExcel.user);
									if(!canEdit.canEdit(topicmap,topicid,occID))
									{
										MessageBox.Show(resources.GetString("CWebBuilder.canEdit"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
										return CExcel.user;
									}
								}
								else
								{
									MessageBox.Show(resources.GetString("CWebBuilder.msg8"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
									return CExcel.user;
								}
							}
						}

						System.Xml.XmlNodeList errors=docxmlinfo.GetElementsByTagName("err"); 
						if(errors.Count>0)
						{
                            Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
							foreach(Office.DocumentProperty prop in props2)
							{
								if(prop.Name.Equals("content"))
								{
									prop.Delete();		
									continue;
								}
								if(prop.Name.Equals("topicid"))
								{
									prop.Delete();
									continue;
								}
								if(prop.Name.Equals("topicmap"))
								{
									prop.Delete();			
									continue;
								}
							}
                            if (!doc.Saved)
                            {
                                doc.Save();
                            }
							actualiza=false;
							if(MessageBox.Show(resources.GetString("CWebBuilder.msg7"),resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question )==System.Windows.Forms.DialogResult.No)						
							{
								return CExcel.user;
							}
						}
					}
					if(actualiza)
					{				
										
						String topicid="";
						String topicmap="";
						String idcont=idcontent;
                        Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
						foreach(Office.DocumentProperty prop in props2)
						{
						
							if(prop.Name.Equals("topicid"))
							{
								WBOffice3.Parameter ptopicid=new WBOffice3.Parameter("topicid",(String)prop.Value);
								topicid=(String)prop.Value;
								parametros.Add(ptopicid);
							}
							if(prop.Name.Equals("topicmap"))
							{
								WBOffice3.Parameter ptopicmap=new WBOffice3.Parameter("topicmap",(String)prop.Value);
								topicmap=(String)prop.Value;
								parametros.Add(ptopicmap);
							}					

						}
						Servicios servicio= new Servicios(CExcel.user);	
						if(!servicio.existsCont(idcontent,topicmap,topicid))
						{
							// debe borrar la liga al contenido
							//Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomOffice.DocumentProperties;							
							foreach(Office.DocumentProperty prop in props2)
							{
								if(prop.Name.Equals("content"))
								{
									prop.Delete();		
									continue;
								}
								if(prop.Name.Equals("topicid"))
								{
									prop.Delete();
									continue;
								}
								if(prop.Name.Equals("topicmap"))
								{
									prop.Delete();			
									continue;
								}
							}
                            if (!doc.Saved)
                            {
                                doc.Save();
                            }
							return CExcel.user;
						}
						if(!user.GetPermiso(topicmap,CExcel.TYPE))
						{						
							//MessageBox.Show(resources.GetString("FrmMoverContenido.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
							return CExcel.user;
						}
					

					

						WBOffice3.Parameter pidContent=new WBOffice3.Parameter("id",idcontent);
						parametros.Add(pidContent);
						servicio= new Servicios(CExcel.user);
						parametros.Add(new WBOffice3.Parameter("type",CExcel.TYPE));
						XmlDocument resp=servicio.updateCont(parametros,topicmap,topicid);
						String version=null;
					
						if(resp.GetElementsByTagName("id").Count>0)
						{
							String id=resp.GetElementsByTagName("id")[0].InnerText;
							if(resp.GetElementsByTagName("lastversion").Count>0)
							{
								version=resp.GetElementsByTagName("lastversion")[0].InnerText;
								WBOffice3.Parameter p=new WBOffice3.Parameter("id",id); 				
								CExcel.resultados.Add(p);
								p=new WBOffice3.Parameter("version",version); 				
								CExcel.resultados.Add(p);
							}
							else
							{
								version=resp.GetElementsByTagName("actualversion")[0].InnerText;
								WBOffice3.Parameter p=new WBOffice3.Parameter("id",id); 				
								CExcel.resultados.Add(p);
								p=new WBOffice3.Parameter("version",version); 				
								CExcel.resultados.Add(p);
							}
						}
			
						foreach(WBOffice3.Parameter p in CExcel.resultados)
						{
							if(p.Name.Equals("version"))
							{
								version=p.Value;
							}
						}
						if(version!=null)
						{
							

							foreach(FileInfo fileimagen in imagenes)
							{
								String resType=CExcel.TYPE;
								CContentUpload cfile=new CContentUpload(fileimagen,topicmap,idcontent,version,user,resType);
								FrmFileUpload fup=new FrmFileUpload(cfile);
								fup.Send();
								FileParameter pfile=new FileParameter("attach",fileimagen.FullName);
								WBOffice3.Attribute att= new WBOffice3.Attribute("filename",fileimagen.Name);
								pfile.Attributes.Add(att); 
								parametros.Add(pfile);  

							}
						}
						FrmResumenContenido frmnew=new FrmResumenContenido(parametros,resultados,user);
						frmnew.ShowDialog(); 
						foreach(Office.DocumentProperty prop in props2)
						{
						
							if(prop.Name.Equals("topicid"))
							{
								topicid=(String)prop.Value;
								
							}
							if(prop.Name.Equals("topicmap"))
							{							
								topicmap=(String)prop.Value;
								
							}	
							if(prop.Name.Equals("content"))
							{
								idcont=(String)prop.Value;
							}

						}
						if(topicid!=null && topicmap!=null && idcont!=null)
						{
							Servicios sflow=new Servicios(CExcel.user);
							if(sflow.needAutorization(topicmap,topicid,idcont))
							{
								MessageBox.Show(resources.GetString("msgneed"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);
							}
						}

					}
					else
					{
						FrmNewContent frm=new FrmNewContent(parametros,imagenes,CExcel.user);
						frm.ShowDialog();
						String topicid=null;
						String topicmap=null;
						String idcont=null;
                        Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
						foreach(Office.DocumentProperty prop in props2)
						{
						
							if(prop.Name.Equals("topicid"))
							{
								
								topicid=(String)prop.Value;
								
							}
							if(prop.Name.Equals("topicmap"))
							{
								
								topicmap=(String)prop.Value;
								
							}	
							if(prop.Name.Equals("content"))
							{
								idcont=(String)prop.Value;
							}

						}
						if(topicid!=null && topicmap!=null && idcont!=null)
						{
							Servicios sflow=new Servicios(CExcel.user);
							if(sflow.needAutorization(topicmap,topicid,idcont))
							{
								MessageBox.Show(resources.GetString("msgneed"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);
							}
						}
					}
					String dirarchivos=fxml.Directory.FullName+"\\"; 
					if(fxml.Exists)
					{
						try
						{
							fxml.Delete();						
						}
						catch{}
					}
					System.IO.DirectoryInfo dir=new DirectoryInfo( dirarchivos);
					try
					{
						if(dir.Exists)
						{
							try
							{
								dir.Delete(); 
							}
							catch{}
						}
					}
					catch(Exception dire)
					{
						Console.WriteLine(dire.Message); 
					}
				}
				catch(Exception e)
				{
					MessageBox.Show(e.Message+"\r\n"+e.StackTrace,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				}
			}
			
			return CExcel.user;
		}
		/// <summary>
		/// Borra asociación de contenido con sección y sitio
		/// </summary>
		public void deleteAsociation()
		{
			try
			{
				bool delete=false;
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
                    if (!doc.Saved)
                    {
                        doc.Save();
                    }				
				}
				
			}
			catch(Exception e)
			{
				Debug.WriteLine(e.Message);
			}
			MessageBox.Show(resources.GetString("CWebBuilder.deleteasociation"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
		}
		private bool isFrame(String html)
		{
			if(html.ToLower().IndexOf("frameset")>0)
			{
				return true;
			}
			return false;
		}
		private String CreateHtml(ArrayList images,FileInfo f,string html,ParameterCollection parametros)
		{
			string htmloriginal=html;
			string htmlnuevo="";
			int pos=htmloriginal.ToLower().LastIndexOf("<frameset");
			int pos2=htmloriginal.ToLower().LastIndexOf("</frameset>");
			int l=pos2-pos+11;
			htmlnuevo=html.Substring(pos,l);			
			//htmloriginal=htmloriginal.Replace(htmlnuevo,"<table width=\"100%\" height=\"100%\"><tr><td><iframe src=\""+ f.Name.Replace(f.Extension,"") +"_wb.html\" width=\"100%\" height=\"100%\"></iframe></td></tr></table>");			
			htmloriginal=htmloriginal.Replace(htmlnuevo,"</script><iframe src=\""+ f.Name.Replace(f.Extension,"") +"_wb.html\" width=\"100%\" height=\"500\"></iframe>");			
			
			String function="function fnBuildFrameset()";

			pos=htmloriginal.IndexOf(function);
			if(pos>0)
			{
				pos2=htmloriginal.IndexOf("function fnBuildTabStrip()",pos);			
				htmloriginal=htmloriginal.Remove(pos,pos2-pos);
			}
			function="fnBuildFrameset();";
			pos=htmloriginal.IndexOf(function);
			while(pos>0)
			{
				htmloriginal=htmloriginal.Remove(pos,function.Length);
				pos=htmloriginal.IndexOf(function);
			}
			function="if (window.g_iIEVer>=4)\r\n";
			pos=htmloriginal.IndexOf(function);
			while(pos>0)
			{
				htmloriginal=htmloriginal.Remove(pos,function.Length);
				pos=htmloriginal.IndexOf(function);
			}


			f.Delete();
			FileStream fout=f.Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);
			byte[] bcont=System.Text.Encoding.Default.GetBytes(htmloriginal);
			fout.Write(bcont,0,bcont.Length);
			fout.Close();

			FileInfo fhtmlnew= new FileInfo(f.DirectoryName+"\\"+f.Name.Replace(f.Extension,"")+"_wb.html");
			fhtmlnew.Delete();

			FileStream fnuevo=fhtmlnew.Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);
			byte[] bnew=System.Text.Encoding.Default.GetBytes(htmlnuevo);
			fnuevo.Write(bnew,0,bnew.Length);
			fnuevo.Close();

			FileParameter pfile=new FileParameter("attach",fhtmlnew.FullName);
			WBOffice3.Attribute att= new WBOffice3.Attribute("filename",fhtmlnew.Name);
			pfile.Attributes.Add(att); 
			parametros.Add(pfile);
			images.Add(fhtmlnew);										
			return htmloriginal;
		}
		private bool ValidaNombre(FileInfo archivo)
		{

			String ext=archivo.Extension;
			int pos=archivo.Name.LastIndexOf(ext);
			String nombre=archivo.Name.Substring(0,pos);  
			if(nombre.Length>40)
			{
				MessageBox.Show(resources.GetString("CWebBuilder.mayor40"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return false;
			}
			char[] letras=nombre.ToCharArray(); 
			for(int i=0;i<letras.Length;i++)
			{
				char letra=letras[i];
				if(Char.IsPunctuation(letra))
				{
					if(letra!='_')
					{
						MessageBox.Show(resources.GetString("CWebBuilder.msg9") +" "+ letra +"",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						return false;
					}
				}
				else if(Char.IsWhiteSpace(letra)) 
				{
					MessageBox.Show(resources.GetString("CWebBuilder.msg10"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return false;
				}
				else if (!Char.IsLetterOrDigit(letra))
				{
					if(letra!='_')
					{
						MessageBox.Show(resources.GetString("CWebBuilder.msg11") +" "+ letra + "",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						return false;
					}
					
					
				}	
				else if(letra>123)
				{
					if(letra!='_')
					{
						MessageBox.Show(resources.GetString("CWebBuilder.msg11")+" "+ letra + "",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						return false;
					}
				
				}
			}

			return true;
		}
		/// <summary>
		/// Muestra panatalla para abrir sesión
		/// </summary>
		/// <param name="app"></param>
		/// <returns></returns>
		public CUserAdmin Login(Excel._Application  app)
		{

			CExcel.app=app; 
			
			CUserAdmin user= new CUserAdmin("","",-1);
			FrmSplash frm=new FrmSplash(user);
			frm.ShowDialog();
			CExcel.user=frm.user;
			return frm.user;
		}
		
		/// <summary>
		/// Muestra la bitacora de cambios
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Bitacora(Excel._Application app,CUserAdmin user)
		{
			resultados=new ParameterCollection(); 				
			parametros=new ParameterCollection(); 				
			CExcel.app=app;
			CExcel.user=user;
            CExcel.doc = app.ActiveWorkbook;
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			
			if(!isValidSession())
			{
				return user;
			}
            Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
			String topicmap="";
			String topicid="";
			String idcont="";
			foreach(Office.DocumentProperty prop in props)
			{
				if(prop.Name.Equals("content"))
				{
					idcont=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicid"))
				{
					topicid=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicmap"))
				{
					topicmap=(String)prop.Value;					
				}
			}
			if(idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}
			FrmBitacora frm=new FrmBitacora(CExcel.user,idcont,topicmap,topicid);
			frm.ShowDialog(); 
			return CExcel.user;

		}
		/// <summary>
		/// Abre un archivo alamacenado en el sitio en formato de excel
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Open(Excel._Application app,CUserAdmin user)
		{
			resultados=new ParameterCollection(); 				
			parametros=new ParameterCollection(); 				
			CExcel.app=app;
			CExcel.user=user;
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			
			
			FrmOpenContent frm=new FrmOpenContent(CExcel.user);
			frm.ShowDialog();
			
			return CExcel.user;
		}
		/// <summary>
		/// Borra un contenido almacenado en el sitio
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Delete(Excel._Application app,CUserAdmin user)
		{
			CExcel.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CExcel.resultados =new ParameterCollection();
            CExcel.doc = (Excel.Workbook)app.ActiveWorkbook;
			CExcel.user=user;
			CExcel.app=doc.Application; 

			if(CExcel.user==null)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
            Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
			String topicmap="";
			String topicid="";
			String idcont="";
			foreach(Office.DocumentProperty prop in props)
			{
				if(prop.Name.Equals("content"))
				{
					idcont=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicid"))
				{
					topicid=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicmap"))
				{
					topicmap=(String)prop.Value;					
				}
			}
			if(idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}
			Servicios servicio= new Servicios(CExcel.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("content"))
					{
						prop.Delete();		
						continue;
					}
					if(prop.Name.Equals("topicid"))
					{
						prop.Delete();
						continue;
					}
					if(prop.Name.Equals("topicmap"))
					{
						prop.Delete();			
						continue;
					}
				}
                if (!doc.Saved)
                {
                    doc.Save();
                }
				return CExcel.user;
			}
			if(MessageBox.Show(resources.GetString("CWebBuilder.msg12"),resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question )==System.Windows.Forms.DialogResult.No)
			{				
				return CExcel.user;
			}			
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}			
			Servicios s= new Servicios(CExcel.user);
			//Debe verificar permisos
			if(user.GetPermiso(topicmap,CExcel.TYPE))
			{
				s.deleteContent(topicmap,topicid,idcont);
				foreach(WBOffice3.IParameter p in CExcel.resultados)
				{
					if(p.Name.Equals("error"))
					{
						MessageBox.Show(p.Value,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						return CExcel.user;
					}
				}

                Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("content"))
					{
						prop.Delete();		
						continue;
					}
					if(prop.Name.Equals("topicid"))
					{
						prop.Delete();
						continue;
					}
					if(prop.Name.Equals("topicmap"))
					{
						prop.Delete();			
						continue;
					}
				}
                if (!doc.Saved)
                {
                    doc.Save();
                }
				MessageBox.Show(resources.GetString("CWebBuilder.msg13"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information );  
			}			
			return CExcel.user;

		}
		/// <summary>
		/// Muestra la ventana de propiedades del contenido
		/// </summary>
		/// <param name="app">Aplicación Excel</param>
		/// <param name="user">Uusuario</param>
		/// <returns></returns>
		public CUserAdmin Properties(Excel._Application  app,CUserAdmin user)
		{
			CExcel.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
            CExcel.doc = app.ActiveWorkbook;
			CExcel.user=user;
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}

            Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
			String topicmap="";
			String topicid="";
			String idcont="";
			foreach(Office.DocumentProperty prop in props)
			{
				if(prop.Name.Equals("content"))
				{
					idcont=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicid"))
				{
					topicid=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicmap"))
				{
					topicmap=(String)prop.Value;					
				}
			}
			if(idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}			
			Servicios servicio= new Servicios(CExcel.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("content"))
					{
						prop.Delete();		
						continue;
					}
					if(prop.Name.Equals("topicid"))
					{
						prop.Delete();
						continue;
					}
					if(prop.Name.Equals("topicmap"))
					{
						prop.Delete();			
						continue;
					}
				}
                if (!doc.Saved)
                {
                    doc.Save();
                }
				return CExcel.user;
			}
			FrmProp frm= new FrmProp(topicmap,topicid,idcont,CExcel.user,CExcel.TYPE);			
			frm.ShowDialog(); 
			this.Save(frm.TopicMap,frm.Topic,frm.Content);
			return CExcel.user;

		}
		private static void ConfMenus(Excel._Application app) // unica sección de configuración de menus en base
		{
			CExcel.app=app;
			
			/*CommandBar comfile=CExcel.app.CommandBars["file"];
			CommandBar comtools=CExcel.app.CommandBars["tools"];

			Excel.Excel.Workbook docactive=null;

			if(app.Excel.Workbooks.Count>0)
			{
				docactive=app.ActiveExcel.Workbook;
			}*/
 
			
		}
		/// <summary>
		/// configura menus
		/// </summary>
		/// <param name="app"></param>
		/// <returns></returns>
		public CUserAdmin AutoExec(Excel._Application app)
		{
			this.ConfMenusLogout(app);		
			CConfig c= new CConfig();
			if(c.Startup.Equals("0"))
			{
				return null;
			}
			return this.Login(app); 			

		}
		/// <summary>
		/// Verifica contenido
		/// </summary>
		public void Verificacontenido()
		{
			if(CExcel.user==null)
			{
				return;
			}
			if(CExcel.user.Uri==null)
			{
				return;
			}
			if(CExcel.doc!=null)
			{
				String idcontent=null;
                Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props)
				{
					if(prop.Name.Equals("content"))
					{
						idcontent=(String)prop.Value;						
					}
				}
				if(idcontent!=null)
				{
					String topicmap="",topicid="";
					foreach(Office.DocumentProperty prop in props)
					{
						if(prop.Name.Equals("topicmap"))
						{
							topicmap=(String)prop.Value;						
						}
						if(prop.Name.Equals("topicid"))
						{
							topicid=(String)prop.Value;						
						}
					}
					Servicios s= new Servicios(CExcel.user);
					System.Xml.XmlDocument docxmlinfo=s.getContentAtt(topicmap,topicid,idcontent);
					if(!s.IsError)  
					{
						System.Xml.XmlNodeList errors=docxmlinfo.GetElementsByTagName("err"); 
						if(errors.Count>0)
						{
                            Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
							foreach(Office.DocumentProperty prop in props2)
							{
								if(prop.Name.Equals("content"))
								{
									prop.Delete();		
									continue;
								}
								if(prop.Name.Equals("topicid"))
								{
									prop.Delete();
									continue;
								}
								if(prop.Name.Equals("topicmap"))
								{
									prop.Delete();			
									continue;
								}
							}
                            if (!doc.Saved)
                            {
                                doc.Save();
                            }
							MessageBox.Show(resources.GetString("CWebBuilder.msg7"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information );
						}
					}
						
				}
			}
		}
		/// <summary>
		/// En caso de activación de ventada depreciado
		/// </summary>
		/// <param name="doc"></param>
		/// <param name="window"></param>
		/*public void ActivateExcel.Window2(Excel.Workbook doc,Excel.Window window)
		{
			//CExcel.user=null;
			CExcel.doc=(Excel.Workbook)doc;
			ConfMenus(doc.Application);
			Verificacontenido();
		}*/
		/// <summary>
		/// En caso de activación de documento
		/// </summary>
		/// <param name="doc"></param>
		/// <param name="window"></param>
		/// <param name="user"></param>
		/*public void ActivateExcel.Window(Excel.Workbook doc,Excel.Window window,CUserAdmin user)
		{
			CExcel.doc=doc;
			CExcel.user=user;
			Verificacontenido();
			if(user==null)
			{
				ConfMenus(doc.Application);
				return;
			}
			if(user.ID>=0) // el usuario no esta registrado
			{
				ConfMenus(doc.Application);
				return;
			}
			
			
		}*/
		/// <summary>
		/// Muestra pantalla de cerrar sesión
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Logout(Excel._Application app,CUserAdmin user)
		{
			CExcel.app =app;
			if(MessageBox.Show(resources.GetString("CWebBuilder.msg15"),resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.No)    
			{
				return user;
			}			
			/*try
			{
				CExcel.Connect.mLogout.Enabled=false;
				CExcel.Connect.mLogin.Enabled=true;					
			}
			catch{}*/
			if(user!=null)
			{
				user.ID=-1;
			}
			return user;
		}
		/// <summary>
		/// Muestra pantalla de documentos por autorizar
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin MuestraFlujo(Excel._Application app,CUserAdmin user)
		{
			CExcel.user=user;
			CExcel.app=app;
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			//FrmDocFlow frm=new FrmDocFlow(CExcel.user); 						
			FrmDocumentosXAutorizar frm=new FrmDocumentosXAutorizar(CExcel.user,app);
			frm.ShowDialog(); 
			return CExcel.user;
		}		
		/// <summary>
		/// Asocia reglas a un contenido
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin CreateRule(Excel._Application app,CUserAdmin user)
		{
			CExcel.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CExcel.parametros= new ParameterCollection();  
			CExcel.resultados= new ParameterCollection();
            CExcel.doc = app.ActiveWorkbook;
			CExcel.app=doc.Application;
			CExcel.user=user; 
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
            Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
			String topicmap="";
			String topicid="";
			String idcont="";
			foreach(Office.DocumentProperty prop in props)
			{
				if(prop.Name.Equals("content"))
				{
					idcont=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicid"))
				{
					topicid=(String)prop.Value;					
				}
				if(prop.Name.Equals("topicmap"))
				{
					topicmap=(String)prop.Value;					
				}
			}
			if(idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CExcel.user;
			}			
			Servicios servicio= new Servicios(CExcel.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("content"))
					{
						prop.Delete();		
						continue;
					}
					if(prop.Name.Equals("topicid"))
					{
						prop.Delete();
						continue;
					}
					if(prop.Name.Equals("topicmap"))
					{
						prop.Delete();			
						continue;
					}
				}
                if (!doc.Saved)
                {
                    doc.Save();
                }
				return CExcel.user;
			}
			Servicios s=new Servicios(CExcel.user);
			XmlDocument doc_user=s.haveAccess2System("WBAd_sysi_ContentsRules");
			if(doc_user.GetElementsByTagName("haveAccess2System").Count>0 && doc_user.GetElementsByTagName("haveAccess2System")[0].InnerText=="true")
			{
				FrmRuleTopic frm=new FrmRuleTopic(topicmap,topicid,idcont,CExcel.user); 
				frm.ShowDialog(); 
			}
			else
			{
				MessageBox.Show(resources.GetString("FrmEditRule.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
			}			
			return CExcel.user;
		}
		/// <summary>
		/// Muestra ayuda
		/// </summary>
		public void ShowManual()
		{
			FrmPreview frm=new FrmPreview("http://espacio.webbuilder.com.mx/wb/WB3H/WB3H_webbuilder_office"); 
			frm.Text=resources.GetString("CWebBuilder.t3"); 			
			frm.ShowDialog(); 
		}
		/// <summary>
		/// Muestra pagina de infotec
		/// </summary>
		public void ShowPagina()
		{
			FrmPreview frm=new FrmPreview("http://www.webbuilder.com.mx/"); 
			frm.Text=resources.GetString("CWebBuilder.t4"); 			
			frm.ShowDialog(); 
		}
		/// <summary>
		/// Crea sección en el sitio
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin CreateTopic(Excel._Application app,CUserAdmin user)
		{
			CExcel.parametros= new ParameterCollection();  
			CExcel.resultados= new ParameterCollection();  
			CExcel.app=app;
			CExcel.user=user; 
			if(CExcel.user==null)
			{
				CExcel.user=this.Login(CExcel.app);
			}
			if(CExcel.user.ID<=0)
			{
				CExcel.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			Servicios s=new Servicios(CExcel.user);
			XmlDocument doc_user=s.haveAccess2Menu("WBAd_mnui_TopicCreate");
			if(doc_user.GetElementsByTagName("haveAccess2Menu").Count>0 && doc_user.GetElementsByTagName("haveAccess2Menu")[0].InnerText=="true")
			{
				FrmNewSection frm=new FrmNewSection(CExcel.user);
				frm.ShowDialog(); 
			}
			else
			{
				MessageBox.Show(resources.GetString("FrmNewTopic1.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
			}			
			return CExcel.user;
		}

		private bool isDocumentoNull()
		{
			try
			{
				if(app.ActiveWorkbook==null)
				{
					MessageBox.Show(resources.GetString("CWebBuilder.msg16"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return false;
				}
			}
			catch(Exception ue)
			{
				Console.WriteLine(ue.Message); 
				MessageBox.Show(resources.GetString("CWebBuilder.msg16"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return false;
			}
			return false;
		}
		private bool isValidSession()
		{
			if(CExcel.user==null)
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg17"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return false;
			}

			if(CExcel.user.ID<=0)
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg17"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return false;
			}		
			return true;
		}
		private void ConfMenusLogout(Excel._Application app) // unica sección de configuración de menus en base
		{
			CExcel.app=app;
			/*CommandBar comfile=CExcel.app.CommandBars["file"];
			CommandBar comtools=CExcel.app.CommandBars["tools"];*/
			
		}
		
	}
}
