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
	/// Summary description for Attributes.
	/// </summary>
	public class Attributes: CollectionBase
	{
		/// <summary>Crea una coleci�n de atributos sin parametros</summary>
		public Attributes()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		/// <summary>Genera una coleci�n de atributos en base a una collecci�n de atributos</summary>
		/// <param name="value">Conjunto de atributos a contener</param>
		public Attributes(Attributes value) 
		{
			this.AddRange(value);
		}
		/// <summary>Genera una coleci�n de atributos en base a una collecci�n de atributos</summary>
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
		/// <summary>Agrega una colecci�n de atributos</summary>
		/// <param name="value">Colecci�n de atributos a gregar</param>
		public void AddRange(Attribute[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		/// <summary>Agrega una colecci�n de atributos</summary>
		/// <param name="value">Colecci�n de atributos a gregar</param>
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
