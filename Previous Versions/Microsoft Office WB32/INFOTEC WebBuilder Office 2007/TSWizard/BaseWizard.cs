using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Security.Permissions;
using System.Diagnostics;
using System.Reflection;
namespace TSWizards
{
	/// <summary>
	/// Summary description for BaseWizard.
	/// </summary>
	[DefaultEvent("LoadSteps")]
	//[System.ComponentModel.Designer(typeof(TSWizards.Designer.WizardDesigner))]
	public class BaseWizard : System.Windows.Forms.Form//, IWizardDesigner
	{
        
		// static objects to index into the Events object
		private static object backClicked = new object();
		private static object nextClicked = new object();
		private static object finishClicked = new object();
		private static object loadSteps = new object();
		private static object wizardLayoutChanged = new object();
		/// <summary>
		/// Logo por defecto
		/// </summary>
		protected static readonly Image DefaultLogo;
		/// <summary>
		/// Imagen de la barra lateral por defecto
		/// </summary>
		protected static readonly Image DefaultSideBarImage;
		/// <summary>
		/// Logo por defecto de la barra lateral
		/// </summary>
		protected static readonly Image DefaultSideBarLogo;
		private Color mbodyBackColor=Color.FromKnownColor(KnownColor.Control);
		static BaseWizard()
		{
            System.Resources.ResourceManager resources = new System.Resources.ResourceManager("TSWizards.BaseWizard", Assembly.GetExecutingAssembly());
            DefaultLogo=(Bitmap)resources.GetObject("wizard.bmp");
            DefaultSideBarLogo = (Bitmap)resources.GetObject("wizardSideLogo.jpg");
            DefaultSideBarImage = (Bitmap)resources.GetObject("wizardSide.jpg");

			//DefaultLogo = new Bitmap(typeof(BaseWizard), "wizard.bmp");
			//DefaultSideBarLogo = new Bitmap(typeof(BaseWizard), "wizardSideLogo.jpg");
			//DefaultSideBarImage = new Bitmap(typeof(BaseWizard), "wizardSide.jpg");
		}

		private Image imageLogo;
		private Image imageSideBarLogo;
		private Image imageSideBarImage;

		private BaseStep currentStep = null;
		private string firstStep = "";
		private WizardStepDictionary steps;
		private AllowClose allowClose = AllowClose.AlwaysAllow;
		/// <summary>
		/// Panel superior
		/// </summary>
		protected System.Windows.Forms.Panel wizardTop;
		private System.Windows.Forms.Label title;
		/// <summary>
		/// Boton de cancelar
		/// </summary>
		public System.Windows.Forms.Button cancel;
		/// <summary>
		/// Boton de regreso
		/// </summary>
		public System.Windows.Forms.Button back;
		/// <summary>
		/// Boton de siguiente
		/// </summary>
		public System.Windows.Forms.Button next;
		private System.Windows.Forms.PictureBox logo;
		private TSWizards.Controls.EtchedLine topLine;
		private TSWizards.Controls.EtchedLine bottomLine;
		private System.Windows.Forms.Label stepDescription;
		private PageLayout currentLayout = PageLayout.InteriorPage;
		private System.Windows.Forms.Panel bottomPanel;
		private System.Windows.Forms.Panel sidePanel;
		private System.Windows.Forms.PictureBox sideLogo;
		/// <summary>
		/// Panel de la página
		/// </summary>
		protected System.Windows.Forms.Panel panelStep;

