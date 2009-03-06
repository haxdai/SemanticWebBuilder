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
 * ActivityG.java
 *
 * Created on 9 de noviembre de 2004, 10:08 PM
 */

package applets.workflowadmin;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.Line2D;

/**
 * Clase que representa una actidad gr�ficamente, esta clase se utiliza dentro del
 * formulario que mustra el flujo en la pesta�a de dise�o.
 * @author Victor Lorenzana
 */
public class ActivityG {
    
    /** Creates a new instance of ActivityG */
    Links links=new Links();
    Color color;
    int x;
    int y;
    Graphics g;
    Activity activity;
    String step;
    boolean selected=false;
    String image;
    public ActivityG(int x,int y,Activity activity,String step,String image) {
        this.x=x;
        this.y=y;
        this.activity=activity;
        this.step=step;
        this.image=image;
    }
   
    public Activity getActivity()
    {
        return activity;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public String getStep()
    {
        return step;
    }
    public Links getLinks()
    {
        return this.activity.getLinks();
    }    
    public String getName()
    {
        return activity.getName();
    }
    public String getDescription()
    {
        return activity.getDescription();
    }    
    public void paint(Graphics g)
    {
        this.g=g;
        g.setFont(new Font("Verdana", Font.BOLD, g.getFont().getSize()));
        /*g.setColor(this.color);
        g.fillOval(x,y, 50,50);*/
        javax.swing.ImageIcon icon=new javax.swing.ImageIcon(getClass().getResource("/applets/workflowadmin/images/"+image));        
        g.drawImage(icon.getImage(),x+5,y,icon.getImageObserver());       
        g.setColor(new Color(42,82,22));
        g.drawString(this.step, x+20,y+12);        
        
    }
    public boolean has(int x,int y)
    {        
        
        double d=Point.distance((double)x,(double)y,(double)this.x+20,(double)this.y+12);        
        if(d<=30D)
        {
            return true;
        }        
        return false;
    }    
    public void setColor(Color color)
    {
        this.color=color;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
        
    }
    public boolean equals(Object obj)
    {
        if(obj instanceof Activity)
        {
            Activity activity=(Activity)obj;
            if(this.activity.equals(activity))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
}
