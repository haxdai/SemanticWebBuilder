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
using WBOffice3;
using System.Xml;
using System.IO;
using Excel = Microsoft.Office.Interop.Excel;
using Office = Microsoft.Office.Core;
namespace WBExcel
{
	/// <summary>Control que muestra el avance de publicación de contenido</summary>
	public class NewStep6 : TSWizards.BaseStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.ProgressBar progressBar1;
		/// <summary> 
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>Crea un control para mostrar el resumen de publicación de contenido</summary>
		public NewStep6()
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(NewStep6));
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
			// NewStep6
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
			this.Name = "NewStep6";
			this.NextStep = "Step7";
			this.PreviousStep = "Step5";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.NewStep6_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.progressBar1, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void NewStep6_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.next.Enabled=false;
			this.Wizard.back.Visible=true;
			this.Wizard.cancel.Visible=true;
			NewStep2 step2 = Wizard.GetStep("Step2") as NewStep2;

			this.progressBar1.Minimum=0;
			this.progressBar1.Maximum=FrmNewContent.imagenes.Count+1;
			
			WBOffice3.Parameter parametro= new WBOffice3.Parameter("title",step2.txttitulo.Text);  
			FrmNewContent.parametros.Add(parametro);  			

			NewStep3 step3 = Wizard.GetStep("Step3") as NewStep3;
			parametro= new WBOffice3.Parameter("description",step3.txtDesc.Text);
			FrmNewContent.parametros.Add(parametro); 
			
			
			NewStep4 step4 = Wizard.GetStep("Step4") as NewStep4;
			TreeView treeView1=step4.treeView1;
			this.Cursor=Cursors.WaitCursor; 
			if(treeView1.SelectedNode!=null && treeView1.SelectedNode is WBNode)
			{
				WBNode wbnode=(WBNode)treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String idtopic=values[values.Length-1];
				String idtopicmap=values[values.Length-2];
				if(CExcel.user.GetPermiso(idtopicmap,CExcel.TYPE))
				{
					bool existe=false;
					foreach(WBOffice3.IParameter p in FrmNewContent.parametros )
					{
						if(p.Name.Equals("topicid"))
						{
							p.Value=idtopic;						
							existe=true;
						}
						if(p.Name.Equals("topicmap"))
						{
							p.Value=idtopicmap;						
							existe=true;
						}
					}	
					if(!existe)
					{
						WBOffice3.Parameter parameter = new WBOffice3.Parameter("topicid",idtopic); 
						FrmNewContent.parametros.Add(parameter); 
						WBOffice3.Parameter ptopicmap=new WBOffice3.Parameter("topicmap",idtopicmap); 
						FrmNewContent.parametros.Add(ptopicmap); 
					}
					Servicios s= new Servicios(CExcel.user);
					FrmNewContent.parametros.Add(new WBOffice3.Parameter("type","excel"));

					NewStep9 step9 = Wizard.GetStep("Step9") as NewStep9;
					if(step9.radioButtonWeb.Checked)
					{
						FrmNewContent.parametros.Add(new WBOffice3.Parameter("mode","web"));
					}
					if(step9.radioButtonOffice.Checked)
					{
						FrmNewContent.parametros.Add(new WBOffice3.Parameter("mode","office"));
					}

					XmlDocument resp=s.altaContenido(FrmNewContent.parametros); 
					this.progressBar1.Value++;
					if(resp.GetElementsByTagName("id").Count>0 && resp.GetElementsByTagName("actualversion").Count>0)
					{
						String id=resp.GetElementsByTagName("id")[0].InnerText;
						String version=resp.GetElementsByTagName("actualversion")[0].InnerText;
						WBOffice3.Parameter p=new WBOffice3.Parameter("id",id); 				
						FrmNewContent.resultados.Add(p);
						p=new WBOffice3.Parameter("version",version); 
						FrmNewContent.resultados.Add(p);
					}		
					foreach(WBOffice3.IParameter paramres in FrmNewContent.resultados)
					{
						if(paramres.Name.Equals("id"))
						{
							object id=paramres.Value;
							foreach(FileInfo fileimagen in FrmNewContent.imagenes)
							{
								String resType=CExcel.TYPE;
								CContentUpload cfile=new CContentUpload(fileimagen,idtopicmap,paramres.Value,"1",CExcel.user,resType);
								FrmFileUpload fup=new FrmFileUpload(cfile);
								fup.Send();
								FileParameter pfile=new FileParameter("attach",fileimagen.FullName);
								WBOffice3.Attribute att= new WBOffice3.Attribute("filename",fileimagen.Name);
								pfile.Attributes.Add(att); 
								FrmNewContent.parametros.Add(pfile);  
								this.progressBar1.Value++;
							}
							string str = "";
							System.Object nullObjStr = str;
							try
							{
								object path=CExcel.doc.FullName;
								object missing = Type.Missing;
								object objtrue=true;								
								object objfalse=false;
                                Office.DocumentProperties props = (Office.DocumentProperties)CExcel.doc.CustomDocumentProperties;
								Office.DocumentProperty prop=props.Add("content",false,Office.MsoDocProperties.msoPropertyTypeString,id,nullObjStr);
                                props.Add("topicid", false, Office.MsoDocProperties.msoPropertyTypeString, idtopic, nullObjStr);
                                props.Add("topicmap", false, Office.MsoDocProperties.msoPropertyTypeString, idtopicmap, nullObjStr);                               
                                CExcel.doc.Save();
                                
							}
							catch(Exception ue)
							{
								String es=ue.Message;
								Console.WriteLine(es); 
							}
						}
					}
					this.Cursor=Cursors.Default;					
				}
				else
				{
					MessageBox.Show(this,resources.GetString("FrmNew3.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					this.Cursor=Cursors.Default;
					Wizard.MoveBack();
					return;
				}
				
			}
			this.Cursor=Cursors.Default;			
			Wizard.MoveNext();
		}
	}
}