		/// <summary>
		///		Tells which way we moved in the wizard
		/// </summary>
		public enum StepDirection
		{
			/// <summary>
			/// Paso incial
			/// </summary>
			InitialStep,
			/// <summary>
			/// Paso anterior
			/// </summary>
			PreviousStep,
			/// <summary>
			/// Siguiente paso
			/// </summary>
			NextStep,
			/// <summary>
			/// Saltar esta página
			/// </summary>
			Jump
		}

		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public BaseWizard()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			// Set initial values
			steps = new WizardStepDictionary();
			Logo = BaseWizard.DefaultLogo;
			SideBarLogo = BaseWizard.DefaultSideBarLogo;
			SideBarImage = BaseWizard.DefaultSideBarImage;
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(BaseWizard));
			this.wizardTop = new System.Windows.Forms.Panel();
			this.stepDescription = new System.Windows.Forms.Label();
			this.title = new System.Windows.Forms.Label();
			this.logo = new System.Windows.Forms.PictureBox();
			this.topLine = new TSWizards.Controls.EtchedLine();
			this.bottomLine = new TSWizards.Controls.EtchedLine();
			this.cancel = new System.Windows.Forms.Button();
			this.back = new System.Windows.Forms.Button();
			this.next = new System.Windows.Forms.Button();
			this.bottomPanel = new System.Windows.Forms.Panel();
			this.sidePanel = new System.Windows.Forms.Panel();
			this.sideLogo = new System.Windows.Forms.PictureBox();
			this.panelStep = new System.Windows.Forms.Panel();
			this.wizardTop.SuspendLayout();
			this.bottomPanel.SuspendLayout();
			this.sidePanel.SuspendLayout();
			this.SuspendLayout();
			// 
			// wizardTop
			// 
			this.wizardTop.AccessibleDescription = resources.GetString("wizardTop.AccessibleDescription");
			this.wizardTop.AccessibleName = resources.GetString("wizardTop.AccessibleName");
			this.wizardTop.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("wizardTop.Anchor")));
			this.wizardTop.AutoScroll = ((bool)(resources.GetObject("wizardTop.AutoScroll")));
			this.wizardTop.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("wizardTop.AutoScrollMargin")));
			this.wizardTop.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("wizardTop.AutoScrollMinSize")));
			this.wizardTop.BackColor = System.Drawing.Color.White;
			this.wizardTop.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("wizardTop.BackgroundImage")));
			this.wizardTop.Controls.Add(this.stepDescription);
			this.wizardTop.Controls.Add(this.title);
			this.wizardTop.Controls.Add(this.logo);
			this.wizardTop.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("wizardTop.Dock")));
			this.wizardTop.Enabled = ((bool)(resources.GetObject("wizardTop.Enabled")));
			this.wizardTop.Font = ((System.Drawing.Font)(resources.GetObject("wizardTop.Font")));
			this.wizardTop.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("wizardTop.ImeMode")));
			this.wizardTop.Location = ((System.Drawing.Point)(resources.GetObject("wizardTop.Location")));
			this.wizardTop.Name = "wizardTop";
			this.wizardTop.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("wizardTop.RightToLeft")));
			this.wizardTop.Size = ((System.Drawing.Size)(resources.GetObject("wizardTop.Size")));
			this.wizardTop.TabIndex = ((int)(resources.GetObject("wizardTop.TabIndex")));
			this.wizardTop.Text = resources.GetString("wizardTop.Text");
			this.wizardTop.Visible = ((bool)(resources.GetObject("wizardTop.Visible")));
			// 
			// stepDescription
			// 
			this.stepDescription.AccessibleDescription = resources.GetString("stepDescription.AccessibleDescription");
			this.stepDescription.AccessibleName = resources.GetString("stepDescription.AccessibleName");
			this.stepDescription.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("stepDescription.Anchor")));
			this.stepDescription.AutoSize = ((bool)(resources.GetObject("stepDescription.AutoSize")));
			this.stepDescription.BackColor = System.Drawing.Color.Transparent;
			this.stepDescription.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("stepDescription.Dock")));
			this.stepDescription.Enabled = ((bool)(resources.GetObject("stepDescription.Enabled")));
			this.stepDescription.Font = ((System.Drawing.Font)(resources.GetObject("stepDescription.Font")));
			this.stepDescription.Image = ((System.Drawing.Image)(resources.GetObject("stepDescription.Image")));
			this.stepDescription.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("stepDescription.ImageAlign")));
			this.stepDescription.ImageIndex = ((int)(resources.GetObject("stepDescription.ImageIndex")));
			this.stepDescription.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("stepDescription.ImeMode")));
			this.stepDescription.Location = ((System.Drawing.Point)(resources.GetObject("stepDescription.Location")));
			this.stepDescription.Name = "stepDescription";
			this.stepDescription.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("stepDescription.RightToLeft")));
			this.stepDescription.Size = ((System.Drawing.Size)(resources.GetObject("stepDescription.Size")));
			this.stepDescription.TabIndex = ((int)(resources.GetObject("stepDescription.TabIndex")));
			this.stepDescription.Text = resources.GetString("stepDescription.Text");
			this.stepDescription.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("stepDescription.TextAlign")));
			this.stepDescription.Visible = ((bool)(resources.GetObject("stepDescription.Visible")));
			// 
			// title
			// 
			this.title.AccessibleDescription = resources.GetString("title.AccessibleDescription");
			this.title.AccessibleName = resources.GetString("title.AccessibleName");
			this.title.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("title.Anchor")));
			this.title.AutoSize = ((bool)(resources.GetObject("title.AutoSize")));
			this.title.BackColor = System.Drawing.Color.Transparent;
			this.title.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("title.Dock")));
			this.title.Enabled = ((bool)(resources.GetObject("title.Enabled")));
			this.title.Font = ((System.Drawing.Font)(resources.GetObject("title.Font")));
			this.title.Image = ((System.Drawing.Image)(resources.GetObject("title.Image")));
			this.title.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("title.ImageAlign")));
			this.title.ImageIndex = ((int)(resources.GetObject("title.ImageIndex")));
			this.title.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("title.ImeMode")));
			this.title.Location = ((System.Drawing.Point)(resources.GetObject("title.Location")));
			this.title.Name = "title";
			this.title.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("title.RightToLeft")));
			this.title.Size = ((System.Drawing.Size)(resources.GetObject("title.Size")));
			this.title.TabIndex = ((int)(resources.GetObject("title.TabIndex")));
			this.title.Text = resources.GetString("title.Text");
			this.title.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("title.TextAlign")));
			this.title.Visible = ((bool)(resources.GetObject("title.Visible")));
			// 
			// logo
			// 
			this.logo.AccessibleDescription = resources.GetString("logo.AccessibleDescription");
			this.logo.AccessibleName = resources.GetString("logo.AccessibleName");
			this.logo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("logo.Anchor")));
			this.logo.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("logo.BackgroundImage")));
			this.logo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("logo.Dock")));
			this.logo.Enabled = ((bool)(resources.GetObject("logo.Enabled")));
			this.logo.Font = ((System.Drawing.Font)(resources.GetObject("logo.Font")));
			this.logo.Image = ((System.Drawing.Image)(resources.GetObject("logo.Image")));
			this.logo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("logo.ImeMode")));
			this.logo.Location = ((System.Drawing.Point)(resources.GetObject("logo.Location")));
			this.logo.Name = "logo";
			this.logo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("logo.RightToLeft")));
			this.logo.Size = ((System.Drawing.Size)(resources.GetObject("logo.Size")));
			this.logo.SizeMode = ((System.Windows.Forms.PictureBoxSizeMode)(resources.GetObject("logo.SizeMode")));
			this.logo.TabIndex = ((int)(resources.GetObject("logo.TabIndex")));
			this.logo.TabStop = false;
			this.logo.Text = resources.GetString("logo.Text");
			this.logo.Visible = ((bool)(resources.GetObject("logo.Visible")));
			// 
			// topLine
			// 
			this.topLine.AccessibleDescription = resources.GetString("topLine.AccessibleDescription");
			this.topLine.AccessibleName = resources.GetString("topLine.AccessibleName");
			this.topLine.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("topLine.Anchor")));
			this.topLine.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("topLine.BackgroundImage")));
			this.topLine.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("topLine.Dock")));
			this.topLine.Enabled = ((bool)(resources.GetObject("topLine.Enabled")));
			this.topLine.Font = ((System.Drawing.Font)(resources.GetObject("topLine.Font")));
			this.topLine.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("topLine.ImeMode")));
			this.topLine.Location = ((System.Drawing.Point)(resources.GetObject("topLine.Location")));
			this.topLine.Name = "topLine";
			this.topLine.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("topLine.RightToLeft")));
			this.topLine.Size = ((System.Drawing.Size)(resources.GetObject("topLine.Size")));
			this.topLine.TabIndex = ((int)(resources.GetObject("topLine.TabIndex")));
			this.topLine.Text = resources.GetString("topLine.Text");
			this.topLine.Visible = ((bool)(resources.GetObject("topLine.Visible")));
			// 
			// bottomLine
			// 
			this.bottomLine.AccessibleDescription = resources.GetString("bottomLine.AccessibleDescription");
			this.bottomLine.AccessibleName = resources.GetString("bottomLine.AccessibleName");
			this.bottomLine.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("bottomLine.Anchor")));
			this.bottomLine.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bottomLine.BackgroundImage")));
			this.bottomLine.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("bottomLine.Dock")));
			this.bottomLine.Enabled = ((bool)(resources.GetObject("bottomLine.Enabled")));
			this.bottomLine.Font = ((System.Drawing.Font)(resources.GetObject("bottomLine.Font")));
			this.bottomLine.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("bottomLine.ImeMode")));
			this.bottomLine.Location = ((System.Drawing.Point)(resources.GetObject("bottomLine.Location")));
			this.bottomLine.Name = "bottomLine";
			this.bottomLine.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("bottomLine.RightToLeft")));
			this.bottomLine.Size = ((System.Drawing.Size)(resources.GetObject("bottomLine.Size")));
			this.bottomLine.TabIndex = ((int)(resources.GetObject("bottomLine.TabIndex")));
			this.bottomLine.Text = resources.GetString("bottomLine.Text");
			this.bottomLine.Visible = ((bool)(resources.GetObject("bottomLine.Visible")));
			// 
			// cancel
			// 
			this.cancel.AccessibleDescription = resources.GetString("cancel.AccessibleDescription");
			this.cancel.AccessibleName = resources.GetString("cancel.AccessibleName");
			this.cancel.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("cancel.Anchor")));
			this.cancel.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("cancel.BackgroundImage")));
			this.cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.cancel.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("cancel.Dock")));
			this.cancel.Enabled = ((bool)(resources.GetObject("cancel.Enabled")));
			this.cancel.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("cancel.FlatStyle")));
			this.cancel.Font = ((System.Drawing.Font)(resources.GetObject("cancel.Font")));
			this.cancel.Image = ((System.Drawing.Image)(resources.GetObject("cancel.Image")));
			this.cancel.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("cancel.ImageAlign")));
			this.cancel.ImageIndex = ((int)(resources.GetObject("cancel.ImageIndex")));
			this.cancel.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("cancel.ImeMode")));
			this.cancel.Location = ((System.Drawing.Point)(resources.GetObject("cancel.Location")));
			this.cancel.Name = "cancel";
			this.cancel.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("cancel.RightToLeft")));
			this.cancel.Size = ((System.Drawing.Size)(resources.GetObject("cancel.Size")));
			this.cancel.TabIndex = ((int)(resources.GetObject("cancel.TabIndex")));
			this.cancel.Text = resources.GetString("cancel.Text");
			this.cancel.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("cancel.TextAlign")));
			this.cancel.Visible = ((bool)(resources.GetObject("cancel.Visible")));
			this.cancel.Click += new System.EventHandler(this.cancel_Click);
			// 
			// back
			// 
			this.back.AccessibleDescription = resources.GetString("back.AccessibleDescription");
			this.back.AccessibleName = resources.GetString("back.AccessibleName");
			this.back.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("back.Anchor")));
			this.back.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("back.BackgroundImage")));
			this.back.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("back.Dock")));
			this.back.Enabled = ((bool)(resources.GetObject("back.Enabled")));
			this.back.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("back.FlatStyle")));
			this.back.Font = ((System.Drawing.Font)(resources.GetObject("back.Font")));
			this.back.Image = ((System.Drawing.Image)(resources.GetObject("back.Image")));
			this.back.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("back.ImageAlign")));
			this.back.ImageIndex = ((int)(resources.GetObject("back.ImageIndex")));
			this.back.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("back.ImeMode")));
			this.back.Location = ((System.Drawing.Point)(resources.GetObject("back.Location")));
			this.back.Name = "back";
			this.back.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("back.RightToLeft")));
			this.back.Size = ((System.Drawing.Size)(resources.GetObject("back.Size")));
			this.back.TabIndex = ((int)(resources.GetObject("back.TabIndex")));
			this.back.Text = resources.GetString("back.Text");
			this.back.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("back.TextAlign")));
			this.back.Visible = ((bool)(resources.GetObject("back.Visible")));
			this.back.Click += new System.EventHandler(this.back_Click);
			// 
			// next
			// 
			this.next.AccessibleDescription = resources.GetString("next.AccessibleDescription");
			this.next.AccessibleName = resources.GetString("next.AccessibleName");
			this.next.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("next.Anchor")));
			this.next.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("next.BackgroundImage")));
			this.next.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("next.Dock")));
			this.next.Enabled = ((bool)(resources.GetObject("next.Enabled")));
			this.next.FlatStyle = ((System.Windows.Forms.FlatStyle)(resources.GetObject("next.FlatStyle")));
			this.next.Font = ((System.Drawing.Font)(resources.GetObject("next.Font")));
			this.next.Image = ((System.Drawing.Image)(resources.GetObject("next.Image")));
			this.next.ImageAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("next.ImageAlign")));
			this.next.ImageIndex = ((int)(resources.GetObject("next.ImageIndex")));
			this.next.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("next.ImeMode")));
			this.next.Location = ((System.Drawing.Point)(resources.GetObject("next.Location")));
			this.next.Name = "next";
			this.next.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("next.RightToLeft")));
			this.next.Size = ((System.Drawing.Size)(resources.GetObject("next.Size")));
			this.next.TabIndex = ((int)(resources.GetObject("next.TabIndex")));
			this.next.Text = resources.GetString("next.Text");
			this.next.TextAlign = ((System.Drawing.ContentAlignment)(resources.GetObject("next.TextAlign")));
			this.next.Visible = ((bool)(resources.GetObject("next.Visible")));
			this.next.Click += new System.EventHandler(this.next_Click);
			// 
			// bottomPanel
			// 
			this.bottomPanel.AccessibleDescription = resources.GetString("bottomPanel.AccessibleDescription");
			this.bottomPanel.AccessibleName = resources.GetString("bottomPanel.AccessibleName");
			this.bottomPanel.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("bottomPanel.Anchor")));
			this.bottomPanel.AutoScroll = ((bool)(resources.GetObject("bottomPanel.AutoScroll")));
			this.bottomPanel.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("bottomPanel.AutoScrollMargin")));
			this.bottomPanel.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("bottomPanel.AutoScrollMinSize")));
			this.bottomPanel.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bottomPanel.BackgroundImage")));
			this.bottomPanel.Controls.Add(this.bottomLine);
			this.bottomPanel.Controls.Add(this.cancel);
			this.bottomPanel.Controls.Add(this.back);
			this.bottomPanel.Controls.Add(this.next);
			this.bottomPanel.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("bottomPanel.Dock")));
			this.bottomPanel.Enabled = ((bool)(resources.GetObject("bottomPanel.Enabled")));
			this.bottomPanel.Font = ((System.Drawing.Font)(resources.GetObject("bottomPanel.Font")));
			this.bottomPanel.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("bottomPanel.ImeMode")));
			this.bottomPanel.Location = ((System.Drawing.Point)(resources.GetObject("bottomPanel.Location")));
			this.bottomPanel.Name = "bottomPanel";
			this.bottomPanel.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("bottomPanel.RightToLeft")));
			this.bottomPanel.Size = ((System.Drawing.Size)(resources.GetObject("bottomPanel.Size")));
			this.bottomPanel.TabIndex = ((int)(resources.GetObject("bottomPanel.TabIndex")));
			this.bottomPanel.Text = resources.GetString("bottomPanel.Text");
			this.bottomPanel.Visible = ((bool)(resources.GetObject("bottomPanel.Visible")));
			// 
			// sidePanel
			// 
			this.sidePanel.AccessibleDescription = resources.GetString("sidePanel.AccessibleDescription");
			this.sidePanel.AccessibleName = resources.GetString("sidePanel.AccessibleName");
			this.sidePanel.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("sidePanel.Anchor")));
			this.sidePanel.AutoScroll = ((bool)(resources.GetObject("sidePanel.AutoScroll")));
			this.sidePanel.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("sidePanel.AutoScrollMargin")));
			this.sidePanel.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("sidePanel.AutoScrollMinSize")));
			this.sidePanel.BackColor = System.Drawing.Color.White;
			this.sidePanel.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("sidePanel.BackgroundImage")));
			this.sidePanel.Controls.Add(this.sideLogo);
			this.sidePanel.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("sidePanel.Dock")));
			this.sidePanel.Enabled = ((bool)(resources.GetObject("sidePanel.Enabled")));
			this.sidePanel.Font = ((System.Drawing.Font)(resources.GetObject("sidePanel.Font")));
			this.sidePanel.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("sidePanel.ImeMode")));
			this.sidePanel.Location = ((System.Drawing.Point)(resources.GetObject("sidePanel.Location")));
			this.sidePanel.Name = "sidePanel";
			this.sidePanel.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("sidePanel.RightToLeft")));
			this.sidePanel.Size = ((System.Drawing.Size)(resources.GetObject("sidePanel.Size")));
			this.sidePanel.TabIndex = ((int)(resources.GetObject("sidePanel.TabIndex")));
			this.sidePanel.Text = resources.GetString("sidePanel.Text");
			this.sidePanel.Visible = ((bool)(resources.GetObject("sidePanel.Visible")));
			// 
			// sideLogo
			// 
			this.sideLogo.AccessibleDescription = resources.GetString("sideLogo.AccessibleDescription");
			this.sideLogo.AccessibleName = resources.GetString("sideLogo.AccessibleName");
			this.sideLogo.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("sideLogo.Anchor")));
			this.sideLogo.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("sideLogo.BackgroundImage")));
			this.sideLogo.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.sideLogo.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("sideLogo.Dock")));
			this.sideLogo.Enabled = ((bool)(resources.GetObject("sideLogo.Enabled")));
			this.sideLogo.Font = ((System.Drawing.Font)(resources.GetObject("sideLogo.Font")));
			this.sideLogo.Image = ((System.Drawing.Image)(resources.GetObject("sideLogo.Image")));
			this.sideLogo.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("sideLogo.ImeMode")));
			this.sideLogo.Location = ((System.Drawing.Point)(resources.GetObject("sideLogo.Location")));
			this.sideLogo.Name = "sideLogo";
			this.sideLogo.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("sideLogo.RightToLeft")));
			this.sideLogo.Size = ((System.Drawing.Size)(resources.GetObject("sideLogo.Size")));
			this.sideLogo.SizeMode = ((System.Windows.Forms.PictureBoxSizeMode)(resources.GetObject("sideLogo.SizeMode")));
			this.sideLogo.TabIndex = ((int)(resources.GetObject("sideLogo.TabIndex")));
			this.sideLogo.TabStop = false;
			this.sideLogo.Text = resources.GetString("sideLogo.Text");
			this.sideLogo.Visible = ((bool)(resources.GetObject("sideLogo.Visible")));
			// 
			// panelStep
			// 
			this.panelStep.AccessibleDescription = resources.GetString("panelStep.AccessibleDescription");
			this.panelStep.AccessibleName = resources.GetString("panelStep.AccessibleName");
			this.panelStep.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("panelStep.Anchor")));
			this.panelStep.AutoScroll = ((bool)(resources.GetObject("panelStep.AutoScroll")));
			this.panelStep.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("panelStep.AutoScrollMargin")));
			this.panelStep.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("panelStep.AutoScrollMinSize")));
			this.panelStep.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panelStep.BackgroundImage")));
			this.panelStep.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("panelStep.Dock")));
			this.panelStep.DockPadding.All = 8;
			this.panelStep.Enabled = ((bool)(resources.GetObject("panelStep.Enabled")));
			this.panelStep.Font = ((System.Drawing.Font)(resources.GetObject("panelStep.Font")));
			this.panelStep.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("panelStep.ImeMode")));
			this.panelStep.Location = ((System.Drawing.Point)(resources.GetObject("panelStep.Location")));
			this.panelStep.Name = "panelStep";
			this.panelStep.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("panelStep.RightToLeft")));
			this.panelStep.Size = ((System.Drawing.Size)(resources.GetObject("panelStep.Size")));
			this.panelStep.TabIndex = ((int)(resources.GetObject("panelStep.TabIndex")));
			this.panelStep.Text = resources.GetString("panelStep.Text");
			this.panelStep.Visible = ((bool)(resources.GetObject("panelStep.Visible")));
			// 
			// BaseWizard
			// 
			this.AcceptButton = this.next;
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScaleBaseSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScaleBaseSize")));
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.CancelButton = this.cancel;
			this.ClientSize = ((System.Drawing.Size)(resources.GetObject("$this.ClientSize")));
			this.Controls.Add(this.panelStep);
			this.Controls.Add(this.sidePanel);
			this.Controls.Add(this.bottomPanel);
			this.Controls.Add(this.topLine);
			this.Controls.Add(this.wizardTop);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.MaximumSize = ((System.Drawing.Size)(resources.GetObject("$this.MaximumSize")));
			this.MinimumSize = ((System.Drawing.Size)(resources.GetObject("$this.MinimumSize")));
			this.Name = "BaseWizard";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.StartPosition = ((System.Windows.Forms.FormStartPosition)(resources.GetObject("$this.StartPosition")));
			this.Text = resources.GetString("$this.Text");
			this.wizardTop.ResumeLayout(false);
			this.bottomPanel.ResumeLayout(false);
			this.sidePanel.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		#region Public Properties
		
		#region BodyBackColor
		/// <summary>
		/// Color de fondo del asistente
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[DefaultValue(KnownColor.Control)]
		public Color BodyBackColor
		{
			get
			{
				return mbodyBackColor;
			}
			set
			{
				mbodyBackColor=value;
				this.BackColor=this.BodyBackColor;
			}
		}
		#endregion

		#region Title
		/// <summary>
		/// Titulo del asistente
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets the text that is displayed in the white area next to the logo")]
		[DefaultValue("Step Title")]
		public string Title
		{
			get
			{
				return title.Text;
			}
			set
			{
				title.Text = value;
			}
		}
		#endregion

		#region Logo
		/// <summary>
		/// Logo a mostrar en el asistente
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets the image that is displayed in the upper-right corner of the wizard")]
		[DefaultValue(typeof(Image), "TSWizards.wizard.bmp")]
		public Image Logo
		{
			get
			{
				return imageLogo;
			}
			set
			{
				imageLogo = value;

				OnLogoChanged(null, EventArgs.Empty);
			}
		}
		#endregion

		#region SideBarLogo
		/// <summary>
		/// Logo en la barra lateral
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets the image that is displayed along the left side of the wizard, seen only on Exterior pages")]
		[DefaultValue(typeof(Image), "TSWizards.wizardSideLogo.jpg")]
		public Image SideBarLogo
		{
			get
			{
				return imageSideBarLogo;
			}
			set
			{
				imageSideBarLogo = value;

				OnSideBarLogoChanged(null, EventArgs.Empty);
			}
		}
		#endregion

		#region SideBarImage
		/// <summary>
		/// Imagen en la barra lateral
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets the image that is displayed along the left side of the wizard, seen only on Exterior pages")]
		[DefaultValue(typeof(Image), "TSWizards.wizardSide.jpg")]
		public Image SideBarImage
		{
			get
			{
				return imageSideBarImage;
			}
			set
			{
				imageSideBarImage = value;

				OnSideBarImageChanged(null, EventArgs.Empty);
			}
		}
		#endregion

		#region BackEnabled
		/// <summary>
		/// Determina si el boton de anterior debe estar habilitado
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets whether the back button will be enabled")]
		[DefaultValue(true)]
		public bool BackEnabled
		{
			get
			{
				return back.Enabled;
			}
			set
			{
				back.Enabled = value;
			}
		}
		#endregion

		#region NextEnabled
		/// <summary>
		/// Determina si el siguiente de anterior debe estar habilitado
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets whether the next button will be enabled")]
		[DefaultValue(true)]
		public bool NextEnabled
		{
			get
			{
				return next.Enabled;
			}
			set
			{
				next.Enabled = value;
			}
		}
		#endregion

		#region FirstStepName
		/// <summary>
		/// Determina el nombre de la primera pagina del asistente
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets the name of the first step of the wizard")]
		[DefaultValue("")]
		public virtual string FirstStepName
		{
			get
			{
				return firstStep;
			}
			set
			{
				if( value == null )
				{
					value = "";
				}

				firstStep = value;
			}
		}
		#endregion

		#region AllowClose

		/// <summary>
		/// Determina si permite cerrar el assitente
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Gets/Sets the kind of closing allowed")]
		[DefaultValue(AllowClose.AlwaysAllow)]
		public AllowClose AllowClose
		{
			get
			{
				return allowClose;
			}
			set
			{
				allowClose = value;
			}
		}
		#endregion

		#region PageLayout
		/// <summary>
		/// Regresa el layout del asistente
		/// </summary>
		[Browsable(true)]
		[Category("Design")]
		[Description("Allows you to switch the design-time view from page layout to another")]
		[DesignerSerializationVisibility(DesignerSerializationVisibility.Hidden)]
		public PageLayout PageLayout
		{
			get
			{
				return currentLayout;
			}
			set
			{
				if( !DesignMode )
					return ;
				currentLayout = value;

				UpdateLayout(currentLayout);
			}
		}
		#endregion

		#endregion

		#region Public Methods

		#region Step Movement

		#region MoveNext
		/// <summary>
		/// Moves to the next step in the wizard
		/// </summary>
		public void MoveNext()
		{
			if( currentStep != null )
			{
				SetCurrentStep(currentStep.NextStep, StepDirection.NextStep);
			}
		}
		#endregion

		#region MoveBack
		/// <summary>
		/// Moves to the previous step in the wizard
		/// </summary>
		public void MoveBack()
		{
			if( currentStep != null )
			{
				SetCurrentStep(currentStep.PreviousStep, StepDirection.PreviousStep);
			}
		}
		#endregion

		#region MoveTo
		/// <summary>
		/// Moves to the specified step in the wizard
		/// </summary>
		public void MoveTo(string step)
		{
			SetCurrentStep(step, StepDirection.Jump);
		}
		#endregion

		#endregion

		#region AddStep
		/// <summary>
		/// Adds a step to the wizard
		/// </summary>
		/// <param name="name">The name of the step, this will be used as the name to look for in the PreviousStep and NextStep properties of the step</param>
		/// <param name="step">The step object to add</param>
		public void AddStep(string name, BaseStep step)
		{
			Steps[name] = step;
		}
		#endregion

		#region GetStep
		/// <summary>
		/// Returns the step named 'name'
		/// </summary>
		/// <param name="name">The name of the step to return</param>
		/// <returns>The step retrieved</returns>
		public BaseStep GetStep(string name)
		{
			return Steps[name];
		}
		#endregion

		#region RemoveStep
		/// <summary>
		/// Removes a step from the wizard
		/// </summary>
		/// <param name="name">The name of the step to remove</param>
		/// <returns>The step removed, returns null if no step by that name was in the list of steps</returns>
		public BaseStep RemoveStep(string name)
		{
			BaseStep step = Steps[name];

			if( step != null )
			{
				Steps.Remove(name);
			}

			return step;
		}
		#endregion

		#region ResetSteps
		/// <summary>
		/// Fires the ResetStep event on all steps in the wizard
		/// This is used to reset all steps to their initial values
		/// </summary>
		public void ResetSteps()
		{
			WizardStepDictionary.WizardStepDictionaryEnumerator wsce = Steps.GetEnumerator();

			while(wsce.MoveNext())
			{
				wsce.Value.FireResetStepEvent();
			}
		}
		#endregion

		#region SetCurrentStep & Logic

		#region SetCurrentStep(string step, StepDirection dir)
		/// <summary>
		/// Determina cual es la pagina que se esta mostrando
		/// </summary>
		/// <param name="name">Nombre de la página</param>
		/// <param name="dir">Dirección de la página</param>
		public void SetCurrentStep(string name, StepDirection dir)
		{
			if( name == null || name == "" )
			{
				throw new ArgumentException("Step is null or empty", "step");
			}

			BaseStep bws = steps[name];

			if( bws == null )
			{
				throw new ArgumentException("Step does not contain the name of a step in the wizard", "name");
			}

			SetCurrentStep(bws, dir);
		}
		#endregion

		#region SetCurrentStep(BaseStep, StepDirection dir)
		/// <summary>
		/// Determina cual es la pagina que se esta mostrando
		/// </summary>
		/// <param name="step">Página</param>
		/// <param name="dir">Dirección de la página</param>
		protected void SetCurrentStep(BaseStep step, StepDirection dir)
		{
			SuspendLayout();

			try
			{
				if( currentStep != null )
				{
					DetatchStep();
				}

				currentStep = step;
			
				AttachStep(dir);
			}
			finally
			{
				ResumeLayout(true);
			}
		}
		#endregion

		#region DetatchStep
		private void DetatchStep()
		{
			// Remove event handlers
			currentStep.StepTitleChanged -= new EventHandler(OnStepTitleChanged);
			currentStep.StepDescriptionChanged -= new EventHandler(OnStepDescriptionChanged);
			currentStep.NextStepChanged -= new EventHandler(OnNextStepChanged);
			currentStep.PreviousStepChanged -= new EventHandler(OnPreviousStepChanged);
			currentStep.PageLayoutChanged -= new EventHandler(OnPageLayoutChanged);
			currentStep.LogoChanged -= new EventHandler(OnLogoChanged);
			currentStep.SideBarLogoChanged -= new EventHandler(OnSideBarLogoChanged);
			currentStep.SideBarImageChanged -= new EventHandler(OnSideBarImageChanged);

			// Remove the step from the panel so it will no longer be shown
			panelStep.Controls.Remove(currentStep);
			
			// Unset the Wizard property
			currentStep.Wizard = null;
		}
		#endregion

		#region AttachStep
		private void AttachStep(StepDirection direction)
		{
			// Set its Wizard property
			currentStep.Wizard = this;

			// Add event handlers
			currentStep.StepTitleChanged += new EventHandler(OnStepTitleChanged);
			currentStep.StepDescriptionChanged += new EventHandler(OnStepDescriptionChanged);
			currentStep.NextStepChanged += new EventHandler(OnNextStepChanged);
			currentStep.PreviousStepChanged += new EventHandler(OnPreviousStepChanged);
			currentStep.PageLayoutChanged += new EventHandler(OnPageLayoutChanged);
			currentStep.LogoChanged += new EventHandler(OnLogoChanged);
			currentStep.SideBarLogoChanged += new EventHandler(OnSideBarLogoChanged);
			currentStep.SideBarImageChanged += new EventHandler(OnSideBarImageChanged);
			
			// Update the title
			OnStepTitleChanged(null, EventArgs.Empty);
			OnStepDescriptionChanged(null, EventArgs.Empty);

			// Show the step
			currentStep.Dock = DockStyle.Fill;
			panelStep.Controls.Add(currentStep);

			// Update the buttons
			OnPreviousStepChanged(null, EventArgs.Empty);
			OnNextStepChanged(null, EventArgs.Empty);

			// Update wizard layout
			OnPageLayoutChanged(null, EventArgs.Empty);

			// Update logos if neccessary
			OnLogoChanged(null, EventArgs.Empty);
			OnSideBarLogoChanged(null, EventArgs.Empty);
			OnSideBarImageChanged(null, EventArgs.Empty);

			currentStep.FireShowEvent(new ShowStepEventArgs(direction));
		}
		#endregion

		#endregion

		#endregion

		#region Protected properties
		
		#region Steps
		/// <summary>
		/// Regresa todas las paginas definidas en el asistente
		/// </summary>
		[Browsable(false)]
		protected WizardStepDictionary Steps
		{
			get
			{
				return steps;
			}
		}
		#endregion

		#region IsFinish
		/// <summary>
		/// Determina si la pagina es final
		/// </summary>
		[Browsable(false)]
		protected bool IsFinish
		{
			get
			{
				return currentStep.NextStep == BaseStep.FinishStep;
			}
		}
		#endregion

		#endregion

		#region Event Handlers

		#region OnStepTitleChanged
		/// <summary>
		/// Handles the StepTitleChanged event on each step
		/// </summary>
		/// <param name="o">The step that changed the title, null if called outside of the event handler context</param>
		/// <param name="e">The arguments for the event, should be EventArgs.Empty</param>
		private void OnStepTitleChanged(object o, EventArgs e)
		{
			Title = currentStep.StepTitle;
		}
		#endregion

		#region OnStepDescriptionChanged
		/// <summary>
		/// Handles the StepDescriptionChanged event on each step
		/// </summary>
		/// <param name="o">The step that changed the description, null if called outside of the event handler context</param>
		/// <param name="e">The arguments for the event, should be EventArgs.Empty</param>
		private void OnStepDescriptionChanged(object o, EventArgs e)
		{
			stepDescription.Text = currentStep.StepDescription;
		}
		#endregion

		#region back_Click - Back button clicked
		/// <summary>
		/// Handles the clicking of the back button
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void back_Click(object sender, System.EventArgs e)
		{
			OnBackClicked(EventArgs.Empty);
		}
		#endregion

		#region next_Click - Next button clicked
		// Handles the clicking of the next button
		private void next_Click(object sender, System.EventArgs e)
		{
			if( !IsFinish )
			{
				OnNextClicked(EventArgs.Empty);
			}
			else
			{
				OnFinishClicked(EventArgs.Empty);
			}
		}
		#endregion

		#region cancel_Click - Cancel button clicked
		// Handles the clicking of the next button
		private void cancel_Click(object sender, System.EventArgs e)
		{
			DialogResult = DialogResult.Cancel;

			if( !Modal )
			{
				Close();
			}
		}
		#endregion

		#region OnLoad
		/// <summary>
		/// Carga todas las paginas del asistente
		/// </summary>
		/// <param name="e"></param>
		
		protected override void OnLoad(System.EventArgs e)
		{
			base.OnLoad(e);

			if( !DesignMode )
			{
				OnLoadSteps(EventArgs.Empty);
			
				if( FirstStepName == "" )
					throw new InvalidOperationException("FirstStepName must be be a non-empty string.");

				ResetSteps();

				SetCurrentStep(FirstStepName, StepDirection.InitialStep);
			}
			else
			{
				UpdateLayout(currentLayout);
			}

			UIPermission uiP = new UIPermission(UIPermissionWindow.AllWindows);
			uiP.Demand();
		}
		#endregion

		#region OnClosing
		/// <summary>
		/// Evento de cerrado de asistente
		/// </summary>
		/// <param name="e"></param>
		protected override void OnClosing(System.ComponentModel.CancelEventArgs e)
		{
			if( DialogResult == DialogResult.Cancel )
			{
				switch( AllowClose )
				{					
					case AllowClose.Ask:
						e.Cancel = !AskToClose();
						break;
				}
			}
		}

		private bool AskToClose()
		{
			DialogResult r = MessageBox.Show("Do you wish to quit the wizard now?\r\nYour changes won't be saved if you do", "Exit wizard?", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

			if(r == DialogResult.Yes)
				return true;
			else
				return false;
		}
		#endregion

		#region OnPreviousStepChanged
		private void OnPreviousStepChanged(object sender, EventArgs e)
		{
			if( currentStep.PreviousStep == "" )
			{
				BackEnabled = false;
			}
			else
			{
				BackEnabled = true;
			}
		}
		#endregion

		#region OnNextStepChanged
		private void OnNextStepChanged(object sender, EventArgs e)
		{
			if( currentStep.NextStep == "" )
			{
				SetFinish(false);
				NextEnabled = false;
			}
			else if( currentStep.NextStep == BaseStep.FinishStep )
			{
				NextEnabled = true;
				SetFinish(true);
			}
			else
			{
				NextEnabled = true;
				SetFinish(false);
			}
		}
		#endregion 

		#region OnPageLayoutChanged
		private void OnPageLayoutChanged(object sender, EventArgs e)
		{
			UpdateLayout(currentStep.PageLayout);
		}
		#endregion

		#region OnLogoChanged
		private void OnLogoChanged(object sender, EventArgs e)
		{
			if( currentStep == null || currentStep.Logo == null )
			{
				if( imageLogo == null )
					logo.Image = BaseWizard.DefaultLogo;
				else
					logo.Image = imageLogo;
			}
			else
			{
				logo.Image = currentStep.Logo;
			}
		}
		#endregion

		#region OnSideBarLogoChanged
		private void OnSideBarLogoChanged(object sender, EventArgs e)
		{
			if( currentStep == null || currentStep.SideBarLogo == null )
			{
				if( imageSideBarLogo == null )
					sideLogo.Image = BaseWizard.DefaultSideBarLogo;
				else
					sideLogo.Image = imageSideBarLogo;
			}
			else
			{
				sideLogo.Image = currentStep.SideBarLogo;
			}
		}
		#endregion

		#region OnSideBarImageChanged
		private void OnSideBarImageChanged(object sender, EventArgs e)
		{
			if( currentStep == null || currentStep.SideBarImage == null )
			{
				if( imageSideBarImage == null )
					sidePanel.BackgroundImage = BaseWizard.DefaultSideBarImage;
				else
					sidePanel.BackgroundImage = imageSideBarImage;
			}
			else
			{
				sidePanel.BackgroundImage = currentStep.SideBarImage;
			}
		}
		#endregion

		#endregion

		#region Events

		#region BackClicked
		/// <summary>
		/// Event that fires when the back button has been clicked.
		/// 
		/// The BaseStep provides base functionality to handle this,
		/// so it need not be public to everyone
		/// </summary>
		[Browsable(false)]
		internal event EventHandler BackClicked
		{
			add
			{
				Events.AddHandler(BaseWizard.backClicked, value);
			}
			remove
			{
				Events.RemoveHandler(BaseWizard.backClicked, value);
			}
		}
		/// <summary>
		/// Evento depresión de back en el asistente
		/// </summary>
		/// <param name="e"></param>
		protected virtual void OnBackClicked(EventArgs e)
		{
			EventHandler handler = (EventHandler) Events[BaseWizard.backClicked];

			if( handler != null )
			{
				handler(this, e);
			}
		}
		#endregion

		#region NextClicked
		/// <summary>
		/// Event that fires when the next button has been clicked.
		/// 
		/// The BaseStep provides base functionality to handle this,
		/// so it need not be public to everyone
		/// </summary>
		[Browsable(false)]
		internal event EventHandler NextClicked
		{
			add
			{
				Events.AddHandler(BaseWizard.nextClicked, value);
			}
			remove
			{
				Events.RemoveHandler(BaseWizard.nextClicked, value);
			}
		}
		/// <summary>
		/// Evento de selección de siguiente
		/// </summary>
		/// <param name="e"></param>
		protected virtual void OnNextClicked(EventArgs e)
		{
			EventHandler handler = (EventHandler) Events[BaseWizard.nextClicked];

			if( handler != null )
			{
				handler(this, e);
			}
		}
		#endregion

		#region FinishClicked
		/// <summary>
		/// Event that fires when the finish button has been clicked.
		/// 
		/// The BaseStep provides base functionality to handle this,
		/// so it need not be public to everyone
		/// </summary>
		[Browsable(false)]
		internal event EventHandler FinishClicked
		{
			add
			{
				Events.AddHandler(BaseWizard.finishClicked, value);
			}
			remove
			{
				Events.RemoveHandler(BaseWizard.finishClicked, value);
			}
		}
		/// <summary>
		/// Evento de selección del boton finalizar
		/// </summary>
		/// <param name="e"></param>
		protected virtual void OnFinishClicked(EventArgs e)
		{
			EventHandler handler = (EventHandler) Events[BaseWizard.finishClicked];

			if( handler != null )
			{
				handler(this, e);
			}
		}
		#endregion

		#region LoadSteps
		/// <summary>
		/// Event that fires when the initial steps of the wizard should be added
		/// </summary>
		[Browsable(true)]
		[Category("Wizard")]
		[Description("Fired when the wizard should add the initial steps to the wizard")]
		public event EventHandler LoadSteps
		{
			add
			{
				Events.AddHandler(BaseWizard.loadSteps, value);
			}
			remove
			{
				Events.RemoveHandler(BaseWizard.loadSteps, value);
			}
		}
		/// <summary>
		/// Evento de carga todas las formas
		/// </summary>
		/// <param name="e"></param>
		protected virtual void OnLoadSteps(EventArgs e)
		{
			EventHandler handler = (EventHandler) Events[BaseWizard.loadSteps];

			if( handler != null )
			{
				handler(this, e);
			}
		}
		#endregion

		#endregion

		#region Protected Methods
		
		#region SetFinish		
		/// <summary>
		/// Cambia el texto de siguiente por el de finalizar
		/// </summary>
		/// <param name="finish">verdadero si la pagina a mostrar es final</param>
		protected void SetFinish( bool finish )
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(BaseWizard));
			System.Resources.ResourceManager global = new System.Resources.ResourceManager("TSWizards.global",System.Reflection.Assembly.GetExecutingAssembly());		
			if( finish )
			{				
				next.Text = resources.GetString("finish");
			}
			else
			{
				next.Text = resources.GetString("next.Text");
			}
		}
		#endregion

		#region UpdateLayout
		/// <summary>
		///		Updates the wizard layout to match the suggested <see cref="PageLayout"/>.
		/// </summary>
		/// <param name="layout">The suggested layout to use</param>
		protected virtual void UpdateLayout(PageLayout layout)
		{
			// Should we perform a layout?
			if( layout == PageLayout.None )
				return;

			SuspendLayout();
			try
			{
				switch( layout )
				{
					case PageLayout.InteriorPage:
						// Show the top bar
						wizardTop.Visible = true;
						wizardTop.Dock = DockStyle.Top;
						wizardTop.Height = 64;
					
						// Show the top line
						topLine.Visible = true;
						topLine.Dock = DockStyle.Top;

						// Hide the side bar
						sidePanel.Visible = false;

						// Position and size the step panel
						panelStep.Dock = DockStyle.Fill;
						panelStep.DockPadding.All = 8;
					
						BackColor = SystemColors.Control;
						panelStep.BackColor = SystemColors.Control;
						break;
					case PageLayout.ExteriorPage:
						// Hide the top bar
						wizardTop.Visible = false;
						topLine.Visible = false;
				
						//BackColor = Color.White;
						panelStep.BackColor = Color.White;

						panelStep.Dock = DockStyle.Fill;

						sidePanel.Visible = true;
						sidePanel.Dock = DockStyle.Left;
						sidePanel.Width = 160;
						break;
					default:
						throw new InvalidOperationException("WizardLayout is not set to one of the allowed values");
				}

				panelStep.BringToFront();
			}
			finally
			{
				ResumeLayout();
			}
		}
		#endregion
			
		#endregion	

		#region Code that is commented out until later
/*
		#region IWizardDesigner implementation
		
		PageLayout IWizardDesigner.CurrentPageLayout 
		{
			get
			{
				return this.currentLayout;
			}
			set
			{
				currentLayout = value;

				UpdateLayout(currentLayout);
			}
		}

		#endregion
*/
		#endregion
	}
}