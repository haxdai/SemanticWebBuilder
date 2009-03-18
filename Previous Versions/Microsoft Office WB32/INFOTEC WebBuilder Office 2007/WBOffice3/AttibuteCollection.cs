/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;

namespace CHtmlParser
{
	/// <summary>
	/// Summary description for AttibuteCollection.
	/// </summary>
	public class AttibuteCollection:CollectionBase
	{
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public AttibuteCollection()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>
		/// Consturctor basado en una colleción de atributos
		/// </summary>
		/// <param name="value">colección de atributos</param>
		public AttibuteCollection(AttibuteCollection value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Agrega una colección de atributos
		/// </summary>
		/// <param name="value"></param>
		public AttibuteCollection(CAttibute[] value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Regresa un atributo
		/// </summary>
		public CAttibute this[int index] 
		{
			get 
			{
				return ((CAttibute)(List[index]));
			}
			set 
			{
				List[index] = value;
			}
		}
		/// <summary>
		/// Agrega un atributo
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public int Add(CAttibute value) 
		{
			return List.Add(value);
		}
		/// <summary>
		/// agrega un conjunto de atributos
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(CAttibute[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// agrega una colección de atributos
		/// </summary>
		/// <param name="value"></param>
		public void AddRange(AttibuteCollection value) 
		{
			for (int i = 0; (i < value.Count); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>
		/// Regresa True si contiene un atributo
		/// </summary>
		/// <param name="value"></param>
		/// <returns>True si contiene un atributo, False en caso contrario</returns>
		public bool Contains(CAttibute value) 
		{
			return List.Contains(value);
		}
		/// <summary>
		/// Copia a un array de atributos dado un indice
		/// </summary>
		/// <param name="array">Array destino</param>
		/// <param name="index">indice inicial</param>
		public void CopyTo(CAttibute[] array, int index) 
		{
			List.CopyTo(array, index);
		}
		/// <summary>
		/// Indice de un atributo
		/// </summary>
		/// <param name="value"></param>
		/// <returns>Indice de un atributo</returns>
		public int IndexOf(CAttibute value) 
		{
			return List.IndexOf(value);
		}
		/// <summary>
		/// inserta un atributo en un cierto indice
		/// </summary>
		/// <param name="index">Indice en donde insertar</param>
		/// <param name="value">Atributo a insertar</param>
		public void Insert(int index, CAttibute value) 
		{
			List.Insert(index, value);
		}
		/// <summary>
		/// Regresaa un enumerador de atributos
		/// </summary>
		/// <returns></returns>
		public new LineEnumerator GetEnumerator() 
		{
			return new LineEnumerator(this);
		}
		/// <summary>
		/// Remueve un atributo
		/// </summary>
		/// <param name="value">Atributo a remover</param>
		public void Remove(CAttibute value) 
		{
			List.Remove(value);
		}
		/// <summary>
		/// Enumerador de atributos
		/// </summary>
		public class LineEnumerator : object, IEnumerator 
		{
            
			private IEnumerator baseEnumerator;
            
			private IEnumerable temp;
            /// <summary>
            /// Constructor basado en una colección de atributos
            /// </summary>
            /// <param name="mappings"></param>
			public LineEnumerator(AttibuteCollection mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            /// <summary>
            /// Atributo actual
            /// </summary>
			public CAttibute Current 
			{
				get 
				{
					return ((CAttibute)(baseEnumerator.Current));
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
            /// Siguiente atributo
            /// </summary>
            /// <returns></returns>
			public bool MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
            /// <summary>
            /// siguiente atributo
            /// </summary>
            /// <returns></returns>
			bool IEnumerator.MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
            /// <summary>
            /// Renicia el aenumerador
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
