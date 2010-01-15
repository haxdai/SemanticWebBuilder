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
 * TitleAndDescription.java
 *
 * Created on 3 de junio de 2008, 10:57 AM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.util.Map;
import javax.swing.JOptionPane;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;
import org.semanticwb.office.interfaces.ContentType;
import org.semanticwb.openoffice.OfficeApplication;
import org.semanticwb.openoffice.util.FixedLengthPlainDocument;

/**
 *
 * @author  victor.lorenzana
 */
public class TitleAndDescription extends WizardPage
{

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String NODE_TYPE = "NODE_TYPE";
    boolean showTypeOfcontent = true;

    /** Creates new form TitleAndDescription */
    public TitleAndDescription(boolean showTypeOfcontent)
    {
        this();
        this.showTypeOfcontent = showTypeOfcontent;
        this.jComboBoxType.setVisible(showTypeOfcontent);
        this.jLabelType.setVisible(showTypeOfcontent);

    }

    @Override
    protected void renderingPage()
    {   
        super.renderingPage();
        this.jTextFieldName.requestFocus();
    }

    public TitleAndDescription()
    {
        initComponents();
        this.jTextFieldName.setDocument(new FixedLengthPlainDocument(255));
        this.jTextAreaDescription.setDocument(new FixedLengthPlainDocument(255));
        this.jComboBoxType.removeAllItems();
        try
        {
            if (SelectCategory.map!=null && SelectCategory.map.get(SelectCategory.REPOSITORY_ID) != null)
            {
                String repository = SelectCategory.map.get(SelectCategory.REPOSITORY_ID).toString();
                for (ContentType type : OfficeApplication.getOfficeApplicationProxy().getContentTypes(repository))
                {
                    this.jComboBoxType.addItem(type);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getDescription()
    {
        return java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/TitleAndDescription").getString("TÍTULO_Y_DESCRIPCIÓN");
    }

    @Override
    public WizardPanelNavResult allowNext(String arg, Map map, Wizard wizard)
    {
        return allowFinish(arg, map, wizard);
    }

    /**     *
     * @param arg
     * @param map
     * @param wizard
     * @return
     */
    @Override
    public WizardPanelNavResult allowFinish(String arg, Map map, Wizard wizard)
    {
        WizardPanelNavResult result = WizardPanelNavResult.REMAIN_ON_PAGE;
        if (this.jTextFieldName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/TitleAndDescription").getString("¡DEBE_INDICAR_EL_TÍTULO_DEL_CONTENIDO!"), getDescription(), JOptionPane.ERROR_MESSAGE);
            this.jTextFieldName.requestFocus();
        }
        else if (this.jTextAreaDescription.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/TitleAndDescription").getString("¡DEBE_INDICAR_LA_DESCRIPCIÓN_DEL_CONTENIDO!"), getDescription(), JOptionPane.ERROR_MESSAGE);
            this.jTextAreaDescription.requestFocus();
        }
        if (showTypeOfcontent)
        {
            if (this.jComboBoxType.getSelectedItem() == null)
            {
                JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/TitleAndDescription").getString("¡DEBE_INDICAR_EL_TIPO_DE_CONTENIDO!"), getDescription(), JOptionPane.ERROR_MESSAGE);
                this.jComboBoxType.requestFocus();
            }
            else
            {
                map.put(TITLE, this.jTextFieldName.getText().trim());
                map.put(DESCRIPTION, this.jTextAreaDescription.getText().trim());
                map.put(NODE_TYPE, ((ContentType) this.jComboBoxType.getSelectedItem()).id);
                result = WizardPanelNavResult.PROCEED;
            }
        }
        else
        {
            map.put(TITLE, this.jTextFieldName.getText().trim());
            map.put(DESCRIPTION, this.jTextAreaDescription.getText().trim());
            result = WizardPanelNavResult.PROCEED;
        }
        return result;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelName = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabelType = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/semanticwb/openoffice/ui/wizard/TitleAndDescription"); // NOI18N
        jLabelName.setText(bundle.getString("TÍTULO:")); // NOI18N

        jLabelDescription.setText(bundle.getString("DESCRIPCIÓN:")); // NOI18N

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setLineWrap(true);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jLabelType.setText(bundle.getString("TIPO_DE_CONTENIDO:")); // NOI18N

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelType)
                    .addComponent(jLabelDescription)
                    .addComponent(jLabelName))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jComboBoxType, 0, 294, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelName))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescription)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelType)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
