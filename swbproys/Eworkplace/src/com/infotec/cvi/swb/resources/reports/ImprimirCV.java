package com.infotec.cvi.swb.resources.reports;

import com.infotec.cvi.swb.CV;
import com.itextpdf.text.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author rene.jara
 */
public class ImprimirCV extends GenericResource {
    public static Logger log = SWBUtils.getLogger(ImprimirCV.class);
    public static final String Mode_PDF = "pdf";
    public static final BaseColor b = new BaseColor(1799611);
    public static final BaseColor h1 = new BaseColor(1530);
    public static final BaseColor h4 = new BaseColor(3381555);
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if(Mode_PDF.equals(mode))
            doPdf(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        User user = paramsRequest.getUser();

        RequestDispatcher dis = request.getRequestDispatcher(basePath + "/viewCV.jsp");
        try {
            request.setAttribute("paramRequest", paramsRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    public void doPdf(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        final String path = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/pdf.jsp";

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void doXML(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/xml; charset=ISO-8859-1");
        
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;

        WebSite wsite = paramRequest.getWebPage().getWebSite();
        CV cv = CV.ClassMgr.getCV(user.getId(), wsite) ;
        org.w3c.dom.Document dom = cv.toDom(user);
        response.getWriter().print(SWBUtils.XML.domToXml(dom, "ISO-8859-1", true));
    }
    
    public static Image getImage(final String path) throws Exception {
        Image img = Image.getInstance(path);
        img.setAlignment(Image.ALIGN_LEFT | Image.TEXTWRAP);
        img.setBorder(Image.BOX);
        img.setBorderWidthLeft(3f);
        img.setBorderWidthRight(2f);
        img.setBorderWidthTop(1f);
        img.setBorderWidthBottom(1f);
        img.setBorderColor(BaseColor.WHITE);
        return img;
    }
}
