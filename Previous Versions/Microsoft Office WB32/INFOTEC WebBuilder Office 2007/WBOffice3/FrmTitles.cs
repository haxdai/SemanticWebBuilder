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
	/// <summary>Forma que muestra los titulos de una sección, para poder editar</summary>
	public class FrmTitles : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Button buttonAceptar;
		private System.Windows.Forms.Button buttonCancelar;
		/// <summary>Lista de titulos existentes en una sección</summary>
		/// <value>Lista de titulos existentes en una sección</value>
		public System.Windows.Forms.ListView listViewTitulos;
		private System.Windows.Forms.ColumnHeader columnHeader47;
		private System.Windows.Forms.ColumnHeader columnHeader48;
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		
		String idtopic,idmap;
		private System.Windows.Forms.ListView listViewContenidos2;
		private System.Windows.Forms.ColumnHeader columnHeader49;
		private System.Windows.Forms.TextBox txtSortName;
		CUserAdmin user;
		private System.Windows.Forms.Button button1;
		String lang;

		
		/// <summary>
		/// Crea la forma para mostrar los titulos de una sección
		/// </summary>
		/// <param name="idtopic">Id de la sección</param>
		/// <param name="idmap">Id del sitio</param>
		/// <param name="user">Usuario</param>
		/// <param name="lang">Lenguaje por defecto</param>
		public FrmTitles(String idtopic, String idmap,CUserAdmin user,String lang)
		{
			//
			// Necesario para admitir el Diseñador de Windows Forms
			//
			InitializeComponent();
			this.lang=lang;
			this.idtopic=idtopic;
			this.idmap=idmap;
			this.user=user;
			this.CargaTitulos(idtopic,idmap);
		}
		private void CargaTitulos(String idtopic, String idmap)
		{
			Servicios s=new Servicios(user);			
			XmlNodeList languages=s.getLanguage(idmap).GetElementsByTagName("Lenguaje");
			foreach(XmlElement lang in languages)
			{
				CCaracteristica c=new CCaracteristica(lang.GetElementsByTagName("name")[0].InnerText,lang.GetElementsByTagName("lang")[0].InnerText);
				string[] sitem=new string[2];
				sitem[0]="";
				sitem[1]=lang.GetElementsByTagName("name")[0].InnerText;
				ListViewItem item=new ListViewItem(sitem);
				item.Tag=c;
				this.listViewTitulos.Items.Add(item);

			}
			s=new Servicios(user);			
			s.getTopicTitles(listViewTitulos, idtopic, idmap,this.txtSortName,this.lang);			
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmTitles));
			this.buttonAceptar = new System.Windows.Forms.Button();
			this.buttonCancelar = new System.Windows.Forms.Button();
			this.listViewTitulos = new System.Windows.Forms.ListView();
			this.columnHeader47 = new System.Windows.Forms.ColumnHeader();
			this.columnHeader48 = new System.Windows.Forms.ColumnHeader();
			this.listViewContenidos2 = new System.Windows.Forms.ListView();
			this.columnHeader49 = new System.Windows.Forms.ColumnHeader();
			this.txtSortName = new System.Windows.Forms.TextBox();
			this.button1 = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// buttonAceptar
			// 
			this.buttonAceptar.AccessibleDescription = resources.GetString("buttonAceptar.AccessibleDescription");
			this.buttonAceptar.AccessibleName = resources.GetString("buttonAceptar.AccessibleName");
			this.buttonAceptar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonAceptar.Anchor")));
			this.buttonAceptar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonAceptar.BackgroundImage")));
			this.buttonAceptar.DialogResult = System.Windows.Forms.DialogResult.Cancel;
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
			// listViewTitulos
			// 
			this.listViewTitulos.AccessibleDescription = resources.GetString("listViewTitulos.AccessibleDescription");
			this.listViewTitulos.AccessibleName = resources.GetString("listViewTitulos.AccessibleName");
			this.listViewTitulos.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listViewTitulos.Alignment")));
			this.listViewTitulos.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listViewTitulos.Anchor")));
			this.listViewTitulos.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listViewTitulos.BackgroundImage")));
			this.listViewTitulos.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																							  this.columnHeader47,
																							  this.columnHeader48});
			this.listViewTitulos.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listViewTitulos.Dock")));
			this.listViewTitulos.Enabled = ((bool)(resources.GetObject("listViewTitulos.Enabled")));
			this.listViewTitulos.Font = ((System.Drawing.Font)(resources.GetObject("listViewTitulos.Font")));
			this.listViewTitulos.FullRowSelect = true;
			this.listViewTitulos.HideSelection = false;
			this.listViewTitulos.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listViewTitulos.ImeMode")));
			this.listViewTitulos.LabelWrap = ((bool)(resources.GetObject("listViewTitulos.LabelWrap")));
			this.listViewTitulos.Location = ((System.Drawing.Point)(resources.GetObject("listViewTitulos.Location")));
			this.listViewTitulos.Name = "listViewTitulos";
			this.listViewTitulos.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listViewTitulos.RightToLeft")));
			this.listViewTitulos.Size = ((System.Drawing.Size)(resources.GetObject("listViewTitulos.Size")));
			this.listViewTitulos.TabIndex = ((int)(resources.GetObject("listViewTitulos.TabIndex")));
			this.listViewTitulos.Text = resources.GetString("listViewTitulos.Text");
			this.listViewTitulos.View = System.Windows.Forms.View.Details;
			this.listViewTitulos.Visible = ((bool)(resources.GetObject("listViewTitulos.Visible")));
			this.listViewTitulos.Click += new System.EventHandler(this.listViewTitulos_Click);
			this.listViewTitulos.DoubleClick += new System.EventHandler(this.listViewTitulos_DoubleClick);
			// 
			// columnHeader47
			// 
			this.columnHeader47.Text = resources.GetString("columnHeader47.Text");
			this.columnHeader47.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader47.TextAlign")));
			this.columnHeader47.Width = ((int)(resources.GetObject("columnHeader47.Width")));
			// 
			// columnHeader48
			// 
			this.columnHeader48.Text = resources.GetString("columnHeader48.Text");
			this.columnHeader48.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader48.TextAlign")));
			this.columnHeader48.Width = ((int)(resources.GetObject("columnHeader48.Width")));
			// 
			// listViewContenidos2
			// 
			this.listViewContenidos2.AccessibleDescription = resources.GetString("listViewContenidos2.AccessibleDescription");
			this.listViewContenidos2.AccessibleName = resources.GetString("listViewContenidos2.AccessibleName");
			this.listViewContenidos2.Alignment = ((System.Windows.Forms.ListViewAlignment)(resources.GetObject("listViewContenidos2.Alignment")));
			this.listViewContenidos2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("listViewContenidos2.Anchor")));
			this.listViewContenidos2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("listViewContenidos2.BackgroundImage")));
			this.listViewContenidos2.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																								  this.columnHeader49});
			this.listViewContenidos2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("listViewContenidos2.Dock")));
			this.listViewContenidos2.Enabled = ((bool)(resources.GetObject("listViewContenidos2.Enabled")));
			this.listViewContenidos2.Font = ((System.Drawing.Font)(resources.GetObject("listViewContenidos2.Font")));
			this.listViewContenidos2.FullRowSelect = true;
			this.listViewContenidos2.HideSelection = false;
			this.listViewContenidos2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("listViewContenidos2.ImeMode")));
			this.listViewContenidos2.LabelWrap = ((bool)(resources.GetObject("listViewContenidos2.LabelWrap")));
			this.listViewContenidos2.Location = ((System.Drawing.Point)(resources.GetObject("listViewContenidos2.Location")));
			this.listViewContenidos2.Name = "listViewContenidos2";
			this.listViewContenidos2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("listViewContenidos2.RightToLeft")));
			this.listViewContenidos2.Size = ((System.Drawing.Size)(resources.GetObject("listViewContenidos2.Size")));
			this.listViewContenidos2.TabIndex = ((int)(resources.GetObject("listViewContenidos2.TabIndex")));
			this.listViewContenidos2.Text = resources.GetString("listViewContenidos2.Text");
			this.listViewContenidos2.View = System.Windows.Forms.View.Details;
			this.listViewContenidos2.Visible = ((bool)(resources.GetObject("listViewContenidos2.Visible")));
			// 
			// columnHeader49
			// 
			this.columnHeader49.Text = resources.GetString("columnHeader49.Text");
			this.columnHeader49.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("columnHeader49.TextAlign")));
			this.columnHeader49.Width = ((int)(resources.GetObject("columnHeader49.Width")));
			// 
			// txtSortName
			// 
			this.txtSortName.AccessibleDescription = resources.GetString("txtSortName.AccessibleDescription");
			this.txtSortName.AccessibleName = resources.GetString("txtSortName.AccessibleName");
			this.txtSortName.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtSortName.Anchor")));
			this.txtSortName.AutoSize = ((bool)(resources.GetObject("txtSortName.AutoSize")));
			this.txtSortName.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtSortName.BackgroundImage")));
			this.txtSortName.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtSortName.Dock")));
			this.txtSortName.Enabled = ((bool)(resources.GetObject("txtSortName.Enabled")));
			this.txtSortName.Font = ((System.Drawing.Font)(resources.GetObject("txtSortName.Font")));
			this.txtSortName.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtSortName.ImeMode")));
			this.txtSortName.Location = ((System.Drawing.Point)(resources.GetObject("txtSortName.Location")));
			this.txtSortName.MaxLength = ((int)(resources.GetObject("txtSortName.MaxLength")));
			this.txtSortName.Multiline = ((bool)(resources.GetObject("txtSortName.Multiline")));
			this.txtSortName.Name = "txtSortName";
			this.txtSortName.PasswordChar = ((char)(resources.GetObject("txtSortName.PasswordChar")));
			this.txtSortName.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtSortName.RightToLeft")));
			this.txtSortName.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtSortName.ScrollBars")));
			this.txtSortName.Size = ((System.Drawing.Size)(resources.GetObject("txtSortName.Size")));
			this.txtSortName.TabIndex = ((int)(resources.GetObject("txtSortName.TabIndex")));
			this.txtSortName.Text = resources.GetString("txtSortName.Text");
			this.txtSortName.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtSortName.TextAlign")));
			this.txtSortName.Visible = ((bool)(resources.GetObject("txtSortName.Visible")));
			this.txtSortName.WordWrap = ((bool)(resources.GetObject("txtSortName.WordWrap")));
			// 
			// button1
			// 
			this.button1.AccessibleDescription = resources.GetString("button1.AccessibleDescription");
			this.button1.AccessibleName = resources.GetString("button1.AccessibleName");
			this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("button1.Anchor")));
			this.button1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("button1.BackgroundImage")));
			this.button1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("button1.Dock")));
			this.button1.Enabled = ((bool)(resources.GetObject("button1.Enabled")));
			this.button1.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("button1.FlatStyle")));
			this.button1.Font = ((System.Drawing.Font)(resources.GetObject("button1.Font")));
			this.button1.Image = ((System.Drawing.Image)(resources.GetObject("button1.Image")));
			this.button1.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button1.ImageAlign")));
			this.button1.ImageIndex = ((int)(resources.GetObject("button1.ImageIndex")));
			this.button1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("button1.ImeMode")));
			this.button1.Location = ((System.Drawing.Point)(resources.GetObject("button1.Location")));
			this.button1.Name = "button1";
			this.button1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("button1.RightToLeft")));
			this.button1.Size = ((System.Drawing.Size)(resources.GetObject("button1.Size")));
			this.button1.TabIndex = ((int)(resources.GetObject("button1.TabIndex")));
			this.button1.Text = resources.GetString("button1.Text");
			this.button1.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("button1.TextAlign")));
			this.button1.Visible = ((bool)(resources.GetObject("button1.Visible")));
			this.button1.Click += new System.EventHandler(this.button1_Click);
			// 
			// FrmTitles
			// 
			this.AcceptButton = this.buttonAceptar;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.buttonAceptar;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.button1);
			this.Controls.Add(this.txtSortName);
			this.Controls.Add(this.listViewTitulos);
			this.Controls.Add(this.buttonAceptar);
			this.Controls.Add(this.buttonCancelar);
			this.Controls.Add(this.listViewContenidos2);
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
			this.Name = "FrmTitles";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonCancelar_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void buttonAceptar_Click(object sender, System.EventArgs e)
		{
			ParameterCollection parametros=new ParameterCollection(); 
			this.Cursor=Cursors.WaitCursor;
			Parameter ptopicid=new Parameter("topicid",this.idtopic);
			Parameter ptopicmap=new Parameter("topicmap",this.idmap);
			parametros.Add(ptopicid);
			parametros.Add(ptopicmap);
			foreach(System.Windows.Forms.ListViewItem item in this.listViewTitulos.Items)
			{
				CCaracteristica ctitulo=(CCaracteristica)item.Tag;
				Parameter pname=new Parameter("name","");
				pname.Attributes.Add(new Attribute("scope","IDM_WB"+ctitulo.Name)); 
				pname.Attributes.Add(new Attribute("value",ctitulo.Label)); 
				foreach(CValorCaracterisitca variant in ctitulo.Valores)
				{
					pname.Parametros.Add(new Parameter("variant",variant.Label)); 
				}
				parametros.Add(pname);
			}
			// agrega el sortname
			if(this.txtSortName.Text.Trim()!="")
			{
				Parameter pname=new Parameter("name","");
				pname.Attributes.Add(new Attribute("scope","CNF_WBSortName")); 
				pname.Attributes.Add(new Attribute("value",this.txtSortName.Text));
				parametros.Add(pname);

			}
			Servicios s=new Servicios(user);
			s.updateTopic(parametros,this.Text); 
			this.Close();
		}

		private void listViewTitulos_DoubleClick(object sender, System.EventArgs e)
		{
			button1_Click(null,null);
		}

		private void listViewTitulos_Click(object sender, System.EventArgs e)
		{
			if(this.listViewTitulos.SelectedItems.Count>0)
			{
				CCaracteristica ctitulo=(CCaracteristica)this.listViewTitulos.SelectedItems[0].Tag;
				this.listViewContenidos2.Items.Clear();
				foreach(CValorCaracterisitca variant in ctitulo.Valores)
				{
					string[] sitem=new string[1];
					sitem[0]=variant.Label;
					ListViewItem item=this.listViewContenidos2.Items.Add(new ListViewItem(sitem));
					item.Tag=variant;
				}
			}
		}

		private void button1_Click(object sender, System.EventArgs e)
		{
			foreach(ListViewItem item in this.listViewTitulos.SelectedItems)
			{
				FrmEditarTitulo frm=new FrmEditarTitulo(item);
				frm.ShowDialog(this);
			}
		}

		


		
	}
}
