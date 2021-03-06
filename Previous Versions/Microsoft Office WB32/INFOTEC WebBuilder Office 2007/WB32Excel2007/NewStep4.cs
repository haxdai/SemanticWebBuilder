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
using WBOffice3;
using System.Xml;
namespace WBExcel
{
	/// <summary>Control que muestra las secciones en donde sera almacenado el contenido</summary>
	public class NewStep4 : TSWizards.BaseStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>�rbol de secciones para seleccionar donde sera almacenado el contenido</summary>
		/// <value>�rbol de secciones para seleccionar donde sera almacenado el contenido</value>
		public System.Windows.Forms.TreeView treeView1;
		private System.Windows.Forms.ImageList imageList1;
		private System.ComponentModel.IContainer components;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		TreeManager tm=null;
		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="next">Boton siguiente del asistente</param>
		public NewStep4(System.Windows.Forms.Button next)
		{
			// Llamada necesaria para el Dise�ador de formularios Windows.Forms.
			InitializeComponent();

			// TODO: agregar cualquier inicializaci�n despu�s de llamar a InitializeComponent
			tm=new TreeManager(this.treeView1,next,CExcel.user);
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
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(NewStep4));
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
			this.treeView1.HideSelection = false;
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
			// NewStep4
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
			this.Name = "NewStep4";
			this.NextStep = "Step9";
			this.PreviousStep = "Step3";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.NewStep4_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.NewStep4_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.treeView1, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void NewStep4_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			this.Cursor=Cursors.WaitCursor;										
			TreeNode root=this.treeView1.SelectedNode;
			NewStep4 step4 = Wizard.GetStep("Step4") as NewStep4;
			TreeView treeView1=step4.treeView1;
			this.Cursor=Cursors.WaitCursor; 
			if(treeView1.SelectedNode!=null && treeView1.SelectedNode is WBNode)
			{
				WBNode wbnode=(WBNode)treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String idtopic=values[values.Length-1];
				String idtopicmap=values[values.Length-2];

				if(!CExcel.user.GetPermiso(idtopicmap,CExcel.TYPE))
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

		private void NewStep4_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			if(this.treeView1.SelectedNode!=null)
				tm.treeView1_AfterSelect(null,new TreeViewEventArgs(this.treeView1.SelectedNode));				
			else
				this.Wizard.NextEnabled=false;
			this.treeView1.Focus();
		}
	}
}
