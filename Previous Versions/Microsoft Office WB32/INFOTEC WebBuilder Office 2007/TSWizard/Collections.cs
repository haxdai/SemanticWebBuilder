using System;
using System.Collections;
using System.Runtime.InteropServices;

namespace TSWizards
{
	/// <summary>
	/// Clase colección e las páginas definidas en un asistente
	/// </summary>
	public class WizardStepDictionary : IDictionary, ICollection, IEnumerable, ICloneable
	{
		/// <summary>
		/// colección e las páginas definidas en un asistente
		/// </summary>
		protected Hashtable innerHash;
		
		#region "Constructors"
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public WizardStepDictionary()
		{
			innerHash = new Hashtable();
		}
		/// <summary>
		/// Constructor basado en una colección de paginas existente
		/// </summary>
		/// <param name="original"></param>
		public WizardStepDictionary(WizardStepDictionary original)
		{
			innerHash = new Hashtable (original.innerHash);
		}
		/// <summary>
		/// Consturctor basado en un diccionario
		/// </summary>
		/// <param name="dictionary"></param>
		public WizardStepDictionary(IDictionary dictionary)
		{
			innerHash = new Hashtable (dictionary);
		}
		/// <summary>
		/// Capcidad del diccionario
		/// </summary>
		/// <param name="capacity"></param>
		public WizardStepDictionary(int capacity)
		{
			innerHash = new Hashtable(capacity);
		}
		#endregion

		#region Implementation of IDictionary
		/// <summary>
		/// Regresa un enumerador de páginas del asistente
		/// </summary>
		/// <returns></returns>
		public WizardStepDictionaryEnumerator GetEnumerator()
		{
			return new WizardStepDictionaryEnumerator(this);
		}
		System.Collections.IDictionaryEnumerator IDictionary.GetEnumerator()
		{
			return new WizardStepDictionaryEnumerator(this);
		}
		IEnumerator IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}
		/// <summary>
		/// Remueve una página
		/// </summary>
		/// <param name="key"></param>
		public void Remove(string key)
		{
			innerHash.Remove (key);
		}
		void IDictionary.Remove(object key)
		{
			Remove ((string)key);
		}
		/// <summary>
		/// Determina si existe una página
		/// </summary>
		/// <param name="key"></param>
		/// <returns>True si la página existe, False en caso contrario</returns>
		public bool Contains(string key)
		{
			return innerHash.Contains(key);
		}
		bool IDictionary.Contains(object key)
		{
			return Contains((string)key);
		}
		/// <summary>
		/// Limpia el diccionario
		/// </summary>
		public void Clear()
		{
			innerHash.Clear();		
		}
		/// <summary>
		/// Agrega una página al diccionario
		/// </summary>
		/// <param name="key"></param>
		/// <param name="value"></param>
		public void Add(string key, BaseStep value)
		{
			innerHash.Add (key, value);
		}
		void IDictionary.Add(object key, object value)
		{
			Add ((string)key, (BaseStep)value);
		}
		/// <summary>
		/// Indica si es sólo de lectura
		/// </summary>
		public bool IsReadOnly
		{
			get
			{
				return innerHash.IsReadOnly;
			}
		}
		/// <summary>
		/// Regresa una pagina
		/// </summary>
		public BaseStep this[string key]
		{
			get
			{
				return (BaseStep) innerHash[key];
			}
			set
			{
				innerHash[key] = value;
			}
		}
		object IDictionary.this[object key]
		{
			get
			{
				return this[(string)key];
			}
			set
			{
				this[(string)key] = (BaseStep)value;
			}
		}
        /// <summary>
        /// Regresa todas las páginas
        /// </summary>
		public System.Collections.ICollection Values
		{
			get
			{
				return innerHash.Values;
			}
		}
		/// <summary>
		/// Regresa todos los nombres de página
		/// </summary>

		public System.Collections.ICollection Keys
		{
			get
			{
				return innerHash.Keys;
			}
		}
		/// <summary>
		/// Regresa si el tamaño es fijo
		/// </summary>
		public bool IsFixedSize
		{
			get
			{
				return innerHash.IsFixedSize;
			}
		}
		#endregion

