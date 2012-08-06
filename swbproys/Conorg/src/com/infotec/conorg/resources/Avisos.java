/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import com.infotec.conorg.Shelf;
import com.infotec.conorg.WorkSpace;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author juan.fernandez
 */
public class Avisos extends GenericAdmResource{
    public static final Logger log = SWBUtils.getLogger(Avisos.class);
    public static final SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yy hh:mm");

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        Resource base = getResourceBase();
        String confClass = base.getAttribute(MyShelf.RES_CONF, "http://www.infotec.com/conorg.owl#Shelf");

        String path = basePath + "view.jsp";

        if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
            path = basePath + "viewShelf.jsp";
        } else if (confClass.equals(WorkSpace.conorg_WorkSpace.getURI())) {
            path = basePath + "viewWS.jsp";
        }

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
        super.processAction(request, response);
    }
    
    
    
    
    
}
