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
 


package org.semanticwb.portal.admin.admresources.util.JSValidations;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.admin.admresources.lib.WBJsValidationsFEAbs;

/**
 * Objeto que valida si un campo es de tipo alphabetico con JavaScript en la apiadmin
 * <p>
 * Object that handles if a field is of type alphabetic with JavaScript in the apiadmin
 * @author  Jorge Alberto Jim�nez
 */

public class Js_AlphabeticValFE extends WBJsValidationsFEAbs
{
    private static Logger log = SWBUtils.getLogger(Js_AlphabeticValFE.class);
    
    public Js_AlphabeticValFE(String field, int minsize)
    {
        this.field = field;
        if(minsize > 1){
            this.minsize = minsize;
        }
    }

    public Js_AlphabeticValFE(String formfeName, String field, int minsize)
    {
        this.formfeName = formfeName;
        this.field = field;
        if(minsize > 1){
            this.minsize = minsize;
        }
    }

    /**
    * Obtiene el html(xml) final del elemento para mostrar en la admin del recurso
    * obtains the final xml element to show in the resource admin
    */   
    public String getHtml(java.util.Locale locale)
    {
        StringBuffer strb = new StringBuffer();
        if(field != null)
        {
            String bundle=getClass().getName();
            strb.append("\n   pCaracter=");
           // if(formfeName != null) {
           //     strb.append("document."+formfeName + ".");
           // }
            //strb.append(field + ".value");
            strb.append("document.getElementById(\""+field+"\").value;");
            strb.append("\n   var valid = \"ABCDEFGHIJKLMN\321OPQRSTUVWXYZ\301\311\315\323\332abcdefghijklmn\361opqrstuvwxyz\341\351\355\363\372 \";");
            strb.append("\n   var ok = true;");
            strb.append("\n for (i = 0; i < pCaracter.length; i++) { ");
            strb.append("\n ch = pCaracter.charAt(i); ");
            strb.append("\n for (j = 0; j < valid.length; j++) ");
            strb.append("\n if (ch == valid.charAt(j)) ");
            strb.append("\n break; ");
            strb.append("\n if (j == valid.length) { ");
            strb.append("\n ok = false; ");
            strb.append("\n break; ");
            strb.append("\n } ");
            strb.append("\n } ");
            strb.append("\n if (!ok || pCaracter.length<" + minsize + ") { ");
            strb.append("\n alert('"+ SWBUtils.TEXT.getLocaleString(bundle, "msgDataRequired", locale) +" ");
            strb.append(minsize);
            strb.append(" "+  SWBUtils.TEXT.getLocaleString(bundle, "msgCharacters", locale) +"'); ");
            //if(formfeName != null) {
            //    strb.append("\n     " + "document."+formfeName + ".");
            //}
            //strb.append(field + ".focus();");
            strb.append("document.getElementById(\""+field+"\").focus();");
            strb.append("\n     return false;");
            strb.append("\n } ");
        }
        return strb.toString();
    }
}
