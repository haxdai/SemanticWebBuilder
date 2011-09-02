package org.semanticwb.cptm;

import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.FormElementURL;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;


public class TreeSelect extends org.semanticwb.cptm.base.TreeSelectBase 
{
    protected static final String pathImages = SWBPlatform.getContextPath() + "/swbadmin/icons/";

    private static Logger log = SWBUtils.getLogger(TreeSelect.class);

    public TreeSelect(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName) {
        if (prop.getDisplayProperty() == null) {
            return;
        }
        String value = request.getParameter("section"+"_" + obj.getShortURI() + "_" + propName);
        String delPages = request.getParameter("deletePages"+"_" + obj.getShortURI() + "_" + propName);
        if ((value != null) && (value.length() > 0)) {
            try {
                obj.setProperty(prop, value);
            } catch (Exception e) {
                log.error("Can't save the value's property in TreeSelect, " + e);
            }
        }
        if(delPages != null) {
            obj.removeProperty(prop);
        }

    }

    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type, String mode, String lang) {
        StringBuffer   ret          = new StringBuffer(256);
        String style= "";
        WebPage tpid = null;
        ArrayList listData = new ArrayList();
        StringBuilder params = new StringBuilder("");

        String li = obj.getProperty(prop);
        WebSite site = SWBContext.getWebSite(getModel().getName());
        WebPage home = site.getHomePage();
        FormElementURL url1 = getRenderURL(obj, prop, type, mode, lang); //url del formElement
        String url = url1.toString().replaceAll("&", "&amp;");

        //Si la propiedad tiene un valor almacenado, obtener los padres para abrir las carpetas
        if(li != null && li.length() > 0 && tpid == null) {
            tpid = site.getWebPage(li);
            WebPage lip = site.getWebPage(li);
            WebPage parent = lip;
            if(lip != null) {
                boolean isparent = true;
                do{
                    parent = parent.getParent();
                    if(parent == null){
                        isparent = false;
                    } else {
                        listData.add(parent);
                    }
                }while(isparent) ;
            }
            tpid = null;
         }

        //Obteniendo la pÃ¡gina web seleccionada
        if(request.getParameter("reptp") != null) {
            tpid=site.getWebPage((String)request.getParameter("reptp"));
            ret.append("<input type=\"hidden\" name=\"section"+"_" + obj.getShortURI() + "_" + propName+"\" id=\"section"+"_" + obj.getShortURI() + "_" + propName+"\" value=\""+tpid.getId()+"\" />");
        }

        //Carpeta Abierta o Cerrada
        boolean toggleopen = Boolean.parseBoolean(request.getParameter(home.getId()) == null ? "false" : ((String)request.getParameter(home.getId())).equals("1") ? "true" : "false");
        if(tpid == null) {
            ret.append("<input type=\"checkbox\" name=\"deletePages"+"_" + obj.getShortURI() + "_" + propName+"\" value=\"deletePages\">Deseleccionar páginas web");
        } else {
            listData = new ArrayList();
        }
        ret.append("<div id=\"slave\">");
        ret.append("<div class=\"sitesectiontree\" id=\"tree_"+site.getId()+"_" + obj.getShortURI() + "_" + propName+"\">");
        ret.append("<ul class=\"treeres\">");
        ret.append("<li>");

        //Icono a mostrar Activo/Inactivo para el sitio
        if(site.isActive()) {
            ret.append("<img src=\""+pathImages+"/icon_siteb.gif\" alt=\"seleccionar sitio\" />");
        } else {
            ret.append("<img src=\""+pathImages+"/icon_sitein.png\" alt=\"seleccionar sitio\" />");
        }
        //Titulo del Sitio
        try {
            ret.append("<span style=\"padding-left:5px\">"+SWBUtils.TEXT.encode(site.getDisplayTitle(lang), SWBUtils.TEXT.CHARSET_UTF8)+"</span>");
        } catch(Exception e) {
            log.error("CanÂ´t convert text to code UTF8" + e);
        }
        ret.append("<ul class=\"treeres\">");
        ret.append("<li>");

        //Si es la pÃ¡gina actual, obteniendo las imagenes
        if(tpid != null && tpid.getId().equalsIgnoreCase(home.getId())) {
            style=" style=\"color:#FF6600; font-weight:bold; background-color:#000\"";
            if(toggleopen) {
                //Si esta abierta
                params.append("&"+home.getId()+"=0");
                ret.append("<img src=\""+pathImages+"/plus.gif\" alt=\"abrir nodo\" onclick=\"getHtml('"+url+"&reptp=" + home.getId()+params+"','tree_'+'"+site.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                toggleopen = false;
            } else {
                //Si la pÃ¡gina esta cerrada
                params.append("&"+home.getId()+"=1");
                ret.append("<img src=\""+pathImages+"/minus.gif\" alt=\"cerrar nodo\" onclick=\"getHtml('"+url+"&reptp=" + home.getId()+params+"','tree_'+'"+site.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                toggleopen = true;
            }
        }else {
            //Si la pÃ¡gina no es la actual
            if(listData.isEmpty()) {
                style="";
                if(toggleopen) {
                    //Si la pÃ¡gina esta abierta
                    params.append("&"+home.getId()+"=1");
                    ret.append("<img src=\""+pathImages+"/minus.gif\" alt=\"cerrar nodo\"  onclick=\"getHtml('"+url+"&reptp=" + home.getId()+params+"','tree_'+'"+site.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                }else {
                    //Si la pÃ¡gina no esta abierta
                    params.append("&"+home.getId()+"=0");
                    ret.append("<img src=\""+pathImages+"/plus.gif\" alt=\"abrir nodo\"  onclick=\"getHtml('"+url+"&reptp=" + home.getId()+params+"','tree_'+'"+site.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                }
            } else {
                    params.append("&"+home.getId()+"=1");
                    ret.append("<img src=\""+pathImages+"/minus.gif\" alt=\"cerrar nodo\"  onclick=\"getHtml('"+url+"&reptp=" + home.getId()+params+"','tree_'+'"+site.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
            }
        }
        if((li != null && li.length() > 0) && li.equalsIgnoreCase(home.getId()))
        {
            style = " style=\"font-weight:bold; background-color:#6699FF\"";
        }
        //Obteniendo las ligas
        ret.append("<a class=\"treeres\" onclick=\"getHtml('"+url+"&reptp=" + home.getId()+params+"','tree_'+'"+site.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" "+style+">");
        //mostrar icono del home(Activo/Desactivo)
        if(home.isActive()) {
            ret.append("<img src=\""+pathImages+"/icon_homeac.png\" alt=\"seleccionar inicio\" />");
        } else {
            ret.append("<img src=\""+pathImages+"/icon_homein.png\" alt=\"seleccionar inicio\" />");
        }

        //Agregar el tÃ­tulo del nodo actual
        try {
            ret.append("<span style=\"padding-left:5px\">"+SWBUtils.TEXT.encode(home.getDisplayTitle(lang), SWBUtils.TEXT.CHARSET_UTF8)+"</span>");
        } catch(Exception e) {
            log.error("Can't save the value's property in TreeSelect, " + e);
        }
        ret.append("</a>");

        //Pintando los hijos si esta abierta la carpeta
        if(home != null && toggleopen) {
            ret.append(addChild(true,listData,request, site, home, tpid, url1, params,lang,li,obj,propName));
        }

        if(!listData.isEmpty() && tpid == null) {
            ret.append(addChild(false,listData,request, site, home, tpid, url1, params, lang, li,obj,propName));
        }
        ret.append("</li>");
        ret.append("</ul>");
        ret.append("</li>");
        ret.append("</ul>");
        ret.append("</div>");
        ret.append("</div>");
        return ret.toString();
    }

    protected String addChild(boolean isAjax, ArrayList list, HttpServletRequest request, WebSite tmit, WebPage pageroot, WebPage tpid, FormElementURL url1, StringBuilder params, String lang, String dataCurrent, SemanticObject obj, String propName) {
        String style;
        String url = url1.toString().replaceAll("&", "&amp;");
        boolean toggleopen;
        StringBuilder html = new StringBuilder("<ul class=\"treeres ch\">");
        Iterator<WebPage> childs=pageroot.listChilds();
        while(childs.hasNext()) {
            WebPage webpage = childs.next();
            if(webpage.getId() != null && !webpage.isDeleted()) {
                if(!list.isEmpty()) {
                    if(list.contains(webpage)) {
                        toggleopen = true;
                    } else {
                        toggleopen = false;
                    }
                }else {
                    toggleopen = Boolean.parseBoolean(request.getParameter(webpage.getId()) == null ? "false" : ((String)request.getParameter(webpage.getId())).equals("1") ? "true" : "false");
                }
                if(webpage.listChilds().hasNext()) {
                    html.append("<li>");
                    if(tpid != null && tpid.getId().equalsIgnoreCase(webpage.getId())) {
                        style=" style=\"color:#FF6600; font-weight:bold; background-color:#000\"";
                        if(toggleopen) {
                            params.append("&"+webpage.getId()+"=0");
                            html.append("<img src=\""+pathImages+"/plus.gif\" alt=\"abrir nodo\" onclick=\"getHtml('"+url+"&reptp="+webpage.getId()+params+"','tree_'+'"+tmit.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                            toggleopen = false;
                        } else {
                            params.append("&"+webpage.getId()+"=1");
                            html.append("<img src=\""+pathImages+"/minus.gif\" alt=\"cerrar nodo\" onclick=\"getHtml('"+url+"&reptp="+webpage.getId()+params+"','tree_'+'"+tmit.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                            toggleopen = true;
                        }
                    } else {
                        style="";
                        if(toggleopen) {
                            params.append("&"+webpage.getId()+"=1");
                            html.append("<img src=\""+pathImages+"/minus.gif\" alt=\"cerrar nodo\" onclick=\"getHtml('"+url+"&reptp="+webpage.getId()+params+"','tree_'+'"+tmit.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                        } else {
                            params.append("&"+webpage.getId()+"=0");
                            html.append("<img src=\""+pathImages+"/plus.gif\" alt=\"abrir nodo\" onclick=\"getHtml('"+url+"&reptp="+webpage.getId()+params+"','tree_'+'"+tmit.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" />");
                        }
                    }
                    if((dataCurrent !=null && dataCurrent.length() > 0)&& dataCurrent.equalsIgnoreCase(webpage.getId()))//tpid==null&&
                    {
                        style=" style=\"font-weight:bold; background-color:#6699FF\"";
                    }
                    html.append("<a class=\"treeres\" onclick=\"getHtml('"+url+"&reptp="+webpage.getId()+params+"','tree_'+'"+tmit.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" "+style+">");
                    if(webpage.isActive()) {
                        html.append("<img src=\""+pathImages+"/icon_secac.png\" alt=\"seleccionar secciÃ³n\" />");
                    } else {
                        html.append("<img src=\""+pathImages+"/icon_secin.png\" alt=\"seleccionar secciÃ³n\" />");
                    }
                    if(!isAjax) {
                        html.append("<span style=\"padding-left:5px\">"+webpage.getDisplayTitle(lang)+"</span>");
                    } else {
                        try {
                            html.append("<span style=\"padding-left:5px\">"+SWBUtils.TEXT.encode(webpage.getDisplayTitle(lang), SWBUtils.TEXT.CHARSET_UTF8)+"</span>");
                        } catch(Exception e) {
                            log.error("Can't save the value's property in TreeSelect, " + e);
                        }
                    }
                    html.append("</a>");
                    if(toggleopen) {
                        html.append(addChild(isAjax,list,request, tmit, webpage, tpid, url1, params,lang,dataCurrent,obj,propName));
                    }
                    html.append("</li>");
                }else {
                    if(tpid != null && tpid.getId().equalsIgnoreCase(webpage.getId())) {
                        style=" style=\"color:#FF6600; font-weight:bold; background-color:#000\"";
                    } else {
                        style="";
                    }
                    if((dataCurrent != null && dataCurrent.length() > 0) && dataCurrent.equalsIgnoreCase(webpage.getId()))
                    {
                        style=" style=\"font-weight:bold; background-color:#6699FF\"";
                    }
                    html.append("<li>");
                    html.append("<img src=\""+pathImages+"/trans.gif\" />");
                    html.append("<a class=\"treeres\" onclick=\"getHtml('"+url+"&reptp="+webpage.getId()+params+"','tree_'+'"+tmit.getId()+"_" + obj.getShortURI() + "_" + propName+"')\" "+style+">");
                    if(webpage.isActive()) {
                        html.append("<img src=\""+pathImages+"/icon_secac.png\" alt=\"seleccionar secciÃ³n\" />");
                    } else {
                        html.append("<img src=\""+pathImages+"/icon_secin.png\" alt=\"seleccionar secciÃ³n\" />");
                    }
                    if(!isAjax) {
                        html.append("<span style=\"padding-left:5px\">"+webpage.getDisplayTitle(lang)+"</span>");
                    } else {
                        try {
                            html.append("<span style=\"padding-left:5px\">"+SWBUtils.TEXT.encode(webpage.getDisplayTitle(lang), SWBUtils.TEXT.CHARSET_UTF8)+"</span>");
                        } catch(Exception e) {
                            log.error("Can't save the value's property in TreeSelect, " + e);
                        }
                    }
                    html.append("</a>");
                    html.append("</li>");
                }
            }
        }
        html.append("</ul>");
        return html.toString();
    }
}
