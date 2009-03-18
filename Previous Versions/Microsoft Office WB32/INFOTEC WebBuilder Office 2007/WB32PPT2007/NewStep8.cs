/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;

namespace WBPowerPoint
{
	/// <summary>
	/// Asistente para indicar la opcipon de descarga de contenido en la publicación
	/// </summary>
	public class NewStep8 : TSWizards.BaseStep
	{
		System.Resources.ResourceManager resword = new System.Resources.ResourceManager("WBPowerPoint.respp",System.Reflection.Assembly.GetExecutingAssembly());		
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.Label label1;
		/// <summary>
		/// Caja de texto para indicar texto para descarga de contenido
		/// </summary>
		public System.Windows.Forms.TextBox txtDownloadText;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		/// <summary>
		/// Opción que permite indicar si se permite la descarga del contenido
		/// </summary>
		public System.Windows.Forms.CheckBox checkBoxDownload;
		private System.ComponentModel.IContainer components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public NewStep8()
		{
			// Llamada necesaria para el Diseñador de Windows Forms.
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
				if (components != null) 
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Código generado por el diseñador
		/// <summary>
		/// Método necesario para admitir el Diseñador. No se puede modificar
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(NewStep8));
			this.checkBoxDownload = new System.Windows.Forms.CheckBox();
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.label1 = new System.Windows.Forms.Label();
			this.txtDownloadText = new System.Windows.Forms.TextBox();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider();
			this.groupBox1.SuspendLayout();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			// 
			// checkBoxDownload
			// 
			this.checkBoxDownload.AccessibleDescription = resources.GetString("checkBoxDownload.AccessibleDescription");
			this.checkBoxDownload.AccessibleName = resources.GetString("checkBoxDownload.AccessibleName");
			this.checkBoxDownload.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("checkBoxDownload.Anchor")));
			this.checkBoxDownload.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("checkBoxDownload.Appearance")));
			this.checkBoxDownload.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("checkBoxDownload.BackgroundImage")));
			this.checkBoxDownload.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxDownload.CheckAlign")));
			this.checkBoxDownload.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("checkBoxDownload.Dock")));
			this.checkBoxDownload.Enabled = ((bool)(resources.GetObject("checkBoxDownload.Enabled")));
			this.errorProvider1.SetError(this.checkBoxDownload, resources.GetString("checkBoxDownload.Error"));
			this.checkBoxDownload.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("checkBoxDownload.FlatStyle")));
			this.checkBoxDownload.Font = ((System.Drawing.Font)(resources.GetObject("checkBoxDownload.Font")));
			this.errorProvider1.SetIconAlignment(this.checkBoxDownload, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("checkBoxDownload.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.checkBoxDownload, ((int)(resources.GetObject("checkBoxDownload.IconPadding"))));
			this.checkBoxDownload.Image = ((System.Drawing.Image)(resources.GetObject("checkBoxDownload.Image")));
			this.checkBoxDownload.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxDownload.ImageAlign")));
			this.checkBoxDownload.ImageIndex = ((int)(resources.GetObject("checkBoxDownload.ImageIndex")));
			this.checkBoxDownload.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("checkBoxDownload.ImeMode")));
			this.checkBoxDownload.Location = ((System.Drawing.Point)(resources.GetObject("checkBoxDownload.Location")));
			this.checkBoxDownload.Name = "checkBoxDownload";
			this.checkBoxDownload.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("checkBoxDownload.RightToLeft")));
			this.checkBoxDownload.Size = ((System.Drawing.Size)(resources.GetObject("checkBoxDownload.Size")));
			this.checkBoxDownload.TabIndex = ((int)(resources.GetObject("checkBoxDownload.TabIndex")));
			this.checkBoxDownload.Text = resources.GetString("checkBoxDownload.Text");
			this.checkBoxDownload.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBoxDownload.TextAlign")));
			this.checkBoxDownload.Visible = ((bool)(resources.GetObject("checkBoxDownload.Visible")));
			this.checkBoxDownload.CheckedChanged += new System.EventHandler(this.checkBoxDownload_CheckedChanged);
			// 
			// groupBox1
			// 
			this.groupBox1.AccessibleDescription = resources.GetString("groupBox1.AccessibleDescription");
			this.groupBox1.AccessibleName = resources.GetString("groupBox1.AccessibleName");
			this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox1.Anchor")));
			this.groupBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox1.BackgroundImage")));
			this.groupBox1.Controls.Add(this.label1);
			this.groupBox1.Controls.Add(this.txtDownloadText);
			this.groupBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox1.Dock")));
			this.groupBox1.Enabled = ((bool)(resources.GetObject("groupBox1.Enabled")));
			this.errorProvider1.SetError(this.groupBox1, resources.GetString("groupBox1.Error"));
			this.groupBox1.Font = ((System.Drawing.Font)(resources.GetObject("groupBox1.Font")));
			this.errorProvider1.SetIconAlignment(this.groupBox1, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("groupBox1.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.groupBox1, ((int)(resources.GetObject("groupBox1.IconPadding"))));
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
			// txtDownloadText
			// 
			this.txtDownloadText.AccessibleDescription = resources.GetString("txtDownloadText.AccessibleDescription");
			this.txtDownloadText.AccessibleName = resources.GetString("txtDownloadText.AccessibleName");
			this.txtDownloadText.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtDownloadText.Anchor")));
			this.txtDownloadText.AutoSize = ((bool)(resources.GetObject("txtDownloadText.AutoSize")));
			this.txtDownloadText.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtDownloadText.BackgroundImage")));
			this.txtDownloadText.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtDownloadText.Dock")));
			this.txtDownloadText.Enabled = ((bool)(resources.GetObject("txtDownloadText.Enabled")));
			this.errorProvider1.SetError(this.txtDownloadText, resources.GetString("txtDownloadText.Error"));
			this.txtDownloadText.Font = ((System.Drawing.Font)(resources.GetObject("txtDownloadText.Font")));
			this.errorProvider1.SetIconAlignment(this.txtDownloadText, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("txtDownloadText.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.txtDownloadText, ((int)(resources.GetObject("txtDownloadText.IconPadding"))));
			this.txtDownloadText.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtDownloadText.ImeMode")));
			this.txtDownloadText.Location = ((System.Drawing.Point)(resources.GetObject("txtDownloadText.Location")));
			this.txtDownloadText.MaxLength = ((int)(resources.GetObject("txtDownloadText.MaxLength")));
			this.txtDownloadText.Multiline = ((bool)(resources.GetObject("txtDownloadText.Multiline")));
			this.txtDownloadText.Name = "txtDownloadText";
			this.txtDownloadText.PasswordChar = ((char)(resources.GetObject("txtDownloadText.PasswordChar")));
			this.txtDownloadText.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtDownloadText.RightToLeft")));
			this.txtDownloadText.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtDownloadText.ScrollBars")));
			this.txtDownloadText.Size = ((System.Drawing.Size)(resources.GetObject("txtDownloadText.Size")));
			this.txtDownloadText.TabIndex = ((int)(resources.GetObject("txtDownloadText.TabIndex")));
			this.txtDownloadText.Text = resources.GetString("txtDownloadText.Text");
			this.txtDownloadText.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtDownloadText.TextAlign")));
			this.txtDownloadText.Visible = ((bool)(resources.GetObject("txtDownloadText.Visible")));
			this.txtDownloadText.WordWrap = ((bool)(resources.GetObject("txtDownloadText.WordWrap")));
			this.txtDownloadText.TextChanged += new System.EventHandler(this.txtDownloadText_TextChanged);
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			this.errorProvider1.Icon = ((System.Drawing.Icon)(resources.GetObject("errorProvider1.Icon")));
			// 
			// NewStep8
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.groupBox1);
			this.Controls.Add(this.checkBoxDownload);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.errorProvider1.SetError(this, resources.GetString("$this.Error"));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.errorProvider1.SetIconAlignment(this, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("$this.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this, ((int)(resources.GetObject("$this.IconPadding"))));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "NewStep8";
			this.NextStep = "Step4";
			this.PreviousStep = "Step3";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.NewStep8_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.NewStep8_ShowStep);
			this.Controls.SetChildIndex(this.checkBoxDownload, 0);
			this.Controls.SetChildIndex(this.groupBox1, 0);
			this.Controls.SetChildIndex(this.Description, 0);
			this.groupBox1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void NewStep8_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			if(this.checkBoxDownload.Checked)
			{
				if(this.txtDownloadText.Text.Trim()=="")
				{
					this.errorProvider1.SetError(this.txtDownloadText,resword.GetString("msgErrorFileDownload"));
					e.Cancel=true;
				}				
			}
			this.Wizard.NextEnabled=true;
		}

		private void NewStep8_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			if(this.checkBoxDownload.Checked)
			{
				this.Wizard.NextEnabled=false;
				txtDownloadText_TextChanged(null,null);
			}
			else
			{
				this.Wizard.NextEnabled=true;				
			}			
		}

		private void txtDownloadText_TextChanged(object sender, System.EventArgs e)
		{
			if(this.checkBoxDownload.Checked)
			{
				if(this.txtDownloadText.Text.Trim()=="")
				{
					this.Wizard.NextEnabled=false;
				}				
			}
			this.Wizard.NextEnabled=true;
		}

		private void checkBoxDownload_CheckedChanged(object sender, System.EventArgs e)
		{
			if(this.checkBoxDownload.Checked)
			{
				this.groupBox1.Enabled=true;
			}
			else
			{
				this.groupBox1.Enabled=false;
			}
		}
	}
}

