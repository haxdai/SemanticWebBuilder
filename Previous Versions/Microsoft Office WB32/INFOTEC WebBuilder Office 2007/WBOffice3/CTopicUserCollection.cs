/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
/*
namespace WBOffice3
{
	/// <summary>Collecci�n de Secciones a las que tiene permiso un Usuario</summary>
	public class CTopicUserCollection: CollectionBase
	{

		public CTopicUserCollection()
		{
			//
			// TODO: Add constructor logic here
			//
		}
		public CTopicUserCollection(CTopicUserCollection value) 
		{
			this.AddRange(value);
		}
		public CTopicUserCollection(CTopicUser[] value) 
		{
			this.AddRange(value);
		}
		public CTopicUser this[int index] 
		{
			get 
			{
				return ((CTopicUser)(List[index]));
			}
			set 
			{
				List[index] = value;
			}
		}
		public int Add(CTopicUser value) 
		{
			return List.Add(value);
		}
		public void AddRange(CTopicUser[] value) 
		{
			for (int i = 0; (i < value.Length); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		public void AddRange(CTopicUserCollection value) 
		{
			for (int i = 0; (i < value.Count); i = (i + 1)) 
			{
				this.Add(value[i]);
			}
		}
		public bool Contains(CTopicUser value) 
		{
			return List.Contains(value);
		}
		public void CopyTo(CTopicUser[] array, int index) 
		{
			List.CopyTo(array, index);
		}
		public int IndexOf(CTopicUser value) 
		{
			return List.IndexOf(value);
		}
		public void Insert(int index, CTopicUser value) 
		{
			List.Insert(index, value);
		}
		public new LineEnumerator GetEnumerator() 
		{
			return new LineEnumerator(this);
		}
		public void Remove(CTopicUser value) 
		{
			List.Remove(value);
		}
		public class LineEnumerator : object, IEnumerator 
		{
            
			private IEnumerator baseEnumerator;
            
			private IEnumerable temp;
            
			public LineEnumerator(CTopicUserCollection mappings) 
			{
				this.temp = ((IEnumerable)(mappings));
				this.baseEnumerator = temp.GetEnumerator();
			}
            
			public CTopicUser Current 
			{
				get 
				{
					return ((CTopicUser)(baseEnumerator.Current));
				}
			}
            
			object IEnumerator.Current 
			{
				get 
				{
					return baseEnumerator.Current;
				}
			}
            
			public bool MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
            
			bool IEnumerator.MoveNext() 
			{
				return baseEnumerator.MoveNext();
			}
            
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
*/
