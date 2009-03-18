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
	/// Control que permite mostrar las opciones para indicar si la presentación es
	/// publicada compatible con MS Explorer o con cualquier navegador
	/// </summary>
	public class SelectPresentation : TSWizards.BaseInteriorStep
	{
		/// <summary>
		/// Opción de publicación con compatible con Explorer
		/// </summary>
		public System.Windows.Forms.RadioButton radioButtonExplorer;
		private System.Windows.Forms.RadioButton radioButton2;
		private System.Windows.Forms.ToolTip toolTip1;
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Crea el control que permite mostrar las opciones para indicar si la presentación
		/// es publicada compatible con MS Explorer o con cualquier navegador
		/// </summary>
		public SelectPresentation()
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
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(SelectPresentation));
			this.radioButtonExplorer = new System.Windows.Forms.RadioButton();
			this.radioButton2 = new System.Windows.Forms.RadioButton();
			this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// radioButtonExplorer
			// 
			this.radioButtonExplorer.AccessibleDescription = resources.GetString("radioButtonExplorer.AccessibleDescription");
			this.radioButtonExplorer.AccessibleName = resources.GetString("radioButtonExplorer.AccessibleName");
			this.radioButtonExplorer.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonExplorer.Anchor")));
			this.radioButtonExplorer.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonExplorer.Appearance")));
			this.radioButtonExplorer.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonExplorer.BackgroundImage")));
			this.radioButtonExplorer.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonExplorer.CheckAlign")));
			this.radioButtonExplorer.Checked = true;
			this.radioButtonExplorer.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonExplorer.Dock")));
			this.radioButtonExplorer.Enabled = ((bool)(resources.GetObject("radioButtonExplorer.Enabled")));
			this.radioButtonExplorer.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonExplorer.FlatStyle")));
			this.radioButtonExplorer.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonExplorer.Font")));
			this.radioButtonExplorer.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonExplorer.Image")));
			this.radioButtonExplorer.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonExplorer.ImageAlign")));
			this.radioButtonExplorer.ImageIndex = ((int)(resources.GetObject("radioButtonExplorer.ImageIndex")));
			this.radioButtonExplorer.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonExplorer.ImeMode")));
			this.radioButtonExplorer.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonExplorer.Location")));
			this.radioButtonExplorer.Name = "radioButtonExplorer";
			this.radioButtonExplorer.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonExplorer.RightToLeft")));
			this.radioButtonExplorer.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonExplorer.Size")));
			this.radioButtonExplorer.TabIndex = ((int)(resources.GetObject("radioButtonExplorer.TabIndex")));
			this.radioButtonExplorer.TabStop = true;
			this.radioButtonExplorer.Text = resources.GetString("radioButtonExplorer.Text");
			this.radioButtonExplorer.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonExplorer.TextAlign")));
			this.toolTip1.SetToolTip(this.radioButtonExplorer, resources.GetString("radioButtonExplorer.ToolTip"));
			this.radioButtonExplorer.Visible = ((bool)(resources.GetObject("radioButtonExplorer.Visible")));
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
			this.toolTip1.SetToolTip(this.radioButton2, resources.GetString("radioButton2.ToolTip"));
			this.radioButton2.Visible = ((bool)(resources.GetObject("radioButton2.Visible")));
			// 
			// SelectPresentation
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackColor = System.Drawing.Color.White;
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.radioButton2);
			this.Controls.Add(this.radioButtonExplorer);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.IsFinished = true;
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "SelectPresentation";
			this.NextStep = "FINISHED";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.toolTip1.SetToolTip(this, resources.GetString("$this.ToolTip"));
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.SelectPresentation_ValidateStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.radioButtonExplorer, 0);
			this.Controls.SetChildIndex(this.radioButton2, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void SelectPresentation_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			if(this.Wizard is FrmSelectPresentation)
			{
				FrmSelectPresentation sp=(FrmSelectPresentation)this.Wizard;
				sp.opExplorer=true;
				if(this.radioButton2.Checked)
				{
					sp.opExplorer=false;
				}
			}
			else
			{
				this.Wizard.DialogResult=DialogResult.Cancel;
			}
		}
	}
}

