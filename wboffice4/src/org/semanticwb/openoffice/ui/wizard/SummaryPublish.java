/*
 * SummaryPublish.java
 *
 * Created on 3 de junio de 2008, 03:58 PM
 */

package org.semanticwb.openoffice.ui.wizard;

/**
 *
 * @author  victor.lorenzana
 */
public class SummaryPublish extends javax.swing.JPanel {
    
    /** Creates new form SummaryPublish */
    public SummaryPublish() {
        initComponents();        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelPreview = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPanePreview = new javax.swing.JEditorPane();
        jPanelSummary = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSummary = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanelPreview.setLayout(new javax.swing.BoxLayout(jPanelPreview, javax.swing.BoxLayout.LINE_AXIS));

        jEditorPanePreview.setEditable(false);
        jScrollPane1.setViewportView(jEditorPanePreview);

        jPanelPreview.add(jScrollPane1);

        jTabbedPane1.addTab("Contenido Almacenado", jPanelPreview);

        jPanelSummary.setLayout(new javax.swing.BoxLayout(jPanelSummary, javax.swing.BoxLayout.LINE_AXIS));

        jTableSummary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableSummary);

        jPanelSummary.add(jScrollPane2);

        jTabbedPane1.addTab("Resumen de publicación", jPanelSummary);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPanePreview;
    private javax.swing.JPanel jPanelPreview;
    private javax.swing.JPanel jPanelSummary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableSummary;
    // End of variables declaration//GEN-END:variables
    
}
