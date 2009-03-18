/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;

namespace CHtmlParser
{
	/// <summary>Colecci�n de tag de HTML</summary>
	public class TagCollection : System.Collections.CollectionBase 
	{
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public TagCollection()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>
		/// Constructor en vase a una colecci�n de tags
		/// </summary>
		/// <param name="value"></param>
		public TagCollection(TagCollection value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Constructor en base a un array de tags
		/// </summary>
		/// <param name="value"></param>
		public TagCollection(CTag[] value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Regresa un tag
		/// </summary>
		public CTag this[int index] 
		{
			get 
			{
				return ((CTag)(List[index]));
			}
			set 
			{
				List[index] = value;
			}
		}
		/// <summary>
		/// Agrega un Tag
		/// </summary>
		/// <param name="value">Tag a agregar</param>
		/// <returns>indice en el que se agrego</returns>
		public int Add(CTag value) 
		{
			return List.Add(value);
		}
		/// <summary>
		/// Agrega un array de tags
		/// </summary>
		/// <param name="value">Array de tags</param>
		public void AddRange(CTag[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Agrega una colecci�n de tags
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(TagCollection value) 
		{
			for (int i = 0; (i < value.Count); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Indica si contiene un tag
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public bool Contains(CTag value) 
		{
			return List.Contains(value);
		}
		/// <summary>
		/// Copia un array de tags dado un indice
		/// </summary>
		/// <param name="array">array de tags</param>
		/// <param name="index">Indice</param>
		public void CopyTo(CTag[] array, int index) 
		{
			List.CopyTo(array, index);
		}
		/// <summary>
		/// Regresa el indice de un tag
		/// </summary>
		/// <param name="value">Tag a buscar</param>
		/// <returns></returns>
		public int IndexOf(CTag value) 
		{
			return List.IndexOf(value);
		}
		/// <summary>
		/// Inserta un tag
		/// </summary>
		/// <param name="index">Posici�n</param>
		/// <param name="value">Tag a agregar</param>
		public void Insert(int index, CTag value) 
		{
			List.Insert(index, value);
		}
		/// <summary>
		/// Regresa un enumerador de tags
		/// </summary>
		/// <returns></returns>
		public new LineEnumerator GetEnumerator() 
		{
			return new LineEnumerator(this);
		}
		/// <summary>
		/// Remive un tag
		/// </summary>
		/// <param name="value">Tag a remover</param>
		public void Remove(CTag value) 
		{
			List.Remove(value);
		}
		/// <summary>
		/// Enumerador de tags
		/// </summary>
		public class LineEnumerator : object, IEnumerator 
		{
            
			private IEnumerator baseEnumerator;
            
			private IEnumerable temp;
            /// <summary>
            /// Crea un enumerador en base a una colecci�n de tags
            /// </summary>
            /// <param name="mappings"></param>
			public LineEnumerator(TagCollection mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            /// <summary>
            /// Regresa el tag actual en la enumeraci�n
            /// </summary>
			public CTag Current 
			{
				get 
				{
					return ((CTag)(baseEnumerator.Current));
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
            /// Se mueve una posici�n
            /// </summary>
            /// <returns>True si se pudo mover, False si no hay m�s elementos</returns>
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
