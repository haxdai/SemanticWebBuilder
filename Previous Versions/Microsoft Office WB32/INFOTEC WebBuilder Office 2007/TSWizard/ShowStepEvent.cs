using System;

namespace TSWizards
{
	/// <summary>
	/// Summary description for ShowStepEvent.
	/// </summary>
	public class ShowStepEventArgs : EventArgs
	{
		private BaseWizard.StepDirection direction;

		/// <summary>
		/// Funci�n ShowStepEventArgs
		/// </summary>
		/// <param name="direction"></param>
		public ShowStepEventArgs(BaseWizard.StepDirection direction)
		{
			this.direction = direction;
		}
		/// <summary>
		/// Regresa el Direction del asistente
		/// </summary>
		public BaseWizard.StepDirection Direction
		{
			get
			{
				return direction;
			}
		}
	}

	/// <summary>
	/// Defincii�n de evento al mostrar p�gina
	/// </summary>
	public delegate void ShowStepEventHandler(object sender, ShowStepEventArgs e);
}
