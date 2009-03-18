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

namespace WBOffice3
{
	/// <summary>Control que muestra el Id de la secci�n</summary>
	public class New5 : TSWizards.BaseInteriorStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>Titulo de la secci�n</summary>
		public System.Windows.Forms.TextBox txttitulo;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		/// <summary> 
		/// Variable del dise�ador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;

		/// <summary>Crea el control</summary>
		public New5()
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(New5));
			this.txttitulo = new System.Windows.Forms.TextBox();
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
			this.txttitulo.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txttitulo_KeyPress);
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			this.errorProvider1.Icon = ((System.Drawing.Icon)(resources.GetObject("errorProvider1.Icon")));
			// 
			// New5
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.txttitulo);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.errorProvider1.SetError(this, resources.GetString("$this.Error"));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.errorProvider1.SetIconAlignment(this, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("$this.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this, ((int)(resources.GetObject("$this.IconPadding"))));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "New5";
			this.NextStep = "Step6";
			this.PreviousStep = "Step4";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.New5_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.New5_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.txttitulo, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void txttitulo_KeyPress(object sender, System.Windows.Forms.KeyPressEventArgs e)
		{
			int ichar=e.KeyChar;			
			if(ichar==8)
			{
				return;
			}
			if(ichar>=65 && ichar<=90) // A-Z
			{
				return;
			}
			if(ichar>=48 && ichar<=57) // 0 - 9
			{
				return;
			}
			if(ichar>=97 && ichar<=122) // a - z
			{
				return;
			}
			if(e.KeyChar=='_') 
			{
				return;
			}			
			e.Handled=true; 
		}

		private void New5_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			if(this.txttitulo.Text.Trim().Equals(""))
			{
				this.errorProvider1.SetError(this.txttitulo,resources.GetString("FrmNewTopic4.msg1"));				
				e.Cancel=true;
				return;
			}
			this.Cursor=Cursors.WaitCursor; 
		}

		private void New5_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{	
			this.txttitulo.Focus();
			New3 step3 = Wizard.GetStep("Step3") as New3;
			foreach(IParameter p in FrmNewSection.parametros)
			{
				if(p.Name.Equals("name"))
				{
					foreach(Attribute att in  p.Attributes)
					{
						if(att.Name.Equals("id") && att.Value.Equals(step3.Idioma))
						{
							String titulo=step3.Prefix+GetId(p.Value); // titulo de la secci�n en idioma default
							if(titulo.Length>50)
							{
								titulo=titulo.Substring(0,50);
							}
							this.txttitulo.Text=titulo; 
						}
					}
					
				}
			}
		}
		private String GetId(String titulo)
		{
			String newtitulo="";
			char[] caracteres=titulo.ToCharArray(); 
			for(int i=0;i<caracteres.Length ;i++)
			{
				char c=caracteres[i];
				if(c>=48 && c<=57) // 0 - 9
				{
					newtitulo+=c;
				}
				if(c>=65 && c<=90) // A - Z
				{
					newtitulo+=c;
				}
				if(c>=97 && c<=122) // a - z
				{
					newtitulo+=c;
				}
				if(c==32) // espacio
				{
					newtitulo+="_";
				}
				if(c==241) // �
				{
					newtitulo+="n";
				}
				if(c==209) // �
				{
					newtitulo+="N";
				}
				if(c>=224 && c<=229)	// a
				{
					newtitulo+="a";
				}
				if(c>=232 && c<=235)	// e
				{
					newtitulo+="e";
				}
				if(c>=236 && c<=239)	// i
				{
					newtitulo+="i";
				}
				if(c>=242 && c<=246)	// o
				{
					newtitulo+="o";
				}
				if(c>=249 && c<=252)	// u
				{
					newtitulo+="u";
				}
				if(c>=192 && c<=197)	// A
				{
					newtitulo+="A";
				}
				if(c>=200 && c<=203)	// E
				{
					newtitulo+="E";
				}
				if(c>=204 && c<=207)	// I
				{
					newtitulo+="I";
				}
				if(c>=210 && c<=214)	// O
				{
					newtitulo+="O";
				}
				if(c>=217 && c<=220)	// U
				{
					newtitulo+="U";
				}
				else
				{
					newtitulo+="";
				}
			}
			return newtitulo;
		}
	}
}
