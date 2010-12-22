/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.process.resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.DisplayProperty;
import org.semanticwb.model.FormElement;
import org.semanticwb.model.GenericFormElement;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.platform.SemanticVocabulary;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.SWBForms;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBParameters;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.process.forms.SWBFormMgrLayer;
import org.semanticwb.process.model.FlowNodeInstance;
import org.semanticwb.process.model.Instance;
import org.semanticwb.process.model.ProcessObject;
import org.semanticwb.process.model.SWBProcessFormMgr;
import org.semanticwb.process.model.UserTask;

/**
 *
 * @author javier.solis
 */
public class ProcessForm extends GenericResource {

    /** The log. */
    private Logger log = SWBUtils.getLogger(ProcessForm.class);
    private HashMap<String, SemanticObject> hmFormEle = null;
    static final String ADMINMODE_SIMPLE = "simple";
    static final String ADMINMODE_ADVANCE = "advance";
    static final String FE_MODE_VIEW = "view";
    static final String FE_MODE_EDIT = "edit";
    static final String FE_DEFAULT = "generico";


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String lang = paramRequest.getUser().getLanguage();

        StringBuilder ret = new StringBuilder("");
        User user = paramRequest.getUser();

        Resource base = getResourceBase();

        String adminMode = base.getAttribute("adminMode", ADMINMODE_SIMPLE);

        String action = paramRequest.getAction();

        String suri = request.getParameter("suri");
        if (suri == null) {
            out.println("Parámetro no difinido...");
            return;
        }

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        FlowNodeInstance foi = (FlowNodeInstance) ont.getGenericObject(suri);

        SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
        mgr.setAction(paramRequest.getActionUrl().setAction("process").toString());
        mgr.clearProperties();



        HashMap<String, SemanticClass> hmclass = new HashMap<String, SemanticClass>();
        HashMap<String, SemanticProperty> hmprops = new HashMap<String, SemanticProperty>();
        Iterator<ProcessObject> it = foi.listHeraquicalProcessObjects().iterator();
        while (it.hasNext()) {
            ProcessObject obj = it.next();
            SemanticClass cls = obj.getSemanticObject().getSemanticClass();

            hmclass.put(cls.getClassId(), cls);

            Iterator<SemanticProperty> itp = cls.listProperties();
            while (itp.hasNext()) {
                SemanticProperty prop = itp.next();
                hmprops.put(prop.getPropId(), prop);
            }
        }


        if (ADMINMODE_SIMPLE.equals(adminMode)) {

            out.println(SWBForms.DOJO_REQUIRED);

            SWBResourceURL urlact = paramRequest.getActionUrl();
            urlact.setAction("process");

            out.println("<form id=\"" + foi.getId() + "/form\" dojoType=\"dijit.form.Form\" class=\"swbform\" action=\"" + urlact + "\" method=\"post\">");
            out.println("<input type=\"hidden\" name=\"suri\" value=\"" + suri + "\"/>");
            out.println("<input type=\"hidden\" name=\"smode\" value=\"edit\"/>");
            out.println("<fieldset>");
            out.println("<legend>Datos Generales</legend>");
            out.println("<table>");


            int max = 1;
            while (!base.getAttribute("prop" + max, "").equals("")) {

                String val = base.getAttribute("prop" + max);
                String classid = "";
                String propid = "";
                String modo = "";
                String fe = "";
                StringTokenizer stoken = new StringTokenizer(val, "|");
                if (stoken.hasMoreTokens()) {
                    classid = stoken.nextToken();
                    propid = stoken.nextToken();
                    modo = stoken.nextToken();
                    fe = stoken.nextToken();
                }

                SemanticProperty semprop = hmprops.get(propid);

                String strMode = "";

                SemanticClass semclass = hmclass.get(classid);

                if (semclass != null && semprop != null) {
                    if (modo.equals(FE_MODE_VIEW)) {
                        mgr.addProperty(semprop, semclass, SWBFormMgr.MODE_VIEW);
                        strMode = SWBFormMgr.MODE_VIEW;
                    } else if (modo.equals(FE_MODE_EDIT)) {
                        mgr.addProperty(semprop, semclass, SWBFormMgr.MODE_EDIT);
                        strMode = SWBFormMgr.MODE_VIEW;
                    }

                    SemanticObject sofe = ont.getSemanticObject(fe);

                    SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);

                    out.println("<tr><td width=\"200px\" align=\"right\"><label for=\"title\">" + fmgr.renderLabel(request, semprop, modo) + "</label></td>");
                    out.println("<td>");
                    if (null != sofe) {
                        FormElement frme = (FormElement) sofe.createGenericInstance();
                        out.println(fmgr.renderElement(request, semclass, semprop, frme, modo));
                    } else {
                        //FormElement frme = new GenericFormElement();
                        out.println(fmgr.renderElement(request, semclass, semprop, modo));
                    }
                    out.println("</td></tr>");
                }
                max++;
            }

