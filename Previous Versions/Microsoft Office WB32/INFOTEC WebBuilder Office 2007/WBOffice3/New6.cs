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
using System.Xml;
namespace WBOffice3
{
	/// <summary>Muestra el resumen para la creación de la sección</summary>
	public class New6 : TSWizards.BaseInteriorStep
	{
		private System.Windows.Forms.TextBox txtResumen;
		/// <summary> 
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public New6()
		{
			// Llamada necesaria para el Diseñador de formularios Windows.Forms.
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
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Código generado por el Diseñador de componentes
		/// <summary> 
		/// Método necesario para admitir el Diseñador. No se puede modificar 
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(New6));
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
			// New6
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
			this.Name = "New6";
			this.NextStep = "Step7";
			this.PreviousStep = "Step5";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.New6_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.New6_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.txtResumen, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void New6_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.back.Visible=true;
			this.Wizard.cancel.Visible=true;
			this.txtResumen.Text="";
			New2 step2 = Wizard.GetStep("Step2") as New2;
			this.txtResumen.Text+=step2.treeView1.SelectedNode.Text+"\r\n";
			foreach(IParameter p in FrmNewSection.parametros)
			{
				if(p.Name=="name")
				{
					this.txtResumen.Text+=p.Attributes[1].Value+":"+p.Value+"\r\n";
				}
			}

			New5 step5 = Wizard.GetStep("Step5") as New5;
			this.txtResumen.Text+=step5.txttitulo.Text+"\r\n";
		}

		private void New6_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			New5 step5 = Wizard.GetStep("Step5") as New5;
			New2 step2 = Wizard.GetStep("Step2") as New2;
			bool existe=false;
			foreach(IParameter p in FrmNewSection.parametros)
			{
				if(p.Name.Equals("id"))
				{
					existe=true;
					p.Value=step5.txttitulo.Text;					
				}
			}	
			if(!existe)
			{
				FrmNewSection.parametros.Add(new Parameter("id",step5.txttitulo.Text));  
			}
			ParameterCollection pnew=new ParameterCollection(); 
			foreach(IParameter pant in FrmNewSection.parametros)
			{
				if(pant.Name.Equals("name"))
				{
					// genera el parametro
					Parameter pname=new Parameter("name",""); 
					WBOffice3.Attribute attscope=new WBOffice3.Attribute("scope","IDM_WB"+pant.Attributes[0].Value); 
					WBOffice3.Attribute attvalue=new WBOffice3.Attribute("value",pant.Value); 
					pname.Attributes.Add(attscope); 
					pname.Attributes.Add(attvalue); 
					pnew.Add(pname); 
				}
				else
				{
					pnew.Add(pant); 
				}
			}
			if(step2.treeView1.SelectedNode!=null && step2.treeView1.SelectedNode is WBNode)
			{
				WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String idtopic=values[values.Length-1];
				String idtopicmap=values[values.Length-2];	
				/*TreeNode root=step2.treeView1.SelectedNode;			
				while(root.Parent!=null)
				{
					root=root.Parent;
				}

				System.Xml.XmlElement topicmap=(XmlElement)root.Tag;
				String idtopicmap=topicmap.GetElementsByTagName("id")[0].InnerText;  
				System.Xml.XmlElement topic=(XmlElement)step2.treeView1.SelectedNode.Tag;
				String idtopic=topic.GetElementsByTagName("id")[0].InnerText;*/

                ParameterCollection temp = FrmNewSection.parametros;
				FrmNewSection.parametros=pnew;							
				Parameter parameter = new Parameter("topicid",idtopic); 
				FrmNewSection.parametros.Add(parameter); 
				Parameter parametermap = new Parameter("topicmap",idtopicmap); 
				FrmNewSection.parametros.Add(parametermap); 
				Servicios s=new Servicios(FrmNewSection.user);
				s.newTopic(FrmNewSection.parametros); 		
				if(s.IsError)
				{
                    FrmNewSection.parametros = temp;
					e.Cancel=true;
				}
			}
		}
	}
}
