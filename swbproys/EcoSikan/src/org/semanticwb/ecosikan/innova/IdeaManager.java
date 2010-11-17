package org.semanticwb.ecosikan.innova;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class IdeaManager extends org.semanticwb.ecosikan.innova.base.IdeaManagerBase 
{
    private static Logger log = SWBUtils.getLogger(IdeaManager.class);

    public static final String Action_VOTE = "vote";
    public static final String Action_COMMENT = "coment";
    public static final String Action_ADD_TO_THEME = "addToTheme";
    public static final String Action_ADD_TO_CHALLENGE = "addToChallenge";

    public IdeaManager() {
    }

    public enum IdeaStatus {
        Opened("Abierto"),
        Revise("En revisión"),
        Revised("Revisado"),
        Running("En ejecución"),
        Executed("Ejecutado");
        private String description;
        IdeaStatus(String description) {
            this.description = description;
        }
        public String getDescription() {
            return this.description;
        }
        public IdeaStatus next() {
            switch(this) {
                case Opened:
                    return Revise;
                case Revise:
                    return Revised;
                case Revised:
                    return Running;
                case Running:
                    return Executed;
                case Executed:
                    return null;
                default:
                    return null;
            }
        }
        public boolean hasNext() {
            switch(this) {
                case Executed:
                    return false;
                default:
                    return true;
            }
        }
    }


   /**
   * Constructs a IdeaManager with a SemanticObject
   * @param base The SemanticObject with the properties for the IdeaManager
   */
    public IdeaManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        WebPage wp = paramRequest.getWebPage();
        final String modelId = wp.getWebSiteId();
        String path = "/work/models/"+modelId+"/jsp/ideas/listIdeas.jsp";
        
        String action = paramRequest.getAction();
        if(Action_ADD_TO_CHALLENGE.equals(action)) {
            path = "/work/models/"+modelId+"/jsp/ideas/addToChallenge.jsp";
        }else if(Action_ADD_TO_THEME.equals(action)) {
            path = "/work/models/"+modelId+"/jsp/ideas/addToTheme.jsp";
        }

        System.out.println("\n\n............\naction="+action+"\npath="+path);


        try {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            //request.setAttribute("statusCBOX", status_CBOX);
            dis.include(request, response);
        }catch(Exception e) {
            log.error(e);
            System.out.println(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebPage wp = response.getWebPage();
        WebSite model = wp.getWebSite();
        if( Action_ADD_TO_THEME.equals(action) ) {
            Idea idea = Idea.ClassMgr.createIdea(model);
            idea.setTitle(request.getParameter("title"));
            idea.setDescription(request.getParameter("desc"));
            idea.setStatus(IdeaStatus.Opened.name());
            idea.setSelected(false);
            Theme theme = (Theme)wp;
            theme.addIdea(idea);
            response.setAction(null);
        }else if( Action_ADD_TO_CHALLENGE.equals(action) ) {
            
        }else if( response.Action_EDIT.equals(action) ) {
            IdeaStatus status;            
            String id = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(id, model);
            try {
                status = IdeaStatus.valueOf(idea.getStatus());
            }catch(IllegalArgumentException iae) {
                status = IdeaStatus.Executed;
            }
            idea.setStatus(status.next().name());
        }else if( Action_VOTE.equals(action) ){
            String vote = request.getParameter("vote");
            String id = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(id, model);
            if("u".equals(vote)) { // voto me gusta (up)
                idea.setVotesP(idea.getVotesP()+1);
            }else if("d".equals(vote)) { // voto no me gusta (down)
                idea.setVotesN(idea.getVotesN()+1);
            }
        }else if( response.Action_REMOVE.equals(action) ) {
            String id = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(id, model);
            if( idea!=null )
                idea.remove();
        }
    }
}