            out.println("    </table>");
            out.println("</fieldset>");
            out.println("<fieldset><span align=\"center\">");
            out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\">Guardar</button>");

            out.println("<button dojoType=\"dijit.form.Button\" name=\"accept\" type=\"submit\">Concluir Tarea</button>");
            out.println("<button dojoType=\"dijit.form.Button\" name=\"reject\" type=\"submit\">Rechazar Tarea</button>");
            out.println("<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + foi.getProcessWebPage().getUrl() + "?suri=" + suri + "'\">Regresar</button>");
            out.println("</span></fieldset>");
            out.println("</form>");

        } else if (ADMINMODE_ADVANCE.equals(adminMode)) {
            if (action.equals("add") || action.equals("edit")) {
                String basepath = SWBPortal.getWorkPath() + base.getWorkPath() + "/";
                String xml = SWBUtils.IO.getFileFromPath(basepath+"code.xml");
                if(null==xml)  xml=base.getXmlConf(); //getFormHTML(request, null);
                if (xml != null && xml.trim().length() > 0) {
                    SWBFormMgrLayer swbFormMgrLayer = new SWBFormMgrLayer(xml, paramRequest, request);
                    String html = swbFormMgrLayer.getHtml();
                    ret.append(html);
                }
            }
            out.println(ret.toString());
        }
    }

    public String getFormHTML(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        StringBuilder ret = new StringBuilder();

        Resource base = getResourceBase();

        User user = response.getUser();

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        UserTask ut = (UserTask) base.getResourceable();


        FlowNodeInstance foi = ut.getFlowObjectInstance();

        HashMap<String, SemanticClass> hmclass = new HashMap<String, SemanticClass>();
        HashMap<String, SemanticProperty> hmprops = new HashMap<String, SemanticProperty>();
        Iterator<ProcessObject> it = foi.listHeraquicalProcessObjects().iterator();
        while (it.hasNext()) {
            ProcessObject obj = it.next();
            SemanticClass cls = obj.getSemanticObject().getSemanticClass();

            hmclass.put(cls.getClassId(), cls);

            Iterator<SemanticProperty> itp = cls.listProperties();
            while (itp.hasNext()) {
                SemanticProperty prop = itp.next();
                hmprops.put(prop.getPropId(), prop);
            }
        }

        ret.append("<form");

        if(request.getParameter("useDojo")!=null&&request.getParameter("useDojo").equals("dojo"))
        {
            ret.append(" htmlType=\"dojo\" ");
        }
        ret.append(">");
        
        ret.append("\n<table>");
        ret.append("\n  <tr><td colspan=\"2\" align=\"center\">" + foi.getProcessWebPage().getDisplayName(user.getLanguage()) + "</td></tr>");
        ret.append("\n  <tr><td>");
        ret.append("\n    <fieldset>");
        //ret.append("<legend>Grupo de Elementos</legend>");
        ret.append("\n      <table>");

        int max = 1;
        while (!base.getAttribute("prop" + max, "").equals("")) {

            String val = base.getAttribute("prop" + max);
            String classid = "";
            String propid = "";
            String modo = "";
            String fe = "";
            StringTokenizer stoken = new StringTokenizer(val, "|");
            if (stoken.hasMoreTokens()) {
                classid = stoken.nextToken();
                propid = stoken.nextToken();
                modo = stoken.nextToken();
                fe = stoken.nextToken();
            }

            SemanticProperty semprop = hmprops.get(propid);

            //System.out.println("Class: "+classid);

            String strMode = "";

            SemanticClass semclass = hmclass.get(classid);

            if (semclass != null && semprop != null) {
                if (modo.equals(FE_MODE_VIEW)) {
                    strMode = SWBFormMgr.MODE_VIEW;
                } else if (modo.equals(FE_MODE_EDIT)) {
                    strMode = SWBFormMgr.MODE_EDIT;
                }
                SemanticObject sofe = ont.getSemanticObject(fe);
                String strFE ="";
                SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
                FormElement frme = null;
                if (null != sofe) {
                    frme = (FormElement) sofe.createGenericInstance();
                    //strFE=sofe.getDisplayName(response.getUser().getLanguage());
                    strFE="formElement=\"" + sofe.getDisplayName(response.getUser().getLanguage()) + "\"";
                    //ret.append(fmgr.renderElement(request, semclass, semprop, frme, modo));
                } else {
                    frme = new GenericFormElement();
                    //strFE=FE_DEFAULT;
                    //ret.append(fmgr.renderElement(request, semclass, semprop, frme, modo));
                }

                ret.append("\n     <tr>");
                ret.append("\n       <td><label class=\"" + classid + "\" prop=\"" + semprop.getName() + "\" prueba=\"\" /></td>");
                ret.append("\n       <td><property class=\"" + classid + "\" prop=\"" + semprop.getName() + "\" prueba1=\"\" " + strFE + " Mode=\"" + strMode + "\" /></td>");
                ret.append("\n    </tr>");
            }
            max++;
        }

        ret.append("\n      </table> ");
        ret.append("\n     </fieldset> ");
        ret.append("\n    </td>");
        ret.append("\n   </tr> ");
        ret.append("\n   <tr> ");
        ret.append("\n    <td colspan=\"2\" align=\"center\">");
        ret.append("\n      <fieldset>");
        //ret.append("<legend>Botones</legend>");

        // validar que botones seleccionaron

        if(request.getParameter("btnSave") != null) ret.append("\n          <Button type=\"savebtn\"/>");
        if(request.getParameter("btnAccept")!=null) ret.append("\n          <Button type=\"submit\" name=\"accept\" title=\"Concluir Tarea\" isBusyButton=\"true\" />");
        if(request.getParameter("btnReject")!=null) ret.append("\n          <Button isBusyButton=\"true\" name=\"reject\" title=\"Rechazar Tarea\" type=\"submit\" />");
        if(request.getParameter("btnCancel")!=null) ret.append("\n          <Button type=\"cancelbtn\"/>");


        ret.append("\n      </fieldset>");
        ret.append("\n     </td>");
        ret.append("\n   </tr>");
        ret.append("\n </table>");
        ret.append("\n</form>");

        return ret.toString();
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
//        SemanticVocabulary voc = SWBPlatform.getSemanticMgr().getVocabulary();

        //System.out.println("Action: " + response.getAction());

        UserTask ut = null;
        String suri = request.getParameter("suri");
        //System.out.println("SURI: " + suri);
        FlowNodeInstance foi = null;

        if ("updAdminMode".equals(response.getAction())) {

            base.setAttribute("adminMode", request.getParameter("adminMode"));
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
            }

            if (request.getParameter("suri") != null) {
                response.setRenderParameter("suri", suri);
            }

        } else if( "updXMLConfig".equals(response.getAction())) {
//            try {
//                String xml = getFormHTML(request, response);
//                if(xml!=null)
//                {
//                    base.setXmlConf(xml);
//                    base.updateAttributesToDB();
//                }
//            } catch (Exception e) { log.error("Error al generar la Forma XML",e);
//            }

            String basepath = SWBPortal.getWorkPath() + base.getWorkPath() + "/";
            File xmlFile = new File(basepath);
            if (!xmlFile.exists()) {
                xmlFile.mkdirs();
            }

            if (xmlFile.exists()) {
                try {
                    String value = getFormHTML(request, response);
                    xmlFile = new File(basepath + "code.xml");
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(xmlFile)));
                    out.print(value);
                    out.flush();
                    //response.setRenderParameter("result", this.saveOK);
                } catch (Exception e) {
                    //response.setRenderParameter("result", this.saveError);
                    log.error("Error saving file: " + xmlFile.getAbsolutePath(), e);
                }
            }

        }  else if("saveXMLFile".equals(response.getAction()))
        {
            String basepath = SWBPortal.getWorkPath() + base.getWorkPath() + "/";
            File xmlFile = new File(basepath);
            if (xmlFile.exists()) {
                try {
                    String value = null;
                    if (request.getParameter("hiddencode") != null &&request.getParameter("hiddencode").trim().length()>0) {
                        value = request.getParameter("hiddencode");
                    } else {
                        value = request.getParameter("resource" + base.getId());
                    }
                    xmlFile = new File(basepath + "code.xml");
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(xmlFile)));
                    out.print(value);
                    out.flush();
                    //response.setRenderParameter("result", this.saveOK);
                } catch (Exception e) {
                    //response.setRenderParameter("result", this.saveError);
                    log.error("Error saving file: " + xmlFile.getAbsolutePath(), e);
                }
            }

