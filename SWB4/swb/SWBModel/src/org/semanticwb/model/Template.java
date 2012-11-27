/*
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
 */
package org.semanticwb.model;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPlatform;
import org.semanticwb.model.base.*;
import org.semanticwb.platform.SemanticObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Template.
 */
public class Template extends TemplateBase 
{
    
    /** The siteid. */
    private String siteid=null;
    
//    private ArrayList parts;
    /** The objects. */
private HashMap objects = new HashMap();

//    private String actPath;
    
//    private HashMap header=null;


    //Para que se muestre funcionalidad de facebook como el boton, agregar las siguientes 2 líneas a los templates (Jorge)
    //<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    //<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
    /** The DEFAU l_ html. */
public static final String DEFAUL_HTML="<template method=\"setHeaders\" Content-Type=\"text/html\"  response=\"{response}\" />\n" +
                           "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                           "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                           "<head>\n" +
                            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n" +
                            "<title>\n" +
                            "   <TOPIC METHOD=\"getDisplayName\" LANGUAGE=\"{user@getLanguage}\"/>\n" +
                            "</title>\n" +

                            "\n<!--\n" +
                            "Nota: No olvides incluir estos scripts en tus plantillas hechas por fuera\n" +
                            "***************************************************************************\n" +
                            "***************************************************************************\n" +
                            "-->\n" +
                            "<link rel='stylesheet' type='text/css' media='all' href='{webpath}/swbadmin/js/dojo/dijit/themes/soria/soria.css' />\n"+
                            "<link rel='stylesheet' type='text/css' media='all' href='{webpath}/swbadmin/css/swb_portal.css' />\n"+
                            //"<style type=\"text/css\">\n" +
                            //"    @import \"<webpath/>/swbadmin/js/dojo/dijit/themes/nihilo/nihilo.css\";\n" +
                            //"    @import \"<webpath/>/swbadmin/js/dojo/dijit/themes/tundra/tundra.css\";\n" +
                            //"    @import \""+ctx+"/swbadmin/js/dojo/dijit/themes/soria/soria.css\";\n" +
                            //"    @import \""+ctx+"/swbadmin/css/swb_portal.css\";\n" +
                            //"</style>\n" +
                            "<script type=\"text/javascript\">\n" +
                            "    var djConfig = {\n" +
                            "        parseOnLoad: true,\n" +
                            "        isDebug: false\n" +
                            "    };\n" +
                            "</script>\n" +
                            "<script type=\"text/javascript\" src=\"{webpath}/swbadmin/js/dojo/dojo/dojo.js\"></script>\n" +
                            //"<script type=\"text/javascript\" src=\"{webpath}/swbadmin/js/swb_.js\"></script>\n" +
                            "<script type=\"text/javascript\" src=\"{webpath}/swbadmin/js/swb.js\"></script>\n" +
                            "<!--\n" +
                            "***************************************************************************\n" +
                            "***************************************************************************\n" +
                            "-->\n\n" +
                            "</head>\n " +
                            "<body>\n   " +
                            "<div>\n" +
                            "   <Content></Content>\n" +
                            "</div>\n " +
                            "</body>\n" +
                            "</html>";

    
    /**
     * Instantiates a new template.
     * 
     * @param base the base
     */
    public Template(SemanticObject base)
    {
        super(base);
        objects.put("template", this);
        objects.put("user", new User(null));
        objects.put("topic", new WebPage(null));
        objects.put("request", HttpServletRequest.class);
        objects.put("response", HttpServletResponse.class);
        objects.put("webpath", SWBPlatform.getContextPath());
//        objects.put("distpath", SWBPortal.getDistributorPath());
    }
    
