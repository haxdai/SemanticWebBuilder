/*
 * TitlePage.java
 *
 * Created on 3 de junio de 2008, 05:19 PM
 */

package org.semanticwb.openoffice.ui.wizard;

import java.util.Map;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;

/**
 *
 * @author  victor.lorenzana
 */
public class TitlePage extends WizardPage {
    
    /** Creates new form TitlePage */
    public TitlePage() {
        initComponents();
    }
    public static String getDescription()
    {
        return "Información de la página";
    }
    @Override
    public WizardPanelNavResult allowNext(String arg, Map map, Wizard wizard)
    {
        return WizardPanelNavResult.PROCEED;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTitles = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jTableTitles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lenguaje", "Defecto", "Titulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTitles.setColumnSelectionAllowed(true);
        jTableTitles.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableTitles);
        jTableTitles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTitles.getColumnModel().getColumn(0).setMinWidth(100);
        jTableTitles.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableTitles.getColumnModel().getColumn(1).setMinWidth(70);
        jTableTitles.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTableTitles.getColumnModel().getColumn(1).setMaxWidth(50);
        jTableTitles.getColumnModel().getColumn(2).setMinWidth(100);
        jTableTitles.getColumnModel().getColumn(2).setPreferredWidth(100);

        jLabel1.setText("Identificador:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTitles;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
