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
	/// Summary description for Attributes.
	/// </summary>
	public class Attributes: CollectionBase
	{
		/// <summary>Crea una coleción de atributos sin parametros</summary>
		public Attributes()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>Genera una coleción de atributos en base a una collección de atributos</summary>
		/// <param name="value">Conjunto de atributos a contener</param>
		public Attributes(Attributes value) 
		{
			this.AddRange(value);
		}
		/// <summary>Genera una coleción de atributos en base a una collección de atributos</summary>
		/// <param name="value">Conjunto de atributos a contener</param>
		public Attributes(Attribute[] value) 
		{
			this.AddRange(value);
		}
		/// <summary>
		/// regresa un atributo
		/// </summary>
		public Attribute this[int index] 
		{
			get 
			{
				return ((Attribute)(List[index]));
			}
			set 
			{
				List[index] = value;
			}
		}
		/// <summary>Agrega un atributo</summary>
		/// <param name="value">Atributo a gregar</param>
		public int Add(Attribute value) 
		{
			return List.Add(value);
		}
		/// <summary>Agrega una colección de atributos</summary>
		/// <param name="value">Colección de atributos a gregar</param>
		public void AddRange(Attribute[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>Agrega una colección de atributos</summary>
		/// <param name="value">Colección de atributos a gregar</param>
		public void AddRange(Attributes value) 
		{
			for (int i = 0; (i < value.Count); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>Indica si contiene o no un atributo</summary>
		/// <returns>Regresa true si existe el atributo</returns>
		/// <param name="value">Atributo a buscar</param>
		public bool Contains(Attribute value) 
		{
			return List.Contains(value);
		}
		/// <summary>
		/// Copia un conjunto de atributos a un array
		/// </summary>
		/// <param name="array">Array de atributos destino</param>
		/// <param name="index">Indice inicial</param>
		public void CopyTo(Attribute[] array, int index) 
		{
			List.CopyTo(array, index);
		}
		/// <summary>
		/// Regresa el indice en el que se encuentra un atributo
		/// </summary>
		/// <param name="value">Atributo</param>
		/// <returns>indice en el que se encuentra un atributo</returns>
		public int IndexOf(Attribute value) 
		{
			return List.IndexOf(value);
		}
		/// <summary>
		/// Inserta un atributo en un cierto indice
		/// </summary>
		/// <param name="index">Indice</param>
		/// <param name="value">Atributo</param>
		public void Insert(int index, Attribute value) 
		{
			List.Insert(index, value);
		}
		/// <summary>
		/// Regresa un enumerador de atributos
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
		public void Remove(Attribute value) 
		{
			List.Remove(value);
		}
		/// <summary>
		/// Clase que enumera un enumerador de atributos
		/// </summary>
		public class LineEnumerator : object, IEnumerator 
		{
            
			private IEnumerator baseEnumerator;
            
			private IEnumerable temp;
            /// <summary>
            /// Constuctor con conunto de atributos
            /// </summary>
            /// <param name="mappings">Atributos</param>
			public LineEnumerator(Attributes mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            /// <summary>
            /// Atributo actual
            /// </summary>
			public Attribute Current 
			{
				get 
				{
					return ((Attribute)(baseEnumerator.Current));
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
            /// Siguiente Atributo
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
            /// Renicial el enumerador
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
