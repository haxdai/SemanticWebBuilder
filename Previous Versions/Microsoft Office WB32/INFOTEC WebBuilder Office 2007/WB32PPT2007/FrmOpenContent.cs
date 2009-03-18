/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using WBOffice3;
using System.Windows.Forms;


namespace WBPowerPoint
{
	/// <summary>Forma asistente de apertura de contenido</summary>
	public class FrmOpenContent : TSWizards.BaseWizard
	{
		private System.ComponentModel.IContainer components = null;
		/// <summary>Parametros para apertura de contenido</summary>
		/// <value>Parametros para apertura de contenido</value>
		public static ParameterCollection parametros=new ParameterCollection();
		/// <summary>Parametros de resultado de apertura</summary>
		/// <value>Parametros de resultado de apertura</value>		
		public static ParameterCollection resultados=new ParameterCollection(); 				
		/// <summary>Ruta de almacenamiento del documento</summary>
		/// <value>Ruta de almacenamiento del documento</value>
		public static String docpath=null;
		/// <summary>Crea una forma para asistente de apertura de contenido</summary>
		/// <param name="user">Usuario que va a abrir el contenido</param>
		public FrmOpenContent(CUserAdmin user) 
		{
			// This call is required by the Windows Form Designer.
			InitializeComponent();

			// TODO: Add any initialization after the InitializeComponent call
			
			parametros=new ParameterCollection(); 				
			resultados=new ParameterCollection(); 	
			docpath=null;
			System.Drawing.Bitmap image=new System.Drawing.Bitmap(69,64);
			image.MakeTransparent();
			this.Logo=image;
			this.SideBarLogo=image;
			foreach(Control c in  this.Controls)
			{
				
				if(c.Name.StartsWith("sideP"))
				{
					foreach(Control cl in  c.Controls)
					{
						
						if(cl.Name.StartsWith("sideLogo"))
						{
							PictureBox pb=(PictureBox)cl;
							cl.Visible=false;
						}
					}
				}
			}
		}
		
		/// <summary>
		/// Crea una forma para asistente de apertura de contenido
		/// </summary>
		/// <param name="parametros">Parametros para apertura</param>
		/// <param name="imagenes">Imagenes asociadas</param>
		/// <param name="user">Usuario</param>
		public FrmOpenContent(ParameterCollection parametros,ArrayList imagenes,CUserAdmin user) : this(user)
		{
			InitializeComponent();
			FrmNewContent.parametros=parametros;
			FrmNewContent.imagenes=imagenes;			
		}

		/// <summary>
		/// Clean up any resources being used.
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

		#region Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmOpenContent));
			this.SuspendLayout();
			// 
			// wizardTop
			// 
			this.wizardTop.BackColor = System.Drawing.Color.Transparent;
			this.wizardTop.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("wizardTop.BackgroundImage")));
			this.wizardTop.ForeColor = System.Drawing.Color.White;
			this.wizardTop.Name = "wizardTop";
			// 
			// cancel
			// 
			this.cancel.Name = "cancel";
			// 
			// back
			// 
			this.back.Name = "back";
			// 
			// next
			// 
			this.next.Name = "next";
			// 
			// panelStep
			// 
			this.panelStep.BackColor = System.Drawing.Color.White;
			this.panelStep.DockPadding.All = 8;
			this.panelStep.Location = ((System.Drawing.Point)(resources.GetObject("panelStep.Location")));
			this.panelStep.Name = "panelStep";
			this.panelStep.Size = ((System.Drawing.Size)(resources.GetObject("panelStep.Size")));
			// 
			// FrmOpenContent
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.ControlBox = false;
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.FirstStepName = "Step1";
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "FrmOpenContent";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.SideBarImage = ((System.Drawing.Image)(resources.GetObject("$this.SideBarImage")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.LoadSteps += new System.EventHandler(this.FrmOpenContent_LoadSteps);
			this.ResumeLayout(false);

		}
		#endregion

		private void FrmOpenContent_LoadSteps(object sender, System.EventArgs e)
		{
			this.Steps.Add("Step1",new OpenStep1());
			this.Steps.Add("Step2",new OpenStep2(this.next));
			this.Steps.Add("Step3",new OpenStep3());
			this.Steps.Add("Step4",new OpenStep4());
			this.Steps.Add("Step5",new OpenStep5());
			this.Steps.Add("Step6",new OpenStep6());
			this.Steps.Add("Step7",new OpenStep7());
		}
	}
}

