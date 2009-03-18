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
namespace WBPowerPoint
{
	/// <summary>Control que muestra el resumen de apertura de contenido</summary>
	public class OpenStep7 : TSWizards.BaseExteriorStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.TabControl tabControl1;
		private System.Windows.Forms.TabPage tabPage1;
		private System.Windows.Forms.ListView listView2;
		private System.Windows.Forms.TabPage tabPage2;
		private System.Windows.Forms.ListView listView1;
		private System.Windows.Forms.ColumnHeader columnHeader4;
		private System.Windows.Forms.ColumnHeader columnHeader5;
		private System.Windows.Forms.ColumnHeader columnHeader6;
		private System.Windows.Forms.ColumnHeader columnHeader7;
		/// <summary> 
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public OpenStep7()
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(OpenStep7));
			this.tabControl1 = new System.Windows.Forms.TabControl();
			this.tabPage1 = new System.Windows.Forms.TabPage();
			this.listView2 = new System.Windows.Forms.ListView();
			this.columnHeader4 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader5 = new System.Windows.Forms.ColumnHeader();
			this.tabPage2 = new System.Windows.Forms.TabPage();
			this.listView1 = new System.Windows.Forms.ListView();
			this.columnHeader6 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader7 = new System.Windows.Forms.ColumnHeader();
			this.tabControl1.SuspendLayout();
			this.tabPage1.SuspendLayout();
			this.tabPage2.SuspendLayout();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
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
			this.listView2.FullRowSelect = true;
			this.listView2.GridLines = true;
			this.listView2.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.Nonclickable;
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
																						this.columnHeader6,
																						this.columnHeader7});
			this.listView1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView1.Dock")));
			this.listView1.Enabled = ((bool)(resources.GetObject("listView1.Enabled")));
			this.listView1.Font = ((System.Drawing.Font)(resources.GetObject("listView1.Font")));
			this.listView1.FullRowSelect = true;
			this.listView1.GridLines = true;
			this.listView1.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
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
			// columnHeader6
			// 
			this.columnHeader6.Text = resources.GetString("columnHeader6.Text");
			this.columnHeader6.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader6.TextAlign")));
			this.columnHeader6.Width = ((int)(resources.GetObject("columnHeader6.Width")));
			// 
			// columnHeader7
			// 
			this.columnHeader7.Text = resources.GetString("columnHeader7.Text");
			this.columnHeader7.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader7.TextAlign")));
			this.columnHeader7.Width = ((int)(resources.GetObject("columnHeader7.Width")));
			// 
			// OpenStep7
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.tabControl1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.IsFinished = true;
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "OpenStep7";
			this.NextStep = "FINISHED";
			this.PreviousStep = "Step6";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.OpenStep7_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.tabControl1, 0);
			this.tabControl1.ResumeLayout(false);
			this.tabPage1.ResumeLayout(false);
			this.tabPage2.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void OpenStep7_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.next.Enabled=true;
			this.Wizard.back.Visible=false;
			this.Wizard.cancel.Visible=false;
			string[] sitem= new string[2];
			foreach(IParameter p in FrmOpenContent.resultados)
			{
				if(p.Name.Equals("content"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg1");
					sitem[1]=p.Attributes[0].Value; 
					listView1.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("attach"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg2");
					sitem[1]=p.Attributes[0].Value; 
					listView1.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("error"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg3");
					sitem[1]=p.Value;
					listView2.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("dir"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg4");
					sitem[1]=p.Value;
					listView2.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("filedoc"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg5")+" "+CPowerPoint.app.Name;
					sitem[1]=p.Value;
					listView2.Items.Add(new ListViewItem(sitem));  
				}
			}
			foreach(IParameter p in FrmOpenContent.parametros)
			{
				if(p.Name.Equals("content"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg1");
					sitem[1]=p.Attributes[0].Value; 
					listView1.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("attach"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg2");
					sitem[1]=p.Attributes[0].Value; 
					listView1.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("error"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg3");
					sitem[1]=p.Value;
					listView2.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("dir"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg4");
					sitem[1]=p.Value;
					listView2.Items.Add(new ListViewItem(sitem));  
				}
				if(p.Name.Equals("filedoc"))
				{
					sitem[0]=resources.GetString("FrmOpen4.msg5")+" "+CPowerPoint.app.Name;
					sitem[1]=p.Value;
					listView2.Items.Add(new ListViewItem(sitem));  
				}
			}
		}
	}
}
