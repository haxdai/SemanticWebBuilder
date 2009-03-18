/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Runtime.InteropServices;
using System.Windows.Forms;  
using System.Web;
using System.IO;
using System.Diagnostics;
using System.Xml;
using Office = Microsoft.Office.Core;
using CHtmlParser;
using System.Globalization;
using System.Collections;
using Word = Microsoft.Office.Interop.Word;
using WBOffice3;
using System.Text;
namespace WBWord
{
	/// <summary>
	/// Summary description for CWebBuilder.
	/// </summary>
	/// 

	public class CWebBuilder 
	{
		/// <summary>
		/// Tipo de contenido
		/// </summary>
		public static readonly String TYPE="word";
		//int loginId,logoutid;
		System.Resources.ResourceManager resword = new System.Resources.ResourceManager("WBWord.wordres",System.Reflection.Assembly.GetExecutingAssembly());		
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));		
		/// <summary>
		/// Documento Word
		/// </summary>
		public static Word.DocumentClass doc=null;
		/// <summary>
		/// Aplicación Word
		/// </summary>
		public static Word.Application  app=null;
		/// <summary>
		/// Usuario
		/// </summary>
		public static CUserAdmin user;
		/// <summary>
		/// Parametros para envío
		/// </summary>
		public static ParameterCollection parametros=new ParameterCollection(); 
		/// <summary>
		/// Resultados de envio
		/// </summary>
		
		public static ParameterCollection resultados=new ParameterCollection(); 				
		/// <summary>
		/// Imagenes asociadas
		/// </summary>
		public static ArrayList imagenes=new ArrayList();		
		
		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="oToolsBar">Menu de herramientas</param>
		/// <param name="connect">Objeto de conexión</param>
		public CWebBuilder()
		{
			
			
			
#if(ING)
				System.Threading.Thread.CurrentThread.CurrentUICulture =new  System.Globalization.CultureInfo("en",false) ;														
#endif	


		}
		/// <summary>
		/// Guarda las propiedades del documento
		/// </summary>
		/// <param name="topicmap"></param>
		/// <param name="topicid"></param>
		/// <param name="idcont"></param>
		public void Save(String topicmap,String topicid,String idcont)
		{
			bool save=false;
			//Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
            Office.DocumentProperties props = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
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
                if (!CWebBuilder.doc.Saved)
                {
                    CWebBuilder.doc.Save();
                }
			}
		}	
		/// <summary>
		/// Muestra resumen del documento
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin ResumenArchivos(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.app=app;
			CWebBuilder.user=user;
			 
			if(isDocumentoNull())
			{
				return user;
			}
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument; 			
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			FileInfo f= new FileInfo(CWebBuilder.doc.FullName);
			if(!f.Exists)
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CWebBuilder.user;
			}
			try
			{
				long l=f.Length;
			}
			catch(Exception fe)
			{
				Console.WriteLine(fe.Message);  
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CWebBuilder.user;
			}			
			FrmDetalleDoc frm=new FrmDetalleDoc(); 			
			frm.ShowDialog(); 
			return CWebBuilder.user;

		}

		/// <summary>
		/// Cambia el password del usuario
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin ChangePassword(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.app=app;
			CWebBuilder.user=user;
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			FrmPassword frm=new FrmPassword(CWebBuilder.user); 
			frm.ShowDialog();
			return CWebBuilder.user;
		}
		/// <summary>
		/// Muestra pantalla de acerca de
		/// </summary>
		public void About()
		{
			FrmAbout frm =new FrmAbout();
			frm.ShowDialog(); 
		}
		/// <summary>
		/// Muestra presentación preeliminar
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Preview(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument;  
			CWebBuilder.user=user; 
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			//Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;				
            Office.DocumentProperties props = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
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
				return CWebBuilder.user;
			}
			Servicios servicio= new Servicios(CWebBuilder.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
				//Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
                Office.DocumentProperties props2 = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("confpag"))
					{
						prop.Delete();		
						continue;
					}
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
				return CWebBuilder.user;
			}
			servicio= new Servicios(CWebBuilder.user);
			XmlDocument resp=servicio.getContentAtt(topicmap,topicid,idcont);
			try
			{
				if(resp.GetElementsByTagName("lastversion").Count>0)
				{
					FrmPreview frm =new FrmPreview(topicmap,topicid,idcont,resp.GetElementsByTagName("lastversion")[0].InnerText,CWebBuilder.user);
					frm.Text=resources.GetString("CWebBuilder.t1");
					frm.ShowDialog(); 
				}
				else
				{
					FrmPreview frm =new FrmPreview(topicmap,topicid,idcont,CWebBuilder.user);
					frm.Text=resources.GetString("CWebBuilder.t1");
					frm.ShowDialog(); 
				}			
				
			}
			catch(Exception ue)
			{
				Debug.WriteLine(ue.Message);
			}
			return CWebBuilder.user;
		}
		/// <summary>
		/// Muestra página de INFOTEC
		/// </summary>
		public void PagWeb()
		{
			FrmPreview frm =new FrmPreview("http://www.infotec.com.mx");
			frm.Text=resources.GetString("CWebBuilder.t2");						
			frm.ShowDialog(); 
			
		}
		/// <summary>
		/// Convierte una cadena en formato hexadecimal
		/// </summary>
		/// <param name="dato"></param>
		/// <returns></returns>
		public String StringToHex(String dato)
		{			
			byte[] b=System.Text.Encoding.Default.GetBytes(dato);
			String hits = "0123456789ABCDEF";
			System.Text.StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < b.Length; i++)
			{
				if(b[i]==46)
				{
					sb.Append('.');
				}
				else
				{
					int j = ((int) b[i]) & 0xFF;

					char first = hits[j / 16];
					char second = hits[j % 16];
					sb.Append('%');
					sb.Append(first);
					sb.Append(second);
				}
			}

			return sb.ToString();

		}
		/// <summary>
		/// Crea o actualiza un contenido
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin New(Word.Application app,CUserAdmin user)
		{		
			ParameterCollection parametros=new ParameterCollection();
			ArrayList imagenes=new ArrayList();
			imagenes=new ArrayList();
			CWebBuilder.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			resultados=new ParameterCollection(); 				
			parametros=new ParameterCollection(); 				
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument;
			CWebBuilder.app=doc.Application;  
			CWebBuilder.user=user; 
			
			
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
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
                    if (!doc.Saved)
                    {
                        doc.Save();
                    }
				}
				catch(Exception)
				{
					return user;
				}
			}
            FileInfo filedocx = new FileInfo(CWebBuilder.doc.FullName);
			fname=new FileInfo(doc.FullName);
			ext=fname.Extension;
			if(ext.ToLower().Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg4")+" .doc",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				try
				{
                    if (!doc.Saved)
                    {
                        doc.Save();
                    }
				}
				catch(Exception)
				{
					return user;
				}
			}
			if(ext.ToLower().Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				return CWebBuilder.user;
			}			
			if(!doc.Saved && ext.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg4")+" .doc",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				try
				{
                    if (!doc.Saved)
                    {
                        doc.Save();
                    }
				}
				catch
				{
					return user;
				}
			}
			fname=new FileInfo(doc.FullName);
			ext=fname.Extension;
			if(!doc.Saved && ext.Equals(""))
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);  
				return CWebBuilder.user;
			}
			// esta salvado
			
			if(!(ext.ToLower().Equals(".doc") || ext.ToLower().Equals(".docx")))
			{
				
				MessageBox.Show(resources.GetString("CWebBuilder.msg4")+" .doc",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CWebBuilder.user;
			}			
			int SaveFormat=doc.SaveFormat;
			//MessageBox.Show("SaveFormat: "+SaveFormat);
			/*int SaveFormat=doc.SaveFormat;
			 
			if(SaveFormat!=0) 
			{
				MessageBox.Show(resources.GetString("CWebBuilder.msg4")+" .doc",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CWebBuilder.user;			
			}*/
			bool showRevisions=doc.ShowRevisions;
			if(showRevisions)
			{
				doc.ShowRevisions=false;
			}
			/*if(doc.ShowRevisions)
			{
				if(MessageBox.Show(resword.GetString("msgdescambios"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Question)==DialogResult.Cancel)
				{
					return CWebBuilder.user;
				}
				doc.ShowRevisions=false;
			}*/
			//valida nombre
			if(ValidaNombre(fname))
			{
				CUserAdmin usertemp=CWebBuilder.user;
				int pos=fname.Name.IndexOf(fname.Extension);
				String name=fname.Name.Substring(0,pos);
                if (!doc.Saved)
                {
                    doc.Save();
                }
				object missing = Type.Missing;
				object strpathHtml=fname.Directory.FullName+"\\"+name+".html";								
				object objformat= Word.WdSaveFormat.wdFormatHTML; 
				object objtrue=true;
				object objfalse=false;			
				doc.WebOptions.AllowPNG=false;				
				doc.WebOptions.Encoding=Office.MsoEncoding.msoEncodingISO88591Latin1;
				
				
				
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
					return CWebBuilder.user;
				}	
				try
				{
					foreach(Word.InlineShape shape in doc.InlineShapes)
					{
						try
						{
							if(shape.LinkFormat!=null && shape.LinkFormat.SourceFullName!=null)
							{										
								System.Uri path=new Uri(shape.LinkFormat.SourceFullName);
								if(path.IsFile)
								{
									FileInfo  farchivo=new FileInfo(path.LocalPath);
									if(farchivo.Exists)
									{
										imagenes.Add(farchivo);	
									}
								}
							}
						}
						catch{}
					}	
				}
				catch{}
				foreach(Word.Hyperlink link in  doc.Hyperlinks )
				{				
					try
					{
						String archivo=link.Address;
						if(archivo!=null)
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
										String filename=StringToHex(farchivo.Name);										
										//String filename=farchivo.Name;										
										try
										{
											link.Address=filename;
										}
										catch{}
									}
								}
							}
						}
					}
					catch{}
				}
				//doc.SaveAs(ref strpathHtml,ref objformat ,ref missing,ref missing,ref objfalse,ref missing,ref missing,ref missing,ref missing,ref missing,ref missing);
                // verifica si es docx
                
                if (filedocx.Extension.Equals(".docx",StringComparison.CurrentCultureIgnoreCase) || SaveFormat == 12)
                {
                    object filedoc = filedocx.FullName.Substring(0, filedocx.FullName.Length - 1);
                    object objformatDoc = Word.WdSaveFormat.wdFormatDocument97;
                    CWebBuilder.doc.SaveAs(ref filedoc, ref objformatDoc, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);
                    CWebBuilder.doc.Close(ref objtrue, ref missing, ref missing);
                    object filedocxtoOpen = filedocx.FullName;
                    CWebBuilder.doc = (Word.DocumentClass)CWebBuilder.app.Documents.Open(ref filedocxtoOpen, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);                    
                }

                CWebBuilder.doc.SaveAs(ref strpathHtml, ref objformat, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);                
				CWebBuilder.doc.Close(ref objtrue,ref missing,ref missing);                
				object docfile=fname.FullName;                
                doc = (Word.DocumentClass)CWebBuilder.app.Documents.Open(ref docfile, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);
				if(showRevisions)
				{
					doc.ShowRevisions=true;
				}	
				FileInfo fhtmltemp= new FileInfo((String) strpathHtml);
				FileStream finhtml=fhtmltemp.OpenRead();
				byte[] bnew= new byte[fhtmltemp.Length];
				finhtml.Read(bnew,0,bnew.Length);
				finhtml.Close();
				String htmlnew=System.Text.Encoding.Default.GetString(bnew,0,bnew.Length);   				
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
								
				CWebBuilder.app=doc.Application;  
				CWebBuilder.user=usertemp;
				// agrega el parametro					
				FileParameter phtml= new FileParameter("content",(String)strpathHtml);	
				String nameHTML=name+".html";				
				WBOffice3.Attribute atthtml= new WBOffice3.Attribute("filename",nameHTML); 
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
				WBOffice3.DialogResultEx valueres=WBOffice3.DialogResultEx.YES;
				foreach(Word.Hyperlink link in  doc.Hyperlinks )
				{
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
											imagenes.Add(farchivo);		
											if(!this.ValidaNombre(farchivo))
											{
												FrmDetalleDoc frmresumen=new FrmDetalleDoc();
												frmresumen.ShowDialog(); 
												return CWebBuilder.user;
											}											
										}
										else
										{
											if(valueres!=DialogResultEx.YESALL)
											{
												valueres=WBOffice3.MessageBoxWB3.Show(resources.GetString("Global.title"),resources.GetString("CWebBuilder.msg5") +" "+ farchivo.FullName +" "+ resources.GetString("CWebBuilder.msg6") +"");
												//if(MessageBox.Show(resources.GetString("CWebBuilder.msg5") +" "+ farchivo.FullName +" "+ resources.GetString("CWebBuilder.msg6") +"",resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Warning)==DialogResult.No)
												if(valueres==DialogResultEx.CANCEL)
												{
													return CWebBuilder.user;
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
				// busca el archivo de lista de archivos
				String pathfiles=name+doc.WebOptions.FolderSuffix;  				
				pathfiles=fname.Directory.FullName+"\\"+ pathfiles+"\\filelist.xml"; 
				FileInfo fxml=new FileInfo(pathfiles); 
				if(fxml.Exists  && fxml.Length>0)
				{
					FileParameter pfilefilelist= new FileParameter("attach",pathfiles); 
					WBOffice3.Attribute pattfilelist=new WBOffice3.Attribute("filename","filelist.xml"); 
					pfilefilelist.Attributes.Add(pattfilelist); 
					parametros.Add( pfilefilelist);

					FileStream finxml=fxml.OpenRead(); 
					byte[] bxmlfilelist=new byte[fxml.Length];
					finxml.Read(bxmlfilelist,0,bxmlfilelist.Length);
					finxml.Close();
					String xmllistfiles=System.Text.Encoding.ASCII.GetString(bxmlfilelist,0,bxmlfilelist.Length);   
					System.Xml.XmlDocument xmlfilelist=new XmlDocument();
					if(!xmllistfiles.Equals(""))
					{
						try
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
											if(fimagen.Extension.ToLower().StartsWith(".ht"))
											{
												FileParameter pfile= new FileParameter("attach",pathfileparameter); 
												WBOffice3.Attribute patt=new WBOffice3.Attribute("filename",nameparameter); 
												pfile.Attributes.Add(patt); 
												parametros.Add( pfile);
												try
												{
													if(fimagen.Exists)
													{
														fimagen.Delete(); 
													}
												}
												catch{}
											}								
											else
											{
												imagenes.Add(fimagen);
											}
										}
									}								
								}
							}
						}
						catch(Exception e)
						{
							Debug.WriteLine(e.Message);
						}
					}					
				}			
				// fin de busqueda de archivos
                String filetoAppend = doc.FullName;
                if (filedocx.Extension.Equals(".docx",StringComparison.CurrentCultureIgnoreCase) || SaveFormat==12)
                {
                    filetoAppend = filetoAppend.Substring(0, filetoAppend.Length - 1);
                }
                FileInfo fWord = new FileInfo(filetoAppend);
				if(fWord.Exists )
				{
					imagenes.Add(fWord);
				}
				bool actualiza=false;
				String idcontent=null;
				//Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
                Office.DocumentProperties props = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;			
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
								try
								{
									prop.Delete(); 
									if(!CWebBuilder.doc.Saved)
                                    {
									    CWebBuilder.doc.Save(); 
                                    }
								}
								catch{}
							}
						}
						actualiza=false;					
					}
				}
				if(actualiza)
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
					Servicios s= new Servicios(CWebBuilder.user);
					if(!s.existsCont(idcontent,topicmap,topicid))
					{
						MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						if(MessageBox.Show(resources.GetString("CWebBuilder.askquitaasocia"),resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.OK)
						{
							this.deleteAsociation();
						}						
						return CWebBuilder.user;
					}
					s= new Servicios(CWebBuilder.user);

					System.Xml.XmlDocument docxmlinfo=s.getContentAtt(topicmap,topicid,idcontent);
					if(s.IsError)
					{
						MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						if(MessageBox.Show(resources.GetString("CWebBuilder.askquitaasocia"),resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.OK)
						{
							this.deleteAsociation();
						}						
						return CWebBuilder.user;
					}
					if(docxmlinfo.GetElementsByTagName("status").Count==0)
					{
						MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						if(MessageBox.Show(resources.GetString("CWebBuilder.askquitaasocia"),resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.OK)
						{
							this.deleteAsociation();
						}						
						return CWebBuilder.user;
					}
					String status=docxmlinfo.GetElementsByTagName("status")[0].InnerText;
					Servicios srevisor=new Servicios(CWebBuilder.user);
					String occID=idcontent;
					if(docxmlinfo.GetElementsByTagName("occurrence").Count>0)
					{
						occID=docxmlinfo.GetElementsByTagName("occurrence")[0].InnerText;
					}							
					
					if(status=="1" || status=="3")
					{
						bool isReviewver=srevisor.isReviewer(topicmap,topicid,occID);
						if(isReviewver)
						{
							Servicios canEdit=new Servicios(CWebBuilder.user);
							if(!canEdit.canEdit(topicmap,topicid,occID))
							{
								MessageBox.Show(resources.GetString("CWebBuilder.canEdit"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
								return CWebBuilder.user;
							}
						}
						else
						{
							MessageBox.Show(resources.GetString("CWebBuilder.msg8"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
							return CWebBuilder.user;
						}
					}
					
					
					
					


					System.Xml.XmlNodeList errors=docxmlinfo.GetElementsByTagName("err"); 
					if(errors.Count>0)
					{
//						Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
                        Office.DocumentProperties props2 = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
						foreach(Office.DocumentProperty prop in props2)
						{
							if(prop.Name.Equals("confpag"))
							{
								prop.Delete();		
								continue;
							}
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
							return CWebBuilder.user;
						}
					}
				}
				if(actualiza)
				{					
					
					String topicid="";
					String topicmap="";
					String idcont=idcontent;	
					String confpag=null;
//					Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
                    Office.DocumentProperties props2 = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
					foreach(Office.DocumentProperty prop in props2)
					{
						if(prop.Name.Equals("confpag"))
						{
							confpag=(String)prop.Value;
						}
						if(prop.Name.Equals("topicid"))
						{
							Parameter ptopicid=new Parameter("topicid",(String)prop.Value);
							topicid=(String)prop.Value;
							parametros.Add(ptopicid);
						}
						if(prop.Name.Equals("topicmap"))
						{
							Parameter ptopicmap=new Parameter("topicmap",(String)prop.Value);
							topicmap=(String)prop.Value;
							parametros.Add(ptopicmap);
						}					

					}
					Servicios servicio= new Servicios(CWebBuilder.user);	
					if(!servicio.existsCont(idcontent,topicmap,topicid))
					{
						// debe borrar la liga al contenido
						//Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
						foreach(Office.DocumentProperty prop in props2)
						{
							if(prop.Name.Equals("confpag"))
							{
								prop.Delete();		
								continue;
							}
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
						
						return CWebBuilder.user;
					}
					if(CWebBuilder.user==null || !CWebBuilder.user.GetPermiso(topicmap,CWebBuilder.TYPE))
					{						
						//MessageBox.Show(resources.GetString("FrmMoverContenido.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
						return CWebBuilder.user;
					}
				

					Parameter pidContent=new Parameter("id",idcontent);
					parametros.Add(pidContent);
					parametros.Add(new Parameter("type",CWebBuilder.TYPE));
					if(confpag!=null && confpag!="")
					{
						char[] sep={'|'};
						string[] values=confpag.Split(sep);
						if(values.Length==4)
						{
							parametros.Add(new Parameter("createPages","true"));						
							parametros.Add(new Parameter("pages",values[0]));						
							parametros.Add(new Parameter("stxtsig",values[1]));						
							parametros.Add(new Parameter("stxtant",values[2]));						
							parametros.Add(new Parameter("position",values[3]));													
						}
					}
					

					servicio= new Servicios(CWebBuilder.user);
					XmlDocument resp=servicio.updateCont(parametros,topicmap,topicid);
					String version=null;
					if(resp.GetElementsByTagName("id").Count>0)
					{
						String id=resp.GetElementsByTagName("id")[0].InnerText;
						if(resp.GetElementsByTagName("lastversion").Count>0)
						{
							version=resp.GetElementsByTagName("lastversion")[0].InnerText;
							Parameter p=new Parameter("id",id); 				
							CWebBuilder.resultados.Add(p);
							p=new Parameter("version",version); 				
							CWebBuilder.resultados.Add(p);
						}
						else
						{
							version=resp.GetElementsByTagName("actualversion")[0].InnerText;
							Parameter p=new Parameter("id",id); 				
							CWebBuilder.resultados.Add(p);
							p=new Parameter("version",version); 				
							CWebBuilder.resultados.Add(p);
						}
					}
					foreach(Parameter p in CWebBuilder.resultados)
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
							String resType="LocalContent";
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
						Servicios sflow=new Servicios(CWebBuilder.user);
						if(sflow.needAutorization(topicmap,topicid,idcont))
						{
							MessageBox.Show(resources.GetString("msgneed"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);
						}
					}

				}
				else
				{
					FrmNewContent frm=new FrmNewContent(parametros,imagenes,CWebBuilder.user);
					frm.ShowDialog();
					String topicid=null;
					String topicmap=null;
					String idcont=null;					
					//Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
                    Office.DocumentProperties props2 = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
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
						Servicios sflow=new Servicios(CWebBuilder.user);
						if(sflow.needAutorization(topicmap,topicid,idcont))
						{
							MessageBox.Show(resources.GetString("msgneed"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);
						}
					}
																	 

				}
				String dirarchivos=fxml.Directory.FullName+"\\"; 
				try
				{
					if(fxml.Exists)
					{
						fxml.Delete();						
					}
				}
				catch{}
				System.IO.DirectoryInfo dir=new DirectoryInfo( dirarchivos);
				try
				{
					try
					{
						if(dir.Exists)
						{
							dir.Delete(); 
						}
					}
					catch{}
				}
				catch(Exception dire)
				{
					Console.WriteLine(dire.Message); 
				}
				
			}
			else
			{
				if(showRevisions)
				{
					doc.ShowRevisions=true;
				}
			}
            
			return CWebBuilder.user;
		}
		/// <summary>
		/// Borra asociación documento, sección, sitio
		/// </summary>
		public void deleteAsociation()
		{
			try
			{
				bool delete=false;				
//				Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
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
		/// Muestra la bitacora de cambios del contenido
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Bitacora(Word.Application app,CUserAdmin user)
		{
			resultados=new ParameterCollection(); 				
			parametros=new ParameterCollection(); 				
			CWebBuilder.app=app;
			CWebBuilder.user=user;
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument;  
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			
			if(!isValidSession())
			{
				return user;
			}
//			Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;				
            Office.DocumentProperties props = (Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;
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
				MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title") ,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CWebBuilder.user;
			}	
			FrmBitacora frm=new FrmBitacora(CWebBuilder.user,idcont,topicmap,topicid);
			frm.ShowDialog(); 
			return CWebBuilder.user;

		}
		/// <summary>
		/// Abre un documento almacenado en el sitio
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Open(Word.Application app,CUserAdmin user)
		{
			resultados=new ParameterCollection(); 				
			parametros=new ParameterCollection(); 				
			CWebBuilder.app=app;
			CWebBuilder.user=user;
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);					
			}
			if(CWebBuilder.user==null)
			{				
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			else if(CWebBuilder.user.ID<=0)
			{
				Trace.WriteLine("user id: "+CWebBuilder.user.ID);
				Trace.WriteLine("");
				Trace.Flush();
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			
			
			FrmOpenContent frm=new FrmOpenContent(CWebBuilder.user);
			frm.ShowDialog(); 
			double version=double.Parse(CWebBuilder.app.Version);
			if(version>=11)							
			{
			
				if(FrmOpenContent.docpath!=null)
				{
					foreach(Word.Document docopen in CWebBuilder.app.Documents)
					{				
						
						if(FrmOpenContent.docpath.ToLower().IndexOf(docopen.Name.ToLower())!=-1)
						{									
							docopen.Activate();
							docopen.ActiveWindow.Activate();
							docopen.ActiveWindow.View.Type=Word.WdViewType.wdPrintView;  
									
						}
					}
				}
			}
			return CWebBuilder.user;
		}
		/// <summary>
		/// Borra un contenido del sitio
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Delete(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CWebBuilder.resultados =new ParameterCollection(); 
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument; 
			CWebBuilder.user=user;
			CWebBuilder.app=doc.Application; 

			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;				
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
				return CWebBuilder.user;
			}
			Servicios servicio= new Servicios(CWebBuilder.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
				Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("confpag"))
					{
						prop.Delete();								
						continue;
					}
					if(prop.Name.Equals("confpag"))
					{
						prop.Delete();		
						continue;
					}
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
				return CWebBuilder.user;
			}						
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			if(MessageBox.Show(resources.GetString("CWebBuilder.msg12"),resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question )==System.Windows.Forms.DialogResult.No)
			{				
				return CWebBuilder.user;
			}
			Servicios s= new Servicios(CWebBuilder.user);
			//Debe verificar permisos
			if(CWebBuilder.user.GetPermiso(topicmap,CWebBuilder.TYPE))
			{
				s.deleteContent(topicmap,topicid,idcont);
				foreach(IParameter p in CWebBuilder.resultados)
				{
					if(p.Name.Equals("error"))
					{
						MessageBox.Show(p.Value,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
						return CWebBuilder.user;
					}
				}

				Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("confpag"))
					{
						prop.Delete();								
						continue;
					}
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
			return CWebBuilder.user;

		}
		/// <summary>
		/// Muestra las opciones para paginación
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin menuPag(Word.Application  app,CUserAdmin user)
		{
			CWebBuilder.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument;  
			CWebBuilder.user=user;
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			
			Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;				
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
				MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title") ,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return CWebBuilder.user;
			}			
			Servicios servicio= new Servicios(CWebBuilder.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
				Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("confpag"))
					{
						prop.Delete();		
						continue;
					}
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
				return CWebBuilder.user;
			}
			string confpag=null;
			props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
			foreach(Office.DocumentProperty prop in props)
			{
				if(prop.Name.Equals("confpag"))
				{
					confpag=(string)prop.Value;
					break;
				}
			}
			FrmPagesConf frm= new FrmPagesConf();			
			if(confpag!=null && confpag!="")
			{
				char[] sep={'|'};
				string[] values=confpag.Split(sep);
				if(values.Length==4)
				{
					frm.checkBoxConfPaginacion.Checked=true;
					frm.numericUpNumero.Value=Int32.Parse(values[0]);
					frm.txtTextoSiguiente.Text=values[1];
					frm.textBoxAnterior.Text=values[2];
					if(values[3]=="1")
					{
						frm.radioButtonAbajo.Checked=true;
					}
					else if(values[3]=="2")
					{
						frm.radioButtonArriba.Checked=true;
					}
					else 
					{
						frm.radioButtonAmbos.Checked=true;
					}							
				}
			}
			if(frm.ShowDialog()==DialogResult.OK)
			{
				String conf="";
				if(frm.checkBoxConfPaginacion.Checked)
				{
					conf=frm.numericUpNumero.Value.ToString();
					conf+="|"+frm.txtTextoSiguiente.Text;						
					conf+="|"+frm.textBoxAnterior.Text;						
					if(frm.radioButtonAbajo.Checked)
						conf+="|1";						
					if(frm.radioButtonArriba.Checked)
						conf+="|2";						
					if(frm.radioButtonAmbos.Checked)
						conf+="|3";	
				}
				bool existeConf=false;
				props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
				foreach(Office.DocumentProperty prop in props)
				{
					if(prop.Name.Equals("confpag"))
					{
						prop.Value=conf;
						existeConf=true;
						break;
					}
				}
				if(!existeConf)
				{
					string str = "";
					System.Object nullObjStr = str;
					props.Add("confpag",false,Office.MsoDocProperties.msoPropertyTypeString,conf,nullObjStr);							  							
				}
				Servicios s=new Servicios(CWebBuilder.user);
				
				ParameterCollection parameters=new ParameterCollection();

				if(frm.checkBoxConfPaginacion.Checked)
					parameters.Add(new Parameter("createPages","true"));						
				else
					parameters.Add(new Parameter("createPages","false"));						


				parameters.Add(new Parameter("topicmap",topicmap));
				parameters.Add(new Parameter("topicid",topicid));
				parameters.Add(new Parameter("contentid",idcont));

				

				parameters.Add(new Parameter("pages",frm.numericUpNumero.Value.ToString()));						
				parameters.Add(new Parameter("stxtsig",frm.txtTextoSiguiente.Text));						
				parameters.Add(new Parameter("stxtant",frm.textBoxAnterior.Text));						
				if(frm.radioButtonAbajo.Checked)
					parameters.Add(new Parameter("position","1"));						
				if(frm.radioButtonArriba.Checked)
					parameters.Add(new Parameter("position","2"));						
				if(frm.radioButtonAmbos.Checked)
					parameters.Add(new Parameter("position","3"));												

				XmlDocument resp=s.addPaginations2Content(parameters);
				if(resp.GetElementsByTagName("pag").Count>0)
				{
					MessageBox.Show(resword.GetString("msgPagDone"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Information);
				}

                if (!doc.Saved)
                {
                    doc.Save();
                }
				
				
			}
			return CWebBuilder.user;
		}
		
		/// <summary>
		/// Muestra las propiedades del documento
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Properties(Word.Application  app,CUserAdmin user)
		{
			
			CWebBuilder.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument;  
			CWebBuilder.user=user;
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			try
			{
				Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;				
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
					MessageBox.Show(resources.GetString("CWebBuilder.msg2"),resources.GetString("Global.title") ,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return CWebBuilder.user;
				}			
				Servicios servicio= new Servicios(CWebBuilder.user);	
				if(!servicio.existsCont(idcont,topicmap,topicid))
				{
					// debe borrar la liga al contenido
					props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
					foreach(Office.DocumentProperty prop in props)
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
					return CWebBuilder.user;
				}
				FrmProp frm= new FrmProp(topicmap,topicid,idcont,CWebBuilder.user,CWebBuilder.TYPE);			
				frm.ShowDialog(); 			
				this.Save(frm.TopicMap,frm.Topic,frm.Content);		
			}
			catch(Exception e)
			{				
				Debug.WriteLine(e.StackTrace);
				Debug.WriteLine("e.TargetSite: "+e.TargetSite);	
				Debug.WriteLine("e.Source: "+e.Source);	
				if(e.InnerException!=null)
				{
					Debug.WriteLine("e.InnerException.StackTrace: "+e.StackTrace);				
				}
			}
			return CWebBuilder.user;

		}
		/// <summary>
		/// Función de autoejecución (depreciada)
		/// </summary>
		/// <param name="app"></param>
		/// <returns></returns>
		public CUserAdmin AutoExec(Word.Application app)
		{

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
			if(CWebBuilder.user==null)
			{
				return;
			}
			if(CWebBuilder.user.Uri==null)
			{
				return;
			}
			if(CWebBuilder.doc!=null)
			{
				String idcontent=null;
				Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;				
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
					Servicios s= new Servicios(CWebBuilder.user);
					System.Xml.XmlDocument docxmlinfo=s.getContentAtt(topicmap,topicid,idcontent);
					if(!s.IsError)  
					{
						System.Xml.XmlNodeList errors=docxmlinfo.GetElementsByTagName("err"); 
						if(errors.Count>0)
						{
							Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
							foreach(Office.DocumentProperty prop in props2)
							{
								if(prop.Name.Equals("confpag"))
								{
									prop.Delete();		
									continue;
								}
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
		/// Acción tomada al activar documento
		/// </summary>
		/// <param name="doc"></param>
		/// <param name="window"></param>
		public void ActivateWindow2(Word.Document doc,Word.Window window)
		{
			//CWebBuilder.user=null;
			CWebBuilder.doc=(Word.DocumentClass)doc;			
			Verificacontenido();
		}
		/// <summary>
		/// Acción tomada al activar documento
		/// </summary>
		/// <param name="doc"></param>
		/// <param name="window"></param>
		/// <param name="user"></param>
		public void ActivateWindow(Word.Document doc,Word.Window window,CUserAdmin user)
		{
			CWebBuilder.doc=(Word.DocumentClass)doc;
			CWebBuilder.user=user;
			Verificacontenido();
			if(user==null)
			{				
				return;
			}
			if(user.ID>=0) // el usuario no esta registrado
			{
				
				return;
			}
			
			
		}
		/// <summary>
		/// Muestra la pantalla para abrir sessión
		/// </summary>
		/// <param name="app"></param>
		/// <returns></returns>
		public CUserAdmin Login(Word.Application  app)
		{
			CWebBuilder.app=app; 			
			CUserAdmin user= new CUserAdmin("","",-1);
			FrmSplash frm=new FrmSplash(user);
			frm.ShowDialog();
			if(frm.DialogResult==DialogResult.OK)
			{
                //try
                //{					
                //    Office.CommandBarButton mlogout=(Office.CommandBarButton)oToolsBar.Controls[resword.GetString("menuclose")];												
                //    mlogout.Enabled=true;
                //    Office.CommandBarButton mlogin=(Office.CommandBarButton)oToolsBar.Controls[resword.GetString("menuinit")];																
                //    mlogin.Enabled=false;
					
                //}
                //catch{}
			}
			CWebBuilder.user=frm.user;			
			return frm.user;
		}
		
		/// <summary>
		/// Muestra la pantalla de cerrar sesión
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin Logout(Word.Application app,CUserAdmin user)
		{			
			
			CWebBuilder.app =app;
			if(MessageBox.Show(resources.GetString("CWebBuilder.msg15"),resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.No)    
			{
				return user;
			}	
			user.ID=-1;			
            //try
            //{
            //    Office.CommandBarButton mlogout=(Office.CommandBarButton)oToolsBar.Controls[resword.GetString("menuclose")];												
            //    mlogout.Enabled=false;
            //    Office.CommandBarButton mlogin=(Office.CommandBarButton)oToolsBar.Controls[resword.GetString("menuinit")];															
            //    mlogin.Enabled=true;	
            //}
            //catch{}
			
			return user;
		}
		/// <summary>
		/// Muestra contenidos por autorizar
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin MuestraFlujo(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.user=user;
			CWebBuilder.app=app;
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(!isValidSession())
			{
				return user;
			}
			//FrmDocFlow frm=new FrmDocFlow(CWebBuilder.user); 						
			FrmDocumentosXAutorizar frm=new FrmDocumentosXAutorizar(CWebBuilder.user,CWebBuilder.app);
			frm.ShowDialog();
			return CWebBuilder.user;
		}		
		/// <summary>
		/// Agrega una liga a una sección dentro del contenido
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin AddLink(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CWebBuilder.parametros= new ParameterCollection();  
			CWebBuilder.resultados= new ParameterCollection();  
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument ;
			CWebBuilder.app=doc.Application;
			CWebBuilder.user=user; 
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			FormAddLink frm=new FormAddLink();
			frm.ShowDialog();
			return CWebBuilder.user;
		}
		/// <summary>
		/// Agrega una regla al contenido
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin CreateRule(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.app=app;
			if(isDocumentoNull())
			{
				return user;
			}
			CWebBuilder.parametros= new ParameterCollection();  
			CWebBuilder.resultados= new ParameterCollection();  
			CWebBuilder.doc=(Word.DocumentClass)app.ActiveDocument ;
			CWebBuilder.app=doc.Application;
			CWebBuilder.user=user; 
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			Office.DocumentProperties props=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;				
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
				return CWebBuilder.user;
			}			
			Servicios servicio= new Servicios(CWebBuilder.user);	
			if(!servicio.existsCont(idcont,topicmap,topicid))
			{
				// debe borrar la liga al contenido
				Office.DocumentProperties props2=(Office.DocumentProperties)CWebBuilder.doc.CustomDocumentProperties;							
				foreach(Office.DocumentProperty prop in props2)
				{
					if(prop.Name.Equals("confpag"))
					{
						prop.Delete();		
						continue;
					}
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
				return CWebBuilder.user;
			}
			Servicios s=new Servicios(CWebBuilder.user);
			XmlDocument doc_user=s.haveAccess2System("WBAd_sysi_ContentsRules");
			if(doc_user.GetElementsByTagName("haveAccess2System").Count>0 && doc_user.GetElementsByTagName("haveAccess2System")[0].InnerText=="true")
			{
				FrmRuleTopic frm=new FrmRuleTopic(topicmap,topicid,idcont,CWebBuilder.user); 
				frm.ShowDialog(); 
			}
			else
			{
				MessageBox.Show(resources.GetString("FrmEditRule.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
			}			
			return CWebBuilder.user;
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
		/// Muestra página de INFOTEC
		/// </summary>
		public void ShowPagina()
		{
			FrmPreview frm=new FrmPreview("http://www.webbuilder.com.mx/"); 
			frm.Text=resources.GetString("CWebBuilder.t4"); 			
			frm.ShowDialog(); 
		}
		/// <summary>
		/// Muestra asistente para creación de sección
		/// </summary>
		/// <param name="app"></param>
		/// <param name="user"></param>
		/// <returns></returns>
		public CUserAdmin CreateTopic(Word.Application app,CUserAdmin user)
		{
			CWebBuilder.parametros= new ParameterCollection();  
			CWebBuilder.resultados= new ParameterCollection();  
			CWebBuilder.app=app;
			CWebBuilder.user=user; 
			if(CWebBuilder.user==null)
			{
				CWebBuilder.user=this.Login(CWebBuilder.app);
			}
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				CWebBuilder.user=this.Login(doc.Application);
			}
			if(!isValidSession())
			{
				return user;
			}
			//FrmNewTopic1 frm=new FrmNewTopic1(); 
			Servicios s=new Servicios(CWebBuilder.user);
			XmlDocument doc_user=s.haveAccess2Menu("WBAd_mnui_TopicCreate");
			if(doc_user.GetElementsByTagName("haveAccess2Menu").Count>0 && doc_user.GetElementsByTagName("haveAccess2Menu")[0].InnerText=="true")
			{
				FrmNewSection frm=new FrmNewSection(CWebBuilder.user);
				frm.ShowDialog(); 
			}
			else
			{
				MessageBox.Show(resources.GetString("FrmNewTopic1.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
			}			 
			return CWebBuilder.user;
		}

		private bool isDocumentoNull()
		{
			try
			{
				if(app.ActiveDocument==null)
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
			if(CWebBuilder.user==null || CWebBuilder.user.ID<=0)
			{
				
				MessageBox.Show(resources.GetString("CWebBuilder.msg17"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return false;
			}			
			return true;
		}		
	}
}
