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
using System.Reflection; 
namespace WBExcel
{
	/// <summary>Forma que muestra el acceso de un usuario al servidor</summary>
	public class FrmSplash : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>Usuario actual</summary>
		/// <value>Usuario actual</value>
		public CUserAdmin user;	
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.CheckBox checkBox1;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.TextBox textBox3;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox textBox2;
		private System.Windows.Forms.TextBox textBox1;
		private System.Windows.Forms.CheckBox checkBoxabrir;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Button button3;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>Configuración del servidor proxy</summary>
		/// <value>Configuración del servidor proxy</value>
		public String proxyserver="";
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.Button buttonSalir;
		private System.Windows.Forms.Button buttonEntrar;
		/// <summary>Configuración del puerto del servidor proxy</summary>
		/// <value>Configuración del puerto del servidor proxy</value>
		public String portserverproxy="80";
		/// <summary>Crea una forma de accesos a WB</summary>
		/// <param name="user">Usuario que intenta acceder</param>
		public FrmSplash(CUserAdmin user)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.user=user;
			Assembly asm=Assembly.GetAssembly((new WBOffice3.CConfig()).GetType());				
			char[] sep={',','='};
			string[] data=asm.FullName.Split(sep);
			String version="";
			int i=0;
			foreach(String s in data)
			{
				if(s.IndexOf("Version")!=-1)
				{
					version=data[i+1];
				}
				i++;
			}
			this.label5.Text="Prod No. "+version +"";
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmSplash));
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.buttonSalir = new System.Windows.Forms.Button();
			this.checkBox1 = new System.Windows.Forms.CheckBox();
			this.label3 = new System.Windows.Forms.Label();
			this.textBox3 = new System.Windows.Forms.TextBox();
			this.buttonEntrar = new System.Windows.Forms.Button();
			this.label2 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.textBox2 = new System.Windows.Forms.TextBox();
			this.textBox1 = new System.Windows.Forms.TextBox();
			this.checkBoxabrir = new System.Windows.Forms.CheckBox();
			this.label4 = new System.Windows.Forms.Label();
			this.button3 = new System.Windows.Forms.Button();
			this.label5 = new System.Windows.Forms.Label();
			this.SuspendLayout();
			// 
			// pictureBox1
			// 
			this.pictureBox1.AccessibleDescription = resources.GetString("pictureBox1.AccessibleDescription");
			this.pictureBox1.AccessibleName = resources.GetString("pictureBox1.AccessibleName");
			this.pictureBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("pictureBox1.Anchor")));
			this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
			this.pictureBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("pictureBox1.Dock")));
			this.pictureBox1.Enabled = ((bool)(resources.GetObject("pictureBox1.Enabled")));
			this.pictureBox1.Font = ((System.Drawing.Font)(resources.GetObject("pictureBox1.Font")));
			this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
			this.pictureBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("pictureBox1.ImeMode")));
			this.pictureBox1.Location = ((System.Drawing.Point)(resources.GetObject("pictureBox1.Location")));
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("pictureBox1.RightToLeft")));
			this.pictureBox1.Size = ((System.Drawing.Size)(resources.GetObject("pictureBox1.Size")));
			this.pictureBox1.SizeMode = ((System.Windows.Forms.PictureBoxSizeMode)(resources.GetObject("pictureBox1.SizeMode")));
			this.pictureBox1.TabIndex = ((int)(resources.GetObject("pictureBox1.TabIndex")));
			this.pictureBox1.TabStop = false;
			this.pictureBox1.Text = resources.GetString("pictureBox1.Text");
			this.pictureBox1.Visible = ((bool)(resources.GetObject("pictureBox1.Visible")));
			// 
			// buttonSalir
			// 
			this.buttonSalir.AccessibleDescription = resources.GetString("buttonSalir.AccessibleDescription");
			this.buttonSalir.AccessibleName = resources.GetString("buttonSalir.AccessibleName");
			this.buttonSalir.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonSalir.Anchor")));
			this.buttonSalir.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(73)), ((System.Byte)(134)), ((System.Byte)(31)));
			this.buttonSalir.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonSalir.BackgroundImage")));
			this.buttonSalir.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.buttonSalir.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonSalir.Dock")));
			this.buttonSalir.Enabled = ((bool)(resources.GetObject("buttonSalir.Enabled")));
			this.buttonSalir.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonSalir.FlatStyle")));
			this.buttonSalir.Font = ((System.Drawing.Font)(resources.GetObject("buttonSalir.Font")));
			this.buttonSalir.ForeColor = System.Drawing.Color.White;
			this.buttonSalir.Image = ((System.Drawing.Image)(resources.GetObject("buttonSalir.Image")));
			this.buttonSalir.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonSalir.ImageAlign")));
			this.buttonSalir.ImageIndex = ((int)(resources.GetObject("buttonSalir.ImageIndex")));
			this.buttonSalir.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonSalir.ImeMode")));
			this.buttonSalir.Location = ((System.Drawing.Point)(resources.GetObject("buttonSalir.Location")));
			this.buttonSalir.Name = "buttonSalir";
			this.buttonSalir.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonSalir.RightToLeft")));
			this.buttonSalir.Size = ((System.Drawing.Size)(resources.GetObject("buttonSalir.Size")));
			this.buttonSalir.TabIndex = ((int)(resources.GetObject("buttonSalir.TabIndex")));
			this.buttonSalir.Text = resources.GetString("buttonSalir.Text");
			this.buttonSalir.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonSalir.TextAlign")));
			this.buttonSalir.Visible = ((bool)(resources.GetObject("buttonSalir.Visible")));
			this.buttonSalir.Click += new System.EventHandler(this.button2_Click);
			// 
			// checkBox1
			// 
			this.checkBox1.AccessibleDescription = resources.GetString("checkBox1.AccessibleDescription");
			this.checkBox1.AccessibleName = resources.GetString("checkBox1.AccessibleName");
			this.checkBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("checkBox1.Anchor")));
			this.checkBox1.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("checkBox1.Appearance")));
			this.checkBox1.BackColor = System.Drawing.Color.White;
			this.checkBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("checkBox1.BackgroundImage")));
			this.checkBox1.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBox1.CheckAlign")));
			this.checkBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("checkBox1.Dock")));
			this.checkBox1.Enabled = ((bool)(resources.GetObject("checkBox1.Enabled")));
			this.checkBox1.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("checkBox1.FlatStyle")));
			this.checkBox1.Font = ((System.Drawing.Font)(resources.GetObject("checkBox1.Font")));
			this.checkBox1.ForeColor = System.Drawing.Color.FromArgb(((System.Byte)(41)), ((System.Byte)(73)), ((System.Byte)(32)));
			this.checkBox1.Image = ((System.Drawing.Image)(resources.GetObject("checkBox1.Image")));
			this.checkBox1.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBox1.ImageAlign")));
			this.checkBox1.ImageIndex = ((int)(resources.GetObject("checkBox1.ImageIndex")));
			this.checkBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("checkBox1.ImeMode")));
			this.checkBox1.Location = ((System.Drawing.Point)(resources.GetObject("checkBox1.Location")));
			this.checkBox1.Name = "checkBox1";
			this.checkBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("checkBox1.RightToLeft")));
			this.checkBox1.Size = ((System.Drawing.Size)(resources.GetObject("checkBox1.Size")));
			this.checkBox1.TabIndex = ((int)(resources.GetObject("checkBox1.TabIndex")));
			this.checkBox1.Text = resources.GetString("checkBox1.Text");
			this.checkBox1.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBox1.TextAlign")));
			this.checkBox1.Visible = ((bool)(resources.GetObject("checkBox1.Visible")));
			// 
			// label3
			// 
			this.label3.AccessibleDescription = resources.GetString("label3.AccessibleDescription");
			this.label3.AccessibleName = resources.GetString("label3.AccessibleName");
			this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label3.Anchor")));
			this.label3.AutoSize = ((bool)(resources.GetObject("label3.AutoSize")));
			this.label3.BackColor = System.Drawing.Color.White;
			this.label3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label3.Dock")));
			this.label3.Enabled = ((bool)(resources.GetObject("label3.Enabled")));
			this.label3.Font = ((System.Drawing.Font)(resources.GetObject("label3.Font")));
			this.label3.ForeColor = System.Drawing.Color.FromArgb(((System.Byte)(114)), ((System.Byte)(169)), ((System.Byte)(69)));
			this.label3.Image = ((System.Drawing.Image)(resources.GetObject("label3.Image")));
			this.label3.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label3.ImageAlign")));
			this.label3.ImageIndex = ((int)(resources.GetObject("label3.ImageIndex")));
			this.label3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label3.ImeMode")));
			this.label3.Location = ((System.Drawing.Point)(resources.GetObject("label3.Location")));
			this.label3.Name = "label3";
			this.label3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label3.RightToLeft")));
			this.label3.Size = ((System.Drawing.Size)(resources.GetObject("label3.Size")));
			this.label3.TabIndex = ((int)(resources.GetObject("label3.TabIndex")));
			this.label3.Text = resources.GetString("label3.Text");
			this.label3.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label3.TextAlign")));
			this.label3.Visible = ((bool)(resources.GetObject("label3.Visible")));
			// 
			// textBox3
			// 
			this.textBox3.AccessibleDescription = resources.GetString("textBox3.AccessibleDescription");
			this.textBox3.AccessibleName = resources.GetString("textBox3.AccessibleName");
			this.textBox3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("textBox3.Anchor")));
			this.textBox3.AutoSize = ((bool)(resources.GetObject("textBox3.AutoSize")));
			this.textBox3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("textBox3.BackgroundImage")));
			this.textBox3.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.textBox3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("textBox3.Dock")));
			this.textBox3.Enabled = ((bool)(resources.GetObject("textBox3.Enabled")));
			this.textBox3.Font = ((System.Drawing.Font)(resources.GetObject("textBox3.Font")));
			this.textBox3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("textBox3.ImeMode")));
			this.textBox3.Location = ((System.Drawing.Point)(resources.GetObject("textBox3.Location")));
			this.textBox3.MaxLength = ((int)(resources.GetObject("textBox3.MaxLength")));
			this.textBox3.Multiline = ((bool)(resources.GetObject("textBox3.Multiline")));
			this.textBox3.Name = "textBox3";
			this.textBox3.PasswordChar = ((char)(resources.GetObject("textBox3.PasswordChar")));
			this.textBox3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("textBox3.RightToLeft")));
			this.textBox3.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("textBox3.ScrollBars")));
			this.textBox3.Size = ((System.Drawing.Size)(resources.GetObject("textBox3.Size")));
			this.textBox3.TabIndex = ((int)(resources.GetObject("textBox3.TabIndex")));
			this.textBox3.Text = resources.GetString("textBox3.Text");
			this.textBox3.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("textBox3.TextAlign")));
			this.textBox3.Visible = ((bool)(resources.GetObject("textBox3.Visible")));
			this.textBox3.WordWrap = ((bool)(resources.GetObject("textBox3.WordWrap")));
			// 
			// buttonEntrar
			// 
			this.buttonEntrar.AccessibleDescription = resources.GetString("buttonEntrar.AccessibleDescription");
			this.buttonEntrar.AccessibleName = resources.GetString("buttonEntrar.AccessibleName");
			this.buttonEntrar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonEntrar.Anchor")));
			this.buttonEntrar.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(73)), ((System.Byte)(134)), ((System.Byte)(31)));
			this.buttonEntrar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonEntrar.BackgroundImage")));
			this.buttonEntrar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonEntrar.Dock")));
			this.buttonEntrar.Enabled = ((bool)(resources.GetObject("buttonEntrar.Enabled")));
			this.buttonEntrar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonEntrar.FlatStyle")));
			this.buttonEntrar.Font = ((System.Drawing.Font)(resources.GetObject("buttonEntrar.Font")));
			this.buttonEntrar.ForeColor = System.Drawing.Color.White;
			this.buttonEntrar.Image = ((System.Drawing.Image)(resources.GetObject("buttonEntrar.Image")));
			this.buttonEntrar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonEntrar.ImageAlign")));
			this.buttonEntrar.ImageIndex = ((int)(resources.GetObject("buttonEntrar.ImageIndex")));
			this.buttonEntrar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonEntrar.ImeMode")));
			this.buttonEntrar.Location = ((System.Drawing.Point)(resources.GetObject("buttonEntrar.Location")));
			this.buttonEntrar.Name = "buttonEntrar";
			this.buttonEntrar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonEntrar.RightToLeft")));
			this.buttonEntrar.Size = ((System.Drawing.Size)(resources.GetObject("buttonEntrar.Size")));
			this.buttonEntrar.TabIndex = ((int)(resources.GetObject("buttonEntrar.TabIndex")));
			this.buttonEntrar.Text = resources.GetString("buttonEntrar.Text");
			this.buttonEntrar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonEntrar.TextAlign")));
			this.buttonEntrar.Visible = ((bool)(resources.GetObject("buttonEntrar.Visible")));
			this.buttonEntrar.Click += new System.EventHandler(this.button1_Click);
			// 
			// label2
			// 
			this.label2.AccessibleDescription = resources.GetString("label2.AccessibleDescription");
			this.label2.AccessibleName = resources.GetString("label2.AccessibleName");
			this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label2.Anchor")));
			this.label2.AutoSize = ((bool)(resources.GetObject("label2.AutoSize")));
			this.label2.BackColor = System.Drawing.Color.White;
			this.label2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label2.Dock")));
			this.label2.Enabled = ((bool)(resources.GetObject("label2.Enabled")));
			this.label2.Font = ((System.Drawing.Font)(resources.GetObject("label2.Font")));
			this.label2.ForeColor = System.Drawing.Color.FromArgb(((System.Byte)(114)), ((System.Byte)(169)), ((System.Byte)(69)));
			this.label2.Image = ((System.Drawing.Image)(resources.GetObject("label2.Image")));
			this.label2.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label2.ImageAlign")));
			this.label2.ImageIndex = ((int)(resources.GetObject("label2.ImageIndex")));
			this.label2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label2.ImeMode")));
			this.label2.Location = ((System.Drawing.Point)(resources.GetObject("label2.Location")));
			this.label2.Name = "label2";
			this.label2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label2.RightToLeft")));
			this.label2.Size = ((System.Drawing.Size)(resources.GetObject("label2.Size")));
			this.label2.TabIndex = ((int)(resources.GetObject("label2.TabIndex")));
			this.label2.Text = resources.GetString("label2.Text");
			this.label2.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label2.TextAlign")));
			this.label2.Visible = ((bool)(resources.GetObject("label2.Visible")));
			// 
			// label1
			// 
			this.label1.AccessibleDescription = resources.GetString("label1.AccessibleDescription");
			this.label1.AccessibleName = resources.GetString("label1.AccessibleName");
			this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label1.Anchor")));
			this.label1.AutoSize = ((bool)(resources.GetObject("label1.AutoSize")));
			this.label1.BackColor = System.Drawing.Color.White;
			this.label1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label1.Dock")));
			this.label1.Enabled = ((bool)(resources.GetObject("label1.Enabled")));
			this.label1.Font = ((System.Drawing.Font)(resources.GetObject("label1.Font")));
			this.label1.ForeColor = System.Drawing.Color.FromArgb(((System.Byte)(114)), ((System.Byte)(169)), ((System.Byte)(69)));
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
			// textBox2
			// 
			this.textBox2.AccessibleDescription = resources.GetString("textBox2.AccessibleDescription");
			this.textBox2.AccessibleName = resources.GetString("textBox2.AccessibleName");
			this.textBox2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("textBox2.Anchor")));
			this.textBox2.AutoSize = ((bool)(resources.GetObject("textBox2.AutoSize")));
			this.textBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("textBox2.BackgroundImage")));
			this.textBox2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.textBox2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("textBox2.Dock")));
			this.textBox2.Enabled = ((bool)(resources.GetObject("textBox2.Enabled")));
			this.textBox2.Font = ((System.Drawing.Font)(resources.GetObject("textBox2.Font")));
			this.textBox2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("textBox2.ImeMode")));
			this.textBox2.Location = ((System.Drawing.Point)(resources.GetObject("textBox2.Location")));
			this.textBox2.MaxLength = ((int)(resources.GetObject("textBox2.MaxLength")));
			this.textBox2.Multiline = ((bool)(resources.GetObject("textBox2.Multiline")));
			this.textBox2.Name = "textBox2";
			this.textBox2.PasswordChar = ((char)(resources.GetObject("textBox2.PasswordChar")));
			this.textBox2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("textBox2.RightToLeft")));
			this.textBox2.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("textBox2.ScrollBars")));
			this.textBox2.Size = ((System.Drawing.Size)(resources.GetObject("textBox2.Size")));
			this.textBox2.TabIndex = ((int)(resources.GetObject("textBox2.TabIndex")));
			this.textBox2.Text = resources.GetString("textBox2.Text");
			this.textBox2.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("textBox2.TextAlign")));
			this.textBox2.Visible = ((bool)(resources.GetObject("textBox2.Visible")));
			this.textBox2.WordWrap = ((bool)(resources.GetObject("textBox2.WordWrap")));
			// 
			// textBox1
			// 
			this.textBox1.AccessibleDescription = resources.GetString("textBox1.AccessibleDescription");
			this.textBox1.AccessibleName = resources.GetString("textBox1.AccessibleName");
			this.textBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("textBox1.Anchor")));
			this.textBox1.AutoSize = ((bool)(resources.GetObject("textBox1.AutoSize")));
			this.textBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("textBox1.BackgroundImage")));
			this.textBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.textBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("textBox1.Dock")));
			this.textBox1.Enabled = ((bool)(resources.GetObject("textBox1.Enabled")));
			this.textBox1.Font = ((System.Drawing.Font)(resources.GetObject("textBox1.Font")));
			this.textBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("textBox1.ImeMode")));
			this.textBox1.Location = ((System.Drawing.Point)(resources.GetObject("textBox1.Location")));
			this.textBox1.MaxLength = ((int)(resources.GetObject("textBox1.MaxLength")));
			this.textBox1.Multiline = ((bool)(resources.GetObject("textBox1.Multiline")));
			this.textBox1.Name = "textBox1";
			this.textBox1.PasswordChar = ((char)(resources.GetObject("textBox1.PasswordChar")));
			this.textBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("textBox1.RightToLeft")));
			this.textBox1.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("textBox1.ScrollBars")));
			this.textBox1.Size = ((System.Drawing.Size)(resources.GetObject("textBox1.Size")));
			this.textBox1.TabIndex = ((int)(resources.GetObject("textBox1.TabIndex")));
			this.textBox1.Text = resources.GetString("textBox1.Text");
			this.textBox1.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("textBox1.TextAlign")));
			this.textBox1.Visible = ((bool)(resources.GetObject("textBox1.Visible")));
			this.textBox1.WordWrap = ((bool)(resources.GetObject("textBox1.WordWrap")));
			// 
			// checkBoxabrir
			// 
			this.checkBoxabrir.AccessibleDescription = resources.GetString("checkBoxabrir.AccessibleDescription");
			this.checkBoxabrir.AccessibleName = resources.GetString("checkBoxabrir.AccessibleName");
			this.checkBoxabrir.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("checkBoxabrir.Anchor")));
			this.checkBoxabrir.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("checkBoxabrir.Appearance")));
			this.checkBoxabrir.BackColor = System.Drawing.Color.White;
			this.checkBoxabrir.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("checkBoxabrir.BackgroundImage")));
			this.checkBoxabrir.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxabrir.CheckAlign")));
			this.checkBoxabrir.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("checkBoxabrir.Dock")));
			this.checkBoxabrir.Enabled = ((bool)(resources.GetObject("checkBoxabrir.Enabled")));
			this.checkBoxabrir.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("checkBoxabrir.FlatStyle")));
			this.checkBoxabrir.Font = ((System.Drawing.Font)(resources.GetObject("checkBoxabrir.Font")));
			this.checkBoxabrir.ForeColor = System.Drawing.Color.FromArgb(((System.Byte)(41)), ((System.Byte)(73)), ((System.Byte)(32)));
			this.checkBoxabrir.Image = ((System.Drawing.Image)(resources.GetObject("checkBoxabrir.Image")));
			this.checkBoxabrir.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxabrir.ImageAlign")));
			this.checkBoxabrir.ImageIndex = ((int)(resources.GetObject("checkBoxabrir.ImageIndex")));
			this.checkBoxabrir.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("checkBoxabrir.ImeMode")));
			this.checkBoxabrir.Location = ((System.Drawing.Point)(resources.GetObject("checkBoxabrir.Location")));
			this.checkBoxabrir.Name = "checkBoxabrir";
			this.checkBoxabrir.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("checkBoxabrir.RightToLeft")));
			this.checkBoxabrir.Size = ((System.Drawing.Size)(resources.GetObject("checkBoxabrir.Size")));
			this.checkBoxabrir.TabIndex = ((int)(resources.GetObject("checkBoxabrir.TabIndex")));
			this.checkBoxabrir.Text = resources.GetString("checkBoxabrir.Text");
			this.checkBoxabrir.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxabrir.TextAlign")));
			this.checkBoxabrir.Visible = ((bool)(resources.GetObject("checkBoxabrir.Visible")));
			// 
			// label4
			// 
			this.label4.AccessibleDescription = resources.GetString("label4.AccessibleDescription");
			this.label4.AccessibleName = resources.GetString("label4.AccessibleName");
			this.label4.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label4.Anchor")));
			this.label4.AutoSize = ((bool)(resources.GetObject("label4.AutoSize")));
			this.label4.BackColor = System.Drawing.Color.White;
			this.label4.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label4.Dock")));
			this.label4.Enabled = ((bool)(resources.GetObject("label4.Enabled")));
			this.label4.Font = ((System.Drawing.Font)(resources.GetObject("label4.Font")));
			this.label4.Image = ((System.Drawing.Image)(resources.GetObject("label4.Image")));
			this.label4.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label4.ImageAlign")));
			this.label4.ImageIndex = ((int)(resources.GetObject("label4.ImageIndex")));
			this.label4.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label4.ImeMode")));
			this.label4.Location = ((System.Drawing.Point)(resources.GetObject("label4.Location")));
			this.label4.Name = "label4";
			this.label4.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label4.RightToLeft")));
			this.label4.Size = ((System.Drawing.Size)(resources.GetObject("label4.Size")));
			this.label4.TabIndex = ((int)(resources.GetObject("label4.TabIndex")));
			this.label4.Text = resources.GetString("label4.Text");
			this.label4.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label4.TextAlign")));
			this.label4.Visible = ((bool)(resources.GetObject("label4.Visible")));
			// 
			// button3
			// 
			this.button3.AccessibleDescription = resources.GetString("button3.AccessibleDescription");
			this.button3.AccessibleName = resources.GetString("button3.AccessibleName");
			this.button3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("button3.Anchor")));
			this.button3.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(73)), ((System.Byte)(134)), ((System.Byte)(31)));
			this.button3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("button3.BackgroundImage")));
			this.button3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("button3.Dock")));
			this.button3.Enabled = ((bool)(resources.GetObject("button3.Enabled")));
			this.button3.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("button3.FlatStyle")));
			this.button3.Font = ((System.Drawing.Font)(resources.GetObject("button3.Font")));
			this.button3.ForeColor = System.Drawing.Color.White;
			this.button3.Image = ((System.Drawing.Image)(resources.GetObject("button3.Image")));
			this.button3.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button3.ImageAlign")));
			this.button3.ImageIndex = ((int)(resources.GetObject("button3.ImageIndex")));
			this.button3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("button3.ImeMode")));
			this.button3.Location = ((System.Drawing.Point)(resources.GetObject("button3.Location")));
			this.button3.Name = "button3";
			this.button3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("button3.RightToLeft")));
			this.button3.Size = ((System.Drawing.Size)(resources.GetObject("button3.Size")));
			this.button3.TabIndex = ((int)(resources.GetObject("button3.TabIndex")));
			this.button3.Text = resources.GetString("button3.Text");
			this.button3.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button3.TextAlign")));
			this.button3.Visible = ((bool)(resources.GetObject("button3.Visible")));
			this.button3.Click += new System.EventHandler(this.button3_Click);
			// 
			// label5
			// 
			this.label5.AccessibleDescription = resources.GetString("label5.AccessibleDescription");
			this.label5.AccessibleName = resources.GetString("label5.AccessibleName");
			this.label5.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label5.Anchor")));
			this.label5.AutoSize = ((bool)(resources.GetObject("label5.AutoSize")));
			this.label5.BackColor = System.Drawing.Color.White;
			this.label5.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label5.Dock")));
			this.label5.Enabled = ((bool)(resources.GetObject("label5.Enabled")));
			this.label5.Font = ((System.Drawing.Font)(resources.GetObject("label5.Font")));
			this.label5.Image = ((System.Drawing.Image)(resources.GetObject("label5.Image")));
			this.label5.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label5.ImageAlign")));
			this.label5.ImageIndex = ((int)(resources.GetObject("label5.ImageIndex")));
			this.label5.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label5.ImeMode")));
			this.label5.Location = ((System.Drawing.Point)(resources.GetObject("label5.Location")));
			this.label5.Name = "label5";
			this.label5.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label5.RightToLeft")));
			this.label5.Size = ((System.Drawing.Size)(resources.GetObject("label5.Size")));
			this.label5.TabIndex = ((int)(resources.GetObject("label5.TabIndex")));
			this.label5.Text = resources.GetString("label5.Text");
			this.label5.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label5.TextAlign")));
			this.label5.Visible = ((bool)(resources.GetObject("label5.Visible")));
			// 
			// FrmSplash
			// 
			this.AcceptButton = this.buttonEntrar;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.buttonSalir;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.textBox2);
			this.Controls.Add(this.label5);
			this.Controls.Add(this.textBox3);
			this.Controls.Add(this.textBox1);
			this.Controls.Add(this.button3);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.checkBoxabrir);
			this.Controls.Add(this.buttonSalir);
			this.Controls.Add(this.checkBox1);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.buttonEntrar);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.pictureBox1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmSplash";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.Load += new System.EventHandler(this.FrmSplash_Load);
			this.Activated += new System.EventHandler(this.FrmSplash_Activated);
			this.ResumeLayout(false);

		}
		#endregion

		private void button2_Click(object sender, System.EventArgs e)
		{
			//CWebBuilder.user=null;
			this.Close();
		}

		private void button1_Click(object sender, System.EventArgs e)
		{
			this.Cursor=Cursors.WaitCursor; 
			CConfig c= new CConfig();
			if(this.textBox1.Text.Trim().Equals(""))
			{
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				this.textBox1.Focus(); 
				return;
			}
			if(this.textBox2.Text.Trim().Equals(""))
			{
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg2"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				this.textBox2.Focus(); 
				return;
			}
			try
			{
				System.Uri uri=new System.Uri(this.textBox3.Text);
			}
			catch(System.UriFormatException urfe)
			{
				Console.WriteLine(urfe.Message); 
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				if(!c.Web.Equals(""))
				{
					this.textBox3.Text=c.Web;
					this.textBox3.Focus(); 
				}				
				return;
			}
			if(!(this.textBox3.Text.StartsWith("http://") || this.textBox3.Text.StartsWith("https://")))
			{
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg4"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				this.textBox3.Focus(); 
				return;
			}
			if(!this.textBox3.Text.EndsWith("/"))
			{
				this.textBox3.Text+="/";
			}
			if(checkBox1.Checked)
			{
				
				c.Password=this.textBox2.Text;
				c.User=this.textBox1.Text;
				c.Web=this.textBox3.Text;  
				
				
			}
			else
			{
				c.Password="";
				c.User="";
				c.Web="";
				
			}	
			if(this.checkBoxabrir.Checked) 
			{
				c.Startup="1"; 		
			}
			else
			{
				c.Startup="0"; 		
			}
			c.Password="";
			c.PortProxy=Int32.Parse(this.portserverproxy);
			c.ServerProxy=this.proxyserver; 
			c.Save();		
			
			try
			{
				

				user.User=this.textBox1.Text;
				user.Password=this.textBox2.Text;
				user.Uri=this.textBox3.Text;
				CExcel.user=user;				
				Servicios s= new Servicios(user);
				CRequest.sesion=null;	
				CExcel.user.ServerProxy=this.proxyserver;
				CExcel.user.PortServerProxy=Int32.Parse(this.portserverproxy); 
				s.login();	
				if(!s.IsError) 
				{					
					           
					/*try
					{
						CExcel.Connect.mLogin.Enabled=false;
						CExcel.Connect.mLogout.Enabled=true;
					}
					catch{}*/
					MessageBox.Show(this,resources.GetString("FrmSplash.msg5"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
					this.Close();
					this.Cursor=Cursors.Default; 
					return;
				}
				else
				{
					if(s.Error==0)
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg6"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox1.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
					if(s.Error==-500)
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox1.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
					else if(s.Error==-404)
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox3.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
					else
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox3.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
				}
			}
			catch(System.UriFormatException uri)
			{
				Console.WriteLine(uri.Message); 
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg7"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
			}
			this.Cursor=Cursors.Default; 
			
		}

		private void FrmSplash_Load(object sender, System.EventArgs e)
		{

			CConfig c= new CConfig();
			this.textBox1.Text=c.User;
			this.textBox2.Text=c.Password;
			this.textBox3.Text=c.Web;
			if(!c.User.Equals("") || !c.Password.Equals("") || !c.Web.Equals(""))
			{
				this.checkBox1.Checked=true;  
			}
			if(c.Startup.Equals("1"))
			{
				this.checkBoxabrir.Checked=true;  
			}
			else
			{
				this.checkBoxabrir.Checked=false;  
			}

			this.proxyserver=c.ServerProxy;  
			this.portserverproxy=""+c.PortProxy;  
			

		}

		private void button3_Click(object sender, System.EventArgs e)
		{
			FrmConfigProxy frm=new FrmConfigProxy(this.proxyserver,this.portserverproxy);
			frm.ShowDialog(this);
			this.proxyserver=frm.proxyserver;
			this.portserverproxy=frm.portserverproxy;
		}

		private void FrmSplash_Activated(object sender, System.EventArgs e)
		{
			if(this.textBox1.Text.Length>0)
			{
				this.textBox2.Focus(); 
			}
		}
		
		
	}
}
