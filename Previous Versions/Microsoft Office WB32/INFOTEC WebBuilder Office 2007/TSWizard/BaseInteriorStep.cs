using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;

using System.Windows.Forms;


namespace TSWizards
{
	/// <summary>
	/// Clase que representa una p�gina Interior para asistente
	/// </summary>
	public class BaseInteriorStep : TSWizards.BaseStep
	{
		private System.ComponentModel.IContainer components = null;
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public BaseInteriorStep()
		{
			// This call is required by the Windows Form Designer.
			InitializeComponent();

			// TODO: Add any initialization after the InitializeComponent call
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
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			// 
			// BaseInteriorStep
			// 
			this.BackColor = System.Drawing.SystemColors.Control;
			this.Name = "BaseInteriorStep";
			this.ResumeLayout(false);

		}
		#endregion
	}
}

