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
	/// Forma que muestra las propiedades de un contenido, información del contenido,
	/// sección a la que pertenece, muestra la opción de mover un contenido,
	/// calendarización.
	/// </summary>
	public class FrmProp : System.Windows.Forms.Form
	{

		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		//bool activatedflow=false;
		/// <summary>Id del flujo donde se encuentra el contenido</summary>
		/// <value>Id del flujo donde se encuentra el contenido</value>
		public System.Xml.XmlElement flowtopic=null;
		/// <summary>Definición del Flujo donde se encuentra el contenido</summary>
		/// <value>Definición del Flujo donde se encuentra el contenido</value>
		public System.Xml.XmlDocument detalleflow=null;
		private String topicmap="";
		private String topicid="";
		private System.Windows.Forms.Button buttonCancelar;
		private System.Windows.Forms.Button buttonAceptar;
		private System.Windows.Forms.Button buttonPeriodicidad;
		private String idcont="";
		/// <summary>
		/// Regresa el Boton de publicar para activarlo o desactivarlo cuando se
		/// requiera
		/// </summary>
		/// <value>
		/// Regresa el Boton de publicar para activarlo o desactivarlo cuando se
		/// requiera
		/// </value>
		public System.Windows.Forms.Button buttonPublicar;			
		/// <summary>
		/// Paso inicial
		/// </summary>
		public String step="0";
		private System.Windows.Forms.TabControl tabControl1;
		private System.Windows.Forms.TabPage tabPage1;
		private System.Windows.Forms.TabPage tabPage2;
		private System.Windows.Forms.Label lblIdentificador;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label lblVersion;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.RadioButton radioNo;
		private System.Windows.Forms.RadioButton radioSi;
		private System.Windows.Forms.Label lblFecMod;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.TextBox txtDesc;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox txttitulo;
		private System.Windows.Forms.Label lbltitulo;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label6;
		private System.Windows.Forms.Label label7;
		private System.Windows.Forms.TextBox txttopicid;
		private System.Windows.Forms.TextBox txttitletopic;
		private System.Windows.Forms.Button buttonMover;
		private System.Windows.Forms.TextBox txttitlesitio;
		private System.Windows.Forms.Label label8;
		private System.Windows.Forms.Label lblIdentificadorCont;
		private System.Windows.Forms.GroupBox groupBox2;
		private System.Windows.Forms.Label label9;
		private System.Windows.Forms.TextBox txtRuta;
		private System.Windows.Forms.Button buttonPreview;
		private System.Windows.Forms.RadioButton radioButtonSecccionSi;
		private System.Windows.Forms.RadioButton radioButtonSeccionNo;
		private System.Windows.Forms.Label labelStatus;
		private System.Windows.Forms.Label labelPaso;
		private System.Windows.Forms.Button buttonTitle;
		/// <summary>
		/// Estado inicial
		/// </summary>
		public String status="0";
		CUserAdmin user;
		private System.Windows.Forms.HelpProvider helpProvider1;
		private System.Windows.Forms.Label lblStep;
		private System.Windows.Forms.Label lblStatus;
		private System.Windows.Forms.TabPage tabPage3;
		private System.Windows.Forms.CheckBox checkBox1;
		private System.Windows.Forms.ComboBox comboBoxRole;
		private System.Windows.Forms.GroupBox groupBoxRoles;
		String lang;
		private System.Windows.Forms.TabPage tabPage4;
		private System.Windows.Forms.GroupBox groupBox3;
		/// <summary>
		/// Selección de modo Web
		/// </summary>
		public System.Windows.Forms.RadioButton radioButtonWeb;
		/// <summary>
		/// Selección de modo embebido
		/// </summary>
		public System.Windows.Forms.RadioButton radioButtonOffice;
		String type;
		#region Propiedades
		/// <summary>Id del sitio donde se encuentra el contenido</summary>
		/// <value>Id del sitio donde se encuentra el contenido</value>
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
		/// <summary>Id de la sección donde se encuentra el contenido</summary>
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
		/// <summary>Id del contenido</summary>
		/// <value>Id del contenido</value>
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
		#endregion
		/// <summary>
		/// Constructor de forma de propiedades
		/// </summary>
		/// <param name="topicmap">Sitio del contenido</param>
		/// <param name="topicid">Sección del contenido</param>
		/// <param name="idcont">Identificador de contenido</param>
		/// <param name="user">Usurio</param>
		/// <param name="type">Tipo de acceso</param>
		public FrmProp(String topicmap,String topicid,String idcont,CUserAdmin user,String type)
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
			this.topicmap=topicmap;
			this.topicid=topicid;
			this.idcont=idcont;
			
			this.lblStatus.Visible=false;
			this.lblStep.Visible=false;
			this.labelStatus.Visible=false;
			this.labelPaso.Visible=false;

			this.lblIdentificador.Text=this.idcont; 
			this.txtRuta.Text=user.Uri+ "wb2/"+topicmap  +"/"+topicid;
			Servicios s=new Servicios(user);			
			s=new Servicios(user);			
			System.Xml.XmlElement docmap=(XmlElement)s.getTopicMapAtt(topicmap);
			if(docmap.GetElementsByTagName("language").Count>0)
			{
				lang=docmap.GetElementsByTagName("language")[0].InnerText;
			}
			System.Xml.XmlDocument doctopic=s.getTopicInfo(topicid,topicmap);
			if(doctopic.GetElementsByTagName("active").Count>0)
			{
				if(doctopic.GetElementsByTagName("active")[0].InnerText=="1")
				{
					this.radioButtonSecccionSi.Checked=true;  
					this.radioButtonSeccionNo.Checked=false;  
				}
				else
				{
					this.radioButtonSeccionNo.Checked=true;  
					this.radioButtonSecccionSi.Checked=false;  
				}
			}
			

			
			Recarga(this.topicid,this.topicmap);
			this.lblIdentificadorCont.Text=this.idcont; 
			s=new Servicios(user);
			System.Xml.XmlDocument doc=s.getContentAtt(this.topicmap,this.topicid, this.idcont); 
			String sActive=doc.GetElementsByTagName("active")[0].InnerText;
			if(sActive.Equals("1"))
			{				
				this.radioSi.Checked=true;
				this.radioNo.Checked=false;  
			}
			else
			{				
				this.radioSi.Checked=false;  
				this.radioNo.Checked=true;  
			}
			if(doc.GetElementsByTagName("title").Count>0)
			{
				this.txttitulo.Text= doc.GetElementsByTagName("title")[0].InnerText;
			}
			if(doc.GetElementsByTagName("descrition").Count>0)
			{
				this.txtDesc.Text= doc.GetElementsByTagName("descrition")[0].InnerText;
			}
			if(doc.GetElementsByTagName("actualversion").Count>0)
			{
				this.lblVersion.Text= doc.GetElementsByTagName("actualversion")[0].InnerText;
			}
			if(doc.GetElementsByTagName("lastupdate").Count>0)
			{
				System.DateTime fecmod=System.DateTime.Parse(doc.GetElementsByTagName("lastupdate")[0].InnerText);
				this.lblFecMod.Text= fecmod.ToLongDateString()+" "+fecmod.ToShortTimeString();  
			}
			Servicios s2=new Servicios(user); 	
			
			String status=doc.GetElementsByTagName("status")[0].InnerText;						
			if(s2.needAutorization(this.topicmap,this.topicid,this.idcont) && (status=="0" || status=="-1"))
			{
				this.buttonPublicar.Visible=true;
			}
			else
			{
				this.buttonPublicar.Visible=false;
			}
			if(status=="-1") // rechazado
			{
				this.labelStatus.Text=resources.GetString("t4"); 
				this.labelStatus.Visible=true;
				this.lblStatus.Visible=true;
			}
			
			if(doc.GetElementsByTagName("flowname").Count>0 && doc.GetElementsByTagName("activityName").Count>0)
			{				
				this.labelPaso.Text=doc.GetElementsByTagName("activityName")[0].InnerText;							
				this.lblStatus.Visible=true;
				this.lblStep.Visible=true;
				this.labelStatus.Visible=true;
				this.labelPaso.Visible=true;

				
				if(status=="0") // sin envíar
				{
					this.labelStatus.Text=resources.GetString("t1"); 
				}
				else if(status=="1") // en revisión
				{
					this.labelStatus.Text=resources.GetString("t3"); 
				}
				else if(status=="2") // terminado
				{
					this.labelStatus.Text=resources.GetString("t5"); 
				}
				else if(status=="3") // no autorizado
				{
					this.labelStatus.Text=resources.GetString("t4"); 
				}
			}
			Servicios smode=new Servicios(user);

			if(smode.isModeWeb(this.idcont,this.topicmap,this.topicid))
			{
				this.radioButtonWeb.Checked=true;
			}
			else
			{
				this.radioButtonOffice.Checked=true;
			}
			Servicios sroles=new Servicios(user);
			this.comboBoxRole.Items.Clear();
			XmlDocument docroles=sroles.getRoles(this.topicmap);
			foreach(XmlElement eRole in  docroles.GetElementsByTagName("role"))
			{
				Role role=new Role();
				role.name=eRole.GetAttribute("name");
				role.id=eRole.GetAttribute("id");
				this.comboBoxRole.Items.Add(role);
			}
			if(this.comboBoxRole.Items.Count>0)
			{
				this.comboBoxRole.SelectedIndex=0;
			}
			sroles=new Servicios(user);
			
			if(doc.GetElementsByTagName("xml").Count>0)
			{
				String xml=doc.GetElementsByTagName("xml").Item(0).InnerText;
				XmlDocument doc_xml=new XmlDocument();
				doc_xml.LoadXml(xml);
				if(doc_xml.GetElementsByTagName("isEditAble").Count>0 && doc_xml.GetElementsByTagName("isEditAble")[0].InnerText=="1")
				{
					this.checkBox1.Checked=true;
				}
				if(doc_xml.GetElementsByTagName("EditRole").Count>0)
				{
					String id=doc_xml.GetElementsByTagName("EditRole").Item(0).InnerText;
					foreach(Role role in this.comboBoxRole.Items)
					{
						if(role.id==id)
						{
							this.comboBoxRole.SelectedItem=role;
							break;
						}
					}
				}
			}
									  
			
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmProp));
			this.buttonCancelar = new System.Windows.Forms.Button();
			this.buttonAceptar = new System.Windows.Forms.Button();
			this.buttonPeriodicidad = new System.Windows.Forms.Button();
			this.buttonPublicar = new System.Windows.Forms.Button();
			this.tabControl1 = new System.Windows.Forms.TabControl();
			this.tabPage1 = new System.Windows.Forms.TabPage();
			this.labelPaso = new System.Windows.Forms.Label();
			this.lblStep = new System.Windows.Forms.Label();
			this.labelStatus = new System.Windows.Forms.Label();
			this.lblStatus = new System.Windows.Forms.Label();
			this.lblIdentificadorCont = new System.Windows.Forms.Label();
			this.label8 = new System.Windows.Forms.Label();
			this.lblIdentificador = new System.Windows.Forms.Label();
			this.label4 = new System.Windows.Forms.Label();
			this.lblVersion = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.radioNo = new System.Windows.Forms.RadioButton();
			this.radioSi = new System.Windows.Forms.RadioButton();
			this.lblFecMod = new System.Windows.Forms.Label();
			this.label5 = new System.Windows.Forms.Label();
			this.txtDesc = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.txttitulo = new System.Windows.Forms.TextBox();
			this.lbltitulo = new System.Windows.Forms.Label();
			this.tabPage2 = new System.Windows.Forms.TabPage();
			this.buttonTitle = new System.Windows.Forms.Button();
			this.buttonPreview = new System.Windows.Forms.Button();
			this.txtRuta = new System.Windows.Forms.TextBox();
			this.label9 = new System.Windows.Forms.Label();
			this.groupBox2 = new System.Windows.Forms.GroupBox();
			this.radioButtonSeccionNo = new System.Windows.Forms.RadioButton();
			this.radioButtonSecccionSi = new System.Windows.Forms.RadioButton();
			this.buttonMover = new System.Windows.Forms.Button();
			this.txttitlesitio = new System.Windows.Forms.TextBox();
			this.label7 = new System.Windows.Forms.Label();
			this.label6 = new System.Windows.Forms.Label();
			this.txttitletopic = new System.Windows.Forms.TextBox();
			this.txttopicid = new System.Windows.Forms.TextBox();
			this.label2 = new System.Windows.Forms.Label();
			this.tabPage3 = new System.Windows.Forms.TabPage();
			this.groupBoxRoles = new System.Windows.Forms.GroupBox();
			this.comboBoxRole = new System.Windows.Forms.ComboBox();
			this.checkBox1 = new System.Windows.Forms.CheckBox();
			this.helpProvider1 = new System.Windows.Forms.HelpProvider();
			this.tabPage4 = new System.Windows.Forms.TabPage();
			this.groupBox3 = new System.Windows.Forms.GroupBox();
			this.radioButtonWeb = new System.Windows.Forms.RadioButton();
			this.radioButtonOffice = new System.Windows.Forms.RadioButton();
			this.tabControl1.SuspendLayout();
			this.tabPage1.SuspendLayout();
			this.groupBox1.SuspendLayout();
			this.tabPage2.SuspendLayout();
			this.groupBox2.SuspendLayout();
			this.tabPage3.SuspendLayout();
			this.groupBoxRoles.SuspendLayout();
			this.tabPage4.SuspendLayout();
			this.groupBox3.SuspendLayout();
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
			this.helpProvider1.SetHelpKeyword(this.buttonCancelar, resources.GetString("buttonCancelar.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.buttonCancelar, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("buttonCancelar.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.buttonCancelar, resources.GetString("buttonCancelar.HelpString"));
			this.buttonCancelar.Image = ((System.Drawing.Image)(resources.GetObject("buttonCancelar.Image")));
			this.buttonCancelar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancelar.ImageAlign")));
			this.buttonCancelar.ImageIndex = ((int)(resources.GetObject("buttonCancelar.ImageIndex")));
			this.buttonCancelar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonCancelar.ImeMode")));
			this.buttonCancelar.Location = ((System.Drawing.Point)(resources.GetObject("buttonCancelar.Location")));
			this.buttonCancelar.Name = "buttonCancelar";
			this.buttonCancelar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonCancelar.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.buttonCancelar, ((bool)(resources.GetObject("buttonCancelar.ShowHelp"))));
			this.buttonCancelar.Size = ((System.Drawing.Size)(resources.GetObject("buttonCancelar.Size")));
			this.buttonCancelar.TabIndex = ((int)(resources.GetObject("buttonCancelar.TabIndex")));
			this.buttonCancelar.Text = resources.GetString("buttonCancelar.Text");
			this.buttonCancelar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonCancelar.TextAlign")));
			this.buttonCancelar.Visible = ((bool)(resources.GetObject("buttonCancelar.Visible")));
			this.buttonCancelar.Click += new System.EventHandler(this.buttonCancelar_Click);
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
			this.helpProvider1.SetHelpKeyword(this.buttonAceptar, resources.GetString("buttonAceptar.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.buttonAceptar, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("buttonAceptar.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.buttonAceptar, resources.GetString("buttonAceptar.HelpString"));
			this.buttonAceptar.Image = ((System.Drawing.Image)(resources.GetObject("buttonAceptar.Image")));
			this.buttonAceptar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAceptar.ImageAlign")));
			this.buttonAceptar.ImageIndex = ((int)(resources.GetObject("buttonAceptar.ImageIndex")));
			this.buttonAceptar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonAceptar.ImeMode")));
			this.buttonAceptar.Location = ((System.Drawing.Point)(resources.GetObject("buttonAceptar.Location")));
			this.buttonAceptar.Name = "buttonAceptar";
			this.buttonAceptar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonAceptar.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.buttonAceptar, ((bool)(resources.GetObject("buttonAceptar.ShowHelp"))));
			this.buttonAceptar.Size = ((System.Drawing.Size)(resources.GetObject("buttonAceptar.Size")));
			this.buttonAceptar.TabIndex = ((int)(resources.GetObject("buttonAceptar.TabIndex")));
			this.buttonAceptar.Text = resources.GetString("buttonAceptar.Text");
			this.buttonAceptar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonAceptar.TextAlign")));
			this.buttonAceptar.Visible = ((bool)(resources.GetObject("buttonAceptar.Visible")));
			this.buttonAceptar.Click += new System.EventHandler(this.buttonAceptar_Click);
			// 
			// buttonPeriodicidad
			// 
			this.buttonPeriodicidad.AccessibleDescription = resources.GetString("buttonPeriodicidad.AccessibleDescription");
			this.buttonPeriodicidad.AccessibleName = resources.GetString("buttonPeriodicidad.AccessibleName");
			this.buttonPeriodicidad.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonPeriodicidad.Anchor")));
			this.buttonPeriodicidad.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonPeriodicidad.BackgroundImage")));
			this.buttonPeriodicidad.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonPeriodicidad.Dock")));
			this.buttonPeriodicidad.Enabled = ((bool)(resources.GetObject("buttonPeriodicidad.Enabled")));
			this.buttonPeriodicidad.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonPeriodicidad.FlatStyle")));
			this.buttonPeriodicidad.Font = ((System.Drawing.Font)(resources.GetObject("buttonPeriodicidad.Font")));
			this.helpProvider1.SetHelpKeyword(this.buttonPeriodicidad, resources.GetString("buttonPeriodicidad.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.buttonPeriodicidad, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("buttonPeriodicidad.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.buttonPeriodicidad, resources.GetString("buttonPeriodicidad.HelpString"));
			this.buttonPeriodicidad.Image = ((System.Drawing.Image)(resources.GetObject("buttonPeriodicidad.Image")));
			this.buttonPeriodicidad.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonPeriodicidad.ImageAlign")));
			this.buttonPeriodicidad.ImageIndex = ((int)(resources.GetObject("buttonPeriodicidad.ImageIndex")));
			this.buttonPeriodicidad.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonPeriodicidad.ImeMode")));
			this.buttonPeriodicidad.Location = ((System.Drawing.Point)(resources.GetObject("buttonPeriodicidad.Location")));
			this.buttonPeriodicidad.Name = "buttonPeriodicidad";
			this.buttonPeriodicidad.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonPeriodicidad.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.buttonPeriodicidad, ((bool)(resources.GetObject("buttonPeriodicidad.ShowHelp"))));
			this.buttonPeriodicidad.Size = ((System.Drawing.Size)(resources.GetObject("buttonPeriodicidad.Size")));
			this.buttonPeriodicidad.TabIndex = ((int)(resources.GetObject("buttonPeriodicidad.TabIndex")));
			this.buttonPeriodicidad.Text = resources.GetString("buttonPeriodicidad.Text");
			this.buttonPeriodicidad.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonPeriodicidad.TextAlign")));
			this.buttonPeriodicidad.Visible = ((bool)(resources.GetObject("buttonPeriodicidad.Visible")));
			this.buttonPeriodicidad.Click += new System.EventHandler(this.buttonPeriodicidad_Click);
			// 
			// buttonPublicar
			// 
			this.buttonPublicar.AccessibleDescription = resources.GetString("buttonPublicar.AccessibleDescription");
			this.buttonPublicar.AccessibleName = resources.GetString("buttonPublicar.AccessibleName");
			this.buttonPublicar.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonPublicar.Anchor")));
			this.buttonPublicar.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonPublicar.BackgroundImage")));
			this.buttonPublicar.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonPublicar.Dock")));
			this.buttonPublicar.Enabled = ((bool)(resources.GetObject("buttonPublicar.Enabled")));
			this.buttonPublicar.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonPublicar.FlatStyle")));
			this.buttonPublicar.Font = ((System.Drawing.Font)(resources.GetObject("buttonPublicar.Font")));
			this.helpProvider1.SetHelpKeyword(this.buttonPublicar, resources.GetString("buttonPublicar.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.buttonPublicar, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("buttonPublicar.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.buttonPublicar, resources.GetString("buttonPublicar.HelpString"));
			this.buttonPublicar.Image = ((System.Drawing.Image)(resources.GetObject("buttonPublicar.Image")));
			this.buttonPublicar.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonPublicar.ImageAlign")));
			this.buttonPublicar.ImageIndex = ((int)(resources.GetObject("buttonPublicar.ImageIndex")));
			this.buttonPublicar.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonPublicar.ImeMode")));
			this.buttonPublicar.Location = ((System.Drawing.Point)(resources.GetObject("buttonPublicar.Location")));
			this.buttonPublicar.Name = "buttonPublicar";
			this.buttonPublicar.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonPublicar.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.buttonPublicar, ((bool)(resources.GetObject("buttonPublicar.ShowHelp"))));
			this.buttonPublicar.Size = ((System.Drawing.Size)(resources.GetObject("buttonPublicar.Size")));
			this.buttonPublicar.TabIndex = ((int)(resources.GetObject("buttonPublicar.TabIndex")));
			this.buttonPublicar.Text = resources.GetString("buttonPublicar.Text");
			this.buttonPublicar.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonPublicar.TextAlign")));
			this.buttonPublicar.Visible = ((bool)(resources.GetObject("buttonPublicar.Visible")));
			this.buttonPublicar.Click += new System.EventHandler(this.buttonPublicar_Click);
			// 
			// tabControl1
			// 
			this.tabControl1.AccessibleDescription = resources.GetString("tabControl1.AccessibleDescription");
			this.tabControl1.AccessibleName = resources.GetString("tabControl1.AccessibleName");
			this.tabControl1.Alignment = ((System.Windows.Forms.TabAlignment)(resources.GetObject("tabControl1.Alignment")));
			this.tabControl1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabControl1.Anchor")));
			this.tabControl1.Appearance = ((System.Windows.Forms.TabAppearance)(resources.GetObject("tabControl1.Appearance")));
			this.tabControl1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabControl1.BackgroundImage")));
			this.tabControl1.Controls.Add(this.tabPage1);
			this.tabControl1.Controls.Add(this.tabPage2);
			this.tabControl1.Controls.Add(this.tabPage3);
			this.tabControl1.Controls.Add(this.tabPage4);
			this.tabControl1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabControl1.Dock")));
			this.tabControl1.Enabled = ((bool)(resources.GetObject("tabControl1.Enabled")));
			this.tabControl1.Font = ((System.Drawing.Font)(resources.GetObject("tabControl1.Font")));
			this.helpProvider1.SetHelpKeyword(this.tabControl1, resources.GetString("tabControl1.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.tabControl1, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("tabControl1.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.tabControl1, resources.GetString("tabControl1.HelpString"));
			this.tabControl1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabControl1.ImeMode")));
			this.tabControl1.ItemSize = ((System.Drawing.Size)(resources.GetObject("tabControl1.ItemSize")));
			this.tabControl1.Location = ((System.Drawing.Point)(resources.GetObject("tabControl1.Location")));
			this.tabControl1.Name = "tabControl1";
			this.tabControl1.Padding = ((System.Drawing.Point)(resources.GetObject("tabControl1.Padding")));
			this.tabControl1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabControl1.RightToLeft")));
			this.tabControl1.SelectedIndex = 0;
			this.helpProvider1.SetShowHelp(this.tabControl1, ((bool)(resources.GetObject("tabControl1.ShowHelp"))));
			this.tabControl1.ShowToolTips = ((bool)(resources.GetObject("tabControl1.ShowToolTips")));
			this.tabControl1.Size = ((System.Drawing.Size)(resources.GetObject("tabControl1.Size")));
			this.tabControl1.TabIndex = ((int)(resources.GetObject("tabControl1.TabIndex")));
			this.tabControl1.Text = resources.GetString("tabControl1.Text");
			this.tabControl1.Visible = ((bool)(resources.GetObject("tabControl1.Visible")));
			// 
			// tabPage1
			// 
			this.tabPage1.AccessibleDescription = resources.GetString("tabPage1.AccessibleDescription");
			this.tabPage1.AccessibleName = resources.GetString("tabPage1.AccessibleName");
			this.tabPage1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabPage1.Anchor")));
			this.tabPage1.AutoScroll = ((bool)(resources.GetObject("tabPage1.AutoScroll")));
			this.tabPage1.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("tabPage1.AutoScrollMargin")));
			this.tabPage1.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("tabPage1.AutoScrollMinSize")));
			this.tabPage1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabPage1.BackgroundImage")));
			this.tabPage1.Controls.Add(this.labelPaso);
			this.tabPage1.Controls.Add(this.lblStep);
			this.tabPage1.Controls.Add(this.labelStatus);
			this.tabPage1.Controls.Add(this.lblStatus);
			this.tabPage1.Controls.Add(this.lblIdentificadorCont);
			this.tabPage1.Controls.Add(this.label8);
			this.tabPage1.Controls.Add(this.lblIdentificador);
			this.tabPage1.Controls.Add(this.label4);
			this.tabPage1.Controls.Add(this.lblVersion);
			this.tabPage1.Controls.Add(this.label3);
			this.tabPage1.Controls.Add(this.groupBox1);
			this.tabPage1.Controls.Add(this.lblFecMod);
			this.tabPage1.Controls.Add(this.label5);
			this.tabPage1.Controls.Add(this.txtDesc);
			this.tabPage1.Controls.Add(this.label1);
			this.tabPage1.Controls.Add(this.txttitulo);
			this.tabPage1.Controls.Add(this.lbltitulo);
			this.tabPage1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabPage1.Dock")));
			this.tabPage1.Enabled = ((bool)(resources.GetObject("tabPage1.Enabled")));
			this.tabPage1.Font = ((System.Drawing.Font)(resources.GetObject("tabPage1.Font")));
			this.helpProvider1.SetHelpKeyword(this.tabPage1, resources.GetString("tabPage1.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.tabPage1, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("tabPage1.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.tabPage1, resources.GetString("tabPage1.HelpString"));
			this.tabPage1.ImageIndex = ((int)(resources.GetObject("tabPage1.ImageIndex")));
			this.tabPage1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabPage1.ImeMode")));
			this.tabPage1.Location = ((System.Drawing.Point)(resources.GetObject("tabPage1.Location")));
			this.tabPage1.Name = "tabPage1";
			this.tabPage1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabPage1.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.tabPage1, ((bool)(resources.GetObject("tabPage1.ShowHelp"))));
			this.tabPage1.Size = ((System.Drawing.Size)(resources.GetObject("tabPage1.Size")));
			this.tabPage1.TabIndex = ((int)(resources.GetObject("tabPage1.TabIndex")));
			this.tabPage1.Text = resources.GetString("tabPage1.Text");
			this.tabPage1.ToolTipText = resources.GetString("tabPage1.ToolTipText");
			this.tabPage1.Visible = ((bool)(resources.GetObject("tabPage1.Visible")));
			// 
			// labelPaso
			// 
			this.labelPaso.AccessibleDescription = resources.GetString("labelPaso.AccessibleDescription");
			this.labelPaso.AccessibleName = resources.GetString("labelPaso.AccessibleName");
			this.labelPaso.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("labelPaso.Anchor")));
			this.labelPaso.AutoSize = ((bool)(resources.GetObject("labelPaso.AutoSize")));
			this.labelPaso.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("labelPaso.Dock")));
			this.labelPaso.Enabled = ((bool)(resources.GetObject("labelPaso.Enabled")));
			this.labelPaso.Font = ((System.Drawing.Font)(resources.GetObject("labelPaso.Font")));
			this.helpProvider1.SetHelpKeyword(this.labelPaso, resources.GetString("labelPaso.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.labelPaso, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("labelPaso.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.labelPaso, resources.GetString("labelPaso.HelpString"));
			this.labelPaso.Image = ((System.Drawing.Image)(resources.GetObject("labelPaso.Image")));
			this.labelPaso.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("labelPaso.ImageAlign")));
			this.labelPaso.ImageIndex = ((int)(resources.GetObject("labelPaso.ImageIndex")));
			this.labelPaso.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("labelPaso.ImeMode")));
			this.labelPaso.Location = ((System.Drawing.Point)(resources.GetObject("labelPaso.Location")));
			this.labelPaso.Name = "labelPaso";
			this.labelPaso.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("labelPaso.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.labelPaso, ((bool)(resources.GetObject("labelPaso.ShowHelp"))));
			this.labelPaso.Size = ((System.Drawing.Size)(resources.GetObject("labelPaso.Size")));
			this.labelPaso.TabIndex = ((int)(resources.GetObject("labelPaso.TabIndex")));
			this.labelPaso.Text = resources.GetString("labelPaso.Text");
			this.labelPaso.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("labelPaso.TextAlign")));
			this.labelPaso.Visible = ((bool)(resources.GetObject("labelPaso.Visible")));
			// 
			// lblStep
			// 
			this.lblStep.AccessibleDescription = resources.GetString("lblStep.AccessibleDescription");
			this.lblStep.AccessibleName = resources.GetString("lblStep.AccessibleName");
			this.lblStep.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lblStep.Anchor")));
			this.lblStep.AutoSize = ((bool)(resources.GetObject("lblStep.AutoSize")));
			this.lblStep.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lblStep.Dock")));
			this.lblStep.Enabled = ((bool)(resources.GetObject("lblStep.Enabled")));
			this.lblStep.Font = ((System.Drawing.Font)(resources.GetObject("lblStep.Font")));
			this.helpProvider1.SetHelpKeyword(this.lblStep, resources.GetString("lblStep.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.lblStep, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("lblStep.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.lblStep, resources.GetString("lblStep.HelpString"));
			this.lblStep.Image = ((System.Drawing.Image)(resources.GetObject("lblStep.Image")));
			this.lblStep.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblStep.ImageAlign")));
			this.lblStep.ImageIndex = ((int)(resources.GetObject("lblStep.ImageIndex")));
			this.lblStep.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lblStep.ImeMode")));
			this.lblStep.Location = ((System.Drawing.Point)(resources.GetObject("lblStep.Location")));
			this.lblStep.Name = "lblStep";
			this.lblStep.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lblStep.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.lblStep, ((bool)(resources.GetObject("lblStep.ShowHelp"))));
			this.lblStep.Size = ((System.Drawing.Size)(resources.GetObject("lblStep.Size")));
			this.lblStep.TabIndex = ((int)(resources.GetObject("lblStep.TabIndex")));
			this.lblStep.Text = resources.GetString("lblStep.Text");
			this.lblStep.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblStep.TextAlign")));
			this.lblStep.Visible = ((bool)(resources.GetObject("lblStep.Visible")));
			// 
			// labelStatus
			// 
			this.labelStatus.AccessibleDescription = resources.GetString("labelStatus.AccessibleDescription");
			this.labelStatus.AccessibleName = resources.GetString("labelStatus.AccessibleName");
			this.labelStatus.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("labelStatus.Anchor")));
			this.labelStatus.AutoSize = ((bool)(resources.GetObject("labelStatus.AutoSize")));
			this.labelStatus.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("labelStatus.Dock")));
			this.labelStatus.Enabled = ((bool)(resources.GetObject("labelStatus.Enabled")));
			this.labelStatus.Font = ((System.Drawing.Font)(resources.GetObject("labelStatus.Font")));
			this.helpProvider1.SetHelpKeyword(this.labelStatus, resources.GetString("labelStatus.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.labelStatus, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("labelStatus.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.labelStatus, resources.GetString("labelStatus.HelpString"));
			this.labelStatus.Image = ((System.Drawing.Image)(resources.GetObject("labelStatus.Image")));
			this.labelStatus.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("labelStatus.ImageAlign")));
			this.labelStatus.ImageIndex = ((int)(resources.GetObject("labelStatus.ImageIndex")));
			this.labelStatus.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("labelStatus.ImeMode")));
			this.labelStatus.Location = ((System.Drawing.Point)(resources.GetObject("labelStatus.Location")));
			this.labelStatus.Name = "labelStatus";
			this.labelStatus.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("labelStatus.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.labelStatus, ((bool)(resources.GetObject("labelStatus.ShowHelp"))));
			this.labelStatus.Size = ((System.Drawing.Size)(resources.GetObject("labelStatus.Size")));
			this.labelStatus.TabIndex = ((int)(resources.GetObject("labelStatus.TabIndex")));
			this.labelStatus.Text = resources.GetString("labelStatus.Text");
			this.labelStatus.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("labelStatus.TextAlign")));
			this.labelStatus.Visible = ((bool)(resources.GetObject("labelStatus.Visible")));
			// 
			// lblStatus
			// 
			this.lblStatus.AccessibleDescription = resources.GetString("lblStatus.AccessibleDescription");
			this.lblStatus.AccessibleName = resources.GetString("lblStatus.AccessibleName");
			this.lblStatus.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lblStatus.Anchor")));
			this.lblStatus.AutoSize = ((bool)(resources.GetObject("lblStatus.AutoSize")));
			this.lblStatus.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lblStatus.Dock")));
			this.lblStatus.Enabled = ((bool)(resources.GetObject("lblStatus.Enabled")));
			this.lblStatus.Font = ((System.Drawing.Font)(resources.GetObject("lblStatus.Font")));
			this.helpProvider1.SetHelpKeyword(this.lblStatus, resources.GetString("lblStatus.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.lblStatus, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("lblStatus.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.lblStatus, resources.GetString("lblStatus.HelpString"));
			this.lblStatus.Image = ((System.Drawing.Image)(resources.GetObject("lblStatus.Image")));
			this.lblStatus.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblStatus.ImageAlign")));
			this.lblStatus.ImageIndex = ((int)(resources.GetObject("lblStatus.ImageIndex")));
			this.lblStatus.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lblStatus.ImeMode")));
			this.lblStatus.Location = ((System.Drawing.Point)(resources.GetObject("lblStatus.Location")));
			this.lblStatus.Name = "lblStatus";
			this.lblStatus.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lblStatus.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.lblStatus, ((bool)(resources.GetObject("lblStatus.ShowHelp"))));
			this.lblStatus.Size = ((System.Drawing.Size)(resources.GetObject("lblStatus.Size")));
			this.lblStatus.TabIndex = ((int)(resources.GetObject("lblStatus.TabIndex")));
			this.lblStatus.Text = resources.GetString("lblStatus.Text");
			this.lblStatus.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblStatus.TextAlign")));
			this.lblStatus.Visible = ((bool)(resources.GetObject("lblStatus.Visible")));
			// 
			// lblIdentificadorCont
			// 
			this.lblIdentificadorCont.AccessibleDescription = resources.GetString("lblIdentificadorCont.AccessibleDescription");
			this.lblIdentificadorCont.AccessibleName = resources.GetString("lblIdentificadorCont.AccessibleName");
			this.lblIdentificadorCont.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lblIdentificadorCont.Anchor")));
			this.lblIdentificadorCont.AutoSize = ((bool)(resources.GetObject("lblIdentificadorCont.AutoSize")));
			this.lblIdentificadorCont.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lblIdentificadorCont.Dock")));
			this.lblIdentificadorCont.Enabled = ((bool)(resources.GetObject("lblIdentificadorCont.Enabled")));
			this.lblIdentificadorCont.Font = ((System.Drawing.Font)(resources.GetObject("lblIdentificadorCont.Font")));
			this.helpProvider1.SetHelpKeyword(this.lblIdentificadorCont, resources.GetString("lblIdentificadorCont.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.lblIdentificadorCont, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("lblIdentificadorCont.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.lblIdentificadorCont, resources.GetString("lblIdentificadorCont.HelpString"));
			this.lblIdentificadorCont.Image = ((System.Drawing.Image)(resources.GetObject("lblIdentificadorCont.Image")));
			this.lblIdentificadorCont.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblIdentificadorCont.ImageAlign")));
			this.lblIdentificadorCont.ImageIndex = ((int)(resources.GetObject("lblIdentificadorCont.ImageIndex")));
			this.lblIdentificadorCont.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lblIdentificadorCont.ImeMode")));
			this.lblIdentificadorCont.Location = ((System.Drawing.Point)(resources.GetObject("lblIdentificadorCont.Location")));
			this.lblIdentificadorCont.Name = "lblIdentificadorCont";
			this.lblIdentificadorCont.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lblIdentificadorCont.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.lblIdentificadorCont, ((bool)(resources.GetObject("lblIdentificadorCont.ShowHelp"))));
			this.lblIdentificadorCont.Size = ((System.Drawing.Size)(resources.GetObject("lblIdentificadorCont.Size")));
			this.lblIdentificadorCont.TabIndex = ((int)(resources.GetObject("lblIdentificadorCont.TabIndex")));
			this.lblIdentificadorCont.Text = resources.GetString("lblIdentificadorCont.Text");
			this.lblIdentificadorCont.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblIdentificadorCont.TextAlign")));
			this.lblIdentificadorCont.Visible = ((bool)(resources.GetObject("lblIdentificadorCont.Visible")));
			// 
			// label8
			// 
			this.label8.AccessibleDescription = resources.GetString("label8.AccessibleDescription");
			this.label8.AccessibleName = resources.GetString("label8.AccessibleName");
			this.label8.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label8.Anchor")));
			this.label8.AutoSize = ((bool)(resources.GetObject("label8.AutoSize")));
			this.label8.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label8.Dock")));
			this.label8.Enabled = ((bool)(resources.GetObject("label8.Enabled")));
			this.label8.Font = ((System.Drawing.Font)(resources.GetObject("label8.Font")));
			this.helpProvider1.SetHelpKeyword(this.label8, resources.GetString("label8.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label8, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label8.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label8, resources.GetString("label8.HelpString"));
			this.label8.Image = ((System.Drawing.Image)(resources.GetObject("label8.Image")));
			this.label8.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label8.ImageAlign")));
			this.label8.ImageIndex = ((int)(resources.GetObject("label8.ImageIndex")));
			this.label8.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label8.ImeMode")));
			this.label8.Location = ((System.Drawing.Point)(resources.GetObject("label8.Location")));
			this.label8.Name = "label8";
			this.label8.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label8.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label8, ((bool)(resources.GetObject("label8.ShowHelp"))));
			this.label8.Size = ((System.Drawing.Size)(resources.GetObject("label8.Size")));
			this.label8.TabIndex = ((int)(resources.GetObject("label8.TabIndex")));
			this.label8.Text = resources.GetString("label8.Text");
			this.label8.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label8.TextAlign")));
			this.label8.Visible = ((bool)(resources.GetObject("label8.Visible")));
			// 
			// lblIdentificador
			// 
			this.lblIdentificador.AccessibleDescription = resources.GetString("lblIdentificador.AccessibleDescription");
			this.lblIdentificador.AccessibleName = resources.GetString("lblIdentificador.AccessibleName");
			this.lblIdentificador.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lblIdentificador.Anchor")));
			this.lblIdentificador.AutoSize = ((bool)(resources.GetObject("lblIdentificador.AutoSize")));
			this.lblIdentificador.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lblIdentificador.Dock")));
			this.lblIdentificador.Enabled = ((bool)(resources.GetObject("lblIdentificador.Enabled")));
			this.lblIdentificador.Font = ((System.Drawing.Font)(resources.GetObject("lblIdentificador.Font")));
			this.helpProvider1.SetHelpKeyword(this.lblIdentificador, resources.GetString("lblIdentificador.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.lblIdentificador, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("lblIdentificador.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.lblIdentificador, resources.GetString("lblIdentificador.HelpString"));
			this.lblIdentificador.Image = ((System.Drawing.Image)(resources.GetObject("lblIdentificador.Image")));
			this.lblIdentificador.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblIdentificador.ImageAlign")));
			this.lblIdentificador.ImageIndex = ((int)(resources.GetObject("lblIdentificador.ImageIndex")));
			this.lblIdentificador.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lblIdentificador.ImeMode")));
			this.lblIdentificador.Location = ((System.Drawing.Point)(resources.GetObject("lblIdentificador.Location")));
			this.lblIdentificador.Name = "lblIdentificador";
			this.lblIdentificador.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lblIdentificador.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.lblIdentificador, ((bool)(resources.GetObject("lblIdentificador.ShowHelp"))));
			this.lblIdentificador.Size = ((System.Drawing.Size)(resources.GetObject("lblIdentificador.Size")));
			this.lblIdentificador.TabIndex = ((int)(resources.GetObject("lblIdentificador.TabIndex")));
			this.lblIdentificador.Text = resources.GetString("lblIdentificador.Text");
			this.lblIdentificador.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblIdentificador.TextAlign")));
			this.lblIdentificador.Visible = ((bool)(resources.GetObject("lblIdentificador.Visible")));
			// 
			// label4
			// 
			this.label4.AccessibleDescription = resources.GetString("label4.AccessibleDescription");
			this.label4.AccessibleName = resources.GetString("label4.AccessibleName");
			this.label4.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label4.Anchor")));
			this.label4.AutoSize = ((bool)(resources.GetObject("label4.AutoSize")));
			this.label4.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label4.Dock")));
			this.label4.Enabled = ((bool)(resources.GetObject("label4.Enabled")));
			this.label4.Font = ((System.Drawing.Font)(resources.GetObject("label4.Font")));
			this.helpProvider1.SetHelpKeyword(this.label4, resources.GetString("label4.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label4, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label4.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label4, resources.GetString("label4.HelpString"));
			this.label4.Image = ((System.Drawing.Image)(resources.GetObject("label4.Image")));
			this.label4.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label4.ImageAlign")));
			this.label4.ImageIndex = ((int)(resources.GetObject("label4.ImageIndex")));
			this.label4.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label4.ImeMode")));
			this.label4.Location = ((System.Drawing.Point)(resources.GetObject("label4.Location")));
			this.label4.Name = "label4";
			this.label4.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label4.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label4, ((bool)(resources.GetObject("label4.ShowHelp"))));
			this.label4.Size = ((System.Drawing.Size)(resources.GetObject("label4.Size")));
			this.label4.TabIndex = ((int)(resources.GetObject("label4.TabIndex")));
			this.label4.Text = resources.GetString("label4.Text");
			this.label4.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label4.TextAlign")));
			this.label4.Visible = ((bool)(resources.GetObject("label4.Visible")));
			// 
			// lblVersion
			// 
			this.lblVersion.AccessibleDescription = resources.GetString("lblVersion.AccessibleDescription");
			this.lblVersion.AccessibleName = resources.GetString("lblVersion.AccessibleName");
			this.lblVersion.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lblVersion.Anchor")));
			this.lblVersion.AutoSize = ((bool)(resources.GetObject("lblVersion.AutoSize")));
			this.lblVersion.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lblVersion.Dock")));
			this.lblVersion.Enabled = ((bool)(resources.GetObject("lblVersion.Enabled")));
			this.lblVersion.Font = ((System.Drawing.Font)(resources.GetObject("lblVersion.Font")));
			this.helpProvider1.SetHelpKeyword(this.lblVersion, resources.GetString("lblVersion.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.lblVersion, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("lblVersion.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.lblVersion, resources.GetString("lblVersion.HelpString"));
			this.lblVersion.Image = ((System.Drawing.Image)(resources.GetObject("lblVersion.Image")));
			this.lblVersion.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblVersion.ImageAlign")));
			this.lblVersion.ImageIndex = ((int)(resources.GetObject("lblVersion.ImageIndex")));
			this.lblVersion.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lblVersion.ImeMode")));
			this.lblVersion.Location = ((System.Drawing.Point)(resources.GetObject("lblVersion.Location")));
			this.lblVersion.Name = "lblVersion";
			this.lblVersion.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lblVersion.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.lblVersion, ((bool)(resources.GetObject("lblVersion.ShowHelp"))));
			this.lblVersion.Size = ((System.Drawing.Size)(resources.GetObject("lblVersion.Size")));
			this.lblVersion.TabIndex = ((int)(resources.GetObject("lblVersion.TabIndex")));
			this.lblVersion.Text = resources.GetString("lblVersion.Text");
			this.lblVersion.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblVersion.TextAlign")));
			this.lblVersion.Visible = ((bool)(resources.GetObject("lblVersion.Visible")));
			// 
			// label3
			// 
			this.label3.AccessibleDescription = resources.GetString("label3.AccessibleDescription");
			this.label3.AccessibleName = resources.GetString("label3.AccessibleName");
			this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label3.Anchor")));
			this.label3.AutoSize = ((bool)(resources.GetObject("label3.AutoSize")));
			this.label3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label3.Dock")));
			this.label3.Enabled = ((bool)(resources.GetObject("label3.Enabled")));
			this.label3.Font = ((System.Drawing.Font)(resources.GetObject("label3.Font")));
			this.helpProvider1.SetHelpKeyword(this.label3, resources.GetString("label3.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label3, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label3.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label3, resources.GetString("label3.HelpString"));
			this.label3.Image = ((System.Drawing.Image)(resources.GetObject("label3.Image")));
			this.label3.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label3.ImageAlign")));
			this.label3.ImageIndex = ((int)(resources.GetObject("label3.ImageIndex")));
			this.label3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label3.ImeMode")));
			this.label3.Location = ((System.Drawing.Point)(resources.GetObject("label3.Location")));
			this.label3.Name = "label3";
			this.label3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label3.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label3, ((bool)(resources.GetObject("label3.ShowHelp"))));
			this.label3.Size = ((System.Drawing.Size)(resources.GetObject("label3.Size")));
			this.label3.TabIndex = ((int)(resources.GetObject("label3.TabIndex")));
			this.label3.Text = resources.GetString("label3.Text");
			this.label3.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label3.TextAlign")));
			this.label3.Visible = ((bool)(resources.GetObject("label3.Visible")));
			// 
			// groupBox1
			// 
			this.groupBox1.AccessibleDescription = resources.GetString("groupBox1.AccessibleDescription");
			this.groupBox1.AccessibleName = resources.GetString("groupBox1.AccessibleName");
			this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox1.Anchor")));
			this.groupBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox1.BackgroundImage")));
			this.groupBox1.Controls.Add(this.radioNo);
			this.groupBox1.Controls.Add(this.radioSi);
			this.groupBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox1.Dock")));
			this.groupBox1.Enabled = ((bool)(resources.GetObject("groupBox1.Enabled")));
			this.groupBox1.Font = ((System.Drawing.Font)(resources.GetObject("groupBox1.Font")));
			this.helpProvider1.SetHelpKeyword(this.groupBox1, resources.GetString("groupBox1.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.groupBox1, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("groupBox1.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.groupBox1, resources.GetString("groupBox1.HelpString"));
			this.groupBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBox1.ImeMode")));
			this.groupBox1.Location = ((System.Drawing.Point)(resources.GetObject("groupBox1.Location")));
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBox1.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.groupBox1, ((bool)(resources.GetObject("groupBox1.ShowHelp"))));
			this.groupBox1.Size = ((System.Drawing.Size)(resources.GetObject("groupBox1.Size")));
			this.groupBox1.TabIndex = ((int)(resources.GetObject("groupBox1.TabIndex")));
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = resources.GetString("groupBox1.Text");
			this.groupBox1.Visible = ((bool)(resources.GetObject("groupBox1.Visible")));
			// 
			// radioNo
			// 
			this.radioNo.AccessibleDescription = resources.GetString("radioNo.AccessibleDescription");
			this.radioNo.AccessibleName = resources.GetString("radioNo.AccessibleName");
			this.radioNo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioNo.Anchor")));
			this.radioNo.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioNo.Appearance")));
			this.radioNo.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioNo.BackgroundImage")));
			this.radioNo.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioNo.CheckAlign")));
			this.radioNo.Checked = true;
			this.radioNo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioNo.Dock")));
			this.radioNo.Enabled = ((bool)(resources.GetObject("radioNo.Enabled")));
			this.radioNo.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioNo.FlatStyle")));
			this.radioNo.Font = ((System.Drawing.Font)(resources.GetObject("radioNo.Font")));
			this.helpProvider1.SetHelpKeyword(this.radioNo, resources.GetString("radioNo.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.radioNo, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("radioNo.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.radioNo, resources.GetString("radioNo.HelpString"));
			this.radioNo.Image = ((System.Drawing.Image)(resources.GetObject("radioNo.Image")));
			this.radioNo.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioNo.ImageAlign")));
			this.radioNo.ImageIndex = ((int)(resources.GetObject("radioNo.ImageIndex")));
			this.radioNo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioNo.ImeMode")));
			this.radioNo.Location = ((System.Drawing.Point)(resources.GetObject("radioNo.Location")));
			this.radioNo.Name = "radioNo";
			this.radioNo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioNo.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.radioNo, ((bool)(resources.GetObject("radioNo.ShowHelp"))));
			this.radioNo.Size = ((System.Drawing.Size)(resources.GetObject("radioNo.Size")));
			this.radioNo.TabIndex = ((int)(resources.GetObject("radioNo.TabIndex")));
			this.radioNo.TabStop = true;
			this.radioNo.Text = resources.GetString("radioNo.Text");
			this.radioNo.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioNo.TextAlign")));
			this.radioNo.Visible = ((bool)(resources.GetObject("radioNo.Visible")));
			// 
			// radioSi
			// 
			this.radioSi.AccessibleDescription = resources.GetString("radioSi.AccessibleDescription");
			this.radioSi.AccessibleName = resources.GetString("radioSi.AccessibleName");
			this.radioSi.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioSi.Anchor")));
			this.radioSi.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioSi.Appearance")));
			this.radioSi.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioSi.BackgroundImage")));
			this.radioSi.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioSi.CheckAlign")));
			this.radioSi.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioSi.Dock")));
			this.radioSi.Enabled = ((bool)(resources.GetObject("radioSi.Enabled")));
			this.radioSi.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioSi.FlatStyle")));
			this.radioSi.Font = ((System.Drawing.Font)(resources.GetObject("radioSi.Font")));
			this.helpProvider1.SetHelpKeyword(this.radioSi, resources.GetString("radioSi.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.radioSi, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("radioSi.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.radioSi, resources.GetString("radioSi.HelpString"));
			this.radioSi.Image = ((System.Drawing.Image)(resources.GetObject("radioSi.Image")));
			this.radioSi.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioSi.ImageAlign")));
			this.radioSi.ImageIndex = ((int)(resources.GetObject("radioSi.ImageIndex")));
			this.radioSi.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioSi.ImeMode")));
			this.radioSi.Location = ((System.Drawing.Point)(resources.GetObject("radioSi.Location")));
			this.radioSi.Name = "radioSi";
			this.radioSi.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioSi.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.radioSi, ((bool)(resources.GetObject("radioSi.ShowHelp"))));
			this.radioSi.Size = ((System.Drawing.Size)(resources.GetObject("radioSi.Size")));
			this.radioSi.TabIndex = ((int)(resources.GetObject("radioSi.TabIndex")));
			this.radioSi.Text = resources.GetString("radioSi.Text");
			this.radioSi.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioSi.TextAlign")));
			this.radioSi.Visible = ((bool)(resources.GetObject("radioSi.Visible")));
			// 
			// lblFecMod
			// 
			this.lblFecMod.AccessibleDescription = resources.GetString("lblFecMod.AccessibleDescription");
			this.lblFecMod.AccessibleName = resources.GetString("lblFecMod.AccessibleName");
			this.lblFecMod.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lblFecMod.Anchor")));
			this.lblFecMod.AutoSize = ((bool)(resources.GetObject("lblFecMod.AutoSize")));
			this.lblFecMod.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lblFecMod.Dock")));
			this.lblFecMod.Enabled = ((bool)(resources.GetObject("lblFecMod.Enabled")));
			this.lblFecMod.Font = ((System.Drawing.Font)(resources.GetObject("lblFecMod.Font")));
			this.helpProvider1.SetHelpKeyword(this.lblFecMod, resources.GetString("lblFecMod.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.lblFecMod, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("lblFecMod.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.lblFecMod, resources.GetString("lblFecMod.HelpString"));
			this.lblFecMod.Image = ((System.Drawing.Image)(resources.GetObject("lblFecMod.Image")));
			this.lblFecMod.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblFecMod.ImageAlign")));
			this.lblFecMod.ImageIndex = ((int)(resources.GetObject("lblFecMod.ImageIndex")));
			this.lblFecMod.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lblFecMod.ImeMode")));
			this.lblFecMod.Location = ((System.Drawing.Point)(resources.GetObject("lblFecMod.Location")));
			this.lblFecMod.Name = "lblFecMod";
			this.lblFecMod.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lblFecMod.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.lblFecMod, ((bool)(resources.GetObject("lblFecMod.ShowHelp"))));
			this.lblFecMod.Size = ((System.Drawing.Size)(resources.GetObject("lblFecMod.Size")));
			this.lblFecMod.TabIndex = ((int)(resources.GetObject("lblFecMod.TabIndex")));
			this.lblFecMod.Text = resources.GetString("lblFecMod.Text");
			this.lblFecMod.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lblFecMod.TextAlign")));
			this.lblFecMod.Visible = ((bool)(resources.GetObject("lblFecMod.Visible")));
			// 
			// label5
			// 
			this.label5.AccessibleDescription = resources.GetString("label5.AccessibleDescription");
			this.label5.AccessibleName = resources.GetString("label5.AccessibleName");
			this.label5.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label5.Anchor")));
			this.label5.AutoSize = ((bool)(resources.GetObject("label5.AutoSize")));
			this.label5.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label5.Dock")));
			this.label5.Enabled = ((bool)(resources.GetObject("label5.Enabled")));
			this.label5.Font = ((System.Drawing.Font)(resources.GetObject("label5.Font")));
			this.helpProvider1.SetHelpKeyword(this.label5, resources.GetString("label5.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label5, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label5.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label5, resources.GetString("label5.HelpString"));
			this.label5.Image = ((System.Drawing.Image)(resources.GetObject("label5.Image")));
			this.label5.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label5.ImageAlign")));
			this.label5.ImageIndex = ((int)(resources.GetObject("label5.ImageIndex")));
			this.label5.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label5.ImeMode")));
			this.label5.Location = ((System.Drawing.Point)(resources.GetObject("label5.Location")));
			this.label5.Name = "label5";
			this.label5.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label5.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label5, ((bool)(resources.GetObject("label5.ShowHelp"))));
			this.label5.Size = ((System.Drawing.Size)(resources.GetObject("label5.Size")));
			this.label5.TabIndex = ((int)(resources.GetObject("label5.TabIndex")));
			this.label5.Text = resources.GetString("label5.Text");
			this.label5.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label5.TextAlign")));
			this.label5.Visible = ((bool)(resources.GetObject("label5.Visible")));
			// 
			// txtDesc
			// 
			this.txtDesc.AccessibleDescription = resources.GetString("txtDesc.AccessibleDescription");
			this.txtDesc.AccessibleName = resources.GetString("txtDesc.AccessibleName");
			this.txtDesc.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtDesc.Anchor")));
			this.txtDesc.AutoSize = ((bool)(resources.GetObject("txtDesc.AutoSize")));
			this.txtDesc.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtDesc.BackgroundImage")));
			this.txtDesc.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtDesc.Dock")));
			this.txtDesc.Enabled = ((bool)(resources.GetObject("txtDesc.Enabled")));
			this.txtDesc.Font = ((System.Drawing.Font)(resources.GetObject("txtDesc.Font")));
			this.helpProvider1.SetHelpKeyword(this.txtDesc, resources.GetString("txtDesc.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.txtDesc, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("txtDesc.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.txtDesc, resources.GetString("txtDesc.HelpString"));
			this.txtDesc.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtDesc.ImeMode")));
			this.txtDesc.Location = ((System.Drawing.Point)(resources.GetObject("txtDesc.Location")));
			this.txtDesc.MaxLength = ((int)(resources.GetObject("txtDesc.MaxLength")));
			this.txtDesc.Multiline = ((bool)(resources.GetObject("txtDesc.Multiline")));
			this.txtDesc.Name = "txtDesc";
			this.txtDesc.PasswordChar = ((char)(resources.GetObject("txtDesc.PasswordChar")));
			this.txtDesc.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtDesc.RightToLeft")));
			this.txtDesc.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtDesc.ScrollBars")));
			this.helpProvider1.SetShowHelp(this.txtDesc, ((bool)(resources.GetObject("txtDesc.ShowHelp"))));
			this.txtDesc.Size = ((System.Drawing.Size)(resources.GetObject("txtDesc.Size")));
			this.txtDesc.TabIndex = ((int)(resources.GetObject("txtDesc.TabIndex")));
			this.txtDesc.Text = resources.GetString("txtDesc.Text");
			this.txtDesc.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtDesc.TextAlign")));
			this.txtDesc.Visible = ((bool)(resources.GetObject("txtDesc.Visible")));
			this.txtDesc.WordWrap = ((bool)(resources.GetObject("txtDesc.WordWrap")));
			// 
			// label1
			// 
			this.label1.AccessibleDescription = resources.GetString("label1.AccessibleDescription");
			this.label1.AccessibleName = resources.GetString("label1.AccessibleName");
			this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label1.Anchor")));
			this.label1.AutoSize = ((bool)(resources.GetObject("label1.AutoSize")));
			this.label1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label1.Dock")));
			this.label1.Enabled = ((bool)(resources.GetObject("label1.Enabled")));
			this.label1.Font = ((System.Drawing.Font)(resources.GetObject("label1.Font")));
			this.helpProvider1.SetHelpKeyword(this.label1, resources.GetString("label1.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label1, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label1.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label1, resources.GetString("label1.HelpString"));
			this.label1.Image = ((System.Drawing.Image)(resources.GetObject("label1.Image")));
			this.label1.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label1.ImageAlign")));
			this.label1.ImageIndex = ((int)(resources.GetObject("label1.ImageIndex")));
			this.label1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label1.ImeMode")));
			this.label1.Location = ((System.Drawing.Point)(resources.GetObject("label1.Location")));
			this.label1.Name = "label1";
			this.label1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label1.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label1, ((bool)(resources.GetObject("label1.ShowHelp"))));
			this.label1.Size = ((System.Drawing.Size)(resources.GetObject("label1.Size")));
			this.label1.TabIndex = ((int)(resources.GetObject("label1.TabIndex")));
			this.label1.Text = resources.GetString("label1.Text");
			this.label1.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label1.TextAlign")));
			this.label1.Visible = ((bool)(resources.GetObject("label1.Visible")));
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
			this.txttitulo.Font = ((System.Drawing.Font)(resources.GetObject("txttitulo.Font")));
			this.helpProvider1.SetHelpKeyword(this.txttitulo, resources.GetString("txttitulo.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.txttitulo, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("txttitulo.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.txttitulo, resources.GetString("txttitulo.HelpString"));
			this.txttitulo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txttitulo.ImeMode")));
			this.txttitulo.Location = ((System.Drawing.Point)(resources.GetObject("txttitulo.Location")));
			this.txttitulo.MaxLength = ((int)(resources.GetObject("txttitulo.MaxLength")));
			this.txttitulo.Multiline = ((bool)(resources.GetObject("txttitulo.Multiline")));
			this.txttitulo.Name = "txttitulo";
			this.txttitulo.PasswordChar = ((char)(resources.GetObject("txttitulo.PasswordChar")));
			this.txttitulo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txttitulo.RightToLeft")));
			this.txttitulo.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txttitulo.ScrollBars")));
			this.helpProvider1.SetShowHelp(this.txttitulo, ((bool)(resources.GetObject("txttitulo.ShowHelp"))));
			this.txttitulo.Size = ((System.Drawing.Size)(resources.GetObject("txttitulo.Size")));
			this.txttitulo.TabIndex = ((int)(resources.GetObject("txttitulo.TabIndex")));
			this.txttitulo.Text = resources.GetString("txttitulo.Text");
			this.txttitulo.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txttitulo.TextAlign")));
			this.txttitulo.Visible = ((bool)(resources.GetObject("txttitulo.Visible")));
			this.txttitulo.WordWrap = ((bool)(resources.GetObject("txttitulo.WordWrap")));
			// 
			// lbltitulo
			// 
			this.lbltitulo.AccessibleDescription = resources.GetString("lbltitulo.AccessibleDescription");
			this.lbltitulo.AccessibleName = resources.GetString("lbltitulo.AccessibleName");
			this.lbltitulo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("lbltitulo.Anchor")));
			this.lbltitulo.AutoSize = ((bool)(resources.GetObject("lbltitulo.AutoSize")));
			this.lbltitulo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("lbltitulo.Dock")));
			this.lbltitulo.Enabled = ((bool)(resources.GetObject("lbltitulo.Enabled")));
			this.lbltitulo.Font = ((System.Drawing.Font)(resources.GetObject("lbltitulo.Font")));
			this.helpProvider1.SetHelpKeyword(this.lbltitulo, resources.GetString("lbltitulo.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.lbltitulo, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("lbltitulo.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.lbltitulo, resources.GetString("lbltitulo.HelpString"));
			this.lbltitulo.Image = ((System.Drawing.Image)(resources.GetObject("lbltitulo.Image")));
			this.lbltitulo.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lbltitulo.ImageAlign")));
			this.lbltitulo.ImageIndex = ((int)(resources.GetObject("lbltitulo.ImageIndex")));
			this.lbltitulo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("lbltitulo.ImeMode")));
			this.lbltitulo.Location = ((System.Drawing.Point)(resources.GetObject("lbltitulo.Location")));
			this.lbltitulo.Name = "lbltitulo";
			this.lbltitulo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("lbltitulo.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.lbltitulo, ((bool)(resources.GetObject("lbltitulo.ShowHelp"))));
			this.lbltitulo.Size = ((System.Drawing.Size)(resources.GetObject("lbltitulo.Size")));
			this.lbltitulo.TabIndex = ((int)(resources.GetObject("lbltitulo.TabIndex")));
			this.lbltitulo.Text = resources.GetString("lbltitulo.Text");
			this.lbltitulo.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("lbltitulo.TextAlign")));
			this.lbltitulo.Visible = ((bool)(resources.GetObject("lbltitulo.Visible")));
			// 
			// tabPage2
			// 
			this.tabPage2.AccessibleDescription = resources.GetString("tabPage2.AccessibleDescription");
			this.tabPage2.AccessibleName = resources.GetString("tabPage2.AccessibleName");
			this.tabPage2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabPage2.Anchor")));
			this.tabPage2.AutoScroll = ((bool)(resources.GetObject("tabPage2.AutoScroll")));
			this.tabPage2.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("tabPage2.AutoScrollMargin")));
			this.tabPage2.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("tabPage2.AutoScrollMinSize")));
			this.tabPage2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabPage2.BackgroundImage")));
			this.tabPage2.Controls.Add(this.buttonTitle);
			this.tabPage2.Controls.Add(this.buttonPreview);
			this.tabPage2.Controls.Add(this.txtRuta);
			this.tabPage2.Controls.Add(this.label9);
			this.tabPage2.Controls.Add(this.groupBox2);
			this.tabPage2.Controls.Add(this.buttonMover);
			this.tabPage2.Controls.Add(this.txttitlesitio);
			this.tabPage2.Controls.Add(this.label7);
			this.tabPage2.Controls.Add(this.label6);
			this.tabPage2.Controls.Add(this.txttitletopic);
			this.tabPage2.Controls.Add(this.txttopicid);
			this.tabPage2.Controls.Add(this.label2);
			this.tabPage2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabPage2.Dock")));
			this.tabPage2.Enabled = ((bool)(resources.GetObject("tabPage2.Enabled")));
			this.tabPage2.Font = ((System.Drawing.Font)(resources.GetObject("tabPage2.Font")));
			this.helpProvider1.SetHelpKeyword(this.tabPage2, resources.GetString("tabPage2.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.tabPage2, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("tabPage2.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.tabPage2, resources.GetString("tabPage2.HelpString"));
			this.tabPage2.ImageIndex = ((int)(resources.GetObject("tabPage2.ImageIndex")));
			this.tabPage2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabPage2.ImeMode")));
			this.tabPage2.Location = ((System.Drawing.Point)(resources.GetObject("tabPage2.Location")));
			this.tabPage2.Name = "tabPage2";
			this.tabPage2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabPage2.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.tabPage2, ((bool)(resources.GetObject("tabPage2.ShowHelp"))));
			this.tabPage2.Size = ((System.Drawing.Size)(resources.GetObject("tabPage2.Size")));
			this.tabPage2.TabIndex = ((int)(resources.GetObject("tabPage2.TabIndex")));
			this.tabPage2.Text = resources.GetString("tabPage2.Text");
			this.tabPage2.ToolTipText = resources.GetString("tabPage2.ToolTipText");
			this.tabPage2.Visible = ((bool)(resources.GetObject("tabPage2.Visible")));
			// 
			// buttonTitle
			// 
			this.buttonTitle.AccessibleDescription = resources.GetString("buttonTitle.AccessibleDescription");
			this.buttonTitle.AccessibleName = resources.GetString("buttonTitle.AccessibleName");
			this.buttonTitle.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonTitle.Anchor")));
			this.buttonTitle.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonTitle.BackgroundImage")));
			this.buttonTitle.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonTitle.Dock")));
			this.buttonTitle.Enabled = ((bool)(resources.GetObject("buttonTitle.Enabled")));
			this.buttonTitle.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonTitle.FlatStyle")));
			this.buttonTitle.Font = ((System.Drawing.Font)(resources.GetObject("buttonTitle.Font")));
			this.helpProvider1.SetHelpKeyword(this.buttonTitle, resources.GetString("buttonTitle.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.buttonTitle, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("buttonTitle.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.buttonTitle, resources.GetString("buttonTitle.HelpString"));
			this.buttonTitle.Image = ((System.Drawing.Image)(resources.GetObject("buttonTitle.Image")));
			this.buttonTitle.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonTitle.ImageAlign")));
			this.buttonTitle.ImageIndex = ((int)(resources.GetObject("buttonTitle.ImageIndex")));
			this.buttonTitle.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonTitle.ImeMode")));
			this.buttonTitle.Location = ((System.Drawing.Point)(resources.GetObject("buttonTitle.Location")));
			this.buttonTitle.Name = "buttonTitle";
			this.buttonTitle.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonTitle.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.buttonTitle, ((bool)(resources.GetObject("buttonTitle.ShowHelp"))));
			this.buttonTitle.Size = ((System.Drawing.Size)(resources.GetObject("buttonTitle.Size")));
			this.buttonTitle.TabIndex = ((int)(resources.GetObject("buttonTitle.TabIndex")));
			this.buttonTitle.Text = resources.GetString("buttonTitle.Text");
			this.buttonTitle.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonTitle.TextAlign")));
			this.buttonTitle.Visible = ((bool)(resources.GetObject("buttonTitle.Visible")));
			this.buttonTitle.Click += new System.EventHandler(this.buttonTitle_Click);
			// 
			// buttonPreview
			// 
			this.buttonPreview.AccessibleDescription = resources.GetString("buttonPreview.AccessibleDescription");
			this.buttonPreview.AccessibleName = resources.GetString("buttonPreview.AccessibleName");
			this.buttonPreview.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonPreview.Anchor")));
			this.buttonPreview.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonPreview.BackgroundImage")));
			this.buttonPreview.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonPreview.Dock")));
			this.buttonPreview.Enabled = ((bool)(resources.GetObject("buttonPreview.Enabled")));
			this.buttonPreview.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonPreview.FlatStyle")));
			this.buttonPreview.Font = ((System.Drawing.Font)(resources.GetObject("buttonPreview.Font")));
			this.helpProvider1.SetHelpKeyword(this.buttonPreview, resources.GetString("buttonPreview.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.buttonPreview, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("buttonPreview.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.buttonPreview, resources.GetString("buttonPreview.HelpString"));
			this.buttonPreview.Image = ((System.Drawing.Image)(resources.GetObject("buttonPreview.Image")));
			this.buttonPreview.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonPreview.ImageAlign")));
			this.buttonPreview.ImageIndex = ((int)(resources.GetObject("buttonPreview.ImageIndex")));
			this.buttonPreview.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonPreview.ImeMode")));
			this.buttonPreview.Location = ((System.Drawing.Point)(resources.GetObject("buttonPreview.Location")));
			this.buttonPreview.Name = "buttonPreview";
			this.buttonPreview.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonPreview.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.buttonPreview, ((bool)(resources.GetObject("buttonPreview.ShowHelp"))));
			this.buttonPreview.Size = ((System.Drawing.Size)(resources.GetObject("buttonPreview.Size")));
			this.buttonPreview.TabIndex = ((int)(resources.GetObject("buttonPreview.TabIndex")));
			this.buttonPreview.Text = resources.GetString("buttonPreview.Text");
			this.buttonPreview.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonPreview.TextAlign")));
			this.buttonPreview.Visible = ((bool)(resources.GetObject("buttonPreview.Visible")));
			this.buttonPreview.Click += new System.EventHandler(this.buttonPreview_Click);
			// 
			// txtRuta
			// 
			this.txtRuta.AccessibleDescription = resources.GetString("txtRuta.AccessibleDescription");
			this.txtRuta.AccessibleName = resources.GetString("txtRuta.AccessibleName");
			this.txtRuta.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txtRuta.Anchor")));
			this.txtRuta.AutoSize = ((bool)(resources.GetObject("txtRuta.AutoSize")));
			this.txtRuta.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txtRuta.BackgroundImage")));
			this.txtRuta.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txtRuta.Dock")));
			this.txtRuta.Enabled = ((bool)(resources.GetObject("txtRuta.Enabled")));
			this.txtRuta.Font = ((System.Drawing.Font)(resources.GetObject("txtRuta.Font")));
			this.helpProvider1.SetHelpKeyword(this.txtRuta, resources.GetString("txtRuta.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.txtRuta, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("txtRuta.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.txtRuta, resources.GetString("txtRuta.HelpString"));
			this.txtRuta.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txtRuta.ImeMode")));
			this.txtRuta.Location = ((System.Drawing.Point)(resources.GetObject("txtRuta.Location")));
			this.txtRuta.MaxLength = ((int)(resources.GetObject("txtRuta.MaxLength")));
			this.txtRuta.Multiline = ((bool)(resources.GetObject("txtRuta.Multiline")));
			this.txtRuta.Name = "txtRuta";
			this.txtRuta.PasswordChar = ((char)(resources.GetObject("txtRuta.PasswordChar")));
			this.txtRuta.ReadOnly = true;
			this.txtRuta.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txtRuta.RightToLeft")));
			this.txtRuta.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txtRuta.ScrollBars")));
			this.helpProvider1.SetShowHelp(this.txtRuta, ((bool)(resources.GetObject("txtRuta.ShowHelp"))));
			this.txtRuta.Size = ((System.Drawing.Size)(resources.GetObject("txtRuta.Size")));
			this.txtRuta.TabIndex = ((int)(resources.GetObject("txtRuta.TabIndex")));
			this.txtRuta.Text = resources.GetString("txtRuta.Text");
			this.txtRuta.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txtRuta.TextAlign")));
			this.txtRuta.Visible = ((bool)(resources.GetObject("txtRuta.Visible")));
			this.txtRuta.WordWrap = ((bool)(resources.GetObject("txtRuta.WordWrap")));
			// 
			// label9
			// 
			this.label9.AccessibleDescription = resources.GetString("label9.AccessibleDescription");
			this.label9.AccessibleName = resources.GetString("label9.AccessibleName");
			this.label9.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label9.Anchor")));
			this.label9.AutoSize = ((bool)(resources.GetObject("label9.AutoSize")));
			this.label9.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label9.Dock")));
			this.label9.Enabled = ((bool)(resources.GetObject("label9.Enabled")));
			this.label9.Font = ((System.Drawing.Font)(resources.GetObject("label9.Font")));
			this.helpProvider1.SetHelpKeyword(this.label9, resources.GetString("label9.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label9, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label9.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label9, resources.GetString("label9.HelpString"));
			this.label9.Image = ((System.Drawing.Image)(resources.GetObject("label9.Image")));
			this.label9.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label9.ImageAlign")));
			this.label9.ImageIndex = ((int)(resources.GetObject("label9.ImageIndex")));
			this.label9.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label9.ImeMode")));
			this.label9.Location = ((System.Drawing.Point)(resources.GetObject("label9.Location")));
			this.label9.Name = "label9";
			this.label9.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label9.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label9, ((bool)(resources.GetObject("label9.ShowHelp"))));
			this.label9.Size = ((System.Drawing.Size)(resources.GetObject("label9.Size")));
			this.label9.TabIndex = ((int)(resources.GetObject("label9.TabIndex")));
			this.label9.Text = resources.GetString("label9.Text");
			this.label9.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label9.TextAlign")));
			this.label9.Visible = ((bool)(resources.GetObject("label9.Visible")));
			// 
			// groupBox2
			// 
			this.groupBox2.AccessibleDescription = resources.GetString("groupBox2.AccessibleDescription");
			this.groupBox2.AccessibleName = resources.GetString("groupBox2.AccessibleName");
			this.groupBox2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox2.Anchor")));
			this.groupBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox2.BackgroundImage")));
			this.groupBox2.Controls.Add(this.radioButtonSeccionNo);
			this.groupBox2.Controls.Add(this.radioButtonSecccionSi);
			this.groupBox2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox2.Dock")));
			this.groupBox2.Enabled = ((bool)(resources.GetObject("groupBox2.Enabled")));
			this.groupBox2.Font = ((System.Drawing.Font)(resources.GetObject("groupBox2.Font")));
			this.helpProvider1.SetHelpKeyword(this.groupBox2, resources.GetString("groupBox2.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.groupBox2, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("groupBox2.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.groupBox2, resources.GetString("groupBox2.HelpString"));
			this.groupBox2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBox2.ImeMode")));
			this.groupBox2.Location = ((System.Drawing.Point)(resources.GetObject("groupBox2.Location")));
			this.groupBox2.Name = "groupBox2";
			this.groupBox2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBox2.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.groupBox2, ((bool)(resources.GetObject("groupBox2.ShowHelp"))));
			this.groupBox2.Size = ((System.Drawing.Size)(resources.GetObject("groupBox2.Size")));
			this.groupBox2.TabIndex = ((int)(resources.GetObject("groupBox2.TabIndex")));
			this.groupBox2.TabStop = false;
			this.groupBox2.Text = resources.GetString("groupBox2.Text");
			this.groupBox2.Visible = ((bool)(resources.GetObject("groupBox2.Visible")));
			// 
			// radioButtonSeccionNo
			// 
			this.radioButtonSeccionNo.AccessibleDescription = resources.GetString("radioButtonSeccionNo.AccessibleDescription");
			this.radioButtonSeccionNo.AccessibleName = resources.GetString("radioButtonSeccionNo.AccessibleName");
			this.radioButtonSeccionNo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonSeccionNo.Anchor")));
			this.radioButtonSeccionNo.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonSeccionNo.Appearance")));
			this.radioButtonSeccionNo.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonSeccionNo.BackgroundImage")));
			this.radioButtonSeccionNo.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonSeccionNo.CheckAlign")));
			this.radioButtonSeccionNo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonSeccionNo.Dock")));
			this.radioButtonSeccionNo.Enabled = ((bool)(resources.GetObject("radioButtonSeccionNo.Enabled")));
			this.radioButtonSeccionNo.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonSeccionNo.FlatStyle")));
			this.radioButtonSeccionNo.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonSeccionNo.Font")));
			this.helpProvider1.SetHelpKeyword(this.radioButtonSeccionNo, resources.GetString("radioButtonSeccionNo.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.radioButtonSeccionNo, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("radioButtonSeccionNo.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.radioButtonSeccionNo, resources.GetString("radioButtonSeccionNo.HelpString"));
			this.radioButtonSeccionNo.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonSeccionNo.Image")));
			this.radioButtonSeccionNo.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonSeccionNo.ImageAlign")));
			this.radioButtonSeccionNo.ImageIndex = ((int)(resources.GetObject("radioButtonSeccionNo.ImageIndex")));
			this.radioButtonSeccionNo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonSeccionNo.ImeMode")));
			this.radioButtonSeccionNo.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonSeccionNo.Location")));
			this.radioButtonSeccionNo.Name = "radioButtonSeccionNo";
			this.radioButtonSeccionNo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonSeccionNo.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.radioButtonSeccionNo, ((bool)(resources.GetObject("radioButtonSeccionNo.ShowHelp"))));
			this.radioButtonSeccionNo.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonSeccionNo.Size")));
			this.radioButtonSeccionNo.TabIndex = ((int)(resources.GetObject("radioButtonSeccionNo.TabIndex")));
			this.radioButtonSeccionNo.Text = resources.GetString("radioButtonSeccionNo.Text");
			this.radioButtonSeccionNo.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonSeccionNo.TextAlign")));
			this.radioButtonSeccionNo.Visible = ((bool)(resources.GetObject("radioButtonSeccionNo.Visible")));
			// 
			// radioButtonSecccionSi
			// 
			this.radioButtonSecccionSi.AccessibleDescription = resources.GetString("radioButtonSecccionSi.AccessibleDescription");
			this.radioButtonSecccionSi.AccessibleName = resources.GetString("radioButtonSecccionSi.AccessibleName");
			this.radioButtonSecccionSi.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonSecccionSi.Anchor")));
			this.radioButtonSecccionSi.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonSecccionSi.Appearance")));
			this.radioButtonSecccionSi.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonSecccionSi.BackgroundImage")));
			this.radioButtonSecccionSi.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonSecccionSi.CheckAlign")));
			this.radioButtonSecccionSi.Checked = true;
			this.radioButtonSecccionSi.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonSecccionSi.Dock")));
			this.radioButtonSecccionSi.Enabled = ((bool)(resources.GetObject("radioButtonSecccionSi.Enabled")));
			this.radioButtonSecccionSi.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonSecccionSi.FlatStyle")));
			this.radioButtonSecccionSi.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonSecccionSi.Font")));
			this.helpProvider1.SetHelpKeyword(this.radioButtonSecccionSi, resources.GetString("radioButtonSecccionSi.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.radioButtonSecccionSi, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("radioButtonSecccionSi.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.radioButtonSecccionSi, resources.GetString("radioButtonSecccionSi.HelpString"));
			this.radioButtonSecccionSi.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonSecccionSi.Image")));
			this.radioButtonSecccionSi.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonSecccionSi.ImageAlign")));
			this.radioButtonSecccionSi.ImageIndex = ((int)(resources.GetObject("radioButtonSecccionSi.ImageIndex")));
			this.radioButtonSecccionSi.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonSecccionSi.ImeMode")));
			this.radioButtonSecccionSi.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonSecccionSi.Location")));
			this.radioButtonSecccionSi.Name = "radioButtonSecccionSi";
			this.radioButtonSecccionSi.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonSecccionSi.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.radioButtonSecccionSi, ((bool)(resources.GetObject("radioButtonSecccionSi.ShowHelp"))));
			this.radioButtonSecccionSi.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonSecccionSi.Size")));
			this.radioButtonSecccionSi.TabIndex = ((int)(resources.GetObject("radioButtonSecccionSi.TabIndex")));
			this.radioButtonSecccionSi.TabStop = true;
			this.radioButtonSecccionSi.Text = resources.GetString("radioButtonSecccionSi.Text");
			this.radioButtonSecccionSi.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonSecccionSi.TextAlign")));
			this.radioButtonSecccionSi.Visible = ((bool)(resources.GetObject("radioButtonSecccionSi.Visible")));
			// 
			// buttonMover
			// 
			this.buttonMover.AccessibleDescription = resources.GetString("buttonMover.AccessibleDescription");
			this.buttonMover.AccessibleName = resources.GetString("buttonMover.AccessibleName");
			this.buttonMover.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("buttonMover.Anchor")));
			this.buttonMover.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("buttonMover.BackgroundImage")));
			this.buttonMover.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("buttonMover.Dock")));
			this.buttonMover.Enabled = ((bool)(resources.GetObject("buttonMover.Enabled")));
			this.buttonMover.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("buttonMover.FlatStyle")));
			this.buttonMover.Font = ((System.Drawing.Font)(resources.GetObject("buttonMover.Font")));
			this.helpProvider1.SetHelpKeyword(this.buttonMover, resources.GetString("buttonMover.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.buttonMover, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("buttonMover.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.buttonMover, resources.GetString("buttonMover.HelpString"));
			this.buttonMover.Image = ((System.Drawing.Image)(resources.GetObject("buttonMover.Image")));
			this.buttonMover.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonMover.ImageAlign")));
			this.buttonMover.ImageIndex = ((int)(resources.GetObject("buttonMover.ImageIndex")));
			this.buttonMover.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("buttonMover.ImeMode")));
			this.buttonMover.Location = ((System.Drawing.Point)(resources.GetObject("buttonMover.Location")));
			this.buttonMover.Name = "buttonMover";
			this.buttonMover.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("buttonMover.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.buttonMover, ((bool)(resources.GetObject("buttonMover.ShowHelp"))));
			this.buttonMover.Size = ((System.Drawing.Size)(resources.GetObject("buttonMover.Size")));
			this.buttonMover.TabIndex = ((int)(resources.GetObject("buttonMover.TabIndex")));
			this.buttonMover.Text = resources.GetString("buttonMover.Text");
			this.buttonMover.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("buttonMover.TextAlign")));
			this.buttonMover.Visible = ((bool)(resources.GetObject("buttonMover.Visible")));
			this.buttonMover.Click += new System.EventHandler(this.buttonMover_Click);
			// 
			// txttitlesitio
			// 
			this.txttitlesitio.AccessibleDescription = resources.GetString("txttitlesitio.AccessibleDescription");
			this.txttitlesitio.AccessibleName = resources.GetString("txttitlesitio.AccessibleName");
			this.txttitlesitio.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txttitlesitio.Anchor")));
			this.txttitlesitio.AutoSize = ((bool)(resources.GetObject("txttitlesitio.AutoSize")));
			this.txttitlesitio.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txttitlesitio.BackgroundImage")));
			this.txttitlesitio.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txttitlesitio.Dock")));
			this.txttitlesitio.Enabled = ((bool)(resources.GetObject("txttitlesitio.Enabled")));
			this.txttitlesitio.Font = ((System.Drawing.Font)(resources.GetObject("txttitlesitio.Font")));
			this.helpProvider1.SetHelpKeyword(this.txttitlesitio, resources.GetString("txttitlesitio.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.txttitlesitio, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("txttitlesitio.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.txttitlesitio, resources.GetString("txttitlesitio.HelpString"));
			this.txttitlesitio.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txttitlesitio.ImeMode")));
			this.txttitlesitio.Location = ((System.Drawing.Point)(resources.GetObject("txttitlesitio.Location")));
			this.txttitlesitio.MaxLength = ((int)(resources.GetObject("txttitlesitio.MaxLength")));
			this.txttitlesitio.Multiline = ((bool)(resources.GetObject("txttitlesitio.Multiline")));
			this.txttitlesitio.Name = "txttitlesitio";
			this.txttitlesitio.PasswordChar = ((char)(resources.GetObject("txttitlesitio.PasswordChar")));
			this.txttitlesitio.ReadOnly = true;
			this.txttitlesitio.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txttitlesitio.RightToLeft")));
			this.txttitlesitio.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txttitlesitio.ScrollBars")));
			this.helpProvider1.SetShowHelp(this.txttitlesitio, ((bool)(resources.GetObject("txttitlesitio.ShowHelp"))));
			this.txttitlesitio.Size = ((System.Drawing.Size)(resources.GetObject("txttitlesitio.Size")));
			this.txttitlesitio.TabIndex = ((int)(resources.GetObject("txttitlesitio.TabIndex")));
			this.txttitlesitio.Text = resources.GetString("txttitlesitio.Text");
			this.txttitlesitio.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txttitlesitio.TextAlign")));
			this.txttitlesitio.Visible = ((bool)(resources.GetObject("txttitlesitio.Visible")));
			this.txttitlesitio.WordWrap = ((bool)(resources.GetObject("txttitlesitio.WordWrap")));
			// 
			// label7
			// 
			this.label7.AccessibleDescription = resources.GetString("label7.AccessibleDescription");
			this.label7.AccessibleName = resources.GetString("label7.AccessibleName");
			this.label7.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label7.Anchor")));
			this.label7.AutoSize = ((bool)(resources.GetObject("label7.AutoSize")));
			this.label7.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label7.Dock")));
			this.label7.Enabled = ((bool)(resources.GetObject("label7.Enabled")));
			this.label7.Font = ((System.Drawing.Font)(resources.GetObject("label7.Font")));
			this.helpProvider1.SetHelpKeyword(this.label7, resources.GetString("label7.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label7, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label7.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label7, resources.GetString("label7.HelpString"));
			this.label7.Image = ((System.Drawing.Image)(resources.GetObject("label7.Image")));
			this.label7.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label7.ImageAlign")));
			this.label7.ImageIndex = ((int)(resources.GetObject("label7.ImageIndex")));
			this.label7.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label7.ImeMode")));
			this.label7.Location = ((System.Drawing.Point)(resources.GetObject("label7.Location")));
			this.label7.Name = "label7";
			this.label7.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label7.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label7, ((bool)(resources.GetObject("label7.ShowHelp"))));
			this.label7.Size = ((System.Drawing.Size)(resources.GetObject("label7.Size")));
			this.label7.TabIndex = ((int)(resources.GetObject("label7.TabIndex")));
			this.label7.Text = resources.GetString("label7.Text");
			this.label7.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label7.TextAlign")));
			this.label7.Visible = ((bool)(resources.GetObject("label7.Visible")));
			// 
			// label6
			// 
			this.label6.AccessibleDescription = resources.GetString("label6.AccessibleDescription");
			this.label6.AccessibleName = resources.GetString("label6.AccessibleName");
			this.label6.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label6.Anchor")));
			this.label6.AutoSize = ((bool)(resources.GetObject("label6.AutoSize")));
			this.label6.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label6.Dock")));
			this.label6.Enabled = ((bool)(resources.GetObject("label6.Enabled")));
			this.label6.Font = ((System.Drawing.Font)(resources.GetObject("label6.Font")));
			this.helpProvider1.SetHelpKeyword(this.label6, resources.GetString("label6.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label6, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label6.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label6, resources.GetString("label6.HelpString"));
			this.label6.Image = ((System.Drawing.Image)(resources.GetObject("label6.Image")));
			this.label6.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label6.ImageAlign")));
			this.label6.ImageIndex = ((int)(resources.GetObject("label6.ImageIndex")));
			this.label6.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label6.ImeMode")));
			this.label6.Location = ((System.Drawing.Point)(resources.GetObject("label6.Location")));
			this.label6.Name = "label6";
			this.label6.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label6.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label6, ((bool)(resources.GetObject("label6.ShowHelp"))));
			this.label6.Size = ((System.Drawing.Size)(resources.GetObject("label6.Size")));
			this.label6.TabIndex = ((int)(resources.GetObject("label6.TabIndex")));
			this.label6.Text = resources.GetString("label6.Text");
			this.label6.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label6.TextAlign")));
			this.label6.Visible = ((bool)(resources.GetObject("label6.Visible")));
			// 
			// txttitletopic
			// 
			this.txttitletopic.AccessibleDescription = resources.GetString("txttitletopic.AccessibleDescription");
			this.txttitletopic.AccessibleName = resources.GetString("txttitletopic.AccessibleName");
			this.txttitletopic.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txttitletopic.Anchor")));
			this.txttitletopic.AutoSize = ((bool)(resources.GetObject("txttitletopic.AutoSize")));
			this.txttitletopic.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txttitletopic.BackgroundImage")));
			this.txttitletopic.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txttitletopic.Dock")));
			this.txttitletopic.Enabled = ((bool)(resources.GetObject("txttitletopic.Enabled")));
			this.txttitletopic.Font = ((System.Drawing.Font)(resources.GetObject("txttitletopic.Font")));
			this.helpProvider1.SetHelpKeyword(this.txttitletopic, resources.GetString("txttitletopic.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.txttitletopic, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("txttitletopic.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.txttitletopic, resources.GetString("txttitletopic.HelpString"));
			this.txttitletopic.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txttitletopic.ImeMode")));
			this.txttitletopic.Location = ((System.Drawing.Point)(resources.GetObject("txttitletopic.Location")));
			this.txttitletopic.MaxLength = ((int)(resources.GetObject("txttitletopic.MaxLength")));
			this.txttitletopic.Multiline = ((bool)(resources.GetObject("txttitletopic.Multiline")));
			this.txttitletopic.Name = "txttitletopic";
			this.txttitletopic.PasswordChar = ((char)(resources.GetObject("txttitletopic.PasswordChar")));
			this.txttitletopic.ReadOnly = true;
			this.txttitletopic.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txttitletopic.RightToLeft")));
			this.txttitletopic.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txttitletopic.ScrollBars")));
			this.helpProvider1.SetShowHelp(this.txttitletopic, ((bool)(resources.GetObject("txttitletopic.ShowHelp"))));
			this.txttitletopic.Size = ((System.Drawing.Size)(resources.GetObject("txttitletopic.Size")));
			this.txttitletopic.TabIndex = ((int)(resources.GetObject("txttitletopic.TabIndex")));
			this.txttitletopic.Text = resources.GetString("txttitletopic.Text");
			this.txttitletopic.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txttitletopic.TextAlign")));
			this.txttitletopic.Visible = ((bool)(resources.GetObject("txttitletopic.Visible")));
			this.txttitletopic.WordWrap = ((bool)(resources.GetObject("txttitletopic.WordWrap")));
			// 
			// txttopicid
			// 
			this.txttopicid.AccessibleDescription = resources.GetString("txttopicid.AccessibleDescription");
			this.txttopicid.AccessibleName = resources.GetString("txttopicid.AccessibleName");
			this.txttopicid.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("txttopicid.Anchor")));
			this.txttopicid.AutoSize = ((bool)(resources.GetObject("txttopicid.AutoSize")));
			this.txttopicid.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("txttopicid.BackgroundImage")));
			this.txttopicid.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("txttopicid.Dock")));
			this.txttopicid.Enabled = ((bool)(resources.GetObject("txttopicid.Enabled")));
			this.txttopicid.Font = ((System.Drawing.Font)(resources.GetObject("txttopicid.Font")));
			this.helpProvider1.SetHelpKeyword(this.txttopicid, resources.GetString("txttopicid.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.txttopicid, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("txttopicid.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.txttopicid, resources.GetString("txttopicid.HelpString"));
			this.txttopicid.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("txttopicid.ImeMode")));
			this.txttopicid.Location = ((System.Drawing.Point)(resources.GetObject("txttopicid.Location")));
			this.txttopicid.MaxLength = ((int)(resources.GetObject("txttopicid.MaxLength")));
			this.txttopicid.Multiline = ((bool)(resources.GetObject("txttopicid.Multiline")));
			this.txttopicid.Name = "txttopicid";
			this.txttopicid.PasswordChar = ((char)(resources.GetObject("txttopicid.PasswordChar")));
			this.txttopicid.ReadOnly = true;
			this.txttopicid.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("txttopicid.RightToLeft")));
			this.txttopicid.ScrollBars = ((System.Windows.Forms.ScrollBars)(resources.GetObject("txttopicid.ScrollBars")));
			this.helpProvider1.SetShowHelp(this.txttopicid, ((bool)(resources.GetObject("txttopicid.ShowHelp"))));
			this.txttopicid.Size = ((System.Drawing.Size)(resources.GetObject("txttopicid.Size")));
			this.txttopicid.TabIndex = ((int)(resources.GetObject("txttopicid.TabIndex")));
			this.txttopicid.Text = resources.GetString("txttopicid.Text");
			this.txttopicid.TextAlign = ((System.Windows.Forms.HorizontalAlignment)(resources.GetObject("txttopicid.TextAlign")));
			this.txttopicid.Visible = ((bool)(resources.GetObject("txttopicid.Visible")));
			this.txttopicid.WordWrap = ((bool)(resources.GetObject("txttopicid.WordWrap")));
			// 
			// label2
			// 
			this.label2.AccessibleDescription = resources.GetString("label2.AccessibleDescription");
			this.label2.AccessibleName = resources.GetString("label2.AccessibleName");
			this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("label2.Anchor")));
			this.label2.AutoSize = ((bool)(resources.GetObject("label2.AutoSize")));
			this.label2.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("label2.Dock")));
			this.label2.Enabled = ((bool)(resources.GetObject("label2.Enabled")));
			this.label2.Font = ((System.Drawing.Font)(resources.GetObject("label2.Font")));
			this.helpProvider1.SetHelpKeyword(this.label2, resources.GetString("label2.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.label2, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("label2.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.label2, resources.GetString("label2.HelpString"));
			this.label2.Image = ((System.Drawing.Image)(resources.GetObject("label2.Image")));
			this.label2.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label2.ImageAlign")));
			this.label2.ImageIndex = ((int)(resources.GetObject("label2.ImageIndex")));
			this.label2.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("label2.ImeMode")));
			this.label2.Location = ((System.Drawing.Point)(resources.GetObject("label2.Location")));
			this.label2.Name = "label2";
			this.label2.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("label2.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.label2, ((bool)(resources.GetObject("label2.ShowHelp"))));
			this.label2.Size = ((System.Drawing.Size)(resources.GetObject("label2.Size")));
			this.label2.TabIndex = ((int)(resources.GetObject("label2.TabIndex")));
			this.label2.Text = resources.GetString("label2.Text");
			this.label2.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("label2.TextAlign")));
			this.label2.Visible = ((bool)(resources.GetObject("label2.Visible")));
			// 
			// tabPage3
			// 
			this.tabPage3.AccessibleDescription = resources.GetString("tabPage3.AccessibleDescription");
			this.tabPage3.AccessibleName = resources.GetString("tabPage3.AccessibleName");
			this.tabPage3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabPage3.Anchor")));
			this.tabPage3.AutoScroll = ((bool)(resources.GetObject("tabPage3.AutoScroll")));
			this.tabPage3.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("tabPage3.AutoScrollMargin")));
			this.tabPage3.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("tabPage3.AutoScrollMinSize")));
			this.tabPage3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabPage3.BackgroundImage")));
			this.tabPage3.Controls.Add(this.groupBoxRoles);
			this.tabPage3.Controls.Add(this.checkBox1);
			this.tabPage3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabPage3.Dock")));
			this.tabPage3.Enabled = ((bool)(resources.GetObject("tabPage3.Enabled")));
			this.tabPage3.Font = ((System.Drawing.Font)(resources.GetObject("tabPage3.Font")));
			this.helpProvider1.SetHelpKeyword(this.tabPage3, resources.GetString("tabPage3.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.tabPage3, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("tabPage3.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.tabPage3, resources.GetString("tabPage3.HelpString"));
			this.tabPage3.ImageIndex = ((int)(resources.GetObject("tabPage3.ImageIndex")));
			this.tabPage3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabPage3.ImeMode")));
			this.tabPage3.Location = ((System.Drawing.Point)(resources.GetObject("tabPage3.Location")));
			this.tabPage3.Name = "tabPage3";
			this.tabPage3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabPage3.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.tabPage3, ((bool)(resources.GetObject("tabPage3.ShowHelp"))));
			this.tabPage3.Size = ((System.Drawing.Size)(resources.GetObject("tabPage3.Size")));
			this.tabPage3.TabIndex = ((int)(resources.GetObject("tabPage3.TabIndex")));
			this.tabPage3.Text = resources.GetString("tabPage3.Text");
			this.tabPage3.ToolTipText = resources.GetString("tabPage3.ToolTipText");
			this.tabPage3.Visible = ((bool)(resources.GetObject("tabPage3.Visible")));
			// 
			// groupBoxRoles
			// 
			this.groupBoxRoles.AccessibleDescription = resources.GetString("groupBoxRoles.AccessibleDescription");
			this.groupBoxRoles.AccessibleName = resources.GetString("groupBoxRoles.AccessibleName");
			this.groupBoxRoles.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBoxRoles.Anchor")));
			this.groupBoxRoles.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBoxRoles.BackgroundImage")));
			this.groupBoxRoles.Controls.Add(this.comboBoxRole);
			this.groupBoxRoles.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBoxRoles.Dock")));
			this.groupBoxRoles.Enabled = ((bool)(resources.GetObject("groupBoxRoles.Enabled")));
			this.groupBoxRoles.Font = ((System.Drawing.Font)(resources.GetObject("groupBoxRoles.Font")));
			this.helpProvider1.SetHelpKeyword(this.groupBoxRoles, resources.GetString("groupBoxRoles.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.groupBoxRoles, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("groupBoxRoles.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.groupBoxRoles, resources.GetString("groupBoxRoles.HelpString"));
			this.groupBoxRoles.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBoxRoles.ImeMode")));
			this.groupBoxRoles.Location = ((System.Drawing.Point)(resources.GetObject("groupBoxRoles.Location")));
			this.groupBoxRoles.Name = "groupBoxRoles";
			this.groupBoxRoles.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBoxRoles.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.groupBoxRoles, ((bool)(resources.GetObject("groupBoxRoles.ShowHelp"))));
			this.groupBoxRoles.Size = ((System.Drawing.Size)(resources.GetObject("groupBoxRoles.Size")));
			this.groupBoxRoles.TabIndex = ((int)(resources.GetObject("groupBoxRoles.TabIndex")));
			this.groupBoxRoles.TabStop = false;
			this.groupBoxRoles.Text = resources.GetString("groupBoxRoles.Text");
			this.groupBoxRoles.Visible = ((bool)(resources.GetObject("groupBoxRoles.Visible")));
			// 
			// comboBoxRole
			// 
			this.comboBoxRole.AccessibleDescription = resources.GetString("comboBoxRole.AccessibleDescription");
			this.comboBoxRole.AccessibleName = resources.GetString("comboBoxRole.AccessibleName");
			this.comboBoxRole.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("comboBoxRole.Anchor")));
			this.comboBoxRole.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("comboBoxRole.BackgroundImage")));
			this.comboBoxRole.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("comboBoxRole.Dock")));
			this.comboBoxRole.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.comboBoxRole.Enabled = ((bool)(resources.GetObject("comboBoxRole.Enabled")));
			this.comboBoxRole.Font = ((System.Drawing.Font)(resources.GetObject("comboBoxRole.Font")));
			this.helpProvider1.SetHelpKeyword(this.comboBoxRole, resources.GetString("comboBoxRole.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.comboBoxRole, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("comboBoxRole.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.comboBoxRole, resources.GetString("comboBoxRole.HelpString"));
			this.comboBoxRole.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("comboBoxRole.ImeMode")));
			this.comboBoxRole.IntegralHeight = ((bool)(resources.GetObject("comboBoxRole.IntegralHeight")));
			this.comboBoxRole.ItemHeight = ((int)(resources.GetObject("comboBoxRole.ItemHeight")));
			this.comboBoxRole.Location = ((System.Drawing.Point)(resources.GetObject("comboBoxRole.Location")));
			this.comboBoxRole.MaxDropDownItems = ((int)(resources.GetObject("comboBoxRole.MaxDropDownItems")));
			this.comboBoxRole.MaxLength = ((int)(resources.GetObject("comboBoxRole.MaxLength")));
			this.comboBoxRole.Name = "comboBoxRole";
			this.comboBoxRole.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("comboBoxRole.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.comboBoxRole, ((bool)(resources.GetObject("comboBoxRole.ShowHelp"))));
			this.comboBoxRole.Size = ((System.Drawing.Size)(resources.GetObject("comboBoxRole.Size")));
			this.comboBoxRole.TabIndex = ((int)(resources.GetObject("comboBoxRole.TabIndex")));
			this.comboBoxRole.Text = resources.GetString("comboBoxRole.Text");
			this.comboBoxRole.Visible = ((bool)(resources.GetObject("comboBoxRole.Visible")));
			// 
			// checkBox1
			// 
			this.checkBox1.AccessibleDescription = resources.GetString("checkBox1.AccessibleDescription");
			this.checkBox1.AccessibleName = resources.GetString("checkBox1.AccessibleName");
			this.checkBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("checkBox1.Anchor")));
			this.checkBox1.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("checkBox1.Appearance")));
			this.checkBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("checkBox1.BackgroundImage")));
			this.checkBox1.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBox1.CheckAlign")));
			this.checkBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("checkBox1.Dock")));
			this.checkBox1.Enabled = ((bool)(resources.GetObject("checkBox1.Enabled")));
			this.checkBox1.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("checkBox1.FlatStyle")));
			this.checkBox1.Font = ((System.Drawing.Font)(resources.GetObject("checkBox1.Font")));
			this.helpProvider1.SetHelpKeyword(this.checkBox1, resources.GetString("checkBox1.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.checkBox1, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("checkBox1.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.checkBox1, resources.GetString("checkBox1.HelpString"));
			this.checkBox1.Image = ((System.Drawing.Image)(resources.GetObject("checkBox1.Image")));
			this.checkBox1.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBox1.ImageAlign")));
			this.checkBox1.ImageIndex = ((int)(resources.GetObject("checkBox1.ImageIndex")));
			this.checkBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("checkBox1.ImeMode")));
			this.checkBox1.Location = ((System.Drawing.Point)(resources.GetObject("checkBox1.Location")));
			this.checkBox1.Name = "checkBox1";
			this.checkBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("checkBox1.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.checkBox1, ((bool)(resources.GetObject("checkBox1.ShowHelp"))));
			this.checkBox1.Size = ((System.Drawing.Size)(resources.GetObject("checkBox1.Size")));
			this.checkBox1.TabIndex = ((int)(resources.GetObject("checkBox1.TabIndex")));
			this.checkBox1.Text = resources.GetString("checkBox1.Text");
			this.checkBox1.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("checkBox1.TextAlign")));
			this.checkBox1.Visible = ((bool)(resources.GetObject("checkBox1.Visible")));
			this.checkBox1.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
			// 
			// helpProvider1
			// 
			this.helpProvider1.HelpNamespace = resources.GetString("helpProvider1.HelpNamespace");
			// 
			// tabPage4
			// 
			this.tabPage4.AccessibleDescription = resources.GetString("tabPage4.AccessibleDescription");
			this.tabPage4.AccessibleName = resources.GetString("tabPage4.AccessibleName");
			this.tabPage4.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("tabPage4.Anchor")));
			this.tabPage4.AutoScroll = ((bool)(resources.GetObject("tabPage4.AutoScroll")));
			this.tabPage4.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("tabPage4.AutoScrollMargin")));
			this.tabPage4.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("tabPage4.AutoScrollMinSize")));
			this.tabPage4.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("tabPage4.BackgroundImage")));
			this.tabPage4.Controls.Add(this.groupBox3);
			this.tabPage4.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("tabPage4.Dock")));
			this.tabPage4.Enabled = ((bool)(resources.GetObject("tabPage4.Enabled")));
			this.tabPage4.Font = ((System.Drawing.Font)(resources.GetObject("tabPage4.Font")));
			this.helpProvider1.SetHelpKeyword(this.tabPage4, resources.GetString("tabPage4.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.tabPage4, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("tabPage4.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.tabPage4, resources.GetString("tabPage4.HelpString"));
			this.tabPage4.ImageIndex = ((int)(resources.GetObject("tabPage4.ImageIndex")));
			this.tabPage4.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("tabPage4.ImeMode")));
			this.tabPage4.Location = ((System.Drawing.Point)(resources.GetObject("tabPage4.Location")));
			this.tabPage4.Name = "tabPage4";
			this.tabPage4.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("tabPage4.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.tabPage4, ((bool)(resources.GetObject("tabPage4.ShowHelp"))));
			this.tabPage4.Size = ((System.Drawing.Size)(resources.GetObject("tabPage4.Size")));
			this.tabPage4.TabIndex = ((int)(resources.GetObject("tabPage4.TabIndex")));
			this.tabPage4.Text = resources.GetString("tabPage4.Text");
			this.tabPage4.ToolTipText = resources.GetString("tabPage4.ToolTipText");
			this.tabPage4.Visible = ((bool)(resources.GetObject("tabPage4.Visible")));
			// 
			// groupBox3
			// 
			this.groupBox3.AccessibleDescription = resources.GetString("groupBox3.AccessibleDescription");
			this.groupBox3.AccessibleName = resources.GetString("groupBox3.AccessibleName");
			this.groupBox3.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("groupBox3.Anchor")));
			this.groupBox3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox3.BackgroundImage")));
			this.groupBox3.Controls.Add(this.radioButtonWeb);
			this.groupBox3.Controls.Add(this.radioButtonOffice);
			this.groupBox3.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("groupBox3.Dock")));
			this.groupBox3.Enabled = ((bool)(resources.GetObject("groupBox3.Enabled")));
			this.groupBox3.Font = ((System.Drawing.Font)(resources.GetObject("groupBox3.Font")));
			this.helpProvider1.SetHelpKeyword(this.groupBox3, resources.GetString("groupBox3.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.groupBox3, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("groupBox3.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.groupBox3, resources.GetString("groupBox3.HelpString"));
			this.groupBox3.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("groupBox3.ImeMode")));
			this.groupBox3.Location = ((System.Drawing.Point)(resources.GetObject("groupBox3.Location")));
			this.groupBox3.Name = "groupBox3";
			this.groupBox3.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("groupBox3.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.groupBox3, ((bool)(resources.GetObject("groupBox3.ShowHelp"))));
			this.groupBox3.Size = ((System.Drawing.Size)(resources.GetObject("groupBox3.Size")));
			this.groupBox3.TabIndex = ((int)(resources.GetObject("groupBox3.TabIndex")));
			this.groupBox3.TabStop = false;
			this.groupBox3.Text = resources.GetString("groupBox3.Text");
			this.groupBox3.Visible = ((bool)(resources.GetObject("groupBox3.Visible")));
			// 
			// radioButtonWeb
			// 
			this.radioButtonWeb.AccessibleDescription = resources.GetString("radioButtonWeb.AccessibleDescription");
			this.radioButtonWeb.AccessibleName = resources.GetString("radioButtonWeb.AccessibleName");
			this.radioButtonWeb.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonWeb.Anchor")));
			this.radioButtonWeb.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonWeb.Appearance")));
			this.radioButtonWeb.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonWeb.BackgroundImage")));
			this.radioButtonWeb.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonWeb.CheckAlign")));
			this.radioButtonWeb.Checked = true;
			this.radioButtonWeb.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonWeb.Dock")));
			this.radioButtonWeb.Enabled = ((bool)(resources.GetObject("radioButtonWeb.Enabled")));
			this.radioButtonWeb.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonWeb.FlatStyle")));
			this.radioButtonWeb.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonWeb.Font")));
			this.helpProvider1.SetHelpKeyword(this.radioButtonWeb, resources.GetString("radioButtonWeb.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.radioButtonWeb, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("radioButtonWeb.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.radioButtonWeb, resources.GetString("radioButtonWeb.HelpString"));
			this.radioButtonWeb.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonWeb.Image")));
			this.radioButtonWeb.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonWeb.ImageAlign")));
			this.radioButtonWeb.ImageIndex = ((int)(resources.GetObject("radioButtonWeb.ImageIndex")));
			this.radioButtonWeb.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonWeb.ImeMode")));
			this.radioButtonWeb.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonWeb.Location")));
			this.radioButtonWeb.Name = "radioButtonWeb";
			this.radioButtonWeb.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonWeb.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.radioButtonWeb, ((bool)(resources.GetObject("radioButtonWeb.ShowHelp"))));
			this.radioButtonWeb.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonWeb.Size")));
			this.radioButtonWeb.TabIndex = ((int)(resources.GetObject("radioButtonWeb.TabIndex")));
			this.radioButtonWeb.TabStop = true;
			this.radioButtonWeb.Text = resources.GetString("radioButtonWeb.Text");
			this.radioButtonWeb.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonWeb.TextAlign")));
			this.radioButtonWeb.Visible = ((bool)(resources.GetObject("radioButtonWeb.Visible")));
			// 
			// radioButtonOffice
			// 
			this.radioButtonOffice.AccessibleDescription = resources.GetString("radioButtonOffice.AccessibleDescription");
			this.radioButtonOffice.AccessibleName = resources.GetString("radioButtonOffice.AccessibleName");
			this.radioButtonOffice.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("radioButtonOffice.Anchor")));
			this.radioButtonOffice.Appearance = ((System.Windows.Forms.Appearance)(resources.GetObject("radioButtonOffice.Appearance")));
			this.radioButtonOffice.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("radioButtonOffice.BackgroundImage")));
			this.radioButtonOffice.CheckAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonOffice.CheckAlign")));
			this.radioButtonOffice.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("radioButtonOffice.Dock")));
			this.radioButtonOffice.Enabled = ((bool)(resources.GetObject("radioButtonOffice.Enabled")));
			this.radioButtonOffice.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("radioButtonOffice.FlatStyle")));
			this.radioButtonOffice.Font = ((System.Drawing.Font)(resources.GetObject("radioButtonOffice.Font")));
			this.helpProvider1.SetHelpKeyword(this.radioButtonOffice, resources.GetString("radioButtonOffice.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this.radioButtonOffice, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("radioButtonOffice.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this.radioButtonOffice, resources.GetString("radioButtonOffice.HelpString"));
			this.radioButtonOffice.Image = ((System.Drawing.Image)(resources.GetObject("radioButtonOffice.Image")));
			this.radioButtonOffice.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonOffice.ImageAlign")));
			this.radioButtonOffice.ImageIndex = ((int)(resources.GetObject("radioButtonOffice.ImageIndex")));
			this.radioButtonOffice.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("radioButtonOffice.ImeMode")));
			this.radioButtonOffice.Location = ((System.Drawing.Point)(resources.GetObject("radioButtonOffice.Location")));
			this.radioButtonOffice.Name = "radioButtonOffice";
			this.radioButtonOffice.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("radioButtonOffice.RightToLeft")));
			this.helpProvider1.SetShowHelp(this.radioButtonOffice, ((bool)(resources.GetObject("radioButtonOffice.ShowHelp"))));
			this.radioButtonOffice.Size = ((System.Drawing.Size)(resources.GetObject("radioButtonOffice.Size")));
			this.radioButtonOffice.TabIndex = ((int)(resources.GetObject("radioButtonOffice.TabIndex")));
			this.radioButtonOffice.Text = resources.GetString("radioButtonOffice.Text");
			this.radioButtonOffice.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("radioButtonOffice.TextAlign")));
			this.radioButtonOffice.Visible = ((bool)(resources.GetObject("radioButtonOffice.Visible")));
			// 
			// FrmProp
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
			this.Controls.Add(this.tabControl1);
			this.Controls.Add(this.buttonPublicar);
			this.Controls.Add(this.buttonPeriodicidad);
			this.Controls.Add(this.buttonAceptar);
			this.Controls.Add(this.buttonCancelar);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.helpProvider1.SetHelpKeyword(this, resources.GetString("$this.HelpKeyword"));
			this.helpProvider1.SetHelpNavigator(this, ((System.Windows.Forms.HelpNavigator)(resources.GetObject("$this.HelpNavigator"))));
			this.helpProvider1.SetHelpString(this, resources.GetString("$this.HelpString"));
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximizeBox = false;
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimizeBox = false;
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmProp";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.helpProvider1.SetShowHelp(this, ((bool)(resources.GetObject("$this.ShowHelp"))));
			this.ShowInTaskbar = false;
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.tabControl1.ResumeLayout(false);
			this.tabPage1.ResumeLayout(false);
			this.groupBox1.ResumeLayout(false);
			this.tabPage2.ResumeLayout(false);
			this.groupBox2.ResumeLayout(false);
			this.tabPage3.ResumeLayout(false);
			this.groupBoxRoles.ResumeLayout(false);
			this.tabPage4.ResumeLayout(false);
			this.groupBox3.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void buttonCancelar_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void buttonAceptar_Click(object sender, System.EventArgs e)
		{
			
			
			if(this.txttitulo.Text.Equals(""))
			{
				MessageBox.Show(this,resources.GetString("FrmProp.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return;
			}
			if(this.txtDesc.Text.Equals(""))
			{
				MessageBox.Show(this,resources.GetString("FrmProp.msg2"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return;
			}
			if(!user.GetPermiso(this.topicmap,this.type))
			{
				//MessageBox.Show(this,resources.GetString("FrmProp.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				return;
			}
			
			if(this.radioSi.Checked) // verifica permiso sobre publicación y la revisión en Flujo
			{				
				Servicios s2=new Servicios(this.user);
				foreach(XmlElement eres in s2.getContentAtt(this.topicmap,this.topicid,this.idcont).GetElementsByTagName("Content"))
		    	{
					String status=eres.GetElementsByTagName("status")[0].InnerText;
					if(status=="1" || status=="3")
					{
						this.radioNo.Checked=true;
						MessageBox.Show(this,resources.GetString("FrmDocFlow.m3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  						
						return;
					}					
				}				
			}	
			Servicios sTopicInfo=new Servicios(this.user);
			System.Xml.XmlDocument doctopic=sTopicInfo.getTopicInfo(topicid,topicmap);
			if(doctopic.GetElementsByTagName("active").Count>0)
			{
				if(doctopic.GetElementsByTagName("active")[0].InnerText=="1" && this.radioButtonSeccionNo.Checked)
				{
					sTopicInfo=new Servicios(this.user);
					XmlDocument doc_permiso=sTopicInfo.haveAccess2Menu("WBAd_mnui_TopicActive");
					if(!(doc_permiso.GetElementsByTagName("haveAccess2Menu").Count>0 && doc_permiso.GetElementsByTagName("haveAccess2Menu")[0].InnerText=="true"))
					{
						// no tiene permiso de activar sección
						MessageBox.Show(this,resources.GetString("FrmProp.activeSection"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						return;
					}
				}
				if(doctopic.GetElementsByTagName("active")[0].InnerText=="0" && this.radioButtonSecccionSi.Checked)
				{
					sTopicInfo=new Servicios(this.user);
					XmlDocument doc_permiso=sTopicInfo.haveAccess2Menu("WBAd_mnui_TopicActive");
					if(!(doc_permiso.GetElementsByTagName("haveAccess2Menu").Count>0 && doc_permiso.GetElementsByTagName("haveAccess2Menu")[0].InnerText=="true"))
					{
						// no tiene permiso de activar sección
						MessageBox.Show(this,resources.GetString("FrmProp.activeSection"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						return;
					}
				}
			}
			Servicios smode=new Servicios(user);
			if(this.radioButtonWeb.Checked)
			{
				smode.changeMode(this.idcont,this.topicmap,this.topicid,"web");
			}
			else
			{
				smode.changeMode(this.idcont,this.topicmap,this.topicid,"office");
			}
			
			this.Cursor=Cursors.WaitCursor;
			Servicios s=new Servicios(user);
			String estadotopic="";
			if(this.radioButtonSecccionSi.Checked)
			{
				s.setStatusTopic(this.topicmap,this.topicid,"1");   
				estadotopic=resources.GetString("t8");
			}
			else
			{
				s.setStatusTopic(this.topicmap,this.topicid,"0");   
				estadotopic=resources.GetString("t9");
			}
			if(!s.IsError)
			{
				MessageBox.Show(this,resources.GetString("FrmProp.msg4") +" "+ estadotopic +"",this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
			}
			s=new Servicios(user);

			ParameterCollection parametros=new ParameterCollection(); 
			parametros.Add(new Parameter("id",this.idcont));
			parametros.Add(new Parameter("topicmap",this.topicmap));
			parametros.Add(new Parameter("topicid",this.topicid));
			parametros.Add(new Parameter("title",this.txttitulo.Text));
			parametros.Add(new Parameter("description",this.txtDesc.Text));
			if(this.checkBox1.Checked)
			{
				parametros.Add(new Parameter("isEditAble","1"));
				parametros.Add(new Parameter("EditRole",((Role)this.comboBoxRole.SelectedItem).id));
			}
			else
			{
				parametros.Add(new Parameter("isEditAble","0"));
			}
			s.updateProps(parametros); 
			if(!s.IsError)
			{
				MessageBox.Show(this,resources.GetString("FrmProp.msg5"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
				if(this.radioSi.Checked)
				{
					if(this.buttonPublicar.Visible==false)
					{
						Servicios s2=new Servicios(user);
						s2.changeStatusContentFromTopic(this.topicid,this.topicmap,this.idcont,"1");							
					}
					else
					{
						// no se puede activar
						this.Cursor=Cursors.Default;  	
						MessageBox.Show(this,resources.GetString("FrmProp.msg6"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error); 					
					}
					
				}
				else
				{
					Servicios s2=new Servicios(user);
					s2.changeStatusContentFromTopic(this.topicid,this.topicmap,this.idcont,"0");							
				}
			}		
			this.Cursor=Cursors.Default;
			this.Close();
		}
		
		private void buttonPeriodicidad_Click(object sender, System.EventArgs e)
		{
			if(!user.GetPermiso(this.topicmap,this.type))
			{				
				return;
			}
			this.Cursor=Cursors.WaitCursor;
			FrmListadoCalendarizacion frm=new FrmListadoCalendarizacion(this.topicmap,this.topicid,this.idcont,user); 
			this.Cursor=Cursors.Default;
			frm.ShowDialog(this);
		}

		private void buttonPublicar_Click(object sender, System.EventArgs e)
		{
			String message=null;
			//if(MessageBox.Show(this,resources.GetString("FrmProp.mandarmensaje"),resources.GetString("Global.title"),MessageBoxButtons.YesNo,MessageBoxIcon.Question)==DialogResult.Yes)
			//{
				FrmAutoriza frmAutoriza=new FrmAutoriza();
				frmAutoriza.label1.Visible=false;
				if(frmAutoriza.ShowDialog(this)==DialogResult.OK)
				{
					message=frmAutoriza.txtconment.Text;
				}
				
			//}
			Servicios s= new Servicios(user);
			String flowid=null,flowtopicmap=null;
			XmlDocument docflows=s.getFlowsToSendContent(this.topicmap,this.topicid,this.idcont);
			if(docflows.GetElementsByTagName("flow").Count==1)
			{
				flowid=((XmlElement)docflows.GetElementsByTagName("flow")[0]).GetAttribute("id");
				flowtopicmap=((XmlElement)docflows.GetElementsByTagName("flow")[0]).GetAttribute("topicmap");
				s= new Servicios(user);
				if(message==null)
				{
					s.sendContenttoAutorize(this.topicmap,this.topicid,this.idcont,flowid,flowtopicmap);
				}
				else
				{
					s.sendContenttoAutorize(this.topicmap,this.topicid,this.idcont,flowid,flowtopicmap,message);
				}
				if(!s.IsError)
				{
					MessageBox.Show(this,resources.GetString("FrmDocFlow.m4"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  				
					this.buttonPublicar.Visible=false; 
				}

			}
			else if(docflows.GetElementsByTagName("flow").Count>1)
			{
				FrmSelectFlow frm=new FrmSelectFlow(docflows);
				frm.ShowDialog(this);
				if(frm.DialogResult==DialogResult.OK)
				{
					CCaracteristica cflow=(CCaracteristica)frm.comboBox1.SelectedItem;
					flowid=cflow.Name;
					flowtopicmap=cflow.Valores[0].Name;
					s= new Servicios(user);
					if(message==null)
					{
						s.sendContenttoAutorize(this.topicmap,this.topicid,this.idcont,flowid,flowtopicmap);
					}
					else
					{
						s.sendContenttoAutorize(this.topicmap,this.topicid,this.idcont,flowid,flowtopicmap,message);
					}
					if(!s.IsError)
					{
						MessageBox.Show(this,resources.GetString("FrmDocFlow.m4"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  				
						this.buttonPublicar.Visible=false; 
					}
				}
			}			
		}
		/// <summary>
		/// Recarga información
		/// </summary>
		/// <param name="topicid">Identificador de sección</param>
		/// <param name="topicmap">Identificador de sitio</param>
		public void Recarga(String topicid,String topicmap)
		{
			this.topicid=topicid;
			this.topicmap=topicmap;
			this.txttopicid.Text=topicid; 
			Servicios s=new Servicios(user);			
			this.txttitletopic.Text=s.getTitleTopic(this.topicid,this.topicmap); 
			s=new Servicios(user);
			System.Xml.XmlDocument docversiones=s.getVersiones(); 
			this.txttitlesitio.Text=s.getTopicMapTitle(topicmap);			
			s=new Servicios(user);
			this.txtRuta.Text=user.Uri+ "wb/"+topicmap  +"/"+topicid;
			System.Xml.XmlDocument doctopic=s.getTopicInfo( topicid,topicmap);
			if(doctopic.GetElementsByTagName("active").Count>0)
			{
				if(doctopic.GetElementsByTagName("active")[0].InnerText=="1")
				{
					this.radioButtonSecccionSi.Checked=true;  
					this.radioButtonSeccionNo.Checked=false;  
				}
				else
				{
					this.radioButtonSeccionNo.Checked=true;  
					this.radioButtonSecccionSi.Checked=false;  
				}
			}
		}

		private void buttonMover_Click(object sender, System.EventArgs e)
		{
			this.Cursor=Cursors.WaitCursor;
			FrmMoverContenido frm=new FrmMoverContenido(this.topicid,this.topicmap,this.idcont,this,user,this.type);
			this.Cursor=Cursors.Default;
			frm.ShowDialog(this);
			if(frm.DialogResult==DialogResult.OK)
			{
				this.topicmap=frm.TopicMap;
				this.topicid=frm.Topic;
				this.idcont=frm.Content;
			}
		}

		private void buttonPreview_Click(object sender, System.EventArgs e)
		{
			try
			{
						
				System.Diagnostics.Process.Start("explorer.exe",this.txtRuta.Text);            
			}
			catch(System.Exception le)
			{
				MessageBox.Show(this,resources.GetString("FrmProp.msg8"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				System.Console.WriteLine(le.Message);  
			}
		}

		private void buttonTitle_Click(object sender, System.EventArgs e)
		{
			FrmTitles frm=new FrmTitles(this.topicid,this.topicmap,this.user,lang);
			frm.ShowDialog();
		}

		private void checkBox1_CheckedChanged(object sender, System.EventArgs e)
		{
			if(this.checkBox1.Checked)
			{
				this.groupBoxRoles.Enabled=true;
			}
			else
			{
				this.groupBoxRoles.Enabled=false;
			}
		}	
	}
	class Role
	{
		public string name;
		public string id;
		public override string ToString()
		{
			return name;
		}
	}
}
