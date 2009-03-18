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
using WBOffice3;

namespace WBOffice3
{
	/// <summary>Forma que permite mover un contenido</summary>
	public class FrmMoverContenido : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.Button buttonCancelar;
		private System.Windows.Forms.Button buttonSiguiente;
		private System.Windows.Forms.TreeView treeView1;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.Label label1;
		private System.ComponentModel.IContainer components;
		String idcont;
		String topicid,topicmap;
		private System.Windows.Forms.ImageList imageList1;		
		FrmProp frm;
		CUserAdmin user;		
		/// <summary>
		/// Id del Topicmap (sitio) donde se encuentra el contenido, no necesariamente es con
		/// el que se creo la forma, puede ser que indique que ya se movio
		/// </summary>
		/// <value>Id del Topicmap (sitio) donde se encuentra el contenido</value>
		public String TopicMap
		{
			get
			{
				return topicmap;
			}
			set
			{
				topicmap=value;
			}
		}
		/// <summary>
		/// Id de la sección donde se encuentra el contenido, no necesariamente es con el que
		/// se creo la forma, puede ser que indique que ya se movio
		/// </summary>
		/// <value>Id de la sección donde se encuentra el contenido</value>
		public String Topic
		{
			get
			{
				return topicid;
			}
			set
			{
				topicid=value;
			}
		}
		/// <summary>Id de contenido</summary>
		/// <value>Id de contenido</value>
		public String Content
		{
			get
			{
				return idcont;
			}
			set
			{
				idcont=value;
			}
		}
		String type;
		
