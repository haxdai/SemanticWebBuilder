/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;

namespace CHtmlParser
{
	/// <summary>Colección de tag de HTML</summary>
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
		/// Constructor en vase a una colección de tags
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
		/// Agrega una colección de tags
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
		/// <param name="index">Posición</param>
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
            /// Crea un enumerador en base a una colección de tags
            /// </summary>
            /// <param name="mappings"></param>
			public LineEnumerator(TagCollection mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            /// <summary>
            /// Regresa el tag actual en la enumeración
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
            /// Se mueve una posición
            /// </summary>
            /// <returns>True si se pudo mover, False si no hay más elementos</returns>
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
