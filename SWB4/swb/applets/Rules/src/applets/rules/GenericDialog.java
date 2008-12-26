/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * GenericDialog.java
 *
 * Created on 20 de enero de 2006, 12:37 PM
 */

package applets.rules;

/**
 *
 * @author  Samuel Aceves modified by Juan Antonio Fern�ndez
 */


import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import applets.commons.*;
import java.util.*;
import java.io.*;
import applets.rules.*;

public class GenericDialog
extends JDialog
implements ActionListener
{
    public static final int ADD_MODE    = 0;
    public static final int EDIT_MODE   = 1;
    public static final int VIEW_MODE   = 2;
    
    private HashMap returnValuesMap;
    private String pathDialogXML;
    private String usrAttrXML;
    private WBTreeNode dialogNode, attrNode;
    private Vector panelVec;
    private HashMap fieldHash;
    private HashMap defaultValuesMap;
    private int displayMode;
    private WBTreeNode catalogSrcNode;
    
    private String attribute=null, attSelActual=null;
    private String operator=null, operatorSelActual=null ;
    private String attrValue=null, attrValueActual=null;
    
    private String toolTipText = "";
    
    private String attrType="catalog";
    
    public GenericDialog(Frame frame, String title, String pathDialogXML, String usrAttrXML, String attribute, String operator, String attrValue)
    throws IOException
    {
        super(frame, title, true);
        
        this.pathDialogXML      = pathDialogXML;
        this.usrAttrXML = usrAttrXML;
        this.panelVec           = new Vector();
        this.fieldHash          = new HashMap();
        this.returnValuesMap    = new HashMap();
        this.defaultValuesMap   = new HashMap();
        this.displayMode        = ADD_MODE;
        this.catalogSrcNode     = null;
        
        this.attribute = attribute;
        this.operator = operator;
        this.attrValue = attrValue;
        
        this.attSelActual = attribute;
        this.operatorSelActual = operator;
        this.attrValueActual = attrValue;
        
        buildDialog();
    }
    
    
    public HashMap displayDialog(int width, int height, int displayMode)
    throws IOException
    {
        this.displayMode = displayMode;
        
        prepareDefaultValues();
        
        this.setSize(width, height);
        this.setVisible(true);
        
        return(returnValuesMap);
    }
    
    
    
    public void buildDialog()
    throws IOException
    {
        BufferedReader reader;
        InputStream input;
        Iterator panelIterator;
        JPanel tempPanel;
        String tempLine, dialogXML;
        WBTreeNode tempTreeNode, panelsNode;
        WBXMLParser parser;
        
        //Read dialog configuration from file
        
        input       = getClass().getClassLoader().getResourceAsStream(this.pathDialogXML);
        reader      = new BufferedReader(new InputStreamReader(input));
        dialogXML   = "";
        
        while(null != (tempLine = reader.readLine()))
        {
            dialogXML = dialogXML + tempLine;
        }
        
        reader.close();
        input.close();
        
        //Prepare DOM node
        parser          = new WBXMLParser();
        this.dialogNode = parser.parse(dialogXML);
        this.attrNode = parser.parse(usrAttrXML);
        panelsNode      = this.dialogNode.getFirstNode().getNodebyName("panels");
        
        //Prepare main pane
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));
        
        panelIterator = panelsNode.getNodesbyName("panel");
        
        while(panelIterator.hasNext())
        {
            tempTreeNode    = (WBTreeNode) panelIterator.next();
            tempPanel       = new JPanel();
            
            tempPanel.setBorder(new TitledBorder(tempTreeNode.getAttribute("title")));
            getContentPane().add(tempPanel);
            
            preparePanel(tempPanel, tempTreeNode);
            
            this.panelVec.add(tempPanel);
        }
        
    }
    
    public void actionPerformed(java.awt.event.ActionEvent actionEvent)
    {
        String actionCommand;
        
        actionCommand = actionEvent.getActionCommand();
        
        if("doOK".equals(actionCommand))
        {
            if(validateForm())
            {
                prepareReturnValues();
                this.setVisible(false);
            }
        }
        else if("doCancel".equals(actionCommand))
        {
            this.setVisible(false);
        }
        //changeAttribute
        else if("changeAttribute".equals(actionCommand))
        {
            Iterator ite= fieldHash.keySet().iterator();
            while(ite.hasNext())
            {
                String campo = (String) ite.next();
                if("caracteristica".equals(campo))
                {
                    javax.swing.JComboBox combo = (javax.swing.JComboBox) fieldHash.get(campo);
                    ComboItem comItem = (ComboItem) combo.getSelectedItem();
                    javax.swing.JLabel tempLabelcombo, tempLabeltxt ;
                    javax.swing.JTextField txtField;
                    javax.swing.JComboBox comboVals;
                    String attrSelected = comItem.getValue();
                    String attrSelectedType = getAttributeType(attrSelected);
                    
                    
                    attSelActual = attrSelected;
                    operatorSelActual = operator;
                    attrValueActual=attrValue;
                    
                    
                    updateFormElement(attrSelected);
                    
                }
            }
        }
    }
    
    public void loadComboOper(javax.swing.JComboBox comboBox, String attrSelected, String loadCat, String selectValue)
    {
        ComboItem tempItem;
        Iterator catalogIterator, optionIterator, operIterator, valIterator;
        String tempName;
        WBTreeNode catalogsNode, catalogNode, tempNode, catalogOperNode, catalogValNode;
        catalogsNode    = this.attrNode.getNodebyName("attributes");
        catalogIterator = catalogsNode.getNodesbyName("attribute");
        if("operator".equals(loadCat))
        {
            while(catalogIterator.hasNext())
            {
                catalogNode = (WBTreeNode) catalogIterator.next();
                
                if(attrSelected.equals(catalogNode.getAttribute("name")))
                {
                    attrType = catalogNode.getAttribute("type");
                    catalogOperNode = catalogNode.getNodebyName("operators");
                    operIterator = catalogOperNode.getNodesbyName("operator");
                    while(operIterator.hasNext())
                    {
                        catalogOperNode = (WBTreeNode) operIterator.next();
                        tempItem    = new ComboItem(catalogOperNode.getAttribute("title"), catalogOperNode.getAttribute("value"));
                        comboBox.addItem(tempItem);
                        if(catalogOperNode.getAttribute("value").equals(selectValue))
                            comboBox.setSelectedItem(tempItem);
                    }
                    break;
                }
            }
        }
        else if("attValues".equals(loadCat))
        {
            catalogsNode    = this.attrNode.getNodebyName("attributes");
            catalogIterator = catalogsNode.getNodesbyName("attribute");
            while(catalogIterator.hasNext())
            {
                catalogNode = (WBTreeNode) catalogIterator.next();
                if(attrSelected.equals(catalogNode.getAttribute("name")))
                {
                    catalogOperNode = catalogNode.getNodebyName("catalog");
                    operIterator = catalogOperNode.getNodesbyName("option");
                    while(operIterator.hasNext())
                    {
                        catalogOperNode = (WBTreeNode) operIterator.next();
                        tempItem    = new ComboItem(catalogOperNode.getAttribute("title"), catalogOperNode.getAttribute("value"));
                        comboBox.addItem(tempItem);
                        if(catalogOperNode.getAttribute("value").equals(selectValue))
                            comboBox.setSelectedItem(tempItem);
                    }
                    break;
                }
            }
            
        }
    }
    
    public void preparePanel(JPanel panel, WBTreeNode panelNode)
    {
        int iRow, iGridX, iGridY;
        GridBagConstraints constraints;
        Iterator fieldIterator;
        JButton tempButton;
        JComboBox tempComboBox;
        JLabel tempLabel;
        JTextField tempText;
        String panelType, fieldType, fieldTitle, fieldName, fieldLabel;
        String buttonAction, columns, catalogName;
        String parentName, childName, titleField, valueField, titleSeparator, valueSeparator;
        WBTreeNode tempNode, fieldsNode;
        
        panelType   = panelNode.getAttribute("type");
        constraints = new GridBagConstraints();
        iGridX      = 0;
        iGridY      = 0;
        
        if("Grid".equals(panelType))
        {
            panel.setLayout(new GridBagLayout());
        }
        else
        {
            panel.setLayout(new FlowLayout());
        }
        
        fieldsNode    = panelNode.getNodebyName("fields");
        
        if(null != fieldsNode)
        {
            fieldIterator = fieldsNode.getNodesbyName("field");
            
            while(fieldIterator.hasNext())
            {
                tempNode    = (WBTreeNode) fieldIterator.next();
                fieldLabel  = tempNode.getAttribute("label");
                fieldName   = tempNode.getAttribute("name");
                fieldType   = tempNode.getAttribute("type");
                fieldTitle  = tempNode.getAttribute("title");
                if("button".equals(fieldType))
                {
                    buttonAction    = tempNode.getAttribute("action");
                    tempButton      = new JButton(fieldLabel);
                    
                    tempButton.setActionCommand(buttonAction);
                    tempButton.addActionListener(this);
                    
                    panel.add(tempButton);
                }
                else if("text".equals(fieldType))
                {
                    columns     = tempNode.getAttribute("columns");
                    tempLabel   = new JLabel(fieldLabel);
                    tempLabel.setName("_label"+fieldName);
                    tempText    = new JTextField("", Integer.parseInt(columns));
                    
                    if("Grid".equals(panelType))
                    {
                        constraints.gridx   = iGridX;
                        constraints.gridy   = iGridY;
                        constraints.weightx = 0.15;
                        constraints.insets  = new Insets(10, 0, 10, 0);
                        constraints.anchor  = GridBagConstraints.WEST;
                        
                        panel.add(tempLabel, constraints);
                        
                        constraints.gridx   = iGridX+1;
                        constraints.gridy   = iGridY;
                        constraints.weightx = 0.75;
                        constraints.insets  = new Insets(0, 10, 0, 0);
                        constraints.anchor  = GridBagConstraints.WEST;
                        constraints.fill    = GridBagConstraints.HORIZONTAL;
                        
                        panel.add(tempText, constraints);
                        
                        iGridY ++;
                    }
                    else
                    {
                        panel.add(tempLabel);
                        panel.add(tempText);
                    }
                    this.fieldHash.put("_label"+fieldName, tempLabel);
                    this.fieldHash.put(fieldName, tempText);
                    tempText.addActionListener(this);
                }
                else if("catalog".equals(fieldType))
                {
                    catalogName     = tempNode.getAttribute("catalog");
                    parentName      = tempNode.getAttribute("parentName");
                    childName       = tempNode.getAttribute("childName");
                    titleField      = tempNode.getAttribute("titleField");
                    valueField      = tempNode.getAttribute("valueField");
                    titleSeparator  = tempNode.getAttribute("titleSeparator");
                    valueSeparator  = tempNode.getAttribute("valueSeparator");
                    
                    tempLabel       = new JLabel(fieldLabel);
                    tempLabel.setName("_label"+fieldName);
                    tempComboBox    = new JComboBox();
                    
                    if("caracteristica".equals(fieldName))
                    {
                        buttonAction = tempNode.getAttribute("action");
                        tempComboBox.setActionCommand(buttonAction);
                        tempComboBox.addActionListener(this);
                    }
                    
                    if("Grid".equals(panelType))
                    {
                        constraints.gridx   = iGridX;
                        constraints.gridy   = iGridY;
                        constraints.weightx = 0.15;
                        constraints.insets  = new Insets(10, 0, 10, 0);
                        constraints.anchor  = GridBagConstraints.WEST;
                        
                        panel.add(tempLabel, constraints);
                        
                        constraints.gridx   = iGridX+1;
                        constraints.gridy   = iGridY;
                        constraints.weightx = 0.75;
                        constraints.insets  = new Insets(0, 10, 0, 0);
                        constraints.anchor  = GridBagConstraints.WEST;
                        constraints.fill    = GridBagConstraints.HORIZONTAL;
                        
                        panel.add(tempComboBox, constraints);
                        
                        iGridY ++;
                    }
                    else
                    {
                        panel.add(tempLabel);
                        panel.add(tempComboBox);
                    }
                    
                    if("catalog".equals(fieldType))
                    {
                        fillCombo(tempComboBox, catalogName, attribute);
                    }
                    
                    if(null!=tempComboBox)
                    {
                        this.fieldHash.put("_label"+fieldName, tempLabel);
                        this.fieldHash.put(fieldName, tempComboBox);
                    }
                }
            }
        }
    }
    
    
    public String getAttributeType(String paramAttr)
    {
        ComboItem tempItem;
        Iterator catalogIterator;
        String tempName=null;
        WBTreeNode catalogsNode, catalogNode, tempNode, catalogOperNode, catalogValNode;
        
        catalogsNode    = this.attrNode.getNodebyName("attributes");
        catalogIterator = catalogsNode.getNodesbyName("attribute");
        
        while(catalogIterator.hasNext())
        {
            catalogNode = (WBTreeNode) catalogIterator.next();
            if(paramAttr.equals(catalogNode.getAttribute("name")))
            {
                tempName = catalogNode.getAttribute("type");
                break;
            }
        }
        return tempName;
    }
    
    protected boolean validateForm()
    {
        Iterator fieldsIterator;
        JTextField tempText;
        JComboBox tempComboBox;
        JDialog errorDialog;
        String fieldName, fieldType, isMandatory, fieldLabel, fieldTitle;
        WBTreeNode fieldNode;
        
        fieldsIterator  = this.fieldHash.keySet().iterator();
        
        while(fieldsIterator.hasNext())
        {
            fieldName   = (String) fieldsIterator.next();
            fieldNode   = findField(fieldName);
            
            if(fieldName.startsWith("_label")) continue;
            
            if(null == fieldNode)
            {
                JOptionPane.showMessageDialog(this, "Field not found on FORM.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
                
                return(false);
            }
            
            fieldType   = fieldNode.getAttribute("type");
            fieldLabel  = fieldNode.getAttribute("label");
            fieldTitle  = fieldNode.getAttribute("title");
            isMandatory = fieldNode.getAttribute("mandatory");
            
            if(null == isMandatory)
            {
                isMandatory = "false";
            }
            
            String tipoAtributo = getAttributeType(attSelActual);
            if("select".equals(tipoAtributo)&&"valortxt".equals(fieldName))  isMandatory = "false";
            if("text".equals(fieldType))
            {
                if("true".equals(isMandatory))
                {
                    tempText = (JTextField) this.fieldHash.get(fieldName);
                    
                    if(null == tempText.getText() || tempText.getText().length() <= 0)
                    {
                        JOptionPane.showMessageDialog(this, "Field [" + fieldTitle + "] must have a value.", "Data Form error", JOptionPane.ERROR_MESSAGE);
                        
                        return(false);
                    }
                }
            }
        }
        return(true);
    }
    
    protected void prepareDefaultValues()
    {
        Iterator fieldsIterator;
        JTextField tempText;
        JComboBox tempComboBox;
        String fieldName, fieldValue, fieldType, fieldTitle;
        WBTreeNode fieldNode;
        attrType="catalog";
        if(null != this.defaultValuesMap)
        {
            fieldsIterator  = this.defaultValuesMap.keySet().iterator();
            
            while(fieldsIterator.hasNext())
            {
                fieldName   = (String) fieldsIterator.next();
                fieldNode   = findField(fieldName);
                
                if(null != fieldNode)
                {
                    fieldType   = fieldNode.getAttribute("type");
                    
                    if("text".equals(fieldType))
                    {
                        fieldValue  = (String) this.defaultValuesMap.get(fieldName);
                        tempText    = (JTextField) this.fieldHash.get(fieldName);
                        tempText.setText(fieldValue);
                        
                        if("select".equals(getAttributeType(attribute))&&"valortxt".equals(fieldName))
                        {
                            JLabel tempLabelcombo =( javax.swing.JLabel) fieldHash.get("_labelvalortxt");
                            tempLabelcombo.setVisible(false);
                            tempLabelcombo.updateUI();
                            tempText.setVisible(false);
                        }
                        if(this.displayMode == VIEW_MODE)
                        {
                            tempText.setEnabled(false);
                        }
                    }
                    else if(("catalog".equals(fieldType)))
                    {
                        fieldValue      = (String) this.defaultValuesMap.get(fieldName);
                        tempComboBox    = (JComboBox) this.fieldHash.get(fieldName);
                        
                        selectCombo(tempComboBox, fieldValue);
                        
                        if("TEXT".equals(getAttributeType(attribute))&&"valor".equals(fieldName))
                        {
                            //tempComboBox.removeAllItems();
                            tempComboBox.setVisible(false);
                        }
                        
                        if(this.displayMode == VIEW_MODE)
                        {
                            tempComboBox.setEnabled(false);
                        }
                    }
                }
            }
            //   INICIALIZANDO CONTROLES DEPENDIENDO DEL TIPO DE ATRIBUTO
            updateFormElement(attribute);
            
        }
    }
    
    protected void updateFormElement(String _pattribute)
    {
        
        javax.swing.JComboBox combo = (javax.swing.JComboBox) fieldHash.get("caracteristica");
        ComboItem comItem = (ComboItem) combo.getSelectedItem();
        
        toolTipText = comItem.gettitle();
        
        javax.swing.JComboBox comboOper = (javax.swing.JComboBox) fieldHash.get("operador");
        comItem = (ComboItem) comboOper.getSelectedItem();
        
        toolTipText += " " + comItem.gettitle();
        
        
        javax.swing.JLabel tempLabelcombo, tempLabeltxt ;
        javax.swing.JTextField txtField;
        javax.swing.JComboBox comboVals;
        
        
        
        
        String attrSelectedType = getAttributeType(_pattribute);
        
        if("select".equals(attrSelectedType))
        {
            comboVals = (javax.swing.JComboBox) fieldHash.get("valor");
            comboVals.removeAllItems();
            comboVals.setVisible(true);
            loadComboOper(comboVals, attSelActual,"attValues",attrValue);
            
            comItem = (ComboItem) comboVals.getSelectedItem();
            toolTipText += " " + comItem.gettitle();
            
            txtField = txtField = (javax.swing.JTextField) fieldHash.get("valortxt");
            txtField.setText("");
            txtField.setVisible(false);
            tempLabelcombo =( javax.swing.JLabel) fieldHash.get("_labelvalor");
            tempLabelcombo.setVisible(true);
            tempLabeltxt = ( javax.swing.JLabel) fieldHash.get("_labelvalortxt");
            tempLabeltxt.setVisible(false);
        }
        else
        {
            txtField = txtField = (javax.swing.JTextField) fieldHash.get("valortxt");
            txtField.setText(attrValueActual);
            txtField.setVisible(true);
            comboVals = (javax.swing.JComboBox) fieldHash.get("valor");
            comboVals.removeAllItems();
            comboVals.setVisible(false);
            loadComboOper(comboVals, attSelActual,"attValues","TEXT");
            tempLabelcombo =( javax.swing.JLabel) fieldHash.get("_labelvalor");
            tempLabelcombo.setVisible(false);
            tempLabeltxt = ( javax.swing.JLabel) fieldHash.get("_labelvalortxt");
            tempLabeltxt.setVisible(true);
        }
        
        txtField.updateUI();
        comboVals.updateUI();
        tempLabelcombo.updateUI();

    }
    
    protected void prepareReturnValues()
    {
        ComboItem tempItem;
        Iterator fieldsIterator;
        JTextField tempText;
        JComboBox tempComboBox;
        String fieldName, fieldValue, fieldType, fieldTitle;
        WBTreeNode fieldNode;
        
        this.returnValuesMap = new HashMap();
        
        fieldsIterator  = this.fieldHash.keySet().iterator();
        
        while(fieldsIterator.hasNext())
        {
            fieldName   = (String) fieldsIterator.next();
            
            if(fieldName.startsWith("_label")) continue;
            
            fieldNode   = findField(fieldName);
            fieldType   = fieldNode.getAttribute("type");
            fieldTitle  = fieldNode.getAttribute("title");
            fieldValue  = "";
            
            if("text".equals(fieldType))
            {
                tempText    = (JTextField) this.fieldHash.get(fieldName);
                fieldValue  = tempText.getText();
                
            }
            else if("catalog".equals(fieldType))
            {
                tempComboBox    = (JComboBox) this.fieldHash.get(fieldName);
                tempItem        = (ComboItem) tempComboBox.getSelectedItem();
                fieldValue      = tempItem.getValue();
            }
            this.returnValuesMap.put(fieldName, fieldValue);
        }
        this.returnValuesMap.put("toolTipText", toolTipText);
    }
    
    private void fillCombo(JComboBox comboBox, String catalogName, String actualAttr)
    {
        ComboItem tempItem;
        Iterator catalogIterator, optionIterator, operIterator, valIterator;
        String tempName;
        WBTreeNode catalogsNode, catalogNode, tempNode, catalogOperNode, catalogValNode;
        catalogsNode    = this.attrNode.getNodebyName(catalogName);
        
        String loadCat = catalogName;
        if("attributes".equals(catalogName))
        {
            loadCat = "attribute";
            catalogIterator = catalogsNode.getNodesbyName(loadCat);
            
            while(catalogIterator.hasNext())
            {
                catalogNode = (WBTreeNode) catalogIterator.next();
                if(null==attribute)
                {
                    attribute=catalogNode.getAttribute("name");
                    attSelActual=attribute;
                    actualAttr = attribute;
                }
                tempItem    = new ComboItem(catalogNode.getAttribute("title"), catalogNode.getAttribute("name"));
                comboBox.addItem(tempItem);
            }
        }
        else if("operators".equals(catalogName))
        {
            
            loadCat = "operator";
            catalogsNode    = this.attrNode.getNodebyName("attributes");
            catalogIterator = catalogsNode.getNodesbyName("attribute");
            
            while(catalogIterator.hasNext())
            {
                catalogNode = (WBTreeNode) catalogIterator.next();
                if(actualAttr.equals(catalogNode.getAttribute("name")))
                {
                    attrType = catalogNode.getAttribute("type");
                    catalogOperNode = catalogNode.getNodebyName("operators");
                    operIterator = catalogOperNode.getNodesbyName("operator");
                    while(operIterator.hasNext())
                    {
                        catalogOperNode = (WBTreeNode) operIterator.next();
                        tempItem    = new ComboItem(catalogOperNode.getAttribute("title"), catalogOperNode.getAttribute("value"));
                        comboBox.addItem(tempItem);
                    }
                    break;
                }
            }
        }
        else if("attValues".equals(catalogName))
        {
            loadCat = "operator";
            catalogsNode    = this.attrNode.getNodebyName("attributes");
            catalogIterator = catalogsNode.getNodesbyName("attribute");
            while(catalogIterator.hasNext())
            {
                catalogNode = (WBTreeNode) catalogIterator.next();
                if(actualAttr.equals(catalogNode.getAttribute("name")))
                {
                    catalogOperNode = catalogNode.getNodebyName("catalog");
                    operIterator = catalogOperNode.getNodesbyName("option");
                    while(operIterator.hasNext())
                    {
                        catalogOperNode = (WBTreeNode) operIterator.next();
                        tempItem    = new ComboItem(catalogOperNode.getAttribute("title"), catalogOperNode.getAttribute("value"));
                        comboBox.addItem(tempItem);
                    }
                    break;
                }
            }
        }
    }
    
    
    public WBTreeNode findField(String name)
    {
        Iterator panelIterator, fieldIterator;
        WBTreeNode panelsNode, panelNode, fieldsNode, fieldNode;
        
        panelsNode = this.dialogNode.getFirstNode().getNodebyName("panels");
        
        if(null != panelsNode)
        {
            panelIterator = panelsNode.getNodesbyName("panel");
            
            while(panelIterator.hasNext())
            {
                panelNode       = (WBTreeNode) panelIterator.next();
                fieldsNode      = panelNode.getNodebyName("fields");
                
                if(null != fieldsNode)
                {
                    fieldIterator   = fieldsNode.getNodesbyName("field");
                    
                    while(fieldIterator.hasNext())
                    {
                        fieldNode = (WBTreeNode) fieldIterator.next();
                        
                        if(name.equals(fieldNode.getAttribute("name")))
                        {
                            return(fieldNode);
                        }
                    }
                }
            }
        }
        
        return(null);
    }
    
    protected void selectCombo(JComboBox combo, String value)
    {
        ComboItem tempItem;
        int numItems, iItem;
        
        numItems = combo.getItemCount();
        
        for(iItem = 0; iItem < numItems; iItem ++)
        {
            tempItem = (ComboItem) combo.getItemAt(iItem);
            
            if(tempItem.getValue().equals(value))
            {
                combo.setSelectedIndex(iItem);
                break;
            }
        }
    }
    
    public void setFieldValue(String fieldName, String fieldValue)
    {
        this.defaultValuesMap.put(fieldName, fieldValue);
    }
    
    public String getReturnValue(String fieldName)
    {
        return((String) this.returnValuesMap.get(fieldName));
    }
    
    public void setCatalogSource(WBTreeNode wbNode)
    {
        this.catalogSrcNode = wbNode;
    }
    
}
