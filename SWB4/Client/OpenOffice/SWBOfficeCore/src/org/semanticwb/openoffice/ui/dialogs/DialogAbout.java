/*
 * DialogAbout.java
 *
 * Created on 4 de junio de 2008, 04:04 PM
 */

package org.semanticwb.openoffice.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Frame;
import org.semanticwb.openoffice.ui.icons.ImageLoader;

/**
 *
 * @author  victor.lorenzana
 */
public class DialogAbout extends javax.swing.JDialog {
    
    /** Creates new form DialogAbout */
    public DialogAbout() {
        super((Frame)null, ModalityType.TOOLKIT_MODAL);
        initComponents();
        AboutBackGound panel=new AboutBackGound(this);
        this.setSize(505, 335);
        this.add(panel,BorderLayout.CENTER);
        this.setIconImage(ImageLoader.images.get("semius").getImage());
        this.setModal(true);                
        setLocationRelativeTo(null);                
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de Semantic INFOTEC WebBuilder 4");
        setModal(true);
        setResizable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String[] args)
    {
        DialogAbout DialogAbout=new DialogAbout();
        DialogAbout.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
