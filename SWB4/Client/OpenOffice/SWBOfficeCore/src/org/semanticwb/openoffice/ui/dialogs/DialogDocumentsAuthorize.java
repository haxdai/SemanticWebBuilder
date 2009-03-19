/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogDocumentsAtuhorize.java
 *
 * Created on 2/03/2009, 03:28:19 PM
 */
package org.semanticwb.openoffice.ui.dialogs;

import java.awt.Frame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.semanticwb.office.interfaces.FlowContentInformation;
import org.semanticwb.office.interfaces.ResourceInfo;
import org.semanticwb.office.interfaces.WebSiteInfo;
import org.semanticwb.openoffice.OfficeApplication;
import org.semanticwb.openoffice.ui.icons.ImageLoader;

/**
 *
 * @author victor.lorenzana
 */
public class DialogDocumentsAuthorize extends java.awt.Dialog
{

    /** Creates new form DialogDocumentsAtuhorize */
    public DialogDocumentsAuthorize()
    {
        super((Frame) null, ModalityType.TOOLKIT_MODAL);
        this.setIconImage(ImageLoader.images.get("semius").getImage());
        this.setModal(true);
        initComponents();
        this.setLocationRelativeTo(null);
        ListSelectionModel listSelectionModel = jTableContents.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener()
        {

            public void valueChanged(ListSelectionEvent e)
            {
                jButtonAuthorize.setEnabled(false);
                jButtonReject.setEnabled(false);
                jButtonSee.setEnabled(false);
                if (e.getFirstIndex() != -1)
                {
                    jButtonAuthorize.setEnabled(true);
                    jButtonSee.setEnabled(true);
                    jButtonReject.setEnabled(true);
                }
            }
        });
        loadSites();
        loadContents();
    }

    private void loadSites()
    {
        this.jComboBoxSites.removeAllItems();
        try
        {
            for (WebSiteInfo site : OfficeApplication.getOfficeApplicationProxy().getSites())
            {
                jComboBoxSites.addItem(site);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void loadContents()
    {
        DefaultTableModel model = (DefaultTableModel) jTableContents.getModel();
        int rows = model.getRowCount();
        for (int i = 1; i <= rows; i++)
        {
            model.removeRow(0);
        }
        try
        {
            for (FlowContentInformation flowContentInformation : OfficeApplication.getOfficeApplicationProxy().getContentsForAuthorize())
            {
                ResourceInfo resourceInfo = flowContentInformation.resourceInfo;
                String version = flowContentInformation.resourceInfo.version;
                if (version.equals("*"))
                {
                    version = "Mostrar la última version";
                }
                Object[] rowData =
                {
                    resourceInfo, resourceInfo.page.site.title, resourceInfo.page.title, version
                };
                model.addRow(rowData);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelCommands = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jPanelTools = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonSee = new javax.swing.JButton();
        jButtonAuthorize = new javax.swing.JButton();
        jButtonReject = new javax.swing.JButton();
        jPanelContents = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBoxSites = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContents = new javax.swing.JTable();

        setResizable(false);
        setTitle("Documentos por autorizar");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanelCommands.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelCommands.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonClose.setText("Cerrar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        jPanelCommands.add(jButtonClose);

        add(jPanelCommands, java.awt.BorderLayout.SOUTH);

        jPanelTools.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelTools.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonSee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/see.png"))); // NOI18N
        jButtonSee.setToolTipText("Ver Contenido");
        jButtonSee.setEnabled(false);
        jButtonSee.setFocusable(false);
        jButtonSee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeeActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonSee);

        jButtonAuthorize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/icono_autorizar.png"))); // NOI18N
        jButtonAuthorize.setToolTipText("Autorizar contenido");
        jButtonAuthorize.setEnabled(false);
        jButtonAuthorize.setFocusable(false);
        jButtonAuthorize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAuthorize.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAuthorize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAuthorizeActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAuthorize);

        jButtonReject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/icon_rechazar.png"))); // NOI18N
        jButtonReject.setToolTipText("Rechazar contenido");
        jButtonReject.setEnabled(false);
        jButtonReject.setFocusable(false);
        jButtonReject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonReject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRejectActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonReject);

        jPanelTools.add(jToolBar1, java.awt.BorderLayout.CENTER);

        add(jPanelTools, java.awt.BorderLayout.NORTH);

        jPanelContents.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(100, 30));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Todos");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Mis contenidos");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Por autorizar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jComboBoxSites, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelContents.add(jPanel4, java.awt.BorderLayout.NORTH);

        jTableContents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Página", "Paso", "Versión"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableContents);

        jPanelContents.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanelContents, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCloseActionPerformed
    {//GEN-HEADEREND:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonSeeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSeeActionPerformed
    {//GEN-HEADEREND:event_jButtonSeeActionPerformed
        if(this.jTableContents.getSelectedRow()!=-1)
        {
            DefaultTableModel model=(DefaultTableModel)this.jTableContents.getModel();
            ResourceInfo info=(ResourceInfo)model.getValueAt(this.jTableContents.getSelectedRow(), 0);
            String version=info.version;
            
        }
    }//GEN-LAST:event_jButtonSeeActionPerformed

    private void jButtonAuthorizeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAuthorizeActionPerformed
    {//GEN-HEADEREND:event_jButtonAuthorizeActionPerformed
        if(this.jTableContents.getSelectedRow()!=-1)
        {
            DefaultTableModel model=(DefaultTableModel)this.jTableContents.getModel();
        }
    }//GEN-LAST:event_jButtonAuthorizeActionPerformed

    private void jButtonRejectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonRejectActionPerformed
    {//GEN-HEADEREND:event_jButtonRejectActionPerformed
        if(this.jTableContents.getSelectedRow()!=-1)
        {
            DefaultTableModel model=(DefaultTableModel)this.jTableContents.getModel();
        }
    }//GEN-LAST:event_jButtonRejectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAuthorize;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonReject;
    private javax.swing.JButton jButtonSee;
    private javax.swing.JComboBox jComboBoxSites;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCommands;
    private javax.swing.JPanel jPanelContents;
    private javax.swing.JPanel jPanelTools;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContents;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
