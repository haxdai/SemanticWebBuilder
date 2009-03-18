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
using WBOffice3;
namespace WBPowerPoint
{
	/// <summary>Control para indicar texto de la liga</summary>
	public class addLink3 : TSWizards.BaseInteriorStep
	{
		/// <summary>Caja de texto que contiene el texto de la liga</summary>
		/// <value>Caja de texto con el texto indicado por el usuario</value>
		public System.Windows.Forms.TextBox textBox1;
		private System.ComponentModel.IContainer components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public addLink3()
		{
			// Llamada necesaria para el Diseñador de Windows Forms.
			InitializeComponent();

			
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(addLink3));
			this.textBox1 = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// textBox1
			// 
			this.textBox1.AccessibleDescription = resources.GetString("textBox1.AccessibleDescription");
			this.textBox1.AccessibleName = resources.GetString("textBox1.AccessibleName");
			this.textBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("textBox1.Anchor")));
			this.textBox1.AutoSize = ((bool)(resources.GetObject("textBox1.AutoSize")));
			this.textBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("textBox1.BackgroundImage")));
			this.textBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("textBox1.Dock")));
			this.textBox1.Enabled = ((bool)(resources.GetObject("textBox1.Enabled")));
			this.textBox1.Font = ((System.Drawing.Font)(resources.GetObject("textBox1.Font")));
			this.textBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("textBox1.ImeMode")));
			this.textBox1.Location = ((System.Drawing.Point)(resources.GetObject("textBox1.Location")));
			this.textBox1.MaxLength = ((int)(resources.GetObject("textBox1.MaxLength")));
			this.textBox1.Multiline = ((bool)(resources.GetObject("textBox1.Multiline")));
			this.textBox1.Name = "textBox1";
			this.textBox1.PasswordChar = ((char)(resources.GetObject("textBox1.PasswordChar")));
			this.textBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("textBox1.RightToLeft")));
			this.textBox1.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("textBox1.ScrollBars")));
			this.textBox1.Size = ((System.Drawing.Size)(resources.GetObject("textBox1.Size")));
			this.textBox1.TabIndex = ((int)(resources.GetObject("textBox1.TabIndex")));
			this.textBox1.Text = resources.GetString("textBox1.Text");
			this.textBox1.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("textBox1.TextAlign")));
			this.textBox1.Visible = ((bool)(resources.GetObject("textBox1.Visible")));
			this.textBox1.WordWrap = ((bool)(resources.GetObject("textBox1.WordWrap")));
			this.textBox1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
			// 
			// addLink3
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.textBox1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.IsFinished = true;
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "addLink3";
			this.NextStep = "FINISHED";
			this.PreviousStep = "step2";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.addLink3_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.addLink3_ShowStep);
			this.Controls.SetChildIndex(this.textBox1, 0);
			this.Controls.SetChildIndex(this.Description, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void textBox1_TextChanged(object sender, System.EventArgs e)
		{
			if(this.textBox1.Text.Trim()=="")
			{
				this.Wizard.next.Enabled=false;
			}
			else
			{
				this.Wizard.next.Enabled=true;
			}
		}

		private void addLink3_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			textBox1_TextChanged(null,null);
		}

		private void addLink3_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			object missing=Type.Missing;
			addLink2 step2 = Wizard.GetStep("step2") as addLink2;
			object text=this.textBox1.Text;
			WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
			char[] chars={'.'};
			String[] values=wbnode.ReloadPath.Split(chars);
			String idtopic=values[values.Length-1];
			String idtopicmap=values[values.Length-2];	
			object address=CPowerPoint.user.Uri+ "wb/"+idtopicmap+"/"+idtopic;	
					
			//CPowerPoint.doc.sli .Hyperlinks.Add(CPowerPoint.app.Selection.Range,ref address,ref missing,ref missing,ref text,ref missing);
		}
	}
}

