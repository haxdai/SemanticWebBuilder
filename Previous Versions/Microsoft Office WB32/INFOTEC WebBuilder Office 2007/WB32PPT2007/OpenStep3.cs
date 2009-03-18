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
namespace WBPowerPoint
{
	/// <summary>
	/// Control que muestra el listado de contenido existentes en la sección para Word,
	/// al seleccionar un contenido este será el que podrá abrirse
	/// </summary>
	public class OpenStep3 : TSWizards.BaseStep
	{
		
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private ColumnSorter TheColumnSorter = new ColumnSorter();
		/// <summary>
		/// Lista de contenidos
		/// </summary>
		public System.Windows.Forms.ListView listView1;
		private System.Windows.Forms.ColumnHeader columnHeader4;
		private System.Windows.Forms.ColumnHeader columnHeader1;
		private System.Windows.Forms.ColumnHeader columnHeader2;
		private System.Windows.Forms.ColumnHeader columnHeader3;
		private System.Windows.Forms.ImageList imageList1;
		private System.Windows.Forms.Button button1;
		private System.ComponentModel.IContainer components;
		/// <summary>
		/// Crea el control que muestra el listado de contenido existentes en la sección para
		/// Word, al seleccionar un contenido este será el que podrá abrirse
		/// </summary>
		public OpenStep3()
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
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(OpenStep3));
			this.listView1 = new System.Windows.Forms.ListView();
			this.columnHeader4 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader2 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader3 = new System.Windows.Forms.ColumnHeader();
			this.imageList1 = new System.Windows.Forms.ImageList(this.components);
			this.button1 = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// listView1
			// 
			this.listView1.AccessibleDescription = resources.GetString("listView1.AccessibleDescription");
			this.listView1.AccessibleName = resources.GetString("listView1.AccessibleName");
			this.listView1.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listView1.Alignment")));
			this.listView1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listView1.Anchor")));
			this.listView1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listView1.BackgroundImage")));
			this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																						this.columnHeader4,
																						this.columnHeader1,
																						this.columnHeader2,
																						this.columnHeader3});
			this.listView1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView1.Dock")));
			this.listView1.Enabled = ((bool)(resources.GetObject("listView1.Enabled")));
			this.listView1.Font = ((System.Drawing.Font)(resources.GetObject("listView1.Font")));
			this.listView1.FullRowSelect = true;
			this.listView1.HideSelection = false;
			this.listView1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listView1.ImeMode")));
			this.listView1.LabelWrap = ((bool)(resources.GetObject("listView1.LabelWrap")));
			this.listView1.LargeImageList = this.imageList1;
			this.listView1.Location = ((System.Drawing.Point)(resources.GetObject("listView1.Location")));
			this.listView1.MultiSelect = false;
			this.listView1.Name = "listView1";
			this.listView1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listView1.RightToLeft")));
			this.listView1.Size = ((System.Drawing.Size)(resources.GetObject("listView1.Size")));
			this.listView1.SmallImageList = this.imageList1;
			this.listView1.TabIndex = ((int)(resources.GetObject("listView1.TabIndex")));
			this.listView1.Text = resources.GetString("listView1.Text");
			this.listView1.View = System.Windows.Forms.View.Details;
			this.listView1.Visible = ((bool)(resources.GetObject("listView1.Visible")));
			this.listView1.DoubleClick += new System.EventHandler(this.listView1_DoubleClick);
			this.listView1.ColumnClick += new System.Windows.Forms.ColumnClickEventHandler(this.listView1_ColumnClick);
			this.listView1.SelectedIndexChanged += new System.EventHandler(this.listView1_SelectedIndexChanged);
			// 
			// columnHeader4
			// 
			this.columnHeader4.Text = resources.GetString("columnHeader4.Text");
			this.columnHeader4.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader4.TextAlign")));
			this.columnHeader4.Width = ((int)(resources.GetObject("columnHeader4.Width")));
			// 
			// columnHeader1
			// 
			this.columnHeader1.Text = resources.GetString("columnHeader1.Text");
			this.columnHeader1.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader1.TextAlign")));
			this.columnHeader1.Width = ((int)(resources.GetObject("columnHeader1.Width")));
			// 
			// columnHeader2
			// 
			this.columnHeader2.Text = resources.GetString("columnHeader2.Text");
			this.columnHeader2.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader2.TextAlign")));
			this.columnHeader2.Width = ((int)(resources.GetObject("columnHeader2.Width")));
			// 
			// columnHeader3
			// 
			this.columnHeader3.Text = resources.GetString("columnHeader3.Text");
			this.columnHeader3.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader3.TextAlign")));
			this.columnHeader3.Width = ((int)(resources.GetObject("columnHeader3.Width")));
			// 
			// imageList1
			// 
			this.imageList1.ImageSize = ((System.Drawing.Size)(resources.GetObject("imageList1.ImageSize")));
			this.imageList1.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList1.ImageStream")));
			this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
			// 
			// button1
			// 
			this.button1.AccessibleDescription = resources.GetString("button1.AccessibleDescription");
			this.button1.AccessibleName = resources.GetString("button1.AccessibleName");
			this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("button1.Anchor")));
			this.button1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("button1.BackgroundImage")));
			this.button1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("button1.Dock")));
			this.button1.Enabled = ((bool)(resources.GetObject("button1.Enabled")));
			this.button1.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("button1.FlatStyle")));
			this.button1.Font = ((System.Drawing.Font)(resources.GetObject("button1.Font")));
			this.button1.Image = ((System.Drawing.Image)(resources.GetObject("button1.Image")));
			this.button1.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button1.ImageAlign")));
			this.button1.ImageIndex = ((int)(resources.GetObject("button1.ImageIndex")));
			this.button1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("button1.ImeMode")));
			this.button1.Location = ((System.Drawing.Point)(resources.GetObject("button1.Location")));
			this.button1.Name = "button1";
			this.button1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("button1.RightToLeft")));
			this.button1.Size = ((System.Drawing.Size)(resources.GetObject("button1.Size")));
			this.button1.TabIndex = ((int)(resources.GetObject("button1.TabIndex")));
			this.button1.Text = resources.GetString("button1.Text");
			this.button1.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button1.TextAlign")));
			this.button1.Visible = ((bool)(resources.GetObject("button1.Visible")));
			this.button1.Click += new System.EventHandler(this.button1_Click);
			// 
			// OpenStep3
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.button1);
			this.Controls.Add(this.listView1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "OpenStep3";
			this.NextStep = "Step4";
			this.PreviousStep = "Step2";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.OpenStep3_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.listView1, 0);
			this.Controls.SetChildIndex(this.button1, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void listView1_ColumnClick(object sender, System.Windows.Forms.ColumnClickEventArgs e)
		{
			TheColumnSorter.Ascending=!TheColumnSorter.Ascending;  
			TheColumnSorter.CurrentColumn  = e.Column;
			listView1.Sort(); 
		}

		private void listView1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{
				this.Wizard.NextEnabled=true;
				this.button1.Enabled=true;
			}
			else
			{
				this.Wizard.NextEnabled=false;
				this.button1.Enabled=false;
			}
		}

		private void OpenStep3_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Cursor=Cursors.WaitCursor;
			this.listView1.Items.Clear();
			this.Wizard.NextEnabled=false;
			this.listView1.ListViewItemSorter = TheColumnSorter;
			OpenStep2 step2 = Wizard.GetStep("Step2") as OpenStep2;			
			
			if(step2.treeView1.SelectedNode!=null && step2.treeView1.SelectedNode is WBNode)
			{
				WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String topicid=values[values.Length-1];
				String idtopicmap=values[values.Length-2];	

				
				
				Servicios s= new Servicios(CPowerPoint.user);								
				System.Xml.XmlDocument doc=s.getContentTopic(topicid,idtopicmap); 
				System.Xml.XmlNodeList xmlcontents=doc.GetElementsByTagName("ContentRelated"); 
				foreach(System.Xml.XmlElement  xmlcontrel in xmlcontents)
				{
					String idcontent=xmlcontrel.GetAttribute("Id");					
					Servicios sAtt=new Servicios(CPowerPoint.user);
					XmlDocument docAtt=sAtt.getContentAtt(idtopicmap,topicid,idcontent);
					if(docAtt.GetElementsByTagName("nameType").Count>0)
					{
						String nameType=docAtt.GetElementsByTagName("nameType")[0].InnerText;
						if(nameType==CPowerPoint.TYPE)
						{
							String lastversion=xmlcontrel.GetElementsByTagName("lastversion")[0].InnerText;
							String actualversion=xmlcontrel.GetElementsByTagName("actualversion")[0].InnerText;
							int ilastversion=Int32.Parse(lastversion);
							int iactualversion=Int32.Parse(actualversion);
							for(int i=1;i<=ilastversion;i++)
							{
								string[] sitem= new string[4];
								sitem[0]=idcontent;
								sitem[1]=xmlcontrel.GetElementsByTagName("title")[0].InnerText; 
								sitem[2]=""+i; 
								if(iactualversion==i)
								{
									sitem[3]=resources.GetString("FrmOpen2.si"); 
								}
								else
								{
									sitem[3]=resources.GetString("FrmOpen2.no"); 
								}
								System.Windows.Forms.ListViewItem item=new ListViewItem(sitem);
								item.ImageIndex=0; 											
								this.listView1.Items.Add(item);
							}
						}
					}
				}
			}
			this.Cursor=Cursors.Default;
		}

		private void listView1_DoubleClick(object sender, System.EventArgs e)
		{
			foreach(ListViewItem item in this.listView1.SelectedItems)
			{
				OpenStep2 step2 = Wizard.GetStep("Step2") as OpenStep2;
				WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String idtopic=values[values.Length-1];
				String idtopicmap=values[values.Length-2];
				string version=item.SubItems[2].Text;
				string contentid=item.Text;
				FrmPreview frm=new FrmPreview(idtopicmap,idtopic,contentid,version,CPowerPoint.user);
				frm.ShowDialog(this);
				return;
			}
		}

		private void button1_Click(object sender, System.EventArgs e)
		{
			listView1_DoubleClick(null,null);
		}
	}
}
