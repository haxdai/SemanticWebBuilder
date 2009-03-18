/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;

namespace WBOffice3
{
	/// <summary>Clase colección de valores</summary>
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
		/// Constructor en base a una coleccón dada
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
		/// agrega una colección de valores
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
            /// Consturctor en vase a una colleción de valores
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
