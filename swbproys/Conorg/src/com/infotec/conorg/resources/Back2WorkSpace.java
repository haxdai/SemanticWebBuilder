/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import com.infotec.conorg.WorkSpace;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author juan.fernandez
 */
public class Back2WorkSpace extends GenericResource {
    public static final Logger log = SWBUtils.getLogger(Back2WorkSpace.class);
    
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
    
    public static WorkSpace findWorkSpaceParent(WebPage wpage){
        WorkSpace wrkspc = null;
        WebSite wsite = wpage.getWebSite();
        WebPage wptmp = wpage;
        //System.out.print("Buscando WorkSpace");
        while(wptmp!=null&&!wptmp.getParent().equals(wsite.getHomePage())){
            wptmp = wptmp.getParent();
            if(wptmp instanceof WorkSpace){
                //System.out.println(" ............... encontrado");
                wrkspc = (WorkSpace)wptmp;
                break;
            }
        }
        return wrkspc;
    }
}
