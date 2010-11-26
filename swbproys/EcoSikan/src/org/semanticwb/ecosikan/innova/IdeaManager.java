package org.semanticwb.ecosikan.innova;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.ChallengeManager.Phases;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class IdeaManager extends org.semanticwb.ecosikan.innova.base.IdeaManagerBase 
{
    private static Logger log = SWBUtils.getLogger(IdeaManager.class);

    public static final String Action_VOTE = "vote";
    public static final String Action_COMMENT = "comment";
    public static final String Action_CATEGORIZE = "categorize";
    public static final String Action_SELECT = "select";

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
                default:
                    return Executed;
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
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = wp.getWebSiteId();
        final Boolean userCanEdit = userCanEdit(paramRequest.getUser());

        request.setAttribute("paramRequest", paramRequest);
        request.setAttribute("userCanEdit", userCanEdit);
        
        String path = "/work/models/"+modelId+"/jsp/ideas/listIdeas.jsp";
        String action = paramRequest.getAction();
        if(paramRequest.Action_ADD.equals(action)) {
            if(wp instanceof Challenge) {
                Challenge challenge = (Challenge)wp;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if(Phases.Opened.equals(phase))
                    path = "/work/models/"+modelId+"/jsp/ideas/add.jsp";
            }else if(wp instanceof Theme) {
                path = "/work/models/"+modelId+"/jsp/ideas/add.jsp";
            }
        }else if(Action_COMMENT.equals(action)) {
            String ideaId = request.getParameter("idea");
            System.out.println("comentar la idea "+ideaId+"....");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            if( IdeaStatus.Opened==IdeaStatus.valueOf(idea.getStatus()) )
                if(wp instanceof Challenge) {
                    Challenge challenge = (Challenge)wp;
                    Phases phase = Phases.valueOf(challenge.getPhase());
                    if(Phases.Opened.equals(phase))
                        path = "/work/models/"+modelId+"/jsp/ideas/comment.jsp";
                }else if(wp instanceof Theme) {
                    path = "/work/models/"+modelId+"/jsp/ideas/comment.jsp";
                }
        }
        
        try {
            RequestDispatcher dis = request.getRequestDispatcher(path);
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
        User user = response.getUser();

        if( response.Action_ADD.equals(action) ) {
            Idea idea = Idea.ClassMgr.createIdea(model);
            idea.setTitle(request.getParameter("title"));
            idea.setDescription(request.getParameter("desc"));
            idea.setStatus(IdeaStatus.Opened.name());
            idea.setSelected(false);
            if(wp instanceof Theme) {
                Theme theme = (Theme)wp;
                theme.addIdea(idea);
            }else if(wp instanceof Challenge) {
                Challenge challenge = (Challenge)wp;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if(Phases.Opened==phase)
                    challenge.addIdea(idea);
            }
            response.setAction(null);
        }else if( response.Action_EDIT.equals(action) ) {
            String ideaId = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            if( wp instanceof Theme && idea!=null &&  userCanEdit(user) ) {
                try {
                    IdeaStatus status = IdeaStatus.valueOf(idea.getStatus());
                    if(status.hasNext())
                        idea.setStatus(status.next().name());
                }catch(IllegalArgumentException iae) {
                }
            }
        }else if( response.Action_REMOVE.equals(action) ) {
            String ideaId = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            if( idea!=null &&  userCanEdit(user) )
                idea.remove();
        }
        else if( Action_VOTE.equals(action) ) {
            String votefor = request.getParameter("vote");
            String ideaId = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            if( idea!=null && IdeaStatus.Opened==IdeaStatus.valueOf(idea.getStatus()) && votefor!=null && !votefor.isEmpty() )
                if("u".equals(votefor)) { // votar por me gusta (u p)
                    idea.setVotesP(idea.getVotesP()+1);
                }else if("d".equals(votefor)) { // votar por no me gusta (d own)
                    idea.setVotesN(idea.getVotesN()+1);
                }
        }else if( Action_COMMENT.equals(action) ) {
            String text = request.getParameter("comment");
            String ideaId = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            if( wp instanceof Theme && idea!=null && IdeaStatus.Opened==IdeaStatus.valueOf(idea.getStatus()) && text!=null && !text.isEmpty() ) {
                Comment comment = Comment.ClassMgr.createComment(model);
                comment.setText(text);
                idea.addComment(comment);
            }else if( wp instanceof Challenge && idea!=null && text!=null && !text.isEmpty() ) {
                Challenge challenge = (Challenge)wp;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if(Phases.Opened==phase) {
                    Comment comment = Comment.ClassMgr.createComment(model);
                    comment.setText(text);
                    idea.addComment(comment);
                }
            }
            response.setAction(null);
        }else if (Action_CATEGORIZE.equals(action)) {
            String categoryId = request.getParameter("cat");
            String ideaId = request.getParameter("idea");
            if( wp instanceof Challenge && ideaId!=null && categoryId!=null ) {
                Challenge challenge = (Challenge)wp;
                Phases phase = Phases.valueOf(challenge.getPhase());
                //if( Phases.Categorizing==phase ) {
                    Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
                    Category category = Category.ClassMgr.getCategory(categoryId, model);
                    if( idea!=null && category!=null )
                        idea.setCategory(category);
                //}
            }
        }else if( Action_SELECT.equals(action) ) {
            String selected = request.getParameter("cat");
            String ideaId = request.getParameter("idea");
            System.out.println("processAction..\nselected="+selected+", ideaId="+ideaId);
            if( wp instanceof Challenge && ideaId!=null && selected!=null ) {
                Challenge challenge = (Challenge)wp;
                Phases phase = Phases.valueOf(challenge.getPhase());
                //if( Phases.Selecting==phase ) {
                    Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
                    boolean select = Boolean.parseBoolean(selected);
                    System.out.println("select="+select);
                    System.out.println("idea="+idea);
                    if( idea!=null )
                        idea.setSelected(select);
                //}
            }
        }
    }

    private Boolean userCanEdit(User user) {
//        Role role = Role.ClassMgr.getRole(base.getAttribute("roleId"), wp.getWebSite());
//        User user = paramRequest.getUser();
//        final boolean canEdit = true;//user.hasRole(role);
        return true;
    }
}
