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
 * DialogContentInformation.java
 *
 * Created on 4 de junio de 2008, 10:09 AM
 */
package org.semanticwb.openoffice.ui.dialogs;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.semanticwb.office.interfaces.CategoryInfo;
import org.semanticwb.office.interfaces.ResourceInfo;
import org.semanticwb.office.interfaces.PropertyInfo;
import org.semanticwb.office.interfaces.VersionInfo;
import org.semanticwb.openoffice.OfficeApplication;
import org.semanticwb.openoffice.OfficeDocument;
import org.semanticwb.openoffice.ui.icons.ImageLoader;

/**
 *
 * @author  victor.lorenzana
 */
public class DialogContentInformation extends javax.swing.JDialog
{

    public static final String CONTENTID = "?contentId=";
    private static final String BOOLEAN = "boolean";
    private static final String EMPTY_STRING = "";
    private static final String GTW = "gtw";
    private static final String INTEGER = "integer";
    private static final String NAME = "&name=";
    private static final String NL = "\r\n";
    private static final String PATH_SEPARATOR = "/";
    private static final String PORT_SEPARATOR = ":";
    private static final String REPOSITORYNAME = "&repositoryName=";
    private static final String SCHEMA_SEPARATOR = "://";
    private static final String STRING = "string";
    private static final String TYPE = "&type=";
    private static final String VERSIONNAME = "&versionName=";
    private String contentId, repository;
    private OfficeDocument document;
    private String type;

    /** Creates new form DialogContentInformation */
    public DialogContentInformation(String contentId, String repository, OfficeDocument document)
    {
        super((Frame) null, ModalityType.TOOLKIT_MODAL);
        type = document.getDocumentType().toString().toLowerCase();
        initComponents();
        this.setIconImage(ImageLoader.images.get("semius").getImage());
        this.setModal(true);
        this.contentId = contentId;
        this.repository = repository;
        this.document = document;
        jTablePages.setColumnSelectionAllowed(false);
        jTablePages.setRowSelectionAllowed(true);

        try
        {
            String otype = OfficeApplication.getOfficeDocumentProxy().getNameOfContent(repository, contentId);
            loadProperties(repository, otype);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        ListSelectionModel listSelectionModel = jTablePages.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener()
        {

            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                jButtonEdit.setEnabled(false);
                jButtonViewPage.setEnabled(false);
                jButtonDeletePage.setEnabled(false);
                if (e.getFirstIndex() != -1)
                {
                    jButtonDeletePage.setEnabled(true);
                    jButtonViewPage.setEnabled(true);
                    jButtonEdit.setEnabled(true);
                }
            }
        });


