using System;

namespace TSWizards
{
	/// <summary>
	/// Enumeración para determinar si se permite el cierre
	/// </summary>
	public enum AllowClose
	{
		/// <summary>
		/// Pregunta antes de cerrar
		/// </summary>
		Ask,
		/// <summary>
		/// Preguntar si no termina
		/// </summary>
		[Obsolete("Use AllowClose.Ask instead")]
		AskIfNotFinish,
		/// <summary>
		/// Diempre preguntar
		/// </summary>
		AlwaysAllow
	}
}