//            try {
//                base.setXmlConf(request.getParameter("hiddencode"));
//                base.updateAttributesToDB();
//            } catch (Exception e) {
//            }

            response.setMode(SWBActionResponse.Mode_ADMIN);
        } else if ("savecnf".equals(response.getAction())) {
            if (suri == null) {
                return;
            }
            foi = (FlowNodeInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
            String data = "";
            Iterator<ProcessObject> it = foi.listHeraquicalProcessObjects().iterator();
            while (it.hasNext()) {
                ProcessObject obj = it.next();
                SemanticClass cls = obj.getSemanticObject().getSemanticClass();
                Iterator<SemanticProperty> itp = cls.listProperties();
                while (itp.hasNext()) {
                    SemanticProperty prop = itp.next();
                    String name = cls.getClassId() + "|" + prop.getPropId();
                    if (request.getParameter(name) != null) {
                        data += name;
                        data += "|" + request.getParameter(name + "|s");
                        data += "|" + request.getParameter(name + "|fe");
                        data += "\n";
                    }
                }
            }
            response.getResourceBase().setData(response.getWebPage(), data);
            response.setMode(response.Mode_VIEW);
        } else if ("process".equals(response.getAction())) {
            if (suri == null) {
                return;
            }
            foi = (FlowNodeInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
            SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
            mgr.clearProperties();

            HashMap<String, String> hmprops = new HashMap();

            int i = 1;
            while (!base.getAttribute("prop" + i, "").equals("")) {

                String sprop = base.getAttribute("prop" + i);
                StringTokenizer stoken = new StringTokenizer(sprop, "|");

                String classid = "";
                String propid = "";

                if (stoken.hasMoreTokens()) {
                    classid = stoken.nextToken();
                    propid = stoken.nextToken();
                }

                hmprops.put(classid + "|" + propid, sprop);
                i++;
            }

            Iterator<ProcessObject> it = foi.listHeraquicalProcessObjects().iterator();
            while (it.hasNext()) {
                ProcessObject obj = it.next();
                SemanticClass cls = obj.getSemanticObject().getSemanticClass();
                Iterator<SemanticProperty> itp = cls.listProperties();
                while (itp.hasNext()) {
                    SemanticProperty prop = itp.next();
                    if (isViewProperty(response, cls, prop, hmprops)) {
                        mgr.addProperty(prop, cls, SWBFormMgr.MODE_VIEW);
                    } else if (isEditProperty(response, cls, prop, hmprops)) {
                        mgr.addProperty(prop, cls, SWBFormMgr.MODE_EDIT);
                    }
                }
            }
            try {
                mgr.processForm(request);
                if (request.getParameter("accept") != null) {
                    foi.close(response.getUser(), Instance.ACTION_ACCEPT);
                    response.sendRedirect(foi.getProcessWebPage().getUrl());
                } else if (request.getParameter("reject") != null) {
                    foi.close(response.getUser(), Instance.ACTION_REJECT);
                    response.sendRedirect(foi.getProcessWebPage().getUrl());
                }

            } catch (Exception e) {
                response.setRenderParameter("err", "invalidForm");
            }

        } else if ("savepropcnf".equals(response.getAction())) {
            //find last prop
            int i = 1;
            while (!base.getAttribute("prop" + i, "").equals("")) {
                i++;
            }
            int max = i;
            String prop = request.getParameter("prop");
            String default_FE = null;
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticProperty sempro = ont.getSemanticProperty(prop);
            SemanticObject dp = sempro.getDisplayProperty();
            if (dp != null) {
                //tiene displayproperty
                DisplayProperty disprop = (DisplayProperty) dp.createGenericInstance();

                //FormElement por defecto
                SemanticObject semobjFE = disprop.getFormElement();
                if (semobjFE != null) {
                    default_FE = semobjFE.getURI();
                } else {
                    default_FE = FE_DEFAULT;
                }

            }

            String modo = request.getParameter("mode");
            String fe = request.getParameter("formElement");
            String value = prop + "|" + modo + "|" + fe;

            boolean isTaken = Boolean.FALSE;
            // revisando que la propiedad no exista
            for (int j = 1; j < max; j++) {
                String val = base.getAttribute("prop" + j);
                if (val.startsWith(prop)) {
                    isTaken = Boolean.TRUE;
                    break;
                }
            }

            if (!isTaken) {
                base.setAttribute("prop" + i, value);
                try {
                    base.updateAttributesToDB();
                } catch (Exception e) {
                    log.error("Error al actualizar atributos del recurso.", e);
                }
            } else {

                response.setRenderParameter("errormsg", "Esa propiedad ya esta seleccionada. selecciona una diferente.");
            }

        } else if ("removeprop".equals(response.getAction())) {
            String prop = request.getParameter("prop");

            HashMap<Integer, String> hmprops = new HashMap();
            int i = 1;
            while (!base.getAttribute("prop" + i, "").equals("")) {
                //System.out.println(i + " = " + base.getAttribute("prop" + i));
                if (!prop.equals("" + i)) {
                    hmprops.put(new Integer(i), base.getAttribute("prop" + i));
                }
                base.removeAttribute("prop" + i);
                i++;
            }

            ArrayList list = new ArrayList(hmprops.keySet());
            Collections.sort(list);

            i = 1;
            Iterator<Integer> itprop = list.iterator();
            while (itprop.hasNext()) {
                Integer integer = itprop.next();
                String thisprop = hmprops.get(integer);
                base.setAttribute("prop" + i, thisprop);
                i++;
            }
            try {
                base.updateAttributesToDB();
            } catch (Exception e) { log.error("Error al guardar las propiedades del recurso en la DB.",e);
            }
        } else if ("addprops".equals(response.getAction())) {

            String[] props = request.getParameterValues("existentes");

            HashMap<Integer, String> hmprops = new HashMap();
            int i = 1;
            while (!base.getAttribute("prop" + i, "").equals("")) {
                hmprops.put(new Integer(i), base.getAttribute("prop" + i));
                base.removeAttribute("prop" + i);
                i++;
            }

            HashMap<String, String> hmparam = new HashMap();

            if (props != null && props.length > 0) {
                int j = 0;
                for (j = 0; j < props.length; j++) {
                    hmparam.put(props[j], props[j]);
                }
            }

            Iterator<Integer> itstr = hmprops.keySet().iterator();
            while (itstr.hasNext()) {
                Integer intg = itstr.next();
                String sprop = hmprops.get(intg);

                StringTokenizer stoken = new StringTokenizer(sprop, "|");

                String classid = "";
                String propid = "";

                if (stoken.hasMoreTokens()) {
                    classid = stoken.nextToken();
                    propid = stoken.nextToken();
                }

                if (hmparam.get(classid + "|" + propid) != null) {
                    hmparam.remove(classid + "|" + propid);

                } else if (hmparam.get(classid + "|" + propid) == null) {
                    itstr.remove();
                }

            }

            int maximo = 0;
            Iterator<Integer> itint = hmprops.keySet().iterator();
            while (itint.hasNext()) {
                Integer num = itint.next();
                if (num.intValue() > maximo) {
                    maximo = num.intValue();
                }
            }

            //Agregar propiedades faltantes

            String defaultFE = "generico";
            String defaultMode = FE_MODE_VIEW;
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();


            // agregando al hmprops las propiedades nuevas
            Iterator<String> itpar = hmparam.keySet().iterator();
            while (itpar.hasNext()) {
                maximo++;
                String strnew = itpar.next();

                StringTokenizer stoken = new StringTokenizer(strnew, "|");

                String classid = "";
                String propid = "";

                if (stoken.hasMoreTokens()) {
                    classid = stoken.nextToken();
                    propid = stoken.nextToken();
                }

                SemanticProperty sempro = ont.getSemanticProperty(propid);
                SemanticObject dp = sempro.getDisplayProperty();
                if (dp != null) {
                    //tiene displayproperty
                    DisplayProperty disprop = (DisplayProperty) dp.createGenericInstance();

                    //FormElement por defecto
                    SemanticObject semobjFE = disprop.getFormElement();
                    if (semobjFE != null) {
                        defaultFE = semobjFE.getURI();
                    } else {
                        defaultFE = FE_DEFAULT;
                    }

                }

                String value = strnew + "|" + defaultMode + "|" + defaultFE;
                hmprops.put(new Integer(maximo), value);
            }

            // ordenando las propiedades
            ArrayList list = new ArrayList(hmprops.keySet());
            Collections.sort(list);

            //guardando las propiedades
            i = 1;
            Iterator<Integer> itprop = list.iterator();
            while (itprop.hasNext()) {
                Integer integer = itprop.next();
                String thisprop = hmprops.get(integer);
                base.setAttribute("prop" + i, thisprop);
                i++;
            }

            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
            }


        } else if ("swap".equals(response.getAction())) {
            String direction = request.getParameter("direction");
            String propid = request.getParameter("prop");
            if (null != direction && "down".equals(direction)) {
                String tmp = base.getAttribute("prop" + propid);
                if (tmp != null) {
                    int pos = 0;
                    int posdown = 0;
                    try {
                        pos = Integer.parseInt(propid);
                        posdown = pos + 1;
                    } catch (Exception e) {
                    }
                    String tmp2 = base.getAttribute("prop" + posdown);
                    if (tmp2 != null && pos > 0 && posdown > 0 && pos < posdown) {
                        base.setAttribute("prop" + pos, tmp2);
                        base.setAttribute("prop" + posdown, tmp);
                    }
                }

            } else if (null != direction && "up".equals(direction)) {
                String tmp = base.getAttribute("prop" + propid);
                if (tmp != null) {
                    int pos = 0;
                    int posup = 0;
                    try {
                        pos = Integer.parseInt(propid);
                        posup = pos - 1;
                    } catch (Exception e) {
                    }
                    String tmp2 = base.getAttribute("prop" + posup);
                    if (tmp2 != null && pos > 0 && posup > 0 && pos > posup) {
                        base.setAttribute("prop" + pos, tmp2);
                        base.setAttribute("prop" + posup, tmp);
                    }
                }
            }
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
            }

        } else if ("updtItem".equals(response.getAction())) {

            String pid = request.getParameter("prop");
            if (pid != null) {
                String prop2change = base.getAttribute("prop" + pid);
                if (null != prop2change) {
                    StringTokenizer stoken = new StringTokenizer(prop2change, "|");
                    String classid = "";
                    String propid = "";
                    String modo = "";
                    String fele = "";

                    try {
                        if (stoken.hasMoreTokens()) {
                            classid = stoken.nextToken();
                            propid = stoken.nextToken();
                            modo = stoken.nextToken();
                            fele = stoken.nextToken();
                        }

                        if (request.getParameter("feuri") != null) {
                            fele = request.getParameter("feuri");
                        }
                        if (request.getParameter("mode") != null) {
                            modo = request.getParameter("mode");
                        }

                        String newvalue = classid + "|" + propid + "|" + modo + "|" + fele;

                        base.setAttribute("prop" + pid, newvalue);
                        base.updateAttributesToDB();

                    } catch (Exception e) { log.error("Error al cambiar el orden de las propiedades.",e);
                    }
                }
            }
        } else if ("update".equals(response.getAction())) {
            try {
                String xml = base.getXmlConf();//bundle.getBundle(getClass().getName(), new java.util.Locale(user.getLanguage()));
                if (xml != null && xml.trim().length() > 0) {
                    SWBFormMgrLayer.update2DB(request, response, foi, xml);
                }
                response.setAction(response.Action_EDIT);
            } catch (Exception e) {
                log.error(e);
            }
        } 

        response.setRenderParameter("suri", suri);
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        String suri = request.getParameter("suri");

        String action = paramRequest.getAction();

        String adminMode = base.getAttribute("adminMode", ADMINMODE_SIMPLE);

        if (action != null && (action.equals(ADMINMODE_ADVANCE) || action.equals(ADMINMODE_SIMPLE))) {
            adminMode = action;
        }

        HashMap<String, String> hmsc = new HashMap();
        HashMap<String, SemanticProperty> hmprops = new HashMap();
        HashMap<String, SemanticProperty> hmselected = new HashMap();

        UserTask ut = null;
        if (base.getResourceable() instanceof UserTask) {
            ut = (UserTask) base.getResourceable();

        }

        if (request.getParameter("errormsg") != null) {
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('" + request.getParameter("errormsg") + "');");
            out.println("</script>");
        }

        if (ut == null) {
            out.println("Parámetro no definido...");
            return;
        }

        //FlowNodeInstance foi = (FlowNodeInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
        FlowNodeInstance foi = ut.getFlowObjectInstance();

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticVocabulary sv = SWBPlatform.getSemanticMgr().getVocabulary();

        if (hmFormEle == null) {
            //System.out.println("Cargando HM - Form Element");
            hmFormEle = new HashMap<String, SemanticObject>();

            Iterator<SemanticObject> itfe = sv.getSemanticClass(sv.SWB_SWBFORMELEMENT).listInstances(false);//sont.listInstancesOfClass(sv.getSemanticClass(sv.SWB_FORMELEMENT));
            while (itfe.hasNext()) {
                SemanticObject sofe = itfe.next();
                hmFormEle.put(sofe.getURI(), sofe);
            }
        }

        Iterator<SemanticClass> itsub = sv.getSemanticClass(sv.SWB_SWBFORMELEMENT).listSubClasses();
        while (itsub.hasNext()) {
            SemanticClass scfe = itsub.next();
            //System.out.println("SemanticClass: " + scfe.getDisplayName(user.getLanguage()));
            Iterator<SemanticObject> itsco = scfe.listInstances(true);
            while (itsco.hasNext()) {
                SemanticObject sOfe = itsco.next();
                //System.out.println("class instance: --=> " + sOfe.getDisplayName(user.getLanguage()));
            }
        }

        Iterator<ProcessObject> it = foi.listHeraquicalProcessObjects().iterator();
        while (it.hasNext()) {
            ProcessObject obj = it.next();
            SemanticClass cls = obj.getSemanticObject().getSemanticClass();
            System.out.println("ClassID: "+cls.getClassId());
            Iterator<SemanticProperty> itp = cls.listProperties();
            while (itp.hasNext()) {
                SemanticProperty prop = itp.next();
                String name = cls.getClassId() + "|" + prop.getPropId();
                hmsc.put(name, prop.getDisplayName(lang));
                hmprops.put(name, prop);
            }
        }

        int max = 1;
        while (!base.getAttribute("prop" + max, "").equals("")) {

            String val = base.getAttribute("prop" + max);
            String classid = "";
            String propid = "";
            String modo = "";
            String fe = "";
            StringTokenizer stoken = new StringTokenizer(val, "|");
            if (stoken.hasMoreTokens()) {
                classid = stoken.nextToken();
                propid = stoken.nextToken();
                modo = stoken.nextToken();
                fe = stoken.nextToken();
            }
            if (hmprops.get(classid + "|" + propid) != null) {
                SemanticProperty sprop = ont.getSemanticProperty(propid);
                hmselected.put(classid + "|" + propid, sprop);
            }
            max++;
        }

        out.println("<div class=\"swbform\">");

        if (ADMINMODE_SIMPLE.equals(adminMode)) {

            out.println("<script type=\"text/javascript\">");
            out.println("function MoveItems(lstbxFrom,lstbxTo) ");
            out.println("{ ");
            out.println("	var varFromBox = document.getElementById(lstbxFrom); ");
            out.println("	var varToBox = document.getElementById(lstbxTo); ");
            out.println("	if ((varFromBox != null) && (varToBox != null))  ");
            out.println("	{  ");
            out.println("		if(varFromBox.length < 1)  ");
            out.println("		{ ");
            out.println("			alert('No hay propiedades en la lista.'); ");
            out.println("			return false; ");
            out.println("		} ");
            out.println("		if(varFromBox.options.selectedIndex == -1) // no hay elementos seleccionados");
            out.println("		{ ");
            out.println("			alert('Selecciona una propiedad de la lista.'); ");
            out.println("			return false; ");
            out.println("		} ");
            out.println("		while ( varFromBox.options.selectedIndex >= 0 )  ");
            out.println("		{  ");
            out.println("			var newOption = new Option(); // crea una opcion en el select  ");
            out.println("			newOption.text = varFromBox.options[varFromBox.options.selectedIndex].text;  ");
            out.println("			newOption.value = varFromBox.options[varFromBox.options.selectedIndex].value;  ");
            out.println("			varToBox.options[varToBox.length] = newOption; //agrega la opción al final del select destino");
            out.println("			varFromBox.remove(varFromBox.options.selectedIndex); //quita la opción del select origen ");
            out.println("		}  ");
            out.println("	} ");
            out.println("	return false;  ");
            out.println("} ");

            out.println("function enviatodos(lstbox)");
            out.println("{");
            out.println("	var list = document.getElementById(lstbox);");
            //out.println("	if(list.options.length==0) return false;");
            out.println("	for (var i=0; i<list.options.length; i++){");
            out.println("	 list.options[i].selected=true;");
            out.println("	}");
            out.println("	return true;");
            out.println("}");
            out.println("   function updItem(uri,param,sel) {");
            out.println("       var valor = sel.options[sel.options.selectedIndex].value;");
            out.println("       var url = uri+'&'+param+'='+escape(valor);");
            out.println("       window.location=url;");
            out.println("}");
            out.println("</script>");



            SWBResourceURL urladd = paramRequest.getActionUrl();
            urladd.setAction("addprops");


            out.println("<form action=\"" + urladd + "\" id=\"" + suri + "/forma\" method=\"post\" onsubmit=\"if(enviatodos('existentes')) { this.form.submit(); return false; } else { return false;}\">");
            out.println("<input type=\"hidden\" name=\"suri\" value=\"" + suri + "\">");
            out.println("<fieldset>");
            out.println("<legend>" + "Configuración" + "</legend>");
            out.println("<table border=\"0\" width=\"100%\" >");
            out.println("<tr>");
            out.println("<th>Propiedades");
            out.println("</th>");
            out.println("<th>");
            out.println("</th>");
            out.println("<th>Seleccionadas");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            // select con la lista de propiedades existentes
            out.println("<select size=\"10\" name=\"propiedades\" id=\"" + suri + "/propiedades\" multiple style=\"width: 100%;\">");
            Iterator<String> its = hmprops.keySet().iterator();
            while (its.hasNext()) {
                String str = its.next();
                String classid="";
                String propid="";
                StringTokenizer stoken = new StringTokenizer(str, "|");
                if (stoken.hasMoreTokens()) {
                    classid = stoken.nextToken();
                    propid = stoken.nextToken();
                 }
                if (hmselected.get(str) == null) {
                    SemanticProperty sp = hmprops.get(str);
                    out.println("<option value=\"" + str + "\">");
                    out.println(classid+"."+sp.getDisplayName(lang));
                    out.println("</option>");
                }
            }
            out.println("</select>");
            out.println("</td>");
            out.println("<td valign=\"middle\" width=\"25px\">");
            // botones
            out.println("<button dojoType=\"dijit.form.Button\" type = \"button\" style=\"width: 25px;\" id = \"" + suri + "btnMoveLeft\" onclick = \"MoveItems('" + suri + "/existentes','" + suri + "/propiedades');\"><-</button><br>");
            out.println("<button dojoType=\"dijit.form.Button\" type = \"button\" style=\"width: 25px;\" id = \"" + suri + "btnMoveRight\" onclick = \"MoveItems('" + suri + "/propiedades','" + suri + "/existentes');\">-></button>");
            out.println("</td>");
            out.println("<td>");
            // select con la lista de propiedades seleccionadas
            out.println("<select size=\"10\" name=\"existentes\" id=\"" + suri + "/existentes\" multiple style=\"width: 100%;\">");
            its = hmselected.keySet().iterator();
            while (its.hasNext()) {
                String str = its.next();
                String classid="";
                String propid="";
                StringTokenizer stoken = new StringTokenizer(str, "|");
                if (stoken.hasMoreTokens()) {
                    classid = stoken.nextToken();
                    propid = stoken.nextToken();
                 }


                SemanticProperty sp = hmselected.get(str);
                out.println("<option value=\"" + str + "\">");
                out.println(classid+"."+sp.getDisplayName(lang));
                out.println("</option>");
            }
            out.println("</select>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=\"3\" >");
            // botones para guadar cambios
            out.println("<button  dojoType=\"dijit.form.Button\" type=\"submit\">Guardar</button>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            //out.println("</form>");
            out.println("</fieldset>");
            out.println("<fieldset>");

            out.println("<table border=\"0\" width=\"100%\">");
            out.println("<tr>");
            out.println("<th>Acción");
            out.println("</th>");
            out.println("<th>Propiedad");
            out.println("</th>");
            out.println("<th>FormElement");
            out.println("</th>");
            out.println("<th>Modo");
            out.println("</th>");
            out.println("</tr>");
            int i = 1;
            while (!base.getAttribute("prop" + i, "").equals("")) {
                String val = base.getAttribute("prop" + i);
                String classid = "";
                String propid = "";
                String modo = "";
                String fe = "";
                StringTokenizer stoken = new StringTokenizer(val, "|");
                if (stoken.hasMoreTokens()) {
                    classid = stoken.nextToken();
                    propid = stoken.nextToken();
                    modo = stoken.nextToken();
                    fe = stoken.nextToken();
                }
                //System.out.println(i + " = " + base.getAttribute("prop" + i));

                out.println("<tr>");

                SWBResourceURL urlrem = paramRequest.getActionUrl();
                urlrem.setAction("removeprop");
                urlrem.setParameter("prop", "" + i);
                urlrem.setParameter("suri", suri);

                out.println("<td>");
                out.println("<a href=\"#\" onclick=\"window.location='" + urlrem + "'; return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" alt=\"eliminar\"></a>");

                if (i != max - 1) {
                    SWBResourceURL urldown = paramRequest.getActionUrl();
                    urldown.setAction("swap");
                    urldown.setParameter("suri", suri);
                    urldown.setParameter("prop", "" + i);
                    urldown.setParameter("direction", "down");
                    out.println("<a href=\"#\" onclick=\"window.location='" + urldown + "'; return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/down.jpg\" border=\"0\" alt=\"bajar\"></a>");
                } else {
                    out.println("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/space.jpg\" border=\"0\" >");
                }

                if (i != 1) //sorderdown>0
                {
                    SWBResourceURL urlup = paramRequest.getActionUrl();
                    urlup.setAction("swap");
                    urlup.setParameter("suri", suri);
                    urlup.setParameter("prop", "" + i);
                    urlup.setParameter("direction", "up");
                    urlup.setParameter("ract", "config");
                    out.println("<a href=\"#\" onclick=\"window.location='" + urlup + "'; return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/up.jpg\" border=\"0\" alt=\"subir\"></a>");
                }
                out.println("</td>");
                out.println("<td>");

                out.println(classid + "." + hmsc.get(classid + "|" + propid));

                out.println("</td>");
                out.println("<td>");

                SWBResourceURL urlupd = paramRequest.getActionUrl();
                urlupd.setAction("updtItem");
                urlupd.setParameter("prop", "" + i);
                urlupd.setParameter("suri", suri);

                out.println("<select id=\"" + suri + "/" + i + "/sfe\" name=\"formElement\" style=\"width:300px;\" onchange=\"updItem('" + urlupd + "','feuri',this);\" >"); //
                out.println(getFESelect(fe, paramRequest));
                out.println("</select>");
                out.println("</td>");
                out.println("<td>");
                out.println("<select id=\"" + suri + "/" + i + "/smode\" name=\"mode\" style=\"width:80px;\" onchange=\"updItem('" + urlupd + "','mode',this);\">"); //
                out.println("<option value=\"edit\" " + (modo.equals("edit") ? "selected" : "") + " >Edit</option>");
                out.println("<option value=\"view\" " + (modo.equals("view") ? "selected" : "") + " >View</option>");
                out.println("</select>");
                out.println("</td>");
                out.println("</tr>");
                i++;
            }

            out.println("</table>");
            out.println("</fieldset>");

            if (hmprops.size() > 0) {
                out.println("<fieldset>");
                SWBResourceURL urladv = paramRequest.getRenderUrl();
                urladv.setAction(ADMINMODE_ADVANCE);
                out.println("<button dojoType=\"dijit.form.Button\" type=\"button\" onclick=\"window.location='" + urladv + "'; return false;\">Ir al modo avanzado</button>");
                out.println("</fieldset>");
            }


            out.println("</form>");

        } else if (ADMINMODE_ADVANCE.equals(adminMode)) {
            SWBResourceURL urladd = paramRequest.getActionUrl();
            urladd.setAction("updAdminMode");
            out.println("<form action=\"" + urladd + "\" id=\"" + suri + "/forma\" method=\"post\" onsubmit=\"if(enviatodos('existentes')) { this.form.submit(); return false; } else { return false;}\">");
            out.println("<input type=\"hidden\" name=\"suri\" value=\"" + suri + "\">");
            out.println("<fieldset>");
            out.println("<legend>" + "Modo avanzado" + "</legend>");
            out.println("<table>");

            out.println("<tr>");
            out.println("<td>");
            out.println("<input type=\"checkbox\" name=\"adminMode\" id=\"" + suri + "_adminmode\"  "+(adminMode.equals(ADMINMODE_ADVANCE)?"checked":"")+" value=\""+ADMINMODE_ADVANCE+"\"><label for=\"" + suri + "_adminmode\">Utilizar modo avanzado</label>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");

            out.println("</fieldset>");
            out.println("<fieldset>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td colspan=\"3\" align=\"center\">");

            out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\">Guardar</button>");

            SWBResourceURL urlbck = paramRequest.getRenderUrl();
            urlbck.setAction(ADMINMODE_SIMPLE);
            urlbck.setParameter("suri", suri);

            out.println("<button  dojoType=\"dijit.form.Button\" type=\"button\" onclick=\"window.location='" + urlbck + "'; return false;\">Regresar</button>");

            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("</form>");

            if (base.getAttribute("adminMode") != null && base.getAttribute("adminMode").equals(ADMINMODE_ADVANCE)) {

                urladd = paramRequest.getActionUrl();
                urladd.setAction("updXMLConfig");
                out.println("<form action=\"" + urladd + "\" id=\"" + suri + "/forma\" method=\"post\" onsubmit=\"if(enviatodos('existentes')) { this.form.submit(); return false; } else { return false;}\">");
                out.println("<input type=\"hidden\" name=\"suri\" value=\"" + suri + "\">");
                out.println("<fieldset>");
                out.println("<legend>" + "Configuración XML" + "</legend>");
                out.println("<table>");

                out.println("<tr>");
                out.println("<td>");
                out.println("<input type=\"checkbox\" name=\"btnAccept\" id=\"" + suri + "_btnAccept\" value=\"incluir\"><label for=\"" + suri + "_btnAccept\">Utilizar botón aceptar</label>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<input type=\"checkbox\" name=\"btnReject\" id=\"" + suri + "_btnReject\" value=\"incluir\"><label for=\"" + suri + "_btnReject\">Utilizar botón rechazar</label>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<input type=\"checkbox\" name=\"btnCancel\" id=\"" + suri + "_btnCancel\" value=\"incluir\"><label for=\"" + suri + "_btnCancel\">Utilizar boton cancelar</label>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<input type=\"checkbox\" name=\"btnSave\" id=\"" + suri + "_btnSave\" value=\"incluir\"><label for=\"" + suri + "_btnSave\">Utilizar botón guardar</label>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<input type=\"checkbox\" name=\"useDojo\" id=\"" + suri + "_useDojo\" value=\"dojo\"><label for=\"" + suri + "_useDojo\">Utilizar Dojo</label>");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");

                out.println("</fieldset>");
                out.println("<fieldset>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<td colspan=\"3\" align=\"center\">");

                out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\">Generar XML</button>");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</fieldset>");
                out.println("</form>");


                String basepath = SWBPortal.getWorkPath() + base.getWorkPath() + "/";
                String value = SWBUtils.IO.getFileFromPath(basepath+"code.xml");

                //value = base.getXmlConf();

                if(null!=value&&value.trim().length()>0)
                {

                    StringBuilder ret = new StringBuilder(400);
                    SWBResourceURL url = paramRequest.getActionUrl().setAction("saveXMLFile");

                    //Despliegue del editor
                    ret.append("<script type=\"text/javascript\" src=\"");
                    ret.append(SWBPlatform.getContextPath());
                    ret.append("/swbadmin/js/editarea/edit_area/edit_area_full.js\"></script>\n");
                    ret.append("<script type=\"text/javascript\" charset=\"UTF-8\">\n");
                    ret.append("editAreaLoader.init({\n");
                    ret.append("    id : \"resource");
                    ret.append(base.getId());
                    ret.append("\"\n    ,language: \"");
                    ret.append(paramRequest.getUser().getLanguage().toLowerCase());
                    ret.append("\"\n    ,syntax: \"xml\"\n");
                    ret.append("    ,start_highlight: true\n");
                    ret.append("    ,toolbar: \"save, |, search, go_to_line,");
                    ret.append(" |, undo, redo, |, select_font,|, change_smooth_selection,");
                    ret.append(" highlight, reset_highlight, |, help\"\n");
                    ret.append("    ,is_multi_files: false\n");
                    ret.append("    ,save_callback: \"my_save\"\n");
                    ret.append("    ,allow_toggle: false\n");
                    ret.append("});\n");
                    ret.append("\n");
                    ret.append("  function my_save(id, content){\n");
                    ret.append("    var elemento = document.getElementById(\"hiddencode\");\n");
                    ret.append("    elemento.value = content;\n");
                    ret.append("    document.xmledition.submit();\n");
                    ret.append("  }\n");
                    ret.append("</script>\n");
                    ret.append("<form name=\"xmledition\" action=\"");
                    ret.append(url.toString());
                    ret.append("\" method=\"post\">\n");
                    ret.append("<textarea id=\"resource");
                    ret.append(base.getId());
                    ret.append("\" name=\"resource");
                    ret.append(base.getId());
                    ret.append("\" rows=\"25");
                    ret.append("\" cols=\"95\">");
                    ret.append(value);
                    ret.append("</textarea>\n");
                    ret.append("<input type=\"hidden\" id=\"hiddencode\" name=\"hiddencode\" value=\"\"/>\n");

                    out.println(ret.toString());

                }


            }

        }

        out.println("</div>");


    }

    public String getFESelect(String FEsel, SWBParamRequest paramRequest) {

        SemanticVocabulary sv = SWBPlatform.getSemanticMgr().getVocabulary();
        StringBuilder ret = new StringBuilder();
        ret.append("\n<optgroup label=\"Genérico\">");
        ret.append("\n<option value=\"generico\" selected >GenericFormElement</option>");
        ret.append("\n</optgroup>");

        Iterator<SemanticClass> itsub = sv.getSemanticClass(sv.SWB_SWBFORMELEMENT).listSubClasses();
        while (itsub.hasNext()) {
            SemanticClass scfe = itsub.next();
            ret.append("\n<optgroup label=\"");
            ret.append(scfe.getDisplayName(paramRequest.getUser().getLanguage()));
            ret.append("\">");
            Iterator<SemanticObject> itsco = scfe.listInstances(true);
            while (itsco.hasNext()) {
                SemanticObject sofe = itsco.next();
                ret.append("\n<option value=\"");
                ret.append(sofe.getURI());
                ret.append("\"");
                String stmp = FEsel + "edit|" + sofe.getURI();
                String stmp2 = FEsel + "view|" + sofe.getURI();
                String data = paramRequest.getResourceBase().getData(paramRequest.getWebPage());
                if (FEsel != null && !FEsel.equals("") && (data != null && (data.indexOf(stmp) > -1 || data.indexOf(stmp2) > -1) || FEsel.equals(sofe.getURI()))) {
                    ret.append(" selected ");
                }
                ret.append(">");
                ret.append(sofe.getDisplayName(paramRequest.getUser().getLanguage()));
                ret.append("\n</option>");
            }
            ret.append("\n</optgroup>");
        }

        return ret.toString();
    }

    public boolean hasProperty(SWBParameters paramRequest, SemanticClass cls, SemanticProperty prop) {
        boolean ret = false;
        String data = paramRequest.getResourceBase().getData(paramRequest.getWebPage());
        if (data != null && data.indexOf(cls.getClassId() + "|" + prop.getPropId()) > -1) {
            return ret = true;
        }
        return ret;
    }

    public boolean isViewProperty(SWBParameters paramRequest, SemanticClass cls, SemanticProperty prop, HashMap<String, String> hm) {
        boolean ret = false;
        String data = hm.get(cls.getClassId() + "|" + prop.getPropId());
        //System.out.println("VIEW-PROP: "+data);
        if (data != null && data.indexOf(cls.getClassId() + "|" + prop.getPropId() + "|view") > -1) {
            return ret = true;
        }
        return ret;
    }

    public boolean isEditProperty(SWBParameters paramRequest, SemanticClass cls, SemanticProperty prop, HashMap<String, String> hm) {
        boolean ret = false;
        String data = hm.get(cls.getClassId() + "|" + prop.getPropId());
        //System.out.println("EDIT-PROP: "+data);
        if (data != null && data.indexOf(cls.getClassId() + "|" + prop.getPropId() + "|edit") > -1) {
            return ret = true;
        }
        return ret;
    }
}
