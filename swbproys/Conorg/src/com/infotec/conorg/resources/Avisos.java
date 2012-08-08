/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import com.infotec.conorg.Aviso;
import com.infotec.conorg.WorkSpace;
import com.infotec.conorg.utils.MessageUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.*;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.*;

/**
 *
 * @author juan.fernandez
 */
public class Avisos extends GenericAdmResource {

    public static final Logger log = SWBUtils.getLogger(Avisos.class);
    public static final SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yy hh:mm");

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        String id = request.getParameter("id");
        String suri = request.getParameter("suri");
        String wsid = request.getParameter("wsid");
        String classid = request.getParameter("classid");
        if (null == action) {
            action = "";
        }

        User usr = response.getUser();
        WebSite wsite = response.getWebPage().getWebSite();
        String eventid = request.getParameter("idevent");
        String page = request.getParameter("page");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = null;
        if (null != id) {
            obj = ont.getSemanticObject(id);
        }
        SemanticClass cls = null;
        if (null != obj) {
            cls = obj.getSemanticClass();
        }

        String msg = "";
        if (SWBResourceURL.Action_ADD.equals(action)) { // || SWBResourceURL.Action_EDIT.equals(action)

            //forall workspace==null && users == null
            //msgasunto msgdescrip 
            //workspaceid  workspace!=null && users == null 
            //contactid  worspace==null && users!=null

            String forall = request.getParameter("tipomsg");
            if (forall == null) {
                forall = "";
            }
            String msgasunto = request.getParameter("msgasunto");
            String msgdescrip = request.getParameter("msgdescrip")!=null?request.getParameter("msgdescrip"):"";
            String listwrkspcs = request.getParameter("workspaceid");
            String[] listcontact = request.getParameterValues("contactid");

            //System.out.println("listcontact: "+(listcontact!=null?listcontact.length:"null"));
            
            GenericObject goparam = null;
            User usrparam = null;
            WorkSpace wrkspc = null;

            if ((msgasunto != null && msgdescrip != null) && ((listwrkspcs != null&&!listwrkspcs.equals("0")) || listcontact != null || !forall.equals(""))) {

                Aviso aviso = null;
                aviso = Aviso.ClassMgr.createAviso(wsite);
                aviso.setTitle(msgasunto);
                aviso.setDescription(msgdescrip);
                aviso.setFromUser(usr);
                
                if(forall.equals("all")) {
                    msg = "Se generó Aviso para la comunidad correctamente.";
                } else  if (listwrkspcs != null && !listwrkspcs.equals("0")) {
                    goparam = ont.getGenericObject(listwrkspcs);
                    if (goparam != null && goparam instanceof WorkSpace) {
                        wrkspc = (WorkSpace) goparam;
                        //se agrega el workspace al aviso
                        aviso.setToWorkSpace(wrkspc);
                        
                        msg = "Se generó Aviso para el espacio de trabajo correctamente.";
                    }
                } else if (listcontact != null) {
                    UserRepository userrep = wsite.getUserRepository();
                    
                    for (int i = 0; i < listcontact.length; i++) {
                        usrparam = userrep.getUser(listcontact[i]);
                        if (usrparam != null) {
                            aviso.addToUser(usrparam);
                        }
                    }
                    msg = "Se generó Aviso para el colega(s) correctamente.";
                } 

            } else {
                msg = "Error en los datos, no se pudo generar el aviso.";
            }

            response.setRenderParameter("alertmsg", msg);
            response.setRenderParameter("id", id);
            response.setRenderParameter("suri", id);
            if (null != wsid) {
                response.setRenderParameter("wsid", wsid);
            }
            response.setMode(SWBActionResponse.Mode_VIEW);
            response.setAction("");
            
        }
    }

    public static String getClassIconMessage(Aviso aviso) {

        String ret = "aviso-usr";
        if (!aviso.listToUsers().hasNext() && aviso.getToUser() == null && aviso.getToWorkSpace() == null) {
            ret = "avisos-all";
        } else if (aviso.listToUsers().hasNext() && aviso.getToWorkSpace() == null) {
            ret = "aviso-usr";
        } else if (!aviso.listToUsers().hasNext() && aviso.getToUser() == null && aviso.getToWorkSpace() != null) {
            ret = "aviso-sys";
        }
        return ret;
    }
}
