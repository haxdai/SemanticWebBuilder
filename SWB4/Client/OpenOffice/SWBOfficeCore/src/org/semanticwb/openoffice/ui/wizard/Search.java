/*
 * Search.java
 *
 * Created on 9 de diciembre de 2008, 12:01 PM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;
import org.semanticwb.office.interfaces.CategoryInfo;
import org.semanticwb.office.interfaces.ContentInfo;
import org.semanticwb.office.interfaces.ContentType;
import org.semanticwb.office.interfaces.RepositoryInfo;
import org.semanticwb.openoffice.DocumentType;
import org.semanticwb.openoffice.OfficeApplication;

/**
 *
 * @author  victor.lorenzana
 */
public class Search extends WizardPage
{

    public static final String CONTENT = "CONTENT";
    public static final String WORKSPACE = "WORKSPACE";
    public static Map map;
    private DocumentType officeType;

    /** Creates new form Search */
    public Search(DocumentType officeType)
    {
        initComponents();
        this.officeType = officeType;
        this.jComboBoxCategory.removeAllItems();
        this.jComboBoxType.removeAllItems();
        this.jComboBoxRepositorio.removeAllItems();
        try
        {
            for (RepositoryInfo rep : OfficeApplication.getOfficeApplicationProxy().getRepositories())
            {
                this.jComboBoxRepositorio.addItem(rep);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void search(String repositoryName, String title, String description, String type, String category)
    {
        DefaultTableModel model = (DefaultTableModel) this.jTableContents.getModel();
        int rows = model.getRowCount();
        for (int i = 0; i < rows; i++)
        {
            model.removeRow(0);
        }
        try
        {

            ContentInfo[] contens = OfficeApplication.getOfficeApplicationProxy().search(repositoryName, title, description, category, type, officeType.toString());
            if (contens.length == 0)
            {
                JOptionPane.showMessageDialog(this, "¡No se encontrarón coincidencias para la busqueda!", Search.getDescription(), JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "¡Se encontrarón " + contens.length + " coincidencias para la busqueda!", Search.getDescription(), JOptionPane.INFORMATION_MESSAGE);
            }
            for (ContentInfo info : contens)
            {
                String date = OfficeApplication.iso8601dateFormat.format(info.created);
                Object[] values =
                {
                    info, info.descripcion, date, info.categoryTitle
                };
                model.addRow(values);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getDescription()
    {
        return "Búsqueda de contenido";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContents = new javax.swing.JTable();
        jButtonView = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxRepositorio = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox();

        jLabel1.setText("Título:");

        jTextFieldTitle.setToolTipText("Debe indicar una palabra o título completo a buscar");

        jLabel2.setText("Descripción:");

        jTextFieldDescription.setToolTipText("Debe indicar una palabra o descripción completa a buscar");

        jButtonSearch.setText("Buscar");
        jButtonSearch.setToolTipText("Seleccione esta opción para buscar contenidos que coincidan con los criterios de búsqueda");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel3.setText("Categoria:");

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCategory.setToolTipText("Seleccione una categoria para buscar el contenido");

        jTableContents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Descripción", "Fecha de creación", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTableContents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableContents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableContentsKeyPressed(evt);
            }
        });
        jTableContents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContents);

        jButtonView.setText("Ver Contenido");
        jButtonView.setEnabled(false);

        jLabel4.setText("Repositorio:");

        jComboBoxRepositorio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRepositorio.setToolTipText("Seleccione un repositorio de contenidos");
        jComboBoxRepositorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRepositorioActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de contenido:");

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxRepositorio, javax.swing.GroupLayout.Alignment.TRAILING, 0, 356, Short.MAX_VALUE)
                            .addComponent(jComboBoxCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(jTextFieldDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(jComboBoxType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 356, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButtonView)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRepositorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxType)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch)
                    .addComponent(jButtonView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
    if (this.jComboBoxRepositorio.getSelectedItem() == null)
    {
        JOptionPane.showMessageDialog(this, "¡Debe indicar un repositorio!", Search.getDescription(), JOptionPane.ERROR_MESSAGE);
        this.jComboBoxRepositorio.requestFocus();
        return;
    }
    if (this.jComboBoxCategory.getSelectedItem() == null)
    {
        JOptionPane.showMessageDialog(this, "¡Debe indicar una categoria!", Search.getDescription(), JOptionPane.ERROR_MESSAGE);
        this.jComboBoxCategory.requestFocus();
        return;
    }
    if (this.jComboBoxType.getSelectedItem() == null)
    {
        JOptionPane.showMessageDialog(this, "¡Debe indicar un tipo de contenido!", Search.getDescription(), JOptionPane.ERROR_MESSAGE);
        this.jComboBoxType.requestFocus();
        return;
    }
    CategoryInfo category = (CategoryInfo) this.jComboBoxCategory.getSelectedItem();
    String title = "*";
    String description = "*";
    if (!this.jTextFieldTitle.getText().isEmpty())
    {
        title = this.jTextFieldTitle.getText();
    }
    if (!this.jTextFieldDescription.getText().isEmpty())
    {
        description = this.jTextFieldDescription.getText();
    }
    ContentType type = (ContentType) jComboBoxType.getSelectedItem();
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    search(this.jComboBoxRepositorio.getSelectedItem().toString(), title, description, type.id, category.UDDI);
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

}//GEN-LAST:event_jButtonSearchActionPerformed

private void jComboBoxRepositorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRepositorioActionPerformed
    this.jComboBoxCategory.removeAllItems();
    if (this.jComboBoxRepositorio.getSelectedItem() != null)
    {
        String rep = this.jComboBoxRepositorio.getSelectedItem().toString();
        try
        {
            for (ContentType type : OfficeApplication.getOfficeApplicationProxy().getContentTypes(rep))
            {
                this.jComboBoxType.addItem(type);
            }
            for (CategoryInfo cat : OfficeApplication.getOfficeApplicationProxy().getAllCategories(rep))
            {
                this.jComboBoxCategory.addItem(cat);
            }
            CategoryInfo all = new CategoryInfo();
            all.UDDI = "*";
            all.title = "Todas las categorias";
            all.description = "Todas las categorias del repositorio";
            this.jComboBoxCategory.addItem(all);
            this.jComboBoxCategory.setSelectedItem(all);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}//GEN-LAST:event_jComboBoxRepositorioActionPerformed

private void jTableContentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContentsMouseClicked
    this.jButtonView.setEnabled(false);
    if (jTableContents.getSelectedRow() != -1)
    {
        this.jButtonView.setEnabled(true);
    }
}//GEN-LAST:event_jTableContentsMouseClicked

private void jTableContentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableContentsKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
    {
        jTableContentsMouseClicked(null);
    }
}//GEN-LAST:event_jTableContentsKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonView;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JComboBox jComboBoxRepositorio;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContents;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldTitle;
    // End of variables declaration//GEN-END:variables

    @Override
    public WizardPanelNavResult allowNext(String arg, Map map, Wizard wizard)
    {
        WizardPanelNavResult result = WizardPanelNavResult.PROCEED;
        if (this.jTableContents.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this, "!Debe indicar un contenido!", Search.getDescription(), JOptionPane.ERROR_MESSAGE);
            this.jTableContents.requestFocus();
            result = WizardPanelNavResult.REMAIN_ON_PAGE;
        }
        else
        {
            Object selection = this.jTableContents.getModel().getValueAt(this.jTableContents.getSelectedRow(), 0);
            map.put(CONTENT, selection);
            map.put(WORKSPACE, this.jComboBoxRepositorio.getSelectedItem().toString());
            Search.map = map;
        }
        return result;
    }

    private void addCategory(String repository, CategoryInfo category)
    {
        if (category.childs > 0)
        {
            try
            {
                for (CategoryInfo cat : OfficeApplication.getOfficeApplicationProxy().getCategories(repository, category.UDDI))
                {
                    this.jComboBoxCategory.addItem(cat);
                    addCategory(repository, cat);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
