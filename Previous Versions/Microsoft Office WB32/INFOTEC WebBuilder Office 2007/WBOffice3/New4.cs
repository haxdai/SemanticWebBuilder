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
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>Control que muestra la pantalla para capturar el titulo</summary>
	public class New4 : TSWizards.BaseInteriorStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.TextBox txttitulo;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		/// <summary> 
		/// Variable del dise�ador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.Label label1;
		private IParameter p;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public New4()
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(New4));
			this.txttitulo = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// txttitulo
			// 
			this.txttitulo.AccessibleDescription = resources.GetString("txttitulo.AccessibleDescription");
			this.txttitulo.AccessibleName = resources.GetString("txttitulo.AccessibleName");
			this.txttitulo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txttitulo.Anchor")));
			this.txttitulo.AutoSize = ((bool)(resources.GetObject("txttitulo.AutoSize")));
			this.txttitulo.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txttitulo.BackgroundImage")));
			this.txttitulo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txttitulo.Dock")));
			this.txttitulo.Enabled = ((bool)(resources.GetObject("txttitulo.Enabled")));
			this.errorProvider1.SetError(this.txttitulo, resources.GetString("txttitulo.Error"));
			this.txttitulo.Font = ((System.Drawing.Font)(resources.GetObject("txttitulo.Font")));
			this.errorProvider1.SetIconAlignment(this.txttitulo, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("txttitulo.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.txttitulo, ((int)(resources.GetObject("txttitulo.IconPadding"))));
			this.txttitulo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txttitulo.ImeMode")));
			this.txttitulo.Location = ((System.Drawing.Point)(resources.GetObject("txttitulo.Location")));
			this.txttitulo.MaxLength = ((int)(resources.GetObject("txttitulo.MaxLength")));
			this.txttitulo.Multiline = ((bool)(resources.GetObject("txttitulo.Multiline")));
			this.txttitulo.Name = "txttitulo";
			this.txttitulo.PasswordChar = ((char)(resources.GetObject("txttitulo.PasswordChar")));
			this.txttitulo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txttitulo.RightToLeft")));
			this.txttitulo.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txttitulo.ScrollBars")));
			this.txttitulo.Size = ((System.Drawing.Size)(resources.GetObject("txttitulo.Size")));
			this.txttitulo.TabIndex = ((int)(resources.GetObject("txttitulo.TabIndex")));
			this.txttitulo.Text = resources.GetString("txttitulo.Text");
			this.txttitulo.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txttitulo.TextAlign")));
			this.txttitulo.Visible = ((bool)(resources.GetObject("txttitulo.Visible")));
			this.txttitulo.WordWrap = ((bool)(resources.GetObject("txttitulo.WordWrap")));
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
			// New4
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.label1);
			this.Controls.Add(this.txttitulo);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.errorProvider1.SetError(this, resources.GetString("$this.Error"));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.errorProvider1.SetIconAlignment(this, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("$this.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this, ((int)(resources.GetObject("$this.IconPadding"))));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "New4";
			this.NextStep = "Step5";
			this.PreviousStep = "Step3";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.New4_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.New4_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.txttitulo, 0);
			this.Controls.SetChildIndex(this.label1, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void New4_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			if(this.txttitulo.Text.Trim()=="")
			{
				this.errorProvider1.SetError(this.txttitulo,resources.GetString("FrmNewTopic3.msg1") +" "+  this.p.Attributes[1].Value);
				e.Cancel=true;
				return ;
			}
			for(int i=0;i<FrmNewSection.parametros.Count;i++) 
			{
				IParameter p= FrmNewSection.parametros[i];
				if(p==this.p)
				{
					p.Value=this.txttitulo.Text; 
					if(i==(FrmNewSection.parametros.Count -1))
					{						
						return;
					}
					else
					{						
						this.p=FrmNewSection.parametros[i+1];						
						this.txttitulo.Text=this.p.Value;
						String name=this.p.Attributes[1].Value;
						this.label1.Text=" "+name;
						this.txttitulo.Focus();
						e.Cancel=true;
						return;						
					}					
				}
			}
			
		}

		private void New4_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			p=FrmNewSection.parametros[0];
			this.txttitulo.Focus();
			String id=p.Value;
			String name=p.Attributes[1].Value;
			this.label1.Text=" "+name;
			this.txttitulo.Text=p.Value;   
			this.txttitulo.Focus();
		}

		
	}
}
