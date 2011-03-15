package org.semanticwb.cptm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.SWBPlatform;
import org.semanticwb.model.DisplayProperty;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticLiteral;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;


   /**
   * Select Multiple2 
   */
public class SelectMultiple2 extends org.semanticwb.cptm.base.SelectMultiple2Base 
{
    public SelectMultiple2(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

     /* (non-Javadoc)
     * @see org.semanticwb.model.base.FormElementBase#process(javax.servlet.http.HttpServletRequest, org.semanticwb.platform.SemanticObject, org.semanticwb.platform.SemanticProperty)
     */
    /**
     * Process.
     *
     * @param request the request
     * @param obj the obj
     * @param prop the prop
     */
    @Override
    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName) {
    
            //String vals[] = request.getParameterValues(propName);

            String val=request.getParameter(propName);

           //System.out.println("vals:"+val);

            obj.removeProperty(prop);

            if(val!=null && val.trim().length()>0)
            {
                if (prop.isObjectProperty()) {
                    StringTokenizer strTokens=new StringTokenizer(val, ",");
                    while(strTokens.hasMoreElements()){
                        String token=(String)strTokens.nextElement();
                        if(token==null || token.trim().length()>0)
                        {
                            SemanticObject semObj=SemanticObject.createSemanticObject(token.trim());
                            if(semObj!=null){
                                obj.addObjectProperty(prop, semObj);
                            }
                        }
                    }
                } else {
                    StringTokenizer strTokens=new StringTokenizer(val, ",");
                    while(strTokens.hasMoreElements()){
                        String token=(String)strTokens.nextElement();
                        if(token==null || token.trim().length()>0)
                        {
                           SemanticLiteral semLiteral=new SemanticLiteral(token.trim());
                           if(semLiteral!=null){
                                obj.addLiteralProperty(prop, semLiteral);
                           }
                        }
                    }
                }
            }
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
        if (obj == null) {
            obj = new SemanticObject();
        }

////        boolean IPHONE = false;
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
        HashMap        <String, SemanticObject> mapVals=new HashMap();
        String sobjShortUri=obj.getShortURI();

        if (sobj != null) {
            DisplayProperty dobj = new DisplayProperty(sobj);

            pmsg         = dobj.getPromptMessage();
            imsg         = dobj.getInvalidMessage();
            selectValues = dobj.getDisplaySelectValues(lang);
            disabled     = dobj.isDisabled();
        }

        if (DOJO) {
            if (imsg == null) {
                if (required) {
                    imsg = label + " es requerido.";

                    if (lang.equals("en")) {
                        imsg = label + " is required.";
                    }
                } else {
                    imsg = "Dato invalido.";

                    if (lang.equals("en")) {
                        imsg = "Invalid data.";
                    }
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
            //ArrayList<String> vals   = new ArrayList();
            String            auxs[] = request.getParameterValues(propName);

            if (auxs == null) {
                auxs = new String[0];
            }

            for (int x = 0; x < auxs.length; x++) {
                mapVals.put(auxs[x],null);
            }

            Iterator<SemanticObject> it2 = obj.listObjectProperties(prop);

            while (it2.hasNext()) {
                SemanticObject semanticObject = it2.next();
                mapVals.put(semanticObject.getURI(), semanticObject);                
            }
            String value = obj.getDisplayName(lang);

            if (mode.equals("edit") || mode.equals("create")) {

                ret.append("<select name=\"" + name +"_"+ sobjShortUri + "_propiedades\" id=\""+name+"_"+sobjShortUri+"_propiedades\" multiple=\"true\"");
                ret.append(" style=\"width:300px;height:300px;\"");

                if (DOJO) {
                    //ret.append(" dojoType=\"dijit.form.MultiSelect\" invalidMessage=\"" + imsg + "\"");
                }

                ret.append(" " + ext + ">");

                // onChange="dojo.byId('oc1').value=arguments[0]"
                SemanticClass            cls = prop.getRangeClass();
                Iterator<SemanticObject> it  = null;

                if (isGlobalScope()) {
                    if (cls != null) {
                        it = SWBComparator.sortSermanticObjects(lang, cls.listInstances());
                    } else {
                        it = SWBComparator.sortSermanticObjects(lang,
                                SWBPlatform.getSemanticMgr().getVocabulary().listSemanticClassesAsSemanticObjects());
                    }
                } else {
                    it = SWBComparator.sortSermanticObjects(lang, getModel().listInstancesOfClass(cls));
                }

                while (it.hasNext()) {
                    SemanticObject sob = it.next();
                    if (mapVals.keySet().contains(sob.getURI())) {
                        continue;
                    }

                    if (sob.getURI() != null) {
                        ret.append("<option value=\"" + sob.getURI() + "\" ");
                        /*
                        if (vals.contains(sob.getURI())) {
                            ret.append("selected=\"selected\"");
                        }*/

                        ret.append(">" + sob.getDisplayName(lang) + "</option>");
                    }
                }
                ret.append("</select>");

                String propBox=name+"_"+sobjShortUri+"_propiedades";
                String propBoxTmp=name+"_"+sobjShortUri+"_tmp";
                //String propBoxTmp=name;

                ret.append("<button dojoType=\"dijit.form.Button\" type = \"button\" style=\"width: 25px;\" id = \"" + name + "_"+sobjShortUri+"_btnMoveLeft\"  >"
                + "<script type=\"dojo/connect\" event=\"onClick\">"
                +   "var self=this; "
                +   " var varFromBox = document.getElementById(\""+propBoxTmp+"\"); "
                +   " var varToBox = document.getElementById(\""+propBox+"\"); "
                +   " var varHidden = document.getElementById(\""+name+"_"+sobjShortUri+"\"); "
                +   " if ((varFromBox != null) && (varToBox != null))  "
                +   " {  "
                +   "   if(varFromBox.length < 1)  "
                +   "    { "
                +   "        return false; "
                +   "    } "
                +   "    if(varFromBox.options.selectedIndex == -1) "
                +   "    { "
                +   "        return false; "
                +   "    } "
                +   "    var cont=0;"
                +   "   while ( varFromBox.options.selectedIndex >= 0 )  "
                +   "    {  "
                +   "        var newOption = new Option(); " // crea una opcion en el select
                +   "        newOption.text = varFromBox.options[varFromBox.options.selectedIndex].text;  "
                +   "        newOption.value = varFromBox.options[varFromBox.options.selectedIndex].value;  "
                +   "        varToBox.options[varToBox.length] = newOption; " //agrega la opción al final del select destino
                +   "        varFromBox.remove(varFromBox.options.selectedIndex); " //quita la opción del select origen
                +   "    }  "
                +   "    if(varFromBox.options.length==0) {varHidden.value='';}"
                +   "    for (var i=0; i<varFromBox.options.length; i++){"
                +   "             varFromBox.options[i].selected=true;"
                +   "             if(i==0) {"
                +   "               varHidden.value=varFromBox.options[i].value;"
                +   "             }else {varHidden.value=varHidden.value+','+varFromBox.options[i].value;}"
                +   "     } "
                +   "  } "
                + "</script>"
                + " << </button>");
                ret.append("&nbsp;&nbsp;&nbsp;");
                ret.append("<button dojoType=\"dijit.form.Button\" type = \"button\" style=\"width: 25px;\" id = \"" + name + "_"+sobjShortUri+"_btnMoveRight\" >"
                + "<script type=\"dojo/connect\" event=\"onClick\">"
                +   "var self=this; "
                +   " var varFromBox = document.getElementById(\""+propBox+"\"); "
                +   " var varToBox = document.getElementById(\""+propBoxTmp+"\"); "
                +   " var varHidden = document.getElementById(\""+name+"_"+sobjShortUri+"\"); "
                +   " if ((varFromBox != null) && (varToBox != null))  "
                +   " {  "
                +   "   if(varFromBox.length < 1)  "
                +   "    { "
                +   "        return false; "
                +   "    } "
                +   "    if(varFromBox.options.selectedIndex == -1) "
                +   "    { "
                +   "        return false; "
                +   "    } "
                +   "   while ( varFromBox.options.selectedIndex >= 0 )  "
                +   "    {  "
                +   "        var newOption = new Option(); " // crea una opcion en el select
                +   "        newOption.text = varFromBox.options[varFromBox.options.selectedIndex].text;  "
                +   "        newOption.value = varFromBox.options[varFromBox.options.selectedIndex].value;  "
                +   "        varToBox.options[varToBox.length] = newOption; " //agrega la opción al final del select destino
                +   "        varFromBox.remove(varFromBox.options.selectedIndex); " //quita la opción del select origen
                +   "    }  "
                +   "    for (var i=0; i<varToBox.options.length; i++){"
                +   "             varToBox.options[i].selected=true;"
                +   "             if(i==0) {"
                +   "               varHidden.value=varToBox.options[i].value;"
                +   "             }else {varHidden.value=varHidden.value+','+varToBox.options[i].value;}"
                +   "     } "
                +   " } "
                + "</script>"
                + " >> </button>");
                ret.append("&nbsp;&nbsp;&nbsp;");

                ret.append("<select size=\"10\" name=\"" + propBoxTmp + "\" id=\"" + propBoxTmp + "\" multiple=\"true\" style=\"width:300px;height:300px;\">");

                int cont=0;
                String valHidden="";
                Iterator <String> itVals=mapVals.keySet().iterator();
                while(itVals.hasNext()){
                    String sValUri=itVals.next();
                    SemanticObject sob = mapVals.get(sValUri);
                    if (sob!=null && sob.getURI() != null) {
                        if(cont==0)valHidden+=sob.getURI();
                        else valHidden+=","+sob.getURI();
                        ret.append("<option value=\"" + sob.getURI() + "\" ");
                        ret.append(">" + sob.getDisplayName(lang) + "</option>");
                        cont++;
                    }
                }
                ret.append("</select>");
                
                ret.append("<input type=\"hidden\" name=\""+name+"\" id=\""+name+"_"+sobjShortUri+"\" value=\""+valHidden+"\" />");


            } else if (mode.equals("view")) {
                ret.append("<span _id=\"" + name + "\" name=\"" + name + "\">" + value + "</span>");
            }
        } else {
            if (selectValues != null) {
                ArrayList<String> vals   = new ArrayList();
                String            auxs[] = request.getParameterValues(propName);

                if (auxs == null) {
                    auxs = new String[0];
                }

                for (int x = 0; x < auxs.length; x++) {
                    vals.add(auxs[x]);
                }

                Iterator<SemanticLiteral> it2 = obj.listLiteralProperties(prop);

                while (it2.hasNext()) {
                    SemanticLiteral lit = it2.next();

                    vals.add(lit.getString());
                }

                ret.append("<select name=\"" + name + "\" multiple=\"true\"");

                if (DOJO) {
                    //ret.append(" dojoType=\"dijit.form.MultiSelect\" invalidMessage=\"" + imsg + "\"");
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

                    if (vals.contains(id)) {
                        ret.append("selected=\"selected\"");
                    }

                    ret.append(">" + val + "</option>");
                }

                ret.append("</select>");

            }
        }       

        return ret.toString();
    }
}
