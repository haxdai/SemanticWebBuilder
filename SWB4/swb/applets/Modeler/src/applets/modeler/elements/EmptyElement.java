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
 * StartElement.java
 *
 * Created on 17 de enero de 2006, 12:23 PM
 */

package applets.modeler.elements;

import com.sun.org.apache.regexp.internal.recompile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class EmptyElement extends GraphElement
{
    Color col=new Color(200,200,200);
    /** Creates a new instance of StartElement */
    public EmptyElement()
    {
        setMaxChilds(0);
        setMinChilds(0);
        setNumChilds(0);
        setTitle("Empty");    
    }
    
    public void paintElement(Graphics g)
    {
        Rectangle rec=getBounds();
        int x=(int)rec.getX();
        int y=(int)rec.getY();
        int w=(int)getWidth();
        int h=(int)rec.getHeight();        
//        if(haveFocus())
//            g.setColor(Color.RED);
//        else
//            g.setColor(Color.BLUE);
        
        g.setColor(col);
        g.drawRoundRect(x, y, w, h,w/3,h/3);
//        g.setColor(Color.BLACK);
        int l=g.getFontMetrics().stringWidth(getTitle());
        g.drawString(getTitle(), x+(w-l)/2,y+h/2+5);
        
    }    
     
}
