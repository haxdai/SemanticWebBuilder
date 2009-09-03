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

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.SWBPlatform;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

public class FileUpload extends org.semanticwb.model.base.FileUploadBase {

    public FileUpload(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String type, String mode, String lang) {
        if (obj == null) {
            obj = new SemanticObject();
        }
        String ret = "";

        if (type.endsWith("iphone")) {
            ret = renderIphone(request, obj, prop, type, mode, lang);
        } else {
            ret = renderXHTML(request, obj, prop, type, mode, lang);
        }
        return ret;
    }

    public String renderIphone(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String type, String mode, String lang) {
        return "";
    }

    public String renderXHTML(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String type, String mode, String lang) {
        //boolean DOJO=false;
        //if(type.equals("dojo"))DOJO=true;
        String ret = "";
        String name = prop.getName();
        String label = prop.getDisplayName(lang);
        SemanticObject sobj = prop.getDisplayProperty();
        boolean required = prop.isRequired();
        String pmsg = null;
        String imsg = null;
        if (sobj != null) {
            DisplayProperty dobj = new DisplayProperty(sobj);
            pmsg = dobj.getPromptMessage();
            imsg = dobj.getInvalidMessage();
        }

        if (imsg == null) {
            if (required) {
                imsg = label + " es requerido.";
                if (lang.equals("en")) {
                    imsg = label + " is required.";
                }
            }
        }

        if (pmsg == null) {
            pmsg = "Captura " + label + ".";
            if (lang.equals("en")) {
                pmsg = "Enter " + label + ".";
            }
        }

        String value = obj.getProperty(prop);
        if (value == null) {
            value = "";
        }
        if (mode.equals("edit") || mode.equals("create")) {
            String attchMsg="";
            if(request.getAttribute("attachCount")!=null &&  request.getAttribute("elementId")!=null && name!=null && request.getAttribute("elementId").equals(name)){
                        attchMsg="Archivo(s) existentes:<br/>";
                        int count=Integer.parseInt((String)request.getAttribute("attachCount"));
                        for(int i=1;i<=count;i++){
                            String fileName=(String)request.getAttribute("attach_"+i);
                            int pos=fileName.lastIndexOf("/");
                            if(pos>-1){
                                fileName=fileName.substring(pos+1);
                            }
                            String target="";
                            if(request.getAttribute("attachTarget_"+i)!=null){
                                target=(String)request.getAttribute("attachTarget_"+i);
                            }

                            if(request.getAttribute("attachRemovePath_"+i)!=null){
                                attchMsg+="<a href=\""+request.getAttribute("attachRemovePath_"+i)+"\">X</a> ";
                            }
                            attchMsg+=i+")<a href=\""+ request.getAttribute("attach_"+i) +"\" target=\""+target+"\">"+fileName+"</a>";
                            attchMsg+="<br/>";
                        }
            }
            String formName=(String)request.getAttribute("formName");
            //Página ejemplo de implementación:http://blog.tremend.ro/2007/03/01/ajax-file-upload-monitoring-monitor-your-file-upload-with-dwr-and-commons-fileupload/
            //Fecha de implemetación:26/Febrero/2009
            //TODO:Haecer que este Bloque solo sea puesto una vez, independientemente de cuantos fileuploads tiene mi forma
            ret = "<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\""+SWBPlatform.getContextPath()+"/swbadmin/css/upload/upload.css\"/>\n"+
                  "<script type='text/javascript' src=\""+SWBPlatform.getContextPath()+"/dwr/util.js\"></script>\n"+
                  "<script type='text/javascript' src=\""+SWBPlatform.getContextPath()+"/dwr/engine.js\"></script>\n"+
                  "<script type=\"text/javascript\" src=\""+SWBPlatform.getContextPath()+"/dwr/interface/uploadProxy.js\"></script>\n"+
                  "<script type='text/javascript' src=\""+SWBPlatform.getContextPath()+"/swbadmin/js/upload/upload.js\"></script>\n";
                  //TODO:Haecer que esta linea solo sea puesta una vez, independientemente de cuantos fileuploads tiene mi forma
            ret += "<iframe id='target_upload_"+name+"' name='target_upload_"+name+"' src='' style='display: none'></iframe><br/>" +  //
                    attchMsg+
                    "<input id=\""+name+"\" name=\""+name+"\" type=\"file\" onChange=\"javascript:if(uploadjs_"+name+"(document.getElementById('"+formName+"'))) {return startUploadMonitoring('"+name+"');}\"> <br/>" +
                    "<div id=\"uploadStatus_"+name+"\" style=\"width:230px\">\n" +
                    "   <div id=\"uploadProgressBar_"+name+"\" style=\"width:200px; height: 2px; border: 0px solid #BBB; text-align: center; float: left;\">\n" +
                    "       <div id=\"uploadIndicator_"+name+"\" style=\" height: 1px; position: relative; margin: 0px; padding: 1px; background: #9DC0F4; width: 0; float: left;\"></div>\n" +
                    "   </div>\n" +
                    "   <div id=\"uploadPercentage_"+name+"\" style=\"width:5px; float: right;\"></div>\n" +
                    "</div>\n";

            ret += "<script type=\"text/javascript\">\n" +
                    "function uploadjs_"+name+"(forma){\n" +
                    "if(forma."+name+".value==''){alert('El campo archivo no debe estar vacio');forma."+name+".focus(); return false;}" +  //TODO:Internacionalizar
                    "  var encoding=forma.encoding;\n" +
                    "  forma.encoding='multipart/form-data';\n" +
                    "  var method=forma.method;\n" +
                    "  forma.method='post';\n" +
                    "  var action=forma.action;\n" +
                    "  forma.action='"+SWBPlatform.getContextPath()+"/Upload';\n" +
                    "  var target=forma.target;\n" +
                    "  forma.target='target_upload_"+name+"';\n" +
                    "  forma.submit();\n" +
                    "  forma.encoding=encoding;\n" +
                    "  forma.method=method;\n" +
                    "  forma.action=action;\n" +
                    "  forma.target=target;\n" +
                    "  return true;\n" +
                    "}\n" +
                    "</script>\n";
        } else if (mode.equals("view")) {
            ret = "<span _id=\"" + name + "\" name=\"" + name + "\">" + value + "</span>";
        }

        return ret;
    }
}