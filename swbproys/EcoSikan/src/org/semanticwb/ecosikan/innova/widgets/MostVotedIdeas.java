package org.semanticwb.ecosikan.innova.widgets;

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
public class MostVotedIdeas extends GenericResource{

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Recurso MostVotedIdeasByThemesAndChallengesResource  ");
        final WebPage wp = paramRequest.getWebPage();
        final String modelId = wp.getWebSiteId();
        String path = "/work/models/"+modelId+"/jsp/widgets/las5IdeasMasVotadasPorTemaYPorRetos.jsp";
        //RequestDispatcher rd = request.getRequestDispatcher("/work/said/las5IdeasMasVotadasPorTemaYPorRetos.jsp");
        RequestDispatcher rd = request.getRequestDispatcher( path );
        try {
            request.setAttribute("resource", this.getResourceBase());
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
