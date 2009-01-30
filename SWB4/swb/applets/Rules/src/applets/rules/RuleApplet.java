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
 * RuleApplet.java
 *
 * Created on 16 de enero de 2006, 11:59 AM
 */

package applets.rules;

import applets.commons.WBConnection;
import applets.commons.WBTreeNode;
import applets.commons.WBXMLParser;
import applets.rules.elements.AndElement;
import applets.rules.elements.CondElement;
import applets.rules.elements.NotElement;
import applets.rules.elements.OrElement;
import applets.modeler.CommandListener;
import applets.modeler.GraphView;
import applets.modeler.elements.EmptyElement;
import applets.modeler.elements.GraphElement;
import applets.modeler.elements.ScopedElement;
import applets.modeler.elements.StartElement;
import java.awt.MediaTracker;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.ButtonModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class RuleApplet extends javax.swing.JApplet implements CommandListener
{
    private HashMap commands=new HashMap();
    private String CMD_POINT="POINT";
    
    private final String PRM_JSESS="jsess";
    private final String PRM_CGIPATH="cgipath";
    private String jsess="";
    private String cgiPath="/gtw.jsp";
    private WBConnection conn=null;
    private String tm=null;
    private String id=null;
    private String act=null;
    private int modeView=0;
    private String xmlAttr=null;
    private String xmlRule=null;
    private boolean error=false;
    
    private Locale locale;
    
    /** Initializes the applet RuleApplet */
    public void init()
    {
        locale=Locale.getDefault();
        //System.out.println("Pa�s:"+locale.getCountry()+" - "+locale.getDisplayLanguage()+" - "+locale.getLanguage());
        if(this.getParameter("locale")!=null && !this.getParameter("locale").equals(""))
        {
            try
            {
                
                locale=new Locale(this.getParameter("locale"));
            }
            catch(Exception e)
            {
                e.printStackTrace(System.out);
            }
        }
        initComponents();
        jsess=this.getParameter(PRM_JSESS);
        cgiPath=this.getParameter(PRM_CGIPATH);
        tm=this.getParameter("tm");
        id=this.getParameter("id");
        act=this.getParameter("act");

        conn=new WBConnection(this);
        
        ((GraphView)jPanel1).setCommandListener(this);
        ((GraphView)jPanel1).setApplet(this);
        ((GraphView)jPanel1).setLocale(locale);
        
        if(null==act)
        {
            modeView=2;
            act="";
            jToolBar1.setVisible(false);
            ((GraphView)jPanel1).setDragEnabled(false);
            ((GraphView)jPanel1).setEnabled(false);
        }
        if("add".equals(act)) modeView=0;
        if("edit".equals(act)) modeView=1;
        
        String comando="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>getXMLAttr."+getTm()+"."+getId()+"</cmd></req>";
        xmlAttr=conn.getData(comando);
        comando="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>getXMLRule."+getTm()+"."+getId()+"</cmd></req>";
        xmlRule = conn.getData(comando);
        
        GraphElement se = ((GraphView)jPanel1).getStartElement();
        Image img=getImage(getClass().getResource("/applets/rules/images/start.gif"));
        MediaTracker tracker = new MediaTracker( this );
        tracker.addImage(img, 1);
        try
        {
            tracker.waitForAll();
        }catch( InterruptedException noe ) {}

        se.setImage(img);
        se.setWidth(85);
        se.setHeight(74);
        se.setX((int)getSize().getWidth()/2);

        if(null!=xmlRule)
        {
            if(xmlRule.indexOf("<rule/>")==-1)
            {
                // dibuja diagrama
                WBXMLParser xmlparser = new WBXMLParser();
                WBTreeNode nodo = xmlparser.parse(xmlRule);
                if(null!=nodo.getNodebyName("rule").getFirstNode() )
                graphRule(se,nodo.getNodebyName("rule").getFirstNode(),0);
            }
        }
        
        
        commands.put("AND", applets.rules.elements.AndElement.class);
        commands.put("OR", applets.rules.elements.OrElement.class);
        commands.put("NOT", applets.rules.elements.NotElement.class);
        commands.put("COND", applets.rules.elements.CondElement.class);
        
    }
    
    private void graphRule(GraphElement se, WBTreeNode node, int pos)
    {
        String nodeName=node.getName();
        GraphElement ge = null;
        if("and".equals(nodeName.toLowerCase()))
        {
            ge = new AndElement();
            ((GraphView)jPanel1).addElement(ge);
            se.setChild(pos,ge);
            ge._init();
            for(int i=0;i<node.getNodesSize(); i++)
            {
                graphRule(ge,node.getNode(i),i);
            }
        }
        else if("or".equals(nodeName.toLowerCase()))
        {
            ge = new OrElement();
            ((GraphView)jPanel1).addElement(ge);
            se.setChild(pos,ge);
            ge._init();
            for(int i=0;i<node.getNodesSize(); i++)
            {
                graphRule(ge,node.getNode(i),i);
            }
            
        }
        else if("not".equals(nodeName.toLowerCase()))
        {
            ge = new NotElement();
            ((GraphView)jPanel1).addElement(ge);
            ge.setParent(se);
            se.setChild(pos,ge);
            ge._init();
            for(int i=0;i<node.getNodesSize(); i++)
            {
                graphRule(ge,node.getNode(i),i);
            }
        }
        else
        {
            CondElement ce = new CondElement();
            ce.set_attribute(nodeName);
            ce.set_operator(node.getAttribute("cond"));
            ce.set_value(node.getFirstNode().getText());
            
            //ce.setToolTipText(ce.get_attribute()+" "+ce.get_operator()+" "+ce.get_value());
            ((GraphView)jPanel1).addElement(ce);
            ce._init();
            ce.getCondExpression(xmlAttr); 
            se.setChild(pos, ce);
        }
    }
    
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Elements = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new GraphView();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jScrollPane1.setAutoscrolls(true);

        jPanel1.setBackground(java.awt.Color.white);
        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setBackground(new java.awt.Color(225, 235, 251));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("applets/rules/RuleApplet",locale); // NOI18N
        jButton1.setText(bundle.getString("Save")); // NOI18N
        jButton1.setToolTipText(bundle.getString("Save")); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(60, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(50, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(50, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        Elements.add(jToggleButton1);
        jToggleButton1.setToolTipText(bundle.getString("Pointer")); // NOI18N
        jToggleButton1.setActionCommand("POINT");
        jToggleButton1.setLabel(bundle.getString("Point")); // NOI18N
        jToggleButton1.setMaximumSize(new java.awt.Dimension(50, 25));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(50, 25));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(50, 25));
        jToolBar1.add(jToggleButton1);

        Elements.add(jToggleButton2);
        jToggleButton2.setText(bundle.getString("Cond")); // NOI18N
        jToggleButton2.setToolTipText(bundle.getString("Condition")); // NOI18N
        jToggleButton2.setActionCommand("COND");
        jToggleButton2.setMaximumSize(new java.awt.Dimension(50, 25));
        jToggleButton2.setMinimumSize(new java.awt.Dimension(50, 25));
        jToggleButton2.setPreferredSize(new java.awt.Dimension(50, 25));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton2);

        Elements.add(jToggleButton3);
        jToggleButton3.setText(bundle.getString("And")); // NOI18N
        jToggleButton3.setToolTipText(bundle.getString("And")); // NOI18N
        jToggleButton3.setActionCommand("AND");
        jToggleButton3.setMaximumSize(new java.awt.Dimension(50, 25));
        jToggleButton3.setMinimumSize(new java.awt.Dimension(50, 25));
        jToggleButton3.setPreferredSize(new java.awt.Dimension(50, 25));
        jToolBar1.add(jToggleButton3);

        Elements.add(jToggleButton4);
        jToggleButton4.setText(bundle.getString("Or")); // NOI18N
        jToggleButton4.setToolTipText(bundle.getString("Or")); // NOI18N
        jToggleButton4.setActionCommand("OR");
        jToggleButton4.setMaximumSize(new java.awt.Dimension(50, 25));
        jToggleButton4.setMinimumSize(new java.awt.Dimension(50, 25));
        jToggleButton4.setPreferredSize(new java.awt.Dimension(50, 25));
        jToolBar1.add(jToggleButton4);

        Elements.add(jToggleButton5);
        jToggleButton5.setText(bundle.getString("Not")); // NOI18N
        jToggleButton5.setToolTipText(bundle.getString("Negation")); // NOI18N
        jToggleButton5.setActionCommand("NOT");
        jToggleButton5.setMaximumSize(new java.awt.Dimension(50, 25));
        jToggleButton5.setMinimumSize(new java.awt.Dimension(50, 25));
        jToggleButton5.setPreferredSize(new java.awt.Dimension(50, 25));
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton5);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        StringBuffer strXML = new StringBuffer("");  //<?xml version=\"1.0\" encoding=\"UTF-8\"?>
        try
        {
            StartElement stEle = (StartElement)((GraphView)jPanel1).getStartElement();
            error=false;
            strXML.append("<rule>");
            addNode(stEle, strXML);
            strXML.append("</rule>");
            if(!error)
            {
                setXmlRule(strXML.toString());
                String comando="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>updateRule."+getTm()+"."+getId()+"</cmd>"+getXmlRule()+"</req>";
                xmlRule = conn.getData(comando);
                JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("applets/rules/RuleApplet",locale).getString("Save_Rule_succesfully."),java.util.ResourceBundle.getBundle("applets/rules/RuleApplet",locale).getString("Save_message"),JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("applets/rules/RuleApplet",locale).getString("ERROR._Probably_forgot_to_add_one_or_more_conditions."), java.util.ResourceBundle.getBundle("applets/rules/RuleApplet",locale).getString("Invalid_Rule"), JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void addNode( GraphElement ge, StringBuffer strXML)
    {
        Iterator ite = ge.getChilds();
        while(ite.hasNext())
        {
            GraphElement obj = (GraphElement)ite.next();
            if(obj instanceof AndElement)
            {
                if(getNumChilds(obj)<2)
                {
                    error=true;
                    return;
                }
                strXML.append("<and>");
                addNode((AndElement)obj,  strXML);
                strXML.append("</and>");
            }
            else if(obj instanceof OrElement)
            {
                if(getNumChilds(obj)<2)
                {
                    error=true;
                    return;
                }
                strXML.append("<or>");
                addNode((OrElement)obj,  strXML);
                strXML.append("</or>");
            }
            else if(obj instanceof NotElement)
            {
                if(getNumChilds(obj)<1)
                {
                    error=true;
                    return;
                }
                strXML.append("<not>");
                addNode((NotElement)obj,  strXML);
                strXML.append("</not>");
            }
            else if(obj instanceof CondElement)
            {
                CondElement condEle = (CondElement) obj;
                strXML.append("<"+condEle.get_attribute()+" cond=\""+condEle.get_operator()+"\">"+condEle.get_value()+"</"+condEle.get_attribute()+">");
            }
        }
        
    }
    
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton2ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    
    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton5ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton5ActionPerformed
    
    public String getActualCommand()
    {
        if(Elements.getSelection()!=null)
        {
            return Elements.getSelection().getActionCommand();
        }
        return null;
    }
    
    public void setActualCommand(String actionCommand)
    {
        Enumeration en=Elements.getElements();
        while(en.hasMoreElements())
        {
            JToggleButton b=(JToggleButton)en.nextElement();
            if(b.getActionCommand().equals(actionCommand))
            {
                b.setSelected(true);
                break;
            }
        }
    }
    
    public String getPointerCommand()
    {
        return CMD_POINT;
    }
    
    public Class getCommandElement(String actionCommand)
    {
        return (Class)commands.get(actionCommand);
    }
    
    /**
     * Getter for property conn.
     * @return Value of property conn.
     */
    public applets.commons.WBConnection getWBConnection()
    {
        return conn;
    }
    
    /**
     * Getter for property tm.
     * @return Value of property tm.
     */
    public java.lang.String getTm()
    {
        return tm;
    }
    
    /**
     * Setter for property tm.
     * @param tm New value of property tm.
     */
    public void setTm(java.lang.String tm)
    {
        this.tm = tm;
    }
    
    /**
     * Getter for property id.
     * @return Value of property id.
     */
    public java.lang.String getId()
    {
        return id;
    }
    
    /**
     * Getter for property act.
     * @return Value of property act.
     */
    public java.lang.String getAct()
    {
        return act;
    }
    
    /**
     * Getter for property modeView.
     * @return Value of property modeView.
     */
    public int getModeView()
    {
        return modeView;
    }
    
    /**
     * Setter for property modeView.
     * @param modeView New value of property modeView.
     */
    public void setModeView(int modeView)
    {
        this.modeView = modeView;
    }
    
    /**
     * Getter for property xmlAttr.
     * @return Value of property xmlAttr.
     */
    public java.lang.String getXmlAttr()
    {
        return xmlAttr;
    }
    
    /**
     * Getter for property xmlRule.
     * @return Value of property xmlRule.
     */
    public java.lang.String getXmlRule()
    {
        return xmlRule;
    }
    
    /**
     * Setter for property xmlRule.
     * @param xmlRule New value of property xmlRule.
     */
    public void setXmlRule(java.lang.String xmlRule)
    {
        this.xmlRule = xmlRule;
    }
    
    private int getNumChilds(GraphElement ge)
    {
        Iterator iteObj = ge.getChilds();
        int i=0;
        while(iteObj.hasNext())
        {
            Object tmpObj= iteObj.next();
            i++;
        }
        return i;
    }
    
    /**
     * Getter for property locale.
     * @return Value of property locale.
     */
    public java.util.Locale getLocale()
    {
        return locale;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Elements;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