        listSelectionModel = jTableSummary1.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener()
        {

            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                jButtonViewVersion.setEnabled(false);
                jButtonDeleteVersion.setEnabled(false);
                if (e.getFirstIndex() != -1)
                {
                    jButtonViewVersion.setEnabled(true);
                    jButtonDeleteVersion.setEnabled(true);
                }
            }
        });

        try
        {
            this.jTextFieldTitle.setText(OfficeApplication.getOfficeDocumentProxy().getTitle(repository, contentId));
            this.jTextAreaDescription.setText(OfficeApplication.getOfficeDocumentProxy().getDescription(repository, contentId));
            String date = EMPTY_STRING;
            try
            {
                date = OfficeApplication.iso8601dateFormat.format(OfficeApplication.getOfficeDocumentProxy().getLastUpdate(repository, contentId));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                date = java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("NO_FUE_POSIBLE_OBTENER_LA_FECHA_DE_ACTUALIZACIÓN.");
            }
            this.jLabel1DisplayDateOfModification.setText(date);
            loadCategories();
            CategoryInfo actualCategory = OfficeApplication.getOfficeDocumentProxy().getCategoryInfo(repository, contentId);
            jComboBoxCategory.setSelectedItem(actualCategory);
            loadVersions();
            loadPorlets();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    class VersionEditor extends DefaultCellEditor
    {

        public VersionEditor(String repositoryName, String contentId)
        {
            super(new ComboVersiones(repositoryName, contentId, null));
        }
    }

    public void loadProperties(String repositoryName, String type)
    {

        try
        {
            PropertyInfo[] props = OfficeApplication.getOfficeDocumentProxy().getContentProperties(repositoryName, type);
            if (props == null || props.length == 0)
            {
                this.jTabbedPane1.remove(this.jPanelProperties);
                /*JPanel panel = new JPanel();
                panel.setBackground(new Color(255, 255, 255));
                panel.setLayout(new BorderLayout());
                JLabel label = new JLabel("No se tienen propiedades para este tipo de contenido, puede continuar.");
                panel.add(label, BorderLayout.NORTH);
                this.add(panel);*/
            }
            else
            {
                HashMap<PropertyInfo, Object> properties = new HashMap<PropertyInfo, Object>();
                for (PropertyInfo info : props)
                {
                    Object defaultValue = null;
                    if (info.type.equalsIgnoreCase(STRING))
                    {
                        defaultValue = EMPTY_STRING;
                    }
                    if (info.type.equalsIgnoreCase(INTEGER))
                    {
                        defaultValue = 0;
                    }
                    if (info.type.equalsIgnoreCase(BOOLEAN))
                    {
                        defaultValue = false;
                    }
                    if (contentId != null)
                    {
                        defaultValue = OfficeApplication.getOfficeDocumentProxy().getContentProperty(info, repositoryName, contentId);
                    }
                    properties.put(info, defaultValue);
                    this.panelPropertyEditor1.loadProperties(properties);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    class ComboVersiones extends JComboBox
    {

        public ComboVersiones(String repositoryName, String contentId, VersionInfo selected)
        {
            VersionInfo info = new VersionInfo();
            info.nameOfVersion = "*";
            this.setEditable(false);
            this.addItem(info);
            try
            {
                for (VersionInfo versionInfo : OfficeApplication.getOfficeDocumentProxy().getVersions(repositoryName, contentId))
                {
                    this.addItem(versionInfo);
                }
                if (selected != null)
                {
                    this.setSelectedItem(selected);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public String toString()
        {
            return this.getSelectedItem().toString();
        }
    }

    class VersionRender implements TableCellRenderer
    {

        private String repositoryName, contentId;

        public VersionRender(String repositoryName, String contentId)
        {
            this.repositoryName = repositoryName;
            this.contentId = contentId;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column)
        {
            if (value instanceof VersionInfo)
            {
                ComboVersiones comboVersiones = new ComboVersiones(repositoryName, contentId, (VersionInfo) value);
                comboVersiones.setSelectedItem(value);
                return comboVersiones;
            }
            else if (value instanceof ComboVersiones)
            {
                return (ComboVersiones) value;
            }
            else
            {
                return null;
            }
        }
    }

    public void loadCategories()
    {
        try
        {
            this.jComboBoxCategory.removeAllItems();
            for (CategoryInfo category : OfficeApplication.getOfficeApplicationProxy().getAllCategories(repository))
            {
                this.jComboBoxCategory.addItem(category);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void loadVersions()
    {
        try
        {
            DefaultTableModel model = (DefaultTableModel) jTableSummary1.getModel();
            int rows = model.getRowCount();
            for (int i = 1; i <= rows; i++)
            {
                model.removeRow(0);
            }
            for (VersionInfo versionInfo : OfficeApplication.getOfficeDocumentProxy().getVersions(this.repository, contentId))
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

    private void loadPorlets()
    {


        DefaultTableModel model = (DefaultTableModel) jTablePages.getModel();
        int rows = model.getRowCount();
        for (int i = 1; i <= rows; i++)
        {
            model.removeRow(0);
        }
        TableColumn column = this.jTablePages.getColumnModel().getColumn(4);
        column.setCellEditor(new VersionEditor(this.repository, this.contentId));
        //column.setCellRenderer(new VersionRender(repository, contentId));
        try
        {
            for (ResourceInfo resourceInfo : OfficeApplication.getOfficeDocumentProxy().listResources(repository, contentId))
            {
                VersionInfo selected = new VersionInfo();
                selected.nameOfVersion = resourceInfo.version;
                Object[] rowData =
                {
                    resourceInfo, resourceInfo.page.site.title, resourceInfo.page.title, resourceInfo.active, new ComboVersiones(repository, contentId, selected)
                };
                model.addRow(rowData);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            this.jButtonEdit.setEnabled(false);
            this.jButtonDeletePage.setEnabled(false);
            this.jButtonViewPage.setEnabled(false);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelButtons = new javax.swing.JPanel();
        jButtonAccept = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelContentInformation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel1DisplayDateOfModification = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox();
        jPanelPublishInformation = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonEdit = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButtonPublish = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButtonViewPage = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButtonDeletePage = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePages = new javax.swing.JTable();
        jPanelVersions = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSummary1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButtonUpdate = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonViewVersion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonDeleteVersion = new javax.swing.JButton();
        jPanelProperties = new javax.swing.JPanel();
        panelPropertyEditor1 = new org.semanticwb.openoffice.components.PanelPropertyEditor();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation"); // NOI18N
        setTitle(bundle.getString("INFORMACIÓN_DEL_CONTENIDO")); // NOI18N
        setModal(true);
        setResizable(false);

        jPanelButtons.setPreferredSize(new java.awt.Dimension(100, 50));

        jButtonAccept.setText(bundle.getString("ACEPTAR")); // NOI18N
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        jButtonCancel.setText(bundle.getString("CERRAR")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(jButtonAccept)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonAccept))
                .addContainerGap())
        );

        getContentPane().add(jPanelButtons, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(550, 250));

        jPanelContentInformation.setPreferredSize(new java.awt.Dimension(650, 269));

        jLabel1.setText(bundle.getString("TÍTULO:")); // NOI18N

        jLabel2.setText(bundle.getString("DESCRIPCIÓN:")); // NOI18N

        jLabel3.setText(bundle.getString("FECHA_DE_ÚLTIMA_MODIFICACIÓN:")); // NOI18N

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jLabel1DisplayDateOfModification.setText(bundle.getString("18_DE_DICIEMBRE_DE_1973_20:30")); // NOI18N

        jLabel4.setText(bundle.getString("CATEGORIA")); // NOI18N

        javax.swing.GroupLayout jPanelContentInformationLayout = new javax.swing.GroupLayout(jPanelContentInformation);
        jPanelContentInformation.setLayout(jPanelContentInformationLayout);
        jPanelContentInformationLayout.setHorizontalGroup(
            jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jLabel1DisplayDateOfModification, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jComboBoxCategory, 0, 353, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelContentInformationLayout.setVerticalGroup(
            jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1DisplayDateOfModification))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContentInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        jTabbedPane1.addTab(bundle.getString("INFORMACIÓN_DEL_CONTENIDO"), jPanelContentInformation); // NOI18N

        jPanelPublishInformation.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/edit.png"))); // NOI18N
        jButtonEdit.setToolTipText(bundle.getString("EDITAR_PROPIEDADES_Y_CALENDARIZACIÓN")); // NOI18N
        jButtonEdit.setEnabled(false);
        jButtonEdit.setFocusable(false);
        jButtonEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEdit);
        jToolBar1.add(jSeparator5);

        jButtonPublish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/envpaga.png"))); // NOI18N
        jButtonPublish.setToolTipText(bundle.getString("PERMITE_PUBLICAR_EL_CONTENIDO_EN_UNA_PÁGINA")); // NOI18N
        jButtonPublish.setFocusable(false);
        jButtonPublish.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPublish.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPublishActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonPublish);
        jToolBar1.add(jSeparator3);

        jButtonViewPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/see.png"))); // NOI18N
        jButtonViewPage.setToolTipText(bundle.getString("VER_PÁGINA")); // NOI18N
        jButtonViewPage.setEnabled(false);
        jButtonViewPage.setFocusable(false);
        jButtonViewPage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonViewPage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonViewPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewPageActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonViewPage);
        jToolBar1.add(jSeparator4);

        jButtonDeletePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/delete.png"))); // NOI18N
        jButtonDeletePage.setToolTipText(bundle.getString("ELIMINAR_LA_PUBLICACIÓN_DE_UN_CONTENIDO_EN_UNA_PÁGINA")); // NOI18N
        jButtonDeletePage.setEnabled(false);
        jButtonDeletePage.setFocusable(false);
        jButtonDeletePage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDeletePage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDeletePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletePageActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonDeletePage);

        jPanelPublishInformation.add(jToolBar1, java.awt.BorderLayout.NORTH);

        jTablePages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Sitio", "Página", "Activo", "Version"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePages.setToolTipText(bundle.getString("PUEDE_EDITAR_LA_VERSIÓN_SELECIONANDO_LA_COLUMNA_CORRESPONDIENTE")); // NOI18N
        jTablePages.setColumnSelectionAllowed(true);
        jTablePages.setRowHeight(20);
        jTablePages.setRowSelectionAllowed(false);
        jTablePages.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablePages.getTableHeader().setReorderingAllowed(false);
        jTablePages.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePagesKeyReleased(evt);
            }
        });
        jTablePages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePagesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePages);
        jTablePages.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanelPublishInformation.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab(bundle.getString("INFORMACIÓN_DE_PUBLICACIÓN"), jPanelPublishInformation); // NOI18N

        jPanelVersions.setLayout(new java.awt.BorderLayout());

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
        jTableSummary1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSummary1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableSummary1);
        jTableSummary1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanelVersions.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(466, 25));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/save.png"))); // NOI18N
        jButtonUpdate.setToolTipText(bundle.getString("ACTUALIZAR_EL_CONTENIDO,_ESTÁ_OPCION_CREA_UNA_NUEVA_VERSIÓN_DE_CONTENIDO")); // NOI18N
        jButtonUpdate.setFocusable(false);
        jButtonUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonUpdate);
        jToolBar2.add(jSeparator2);

        jButtonViewVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/see.png"))); // NOI18N
        jButtonViewVersion.setToolTipText(bundle.getString("VER_VERSIÓN_DEL_CONTENIDO")); // NOI18N
        jButtonViewVersion.setEnabled(false);
        jButtonViewVersion.setFocusable(false);
        jButtonViewVersion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonViewVersion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonViewVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewVersionActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonViewVersion);
        jToolBar2.add(jSeparator1);

        jButtonDeleteVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/delete.png"))); // NOI18N
        jButtonDeleteVersion.setToolTipText(bundle.getString("BORRAR_VERSIÓN")); // NOI18N
        jButtonDeleteVersion.setEnabled(false);
        jButtonDeleteVersion.setFocusable(false);
        jButtonDeleteVersion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDeleteVersion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDeleteVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteVersionActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonDeleteVersion);

        jPanel1.add(jToolBar2, java.awt.BorderLayout.CENTER);

        jPanelVersions.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab(bundle.getString("VERSIONES_DEL_CONTENIDO"), jPanelVersions); // NOI18N

        jPanelProperties.setLayout(new java.awt.BorderLayout());
        jPanelProperties.add(panelPropertyEditor1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab(bundle.getString("PROPIEDADES_DE_CONTENIDO"), jPanelProperties); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCancelActionPerformed
    {//GEN-HEADEREND:event_jButtonCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonPublishActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonPublishActionPerformed
    {//GEN-HEADEREND:event_jButtonPublishActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        document.publish();
        this.repaint();
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        loadPorlets();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButtonPublishActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAcceptActionPerformed
    {//GEN-HEADEREND:event_jButtonAcceptActionPerformed

        if (this.jTextFieldTitle.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¡DEBE_INDICAR_UN_TÍTULO_DE_CONTENIDO!"), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
            this.jTextFieldTitle.requestFocus();
            return;
        }
        if (this.jTextAreaDescription.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¡DEBE_INDICAR_UNA_DESCRIPCIÓN_DE_CONTENIDO!"), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
            this.jTextAreaDescription.requestFocus();
            return;
        }
        try
        {
            Map<PropertyInfo, String> properties = panelPropertyEditor1.getProperties();
            PropertyInfo[] props = new PropertyInfo[properties.keySet().size()];
            String[] values = new String[properties.keySet().size()];
            int i = 0;
            for (PropertyInfo prop : properties.keySet())
            {
                String value = properties.get(prop);
                values[i] = value;
                props[i] = prop;
                i++;
            }
            String otype = OfficeApplication.getOfficeDocumentProxy().getNameOfContent(repository, contentId);
            OfficeApplication.getOfficeDocumentProxy().validateContentValues(repository, props, values, otype);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            String oldTitle = OfficeApplication.getOfficeDocumentProxy().getTitle(repository, contentId);
            if (!oldTitle.equals(jTextFieldTitle.getText()))
            {
                OfficeApplication.getOfficeDocumentProxy().setTitle(repository, contentId, this.jTextFieldTitle.getText());
            }
            String oldDescription = OfficeApplication.getOfficeDocumentProxy().getDescription(repository, contentId);
            if (!oldDescription.equals(this.jTextAreaDescription.getText()))
            {
                OfficeApplication.getOfficeDocumentProxy().setDescription(repository, contentId, this.jTextAreaDescription.getText());
            }
            CategoryInfo oldCategory = OfficeApplication.getOfficeDocumentProxy().getCategoryInfo(repository, contentId);
            CategoryInfo newCategory = (CategoryInfo) this.jComboBoxCategory.getSelectedItem();
            if (!oldCategory.equals(newCategory))
            {
                OfficeApplication.getOfficeDocumentProxy().changeCategory(repository, contentId, newCategory.UDDI);
            }
            // update content properties
            Map<PropertyInfo, String> properties = panelPropertyEditor1.getProperties();

            for (PropertyInfo propertyInfo : properties.keySet())
            {
                String value = properties.get(propertyInfo);
                OfficeApplication.getOfficeDocumentProxy().setContentPropertyValue(repository, contentId, propertyInfo, value);
            }
            //update porlets
            DefaultTableModel model = (DefaultTableModel) jTablePages.getModel();
            int rows = model.getRowCount();
            for (int i = 0; i < rows; i++)
            {
                ResourceInfo resourceInfo = (ResourceInfo) model.getValueAt(i, 0);
                boolean newactive = (Boolean) model.getValueAt(i, 3);
                if (resourceInfo.active != newactive)
                {
                    if (resourceInfo.active)
                    {
                        if (OfficeApplication.getOfficeDocumentProxy().needsSendToPublish(resourceInfo))
                        {
                            int res = JOptionPane.showConfirmDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("EL_CONTENIDO_NECESITA_SER_AUTORIZADO_PARA_PRESENTARSE_EN_EL_SITIO.") + NL + java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¿DESEA_ENVIARLO_A_AUTORIZACIÓN?"), this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (res == JOptionPane.YES_OPTION)
                            {
                                DialogSelectFlow dialogSelectFlow = new DialogSelectFlow(resourceInfo);
                                dialogSelectFlow.setVisible(true);
                                if (dialogSelectFlow.selected != null)
                                {
                                    OfficeApplication.getOfficeDocumentProxy().sendToAuthorize(resourceInfo, dialogSelectFlow.selected, dialogSelectFlow.jTextAreaMessage.getText().trim());
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¡PARA_ACTIVAR_ESTE_CONTENIDO_DEBE_SER_AUTORIZADO_PRIMERO!"), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                        else if (OfficeApplication.getOfficeDocumentProxy().isInFlow(resourceInfo))
                        {
                            JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¡ESTE_CONTENIDO_SE_ENCUENTRA_EN_PROCESO_DE_AUTORIZACIÓN,_PARA_ACTIVAR_ESTE_CONTENIDO_DEBE_TERMINAR_PRIMERO_EL_PROCESO_DE_AUTORIZACIÓN!"), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if (OfficeApplication.getOfficeDocumentProxy().isAuthorized(resourceInfo))
                        {
                            OfficeApplication.getOfficeDocumentProxy().activateResource(resourceInfo, newactive);
                        }
                        else
                        {
                            int res = JOptionPane.showConfirmDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("EL_CONTENIDO_FUE_RECHAZADO.") + NL + java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("PARA_ACTIVARLO_NECESITA_ENVIARLO_A_AUTORIZACIÓN_DE_NUEVO") + NL + java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¿DESEA_ENVIARLO_A_AUTORIZACIÓN?"), this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (res == JOptionPane.YES_OPTION)
                            {
                                DialogSelectFlow dialogSelectFlow = new DialogSelectFlow(resourceInfo);
                                dialogSelectFlow.setVisible(true);
                                if (dialogSelectFlow.selected != null)
                                {
                                    OfficeApplication.getOfficeDocumentProxy().sendToAuthorize(resourceInfo, dialogSelectFlow.selected, dialogSelectFlow.jTextAreaMessage.getText().trim());
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¡PARA_ACTIVAR_ESTE_CONTENIDO_DEBE_SER_AUTORIZADO_PRIMERO!"), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    }
                    else
                    {
                        OfficeApplication.getOfficeDocumentProxy().activateResource(resourceInfo, newactive);
                    }
                }

                if (model.getValueAt(i, 4) instanceof VersionInfo)
                {
                    VersionInfo versionInfo = (VersionInfo) model.getValueAt(i, 4);
                    String newVersion = versionInfo.nameOfVersion;
                    String oldVersion = OfficeApplication.getOfficeDocumentProxy().getVersionToShow(resourceInfo);
                    if (oldVersion == null || !newVersion.equals(oldVersion))
                    {
                        OfficeApplication.getOfficeDocumentProxy().changeVersionPorlet(resourceInfo, newVersion);
                    }
                }
                if (model.getValueAt(i, 4) instanceof ComboVersiones)
                {
                    ComboVersiones combo = (ComboVersiones) model.getValueAt(i, 4);
                    String newVersion = ((VersionInfo) combo.getSelectedItem()).nameOfVersion;
                    String oldVersion = OfficeApplication.getOfficeDocumentProxy().getVersionToShow(resourceInfo);
                    if (oldVersion == null || !newVersion.equals(oldVersion))
                    {
                        OfficeApplication.getOfficeDocumentProxy().changeVersionPorlet(resourceInfo, newVersion);
                    }
                }
            }
            String date = OfficeApplication.iso8601dateFormat.format(OfficeApplication.getOfficeDocumentProxy().getLastUpdate(repository, contentId));
            this.jLabel1DisplayDateOfModification.setText(date);
            loadPorlets();
            loadVersions();
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¡SE_HAN_REALIZADO_CORRECTAMENTE_LOS_CAMBIOS!"), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
        finally
        {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

    }//GEN-LAST:event_jButtonAcceptActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonUpdateActionPerformed
    {//GEN-HEADEREND:event_jButtonUpdateActionPerformed
        document.saveToSite();
        loadVersions();
        loadPorlets();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeletePageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeletePageActionPerformed
    {//GEN-HEADEREND:event_jButtonDeletePageActionPerformed
        if (jTablePages.getSelectedRow() != -1)
        {
            ResourceInfo porlet = (ResourceInfo) jTablePages.getModel().getValueAt(jTablePages.getSelectedRow(), 0);
            try
            {
                int res = JOptionPane.showConfirmDialog(this, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¿DESEA_ELIMINAR_LA_PUBLICACIÓN_DEL_CONTENIDO_CON_TITULO_") + " " + porlet.title + " " + java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("_DE_LA_PÁGINA_")+" " + porlet.page.title + "?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION)
                {
                    this.jButtonDeletePage.setEnabled(false);
                    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    OfficeApplication.getOfficeDocumentProxy().deleteResource(porlet);
                    loadPorlets();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
        this.jButtonDeletePage.setEnabled(false);
    }//GEN-LAST:event_jButtonDeletePageActionPerformed

    private void jTablePagesKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTablePagesKeyReleased
    {//GEN-HEADEREND:event_jTablePagesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE && jTablePages.getSelectedRow() != -1)
        {
            jButtonDeletePageActionPerformed(null);
        }
}//GEN-LAST:event_jTablePagesKeyReleased

    private void jButtonViewPageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonViewPageActionPerformed
    {//GEN-HEADEREND:event_jButtonViewPageActionPerformed
        int row = jTablePages.getSelectedRow();
        if (row != -1)
        {
            DefaultTableModel model = (DefaultTableModel) jTablePages.getModel();
            ResourceInfo resourceInfo = (ResourceInfo) model.getValueAt(row, 0);
            try
            {
                String title = resourceInfo.title;
                URI uri = document.getOfficeDocumentProxy().getWebAddress();
                URL url = new URL(uri.getScheme() + SCHEMA_SEPARATOR + uri.getHost() + PORT_SEPARATOR + uri.getPort() + resourceInfo.page.url);
                DialogPreview preview = new DialogPreview(url, title);
                preview.setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButtonViewPageActionPerformed

    private void jButtonViewVersionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonViewVersionActionPerformed
    {//GEN-HEADEREND:event_jButtonViewVersionActionPerformed
        if (jTableSummary1.getSelectedRow() != -1)
        {
            DefaultTableModel model = (DefaultTableModel) jTableSummary1.getModel();
            String version = model.getValueAt(jTableSummary1.getSelectedRow(), 0).toString();
            String name = null;
            try
            {
                String urlproxy = OfficeApplication.getOfficeApplicationProxy().getWebAddress().toString();
                if (!urlproxy.endsWith(PATH_SEPARATOR + GTW))
                {
                    if (!urlproxy.endsWith(PATH_SEPARATOR))
                    {
                        urlproxy += PATH_SEPARATOR;
                    }
                    urlproxy += GTW;
                }
                name = OfficeApplication.getOfficeDocumentProxy().createPreview(repository, contentId, version, type);
                URL url = new URL(urlproxy + CONTENTID + contentId + VERSIONNAME + version + REPOSITORYNAME + repository + NAME + name + TYPE + type);
                String title = OfficeApplication.getOfficeDocumentProxy().getTitle(repository, contentId) + " (" + version + ") ";
                DialogPreview preview = new DialogPreview(url, false, title);
                preview.setVisible(true);
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
                        // no imprimir al usuario
                        e.printStackTrace();
                    }
                }
            }

        }
    }//GEN-LAST:event_jButtonViewVersionActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonEditActionPerformed
    {//GEN-HEADEREND:event_jButtonEditActionPerformed
        if (jTablePages.getSelectedRow() != -1)
        {
            ResourceInfo resourceInfo = (ResourceInfo) jTablePages.getModel().getValueAt(jTablePages.getSelectedRow(), 0);
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            DialogEditResource dialogEditPorlet = new DialogEditResource(resourceInfo, repository, contentId);
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            dialogEditPorlet.setVisible(true);
            if (!dialogEditPorlet.isCancel)
            {
                this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                try
                {
                    loadPorlets();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
            else
            {
                ResourceInfo info = dialogEditPorlet.getResourceInfo();
                if (!info.page.id.equals(resourceInfo.page.id))
                {
                    try
                    {
                        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        loadPorlets();
                    }
                    catch (Exception ue)
                    {
                        ue.printStackTrace();
                    }
                    finally
                    {
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteVersionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeleteVersionActionPerformed
    {//GEN-HEADEREND:event_jButtonDeleteVersionActionPerformed
        if (this.jTableSummary1.getSelectedRow() != -1)
        {
            DefaultTableModel model = (DefaultTableModel) this.jTableSummary1.getModel();
            String versionInfo = (String) model.getValueAt(this.jTableSummary1.getSelectedRow(), 0);
            boolean published = (Boolean) model.getValueAt(this.jTableSummary1.getSelectedRow(), 3);
            if (published)
            {
                JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¡NO_SE_PUEDE_BORRAR_UNA_VERSIÓN_QUE_HA_SIDO_PUBLICADA.!") + NL + java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("DEBE_BORRAR_PRIMERO_LA_PUBLICACIÓN_DEL_CONTENIDO."), java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("BORRADO_DE_VERSIÓN_DE_CONTENIDO"), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                int res = JOptionPane.showConfirmDialog(this, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("¿DESEA_BORRAR_LA_VERSIÓN_")+" " + versionInfo + "?", java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/dialogs/DialogContentInformation").getString("BORRADO_DE_VERSIÓN_DE_CONTENIDO"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION)
                {
                    try
                    {
                        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        OfficeApplication.getOfficeDocumentProxy().deleteVersionOfContent(repository, contentId, versionInfo);
                        loadVersions();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonDeleteVersionActionPerformed

    private void jTablePagesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTablePagesMouseClicked
    {//GEN-HEADEREND:event_jTablePagesMouseClicked
        if (evt.getClickCount() == 2)
        {
            int row = jTablePages.getSelectedRow();
            //int column = jTablePages.getSelectedColumn();
            if (row != -1)
            {
                jButtonEditActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTablePagesMouseClicked

    private void jTableSummary1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTableSummary1KeyReleased
    {//GEN-HEADEREND:event_jTableSummary1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE && jTablePages.getSelectedRow() != -1)
        {
            jButtonDeleteVersionActionPerformed(null);
        }
    }//GEN-LAST:event_jTableSummary1KeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDeletePage;
    private javax.swing.JButton jButtonDeleteVersion;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonPublish;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonViewPage;
    private javax.swing.JButton jButtonViewVersion;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1DisplayDateOfModification;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelContentInformation;
    private javax.swing.JPanel jPanelProperties;
    private javax.swing.JPanel jPanelPublishInformation;
    private javax.swing.JPanel jPanelVersions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePages;
    private javax.swing.JTable jTableSummary1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private org.semanticwb.openoffice.components.PanelPropertyEditor panelPropertyEditor1;
    // End of variables declaration//GEN-END:variables
}


