/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 


/*
 * ImgaePreview.java
 *
 * Created on 15 de noviembre de 2004, 06:59 PM
 */

package applets.htmleditor;

import javax.swing.*;
import java.applet.*;
import java.awt.*;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class ImagePreview extends JComponent
{
    
    Image img=null;
    int width=0;
    int height=0;
    String filePath=null;
    String fileSize="0";
    String fileDate=null;
    
    int orig_width=0;
    int orig_height=0;
    
    /** Creates new form BeanForm */
    public ImagePreview()
    {
        initComponents();
    }
    
    public void setImage(Image img)
    {
        this.img=img;
        orig_width=img.getWidth(this);
        orig_height=img.getHeight(this);
        width=orig_width;
        height=orig_height;
        this.setSize(width,height);
        this.setPreferredSize(new Dimension(width,height));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents()//GEN-BEGIN:initComponents
    {
        
    }//GEN-END:initComponents
    
    public void paint(Graphics g)
    {
        System.out.println("w:"+width+" h:"+height);
        if(img!=null)
        {
            g.drawImage(img,0,0,width,height,this);
        }
    }
    
    public int getImageWidth()
    {
        return width;
    }
    
    
    public void setImageWidth(int width)
    {
        this.width=width;
        this.setSize(width,height);
        this.setPreferredSize(new Dimension(width,height));
    }
    
    
    public int getImageHeight()
    {
        return height;
    }

    
    public void setImageHeight(int height)
    {
        this.height=height;
        this.setSize(width,height);
        this.setPreferredSize(new Dimension(width,height));
    }
    
    public int getOrigImageWidth()
    {
        return orig_width;
    }
    
    
    public void setOrigImageWidth(int width)
    {
        this.orig_width=width;
    }
    
    
    public int getOrigImageHeight()
    {
        return orig_height;
    }

    
    public void setOrigImageHeight(int height)
    {
        this.orig_height=height;
    }    
    
    
    public boolean getScrollableTracksViewportWidth()
    {
        return false;
    }
    
    public boolean getScrollableTracksViewportHeight()
    {
        return false;
    }
    
    public int getScaleX()
    {
        return (int)(((double)(width*100))/orig_width);
    }

    public int getScaleY()
    {
        return (int)(((double)(height*100))/orig_height);
    }
    
    public void setScaleX(int scalex)
    {
        setImageWidth((int)(((double)(scalex*orig_width))/100));
    }

    public void setScaleY(int scaley)
    {
        setImageHeight((int)(((double)(scaley*orig_height))/100));
    }    

    /**
     * Getter for property filePath.
     * @return Value of property filePath.
     */
    public java.lang.String getFilePath()
    {
        return filePath;
    }    
    
    /**
     * Setter for property filePath.
     * @param filePath New value of property filePath.
     */
    public void setFilePath(java.lang.String filePath)
    {
        this.filePath = filePath;
    }
    
    /**
     * Getter for property fileSize.
     * @return Value of property fileSize.
     */
    public String getFileSize()
    {
        return fileSize;
    }
    
    /**
     * Setter for property fileSize.
     * @param fileSize New value of property fileSize.
     */
    public void setFileSize(String fileSize)
    {
        this.fileSize = fileSize;
    }
    
    /**
     * Getter for property fileDate.
     * @return Value of property fileDate.
     */
    public java.lang.String getFileDate()
    {
        return fileDate;
    }
    
    /**
     * Setter for property fileDate.
     * @param fileDate New value of property fileDate.
     */
    public void setFileDate(java.lang.String fileDate)
    {
        this.fileDate = fileDate;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
