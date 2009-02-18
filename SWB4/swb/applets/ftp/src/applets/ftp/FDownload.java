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
 * FDownload.java
 *
 * Created on 16 de noviembre de 2004, 06:52 PM
 */

package applets.ftp;

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
/**
 * Formulario para descarga de archivos, muestra el avance de la descarga.
 * @author Victor Lorenzana
 */
public class FDownload extends javax.swing.JDialog {
    
    /** Creates new form FDownload */
    
    java.io.File f;    
    URL url;
    String path;
    String jsess;
    Locale locale;
    public FDownload(java.awt.Frame parent, boolean modal,String path,java.io.File f,String jsess,URL url,Locale locale) {
        super(parent, modal);
        initComponents();
        this.setTitle(f.getName());
        this.f=f;        
        this.path=path;
        this.jsess=jsess;
        this.url=url;
        this.locale=locale;
    }
    public void getFile() {
        this.setVisible(true);
        Worker w=new Worker();
        w.start();
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jProgressBar1 = new javax.swing.JProgressBar();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        getContentPane().add(jProgressBar1, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_closeDialog
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    private class Worker extends Thread
    {
        public void run()
        {
            try
            {

                FileOutputStream out=new FileOutputStream(f);
                URLConnection con=url.openConnection();
                con.setUseCaches(false);
                if(jsess!=null)con.setRequestProperty("Cookie","JSESSIONID="+jsess);
                con.addRequestProperty("PATHFILEWB",path);
                con.setDoInput(true);
                InputStream in=con.getInputStream();
                byte[] bcont=new byte[8192];
                String contentLength=con.getHeaderField("Content-Length");                
                int size=0;
                try
                {
                    size=Integer.parseInt(contentLength);
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                int packs=(size/8192)+1;
                jProgressBar1.setMaximum(packs);
                jProgressBar1.setMinimum(0);
                jProgressBar1.setValue(0);
                jProgressBar1.setStringPainted(true);
                int ipack=0;
                int ret=in.read(bcont);
                while(ret!=-1)
                {
                    out.write(bcont,0,ret);
                    ipack++;                    
                    jProgressBar1.setValue(ipack);
                    jProgressBar1.updateUI();                    
                    ret=in.read(bcont);
                }               
                in.close();
                out.close();                                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage(),java.util.ResourceBundle.getBundle("applets/ftp/ftp",locale).getString("title"),JOptionPane.ERROR_MESSAGE);            
            } 
            setVisible(false);
            dispose();
        }
    }
}