    /**
     * Gets the web site id.
     * 
     * @return the web site id
     */
    public String getWebSiteId()
    {
        if(siteid==null)
        {
            siteid=getWebSite().getId();
        }
        return siteid;
    }    
    


//    public Object identifyObject(String val, HashMap objects)
//    {
//        try
//        {
//            if (val.startsWith("{") && val.endsWith("}"))
//            {
//                int sar = val.indexOf('@');
//                if (sar == -1)
//                {
//                    String sobj = val.substring(1, val.length() - 1).toLowerCase();
//                    return objects.get(sobj);
//                } else
//                {
//                    String sobj = val.substring(1, sar).toLowerCase();
//                    if(objects.get(sobj)==null)return null;
//                    String smto = val.substring(sar + 1, val.length() - 1);
//                    Method mto = objects.get(sobj).getClass().getMethod(smto, (Class[])null);
//                    return new WBMethod(mto, objects.get(sobj), null, this);
//                }
//            }
//        } catch (Exception e)
//        {
//            log.error(e);
//        }
//        return val;
//    }

//    public StringBuffer replaceObjectsValues(String value, StringBuffer auxparts, ArrayList parts, HashMap objects)
//    {
//        //ArrayList p = split(value, "\\{(.+?)[^\\}]@(.+?)\\}");
//        ArrayList p = AFUtils.regExpSplit(value, "\\{([^\\{]+?)\\}");
//        Iterator it = p.iterator();
//        while (it.hasNext())
//        {
//            String sp = (String) it.next();
//            Object obj = identifyObject(sp, objects);
//            if(obj==null)
//            {
//                auxparts.append(sp);
//            }else
//            {
//                if (obj instanceof String)
//                {
//                    auxparts.append((String) obj);
//                } else
//                {
//                    if (auxparts.length() > 0)
//                    {
//                        parts.add(auxparts.toString());
//                        parts.add(obj);
//                        auxparts = new StringBuffer();
//                    }
//                }
//            }
//        }
//        return auxparts;
//    }
//    
//    private RecResourceType getResourceType(String type)
//    {
//        //TODO: revisar objetos de otros sitios
//        //busca el tipo de recurso en el topicmap del template
//        RecResourceType rt=DBResourceType.getInstance().getResourceTypeByName(this.getTopicMapId(),type.toLowerCase());
//        //busca el tipo de recurso en el topicmap global
//        if(rt==null)rt=DBResourceType.getInstance().getResourceTypeByName(TopicMgr.TM_GLOBAL,type.toLowerCase());
//        return rt;
//    }
//    
//    /*
//     * Regresa ID (numero) del recurso como string y concatena 
//     * typemap en el caso de no coincidir con el topicmap de la plantilla
//     */
//    public String getResourceTypeId(String type)
//    {
//        RecResourceType rec=getResourceType(type);
//        int itype = rec.getId();
//        String typemap=rec.getTopicMapId();
//        
//        String stype=""+itype;
//        if(!getTopicMapId().equals(typemap))stype+="|"+typemap;
//        
//        return stype;
//    }
//    
//    /*
//     * Regresa ID (numero) del subtipo de recurso como string y concatena 
//     * subtypemap en el caso de no coincidir con el topicmap de la plantilla
//     */    
//    public String getSubTypeId(String type, String stype)
//    {
//        return getSubTypeId(getResourceType(type),stype);
//    }
//    
//    private String getSubTypeId(RecResourceType _type, String _stype)
//    {
//        if(_stype!=null)
//        {
//            RecResourceType rt=_type;
//
//            int type = rt.getId();
//            String typemap=rt.getTopicMapId();
//            //System.out.println("template:"+recTemplate.getId()+"-->"+name+":"+tag.getParam(name));
//
//            //todo: revisar objetos de otros sitios
//            //Busca el subtipo en el topicmap del template
//            Iterator it = DBCatalogs.getInstance().getSubTypes(this.getTopicMapId(),type,typemap);
//            while (it.hasNext())
//            {
//                RecSubType rec = (RecSubType) it.next();
//                if (rec.getTitle().toLowerCase().equals(_stype.toLowerCase()))
//                {
//                    return ""+rec.getId();
//                }
//            }
//
//            //Busca el subtipo en el topicmap global
//            it = DBCatalogs.getInstance().getSubTypes(TopicMgr.TM_GLOBAL,type,typemap);
//            while (it.hasNext())
//            {
//                RecSubType rec = (RecSubType) it.next();
//                if (rec.getTitle().toLowerCase().equals(_stype.toLowerCase()))
//                {
//                    return rec.getId()+"|"+rec.getTopicMapId();
//                }
//            }
//        }
//        return "-1";
//    }    
//
//    /**
//     * @param filename
//     * @return  */
//    public ArrayList parse(String filename)
//    {
//        ArrayList parts = new ArrayList();
//        try
//        {
//            //FileInputStream in= new FileInputStream(AFUtils.getInstance().getWorkPath()+"/templates/"+recTemplate.getId()+"/"+recTemplate.getActualversion()+"/"+filename);
//            HtmlStreamTokenizer tok = null;
//            if (filename.startsWith("/"))
//                tok = new HtmlStreamTokenizer(WBUtils.getInstance().getFileFromWorkPath(filename));
//            else
//                tok = new HtmlStreamTokenizer(WBUtils.getInstance().getFileFromWorkPath("/sites/"+recTemplate.getTopicMapId()+"/templates/" + recTemplate.getId() + "/" + recTemplate.getActualversion() + "/" + filename));
//            HtmlTag tag = new HtmlTag();
//            StringBuffer auxpart = new StringBuffer();
//            boolean textpart = false;
//            boolean objectpart = false;
//            boolean resourcepart = false;
//            boolean contentpart = false;
//            boolean scriptpart = false;
//            while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF)
//            {
//                //System.out.println("element:"+tok.getStringValue());
//                int ttype = tok.getTokenType();
//                if (ttype == HtmlStreamTokenizer.TT_TAG)
//                {
//                    tok.parseTag(tok.getStringValue(), tag);
//                    if (tag.getTagString().toLowerCase().equals("resource"))
//                    {
//                        if (textpart)
//                        {
//                            if (!resourcepart)
//                                parts.add(auxpart.toString());
//                            //System.out.print(auxpart.toString());
//                            auxpart = new StringBuffer();
//                            textpart = false;
//                        }
//                        ResourceMgr obj = ResourceMgr.getInstance();
//                        try
//                        {
//                            //System.out.println(tag.getTagString()+" type:"+tag.getTagType()+" endtag:"+tag.isEndTag()+" empty:"+tag.isEmpty()+" "+tag.getParamCount());
//                            if (!tag.isEndTag())
//                            {
//                                if (!tag.isEmpty()) resourcepart = true;
//
//                                HashMap params = new HashMap();
//                                Enumeration en = tag.getParamNames();
//                                while (en.hasMoreElements())
//                                {
//                                    String name = (String) en.nextElement();
//                                    if (name.toLowerCase().equals("stype"))
//                                    {
//                                        params.put(name.toLowerCase(), getSubTypeId(tag.getParam("type"),tag.getParam(name).toLowerCase()));
//                                    } else
//                                    {
//                                        params.put(name.toLowerCase(), tag.getParam(name));
//                                    }
//                                }
//                                String type=getResourceTypeId(tag.getParam("type"));
//                                Object args[] = {type, params};
//                                parts.add(new WBMethod(null, obj, args, this));
//                                //System.out.print(cls.getName()+":"+"getResources");
//                            } else
//                            {
//                                resourcepart = false;
//                            }
//                        } catch (Exception e)
//                        {
//                            AFUtils.log(com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_parse_resource") + " " + tag.getParam("class") + " ->Template:" + getTitle(), true);
//                        }
//                    } else if (tag.getTagString().toLowerCase().equals("wbobject"))
//                    {
//                        if (textpart)
//                        {
//                            if(!tag.isEndTag())parts.add(auxpart.toString());
//                            auxpart = new StringBuffer();
//                            textpart = false;
//                        }
//                        try
//                        {
//                            if (!tag.isEndTag())
//                            {
//                                RecResourceType rec=DBResourceType.getInstance().getResourceTypeByName(this.getTopicMapId(),tag.getParam("name").toLowerCase());
//                                if(rec==null && !this.getTopicMapId().equals(TopicMgr.TM_GLOBAL))
//                                {
//                                    rec=DBResourceType.getInstance().getResourceTypeByName(TopicMgr.TM_GLOBAL,tag.getParam("name").toLowerCase());
//                                }
//                                String objclass = rec.getObjclass();
//                                Class cls = getClass().forName(objclass);
//                                objects.put(tag.getParam("name").toLowerCase(), cls.newInstance());
//                            }
//                        } catch (Exception e)
//                        {
//                            AFUtils.log(com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_parse_notFound") + getTitle(), true);
//                        }
//                    } else if (objects.containsKey(tag.getTagString().toLowerCase()))
//                    {
//                        Object obj = objects.get(tag.getTagString().toLowerCase());
//                        if(obj instanceof String)
//                        {
//                            if (!textpart) textpart = true;
//                            auxpart.append(obj.toString());
//                        }else
//                        {
//                            if (textpart)
//                            {
//                                if (!objectpart)
//                                    parts.add(auxpart.toString());
//                                auxpart = new StringBuffer();
//                                textpart = false;
//                            }
//                            try
//                            {
//                                if (!tag.isEndTag())
//                                {
//                                    if (!tag.isEmpty()) objectpart = true;
//                                    Class cls = null;
//                                    if (obj instanceof Class)
//                                        cls = (Class) obj;
//                                    else
//                                        cls = obj.getClass();
//
//                                    HashMap params = new HashMap();
//                                    Enumeration en = tag.getParamNames();
//                                    boolean objArgs = false;
//                                    while (en.hasMoreElements())
//                                    {
//                                        String name = (String) en.nextElement();
//                                        String val = tag.getParam(name);
//                                        if (val.startsWith("{") && val.endsWith("}"))
//                                        {
//                                            objArgs = true;
//                                            int sar = val.indexOf('@');
//                                            if (sar == -1)
//                                            {
//                                                String sobj = val.substring(1, val.length() - 1).toLowerCase();
//                                                params.put(name.toLowerCase(), objects.get(sobj));
//                                            } else
//                                            {
//                                                String sobj = val.substring(1, sar).toLowerCase();
//                                                String smto = val.substring(sar + 1, val.length() - 1);
//                                                Method mto = objects.get(sobj).getClass().getMethod(smto, (Class[])null);
//                                                params.put(name.toLowerCase(), new WBMethod(mto, objects.get(sobj), null, this));
//                                            }
//                                        } else
//                                            params.put(name.toLowerCase(), val);
//                                    }
//                                    //System.out.println(cls.getName()+":"+tag.getParam("method"));
//                                    if (params.size() > 1)
//                                    {
//                                        Object arg[] = {params};
//                                        Class argumentTypes[] = {new HashMap().getClass()};
//                                        Method mto = cls.getMethod(tag.getParam("method"), argumentTypes);
//                                        WBMethod wbmto = new WBMethod(mto, obj, arg, this);
//                                        wbmto.setObjArgs(objArgs);
//                                        parts.add(wbmto);
//                                    } else
//                                    {
//                                        Method mto = cls.getMethod(tag.getParam("method"), (Class[])null);
//                                        parts.add(new WBMethod(mto, obj, null, this));
//                                    }
//                                } else
//                                {
//                                    objectpart = false;
//                                }
//                            } catch (Exception e)
//                            {
//                                AFUtils.log(com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_parse_notFoundMethod") + " " + tag.getParam("method") + " ->Template:" + getTitle(), true);
//                            }
//                        }
//                    } else if (tag.getTagString().toLowerCase().equals("content"))
//                    {
//                        if (textpart)
//                        {
//                            if (!contentpart)
//                                parts.add(auxpart.toString());
//                            //System.out.print(auxpart.toString());
//                            auxpart = new StringBuffer();
//                            textpart = false;
//                        }
//                        ResourceMgr obj = ResourceMgr.getInstance();
//                        try
//                        {
//                            if (!tag.isEndTag())
//                            {
//                                if (!tag.isEmpty()) contentpart = true;
//                                HashMap params = new HashMap();
//                                Enumeration en = tag.getParamNames();
//                                while (en.hasMoreElements())
//                                {
//                                    String name = (String) en.nextElement();
//                                    params.put(name.toLowerCase(), tag.getParam(name));
//                                }
//                                Object args[] = {"content", params};
//                                parts.add(new WBMethod(null, obj, args, this));
//                                //System.out.print(cls.getName()+":"+"getResources");
//                            } else
//                            {
//                                contentpart = false;
//                            }
//                        } catch (Exception e)
//                        {
//                            AFUtils.log(com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_parse_notFoundResource") + " " + tag.getParam("class") + " ->Template:" + getTitle(), true);
//                        }
//                    } else if (tag.getTagString().toLowerCase().equals("include"))
//                    {
//                        if (textpart)
//                        {
//                            if(!tag.isEndTag())parts.add(auxpart.toString());
//                            auxpart = new StringBuffer();
//                            textpart = false;
//                        }
//                        try
//                        {
//                            if (!tag.isEndTag())
//                            {
//                                String src=tag.getParam("src");
//                                if(tag!=null)
//                                {
//                                    if(!src.endsWith(".jsp"))
//                                    {
//                                        ArrayList arr = parse(tag.getParam("src"));
//                                        parts.addAll(arr);
//                                    }else
//                                    {
//                                        HashMap params = new HashMap();
//                                        Enumeration en = tag.getParamNames();
//                                        while (en.hasMoreElements())
//                                        {
//                                            String name = (String) en.nextElement();
//                                            params.put(name.toLowerCase(), tag.getParam(name));
//                                        }
//                                        Object args[] = {src, params};
//                                        parts.add(new WBMethod(null, "include", args, this));
//                                    }
//                                }
//                            }
//                        } catch (Exception e)
//                        {
//                            AFUtils.log(com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_parse_notFound") + getTitle(), true);
//                        }
//                    } else if (!resourcepart && !contentpart && !objectpart &&
//                            (tag.getTagString().toLowerCase().equals("img")
//                            || tag.getTagString().toLowerCase().equals("script")
//                            || tag.getTagString().toLowerCase().equals("applet")
//                            || tag.getTagString().toLowerCase().equals("tr")
//                            || tag.getTagString().toLowerCase().equals("td")
//                            || tag.getTagString().toLowerCase().equals("table")
//                            || tag.getTagString().toLowerCase().equals("body")
//                            || tag.getTagString().toLowerCase().equals("input")
//                            || tag.getTagString().toLowerCase().equals("a")
//                            || tag.getTagString().toLowerCase().equals("link")
//                            || tag.getTagString().toLowerCase().equals("form")
//                            || tag.getTagString().toLowerCase().equals("area")
//                            || tag.getTagString().toLowerCase().equals("meta")
//                            || tag.getTagString().toLowerCase().equals("bca")
//                            || tag.getTagString().toLowerCase().equals("embed")
//                            )
//                    )
//                    {
//                        if (tag.getTagString().toLowerCase().equals("script"))
//                        {
//                            if (!tag.isEndTag())
//                            {
//                                if (!tag.isEmpty()) scriptpart = true;
//                            } else
//                            {
//                                scriptpart = false;
//                            }
//                        }
//                        if (!textpart) textpart = true;
//                        if (!tag.isEndTag())
//                        {
//                            auxpart.append("<");
//                            auxpart.append(tag.getTagString());
//                            auxpart.append(" ");
//                            Enumeration en = tag.getParamNames();
//                            while (en.hasMoreElements())
//                            {
//                                String name = (String) en.nextElement();
//                                String value = tag.getParam(name);
//                                auxpart.append(name);
//                                auxpart.append("=\"");
//                                if ((name.toLowerCase().equals("src")
//                                        || name.toLowerCase().equals("background")
//                                        || name.toLowerCase().equals("href"))
//                                        && !value.startsWith("/")
//                                        && !value.startsWith("{")
//                                        && !value.startsWith("http://")
//                                        && !value.startsWith("https://")
//                                        && !value.startsWith("mailto:")
//                                        && !value.startsWith("ftp://")
//                                        && !value.startsWith("telnet://")
//                                        && !value.startsWith("javascript")
//                                        && !value.startsWith("#")
//                                )
//                                {
//                                    auxpart.append(actPath);
//                                }
//                                if (name.toLowerCase().equals("onmouseover") || name.toLowerCase().equals("onload") || name.toLowerCase().equals("onmouseout") || name.toLowerCase().equals("onclick"))
//                                {
//                                    String out = findImagesInScript(value, ".gif'");
//                                    out = findImagesInScript(out, ".jpg'");
//                                    auxpart = replaceObjectsValues(out, auxpart, parts, objects);
//                                    //auxpart.append(out);
//                                } else
//                                {
//                                    auxpart = replaceObjectsValues(value, auxpart, parts, objects);
//                                    //auxpart.append(value);
//                                }
//                                auxpart.append("\" ");
//                            }
//                            auxpart.append(">");
//                        } else
//                            auxpart.append(tok.getRawString());
//                    } else if (!resourcepart && !contentpart && !objectpart &&
//                            tag.getTagString().toLowerCase().equals("param"))
//                    {
//                        if (!textpart) textpart = true;
//                        if (!tag.isEndTag())
//                        {
//                            if (tok.getRawString().toLowerCase().indexOf("movie") > 0)
//                            {
//                                auxpart.append("<");
//                                auxpart.append(tag.getTagString());
//                                auxpart.append(" ");
//                                Enumeration en = tag.getParamNames();
//                                while (en.hasMoreElements())
//                                {
//                                    String name = (String) en.nextElement();
//                                    String value = tag.getParam(name);
//                                    auxpart.append(name);
//                                    auxpart.append("=\"");
//                                    if (name.toLowerCase().equals("value")
//                                            && !value.startsWith("/")
//                                            && !value.startsWith("{")
//                                            && !value.startsWith("http://")
//                                            && !value.startsWith("https://")
//                                            && !value.startsWith("mailto:")
//                                            && !value.startsWith("ftp://")
//                                            && !value.startsWith("telnet://")
//                                            && !value.startsWith("javascript")
//                                            && !value.startsWith("#")
//                                    )
//                                    {
//                                        auxpart.append(actPath);
//                                    }
//                                    if (name.toLowerCase().equals("onmouseover") || name.toLowerCase().equals("onload") || name.toLowerCase().equals("onmouseout") || name.toLowerCase().equals("onclick"))
//                                    {
//                                        String out = findImagesInScript(value, ".gif'");
//                                        out = findImagesInScript(out, ".jpg'");
//                                        auxpart = replaceObjectsValues(out, auxpart, parts, objects);
//                                        //auxpart.append(out);
//                                    } else
//                                    {
//                                        auxpart = replaceObjectsValues(value, auxpart, parts, objects);
//                                        //auxpart.append(value);
//                                    }
//                                    auxpart.append("\" ");
//                                }
//                                auxpart.append(">");
//
//                            } else
//                                auxpart.append(tok.getRawString());
//                        } else
//                            auxpart.append(tok.getRawString());
//                    } else if (!resourcepart && !contentpart && !objectpart)
//                    {
//                        if (!textpart) textpart = true;
//                        auxpart = replaceObjectsValues(tok.getRawString(), auxpart, parts, objects);
//                        //auxpart.append(tok.getRawString());
//                    }
//                } else if (!resourcepart && !contentpart && !objectpart && ttype == HtmlStreamTokenizer.TT_TEXT)
//                {
//                    if (!textpart) textpart = true;
//                    auxpart.append(tok.getRawString());
//                } else if (ttype == HtmlStreamTokenizer.TT_COMMENT)
//                {
//                    if (scriptpart) auxpart.append(tok.getRawString());
//                    //System.out.println("Comment:"+tok.getStringValue());
//                }
//            }
//            if (textpart)
//            {
//                parts.add(auxpart.toString());
//                //System.out.println(auxpart.toString());
//                textpart = false;
//            }
//        } catch (AFException e)
//        {
//            AFUtils.log(e, "Template:parse", true);
//            //throw new AFException(e.getMessage(),"Template:parse");
//        } catch (IOException e)
//        {
//            AFUtils.log(e, "Template:parse", true);
//            //throw new AFException(ioe.getMessage(),"Template:parse");
//        } catch (HtmlException e)
//        {
//            AFUtils.log(e, "Template:parse", true);
//            //throw new AFException(ioe.getMessage(),"Template:parse");
//        }
//
//        return parts;
//    }

//    private String findImagesInScript(String value, String ext)
//    {
//        StringBuffer aux = new StringBuffer(value.length());
//        int off = 0;
//        int f = 0;
//        int i = 0;
//        do
//        {
//            f = value.indexOf(ext, off);
//            i = value.lastIndexOf("'", f);
//            if (f > 0 && i >= 0)
//            {
//                i++;
//                if (value.startsWith("/", i) || value.startsWith("http://", i))
//                {
//                    aux.append(value.substring(off, f + ext.length()));
//                } else
//                {
//                    aux.append(value.substring(off, i) + actPath + value.substring(i, f + ext.length()));
//                }
//                off = f + ext.length();
//            }
//        } while (f > 0 && i > 0);
//        aux.append(value.substring(off));
//        return aux.toString();
//    }
//
//    private String findImageInScript(String value, String ext)
//    {
//        int f = value.indexOf(ext);
//        int i = value.lastIndexOf("'", f);
//        if (f > 0 && i >= 0)
//        {
//            i++;
//            if (value.startsWith("/", i) || value.startsWith("http://", i))
//            {
//                return value;
//            } else
//            {
//                return value.substring(0, i) + actPath + value.substring(i, value.length());
//            }
//        }
//        return value;
//    }
    
//    public String include(String src, HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap params)
//    {
//        String ret="";
//        try
//        {
//            if(!(src.startsWith("/") || src.startsWith("http://")))
//            {
//                src=getActualPath()+src;
//            }
//            //System.out.println("Include src:"+src);
//            WBResponse res=new WBResponse(response);
//            request.setAttribute("topic", topic);
//            request.setAttribute("user", user);
//            request.setAttribute("params", params);
//            request.setAttribute("template", this);
//            RequestDispatcher dispatcher = request.getRequestDispatcher(src);
//            dispatcher.include(request, res);
//            ret=res.toString();
//        }catch(Exception e)
//        {
//            AFUtils.log(e);
//        }finally
//        {
//            if(request!=null)
//            {
//                request.removeAttribute("topic");
//                request.removeAttribute("user");
//                request.removeAttribute("params");            
//                request.removeAttribute("template"); 
//            }
//        }
//        return ret;
//    }

//    /**
//     * @param request
//     * @param response
//     * @param user
//     * @param topic  */
//    public void build(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic) throws TemplateInterruptedException
//    {
//        build(request, response, user, topic, false);
//    }
//
//    /**
//     * @param request
//     * @param response
//     * @param user
//     * @param topic
//     * @param savelog  */
//    public void build(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, boolean savelog)
//    {
//        try
//        {
//            PrintWriter out = response.getWriter();
//            build(request, response, out, user, topic, savelog,null,null);
//            out.flush();
//            out.close();
//        } catch (Exception e)
//        {
//            AFUtils.log(e, com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_build"), true);
//        }
//    }
//
//    /**
//     * @param request
//     * @param response
//     * @param out
//     * @param user
//     * @param topic
//     * @param savelog  */
//    public void build(HttpServletRequest request, HttpServletResponse response, PrintWriter out, User user, WebPage topic, boolean savelog) 
//    {
//        build(request, response, out, user, topic, savelog, null,null);
//    }
//
//    public void build(HttpServletRequest request, HttpServletResponse response, PrintWriter out, User user, WebPage topic, boolean savelog, String content) 
//    {
//        build(request, response, out, user, topic, savelog, content,null);
//    }
//
//    /**
//     * @param request
//     * @param response
//     * @param out
//     * @param user
//     * @param topic
//     * @param savelog
//     * @param content
//     */
//    public void build(HttpServletRequest request, HttpServletResponse response, PrintWriter out, User user, WebPage topic, boolean savelog, String content, DistributorParams distparams) 
//    {
//        //System.out.println("Enter Builder...");
//        StringBuffer logbuf = null;
//        StringBuffer resbuf = null;
//        long tini = 0;
//        if (savelog)
//        {
//            tini = System.currentTimeMillis();
//            resbuf = new StringBuffer(300);
//            logbuf = new StringBuffer(300);
//            logbuf.append("log|");
//            logbuf.append(request.getRemoteAddr());
//            logbuf.append("|");
//            logbuf.append(WBMessageCenter.getInstance().getAddress());
//            logbuf.append("|");
//            String sess=request.getSession().getId();
//            if(sess!=null)
//            {
//                int p=sess.length()-10;
//                if(p>-1)sess=sess.substring(p);
//            }else sess="_";
//            logbuf.append(sess);
//            logbuf.append("|");
//            logbuf.append(topic.getMap().getId());
//            logbuf.append("|");
//            logbuf.append(topic.getId());
//            logbuf.append("|");
//            logbuf.append(user.getRepository());
//            logbuf.append("|");
//            if (user.getLogin() != null)
//                logbuf.append(user.getLogin());
//            else
//                logbuf.append("_");
//            logbuf.append("|");
//            if (user.getUserType() != null)
//                logbuf.append(user.getUserType());
//            else
//                logbuf.append("_");
//            logbuf.append("|");
//            logbuf.append(user.getDevice());
//            logbuf.append("|");
//            if (user.getLanguage() != null && user.getLanguage().length() > 0)
//                logbuf.append(user.getLanguage());
//            else
//                logbuf.append("_");
//        }
//        AFUtils.debug("<!-- Template1:"+ (System.currentTimeMillis()-tini) +"ms -->",AFUtils.DEBUG_INFO);
//        HashMap antresrc = new HashMap(5);                    //recursos evaluados anteriormente
//        try
//        {
//            //PrintWriter out=response.getWriter();
//            Iterator en = parts.iterator();
//            while (en.hasNext())
//            {
//                Object obj = en.next();
//                if (obj instanceof String)
//                    out.print(obj);
//                else if (obj instanceof WBMethod)
//                {
//                    WBMethod wbm = (WBMethod) obj;
//                    if (wbm.getObj() instanceof User)
//                        out.print(wbm.invoke(user, topic, user, request,response));
//                    else if (wbm.getObj() instanceof WebPage)
//                        out.print(wbm.invoke(topic, topic, user, request,response));
//                    else if (wbm.getObj() == HttpServletRequest.class)
//                        out.print(wbm.invoke(request, topic, user, request,response));
//                    else if (wbm.getObj() == HttpServletResponse.class)
//                        out.print(wbm.invoke(response, topic, user, request,response));
//                    else if (wbm.getObj() instanceof ResourceMgr)
//                    {
//                        HashMap args = (HashMap) wbm.getArguments(1);
//                        if ("content".equals(wbm.getArguments(0)))   //es contenido
//                        {
//                            if (content != null)
//                            {
//                                out.println(content);
//                                if (savelog && distparams!=null)
//                                {
//                                    resbuf.append("|");
//                                    //System.out.println("distparams:"+distparams);
//                                    //System.out.println("topic:"+topic);
//                                    if(!topic.getMap().getId().equals(distparams.getAccResourceTMID()))
//                                        resbuf.append("0");
//                                    resbuf.append(distparams.getAccResourceID());
//                                }                                
//                            } else
//                            {
//                                boolean first = true;
//                                
//                                //cambio de topico en el contenido
//                                String resTopic=(String)args.get("topic");
//                                WebPage auxTopic=null;
//                                if(resTopic!=null)
//                                {
//                                    auxTopic=topic.getMap().getTopic(resTopic);
//                                }
//                                
//                                Iterator it;
//                                if(auxTopic!=null)
//                                    it = (Iterator) wbm.invoke((ResourceMgr) wbm.getObj(), user, auxTopic);
//                                else
//                                    it = (Iterator) wbm.invoke((ResourceMgr) wbm.getObj(), user, topic);
//                                int con=-1;
//                                while (it.hasNext())
//                                {
//                                    con++;
//                                    WBResource wbres = (WBResource) it.next();
//                                    //System.out.println("tpl id:"+wbres.getResourceBase().getId()+" prt:"+wbres.getResourceBase().getPriority()+wbres.getResourceBase().getRandPriority());
//                                    
//                                    String resTitle=(String)args.get("gettitle");
//                                    if(resTitle!=null)
//                                    {
//                                        int rt=-1;
//                                        try
//                                        {
//                                            rt=Integer.parseInt(resTitle);
//                                        }catch(Exception e){AFUtils.log(e);}
//                                        if(rt==con)out.print(wbres.getResourceBase().getTitle());
//                                        continue;
//                                    }
//
//                                    String resDesc=(String)args.get("getdescription");
//                                    if(resDesc!=null)
//                                    {
//                                        int rt=-1;
//                                        try
//                                        {
//                                            rt=Integer.parseInt(resDesc);
//                                        }catch(Exception e){AFUtils.log(e);}
//                                        if(rt==con)out.print(wbres.getResourceBase().getDescription());
//                                        continue;
//                                    }
///*                                    
//                                    String resMUrl=(String)args.get("getmaximizedurl");
//                                    if(resMUrl!=null)
//                                    {
//                                        int rt=-1;
//                                        try
//                                        {
//                                            rt=Integer.parseInt(resMUrl);
//                                        }catch(Exception e){AFUtils.log(e);}
//                                        if(rt==con)
//                                        {
//                                            long rid=wbres.getResourceBase().getId();
//                                            javax.servlet.http.HttpServletRequest req=null;
//                                            if(distparams!=null)
//                                            {
//                                                req=distparams.getInternalRequest(request,rid);
//                                            }else
//                                            {
//                                                req=new WBHttpServletRequestWrapper(request);
//                                            }              
//                                            WBParamRequestImp resParams = new WBParamRequestImp(req,wbres.getResourceBase(),topic,user);
//                                            out.print(resParams.getRenderUrl().setWindowState(WBResourceURL.WinState_MAXIMIZED));
//                                        }
//                                        continue;
//                                    }                                    
//                                    String resDUrl=(String)args.get("getdirecturl");
//                                    if(resDUrl!=null)
//                                    {
//                                        int rt=-1;
//                                        try
//                                        {
//                                            rt=Integer.parseInt(resDUrl);
//                                        }catch(Exception e){AFUtils.log(e);}
//                                        if(rt==con)
//                                        {
//                                            long rid=wbres.getResourceBase().getId();
//                                            javax.servlet.http.HttpServletRequest req=null;
//                                            if(distparams!=null)
//                                            {
//                                                req=distparams.getInternalRequest(request,rid);
//                                            }else
//                                            {
//                                                req=new WBHttpServletRequestWrapper(request);
//                                            }              
//                                            WBParamRequestImp resParams = new WBParamRequestImp(req,wbres.getResourceBase(),topic,user);
//                                            out.print(resParams.getRenderUrl().setCallMethod(WBResourceURL.Call_DIRECT));
//                                        }
//                                        continue;
//                                    }                                    
//*/                                    
//                                    if (!(!first && wbres.getResourceBase().getPriority() <= 1))
//                                    {
//                                        String resCont=(String)args.get("getcontent");
//                                        if(resCont!=null)
//                                        {
//                                            int rt=-1;
//                                            try
//                                            {
//                                                rt=Integer.parseInt(resCont);
//                                            }catch(Exception e){AFUtils.log(e);}
//                                            if(rt!=con)continue;
//                                        }                                        
//                                        
//                                        //System.out.println("tpl ok");
//                                        //out.print(ResourceMgr.getInstance().getResourceTraceMgr().getHtmlTraced(wbres, request, response, user, topic, args));
//                                        long rid=wbres.getResourceBase().getId();
//                                        String mdo=null;
//                                        String wst=null;
//                                        String act=null;
//                                        WebPage vtopic=null;
//                                        String extParams=null;
//                                        if(distparams!=null)
//                                        {
//                                            vtopic=distparams.getVirtTopic();
//                                            HashMap resp=distparams.getResourceURI(rid);
//                                            if(resp!=null && distparams.getResourceTMID(rid).equals(wbres.getResourceBase().getTopicMapId()))
//                                            {
//                                                mdo=(String)resp.get(distparams.URLP_MODE);
//                                                wst=(String)resp.get(distparams.URLP_WINSTATE);
//                                                act=(String)resp.get(distparams.URLP_ACTION);
//                                            }
//                                            extParams=distparams.getNotAccResourceURI(rid);
//                                        }
//                                        
//                                        //System.out.println("rid:"+rid);
//                                        //System.out.println("distparams.getAccResourceID():"+distparams.getAccResourceID());
//                                        
//                                        WBResponse res=new WBResponse(response);
//                                        javax.servlet.http.HttpServletRequest req=null;
//                                        if(distparams!=null)
//                                        {
//                                            req=distparams.getInternalRequest(request,rid);
//                                        }else
//                                        {
//                                            req=new WBHttpServletRequestWrapper(request);
//                                        }              
//                                        
//                                        WBParamRequestImp resParams = new WBParamRequestImp(req,wbres.getResourceBase(),topic,user);
//                                        resParams.setArguments(args);
//                                        resParams.setExtURIParams(extParams);
//                                        resParams.setCallMethod(resParams.Call_CONTENT);
//                                        if(act!=null)resParams.setAction(act);
//                                        if(mdo!=null)resParams.setMode(mdo);
//                                        if(wst!=null)resParams.setWindowState(wst);                                        
//                                        if(vtopic!=null)
//                                        {
//                                            resParams.setVirtualTopic(vtopic);
//                                        }
//                                        
//                                        ResourceMgr.getInstance().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
//                                        out.print(res.toString());
//                                        
//                                        String intraBR=(String)args.get("intrabr");
//                                        if(it.hasNext() && (intraBR==null || intraBR.equalsIgnoreCase("true")))
//                                        {
//                                            out.println("<BR>");
//                                        }
//                                        if(savelog)
//                                        {
//                                            resbuf.append("|");
//                                            if(!wbres.getResourceBase().getTopicMapId().equals(topic.getMap().getId()))
//                                                resbuf.append("0");
//                                            resbuf.append(wbres.getResourceBase().getId());
//                                        }
//                                        first = false;
//                                    }
//                                }
//                            }
//                        } else                                        //es estrategia
//                        {
//                            String id = "" + args.get("type") + args.get("stype");       //id para guardar recurso en anteriores
//                            if (antresrc.get(id) == null)
//                            {
//                                //System.out.println("id:"+id+":"+0);
//                                Iterator it = (Iterator) wbm.invoke((ResourceMgr) wbm.getObj(), user, topic);
//                                if (it.hasNext())
//                                {
//                                    WBResource wbres = (WBResource) it.next();
//                                    //System.out.println("rec:"+wbres.getResourceBase().getId()+" typemap="+wbres.getResourceBase().getTopicMapId());
//                                    
//                                    long rid=wbres.getResourceBase().getId();
//                                    String mdo=null;
//                                    String wst=null;
//                                    String act=null;
//                                    WebPage vtopic=null;
//                                    String extParams=null;
//                                    if(distparams!=null)
//                                    {
//                                        vtopic=distparams.getVirtTopic();
//                                        HashMap resp=distparams.getResourceURI(rid);
//                                        if(resp!=null && distparams.getResourceTMID(rid).equals(wbres.getResourceBase().getTopicMapId()))
//                                        {
//                                            mdo=(String)resp.get(distparams.URLP_MODE);
//                                            wst=(String)resp.get(distparams.URLP_WINSTATE);
//                                            act=(String)resp.get(distparams.URLP_ACTION);
//                                        }
//                                        extParams=distparams.getNotAccResourceURI(rid);
//                                    }
//                                    
//                                    //out.print(ResourceMgr.getInstance().getResourceTraceMgr().getHtmlTraced(wbres, request, response, user, topic, args));
//                                    WBResponse res=new WBResponse(response);
//                                    javax.servlet.http.HttpServletRequest req=null;
//                                    if(distparams!=null)
//                                    {
//                                        req=distparams.getInternalRequest(request,rid);
//                                    }else
//                                    {
//                                        req=new WBHttpServletRequestWrapper(request);
//                                    }                                       
//                                    
//                                    WBParamRequestImp resParams = new WBParamRequestImp(request,wbres.getResourceBase(),topic,user);
//                                    resParams.setArguments(args);
//                                    resParams.setExtURIParams(extParams);
//                                    resParams.setCallMethod(resParams.Call_STRATEGY);
//                                    if(act!=null)resParams.setAction(act);
//                                    //resParams.setCallMethod(mto);
//                                    if(mdo!=null)resParams.setMode(mdo);
//                                    if(wst!=null)resParams.setWindowState(wst);                                        
//                                    if(vtopic!=null)
//                                    {
//                                        resParams.setVirtualTopic(vtopic);
//                                    }
//                                    
//                                    ResourceMgr.getInstance().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
//                                    out.print(res.toString());
//                                    
//                                    //System.out.println("Salida:"+wbres.getResourceBase().getId()+":"+res.toString());
//                                    
//                                    if (savelog)
//                                    {
//                                        resbuf.append("|");
//                                        if(!wbres.getResourceBase().getTopicMapId().equals(topic.getMap().getId()))
//                                            resbuf.append("0");
//                                        resbuf.append(wbres.getResourceBase().getId());
//                                    }
//                                }
//                                if (it.hasNext()) antresrc.put(id, it);
//                            } else
//                            {
//                                //System.out.println("id:"+id+":n");
//                                Iterator it = (Iterator) antresrc.get(id);
//                                WBResource wbres = (WBResource) it.next();
//                                
//                                long rid=wbres.getResourceBase().getId();
//                                String mdo=null;
//                                String wst=null;
//                                String act=null;
//                                WebPage vtopic=null;
//                                String extParams=null;
//                                if(distparams!=null)
//                                {
//                                    vtopic=distparams.getVirtTopic();
//                                    HashMap resp=distparams.getResourceURI(rid);
//                                    if(resp!=null && distparams.getResourceTMID(rid).equals(wbres.getResourceBase().getTopicMapId()))
//                                    {
//                                        mdo=(String)resp.get("_mod");
//                                        wst=(String)resp.get("_wst");
//                                        act=(String)resp.get("_act");
//                                    }
//                                    extParams=distparams.getNotAccResourceURI(rid);
//                                }
//                                //out.print(ResourceMgr.getInstance().getResourceTraceMgr().getHtmlTraced(wbres, request, response, user, topic, args));
//                                WBResponse res=new WBResponse(response);
//                                javax.servlet.http.HttpServletRequest req=null;
//                                if(distparams!=null)
//                                {
//                                    req=distparams.getInternalRequest(request,rid);
//                                }else
//                                {
//                                    req=new WBHttpServletRequestWrapper(request);
//                                }                                
//                                
//                                WBParamRequestImp resParams = new WBParamRequestImp(request,wbres.getResourceBase(),topic,user);
//                                resParams.setArguments(args);
//                                resParams.setExtURIParams(extParams);
//                                resParams.setCallMethod(resParams.Call_STRATEGY);
//                                
//                                if(act!=null)resParams.setAction(act);
//                                //resParams.setCallMethod(mto);
//                                if(mdo!=null)resParams.setMode(mdo);
//                                if(wst!=null)resParams.setWindowState(wst);                                        
//                                if(vtopic!=null)
//                                {
//                                    resParams.setVirtualTopic(vtopic);
//                                }
//                                
//                                ResourceMgr.getInstance().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
//                                out.print(res.toString());
//                                
//                                if (!it.hasNext()) antresrc.remove(id);
//                                if (savelog)
//                                {
//                                    resbuf.append("|");
//                                    if(!wbres.getResourceBase().getTopicMapId().equals(topic.getMap().getId()))
//                                        resbuf.append("0");
//                                    resbuf.append(wbres.getResourceBase().getId());
//                                }
//                            }
//                        }
//                    }else if (wbm.getObj() instanceof String)
//                    {
//                        String aux=(String)wbm.getObj();
//                        if(aux.equals("include"))
//                        {
//                            HashMap args = (HashMap) wbm.getArguments(1);
//                            out.print(include((String)wbm.getArguments(0),request,response,user,topic,args));
//                        }
//                    } else
//                        out.print(wbm.invoke(topic, user, request,response));
//                }
//                AFUtils.debug("<!-- TemplateTag:"+ (System.currentTimeMillis()-tini) +"ms -->",AFUtils.DEBUG_INFO);                
//            }
//        } catch (TemplateInterruptedException tie)
//        {
//            throw tie;
//        } catch (Exception e)
//        {
//            AFUtils.log(e, com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_build"), true);
//        }
//
//        if (savelog)
//        {
//            long tfin = System.currentTimeMillis() - tini;            
//            WBMessageCenter.getInstance().sendMessage(logbuf.toString()+"|"+tfin+resbuf.toString());
//        }
//        AFUtils.debug("<!-- TemplateFin:"+ (System.currentTimeMillis()-tini) +"ms -->",AFUtils.DEBUG_INFO);
//    }
//    
//    public static void buildContents(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, PrintWriter out, DistributorParams distparams, boolean savelog, String content) 
//    {
//        StringBuffer logbuf = null;
//        StringBuffer resbuf = null;
//        
//        WebPage topic=distparams.getTopic();
//        User user=distparams.getUser();
//        
//        long tini = 0;
//        if (savelog)
//        {
//            tini = System.currentTimeMillis();
//            resbuf = new StringBuffer(300);
//            logbuf = new StringBuffer(300);
//            logbuf.append("log|");
//            logbuf.append(request.getRemoteAddr());
//            logbuf.append("|");
//            logbuf.append(WBMessageCenter.getInstance().getAddress());
//            logbuf.append("|");
//            String sess=request.getSession().getId();
//            if(sess!=null)
//            {
//                int p=sess.length()-10;
//                if(p>-1)sess=sess.substring(p);
//            }else sess="_";
//            logbuf.append(sess);
//            logbuf.append("|");
//            logbuf.append(topic.getMap().getId());
//            logbuf.append("|");
//            logbuf.append(topic.getId());
//            logbuf.append("|");
//            logbuf.append(user.getRepository());
//            logbuf.append("|");
//            if (user.getLogin() != null)
//                logbuf.append(user.getLogin());
//            else
//                logbuf.append("_");
//            logbuf.append("|");
//            if (user.getUserType() != null)
//                logbuf.append(user.getUserType());
//            else
//                logbuf.append("_");
//            logbuf.append("|");
//            logbuf.append(user.getDevice());
//            logbuf.append("|");
//            if (user.getLanguage() != null && user.getLanguage().length() > 0)
//                logbuf.append(user.getLanguage());
//            else
//                logbuf.append("_");
//        }
//        
//        try
//        {
//            if (content != null)
//            {
//                out.println(content);
//                if (savelog)
//                {
//                    resbuf.append("|");
//                    if(!distparams.getAccResourceTMID().equals(topic.getMap().getId()))
//                        resbuf.append("0");
//                    resbuf.append(distparams.getAccResourceID());
//                }
//            }else
//            {
//                boolean first = true;
//                Iterator it = ResourceMgr.getInstance().getContents(distparams.getUser(), distparams.getTopic(), null,null);
//                while (it.hasNext())
//                {
//                    WBResource wbres = (WBResource) it.next();
//                    //System.out.println("tpl id:"+wbres.getResourceBase().getId()+" prt:"+wbres.getResourceBase().getPriority()+wbres.getResourceBase().getRandPriority());
//                    if (!(!first && wbres.getResourceBase().getPriority() <= 1))
//                    {
//                        //System.out.println("tpl ok");
//                        //out.print(ResourceMgr.getInstance().getResourceTraceMgr().getHtmlTraced(wbres, request, response, user, topic, args));
//                        long rid=wbres.getResourceBase().getId();
//                        String mdo=null;
//                        String wst=null;
//                        String act=null;
//                        WebPage vtopic=null;
//                        String extParams=null;
//                        if(distparams!=null)
//                        {
//                            vtopic=distparams.getVirtTopic();
//                            HashMap resp=distparams.getResourceURI(rid);
//                            if(resp!=null && distparams.getResourceTMID(rid).equals(wbres.getResourceBase().getTopicMapId()))
//                            {
//                                mdo=(String)resp.get(distparams.URLP_MODE);
//                                wst=(String)resp.get(distparams.URLP_WINSTATE);
//                                act=(String)resp.get(distparams.URLP_ACTION);
//                            }
//                            extParams=distparams.getNotAccResourceURI(rid);
//                        }
//
//                        //System.out.println("rid:"+rid);
//                        //System.out.println("distparams.getAccResourceID():"+distparams.getAccResourceID());
//
//                        WBResponse res=new WBResponse(response);
//                        javax.servlet.http.HttpServletRequest req=null;
//                        if(distparams!=null)
//                        {
//                            req=distparams.getInternalRequest(request,rid);
//                        }else
//                        {
//                            req=new WBHttpServletRequestWrapper(request);
//                        }
//                        
//                        WBParamRequestImp resParams = new WBParamRequestImp(req,wbres.getResourceBase(),distparams.getTopic(),distparams.getUser());
//                        resParams.setArguments(new HashMap());
//                        resParams.setExtURIParams(extParams);
//                        resParams.setCallMethod(resParams.Call_CONTENT);
//                        if(act!=null)resParams.setAction(act);
//                        if(mdo!=null)resParams.setMode(mdo);
//                        if(wst!=null)resParams.setWindowState(wst);                                        
//                        if(vtopic!=null)
//                        {
//                            resParams.setVirtualTopic(vtopic);
//                        }
//
//                        ResourceMgr.getInstance().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
//                        out.print(res.toString());
//
//                        //String intraBR=(String)args.get("intrabr");
//                        //if(it.hasNext() && (intraBR==null || intraBR.equalsIgnoreCase("true")))
//                        if(it.hasNext())
//                        {
//                            out.println("<BR>");
//                        }
//                        if (savelog)
//                        {
//                            resbuf.append("|");
//                            if(!wbres.getResourceBase().getTopicMapId().equals(topic.getMap().getId()))
//                                resbuf.append("0");
//                            resbuf.append(wbres.getResourceBase().getId());
//                        }
//                        first = false;
//                    }
//                }
//            }
//        }catch(TemplateInterruptedException tie)
//        {
//            throw tie;
//        } catch (Exception e)
//        {
//            AFUtils.log(e, com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_build"), true);
//        }
//        
//        if (savelog)
//        {
//            long tfin = System.currentTimeMillis() - tini;            
//            WBMessageCenter.getInstance().sendMessage(logbuf.toString()+"|"+tfin+resbuf.toString());
//        }        
//    }
//
//    public String getPreview()
//    {
//        StringBuffer out = new StringBuffer();
//        try
//        {
//            Iterator en = parts.iterator();
//            while (en.hasNext())
//            {
//                Object obj = en.next();
//                if (obj instanceof String)
//                    out.append(obj);
//                else if (obj instanceof WBMethod)
//                {
//                    out.append("<table bgcolor=#bbbbbb><tr><td>\n");
//                    out.append("<font color=red fase=arial size=2>\n");
//                    WBMethod wbm = (WBMethod) obj;
//                    //if(wbm.getObj() instanceof User)out.append("<font color=red fase=arial size=2>User</font>");//out.append(wbm.invoke(user));
//                    //else if(wbm.getObj() instanceof WebPage)out.append("<font color=red fase=arial size=2>WebPage</font>");//out.append(wbm.invoke(topic));
//                    if (wbm.getObj() instanceof ResourceMgr)
//                    {
//                        HashMap args = (HashMap) wbm.getArguments(1);
//                        if (wbm.getArguments(0) instanceof String)   //es contenido
//                        {
//                            out.append("Contenido:");
//                        } else
//                        {
//                            out.append("Recurso:");
//                        }
//                        Iterator it = args.keySet().iterator();
//                        while (it.hasNext())
//                        {
//                            Object aux = it.next();
//                            if (aux.toString().equalsIgnoreCase("stype"))
//                            {
//                                //TODO: revisar objetos de otros sitios
//                                String stype = DBCatalogs.getInstance().getSubType(this.getTopicMapId(),Integer.parseInt(args.get(aux).toString())).getTitle();
//                                out.append("<BR>&nbsp;&nbsp;&nbsp;" + aux + "=\"" + stype + "\"\n");
//                            } else
//                            {
//                                out.append("<BR>&nbsp;&nbsp;&nbsp;" + aux + "=\"" + args.get(aux) + "\"\n");
//                            }
//                        }
//                    } else
//                    {
//                        //out.append(" "+wbm.getObj().getClass().getName());
//                        String mto = wbm.getMethod().toString();
//                        int k = mto.lastIndexOf('(');
//                        int i = mto.lastIndexOf('.', k);
//                        int j = mto.lastIndexOf('.', i - 1);
//                        String method = mto.substring(i + 1);
//                        String name = mto.substring(j + 1, i);
//                        out.append("Objeto:" + "\n");
//                        out.append("<BR>&nbsp;&nbsp;&nbsp;" + com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "usrmsg_Template_getPreview_class") + ":" + name + "\n");
//                        out.append("<BR>&nbsp;&nbsp;&nbsp;" + com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "usrmsg_Template_getPreview_method") + ":" + method + "\n");
//                        if (mto.length() - k > 2)
//                        {
//                            if (wbm.getArguments(0) instanceof HashMap)
//                            {
//                                out.append("<BR>&nbsp;&nbsp;&nbsp;" + com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "usrmsg_Template_getPreview_args") + ":\n");
//                                HashMap args2 = (HashMap) wbm.getArguments(0);
//                                Iterator it = (args2).keySet().iterator();
//                                while (it.hasNext())
//                                {
//                                    Object aux = it.next();
//                                    out.append("<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + aux + "=\"" + args2.get(aux) + "\"\n");
//                                }
//                            }
//                        }
//                    }
//                    out.append("</font>\n");
//                    out.append("</td</tr></table>\n");
//                }
//            }
//        } catch (Exception e)
//        {
//            AFUtils.log(e, com.infotec.appfw.util.AFUtils.getLocaleString("locale_core", "error_Template_getPreview"), true);
//        }
//        return out.toString();
//    }
//
//    /**
//     * @return  */
//    public java.util.ArrayList getParts()
//    {
//        return parts;
//    }

//    /** Verifica si el usuario tiene permisos de acceso al recurso.
//     * @return boolean
//     */
//    public boolean haveAccess(User user)
//    {
//        return checkRoles(user) && checkRules(user);
//    }    
//    
//    public boolean checkRules(User user)
//    {
//        boolean passrule = true;
//        boolean criterial_or=true;
//        
//        String cnf_rule=this.getAttribute("CNF_WBRule","");
//        if(cnf_rule.equals(WebPage.CONFIG_DATA_AND_CRITERIAL))criterial_or=false;
//        
//        //System.out.println("haveAccess:"+getId()+" crit:"+criterial_or);
//        Iterator ru = this.getRules();
//        while (ru.hasNext())
//        {
//            int nrule = ((Integer) ru.next()).intValue();
//            //System.out.println("rule:"+nrule);
//            if (RuleMgr.getInstance().eval(user, nrule, this.getTopicMapId()))
//            {
//                passrule = true;
//                if(criterial_or)break;
//            } else
//            {
//                passrule = false;
//                if(!criterial_or)break;
//            }
//        }        
//        //System.out.println("haveAccess ret:"+passrule);
//        return passrule;
//    }
//    
//    public boolean checkRoles(User user)
//    {
//        boolean pass = true;
//        boolean criterial_or=true;
//        
//        String cnf_rule=this.getAttribute("CNF_WBRole","");
//        if(cnf_rule.equals(WebPage.CONFIG_DATA_AND_CRITERIAL))criterial_or=false;
//        
//        //System.out.println("haveAccess:"+getId()+" crit:"+criterial_or);
//        Iterator ru = this.getRoles();
//        while (ru.hasNext())
//        {
//            int nrole = ((Integer) ru.next()).intValue();
//            //System.out.println("role:"+nrole);
//            if (user.haveRole(nrole))
//            {
//                pass = true;
//                if(criterial_or)break;
//            } else
//            {
//                pass = false;
//                if(!criterial_or)break;
//            }
//        }        
//        //System.out.println("haveAccess ret:"+pass);
//        return pass;
//    }  
    
    
//    /**
//     * Regresa webPath mas el directorio de la version actual.
//     * @return Value of property actPath.
//     */
//    public java.lang.String getActualPath()
//    {
//        return actPath;
//    }    
//
//    public String getFileName(int version){
//        return getAttribute("version_"+version,getFilename());
//    }
//    
//    //UTILIDADES DE TEMPLATES
//    public String setHeaders(HashMap map)
//    {
//        try
//        {
//            HttpServletResponse response=(HttpServletResponse)map.get("response");
//            //System.out.println(response);
//            if(response!=null && response instanceof HttpServletResponse)
//            {
//                Iterator it=map.keySet().iterator();
//                while(it.hasNext())
//                {
//                    String key=(String)it.next();
//                    Object val=map.get(key);
//                    if(val instanceof String && !key.equals("method"))
//                    {
//                        String value=(String)val;
//                        try
//                        {
//                            //System.out.println(AFUtils.toUpperCaseFL(key)+":"+value);
//                            response.setHeader(AFUtils.toUpperCaseFL(key),value);
//                        }catch(Exception e){AFUtils.log(e);}
//                    }
//                } 
//            }
//        }catch(Exception e){AFUtils.log(e);}
//        return "";
//    }
    
//    public String getRequestParameter(HashMap map)
//    {
//        try
//        {
//            HttpServletRequest request=(HttpServletRequest)map.get("request");
//            //System.out.println(response);
//            if(request!=null && request instanceof HttpServletRequest)
//            {
//                String name=(String)map.get("name");
//                String defvalue=(String)map.get("defaultvalue");
//                String val=request.getParameter(name);
//                if(val==null)return defvalue;
//                return val;
//            }
//        }catch(Exception e){AFUtils.log(e);}
//        return "";        
//    }
//    
//    public String writeText(HashMap map)
//    {
//        try
//        {
//            String ret=(String)map.get("text");
//            if(ret==null)ret="";
//            return ret;
//        }catch(Exception e){AFUtils.log(e);}
//        return "";        
//    }    
//    
//    public String writeGT()
//    {
//        return "<";        
//    }        
    
    /**
 * Reload.
 */
    public void reload()
    {
        
    }

    /**
     * Gets the file name.
     * 
     * @param version the version
     * @return the file name
     */
    public String getFileName(int version)
    {
        String ret=null;
        VersionInfo info=getLastVersion();
        while(info!=null && info.getVersionNumber()!=version)
        {
            info=info.getPreviousVersion();
        }
        if(info!=null)
        {
            ret=info.getVersionFile();
        }
        return ret;
    }
}
