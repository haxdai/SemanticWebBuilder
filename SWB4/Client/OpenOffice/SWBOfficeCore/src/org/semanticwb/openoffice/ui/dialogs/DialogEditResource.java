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
 * DialogContentPublicationInformation.java
 *
 * Created on 29 de diciembre de 2008, 04:18 PM
 */
package org.semanticwb.openoffice.ui.dialogs;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.semanticwb.office.interfaces.CalendarInfo;
import org.semanticwb.office.interfaces.ResourceInfo;
import org.semanticwb.office.interfaces.PropertyInfo;
import org.semanticwb.office.interfaces.ElementInfo;
import org.semanticwb.office.interfaces.LanguageInfo;
import org.semanticwb.office.interfaces.VersionInfo;
import org.semanticwb.openoffice.MoveContentResultProducer;
import org.semanticwb.openoffice.OfficeApplication;
import org.semanticwb.openoffice.components.PanelPropertyEditor;
import org.semanticwb.openoffice.ui.icons.ImageLoader;
import org.semanticwb.openoffice.ui.wizard.SelectPage;

/**
 *
 * @author  victor.lorenzana
 */
public class DialogEditResource extends javax.swing.JDialog
{

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    //private static final SimpleDateFormat DATE_SIMPLEFORMAT = new SimpleDateFormat(DATE_FORMAT);
    private PanelPropertyEditor panelPropertyEditor1 = new PanelPropertyEditor();
    public final String repositoryName, contentID;
    public ResourceInfo pageInformation;
    public boolean isCancel = true;
    ArrayList<CalendarInfo> added = new ArrayList<CalendarInfo>();

