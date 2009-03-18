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
	/// Summary description for HeaderCollection.
	/// </summary>
	public class HeaderCollection: CollectionBase
	{
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public HeaderCollection()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>
		/// Constructor basado en una colecci�n de headers
		/// </summary>
		/// <param name="value"></param>
		public HeaderCollection(HeaderCollection value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Constructor basado en un array de headers
		/// </summary>
		/// <param name="value"></param>
		public HeaderCollection(HtmlHeader[] value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Regresa un header
		/// </summary>
		public HtmlHeader this[int index] 
		{
			get 
			{
				return ((HtmlHeader)(List[index]));
			}
			set 
			{
				List[index] = value;
			}
		}
		/// <summary>
		/// Agrega un header
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public int Add(HtmlHeader value) 
		{
			return List.Add(value);
		}
		/// <summary>
		/// Agrega un rango de headers
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(HtmlHeader[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Agrega una colecci�n de headers
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(HeaderCollection value) 
		{
			for (int i = 0; (i < value.Count); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Indica si contiene un header
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public bool Contains(HtmlHeader value) 
		{
			return List.Contains(value);
		}
		/// <summary>
		/// Copia a un array de headers dado un indice
		/// </summary>
		/// <param name="array">Array de Headers</param>
		/// <param name="index">Indice inicial</param>
		public void CopyTo(HtmlHeader[] array, int index) 
		{
			List.CopyTo(array, index);
		}
		/// <summary>
		/// Regresa el indice de un header
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public int IndexOf(HtmlHeader value) 
		{
			return List.IndexOf(value);
		}
		/// <summary>
		/// inserta un header en un indice
		/// </summary>
		/// <param name="index"></param>
		/// <param name="value"></param>
		public void Insert(int index, HtmlHeader value) 
		{
			List.Insert(index, value);
		}
		/// <summary>
		/// Regresa un enumerador de headers
		/// </summary>
		/// <returns></returns>
		public new LineEnumerator GetEnumerator() 
		{
			return new LineEnumerator(this);
		}
		/// <summary>
		/// Remive eun header
		/// </summary>
		/// <param name="value"></param>
		public void Remove(HtmlHeader value) 
		{
			List.Remove(value);
		}
		/// <summary>
		/// Enumerador de headers
		/// </summary>
		public class LineEnumerator : object, IEnumerator 
		{
            
			private IEnumerator baseEnumerator;
            
			private IEnumerable temp;
            /// <summary>
            /// Construne un enumerador de headers en base a una colecci�n dada
            /// </summary>
            /// <param name="mappings"></param>
			public LineEnumerator(HeaderCollection mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            /// <summary>
            /// Regresa el header actual
            /// </summary>
			public HtmlHeader Current 
			{
				get 
				{
					return ((HtmlHeader)(baseEnumerator.Current));
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
            /// Se mueve al siguiente Header
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
            /// Reinicial el enumerador
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
