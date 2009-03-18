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
	/// <summary>Forma que indica si se autoriza o no un contenido.</summary>
	public class FrmAutoriza : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));		
		private System.Windows.Forms.Button button2;
		private System.Windows.Forms.Button buttonSiguiente;
		/// <summary>
		/// Etiqueta a mostrar
		/// </summary>
		public System.Windows.Forms.Label label1;
		/// <summary>
		/// Caja de texto para capturar comentarios
		/// </summary>
		public System.Windows.Forms.TextBox txtconment;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;		
		/// <summary>Construye una forma que muestra si se autoriza o no un contenido.</summary>
		public FrmAutoriza()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//			
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmAutoriza));
			this.label1 = new System.Windows.Forms.Label();
			this.txtconment = new System.Windows.Forms.TextBox();
			this.button2 = new System.Windows.Forms.Button();
			this.buttonSiguiente = new System.Windows.Forms.Button();
			this.SuspendLayout();
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
			// txtconment
			// 
			this.txtconment.AccessibleDescription = resources.GetString("txtconment.AccessibleDescription");
			this.txtconment.AccessibleName = resources.GetString("txtconment.AccessibleName");
			this.txtconment.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtconment.Anchor")));
			this.txtconment.AutoSize = ((bool)(resources.GetObject("txtconment.AutoSize")));
			this.txtconment.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtconment.BackgroundImage")));
			this.txtconment.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtconment.Dock")));
			this.txtconment.Enabled = ((bool)(resources.GetObject("txtconment.Enabled")));
			this.txtconment.Font = ((System.Drawing.Font)(resources.GetObject("txtconment.Font")));
			this.txtconment.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtconment.ImeMode")));
			this.txtconment.Location = ((System.Drawing.Point)(resources.GetObject("txtconment.Location")));
			this.txtconment.MaxLength = ((int)(resources.GetObject("txtconment.MaxLength")));
			this.txtconment.Multiline = ((bool)(resources.GetObject("txtconment.Multiline")));
			this.txtconment.Name = "txtconment";
			this.txtconment.PasswordChar = ((char)(resources.GetObject("txtconment.PasswordChar")));
			this.txtconment.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtconment.RightToLeft")));
			this.txtconment.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtconment.ScrollBars")));
			this.txtconment.Size = ((System.Drawing.Size)(resources.GetObject("txtconment.Size")));
			this.txtconment.TabIndex = ((int)(resources.GetObject("txtconment.TabIndex")));
			this.txtconment.Text = resources.GetString("txtconment.Text");
			this.txtconment.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtconment.TextAlign")));
			this.txtconment.Visible = ((bool)(resources.GetObject("txtconment.Visible")));
			this.txtconment.WordWrap = ((bool)(resources.GetObject("txtconment.WordWrap")));
			// 
			// button2
			// 
			this.button2.AccessibleDescription = resources.GetString("button2.AccessibleDescription");
			this.button2.AccessibleName = resources.GetString("button2.AccessibleName");
			this.button2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("button2.Anchor")));
			this.button2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("button2.BackgroundImage")));
			this.button2.DialogResult = System.Windows.Forms.DialogResult.Cancel;
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
			// buttonSiguiente
			// 
			this.buttonSiguiente.AccessibleDescription = resources.GetString("buttonSiguiente.AccessibleDescription");
			this.buttonSiguiente.AccessibleName = resources.GetString("buttonSiguiente.AccessibleName");
			this.buttonSiguiente.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonSiguiente.Anchor")));
			this.buttonSiguiente.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonSiguiente.BackgroundImage")));
			this.buttonSiguiente.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonSiguiente.Dock")));
			this.buttonSiguiente.Enabled = ((bool)(resources.GetObject("buttonSiguiente.Enabled")));
			this.buttonSiguiente.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonSiguiente.FlatStyle")));
			this.buttonSiguiente.Font = ((System.Drawing.Font)(resources.GetObject("buttonSiguiente.Font")));
			this.buttonSiguiente.Image = ((System.Drawing.Image)(resources.GetObject("buttonSiguiente.Image")));
			this.buttonSiguiente.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonSiguiente.ImageAlign")));
			this.buttonSiguiente.ImageIndex = ((int)(resources.GetObject("buttonSiguiente.ImageIndex")));
			this.buttonSiguiente.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonSiguiente.ImeMode")));
			this.buttonSiguiente.Location = ((System.Drawing.Point)(resources.GetObject("buttonSiguiente.Location")));
			this.buttonSiguiente.Name = "buttonSiguiente";
			this.buttonSiguiente.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonSiguiente.RightToLeft")));
			this.buttonSiguiente.Size = ((System.Drawing.Size)(resources.GetObject("buttonSiguiente.Size")));
			this.buttonSiguiente.TabIndex = ((int)(resources.GetObject("buttonSiguiente.TabIndex")));
			this.buttonSiguiente.Text = resources.GetString("buttonSiguiente.Text");
			this.buttonSiguiente.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonSiguiente.TextAlign")));
			this.buttonSiguiente.Visible = ((bool)(resources.GetObject("buttonSiguiente.Visible")));
			this.buttonSiguiente.Click += new System.EventHandler(this.buttonSiguiente_Click);
			// 
			// FrmAutoriza
			// 
			this.AcceptButton = this.buttonSiguiente;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.button2;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.label1);
			this.Controls.Add(this.txtconment);
			this.Controls.Add(this.button2);
			this.Controls.Add(this.buttonSiguiente);
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
			this.Name = "FrmAutoriza";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.ResumeLayout(false);

		}
		#endregion

		private void button2_Click(object sender, System.EventArgs e)
		{
			this.DialogResult=DialogResult.Cancel;
			this.Close();
		}

		private void buttonSiguiente_Click(object sender, System.EventArgs e)
		{
			this.DialogResult=DialogResult.OK;
			this.Close();
		}
	}
}
