package org.semanticwb.ecosikan.innova.widgets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

public class LastComments extends GenericResource {
    private static Logger log = SWBUtils.getLogger(LastComments.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final WebSite model = paramRequest.getWebPage().getWebSite();
        final String modelId = model.getId();
        request.setAttribute("paramRequest", paramRequest);
        try {
            RequestDispatcher dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/widgets/losUltimosComentarios.jsp");
            dis.include(request, response);
        }catch(Exception e) {
            log.error(e);
            e.printStackTrace(System.out);
        }
    }
}
