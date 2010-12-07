package org.semanticwb.ecosikan.votes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author José Said Olano García
 */
public class NewestIdeasByThemesAndChallengesResource extends GenericResource{

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Recurso NewestIdeasByThemesAndChallengesResource  ");
        RequestDispatcher rd = request.getRequestDispatcher("/work/said/las5IdeasMasNuevasPorTemaYPorRetos.jsp");
        try {
            request.setAttribute("resource", this.getResourceBase());
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
