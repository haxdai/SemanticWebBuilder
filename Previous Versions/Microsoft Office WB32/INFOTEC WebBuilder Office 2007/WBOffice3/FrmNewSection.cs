/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using WBOffice3;
using System.Windows.Forms;


namespace WBOffice3
{
	/// <summary>Forma Base del asistente para crear un contenido</summary>
	public class FrmNewSection : TSWizards.BaseWizard
	{
		private System.ComponentModel.IContainer components = null;
		/// <summary>Parametros que va coleccionando a trav�z de los diferentes pasos</summary>
		/// <value>Parametros que va coleccionando a trav�z de los diferentes pasos</value>
		public static ParameterCollection parametros=new ParameterCollection(); 				
		/// <summary>Resultados de la operaci�n de agregar una secci�n</summary>
		public static ParameterCollection resultados=new ParameterCollection(); 				
		/// <summary>Usuario que esta creando la secci�n</summary>
		public static CUserAdmin user;
		/// <summary>
		/// Constructor de forma para crear secci�n
		/// </summary>
		/// <param name="user">Uusario que va a crear la secci�n</param>
		public FrmNewSection(CUserAdmin user) 
		{
			// This call is required by the Windows Form Designer.
			InitializeComponent();

			// TODO: Add any initialization after the InitializeComponent call			
			FrmNewSection.user=user;
			parametros=new ParameterCollection(); 				
			resultados=new ParameterCollection(); 	
			System.Drawing.Bitmap image=new System.Drawing.Bitmap(69,64);
			image.MakeTransparent();
			this.Logo=image;
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FrmNewSection));
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
			// FrmNewSection
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
			this.Name = "FrmNewSection";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.SideBarImage = ((System.Drawing.Image)(resources.GetObject("$this.SideBarImage")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.LoadSteps += new System.EventHandler(this.FrmNewSection_LoadSteps);			
			this.ResumeLayout(false);

		}
		#endregion

		private void FrmNewSection_LoadSteps(object sender, System.EventArgs e)
		{
			this.Steps.Add("Step1",new New1());
			this.Steps.Add("Step2",new New2(this.next));
			this.Steps.Add("Step3",new New3());
			this.Steps.Add("Step4",new New4());
			this.Steps.Add("Step5",new New5());
			this.Steps.Add("Step6",new New6());
			this.Steps.Add("Step7",new New7());
		}
	}
}

