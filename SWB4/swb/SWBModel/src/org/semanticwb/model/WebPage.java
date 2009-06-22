package org.semanticwb.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.base.*;
import org.semanticwb.platform.SemanticObject;

public class WebPage extends WebPageBase 
{
    private static Logger log=SWBUtils.getLogger(WebPage.class);

    private String siteid=null;
    private String realurl=null;

    private long views=-1;
    private long timer;                     //valores de sincronizacion de views, hits
    private static long time;                      //tiempo en milisegundos por cada actualizacion
    private boolean viewed = false;

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

    public WebPage(SemanticObject base)
    {
        super(base);
        timer = System.currentTimeMillis();
    }
    
    public String getWebSiteId()
    {
        if(siteid==null)
        {
            siteid=getWebSite().getId();
        }
        return siteid;
    }

    /**  Regresa el Url de la pagina
     *  Ejemplo: /wb2/jei/home
     * @return String
     */
    public String getRealUrl()
    {
        if(realurl==null)
        {
            realurl=SWBPlatform.getContextPath() + "/" + SWBPlatform.getEnv("swb/distributor","swb") + "/" + getWebSiteId() + "/" + getId();
        }
        return realurl;
    }    
    
    /**  
     * Regresa el Url de la pagina
     * Ejemplo: /swb/jei/home
     * @return String
     */
    public String getUrl()
    {
        String url=getWebPageURL();
        if(url!=null)
        {
            if(getWebPageURLType()==2)  //Friendly
            {
                url=SWBPlatform.getContextPath()+url;
            }else if(getWebPageURLType()==1) //Redirect
            {
                if(url.startsWith("//"))
                {
                    url=url.substring(1);
                }else
                {
                    url=SWBPlatform.getContextPath()+url;
                }
//                Iterator it=paths.keySet().iterator();
//                while(it.hasNext())
//                {
//                    String key=(String)it.next();
//                    int i=url.indexOf(key);
//                    if(i>=0)
//                    {
//                        url=url.substring(0,i)+paths.get(key)+url.substring(i+key.length());
//                    }
//                }
            }
            return url;
        }
        return getRealUrl();
    }
    
    /** Regresa una representacion en html de la ruta de navegacion de la pagina.
     * @return String en formato html
     */
    public String getPath()
    {
        return getPath(new HashMap());
    }

