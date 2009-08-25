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
 * WBTopicMap.java
 *
 * Created on 8 de agosto de 2002, 18:07
 */

package applets.mapsadm;

import java.util.*;

import applets.commons.*;

/**
 *
 * @author  Administrador
 * @version 
 */
public class WBTopic {

    private WBTreeNode node;
    private String id;
    private String name=null;
    private boolean havechild=false;
    private int active=0;
    private int accesslevel=0;
    private boolean cheched=true;
    private WBTopic parent=null;
    private WBTopicMap topicMap=null;
    private boolean virtual=false;
    private String link=null;
    private Object treeNode=null;
    
    /** Creates new WBTopicMap */
    public WBTopic(WBTopicMap topicMap, WBTreeNode node) {
        this.topicMap=topicMap;
        this.node=node;
        init();
    }
    
    private void init()
    {
        for(int x=0;x<node.getNodesSize();x++)
        {
            String name=node.getNode(x).getName();
            //System.out.println("Tag:"+name);
            if(name.equals("id"))
            {
                id=node.getNode(x).getFirstNode().getText();
            }
            else if(name.equals("name"))
            {
                //System.out.println("Value:"+node.getNode(x).getAttribute("value"));
                String scope=node.getNode(x).getAttribute("scope");
                if(this.name==null)
                {   
                    if(scope!=null && scope.equals(topicMap.getLang()))
                        this.name=node.getNode(x).getAttribute("value");
                }
            }
            else if(name.equals("child"))
            {
                havechild=true;
            }
            else if(name.equals("active"))
            {
                active=Integer.parseInt(node.getNode(x).getFirstNode().getText());
            }
            else if(name.equals("havechild"))
            {
                cheched=false;
                String hvchild=node.getNode(x).getFirstNode().getText();
                if(hvchild.equals("true"))havechild=true;
            }
            else if(name.equals("linked"))
            {
                link=node.getNode(x).getFirstNode().getText();
                virtual=true;
                havechild=false;
            }
        }
        if(name==null)
        {
            Iterator it=node.getNodesbyName("name");
            if(it.hasNext())
            {
                WBTreeNode node=(WBTreeNode)it.next();
                name=node.getAttribute("value");
            }            
        }
    }
    
    public String toString()
    {
        String ret="Topic";
        if(name!=null)ret=name;
        /*
        Iterator it=getDataNode().getNodesbyName("name");
        if(it.hasNext())
        {
            WBTreeNode node=(WBTreeNode)it.next();
            ret=node.getAttribute("value");
        }
        */
        return ret;
    }
    
    public void refreshName()
    {
        String first=null;
        name=null;
        Iterator it=getDataNode().getNodesbyName("name");
        if(it.hasNext())
        {
            WBTreeNode node=(WBTreeNode)it.next();
            String scope=node.getAttribute("scope");
            if(this.name==null)
            {   
                if(scope!=null && scope.equals(topicMap.getLang()))
                    this.name=node.getAttribute("value");
            }
            if(first==null)first=node.getAttribute("value");
        }
        if(name==null)
        {
            name=first;
        }
    }

    /** Getter for property name.
     * @return Value of property name.
     */
    public java.lang.String getName() {
        return name;
    }
    
    /** Getter for property id.
     * @return Value of property id.
     */
    public java.lang.String getId() {
        return id;
    }
    
    /** Getter for property havechild.
     * @return Value of property havechild.
     */
    public boolean haveChild() {
        return havechild;
    }
    
    public Enumeration getChild()
    {
        Vector ret=new Vector();
        for(int x=0;x<node.getNodesSize();x++)
        {
            String name=node.getNode(x).getName();
            if(name.equals("child"))
            {
                WBTreeNode childnode=node.getNode(x);
                for(int y=0;y<childnode.getNodesSize();y++)
                {
                    ret.add(childnode.getNode(y));
                }
            }
        }
        return ret.elements();
    }
    
    /** Getter for property cheched.
     * @return Value of property cheched.
     */
    public boolean isCheched() {
        return cheched;
    }
    
    /** Setter for property cheched.
     * @param cheched New value of property cheched.
     */
    public void setCheched(boolean cheched) {
        this.cheched = cheched;
    }
    
    /** Getter for property node.
     * @return Value of property node.
     */
    public WBTreeNode getDataNode() {
        return node;
    }
    
    /** Getter for property changed.
     * @return Value of property changed.
     */
    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        if(virtual)
        {
           havechild=false; 
        }
        this.virtual=virtual;
    }
    
    /** Getter for property active.
     * @return Value of property active.
     */
    public int getActive() {
        return active;
    }
    
    /** Setter for property active.
     * @param active New value of property active.
     */
    public void setActive(int active) {
        this.active = active;
    }
    
    /** Getter for property level.
     * @return Value of property level.
     */
    public int getAccessLevel() {
        if(virtual)return 0;
        return accesslevel;
    }
    
    /** Setter for property level.
     * @param level New value of property level.
     */
    public void setAccessLevel(int level) {
        this.accesslevel = level;
    }
    
    /** Getter for property parent.
     * @return Value of property parent.
     */
    public WBTopic getParent() {
        return parent;
    }
    
    /** Setter for property parent.
     * @param parent New value of property parent.
     */
    public void setParent(WBTopic parent) {
        this.parent = parent;
    }
    
    /** Getter for property topicMap.
     * @return Value of property topicMap.
     */
    public WBTopicMap getTopicMap()
    {
        return topicMap;
    }
    
    /** Setter for property topicMap.
     * @param topicMap New value of property topicMap.
     */
    public void setTopicMap(WBTopicMap topicMap)
    {
        this.topicMap = topicMap;
    }
    
    /** Getter for property link.
     * @return Value of property link.
     */
    public java.lang.String getLink()
    {
        return link;
    }
    
    /** Setter for property link.
     * @param link New value of property link.
     */
    public void setLink(java.lang.String link)
    {
        this.link = link;
    }
    
    /** Getter for property treeNode.
     * @return Value of property treeNode.
     *
     */
    public java.lang.Object getTreeNode()
    {
        return treeNode;
    }
    
    /** Setter for property treeNode.
     * @param treeNode New value of property treeNode.
     *
     */
    public void setTreeNode(java.lang.Object treeNode)
    {
        this.treeNode = treeNode;
    }
    
}
