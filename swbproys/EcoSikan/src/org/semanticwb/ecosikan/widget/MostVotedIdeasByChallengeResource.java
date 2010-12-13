package org.semanticwb.ecosikan.widget;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author José Said Olano García
 */
public class MostVotedIdeasByChallengeResource extends GenericResource{

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final WebPage wp = paramRequest.getWebPage();
        final String modelId = wp.getWebSiteId();
        PrintWriter out = response.getWriter();
        out.println("Recurso MostVotedIdeasByChallengeResource  ");
        String path = "/work/models/"+modelId+"/jsp/widgets/las5IdeasMasVotadasPorReto.jsp";
        //out.println("path "+ path);
        //RequestDispatcher rd = request.getRequestDispatcher("/work/said/las5IdeasMasVotadasPorReto.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("resource", this.getResourceBase());
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
