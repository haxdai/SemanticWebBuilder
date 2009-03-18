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
	/// <summary>Control que muestra la secciones de un sitio</summary>	
	public class addLink2 : TSWizards.BaseInteriorStep
	{		
		/// <summary>Árbol de secciones</summary>
		/// <value>Regresa el arbol de secciones a llenar con las secciones</value>
		public System.Windows.Forms.TreeView treeView1;
		private System.Windows.Forms.ImageList imageList1;
		private System.ComponentModel.IContainer components = null;
		TreeManager tm;
		/// <summary>Crea el control</summary>
		/// <param name="next">
		/// Boton siguiente para habilitarlo o desabilitarlo en caso de selección correcta o
		/// incorrecta.
		/// </param>
		public addLink2(System.Windows.Forms.Button next)
		{
			// Llamada necesaria para el Diseñador de Windows Forms.
			InitializeComponent();
			tm=new TreeManager(this.treeView1,next,CPowerPoint.user);
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(addLink2));
			this.treeView1 = new System.Windows.Forms.TreeView();
			this.imageList1 = new System.Windows.Forms.ImageList(this.components);
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
			this.treeView1.Font = ((System.Drawing.Font)(resources.GetObject("treeView1.Font")));
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
			this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
			// 
			// addLink2
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.treeView1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "addLink2";
			this.NextStep = "step3";
			this.PreviousStep = "step2";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.Controls.SetChildIndex(this.treeView1, 0);
			this.Controls.SetChildIndex(this.Description, 0);
			this.ResumeLayout(false);

		}
		#endregion
	}
}

