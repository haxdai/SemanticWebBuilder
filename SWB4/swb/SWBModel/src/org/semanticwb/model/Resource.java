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
 
package org.semanticwb.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class Resource extends org.semanticwb.model.base.ResourceBase 
{
    private static Logger log = SWBUtils.getLogger(Resource.class);

    private String siteid=null;
    protected int randpriority;

    private Document m_dom=null;
    private Document m_filter=null;
    private NodeList m_filternode=null;

    private long hits=0;
    private long views=0;
    private long timer;                     //valores de sincronizacion de views, hits
    private static long time;               //tiempo en milisegundos por cada actualizacion
    private boolean viewed = false;

    private static Random rand=new Random();

    static
    {
        time = 600000L;
        try
        {
            time = 1000L * Long.parseLong((String) SWBPlatform.getEnv("swb/accessLogTime","600"));
        } catch (Exception e)
        {
            log.error("Error to read accessLogTime...",e);
        }
    }



    public Resource(SemanticObject base)
    {
        super(base);
        //System.out.println("Create Resource:"+base.getURI());
        //new Exception().printStackTrace();
    }

    public String getWebSiteId()
    {
        if(siteid==null)
        {
            siteid=getWebSite().getId();
        }
        return siteid;
    }

    public boolean isCached()
    {
        boolean ret=false;
        if(getResourceType().getResourceCache()>0)
        {
            ret=true;
        }
        return ret;
    }

    public void refreshRandPriority()
    {
        //TODO:
        //if (this.getCamp() == 1)
        //    randpriority = SWBPriorityCalculator.getInstance().calcPriority(0);
        //else if (this.getCamp() == 2)
        //    randpriority = WBUtils.getInstance().calcPriority(6);
        //else
            randpriority = calcPriority(getPriority());
    }

    private int calcPriority(int p)
    {
        if (p == 0)
            return 0;
        else if (p == 1)
            return 1;
        else if (p == 5)
            return 50;
        else if (p > 5)
            return 60;
        else {
            return rand.nextInt(10 * p) + 1;
        }
    }


    public void setRandPriority(int randpriority)
    {
        this.randpriority=randpriority;
    }

    /**
     * @return  */
    public int getRandPriority()
    {
        return randpriority;
    }

    public Document getDom() throws SWBException
    {
       if(m_dom==null)
       {
           if(swb_xml!=null)
           {
               m_dom=getSemanticObject().getDomProperty(swb_xml);
           }else
           {
               m_dom=SWBUtils.XML.getNewDocument();
           }
       }
       return m_dom;
    }


    /** Asigna un atributo al DOM del recurso.
     * Si no existe el atributo, lo crea y si existe lo modifica
     * @param name String nombre del atributo
     * @param value String valor del atributo
     */
    public void setAttribute(String name, String value)
    {
        try
        {
            Document dom=getDom();
            Element res = (Element) dom.getFirstChild();
            if(res==null){
                Element ele = dom.createElement("resource");
                dom.appendChild(ele);
            }
            SWBUtils.XML.setAttribute(dom, name, value);
        } catch (Exception e)
        {
            log.error("Error in setAttribute: " + name + " ->Resource " + getId(),e);
        }
    }

    /** Lee un atributo del DOM del Recurso
     * Si el atributo no esta declarado regresa el valor por defecto defvalue.
     */
    public String getAttribute(String name, String defvalue)
    {
        String ret = getAttribute(name);
        if (ret == null) ret = defvalue;
        return ret;
    }


    /** Lee un atributo del DOM del Recurso
     * Si el atributo no esta declarado regresa null.
     */
    public String getAttribute(String name)
    {
        String ret = null;
        try
        {
            Document dom=getDom();
            NodeList data = dom.getElementsByTagName(name);
            if (data.getLength() > 0)
            {
                Node txt = data.item(0).getFirstChild();
                if (txt != null) ret = txt.getNodeValue();
            }
        } catch (Exception e)
        {
            //log.error("Error in getAttribute: " + name + " ->Resource " + getId(), e);
        }
        return ret;
    }

    /** Lee un atributo del DOM del Recurso
     * Si el atributo no esta declarado regresa null.
     */
    public Iterator<String> getAttributeNames() {
        ArrayList attributeNames=new ArrayList();
        try {
            Document dom=getDom();
            Node root=dom.getFirstChild();

            NodeList data=root.getChildNodes();
            for(int x=0;x<data.getLength();x++) {
                attributeNames.add(data.item(x).getNodeName());
            }
        }catch (Exception e) {
        }
        return attributeNames.iterator();
    }


    /** Borra un atributo del DOM del Recurso
     */
    public void removeAttribute(String name)
    {
        try
        {
            Document dom=getDom();
            Node res = dom.getFirstChild();
            NodeList data = dom.getElementsByTagName(name);
            if (data.getLength() > 0)
            {
                res.removeChild(data.item(0));
            }
        } catch (Exception e)
        {
            log.error("Error in removeAttribute: " + name + " ->Resource " + getId(), e);
        }
    }

    /** Actualiza los atributos del DOM a base de datos. */
    public void updateAttributesToDB() throws SWBException
    {
        Document dom=getDom();
        if(dom!=null)
        {
            String xml = SWBUtils.XML.domToXml(dom);
            if (xml != null && !xml.equals(getXml()))
            {
                setXml(xml);
            }
        }
    }

    @Override
    public void setXml(String xml)
    {
        //Garantiza que se borren las propiedades
        getSemanticObject().getRDFResource().removeAll(swb_xml.getRDFProperty());
        super.setXml(xml);
        m_dom=null;
    }

    public void addHit(HttpServletRequest request, User user, WebPage page)
    {
        //TODO:
    }

    /**
     * @throws AFException
     * @return  */
    public String getData()
    {
        return getProperty("data");
    }

    /**
     * @param key
     */
    public String getData(String key)
    {
        return getProperty("data/"+key);
    }
    

    /**
     * @param data
     * @throws AFException  */
    public void setData(String data)
    {
        setProperty("data", data);
    }

    /**
     * @param data
     * @throws AFException  */
    public void setData(String key, String data)
    {
        setProperty("data/"+key, data);
    }

    /**
     * @param usr
     * @throws AFException
     * @return  */
    public String getData(User usr)
    {
        return getProperty("data/usr/"+usr.getUserRepository().getId()+"/"+usr.getId());
    }

    /**
     * @param usr
     * @param data
     * @throws AFException  */
    public void setData(User usr, String data)
    {
        setProperty("data/usr/"+usr.getUserRepository().getId()+"/"+usr.getId(),data);
    }

    /**
     * @param usr
     * @param topic
     * @throws AFException
     * @return  */
    public String getData(User usr, WebPage page)
    {
        return getProperty("data/usr/"+usr.getUserRepository().getId()+"/"+usr.getId()+"/wp/"+page.getWebSiteId()+"/"+page.getId());
    }

    /**
     * @param usr
     * @param topic
     * @param data
     * @throws AFException  */
    public void setData(User usr, WebPage page, String data)
    {
        setProperty("data/usr/"+usr.getUserRepository().getId()+"/"+usr.getId()+"/wp/"+page.getWebSiteId()+"/"+page.getId(),data);
    }

    /**
     * @param topic
     * @throws AFException
     * @return  */
    public String getData(WebPage page)
    {
        return getProperty("data/wp/"+page.getWebSiteId()+"/"+page.getId());
    }

    /**
     * @param topic
     * @param data
     * @throws AFException  */
    public void setData(WebPage page, String data)
    {
        setProperty("data/wp/"+page.getWebSiteId()+"/"+page.getId(),data);
    }

    /** Getter for property filterMap.
     * @return Value of property filterMap.
     */
    public org.w3c.dom.NodeList getFilterNode()
    {
        ResourceFilter pfilter=getResourceFilter();
        if(pfilter!=null)
        {
            Document aux=pfilter.getSemanticObject().getDomProperty(swb_xml);
            if(aux!=m_filter)
            {
                m_filter=aux;
                NodeList nl = aux.getElementsByTagName("topicmap");
                int n = nl.getLength();
                if (n > 0)
                {
                    m_filternode = nl;
                } else
                {
                    m_filternode = null;
                }
            }
        }else
        {
            m_filternode=null;
        }
        //System.out.println("getFilterNode:"+getURI()+" "+m_filternode);
        return m_filternode;
    }


    /**  org.semanticwb.model.Inheritable
     * @param topic
     * @return  */
    public boolean evalFilterMap(WebPage topic)
    {
        boolean ret = false;
        NodeList fi = getFilterNode();
        if (fi == null) return true;
        for (int x = 0; x < fi.getLength(); x++)
        {
            Element el = (Element) fi.item(x);
            //System.out.println("evalFilterMap:"+topic.getWebSiteId()+"="+el.getAttribute("id"));
            if (topic.getWebSiteId().equals(el.getAttribute("id")))
            {
                NodeList ti = el.getElementsByTagName("topic");
                for (int y = 0; y < ti.getLength(); y++)
                {
                    Element eltp = (Element) ti.item(y);
                    WebPage atopic = topic.getWebSite().getWebPage(eltp.getAttribute("id"));
                    if (atopic != null)
                    {
                        if (topic.equals(atopic))
                            ret = true;
                        else if (eltp.getAttribute("childs").equals("true"))
                        {
                            if (topic.isChildof(atopic)) ret = true;
                        }
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public long getHits()
    {
        if(hits==0)hits=super.getHits();
        return hits;
    }

    public boolean incHits()
    {
        viewed = true;
        if(hits==0)hits=getHits();
        hits+=1;
        long t = System.currentTimeMillis() - timer;
        if (t > time || t < -time)
        {
            //TODO: evalDate4Views();
            return true;
        }
        return false;
    }

    @Override
    public void setHits(long hits)
    {
        super.setHits(hits);
        this.hits=hits;
    }

    @Override
    public long getViews()
    {
        if(views==0)views=super.getViews();
        return views;
    }

    public boolean incViews()
    {
        //System.out.println("incViews:"+views);
        viewed = true;
        if(views==0)views=getViews();
        views+=1;
        long t = System.currentTimeMillis() - timer;
        if (t > time || t < -time)
        {
            //TODO: evalDate4Views();
            return true;
        }
        return false;
    }

    @Override
    public void setViews(long views)
    {
        //System.out.println("setViews:"+views);
        super.setViews(views);
        this.views=views;
    }

    public void updateViews()
    {
        //System.out.println("updateViews:"+views);
        if(viewed)
        {
            timer = System.currentTimeMillis();
            if(views>0)setViews(views);
            if(hits>0)setHits(hits);
            viewed = false;
        }
    }

}
