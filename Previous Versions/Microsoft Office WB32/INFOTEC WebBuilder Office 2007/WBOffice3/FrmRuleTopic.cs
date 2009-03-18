/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using WBOffice3;
namespace WBOffice3
{
	/// <summary>Forma que se encarga de asociar una regla a un contenido</summary>
	public class FrmRuleTopic : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.Button button1;
		private System.Windows.Forms.ContextMenu contextMenu1;
		private System.Windows.Forms.MenuItem menuItem1;
		private System.Windows.Forms.MenuItem menuItem3;
		private System.Windows.Forms.Button button2;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		String topicmap="";
		String topicid="";
		String idcont="";		
		private System.Windows.Forms.Button buttonEliminar;
		private ColumnSorter TheColumnSorter = new ColumnSorter();
		private System.Windows.Forms.TabControl tabControl1;
		private System.Windows.Forms.TabPage tabPage1;
		private System.Windows.Forms.TabPage tabPage2;
		private System.Windows.Forms.ListView listView1;
		private System.Windows.Forms.ColumnHeader columnHeader4;
		private System.Windows.Forms.ColumnHeader columnHeader1;
		private System.Windows.Forms.ColumnHeader columnHeader2;
		private System.Windows.Forms.ColumnHeader columnHeader3;
		private System.Windows.Forms.ListView listView2;
		private System.Windows.Forms.ColumnHeader columnHeader5;
		private System.Windows.Forms.ColumnHeader columnHeader6;
		CUserAdmin user;
		System.Xml.XmlDocument docrules,docroles;
		/// <summary>
		/// Consturctor  para Forma apra asignar una regla a un contenido
		/// </summary>
		/// <param name="topicmap">Sitio</param>
		/// <param name="topicid">Sección</param>
		/// <param name="idcont">Contenido</param>
		/// <param name="user">Usuario</param>
		public FrmRuleTopic(String topicmap,String topicid,String idcont,CUserAdmin user)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.user=user;
			this.listView1.ListViewItemSorter=  TheColumnSorter;
			this.topicmap=topicmap;
			this.topicid=topicid;
			this.idcont=idcont;
			Servicios s=new Servicios(user);
			docrules=s.getRulesContent(topicmap,idcont,this.listView1);
			docroles=s.getRolesContent(topicmap,idcont,this.listView2);
		}

		/// <summary>
		/// Clean up any resources being used.
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

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmRuleTopic));
			this.button1 = new System.Windows.Forms.Button();
			this.contextMenu1 = new System.Windows.Forms.ContextMenu();
			this.menuItem1 = new System.Windows.Forms.MenuItem();
			this.menuItem3 = new System.Windows.Forms.MenuItem();
			this.button2 = new System.Windows.Forms.Button();
			this.buttonEliminar = new System.Windows.Forms.Button();
			this.tabControl1 = new System.Windows.Forms.TabControl();
			this.tabPage1 = new System.Windows.Forms.TabPage();
			this.listView1 = new System.Windows.Forms.ListView();
			this.columnHeader4 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader2 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader3 = new System.Windows.Forms.ColumnHeader();
			this.tabPage2 = new System.Windows.Forms.TabPage();
			this.listView2 = new System.Windows.Forms.ListView();
			this.columnHeader5 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader6 = new System.Windows.Forms.ColumnHeader();
			this.tabControl1.SuspendLayout();
			this.tabPage1.SuspendLayout();
			this.tabPage2.SuspendLayout();
			this.SuspendLayout();
			// 
			// button1
			// 
			this.button1.AccessibleDescription = resources.GetString("button1.AccessibleDescription");
			this.button1.AccessibleName = resources.GetString("button1.AccessibleName");
			this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("button1.Anchor")));
			this.button1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("button1.BackgroundImage")));
			this.button1.DialogResult = System.Windows.Forms.DialogResult.Cancel;
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
			// contextMenu1
			// 
			this.contextMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																						 this.menuItem1,
																						 this.menuItem3});
			this.contextMenu1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("contextMenu1.RightToLeft")));
			// 
			// menuItem1
			// 
			this.menuItem1.Enabled = ((bool)(resources.GetObject("menuItem1.Enabled")));
			this.menuItem1.Index = 0;
			this.menuItem1.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem1.Shortcut")));
			this.menuItem1.ShowShortcut = ((bool)(resources.GetObject("menuItem1.ShowShortcut")));
			this.menuItem1.Text = resources.GetString("menuItem1.Text");
			this.menuItem1.Visible = ((bool)(resources.GetObject("menuItem1.Visible")));
			this.menuItem1.Click += new System.EventHandler(this.menuItem1_Click);
			// 
			// menuItem3
			// 
			this.menuItem3.Enabled = ((bool)(resources.GetObject("menuItem3.Enabled")));
			this.menuItem3.Index = 1;
			this.menuItem3.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem3.Shortcut")));
			this.menuItem3.ShowShortcut = ((bool)(resources.GetObject("menuItem3.ShowShortcut")));
			this.menuItem3.Text = resources.GetString("menuItem3.Text");
			this.menuItem3.Visible = ((bool)(resources.GetObject("menuItem3.Visible")));
			this.menuItem3.Click += new System.EventHandler(this.menuItem3_Click);
			// 
			// button2
			// 
			this.button2.AccessibleDescription = resources.GetString("button2.AccessibleDescription");
			this.button2.AccessibleName = resources.GetString("button2.AccessibleName");
			this.button2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("button2.Anchor")));
			this.button2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("button2.BackgroundImage")));
			this.button2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("button2.Dock")));
			this.button2.Enabled = ((bool)(resources.GetObject("button2.Enabled")));
			this.button2.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("button2.FlatStyle")));
			this.button2.Font = ((System.Drawing.Font)(resources.GetObject("button2.Font")));
			this.button2.Image = ((System.Drawing.Image)(resources.GetObject("button2.Image")));
			this.button2.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button2.ImageAlign")));
			this.button2.ImageIndex = ((int)(resources.GetObject("button2.ImageIndex")));
			this.button2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("button2.ImeMode")));
			this.button2.Location = ((System.Drawing.Point)(resources.GetObject("button2.Location")));
			this.button2.Name = "button2";
			this.button2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("button2.RightToLeft")));
			this.button2.Size = ((System.Drawing.Size)(resources.GetObject("button2.Size")));
			this.button2.TabIndex = ((int)(resources.GetObject("button2.TabIndex")));
			this.button2.Text = resources.GetString("button2.Text");
			this.button2.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button2.TextAlign")));
			this.button2.Visible = ((bool)(resources.GetObject("button2.Visible")));
			this.button2.Click += new System.EventHandler(this.button2_Click);
			// 
			// buttonEliminar
			// 
			this.buttonEliminar.AccessibleDescription = resources.GetString("buttonEliminar.AccessibleDescription");
			this.buttonEliminar.AccessibleName = resources.GetString("buttonEliminar.AccessibleName");
			this.buttonEliminar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonEliminar.Anchor")));
			this.buttonEliminar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonEliminar.BackgroundImage")));
			this.buttonEliminar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonEliminar.Dock")));
			this.buttonEliminar.Enabled = ((bool)(resources.GetObject("buttonEliminar.Enabled")));
			this.buttonEliminar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonEliminar.FlatStyle")));
			this.buttonEliminar.Font = ((System.Drawing.Font)(resources.GetObject("buttonEliminar.Font")));
			this.buttonEliminar.Image = ((System.Drawing.Image)(resources.GetObject("buttonEliminar.Image")));
			this.buttonEliminar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonEliminar.ImageAlign")));
			this.buttonEliminar.ImageIndex = ((int)(resources.GetObject("buttonEliminar.ImageIndex")));
			this.buttonEliminar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonEliminar.ImeMode")));
			this.buttonEliminar.Location = ((System.Drawing.Point)(resources.GetObject("buttonEliminar.Location")));
			this.buttonEliminar.Name = "buttonEliminar";
			this.buttonEliminar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonEliminar.RightToLeft")));
			this.buttonEliminar.Size = ((System.Drawing.Size)(resources.GetObject("buttonEliminar.Size")));
			this.buttonEliminar.TabIndex = ((int)(resources.GetObject("buttonEliminar.TabIndex")));
			this.buttonEliminar.Text = resources.GetString("buttonEliminar.Text");
			this.buttonEliminar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonEliminar.TextAlign")));
			this.buttonEliminar.Visible = ((bool)(resources.GetObject("buttonEliminar.Visible")));
			this.buttonEliminar.Click += new System.EventHandler(this.buttonEliminar_Click);
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
			this.tabControl1.SelectedIndexChanged += new System.EventHandler(this.tabControl1_SelectedIndexChanged);
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
			this.tabPage1.Controls.Add(this.listView1);
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
			this.listView1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listView1.ImeMode")));
			this.listView1.LabelWrap = ((bool)(resources.GetObject("listView1.LabelWrap")));
			this.listView1.Location = ((System.Drawing.Point)(resources.GetObject("listView1.Location")));
			this.listView1.Name = "listView1";
			this.listView1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listView1.RightToLeft")));
			this.listView1.Size = ((System.Drawing.Size)(resources.GetObject("listView1.Size")));
			this.listView1.Sorting = System.Windows.Forms.SortOrder.Ascending;
			this.listView1.TabIndex = ((int)(resources.GetObject("listView1.TabIndex")));
			this.listView1.Text = resources.GetString("listView1.Text");
			this.listView1.View = System.Windows.Forms.View.Details;
			this.listView1.Visible = ((bool)(resources.GetObject("listView1.Visible")));
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
			// tabPage2
			// 
			this.tabPage2.AccessibleDescription = resources.GetString("tabPage2.AccessibleDescription");
			this.tabPage2.AccessibleName = resources.GetString("tabPage2.AccessibleName");
			this.tabPage2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabPage2.Anchor")));
			this.tabPage2.AutoScroll = ((bool)(resources.GetObject("tabPage2.AutoScroll")));
			this.tabPage2.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("tabPage2.AutoScrollMargin")));
			this.tabPage2.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("tabPage2.AutoScrollMinSize")));
			this.tabPage2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabPage2.BackgroundImage")));
			this.tabPage2.Controls.Add(this.listView2);
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
			// listView2
			// 
			this.listView2.AccessibleDescription = resources.GetString("listView2.AccessibleDescription");
			this.listView2.AccessibleName = resources.GetString("listView2.AccessibleName");
			this.listView2.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listView2.Alignment")));
			this.listView2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listView2.Anchor")));
			this.listView2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listView2.BackgroundImage")));
			this.listView2.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																						this.columnHeader5,
																						this.columnHeader6});
			this.listView2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView2.Dock")));
			this.listView2.Enabled = ((bool)(resources.GetObject("listView2.Enabled")));
			this.listView2.Font = ((System.Drawing.Font)(resources.GetObject("listView2.Font")));
			this.listView2.FullRowSelect = true;
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
			this.listView2.SelectedIndexChanged += new System.EventHandler(this.listView2_SelectedIndexChanged);
			// 
			// columnHeader5
			// 
			this.columnHeader5.Text = resources.GetString("columnHeader5.Text");
			this.columnHeader5.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader5.TextAlign")));
			this.columnHeader5.Width = ((int)(resources.GetObject("columnHeader5.Width")));
			// 
			// columnHeader6
			// 
			this.columnHeader6.Text = resources.GetString("columnHeader6.Text");
			this.columnHeader6.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader6.TextAlign")));
			this.columnHeader6.Width = ((int)(resources.GetObject("columnHeader6.Width")));
			// 
			// FrmRuleTopic
			// 
			this.AcceptButton = this.button2;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.button1;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.tabControl1);
			this.Controls.Add(this.buttonEliminar);
			this.Controls.Add(this.button2);
			this.Controls.Add(this.button1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximizeBox = false;
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimizeBox = false;
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmRuleTopic";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.tabControl1.ResumeLayout(false);
			this.tabPage1.ResumeLayout(false);
			this.tabPage2.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void button1_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void listView1_MouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			if(e.Button==System.Windows.Forms.MouseButtons.Right)
			{
				this.contextMenu1.Show(this.listView1,new Point(e.X,e.Y));   
			}
		}

		private void menuItem1_Click(object sender, System.EventArgs e)
		{	
			
			if(this.tabControl1.SelectedIndex==0)
			{
				/*if(!user.GetPermiso(topicmap,topicid,PermisoType.Reglas))
				{
					MessageBox.Show(this,resources.GetString("FrmRuleTopic.m1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					this.Cursor=Cursors.Default;
					return;
				}*/
				this.Cursor=Cursors.WaitCursor;  
				FrmEditRule frm=new FrmEditRule(docrules,user,this.topicmap,this.topicid,this.idcont); 
				frm.ShowDialog(this); 
				this.Refresh();
				this.Cursor=Cursors.WaitCursor;  
				Servicios s=new Servicios(user);
				docrules=s.getRulesContent(this.topicmap,idcont,this.listView1);
				this.Refresh();
				this.Cursor=Cursors.Default;  
			}
			else
			{
				/*if(!user.GetPermiso(topicmap,topicid,PermisoType.Reglas))
				{
					MessageBox.Show(this,resources.GetString("FrmRuleTopic.m1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					this.Cursor=Cursors.Default;
					return;
				}*/
				this.Cursor=Cursors.WaitCursor;  
				FrmEditRole frm=new FrmEditRole(docroles,user,this.topicmap,this.topicid,this.idcont); 
				frm.ShowDialog(this); 
				this.Refresh();
				this.Cursor=Cursors.WaitCursor;  
				Servicios s=new Servicios(user);
				docroles=s.getRolesContent(topicmap,idcont,this.listView2);
				this.Refresh();
				this.Cursor=Cursors.Default; 
			}
		}
		
		
		private void button2_Click(object sender, System.EventArgs e)
		{
			menuItem1_Click(null,null);
		}

		private void listView1_KeyUp(object sender, System.Windows.Forms.KeyEventArgs e)
		{
			
			if(e.KeyCode==System.Windows.Forms.Keys.Delete)
			{
				buttonEliminar_Click(null,null);
			}
		}

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
				this.buttonEliminar.Enabled=true;  
			}
			else
			{
				this.buttonEliminar.Enabled=false;  
			}
		}

		private void buttonEliminar_Click(object sender, System.EventArgs e)
		{
			if(this.tabControl1.SelectedIndex==0)
			{
				/*if(!user.GetPermiso(topicmap,topicid,PermisoType.Reglas))
				{
					MessageBox.Show(this,resources.GetString("FrmRuleTopic.m1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					this.Cursor=Cursors.Default;
					return;
				}*/
				if(this.listView1.SelectedItems.Count>0)
				{
					if(MessageBox.Show(this,resources.GetString("FrmRuleTopic.m2"),this.Text,MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.No)
					{
						return;
					}
					this.Cursor=Cursors.WaitCursor;  
					foreach(ListViewItem item in this.listView1.SelectedItems)
					{
						ParameterCollection parametros= new ParameterCollection(); 
						parametros.Add(new Parameter("topicmap",this.topicmap));   					
						parametros.Add(new Parameter("id",idcont));   					
						parametros.Add(new Parameter("ruleid",item.SubItems[0].Text));   					
						Servicios s= new Servicios(user);
						s.removeRules(parametros);  
					}
					Servicios servicios=new Servicios(user);
					docrules=servicios.getRulesContent(this.topicmap,idcont,this.listView1);
					this.Cursor=Cursors.Default;  
				}
				listView1_SelectedIndexChanged(null,null);
			}
			else
			{
				/*if(!user.GetPermiso(topicmap,topicid,PermisoType.Reglas))
				{
					MessageBox.Show(this,resources.GetString("FrmRuleTopic.m1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					this.Cursor=Cursors.Default;
					return;
				}*/
				if(this.listView2.SelectedItems.Count>0)
				{
					if(MessageBox.Show(this,resources.GetString("FrmRuleTopic.m3"),this.Text,MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.No)
					{
						return;
					}
					this.Cursor=Cursors.WaitCursor;  
					foreach(ListViewItem item in this.listView2.SelectedItems)
					{
						ParameterCollection parametros= new ParameterCollection(); 
						parametros.Add(new Parameter("topicmap",this.topicmap));   					
						parametros.Add(new Parameter("id",idcont));   					
						parametros.Add(new Parameter("roleid",item.SubItems[0].Text));   					
						Servicios s= new Servicios(user);
						s.removeRoles(parametros);  
					}
					Servicios servicios=new Servicios(user);
					docrules=servicios.getRolesContent(this.topicmap,idcont,this.listView2);
					this.Cursor=Cursors.Default;  
				}
				listView2_SelectedIndexChanged(null,null);
			}
			
		}

		private void menuItem3_Click(object sender, System.EventArgs e)
		{
			buttonEliminar_Click(null,null);
		}

		private void listView2_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			if(this.listView2.SelectedItems.Count>0)
			{
				this.buttonEliminar.Enabled=true;  
			}
			else
			{
				this.buttonEliminar.Enabled=false;  
			}
		}

		private void tabControl1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			this.buttonEliminar.Enabled=false;  
			if(this.tabControl1.SelectedIndex==0)
			{
				if(this.listView1.SelectedItems.Count>0)
				{
					this.buttonEliminar.Enabled=true;  
				}
			}
			else
			{
				if(this.listView2.SelectedItems.Count>0)
				{
					this.buttonEliminar.Enabled=true;  
				}
			}
		}
	}
}
