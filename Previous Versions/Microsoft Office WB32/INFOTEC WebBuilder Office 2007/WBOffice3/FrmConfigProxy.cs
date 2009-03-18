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

namespace WBOffice3
{
	/// <summary>
	/// Forma que presenta la configuración proxy usada para conectarse al
	/// servidor
	/// </summary>
	public class FrmConfigProxy : System.Windows.Forms.Form
	{
		/// <summary>Contiene la dirección del servidor proxy a usar para conectarse a WB</summary>
		/// <value>La dirección del servidor proxy a usar para conectarse a WB</value>
		public String proxyserver;
		/// <summary>Contiene el puerto del servidor proxy a usar para conectarse a WB</summary>
		/// <value>El puerto del servidor proxy a usar para conectarse a WB</value>
		public String portserverproxy;
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.CheckBox checkBox1;
		private System.Windows.Forms.Button buttonAceptar;
		private System.Windows.Forms.Button buttonCancelar;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.TextBox txtport;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.TextBox txtserver;
		private System.Windows.Forms.Label label1;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		/// <summary>Contruye una forma para configurar la conexión vía proxy</summary>
		/// <param name="proxyserver">
		/// Dirección proxy almacenada con anterioridad, si es nulo, indica que no se ha
		/// configurado un puerto proxy.
		/// </param>
		/// <param name="portserverproxy">Puerto proxy almacenada con anterioridad</param>
		public FrmConfigProxy(String proxyserver,String portserverproxy)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.proxyserver=proxyserver;
			this.portserverproxy=portserverproxy;
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmConfigProxy));
			this.checkBox1 = new System.Windows.Forms.CheckBox();
			this.buttonAceptar = new System.Windows.Forms.Button();
			this.buttonCancelar = new System.Windows.Forms.Button();
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.txtport = new System.Windows.Forms.TextBox();
			this.label2 = new System.Windows.Forms.Label();
			this.txtserver = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.groupBox1.SuspendLayout();
			this.SuspendLayout();
			// 
			// checkBox1
			// 
			this.checkBox1.AccessibleDescription = resources.GetString("checkBox1.AccessibleDescription");
			this.checkBox1.AccessibleName = resources.GetString("checkBox1.AccessibleName");
			this.checkBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("checkBox1.Anchor")));
			this.checkBox1.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("checkBox1.Appearance")));
			this.checkBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("checkBox1.BackgroundImage")));
			this.checkBox1.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBox1.CheckAlign")));
			this.checkBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("checkBox1.Dock")));
			this.checkBox1.Enabled = ((bool)(resources.GetObject("checkBox1.Enabled")));
			this.checkBox1.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("checkBox1.FlatStyle")));
			this.checkBox1.Font = ((System.Drawing.Font)(resources.GetObject("checkBox1.Font")));
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
			this.checkBox1.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
			// 
			// buttonAceptar
			// 
			this.buttonAceptar.AccessibleDescription = resources.GetString("buttonAceptar.AccessibleDescription");
			this.buttonAceptar.AccessibleName = resources.GetString("buttonAceptar.AccessibleName");
			this.buttonAceptar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonAceptar.Anchor")));
			this.buttonAceptar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonAceptar.BackgroundImage")));
			this.buttonAceptar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonAceptar.Dock")));
			this.buttonAceptar.Enabled = ((bool)(resources.GetObject("buttonAceptar.Enabled")));
			this.buttonAceptar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonAceptar.FlatStyle")));
			this.buttonAceptar.Font = ((System.Drawing.Font)(resources.GetObject("buttonAceptar.Font")));
			this.buttonAceptar.Image = ((System.Drawing.Image)(resources.GetObject("buttonAceptar.Image")));
			this.buttonAceptar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAceptar.ImageAlign")));
			this.buttonAceptar.ImageIndex = ((int)(resources.GetObject("buttonAceptar.ImageIndex")));
			this.buttonAceptar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonAceptar.ImeMode")));
			this.buttonAceptar.Location = ((System.Drawing.Point)(resources.GetObject("buttonAceptar.Location")));
			this.buttonAceptar.Name = "buttonAceptar";
			this.buttonAceptar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonAceptar.RightToLeft")));
			this.buttonAceptar.Size = ((System.Drawing.Size)(resources.GetObject("buttonAceptar.Size")));
			this.buttonAceptar.TabIndex = ((int)(resources.GetObject("buttonAceptar.TabIndex")));
			this.buttonAceptar.Text = resources.GetString("buttonAceptar.Text");
			this.buttonAceptar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAceptar.TextAlign")));
			this.buttonAceptar.Visible = ((bool)(resources.GetObject("buttonAceptar.Visible")));
			this.buttonAceptar.Click += new System.EventHandler(this.buttonAceptar_Click);
			// 
			// buttonCancelar
			// 
			this.buttonCancelar.AccessibleDescription = resources.GetString("buttonCancelar.AccessibleDescription");
			this.buttonCancelar.AccessibleName = resources.GetString("buttonCancelar.AccessibleName");
			this.buttonCancelar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonCancelar.Anchor")));
			this.buttonCancelar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonCancelar.BackgroundImage")));
			this.buttonCancelar.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.buttonCancelar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonCancelar.Dock")));
			this.buttonCancelar.Enabled = ((bool)(resources.GetObject("buttonCancelar.Enabled")));
			this.buttonCancelar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonCancelar.FlatStyle")));
			this.buttonCancelar.Font = ((System.Drawing.Font)(resources.GetObject("buttonCancelar.Font")));
			this.buttonCancelar.Image = ((System.Drawing.Image)(resources.GetObject("buttonCancelar.Image")));
			this.buttonCancelar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancelar.ImageAlign")));
			this.buttonCancelar.ImageIndex = ((int)(resources.GetObject("buttonCancelar.ImageIndex")));
			this.buttonCancelar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonCancelar.ImeMode")));
			this.buttonCancelar.Location = ((System.Drawing.Point)(resources.GetObject("buttonCancelar.Location")));
			this.buttonCancelar.Name = "buttonCancelar";
			this.buttonCancelar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonCancelar.RightToLeft")));
			this.buttonCancelar.Size = ((System.Drawing.Size)(resources.GetObject("buttonCancelar.Size")));
			this.buttonCancelar.TabIndex = ((int)(resources.GetObject("buttonCancelar.TabIndex")));
			this.buttonCancelar.Text = resources.GetString("buttonCancelar.Text");
			this.buttonCancelar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancelar.TextAlign")));
			this.buttonCancelar.Visible = ((bool)(resources.GetObject("buttonCancelar.Visible")));
			this.buttonCancelar.Click += new System.EventHandler(this.buttonCancelar_Click);
			// 
			// groupBox1
			// 
			this.groupBox1.AccessibleDescription = resources.GetString("groupBox1.AccessibleDescription");
			this.groupBox1.AccessibleName = resources.GetString("groupBox1.AccessibleName");
			this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox1.Anchor")));
			this.groupBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox1.BackgroundImage")));
			this.groupBox1.Controls.Add(this.txtport);
			this.groupBox1.Controls.Add(this.label2);
			this.groupBox1.Controls.Add(this.txtserver);
			this.groupBox1.Controls.Add(this.label1);
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
			// txtport
			// 
			this.txtport.AccessibleDescription = resources.GetString("txtport.AccessibleDescription");
			this.txtport.AccessibleName = resources.GetString("txtport.AccessibleName");
			this.txtport.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtport.Anchor")));
			this.txtport.AutoSize = ((bool)(resources.GetObject("txtport.AutoSize")));
			this.txtport.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtport.BackgroundImage")));
			this.txtport.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtport.Dock")));
			this.txtport.Enabled = ((bool)(resources.GetObject("txtport.Enabled")));
			this.txtport.Font = ((System.Drawing.Font)(resources.GetObject("txtport.Font")));
			this.txtport.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtport.ImeMode")));
			this.txtport.Location = ((System.Drawing.Point)(resources.GetObject("txtport.Location")));
			this.txtport.MaxLength = ((int)(resources.GetObject("txtport.MaxLength")));
			this.txtport.Multiline = ((bool)(resources.GetObject("txtport.Multiline")));
			this.txtport.Name = "txtport";
			this.txtport.PasswordChar = ((char)(resources.GetObject("txtport.PasswordChar")));
			this.txtport.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtport.RightToLeft")));
			this.txtport.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtport.ScrollBars")));
			this.txtport.Size = ((System.Drawing.Size)(resources.GetObject("txtport.Size")));
			this.txtport.TabIndex = ((int)(resources.GetObject("txtport.TabIndex")));
			this.txtport.Text = resources.GetString("txtport.Text");
			this.txtport.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtport.TextAlign")));
			this.txtport.Visible = ((bool)(resources.GetObject("txtport.Visible")));
			this.txtport.WordWrap = ((bool)(resources.GetObject("txtport.WordWrap")));
			this.txtport.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtport_KeyPress);
			// 
			// label2
			// 
			this.label2.AccessibleDescription = resources.GetString("label2.AccessibleDescription");
			this.label2.AccessibleName = resources.GetString("label2.AccessibleName");
			this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label2.Anchor")));
			this.label2.AutoSize = ((bool)(resources.GetObject("label2.AutoSize")));
			this.label2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label2.Dock")));
			this.label2.Enabled = ((bool)(resources.GetObject("label2.Enabled")));
			this.label2.Font = ((System.Drawing.Font)(resources.GetObject("label2.Font")));
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
			// txtserver
			// 
			this.txtserver.AccessibleDescription = resources.GetString("txtserver.AccessibleDescription");
			this.txtserver.AccessibleName = resources.GetString("txtserver.AccessibleName");
			this.txtserver.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtserver.Anchor")));
			this.txtserver.AutoSize = ((bool)(resources.GetObject("txtserver.AutoSize")));
			this.txtserver.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtserver.BackgroundImage")));
			this.txtserver.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtserver.Dock")));
			this.txtserver.Enabled = ((bool)(resources.GetObject("txtserver.Enabled")));
			this.txtserver.Font = ((System.Drawing.Font)(resources.GetObject("txtserver.Font")));
			this.txtserver.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtserver.ImeMode")));
			this.txtserver.Location = ((System.Drawing.Point)(resources.GetObject("txtserver.Location")));
			this.txtserver.MaxLength = ((int)(resources.GetObject("txtserver.MaxLength")));
			this.txtserver.Multiline = ((bool)(resources.GetObject("txtserver.Multiline")));
			this.txtserver.Name = "txtserver";
			this.txtserver.PasswordChar = ((char)(resources.GetObject("txtserver.PasswordChar")));
			this.txtserver.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtserver.RightToLeft")));
			this.txtserver.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtserver.ScrollBars")));
			this.txtserver.Size = ((System.Drawing.Size)(resources.GetObject("txtserver.Size")));
			this.txtserver.TabIndex = ((int)(resources.GetObject("txtserver.TabIndex")));
			this.txtserver.Text = resources.GetString("txtserver.Text");
			this.txtserver.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtserver.TextAlign")));
			this.txtserver.Visible = ((bool)(resources.GetObject("txtserver.Visible")));
			this.txtserver.WordWrap = ((bool)(resources.GetObject("txtserver.WordWrap")));
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
			// FrmConfigProxy
			// 
			this.AcceptButton = this.buttonAceptar;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.buttonCancelar;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.ControlBox = false;
			this.Controls.Add(this.groupBox1);
			this.Controls.Add(this.checkBox1);
			this.Controls.Add(this.buttonAceptar);
			this.Controls.Add(this.buttonCancelar);
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
			this.Name = "FrmConfigProxy";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.Load += new System.EventHandler(this.FrmConfigProxy_Load);
			this.groupBox1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonCancelar_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void buttonAceptar_Click(object sender, System.EventArgs e)
		{
			if(this.checkBox1.Checked)
			{
				if(this.txtserver.Text.Trim().Equals(""))
				{
					MessageBox.Show(this,resources.GetString("FrmConfigProxy.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return;
				}
				if(this.txtport.Text.Trim().Equals(""))
				{
					MessageBox.Show(this,resources.GetString("FrmConfigProxy.msg2"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return;
				}
			}
			else
			{
				this.txtserver.Text="";
				this.txtport.Text="80"; 
			}
			proxyserver=this.txtserver.Text;
			portserverproxy=this.txtport.Text;  
			this.Close();
		}

		private void checkBox1_CheckedChanged(object sender, System.EventArgs e)
		{
			if(this.checkBox1.Checked)
			{
				this.txtserver.Enabled=true;
				this.txtport.Text="";
				this.txtport.Text="80"; 
				this.txtport.Enabled=true;
				this.groupBox1.Enabled=true;
			}
			else
			{
				this.txtserver.Text="";
				this.txtport.Text=""; 
				this.txtserver.Enabled=false;
				this.txtport.Enabled=false;
				this.groupBox1.Enabled=false;
			}
		}

		private void txtport_KeyPress(object sender, System.Windows.Forms.KeyPressEventArgs e)
		{
			int ichar=e.KeyChar;
			if(ichar==8)
			{
				return; 
			}
			if(ichar>=48 && ichar<=57)
			{
				return; 
			}
			e.Handled=true; 
		}

		private void FrmConfigProxy_Load(object sender, System.EventArgs e)
		{
			
			this.txtserver.Text=proxyserver;
			this.txtport.Text=portserverproxy;	
			if(this.txtserver.Text.Equals(""))
			{
				this.checkBox1.Checked=false; 
				this.txtserver.Enabled=false;
				this.txtport.Text="";
				this.txtport.Enabled=false;

			}
			else
			{
				this.checkBox1.Checked=true; 
				this.txtserver.Enabled=true;
				this.txtport.Enabled=true;
				this.txtserver.Text=proxyserver;
				this.txtport.Text=portserverproxy;
			}
		}
	}
}
