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
namespace WBOffice3
{
	/// <summary>Forma que muestra el listado de calendarizaciones asociadas a un contenido</summary>
	public class FrmListadoCalendarizacion : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.ColumnHeader columnHeader1;
		private System.Windows.Forms.Button buttonAceptar;
		private System.Windows.Forms.Button buttonCancelar;
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		String topicmap,topicid,idcont;
		private System.Windows.Forms.ListView listViewCalendarizacion;
		CUserAdmin user;
		System.Xml.XmlDocument doccconf;
		private System.Windows.Forms.MainMenu mainMenu1;
		private System.Windows.Forms.MenuItem menuItem1;
		private System.Windows.Forms.MenuItem menuItemAgregar;
		private System.Windows.Forms.MenuItem menuItemEditar;
		private System.Windows.Forms.MenuItem menuItemDelete;
		private System.Windows.Forms.MenuItem menuItem5;
		private System.Windows.Forms.MenuItem menuItemCerrar;
		private System.Windows.Forms.MenuItem menuItemGuardar;
		private System.Windows.Forms.MenuItem menuItem3;
		System.Xml.XmlDocument doccontenido;
		/// <summary>
		/// Constructor de listado de calendarizaciones
		/// </summary>
		/// <param name="topicmap">Sitio donde se encuentra el contenido</param>
		/// <param name="topicid">Sección donde se encuentra el contenido</param>
		/// <param name="idcont">Identificador de contenido</param>
		/// <param name="user">Usuario que accede</param>
		public FrmListadoCalendarizacion(String topicmap,String topicid,String idcont,CUserAdmin user)
		{
			//
			// Necesario para admitir el Diseñador de Windows Forms
			//
			InitializeComponent();

			this.topicmap=topicmap;
			this.topicid=topicid;
			this.idcont=idcont;
			this.user=user;

			Servicios s=new Servicios(user);
			doccontenido=s.getContentAtt(topicmap,topicid,this.idcont); 
			if(doccontenido.GetElementsByTagName("xmlconf").Count>0)
			{
				String xmlconf=doccontenido.GetElementsByTagName("xmlconf")[0].InnerText;
				//byte[] bxml=System.Text.Encoding.Default.GetBytes(xmlconf);
				//byte[] bres=System.Text.Encoding.Convert(System.Text.Encoding.UTF8,System.Text.Encoding.Default,bxml);*/
				//xmlconf	=System.Text.Encoding.Default.GetString(bres);

				if(xmlconf!=null)
				{
					if(!(xmlconf.Equals("") || xmlconf.Equals("null")))
					{
						System.Xml.XmlDocument docc=new System.Xml.XmlDocument();
						doccconf=docc;
						docc.LoadXml(xmlconf);
						int ical=1;
						foreach(XmlElement cal in docc.GetElementsByTagName("interval"))
						{
							String title;
							if(cal.GetElementsByTagName("title").Count>0)
							{
								title=cal.GetElementsByTagName("title")[0].InnerText;
							}
							else
							{
								title=ical.ToString();
							}

							string[] sitem=new string[1];
							sitem[0]=title;
							ical++;
							ListViewItem item=new ListViewItem(sitem);
							this.listViewCalendarizacion.Items.Add(item);
							item.Tag=cal;
						}
					}
				}
			}
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmListadoCalendarizacion));
			this.listViewCalendarizacion = new System.Windows.Forms.ListView();
			this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
			this.buttonAceptar = new System.Windows.Forms.Button();
			this.buttonCancelar = new System.Windows.Forms.Button();
			this.mainMenu1 = new System.Windows.Forms.MainMenu();
			this.menuItem1 = new System.Windows.Forms.MenuItem();
			this.menuItemAgregar = new System.Windows.Forms.MenuItem();
			this.menuItemEditar = new System.Windows.Forms.MenuItem();
			this.menuItemDelete = new System.Windows.Forms.MenuItem();
			this.menuItem5 = new System.Windows.Forms.MenuItem();
			this.menuItemGuardar = new System.Windows.Forms.MenuItem();
			this.menuItem3 = new System.Windows.Forms.MenuItem();
			this.menuItemCerrar = new System.Windows.Forms.MenuItem();
			this.SuspendLayout();
			// 
			// listViewCalendarizacion
			// 
			this.listViewCalendarizacion.AccessibleDescription = resources.GetString("listViewCalendarizacion.AccessibleDescription");
			this.listViewCalendarizacion.AccessibleName = resources.GetString("listViewCalendarizacion.AccessibleName");
			this.listViewCalendarizacion.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listViewCalendarizacion.Alignment")));
			this.listViewCalendarizacion.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listViewCalendarizacion.Anchor")));
			this.listViewCalendarizacion.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listViewCalendarizacion.BackgroundImage")));
			this.listViewCalendarizacion.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																									  this.columnHeader1});
			this.listViewCalendarizacion.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listViewCalendarizacion.Dock")));
			this.listViewCalendarizacion.Enabled = ((bool)(resources.GetObject("listViewCalendarizacion.Enabled")));
			this.listViewCalendarizacion.Font = ((System.Drawing.Font)(resources.GetObject("listViewCalendarizacion.Font")));
			this.listViewCalendarizacion.FullRowSelect = true;
			this.listViewCalendarizacion.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listViewCalendarizacion.ImeMode")));
			this.listViewCalendarizacion.LabelWrap = ((bool)(resources.GetObject("listViewCalendarizacion.LabelWrap")));
			this.listViewCalendarizacion.Location = ((System.Drawing.Point)(resources.GetObject("listViewCalendarizacion.Location")));
			this.listViewCalendarizacion.Name = "listViewCalendarizacion";
			this.listViewCalendarizacion.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listViewCalendarizacion.RightToLeft")));
			this.listViewCalendarizacion.Size = ((System.Drawing.Size)(resources.GetObject("listViewCalendarizacion.Size")));
			this.listViewCalendarizacion.TabIndex = ((int)(resources.GetObject("listViewCalendarizacion.TabIndex")));
			this.listViewCalendarizacion.Text = resources.GetString("listViewCalendarizacion.Text");
			this.listViewCalendarizacion.View = System.Windows.Forms.View.Details;
			this.listViewCalendarizacion.Visible = ((bool)(resources.GetObject("listViewCalendarizacion.Visible")));
			this.listViewCalendarizacion.DoubleClick += new System.EventHandler(this.listViewCalendarizacion_DoubleClick);
			this.listViewCalendarizacion.KeyUp += new System.Windows.Forms.KeyEventHandler(this.listViewCalendarizacion_KeyUp);
			// 
			// columnHeader1
			// 
			this.columnHeader1.Text = resources.GetString("columnHeader1.Text");
			this.columnHeader1.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader1.TextAlign")));
			this.columnHeader1.Width = ((int)(resources.GetObject("columnHeader1.Width")));
			// 
			// buttonAceptar
			// 
			this.buttonAceptar.AccessibleDescription = resources.GetString("buttonAceptar.AccessibleDescription");
			this.buttonAceptar.AccessibleName = resources.GetString("buttonAceptar.AccessibleName");
			this.buttonAceptar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonAceptar.Anchor")));
			this.buttonAceptar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonAceptar.BackgroundImage")));
			this.buttonAceptar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonAceptar.Dock")));
			this.buttonAceptar.Enabled = ((bool)(resources.GetObject("buttonAceptar.Enabled")));
			this.buttonAceptar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonAceptar.FlatStyle")));
			this.buttonAceptar.Font = ((System.Drawing.Font)(resources.GetObject("buttonAceptar.Font")));
			this.buttonAceptar.Image = ((System.Drawing.Image)(resources.GetObject("buttonAceptar.Image")));
			this.buttonAceptar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAceptar.ImageAlign")));
			this.buttonAceptar.ImageIndex = ((int)(resources.GetObject("buttonAceptar.ImageIndex")));
			this.buttonAceptar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonAceptar.ImeMode")));
			this.buttonAceptar.Location = ((System.Drawing.Point)(resources.GetObject("buttonAceptar.Location")));
			this.buttonAceptar.Name = "buttonAceptar";
			this.buttonAceptar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonAceptar.RightToLeft")));
			this.buttonAceptar.Size = ((System.Drawing.Size)(resources.GetObject("buttonAceptar.Size")));
			this.buttonAceptar.TabIndex = ((int)(resources.GetObject("buttonAceptar.TabIndex")));
			this.buttonAceptar.Text = resources.GetString("buttonAceptar.Text");
			this.buttonAceptar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAceptar.TextAlign")));
			this.buttonAceptar.Visible = ((bool)(resources.GetObject("buttonAceptar.Visible")));
			this.buttonAceptar.Click += new System.EventHandler(this.buttonAceptar_Click);
			// 
			// buttonCancelar
			// 
			this.buttonCancelar.AccessibleDescription = resources.GetString("buttonCancelar.AccessibleDescription");
			this.buttonCancelar.AccessibleName = resources.GetString("buttonCancelar.AccessibleName");
			this.buttonCancelar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonCancelar.Anchor")));
			this.buttonCancelar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonCancelar.BackgroundImage")));
			this.buttonCancelar.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.buttonCancelar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonCancelar.Dock")));
			this.buttonCancelar.Enabled = ((bool)(resources.GetObject("buttonCancelar.Enabled")));
			this.buttonCancelar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonCancelar.FlatStyle")));
			this.buttonCancelar.Font = ((System.Drawing.Font)(resources.GetObject("buttonCancelar.Font")));
			this.buttonCancelar.Image = ((System.Drawing.Image)(resources.GetObject("buttonCancelar.Image")));
			this.buttonCancelar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancelar.ImageAlign")));
			this.buttonCancelar.ImageIndex = ((int)(resources.GetObject("buttonCancelar.ImageIndex")));
			this.buttonCancelar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonCancelar.ImeMode")));
			this.buttonCancelar.Location = ((System.Drawing.Point)(resources.GetObject("buttonCancelar.Location")));
			this.buttonCancelar.Name = "buttonCancelar";
			this.buttonCancelar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonCancelar.RightToLeft")));
			this.buttonCancelar.Size = ((System.Drawing.Size)(resources.GetObject("buttonCancelar.Size")));
			this.buttonCancelar.TabIndex = ((int)(resources.GetObject("buttonCancelar.TabIndex")));
			this.buttonCancelar.Text = resources.GetString("buttonCancelar.Text");
			this.buttonCancelar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancelar.TextAlign")));
			this.buttonCancelar.Visible = ((bool)(resources.GetObject("buttonCancelar.Visible")));
			this.buttonCancelar.Click += new System.EventHandler(this.buttonCancelar_Click);
			// 
			// mainMenu1
			// 
			this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.menuItem1});
			this.mainMenu1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("mainMenu1.RightToLeft")));
			// 
			// menuItem1
			// 
			this.menuItem1.Enabled = ((bool)(resources.GetObject("menuItem1.Enabled")));
			this.menuItem1.Index = 0;
			this.menuItem1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.menuItemAgregar,
																					  this.menuItemEditar,
																					  this.menuItemDelete,
																					  this.menuItem5,
																					  this.menuItemGuardar,
																					  this.menuItem3,
																					  this.menuItemCerrar});
			this.menuItem1.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem1.Shortcut")));
			this.menuItem1.ShowShortcut = ((bool)(resources.GetObject("menuItem1.ShowShortcut")));
			this.menuItem1.Text = resources.GetString("menuItem1.Text");
			this.menuItem1.Visible = ((bool)(resources.GetObject("menuItem1.Visible")));
			// 
			// menuItemAgregar
			// 
			this.menuItemAgregar.Enabled = ((bool)(resources.GetObject("menuItemAgregar.Enabled")));
			this.menuItemAgregar.Index = 0;
			this.menuItemAgregar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemAgregar.Shortcut")));
			this.menuItemAgregar.ShowShortcut = ((bool)(resources.GetObject("menuItemAgregar.ShowShortcut")));
			this.menuItemAgregar.Text = resources.GetString("menuItemAgregar.Text");
			this.menuItemAgregar.Visible = ((bool)(resources.GetObject("menuItemAgregar.Visible")));
			this.menuItemAgregar.Click += new System.EventHandler(this.menuItemAgregar_Click);
			// 
			// menuItemEditar
			// 
			this.menuItemEditar.Enabled = ((bool)(resources.GetObject("menuItemEditar.Enabled")));
			this.menuItemEditar.Index = 1;
			this.menuItemEditar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemEditar.Shortcut")));
			this.menuItemEditar.ShowShortcut = ((bool)(resources.GetObject("menuItemEditar.ShowShortcut")));
			this.menuItemEditar.Text = resources.GetString("menuItemEditar.Text");
			this.menuItemEditar.Visible = ((bool)(resources.GetObject("menuItemEditar.Visible")));
			this.menuItemEditar.Click += new System.EventHandler(this.menuItemEditar_Click);
			// 
			// menuItemDelete
			// 
			this.menuItemDelete.Enabled = ((bool)(resources.GetObject("menuItemDelete.Enabled")));
			this.menuItemDelete.Index = 2;
			this.menuItemDelete.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemDelete.Shortcut")));
			this.menuItemDelete.ShowShortcut = ((bool)(resources.GetObject("menuItemDelete.ShowShortcut")));
			this.menuItemDelete.Text = resources.GetString("menuItemDelete.Text");
			this.menuItemDelete.Visible = ((bool)(resources.GetObject("menuItemDelete.Visible")));
			this.menuItemDelete.Click += new System.EventHandler(this.menuItemDelete_Click);
			// 
			// menuItem5
			// 
			this.menuItem5.Enabled = ((bool)(resources.GetObject("menuItem5.Enabled")));
			this.menuItem5.Index = 3;
			this.menuItem5.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem5.Shortcut")));
			this.menuItem5.ShowShortcut = ((bool)(resources.GetObject("menuItem5.ShowShortcut")));
			this.menuItem5.Text = resources.GetString("menuItem5.Text");
			this.menuItem5.Visible = ((bool)(resources.GetObject("menuItem5.Visible")));
			// 
			// menuItemGuardar
			// 
			this.menuItemGuardar.Enabled = ((bool)(resources.GetObject("menuItemGuardar.Enabled")));
			this.menuItemGuardar.Index = 4;
			this.menuItemGuardar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemGuardar.Shortcut")));
			this.menuItemGuardar.ShowShortcut = ((bool)(resources.GetObject("menuItemGuardar.ShowShortcut")));
			this.menuItemGuardar.Text = resources.GetString("menuItemGuardar.Text");
			this.menuItemGuardar.Visible = ((bool)(resources.GetObject("menuItemGuardar.Visible")));
			this.menuItemGuardar.Click += new System.EventHandler(this.menuItemGuardar_Click);
			// 
			// menuItem3
			// 
			this.menuItem3.Enabled = ((bool)(resources.GetObject("menuItem3.Enabled")));
			this.menuItem3.Index = 5;
			this.menuItem3.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem3.Shortcut")));
			this.menuItem3.ShowShortcut = ((bool)(resources.GetObject("menuItem3.ShowShortcut")));
			this.menuItem3.Text = resources.GetString("menuItem3.Text");
			this.menuItem3.Visible = ((bool)(resources.GetObject("menuItem3.Visible")));
			// 
			// menuItemCerrar
			// 
			this.menuItemCerrar.Enabled = ((bool)(resources.GetObject("menuItemCerrar.Enabled")));
			this.menuItemCerrar.Index = 6;
			this.menuItemCerrar.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemCerrar.Shortcut")));
			this.menuItemCerrar.ShowShortcut = ((bool)(resources.GetObject("menuItemCerrar.ShowShortcut")));
			this.menuItemCerrar.Text = resources.GetString("menuItemCerrar.Text");
			this.menuItemCerrar.Visible = ((bool)(resources.GetObject("menuItemCerrar.Visible")));
			this.menuItemCerrar.Click += new System.EventHandler(this.menuItemCerrar_Click);
			// 
			// FrmListadoCalendarizacion
			// 
			this.AcceptButton = this.buttonAceptar;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.buttonCancelar;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.ControlBox = false;
			this.Controls.Add(this.buttonAceptar);
			this.Controls.Add(this.buttonCancelar);
			this.Controls.Add(this.listViewCalendarizacion);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximizeBox = false;
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.Menu = this.mainMenu1;
			this.MinimizeBox = false;
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmListadoCalendarizacion";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.ResumeLayout(false);

		}
		#endregion

		private void menuItemCerrar_Click(object sender, System.EventArgs e)
		{
			this.buttonCancelar_Click(null,null);
		}

		private void buttonCancelar_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void menuItemAgregar_Click(object sender, System.EventArgs e)
		{
			XmlDocument doc=new XmlDocument();  
			doc.AppendChild(doc.CreateXmlDeclaration("1.0","UTF-8",null));			
			XmlElement resource=doc.CreateElement("Resource");
			XmlAttribute att=doc.CreateAttribute("new");
			att.Value="true";
			resource.Attributes.Append(att);
			doc.AppendChild(resource);
			string[] sitem={""};
			ListViewItem item=new ListViewItem(sitem);
			item.Tag=resource;
			this.listViewCalendarizacion.Items.Add(item);
			FrmPeriodicidad frm=new FrmPeriodicidad(item,this.user,this.listViewCalendarizacion);
			frm.ShowDialog(this);
			
		}

		private void buttonAceptar_Click(object sender, System.EventArgs e)
		{
			ParameterCollection parametros=new ParameterCollection();
			parametros.Add(new Parameter("title",doccontenido.GetElementsByTagName("title")[0].InnerText)); 
			parametros.Add(new Parameter("id",this.idcont)); 
			parametros.Add(new Parameter("description",doccontenido.GetElementsByTagName("descrition")[0].InnerText)); 
			XmlDocument doc=new XmlDocument();  
			doc.AppendChild(doc.CreateXmlDeclaration("1.0","UTF-8",null));
			System.Xml.XmlElement resource=doc.CreateElement("Resource");	
			doc.AppendChild(resource);
			if(this.doccconf!=null)
			{
				System.Xml.XmlNodeList reglas=this.doccconf.GetElementsByTagName("rule"); 
				foreach(System.Xml.XmlElement regla in reglas)
				{
					parametros.Add(new Parameter("rule",regla.InnerText));
				}
			}
			if(this.listViewCalendarizacion.Items.Count>0)
			{
				XmlElement sch=doc.CreateElement("schedule");
				resource.AppendChild(sch);
				foreach(ListViewItem item in this.listViewCalendarizacion.Items)
				{
					XmlElement cal=(XmlElement)item.Tag;
					XmlDocumentFragment f=doc.CreateDocumentFragment();
					f.InnerXml=cal.OuterXml;
					sch.AppendChild(f);
				}
			}
			for(int i=0;i<parametros.Count;i++)
			{
					
				IParameter p=parametros[i];
				if(p.Name.Equals("rule"))
				{										
					XmlElement elem=doc.CreateElement("rule");
					elem.InnerText=p.Value;
					resource.AppendChild(elem);
				}																	
				if(p.Name.Equals("apariciones"))
				{					
					if(p.Value!=null)
					{
						XmlElement elem=doc.CreateElement("views");
						elem.InnerText=p.Value;
						resource.AppendChild(elem);
					}
				}

			}
			parametros.Add(new Parameter("topicmap",this.topicmap));
			parametros.Add(new Parameter("subtype","0"));
			parametros.Add(new Parameter("priority","3"));
			parametros.Add(new Parameter("camp",""));
			byte[] bxml=System.Text.Encoding.Default.GetBytes(doc.InnerXml);
			byte[] bres=System.Text.Encoding.Convert(System.Text.Encoding.Default,System.Text.Encoding.UTF8,bxml);
			
			parametros.Add(new Parameter("xmlconf",System.Text.Encoding.Default.GetString(bres)));
			Servicios s=new Servicios(user);
			s.updatePeriodicidad(parametros);
			if(!s.IsError)
			{
				MessageBox.Show(this,resources.GetString("FrmPeriodicidad.msg18"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
			}
			this.Cursor=Cursors.Default; 
			this.Close();
		}

		private void menuItemEditar_Click(object sender, System.EventArgs e)
		{
			foreach(ListViewItem item in this.listViewCalendarizacion.SelectedItems)
			{
				FrmPeriodicidad frm=new FrmPeriodicidad(item,this.user,this.listViewCalendarizacion);
				frm.ShowDialog(this);
			}
		}

		private void menuItemDelete_Click(object sender, System.EventArgs e)
		{
			ArrayList items=new ArrayList();
			foreach(ListViewItem item in this.listViewCalendarizacion.SelectedItems)
			{
				items.Add(item);
			}
			foreach(ListViewItem item in items)
			{
				item.Remove();
			}
		}

		private void listViewCalendarizacion_KeyUp(object sender, System.Windows.Forms.KeyEventArgs e)
		{
			if(e.KeyCode == Keys.Delete)
			{
				menuItemDelete_Click(null,null);
			}
		}

		private void listViewCalendarizacion_DoubleClick(object sender, System.EventArgs e)
		{
			menuItemEditar_Click(null,null);
		}

		private void menuItemGuardar_Click(object sender, System.EventArgs e)
		{
			buttonAceptar_Click(null,null);
		}
	}
}
