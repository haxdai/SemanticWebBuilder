/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ftp.java
 *
 * Created on 20/04/2012, 02:50:03 PM
 */
package applets.ftp;

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.net.URL;
import java.util.Locale;

/**
 *
 * @author victor.lorenzana
 */
public class ftp extends javax.swing.JApplet implements DropTargetListener
{

    public final String PRM_JSESS = "jsess";
    private final String PRM_CGIPATH = "cgipath";
    private final String PRM_UPLOADPATH = "uploadpath";
    private final String PRM_DOWNLOADPATH = "downloadpath";

    @Override
    public void init()
    {

        Locale locale = Locale.getDefault();
        if (this.getParameter("locale") != null && !this.getParameter("locale").equals(""))
        {
            try
            {

                locale = new Locale(this.getParameter("locale"));
            }
            catch (Exception e)
            {
                e.printStackTrace(System.out);
            }
        }



        initComponents();

        String jsess = this.getParameter(PRM_JSESS);
        String cgiPath = this.getParameter(PRM_CGIPATH);
        String uploadpath = this.getParameter(PRM_UPLOADPATH);
        String downloadpath = this.getParameter(PRM_DOWNLOADPATH);
        URL url = null;
        try
        {
            url = new URL(getCodeBase().getProtocol(), getCodeBase().getHost(), getCodeBase().getPort(), cgiPath);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            URL urldownload = new URL(getCodeBase().getProtocol(), getCodeBase().getHost(), getCodeBase().getPort(), downloadpath);
            URL urlupload = new URL(getCodeBase().getProtocol(), getCodeBase().getHost(), getCodeBase().getPort(), uploadpath);

            ftpPanel panel = new ftpPanel(jsess, locale, urlupload, urldownload, url, null, this);
            getContentPane().add(panel, java.awt.BorderLayout.CENTER);
            java.awt.dnd.DropTarget dt = new DropTarget(panel, this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }





    }

    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void dragEnter(DropTargetDragEvent dtde)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dragExit(DropTargetEvent dte)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void drop(DropTargetDropEvent dtde)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
