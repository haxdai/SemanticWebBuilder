/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.AreaEstudio;
import com.infotec.cvi.swb.Avance;
import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.DisciplinaEstudio;
import com.infotec.cvi.swb.EstudioSuperior;
import com.infotec.cvi.swb.Estudios;
import com.infotec.cvi.swb.TipoEstudio;
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
public class EstudioSuperiorResource extends GenericResource
{

    private Logger log = SWBUtils.getLogger(EstudioSuperiorResource.class);
    private final String MODE_DISCIPLINA = "mod_disciplina";
    private final String MODE_TIPO = "mod_tipo";
    private final String MODE_AREA = "mod_area";
    private final String MODE_POSGRADO = "mod_posgrado";

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

        CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
        if(cv==null) {
            cv = CV.ClassMgr.createCV(usr.getId(),wsite);
            cv.setPropietario(usr);
        }
             
        Academia aca = cv.getAcademia();
        if(aca==null){
            aca = Academia.ClassMgr.createAcademia(wsite);
            cv.setAcademia(aca);
        }
        
        String msg = "";
        if (SWBResourceURL.Action_ADD.equals(action)||SWBResourceURL.Action_EDIT.equals(action)) {
            
            String idestudio = request.getParameter("sel_Estudio");
            String idgavance = request.getParameter("idgavance");
            int intPeriodo = request.getParameter("periodo")!=null?Integer.parseInt(request.getParameter("periodo")):0;
            
            Estudios estudio = Estudios.ClassMgr.getEstudios(idestudio, wsite);
            Avance gavance = Avance.ClassMgr.getAvance(idgavance, wsite);
            
            //System.out.println("estudio: "+idestudio+", Avance: "+idgavance+", periodo: "+intPeriodo);
            
            if(estudio!=null&&gavance!=null&&intPeriodo>=0)
            {
                
                EstudioSuperior estSuperior = null;
                if(id!=null){
                    estSuperior = EstudioSuperior.ClassMgr.getEstudioSuperior(id,wsite);
                    msg="Se actualizó correctamente Estudio Superior";
                }
                if(estSuperior==null){
                    estSuperior = EstudioSuperior.ClassMgr.createEstudioSuperior(wsite);
                    aca.addEstudioSuperior(estSuperior);
                    msg="Se agregó correctamente Estudio Superior";
                }

                estSuperior.setGradoAvance(gavance);
                estSuperior.setEstudiosSuperiores(estudio);
                estSuperior.setPeriodoYears(intPeriodo);

                aca.setNoAplicaEstudioSuperior(Boolean.FALSE);
                
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", msg);
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo procesar Estudio Superior");
            }

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            if(id!=null){
                EstudioSuperior estSuperior = EstudioSuperior.ClassMgr.getEstudioSuperior(id, wsite);
                if(estSuperior!=null){
                    try {
                        estSuperior.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente el Estudio Superior.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar el Estudio Superior");
                    }                    
                }                
            }
        } else if (action.equals("updateNoAplica")){
            //System.out.println("NoAplica: "+request.getParameter("noAplica"));
            String noAplica = request.getParameter("noAplica");
            msg="Se actualizó No aplican Estudio Superior";
            if(noAplica!=null&&noAplica.equals("true"))
            {
                aca.setNoAplicaEstudioSuperior(Boolean.TRUE);
            } else {
                aca.setNoAplicaEstudioSuperior(Boolean.FALSE);
            }

            response.setRenderParameter("act", "");
            response.setRenderParameter("alertmsg", msg);
            
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
            Iterator<TipoEstudio> it = SWBComparator.sortByDisplayName(TipoEstudio.ClassMgr.listTipoEstudios(wsite), usr.getLanguage());
            while (it.hasNext()) {
                TipoEstudio tipo = it.next();
                JSONObject jtipo = new JSONObject();
                items.put(jtipo);
                jtipo.put("id", tipo.getId());
                jtipo.put("name", tipo.getTitle());
                Iterator<DisciplinaEstudio> itarea = tipo.listDisciplinas();
                while (itarea.hasNext()) {
                    DisciplinaEstudio areaCarrera = itarea.next();
                    jtipo.put("disciplina", areaCarrera.getId());
                }
            }

            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }
    
    public void getDisciplina(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

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
            Iterator<DisciplinaEstudio> it = SWBComparator.sortByDisplayName(DisciplinaEstudio.ClassMgr.listDisciplinaEstudios(wsite), usr.getLanguage());
            while (it.hasNext()) {
                DisciplinaEstudio disc = it.next();
                JSONObject jtipo = new JSONObject();
                items.put(jtipo);
                jtipo.put("id", disc.getId());
                jtipo.put("name", disc.getTitle());
                TipoEstudio tipo = disc.getTipoEstudioInv();
                if(tipo!=null){
                    jtipo.put("tipo", tipo.getId());
                }
                Iterator<AreaEstudio> itarea = disc.listAreaEstudios();
                while (itarea.hasNext()) {
                    AreaEstudio areaEst = itarea.next();
                    jtipo.put("area", areaEst.getId());
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
            Iterator<AreaEstudio> it = SWBComparator.sortByDisplayName(AreaEstudio.ClassMgr.listAreaEstudios(wsite), usr.getLanguage());
            while (it.hasNext()) {
                AreaEstudio area = it.next();
                JSONObject jarea = new JSONObject();
                items.put(jarea);
                jarea.put("id", area.getId());
                jarea.put("name", area.getTitle());
                DisciplinaEstudio disciplina = area.getDisciplinaInv();
                    if (disciplina != null) {
                        jarea.put("disciplina", disciplina.getId());
                        TipoEstudio testu = disciplina.getTipoEstudioInv();
                        if(testu!=null){
                           jarea.put("tipo", testu.getId()); 
                        }
                    }
            }

            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }

    public void getEstudio(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
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
            Iterator<Estudios> it = SWBComparator.sortByDisplayName(Estudios.ClassMgr.listEstudioses(wsite), usr.getLanguage());
            while (it.hasNext()) {
                Estudios estu = it.next();
                JSONObject jestu = new JSONObject();
                items.put(jestu);
                jestu.put("id", estu.getId());
                jestu.put("name", estu.getTitle());
                AreaEstudio area = estu.getAreaEstudio();
                if(area!=null){
                    jestu.put("area", area.getId());
                    DisciplinaEstudio disc = area.getDisciplinaInv();
                    if (disc != null) {
                        jestu.put("disciplina", disc.getId());
                        TipoEstudio testu = disc.getTipoEstudioInv();
                        if(testu!=null){
                          jestu.put("tipo", testu.getId());  
                        }
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

        if (paramRequest.getMode().equals(MODE_DISCIPLINA)) {
            getDisciplina(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(MODE_TIPO)) {
            getTipo(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(MODE_AREA)) {
            getArea(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(MODE_POSGRADO)) {
            getEstudio(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest); 
        }
    }
}
