/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogCalendar.java
 *
 * Created on 12/02/2009, 03:11:52 PM
 */

package org.semanticwb.openoffice.ui.dialogs;

import java.awt.Frame;
import javax.swing.JSpinner;
import org.w3c.dom.Document;


/**
 *
 * @author victor.lorenzana
 */
public class DialogCalendar extends java.awt.Dialog {

    private Document document;
    /** Creates new form DialogCalendar */
    public DialogCalendar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jSpinnerInitDate.setEditor(new JSpinner.DateEditor(jSpinnerEndDate,"dd/MM/yyyy"));
        this.jSpinnerEndDate.setEditor(new JSpinner.DateEditor(jSpinnerEndDate,"dd/MM/yyyy"));

        this.jSpinnerInitTime.setEditor(new JSpinner.DateEditor(jSpinnerInitTime,"HH:mm:ss"));
        this.jSpinnerEndTime.setEditor(new JSpinner.DateEditor(jSpinnerEndTime,"HH:mm:ss"));
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
        jPanel2 = new javax.swing.JPanel();
        jButtonRegularPeriods = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanelByTime = new javax.swing.JPanel();
        jCheckBoxByTime = new javax.swing.JCheckBox();
        jSpinnerInitTime = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerEndTime = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerInitDate = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerEndDate = new javax.swing.JSpinner();
        jRadioButtonNotEndDate = new javax.swing.JRadioButton();

        setResizable(false);
        setTitle("Calendarización");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonRegularPeriods.setText("Configurar por periodos regulares");
        jButtonRegularPeriods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegularPeriodsActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRegularPeriods);

        jButtonOk.setText("Aceptar");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonOk);

        jButtonClose.setText("Cerrar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonClose);

        jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel1.setText("Título:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanelByTime.setBorder(javax.swing.BorderFactory.createTitledBorder("Horario de Presentación"));

        jCheckBoxByTime.setText("Por Hora");
        jCheckBoxByTime.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxByTimeStateChanged(evt);
            }
        });

        jSpinnerInitTime.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerInitTime.setEnabled(false);

        jLabel2.setText("Hora de inicio:");

        jLabel3.setText("Hora final:");

        jSpinnerEndTime.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerEndTime.setEnabled(false);

        javax.swing.GroupLayout jPanelByTimeLayout = new javax.swing.GroupLayout(jPanelByTime);
        jPanelByTime.setLayout(jPanelByTimeLayout);
        jPanelByTimeLayout.setHorizontalGroup(
            jPanelByTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelByTimeLayout.createSequentialGroup()
                .addGroup(jPanelByTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxByTime)
                    .addGroup(jPanelByTimeLayout.createSequentialGroup()
                        .addGroup(jPanelByTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelByTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerInitTime, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanelByTimeLayout.setVerticalGroup(
            jPanelByTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelByTimeLayout.createSequentialGroup()
                .addComponent(jCheckBoxByTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelByTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerInitTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanelByTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalo de Dias"));
        jPanel6.setPreferredSize(new java.awt.Dimension(500, 100));

        jLabel4.setText("Feha de inicio:");

        jSpinnerInitDate.setModel(new javax.swing.SpinnerDateModel());

        jLabel5.setText("Finaliza el:");

        jSpinnerEndDate.setModel(new javax.swing.SpinnerDateModel());

        jRadioButtonNotEndDate.setText("Sin fecha de finalización");
        jRadioButtonNotEndDate.setActionCommand("Sin fecha de finalización");
        jRadioButtonNotEndDate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonNotEndDateStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinnerEndDate, 0, 0, Short.MAX_VALUE)
                            .addComponent(jSpinnerInitDate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE)))
                    .addComponent(jRadioButtonNotEndDate))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerInitDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jRadioButtonNotEndDate)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanelByTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jPanelByTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButtonRegularPeriodsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonRegularPeriodsActionPerformed
    {//GEN-HEADEREND:event_jButtonRegularPeriodsActionPerformed
        DialogRegularPeriods dialogRegularPeriods=new DialogRegularPeriods(new Frame(),true);
        dialogRegularPeriods.setVisible(true);
    }//GEN-LAST:event_jButtonRegularPeriodsActionPerformed

    private void jCheckBoxByTimeStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jCheckBoxByTimeStateChanged
    {//GEN-HEADEREND:event_jCheckBoxByTimeStateChanged
        if(this.jCheckBoxByTime.isSelected())
        {
            this.jSpinnerInitTime.setEnabled(true);
            this.jSpinnerEndTime.setEnabled(true);
        }
        else
        {
            this.jSpinnerInitTime.setEnabled(false);
            this.jSpinnerEndTime.setEnabled(false);            
        }
    }//GEN-LAST:event_jCheckBoxByTimeStateChanged

    private void jRadioButtonNotEndDateStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jRadioButtonNotEndDateStateChanged
    {//GEN-HEADEREND:event_jRadioButtonNotEndDateStateChanged
        if(jRadioButtonNotEndDate.isSelected())
        {
            jSpinnerEndDate.setEnabled(false);
        }
        else
        {
            jSpinnerEndDate.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonNotEndDateStateChanged

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCloseActionPerformed
    {//GEN-HEADEREND:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonOkActionPerformed
    {//GEN-HEADEREND:event_jButtonOkActionPerformed
        this.setVisible(false);        
    }//GEN-LAST:event_jButtonOkActionPerformed
    public Document getDocument()
    {
        if(document==null)
        {
            org.jdom.output.DOMOutputter out=new org.jdom.output.DOMOutputter();
            try
            {
                document=out.output(new org.jdom.Document());
            }
            catch(Exception e)
            {
                
            }
        }
        return document;
    }
    public void setDocument(Document document)
    {
        this.document=document;
        init();
    }
    private void init()
    {
        if(document!=null)
        {
            if(document.getElementsByTagName("weekly").getLength()>0)
            {

            }
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogCalendar dialog = new DialogCalendar(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonRegularPeriods;
    private javax.swing.JCheckBox jCheckBoxByTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelByTime;
    private javax.swing.JRadioButton jRadioButtonNotEndDate;
    private javax.swing.JSpinner jSpinnerEndDate;
    private javax.swing.JSpinner jSpinnerEndTime;
    private javax.swing.JSpinner jSpinnerInitDate;
    private javax.swing.JSpinner jSpinnerInitTime;
    private javax.swing.JTextField jTextFieldTitle;
    // End of variables declaration//GEN-END:variables

}
