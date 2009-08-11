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
 * DialogSummaryPublish.java
 *
 * Created on 4 de junio de 2008, 11:38 AM
 */
package org.semanticwb.openoffice.ui.dialogs;

import java.awt.Cursor;
import java.awt.Frame;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.semanticwb.openoffice.OfficeApplication;
import org.semanticwb.openoffice.OfficeDocument;
import org.semanticwb.openoffice.ui.icons.ImageLoader;
import org.semanticwb.xmlrpc.Attachment;

/**
 *
 * @author  victor.lorenzana
 */
public class DialogUpdateContent extends javax.swing.JDialog
{

    private boolean updated = false;
    private String workspaceid,  contentid;
    private OfficeDocument document;

    class Update extends Thread
    {

        File zipFile;
        JDialog dialog;

        public Update(File zipFile, JDialog dialog)
        {
            this.zipFile = zipFile;
            this.dialog = dialog;
        }

        @Override
        public void run()
        {
            try
            {
                dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                jLabel1.setText("Enviando archivo de publicación " + zipFile.getName());
                jLabel1.repaint();
                String name = document.getLocalPath().getName().replace(document.getDefaultExtension(), document.getPublicationExtension());
                document.getOfficeDocumentProxy().updateContent(workspaceid, contentid, name);
                jProgressBar.setValue(2);
                jLabel1.setText("Actualización terminada");
                summaryPublish1.loadVersions(contentid, workspaceid);
                jButtonUpdate.setEnabled(false);
                JOptionPane.showMessageDialog(dialog, "¡Contenido actualizado!", dialog.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Actualización de contenido", JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                if (zipFile != null && zipFile.exists())
                {
                    zipFile.delete();
                }
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    
    /** Creates new form DialogSummaryPublish */
    public DialogUpdateContent(String wokspaceid, String contentid, OfficeDocument document)
    {
        super((Frame)null, ModalityType.TOOLKIT_MODAL);
        initComponents();
        this.setIconImage(ImageLoader.images.get("semius").getImage());
        summaryPublish1.setType(document.getDocumentType().toString().toLowerCase());
        this.setModal(true);
        this.workspaceid = wokspaceid;
        this.contentid = contentid;
        summaryPublish1.loadVersions(contentid, wokspaceid);
        this.document = document;
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();
        jButtonUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        summaryPublish1 = new org.semanticwb.openoffice.ui.wizard.SummaryPublish();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizacón de contenido");
        setModal(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(350, 50));

        jButtonClose.setText("Cerrar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jProgressBar.setMaximum(2);
        jProgressBar.setBorderPainted(false);
        jProgressBar.setOpaque(true);
        jProgressBar.setStringPainted(true);

        jButtonUpdate.setText("Actualizar");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione la opción de actualizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClose))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonClose)
                        .addComponent(jButtonUpdate))
                    .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        summaryPublish1.setPreferredSize(new java.awt.Dimension(400, 250));
        getContentPane().add(summaryPublish1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
    if (!updated)
    {
        File zipFile = null;
        try
        {
            int limit = OfficeApplication.getOfficeApplicationProxy().getLimitOfVersions();
            if (limit > 0)
            {
                int versions = OfficeApplication.getOfficeDocumentProxy().getNumberOfVersions(workspaceid, contentid);
                if (OfficeApplication.getOfficeDocumentProxy().allVersionsArePublished(workspaceid, contentid))
                {
                    if (versions >= limit)
                    {
                        int resp=JOptionPane.showConfirmDialog(this, "¡El limite máximo de versiones es de " + limit + "!\r\nPuede publicar este contenido, debido a que tiene todas las versiones publicadas, pero excederá del límite de versiones\r\n¿Desea continuar?", this.getTitle(), JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(resp==JOptionPane.NO_OPTION)
                        {
                            return;
                        }
                    }
                }
                else
                {                    
                    if (versions >= limit)
                    {
                        JOptionPane.showMessageDialog(this, "¡El limite máximo de versiones es de " + limit + "!\r\nSi desea crear una nueva version, debe borrar alguna de las existentes, que no este publicada.", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            jProgressBar.setMaximum(2);
            this.jLabel1.setText("Creando archivo para publicación ...");
            jLabel1.repaint();
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            jProgressBar.setValue(0);
            zipFile = document.createZipFile();
            this.jLabel1.setText("Archivo de publicación creado");
            jLabel1.repaint();
            jProgressBar.setValue(1);
            document.getOfficeDocumentProxy().addAttachment(new Attachment(zipFile, zipFile.getName()));
            Update up = new Update(zipFile, this);
            up.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
        }

    }

    updated = true;
}//GEN-LAST:event_jButtonUpdateActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar;
    private org.semanticwb.openoffice.ui.wizard.SummaryPublish summaryPublish1;
    // End of variables declaration//GEN-END:variables
}
