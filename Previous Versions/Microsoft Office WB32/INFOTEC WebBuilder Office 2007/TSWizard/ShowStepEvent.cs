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
		/// Función ShowStepEventArgs
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
	/// Definciión de evento al mostrar página
	/// </summary>
	public delegate void ShowStepEventHandler(object sender, ShowStepEventArgs e);
}
