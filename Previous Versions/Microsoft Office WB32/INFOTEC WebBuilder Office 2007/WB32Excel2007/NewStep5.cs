/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;

namespace WBExcel
{
	/// <summary>Control que muestra el resumen para alta de contenido</summary>
	public class NewStep5 : TSWizards.BaseStep
	{
		private System.Windows.Forms.TextBox txtResumen;
		/// <summary> 
		/// Variable del dise�ador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public NewStep5()
		{
			// Llamada necesaria para el Dise�ador de formularios Windows.Forms.
			InitializeComponent();

			// TODO: agregar cualquier inicializaci�n despu�s de llamar a InitializeComponent

		}

		/// <summary> 
		/// Limpiar los recursos que se est�n utilizando.
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

		#region C�digo generado por el Dise�ador de componentes
		/// <summary> 
		/// M�todo necesario para admitir el Dise�ador. No se puede modificar 
		/// el contenido del m�todo con el editor de c�digo.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(NewStep5));
			this.txtResumen = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// txtResumen
			// 
			this.txtResumen.AccessibleDescription = resources.GetString("txtResumen.AccessibleDescription");
			this.txtResumen.AccessibleName = resources.GetString("txtResumen.AccessibleName");
			this.txtResumen.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtResumen.Anchor")));
			this.txtResumen.AutoSize = ((bool)(resources.GetObject("txtResumen.AutoSize")));
			this.txtResumen.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtResumen.BackgroundImage")));
			this.txtResumen.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtResumen.Dock")));
			this.txtResumen.Enabled = ((bool)(resources.GetObject("txtResumen.Enabled")));
			this.txtResumen.Font = ((System.Drawing.Font)(resources.GetObject("txtResumen.Font")));
			this.txtResumen.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtResumen.ImeMode")));
			this.txtResumen.Location = ((System.Drawing.Point)(resources.GetObject("txtResumen.Location")));
			this.txtResumen.MaxLength = ((int)(resources.GetObject("txtResumen.MaxLength")));
			this.txtResumen.Multiline = ((bool)(resources.GetObject("txtResumen.Multiline")));
			this.txtResumen.Name = "txtResumen";
			this.txtResumen.PasswordChar = ((char)(resources.GetObject("txtResumen.PasswordChar")));
			this.txtResumen.ReadOnly = true;
			this.txtResumen.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtResumen.RightToLeft")));
			this.txtResumen.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtResumen.ScrollBars")));
			this.txtResumen.Size = ((System.Drawing.Size)(resources.GetObject("txtResumen.Size")));
			this.txtResumen.TabIndex = ((int)(resources.GetObject("txtResumen.TabIndex")));
			this.txtResumen.Text = resources.GetString("txtResumen.Text");
			this.txtResumen.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtResumen.TextAlign")));
			this.txtResumen.Visible = ((bool)(resources.GetObject("txtResumen.Visible")));
			this.txtResumen.WordWrap = ((bool)(resources.GetObject("txtResumen.WordWrap")));
			// 
			// NewStep5
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.txtResumen);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "NewStep5";
			this.NextStep = "Step6";
			this.PreviousStep = "Step9";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.NewStep5_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.txtResumen, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void NewStep5_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.next.Enabled=true;
			this.txtResumen.Text="";
			NewStep2 step2 = Wizard.GetStep("Step2") as NewStep2;
			if(step2!=null)
				this.txtResumen.Text+=step2.StepTitle+": "+step2.txttitulo.Text+"\r\n";

			NewStep3 step3 = Wizard.GetStep("Step3") as NewStep3;
			if(step3!=null)
				this.txtResumen.Text+=step3.StepTitle+": "+step3.txtDesc.Text+"\r\n";


			NewStep4 step4 = Wizard.GetStep("Step4") as NewStep4;
			if(step4!=null && step4.treeView1.SelectedNode!=null)
			{
				this.txtResumen.Text+=step4.StepTitle+": "+step4.treeView1.SelectedNode.Text+"\r\n";
			}
			NewStep9 step9 = Wizard.GetStep("Step9") as NewStep9;
			if(step9.radioButtonWeb.Checked)
			{
				this.txtResumen.Text+=step9.radioButtonWeb.Text;
			}
			if(step9.radioButtonOffice.Checked)
			{
				this.txtResumen.Text+=step9.radioButtonOffice.Text;
			}
		}
	}
}
