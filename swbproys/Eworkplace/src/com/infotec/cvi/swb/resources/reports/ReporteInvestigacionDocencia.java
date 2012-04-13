/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources.reports;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author juan.fernandez
 */
public class ReporteInvestigacionDocencia extends GenericResource {

    private Logger log = SWBUtils.getLogger(ReporteInvestigacionDocencia.class);
    private static final String MODE_EXPORT = "export";

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
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        if (paramRequest.getMode().equals(MODE_EXPORT)) {
            doExport(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doExport(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setHeader("Content-Disposition", " attachment; filename=\"reportInvestigacionDocencia" + System.currentTimeMillis() + ".xls\";");
        response.setContentType("application/vnd.ms-excel"); //
        
        doView(request, response, paramRequest);
        
//        String reporte = "";
//        reporte = request.getParameter("reporte");
//        
//        if(reporte==null) reporte = "Reporte sin datos...";
//        else reporte = SWBUtils.TEXT.decodeBase64(reporte);
//        InputStream fin = null;
//        fin = SWBUtils.IO.getStreamFromString(reporte);
//        OutputStream out = response.getOutputStream();
//        SWBUtils.IO.copyStream(fin, out);
//        out.close();
    }
}
