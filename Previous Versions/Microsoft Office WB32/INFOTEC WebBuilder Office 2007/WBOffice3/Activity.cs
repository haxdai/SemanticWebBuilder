/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;

namespace WBOffice3
{
	/// <summary>Muestra una actividad en el cuadro de dialogo de flujos</summary>
	public class Activity : System.Windows.Forms.Control
	{
		Color colorSelected=Color.FromKnownColor(KnownColor.ActiveCaption);
		/// <summary>
		/// Lista de ligas a actividades
		/// </summary>
		protected ArrayList links=new ArrayList();
		/// <summary>
		/// Nombre de la actividad
		/// </summary>
		protected String name;
		/// <summary>
		/// Descripción de la actividad
		/// </summary>
		protected String description;
		/// <summary>
		/// Paso en el que se encuentra
		/// </summary>
		protected String step="";
		bool selected=false;
		/// <summary>
		/// Imagen de paso
		/// </summary>
		protected System.Windows.Forms.PictureBox pictureBoxPaso;
		/// <summary>
		/// imagen de inicio
		/// </summary>
		protected System.Windows.Forms.PictureBox pictureBoxInicio;
		/// <summary>
		/// Imagen de paso final
		/// </summary>
		protected System.Windows.Forms.PictureBox pictureBoxFinal;
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;

		/// <summary>Contruye un actividad en base al nombre de la actividad y su descripción</summary>
		/// <param name="name">Nombre de la actividad</param>
		/// <param name="description">Descripción de la actividad</param>
		public Activity(String name,String description)
		{
			// Llamada necesaria para el Diseñador de formularios Windows.Forms.
			InitializeComponent();

			this.name=name;
			this.description=description;
			this.Width=50;
			this.Height=50;
		}

		/// <summary>
		/// Limpiar los recursos que se estén utilizando.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if( components != null )
					components.Dispose();
			}
			base.Dispose( disposing );
		}

		#region Código generado por el Diseñador de componentes
		/// <summary>
		/// Método necesario para admitir el Diseñador. No se puede modificar 
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(Activity));
			this.pictureBoxPaso = new System.Windows.Forms.PictureBox();
			this.pictureBoxInicio = new System.Windows.Forms.PictureBox();
			this.pictureBoxFinal = new System.Windows.Forms.PictureBox();
			// 
			// pictureBoxPaso
			// 
			this.pictureBoxPaso.Image = ((System.Drawing.Image)(resources.GetObject("pictureBoxPaso.Image")));
			this.pictureBoxPaso.Location = new System.Drawing.Point(17, 17);
			this.pictureBoxPaso.Name = "pictureBoxPaso";
			this.pictureBoxPaso.TabIndex = 0;
			this.pictureBoxPaso.TabStop = false;
			// 
			// pictureBoxInicio
			// 
			this.pictureBoxInicio.Image = ((System.Drawing.Image)(resources.GetObject("pictureBoxInicio.Image")));
			this.pictureBoxInicio.Location = new System.Drawing.Point(144, 17);
			this.pictureBoxInicio.Name = "pictureBoxInicio";
			this.pictureBoxInicio.TabIndex = 0;
			this.pictureBoxInicio.TabStop = false;
			// 
			// pictureBoxFinal
			// 
			this.pictureBoxFinal.Image = ((System.Drawing.Image)(resources.GetObject("pictureBoxFinal.Image")));
			this.pictureBoxFinal.Location = new System.Drawing.Point(275, 17);
			this.pictureBoxFinal.Name = "pictureBoxFinal";
			this.pictureBoxFinal.TabIndex = 0;
			this.pictureBoxFinal.TabStop = false;

		}
		#endregion
		/// <summary>Indica si una actividad esta seleciconada o no</summary>
		public bool Selected
		{
			get
			{
				return selected;
			}
			set
			{
				selected=value;
			}
		}
		/// <summary>Regresa el nombre de la actividad</summary>
		/// <value>Regresa el nombre de la actividad</value>
		public String ActivityName
		{
			get
			{
				return name;
			}
		}
		/// <summary>Propiedad que regresa el paso en el que se encuentra</summary>
		/// <value>Regresa el paso en el que se encuentra</value>
		public String Step
		{
			get
			{
				return step;
			}
			set
			{
				step=value;
			}
		}
		/// <summary>Propiedad que regresa la descripción de la actividad</summary>
		/// <value>Regresa la descripción de la actividad</value>
		public String Description
		{
			get
			{
				return description;
			}
		}
		/// <summary>Regresa un array con las actividades con las que se encuentra ligado</summary>
		/// <value>Regresa un array con las actividades con las que se encuentra ligado</value>
		public ArrayList Links
		{
			get
			{
				return links;
			}
		}
		/// <summary>Indica el color seleccionado</summary>
		/// <value>Regresa el color con el cual se mostrará la actividad</value>
		public Color SelectedColor
		{
			get
			{
				return colorSelected;
			}
		}
		/// <summary>
		/// Función para dibujar una actividad
		/// </summary>
		/// <param name="pe"></param>
		protected override void OnPaint(PaintEventArgs pe)
		{
			if(selected)
			{
				this.BackColor=colorSelected;
			}
			pe.Graphics.DrawImage(this.pictureBoxPaso.Image,0,0,this.Height,this.Width);
			pe.Graphics.DrawString(this.step,new Font(new FontFamily("Verdana"),10),Brushes.Black,15,0);
			base.OnPaint(pe);
		}
	}
}
