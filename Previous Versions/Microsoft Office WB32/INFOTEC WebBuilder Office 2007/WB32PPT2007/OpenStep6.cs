/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;
using System.IO;
using WBOffice3;
using PowerPoint = Microsoft.Office.Interop.PowerPoint;
using Office = Microsoft.Office.Core;
using System.Xml;
using System.Runtime.InteropServices;
using System.Diagnostics;
using System.Text;
namespace WBPowerPoint
{
	/// <summary>Control que muestra el avance de descarga de contenido</summary>
	public class OpenStep6 : TSWizards.BaseStep
	{
		

		/// <summary>
		/// Obtiene el tipo de drive
		/// </summary>
		/// <param name="driveLetter"></param>
		/// <returns></returns>
        public int getDriveType(string drive)
        {
            /*if((GetDriveType(drive) & 5)==5)return 5;//cd
            if((GetDriveType(drive) & 3)==3)return 3;//fixed
            if((GetDriveType(drive) & 2)==2)return 2;//removable
            if((GetDriveType(drive) & 4)==4)return 4;//remote disk
            if((GetDriveType(drive) & 6)==6)return 6;//ram disk
            return 0;*/
            if (GetDriveType(drive) == DriveType.CDRom)
            {
                return 5;
            }
            if (GetDriveType(drive) == DriveType.Fixed)
            {
                return 3;
            }
            if (GetDriveType(drive) == DriveType.Removable)
            {
                return 2;
            }
            if (GetDriveType(drive) == DriveType.Ram)
            {
                return 6;
            }
            if (GetDriveType(drive) == DriveType.Network)
            {
                return 4;
            }
            else
            {
                return 0;
            }
        }
        public System.IO.DriveType GetDriveType(string drive)
        {
            System.IO.DriveInfo[] drives = System.IO.DriveInfo.GetDrives();

            foreach (System.IO.DriveInfo odrive in drives)
            {
                if (odrive.Name == drive)
                {
                    return odrive.DriveType;
                }
            }
            return System.IO.DriveType.Unknown;

        }
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.ProgressBar progressBar1;
		/// <summary> 
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public OpenStep6()
		{
			// Llamada necesaria para el Diseñador de formularios Windows.Forms.
			InitializeComponent();

			// TODO: agregar cualquier inicialización después de llamar a InitializeComponent

		}

