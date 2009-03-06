/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * JActivityFlowPanel.java
 *
 * Created on 9 de noviembre de 2004, 09:48 PM
 */

package applets.workflowadmin;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics2D;
/**
 * Clase uqe maneja graficamente las actividades, esta clase esta asociada con el
 * modelo de actividades gr�ficas y con ActiviG.
 * @author Victor Lorenzana
 */
public class JActivityFlowPanel extends JPanel implements MouseListener,MouseMotionListener{
    
    /** Creates a new instance of JActivityFlowPanel */
    jTableActivitiesModel model;    
    JTable table;
    ActivityGModel modelg=null;
    Locale locale;
    String activityName;
    public JActivityFlowPanel(jTableActivitiesModel model,JTable table,Locale locale,String  activityName,boolean edit) {
       this.locale=locale;
       modelg=new ActivityGModel(locale);
       this.model=model;     
       this.table=table;                   
       this.activityName=activityName;
       if(this.activityName==null)
       {
           this.activityName="";           
       }
       if(edit)
       {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
       }
       
    }
     public JActivityFlowPanel(jTableActivitiesModel model,JTable table,Locale locale) {
       this(model, table, locale,null,true);       
    }
    public void paint(Graphics g)
    {   
        modelg.clear();        
        table.setModel(modelg);        
        
        this.setBackground(Color.WHITE);
        g.clearRect(0,0,this.getWidth(), this.getHeight());
        int width=((this.model.size()+2)*100);
        int step=1;
        Color green=new Color(0,102,51);
        this.setPreferredSize(new Dimension(width,300));
        Color blue=new Color(0,153,204);
        Color red=new Color(255,51,51);
        int y=40;         
        int x=50;        
        ActivityG init=new ActivityG(x, y,new AuthorActivity(locale),String.valueOf(step),"inicio.gif");        
        modelg.addActivity(init);
        if(model.size()>0)
        {
            g.setColor(green);
            g.drawArc(init.getX()+25, init.getY()-25, 100, 50, 0, 180);
        }
        init.setColor(blue);        
        for(int i=1;i<this.model.size()+1;i++)
        {
            step++;
            x=(100*i)+50;            
            Activity activity=this.model.getActivity(i-1);
            if(activity.getName().equals(this.activityName))
            {
                g.setColor(new Color(0,128,128));
                //g.drawRect(x,y, 40, 50);
                Graphics2D g2d = ( Graphics2D ) g;
                g2d.fill(new Rectangle2D.Float(x+5,y, 40,50));
                g2d.fill(new Rectangle2D.Float(10,140, 10,10));
                g.drawString(java.util.ResourceBundle.getBundle("applets/workflowadmin/JActivityFlowPanel",locale).getString("leyend"),30,150);
            }
            ActivityG act=new ActivityG(x, y,activity,String.valueOf(step),"paso.gif");
            modelg.addActivity(act);            
            act.setColor(new Color(51,102,255));
        }
        step++;
        x=(100*(this.model.size()+1))+50;      
        ActivityG fin=new ActivityG(x, y,new EndActivity(locale),String.valueOf(step),"final.gif");
        modelg.addActivity(fin);
        fin.setColor(red);        
        Iterator it=modelg.iterator();
        while(it.hasNext())
        {
            ActivityG act=(ActivityG)it.next();
            act.paint(g);
            Iterator links=act.getLinks().iterator();
            while(links.hasNext())
            {
                Link link=(Link)links.next();                
                Color color=green;
                if(!link.getType().equals("authorized"))
                {
                    color=red;
                }                
                Activity to=link.getActivityTo();
                Iterator activities=modelg.iterator();
                while(activities.hasNext())
                {
                    ActivityG gto=(ActivityG)activities.next();
                    if(gto.equals(to))
                    {
                        g.setColor(color);
                        if(color==red)
                        {
                            if((gto.getX()-act.getX())>0)
                            {
                                g.drawArc(act.getX()+25, act.getY()+25, gto.getX()-act.getX(), 50, 0, -180);
                                
                            }
                            else
                            {
                                g.drawArc(gto.getX()+25, gto.getY()+25, act.getX()-gto.getX(), 50, 0, -180);
                            }
                        }
                        else
                        {
                            if((gto.getX()-act.getX())>0)
                            {
                                g.drawArc(act.getX()+25, act.getY()-25, gto.getX()-act.getX(), 50, 0, 180);                                
                                //g.drawLine(gto.getX()+25, gto.getY()-25, 0, 0);
                            }
                            else
                            {
                                g.drawArc(gto.getX()+25, gto.getY()-25, act.getX()-gto.getX(), 50, 0, 180);
                            }
                        }
                    }
                }
            }
        }
        this.table.getColumnModel().getColumn(0).setWidth(50);       
        this.table.getColumnModel().getColumn(0).setMinWidth(50);
        this.table.getColumnModel().getColumn(0).setMaxWidth(50);
        this.table.updateUI();
    }
    
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==e.BUTTON1 && e.getClickCount()==2)
        {
           int l=this.modelg.getRowCount();
           for(int i=0;i<l;i++)
           {
               ActivityG activityg=this.modelg.getActivity(i);
               if(activityg.has(e.getX(),e.getY()))
               {
                    Activity activity=activityg.getActivity();
                    if(!(activity instanceof EndActivity) && !(activity instanceof AuthorActivity))
                    {
                        ActivityEdition frm=new ActivityEdition(activity,this.model,locale);
                        frm.setModal(true);
                        frm.setLocation(200,200);
                        frm.setSize(500,400);
                        frm.show(); 
                        this.updateUI();
                        this.table.updateUI();
                    }                   
               }
           }
        }
    }    
    
    public void mouseEntered(MouseEvent e) {
    }    
    
    public void mouseExited(MouseEvent e) {
    }    
       
    public void mousePressed(MouseEvent e) {
    }    
    
    public void mouseReleased(MouseEvent e) {
    }    
    
    public void mouseDragged(MouseEvent e) {
    }    
    
    public void mouseMoved(MouseEvent e) {
       int l=this.modelg.getRowCount();
       for(int i=0;i<l;i++)
       {
           ActivityG activityg=this.modelg.getActivity(i);
           if(activityg.has(e.getX(),e.getY()))
           {
                Activity activity=activityg.getActivity();
                if(!(activity instanceof EndActivity) && !(activity instanceof AuthorActivity))
                {                   
                    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    return;
                }                                   
           }
       }
       this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}
