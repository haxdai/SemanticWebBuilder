using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Security.Permissions;
using System.Collections.Generic;
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

		protected static readonly Image DefaultLogo;
        protected static readonly Image DefaultSideBarImage;
        private TSWizards.Controls.EtchedLine bottomLine;
        private Panel panel1;
        private ProgressBar progressBar1;
        private Label label1;
		protected static readonly Image DefaultSideBarLogo;
        private IDictionary<String, object> _data = new Dictionary<String, object>();
		static BaseWizard()
		{
			DefaultLogo = new Bitmap(typeof(BaseWizard), "wizard.bmp");
			DefaultSideBarLogo = new Bitmap(typeof(BaseWizard), "wizardSideLogo.jpg");
			DefaultSideBarImage = new Bitmap(typeof(BaseWizard), "wizardSide.jpg");
		}
        public IDictionary<String,object> Data
        {
            get
            {
                return _data;
            }
        }

		private Image imageLogo;
		private Image imageSideBarLogo;
		private Image imageSideBarImage;

		private BaseStep currentStep = null;
		private string firstStep = "";
		private WizardStepDictionary steps;
		private AllowClose allowClose = AllowClose.AlwaysAllow;
		protected System.Windows.Forms.Panel wizardTop;
		private System.Windows.Forms.Label title;
		protected System.Windows.Forms.Button cancel;
		protected System.Windows.Forms.Button back;
		protected System.Windows.Forms.Button next;
		private System.Windows.Forms.PictureBox logo;
        private TSWizards.Controls.EtchedLine topLine;
		private System.Windows.Forms.Label stepDescription;
		private PageLayout currentLayout = PageLayout.InteriorPage;
		private System.Windows.Forms.Panel bottomPanel;
		private System.Windows.Forms.Panel sidePanel;
		private System.Windows.Forms.PictureBox sideLogo;
		protected System.Windows.Forms.Panel panelStep;

		/// <summary>
		///		Tells which way we moved in the wizard
		/// </summary>
		public enum StepDirection
		{
			InitialStep,
			PreviousStep,
			NextStep,
			Jump
		}

		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

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
        public void SetProgressBarInit(int maxValue,int value,String message)
        {
            this.panel1.Visible = true;
            if (value > maxValue)
            {
                value = maxValue;
            }
            this.progressBar1.Maximum = maxValue;
            this.cancel.Enabled = false;
            this.next.Enabled = false;
            this.back.Enabled = false;
            this.progressBar1.Visible = true;
            this.progressBar1.Value = value;
            this.label1.Text = message;
            this.label1.Visible = true;            
            this.progressBar1.Minimum = 0;
            this.Refresh();
            this.label1.Refresh();
            this.progressBar1.Refresh();
            
        }
        public void SetProgressBarEnd()
        {
            this.panel1.Visible = false;
            this.cancel.Enabled = true;
            this.next.Enabled = true;
            this.back.Enabled = true;
            this.progressBar1.Visible = false;
            this.label1.Visible = false;
            this.label1.Text = "";
            this.progressBar1.Minimum = 0;
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
            this.wizardTop = new System.Windows.Forms.Panel();
            this.stepDescription = new System.Windows.Forms.Label();
            this.title = new System.Windows.Forms.Label();
            this.logo = new System.Windows.Forms.PictureBox();
            this.cancel = new System.Windows.Forms.Button();
            this.back = new System.Windows.Forms.Button();
            this.next = new System.Windows.Forms.Button();
            this.bottomPanel = new System.Windows.Forms.Panel();
            this.bottomLine = new TSWizards.Controls.EtchedLine();
            this.sidePanel = new System.Windows.Forms.Panel();
            this.sideLogo = new System.Windows.Forms.PictureBox();
            this.panelStep = new System.Windows.Forms.Panel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.progressBar1 = new System.Windows.Forms.ProgressBar();
            this.topLine = new TSWizards.Controls.EtchedLine();
            this.wizardTop.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.logo)).BeginInit();
            this.bottomPanel.SuspendLayout();
            this.sidePanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.sideLogo)).BeginInit();
            this.panelStep.SuspendLayout();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // wizardTop
            // 
            this.wizardTop.BackColor = System.Drawing.Color.White;
            this.wizardTop.Controls.Add(this.stepDescription);
            this.wizardTop.Controls.Add(this.title);
            this.wizardTop.Controls.Add(this.logo);
            this.wizardTop.Dock = System.Windows.Forms.DockStyle.Top;
            this.wizardTop.Location = new System.Drawing.Point(0, 0);
            this.wizardTop.Name = "wizardTop";
            this.wizardTop.Size = new System.Drawing.Size(488, 64);
            this.wizardTop.TabIndex = 0;
            // 
            // stepDescription
            // 
            this.stepDescription.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.stepDescription.Location = new System.Drawing.Point(16, 24);
            this.stepDescription.Name = "stepDescription";
            this.stepDescription.Size = new System.Drawing.Size(408, 32);
            this.stepDescription.TabIndex = 4;
            this.stepDescription.Text = "Step Description";
            // 
            // title
            // 
            this.title.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.title.AutoSize = true;
            this.title.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.title.Location = new System.Drawing.Point(8, 8);
            this.title.Name = "title";
            this.title.Size = new System.Drawing.Size(62, 13);
            this.title.TabIndex = 3;
            this.title.Text = "Step Text";
            // 
            // logo
            // 
            this.logo.Dock = System.Windows.Forms.DockStyle.Right;
            this.logo.Location = new System.Drawing.Point(429, 0);
            this.logo.Name = "logo";
            this.logo.Size = new System.Drawing.Size(59, 64);
            this.logo.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.logo.TabIndex = 2;
            this.logo.TabStop = false;
            this.logo.Visible = false;
            // 
            // cancel
            // 
            this.cancel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancel.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.cancel.Location = new System.Drawing.Point(8, 8);
            this.cancel.Name = "cancel";
            this.cancel.Size = new System.Drawing.Size(88, 23);
            this.cancel.TabIndex = 3;
            this.cancel.Text = "Cancel";
            this.cancel.Click += new System.EventHandler(this.cancel_Click);
            // 
            // back
            // 
            this.back.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.back.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.back.Location = new System.Drawing.Point(296, 8);
            this.back.Name = "back";
            this.back.Size = new System.Drawing.Size(88, 23);
            this.back.TabIndex = 4;
            this.back.Text = "< Back";
            this.back.Click += new System.EventHandler(this.back_Click);
            // 
            // next
            // 
            this.next.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.next.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.next.Location = new System.Drawing.Point(392, 8);
            this.next.Name = "next";
            this.next.Size = new System.Drawing.Size(88, 23);
            this.next.TabIndex = 5;
            this.next.Text = "Next >";
            this.next.Click += new System.EventHandler(this.next_Click);
            // 
            // bottomPanel
            // 
            this.bottomPanel.Controls.Add(this.bottomLine);
            this.bottomPanel.Controls.Add(this.cancel);
            this.bottomPanel.Controls.Add(this.back);
            this.bottomPanel.Controls.Add(this.next);
            this.bottomPanel.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.bottomPanel.Location = new System.Drawing.Point(0, 315);
            this.bottomPanel.Name = "bottomPanel";
            this.bottomPanel.Size = new System.Drawing.Size(488, 40);
            this.bottomPanel.TabIndex = 8;
            // 
            // bottomLine
            // 
            this.bottomLine.Dock = System.Windows.Forms.DockStyle.Top;
            this.bottomLine.Location = new System.Drawing.Point(0, 0);
            this.bottomLine.Name = "bottomLine";
            this.bottomLine.Size = new System.Drawing.Size(488, 2);
            this.bottomLine.TabIndex = 2;
            this.bottomLine.Text = "lineFrame2";
            // 
            // sidePanel
            // 
            this.sidePanel.BackColor = System.Drawing.Color.White;
            this.sidePanel.Controls.Add(this.sideLogo);
            this.sidePanel.Dock = System.Windows.Forms.DockStyle.Left;
            this.sidePanel.Location = new System.Drawing.Point(0, 66);
            this.sidePanel.Name = "sidePanel";
            this.sidePanel.Size = new System.Drawing.Size(164, 249);
            this.sidePanel.TabIndex = 9;
            this.sidePanel.Visible = false;
            // 
            // sideLogo
            // 
            this.sideLogo.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.sideLogo.Location = new System.Drawing.Point(88, 16);
            this.sideLogo.Name = "sideLogo";
            this.sideLogo.Size = new System.Drawing.Size(61, 61);
            this.sideLogo.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.sideLogo.TabIndex = 9;
            this.sideLogo.TabStop = false;
            this.sideLogo.Visible = false;
            // 
            // panelStep
            // 
            this.panelStep.Controls.Add(this.panel1);
            this.panelStep.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panelStep.Location = new System.Drawing.Point(164, 66);
            this.panelStep.Name = "panelStep";
            this.panelStep.Padding = new System.Windows.Forms.Padding(8);
            this.panelStep.Size = new System.Drawing.Size(324, 249);
            this.panelStep.TabIndex = 10;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.progressBar1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel1.Location = new System.Drawing.Point(8, 210);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(308, 31);
            this.panel1.TabIndex = 0;
            this.panel1.Visible = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(0, 5);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(0, 15);
            this.label1.TabIndex = 1;
            // 
            // progressBar1
            // 
            this.progressBar1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.progressBar1.Location = new System.Drawing.Point(0, 20);
            this.progressBar1.Name = "progressBar1";
            this.progressBar1.Size = new System.Drawing.Size(308, 11);
            this.progressBar1.TabIndex = 0;
            this.progressBar1.Visible = false;
            // 
            // topLine
            // 
            this.topLine.Dock = System.Windows.Forms.DockStyle.Top;
            this.topLine.Location = new System.Drawing.Point(0, 64);
            this.topLine.Name = "topLine";
            this.topLine.Size = new System.Drawing.Size(488, 2);
            this.topLine.TabIndex = 1;
            this.topLine.Text = "lineFrame1";
            // 
            // BaseWizard
            // 
            this.AcceptButton = this.next;
            this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
            this.CancelButton = this.cancel;
            this.ClientSize = new System.Drawing.Size(488, 355);
            this.Controls.Add(this.panelStep);
            this.Controls.Add(this.sidePanel);
            this.Controls.Add(this.bottomPanel);
            this.Controls.Add(this.topLine);
            this.Controls.Add(this.wizardTop);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.MinimumSize = new System.Drawing.Size(304, 232);
            this.Name = "BaseWizard";
            this.Text = "Wizard Title";
            this.wizardTop.ResumeLayout(false);
            this.wizardTop.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.logo)).EndInit();
            this.bottomPanel.ResumeLayout(false);
            this.sidePanel.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.sideLogo)).EndInit();
            this.panelStep.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

		}
		#endregion

		#region Public Properties
		
		#region Title
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
        [Browsable(true)]
        [Category("Wizard")]
        [Description("Gets/Sets the visibility of the image that is displayed along the rigth side of the wizard, seen only on Exterior pages")]
        [DefaultValue(typeof(bool), "false")]
        public Boolean VisibleLogo
        {
            get
            {
                return this.logo.Visible;
            }
            set
            {
                this.logo.Visible = false;
            }
        }

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

        

        [Browsable(true)]
        [Category("Wizard")]
        [Description("Gets/Sets the visibility of the image that is displayed along the left side of the wizard, seen only on Exterior pages")]
        [DefaultValue(typeof(bool), "false")]
        public Boolean VisibleSideBarLogo
        {
            get
            {
                return this.sideLogo.Visible;
            }
            set
            {
                this.sideLogo.Visible = false;
            }
        }

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
        public void changeToNext()
        {
            SetFinish(false);
        }
        public void changeToFinish()
        {
            SetFinish(true);
        }
		#endregion

		#region FirstStepName
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
		/*public void AddStep(string name, BaseStep step)
		{
			Steps[name] = step;
		}*/
        public void AddStep(BaseStep step)
        {
            String prefix = "Step";
            step.PreviousStep = "";
            step.NextStep = "";
            Steps[prefix + Steps.Count] = step;
            for (int i = 0; i < Steps.Count; i++)
            {
                
                if (Steps.Count == 1)
                {
                    Steps[prefix + i].PreviousStep = "";
                    Steps[prefix + i].NextStep = "";
                    Steps[prefix + i].IsFinished = true;
                    this.firstStep = prefix + i;
                }
                else
                {
                    Steps[prefix + i].IsFinished = false;
                    if (i == 0)
                    {
                        this.firstStep = prefix + i;
                        Steps[prefix + i].PreviousStep = "";
                        Steps[prefix + i].NextStep = prefix+(i+1);
                    }
                    else if (i == (Steps.Count - 1))
                    {
                        Steps[prefix + i].PreviousStep = prefix + (i - 1); ;
                        Steps[prefix + i].NextStep = "";
                        Steps[prefix + i].IsFinished = true;
                    }
                    else
                    {
                        Steps[prefix + i].PreviousStep = prefix + (i - 1); ;
                        Steps[prefix + i].NextStep = prefix + (i + 1);
                    }
                }
                
            }
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
		// Loads any steps 
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
		protected override void OnClosing(System.ComponentModel.CancelEventArgs e)
		{
			if( DialogResult == DialogResult.Cancel )
			{
				switch( AllowClose )
				{
					//case AllowClose.AskIfNotFinish:
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
		
		#region SetFinish - bug fix by Ingram Leedy [http://www.codeproject.com/script/profile/whos_who.asp?id=26150]
		/// <summary>
		/// Changes the text of the Next/Finish button to reflect 
		/// the correct state
		/// </summary>
		/// <param name="bFinish">True if we should set the next button up for a finish</param>
		protected void SetFinish( bool finish )
		{
            cancel.Enabled = true;
			if( finish )
			{
				next.Text = "Finish";
                cancel.Enabled = false;
			}
			else
			{
				next.Text = "Next >";
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