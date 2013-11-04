package org.semanticwb.social;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.model.Activeable;
import org.semanticwb.model.DisplayProperty;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.Trashable;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticLiteral;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;


   /**
   * SelectMultipleActives 
   */
public class SelectMultipleActives extends org.semanticwb.social.base.SelectMultipleActivesBase 
{
    public SelectMultipleActives(org.semanticwb.platform.SemanticObject base)
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
        System.out.println("Entra a SelectMultipleActives/process-1");
        // super.process(request, obj, prop);
        // System.out.println("Process...");
        // System.out.println("Prop:"+prop);
        // System.out.println("obj:"+obj);
        String vals[] = request.getParameterValues(propName);

        if (vals == null) {
            vals = new String[0];
        }

        obj.removeProperty(prop);

        if (prop.isObjectProperty()) {
            for (int x = 0; x < vals.length; x++) {
                obj.addObjectProperty(prop, SemanticObject.createSemanticObject(vals[x]));
            }
        } else {
            for (int x = 0; x < vals.length; x++) {
                obj.addLiteralProperty(prop, new SemanticLiteral(vals[x]));

                // System.out.println("val"+x+":"+vals[x]);
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
        System.out.println("Entra a SelectMultipleActives/renderElement-1");
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
            ArrayList<String> vals   = new ArrayList();
            String            auxs[] = request.getParameterValues(propName);

            if (auxs == null) {
                auxs = new String[0];
            }

            for (int x = 0; x < auxs.length; x++) {
                vals.add(auxs[x]);
            }

            Iterator<SemanticObject> it2 = obj.listObjectProperties(prop);

            while (it2.hasNext()) {
                SemanticObject semanticObject = it2.next();

                // System.out.println("semanticObject:"+semanticObject+" vals:"+vals);
                vals.add(semanticObject.getURI());
            }

            //String value = obj.getDisplayName(lang);

            if (mode.equals("edit") || mode.equals("create")) {
                ret.append("<select name=\"" + name + "\" multiple=\"true\"");
                ret.append(" style=\"width:300px;\"");

                if (DOJO) {
                    //ret.append(" dojoType=\"dijit.form.MultiSelect\" invalidMessage=\"" + imsg + "\"");
                }

                ret.append(" " + ext + ">");

                // onChange="dojo.byId('oc1').value=arguments[0]"
                SemanticClass            cls = prop.getRangeClass();
                Iterator<SemanticObject> it  = null;

                /*
                if (isGlobalScope()) {
                    if (cls != null) {
                        it = SWBComparator.sortSemanticObjects(lang, cls.listInstances());
                    } else {
                        it = SWBComparator.sortSemanticObjects(lang,
                                SWBPlatform.getSemanticMgr().getVocabulary().listSemanticClassesAsSemanticObjects());
                    }
                } else {
                * */
                    it = SWBComparator.sortSemanticObjects(lang, getModel().listInstancesOfClass(cls));
                //}

                while (it.hasNext()) {
                    SemanticObject sob = it.next();
                    boolean deleted=false;
                    boolean active=false;
                    if(sob.instanceOf(Trashable.swb_Trashable))
                    {
                        deleted=sob.getBooleanProperty(Trashable.swb_deleted);
                    }
                    if(sob.instanceOf(Activeable.swb_Activeable))
                    {
                        active=sob.getBooleanProperty(Activeable.swb_active);
                    }

                    if(!deleted && active)
                    {                    

                        if (sob.getURI() != null) {
                            ret.append("<option value=\"" + sob.getURI() + "\" ");

                            if (vals.contains(sob.getURI())) {
                                ret.append("selected=\"selected\"");
                            }

                            ret.append(">" + sob.getDisplayName(lang) + "</option>");
                        }
                    }
                }

                ret.append("</select>");
            } else if (mode.equals("view")) {
                ret.append("<select name=\"" + name + "\" multiple=\"true\"");
                ret.append(" style=\"width:300px;\"");

                if (DOJO) {
                    //ret.append(" dojoType=\"dijit.form.MultiSelect\" invalidMessage=\"" + imsg + "\"");
                }

                ret.append(" disabled=\"disabled\">");

                // onChange="dojo.byId('oc1').value=arguments[0]"
                SemanticClass            cls = prop.getRangeClass();
                Iterator<SemanticObject> it  = null;
                
                /*
                if (isGlobalScope()) {
                    if (cls != null) {
                        it = SWBComparator.sortSemanticObjects(lang, cls.listInstances());
                    } else {
                        it = SWBComparator.sortSemanticObjects(lang,
                        SWBPlatform.getSemanticMgr().getVocabulary().listSemanticClassesAsSemanticObjects());
                    }
                } else {*/
                    it = SWBComparator.sortSemanticObjects(lang, getModel().listInstancesOfClass(cls));
                //}

                while (it.hasNext()) {
                    SemanticObject sob = it.next();
                    boolean deleted=false;
                    boolean active=false;
                    if(sob.instanceOf(Trashable.swb_Trashable))
                    {
                        deleted=sob.getBooleanProperty(Trashable.swb_deleted);
                    }
                    if(sob.instanceOf(Activeable.swb_Activeable))
                    {
                        active=sob.getBooleanProperty(Activeable.swb_active);
                    }

                    if(!deleted && active)
                    {                    
                        if (sob.getURI() != null) {
                            if (vals.contains(sob.getURI())) {
                                ret.append("<option value=\"" + sob.getURI() + "\" ");
                                ret.append(">" + sob.getDisplayName(lang) + "</option>");
                            }
                        }
                    }
                }
                ret.append("</select>");
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