    /** Creates new form DialogContentPublicationInformation */
    public DialogEditResource(ResourceInfo pageInformation, String repositoryName, String contentID)
    {
        super((Frame) null, ModalityType.TOOLKIT_MODAL);
        initComponents();
        this.jSpinnerEndDate.setEditor(new JSpinner.DateEditor(jSpinnerEndDate, DATE_FORMAT));
        this.jPanelProperties.add(panelPropertyEditor1);
        this.setIconImage(ImageLoader.images.get("semius").getImage());
        this.setModal(true);
        setLocationRelativeTo(null);
        ListSelectionModel listSelectionModel = jTableRules.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener()
        {

            public void valueChanged(ListSelectionEvent e)
            {
                DefaultTableModel model = (DefaultTableModel) jTableRules.getModel();
                if (model.getRowCount() == 0 || jTableRules.getSelectedRow() == -1)
                {
                    jButtonDeleteRule.setEnabled(false);
                }
                else
                {
                    jButtonDeleteRule.setEnabled(true);
                }
            }
        });
        this.pageInformation = pageInformation;
        this.repositoryName = repositoryName;
        this.contentID = contentID;
        initialize();
    }

    public void initialize()
    {
        this.jCheckBoxPageActive.setSelected(this.pageInformation.page.active);
        this.jTextFieldTitle.setText(pageInformation.title);
        this.jTextAreaDescription.setText(pageInformation.description);
        this.jCheckBoxActive.setSelected(pageInformation.active);
        this.jLabelSite.setText(pageInformation.page.site.title);
        this.jLabelPage.setText(pageInformation.page.title);

        loadTitles();

        loadProperties();
        loadCalendars();



        try
        {
            Date date = OfficeApplication.getOfficeDocumentProxy().getEndDate(pageInformation);
            if (date == null)
            {
                this.jCheckBoxEndDateActive.setSelected(false);
                this.jSpinnerEndDate.setEnabled(false);
            }
            else
            {
                this.jCheckBoxEndDateActive.setSelected(true);
                this.jSpinnerEndDate.setEnabled(true);
                this.jSpinnerEndDate.setValue(date);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        jButtonSendToAuthorize.setVisible(false);
        try
        {
            if (OfficeApplication.getOfficeDocumentProxy().needsSendToPublish(pageInformation))
            {
                jButtonSendToAuthorize.setVisible(true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        this.jTableScheduler.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {

            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                jButtonDeleteScheduler.setEnabled(false);
                if (e.getFirstIndex() != -1)
                {
                    jButtonDeleteScheduler.setEnabled(true);

                }
            }
        });

        VersionInfo info = new VersionInfo();
        info.nameOfVersion = "*";
        jComboBoxVersion.setEditable(false);
        jComboBoxVersion.addItem(info);
        try
        {
            for (VersionInfo versionInfo : OfficeApplication.getOfficeDocumentProxy().getVersions(repositoryName, contentID))
            {
                jComboBoxVersion.addItem(versionInfo);
            }
            VersionInfo selected = new VersionInfo();
            selected.nameOfVersion = pageInformation.version;
            jComboBoxVersion.setSelectedItem(selected);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            if (OfficeApplication.getOfficeDocumentProxy().needsSendToPublish(pageInformation))
            {
                this.jCheckBoxActive.setToolTipText("El contenido debe ser autorizado antes de activarse");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            if (OfficeApplication.getOfficeDocumentProxy().isInFlow(pageInformation))
            {
                this.jCheckBoxActive.setToolTipText("El contenido esta en proceso de autorización, debe ser autorizado antes de activarse");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        loadRules();
    }

    private void loadRules()
    {
        DefaultTableModel model = (DefaultTableModel) jTableRules.getModel();
        int rows = model.getRowCount();
        for (int i = 1; i <= rows; i++)
        {
            model.removeRow(0);
        }
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try
        {
            for (ElementInfo info : OfficeApplication.getOfficeDocumentProxy().getElementsOfResource(pageInformation))
            {
                Object[] data =
                {
                    info, info.active, info.type
                };
                model.addRow(data);
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
    private void loadTitles()
    {
        try
        {
            LanguageInfo[] languages=OfficeApplication.getOfficeDocumentProxy().getLanguages(pageInformation.page.site);
            ArrayList<String> titles=new ArrayList<String>(languages.length);
            for(LanguageInfo language : languages)
            {
                String title=OfficeApplication.getOfficeDocumentProxy().getTitleOfWebPage(this.pageInformation.page, language);
                titles.add(title);
            }
            this.jLanguageEditor.setLenguages(languages, titles.toArray(new String[titles.size()]));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void loadCalendars()
    {
        DefaultTableModel model = (DefaultTableModel) jTableScheduler.getModel();
        int rows = model.getRowCount();
        for (int i = 1; i <= rows; i++)
        {
            model.removeRow(0);
        }
        try
        {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            for (CalendarInfo info : OfficeApplication.getOfficeDocumentProxy().getCalendarsOfResource(pageInformation))
            {
                if (OfficeApplication.getOfficeApplicationProxy().existCalendar(pageInformation.page.site, info))
                {
                    Object[] data =
                    {
                        info, info.active
                    };
                    model.addRow(data);
                }
            }
            for (CalendarInfo info : added)
            {
                if (OfficeApplication.getOfficeApplicationProxy().existCalendar(pageInformation.page.site, info))
                {
                    Object[] data =
                    {
                        info, info.active
                    };
                    model.addRow(data);
                }
                else
                {
                    added.remove(info);
                }
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

    private void loadProperties()
    {
        try
        {
            HashMap<PropertyInfo, Object> properties = new HashMap<PropertyInfo, Object>();
            PropertyInfo[] o_properties=OfficeApplication.getOfficeDocumentProxy().getResourceProperties(repositoryName, contentID);
            if(o_properties==null || o_properties.length==0)
            {
                this.jTabbedPane1.remove(this.jPanelProperties);
            }
            else
            {
                for (PropertyInfo info : o_properties)
                {
                    String value = OfficeApplication.getOfficeDocumentProxy().getViewPropertyValue(pageInformation, info);
                    properties.put(info, value);
                }
                if(this.panelPropertyEditor1!=null && properties!=null)
                {
                    this.panelPropertyEditor1.loadProperties(properties);
                }
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelOptions = new javax.swing.JPanel();
        jButtonSendToAuthorize = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelInformation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxActive = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabelSite = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelPage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxVersion = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerEndDate = new javax.swing.JSpinner();
        jCheckBoxEndDateActive = new javax.swing.JCheckBox();
        jButtonMove = new javax.swing.JButton();
        jCheckBoxPageActive = new javax.swing.JCheckBox();
        jPanelProperties = new javax.swing.JPanel();
        jPanelSchedule = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableScheduler = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonAddCalendar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonDeleteScheduler = new javax.swing.JButton();
        jPanelRules = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jToolBarRules = new javax.swing.JToolBar();
        jButtonAddRule = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonDeleteRule = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRules = new javax.swing.JTable();
        jPanelTitles = new javax.swing.JPanel();
        jLanguageEditor = new org.semanticwb.openoffice.ui.wizard.LanguageEditor();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Propiedades");
        setResizable(false);

        jPanelOptions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonSendToAuthorize.setText("Enviar a autorización");
        jButtonSendToAuthorize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendToAuthorizeActionPerformed(evt);
            }
        });
        jPanelOptions.add(jButtonSendToAuthorize);

        jButtonOK.setText("Aceptar");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanelOptions.add(jButtonOK);

        jButtonCancel.setText("Cerrar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanelOptions.add(jButtonCancel);

        getContentPane().add(jPanelOptions, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(457, 320));

        jLabel1.setText("Título:");

        jLabel2.setText("Descripción:");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDescription);

        jLabel3.setText("Activo:");

        jLabel4.setText("Sitio:");

        jLabelSite.setText("Sitio de prueba");

        jLabel6.setText("Página:");

        jLabelPage.setText("Página");

        jLabel8.setText("Versión a publicar:");

        jLabel5.setText("Vigencia:");

        jSpinnerEndDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_WEEK));
        jSpinnerEndDate.setEnabled(false);

        jCheckBoxEndDateActive.setText("Activar Vigencia");
        jCheckBoxEndDateActive.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxEndDateActiveItemStateChanged(evt);
            }
        });
        jCheckBoxEndDateActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEndDateActiveActionPerformed(evt);
            }
        });

        jButtonMove.setText("Mover");
        jButtonMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveActionPerformed(evt);
            }
        });

        jCheckBoxPageActive.setText("Página activa");

        javax.swing.GroupLayout jPanelInformationLayout = new javax.swing.GroupLayout(jPanelInformation);
        jPanelInformation.setLayout(jPanelInformationLayout);
        jPanelInformationLayout.setHorizontalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformationLayout.createSequentialGroup()
                        .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
                    .addComponent(jLabel8)
                    .addGroup(jPanelInformationLayout.createSequentialGroup()
                        .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSite, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxActive, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanelInformationLayout.createSequentialGroup()
                                    .addComponent(jLabelPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonMove)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBoxPageActive))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInformationLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelInformationLayout.createSequentialGroup()
                                            .addComponent(jCheckBoxEndDateActive)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSpinnerEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jComboBoxVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanelInformationLayout.setVerticalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSite)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelPage)
                    .addComponent(jButtonMove)
                    .addComponent(jCheckBoxPageActive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxActive)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBoxEndDateActive))
                    .addComponent(jLabel5))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Información", jPanelInformation);

        jPanelProperties.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Propiedades de publicación", jPanelProperties);

        jPanelSchedule.setLayout(new java.awt.BorderLayout());

        jTableScheduler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableScheduler.setColumnSelectionAllowed(true);
        jTableScheduler.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableScheduler.getTableHeader().setReorderingAllowed(false);
        jTableScheduler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSchedulerKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableScheduler);
        jTableScheduler.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanelSchedule.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonAddCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/add.png"))); // NOI18N
        jButtonAddCalendar.setToolTipText("Agregar una calendarizacin para la publicación actual");
        jButtonAddCalendar.setFocusable(false);
        jButtonAddCalendar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddCalendar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAddCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCalendarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAddCalendar);
        jToolBar1.add(jSeparator1);

        jButtonDeleteScheduler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/delete.png"))); // NOI18N
        jButtonDeleteScheduler.setToolTipText("Eliminar la calendarización seleccionada");
        jButtonDeleteScheduler.setEnabled(false);
        jButtonDeleteScheduler.setFocusable(false);
        jButtonDeleteScheduler.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDeleteScheduler.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDeleteScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteSchedulerActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonDeleteScheduler);

        jPanelSchedule.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Calendarización", jPanelSchedule);

        jPanelRules.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(448, 30));

        jToolBarRules.setFloatable(false);
        jToolBarRules.setRollover(true);

        jButtonAddRule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/add.png"))); // NOI18N
        jButtonAddRule.setToolTipText("Agregar una calendarizacin para la publicación actual");
        jButtonAddRule.setFocusable(false);
        jButtonAddRule.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddRule.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAddRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRuleActionPerformed(evt);
            }
        });
        jToolBarRules.add(jButtonAddRule);
        jToolBarRules.add(jSeparator2);

        jButtonDeleteRule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/delete.png"))); // NOI18N
        jButtonDeleteRule.setToolTipText("Eliminar la calendarización seleccionada");
        jButtonDeleteRule.setEnabled(false);
        jButtonDeleteRule.setFocusable(false);
        jButtonDeleteRule.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDeleteRule.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDeleteRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRuleActionPerformed(evt);
            }
        });
        jToolBarRules.add(jButtonDeleteRule);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBarRules, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBarRules, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRules.add(jPanel4, java.awt.BorderLayout.NORTH);

        jTableRules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Activar", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRules.setColumnSelectionAllowed(true);
        jTableRules.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableRulesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRules);
        jTableRules.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanelRules.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Reglas / Roles o Grupos de Usuarios", jPanelRules);

        jPanelTitles.setLayout(new java.awt.BorderLayout());
        jPanelTitles.add(jLanguageEditor, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Títulos de página", jPanelTitles);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
}//GEN-LAST:event_jRadioButton1ActionPerformed