		/// <summary> 
		/// Limpiar los recursos que se estén utilizando.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Código generado por el Diseñador de componentes
		/// <summary> 
		/// Método necesario para admitir el Diseñador. No se puede modificar 
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(OpenStep6));
			this.progressBar1 = new System.Windows.Forms.ProgressBar();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// progressBar1
			// 
			this.progressBar1.AccessibleDescription = resources.GetString("progressBar1.AccessibleDescription");
			this.progressBar1.AccessibleName = resources.GetString("progressBar1.AccessibleName");
			this.progressBar1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("progressBar1.Anchor")));
			this.progressBar1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("progressBar1.BackgroundImage")));
			this.progressBar1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("progressBar1.Dock")));
			this.progressBar1.Enabled = ((bool)(resources.GetObject("progressBar1.Enabled")));
			this.progressBar1.Font = ((System.Drawing.Font)(resources.GetObject("progressBar1.Font")));
			this.progressBar1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("progressBar1.ImeMode")));
			this.progressBar1.Location = ((System.Drawing.Point)(resources.GetObject("progressBar1.Location")));
			this.progressBar1.Name = "progressBar1";
			this.progressBar1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("progressBar1.RightToLeft")));
			this.progressBar1.Size = ((System.Drawing.Size)(resources.GetObject("progressBar1.Size")));
			this.progressBar1.TabIndex = ((int)(resources.GetObject("progressBar1.TabIndex")));
			this.progressBar1.Text = resources.GetString("progressBar1.Text");
			this.progressBar1.Visible = ((bool)(resources.GetObject("progressBar1.Visible")));
			// 
			// OpenStep6
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.progressBar1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "OpenStep6";
			this.NextStep = "Step7";
			this.PreviousStep = "Step5";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.OpenStep6_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.progressBar1, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void OpenStep6_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.next.Enabled=false;
			this.Wizard.back.Visible=true;
			this.Wizard.cancel.Visible=true;
			string step="Step4";
			OpenStep2 step2 = Wizard.GetStep("Step2") as OpenStep2;
			OpenStep3 step3 = Wizard.GetStep("Step3") as OpenStep3;
			OpenStep4 step4 = Wizard.GetStep("Step4") as OpenStep4;
			TreeView treedir=step4.treedir;
			String prefix="_archivos";
			try
			{
				PowerPoint.Presentation book=null;
				if(CPowerPoint.app.Presentations.Count==0)
				{
					book=CPowerPoint.app.Presentations.Add(Office.MsoTriState.msoFalse);
					prefix=book.WebOptions.FolderSuffix;
					book.Close();
				}
				else
				{
					book=CPowerPoint.app.Presentations[1];
					prefix=book.WebOptions.FolderSuffix;
				}
			}
			catch{}
			try
			{		

				if(treedir.SelectedNode!=null && step2.treeView1.SelectedNode!=null && step2.treeView1.SelectedNode is WBNode)
				{
					WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
					char[] chars={'.'};
					String[] values=wbnode.ReloadPath.Split(chars);
					String idtopic=values[values.Length-1];
					String idtopicmap=values[values.Length-2];	

					this.Cursor=Cursors.WaitCursor; 
										
					String idcontent=step3.listView1.SelectedItems[0].SubItems[0].Text;
					String idversion=step3.listView1.SelectedItems[0].SubItems[2].Text;
					Parameter parameter = new Parameter("topicid",idtopic); 
					FrmOpenContent.parametros.Add(parameter); 
					Parameter parametermap = new Parameter("topicmap",idtopicmap); 
					FrmOpenContent.parametros.Add(parametermap); 

					Parameter pidcontent= new Parameter("contentid",idcontent);
					FrmOpenContent.parametros.Add(pidcontent); 
					FrmOpenContent.parametros.Add(new Parameter("version",idversion)); 
					bool cont=true;
					while(cont)
					{
						System.IO.DirectoryInfo dinfo=(DirectoryInfo)treedir.SelectedNode.Tag; 
						System.Windows.Forms.DialogResult resp=DirTargetTest(dinfo.FullName);
						if(resp==System.Windows.Forms.DialogResult.OK)
						{
							cont=false;
						}
						if(resp==System.Windows.Forms.DialogResult.Cancel)
						{
							cont=false;
							this.Cursor=Cursors.Default;
							this.Wizard.MoveTo(step);
							return;
						}					
					}					
					Servicios s= new Servicios(CPowerPoint.user);
					FrmOpenContent.parametros.Add(new Parameter("filenames","1"));
					XmlDocument doccont=s.openCont(idtopicmap,FrmOpenContent.parametros);
					// agrega del xml resultado a la lista de resultados.		
					if(doccont.GetElementsByTagName("content").Count>0)
					{
						System.Xml.XmlNode xmocont=doccont.GetElementsByTagName("content")[0];
						Parameter pcont= new Parameter("content",xmocont.InnerText);
						pcont.Attributes.Add(new WBOffice3.Attribute(xmocont.Attributes[0].Name,xmocont.Attributes[0].Value));
						FrmOpenContent.resultados.Add(pcont);
						System.Xml.XmlNodeList attachs=doccont.GetElementsByTagName("attachment");			
						foreach(System.Xml.XmlNode xmlattach in attachs)
						{
							Parameter pattach= new Parameter("attach",xmlattach.InnerText);
							pattach.Attributes.Add(new WBOffice3.Attribute(xmlattach.Attributes[0].Name,xmlattach.Attributes[0].Value ));
							FrmOpenContent.resultados.Add(pattach);

						}
					}

					
					foreach(IParameter presult in FrmOpenContent.resultados)
					{
						if(presult.Name.Equals("content"))
						{
							// guarda el contenido
							System.IO.DirectoryInfo dinfo=(DirectoryInfo)treedir.SelectedNode.Tag; 
							String path=dinfo.FullName; 
							String namecont=presult.Attributes[0].Value;
							String archiohtml=path+"\\"+namecont;						
							FileInfo fhtml=new FileInfo(archiohtml);


							//define el nombre del contenido en formato word
							String archivodoc=path+"\\"+namecont;
							FileInfo fdoc=new FileInfo(archivodoc);
							int pos=fdoc.FullName.LastIndexOf(fdoc.Extension);
							archivodoc=fdoc.FullName.Substring(0,pos);  
							archivodoc+=".ppt";

							object missing = Type.Missing;
							object objtrue=true;
							object objfalse=false;
							// verifica que no exista un archivo abierto con el mismo nombre
							bool overwrite=false;
							foreach(PowerPoint.Presentation docopen in CPowerPoint.app.Presentations)
							{
								if(docopen.FullName.ToLower().Equals(archivodoc.ToLower()))
								{
									this.Cursor=Cursors.Default;
									if(MessageBox.Show(this,resources.GetString("FrmOpen3.msg3") +" "+  docopen.FullName +", "+ resources.GetString("FrmOpen3.msg4") +"",this.Text,MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.Yes)
									{
										this.Cursor=Cursors.WaitCursor; 
										overwrite=true;									
										docopen.Close();                                        
										continue;
									}
									else
									{
										this.Cursor=Cursors.Default;
										MessageBox.Show(this,resources.GetString("FrmOpen3.msg5") +" "+docopen.FullName ,this.Text,MessageBoxButtons.OK ,MessageBoxIcon.Information);										
										this.Wizard.MoveTo(step);
										return;
									}								
								}							
							}
							//verifica la existencia fisica del archivo fisicamente
							fdoc=new FileInfo(archivodoc);
							if(fdoc.Exists)
							{
								if(!overwrite) // no esta definido la sobre escritura
								{
									this.Cursor=Cursors.Default;
									if(MessageBox.Show(this,resources.GetString("FrmOpen3.msg3") +" "+  fdoc.FullName +", "+ resources.GetString("FrmOpen3.msg4") +"",this.Text,MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.Yes)
									{
										this.Cursor=Cursors.WaitCursor; 
										overwrite=true;
										fdoc.Delete();
									}
									else
									{
										Cursor=Cursors.Default;
										this.Wizard.MoveTo(step);
										return;
									}
								}
								else
								{
									fdoc.Delete();
								}
							}

							// revisa que no exista un archivo html con el mismo nombre	
							
							if(fhtml.Exists)
							{
								fhtml.Delete();
							}
							//guarda las imagenes
							String snamedoc=fdoc.Name;
							int posext=snamedoc.IndexOf(fdoc.Extension);
							snamedoc=snamedoc.Substring(0,posext);
							snamedoc=snamedoc+prefix;
							String idcont=null;
							String version=null;
							foreach(IParameter param in FrmOpenContent.parametros )
							{
								if(param.Name.Equals("version"))
								{
									version=param.Value;
									
								}
								if(param.Name.Equals("contentid"))
								{
									idcont=param.Value;									
								}						
							}
							int iimagenes=0;
							foreach(IParameter presultiamges in FrmOpenContent.resultados)
							{
								if(presultiamges.Name.Equals("attach"))
								{	
									if(idcont!=null && version!=null)
									{
										iimagenes++;
									}
								}
							}
							this.progressBar1.Minimum=0;
							this.progressBar1.Maximum=iimagenes+1;
							this.progressBar1.Value++;
							foreach(IParameter presultiamges in FrmOpenContent.resultados)
							{
								if(presultiamges.Name.Equals("attach"))
								{	
									if(idcont!=null && version!=null)
									{
										String fileimagen=fdoc.Directory.FullName + "\\"+snamedoc+"\\"+presultiamges.Attributes[0].Value; 
										FileInfo fimagen=new FileInfo(fileimagen);
										if(!fimagen.Directory.Exists)
										{
											fimagen.Directory.Create(); 
										}
										String resType=CPowerPoint.TYPE;
										CDownLoadContent cdown=new CDownLoadContent(fimagen,idtopicmap,idcont,version,CPowerPoint.user,resType);
										FrmDownLoadFile frm=new FrmDownLoadFile(cdown);
										frm.GetFile();
										FileInfo f=new FileInfo(fileimagen);
										if(f.Name.ToLower().EndsWith(".html") || f.Name.ToLower().EndsWith(".htm"))
										{
											byte[] bcontimg=new byte[f.Length];
											FileStream sin=f.OpenRead();
											sin.Read(bcontimg,0,bcontimg.Length);
											sin.Close();
											String htmlimg=System.Text.Encoding.Default.GetString(bcontimg,0,bcontimg.Length);
											htmlimg=Parsea(htmlimg,fdoc.Directory.FullName+"\\"+snamedoc+"\\",false,fdoc);
											bcontimg=System.Text.Encoding.Default.GetBytes(htmlimg);
											sin=f.Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);
											sin.Write(bcontimg,0,bcontimg.Length);
											sin.Close();

										}
										this.progressBar1.Value++;
									}
								}
							}
							
							byte[] bcont=System.Convert.FromBase64String(presult.Value); 
							
							// parsea el archivo
							String html=System.Text.Encoding.Default.GetString(bcont,0,bcont.Length);    
							html=html.Replace("\r"," ");
							html=html.Replace("\n"," ");
							html=Parsea(html,fdoc.Directory.FullName+"\\"+snamedoc+"\\",true,fdoc);
							bcont=System.Text.Encoding.Default.GetBytes(html); 

							// Graba el archivo
							try
							{
								FileStream fout=fhtml.Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);
								fout.Write( bcont,0,bcont.Length);
								fout.Close();
							}
							catch(System.IO.IOException ioe)
							{
								System.Console.WriteLine(ioe.Message);
								this.Cursor=Cursors.Default;
								MessageBox.Show(this,ioe.Message,this.Text,MessageBoxButtons.RetryCancel,MessageBoxIcon.Error);
								this.Wizard.MoveTo(step);
								return;
							}


							
							// abre el documento en formato html para traducción
										
							object strpathHtml=archiohtml;								
							object strpathDoc=archivodoc;								
							
							
							FileInfo fppt=new FileInfo((string)strpathHtml);
							String name=fppt.Name;							
							name=name.Substring(0,name.IndexOf(fppt.Extension));
							String subdir=name+prefix;
							name+=".ppt";
							fppt=new FileInfo(fppt.DirectoryName+"\\"+subdir+"\\"+name);
							if(fppt.Exists)
							{
                                PowerPoint.Presentation dochtml = CPowerPoint.app.Presentations.Open((string)fppt.FullName, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse);
								foreach(PowerPoint.Slide slide in  dochtml.Slides )
								{
									foreach(PowerPoint.Hyperlink link in  slide.Hyperlinks )
									{			
										try
										{
											String archivo=link.Address;
											if(archivo!=null)
											{
												System.Uri basepath=new System.Uri(fppt.DirectoryName+"\\");
												System.Uri filepath=new System.Uri(basepath, archivo);

												
												
												if(filepath.IsFile && filepath.Scheme.ToLower().StartsWith("file")) 
												{										
													FileInfo farchivo= new FileInfo(filepath.LocalPath);						
													if(farchivo.Extension.IndexOf(".")!=-1)
													{
														farchivo= new FileInfo(fppt.DirectoryName+"\\"+farchivo.Name);						
														if(farchivo.Exists)
														{												
															link.Address=farchivo.FullName;
														}
													}
												}
											}
										}
										catch{}
									}
								}
								dochtml.SaveAs((string)strpathDoc,PowerPoint.PpSaveAsFileType.ppSaveAsDefault,Office.MsoTriState.msoTrue);
								dochtml.Close();
							}
							else
							{
                                PowerPoint.Presentation dochtml = CPowerPoint.app.Presentations.Open((string)strpathHtml, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse);
                                dochtml.SaveAs((string)strpathDoc, PowerPoint.PpSaveAsFileType.ppSaveAsDefault, Office.MsoTriState.msoTrue);
								dochtml.Close();
							}
                            PowerPoint.Presentation docopenwb = CPowerPoint.app.Presentations.Open((string)strpathDoc, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse, Office.MsoTriState.msoTrue);

							// guarda las propedades


                            Office.DocumentProperties props = (Office.DocumentProperties)docopenwb.CustomDocumentProperties;
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
							string str = "";
							System.Object nullObjStr = str;
							

							props.Add("content",false,Office.MsoDocProperties.msoPropertyTypeString,idcontent,nullObjStr);
                            props.Add("topicid", false, Office.MsoDocProperties.msoPropertyTypeString, idtopic, nullObjStr);
                            props.Add("topicmap", false, Office.MsoDocProperties.msoPropertyTypeString, idtopicmap, nullObjStr);
                            docopenwb.Saved = Office.MsoTriState.msoFalse; 
							docopenwb.Save();
							
							try
							{
								if(docopenwb.Windows.Count>0)
								{
									docopenwb.Windows[0].Activate();
									docopenwb.Windows[0].ViewType=PowerPoint.PpViewType.ppViewNormal;
								}
							}
							catch{}
					

							FrmOpenContent.parametros.Add(new Parameter("dir",docopenwb.Path));   
							FrmOpenContent.parametros.Add(new Parameter("filedoc",docopenwb.Name));   

							// borra archivos temporales
							try
							{
								fhtml.Delete();
							}
							catch(System.IO.IOException fdele)
							{
								System.Console.WriteLine(fdele.Message);  
							}
							// borra
							/*String dirborrar=fdoc.Directory.FullName + "\\"+snamedoc+"\\";
							System.IO.DirectoryInfo  fdirborrar= new DirectoryInfo( dirborrar);
							if(fdirborrar.Exists)
							{
								try
								{
									FileInfo[] fimagenesborrar=fdirborrar.GetFiles(); 
									foreach(FileInfo fimagenb in fimagenesborrar)
									{
										if(fimagenb.Exists)
										{
											fimagenb.Delete();
											continue;
										}
									}
								}
								catch(System.IO.IOException ioe2)
								{
									System.Console.WriteLine(ioe2.Message);  
								}
							}
							try
							{
								fdirborrar.Delete();
							}
							catch(System.IO.IOException ioe3)
							{
								System.Console.WriteLine(ioe3.Message);  
							}*/
						}
					}
					this.Cursor=Cursors.Default;
					
				}
				this.Cursor=Cursors.Default;
			}
			catch(Exception undefe)
			{
				this.Cursor=Cursors.Default;
				FrmOpenContent.resultados.Add(new Parameter("error",undefe.Message));   
				MessageBox.Show(this,resources.GetString("FrmOpen3.msg2") +" [ "+ undefe.Message +" ]",this.Text,MessageBoxButtons.OK ,MessageBoxIcon.Error );				
				this.Wizard.MoveTo(step);
				return;
			}
			this.Wizard.MoveNext();
		}
		private String Parsea(CHtmlParser.CTag tag,String attname,String html,String pathdoc,FileInfo fdoc)
		{
			foreach(CHtmlParser.CAttibute  att in tag.Attibutes)
			{
				if(att.Name.ToLower().Equals(attname))
				{
					if(!att.Value.StartsWith("#"))
					{
						try
						{
							System.Uri basepath= new System.Uri(pathdoc);
							System.Uri filepath= new System.Uri(basepath,att.Value);
							if(filepath.IsFile)
							{
								String pathincorrecta=att.Value;
								if(att.Value.IndexOf(":")!=-1)
								{
									int pos=att.Value.IndexOf(":");
									if(pos>1)
									{
										att.Value=att.Value.Substring(pos-1);
									}
									FileInfo ftemp=new FileInfo(att.Value);
									pathincorrecta=pathdoc+ftemp.Name;
								}
								else
								{
									pathincorrecta=pathdoc+att.Value;
								}
								FileInfo fmal= new FileInfo(pathincorrecta);
								String pathcorrecta=pathdoc+fmal.Name;
								String stag=tag.Tag;								
								String newtag="<"+tag.Name+" ";
								foreach(CHtmlParser.CAttibute  natt in tag.Attibutes )
								{
									if(natt.Name.ToLower().Equals(attname))
									{
										System.Uri uri=new System.Uri(pathcorrecta);																				
										pathcorrecta=uri.LocalPath;
										newtag+=" "+natt.Name+"=\""+ pathcorrecta +"\" ";
									}
									else
									{
										newtag+=" "+natt.Name+"=\""+ natt.Value  +"\" ";
									}
								}
								newtag+=">";
								html=html.Replace(stag,newtag); 
							}		
						}
						catch(Exception ue)
						{
							Debug.WriteLine(ue.Message);
						}
					}
				}
			}
			return html;
		}
		private String Parsea(String html,String pathdoc,bool showWarning,FileInfo fdoc)
		{
			bool warning=true;
			CHtmlParser.CHTMLDcoument doc=new CHtmlParser.CHTMLDcoument();
			doc.LoadHml(html);
			foreach(CHtmlParser.CTag tag in doc.Tags)
			{
				if(tag.Name.ToLower().Equals("html"))
				{
					foreach(CHtmlParser.CAttibute att in tag.Attibutes)
					{
						if(att.Value.ToLower().Equals("urn:schemas-microsoft-com:office:powerpoint"))
						{
							warning=false;
						}
					}
				}
				html=Parsea(tag,"background",html,pathdoc,fdoc);
				html=Parsea(tag,"codebase",html,pathdoc,fdoc);				
				html=Parsea(tag,"src",html,pathdoc,fdoc);
				html=Parsea(tag,"href",html,pathdoc,fdoc);
				if(tag.Name.ToLower().Equals("link"))
				{
					bool borrado=false;
					foreach(CHtmlParser.CAttibute att in tag.Attibutes)
					{
						if(att.Name.ToLower().Equals("rel") && att.Value.Equals("Edit-Time-Data"))
						{
							String stag=tag.Tag;								
							html=html.Replace(stag,null);
							borrado=true;
						}						
					}
					if(!borrado)
					{
						html=Parsea(tag,"href",html,pathdoc,fdoc);
					}
					
				}
				else
				{
					html=Parsea(tag,"href",html,pathdoc,fdoc);
				}
				
								
				
			}
			if(warning && showWarning)
			{
				MessageBox.Show(this,resources.GetString("FrmOpen3.msg1ppt"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Warning);  
			}
			return html;
		}



        /// <summary>Obtiene el nombre del drive</summary>
        /// <returns>Nombre del Drive</returns>
        /// <param name="drive">Drive a buscar nombre , puede ser c:, d:, etc.</param>
        public string GetDriveName(string drive)
        {
            string retval = "";
            System.IO.DriveInfo[] drives = System.IO.DriveInfo.GetDrives();
            foreach (System.IO.DriveInfo odrive in drives)
            {
                if (odrive.Name == drive)
                {
                    if (odrive.IsReady)
                    {
                        retval = odrive.VolumeLabel;
                    }
                }
            }
            return retval;
        }

		private System.Windows.Forms.DialogResult DirTargetTest(String path)
		{
			try
			{
				System.IO.DirectoryInfo fdir=new DirectoryInfo(path);
				System.IO.FileInfo[] file=fdir.GetFiles();
			}
			catch(System.IO.IOException ioedir)
			{
				Console.WriteLine(ioedir.Message); 
				return MessageBox.Show(this,ioedir.Message,this.Text,MessageBoxButtons.RetryCancel,MessageBoxIcon.Warning);
			}
			return System.Windows.Forms.DialogResult.OK;
		}

	}
}