		/// <summary>
		/// Crea una forma para permitir a travéz de esta mover un contenido
		/// </summary>
		/// <param name="topicid">Id de la sección donde se encuentra el contenido</param>
		/// <param name="topicmap">Id del sitio donde se encuentra el contenido</param>
		/// <param name="idcont">Id den contenido</param>
		/// <param name="frm">Forma de propiedades asociada</param>
		/// <param name="user">Usuario que va a mover el contenido</param>
		/// <param name="type">Tipo de moviento relizado</param>
		public FrmMoverContenido(String topicid,String topicmap,String idcont,FrmProp frm,CUserAdmin user,String type)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.type=type;
			this.user=user;
			this.idcont=idcont;
			this.topicid=topicid;
			this.topicmap=topicmap;
			this.frm=frm;
			Servicios s= new Servicios(user);
			TreeManager tree=new TreeManager(this.treeView1,this.buttonSiguiente,user);			
		
		}

		/// <summary>
		/// Clean up any resources being used.
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

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmMoverContenido));
			this.buttonCancelar = new System.Windows.Forms.Button();
			this.buttonSiguiente = new System.Windows.Forms.Button();
			this.treeView1 = new System.Windows.Forms.TreeView();
			this.imageList1 = new System.Windows.Forms.ImageList(this.components);
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.label1 = new System.Windows.Forms.Label();
			this.SuspendLayout();
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
			// buttonSiguiente
			// 
			this.buttonSiguiente.AccessibleDescription = resources.GetString("buttonSiguiente.AccessibleDescription");
			this.buttonSiguiente.AccessibleName = resources.GetString("buttonSiguiente.AccessibleName");
			this.buttonSiguiente.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonSiguiente.Anchor")));
			this.buttonSiguiente.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonSiguiente.BackgroundImage")));
			this.buttonSiguiente.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonSiguiente.Dock")));
			this.buttonSiguiente.Enabled = ((bool)(resources.GetObject("buttonSiguiente.Enabled")));
			this.buttonSiguiente.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonSiguiente.FlatStyle")));
			this.buttonSiguiente.Font = ((System.Drawing.Font)(resources.GetObject("buttonSiguiente.Font")));
			this.buttonSiguiente.Image = ((System.Drawing.Image)(resources.GetObject("buttonSiguiente.Image")));
			this.buttonSiguiente.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonSiguiente.ImageAlign")));
			this.buttonSiguiente.ImageIndex = ((int)(resources.GetObject("buttonSiguiente.ImageIndex")));
			this.buttonSiguiente.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonSiguiente.ImeMode")));
			this.buttonSiguiente.Location = ((System.Drawing.Point)(resources.GetObject("buttonSiguiente.Location")));
			this.buttonSiguiente.Name = "buttonSiguiente";
			this.buttonSiguiente.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonSiguiente.RightToLeft")));
			this.buttonSiguiente.Size = ((System.Drawing.Size)(resources.GetObject("buttonSiguiente.Size")));
			this.buttonSiguiente.TabIndex = ((int)(resources.GetObject("buttonSiguiente.TabIndex")));
			this.buttonSiguiente.Text = resources.GetString("buttonSiguiente.Text");
			this.buttonSiguiente.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonSiguiente.TextAlign")));
			this.buttonSiguiente.Visible = ((bool)(resources.GetObject("buttonSiguiente.Visible")));
			this.buttonSiguiente.Click += new System.EventHandler(this.buttonSiguiente_Click);
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
			this.imageList1.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList1.ImageStream")));
			this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
			// 
			// pictureBox1
			// 
			this.pictureBox1.AccessibleDescription = resources.GetString("pictureBox1.AccessibleDescription");
			this.pictureBox1.AccessibleName = resources.GetString("pictureBox1.AccessibleName");
			this.pictureBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("pictureBox1.Anchor")));
			this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
			this.pictureBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("pictureBox1.Dock")));
			this.pictureBox1.Enabled = ((bool)(resources.GetObject("pictureBox1.Enabled")));
			this.pictureBox1.Font = ((System.Drawing.Font)(resources.GetObject("pictureBox1.Font")));
			this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
			this.pictureBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("pictureBox1.ImeMode")));
			this.pictureBox1.Location = ((System.Drawing.Point)(resources.GetObject("pictureBox1.Location")));
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("pictureBox1.RightToLeft")));
			this.pictureBox1.Size = ((System.Drawing.Size)(resources.GetObject("pictureBox1.Size")));
			this.pictureBox1.SizeMode = ((System.Windows.Forms.PictureBoxSizeMode)(resources.GetObject("pictureBox1.SizeMode")));
			this.pictureBox1.TabIndex = ((int)(resources.GetObject("pictureBox1.TabIndex")));
			this.pictureBox1.TabStop = false;
			this.pictureBox1.Text = resources.GetString("pictureBox1.Text");
			this.pictureBox1.Visible = ((bool)(resources.GetObject("pictureBox1.Visible")));
			// 
			// label1
			// 
			this.label1.AccessibleDescription = resources.GetString("label1.AccessibleDescription");
			this.label1.AccessibleName = resources.GetString("label1.AccessibleName");
			this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label1.Anchor")));
			this.label1.AutoSize = ((bool)(resources.GetObject("label1.AutoSize")));
			this.label1.BackColor = System.Drawing.SystemColors.Info;
			this.label1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label1.Dock")));
			this.label1.Enabled = ((bool)(resources.GetObject("label1.Enabled")));
			this.label1.Font = ((System.Drawing.Font)(resources.GetObject("label1.Font")));
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
			// FrmMoverContenido
			// 
			this.AcceptButton = this.buttonSiguiente;
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
			this.Controls.Add(this.buttonCancelar);
			this.Controls.Add(this.buttonSiguiente);
			this.Controls.Add(this.treeView1);
			this.Controls.Add(this.pictureBox1);
			this.Controls.Add(this.label1);
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
			this.Name = "FrmMoverContenido";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonCancelar_Click(object sender, System.EventArgs e)
		{
			this.DialogResult=DialogResult.Cancel;
			this.Close();
		}

		private void buttonSiguiente_Click(object sender, System.EventArgs e)
		{
			this.Cursor=Cursors.WaitCursor; 
			if(this.treeView1.SelectedNode!=null)
			{
				WBNode wbnode=(WBNode)treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String idtopic=values[values.Length-1];
				String idtopicmap=values[values.Length-2];	

				bool permiso=user.GetPermiso(idtopicmap,this.type);
				if(!permiso)
				{
					this.Cursor=Cursors.Default;
					//MessageBox.Show(this,resources.GetString("FrmMoverContenido.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
					return;
				}
				

				

				
				ParameterCollection parametros=new ParameterCollection();
				
				
				parametros.Add(new Parameter("id",this.idcont));
				parametros.Add(new Parameter("topicidcurrent",this.topicid));
				parametros.Add(new Parameter("topicmapcurrent",this.topicmap));
				Parameter parameter = new Parameter("topicidnew",idtopic); 
				parametros.Add(parameter); 
				Parameter ptopicmap=new Parameter("topicmapnew",idtopicmap); 
				parametros.Add(ptopicmap); 								
				Servicios s= new Servicios(user);
				XmlDocument docresp=s.moveContenido(parametros);
				if(!s.IsError)
				{
					if(this.topicmap!=idtopicmap)
					{
						foreach(XmlElement ele in docresp.GetElementsByTagName("ContentMoved"))
						{
							this.Content=ele.InnerText;
							this.TopicMap=idtopicmap;
							this.Topic=idtopic;
							this.DialogResult=DialogResult.OK;
						}
					}
					this.frm.Recarga(idtopic,idtopicmap);
					MessageBox.Show(this,resources.GetString("FrmMoverContenido.msg2"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
				}
				this.Cursor=Cursors.Default;				
				this.Close();
				
			}
			this.Cursor=Cursors.Default;
		}
	}
}
