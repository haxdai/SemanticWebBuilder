/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.AreaCarrera;
import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Carrera;
import com.infotec.cvi.swb.Grado;
import com.infotec.cvi.swb.GradoAcademico;
import com.infotec.cvi.swb.SituacionAcademica;
import com.infotec.cvi.swb.TipoCarrera;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author juan.fernandez
 */
public class GradoAcademicoResource extends GenericResource {

    private Logger log = SWBUtils.getLogger(GradoAcademicoResource.class);
    private final String MODE_TIPO = "mod_tipo";
    private final String MODE_AREA = "mod_area";
    private final String MODE_CARRERA = "mod_carrera";

    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);

            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
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
        if (null == action) {
            action = "";
        }

        User usr = response.getUser();
        WebSite wsite = response.getWebPage().getWebSite();
        String eventid = request.getParameter("idevent");
        String page = request.getParameter("page");
        String msg = "";

        CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
        if (cv == null) {
            cv = CV.ClassMgr.createCV(usr.getId(), wsite);
            cv.setPropietario(usr);
        }

        Academia aca = cv.getAcademia();
        if (aca == null) {
            aca = Academia.ClassMgr.createAcademia(wsite);
            cv.setAcademia(aca);
        }


        if (SWBResourceURL.Action_ADD.equals(action) || SWBResourceURL.Action_EDIT.equals(action)) {

            String idcarrera = request.getParameter("sel_Carrera");
            String idsituacion = request.getParameter("idsituacion");
            String nomInstitucion = request.getParameter("txtInstitucion");
            int intPeriodo = request.getParameter("periodo") != null ? Integer.parseInt(request.getParameter("periodo")) : 0;
            String idgrado = request.getParameter("idgrado");

            //System.out.println("Carrera: "+idcarrera+" situación: "+idsituacion+" institución: "+nomInstitucion+" periodo: "+intPeriodo+" Grado: "+idgrado);
            
            Carrera carrera = Carrera.ClassMgr.getCarrera(idcarrera, wsite);
            //System.out.println("carrera: "+carrera);
            SituacionAcademica situacion = SituacionAcademica.ClassMgr.getSituacionAcademica(idsituacion, wsite);
            Grado grado = Grado.ClassMgr.getGrado(idgrado, wsite);

            if (grado != null && situacion != null  && intPeriodo > 0) { //&& carrera != null
                GradoAcademico ga = null;
                if (id != null) {
                    ga = GradoAcademico.ClassMgr.getGradoAcademico(id, wsite);
                    msg = "Se actualizó correctamente Grado Académico";
                }
                if (ga == null) {
                    ga = GradoAcademico.ClassMgr.createGradoAcademico(wsite);
                    aca.addGradoAcademico(ga);
                    msg = "Se agregó correctamente el Grado Académico";
                }

                ga.setNombreInstitucion(nomInstitucion);
                if(carrera!=null) ga.setCarrera(carrera);
                ga.setSituacionAcademica(situacion);
                ga.setPeriodoYears(intPeriodo);
                ga.setGrado(grado);

                response.setAction("");

                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", msg);
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo procesar Grado Académico");
            }

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            if (id != null) {
                GradoAcademico ga = GradoAcademico.ClassMgr.getGradoAcademico(id, wsite);
                if (ga != null) {
                    try {
                        ga.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente el Grado Académico.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar el Grado Académico");
                    }
                }
            }
        }
        if (eventid != null) {
            response.setRenderParameter("id", eventid);
        }
        if (page != null) {
            response.setRenderParameter("page", page);
        }
    }

    public void getTipo(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("application/json; charset=ISO-8859-1");//ISO-8859-1
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User usr = paramRequest.getUser();
        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<TipoCarrera> it = SWBComparator.sortByDisplayName(TipoCarrera.ClassMgr.listTipoCarreras(wsite), usr.getLanguage());
            while (it.hasNext()) {
                TipoCarrera tipo = it.next();
                JSONObject jtipo = new JSONObject();
                items.put(jtipo);
                jtipo.put("id", tipo.getId());
                jtipo.put("name", tipo.getTitle());
                Iterator<AreaCarrera> itarea = tipo.listAreas();
                while (itarea.hasNext()) {
                    AreaCarrera areaCarrera = itarea.next();
                    jtipo.put("area", areaCarrera.getId());
                }
            }

            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }

    public void getArea(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");//ISO-8859-1
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User usr = paramRequest.getUser();

        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<AreaCarrera> it = SWBComparator.sortByDisplayName(AreaCarrera.ClassMgr.listAreaCarreras(wsite), usr.getLanguage());
            while (it.hasNext()) {
                AreaCarrera area = it.next();
                JSONObject jarea = new JSONObject();
                items.put(jarea);
                jarea.put("id", area.getId());
                jarea.put("name", area.getTitle());
                TipoCarrera tipo = area.getTipoCarreraInv();
                    if (tipo != null) {
                        jarea.put("tipo", area.getTipoCarreraInv().getId());
                    }
            }
            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }

    public void getCarrera(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");//ISO-8859-1
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User usr = paramRequest.getUser();
        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<Carrera> it = SWBComparator.sortByDisplayName(Carrera.ClassMgr.listCarreras(wsite), usr.getLanguage());
            while (it.hasNext()) {
                Carrera car = it.next();
                JSONObject jcarrera = new JSONObject();
                items.put(jcarrera);
                jcarrera.put("id", car.getId());
                jcarrera.put("name", car.getTitle());
                AreaCarrera area = car.getAreaCarrera();
                if(area!=null){
                    jcarrera.put("area", area.getId());
                    TipoCarrera tipo = area.getTipoCarreraInv();
                    if (tipo != null) {
                        jcarrera.put("tipo", area.getTipoCarreraInv().getId());
                    }
                }
            }
            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        if (paramRequest.getMode().equals(MODE_TIPO)) {
            getTipo(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(MODE_AREA)) {
            getArea(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(MODE_CARRERA)) {
            getCarrera(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
}
