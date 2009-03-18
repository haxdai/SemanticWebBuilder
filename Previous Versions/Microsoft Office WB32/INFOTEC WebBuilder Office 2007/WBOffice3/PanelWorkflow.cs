/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Windows.Forms;
using System.Collections;
using System.Drawing;
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>
	/// Panel donde se muestran los controles de actividad para un flujo de
	/// publicación
	/// </summary>
	public class PanelWorkflow : Panel
	{
		String leyenda="Actividad actual";
		ArrayList activities;
		AuthorActivity init=null;
		EndActivity end=null;
		String activityShow;
		ListView listview;
		/// <summary>
		/// Crea un panel con las actividades de un flujo de publicación, y muestra resaltado
		/// la actividad activityshow
		/// </summary>
		/// <param name="activities">Actividades de un flujo</param>
		/// <param name="activityShow">Actividad a resaltar</param>
		/// <param name="listview">Lista de actividades en formato de Listview</param>
		public PanelWorkflow(ArrayList activities,String activityShow,ListView listview)
		{			
			this.listview=listview;
			this.activityShow=activityShow;
			this.BackColor=Color.FromKnownColor(KnownColor.White);
			this.activities=activities;			
			foreach(Activity activity in this.activities)
			{
				if(activityShow==activity.ActivityName)
				{
					activity.Selected=true;
				}
				this.Controls.Add(activity);
				if(activity is AuthorActivity)
				{
					init=(AuthorActivity)activity;
				}
				if(activity is EndActivity)
				{
					end=(EndActivity)activity;
				}
			}
			this.activities.Remove(init);
			this.activities.Remove(end);						
			this.Paint+=new PaintEventHandler(paintActivties);						
		}
		/// <summary>Leyenda a mostrar</summary>
		/// <value>Leyenda a mostrar</value>
		public String Leyenda
		{
			get
			{
				return leyenda;
			}
			set
			{
				leyenda=value;
			}
		}
		/// <summary>Muestra las actividades</summary>
		private void paintActivties(object obj,PaintEventArgs args)
		{		
			
			SolidBrush sb=new SolidBrush(init.SelectedColor);
			args.Graphics.FillRectangle(sb,10,133,10,10);
			args.Graphics.DrawString(this.leyenda,new Font("Verdana",10),sb,20f,130f);
			listview.Items.Clear();
			int istep=1;
			Graphics g=args.Graphics;
			this.activities.Remove(end);
			int y=40;         
			int x=50; 
			init.Location=new Point(x,y);			
			init.Step=Convert.ToString(istep);
			string[] sitem=new string[3];
			sitem[0]=init.Step;
			sitem[1]=init.ActivityName;
			sitem[2]=init.Description;
			listview.Items.Add(new ListViewItem(sitem));
			g.DrawArc(Pens.Green,x+25,y-25, 100, 50, 0, -180);			
			int i=1;
			istep++;
			foreach(Activity activity in this.activities)
			{
				activity.Step=Convert.ToString(istep);
				x=(100*i)+50;            
				activity.Location=new Point(x,y);								
				i++;
				istep++;
				sitem=new string[3];
				sitem[0]=activity.Step;
				sitem[1]=activity.ActivityName;
				sitem[2]=activity.Description;
				listview.Items.Add(new ListViewItem(sitem));
			}
			end.Step=Convert.ToString(istep);
			x=(100*(this.activities.Count+1))+50;      
			end.Location=new Point(x,y);		
			sitem=new string[3];
			sitem[0]=end.Step;
			sitem[1]=end.ActivityName;
			sitem[2]=end.Description;
			listview.Items.Add(new ListViewItem(sitem));
			foreach(Activity activityf in this.activities)
			{
				Pen color=Pens.Green;
				foreach(Link link in activityf.Links)
				{
					if(link.Type!="authorized")
					{
						color=Pens.Red;
					} 
					else
					{
						color=Pens.Green;
					}
					Activity activity=link.From;
					Activity gto=link.To;
					if(color==Pens.Red)
					{
						if((gto.Location.X-activity.Location.X)>0)
						{
							args.Graphics.DrawArc(color,activity.Location.X+25, activity.Location.Y+25, gto.Location.X-activity.Location.X, 50, 0, 180);
                                
						}
						else
						{
							try
							{
								args.Graphics.DrawArc(color,gto.Location.X+25, gto.Location.Y+25, activity.Location.X-gto.Location.X, 50, 0, 180);
							}
							catch(Exception ue)
							{
								Debug.WriteLine(ue.Message);
							}
						}
					}
					else
					{
						if((gto.Location.X-activity.Location.X)>0)
						{
							args.Graphics.DrawArc(color,activity.Location.X+25, activity.Location.Y-25, gto.Location.X-activity.Location.X, 50, 0, -180);                                
							//g.drawLine(gto.getX()+25, gto.getY()-25, 0, 0);
						}
						else
						{
							try
							{
								args.Graphics.DrawArc(color,gto.Location.X+25, gto.Location.Y-25, activity.Location.X-gto.Location.X, 50, 0, -180);
							}
							catch(Exception ue)
							{
								Debug.WriteLine(ue.Message);
							}
						}
					}
				}
			}
		}

	}
}
