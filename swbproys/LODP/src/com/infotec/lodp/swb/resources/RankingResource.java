/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Application;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.utils.LODPUtils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author rene.jara
 */
public class RankingResource extends GenericResource{

    public static final Logger log = SWBUtils.getLogger(RankingResource.class);
    /** Modo personalizada para procesar la peticion ajax*/
    public static final String Mode_AJAX="ajx";
    /** Accion personalizada para procesar la valoracion*/
    public static final String Action_RANK="rnk";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if (Mode_AJAX.equals(mode)) {
            doAjax(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        String suri=request.getParameter("suri");
        int rank;
        int average=0;
        try{
            rank=Integer.parseInt(request.getParameter("rank"));
        }catch(NumberFormatException ignored){
            rank=0;
        }
        if (Action_RANK.equals(action)) {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj = null;
            if (suri != null && !suri.equals("")&&rank>0) {
                gobj = ont.getGenericObject(suri);
                if (gobj != null && gobj instanceof Application) {
                    Application ap = (Application) gobj;
                    LODPUtils.updateAppRank(ap,rank);
                    average=Math.round(ap.getAverage());
                } else if (gobj != null && gobj instanceof Dataset) {
                    Dataset ds = (Dataset) gobj;
                    LODPUtils.updateDSRank(ds, rank);
                    average=Math.round(ds.getAverage());
                }
                response.setRenderParameter("rank", average+"");
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
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
    public void doAjax(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
System.out.println("doajax");
System.out.println("average:"+request.getParameter("rank"));
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "ajax.jsp";
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

}
