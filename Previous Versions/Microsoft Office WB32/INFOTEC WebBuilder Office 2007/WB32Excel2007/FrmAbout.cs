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
using System.Reflection;
using System.Diagnostics;
using WBOffice3;
using System.Xml;
namespace WBExcel
{
	/// <summary>Forma para mostrar acerca de</summary>
	class FrmAbout : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Button buttonAceptar;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label label1;
		/// <summary>Lista de imagenes asociada a la forma</summary>
		/// <value>Lista de imagenes asociada a la forma</value>
		public System.Windows.Forms.ImageList imageList2;
		private System.Windows.Forms.Label lblVersionCore;
		private System.ComponentModel.IContainer components;

		public FrmAbout()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			
			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			if(CExcel.user!=null && CExcel.user.ID>=0)
			{
				Servicios s=new Servicios(CExcel.user);
				XmlDocument doc=s.getVersionCore();
				if(doc.GetElementsByTagName("VersionCore").Count>0)
				{
					this.lblVersionCore.Text+=" "+doc.GetElementsByTagName("VersionCore")[0].InnerText;					
				}
				else
				{
					this.lblVersionCore.Text+=" The user must be logged";
				}
			}
			else
			{
				this.lblVersionCore.Text+=" The user must be logged";
			}

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
			this.label1.Text="Prod No. "+  version		+"";
			
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
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmAbout));
			this.buttonAceptar = new System.Windows.Forms.Button();
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.label4 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.imageList2 = new System.Windows.Forms.ImageList(this.components);
			this.lblVersionCore = new System.Windows.Forms.Label();
			this.SuspendLayout();
			// 
			// buttonAceptar
			// 
			this.buttonAceptar.AccessibleDescription = resources.GetString("buttonAceptar.AccessibleDescription");
			this.buttonAceptar.AccessibleName = resources.GetString("buttonAceptar.AccessibleName");
			this.buttonAceptar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonAceptar.Anchor")));
			this.buttonAceptar.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(73)), ((System.Byte)(134)), ((System.Byte)(31)));
			this.buttonAceptar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonAceptar.BackgroundImage")));
			this.buttonAceptar.Cursor = System.Windows.Forms.Cursors.Hand;
			this.buttonAceptar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonAceptar.Dock")));
			this.buttonAceptar.Enabled = ((bool)(resources.GetObject("buttonAceptar.Enabled")));
			this.buttonAceptar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonAceptar.FlatStyle")));
			this.buttonAceptar.Font = ((System.Drawing.Font)(resources.GetObject("buttonAceptar.Font")));
			this.buttonAceptar.ForeColor = System.Drawing.Color.White;
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
			// imageList2
			// 
			this.imageList2.ColorDepth = System.Windows.Forms.ColorDepth.Depth32Bit;
			this.imageList2.ImageSize = ((System.Drawing.Size)(resources.GetObject("imageList2.ImageSize")));
			this.imageList2.TransparentColor = System.Drawing.Color.DarkGray;
			// 
			// lblVersionCore
			// 
			this.lblVersionCore.AccessibleDescription = resources.GetString("lblVersionCore.AccessibleDescription");
			this.lblVersionCore.AccessibleName = resources.GetString("lblVersionCore.AccessibleName");
			this.lblVersionCore.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lblVersionCore.Anchor")));
			this.lblVersionCore.AutoSize = ((bool)(resources.GetObject("lblVersionCore.AutoSize")));
			this.lblVersionCore.BackColor = System.Drawing.Color.White;
			this.lblVersionCore.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lblVersionCore.Dock")));
			this.lblVersionCore.Enabled = ((bool)(resources.GetObject("lblVersionCore.Enabled")));
			this.lblVersionCore.Font = ((System.Drawing.Font)(resources.GetObject("lblVersionCore.Font")));
			this.lblVersionCore.Image = ((System.Drawing.Image)(resources.GetObject("lblVersionCore.Image")));
			this.lblVersionCore.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblVersionCore.ImageAlign")));
			this.lblVersionCore.ImageIndex = ((int)(resources.GetObject("lblVersionCore.ImageIndex")));
			this.lblVersionCore.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lblVersionCore.ImeMode")));
			this.lblVersionCore.Location = ((System.Drawing.Point)(resources.GetObject("lblVersionCore.Location")));
			this.lblVersionCore.Name = "lblVersionCore";
			this.lblVersionCore.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lblVersionCore.RightToLeft")));
			this.lblVersionCore.Size = ((System.Drawing.Size)(resources.GetObject("lblVersionCore.Size")));
			this.lblVersionCore.TabIndex = ((int)(resources.GetObject("lblVersionCore.TabIndex")));
			this.lblVersionCore.Text = resources.GetString("lblVersionCore.Text");
			this.lblVersionCore.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblVersionCore.TextAlign")));
			this.lblVersionCore.Visible = ((bool)(resources.GetObject("lblVersionCore.Visible")));
			// 
			// FrmAbout
			// 
			this.AcceptButton = this.buttonAceptar;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.lblVersionCore);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.buttonAceptar);
			this.Controls.Add(this.pictureBox1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximizeBox = false;
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimizeBox = false;
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmAbout";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonAceptar_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}
	}
}
