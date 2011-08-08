
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
 */
package org.semanticwb.model;

//~--- non-JDK imports --------------------------------------------------------

import org.semanticwb.SWBPlatform;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

//~--- JDK imports ------------------------------------------------------------

import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectTree.
 */
public class SelectTree extends org.semanticwb.model.base.SelectTreeBase {
    
    /**
     * Instantiates a new select tree.
     * 
     * @param base the base
     */
    public SelectTree(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

/*
    private String addPage(WebPage page, String selected, String lang, String separator)
    {
        String ret="<option value=\""+page.getURI()+"\" ";
        if(page.getURI().equals(selected))ret+="selected";
        ret+=">"+separator+page.getDisplayName(lang)+"</option>";

        if(separator.length()==0)separator=">";

        Iterator<WebPage> it=page.listVisibleChilds(lang);
        while(it.hasNext())
        {
            WebPage child=it.next();
            ret+=addPage(child,selected,lang,"--"+separator);
        }
        return ret;
    }
*/
    /**
 * Adds the object.
 * 
 * @param obj the obj
 * @param selected the selected
 * @param lang the lang
 * @param separator the separator
 * @return the string
 */
private String addObject(SemanticObject obj, String selected, String lang, String separator) {
        String ret = "<option value=\"" + obj.getURI() + "\" ";

        if (obj.getURI().equals(selected)) {
            ret += "selected";
        }

        ret += ">" + separator + obj.getDisplayName(lang) + "</option>";

        if (separator.length() == 0) {
            separator = ">";
        }

        Iterator<SemanticObject> it = obj.listHerarquicalChilds();

        while (it.hasNext()) {
            SemanticObject child = it.next();

            ret += addObject(child, selected, lang, "--" + separator);
        }

        return ret;
    }

    /* (non-Javadoc)
     * @see org.semanticwb.model.SelectOne#renderElement(javax.servlet.http.HttpServletRequest, org.semanticwb.platform.SemanticObject, org.semanticwb.platform.SemanticProperty, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type,
                                String mode, String lang) {
        if (obj == null) {
            obj = new SemanticObject();
        }

//        boolean IPHONE = false;
//        boolean XHTML  = false;
        boolean DOJO   = false;

//        if (type.equals("iphone")) {
//            IPHONE = true;
//        } else if (type.equals("xhtml")) {
//            XHTML = true;
//        } else
        if (type.equals("dojo")) {
            DOJO = true;
        }

        StringBuffer   ret          = new StringBuffer();
        String         name         = propName;
        String         label        = prop.getDisplayName(lang);
        SemanticObject sobj         = prop.getDisplayProperty();
        boolean        required     = prop.isRequired();
        String         pmsg         = null;
        String         imsg         = null;
        String         selectValues = null;
        boolean        disabled     = false;

        if (sobj != null) {
            DisplayProperty dobj = new DisplayProperty(sobj);

            pmsg         = dobj.getPromptMessage();
            imsg         = dobj.getInvalidMessage();
            selectValues = dobj.getDisplaySelectValues(lang);
            disabled     = dobj.isDisabled();
        }

        if (DOJO) {
            if (required && imsg == null) {
                imsg = label + " es requerido.";

                if (lang.equals("en")) {
                    imsg = label + " is required.";
                }
            }

            if (pmsg == null) {
                pmsg = "Captura " + label + ".";

                if (lang.equals("en")) {
                    pmsg = "Enter " + label + ".";
                }
            }
        }

        String ext = "";

        if (disabled) {
            ext += " disabled=\"disabled\"";
        }

        if (prop.isObjectProperty()) {
            SemanticObject val = null;
            String         aux = request.getParameter(propName);

            if (aux != null) {
                val = SemanticObject.createSemanticObject(aux);
            } else {
                val = obj.getObjectProperty(prop);
            }

            String uri   = "";
            String value = "";

            if (val != null) {
                uri   = val.getURI();
                value = obj.getDisplayName(lang);
            }

            if (mode.equals("edit") || mode.equals("create")) {
                ret.append("<select name=\"" + name + "\"");

                if (DOJO) {
                    ret.append(" dojoType=\"dijit.form.FilteringSelect\" autoComplete=\"true\" invalidMessage=\""
                               + imsg + "\"");
                }

                ret.append(" required=\"" + required + "\"");

                if (isBlankSuport() && ((uri == null) || (uri.length() == 0))) {
                    ret.append(" displayedvalue=\"\"");
                }

                ret.append(" " + ext + ">");

                // onChange="dojo.byId('oc1').value=arguments[0]"
                if (isBlankSuport()) {
                    ret.append("<option value=\"\"></option>");
                }

                SemanticClass            cls = prop.getRangeClass();
                Iterator<SemanticObject> it  = null;

                if (cls != WebPage.sclass) {
                    if (isGlobalScope()) {
                        if (cls != null) {
                            it = SWBComparator.sortSermanticObjects(lang, cls.listInstances());
                        } else {
                            it = SWBComparator.sortSermanticObjects(
                                lang,
                                SWBPlatform.getSemanticMgr().getVocabulary().listSemanticClassesAsSemanticObjects());
                        }
                    } else {
                        it = SWBComparator.sortSermanticObjects(lang, getModel().listInstancesOfClass(cls));
                    }

                    boolean hp = false;

                    if (cls != null) {
                        hp = cls.hasHerarquicalProperties();
                    }

                    // System.out.println("cls:"+cls+" hp:"+hp+" "+cls.hasHerarquicalProperties()+" "+cls.hasInverseHerarquicalProperties());
                    while (it.hasNext()) {
                        SemanticObject sob = it.next();
                        
                        boolean deleted=false;
                        if(sob.instanceOf(Trashable.swb_Trashable))
                        {
                            deleted=sob.getBooleanProperty(Trashable.swb_deleted);
                        }

                        if(!deleted)
                        {                        

                            if (hp) {
                                if (!sob.hasHerarquicalParents()) {
                                    ret.append(addObject(sob, uri, lang, ""));
                                }
                            } else {
                                ret.append("<option value=\"" + sob.getURI() + "\" ");

                                if (sob.getURI().equals(uri)) {
                                    ret.append("selected");
                                }

                                ret.append(">" + sob.getDisplayName(lang) + "</option>");
                            }
                        }
                    }
                } else {
                    WebSite site = SWBContext.getWebSite(getModel().getName());

                    if (site != null) {
                        WebPage home = site.getHomePage();

                        ret.append(addObject(home.getSemanticObject(), uri, lang, ""));
                    }
                }

                ret.append("</select>");
            } else if (mode.equals("view")) {
                ret.append("<span _id=\"" + name + "\" name=\"" + name + "\">" + value + "</span>");
            }
        } else {
            if (selectValues != null) {
                String value = request.getParameter(propName);

                if (value == null) {
                    value = obj.getProperty(prop);
                }

                ret.append("<select name=\"" + name + "\"");

                if (DOJO) {
                    ret.append(" dojoType=\"dijit.form.FilteringSelect\" autoComplete=\"true\" invalidMessage=\""
                               + imsg + "\"");
                }

                ret.append(" " + ext + ">");

                StringTokenizer st = new StringTokenizer(selectValues, "|");

                while (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    int    ind = tok.indexOf(':');
                    String id  = tok;
                    String val = tok;

                    if (ind > 0) {
                        id  = tok.substring(0, ind);
                        val = tok.substring(ind + 1);
                    }

                    ret.append("<option value=\"" + id + "\" ");

                    if (id.equals(value)) {
                        ret.append("selected");
                    }

                    ret.append(">" + val + "</option>");
                }

                ret.append("</select>");
            }
        }

        return ret.toString();
    }
}
