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

namespace WBWord
{
	/// <summary>Control que muestra la configuración de paginación para un contenido</summary>
	public class NewStep8 : TSWizards.BaseStep
	{
		System.Resources.ResourceManager resword = new System.Resources.ResourceManager("WBWord.wordres",System.Reflection.Assembly.GetExecutingAssembly());		
		/// <summary>Text a mostrar para navegación entre páginas (Anterior)</summary>
		/// <value>Text a mostrar para navegación entre páginas (Anterior)</value>
		public System.Windows.Forms.TextBox textBoxAnterior;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.GroupBox groupBox2;
		/// <value>Indica si debe mostrar la navegación de paginación arriba y abajo</value>
		/// <summary>Indica si debe mostrar la navegación de paginación arriba y abajo</summary>
		public System.Windows.Forms.RadioButton radioButtonAmbos;
		/// <summary>Indica si debe mostrar la navegación de paginación abajo</summary>
		/// <value>Indica si debe mostrar la navegación de paginación abajo</value>
		public System.Windows.Forms.RadioButton radioButtonAbajo;
		/// <summary>Indica si debe mostrar la navegación de paginación arriba</summary>
		/// <value>Indica si debe mostrar la navegación de paginación arriba</value>
		public System.Windows.Forms.RadioButton radioButtonArriba;
		/// <summary>Text a mostrar para navegación entre páginas (Sigiente)</summary>
		/// <value>Text a mostrar para navegación entre páginas (Sigiente)</value>
		public System.Windows.Forms.TextBox txtTextoSiguiente;
		private System.Windows.Forms.Label label2;
		/// <summary>Indica el número de páginas a mostrar en la navegación de páginas</summary>
		/// <value>Indica el número de páginas a mostrar en la navegación de páginas</value>
		public System.Windows.Forms.NumericUpDown numericUpNumero;
		private System.Windows.Forms.Label label1;
		/// <summary>Regresa la selección para Páginación</summary>
		/// <value>
		/// Regresa la selección para Páginación, si el valor cheched es true debe paginar,
		/// si el valor es false, no debe paginar
		/// </value>
		public System.Windows.Forms.CheckBox checkBoxConfPaginacion;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		private System.Windows.Forms.GroupBox groupBoxOptions;
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
			this.groupBoxOptions = new System.Windows.Forms.GroupBox();
			this.textBoxAnterior = new System.Windows.Forms.TextBox();
			this.label3 = new System.Windows.Forms.Label();
			this.groupBox2 = new System.Windows.Forms.GroupBox();
			this.radioButtonAmbos = new System.Windows.Forms.RadioButton();
			this.radioButtonAbajo = new System.Windows.Forms.RadioButton();
			this.radioButtonArriba = new System.Windows.Forms.RadioButton();
			this.txtTextoSiguiente = new System.Windows.Forms.TextBox();
			this.label2 = new System.Windows.Forms.Label();
			this.numericUpNumero = new System.Windows.Forms.NumericUpDown();
			this.label1 = new System.Windows.Forms.Label();
			this.checkBoxConfPaginacion = new System.Windows.Forms.CheckBox();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider();
			this.groupBoxOptions.SuspendLayout();
			this.groupBox2.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.numericUpNumero)).BeginInit();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// groupBoxOptions
			// 
			this.groupBoxOptions.AccessibleDescription = resources.GetString("groupBoxOptions.AccessibleDescription");
			this.groupBoxOptions.AccessibleName = resources.GetString("groupBoxOptions.AccessibleName");
			this.groupBoxOptions.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBoxOptions.Anchor")));
			this.groupBoxOptions.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBoxOptions.BackgroundImage")));
			this.groupBoxOptions.Controls.Add(this.textBoxAnterior);
			this.groupBoxOptions.Controls.Add(this.label3);
			this.groupBoxOptions.Controls.Add(this.groupBox2);
			this.groupBoxOptions.Controls.Add(this.txtTextoSiguiente);
			this.groupBoxOptions.Controls.Add(this.label2);
			this.groupBoxOptions.Controls.Add(this.numericUpNumero);
			this.groupBoxOptions.Controls.Add(this.label1);
			this.groupBoxOptions.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBoxOptions.Dock")));
			this.groupBoxOptions.Enabled = ((bool)(resources.GetObject("groupBoxOptions.Enabled")));
			this.errorProvider1.SetError(this.groupBoxOptions, resources.GetString("groupBoxOptions.Error"));
			this.groupBoxOptions.Font = ((System.Drawing.Font)(resources.GetObject("groupBoxOptions.Font")));
			this.errorProvider1.SetIconAlignment(this.groupBoxOptions, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("groupBoxOptions.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.groupBoxOptions, ((int)(resources.GetObject("groupBoxOptions.IconPadding"))));
			this.groupBoxOptions.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBoxOptions.ImeMode")));
			this.groupBoxOptions.Location = ((System.Drawing.Point)(resources.GetObject("groupBoxOptions.Location")));
			this.groupBoxOptions.Name = "groupBoxOptions";
			this.groupBoxOptions.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBoxOptions.RightToLeft")));
			this.groupBoxOptions.Size = ((System.Drawing.Size)(resources.GetObject("groupBoxOptions.Size")));
			this.groupBoxOptions.TabIndex = ((int)(resources.GetObject("groupBoxOptions.TabIndex")));
			this.groupBoxOptions.TabStop = false;
			this.groupBoxOptions.Text = resources.GetString("groupBoxOptions.Text");
			this.groupBoxOptions.Visible = ((bool)(resources.GetObject("groupBoxOptions.Visible")));
			// 
			// textBoxAnterior
			// 
			this.textBoxAnterior.AccessibleDescription = resources.GetString("textBoxAnterior.AccessibleDescription");
			this.textBoxAnterior.AccessibleName = resources.GetString("textBoxAnterior.AccessibleName");
			this.textBoxAnterior.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("textBoxAnterior.Anchor")));
			this.textBoxAnterior.AutoSize = ((bool)(resources.GetObject("textBoxAnterior.AutoSize")));
			this.textBoxAnterior.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("textBoxAnterior.BackgroundImage")));
			this.textBoxAnterior.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("textBoxAnterior.Dock")));
			this.textBoxAnterior.Enabled = ((bool)(resources.GetObject("textBoxAnterior.Enabled")));
			this.errorProvider1.SetError(this.textBoxAnterior, resources.GetString("textBoxAnterior.Error"));
			this.textBoxAnterior.Font = ((System.Drawing.Font)(resources.GetObject("textBoxAnterior.Font")));
			this.errorProvider1.SetIconAlignment(this.textBoxAnterior, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("textBoxAnterior.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.textBoxAnterior, ((int)(resources.GetObject("textBoxAnterior.IconPadding"))));
			this.textBoxAnterior.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("textBoxAnterior.ImeMode")));
			this.textBoxAnterior.Location = ((System.Drawing.Point)(resources.GetObject("textBoxAnterior.Location")));
			this.textBoxAnterior.MaxLength = ((int)(resources.GetObject("textBoxAnterior.MaxLength")));
			this.textBoxAnterior.Multiline = ((bool)(resources.GetObject("textBoxAnterior.Multiline")));
			this.textBoxAnterior.Name = "textBoxAnterior";
			this.textBoxAnterior.PasswordChar = ((char)(resources.GetObject("textBoxAnterior.PasswordChar")));
			this.textBoxAnterior.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("textBoxAnterior.RightToLeft")));
			this.textBoxAnterior.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("textBoxAnterior.ScrollBars")));
			this.textBoxAnterior.Size = ((System.Drawing.Size)(resources.GetObject("textBoxAnterior.Size")));
			this.textBoxAnterior.TabIndex = ((int)(resources.GetObject("textBoxAnterior.TabIndex")));
			this.textBoxAnterior.Text = resources.GetString("textBoxAnterior.Text");
			this.textBoxAnterior.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("textBoxAnterior.TextAlign")));
			this.textBoxAnterior.Visible = ((bool)(resources.GetObject("textBoxAnterior.Visible")));
			this.textBoxAnterior.WordWrap = ((bool)(resources.GetObject("textBoxAnterior.WordWrap")));
			this.textBoxAnterior.TextChanged += new System.EventHandler(this.textBoxAnterior_TextChanged);
			// 
			// label3
			// 
			this.label3.AccessibleDescription = resources.GetString("label3.AccessibleDescription");
			this.label3.AccessibleName = resources.GetString("label3.AccessibleName");
			this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label3.Anchor")));
			this.label3.AutoSize = ((bool)(resources.GetObject("label3.AutoSize")));
			this.label3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label3.Dock")));
			this.label3.Enabled = ((bool)(resources.GetObject("label3.Enabled")));
			this.errorProvider1.SetError(this.label3, resources.GetString("label3.Error"));
			this.label3.Font = ((System.Drawing.Font)(resources.GetObject("label3.Font")));
			this.errorProvider1.SetIconAlignment(this.label3, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("label3.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.label3, ((int)(resources.GetObject("label3.IconPadding"))));
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
			// groupBox2
			// 
			this.groupBox2.AccessibleDescription = resources.GetString("groupBox2.AccessibleDescription");
			this.groupBox2.AccessibleName = resources.GetString("groupBox2.AccessibleName");
			this.groupBox2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox2.Anchor")));
			this.groupBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox2.BackgroundImage")));
			this.groupBox2.Controls.Add(this.radioButtonAmbos);
			this.groupBox2.Controls.Add(this.radioButtonAbajo);
			this.groupBox2.Controls.Add(this.radioButtonArriba);
			this.groupBox2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox2.Dock")));
			this.groupBox2.Enabled = ((bool)(resources.GetObject("groupBox2.Enabled")));
			this.errorProvider1.SetError(this.groupBox2, resources.GetString("groupBox2.Error"));
			this.groupBox2.Font = ((System.Drawing.Font)(resources.GetObject("groupBox2.Font")));
			this.errorProvider1.SetIconAlignment(this.groupBox2, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("groupBox2.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.groupBox2, ((int)(resources.GetObject("groupBox2.IconPadding"))));
			this.groupBox2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBox2.ImeMode")));
			this.groupBox2.Location = ((System.Drawing.Point)(resources.GetObject("groupBox2.Location")));
			this.groupBox2.Name = "groupBox2";
			this.groupBox2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBox2.RightToLeft")));
			this.groupBox2.Size = ((System.Drawing.Size)(resources.GetObject("groupBox2.Size")));
			this.groupBox2.TabIndex = ((int)(resources.GetObject("groupBox2.TabIndex")));
			this.groupBox2.TabStop = false;
			this.groupBox2.Text = resources.GetString("groupBox2.Text");
			this.groupBox2.Visible = ((bool)(resources.GetObject("groupBox2.Visible")));
			// 
			// radioButtonAmbos
			// 
			this.radioButtonAmbos.AccessibleDescription = resources.GetString("radioButtonAmbos.AccessibleDescription");
			this.radioButtonAmbos.AccessibleName = resources.GetString("radioButtonAmbos.AccessibleName");
			this.radioButtonAmbos.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonAmbos.Anchor")));
			this.radioButtonAmbos.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonAmbos.Appearance")));
			this.radioButtonAmbos.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonAmbos.BackgroundImage")));
			this.radioButtonAmbos.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonAmbos.CheckAlign")));
			this.radioButtonAmbos.Checked = true;
			this.radioButtonAmbos.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonAmbos.Dock")));
			this.radioButtonAmbos.Enabled = ((bool)(resources.GetObject("radioButtonAmbos.Enabled")));
			this.errorProvider1.SetError(this.radioButtonAmbos, resources.GetString("radioButtonAmbos.Error"));
			this.radioButtonAmbos.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonAmbos.FlatStyle")));
			this.radioButtonAmbos.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonAmbos.Font")));
			this.errorProvider1.SetIconAlignment(this.radioButtonAmbos, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("radioButtonAmbos.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.radioButtonAmbos, ((int)(resources.GetObject("radioButtonAmbos.IconPadding"))));
			this.radioButtonAmbos.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonAmbos.Image")));
			this.radioButtonAmbos.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonAmbos.ImageAlign")));
			this.radioButtonAmbos.ImageIndex = ((int)(resources.GetObject("radioButtonAmbos.ImageIndex")));
			this.radioButtonAmbos.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonAmbos.ImeMode")));
			this.radioButtonAmbos.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonAmbos.Location")));
			this.radioButtonAmbos.Name = "radioButtonAmbos";
			this.radioButtonAmbos.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonAmbos.RightToLeft")));
			this.radioButtonAmbos.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonAmbos.Size")));
			this.radioButtonAmbos.TabIndex = ((int)(resources.GetObject("radioButtonAmbos.TabIndex")));
			this.radioButtonAmbos.TabStop = true;
			this.radioButtonAmbos.Text = resources.GetString("radioButtonAmbos.Text");
			this.radioButtonAmbos.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonAmbos.TextAlign")));
			this.radioButtonAmbos.Visible = ((bool)(resources.GetObject("radioButtonAmbos.Visible")));
			// 
			// radioButtonAbajo
			// 
			this.radioButtonAbajo.AccessibleDescription = resources.GetString("radioButtonAbajo.AccessibleDescription");
			this.radioButtonAbajo.AccessibleName = resources.GetString("radioButtonAbajo.AccessibleName");
			this.radioButtonAbajo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonAbajo.Anchor")));
			this.radioButtonAbajo.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonAbajo.Appearance")));
			this.radioButtonAbajo.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonAbajo.BackgroundImage")));
			this.radioButtonAbajo.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonAbajo.CheckAlign")));
			this.radioButtonAbajo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonAbajo.Dock")));
			this.radioButtonAbajo.Enabled = ((bool)(resources.GetObject("radioButtonAbajo.Enabled")));
			this.errorProvider1.SetError(this.radioButtonAbajo, resources.GetString("radioButtonAbajo.Error"));
			this.radioButtonAbajo.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonAbajo.FlatStyle")));
			this.radioButtonAbajo.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonAbajo.Font")));
			this.errorProvider1.SetIconAlignment(this.radioButtonAbajo, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("radioButtonAbajo.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.radioButtonAbajo, ((int)(resources.GetObject("radioButtonAbajo.IconPadding"))));
			this.radioButtonAbajo.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonAbajo.Image")));
			this.radioButtonAbajo.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonAbajo.ImageAlign")));
			this.radioButtonAbajo.ImageIndex = ((int)(resources.GetObject("radioButtonAbajo.ImageIndex")));
			this.radioButtonAbajo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonAbajo.ImeMode")));
			this.radioButtonAbajo.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonAbajo.Location")));
			this.radioButtonAbajo.Name = "radioButtonAbajo";
			this.radioButtonAbajo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonAbajo.RightToLeft")));
			this.radioButtonAbajo.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonAbajo.Size")));
			this.radioButtonAbajo.TabIndex = ((int)(resources.GetObject("radioButtonAbajo.TabIndex")));
			this.radioButtonAbajo.Text = resources.GetString("radioButtonAbajo.Text");
			this.radioButtonAbajo.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonAbajo.TextAlign")));
			this.radioButtonAbajo.Visible = ((bool)(resources.GetObject("radioButtonAbajo.Visible")));
			// 
			// radioButtonArriba
			// 
			this.radioButtonArriba.AccessibleDescription = resources.GetString("radioButtonArriba.AccessibleDescription");
			this.radioButtonArriba.AccessibleName = resources.GetString("radioButtonArriba.AccessibleName");
			this.radioButtonArriba.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonArriba.Anchor")));
			this.radioButtonArriba.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonArriba.Appearance")));
			this.radioButtonArriba.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonArriba.BackgroundImage")));
			this.radioButtonArriba.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonArriba.CheckAlign")));
			this.radioButtonArriba.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonArriba.Dock")));
			this.radioButtonArriba.Enabled = ((bool)(resources.GetObject("radioButtonArriba.Enabled")));
			this.errorProvider1.SetError(this.radioButtonArriba, resources.GetString("radioButtonArriba.Error"));
			this.radioButtonArriba.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonArriba.FlatStyle")));
			this.radioButtonArriba.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonArriba.Font")));
			this.errorProvider1.SetIconAlignment(this.radioButtonArriba, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("radioButtonArriba.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.radioButtonArriba, ((int)(resources.GetObject("radioButtonArriba.IconPadding"))));
			this.radioButtonArriba.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonArriba.Image")));
			this.radioButtonArriba.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonArriba.ImageAlign")));
			this.radioButtonArriba.ImageIndex = ((int)(resources.GetObject("radioButtonArriba.ImageIndex")));
			this.radioButtonArriba.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonArriba.ImeMode")));
			this.radioButtonArriba.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonArriba.Location")));
			this.radioButtonArriba.Name = "radioButtonArriba";
			this.radioButtonArriba.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonArriba.RightToLeft")));
			this.radioButtonArriba.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonArriba.Size")));
			this.radioButtonArriba.TabIndex = ((int)(resources.GetObject("radioButtonArriba.TabIndex")));
			this.radioButtonArriba.Text = resources.GetString("radioButtonArriba.Text");
			this.radioButtonArriba.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonArriba.TextAlign")));
			this.radioButtonArriba.Visible = ((bool)(resources.GetObject("radioButtonArriba.Visible")));
			// 
			// txtTextoSiguiente
			// 
			this.txtTextoSiguiente.AccessibleDescription = resources.GetString("txtTextoSiguiente.AccessibleDescription");
			this.txtTextoSiguiente.AccessibleName = resources.GetString("txtTextoSiguiente.AccessibleName");
			this.txtTextoSiguiente.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtTextoSiguiente.Anchor")));
			this.txtTextoSiguiente.AutoSize = ((bool)(resources.GetObject("txtTextoSiguiente.AutoSize")));
			this.txtTextoSiguiente.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtTextoSiguiente.BackgroundImage")));
			this.txtTextoSiguiente.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtTextoSiguiente.Dock")));
			this.txtTextoSiguiente.Enabled = ((bool)(resources.GetObject("txtTextoSiguiente.Enabled")));
			this.errorProvider1.SetError(this.txtTextoSiguiente, resources.GetString("txtTextoSiguiente.Error"));
			this.txtTextoSiguiente.Font = ((System.Drawing.Font)(resources.GetObject("txtTextoSiguiente.Font")));
			this.errorProvider1.SetIconAlignment(this.txtTextoSiguiente, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("txtTextoSiguiente.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.txtTextoSiguiente, ((int)(resources.GetObject("txtTextoSiguiente.IconPadding"))));
			this.txtTextoSiguiente.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtTextoSiguiente.ImeMode")));
			this.txtTextoSiguiente.Location = ((System.Drawing.Point)(resources.GetObject("txtTextoSiguiente.Location")));
			this.txtTextoSiguiente.MaxLength = ((int)(resources.GetObject("txtTextoSiguiente.MaxLength")));
			this.txtTextoSiguiente.Multiline = ((bool)(resources.GetObject("txtTextoSiguiente.Multiline")));
			this.txtTextoSiguiente.Name = "txtTextoSiguiente";
			this.txtTextoSiguiente.PasswordChar = ((char)(resources.GetObject("txtTextoSiguiente.PasswordChar")));
			this.txtTextoSiguiente.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtTextoSiguiente.RightToLeft")));
			this.txtTextoSiguiente.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtTextoSiguiente.ScrollBars")));
			this.txtTextoSiguiente.Size = ((System.Drawing.Size)(resources.GetObject("txtTextoSiguiente.Size")));
			this.txtTextoSiguiente.TabIndex = ((int)(resources.GetObject("txtTextoSiguiente.TabIndex")));
			this.txtTextoSiguiente.Text = resources.GetString("txtTextoSiguiente.Text");
			this.txtTextoSiguiente.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtTextoSiguiente.TextAlign")));
			this.txtTextoSiguiente.Visible = ((bool)(resources.GetObject("txtTextoSiguiente.Visible")));
			this.txtTextoSiguiente.WordWrap = ((bool)(resources.GetObject("txtTextoSiguiente.WordWrap")));
			this.txtTextoSiguiente.TextChanged += new System.EventHandler(this.txtTextoSiguiente_TextChanged);
			// 
			// label2
			// 
			this.label2.AccessibleDescription = resources.GetString("label2.AccessibleDescription");
			this.label2.AccessibleName = resources.GetString("label2.AccessibleName");
			this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label2.Anchor")));
			this.label2.AutoSize = ((bool)(resources.GetObject("label2.AutoSize")));
			this.label2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label2.Dock")));
			this.label2.Enabled = ((bool)(resources.GetObject("label2.Enabled")));
			this.errorProvider1.SetError(this.label2, resources.GetString("label2.Error"));
			this.label2.Font = ((System.Drawing.Font)(resources.GetObject("label2.Font")));
			this.errorProvider1.SetIconAlignment(this.label2, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("label2.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.label2, ((int)(resources.GetObject("label2.IconPadding"))));
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
			// numericUpNumero
			// 
			this.numericUpNumero.AccessibleDescription = resources.GetString("numericUpNumero.AccessibleDescription");
			this.numericUpNumero.AccessibleName = resources.GetString("numericUpNumero.AccessibleName");
			this.numericUpNumero.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("numericUpNumero.Anchor")));
			this.numericUpNumero.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("numericUpNumero.Dock")));
			this.numericUpNumero.Enabled = ((bool)(resources.GetObject("numericUpNumero.Enabled")));
			this.errorProvider1.SetError(this.numericUpNumero, resources.GetString("numericUpNumero.Error"));
			this.numericUpNumero.Font = ((System.Drawing.Font)(resources.GetObject("numericUpNumero.Font")));
			this.errorProvider1.SetIconAlignment(this.numericUpNumero, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("numericUpNumero.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.numericUpNumero, ((int)(resources.GetObject("numericUpNumero.IconPadding"))));
			this.numericUpNumero.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("numericUpNumero.ImeMode")));
			this.numericUpNumero.Location = ((System.Drawing.Point)(resources.GetObject("numericUpNumero.Location")));
			this.numericUpNumero.Maximum = new System.Decimal(new int[] {
																			50,
																			0,
																			0,
																			0});
			this.numericUpNumero.Minimum = new System.Decimal(new int[] {
																			1,
																			0,
																			0,
																			0});
			this.numericUpNumero.Name = "numericUpNumero";
			this.numericUpNumero.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("numericUpNumero.RightToLeft")));
			this.numericUpNumero.Size = ((System.Drawing.Size)(resources.GetObject("numericUpNumero.Size")));
			this.numericUpNumero.TabIndex = ((int)(resources.GetObject("numericUpNumero.TabIndex")));
			this.numericUpNumero.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("numericUpNumero.TextAlign")));
			this.numericUpNumero.ThousandsSeparator = ((bool)(resources.GetObject("numericUpNumero.ThousandsSeparator")));
			this.numericUpNumero.UpDownAlign = ((System.Windows.Forms.LeftRightAlignment)(resources.GetObject("numericUpNumero.UpDownAlign")));
			this.numericUpNumero.Value = new System.Decimal(new int[] {
																		  15,
																		  0,
																		  0,
																		  0});
			this.numericUpNumero.Visible = ((bool)(resources.GetObject("numericUpNumero.Visible")));
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
			this.Controls.Add(this.groupBoxOptions);
			this.Controls.Add(this.checkBoxConfPaginacion);
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
			this.Controls.SetChildIndex(this.checkBoxConfPaginacion, 0);
			this.Controls.SetChildIndex(this.groupBoxOptions, 0);
			this.Controls.SetChildIndex(this.Description, 0);
			this.groupBoxOptions.ResumeLayout(false);
			this.groupBox2.ResumeLayout(false);
			((System.ComponentModel.ISupportInitialize)(this.numericUpNumero)).EndInit();
			this.ResumeLayout(false);

		}
		#endregion


		private void checkBoxConfPaginacion_CheckedChanged(object sender, System.EventArgs e)
		{
			this.groupBoxOptions.Enabled=!this.groupBoxOptions.Enabled;
		}

		private void NewStep8_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			if(this.txtTextoSiguiente.Text.Trim()=="")
			{
				this.errorProvider1.SetError(this.txtTextoSiguiente,resword.GetString("msgSiguiente"));
				e.Cancel=true;
			}
			if(this.textBoxAnterior.Text.Trim()=="")
			{
				this.errorProvider1.SetError(this.textBoxAnterior,resword.GetString("msgAnterior"));
				e.Cancel=true;
			}
			this.Wizard.NextEnabled=true;
		}

		private void NewStep8_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.NextEnabled=false;
			txtTextoSiguiente_TextChanged(null,null);
		}

		private void txtTextoSiguiente_TextChanged(object sender, System.EventArgs e)
		{
			if(this.txtTextoSiguiente.Text.Trim()=="")
			{
				this.Wizard.NextEnabled=false;
			}
			if(this.textBoxAnterior.Text.Trim()=="")
			{
				this.Wizard.NextEnabled=false;
			}
			this.Wizard.NextEnabled=true;
		}

		private void textBoxAnterior_TextChanged(object sender, System.EventArgs e)
		{
			if(this.txtTextoSiguiente.Text.Trim()=="")
			{
				this.Wizard.NextEnabled=false;
			}
			if(this.textBoxAnterior.Text.Trim()=="")
			{
				this.Wizard.NextEnabled=false;
			}
			this.Wizard.NextEnabled=true;
		}
	}
}