		#region Implementation of ICollection
		/// <summary>
		/// Copia un conjunto de páginas a un array
		/// </summary>
		/// <param name="array">Array a gardar las páginas</param>
		/// <param name="index">Indice inicial</param>
		public void CopyTo(System.Array array, int index)
		{
			innerHash.CopyTo (array, index);
		}
		/// <summary>
		/// Copia dentro de un diccionario un conjunto de páginas existentes
		/// </summary>
		/// <param name="wsc">Diccionario a gardar las páginas</param>
		/// <param name="index">Indice inicial</param>
		public void CopyTo(WizardStepDictionary wsc, int index)
		{
			IEnumerator keys = Keys.GetEnumerator();
			IEnumerator values = Values.GetEnumerator();

			int count = Count;

			for(int i = 0; i < index; i++)
			{
				keys.MoveNext();
				values.MoveNext();
			}

			for(int i = index; i < count; i++)
			{
				keys.MoveNext();
				values.MoveNext();

				wsc.Add( keys.Current as string, values.Current as BaseStep );
			}
		}
		/// <summary>
		/// Determina si el diccionario es sincronizado
		/// </summary>
		public bool IsSynchronized
		{
			get
			{
				return innerHash.IsSynchronized;
			}
		}
		/// <summary>
		/// Cuantas páginas contiene
		/// </summary>
		public int Count
		{
			get
			{
				return innerHash.Count;
			}
		}
		/// <summary>
		/// Regresa el SyncRoot
		/// </summary>
		public object SyncRoot
		{
			get
			{
				return innerHash.SyncRoot;
			}
		}
		#endregion

		#region Implementation of ICloneable
		/// <summary>
		/// Clona el diccionario de páginas
		/// </summary>
		/// <returns></returns>
		public WizardStepDictionary Clone()
		{
			WizardStepDictionary clone = new WizardStepDictionary();
			clone.innerHash = (Hashtable) innerHash.Clone();
			
			return clone;
		}
		object ICloneable.Clone()
		{
			return Clone();
		}
		#endregion
		
		#region "HashTable Methods"
		/// <summary>
		/// indica si existe un nombre de página en el diccionario
		/// </summary>
		/// <param name="key"></param>
		/// <returns></returns>
		public bool ContainsKey (string key)
		{
			return innerHash.ContainsKey(key);
		}
		/// <summary>
		/// Indica si el diccionario contiene una página
		/// </summary>
		/// <param name="value"></param>
		/// <returns></returns>
		public bool ContainsValue (BaseStep value)
		{
			return innerHash.ContainsValue(value);
		}
		/// <summary>
		/// Regresa un diccionario sincronizado
		/// </summary>
		/// <returns></returns>
		public WizardStepDictionary Synchronized()
		{
			WizardStepDictionary sync = new WizardStepDictionary();
			sync.innerHash = Hashtable.Synchronized(innerHash);

			return sync;
		}
		#endregion
		/// <summary>
		/// Clase enumeradora del diccionario
		/// </summary>
		public class WizardStepDictionaryEnumerator : IDictionaryEnumerator
		{
			private IDictionaryEnumerator innerEnumerator;
			
			internal WizardStepDictionaryEnumerator(WizardStepDictionary enumerable)
			{
				innerEnumerator = enumerable.innerHash.GetEnumerator();
			}

			#region Implementation of IDictionaryEnumerator
			/// <summary>
			/// Nombre de la pagina actual
			/// </summary>
			public string Key
			{
				get
				{
					return (string)innerEnumerator.Key;
				}
			}
			object IDictionaryEnumerator.Key
			{
				get
				{
					return Key;
				}
			}

			/// <summary>
			/// Pagina actual
			/// </summary>
			public BaseStep Value
			{
				get
				{
					return (BaseStep)innerEnumerator.Value;
				}
			}
			object IDictionaryEnumerator.Value
			{
				get
				{
					return Value;
				}
			}
			/// <summary>
			/// Regresa el Entry
			/// </summary>
			public System.Collections.DictionaryEntry Entry
			{
				get
				{
					return innerEnumerator.Entry;
				}
			}

			#endregion

			#region Implementation of IEnumerator
			/// <summary>
			/// Reinicial el diccionario
			/// </summary>
			public void Reset()
			{
				innerEnumerator.Reset();
			}
			/// <summary>
			/// Avanza a la siguiente página
			/// </summary>
			/// <returns></returns>
			public bool MoveNext()
			{
				return innerEnumerator.MoveNext();
			}

			object IEnumerator.Current
			{
				get
				{
					return innerEnumerator.Current;
				}
			}
			/// <summary>
			/// Regresa la entrada actual
			/// </summary>
			public DictionaryEntry Current
			{
				get
				{
					return Entry;
				}
			}
			#endregion
		}
	}

}