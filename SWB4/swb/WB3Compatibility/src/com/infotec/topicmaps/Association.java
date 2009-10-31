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
 * Association.java
 *
 * Created on 22 de abril de 2002, 15:54
 */

package com.infotec.topicmaps;

import com.infotec.topicmaps.bean.*;
import com.infotec.topicmaps.util.*;

import java.util.*;

import com.infotec.topicmaps.db.*;
import org.xml.sax.*;
import org.apache.xerces.parsers.*;

import java.io.*;

/**
 * Objeto <B>Association</B> que es parte de la implementacion del estandar XTM de
 * TopicMaps.
 * <BR>
 *
 * An <B>association</B> is a relationship between one or more topics, each of which plays a {@link role} as a {@link member} of that association.
 * The roles a topic plays in associations are among the characteristics that can be assigned to it and are therefore governed by {@link scope}.
 * Each individual association is an instance of a single class of association (also known as an association type) that may or may not be indicated explicitly.
 * The default association type is defined by the �association� published subject.
 * There is no directionality inherent in an association.
 * (Associations describe relationships: If A is related to B, then B must also be related to A. The issue is rather, what is the type of the relationship, and what roles are played by its members.
 * The question of how to label a relationship is one of naming, not direction.)
 * @author Javier Solis Gonzalez
 * @version 1.1
 */
public class Association
{

    protected String m_id;
    protected InstanceOf m_instanceof;                  //InstanceOf
    protected Scope m_scope;
    protected ArrayList m_members;

    protected RecAssociation dbdata = null;  //objeto de base de datos, si es nulo, no se sincroniza con base de datos
    protected boolean syncronized = false;

    protected TopicMap m_parent;

    /** Creates new Association */
    public Association()
    {
        m_id = TopicMgr.getInstance().getNewId();
        m_members = new ArrayList();
        dbdata = new RecAssociation(m_id);
    }
    
    //regresa otro objeto con la misma informacion que este
    public Association getCopy()
    {
        Association ass=new Association(m_parent);
        ass.m_id=m_id;
        if(m_instanceof!=null)ass.m_instanceof=m_instanceof.getCopy();
        if(m_scope!=null)ass.m_scope=m_scope.getCopy();
        Iterator it=m_members.iterator();
        while(it.hasNext())
        {
            Member mem=(Member)it.next();
            ass.m_members.add(mem.getCopy());
        }
        ass.dbdata=dbdata;
        return ass;
    }

    /**
     * @param parent  */
    public Association(TopicMap parent)
    {
        this();
        m_parent = parent;
        dbdata.setIdtm(parent.getId());
    }

    /**
     * @param rec
     * @throws UnsupportedEncodingException
     * @throws SAXException
     * @throws IOException
     * @return  */
    public static Association createAssociation(RecAssociation rec) throws java.io.UnsupportedEncodingException, org.xml.sax.SAXException, java.io.IOException
    {
        XTMParser reader = new XTMParser();
        SAXParser parser = new SAXParser();
        parser.setContentHandler(reader);
        //System.out.println("xml de la occurrencia:"+rec.getXml());
        TopicMap tm = TopicMgr.getInstance().getTopicMap(rec.getIdtm());
        //System.out.println("Topic"+tp.getDisplayName());
        reader.setTopicMap(tm);
        reader.setStartFrom(tm);
        parser.parse(new InputSource(new InputStreamReader(new java.io.ByteArrayInputStream(rec.getXml().getBytes()), TopicMgr.getInstance().getEncode())));
        Association ass = reader.getAssociation();
        ass.setDbdata(rec);
        ass.setDBSyncronized(true);
        return ass;
    }


    /** Getter for property m_id.
     * @return Value of property m_id.
     */
    public String getId()
    {
        return m_id;
    }

    /** Setter for property m_id.
     * @param id New value of property m_id.
     */
    public void setId(String id)
    {
        this.m_id = id;
        dbdata.setId(id);
    }

    /** Getter for property m_instanceof.
     * @return Value of property m_instanceof.
     */
    public com.infotec.topicmaps.InstanceOf getInstanceOf()
    {
        return m_instanceof;
    }

    /** Setter for property m_instanceof.
     * @param instanceOf New value of property m_instanceof.
     */
    public void setInstanceOf(com.infotec.topicmaps.InstanceOf instanceOf)
    {
        this.m_instanceof = instanceOf;
    }

    /** Getter for property m_scope.
     * @return Value of property m_scope.
     */
    public Scope getScope()
    {
        return m_scope;
    }

    /** Setter for property m_scope.
     * @param scope New value of property m_scope.
     */
    public void setScope(Scope scope)
    {
        this.m_scope = scope;
    }

    /** Getter for property m_members.
     * @return Value of property m_members.
     */
    public ArrayList getMembers()
    {
        return m_members;
    }

    /** Setter for property m_members.
     * @param members New value of property m_members.
     */
    public void setMembers(ArrayList members)
    {
        this.m_members = members;
    }

    /**
     * @return  */
    public Topic getType()
    {
        return m_instanceof.getTopicRef();
    }

    /** Getter for property dbdata.
     * @return Value of property dbdata.
     */
    public RecAssociation getDbdata()
    {
        return dbdata;
    }

    /** Setter for property dbdata.
     * @param dbdata New value of property dbdata.
     */
    public void setDbdata(RecAssociation dbdata)
    {
        this.dbdata = dbdata;
    }

    /** Getter for property syncronized.
     * @return Value of property syncronized.
     */
    public boolean isDBSyncronized()
    {
        return syncronized;
    }

    /** Setter for property syncronized.
     * @param syncronized New value of property syncronized.
     */
    public void setDBSyncronized(boolean syncronized)
    {
        this.syncronized = syncronized;
    }
    
    public boolean isActive()
    {
        if(getType()==null || (getType()!=null && getType().isDeleted()))return false;
        
        Iterator itaux = getMembers().iterator();
        while (itaux.hasNext())
        {
            Member mem = (Member)itaux.next();
            if(mem.getRoleSpec()!=null && mem.getRoleSpec().getTopicRef()!=null)
            {
                if(mem.getRoleSpec().getTopicRef().isDeleted())return false;
            }else
            {
                return false;
            }
            Iterator itpla = mem.getTopicRefs().values().iterator();
            while (itpla.hasNext())
            {
                Topic tpla = (Topic) itpla.next();
                if(!tpla.isActive())return false;
            }
        }        
        return true;
    }

}
