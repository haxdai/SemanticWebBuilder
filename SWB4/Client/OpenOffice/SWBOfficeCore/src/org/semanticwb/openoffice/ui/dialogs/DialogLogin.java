/*
 * DialogLogin.java
 *
 * Created on 3 de junio de 2008, 10:28 AM
 */
package org.semanticwb.openoffice.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.image.ImageObserver;
import java.net.URI;
import org.semanticwb.openoffice.*;
import org.semanticwb.openoffice.ui.icons.ImageLoader;

/**
 *
 * @author  victor.lorenzana
 */
public class DialogLogin extends javax.swing.JDialog implements ImageObserver
{   
    public boolean canceled = true;
    public URI webAddress;
    public String login,  password;
    ConfigurationListURI configurationListURI = new ConfigurationListURI();

    /** Creates new form DialogLogin */
    public DialogLogin()
    {
        super((Frame)null, ModalityType.TOOLKIT_MODAL);
        initComponents();
        this.setIconImage(ImageLoader.images.get("semius").getImage());
        this.setModal(true);
        this.add(new BackGroundImagePanel(this),BorderLayout.CENTER);
        this.setSize(505, 335);
        setLocationRelativeTo(null);

    }

    public boolean isCanceled()
    {
        return canceled;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public URI getWebAddress()
    {
        return webAddress;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acceso a servicio de publicación");
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
