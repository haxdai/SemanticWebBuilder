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
	/// <summary>Forma pora cambiar el password de un usuario</summary>
	public class FrmPassword : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.TextBox txtconf;
		private System.Windows.Forms.TextBox txtpwd;
		private System.Windows.Forms.TextBox txtlogin;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Button butoncancel;
		private System.Windows.Forms.Button buttonok;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		CUserAdmin user;
		/// <summary>
		/// Constructor de forma para cambiar password
		/// </summary>
		/// <param name="user">Usuario que va a cambiar password</param>
		public FrmPassword(CUserAdmin user)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.txtlogin.Text=user.User;  
			this.user=user;
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmPassword));
			this.txtconf = new System.Windows.Forms.TextBox();
			this.txtpwd = new System.Windows.Forms.TextBox();
			this.txtlogin = new System.Windows.Forms.TextBox();
			this.label3 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.butoncancel = new System.Windows.Forms.Button();
			this.buttonok = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// txtconf
			// 
			this.txtconf.AccessibleDescription = resources.GetString("txtconf.AccessibleDescription");
			this.txtconf.AccessibleName = resources.GetString("txtconf.AccessibleName");
			this.txtconf.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtconf.Anchor")));
			this.txtconf.AutoSize = ((bool)(resources.GetObject("txtconf.AutoSize")));
			this.txtconf.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtconf.BackgroundImage")));
			this.txtconf.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtconf.Dock")));
			this.txtconf.Enabled = ((bool)(resources.GetObject("txtconf.Enabled")));
			this.txtconf.Font = ((System.Drawing.Font)(resources.GetObject("txtconf.Font")));
			this.txtconf.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtconf.ImeMode")));
			this.txtconf.Location = ((System.Drawing.Point)(resources.GetObject("txtconf.Location")));
			this.txtconf.MaxLength = ((int)(resources.GetObject("txtconf.MaxLength")));
			this.txtconf.Multiline = ((bool)(resources.GetObject("txtconf.Multiline")));
			this.txtconf.Name = "txtconf";
			this.txtconf.PasswordChar = ((char)(resources.GetObject("txtconf.PasswordChar")));
			this.txtconf.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtconf.RightToLeft")));
			this.txtconf.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtconf.ScrollBars")));
			this.txtconf.Size = ((System.Drawing.Size)(resources.GetObject("txtconf.Size")));
			this.txtconf.TabIndex = ((int)(resources.GetObject("txtconf.TabIndex")));
			this.txtconf.Text = resources.GetString("txtconf.Text");
			this.txtconf.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtconf.TextAlign")));
			this.txtconf.Visible = ((bool)(resources.GetObject("txtconf.Visible")));
			this.txtconf.WordWrap = ((bool)(resources.GetObject("txtconf.WordWrap")));
			// 
			// txtpwd
			// 
			this.txtpwd.AccessibleDescription = resources.GetString("txtpwd.AccessibleDescription");
			this.txtpwd.AccessibleName = resources.GetString("txtpwd.AccessibleName");
			this.txtpwd.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtpwd.Anchor")));
			this.txtpwd.AutoSize = ((bool)(resources.GetObject("txtpwd.AutoSize")));
			this.txtpwd.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtpwd.BackgroundImage")));
			this.txtpwd.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtpwd.Dock")));
			this.txtpwd.Enabled = ((bool)(resources.GetObject("txtpwd.Enabled")));
			this.txtpwd.Font = ((System.Drawing.Font)(resources.GetObject("txtpwd.Font")));
			this.txtpwd.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtpwd.ImeMode")));
			this.txtpwd.Location = ((System.Drawing.Point)(resources.GetObject("txtpwd.Location")));
			this.txtpwd.MaxLength = ((int)(resources.GetObject("txtpwd.MaxLength")));
			this.txtpwd.Multiline = ((bool)(resources.GetObject("txtpwd.Multiline")));
			this.txtpwd.Name = "txtpwd";
			this.txtpwd.PasswordChar = ((char)(resources.GetObject("txtpwd.PasswordChar")));
			this.txtpwd.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtpwd.RightToLeft")));
			this.txtpwd.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtpwd.ScrollBars")));
			this.txtpwd.Size = ((System.Drawing.Size)(resources.GetObject("txtpwd.Size")));
			this.txtpwd.TabIndex = ((int)(resources.GetObject("txtpwd.TabIndex")));
			this.txtpwd.Text = resources.GetString("txtpwd.Text");
			this.txtpwd.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtpwd.TextAlign")));
			this.txtpwd.Visible = ((bool)(resources.GetObject("txtpwd.Visible")));
			this.txtpwd.WordWrap = ((bool)(resources.GetObject("txtpwd.WordWrap")));
			// 
			// txtlogin
			// 
			this.txtlogin.AccessibleDescription = resources.GetString("txtlogin.AccessibleDescription");
			this.txtlogin.AccessibleName = resources.GetString("txtlogin.AccessibleName");
			this.txtlogin.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtlogin.Anchor")));
			this.txtlogin.AutoSize = ((bool)(resources.GetObject("txtlogin.AutoSize")));
			this.txtlogin.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtlogin.BackgroundImage")));
			this.txtlogin.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtlogin.Dock")));
			this.txtlogin.Enabled = ((bool)(resources.GetObject("txtlogin.Enabled")));
			this.txtlogin.Font = ((System.Drawing.Font)(resources.GetObject("txtlogin.Font")));
			this.txtlogin.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtlogin.ImeMode")));
			this.txtlogin.Location = ((System.Drawing.Point)(resources.GetObject("txtlogin.Location")));
			this.txtlogin.MaxLength = ((int)(resources.GetObject("txtlogin.MaxLength")));
			this.txtlogin.Multiline = ((bool)(resources.GetObject("txtlogin.Multiline")));
			this.txtlogin.Name = "txtlogin";
			this.txtlogin.PasswordChar = ((char)(resources.GetObject("txtlogin.PasswordChar")));
			this.txtlogin.ReadOnly = true;
			this.txtlogin.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtlogin.RightToLeft")));
			this.txtlogin.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtlogin.ScrollBars")));
			this.txtlogin.Size = ((System.Drawing.Size)(resources.GetObject("txtlogin.Size")));
			this.txtlogin.TabIndex = ((int)(resources.GetObject("txtlogin.TabIndex")));
			this.txtlogin.Text = resources.GetString("txtlogin.Text");
			this.txtlogin.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtlogin.TextAlign")));
			this.txtlogin.Visible = ((bool)(resources.GetObject("txtlogin.Visible")));
			this.txtlogin.WordWrap = ((bool)(resources.GetObject("txtlogin.WordWrap")));
			// 
			// label3
			// 
			this.label3.AccessibleDescription = resources.GetString("label3.AccessibleDescription");
			this.label3.AccessibleName = resources.GetString("label3.AccessibleName");
			this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label3.Anchor")));
			this.label3.AutoSize = ((bool)(resources.GetObject("label3.AutoSize")));
			this.label3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label3.Dock")));
			this.label3.Enabled = ((bool)(resources.GetObject("label3.Enabled")));
			this.label3.Font = ((System.Drawing.Font)(resources.GetObject("label3.Font")));
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
			// butoncancel
			// 
			this.butoncancel.AccessibleDescription = resources.GetString("butoncancel.AccessibleDescription");
			this.butoncancel.AccessibleName = resources.GetString("butoncancel.AccessibleName");
			this.butoncancel.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("butoncancel.Anchor")));
			this.butoncancel.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("butoncancel.BackgroundImage")));
			this.butoncancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.butoncancel.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("butoncancel.Dock")));
			this.butoncancel.Enabled = ((bool)(resources.GetObject("butoncancel.Enabled")));
			this.butoncancel.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("butoncancel.FlatStyle")));
			this.butoncancel.Font = ((System.Drawing.Font)(resources.GetObject("butoncancel.Font")));
			this.butoncancel.Image = ((System.Drawing.Image)(resources.GetObject("butoncancel.Image")));
			this.butoncancel.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("butoncancel.ImageAlign")));
			this.butoncancel.ImageIndex = ((int)(resources.GetObject("butoncancel.ImageIndex")));
			this.butoncancel.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("butoncancel.ImeMode")));
			this.butoncancel.Location = ((System.Drawing.Point)(resources.GetObject("butoncancel.Location")));
			this.butoncancel.Name = "butoncancel";
			this.butoncancel.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("butoncancel.RightToLeft")));
			this.butoncancel.Size = ((System.Drawing.Size)(resources.GetObject("butoncancel.Size")));
			this.butoncancel.TabIndex = ((int)(resources.GetObject("butoncancel.TabIndex")));
			this.butoncancel.Text = resources.GetString("butoncancel.Text");
			this.butoncancel.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("butoncancel.TextAlign")));
			this.butoncancel.Visible = ((bool)(resources.GetObject("butoncancel.Visible")));
			this.butoncancel.Click += new System.EventHandler(this.butoncancel_Click);
			// 
			// buttonok
			// 
			this.buttonok.AccessibleDescription = resources.GetString("buttonok.AccessibleDescription");
			this.buttonok.AccessibleName = resources.GetString("buttonok.AccessibleName");
			this.buttonok.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonok.Anchor")));
			this.buttonok.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonok.BackgroundImage")));
			this.buttonok.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonok.Dock")));
			this.buttonok.Enabled = ((bool)(resources.GetObject("buttonok.Enabled")));
			this.buttonok.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonok.FlatStyle")));
			this.buttonok.Font = ((System.Drawing.Font)(resources.GetObject("buttonok.Font")));
			this.buttonok.Image = ((System.Drawing.Image)(resources.GetObject("buttonok.Image")));
			this.buttonok.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonok.ImageAlign")));
			this.buttonok.ImageIndex = ((int)(resources.GetObject("buttonok.ImageIndex")));
			this.buttonok.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonok.ImeMode")));
			this.buttonok.Location = ((System.Drawing.Point)(resources.GetObject("buttonok.Location")));
			this.buttonok.Name = "buttonok";
			this.buttonok.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonok.RightToLeft")));
			this.buttonok.Size = ((System.Drawing.Size)(resources.GetObject("buttonok.Size")));
			this.buttonok.TabIndex = ((int)(resources.GetObject("buttonok.TabIndex")));
			this.buttonok.Text = resources.GetString("buttonok.Text");
			this.buttonok.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonok.TextAlign")));
			this.buttonok.Visible = ((bool)(resources.GetObject("buttonok.Visible")));
			this.buttonok.Click += new System.EventHandler(this.buttonok_Click);
			// 
			// FrmPassword
			// 
			this.AcceptButton = this.buttonok;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.butoncancel;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.butoncancel);
			this.Controls.Add(this.buttonok);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.txtconf);
			this.Controls.Add(this.txtpwd);
			this.Controls.Add(this.txtlogin);
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
			this.Name = "FrmPassword";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonok_Click(object sender, System.EventArgs e)
		{
			if(this.txtpwd.Text.Equals(""))
			{
				MessageBox.Show(this,resources.GetString("FrmPassword.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return;
			}
			if(!this.txtpwd.Text.Equals(this.txtconf.Text))
			{
				MessageBox.Show(this,resources.GetString("FrmPassword.msg2"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return;
			}
			Servicios s= new Servicios(user);
			s.changePassword(user.ID,user.User,user.Password,this.txtpwd.Text);    
			if(!s.IsError)
			{
				MessageBox.Show(this,resources.GetString("FrmPassword.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);
			}			
			else
			{
				MessageBox.Show(this,resources.GetString("FrmPassword.msg4"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);
			}
			this.Close();
		}

		private void butoncancel_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}
	}
}
