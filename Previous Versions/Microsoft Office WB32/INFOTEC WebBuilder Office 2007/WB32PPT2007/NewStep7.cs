/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;
using WBOffice3;
using System.Diagnostics;
namespace WBPowerPoint
{
	/// <summary>Control para mostrar resumen de avance de publicaci�n de contenido</summary>
	public class NewStep7 : TSWizards.BaseExteriorStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.TabControl tabControl1;
		private System.Windows.Forms.TabPage tabPage1;
		private System.Windows.Forms.ListView listView2;
		private System.Windows.Forms.TabPage tabPage2;
		private System.Windows.Forms.ListView listView1;
		private System.Windows.Forms.ColumnHeader columnHeader4;
		private System.Windows.Forms.ColumnHeader columnHeader5;
		private System.Windows.Forms.ColumnHeader columnHeader1;
		private System.Windows.Forms.ColumnHeader columnHeader2;
		private System.Windows.Forms.ColumnHeader columnHeader3;
		private System.Windows.Forms.Button buttonVer;
		/// <summary> 
		/// Variable del dise�ador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public NewStep7()
		{
			// Llamada necesaria para el Dise�ador de formularios Windows.Forms.
			InitializeComponent();

			// TODO: agregar cualquier inicializaci�n despu�s de llamar a InitializeComponent

		}

		/// <summary> 
		/// Limpiar los recursos que se est�n utilizando.
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

