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
using System.Diagnostics;
using Word = Microsoft.Office.Interop.Word;
using Office = Microsoft.Office.Core;
using System.IO;
using WBOffice3;
namespace WBWord
{
	/// <summary>Forma que muestra los documentos por autorizar</summary>
	public class FrmDocumentosXAutorizar : System.Windows.Forms.Form
	{
		static System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.GroupBox groupBox2;
		private System.Windows.Forms.ListView listView1;
		private System.Windows.Forms.ColumnHeader columnHeader2;
		private System.Windows.Forms.ColumnHeader columnHeader5;
		private System.Windows.Forms.ColumnHeader columnHeader3;
		private System.Windows.Forms.GroupBox groupBox3;
		private System.Windows.Forms.ComboBox comboBox1;
		private System.Windows.Forms.RadioButton radioButton3;
		private System.Windows.Forms.RadioButton radioButton2;
		private System.Windows.Forms.RadioButton radioButton1;
		private System.Windows.Forms.Button buttonCerrar;
		private System.Windows.Forms.Button buttonAuthorize;
		private System.Windows.Forms.Button buttonReject;
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		CUserAdmin user;
		ColumnSorter colum= new ColumnSorter();
		
		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.Button buttonShowFlow;
		
		private System.Windows.Forms.Button buttonOpen;
		private System.Windows.Forms.Button buttonInfo;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox textBoxMessage;
        private WebBrowser axWebBrowser1;
		//private AxSHDocVw.AxWebBrowser axWebBrowser1;
		System.Collections.Hashtable flujoscol=new Hashtable(); 
		Word.Application app;
		/// <summary>Crea una forma con la lista de documentos por autorizar</summary>
		/// <param name="user">Usuario actual</param>
		/// <param name="app">Applicación de Word</param>
		public FrmDocumentosXAutorizar(CUserAdmin user,Word.Application app)
		{
			//
			// Necesario para admitir el Diseñador de Windows Forms
			//
			InitializeComponent();
			this.app=app;			
			this.user=user;
			this.listView1.ListViewItemSorter=colum;  
			this.buttonAuthorize.Enabled=false;
			this.buttonReject.Enabled=false;
			this.buttonShowFlow.Enabled=false;
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
			//
			// TODO: agregar código de constructor después de llamar a InitializeComponent
			//
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

		#region Código generado por el Diseñador de Windows Forms
		/// <summary>
		/// Método necesario para admitir el Diseñador. No se puede modificar
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmDocumentosXAutorizar));
			this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.axWebBrowser1 = new WebBrowser();
			this.panel1 = new System.Windows.Forms.Panel();
			this.buttonOpen = new System.Windows.Forms.Button();
			this.buttonInfo = new System.Windows.Forms.Button();
			this.buttonShowFlow = new System.Windows.Forms.Button();
			this.groupBox2 = new System.Windows.Forms.GroupBox();
			this.listView1 = new System.Windows.Forms.ListView();
			this.columnHeader2 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader5 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader3 = new System.Windows.Forms.ColumnHeader();
			this.groupBox3 = new System.Windows.Forms.GroupBox();
			this.radioButton3 = new System.Windows.Forms.RadioButton();
			this.radioButton2 = new System.Windows.Forms.RadioButton();
			this.radioButton1 = new System.Windows.Forms.RadioButton();
			this.comboBox1 = new System.Windows.Forms.ComboBox();
			this.buttonAuthorize = new System.Windows.Forms.Button();
			this.buttonReject = new System.Windows.Forms.Button();
			this.buttonCerrar = new System.Windows.Forms.Button();
			this.textBoxMessage = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.groupBox1.SuspendLayout();
			//((System.ComponentModel.ISupportInitialize)(this.axWebBrowser1)).BeginInit();
			this.panel1.SuspendLayout();
			this.groupBox2.SuspendLayout();
			this.groupBox3.SuspendLayout();
			this.SuspendLayout();
			// 
			// groupBox1
			// 
			this.groupBox1.AccessibleDescription = resources.GetString("groupBox1.AccessibleDescription");
			this.groupBox1.AccessibleName = resources.GetString("groupBox1.AccessibleName");
			this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox1.Anchor")));
			this.groupBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox1.BackgroundImage")));
			this.groupBox1.Controls.Add(this.axWebBrowser1);
			this.groupBox1.Controls.Add(this.panel1);
			this.groupBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox1.Dock")));
			this.groupBox1.Enabled = ((bool)(resources.GetObject("groupBox1.Enabled")));
			this.groupBox1.Font = ((System.Drawing.Font)(resources.GetObject("groupBox1.Font")));
			this.groupBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBox1.ImeMode")));
			this.groupBox1.Location = ((System.Drawing.Point)(resources.GetObject("groupBox1.Location")));
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBox1.RightToLeft")));
			this.groupBox1.Size = ((System.Drawing.Size)(resources.GetObject("groupBox1.Size")));
			this.groupBox1.TabIndex = ((int)(resources.GetObject("groupBox1.TabIndex")));
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = resources.GetString("groupBox1.Text");
			this.groupBox1.Visible = ((bool)(resources.GetObject("groupBox1.Visible")));
			// 
			// axWebBrowser1
			// 
			this.axWebBrowser1.AccessibleDescription = resources.GetString("axWebBrowser1.AccessibleDescription");
			this.axWebBrowser1.AccessibleName = resources.GetString("axWebBrowser1.AccessibleName");
			this.axWebBrowser1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("axWebBrowser1.Anchor")));            			
			this.axWebBrowser1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("axWebBrowser1.Dock")));			
			this.axWebBrowser1.Font = ((System.Drawing.Font)(resources.GetObject("axWebBrowser1.Font")));
			this.axWebBrowser1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("axWebBrowser1.ImeMode")));
			this.axWebBrowser1.Location = ((System.Drawing.Point)(resources.GetObject("axWebBrowser1.Location")));						
			this.axWebBrowser1.Size = ((System.Drawing.Size)(resources.GetObject("axWebBrowser1.Size")));
			this.axWebBrowser1.TabIndex = ((int)(resources.GetObject("axWebBrowser1.TabIndex")));			
			this.axWebBrowser1.Visible = ((bool)(resources.GetObject("axWebBrowser1.Visible")));
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
			this.panel1.Controls.Add(this.buttonOpen);
			this.panel1.Controls.Add(this.buttonInfo);
			this.panel1.Controls.Add(this.buttonShowFlow);
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
			// buttonOpen
			// 
			this.buttonOpen.AccessibleDescription = resources.GetString("buttonOpen.AccessibleDescription");
			this.buttonOpen.AccessibleName = resources.GetString("buttonOpen.AccessibleName");
			this.buttonOpen.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonOpen.Anchor")));
			this.buttonOpen.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonOpen.BackgroundImage")));
			this.buttonOpen.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonOpen.Dock")));
			this.buttonOpen.Enabled = ((bool)(resources.GetObject("buttonOpen.Enabled")));
			this.buttonOpen.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonOpen.FlatStyle")));
			this.buttonOpen.Font = ((System.Drawing.Font)(resources.GetObject("buttonOpen.Font")));
			this.buttonOpen.Image = ((System.Drawing.Image)(resources.GetObject("buttonOpen.Image")));
			this.buttonOpen.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonOpen.ImageAlign")));
			this.buttonOpen.ImageIndex = ((int)(resources.GetObject("buttonOpen.ImageIndex")));
			this.buttonOpen.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonOpen.ImeMode")));
			this.buttonOpen.Location = ((System.Drawing.Point)(resources.GetObject("buttonOpen.Location")));
			this.buttonOpen.Name = "buttonOpen";
			this.buttonOpen.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonOpen.RightToLeft")));
			this.buttonOpen.Size = ((System.Drawing.Size)(resources.GetObject("buttonOpen.Size")));
			this.buttonOpen.TabIndex = ((int)(resources.GetObject("buttonOpen.TabIndex")));
			this.buttonOpen.Text = resources.GetString("buttonOpen.Text");
			this.buttonOpen.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonOpen.TextAlign")));
			this.buttonOpen.Visible = ((bool)(resources.GetObject("buttonOpen.Visible")));
			this.buttonOpen.Click += new System.EventHandler(this.buttonOpen_Click);
			// 
			// buttonInfo
			// 
			this.buttonInfo.AccessibleDescription = resources.GetString("buttonInfo.AccessibleDescription");
			this.buttonInfo.AccessibleName = resources.GetString("buttonInfo.AccessibleName");
			this.buttonInfo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonInfo.Anchor")));
			this.buttonInfo.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonInfo.BackgroundImage")));
			this.buttonInfo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonInfo.Dock")));
			this.buttonInfo.Enabled = ((bool)(resources.GetObject("buttonInfo.Enabled")));
			this.buttonInfo.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonInfo.FlatStyle")));
			this.buttonInfo.Font = ((System.Drawing.Font)(resources.GetObject("buttonInfo.Font")));
			this.buttonInfo.Image = ((System.Drawing.Image)(resources.GetObject("buttonInfo.Image")));
			this.buttonInfo.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonInfo.ImageAlign")));
			this.buttonInfo.ImageIndex = ((int)(resources.GetObject("buttonInfo.ImageIndex")));
			this.buttonInfo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonInfo.ImeMode")));
			this.buttonInfo.Location = ((System.Drawing.Point)(resources.GetObject("buttonInfo.Location")));
			this.buttonInfo.Name = "buttonInfo";
			this.buttonInfo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonInfo.RightToLeft")));
			this.buttonInfo.Size = ((System.Drawing.Size)(resources.GetObject("buttonInfo.Size")));
			this.buttonInfo.TabIndex = ((int)(resources.GetObject("buttonInfo.TabIndex")));
			this.buttonInfo.Text = resources.GetString("buttonInfo.Text");
			this.buttonInfo.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonInfo.TextAlign")));
			this.buttonInfo.Visible = ((bool)(resources.GetObject("buttonInfo.Visible")));
			this.buttonInfo.Click += new System.EventHandler(this.buttonInfo_Click);
			// 
			// buttonShowFlow
			// 
			this.buttonShowFlow.AccessibleDescription = resources.GetString("buttonShowFlow.AccessibleDescription");
			this.buttonShowFlow.AccessibleName = resources.GetString("buttonShowFlow.AccessibleName");
			this.buttonShowFlow.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonShowFlow.Anchor")));
			this.buttonShowFlow.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonShowFlow.BackgroundImage")));
			this.buttonShowFlow.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonShowFlow.Dock")));
			this.buttonShowFlow.Enabled = ((bool)(resources.GetObject("buttonShowFlow.Enabled")));
			this.buttonShowFlow.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonShowFlow.FlatStyle")));
			this.buttonShowFlow.Font = ((System.Drawing.Font)(resources.GetObject("buttonShowFlow.Font")));
			this.buttonShowFlow.Image = ((System.Drawing.Image)(resources.GetObject("buttonShowFlow.Image")));
			this.buttonShowFlow.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonShowFlow.ImageAlign")));
			this.buttonShowFlow.ImageIndex = ((int)(resources.GetObject("buttonShowFlow.ImageIndex")));
			this.buttonShowFlow.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonShowFlow.ImeMode")));
			this.buttonShowFlow.Location = ((System.Drawing.Point)(resources.GetObject("buttonShowFlow.Location")));
			this.buttonShowFlow.Name = "buttonShowFlow";
			this.buttonShowFlow.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonShowFlow.RightToLeft")));
			this.buttonShowFlow.Size = ((System.Drawing.Size)(resources.GetObject("buttonShowFlow.Size")));
			this.buttonShowFlow.TabIndex = ((int)(resources.GetObject("buttonShowFlow.TabIndex")));
			this.buttonShowFlow.Text = resources.GetString("buttonShowFlow.Text");
			this.buttonShowFlow.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonShowFlow.TextAlign")));
			this.buttonShowFlow.Visible = ((bool)(resources.GetObject("buttonShowFlow.Visible")));
			this.buttonShowFlow.Click += new System.EventHandler(this.buttonShowFlow_Click);
			// 
			// groupBox2
			// 
			this.groupBox2.AccessibleDescription = resources.GetString("groupBox2.AccessibleDescription");
			this.groupBox2.AccessibleName = resources.GetString("groupBox2.AccessibleName");
			this.groupBox2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox2.Anchor")));
			this.groupBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox2.BackgroundImage")));
			this.groupBox2.Controls.Add(this.listView1);
			this.groupBox2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox2.Dock")));
			this.groupBox2.Enabled = ((bool)(resources.GetObject("groupBox2.Enabled")));
			this.groupBox2.Font = ((System.Drawing.Font)(resources.GetObject("groupBox2.Font")));
			this.groupBox2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBox2.ImeMode")));
			this.groupBox2.Location = ((System.Drawing.Point)(resources.GetObject("groupBox2.Location")));
			this.groupBox2.Name = "groupBox2";
			this.groupBox2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBox2.RightToLeft")));
			this.groupBox2.Size = ((System.Drawing.Size)(resources.GetObject("groupBox2.Size")));
			this.groupBox2.TabIndex = ((int)(resources.GetObject("groupBox2.TabIndex")));
			this.groupBox2.TabStop = false;
			this.groupBox2.Text = resources.GetString("groupBox2.Text");
			this.groupBox2.Visible = ((bool)(resources.GetObject("groupBox2.Visible")));
			// 
			// listView1
			// 
			this.listView1.AccessibleDescription = resources.GetString("listView1.AccessibleDescription");
			this.listView1.AccessibleName = resources.GetString("listView1.AccessibleName");
			this.listView1.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listView1.Alignment")));
			this.listView1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listView1.Anchor")));
			this.listView1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listView1.BackgroundImage")));
			this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																						this.columnHeader2,
																						this.columnHeader5,
																						this.columnHeader3});
			this.listView1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView1.Dock")));
			this.listView1.Enabled = ((bool)(resources.GetObject("listView1.Enabled")));
			this.listView1.Font = ((System.Drawing.Font)(resources.GetObject("listView1.Font")));
			this.listView1.FullRowSelect = true;
			this.listView1.HideSelection = false;
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
			this.listView1.SelectedIndexChanged += new System.EventHandler(this.listView1_SelectedIndexChanged);
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
			// groupBox3
			// 
			this.groupBox3.AccessibleDescription = resources.GetString("groupBox3.AccessibleDescription");
			this.groupBox3.AccessibleName = resources.GetString("groupBox3.AccessibleName");
			this.groupBox3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox3.Anchor")));
			this.groupBox3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox3.BackgroundImage")));
			this.groupBox3.Controls.Add(this.radioButton3);
			this.groupBox3.Controls.Add(this.radioButton2);
			this.groupBox3.Controls.Add(this.radioButton1);
			this.groupBox3.Controls.Add(this.comboBox1);
			this.groupBox3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox3.Dock")));
			this.groupBox3.Enabled = ((bool)(resources.GetObject("groupBox3.Enabled")));
			this.groupBox3.Font = ((System.Drawing.Font)(resources.GetObject("groupBox3.Font")));
			this.groupBox3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBox3.ImeMode")));
			this.groupBox3.Location = ((System.Drawing.Point)(resources.GetObject("groupBox3.Location")));
			this.groupBox3.Name = "groupBox3";
			this.groupBox3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBox3.RightToLeft")));
			this.groupBox3.Size = ((System.Drawing.Size)(resources.GetObject("groupBox3.Size")));
			this.groupBox3.TabIndex = ((int)(resources.GetObject("groupBox3.TabIndex")));
			this.groupBox3.TabStop = false;
			this.groupBox3.Text = resources.GetString("groupBox3.Text");
			this.groupBox3.Visible = ((bool)(resources.GetObject("groupBox3.Visible")));
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
			// buttonAuthorize
			// 
			this.buttonAuthorize.AccessibleDescription = resources.GetString("buttonAuthorize.AccessibleDescription");
			this.buttonAuthorize.AccessibleName = resources.GetString("buttonAuthorize.AccessibleName");
			this.buttonAuthorize.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonAuthorize.Anchor")));
			this.buttonAuthorize.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonAuthorize.BackgroundImage")));
			this.buttonAuthorize.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonAuthorize.Dock")));
			this.buttonAuthorize.Enabled = ((bool)(resources.GetObject("buttonAuthorize.Enabled")));
			this.buttonAuthorize.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonAuthorize.FlatStyle")));
			this.buttonAuthorize.Font = ((System.Drawing.Font)(resources.GetObject("buttonAuthorize.Font")));
			this.buttonAuthorize.Image = ((System.Drawing.Image)(resources.GetObject("buttonAuthorize.Image")));
			this.buttonAuthorize.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAuthorize.ImageAlign")));
			this.buttonAuthorize.ImageIndex = ((int)(resources.GetObject("buttonAuthorize.ImageIndex")));
			this.buttonAuthorize.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonAuthorize.ImeMode")));
			this.buttonAuthorize.Location = ((System.Drawing.Point)(resources.GetObject("buttonAuthorize.Location")));
			this.buttonAuthorize.Name = "buttonAuthorize";
			this.buttonAuthorize.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonAuthorize.RightToLeft")));
			this.buttonAuthorize.Size = ((System.Drawing.Size)(resources.GetObject("buttonAuthorize.Size")));
			this.buttonAuthorize.TabIndex = ((int)(resources.GetObject("buttonAuthorize.TabIndex")));
			this.buttonAuthorize.Text = resources.GetString("buttonAuthorize.Text");
			this.buttonAuthorize.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAuthorize.TextAlign")));
			this.buttonAuthorize.Visible = ((bool)(resources.GetObject("buttonAuthorize.Visible")));
			this.buttonAuthorize.Click += new System.EventHandler(this.buttonAuthorize_Click);
			// 
			// buttonReject
			// 
			this.buttonReject.AccessibleDescription = resources.GetString("buttonReject.AccessibleDescription");
			this.buttonReject.AccessibleName = resources.GetString("buttonReject.AccessibleName");
			this.buttonReject.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonReject.Anchor")));
			this.buttonReject.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonReject.BackgroundImage")));
			this.buttonReject.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonReject.Dock")));
			this.buttonReject.Enabled = ((bool)(resources.GetObject("buttonReject.Enabled")));
			this.buttonReject.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonReject.FlatStyle")));
			this.buttonReject.Font = ((System.Drawing.Font)(resources.GetObject("buttonReject.Font")));
			this.buttonReject.Image = ((System.Drawing.Image)(resources.GetObject("buttonReject.Image")));
			this.buttonReject.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonReject.ImageAlign")));
			this.buttonReject.ImageIndex = ((int)(resources.GetObject("buttonReject.ImageIndex")));
			this.buttonReject.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonReject.ImeMode")));
			this.buttonReject.Location = ((System.Drawing.Point)(resources.GetObject("buttonReject.Location")));
			this.buttonReject.Name = "buttonReject";
			this.buttonReject.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonReject.RightToLeft")));
			this.buttonReject.Size = ((System.Drawing.Size)(resources.GetObject("buttonReject.Size")));
			this.buttonReject.TabIndex = ((int)(resources.GetObject("buttonReject.TabIndex")));
			this.buttonReject.Text = resources.GetString("buttonReject.Text");
			this.buttonReject.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonReject.TextAlign")));
			this.buttonReject.Visible = ((bool)(resources.GetObject("buttonReject.Visible")));
			this.buttonReject.Click += new System.EventHandler(this.buttonReject_Click);
			// 
			// buttonCerrar
			// 
			this.buttonCerrar.AccessibleDescription = resources.GetString("buttonCerrar.AccessibleDescription");
			this.buttonCerrar.AccessibleName = resources.GetString("buttonCerrar.AccessibleName");
			this.buttonCerrar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonCerrar.Anchor")));
			this.buttonCerrar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonCerrar.BackgroundImage")));
			this.buttonCerrar.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.buttonCerrar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonCerrar.Dock")));
			this.buttonCerrar.Enabled = ((bool)(resources.GetObject("buttonCerrar.Enabled")));
			this.buttonCerrar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonCerrar.FlatStyle")));
			this.buttonCerrar.Font = ((System.Drawing.Font)(resources.GetObject("buttonCerrar.Font")));
			this.buttonCerrar.Image = ((System.Drawing.Image)(resources.GetObject("buttonCerrar.Image")));
			this.buttonCerrar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCerrar.ImageAlign")));
			this.buttonCerrar.ImageIndex = ((int)(resources.GetObject("buttonCerrar.ImageIndex")));
			this.buttonCerrar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonCerrar.ImeMode")));
			this.buttonCerrar.Location = ((System.Drawing.Point)(resources.GetObject("buttonCerrar.Location")));
			this.buttonCerrar.Name = "buttonCerrar";
			this.buttonCerrar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonCerrar.RightToLeft")));
			this.buttonCerrar.Size = ((System.Drawing.Size)(resources.GetObject("buttonCerrar.Size")));
			this.buttonCerrar.TabIndex = ((int)(resources.GetObject("buttonCerrar.TabIndex")));
			this.buttonCerrar.Text = resources.GetString("buttonCerrar.Text");
			this.buttonCerrar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCerrar.TextAlign")));
			this.buttonCerrar.Visible = ((bool)(resources.GetObject("buttonCerrar.Visible")));
			this.buttonCerrar.Click += new System.EventHandler(this.buttonCerrar_Click);
			// 
			// textBoxMessage
			// 
			this.textBoxMessage.AccessibleDescription = resources.GetString("textBoxMessage.AccessibleDescription");
			this.textBoxMessage.AccessibleName = resources.GetString("textBoxMessage.AccessibleName");
			this.textBoxMessage.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("textBoxMessage.Anchor")));
			this.textBoxMessage.AutoSize = ((bool)(resources.GetObject("textBoxMessage.AutoSize")));
			this.textBoxMessage.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("textBoxMessage.BackgroundImage")));
			this.textBoxMessage.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("textBoxMessage.Dock")));
			this.textBoxMessage.Enabled = ((bool)(resources.GetObject("textBoxMessage.Enabled")));
			this.textBoxMessage.Font = ((System.Drawing.Font)(resources.GetObject("textBoxMessage.Font")));
			this.textBoxMessage.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("textBoxMessage.ImeMode")));
			this.textBoxMessage.Location = ((System.Drawing.Point)(resources.GetObject("textBoxMessage.Location")));
			this.textBoxMessage.MaxLength = ((int)(resources.GetObject("textBoxMessage.MaxLength")));
			this.textBoxMessage.Multiline = ((bool)(resources.GetObject("textBoxMessage.Multiline")));
			this.textBoxMessage.Name = "textBoxMessage";
			this.textBoxMessage.PasswordChar = ((char)(resources.GetObject("textBoxMessage.PasswordChar")));
			this.textBoxMessage.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("textBoxMessage.RightToLeft")));
			this.textBoxMessage.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("textBoxMessage.ScrollBars")));
			this.textBoxMessage.Size = ((System.Drawing.Size)(resources.GetObject("textBoxMessage.Size")));
			this.textBoxMessage.TabIndex = ((int)(resources.GetObject("textBoxMessage.TabIndex")));
			this.textBoxMessage.Text = resources.GetString("textBoxMessage.Text");
			this.textBoxMessage.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("textBoxMessage.TextAlign")));
			this.textBoxMessage.Visible = ((bool)(resources.GetObject("textBoxMessage.Visible")));
			this.textBoxMessage.WordWrap = ((bool)(resources.GetObject("textBoxMessage.WordWrap")));
			// 
			// label1
			// 
			this.label1.AccessibleDescription = resources.GetString("label1.AccessibleDescription");
			this.label1.AccessibleName = resources.GetString("label1.AccessibleName");
			this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label1.Anchor")));
			this.label1.AutoSize = ((bool)(resources.GetObject("label1.AutoSize")));
			this.label1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label1.Dock")));
			this.label1.Enabled = ((bool)(resources.GetObject("label1.Enabled")));
			this.label1.Font = ((System.Drawing.Font)(resources.GetObject("label1.Font")));
			this.label1.Image = ((System.Drawing.Image)(resources.GetObject("label1.Image")));
			this.label1.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label1.ImageAlign")));
			this.label1.ImageIndex = ((int)(resources.GetObject("label1.ImageIndex")));
			this.label1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label1.ImeMode")));
			this.label1.Location = ((System.Drawing.Point)(resources.GetObject("label1.Location")));
			this.label1.Name = "label1";
			this.label1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label1.RightToLeft")));
			this.label1.Size = ((System.Drawing.Size)(resources.GetObject("label1.Size")));
			this.label1.TabIndex = ((int)(resources.GetObject("label1.TabIndex")));
			this.label1.Text = resources.GetString("label1.Text");
			this.label1.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label1.TextAlign")));
			this.label1.Visible = ((bool)(resources.GetObject("label1.Visible")));
			// 
			// FrmDocumentosXAutorizar
			// 
			this.AcceptButton = this.buttonCerrar;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.buttonCerrar;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.label1);
			this.Controls.Add(this.textBoxMessage);
			this.Controls.Add(this.buttonCerrar);
			this.Controls.Add(this.buttonReject);
			this.Controls.Add(this.buttonAuthorize);
			this.Controls.Add(this.groupBox3);
			this.Controls.Add(this.groupBox2);
			this.Controls.Add(this.groupBox1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximizeBox = false;
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimizeBox = false;
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmDocumentosXAutorizar";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.Load += new System.EventHandler(this.FrmDocumentosXAutorizar_Load);
			this.groupBox1.ResumeLayout(false);
            
			//((System.ComponentModel.ISupportInitialize)(this.axWebBrowser1)).EndInit();
			this.panel1.ResumeLayout(false);
			this.groupBox2.ResumeLayout(false);
			this.groupBox3.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonCerrar_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void radioButton1_CheckedChanged(object sender, System.EventArgs e)
		{
			clearWebBrowser();
			this.buttonAuthorize.Enabled=false;  
			this.buttonReject.Enabled=false;  
			this.buttonShowFlow.Enabled=false;
			this.buttonOpen.Enabled=false;
			this.buttonInfo.Enabled=false;
			if(this.radioButton1.Checked)
			{
				if(this.comboBox1.Items.Count==0)
				{
					this.listView1.Items.Clear();  
					return;
				}
				CCaracteristica c=(CCaracteristica)this.comboBox1.SelectedItem;
				String topicmap=c.Name;
				//MessageBox.Show(this,resources.GetString("FrmDocFlow.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
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
					string[] sitem=new string[3];
					
					sitem[0]=title;
					sitem[1]=flowname;
					sitem[2]=activity;
					
					CWBListViewItem citem=new CWBListViewItem();
					citem.ID=id;
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
			if(this.listView1.Items.Count>0)
			{
				this.listView1.Items[0].Selected=true;
			}
			
		}

		private void radioButton2_CheckedChanged(object sender, System.EventArgs e)
		{
			clearWebBrowser();
			this.buttonAuthorize.Enabled=false;  
			this.buttonReject.Enabled=false;  
			this.buttonShowFlow.Enabled=false;
			this.buttonOpen.Enabled=false;
			this.buttonInfo.Enabled=false;
			if(radioButton2.Checked)
			{
				if(this.comboBox1.Items.Count==0)
				{
					this.listView1.Items.Clear();  
					return;
				}
				CCaracteristica c=(CCaracteristica)this.comboBox1.SelectedItem;
				String topicmap=c.Name;
				//MessageBox.Show(this,resources.GetString("FrmDocFlow.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
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
					string[] sitem=new string[3];					
					sitem[0]=title;
					sitem[1]=flowname;
					sitem[2]=activity;
					
					CWBListViewItem citem=new CWBListViewItem();
					citem.ID=id;
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
			if(this.listView1.Items.Count>0)
			{
				this.listView1.Items[0].Selected=true;
			}
			
		}
		private void clearWebBrowser()
		{
			String url="about:blank";
			object missing=Type.Missing;
            this.axWebBrowser1.Navigate(url);
			//this.axWebBrowser1.Navigate(url,ref missing,ref missing,ref missing,ref missing);
		}
		private void radioButton3_CheckedChanged(object sender, System.EventArgs e)
		{
			clearWebBrowser();
			this.buttonAuthorize.Enabled=false;  
			this.buttonReject.Enabled=false;  
			this.buttonShowFlow.Enabled=false;
			this.buttonOpen.Enabled=false;
			this.buttonInfo.Enabled=false;
			if(radioButton3.Checked)
			{
				if(this.comboBox1.Items.Count==0)
				{
					this.listView1.Items.Clear();  
					return;
				}
				CCaracteristica c=(CCaracteristica)this.comboBox1.SelectedItem;
				String topicmap=c.Name;
				//MessageBox.Show(this,resources.GetString("FrmDocFlow.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
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
					string[] sitem=new string[3];
					//sitem[0]=id;
					sitem[0]=title;
					sitem[1]=flowname;
					sitem[2]=activity;
					//sitem[4]=estado;
					CWBListViewItem citem=new CWBListViewItem();
					citem.ID=id;
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

		private void buttonAuthorize_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{		
				if(this.textBoxMessage.Text.Trim()=="")
				{
					MessageBox.Show(this,resources.GetString("FrmDocumentosXAutorizar.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
					return;
				}
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
				if(MessageBox.Show(this,resources.GetString("FrmDocumentosXAutorizar.msg4")+"\r\n"+resources.GetString("FrmDocumentosXAutorizar.msg3")+":"+this.textBoxMessage.Text,resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.Cancel)
				{
					return;
				}
				s.acceptFlow(citem.TopicMap,citem.Topic,citem.Occurrence,this.textBoxMessage.Text);
				if(!s.IsError)
				{					
					MessageBox.Show(this,resources.GetString("FrmDocFlow.m1")+" '"+ citem.Paso +"'",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  						
					this.comboBox1_SelectedIndexChanged(null,null);
					textBoxMessage.Text="";
				}
				this.Cursor=Cursors.Default;
			}
		}

		private void buttonReject_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{				
				if(this.textBoxMessage.Text.Trim()=="")
				{
					MessageBox.Show(this,resources.GetString("FrmDocumentosXAutorizar.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
					return;
				}
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
				if(MessageBox.Show(this,resources.GetString("FrmDocumentosXAutorizar.msg2")+"\r\n"+resources.GetString("FrmDocumentosXAutorizar.msg3")+":"+this.textBoxMessage.Text,resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.Cancel)
				{
					return;
				}
				s=new Servicios(this.user);
				s.rejectFlow(citem.TopicMap,citem.Topic,citem.Occurrence,this.textBoxMessage.Text);
				if(!s.IsError)
				{					
					MessageBox.Show(this,resources.GetString("FrmDocFlow.m2")+" '"+ citem.Paso + "'",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  						
					this.comboBox1_SelectedIndexChanged(null,null);
					textBoxMessage.Text="";
				}
				this.Cursor=Cursors.Default;
				

			}
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

		private void listView1_Click(object sender, System.EventArgs e)
		{
			
		}

		private void listView1_ColumnClick(object sender, System.Windows.Forms.ColumnClickEventArgs e)
		{
			colum.Ascending=!colum.Ascending;
			colum.CurrentColumn=e.Column;
			this.listView1.Sort(); 
		}

		private void listView1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			
				this.buttonOpen.Enabled=false;
				if(this.listView1.SelectedItems.Count>0)
				{				
					CWBListViewItem item=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
					String topicmap=item.TopicMap;
					String topicid=item.Topic;
					String idcont=item.ID;				
					Servicios servicio= new Servicios(this.user);
					String lastversion="1";
					XmlDocument resp=servicio.getContentAtt(topicmap,topicid,idcont);
					try
					{
						if(resp.GetElementsByTagName("lastversion").Count>0)
						{
							lastversion=resp.GetElementsByTagName("lastversion")[0].InnerText;
						}							
					
					}
					catch(Exception ue)
					{
						Debug.WriteLine(ue.Message);
					}	
					
					if(resp.GetElementsByTagName("nameType").Count>0)
					{
						String nameType=resp.GetElementsByTagName("nameType")[0].InnerText;	
						if(nameType=="LocalContent")
						{
							this.buttonOpen.Enabled=true;
						}
					}
					object missing=Type.Missing;
					FrmPreview frm=new FrmPreview(topicmap,topicid,idcont,lastversion,CWebBuilder.user);
					String urlNavigate=frm.Navigate;
                    this.axWebBrowser1.Navigate(urlNavigate);
					//this.axWebBrowser1.Navigate(urlNavigate,ref missing,ref missing,ref missing,ref missing);
					Servicios sReviewer=new Servicios(this.user);
					if(sReviewer.isReviewer(topicmap,topicid,item.Occurrence))
					{
						this.buttonAuthorize.Enabled=true;  
						this.buttonReject.Enabled=true;  
						this.buttonShowFlow.Enabled=true;
					}
					else
					{
						this.buttonAuthorize.Enabled=false;  
						this.buttonReject.Enabled=false;  
						this.buttonShowFlow.Enabled=false;
					}	
					
					this.buttonInfo.Enabled=true;
				}
				else
				{
					this.buttonAuthorize.Enabled=false;  
					this.buttonReject.Enabled=false;  
					this.buttonShowFlow.Enabled=false;
					
					this.buttonInfo.Enabled=false;
				}
			
		}

		private void buttonShowFlow_Click(object sender, System.EventArgs e)
		{

			if(this.listView1.SelectedItems.Count>0)
			{
				CWBListViewItem item=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				String topicmap=item.TopicMap;
				String topicid=item.Topic;			
				FrmShowflow frm=new FrmShowflow(this.user,topicmap,topicid,item.Occurrence,item.Paso);
				frm.ShowDialog(this);
			}

		}

		private void buttonInfo_Click(object sender, System.EventArgs e)	
		{
			if(this.listView1.SelectedItems.Count>0)
			{
				CWBListViewItem item=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				String topicmap=item.TopicMap;
				String topicid=item.Topic;			
				FrmProp prop=new FrmProp(topicmap,topicid,item.ID,this.user,CWebBuilder.TYPE);
				prop.ShowDialog(this);
			}
		}
		
		/// <summary>Función de apertura de documento</summary>
		/// <param name="app">Aplicación de Word</param>
		/// <param name="idtopicmap">Id del sitio</param>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="idcontent">Id del contenido</param>
		/// <param name="user">Usuario actual</param>
		/// <param name="dinfo">Directorio a almacenar el contenido</param>
		public static void OpenWordDocument(Word.Application app,String idtopicmap,String idtopic,String idcontent,CUserAdmin user,System.IO.DirectoryInfo dinfo)
		{
			double Appversion=double.Parse(CWebBuilder.app.Version);
			String lastversion="1";
			Servicios servicio= new Servicios(user);
			XmlDocument resp=servicio.getContentAtt(idtopicmap,idtopic,idcontent);
			try
			{
				if(resp.GetElementsByTagName("lastversion").Count>0)
				{
					lastversion=resp.GetElementsByTagName("lastversion")[0].InnerText;
				}							
				
			}
			catch(Exception ue)
			{
				Debug.WriteLine(ue.Message);
			}
			ParameterCollection parametros=new ParameterCollection();
			ParameterCollection resultados=new ParameterCollection();
			WBOffice3.Parameter parameter = new WBOffice3.Parameter("topicid",idtopic); 
			parametros.Add(parameter); 
			WBOffice3.Parameter parametermap = new WBOffice3.Parameter("topicmap",idtopicmap); 
			parametros.Add(parametermap); 

			WBOffice3.Parameter pidcontent= new WBOffice3.Parameter("contentid",idcontent);
			parametros.Add(pidcontent); 
			parametros.Add(new WBOffice3.Parameter("version",lastversion)); 
			Servicios s= new Servicios(user);
			parametros.Add(new WBOffice3.Parameter("filenames","1"));
			XmlDocument doccont=s.openCont(idtopicmap,parametros);
			if(doccont.GetElementsByTagName("content").Count>0)
			{
				System.Xml.XmlNode xmocont=doccont.GetElementsByTagName("content")[0];
				WBOffice3.Parameter pcont= new WBOffice3.Parameter("content",xmocont.InnerText);
				pcont.Attributes.Add(new WBOffice3.Attribute(xmocont.Attributes[0].Name,xmocont.Attributes[0].Value));
				resultados.Add(pcont);
				System.Xml.XmlNodeList attachs=doccont.GetElementsByTagName("attachment");			
				foreach(System.Xml.XmlNode xmlattach in attachs)
				{
					WBOffice3.Parameter pattach= new WBOffice3.Parameter("attach",xmlattach.InnerText);
					pattach.Attributes.Add(new WBOffice3.Attribute(xmlattach.Attributes[0].Name,xmlattach.Attributes[0].Value ));
					resultados.Add(pattach);

				}
			}

					
			foreach(WBOffice3.IParameter presult in resultados)
			{
				if(presult.Name.Equals("content"))
				{
					// guarda el contenido
						

					String path=dinfo.FullName; 
					String namecont=presult.Attributes[0].Value;
					String archiohtml=path+"\\"+namecont;						
					FileInfo fhtml=new FileInfo(archiohtml);
					if(fhtml.Exists)
					{
						try
						{
							fhtml.Delete();
						}
						catch{}
					}

					//define el nombre del contenido en formato word
					String archivodoc=path+"\\"+namecont;
					FileInfo fdoc=new FileInfo(archivodoc);
					int pos=fdoc.FullName.LastIndexOf(fdoc.Extension);
					archivodoc=fdoc.FullName.Substring(0,pos);  
					archivodoc+=".doc";

					object missing = Type.Missing;
					object objtrue=true;
					object objfalse=false;
					// verifica que no exista un archivo abierto con el mismo nombre
					bool overwrite=false;
					app.Activate();
					app.Visible=true;
					foreach(Word.DocumentClass docopen in app.Documents)
					{
						if(docopen.FullName.ToLower().Equals(archivodoc.ToLower()))
						{
							//this.Cursor=Cursors.Default;
							if(MessageBox.Show(resources.GetString("FrmOpen3.msg3") +" "+  docopen.FullName +", "+ resources.GetString("FrmOpen3.msg4") +"",resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.Yes)
							{
								//								this.Cursor=Cursors.WaitCursor; 
								overwrite=true;									
								docopen.Close(ref objtrue,ref missing,ref missing);
								continue;
							}
							else
							{
								//								this.Cursor=Cursors.Default;
								MessageBox.Show(resources.GetString("FrmOpen3.msg5") +" "+docopen.FullName ,resources.GetString("Global.title"),MessageBoxButtons.OK ,MessageBoxIcon.Information);																				
								//this.Wizard.MoveTo(step);
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
							//							this.Cursor=Cursors.Default;
							if(MessageBox.Show(resources.GetString("FrmOpen3.msg3") +" "+  fdoc.FullName +", "+ resources.GetString("FrmOpen3.msg4") +"",resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question)==System.Windows.Forms.DialogResult.Yes)
							{
								//								this.Cursor=Cursors.WaitCursor; 
								overwrite=true;
								fdoc.Delete();
							}
							else
							{
								//								Cursor=Cursors.Default;																			
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
					String prefix="_archivos";
					//guarda las imagenes
					String snamedoc=fdoc.Name;
					int posext=snamedoc.IndexOf(fdoc.Extension);
					snamedoc=snamedoc.Substring(0,posext);
					snamedoc=snamedoc+prefix;
					String idcont=null;
					String version=null;
					foreach(WBOffice3.IParameter param in parametros )
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
					foreach(WBOffice3.IParameter presultiamges in resultados)
					{
						if(presultiamges.Name.Equals("attach"))
						{	
							if(idcont!=null && version!=null)
							{
								iimagenes++;
							}
						}
					}
					//this.progressBar1.Minimum=0;
					//this.progressBar1.Maximum=iimagenes+1;
					//this.progressBar1.Value++;
					foreach(WBOffice3.IParameter presultiamges in resultados)
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
								String resType="LocalContent";
								CDownLoadContent cdown=new CDownLoadContent(fimagen,idtopicmap,idcont,version,user,resType);
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
								//									this.progressBar1.Value++;
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
#if (DEBUG)
						fout=new FileInfo(fhtml.DirectoryName+"\\temp.html").Open(FileMode.Create,FileAccess.ReadWrite,FileShare.ReadWrite);								
						fout.Write( bcont,0,bcont.Length);
						fout.Close();
#endif

					}
					catch(System.IO.IOException ioe)
					{
						System.Console.WriteLine(ioe.Message);
						//						this.Cursor=Cursors.Default;
						MessageBox.Show(ioe.Message,resources.GetString("Global.title"),MessageBoxButtons.RetryCancel,MessageBoxIcon.Error);
						//this.Wizard.MoveTo(step);
						return;
					}


							
					// abre el documento en formato html para traducción
										
					object strpathHtml=archiohtml;								
					object strpathDoc=archivodoc;								
					object objformat= Word.WdSaveFormat.wdFormatDocument;
					object objformathtml= Word.WdOpenFormat.wdOpenFormatWebPages;
						
								
					Word.DocumentClass dochtml=null;


					FileInfo fword=new FileInfo((string)strpathHtml);
					String name=fword.Name;							
					name=name.Substring(0,name.IndexOf(fword.Extension));
					String subdir=name+prefix;
					name+=".doc";
					fword=new FileInfo(fword.DirectoryName+"\\"+subdir+"\\"+name);
					if(fword.Exists)
					{
						object filename=fword.FullName;
                        dochtml = (Word.DocumentClass)app.Documents.Open(ref filename, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);										
						foreach(Word.Hyperlink link in  dochtml.Hyperlinks )
						{				
							try
							{
								String archivo=link.Address;
								if(archivo!=null)
								{
									System.Uri basepath=new System.Uri(fword.DirectoryName+"\\");
									System.Uri filepath=new System.Uri(basepath, archivo);

											
											
									if(filepath.IsFile && filepath.Scheme.ToLower().StartsWith("file")) 
									{										
										FileInfo farchivo= new FileInfo(filepath.LocalPath);						
										if(farchivo.Extension.IndexOf(".")!=-1)
										{
											farchivo= new FileInfo(fword.DirectoryName+"\\"+farchivo.Name);						
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
					else
					{		
						
						if(Appversion>=11)
                            dochtml = (Word.DocumentClass)app.Documents.Open(ref strpathHtml, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref objformathtml, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);		
						else
                            dochtml = (Word.DocumentClass)app.Documents.Open(ref strpathHtml, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref objformathtml, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);	
					}


					// convierte el archivo en formato Word
					FileInfo fdoce=new FileInfo((string)strpathDoc);
					if(fdoce.Exists)
					{
						fdoce.Delete();
					}
                    dochtml.SaveAs(ref strpathDoc, ref objformat, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);															


					dochtml.Close(ref objtrue,ref missing,ref missing);						
							
					FileInfo fdochtml=new FileInfo((string)strpathHtml);
					if(fdochtml.Exists)
					{
						fdochtml.Delete();
					}
					Word.DocumentClass docopenwb=null;					
					if(Appversion>=11)
                        docopenwb = (Word.DocumentClass)app.Documents.Open(ref strpathDoc, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing);
					else
                        docopenwb = (Word.DocumentClass)app.Documents.Open(ref strpathDoc, ref missing, ref missing, ref objfalse, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);
							
					// guarda las propedades




                    Office.DocumentProperties props = (Office.DocumentProperties)docopenwb.CustomDocumentProperties;
					foreach(Office.DocumentProperty prop in props)
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
					string str = "";
					System.Object nullObjStr = str;
							

					props.Add("content",false,Office.MsoDocProperties.msoPropertyTypeString,idcont,nullObjStr);
                    props.Add("topicid", false, Office.MsoDocProperties.msoPropertyTypeString, idtopic, nullObjStr);
                    props.Add("topicmap", false, Office.MsoDocProperties.msoPropertyTypeString, idtopicmap, nullObjStr);							  														
					docopenwb.Saved=false; 
					docopenwb.Save();
					parametros.Add(new WBOffice3.Parameter("dir",docopenwb.Path));   
					parametros.Add(new WBOffice3.Parameter("filedoc",docopenwb.Name));										
					if(Appversion>=11)							
					{
                        
						docopenwb.Close(ref objfalse,ref missing,ref missing);						
						try
						{
                            docopenwb = (Word.DocumentClass)app.Documents.Open(ref strpathDoc, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing, ref missing);
									
							if(docopenwb.Windows.Count>0)
							{
								object index=0;
								docopenwb.Windows.get_Item(ref index).Activate();
							}
							docopenwb.Activate();
							docopenwb.ActiveWindow.View.Type=Word.WdViewType.wdPrintView;  
						}
						catch(Exception opene)
						{
							Debug.WriteLine(opene.Message);
						}
						String docname=(String)strpathDoc;
						foreach(Word.Document doc in app.Documents)
						{
									
							if(docname.ToLower().IndexOf(doc.Name.ToLower())!=-1)
							{									
								doc.Activate();
								doc.ActiveWindow.View.Type=Word.WdViewType.wdPrintView;  
								doc.ActiveWindow.Activate();
							}
						}
					}
					else
					{
						docopenwb.Activate();
						docopenwb.ActiveWindow.View.Type=Word.WdViewType.wdPrintView;  
					}


					// borra archivos temporales
					try
					{
						fhtml.Delete();
					}
					catch(System.IO.IOException fdele)
					{
						System.Console.WriteLine(fdele.Message);  
					}
				}
			}
		}

		private void buttonOpen_Click(object sender, System.EventArgs e)
		{
			if(this.listView1.SelectedItems.Count>0)
			{				
							
				CWBListViewItem item=(CWBListViewItem)this.listView1.SelectedItems[0].Tag;
				String idtopicmap=item.TopicMap;
				String idtopic=item.Topic;	
				String idcontent=item.ID;	
				Servicios s=new Servicios(this.user);
				XmlDocument doc=s.getContentAtt(idtopicmap,idtopic,idcontent);
				if(doc.GetElementsByTagName("nameType").Count==0)
				{
					return;
				}
				String nameType=doc.GetElementsByTagName("nameType")[0].InnerText;
				if(nameType=="LocalContent")
				{			
					FrmSelectFolder treedir=new FrmSelectFolder();
					if(treedir.ShowDialog(this)==DialogResult.Cancel)
					{
						return;
					}	
					OpenWordDocument(app,idtopicmap,idtopic,idcontent,this.user,new DirectoryInfo(treedir.FolderName));
					return;
				}
			}

		}
		private static String Parsea(CHtmlParser.CTag tag,String attname,String html,String pathdoc,FileInfo fdoc)
		{
			foreach(CHtmlParser.CAttibute  att in tag.Attibutes)
			{
				if(att.Name.ToLower().Equals(attname))
				{
					if(!att.Value.StartsWith("#"))
					{
						try
						{
							//System.Uri basepath= new System.Uri(pathdoc,true);
                            System.Uri basepath = new System.Uri(pathdoc);
							//System.Uri filepath= new System.Uri(basepath,att.Value,true);
                            System.Uri filepath = new System.Uri(basepath, att.Value);
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
								//String pathcorrecta=pathdoc+fmal.Name;
								String stag=tag.Tag;								
								String newtag="<"+tag.Name+" ";
								foreach(CHtmlParser.CAttibute  natt in tag.Attibutes )
								{
									if(natt.Name.ToLower().Equals(attname))
									{
										//System.Uri uri=new System.Uri(pathcorrecta,true);																				
										//System.Uri urifiledoc=new Uri(fdoc.FullName,true);
                                        System.Uri uri = new System.Uri(pathcorrecta);
                                        System.Uri urifiledoc = new Uri(fdoc.FullName);
										pathcorrecta=uri.LocalPath;
										pathcorrecta=urifiledoc.MakeRelativeUri(uri).ToString();
										FileInfo fileimagen=new FileInfo(uri.LocalPath);
										//										if(!fileimagen.Exists)
										//										{
										//											MessageBox.Show(resources.GetString("OpenStep6.filenotfound")+" : "+fileimagen.FullName,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);
										//										}
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

		private void FrmDocumentosXAutorizar_Load(object sender, System.EventArgs e)
		{
			if(this.listView1.Items.Count>0)
			{
				this.listView1.Items[0].Selected=true;
			}
			this.listView1_SelectedIndexChanged(null,null);
		}
	
		private static String Parsea(String html,String pathdoc,bool showWarning,FileInfo fdoc)
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
						if(att.Value.ToLower().Equals("urn:schemas-microsoft-com:office:word"))
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
				MessageBox.Show(resources.GetString("FrmOpen3.msg1"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Warning);  
			}
			return html;
		}
		
	}
}
