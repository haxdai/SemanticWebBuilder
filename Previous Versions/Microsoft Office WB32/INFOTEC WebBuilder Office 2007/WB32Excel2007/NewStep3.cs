/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;
using WBOffice3;
namespace WBExcel
{
	/// <summary>Control del asistente de creación de contenido para indicar descripción</summary>
	public class NewStep3 : TSWizards.BaseStep
	{
		private System.Windows.Forms.ErrorProvider errorProvider1;
		/// <summary>
		/// Texto de captura de descripción de contenido
		/// </summary>
		public System.Windows.Forms.TextBox txtDesc;
		
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public NewStep3()
		{
			// Llamada necesaria para el Diseñador de formularios Windows.Forms.
			InitializeComponent();

			
			

		}

		
		
		
		/// <summary> 
		/// Método necesario para admitir el Diseñador. No se puede modificar 
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(NewStep3));
			this.txtDesc = new System.Windows.Forms.TextBox();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// txtDesc
			// 
			this.txtDesc.AccessibleDescription = resources.GetString("txtDesc.AccessibleDescription");
			this.txtDesc.AccessibleName = resources.GetString("txtDesc.AccessibleName");
			this.txtDesc.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtDesc.Anchor")));
			this.txtDesc.AutoSize = ((bool)(resources.GetObject("txtDesc.AutoSize")));
			this.txtDesc.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtDesc.BackgroundImage")));
			this.txtDesc.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtDesc.Dock")));
			this.txtDesc.Enabled = ((bool)(resources.GetObject("txtDesc.Enabled")));
			this.errorProvider1.SetError(this.txtDesc, resources.GetString("txtDesc.Error"));
			this.txtDesc.Font = ((System.Drawing.Font)(resources.GetObject("txtDesc.Font")));
			this.errorProvider1.SetIconAlignment(this.txtDesc, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("txtDesc.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.txtDesc, ((int)(resources.GetObject("txtDesc.IconPadding"))));
			this.txtDesc.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtDesc.ImeMode")));
			this.txtDesc.Location = ((System.Drawing.Point)(resources.GetObject("txtDesc.Location")));
			this.txtDesc.MaxLength = ((int)(resources.GetObject("txtDesc.MaxLength")));
			this.txtDesc.Multiline = ((bool)(resources.GetObject("txtDesc.Multiline")));
			this.txtDesc.Name = "txtDesc";
			this.txtDesc.PasswordChar = ((char)(resources.GetObject("txtDesc.PasswordChar")));
			this.txtDesc.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtDesc.RightToLeft")));
			this.txtDesc.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtDesc.ScrollBars")));
			this.txtDesc.Size = ((System.Drawing.Size)(resources.GetObject("txtDesc.Size")));
			this.txtDesc.TabIndex = ((int)(resources.GetObject("txtDesc.TabIndex")));
			this.txtDesc.Text = resources.GetString("txtDesc.Text");
			this.txtDesc.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtDesc.TextAlign")));
			this.txtDesc.Visible = ((bool)(resources.GetObject("txtDesc.Visible")));
			this.txtDesc.WordWrap = ((bool)(resources.GetObject("txtDesc.WordWrap")));
			this.txtDesc.TextChanged += new System.EventHandler(this.txtDesc_TextChanged);
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			this.errorProvider1.Icon = ((System.Drawing.Icon)(resources.GetObject("errorProvider1.Icon")));
			// 
			// NewStep3
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.txtDesc);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.errorProvider1.SetError(this, resources.GetString("$this.Error"));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.errorProvider1.SetIconAlignment(this, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("$this.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this, ((int)(resources.GetObject("$this.IconPadding"))));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "NewStep3";
			this.NextStep = "Step4";
			this.PreviousStep = "Step2";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.NewStep3_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.txtDesc, 0);
			this.ResumeLayout(false);

		}

		private void NewStep3_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.NextEnabled=false;
			txtDesc_TextChanged(null,null);
			this.txtDesc.Focus();
		}

		private void txtDesc_TextChanged(object sender, System.EventArgs e)
		{
			if(this.txtDesc.Text.Trim()=="")
			{
				this.Wizard.NextEnabled=false;
			}
			else
			{
				this.Wizard.NextEnabled=true;
			}
		}
		

	}
}
