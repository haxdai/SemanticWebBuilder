package org.semanticwb.promexico;


import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.*;

public class SlideShowViewer extends org.semanticwb.promexico.base.SlideShowViewerBase 
{
    Logger log = SWBUtils.getLogger(SlideShowViewer.class);

    public SlideShowViewer()
    {
    }

   /**
   * Constructs a SlideShowViewer with a SemanticObject
   * @param base The SemanticObject with the properties for the SlideShowViewer
   */
    public SlideShowViewer(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/SlideShowViewer.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        Iterator<PictureSlide>itPicSlide = listPictureSlideses();
        Iterator<SlideButton> bttns = listButtonses();
        try {
            request.setAttribute("itPicSlide", itPicSlide);
            request.setAttribute("itButtons", bttns);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("isTargetNew", isTargetNew());
            request.setAttribute("idRes", getId());
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }
}