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
 * ShowFlow.java
 *
 * Created on 1 de junio de 2005, 11:47 AM
 */

package applets.workflowadmin;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;

import applets.commons.*;
/**
 *
 * @author  Victor Lorenzana
 */
public class ShowFlow extends javax.swing.JApplet {
    
    private final String PRM_JSESS="jsess";
    private final String PRM_CGIPATH="cgipath";
    private final String PRM_TOPICMAP="tm";

    private static String cgiPath="/gtw.jsp";
    private static String jsess="";
    public static String tm="";
    private JActivityFlowPanel jPanelDesign=null;
    private static URL url=null;
    public Workflow workflow;
    String version=null;
    Locale locale;
    
    /** Initializes the applet ShowFlow */
    public void init() {
        initComponents();
        locale=Locale.getDefault();
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
        String activityName=this.getParameter("activityName");
        if(activityName==null || activityName.equals(""))
        {
            return;
        }
        version=this.getParameter("version");
        if(activityName==null || activityName.equals(""))
        {
            version=null;
        }
        workflow=new Workflow(locale);        
        jsess=this.getParameter(PRM_JSESS);
        cgiPath=this.getParameter(PRM_CGIPATH);
        tm=this.getParameter(PRM_TOPICMAP);
        String id=this.getParameter("idworkflow");
        try {
            url=new URL(getCodeBase().getProtocol(),getCodeBase().getHost(),getCodeBase().getPort(),cgiPath);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        if(id!=null && !id.equals(""))
        {            
            loadWorkflow(id);
            jPanelDesign=new JActivityFlowPanel(workflow.getActivitiesModel(),this.jTableActivitiesG,locale,activityName,false);
            this.jScrollPaneDesign.setViewportView(this.jPanelDesign);                 
        }
        else
        {
            return;
        }
    }
    public void loadWorkflow(String id)
    {        
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>getWorkflow</cmd><id>"+ id +"</id><tm>" + tm + "</tm></req>";        
        if(version!=null)
        {
            xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>getWorkflow</cmd><id version=\""+ version +"\">"+ id +"</id><tm>" + tm + "</tm></req>";        
        }
        String respxml=this.getData(xml,this);                
        WBXMLParser parser=new WBXMLParser();
        WBTreeNode exml=parser.parse(respxml);
        if(exml.getFirstNode()!=null && exml.getFirstNode().getFirstNode()!=null)
        {            
            WBTreeNode wfnode=exml.getFirstNode().getFirstNode();                        
            if(wfnode.getName().equals("workflow"))
            {      
                this.workflow=new Workflow(wfnode,id,locale);                                                
            }
        }
    }
    public static String getData(String xml,Component cmp) {

        StringBuffer ret=new StringBuffer();
        try {

            URLConnection urlconn=url.openConnection();
            urlconn.setUseCaches(false);
            if(jsess!=null)urlconn.setRequestProperty("Cookie","JSESSIONID="+jsess);
            urlconn.setRequestProperty("Content-Type","application/xml");
            urlconn.setDoOutput(true);
            PrintWriter pout = new PrintWriter(urlconn.getOutputStream());
            pout.println(xml);
            pout.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                ret.append(inputLine);
                ret.append("\n");
            }
            in.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(cmp,e.getMessage(),"INFOTEC WebBuilder 3.0",JOptionPane.ERROR_MESSAGE);
            System.out.println(java.util.ResourceBundle.getBundle("applets/workflowadmin/EditWorkflow").getString("Error_to_open_service...")+e);
        }
        return ret.toString();
    }
    
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActivitiesG = new javax.swing.JTable();
        jScrollPaneDesign = new javax.swing.JScrollPane();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(10, 100));
        jTableActivitiesG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableActivitiesG);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jScrollPaneDesign, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneDesign;
    private javax.swing.JTable jTableActivitiesG;
    // End of variables declaration//GEN-END:variables
    
}
