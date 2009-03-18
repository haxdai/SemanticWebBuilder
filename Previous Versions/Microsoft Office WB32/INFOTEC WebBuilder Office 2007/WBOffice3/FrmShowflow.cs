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
using System.Xml;
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>
	/// Forma que muestra el flujo de un contenido, el paso actual y los pasos que
	/// contempla.
	/// </summary>
	public class FrmShowflow : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Button buttonClose;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.ListView listView1;
		private System.Windows.Forms.ColumnHeader columnHeader1;
		private System.Windows.Forms.ColumnHeader columnHeader2;
		private System.Windows.Forms.ColumnHeader columnHeader3;
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		String topicmap;
		String topicid;
		String occurrence;
		String step;
		CUserAdmin user;
		private System.Windows.Forms.Panel panelConteniner;
		ArrayList activities=new ArrayList();
		/// <summary>
		/// Consturctor para mostrar el flujo
		/// </summary>
		/// <param name="user">Usuario</param>
		/// <param name="topicmap">Sitio del contenido</param>
		/// <param name="topicid">Sección del contenido</param>
		/// <param name="occurrence">Ocurrencia del contenido</param>
		/// <param name="step">Paso en el que se encuentra</param>
		public FrmShowflow(CUserAdmin user,String topicmap,String topicid,String occurrence,String step)
		{
			//
			// Necesario para admitir el Diseñador de Windows Forms
			//
			InitializeComponent();

			this.user=user;
			this.topicmap=topicmap;
			this.topicid=topicid;
			this.occurrence=occurrence;
			this.step=step;
			
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

		#region Código generado por el Diseñador de Windows Forms
		/// <summary>
		/// Método necesario para admitir el Diseñador. No se puede modificar
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmShowflow));
			this.buttonClose = new System.Windows.Forms.Button();
			this.panelConteniner = new System.Windows.Forms.Panel();
			this.panel2 = new System.Windows.Forms.Panel();
			this.listView1 = new System.Windows.Forms.ListView();
			this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader2 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader3 = new System.Windows.Forms.ColumnHeader();
			this.panel2.SuspendLayout();
			this.SuspendLayout();
			// 
			// buttonClose
			// 
			this.buttonClose.AccessibleDescription = resources.GetString("buttonClose.AccessibleDescription");
			this.buttonClose.AccessibleName = resources.GetString("buttonClose.AccessibleName");
			this.buttonClose.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonClose.Anchor")));
			this.buttonClose.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonClose.BackgroundImage")));
			this.buttonClose.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonClose.Dock")));
			this.buttonClose.Enabled = ((bool)(resources.GetObject("buttonClose.Enabled")));
			this.buttonClose.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonClose.FlatStyle")));
			this.buttonClose.Font = ((System.Drawing.Font)(resources.GetObject("buttonClose.Font")));
			this.buttonClose.Image = ((System.Drawing.Image)(resources.GetObject("buttonClose.Image")));
			this.buttonClose.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonClose.ImageAlign")));
			this.buttonClose.ImageIndex = ((int)(resources.GetObject("buttonClose.ImageIndex")));
			this.buttonClose.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonClose.ImeMode")));
			this.buttonClose.Location = ((System.Drawing.Point)(resources.GetObject("buttonClose.Location")));
			this.buttonClose.Name = "buttonClose";
			this.buttonClose.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonClose.RightToLeft")));
			this.buttonClose.Size = ((System.Drawing.Size)(resources.GetObject("buttonClose.Size")));
			this.buttonClose.TabIndex = ((int)(resources.GetObject("buttonClose.TabIndex")));
			this.buttonClose.Text = resources.GetString("buttonClose.Text");
			this.buttonClose.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonClose.TextAlign")));
			this.buttonClose.Visible = ((bool)(resources.GetObject("buttonClose.Visible")));
			this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
			// 
			// panelConteniner
			// 
			this.panelConteniner.AccessibleDescription = resources.GetString("panelConteniner.AccessibleDescription");
			this.panelConteniner.AccessibleName = resources.GetString("panelConteniner.AccessibleName");
			this.panelConteniner.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("panelConteniner.Anchor")));
			this.panelConteniner.AutoScroll = ((bool)(resources.GetObject("panelConteniner.AutoScroll")));
			this.panelConteniner.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("panelConteniner.AutoScrollMargin")));
			this.panelConteniner.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("panelConteniner.AutoScrollMinSize")));
			this.panelConteniner.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panelConteniner.BackgroundImage")));
			this.panelConteniner.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("panelConteniner.Dock")));
			this.panelConteniner.Enabled = ((bool)(resources.GetObject("panelConteniner.Enabled")));
			this.panelConteniner.Font = ((System.Drawing.Font)(resources.GetObject("panelConteniner.Font")));
			this.panelConteniner.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("panelConteniner.ImeMode")));
			this.panelConteniner.Location = ((System.Drawing.Point)(resources.GetObject("panelConteniner.Location")));
			this.panelConteniner.Name = "panelConteniner";
			this.panelConteniner.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("panelConteniner.RightToLeft")));
			this.panelConteniner.Size = ((System.Drawing.Size)(resources.GetObject("panelConteniner.Size")));
			this.panelConteniner.TabIndex = ((int)(resources.GetObject("panelConteniner.TabIndex")));
			this.panelConteniner.Text = resources.GetString("panelConteniner.Text");
			this.panelConteniner.Visible = ((bool)(resources.GetObject("panelConteniner.Visible")));
			// 
			// panel2
			// 
			this.panel2.AccessibleDescription = resources.GetString("panel2.AccessibleDescription");
			this.panel2.AccessibleName = resources.GetString("panel2.AccessibleName");
			this.panel2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("panel2.Anchor")));
			this.panel2.AutoScroll = ((bool)(resources.GetObject("panel2.AutoScroll")));
			this.panel2.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("panel2.AutoScrollMargin")));
			this.panel2.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("panel2.AutoScrollMinSize")));
			this.panel2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panel2.BackgroundImage")));
			this.panel2.Controls.Add(this.listView1);
			this.panel2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("panel2.Dock")));
			this.panel2.Enabled = ((bool)(resources.GetObject("panel2.Enabled")));
			this.panel2.Font = ((System.Drawing.Font)(resources.GetObject("panel2.Font")));
			this.panel2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("panel2.ImeMode")));
			this.panel2.Location = ((System.Drawing.Point)(resources.GetObject("panel2.Location")));
			this.panel2.Name = "panel2";
			this.panel2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("panel2.RightToLeft")));
			this.panel2.Size = ((System.Drawing.Size)(resources.GetObject("panel2.Size")));
			this.panel2.TabIndex = ((int)(resources.GetObject("panel2.TabIndex")));
			this.panel2.Text = resources.GetString("panel2.Text");
			this.panel2.Visible = ((bool)(resources.GetObject("panel2.Visible")));
			// 
			// listView1
			// 
			this.listView1.AccessibleDescription = resources.GetString("listView1.AccessibleDescription");
			this.listView1.AccessibleName = resources.GetString("listView1.AccessibleName");
			this.listView1.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listView1.Alignment")));
			this.listView1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listView1.Anchor")));
			this.listView1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listView1.BackgroundImage")));
			this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																						this.columnHeader1,
																						this.columnHeader2,
																						this.columnHeader3});
			this.listView1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listView1.Dock")));
			this.listView1.Enabled = ((bool)(resources.GetObject("listView1.Enabled")));
			this.listView1.Font = ((System.Drawing.Font)(resources.GetObject("listView1.Font")));
			this.listView1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listView1.ImeMode")));
			this.listView1.LabelWrap = ((bool)(resources.GetObject("listView1.LabelWrap")));
			this.listView1.Location = ((System.Drawing.Point)(resources.GetObject("listView1.Location")));
			this.listView1.Name = "listView1";
			this.listView1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listView1.RightToLeft")));
			this.listView1.Size = ((System.Drawing.Size)(resources.GetObject("listView1.Size")));
			this.listView1.TabIndex = ((int)(resources.GetObject("listView1.TabIndex")));
			this.listView1.Text = resources.GetString("listView1.Text");
			this.listView1.View = System.Windows.Forms.View.Details;
			this.listView1.Visible = ((bool)(resources.GetObject("listView1.Visible")));
			// 
			// columnHeader1
			// 
			this.columnHeader1.Text = resources.GetString("columnHeader1.Text");
			this.columnHeader1.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader1.TextAlign")));
			this.columnHeader1.Width = ((int)(resources.GetObject("columnHeader1.Width")));
			// 
			// columnHeader2
			// 
			this.columnHeader2.Text = resources.GetString("columnHeader2.Text");
			this.columnHeader2.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader2.TextAlign")));
			this.columnHeader2.Width = ((int)(resources.GetObject("columnHeader2.Width")));
			// 
			// columnHeader3
			// 
			this.columnHeader3.Text = resources.GetString("columnHeader3.Text");
			this.columnHeader3.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader3.TextAlign")));
			this.columnHeader3.Width = ((int)(resources.GetObject("columnHeader3.Width")));
			// 
			// FrmShowflow
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.panel2);
			this.Controls.Add(this.panelConteniner);
			this.Controls.Add(this.buttonClose);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximizeBox = false;
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimizeBox = false;
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmShowflow";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.Load += new System.EventHandler(this.FrmShowflow_Load);
			this.panel2.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonClose_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void FrmShowflow_Load(object sender, System.EventArgs e)
		{
			Servicios s=new Servicios(this.user);
			XmlDocument docworkflow=s.getWorkflowXML(topicmap,topicid,occurrence);
			XmlNodeList workflows=docworkflow.GetElementsByTagName("workflow");
			if(workflows.Count>0)
			{
				foreach(XmlElement workflow in workflows)
				{
					XmlNodeList activities=workflow.GetElementsByTagName("activity");
					foreach(XmlElement eActivity in activities)
					{						
						if(eActivity.GetAttribute("type")=="Activity")
						{
							String description=eActivity.GetElementsByTagName("description")[0].InnerText;
							Activity activity=new Activity(eActivity.GetAttribute("name"),description);
							this.activities.Add(activity);
						}
						else if(eActivity.GetAttribute("type")=="EndActivity")
						{
							EndActivity activity=new EndActivity(eActivity.GetAttribute("name"),eActivity.GetAttribute("name"));
							this.activities.Add(activity);
						}
						else if(eActivity.GetAttribute("type")=="AuthorActivity")
						{
							AuthorActivity activity=new AuthorActivity(eActivity.GetAttribute("name"),eActivity.GetAttribute("name"));
							this.activities.Add(activity);
						}
					}
					XmlNodeList links=workflow.GetElementsByTagName("link");
					foreach(XmlElement elink in links)
					{
						Activity activityTo=null,activityFrom=null;
						String to=elink.GetAttribute("to");
						String from=elink.GetAttribute("from");
						String type=elink.GetAttribute("type");
						foreach(Activity activity in this.activities)
						{
							if(activity.ActivityName==to)
							{
								activityTo=activity;
							}
							if(activity.ActivityName==from)
							{
								activityFrom=activity;
							}
						}
						Link link=new Link(activityTo,activityFrom,type);
						activityTo.Links.Add(link);
						activityFrom.Links.Add(link);
					}
				}
			}
			else
			{
				this.Close();
			}
			PanelWorkflow p=new PanelWorkflow(this.activities,this.step,this.listView1);
			this.panelConteniner.Controls.Add(p);
			p.Dock=DockStyle.Fill;
			
			
		}
	}
}
