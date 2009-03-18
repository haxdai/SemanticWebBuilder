/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
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
		/// Constructor en base a una colección de parametros
		/// </summary>
		/// <param name="value"></param>
		public ParameterCollection(ParameterCollection value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// Construcción en base a un array de parametros
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
		/// Agrega una colección de parametros
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
		/// Inserta un parametro en un posición
		/// </summary>
		/// <param name="index">Posición</param>
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
            /// Constructor de enumerador en base a una colección de parametros
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
            /// Se mueve una posicicón
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
