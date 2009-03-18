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
	/// <summary>Forma para enviar un contenido a Flujo</summary>
	public class FrmEnviarFlujo : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.ComboBox comboBox1;
		private System.Windows.Forms.Button button2;
		private System.Windows.Forms.Button buttonSiguiente;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		String idcont,topicmap,topicid;
		FrmProp frm;
		CUserAdmin user;
		/// <summary>
		/// Constructor para forma de enviar a flujo un contenido
		/// </summary>
		/// <param name="idcont">Id del contenido</param>
		/// <param name="topicmap">sitio donde se encuentra el contenido</param>
		/// <param name="topicid">Sección en la que se encuentra el contenido</param>
		/// <param name="frm">Forma de propioedades donde fue invocada</param>
		/// <param name="user">Usuario que accede</param>
		public FrmEnviarFlujo(String idcont,String topicmap,String topicid,FrmProp frm,CUserAdmin user)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.user=user;
			this.idcont=idcont;
			this.topicmap=topicmap;
			this.topicid=topicid;
			this.frm=frm;
			
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmEnviarFlujo));
			this.comboBox1 = new System.Windows.Forms.ComboBox();
			this.button2 = new System.Windows.Forms.Button();
			this.buttonSiguiente = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// comboBox1
			// 
			this.comboBox1.AccessibleDescription = resources.GetString("comboBox1.AccessibleDescription");
			this.comboBox1.AccessibleName = resources.GetString("comboBox1.AccessibleName");
			this.comboBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("comboBox1.Anchor")));
			this.comboBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("comboBox1.BackgroundImage")));
			this.comboBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("comboBox1.Dock")));
			this.comboBox1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.comboBox1.Enabled = ((bool)(resources.GetObject("comboBox1.Enabled")));
			this.comboBox1.Font = ((System.Drawing.Font)(resources.GetObject("comboBox1.Font")));
			this.comboBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("comboBox1.ImeMode")));
			this.comboBox1.IntegralHeight = ((bool)(resources.GetObject("comboBox1.IntegralHeight")));
			this.comboBox1.ItemHeight = ((int)(resources.GetObject("comboBox1.ItemHeight")));
			this.comboBox1.Location = ((System.Drawing.Point)(resources.GetObject("comboBox1.Location")));
			this.comboBox1.MaxDropDownItems = ((int)(resources.GetObject("comboBox1.MaxDropDownItems")));
			this.comboBox1.MaxLength = ((int)(resources.GetObject("comboBox1.MaxLength")));
			this.comboBox1.Name = "comboBox1";
			this.comboBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("comboBox1.RightToLeft")));
			this.comboBox1.Size = ((System.Drawing.Size)(resources.GetObject("comboBox1.Size")));
			this.comboBox1.TabIndex = ((int)(resources.GetObject("comboBox1.TabIndex")));
			this.comboBox1.Text = resources.GetString("comboBox1.Text");
			this.comboBox1.Visible = ((bool)(resources.GetObject("comboBox1.Visible")));
			// 
			// button2
			// 
			this.button2.AccessibleDescription = resources.GetString("button2.AccessibleDescription");
			this.button2.AccessibleName = resources.GetString("button2.AccessibleName");
			this.button2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("button2.Anchor")));
			this.button2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("button2.BackgroundImage")));
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
			// FrmEnviarFlujo
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.comboBox1);
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
			this.Name = "FrmEnviarFlujo";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.ResumeLayout(false);

		}
		#endregion

		private void button2_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}
		private void CambiarEstado()
		{			
			Servicios s= new Servicios(user);
			s.acceptFlow(this.topicmap,this.topicid,this.idcont);
			if(!s.IsError)
			{
				MessageBox.Show(this,resources.GetString("FrmEnviarFlujo.msg1")+" "+ ((CCaracteristica)this.comboBox1.SelectedItem).Label +"",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  				
				frm.buttonPublicar.Visible=false; 
			}
		}
		private void buttonSiguiente_Click(object sender, System.EventArgs e)
		{
			if(this.comboBox1.Items.Count>0)
			{
				if(this.comboBox1.SelectedIndex!=-1)
				{					
					CambiarEstado();  
					this.Close();
				}
			}
		}
	}
}
