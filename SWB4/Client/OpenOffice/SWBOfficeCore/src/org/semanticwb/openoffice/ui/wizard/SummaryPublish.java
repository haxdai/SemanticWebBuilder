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
 * SummaryPublish.java
 *
 * Created on 3 de junio de 2008, 03:58 PM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.awt.Cursor;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.semanticwb.office.interfaces.IOfficeDocument;
import org.semanticwb.office.interfaces.VersionInfo;
import org.semanticwb.openoffice.OfficeApplication;
import org.semanticwb.openoffice.ui.dialogs.DialogPreview;

/**
 *
 * @author  victor.lorenzana
 */
public class SummaryPublish extends javax.swing.JPanel
{
    private static final String NL = "\r\n";
    private static final String CONTENTID = "?contentId=";
    private static final String NAME = "&name=";
    private static final String REPOSITORYNAME = "&repositoryName=";
    private static final String TYPE = "&type=";
    private static final String VERSIONNAME = "&versionName=";

    private String contentId,  repositoryName;
    private String type;
    public SummaryPublish()
    {
        initComponents();
        this.type=type;
        ListSelectionModel listSelectionModel = jTableSummary1.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                jButtonDelete.setEnabled(false);
                jButtonViewContent.setEnabled(false);
                if (e.getFirstIndex() != -1)
                {
                    jButtonDelete.setEnabled(true);
                    jButtonViewContent.setEnabled(true);
                }
            }
        });
    }


    /** Creates new form SummaryPublish */
    public SummaryPublish(String contentId, String repositoryName,String type)
    {
        this();
        this.repositoryName = repositoryName;
        this.contentId = contentId;
        loadVersions(contentId, repositoryName);
        

    }

    public void setType(String type)
    {
        this.type=type;
    }
    public void loadVersions(String contentId, String repositoryName)
    {
        this.jButtonDelete.setEnabled(false);
        this.jButtonViewContent.setEnabled(false);
        this.contentId=contentId;
        this.repositoryName=repositoryName;
        try
        {
            DefaultTableModel model = (DefaultTableModel) jTableSummary1.getModel();
            int rows = model.getRowCount();
            for (int i = 1; i <= rows; i++)
            {
                model.removeRow(0);
            }
            IOfficeDocument document = OfficeApplication.getOfficeDocumentProxy();
            for (VersionInfo versionInfo : document.getVersions(repositoryName, contentId))
            {
                String date = OfficeApplication.iso8601dateFormat.format(versionInfo.created);
                Object[] rowData =
                {
                    versionInfo.nameOfVersion, date, versionInfo.user, versionInfo.published
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelPreview = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSummary1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonViewContent = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelPreview.setLayout(new javax.swing.BoxLayout(jPanelPreview, javax.swing.BoxLayout.LINE_AXIS));

        jTableSummary1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Versión", "Fecha de creación", "Creador", "Publicada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSummary1.setColumnSelectionAllowed(true);
        jTableSummary1.setFocusable(false);
        jTableSummary1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSummary1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableSummary1);
        jTableSummary1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSummary1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableSummary1.getColumnModel().getColumn(3).setPreferredWidth(30);

        jPanelPreview.add(jScrollPane3);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/SummaryPublish"); // NOI18N
        jTabbedPane1.addTab(bundle.getString("VERSIONES_EXISTENTES"), jPanelPreview); // NOI18N

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonViewContent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/see.png"))); // NOI18N
        jButtonViewContent.setToolTipText(bundle.getString("VER_CONTENIDO")); // NOI18N
        jButtonViewContent.setEnabled(false);
        jButtonViewContent.setFocusable(false);
        jButtonViewContent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonViewContent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonViewContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewContentActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonViewContent);

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/delete.png"))); // NOI18N
        jButtonDelete.setToolTipText(bundle.getString("BORRAR_VERSION")); // NOI18N
        jButtonDelete.setEnabled(false);
        jButtonDelete.setFocusable(false);
        jButtonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonDelete);

        jPanel2.add(jToolBar1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewContentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonViewContentActionPerformed
    {//GEN-HEADEREND:event_jButtonViewContentActionPerformed
        if (this.jTableSummary1.getSelectedRow() != -1)
        {
            DefaultTableModel model = (DefaultTableModel) this.jTableSummary1.getModel();
            String versionInfo = (String) model.getValueAt(this.jTableSummary1.getSelectedRow(), 0);
            String name = null;
            try
            {                
                name = OfficeApplication.getOfficeDocumentProxy().createPreview(this.repositoryName, this.contentId, versionInfo,type);
                String urlproxy = OfficeApplication.getOfficeApplicationProxy().getWebAddress().toString();
                URL url = new URL(urlproxy + CONTENTID + contentId+ VERSIONNAME + versionInfo + REPOSITORYNAME + repositoryName + NAME + name+TYPE+type);
                String title=OfficeApplication.getOfficeDocumentProxy().getTitle(repositoryName, contentId)+" ("+ versionInfo+") ";
                DialogPreview dialogPreview = new DialogPreview(url,false,title);
                dialogPreview.setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (name != null)
                {
                    try
                    {
                        OfficeApplication.getOfficeDocumentProxy().deletePreview(name);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonViewContentActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeleteActionPerformed
    {//GEN-HEADEREND:event_jButtonDeleteActionPerformed
        if (this.jTableSummary1.getSelectedRow() != -1)
        {
            DefaultTableModel model = (DefaultTableModel) this.jTableSummary1.getModel();
            String versionInfo = (String) model.getValueAt(this.jTableSummary1.getSelectedRow(), 0);
            boolean published=(Boolean) model.getValueAt(this.jTableSummary1.getSelectedRow(), 3);
            if(published)
            {
                JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/SummaryPublish").getString("¡NO_SE_PUEDE_BORRAR_UNA_VERSIÓN_QUE_HA_SIDO_PUBLICADA!")+ NL +java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/SummaryPublish").getString("DEBE_BORRAR_PRIMERO_LA_PUBLICACIÓN_DEL_CONTENIDO."),java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/SummaryPublish").getString("BORRADO_DE_VERSIÓN_DE_CONTENIDO"),JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                int res=JOptionPane.showConfirmDialog(this, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/SummaryPublish").getString("¿DESEA_BORRAR_LA_VERSIÓN_")+ versionInfo +"?",java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/SummaryPublish").getString("BORRADO_DE_VERSIÓN_DE_CONTENIDO"),JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(res==JOptionPane.YES_OPTION)
                {
                    try
                    {
                        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        OfficeApplication.getOfficeDocumentProxy().deleteVersionOfContent(repositoryName, contentId, versionInfo);
                        loadVersions(contentId, repositoryName);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonViewContent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelPreview;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableSummary1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
