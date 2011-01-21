package org.semanticwb.ecosikan.innova.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.Challenge;
import org.semanticwb.ecosikan.innova.ChallengeManager.Phases;
import org.semanticwb.ecosikan.innova.Idea;
import org.semanticwb.ecosikan.innova.base.ChallengeBase;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import static org.semanticwb.ecosikan.innova.IdeaManager.*;

public class MostVotedIdeas extends GenericResource {
    public static final int List_Last = 3;

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final WebPage wp = paramRequest.getWebPage();
        final String modelId = wp.getWebSiteId();
        String path = "/work/models/"+modelId+"/jsp/widgets/las5IdeasMasVotadas.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }


        /*PrintWriter out = response.getWriter();

        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = wp.getWebSiteId();
        
        request.setAttribute("paramRequest", paramRequest);
        RequestDispatcher dis;
        if(wp==model.getHomePage()) {
            Boolean userCanAdd = true;
            Challenge challenge = null;
            Iterator<Challenge> challenges = ChallengeBase.ClassMgr.listChallenges(model);
            while( challenges.hasNext()&&userCanAdd ) {
                challenge = challenges.next();
                Phases phase = Phases.Closed;
                try {
                    phase = Phases.valueOf(challenge.getPhase());
                }catch(IllegalArgumentException iae) {
                    challenge.setPhase(Phases.Closed.name());
                }catch(NullPointerException npe) {
                    challenge.setPhase(Phases.Closed.name());
                }
                userCanAdd = userCanAdd && phase==Phases.Closed;
            }
            if(challenge!=null) {
                User user = paramRequest.getUser();
                SWBResourceURL urlComment = paramRequest.getRenderUrl().setAction(Action_COMMENT);
                List<Idea> ideas = SWBUtils.Collections.copyIterator(challenge.listIdeas());
                Iterator<Idea> more = getRecent(3, ideas);
                
                out.println("<div class=\"idea ideaw\">");
                for(int j=1; more.hasNext(); j++) {
                    Idea idea = more.next();
                    out.println(" <div class=\"foco\">"+j+"</div>");
                    out.println(" <div class=\"info\">");
                    out.println("   <div class=\"votabox\">");
                    out.println("     <div class=\"agree\">");
                    out.println(       idea.getVotesP()+"<img align=\"absmiddle\" alt=\"Estoy de acuerdo\" src=\"/work/models/EcoSikan/Template/7/1/images/deacuerdo.gif\" />");
                    out.println("     </div>");
                    out.println("     <div class=\"agree\">");
                    out.println(       idea.getVotesN()+"<img align=\"absmiddle\" alt=\"Estoy de acuerdo\" src=\"/work/models/EcoSikan/Template/7/1/images/desacuerdo.gif\" />");
                    out.println("     </div>");
                    out.println("     <div class=\"btn\">");
                    out.println("      <a href=\"#\" onclick=\"window.location.href='"+urlComment.setParameter("idea",idea.getId())+"'\">COMENTA</a>");
                    out.println("     </div>");
                    out.println("   </div>");
                    out.println("   <a href=\"#\"><b>"+idea.getCreator().getName()+"</b></a>");
                    out.println("   <br/>");
                    out.println("   <h3>"+idea.getTitle()+"</h3>");
                    out.println("   <p align=\"justify\">"+idea.getDescription()+"</p>");
                    out.println(" </div>");
                    out.println(" <div class=\"clearfix\"></div>");
                }
                out.println("</div>");
            }
        }else if(wp instanceof Challenge) {
            String path = "/work/models/"+modelId+"/jsp/widgets/las5IdeasMasVotadas.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path );
            try {
                request.setAttribute("paramRequest", paramRequest);
                rd.include(request, response);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }*/
    }

    public Iterator<Idea> getRecent(int length, List<Idea> ideas) throws IllegalArgumentException {
        if (length < 1) {
            throw new IllegalArgumentException("El argumento length debe ser mayor que cero");
        }
        Collections.sort(ideas, new Idea.IdeasSortByPositiveVotes());
        Collections.reverse(ideas);
        if(ideas.size()>=length)
            return ideas.subList(0, length).iterator();
        else
            return ideas.iterator();
    }
}
