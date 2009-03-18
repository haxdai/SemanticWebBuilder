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
using System.Xml;
using WBOffice3;
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>Clase que muestra los contenidos en flujo</summary>
	public class FrmDocFlow : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.MainMenu mainMenu1;
		
		private System.Windows.Forms.StatusBar statusBar1;
		
		/// <summary>
		/// Required designer variable.
		/// </summary>
		/// 
		
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.ListView listView1;
		private System.Windows.Forms.ColumnHeader columnHeader1;
		private System.Windows.Forms.ColumnHeader columnHeader2;
		private System.Windows.Forms.ColumnHeader columnHeader3;
		private System.Windows.Forms.ColumnHeader columnHeader4;
		private System.Windows.Forms.RadioButton radioButton2;
		private System.Windows.Forms.RadioButton radioButton1;

		private ColumnSorter TheColumnSorter = new ColumnSorter();
		private System.Windows.Forms.MenuItem menuItem8;
		private System.Windows.Forms.MenuItem menuItem9;
		private System.Windows.Forms.MenuItem menuItem10;
		private System.Windows.Forms.MenuItem menuItem11;
		private System.Windows.Forms.MenuItem menuFlujo;
		private System.Windows.Forms.MenuItem menuPreview;
		private System.Windows.Forms.MenuItem menuPropiedades;
		private System.Windows.Forms.MenuItem menuItem15;
		private System.Windows.Forms.MenuItem menuAutorizar;
		private System.Windows.Forms.MenuItem menuRechazar;
		private System.Windows.Forms.MenuItem menuPublicar;
		private System.Windows.Forms.MenuItem menuItem19;
		private System.Windows.Forms.MenuItem menuCerrar;
		private System.Windows.Forms.RadioButton radioButton3;
		private System.Windows.Forms.ColumnHeader columnHeader5;
		ColumnSorter colum= new ColumnSorter();
		CUserAdmin user;
		private System.Windows.Forms.ComboBox comboBox1;
		System.Collections.Hashtable flujoscol=new Hashtable(); 
		String type;
		/// <summary>
		/// Constructor para una forma de documentos por autorizar
		/// </summary>
		/// <param name="user">Usuario de accede</param>
		/// <param name="type">Type de presentación de la forma</param>
		public FrmDocFlow(CUserAdmin user,String type)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.type=type;
			this.user=user;
			this.listView1.ListViewItemSorter=colum;  
			this.menuAutorizar.Enabled=false;  
			this.menuRechazar.Enabled=false;  
			this.user=user;						
			this.listView1.Items.Clear();
			if(user.Type==0)
			{
				this.radioButton1.Enabled=true;  
			}
			else
			{
				this.radioButton1.Enabled=false;
			}
			radioButton3_CheckedChanged(null,null);
			this.menuPublicar.Enabled=false; 
			this.menuAutorizar.Enabled=false;							
			this.menuRechazar.Enabled=false; 
 		    this.menuPreview.Enabled=false; 
			this.menuPropiedades.Enabled=false;
			Servicios s=new Servicios(this.user);
			this.comboBox1.Items.Clear();
			foreach(XmlElement map in s.getTopicMaps().GetElementsByTagName("topicmap"))
			{
				CCaracteristica c=new CCaracteristica(map.GetAttribute("name"),map.GetAttribute("id"));
				this.comboBox1.Items.Add(c);
			}
			if(this.comboBox1.Items.Count>0)
			{
				this.comboBox1.SelectedIndex=0;
			}
			//comboBox1_SelectedIndexChanged(null,null);

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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmDocFlow));
			this.mainMenu1 = new System.Windows.Forms.MainMenu();
			this.menuFlujo = new System.Windows.Forms.MenuItem();
			this.menuPreview = new System.Windows.Forms.MenuItem();
			this.menuPropiedades = new System.Windows.Forms.MenuItem();
			this.menuItem15 = new System.Windows.Forms.MenuItem();
			this.menuAutorizar = new System.Windows.Forms.MenuItem();
			this.menuRechazar = new System.Windows.Forms.MenuItem();
			this.menuPublicar = new System.Windows.Forms.MenuItem();
			this.menuItem19 = new System.Windows.Forms.MenuItem();
			this.menuCerrar = new System.Windows.Forms.MenuItem();
			this.menuItem11 = new System.Windows.Forms.MenuItem();
			this.menuItem10 = new System.Windows.Forms.MenuItem();
			this.menuItem8 = new System.Windows.Forms.MenuItem();
			this.menuItem9 = new System.Windows.Forms.MenuItem();
			this.statusBar1 = new System.Windows.Forms.StatusBar();
			this.panel1 = new System.Windows.Forms.Panel();
			this.comboBox1 = new System.Windows.Forms.ComboBox();
			this.radioButton3 = new System.Windows.Forms.RadioButton();
			this.radioButton2 = new System.Windows.Forms.RadioButton();
			this.radioButton1 = new System.Windows.Forms.RadioButton();
			this.listView1 = new System.Windows.Forms.ListView();
			this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader2 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader5 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader3 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader4 = new System.Windows.Forms.ColumnHeader();
			this.panel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// mainMenu1
			// 
			this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.menuFlujo});
			this.mainMenu1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("mainMenu1.RightToLeft")));
			// 
			// menuFlujo
			// 
			this.menuFlujo.Enabled = ((bool)(resources.GetObject("menuFlujo.Enabled")));
			this.menuFlujo.Index = 0;
			this.menuFlujo.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.menuPreview,
																					  this.menuPropiedades,
																					  this.menuItem15,
																					  this.menuAutorizar,
																					  this.menuRechazar,
																					  this.menuPublicar,
																					  this.menuItem19,
																					  this.menuCerrar});
			this.menuFlujo.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuFlujo.Shortcut")));
			this.menuFlujo.ShowShortcut = ((bool)(resources.GetObject("menuFlujo.ShowShortcut")));
			this.menuFlujo.Text = resources.GetString("menuFlujo.Text");
			this.menuFlujo.Visible = ((bool)(resources.GetObject("menuFlujo.Visible")));
			// 
			// menuPreview
			// 
			this.menuPreview.Enabled = ((bool)(resources.GetObject("menuPreview.Enabled")));
			this.menuPreview.Index = 0;
			this.menuPreview.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuPreview.Shortcut")));
			this.menuPreview.ShowShortcut = ((bool)(resources.GetObject("menuPreview.ShowShortcut")));
			this.menuPreview.Text = resources.GetString("menuPreview.Text");
			this.menuPreview.Visible = ((bool)(resources.GetObject("menuPreview.Visible")));
			this.menuPreview.Click += new System.EventHandler(this.menuPreview_Click);
			// 
			// menuPropiedades
			// 
			this.menuPropiedades.Enabled = ((bool)(resources.GetObject("menuPropiedades.Enabled")));
			this.menuPropiedades.Index = 1;
			this.menuPropiedades.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuPropiedades.Shortcut")));
			this.menuPropiedades.ShowShortcut = ((bool)(resources.GetObject("menuPropiedades.ShowShortcut")));
			this.menuPropiedades.Text = resources.GetString("menuPropiedades.Text");
			this.menuPropiedades.Visible = ((bool)(resources.GetObject("menuPropiedades.Visible")));
			this.menuPropiedades.Click += new System.EventHandler(this.menuPropiedades_Click);
			// 
			// menuItem15
			// 
			this.menuItem15.Enabled = ((bool)(resources.GetObject("menuItem15.Enabled")));
			this.menuItem15.Index = 2;
			this.menuItem15.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem15.Shortcut")));
			this.menuItem15.ShowShortcut = ((bool)(resources.GetObject("menuItem15.ShowShortcut")));
			this.menuItem15.Text = resources.GetString("menuItem15.Text");
			this.menuItem15.Visible = ((bool)(resources.GetObject("menuItem15.Visible")));
			// 
			// menuAutorizar
			// 
			this.menuAutorizar.Enabled = ((bool)(resources.GetObject("menuAutorizar.Enabled")));
			this.menuAutorizar.Index = 3;
			this.menuAutorizar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuAutorizar.Shortcut")));
			this.menuAutorizar.ShowShortcut = ((bool)(resources.GetObject("menuAutorizar.ShowShortcut")));
			this.menuAutorizar.Text = resources.GetString("menuAutorizar.Text");
			this.menuAutorizar.Visible = ((bool)(resources.GetObject("menuAutorizar.Visible")));
			this.menuAutorizar.Click += new System.EventHandler(this.menuAutorizar_Click);
			// 
			// menuRechazar
			// 
			this.menuRechazar.Enabled = ((bool)(resources.GetObject("menuRechazar.Enabled")));
			this.menuRechazar.Index = 4;
			this.menuRechazar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuRechazar.Shortcut")));
			this.menuRechazar.ShowShortcut = ((bool)(resources.GetObject("menuRechazar.ShowShortcut")));
			this.menuRechazar.Text = resources.GetString("menuRechazar.Text");
			this.menuRechazar.Visible = ((bool)(resources.GetObject("menuRechazar.Visible")));
			this.menuRechazar.Click += new System.EventHandler(this.menuRechazar_Click);
			// 
			// menuPublicar
			// 
			this.menuPublicar.Enabled = ((bool)(resources.GetObject("menuPublicar.Enabled")));
			this.menuPublicar.Index = 5;
			this.menuPublicar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuPublicar.Shortcut")));
			this.menuPublicar.ShowShortcut = ((bool)(resources.GetObject("menuPublicar.ShowShortcut")));
			this.menuPublicar.Text = resources.GetString("menuPublicar.Text");
			this.menuPublicar.Visible = ((bool)(resources.GetObject("menuPublicar.Visible")));
			this.menuPublicar.Click += new System.EventHandler(this.menuPublicar_Click);
			// 
			// menuItem19
			// 
			this.menuItem19.Enabled = ((bool)(resources.GetObject("menuItem19.Enabled")));
			this.menuItem19.Index = 6;
			this.menuItem19.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem19.Shortcut")));
			this.menuItem19.ShowShortcut = ((bool)(resources.GetObject("menuItem19.ShowShortcut")));
			this.menuItem19.Text = resources.GetString("menuItem19.Text");
			this.menuItem19.Visible = ((bool)(resources.GetObject("menuItem19.Visible")));
			// 
			// menuCerrar
			// 
			this.menuCerrar.Enabled = ((bool)(resources.GetObject("menuCerrar.Enabled")));
			this.menuCerrar.Index = 7;
			this.menuCerrar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuCerrar.Shortcut")));
			this.menuCerrar.ShowShortcut = ((bool)(resources.GetObject("menuCerrar.ShowShortcut")));
			this.menuCerrar.Text = resources.GetString("menuCerrar.Text");
			this.menuCerrar.Visible = ((bool)(resources.GetObject("menuCerrar.Visible")));
			this.menuCerrar.Click += new System.EventHandler(this.menuCerrar_Click);
			// 
			// menuItem11
			// 
			this.menuItem11.Enabled = ((bool)(resources.GetObject("menuItem11.Enabled")));
			this.menuItem11.Index = -1;
			this.menuItem11.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem11.Shortcut")));
			this.menuItem11.ShowShortcut = ((bool)(resources.GetObject("menuItem11.ShowShortcut")));
			this.menuItem11.Text = resources.GetString("menuItem11.Text");
			this.menuItem11.Visible = ((bool)(resources.GetObject("menuItem11.Visible")));
			// 
			// menuItem10
			// 
			this.menuItem10.Enabled = ((bool)(resources.GetObject("menuItem10.Enabled")));
			this.menuItem10.Index = -1;
			this.menuItem10.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem10.Shortcut")));
			this.menuItem10.ShowShortcut = ((bool)(resources.GetObject("menuItem10.ShowShortcut")));
			this.menuItem10.Text = resources.GetString("menuItem10.Text");
			this.menuItem10.Visible = ((bool)(resources.GetObject("menuItem10.Visible")));
			// 
			// menuItem8
			// 
			this.menuItem8.Enabled = ((bool)(resources.GetObject("menuItem8.Enabled")));
			this.menuItem8.Index = -1;
			this.menuItem8.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem8.Shortcut")));
			this.menuItem8.ShowShortcut = ((bool)(resources.GetObject("menuItem8.ShowShortcut")));
			this.menuItem8.Text = resources.GetString("menuItem8.Text");
			this.menuItem8.Visible = ((bool)(resources.GetObject("menuItem8.Visible")));
			// 
			// menuItem9
			// 
			this.menuItem9.Enabled = ((bool)(resources.GetObject("menuItem9.Enabled")));
			this.menuItem9.Index = -1;
			this.menuItem9.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem9.Shortcut")));
			this.menuItem9.ShowShortcut = ((bool)(resources.GetObject("menuItem9.ShowShortcut")));
			this.menuItem9.Text = resources.GetString("menuItem9.Text");
			this.menuItem9.Visible = ((bool)(resources.GetObject("menuItem9.Visible")));
			// 
			// statusBar1
			// 
			this.statusBar1.AccessibleDescription = resources.GetString("statusBar1.AccessibleDescription");
			this.statusBar1.AccessibleName = resources.GetString("statusBar1.AccessibleName");
			this.statusBar1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("statusBar1.Anchor")));
			this.statusBar1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("statusBar1.BackgroundImage")));
			this.statusBar1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("statusBar1.Dock")));
			this.statusBar1.Enabled = ((bool)(resources.GetObject("statusBar1.Enabled")));
			this.statusBar1.Font = ((System.Drawing.Font)(resources.GetObject("statusBar1.Font")));
			this.statusBar1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("statusBar1.ImeMode")));
			this.statusBar1.Location = ((System.Drawing.Point)(resources.GetObject("statusBar1.Location")));
			this.statusBar1.Name = "statusBar1";
			this.statusBar1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("statusBar1.RightToLeft")));
			this.statusBar1.ShowPanels = true;
			this.statusBar1.Size = ((System.Drawing.Size)(resources.GetObject("statusBar1.Size")));
			this.statusBar1.TabIndex = ((int)(resources.GetObject("statusBar1.TabIndex")));
			this.statusBar1.Text = resources.GetString("statusBar1.Text");
			this.statusBar1.Visible = ((bool)(resources.GetObject("statusBar1.Visible")));
			// 
			// panel1
			// 
			this.panel1.AccessibleDescription = resources.GetString("panel1.AccessibleDescription");
			this.panel1.AccessibleName = resources.GetString("panel1.AccessibleName");
			this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("panel1.Anchor")));
			this.panel1.AutoScroll = ((bool)(resources.GetObject("panel1.AutoScroll")));
			this.panel1.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("panel1.AutoScrollMargin")));
			this.panel1.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("panel1.AutoScrollMinSize")));
			this.panel1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panel1.BackgroundImage")));
			this.panel1.Controls.Add(this.comboBox1);
			this.panel1.Controls.Add(this.radioButton3);
			this.panel1.Controls.Add(this.radioButton2);
			this.panel1.Controls.Add(this.radioButton1);
			this.panel1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("panel1.Dock")));
			this.panel1.Enabled = ((bool)(resources.GetObject("panel1.Enabled")));
			this.panel1.Font = ((System.Drawing.Font)(resources.GetObject("panel1.Font")));
			this.panel1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("panel1.ImeMode")));
			this.panel1.Location = ((System.Drawing.Point)(resources.GetObject("panel1.Location")));
			this.panel1.Name = "panel1";
			this.panel1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("panel1.RightToLeft")));
			this.panel1.Size = ((System.Drawing.Size)(resources.GetObject("panel1.Size")));
			this.panel1.TabIndex = ((int)(resources.GetObject("panel1.TabIndex")));
			this.panel1.Text = resources.GetString("panel1.Text");
			this.panel1.Visible = ((bool)(resources.GetObject("panel1.Visible")));
			// 
			// comboBox1
			// 
			this.comboBox1.AccessibleDescription = resources.GetString("comboBox1.AccessibleDescription");
			this.comboBox1.AccessibleName = resources.GetString("comboBox1.AccessibleName");
			this.comboBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("comboBox1.Anchor")));
			this.comboBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("comboBox1.BackgroundImage")));
			this.comboBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("comboBox1.Dock")));
			this.comboBox1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.comboBox1.Enabled = ((bool)(resources.GetObject("comboBox1.Enabled")));
			this.comboBox1.Font = ((System.Drawing.Font)(resources.GetObject("comboBox1.Font")));
			this.comboBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("comboBox1.ImeMode")));
			this.comboBox1.IntegralHeight = ((bool)(resources.GetObject("comboBox1.IntegralHeight")));
			this.comboBox1.ItemHeight = ((int)(resources.GetObject("comboBox1.ItemHeight")));
			this.comboBox1.Location = ((System.Drawing.Point)(resources.GetObject("comboBox1.Location")));
			this.comboBox1.MaxDropDownItems = ((int)(resources.GetObject("comboBox1.MaxDropDownItems")));
			this.comboBox1.MaxLength = ((int)(resources.GetObject("comboBox1.MaxLength")));
			this.comboBox1.Name = "comboBox1";
			this.comboBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("comboBox1.RightToLeft")));
			this.comboBox1.Size = ((System.Drawing.Size)(resources.GetObject("comboBox1.Size")));
			this.comboBox1.TabIndex = ((int)(resources.GetObject("comboBox1.TabIndex")));
			this.comboBox1.Text = resources.GetString("comboBox1.Text");
			this.comboBox1.Visible = ((bool)(resources.GetObject("comboBox1.Visible")));
			this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
			// 
			// radioButton3
			// 
			this.radioButton3.AccessibleDescription = resources.GetString("radioButton3.AccessibleDescription");
			this.radioButton3.AccessibleName = resources.GetString("radioButton3.AccessibleName");
			this.radioButton3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButton3.Anchor")));
			this.radioButton3.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButton3.Appearance")));
			this.radioButton3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButton3.BackgroundImage")));
			this.radioButton3.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton3.CheckAlign")));
			this.radioButton3.Checked = true;
			this.radioButton3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButton3.Dock")));
			this.radioButton3.Enabled = ((bool)(resources.GetObject("radioButton3.Enabled")));
			this.radioButton3.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButton3.FlatStyle")));
			this.radioButton3.Font = ((System.Drawing.Font)(resources.GetObject("radioButton3.Font")));
			this.radioButton3.Image = ((System.Drawing.Image)(resources.GetObject("radioButton3.Image")));
			this.radioButton3.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton3.ImageAlign")));
			this.radioButton3.ImageIndex = ((int)(resources.GetObject("radioButton3.ImageIndex")));
			this.radioButton3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButton3.ImeMode")));
			this.radioButton3.Location = ((System.Drawing.Point)(resources.GetObject("radioButton3.Location")));
			this.radioButton3.Name = "radioButton3";
			this.radioButton3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButton3.RightToLeft")));
			this.radioButton3.Size = ((System.Drawing.Size)(resources.GetObject("radioButton3.Size")));
			this.radioButton3.TabIndex = ((int)(resources.GetObject("radioButton3.TabIndex")));
			this.radioButton3.TabStop = true;
			this.radioButton3.Text = resources.GetString("radioButton3.Text");
			this.radioButton3.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton3.TextAlign")));
			this.radioButton3.Visible = ((bool)(resources.GetObject("radioButton3.Visible")));
			this.radioButton3.CheckedChanged += new System.EventHandler(this.radioButton3_CheckedChanged);
			// 
			// radioButton2
			// 
			this.radioButton2.AccessibleDescription = resources.GetString("radioButton2.AccessibleDescription");
			this.radioButton2.AccessibleName = resources.GetString("radioButton2.AccessibleName");
			this.radioButton2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButton2.Anchor")));
			this.radioButton2.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButton2.Appearance")));
			this.radioButton2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButton2.BackgroundImage")));
			this.radioButton2.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton2.CheckAlign")));
			this.radioButton2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButton2.Dock")));
			this.radioButton2.Enabled = ((bool)(resources.GetObject("radioButton2.Enabled")));
			this.radioButton2.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButton2.FlatStyle")));
			this.radioButton2.Font = ((System.Drawing.Font)(resources.GetObject("radioButton2.Font")));
			this.radioButton2.Image = ((System.Drawing.Image)(resources.GetObject("radioButton2.Image")));
			this.radioButton2.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton2.ImageAlign")));
			this.radioButton2.ImageIndex = ((int)(resources.GetObject("radioButton2.ImageIndex")));
			this.radioButton2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButton2.ImeMode")));
			this.radioButton2.Location = ((System.Drawing.Point)(resources.GetObject("radioButton2.Location")));
			this.radioButton2.Name = "radioButton2";
			this.radioButton2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButton2.RightToLeft")));
			this.radioButton2.Size = ((System.Drawing.Size)(resources.GetObject("radioButton2.Size")));
			this.radioButton2.TabIndex = ((int)(resources.GetObject("radioButton2.TabIndex")));
			this.radioButton2.Text = resources.GetString("radioButton2.Text");
			this.radioButton2.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton2.TextAlign")));
			this.radioButton2.Visible = ((bool)(resources.GetObject("radioButton2.Visible")));
			this.radioButton2.CheckedChanged += new System.EventHandler(this.radioButton2_CheckedChanged);
			// 
			// radioButton1
			// 
			this.radioButton1.AccessibleDescription = resources.GetString("radioButton1.AccessibleDescription");
			this.radioButton1.AccessibleName = resources.GetString("radioButton1.AccessibleName");
			this.radioButton1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButton1.Anchor")));
			this.radioButton1.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButton1.Appearance")));
			this.radioButton1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButton1.BackgroundImage")));
			this.radioButton1.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton1.CheckAlign")));
			this.radioButton1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButton1.Dock")));
			this.radioButton1.Enabled = ((bool)(resources.GetObject("radioButton1.Enabled")));
			this.radioButton1.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButton1.FlatStyle")));
			this.radioButton1.Font = ((System.Drawing.Font)(resources.GetObject("radioButton1.Font")));
			this.radioButton1.Image = ((System.Drawing.Image)(resources.GetObject("radioButton1.Image")));
			this.radioButton1.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton1.ImageAlign")));
			this.radioButton1.ImageIndex = ((int)(resources.GetObject("radioButton1.ImageIndex")));
			this.radioButton1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButton1.ImeMode")));
			this.radioButton1.Location = ((System.Drawing.Point)(resources.GetObject("radioButton1.Location")));
			this.radioButton1.Name = "radioButton1";
			this.radioButton1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButton1.RightToLeft")));
			this.radioButton1.Size = ((System.Drawing.Size)(resources.GetObject("radioButton1.Size")));
			this.radioButton1.TabIndex = ((int)(resources.GetObject("radioButton1.TabIndex")));
			this.radioButton1.Text = resources.GetString("radioButton1.Text");
			this.radioButton1.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButton1.TextAlign")));
			this.radioButton1.Visible = ((bool)(resources.GetObject("radioButton1.Visible")));
			this.radioButton1.CheckedChanged += new System.EventHandler(this.radioButton1_CheckedChanged);
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
																						this.columnHeader5,
																						this.columnHeader3,
																						this.columnHeader4});
			this.listView1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView1.Dock")));
			this.listView1.Enabled = ((bool)(resources.GetObject("listView1.Enabled")));
			this.listView1.Font = ((System.Drawing.Font)(resources.GetObject("listView1.Font")));
			this.listView1.FullRowSelect = true;
			this.listView1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listView1.ImeMode")));
			this.listView1.LabelWrap = ((bool)(resources.GetObject("listView1.LabelWrap")));
			this.listView1.Location = ((System.Drawing.Point)(resources.GetObject("listView1.Location")));
			this.listView1.MultiSelect = false;
			this.listView1.Name = "listView1";
			this.listView1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listView1.RightToLeft")));
			this.listView1.Size = ((System.Drawing.Size)(resources.GetObject("listView1.Size")));
			this.listView1.TabIndex = ((int)(resources.GetObject("listView1.TabIndex")));
			this.listView1.Text = resources.GetString("listView1.Text");
			this.listView1.View = System.Windows.Forms.View.Details;
			this.listView1.Visible = ((bool)(resources.GetObject("listView1.Visible")));
			this.listView1.Click += new System.EventHandler(this.listView1_Click);
			this.listView1.ColumnClick += new System.Windows.Forms.ColumnClickEventHandler(this.listView1_ColumnClick);
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
			// columnHeader5
			// 
			this.columnHeader5.Text = resources.GetString("columnHeader5.Text");
			this.columnHeader5.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader5.TextAlign")));
			this.columnHeader5.Width = ((int)(resources.GetObject("columnHeader5.Width")));
			// 
			// columnHeader3
			// 
			this.columnHeader3.Text = resources.GetString("columnHeader3.Text");
			this.columnHeader3.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader3.TextAlign")));
			this.columnHeader3.Width = ((int)(resources.GetObject("columnHeader3.Width")));
			// 
			// columnHeader4
			// 
			this.columnHeader4.Text = resources.GetString("columnHeader4.Text");
			this.columnHeader4.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader4.TextAlign")));
			this.columnHeader4.Width = ((int)(resources.GetObject("columnHeader4.Width")));
			// 
			// FrmDocFlow
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.listView1);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.statusBar1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximizeBox = false;
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.Menu = this.mainMenu1;
			this.MinimizeBox = false;
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmDocFlow";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.panel1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		

		

		private void radioButton2_CheckedChanged(object sender, System.EventArgs e)
		{	
			if(radioButton2.Checked)
			{
				if(this.comboBox1.Items.Count==0)
				{
					this.listView1.Items.Clear();  
					return;
				}
				CCaracteristica c=(CCaracteristica)this.comboBox1.SelectedItem;
				String topicmap=c.Name;
				MessageBox.Show(this,resources.GetString("FrmDocFlow.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
				this.Cursor=Cursors.WaitCursor; 
				this.listView1.Items.Clear();  
				flujoscol= new Hashtable();
				Servicios s= new Servicios(user);
				System.Xml.XmlNodeList contenidos=s.getContentinFlowUser(topicmap).GetElementsByTagName("Content"); 
				foreach(System.Xml.XmlElement contenido in contenidos)
				{					
					String id=contenido.GetAttribute("id");					
					String topic=contenido.GetAttribute("topic");
					String title=contenido.GetAttribute("title");
					String idflujo=contenido.GetAttribute("flowid");
					String activity=contenido.GetAttribute("activity");
					String flowname=contenido.GetAttribute("flowname");					
					String occurrenceid=contenido.GetAttribute("occurrence");

					// 0=no enviado ,1=en revisión, 2=terminado 3=rechazado
					String idestado=contenido.GetAttribute("status");
					String estado="";
					if(idestado.Equals("0"))
					{
						estado=resources.GetString("FrmDocFlow.t1");
					}
					else if(idestado.Equals("1"))
					{
						estado=resources.GetString("FrmDocFlow.t1");
					}
					else if(idestado.Equals("2"))
					{
						estado=resources.GetString("FrmDocFlow.t3");
					}
					else if(idestado.Equals("3"))
					{
						estado=resources.GetString("FrmDocFlow.t2");
					}
					string[] sitem=new string[5];
					sitem[0]=id;
					sitem[1]=title;
					sitem[2]=flowname;
					sitem[3]=activity;
					sitem[4]=estado;
					CWBListViewItem citem=new CWBListViewItem();
					citem.TopicMap=topicmap;
					citem.Topic=topic;
					citem.Flow=idflujo;
					citem.Paso=activity;
					citem.XMLContent=contenido;					
					citem.Occurrence=occurrenceid;
					ListViewItem item=this.listView1.Items.Add(new ListViewItem(sitem));   
					item.ImageIndex=0;
					item.Tag=citem;
				}
				this.Cursor=Cursors.Default;
			}
		}
		/// <summary>Funciión que permite aprobar o rechazar un contenido</summary>
		/// <param name="newstep">Nuevo paso del contenido</param>
		/// <param name="autorizar">Si autoriza o rechaza</param>
		/// <param name="comentario">Comentario de aprobación o rechazado</param>
		/// <param name="namestep">Nombre del paso actual</param>
		public void CambiarEstado(String newstep,bool autorizar,String comentario,String namestep)
		{
			if(this.listView1.SelectedItems.Count>0)
			{
				CWBListViewItem citem=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				String idcont=this.listView1.SelectedItems[0].Text;  				
				Servicios s= new Servicios(user); 
				if(autorizar)
				{
					s.acceptFlow(citem.TopicMap,citem.Topic,idcont);
				}
				else
				{					
					s.rejectFlow(citem.TopicMap,citem.Topic,idcont,comentario);
				}
				if(!s.IsError)
				{
					if(autorizar)
					{
						MessageBox.Show(this,resources.GetString("FrmDocFlow.msg2") +" "+ namestep +"",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
					}
					else
					{
						MessageBox.Show(this,resources.GetString("FrmDocFlow.msg2")+" "+ namestep +"",this.Text ,MessageBoxButtons.OK,MessageBoxIcon.Information);  
					}
					this.listView1.Items.Clear();
					if(this.radioButton1.Checked)
					{
						radioButton1_CheckedChanged(null,null); 
					}
					else if(this.radioButton2.Checked)
					{
						radioButton2_CheckedChanged(null,null); 
					}
					else
					{
						radioButton3_CheckedChanged(null,null); 
					}
				}
			}
		}

		private void radioButton1_CheckedChanged(object sender, System.EventArgs e)
		{			
			if(this.radioButton1.Checked)
			{
				if(this.comboBox1.Items.Count==0)
				{
					this.listView1.Items.Clear();  
					return;
				}
				CCaracteristica c=(CCaracteristica)this.comboBox1.SelectedItem;
				String topicmap=c.Name;
				MessageBox.Show(this,resources.GetString("FrmDocFlow.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
				this.Cursor=Cursors.WaitCursor; 
				this.listView1.Items.Clear();  
				flujoscol= new Hashtable();
				Servicios s= new Servicios(user);
				System.Xml.XmlNodeList contenidos=s.getContentinFlow(topicmap).GetElementsByTagName("Content"); 
				foreach(System.Xml.XmlElement contenido in contenidos)
				{					
					String id=contenido.GetAttribute("id");					
					String topic=contenido.GetAttribute("topic");
					String title=contenido.GetAttribute("title");
					String idflujo=contenido.GetAttribute("flowid");
					String activity=contenido.GetAttribute("activity");
					String flowname=contenido.GetAttribute("flowname");					
					String occurrenceid=contenido.GetAttribute("occurrence");

					// 0=no enviado ,1=en revisión, 2=terminado 3=rechazado
					String idestado=contenido.GetAttribute("status");
					String estado="";
					if(idestado.Equals("0"))
					{
						estado=resources.GetString("FrmDocFlow.t1");
					}
					else if(idestado.Equals("1"))
					{
						estado=resources.GetString("FrmDocFlow.t1");
					}
					else if(idestado.Equals("2"))
					{
						estado=resources.GetString("FrmDocFlow.t3");
					}
					else if(idestado.Equals("3"))
					{
						estado=resources.GetString("FrmDocFlow.t2");
					}
					string[] sitem=new string[5];
					sitem[0]=id;
					sitem[1]=title;
					sitem[2]=flowname;
					sitem[3]=activity;
					sitem[4]=estado;
					CWBListViewItem citem=new CWBListViewItem();
					citem.TopicMap=topicmap;
					citem.Topic=topic;
					citem.Flow=idflujo;
					citem.Paso=activity;
					citem.XMLContent=contenido;					
					citem.Occurrence=occurrenceid;
					ListViewItem item=this.listView1.Items.Add(new ListViewItem(sitem));   
					item.ImageIndex=0;
					item.Tag=citem;
				}
				this.Cursor=Cursors.Default;
			}
		}

		private void menuPreview_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{
				CWBListViewItem citem=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;								
				try
				{
					Servicios s=new Servicios(this.user);
					XmlDocument doc=s.getContentAtt(citem.TopicMap,citem.Topic,this.listView1.SelectedItems[0].Text);
					if(doc.GetElementsByTagName("lastversion").Count>0)
					{
						FrmPreview frm=new FrmPreview(citem.TopicMap,citem.Topic,this.listView1.SelectedItems[0].Text,doc.GetElementsByTagName("lastversion")[0].InnerText,this.user);				
						this.Cursor=Cursors.WaitCursor;					
						frm.Text=resources.GetString("FrmDocFlow.t4");
						this.Cursor=Cursors.Default;
						frm.ShowDialog(this);
					}
				}
				catch(Exception ue)
				{
					Debug.WriteLine(ue.Message);
				}
			}
		
		}

		private void menuAutorizar_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{		
				this.Cursor=Cursors.WaitCursor;				
				CWBListViewItem citem=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				Servicios s=new Servicios(this.user);
				
				if(!s.isReviewer(citem.TopicMap,citem.Topic,citem.Occurrence))
				{
					MessageBox.Show(this,resources.GetString("FrmDocFlow.msg4") +" "+this.listView1.SelectedItems[0].SubItems[3].Text +" "+ resources.GetString("FrmDocFlow.msg5") +"",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return;
				}
				CWBListViewItem item=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				String paso=item.Paso;
				
				s=new Servicios(this.user);
				String message=null;
				if(MessageBox.Show(this,resources.GetString("FrmProp.mandarmensaje"),resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question)==DialogResult.Yes)
				{
					FrmAutoriza frm=new FrmAutoriza();
					frm.label1.Visible=false;
					if(frm.ShowDialog(this)==DialogResult.OK)
					{
						message=frm.txtconment.Text;
					}
				
				}
				if(message==null)
				{
					s.acceptFlow(citem.TopicMap,citem.Topic,citem.Occurrence);
				}
				else
				{
					s.acceptFlow(citem.TopicMap,citem.Topic,citem.Occurrence,message);
				}
				if(!s.IsError)
				{					
					MessageBox.Show(this,resources.GetString("FrmDocFlow.m1")+" '"+ citem.Paso +"'",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  						
					this.comboBox1_SelectedIndexChanged(null,null);
				}
				this.Cursor=Cursors.Default;
			}
		}

		private void menuCerrar_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void menuPropiedades_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{
				CWBListViewItem item=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				String topicmap=item.TopicMap;
				String topicid=item.Topic;
				String idcont=this.listView1.SelectedItems[0].SubItems[0].Text;
				this.Cursor=Cursors.WaitCursor;
				FrmProp frm=new FrmProp(topicmap,topicid,idcont,user,this.type); 
				this.Cursor=Cursors.Default;
				frm.ShowDialog(this); 
			}
		}

		private void menuRechazar_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{				
				CWBListViewItem citem=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				Servicios s=new Servicios(this.user);
				
				if(!s.isReviewer(citem.TopicMap,citem.Topic,citem.Occurrence))
				{
					MessageBox.Show(this,resources.GetString("FrmDocFlow.msg4") +" "+this.listView1.SelectedItems[0].SubItems[3].Text +" "+ resources.GetString("FrmDocFlow.msg5") +"",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return;
				}
				CWBListViewItem item=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				String paso=item.Paso;
				this.Cursor=Cursors.WaitCursor;			
				FrmAutoriza frm=new FrmAutoriza();
				if(frm.ShowDialog(this)==DialogResult.Cancel)
				{
					this.Cursor=Cursors.Default;
					return;
				}
				s=new Servicios(this.user);
				s.rejectFlow(citem.TopicMap,citem.Topic,citem.Occurrence,frm.txtconment.Text);
				if(!s.IsError)
				{					
					MessageBox.Show(this,resources.GetString("FrmDocFlow.m2")+" '"+ citem.Paso + "'",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  						
					this.comboBox1_SelectedIndexChanged(null,null);
				}
				this.Cursor=Cursors.Default;
				

			}
		}
		
		private void menuPublicar_Click(object sender, System.EventArgs e)
		{			
			if(this.listView1.SelectedItems.Count>0)
			{				
				
				CWBListViewItem citem=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;

				if(!user.GetPermiso(citem.TopicMap,this.type))
				{
					//MessageBox.Show(this,resources.GetString("FrmDocFlow.msg7"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  	
					return;
				}
				ParameterCollection parametros=new ParameterCollection(); 
				ParameterCollection resultados=new ParameterCollection(); 
				parametros.Add(new Parameter("topicmap",citem.TopicMap));
				parametros.Add(new Parameter("topicid",citem.Topic));
				parametros.Add(new Parameter("id",this.listView1.SelectedItems[0].SubItems[0].Text));
				parametros.Add(new Parameter("action","1"));
				Servicios s= new Servicios(user);
				s.PublishFlow(parametros);
				if(!s.IsError)
				{
					MessageBox.Show(this,resources.GetString("FrmDocFlow.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
					this.listView1.Items.Clear();
					if(this.radioButton1.Checked)
					{
						radioButton1_CheckedChanged(null,null); 
					}
					else if(this.radioButton2.Checked)
					{
						radioButton2_CheckedChanged(null,null); 
					}
					else
					{
						radioButton3_CheckedChanged(null,null); 
					}
				}
			}
		}
		private void listView1_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{
				this.menuPreview.Enabled=true;				
				this.menuPropiedades.Enabled=true; 
				if(!this.listView1.SelectedItems[0].SubItems[4].Text.Equals("Autorizado (a Publicar)"))
				{
					if(this.listView1.SelectedItems[0].SubItems[4].Text.Equals("Rechazado"))						
					{
						this.menuPublicar.Enabled=false; 
						this.menuAutorizar.Enabled=true;							
						this.menuRechazar.Enabled=true;  							
						
					}
					else
					{
						this.menuPublicar.Enabled=false; 
						this.menuAutorizar.Enabled=true;
						this.menuRechazar.Enabled=true;
						
					}						
				}
				else
				{
					this.menuPublicar.Enabled=true; 
					this.menuAutorizar.Enabled=false;  
					this.menuRechazar.Enabled=false;  
				}
			}
		}

		private void radioButton3_CheckedChanged(object sender, System.EventArgs e)
		{
			if(radioButton3.Checked)
			{
				if(this.comboBox1.Items.Count==0)
				{
					this.listView1.Items.Clear();  
					return;
				}
				CCaracteristica c=(CCaracteristica)this.comboBox1.SelectedItem;
				String topicmap=c.Name;
				MessageBox.Show(this,resources.GetString("FrmDocFlow.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
				this.Cursor=Cursors.WaitCursor; 
				this.listView1.Items.Clear();  
				flujoscol= new Hashtable();
				Servicios s= new Servicios(user);
				System.Xml.XmlNodeList contenidos=s.getContentReview(topicmap).GetElementsByTagName("Content"); 
				foreach(System.Xml.XmlElement contenido in contenidos)
				{					
					String id=contenido.GetAttribute("id");					
					String topic=contenido.GetAttribute("topic");
					String title=contenido.GetAttribute("title");
					String idflujo=contenido.GetAttribute("flowid");
					String activity=contenido.GetAttribute("activity");
					String flowname=contenido.GetAttribute("flowname");					
					String occurrenceid=contenido.GetAttribute("occurrence");

					// 0=no enviado ,1=en revisión, 2=terminado 3=rechazado
					String idestado=contenido.GetAttribute("status");
					String estado="";
					if(idestado.Equals("0"))
					{
						estado=resources.GetString("FrmDocFlow.t1");
					}
					else if(idestado.Equals("1"))
					{
						estado=resources.GetString("FrmDocFlow.t1");
					}
					else if(idestado.Equals("2"))
					{
						estado=resources.GetString("FrmDocFlow.t3");
					}
					else if(idestado.Equals("3"))
					{
						estado=resources.GetString("FrmDocFlow.t2");
					}
					string[] sitem=new string[5];
					sitem[0]=id;
					sitem[1]=title;
					sitem[2]=flowname;
					sitem[3]=activity;
					sitem[4]=estado;
					CWBListViewItem citem=new CWBListViewItem();
					citem.TopicMap=topicmap;
					citem.Topic=topic;
					citem.Flow=idflujo;
					citem.Paso=activity;
					citem.XMLContent=contenido;					
					citem.Occurrence=occurrenceid;
					ListViewItem item=this.listView1.Items.Add(new ListViewItem(sitem));   
					item.ImageIndex=0;
					item.Tag=citem;
				}
				this.Cursor=Cursors.Default;				
			}
		}

		private void listView1_ColumnClick(object sender, System.Windows.Forms.ColumnClickEventArgs e)
		{
			colum.Ascending=!colum.Ascending;
			colum.CurrentColumn=e.Column;
			this.listView1.Sort(); 
		}

		private void comboBox1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			if(this.radioButton1.Checked)
			{
				this.radioButton1_CheckedChanged(null,null);
			}
			else if(this.radioButton2.Checked)
			{
				this.radioButton2_CheckedChanged(null,null);
			}
			else if(this.radioButton3.Checked)
			{
				this.radioButton3_CheckedChanged(null,null);
			}
		}		
	}
}
