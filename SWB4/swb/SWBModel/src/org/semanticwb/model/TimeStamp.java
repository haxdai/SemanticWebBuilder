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

//~--- non-JDK imports --------------------------------------------------------

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

//~--- JDK imports ------------------------------------------------------------

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class TimeStamp.
 */
public class TimeStamp extends org.semanticwb.model.base.TimeStampBase {
    
    /** The log. */
    private static Logger log = SWBUtils.getLogger(TimeStamp.class);

    /**
     * Instantiates a new time stamp.
     * 
     * @param base the base
     */
    public TimeStamp(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    /* (non-Javadoc)
     * @see org.semanticwb.model.base.FormElementBase#renderElement(javax.servlet.http.HttpServletRequest, org.semanticwb.platform.SemanticObject, org.semanticwb.platform.SemanticProperty, java.lang.String, java.lang.String, java.lang.String)
     */
    /**
     * Render element.
     * 
     * @param request the request
     * @param obj the obj
     * @param prop the prop
     * @param type the type
     * @param mode the mode
     * @param lang the lang
     * @return the string
     */
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type,
                                String mode, String lang) {
        boolean DOJO   = false;
        if (obj == null) {
            obj = new SemanticObject();
        }

        if ("dojo".equals(type)) {
            DOJO = true;
        }

        StringBuilder ret   = new StringBuilder();
        String       name  = propName;
        //String       label = prop.getDisplayName(lang);
        Date         ndate = new Date();
        Date         date  = null;

        if (prop.isDateTime()) {
            date = obj.getDateTimeProperty(prop);
        }

        if (date != null) {
            ndate = date;
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("'T'HH:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String value = ndate.toString();

        if ("edit".equals(mode) || "create".equals(mode)) {
            ret.append("<input name=\"").append(name).append("_date\" ");
            if (DOJO) {
                ret.append("dojoType=\"dijit.form.DateTextBox\" ");
            }
            ret.append("value=\"").append(dateFormat.format(ndate)).append("\" />");
            ret.append("<input name=\"").append(name).append("_time\" ");
            if (DOJO) {
                ret.append("dojoType=\"dijit.form.TimeTextBox\" ");
            }
            ret.append("value=\"").append(timeFormat.format(ndate)).append("\" />");
        } else if (mode.equals("view")) {
            ret.append("<span name=\"").append(name).append("\">").append(value).append("</span>");
        }
//        if (mode.equals("edit") || mode.equals("create")) {
//            ret.append("<span name=\"" + name + "\">" + value + "</span>");
//
//            if (date != null) {
//                ret.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + date.getTime() + "\">");
//            }
//        } else if (mode.equals("view")) {
//            ret.append("<span name=\"" + name + "\">" + value + "</span>");
//        }
        return ret.toString();
    }
}
