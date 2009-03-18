/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;

namespace WBOffice3
{
	/// <summary>
	/// Summary description for ParameterCollection.
	/// </summary>
	public class ParameterCollection: CollectionBase
	{
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public ParameterCollection()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>
		/// Constructor en base a una colecci�n de parametros
		/// </summary>
		/// <param name="value"></param>
		public ParameterCollection(ParameterCollection value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Construcci�n en base a un array de parametros
		/// </summary>
		/// <param name="value"></param>
		public ParameterCollection(IParameter[] value) 
		{
			this.AddRange(value);
		}

		/// <summary>
		/// Regresa un parametro
		/// </summary>
		public IParameter this[int index] 
		{
			get 
			{
				return ((IParameter)(List[index]));
			}
			set 
			{
				List[index] = value;
			}
		}
		/// <summary>
		/// Agrega un parametro
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public int Add(IParameter value) 
		{
			return List.Add(value);
		}
		/// <summary>
		/// Agrega un array de parametros
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(IParameter[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Agrega una colecci�n de parametros
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(ParameterCollection value) 
		{
			for (int i = 0; (i < value.Count); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Regresa True si contiene un parametro
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public bool Contains(IParameter value) 
		{
			return List.Contains(value);
		}
		/// <summary>
		/// Copia un conjunto de parametros a un array
		/// </summary>
		/// <param name="array">Array destino</param>
		/// <param name="index">indice inicial</param>
		public void CopyTo(IParameter[] array, int index) 
		{
			List.CopyTo(array, index);
		}
		/// <summary>
		/// Regresa el indice de un parametro
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public int IndexOf(IParameter value) 
		{
			return List.IndexOf(value);
		}
		/// <summary>
		/// Inserta un parametro en un posici�n
		/// </summary>
		/// <param name="index">Posici�n</param>
		/// <param name="value">Parametro a insertar</param>
		public void Insert(int index, IParameter value) 
		{
			List.Insert(index, value);
		}
		/// <summary>
		/// Regresa un enumerador de parametros
		/// </summary>
		/// <returns></returns>
		public new LineEnumerator GetEnumerator() 
		{
			return new LineEnumerator(this);
		}
		/// <summary>
		/// Remieve un parametro
		/// </summary>
		/// <param name="value"></param>
		public void Remove(IParameter value) 
		{
			List.Remove(value);
		}
		/// <summary>
		/// Clase enumerador de parametros
		/// </summary>
		public class LineEnumerator : object, IEnumerator 
		{
            
			private IEnumerator baseEnumerator;
            
			private IEnumerable temp;
            /// <summary>
            /// Constructor de enumerador en base a una colecci�n de parametros
            /// </summary>
            /// <param name="mappings"></param>
			public LineEnumerator(ParameterCollection mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            /// <summary>
            /// Regresa el parametro actual
            /// </summary>
			public IParameter Current 
			{
				get 
				{
					return ((IParameter)(baseEnumerator.Current));
				}
			}
            
			object IEnumerator.Current 
			{
				get 
				{
					return baseEnumerator.Current;
				}
			}
            /// <summary>
            /// Se mueve una posicic�n
            /// </summary>
            /// <returns></returns>
			public bool MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
            
			bool IEnumerator.MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
            /// <summary>
            /// Reinicia el enumerador
            /// </summary>
			public void Reset() 
			{
				baseEnumerator.Reset();
			}
            
			void IEnumerator.Reset() 
			{
				baseEnumerator.Reset();
			}
		}        
	}
}
