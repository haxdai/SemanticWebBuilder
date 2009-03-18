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
namespace WBPowerPoint
{
	/// <summary>
	/// Control que permite mostrar el árbol de secciones para selecionar en que sección
	/// se encuentra el contenido para abrir
	/// </summary>
	public class OpenStep2 : TSWizards.BaseStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>
		/// Árbol de secciones a mostrar para seleccionar donde se encuentra el contenido
		/// para abrir
		/// </summary>
		public System.Windows.Forms.TreeView treeView1;
		private System.Windows.Forms.ImageList imageList1;
		private System.ComponentModel.IContainer components;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		TreeManager tm;
		/// <summary>
		/// Constructor de página de asistente
		/// </summary>
		/// <param name="next">boton siguiente de asistente</param>
		public OpenStep2(System.Windows.Forms.Button next)
		{
			// Llamada necesaria para el Diseñador de formularios Windows.Forms.
			InitializeComponent();

			// TODO: agregar cualquier inicialización después de llamar a InitializeComponent
			tm=new TreeManager(this.treeView1,next,CPowerPoint.user);
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
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(OpenStep2));
			this.treeView1 = new System.Windows.Forms.TreeView();
			this.imageList1 = new System.Windows.Forms.ImageList(this.components);
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// treeView1
			// 
			this.treeView1.AccessibleDescription = resources.GetString("treeView1.AccessibleDescription");
			this.treeView1.AccessibleName = resources.GetString("treeView1.AccessibleName");
			this.treeView1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("treeView1.Anchor")));
			this.treeView1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("treeView1.BackgroundImage")));
			this.treeView1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("treeView1.Dock")));
			this.treeView1.Enabled = ((bool)(resources.GetObject("treeView1.Enabled")));
			this.errorProvider1.SetError(this.treeView1, resources.GetString("treeView1.Error"));
			this.treeView1.Font = ((System.Drawing.Font)(resources.GetObject("treeView1.Font")));
			this.errorProvider1.SetIconAlignment(this.treeView1, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("treeView1.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.treeView1, ((int)(resources.GetObject("treeView1.IconPadding"))));
			this.treeView1.ImageIndex = ((int)(resources.GetObject("treeView1.ImageIndex")));
			this.treeView1.ImageList = this.imageList1;
			this.treeView1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("treeView1.ImeMode")));
			this.treeView1.Indent = ((int)(resources.GetObject("treeView1.Indent")));
			this.treeView1.ItemHeight = ((int)(resources.GetObject("treeView1.ItemHeight")));
			this.treeView1.Location = ((System.Drawing.Point)(resources.GetObject("treeView1.Location")));
			this.treeView1.Name = "treeView1";
			this.treeView1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("treeView1.RightToLeft")));
			this.treeView1.SelectedImageIndex = ((int)(resources.GetObject("treeView1.SelectedImageIndex")));
			this.treeView1.Size = ((System.Drawing.Size)(resources.GetObject("treeView1.Size")));
			this.treeView1.TabIndex = ((int)(resources.GetObject("treeView1.TabIndex")));
			this.treeView1.Text = resources.GetString("treeView1.Text");
			this.treeView1.Visible = ((bool)(resources.GetObject("treeView1.Visible")));
			// 
			// imageList1
			// 
			this.imageList1.ImageSize = ((System.Drawing.Size)(resources.GetObject("imageList1.ImageSize")));
			this.imageList1.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList1.ImageStream")));
			this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			this.errorProvider1.Icon = ((System.Drawing.Icon)(resources.GetObject("errorProvider1.Icon")));
			// 
			// OpenStep2
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.treeView1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.errorProvider1.SetError(this, resources.GetString("$this.Error"));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.errorProvider1.SetIconAlignment(this, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("$this.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this, ((int)(resources.GetObject("$this.IconPadding"))));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "OpenStep2";
			this.NextStep = "Step3";
			this.PreviousStep = "Step1";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.OpenStep2_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.OpenStep2_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.treeView1, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void OpenStep2_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			this.Cursor=Cursors.WaitCursor;										
			TreeNode root=this.treeView1.SelectedNode;
			OpenStep2 step2 = Wizard.GetStep("Step2") as OpenStep2;			
			
			if(step2.treeView1.SelectedNode!=null && step2.treeView1.SelectedNode is WBNode)
			{
				WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String topicid=values[values.Length-1];
				String idtopicmap=values[values.Length-2];	

				if(!CPowerPoint.user.GetPermiso(idtopicmap,CPowerPoint.TYPE))
				{
					this.errorProvider1.SetError(this.treeView1,resources.GetString("FrmMoverContenido.msg1"));
					e.Cancel=true;
					this.Cursor=Cursors.Default;										
					
				}
				else
				{
					this.errorProvider1.SetError(this.treeView1,"");
				}
			}
		}

		private void OpenStep2_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			if(this.treeView1.SelectedNode!=null)
				tm.treeView1_AfterSelect(null,new TreeViewEventArgs(this.treeView1.SelectedNode));				
			else
				this.Wizard.NextEnabled=false;
		}
	}
}
