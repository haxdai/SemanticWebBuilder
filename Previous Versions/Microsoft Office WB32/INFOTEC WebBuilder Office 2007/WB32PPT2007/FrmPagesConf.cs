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

namespace WBPowerPoint
{
	/// <summary>Forma para configurar páginación de contenido</summary>
	public class FrmPagesConf : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resppt = new System.Resources.ResourceManager("WBPowerPoint.respp",System.Reflection.Assembly.GetExecutingAssembly());		
		private System.Windows.Forms.Button buttonCancel;
		private System.Windows.Forms.Button buttonAccept;
		/// <summary>Regresa la selección para Páginación</summary>
		/// <value>
		/// Regresa la selección para Páginación, si el valor cheched es true debe paginar,
		/// si el valor es false, no debe paginar
		/// </value>
		public System.Windows.Forms.CheckBox checkBoxConfPaginacion;
		private System.Windows.Forms.GroupBox groupBoxConfPag;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		private System.Windows.Forms.Label label1;
		/// <summary>
		/// Caja de texto que se indica texto para que al publicar contenido se descarge el mismo al publicarse
		/// </summary>
		public System.Windows.Forms.TextBox txtDownloadFile;
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;

		/// <summary>Crea una forma de configuración de paginación de un contenido</summary>
		public FrmPagesConf()
		{
			//
			// Necesario para admitir el Diseñador de Windows Forms
			//
			InitializeComponent();

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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmPagesConf));
			this.buttonCancel = new System.Windows.Forms.Button();
			this.buttonAccept = new System.Windows.Forms.Button();
			this.checkBoxConfPaginacion = new System.Windows.Forms.CheckBox();
			this.groupBoxConfPag = new System.Windows.Forms.GroupBox();
			this.txtDownloadFile = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider();
			this.groupBoxConfPag.SuspendLayout();
			this.SuspendLayout();
			// 
			// buttonCancel
			// 
			this.buttonCancel.AccessibleDescription = resources.GetString("buttonCancel.AccessibleDescription");
			this.buttonCancel.AccessibleName = resources.GetString("buttonCancel.AccessibleName");
			this.buttonCancel.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonCancel.Anchor")));
			this.buttonCancel.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonCancel.BackgroundImage")));
			this.buttonCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.buttonCancel.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonCancel.Dock")));
			this.buttonCancel.Enabled = ((bool)(resources.GetObject("buttonCancel.Enabled")));
			this.errorProvider1.SetError(this.buttonCancel, resources.GetString("buttonCancel.Error"));
			this.buttonCancel.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonCancel.FlatStyle")));
			this.buttonCancel.Font = ((System.Drawing.Font)(resources.GetObject("buttonCancel.Font")));
			this.errorProvider1.SetIconAlignment(this.buttonCancel, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("buttonCancel.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.buttonCancel, ((int)(resources.GetObject("buttonCancel.IconPadding"))));
			this.buttonCancel.Image = ((System.Drawing.Image)(resources.GetObject("buttonCancel.Image")));
			this.buttonCancel.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancel.ImageAlign")));
			this.buttonCancel.ImageIndex = ((int)(resources.GetObject("buttonCancel.ImageIndex")));
			this.buttonCancel.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonCancel.ImeMode")));
			this.buttonCancel.Location = ((System.Drawing.Point)(resources.GetObject("buttonCancel.Location")));
			this.buttonCancel.Name = "buttonCancel";
			this.buttonCancel.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonCancel.RightToLeft")));
			this.buttonCancel.Size = ((System.Drawing.Size)(resources.GetObject("buttonCancel.Size")));
			this.buttonCancel.TabIndex = ((int)(resources.GetObject("buttonCancel.TabIndex")));
			this.buttonCancel.Text = resources.GetString("buttonCancel.Text");
			this.buttonCancel.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancel.TextAlign")));
			this.buttonCancel.Visible = ((bool)(resources.GetObject("buttonCancel.Visible")));
			this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
			// 
			// buttonAccept
			// 
			this.buttonAccept.AccessibleDescription = resources.GetString("buttonAccept.AccessibleDescription");
			this.buttonAccept.AccessibleName = resources.GetString("buttonAccept.AccessibleName");
			this.buttonAccept.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonAccept.Anchor")));
			this.buttonAccept.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonAccept.BackgroundImage")));
			this.buttonAccept.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonAccept.Dock")));
			this.buttonAccept.Enabled = ((bool)(resources.GetObject("buttonAccept.Enabled")));
			this.errorProvider1.SetError(this.buttonAccept, resources.GetString("buttonAccept.Error"));
			this.buttonAccept.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonAccept.FlatStyle")));
			this.buttonAccept.Font = ((System.Drawing.Font)(resources.GetObject("buttonAccept.Font")));
			this.errorProvider1.SetIconAlignment(this.buttonAccept, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("buttonAccept.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.buttonAccept, ((int)(resources.GetObject("buttonAccept.IconPadding"))));
			this.buttonAccept.Image = ((System.Drawing.Image)(resources.GetObject("buttonAccept.Image")));
			this.buttonAccept.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAccept.ImageAlign")));
			this.buttonAccept.ImageIndex = ((int)(resources.GetObject("buttonAccept.ImageIndex")));
			this.buttonAccept.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonAccept.ImeMode")));
			this.buttonAccept.Location = ((System.Drawing.Point)(resources.GetObject("buttonAccept.Location")));
			this.buttonAccept.Name = "buttonAccept";
			this.buttonAccept.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonAccept.RightToLeft")));
			this.buttonAccept.Size = ((System.Drawing.Size)(resources.GetObject("buttonAccept.Size")));
			this.buttonAccept.TabIndex = ((int)(resources.GetObject("buttonAccept.TabIndex")));
			this.buttonAccept.Text = resources.GetString("buttonAccept.Text");
			this.buttonAccept.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAccept.TextAlign")));
			this.buttonAccept.Visible = ((bool)(resources.GetObject("buttonAccept.Visible")));
			this.buttonAccept.Click += new System.EventHandler(this.buttonAccept_Click);
			// 
			// checkBoxConfPaginacion
			// 
			this.checkBoxConfPaginacion.AccessibleDescription = resources.GetString("checkBoxConfPaginacion.AccessibleDescription");
			this.checkBoxConfPaginacion.AccessibleName = resources.GetString("checkBoxConfPaginacion.AccessibleName");
			this.checkBoxConfPaginacion.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("checkBoxConfPaginacion.Anchor")));
			this.checkBoxConfPaginacion.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("checkBoxConfPaginacion.Appearance")));
			this.checkBoxConfPaginacion.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("checkBoxConfPaginacion.BackgroundImage")));
			this.checkBoxConfPaginacion.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxConfPaginacion.CheckAlign")));
			this.checkBoxConfPaginacion.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("checkBoxConfPaginacion.Dock")));
			this.checkBoxConfPaginacion.Enabled = ((bool)(resources.GetObject("checkBoxConfPaginacion.Enabled")));
			this.errorProvider1.SetError(this.checkBoxConfPaginacion, resources.GetString("checkBoxConfPaginacion.Error"));
			this.checkBoxConfPaginacion.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("checkBoxConfPaginacion.FlatStyle")));
			this.checkBoxConfPaginacion.Font = ((System.Drawing.Font)(resources.GetObject("checkBoxConfPaginacion.Font")));
			this.errorProvider1.SetIconAlignment(this.checkBoxConfPaginacion, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("checkBoxConfPaginacion.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.checkBoxConfPaginacion, ((int)(resources.GetObject("checkBoxConfPaginacion.IconPadding"))));
			this.checkBoxConfPaginacion.Image = ((System.Drawing.Image)(resources.GetObject("checkBoxConfPaginacion.Image")));
			this.checkBoxConfPaginacion.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxConfPaginacion.ImageAlign")));
			this.checkBoxConfPaginacion.ImageIndex = ((int)(resources.GetObject("checkBoxConfPaginacion.ImageIndex")));
			this.checkBoxConfPaginacion.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("checkBoxConfPaginacion.ImeMode")));
			this.checkBoxConfPaginacion.Location = ((System.Drawing.Point)(resources.GetObject("checkBoxConfPaginacion.Location")));
			this.checkBoxConfPaginacion.Name = "checkBoxConfPaginacion";
			this.checkBoxConfPaginacion.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("checkBoxConfPaginacion.RightToLeft")));
			this.checkBoxConfPaginacion.Size = ((System.Drawing.Size)(resources.GetObject("checkBoxConfPaginacion.Size")));
			this.checkBoxConfPaginacion.TabIndex = ((int)(resources.GetObject("checkBoxConfPaginacion.TabIndex")));
			this.checkBoxConfPaginacion.Text = resources.GetString("checkBoxConfPaginacion.Text");
			this.checkBoxConfPaginacion.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxConfPaginacion.TextAlign")));
			this.checkBoxConfPaginacion.Visible = ((bool)(resources.GetObject("checkBoxConfPaginacion.Visible")));
			this.checkBoxConfPaginacion.CheckedChanged += new System.EventHandler(this.checkBoxConfPaginacion_CheckedChanged);
			// 
			// groupBoxConfPag
			// 
			this.groupBoxConfPag.AccessibleDescription = resources.GetString("groupBoxConfPag.AccessibleDescription");
			this.groupBoxConfPag.AccessibleName = resources.GetString("groupBoxConfPag.AccessibleName");
			this.groupBoxConfPag.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBoxConfPag.Anchor")));
			this.groupBoxConfPag.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBoxConfPag.BackgroundImage")));
			this.groupBoxConfPag.Controls.Add(this.txtDownloadFile);
			this.groupBoxConfPag.Controls.Add(this.label1);
			this.groupBoxConfPag.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBoxConfPag.Dock")));
			this.groupBoxConfPag.Enabled = ((bool)(resources.GetObject("groupBoxConfPag.Enabled")));
			this.errorProvider1.SetError(this.groupBoxConfPag, resources.GetString("groupBoxConfPag.Error"));
			this.groupBoxConfPag.Font = ((System.Drawing.Font)(resources.GetObject("groupBoxConfPag.Font")));
			this.errorProvider1.SetIconAlignment(this.groupBoxConfPag, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("groupBoxConfPag.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.groupBoxConfPag, ((int)(resources.GetObject("groupBoxConfPag.IconPadding"))));
			this.groupBoxConfPag.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBoxConfPag.ImeMode")));
			this.groupBoxConfPag.Location = ((System.Drawing.Point)(resources.GetObject("groupBoxConfPag.Location")));
			this.groupBoxConfPag.Name = "groupBoxConfPag";
			this.groupBoxConfPag.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBoxConfPag.RightToLeft")));
			this.groupBoxConfPag.Size = ((System.Drawing.Size)(resources.GetObject("groupBoxConfPag.Size")));
			this.groupBoxConfPag.TabIndex = ((int)(resources.GetObject("groupBoxConfPag.TabIndex")));
			this.groupBoxConfPag.TabStop = false;
			this.groupBoxConfPag.Text = resources.GetString("groupBoxConfPag.Text");
			this.groupBoxConfPag.Visible = ((bool)(resources.GetObject("groupBoxConfPag.Visible")));
			// 
			// txtDownloadFile
			// 
			this.txtDownloadFile.AccessibleDescription = resources.GetString("txtDownloadFile.AccessibleDescription");
			this.txtDownloadFile.AccessibleName = resources.GetString("txtDownloadFile.AccessibleName");
			this.txtDownloadFile.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtDownloadFile.Anchor")));
			this.txtDownloadFile.AutoSize = ((bool)(resources.GetObject("txtDownloadFile.AutoSize")));
			this.txtDownloadFile.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtDownloadFile.BackgroundImage")));
			this.txtDownloadFile.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtDownloadFile.Dock")));
			this.txtDownloadFile.Enabled = ((bool)(resources.GetObject("txtDownloadFile.Enabled")));
			this.errorProvider1.SetError(this.txtDownloadFile, resources.GetString("txtDownloadFile.Error"));
			this.txtDownloadFile.Font = ((System.Drawing.Font)(resources.GetObject("txtDownloadFile.Font")));
			this.errorProvider1.SetIconAlignment(this.txtDownloadFile, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("txtDownloadFile.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.txtDownloadFile, ((int)(resources.GetObject("txtDownloadFile.IconPadding"))));
			this.txtDownloadFile.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtDownloadFile.ImeMode")));
			this.txtDownloadFile.Location = ((System.Drawing.Point)(resources.GetObject("txtDownloadFile.Location")));
			this.txtDownloadFile.MaxLength = ((int)(resources.GetObject("txtDownloadFile.MaxLength")));
			this.txtDownloadFile.Multiline = ((bool)(resources.GetObject("txtDownloadFile.Multiline")));
			this.txtDownloadFile.Name = "txtDownloadFile";
			this.txtDownloadFile.PasswordChar = ((char)(resources.GetObject("txtDownloadFile.PasswordChar")));
			this.txtDownloadFile.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtDownloadFile.RightToLeft")));
			this.txtDownloadFile.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtDownloadFile.ScrollBars")));
			this.txtDownloadFile.Size = ((System.Drawing.Size)(resources.GetObject("txtDownloadFile.Size")));
			this.txtDownloadFile.TabIndex = ((int)(resources.GetObject("txtDownloadFile.TabIndex")));
			this.txtDownloadFile.Text = resources.GetString("txtDownloadFile.Text");
			this.txtDownloadFile.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtDownloadFile.TextAlign")));
			this.txtDownloadFile.Visible = ((bool)(resources.GetObject("txtDownloadFile.Visible")));
			this.txtDownloadFile.WordWrap = ((bool)(resources.GetObject("txtDownloadFile.WordWrap")));
			// 
			// label1
			// 
			this.label1.AccessibleDescription = resources.GetString("label1.AccessibleDescription");
			this.label1.AccessibleName = resources.GetString("label1.AccessibleName");
			this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label1.Anchor")));
			this.label1.AutoSize = ((bool)(resources.GetObject("label1.AutoSize")));
			this.label1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label1.Dock")));
			this.label1.Enabled = ((bool)(resources.GetObject("label1.Enabled")));
			this.errorProvider1.SetError(this.label1, resources.GetString("label1.Error"));
			this.label1.Font = ((System.Drawing.Font)(resources.GetObject("label1.Font")));
			this.errorProvider1.SetIconAlignment(this.label1, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("label1.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.label1, ((int)(resources.GetObject("label1.IconPadding"))));
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
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			this.errorProvider1.Icon = ((System.Drawing.Icon)(resources.GetObject("errorProvider1.Icon")));
			// 
			// FrmPagesConf
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.ControlBox = false;
			this.Controls.Add(this.groupBoxConfPag);
			this.Controls.Add(this.checkBoxConfPaginacion);
			this.Controls.Add(this.buttonCancel);
			this.Controls.Add(this.buttonAccept);
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
			this.Name = "FrmPagesConf";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.groupBoxConfPag.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonCancel_Click(object sender, System.EventArgs e)
		{
			this.DialogResult=DialogResult.Cancel;
			this.Close();
		}

		private void buttonAccept_Click(object sender, System.EventArgs e)
		{		
			if(this.checkBoxConfPaginacion.Checked)
			{
				if(this.txtDownloadFile.Text.Trim()=="")
				{
					this.errorProvider1.SetError(this.txtDownloadFile,resppt.GetString("msgErrorFileDownload"));
					return;
				}
			}
			this.DialogResult=DialogResult.OK;
			this.Close();
		}

		private void checkBoxConfPaginacion_CheckedChanged(object sender, System.EventArgs e)
		{
			this.groupBoxConfPag.Enabled=!this.groupBoxConfPag.Enabled;
		}		
	}
}
