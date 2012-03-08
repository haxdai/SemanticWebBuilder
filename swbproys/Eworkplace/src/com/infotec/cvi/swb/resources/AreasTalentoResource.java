package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.AreaTalento;
import com.infotec.cvi.swb.Habilidad;
import com.infotec.cvi.swb.TipoTalento;

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
 * @author carlos.ramos
 */
public class AreasTalentoResource extends GenericResource {
    private Logger log = SWBUtils.getLogger(AreasTalentoResource.class);
    public static final String Mode_TLNT = "tlnt";
    public static final String Mode_HBLDS = "hblds";
    
    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                    e.printStackTrace(System.out);
                }
            }
        }
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        User user = response.getUser();
        if(!user.isSigned())
            return;
        
        final String action = response.getAction();
        WebSite wsite = response.getWebPage().getWebSite();

        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        if(cv==null) {
            log.error("Objeto semantico cv del usuario es nulo");
        }
        
        if(SWBResourceURL.Action_ADD.equals(action)) {
//            if(!validate(request, response))
//                return;
//            AreaTalento talento = AreaTalento.ClassMgr.createAreaTalento(wsite);
//            talento.setAreaTalento(SWBUtils.XML.replaceXMLChars(request.getParameter("tlnt")));
//            talento.setYearExperienceTalento(Integer.parseInt(request.getParameter("ytlnt")));
//            talento.setAreaDestrezaTI(SWBUtils.XML.replaceXMLChars(request.getParameter("dstrz")));
//            talento.setYearExpirienceTI(Integer.parseInt(request.getParameter("ydstrz")));
//            cv.addAreaTalento(talento);
        }else if(SWBResourceURL.Action_EDIT.equals(action)) {
//            final String distincionId = request.getParameter("id");
//            AreaTalento talento;
//            try {
//                talento = AreaTalento.ClassMgr.getAreaTalento(distincionId, wsite);
//            }catch(Exception e) {
//                response.setRenderParameter("alertmsg", "distincion no existe");
//                return;
//            }
//            if(!validate(request, response))
//                return;
//            
//            if(!cv.hasAreaTalento(talento)) {
//                response.setRenderParameter("alertmsg", "Tu cv no contiene esta distincion");
//                return;
//            }
            
//            talento.setAreaTalento(SWBUtils.XML.replaceXMLChars(request.getParameter("tlnt")));
//            talento.setYearExperienceTalento(Integer.parseInt(request.getParameter("ytlnt")));
//            talento.setAreaDestrezaTI(SWBUtils.XML.replaceXMLChars(request.getParameter("dstrz")));
//            talento.setYearExpirienceTI(Integer.parseInt(request.getParameter("ydstrz")));
//            response.setRenderParameter("alertmsg", "talento modifcado bien");
        }else if(SWBResourceURL.Action_REMOVE.equals(action)) {
            final String talentoId = request.getParameter("id");
            try {
                AreaTalento talento = AreaTalento.ClassMgr.getAreaTalento(talentoId, wsite);
                if(cv.hasAreaTalento(talento)) {
                    talento.remove();
                    response.setRenderParameter("alertmsg", "talento eliminado");
                }else {
                    response.setRenderParameter("alertmsg", "Tu cv no contiene este talento");
                }
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", "talento no se pudo eliminar");
                log.error(e);
            }
        }
    }
    
    private boolean validate(HttpServletRequest request, SWBActionResponse response) {
        if(request.getParameter("tlnt").isEmpty() || request.getParameter("dstrz").isEmpty()) {
            response.setRenderParameter("alertmsg", "faltan datos");
            return false;
        }
        try {
            Integer.parseInt(request.getParameter("ytlnt"));
            Integer.parseInt(request.getParameter("ydstrz"));
        }catch(Exception e) {
            response.setRenderParameter("alertmsg", "Los años de experiencia esta mal");
            return false;
        }
        return true;
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if(Mode_TLNT.equals(mode))
            doTalentType(request, response, paramRequest);
        else if(Mode_HBLDS.equals(mode))
            doSkillsType(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    
    public void doTalentType(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User user = paramRequest.getUser();
        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<TipoTalento> talentos = SWBComparator.sortByDisplayName(TipoTalento.ClassMgr.listTipoTalentos(wsite), user.getLanguage());
            while (talentos.hasNext()) {
                TipoTalento tipo = talentos.next();
                JSONObject jtipo = new JSONObject();
                items.put(jtipo);
                jtipo.put("id", tipo.getId());
                jtipo.put("name", tipo.getTitle());
//                Iterator<AreaCarrera> itarea = tipo.listAreas();
//                while (itarea.hasNext()) {
//                    AreaCarrera areaCarrera = itarea.next();
//                    jtipo.put("area", areaCarrera.getId());
//                }
            }
            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }
    
    public void doSkillsType(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User user = paramRequest.getUser();
        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<Habilidad> habilidades = SWBComparator.sortByDisplayName(Habilidad.ClassMgr.listHabilidads(wsite), user.getLanguage());
            while (habilidades.hasNext()) {
                Habilidad hbld = habilidades.next();
                JSONObject jtipo = new JSONObject();
                items.put(jtipo);
                jtipo.put("id", hbld.getId());
                jtipo.put("name", hbld.getTitle());
                jtipo.put("tipo", hbld.getTipoTalento().getId()); 
//                Iterator<AreaCarrera> itarea = tipo.listAreas();
//                while (itarea.hasNext()) {
//                    AreaCarrera areaCarrera = itarea.next();
//                    jtipo.put("area", areaCarrera.getId());
//                }
            }
            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }
}