    /** Obtiene la ruta de navegacion de la seccion
     * parametros:
     *      -   separator: caracter que se utilizara como separador.
     *      -   cssclass: nombre de la clase definida en el archivo CSS para utilizar en las ligas de la ruta.
     *      -   selectcolor: color de la seccion seleccionada.
     *      -   links: true/false, si tendra links en la ruta.
     *      -   language: lenguaje en el que se quiere presentar la ruta.
     *      -   home: Identificador de la sección home (si se quiere definir un home
     *          diferente al de defecto).
     *      -   target: Definicion del frame destino.
     *          diferente al de defecto).
     *      -   hiddentopics: identificadores de topicos seperados por comas que se quiere que se despliegen en la ruta.
     * @param args HashMap con los parametros del template
     * @return String de la ruta.
     */
    public String getPath(HashMap args)
    {
        //AFUtils.log("entra a nuevo topic getPath george...",true);
        StringBuffer ret = new StringBuffer();
        String separator = (String) args.get("separator");
        String cssclass = (String) args.get("cssclass");
        String tpacssclass = (String) args.get("tpacssclass");
        String selectcolor = (String) args.get("selectcolor");
        String links = (String) args.get("links");
        String language = (String) args.get("language");
        String home = (String) args.get("home");
        String active = (String) args.get("active");
        String target = (String) args.get("target");
        String hiddentopics=(String)args.get("hiddentopics");

        if (separator == null) separator = "";
        if (cssclass == null) cssclass = ""; else cssclass = "class=\"" + cssclass + "\"";
        if (selectcolor == null) selectcolor = ""; else selectcolor = "color=\"" + selectcolor + "\"";
        if (links == null) links = "true";
        if(target==null)target="";
        else target="target=\""+target+"\"";

        //Hidden Topics
        ArrayList hd=null;
        if(hiddentopics!=null)
        {
            hd=new ArrayList();
            StringTokenizer st=new StringTokenizer(hiddentopics," ,|;&:");
            while(st.hasMoreTokens())
            {
                WebPage tp=getWebSite().getWebPage(st.nextToken());
                if(tp!=null)
                {
                    hd.add(tp);
                }
            }
        }

        WebPage tphome = null;
        if (home != null)
        {
            tphome = getWebSite().getWebPage(home);
            if (tphome == null) tphome = getWebSite().getHomePage();
        } else
            tphome = getWebSite().getHomePage();

        if (tpacssclass!=null && tpacssclass.length() > 0) ret.append("<span " + tpacssclass + ">");
        else if (cssclass != null && cssclass.length() > 0) ret.append("<span " + cssclass + ">");
        if (selectcolor != null && selectcolor.length() > 0) ret.append("<font " + selectcolor + ">");
        ret.append(this.getDisplayName(language));
        if (selectcolor != null && selectcolor.length() > 0) ret.append("</font>");
        if ((tpacssclass!=null && tpacssclass.length() > 0) || (cssclass != null && cssclass.length() > 0)) ret.append("</span>");
            
        if (tphome != this)
        {
            ArrayList arr = new ArrayList();
            WebPage tp=this.getParent();
            while (tp!=null)
            {
                if(hd==null || (hd!=null && !hd.contains(tp)))
                {
                    if (links.equals("true") && tp.isActive())
                    {
                        ret.insert(0, separator);
                        ret.insert(0, "<a href=\"" + tp.getUrl() + "\" " + cssclass + " "+target+">" + tp.getDisplayName(language) + "</a>");
                    }
                    else if(active==null || (tp.isActive() && active!=null && !active.toLowerCase().trim().equals("true")))
                    {
                        ret.insert(0, separator);
                        ret.insert(0, tp.getDisplayName(language));
                    }
                }
                if (arr.contains(tp)) break;
                arr.add(tp);
                tp = tp.getParent();
                if (tphome == tp) break;
            }
        }
        return ret.toString();
    }    
    
    public boolean isVisible()
    {
        return isValid() && !isHidden();
    }
    
    /**
     * Regresa el Url de la pagina
     * Ejemplo: /swb/jei/home
     * @return String
     */
    public String getUrl(WebPage virtualtopic)
    {
        if(virtualtopic==null)return getUrl();
        String ret=getRealUrl();
        ret+="/"+"_vtp";                    //DistributorParams.URLP_VTOPIC;
        ret+="/" + virtualtopic.getWebSiteId() + "/" + virtualtopic.getId();
        return ret;
    }    
    
    /** Regresa el nivel de profundidad del topico con respecto a la seccion home.
     * @return int, nivel de profundidad.
     */
    public int getLevel()
    {
        int ret = 0;
        WebPage home=getWebSite().getHomePage();
        if (!home.equals(this))
        {
            ArrayList arr = new ArrayList();
            WebPage tp = this.getParent();
            while (tp!=null)
            {
                ret++;
                if (home.equals(tp)) break;
                if (arr.contains(tp)) break;
                arr.add(tp);
                tp = tp.getParent();
            }
        }
        return ret;
    }    
    
    /** indica si el topico es hijo de otro topico.
     * @param topic Topic
     * @return boolean
     */
    public boolean isChildof(WebPage page)
    {
        ArrayList<WebPage> arr = new ArrayList();
        WebPage tp = this.getParent();
        while (tp!=null)
        {
            if (tp.equals(page)) return true;
            if (arr.contains(tp)) return false;
            arr.add(tp);
            tp=tp.getParent();
        }
        return false;
    }

    /** indica si el topico es padre de otro topico.
     * @param topic Topci
     * @return bollean
     */
    public boolean isParentof(WebPage page)
    {
        return page.isChildof(this);
    }

    /**
     * Indica si la pagina tienen alguna regla, rol o grupo de usuarios asignado o heredado
     * @return
     */
    public boolean isFiltered()
    {
        boolean ret=false;
        ret=listInheritRoleRefs().hasNext();
        if(!ret)ret=listInheritUserGroupRefs().hasNext();
        if(!ret)ret=listInheritRuleRefs().hasNext();
        return ret;
    }
    
