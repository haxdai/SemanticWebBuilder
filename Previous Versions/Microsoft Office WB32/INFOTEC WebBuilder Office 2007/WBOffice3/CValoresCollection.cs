/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;

namespace WBOffice3
{
	/// <summary>Clase colecci�n de valores</summary>
	public class CValoresCollection : CollectionBase
	{
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public CValoresCollection()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>
		/// Constructor en base a un valor dado
		/// </summary>
		/// <param name="value"></param>
		public CValoresCollection(CValoresCollection value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Constructor en base a una colecc�n dada
		/// </summary>
		/// <param name="value"></param>
		public CValoresCollection(CValorCaracterisitca[] value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Regresa una valor
		/// </summary>
		public CValorCaracterisitca this[int index] 
		{
			get 
			{
				return ((CValorCaracterisitca)(List[index]));
			}
			set 
			{
				List[index] = value;
			}
		}
		/// <summary>
		/// agrega una valor
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public int Add(CValorCaracterisitca value) 
		{
			return List.Add(value);
		}
		/// <summary>
		/// Agrega un conjunto de valores
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(CValorCaracterisitca[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// agrega una colecci�n de valores
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(CValoresCollection value) 
		{
			for (int i = 0; (i < value.Count); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Determina si existe un valor
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public bool Contains(CValorCaracterisitca value) 
		{
			return List.Contains(value);
		}
		/// <summary>
		/// Copia un conjunto de valores a un Array
		/// </summary>
		/// <param name="array">Array destino</param>
		/// <param name="index">Indice inicial</param>
		public void CopyTo(CValorCaracterisitca[] array, int index) 
		{
			List.CopyTo(array, index);
		}
		/// <summary>
		/// Regresa el indice de un valor
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public int IndexOf(CValorCaracterisitca value) 
		{
			return List.IndexOf(value);
		}
		/// <summary>
		/// Inserta un valor en un indice dado
		/// </summary>
		/// <param name="index">Indice</param>
		/// <param name="value">Valor a insertar</param>
		public void Insert(int index, CValorCaracterisitca value) 
		{
			List.Insert(index, value);
		}
		/// <summary>
		/// Regresa un enumerador de Valores
		/// </summary>
		/// <returns></returns>
		public new LineEnumerator GetEnumerator() 
		{
			return new LineEnumerator(this);
		}
		/// <summary>
		/// Remueve un valor
		/// </summary>
		/// <param name="value"></param>
		public void Remove(CValorCaracterisitca value) 
		{
			List.Remove(value);
		}
		/// <summary>
		/// Enumerador de valores
		/// </summary>
		public class LineEnumerator : object, IEnumerator 
		{
            
			private IEnumerator baseEnumerator;
            
			private IEnumerable temp;
            /// <summary>
            /// Consturctor en vase a una colleci�n de valores
            /// </summary>
            /// <param name="mappings"></param>
			public LineEnumerator(CValoresCollection mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            /// <summary>
            /// Regresa el valor actual
            /// </summary>
			public CValorCaracterisitca Current 
			{
				get 
				{
					return ((CValorCaracterisitca)(baseEnumerator.Current));
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
            /// Se mueve al siguiente valor
            /// </summary>
            /// <returns></returns>

			public bool MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
			/// <summary>
			/// Se mueve al siguiente valor
			/// </summary>
			/// <returns></returns>
			bool IEnumerator.MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
			/// <summary>
			/// Reinicial el enumerador
			/// </summary>
			/// <returns></returns>
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