		#region C�digo generado por el Dise�ador de componentes
		/// <summary> 
		/// M�todo necesario para admitir el Dise�ador. No se puede modificar 
		/// el contenido del m�todo con el editor de c�digo.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(NewStep7));
			this.tabControl1 = new System.Windows.Forms.TabControl();
			this.tabPage1 = new System.Windows.Forms.TabPage();
			this.listView2 = new System.Windows.Forms.ListView();
			this.columnHeader4 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader5 = new System.Windows.Forms.ColumnHeader();
			this.tabPage2 = new System.Windows.Forms.TabPage();
			this.listView1 = new System.Windows.Forms.ListView();
			this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader2 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader3 = new System.Windows.Forms.ColumnHeader();
			this.buttonVer = new System.Windows.Forms.Button();
			this.tabControl1.SuspendLayout();
			this.tabPage1.SuspendLayout();
			this.tabPage2.SuspendLayout();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Size = ((System.Drawing.Size)(resources.GetObject("Description.Size")));
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// tabControl1
			// 
			this.tabControl1.AccessibleDescription = resources.GetString("tabControl1.AccessibleDescription");
			this.tabControl1.AccessibleName = resources.GetString("tabControl1.AccessibleName");
			this.tabControl1.Alignment = ((System.Windows.Forms.TabAlignment)(resources.GetObject("tabControl1.Alignment")));
			this.tabControl1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabControl1.Anchor")));
			this.tabControl1.Appearance = ((System.Windows.Forms.TabAppearance)(resources.GetObject("tabControl1.Appearance")));
			this.tabControl1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabControl1.BackgroundImage")));
			this.tabControl1.Controls.Add(this.tabPage1);
			this.tabControl1.Controls.Add(this.tabPage2);
			this.tabControl1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabControl1.Dock")));
			this.tabControl1.Enabled = ((bool)(resources.GetObject("tabControl1.Enabled")));
			this.tabControl1.Font = ((System.Drawing.Font)(resources.GetObject("tabControl1.Font")));
			this.tabControl1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabControl1.ImeMode")));
			this.tabControl1.ItemSize = ((System.Drawing.Size)(resources.GetObject("tabControl1.ItemSize")));
			this.tabControl1.Location = ((System.Drawing.Point)(resources.GetObject("tabControl1.Location")));
			this.tabControl1.Name = "tabControl1";
			this.tabControl1.Padding = ((System.Drawing.Point)(resources.GetObject("tabControl1.Padding")));
			this.tabControl1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabControl1.RightToLeft")));
			this.tabControl1.SelectedIndex = 0;
			this.tabControl1.ShowToolTips = ((bool)(resources.GetObject("tabControl1.ShowToolTips")));
			this.tabControl1.Size = ((System.Drawing.Size)(resources.GetObject("tabControl1.Size")));
			this.tabControl1.TabIndex = ((int)(resources.GetObject("tabControl1.TabIndex")));
			this.tabControl1.Text = resources.GetString("tabControl1.Text");
			this.tabControl1.Visible = ((bool)(resources.GetObject("tabControl1.Visible")));
			// 
			// tabPage1
			// 
			this.tabPage1.AccessibleDescription = resources.GetString("tabPage1.AccessibleDescription");
			this.tabPage1.AccessibleName = resources.GetString("tabPage1.AccessibleName");
			this.tabPage1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabPage1.Anchor")));
			this.tabPage1.AutoScroll = ((bool)(resources.GetObject("tabPage1.AutoScroll")));
			this.tabPage1.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("tabPage1.AutoScrollMargin")));
			this.tabPage1.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("tabPage1.AutoScrollMinSize")));
			this.tabPage1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabPage1.BackgroundImage")));
			this.tabPage1.Controls.Add(this.listView2);
			this.tabPage1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabPage1.Dock")));
			this.tabPage1.Enabled = ((bool)(resources.GetObject("tabPage1.Enabled")));
			this.tabPage1.Font = ((System.Drawing.Font)(resources.GetObject("tabPage1.Font")));
			this.tabPage1.ImageIndex = ((int)(resources.GetObject("tabPage1.ImageIndex")));
			this.tabPage1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabPage1.ImeMode")));
			this.tabPage1.Location = ((System.Drawing.Point)(resources.GetObject("tabPage1.Location")));
			this.tabPage1.Name = "tabPage1";
			this.tabPage1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabPage1.RightToLeft")));
			this.tabPage1.Size = ((System.Drawing.Size)(resources.GetObject("tabPage1.Size")));
			this.tabPage1.TabIndex = ((int)(resources.GetObject("tabPage1.TabIndex")));
			this.tabPage1.Text = resources.GetString("tabPage1.Text");
			this.tabPage1.ToolTipText = resources.GetString("tabPage1.ToolTipText");
			this.tabPage1.Visible = ((bool)(resources.GetObject("tabPage1.Visible")));
			// 
			// listView2
			// 
			this.listView2.AccessibleDescription = resources.GetString("listView2.AccessibleDescription");
			this.listView2.AccessibleName = resources.GetString("listView2.AccessibleName");
			this.listView2.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listView2.Alignment")));
			this.listView2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listView2.Anchor")));
			this.listView2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listView2.BackgroundImage")));
			this.listView2.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																						this.columnHeader4,
																						this.columnHeader5});
			this.listView2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView2.Dock")));
			this.listView2.Enabled = ((bool)(resources.GetObject("listView2.Enabled")));
			this.listView2.Font = ((System.Drawing.Font)(resources.GetObject("listView2.Font")));
			this.listView2.GridLines = true;
			this.listView2.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
			this.listView2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listView2.ImeMode")));
			this.listView2.LabelWrap = ((bool)(resources.GetObject("listView2.LabelWrap")));
			this.listView2.Location = ((System.Drawing.Point)(resources.GetObject("listView2.Location")));
			this.listView2.Name = "listView2";
			this.listView2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listView2.RightToLeft")));
			this.listView2.Size = ((System.Drawing.Size)(resources.GetObject("listView2.Size")));
			this.listView2.TabIndex = ((int)(resources.GetObject("listView2.TabIndex")));
			this.listView2.Text = resources.GetString("listView2.Text");
			this.listView2.View = System.Windows.Forms.View.Details;
			this.listView2.Visible = ((bool)(resources.GetObject("listView2.Visible")));
			// 
			// columnHeader4
			// 
			this.columnHeader4.Text = resources.GetString("columnHeader4.Text");
			this.columnHeader4.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader4.TextAlign")));
			this.columnHeader4.Width = ((int)(resources.GetObject("columnHeader4.Width")));
			// 
			// columnHeader5
			// 
			this.columnHeader5.Text = resources.GetString("columnHeader5.Text");
			this.columnHeader5.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader5.TextAlign")));
			this.columnHeader5.Width = ((int)(resources.GetObject("columnHeader5.Width")));
			// 
			// tabPage2
			// 
			this.tabPage2.AccessibleDescription = resources.GetString("tabPage2.AccessibleDescription");
			this.tabPage2.AccessibleName = resources.GetString("tabPage2.AccessibleName");
			this.tabPage2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabPage2.Anchor")));
			this.tabPage2.AutoScroll = ((bool)(resources.GetObject("tabPage2.AutoScroll")));
			this.tabPage2.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("tabPage2.AutoScrollMargin")));
			this.tabPage2.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("tabPage2.AutoScrollMinSize")));
			this.tabPage2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabPage2.BackgroundImage")));
			this.tabPage2.Controls.Add(this.listView1);
			this.tabPage2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabPage2.Dock")));
			this.tabPage2.Enabled = ((bool)(resources.GetObject("tabPage2.Enabled")));
			this.tabPage2.Font = ((System.Drawing.Font)(resources.GetObject("tabPage2.Font")));
			this.tabPage2.ImageIndex = ((int)(resources.GetObject("tabPage2.ImageIndex")));
			this.tabPage2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabPage2.ImeMode")));
			this.tabPage2.Location = ((System.Drawing.Point)(resources.GetObject("tabPage2.Location")));
			this.tabPage2.Name = "tabPage2";
			this.tabPage2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabPage2.RightToLeft")));
			this.tabPage2.Size = ((System.Drawing.Size)(resources.GetObject("tabPage2.Size")));
			this.tabPage2.TabIndex = ((int)(resources.GetObject("tabPage2.TabIndex")));
			this.tabPage2.Text = resources.GetString("tabPage2.Text");
			this.tabPage2.ToolTipText = resources.GetString("tabPage2.ToolTipText");
			this.tabPage2.Visible = ((bool)(resources.GetObject("tabPage2.Visible")));
			// 
			// listView1
			// 
			this.listView1.AccessibleDescription = resources.GetString("listView1.AccessibleDescription");
			this.listView1.AccessibleName = resources.GetString("listView1.AccessibleName");
			this.listView1.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listView1.Alignment")));
			this.listView1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listView1.Anchor")));
			this.listView1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listView1.BackgroundImage")));
			this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																						this.columnHeader1,
																						this.columnHeader2,
																						this.columnHeader3});
			this.listView1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView1.Dock")));
			this.listView1.Enabled = ((bool)(resources.GetObject("listView1.Enabled")));
			this.listView1.Font = ((System.Drawing.Font)(resources.GetObject("listView1.Font")));
			this.listView1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listView1.ImeMode")));
			this.listView1.LabelWrap = ((bool)(resources.GetObject("listView1.LabelWrap")));
			this.listView1.Location = ((System.Drawing.Point)(resources.GetObject("listView1.Location")));
			this.listView1.Name = "listView1";
			this.listView1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listView1.RightToLeft")));
			this.listView1.Size = ((System.Drawing.Size)(resources.GetObject("listView1.Size")));
			this.listView1.TabIndex = ((int)(resources.GetObject("listView1.TabIndex")));
			this.listView1.Text = resources.GetString("listView1.Text");
			this.listView1.View = System.Windows.Forms.View.Details;
			this.listView1.Visible = ((bool)(resources.GetObject("listView1.Visible")));
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
			// buttonVer
			// 
			this.buttonVer.AccessibleDescription = resources.GetString("buttonVer.AccessibleDescription");
			this.buttonVer.AccessibleName = resources.GetString("buttonVer.AccessibleName");
			this.buttonVer.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonVer.Anchor")));
			this.buttonVer.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonVer.BackgroundImage")));
			this.buttonVer.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonVer.Dock")));
			this.buttonVer.Enabled = ((bool)(resources.GetObject("buttonVer.Enabled")));
			this.buttonVer.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonVer.FlatStyle")));
			this.buttonVer.Font = ((System.Drawing.Font)(resources.GetObject("buttonVer.Font")));
			this.buttonVer.Image = ((System.Drawing.Image)(resources.GetObject("buttonVer.Image")));
			this.buttonVer.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonVer.ImageAlign")));
			this.buttonVer.ImageIndex = ((int)(resources.GetObject("buttonVer.ImageIndex")));
			this.buttonVer.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonVer.ImeMode")));
			this.buttonVer.Location = ((System.Drawing.Point)(resources.GetObject("buttonVer.Location")));
			this.buttonVer.Name = "buttonVer";
			this.buttonVer.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonVer.RightToLeft")));
			this.buttonVer.Size = ((System.Drawing.Size)(resources.GetObject("buttonVer.Size")));
			this.buttonVer.TabIndex = ((int)(resources.GetObject("buttonVer.TabIndex")));
			this.buttonVer.Text = resources.GetString("buttonVer.Text");
			this.buttonVer.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonVer.TextAlign")));
			this.buttonVer.Visible = ((bool)(resources.GetObject("buttonVer.Visible")));
			this.buttonVer.Click += new System.EventHandler(this.button1_Click);
			// 
			// NewStep7
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.buttonVer);
			this.Controls.Add(this.tabControl1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.IsFinished = true;
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "NewStep7";
			this.NextStep = "FINISHED";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.NewStep7_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.tabControl1, 0);
			this.Controls.SetChildIndex(this.buttonVer, 0);
			this.tabControl1.ResumeLayout(false);
			this.tabPage1.ResumeLayout(false);
			this.tabPage2.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void NewStep7_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.next.Enabled=true;
			this.Wizard.back.Visible=false;
			this.Wizard.cancel.Visible=false;
			string [] item=new String[3];
			int ifiles=0;
			int itotaltam=0;
			foreach(IParameter p in FrmNewContent.parametros)
			{
				if(p.IsFile)
				{
					FileParameter filep=(FileParameter)p;
					if(filep.FileInfo.Exists)
					{
						item[0]=filep.FileInfo.Name;
						item[1]=filep.FileInfo.Directory.FullName; 
						int tam=(int)(filep.FileInfo.Length/1024d);
						itotaltam+=tam;
						if(tam==0)
						{
							tam++;
						}
						item[2]=""+tam;					
						System.Windows.Forms.ListViewItem listitem= new ListViewItem(item);
						this.listView1.Items.Add(listitem);  
						ifiles++;
					}
				}				
			}	
			string[] items2=new string[2];
			items2[0]=resources.GetString("FrmNew4.msg1");
			items2[1]=""+ifiles;
			System.Windows.Forms.ListViewItem listitem1= new ListViewItem(items2);
			this.listView2.Items.Add(listitem1); 
			
			if(itotaltam==0)
			{
				itotaltam++;
			}
			items2[0]=resources.GetString("FrmNew4.msg2");
			items2[1]=""+itotaltam+" KB";			
			listitem1= new ListViewItem(items2);
			this.listView2.Items.Add(listitem1); 

			items2[0]=resources.GetString("FrmNew4.msg3");
			String id=null;
			foreach(IParameter pres in FrmNewContent.resultados)
			{
				if(pres.Name.Equals("id"))
				{
					id=pres.Value; 
				}
			}
			if(id==null)
			{
				buttonVer.Enabled=false;
			}
			items2[1]=id;		
			Parameter pid= new Parameter("id",items2[1]); 
			FrmNewContent.resultados.Add(pid);  
			listitem1= new ListViewItem(items2);
			this.listView2.Items.Add(listitem1); 
			foreach(IParameter pres in FrmNewContent.resultados)
			{
				if(pres.Name.Equals("error"))
				{
					items2[0]="Error";
					items2[1]=pres.Value; 	
					listitem1= new ListViewItem(items2);
					this.listView2.Items.Add(listitem1);
					buttonVer.Enabled=false;
				}
			}
			foreach(IParameter pres in FrmNewContent.resultados)
			{
				if(pres.Name.Equals("version"))
				{
					items2[0]=resources.GetString("FrmNew4.msg4");
					items2[1]=pres.Value; 	
					listitem1= new ListViewItem(items2);
					this.listView2.Items.Add(listitem1);
					items2[0]=resources.GetString("FrmNew4.msg5");
					items2[1]=pres.Value; 	
					listitem1= new ListViewItem(items2);
					this.listView2.Items.Add(listitem1);
				}
			}
		}

		private void button1_Click(object sender, System.EventArgs e)
		{
			
			String idcont="";
			String topicid="";
			String topicmap="";
			String version="";
			foreach(IParameter p in FrmNewContent.resultados)
			{
				if(p.Name.Equals("id"))
				{
					idcont=p.Value;
				}
				if(p.Name.Equals("version"))
				{
					version=p.Value;
				}
				
			}
			foreach(IParameter p in FrmNewContent.parametros)
			{
				if(p.Name.Equals("topicid"))
				{
					topicid=p.Value;
				}
				if(p.Name.Equals("version"))
				{
					version=p.Value;
				}
				if(p.Name.Equals("topicmap"))
				{
					topicmap=p.Value;
				}
			}
			if(idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
			{
				return;
			}
			try
			{
				FrmPreview frm=new FrmPreview(topicmap,topicid,idcont,version,FrmNewContent.user); 				
				frm.Text=resources.GetString("FrmNew4.msg6");
				frm.ShowDialog(this); 
			}
			catch(Exception ue)
			{
				Debug.WriteLine(ue.Message);
			}
		}
	}
}