    /** Regresa el nombre por defecto.
     * @return String
     */
    public String getDisplayName()
    {
        return getDisplayName((String)null);
    }    
    
    /** Regresa el nombre por defecto, en base a un idioma.
     * @param String Idioma
     * @return String
     */
    public String getDisplayName(String lang)
    {
        return getSemanticObject().getLocaleProperty(Descriptiveable.swb_title, lang);
    }

    /** Regresa el nombre por defecto, en base a un idioma que recibe como parametro
     * con identificador "<B>language</B>".
     *
     * Ejemplo:
     *    HashMap arg=new HashMap();
     *    args.pur("language","es");
     *    String name=topic.getDisplayName(args);
     *
     * Este metodo normalmente se utiliza en templates.
     * parametros:
     *      -   languege: idioma de despliege (ejemplo es, en, fr).
     * @return String
     * @param args HashMap, con paraetros del template
     * ejemplo:
     *    language=es
     */
    public String getDisplayName(HashMap args)
    {
        String language = (String) args.get("language");
        return getTitle(language);
    }    
    
    /**
     * Lista templates activos y no borrados, si no existen en la pagina regresa las del padre
     * @return
     *
    public Iterator<TemplateRef> listConfigTemplateRefs()
    {
        boolean inherit=true;
        ArrayList<TemplateRef> ret=new ArrayList();
        Iterator<TemplateRef> it=listTemplateRefs();
        while(it.hasNext())
        {
            TemplateRef ref=it.next();
            if(ref.isActive())
            {
                ret.add(ref);
            }
        }
        if(inherit && ret.size()==0)
        {
            WebPage parent=getParent();
            if(parent!=null)
            {
                return parent.listConfigTemplateRefs();
            }
        }
        return ret.iterator();
    }
    */

    public boolean isOnSchedule()
    {
        boolean ret=true;
        Iterator<Calendar> it=((Calendarable)this).listCalendars();
        while(it.hasNext())
        {
            Calendar cal=it.next();
            if(cal.isActive() && !cal.isOnSchedule())
            {
                ret=false;
                break;
            }
        }
        return ret;
    }
    
    public Iterator<WebPage> listVisibleChilds(String sortLang)
    {
        TreeSet set= new TreeSet(new SWBComparator(sortLang));
        Iterator<WebPage> it = listChilds();
        while (it.hasNext())
        {
            WebPage tp=it.next();
            if(tp.isVisible())set.add(tp);
        }
        return set.iterator();
    }
    
    public Iterator<WebPage> listChilds(String sortLang, Boolean active, Boolean deleted, Boolean hidden, Boolean onSchedule)
    {
        TreeSet set= new TreeSet(new SWBComparator(sortLang));
        //set.addAll(getChild());
        Iterator<WebPage> it = listChilds();
        while (it.hasNext())
        {
            WebPage tp=it.next();
            if (active!=null && tp.isActive() != active) continue;
            if (deleted!=null && tp.isDeleted() != deleted) continue;
            if (hidden!=null && tp.isHidden() != hidden) continue;
            if (onSchedule!=null && tp.isOnSchedule() == onSchedule) continue;
            set.add(tp);
        }
        return set.iterator();        
    }
    
//    public void addHit(HttpServletRequest request, User user)
//    {
//        //TODO:
//    }
    
    @Override
    public long getDiskUsage()
    {
        long ret=0;
        Iterator<Resource> it=listResources();
        while(it.hasNext())
        {
            Resource res=it.next();
            String work=SWBPlatform.getWorkPath()+res.getWorkPath();
            ret+=SWBUtils.IO.getFileSize(work);
        }
        return ret/1000;
    }

    @Override
    public long getViews()
    {
        if(views==-1)views=super.getViews();
        return views;
    }

    public boolean incViews()
    {
        viewed = true;
        if(views==-1)views=getViews();
        views+=1;
        long t = System.currentTimeMillis() - timer;
        if (t > time || t < -time)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public void setViews(long views)
    {
        super.setViews(views);
        this.views=views;
    }

    public void updateViews()
    {
        if(viewed)
        {
            timer = System.currentTimeMillis();
            setViews(views);
            viewed = false;
        }
    }
    
}
