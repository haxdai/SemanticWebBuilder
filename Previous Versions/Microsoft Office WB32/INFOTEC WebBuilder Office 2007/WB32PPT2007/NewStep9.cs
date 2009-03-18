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
	/// Clase asistente que muestra la opción de publicación web o embebida
	/// </summary>
	public class NewStep9 : TSWizards.BaseStep
	{
		private System.Windows.Forms.GroupBox groupBox1;
		/// <summary>
		/// Opción embebida
		/// </summary>
		public System.Windows.Forms.RadioButton radioButtonOffice;
		/// <summary>
		/// Opción web
		/// </summary>
		public System.Windows.Forms.RadioButton radioButtonWeb;
		private System.ComponentModel.IContainer components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public NewStep9()
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(NewStep9));
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.radioButtonWeb = new System.Windows.Forms.RadioButton();
			this.radioButtonOffice = new System.Windows.Forms.RadioButton();
			this.groupBox1.SuspendLayout();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// groupBox1
			// 
			this.groupBox1.AccessibleDescription = resources.GetString("groupBox1.AccessibleDescription");
			this.groupBox1.AccessibleName = resources.GetString("groupBox1.AccessibleName");
			this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox1.Anchor")));
			this.groupBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox1.BackgroundImage")));
			this.groupBox1.Controls.Add(this.radioButtonWeb);
			this.groupBox1.Controls.Add(this.radioButtonOffice);
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
			// radioButtonWeb
			// 
			this.radioButtonWeb.AccessibleDescription = resources.GetString("radioButtonWeb.AccessibleDescription");
			this.radioButtonWeb.AccessibleName = resources.GetString("radioButtonWeb.AccessibleName");
			this.radioButtonWeb.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonWeb.Anchor")));
			this.radioButtonWeb.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonWeb.Appearance")));
			this.radioButtonWeb.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonWeb.BackgroundImage")));
			this.radioButtonWeb.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonWeb.CheckAlign")));
			this.radioButtonWeb.Checked = true;
			this.radioButtonWeb.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonWeb.Dock")));
			this.radioButtonWeb.Enabled = ((bool)(resources.GetObject("radioButtonWeb.Enabled")));
			this.radioButtonWeb.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonWeb.FlatStyle")));
			this.radioButtonWeb.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonWeb.Font")));
			this.radioButtonWeb.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonWeb.Image")));
			this.radioButtonWeb.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonWeb.ImageAlign")));
			this.radioButtonWeb.ImageIndex = ((int)(resources.GetObject("radioButtonWeb.ImageIndex")));
			this.radioButtonWeb.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonWeb.ImeMode")));
			this.radioButtonWeb.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonWeb.Location")));
			this.radioButtonWeb.Name = "radioButtonWeb";
			this.radioButtonWeb.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonWeb.RightToLeft")));
			this.radioButtonWeb.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonWeb.Size")));
			this.radioButtonWeb.TabIndex = ((int)(resources.GetObject("radioButtonWeb.TabIndex")));
			this.radioButtonWeb.TabStop = true;
			this.radioButtonWeb.Text = resources.GetString("radioButtonWeb.Text");
			this.radioButtonWeb.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonWeb.TextAlign")));
			this.radioButtonWeb.Visible = ((bool)(resources.GetObject("radioButtonWeb.Visible")));
			// 
			// radioButtonOffice
			// 
			this.radioButtonOffice.AccessibleDescription = resources.GetString("radioButtonOffice.AccessibleDescription");
			this.radioButtonOffice.AccessibleName = resources.GetString("radioButtonOffice.AccessibleName");
			this.radioButtonOffice.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonOffice.Anchor")));
			this.radioButtonOffice.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonOffice.Appearance")));
			this.radioButtonOffice.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonOffice.BackgroundImage")));
			this.radioButtonOffice.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonOffice.CheckAlign")));
			this.radioButtonOffice.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonOffice.Dock")));
			this.radioButtonOffice.Enabled = ((bool)(resources.GetObject("radioButtonOffice.Enabled")));
			this.radioButtonOffice.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonOffice.FlatStyle")));
			this.radioButtonOffice.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonOffice.Font")));
			this.radioButtonOffice.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonOffice.Image")));
			this.radioButtonOffice.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonOffice.ImageAlign")));
			this.radioButtonOffice.ImageIndex = ((int)(resources.GetObject("radioButtonOffice.ImageIndex")));
			this.radioButtonOffice.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonOffice.ImeMode")));
			this.radioButtonOffice.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonOffice.Location")));
			this.radioButtonOffice.Name = "radioButtonOffice";
			this.radioButtonOffice.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonOffice.RightToLeft")));
			this.radioButtonOffice.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonOffice.Size")));
			this.radioButtonOffice.TabIndex = ((int)(resources.GetObject("radioButtonOffice.TabIndex")));
			this.radioButtonOffice.Text = resources.GetString("radioButtonOffice.Text");
			this.radioButtonOffice.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonOffice.TextAlign")));
			this.radioButtonOffice.Visible = ((bool)(resources.GetObject("radioButtonOffice.Visible")));
			// 
			// NewStep9
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.groupBox1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "NewStep9";
			this.NextStep = "Step5";
			this.PreviousStep = "Step4";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.Controls.SetChildIndex(this.groupBox1, 0);
			this.Controls.SetChildIndex(this.Description, 0);
			this.groupBox1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion
	}
}