private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
}//GEN-LAST:event_jRadioButton2ActionPerformed

private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
    isCancel = true;
    this.setVisible(false);
}//GEN-LAST:event_jButtonCancelActionPerformed

private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
    isCancel = false;
    if (this.jTextFieldTitle.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(this, "¡Debe indicar el título de la públicación!", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
        jTextFieldTitle.requestFocus();
        return;
    }
    if (this.jTextAreaDescription.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(this, "¡Debe indicar una descripción de la públicación!", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
        jTextAreaDescription.requestFocus();
        return;
    }
    int res = JOptionPane.showConfirmDialog(this, "Se va a realizar los cambios de la información de publicación.\r\n¿Desea continuar?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (res == JOptionPane.YES_OPTION)
    {
        pageInformation.title = this.jTextFieldTitle.getText();
        pageInformation.description = this.jTextAreaDescription.getText();
        pageInformation.version = ((VersionInfo) this.jComboBoxVersion.getSelectedItem()).nameOfVersion;
        pageInformation.active = this.jCheckBoxActive.isSelected();
        try
        {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            OfficeApplication.getOfficeDocumentProxy().updatePorlet(pageInformation);
            if (this.jCheckBoxEndDateActive.isSelected())
            {
                Date date = (Date) this.jSpinnerEndDate.getValue();
                OfficeApplication.getOfficeDocumentProxy().setEndDate(pageInformation, date);
            }
            else
            {
                OfficeApplication.getOfficeDocumentProxy().deleteEndDate(pageInformation);
            }
            if (this.jCheckBoxActive.isSelected())
            {
                if (this.pageInformation.active)
                {
                    try
                    {
                        OfficeApplication.getOfficeDocumentProxy().activateResource(pageInformation, this.jCheckBoxActive.isSelected());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    try
                    {
                        if (OfficeApplication.getOfficeDocumentProxy().needsSendToPublish(pageInformation))
                        {
                            this.jCheckBoxActive.setSelected(pageInformation.active);
                            res = JOptionPane.showConfirmDialog(this, "El documento requiere una autorización para activarse\r\n¿Desea envíar a publicar el contenido?", this.getTitle(), JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION)
                            {
                                DialogSelectFlow formSendToAutorize = new DialogSelectFlow(pageInformation);
                                formSendToAutorize.setVisible(true);
                                if (formSendToAutorize.selected != null)
                                {
                                    OfficeApplication.getOfficeDocumentProxy().sendToAuthorize(pageInformation, formSendToAutorize.selected, formSendToAutorize.jTextAreaMessage.getText());
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(this, "El contenido no se activo, ya que se requiere una autorización", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this, "El contenido no se activo, ya que se requiere una autorización", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else if (OfficeApplication.getOfficeDocumentProxy().isInFlow(pageInformation))
                        {
                            this.jCheckBoxActive.setSelected(pageInformation.active);
                            JOptionPane.showMessageDialog(this, "El contenido se encuentra en proceso de ser autorizado.\r\nPara activarlo necesita terminar el proceso de autorización", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if (OfficeApplication.getOfficeDocumentProxy().isAuthorized(pageInformation))
                        {
                            OfficeApplication.getOfficeDocumentProxy().activateResource(pageInformation, this.jCheckBoxActive.isSelected());
                        }
                        else
                        {
                            this.jCheckBoxActive.setSelected(pageInformation.active);
                            res = JOptionPane.showConfirmDialog(this, "El contenido fue rechazado.\r\nPara activarlo necesita enviarlo a autorización de nuevo\r\n¿Desea enviarlo a autorización?", this.getTitle(), JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION)
                            {
                                DialogSelectFlow formSendToAutorize = new DialogSelectFlow(pageInformation);
                                formSendToAutorize.setVisible(true);
                                if (formSendToAutorize.selected != null)
                                {
                                    OfficeApplication.getOfficeDocumentProxy().sendToAuthorize(pageInformation, formSendToAutorize.selected, formSendToAutorize.jTextAreaMessage.getText());
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(this, "El contenido no se activo, ya que se requiere una autorización", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this, "El contenido no se activo, ya que se requiere una autorización", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                try
                {
                    OfficeApplication.getOfficeDocumentProxy().activateResource(pageInformation, this.jCheckBoxActive.isSelected());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            String[] titles=this.jLanguageEditor.getTitles();
            LanguageInfo[] languages=this.jLanguageEditor.getLanguages();
            OfficeApplication.getOfficeDocumentProxy().setTitlesOfWebPage(this.pageInformation.page, languages, titles);
            OfficeApplication.getOfficeApplicationProxy().activePage(this.pageInformation.page, this.jCheckBoxPageActive.isSelected());
            DefaultTableModel model = (DefaultTableModel) jTableScheduler.getModel();
            for (int i = 0; i < jTableScheduler.getRowCount(); i++)
            {
                CalendarInfo cal = (CalendarInfo) model.getValueAt(i, 0);
                boolean active = (Boolean) model.getValueAt(i, 1);
                OfficeApplication.getOfficeDocumentProxy().insertCalendartoResource(pageInformation, cal);
                added.remove(cal);
                OfficeApplication.getOfficeDocumentProxy().activeCalendar(pageInformation, cal, active);
            }
            model = (DefaultTableModel) jTableRules.getModel();
            for (int i = 0; i < jTableRules.getRowCount(); i++)
            {
                ElementInfo ruleInfo = (ElementInfo) model.getValueAt(i, 0);
                Boolean active = (Boolean) model.getValueAt(i, 1);
                ruleInfo.active = active.booleanValue();
                OfficeApplication.getOfficeDocumentProxy().addElementToResource(pageInformation, ruleInfo);
            }

            for (PropertyInfo prop : this.panelPropertyEditor1.getProperties().keySet())
            {

                Object obj = this.panelPropertyEditor1.getProperties().get(prop);
                String value = null;
                if (obj != null)
                {
                    value = obj.toString();
                }
                OfficeApplication.getOfficeDocumentProxy().setResourceProperties(pageInformation, prop, value);
            }
            JOptionPane.showMessageDialog(this, "¡Se ha guardado la información correctamente!", this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "¡Existe un error la guardar la información!\r\nDetalle: " + e.getLocalizedMessage(), this.getTitle(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        finally
        {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

}//GEN-LAST:event_jButtonOKActionPerformed

private void jButtonAddCalendarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddCalendarActionPerformed
{//GEN-HEADEREND:event_jButtonAddCalendarActionPerformed
    DialogCalendarList list = new DialogCalendarList(pageInformation);
    list.setVisible(true);
    if (!list.isCanceled())
    {
        DefaultListModel model = (DefaultListModel) list.jListCalendars.getModel();
        if (list.jListCalendars.getSelectedIndices() != null)
        {
            for (int index : list.jListCalendars.getSelectedIndices())
            {
                CalendarInfo calendar = (CalendarInfo) model.get(index);
                boolean exists = false;
                DefaultTableModel tableModel = (DefaultTableModel) this.jTableScheduler.getModel();
                int count = tableModel.getRowCount();
                for (int i = 0; i < count; i++)
                {
                    CalendarInfo calactual = (CalendarInfo) tableModel.getValueAt(0, i);
                    if (calactual.id.equals(calendar.id))
                    {
                        exists = true;
                        break;
                    }
                }
                if (!exists)
                {
                    try
                    {
                        added.add(calendar);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    loadCalendars();
}//GEN-LAST:event_jButtonAddCalendarActionPerformed

private void jButtonDeleteSchedulerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeleteSchedulerActionPerformed
{//GEN-HEADEREND:event_jButtonDeleteSchedulerActionPerformed
    if (jTableScheduler.getSelectedRow() != -1)
    {
        int res = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la calendarización?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION)
        {
            CalendarInfo cal = (CalendarInfo) jTableScheduler.getModel().getValueAt(jTableScheduler.getSelectedRow(), 0);
            DefaultTableModel model = (DefaultTableModel) jTableScheduler.getModel();
            model.removeRow(jTableScheduler.getSelectedRow());

            if (model.getRowCount() == 0 || jTableScheduler.getSelectedRow() == -1)
            {
                this.jButtonDeleteScheduler.setEnabled(false);
            }
            try
            {
                added.remove(cal);
                OfficeApplication.getOfficeDocumentProxy().deleteCalendar(pageInformation, cal);
                loadCalendars();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    if (this.jTableScheduler.getSelectedRow() == -1)
    {
        this.jButtonDeleteScheduler.setEnabled(false);
    }
}//GEN-LAST:event_jButtonDeleteSchedulerActionPerformed

private void jButtonSendToAuthorizeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSendToAuthorizeActionPerformed
{//GEN-HEADEREND:event_jButtonSendToAuthorizeActionPerformed
    DialogSelectFlow dialogSelectFlow = new DialogSelectFlow(pageInformation);
    dialogSelectFlow.setVisible(true);
    if (dialogSelectFlow.selected != null)
    {
        try
        {
            OfficeApplication.getOfficeDocumentProxy().sendToAuthorize(pageInformation, dialogSelectFlow.selected, dialogSelectFlow.jTextAreaMessage.getText());
            this.jButtonSendToAuthorize.setVisible(false);
            try
            {
                if (OfficeApplication.getOfficeDocumentProxy().needsSendToPublish(pageInformation))
                {
                    this.jCheckBoxActive.setToolTipText("El contenido debe ser autorizado antes de activarse");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                if (OfficeApplication.getOfficeDocumentProxy().isInFlow(pageInformation))
                {
                    this.jCheckBoxActive.setToolTipText("El contenido esta en proceso de autorización, debe ser autorizado antes de activarse");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}//GEN-LAST:event_jButtonSendToAuthorizeActionPerformed

private void jCheckBoxEndDateActiveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxEndDateActiveActionPerformed
{//GEN-HEADEREND:event_jCheckBoxEndDateActiveActionPerformed
}//GEN-LAST:event_jCheckBoxEndDateActiveActionPerformed

private void jCheckBoxEndDateActiveItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jCheckBoxEndDateActiveItemStateChanged
{//GEN-HEADEREND:event_jCheckBoxEndDateActiveItemStateChanged
    if (jCheckBoxEndDateActive.isSelected())
    {
        this.jSpinnerEndDate.setEnabled(true);
    }
    else
    {
        this.jSpinnerEndDate.setEnabled(false);
    }
}//GEN-LAST:event_jCheckBoxEndDateActiveItemStateChanged

private void jButtonAddRuleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddRuleActionPerformed
{//GEN-HEADEREND:event_jButtonAddRuleActionPerformed
    DialogAddRule dialogAddRule = new DialogAddRule(this.pageInformation.page.site, this.pageInformation);
    dialogAddRule.setVisible(true);
    if (!dialogAddRule.isCanceled())
    {
        ElementInfo rule = dialogAddRule.getRule();
        try
        {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            OfficeApplication.getOfficeDocumentProxy().addElementToResource(pageInformation, rule);
            loadRules();
            DefaultTableModel model = (DefaultTableModel) jTableRules.getModel();
            if (model.getRowCount() == 0 || jTableRules.getSelectedRow() == -1)
            {
                jButtonDeleteRule.setEnabled(false);
            }
            else
            {
                jButtonDeleteRule.setEnabled(true);
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
}//GEN-LAST:event_jButtonAddRuleActionPerformed

private void jButtonDeleteRuleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeleteRuleActionPerformed
{//GEN-HEADEREND:event_jButtonDeleteRuleActionPerformed
    if (this.jTableRules.getModel().getRowCount() > 0 && this.jTableRules.getSelectedRow() != -1)
    {
        DefaultTableModel model = (DefaultTableModel) jTableRules.getModel();
        ElementInfo info = (ElementInfo) model.getValueAt(this.jTableRules.getSelectedRow(), 0);
        int res = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la regla / rol ó grupo de usuario " + info.title, this.getTitle(), JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION)
        {
            try
            {
                this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                OfficeApplication.getOfficeDocumentProxy().deleteElementToResource(pageInformation, info);
                loadRules();
                if (model.getRowCount() == 0 || jTableRules.getSelectedRow() == -1)
                {
                    jButtonDeleteRule.setEnabled(false);
                }
                else
                {
                    jButtonDeleteRule.setEnabled(true);
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
    }
}//GEN-LAST:event_jButtonDeleteRuleActionPerformed
    public ResourceInfo getResourceInfo()
    {
        return pageInformation;
    }
private void jButtonMoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonMoveActionPerformed
{//GEN-HEADEREND:event_jButtonMoveActionPerformed

    try
    {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        MoveContentResultProducer resultProducer = new MoveContentResultProducer(this);
        WizardPage[] clazz = new WizardPage[]
        {
            new SelectPage(this.pageInformation.page.site.id)
        };
        Wizard wiz = WizardPage.createWizard("Mover Contenido de Página", clazz, resultProducer);
        wiz.show();
    }
    catch (Exception ue)
    {
        ue.printStackTrace();
    }
    finally
    {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}//GEN-LAST:event_jButtonMoveActionPerformed

private void jTableSchedulerKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTableSchedulerKeyReleased
{//GEN-HEADEREND:event_jTableSchedulerKeyReleased
    if (evt.getKeyCode() == KeyEvent.VK_DELETE && jTableScheduler.getSelectedRow() != -1)
    {
        jButtonDeleteSchedulerActionPerformed(null);
    }
}//GEN-LAST:event_jTableSchedulerKeyReleased

private void jTableRulesKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTableRulesKeyPressed
{//GEN-HEADEREND:event_jTableRulesKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_DELETE && jTableScheduler.getSelectedRow() != -1)
    {
        jButtonDeleteRuleActionPerformed(null);
    }
}//GEN-LAST:event_jTableRulesKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCalendar;
    private javax.swing.JButton jButtonAddRule;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDeleteRule;
    private javax.swing.JButton jButtonDeleteScheduler;
    private javax.swing.JButton jButtonMove;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonSendToAuthorize;
    private javax.swing.JCheckBox jCheckBoxActive;
    private javax.swing.JCheckBox jCheckBoxEndDateActive;
    private javax.swing.JCheckBox jCheckBoxPageActive;
    private javax.swing.JComboBox jComboBoxVersion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelPage;
    private javax.swing.JLabel jLabelSite;
    private org.semanticwb.openoffice.ui.wizard.LanguageEditor jLanguageEditor;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelOptions;
    private javax.swing.JPanel jPanelProperties;
    private javax.swing.JPanel jPanelRules;
    private javax.swing.JPanel jPanelSchedule;
    private javax.swing.JPanel jPanelTitles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSpinner jSpinnerEndDate;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableRules;
    private javax.swing.JTable jTableScheduler;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBarRules;
    // End of variables declaration//GEN-END:variables
}
