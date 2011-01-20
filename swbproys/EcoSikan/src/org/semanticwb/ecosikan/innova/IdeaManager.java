package org.semanticwb.ecosikan.innova;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.ChallengeManager.Phases;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class IdeaManager extends org.semanticwb.ecosikan.innova.base.IdeaManagerBase {
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
        final WebSite model = getResource().getWebSite();
        final String modelId = model.getId();
        final WebPage wp;
        if(request.getParameter("wp")!=null) {
            wp = model.getWebPage(request.getParameter("wp"));
            request.getSession(true).setAttribute("wp", wp);
        }else {
            wp = (WebPage)request.getSession(true).getAttribute("wp");
        }
        
        request.setAttribute("userCanEdit", userCanEdit(paramRequest.getUser()));
        request.setAttribute("paramRequest", paramRequest);
        
        String path = "/work/models/"+modelId+"/jsp/ideas/listIdeas.jsp";
        
        String action = paramRequest.getAction();
        if(paramRequest.Action_ADD.equals(action)) {
            if( wp instanceof Challenge || request.getParameter("Challenge")!=null ) {
                Challenge challenge = null;
                challenge = Challenge.ClassMgr.getChallenge(request.getParameter("Challenge"), model);
                if(challenge==null && wp instanceof Challenge) {
                    challenge = (Challenge)wp;
                    Phases phase = Phases.valueOf(challenge.getPhase());
                    if(Phases.Opened.equals(phase))
                        path = "/work/models/"+modelId+"/jsp/ideas/add.jsp";
                }
            }else if( wp instanceof Theme || request.getParameter("Theme")!=null ) {
                path = "/work/models/"+modelId+"/jsp/ideas/add.jsp";
            }
        }else if(Action_COMMENT.equals(action)) {
            String ideaId = request.getParameter("idea");
            System.out.println("comentar la idea "+ideaId+"....");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            WebPage parent = idea.getWp();
            if( parent instanceof Theme && IdeaStatus.Opened==IdeaStatus.valueOf(idea.getStatus()) ) {
                path = "/work/models/"+modelId+"/jsp/ideas/comment.jsp";
                System.out.println("comentar un tema");
            }else if( parent instanceof Challenge) {
                Challenge challenge = (Challenge)wp;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if(Phases.Opened==phase) {
                    path = "/work/models/"+modelId+"/jsp/ideas/comment.jsp";
                }
                System.out.println("comentar un reto");
            }
        }

        try {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            dis.include(request, response);
            dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/widgets/losUltimosComentarios.jsp");
            dis.include(request, response);
        }catch(Exception e) {
            log.error(e);
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebPage wp = response.getWebPage();
        WebSite model = wp.getWebSite();
        User user = response.getUser();

        if( response.Action_ADD.equals(action) ) {
            wp = (WebPage)request.getSession(true).getAttribute("wp");
            Idea idea = Idea.ClassMgr.createIdea(model);
            try {
                idea.addData(SWBUtils.XML.replaceXMLChars(request.getParameter("title")), SWBUtils.XML.replaceXMLChars(request.getParameter("desc")), wp);
            }catch(IllegalArgumentException iae) {
                response.setRenderParameter("msgerr", iae.getMessage());
                response.setRenderParameter("title", request.getParameter("title"));
                response.setRenderParameter("desc", request.getParameter("desc"));
                return;
            }
//            idea.setTitle(request.getParameter("title"));
//            idea.setDescription(request.getParameter("desc"));
//            idea.setStatus(IdeaStatus.Opened.name());
//            idea.setSelected(false);
//            idea.setWp(wp);
            if(wp instanceof Theme) {
                Theme theme = (Theme)wp;
                response.setRenderParameter("Theme", theme.getId());
                theme.addIdea(idea);
            }else if(wp instanceof Challenge) {
                Challenge challenge = (Challenge)wp;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if(Phases.Opened==phase)
                    challenge.addIdea(idea);
                response.setRenderParameter("Challenge", challenge.getId());
            }
            response.setAction(null);
        }else if( response.Action_EDIT.equals(action) ) {
            String ideaId = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            idea.edit(user);
//            wp = idea.getWp();
//            if(wp instanceof Theme &&  userCanEdit(user)) {
//                try {
//                    IdeaStatus status = IdeaStatus.valueOf(idea.getStatus());
//                    if(status.hasNext())
//                        idea.setStatus(status.next().name());
//                }catch(IllegalArgumentException iae) {
//                }
//            }
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
            idea.vote(request.getRemoteAddr(), votefor);
//            if( idea!=null && IdeaStatus.Opened==IdeaStatus.valueOf(idea.getStatus()) && votefor!=null && !votefor.isEmpty() ) {
//                if(canIPAddressVote(request.getRemoteAddr(), ideaId)) {
//                    if("u".equals(votefor)) { // votar por me gusta (u p)
//                        idea.setVotesP(idea.getVotesP()+1);
//                    }else if("d".equals(votefor)) { // votar por no me gusta (d own)
//                        idea.setVotesN(idea.getVotesN()+1);
//                    }
//                }
//            }
        }else if( Action_COMMENT.equals(action) ) {
            String securCodeSent = request.getParameter("scode");
            String securCodeCreated = (String)request.getSession(true).getAttribute("cdlog");
            String text = request.getParameter("comment");
            String ideaId = request.getParameter("idea");
            response.setRenderParameter("idea", ideaId);
            if( securCodeCreated!=null && securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
                idea.comment(text);
//                wp = idea.getWp();
//                if( wp instanceof Theme && IdeaStatus.Opened==IdeaStatus.valueOf(idea.getStatus()) && text!=null && !text.isEmpty() ) {
//                    Comment comment = Comment.ClassMgr.createComment(model);
//                    comment.setText(text);
//                    idea.addComment(comment);
//                    ((Theme)wp).offer(comment);
//                    ((Dependencia)wp.getParent()).offer(comment);
//                }else if( wp instanceof Challenge && text!=null && !text.isEmpty() ) {
//                    Challenge challenge = (Challenge)wp;
//                    Phases phase = Phases.valueOf(challenge.getPhase());
//                    if(Phases.Opened==phase) {
//                        Comment comment = Comment.ClassMgr.createComment(model);
//                        comment.setText(text);
//                        idea.addComment(comment);
//                        challenge.offer(comment);
//                        ((Dependencia)wp.getParent()).offer(comment);
//                    }
//                }
            }else {
                response.setRenderParameter("comment", text);
            }
            //response.setAction(null);
        }else if (Action_CATEGORIZE.equals(action)) {
            String categoryId = request.getParameter("cat");
            String ideaId = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            idea.categorize(categoryId);
//            wp = idea.getWp();
//            if( wp instanceof Challenge && categoryId!=null && !categoryId.isEmpty() ) {
//                Challenge challenge = (Challenge)wp;
//                Phases phase = Phases.valueOf(challenge.getPhase());
//                //if( Phases.Categorizing==phase ) {
//                    Category category = Category.ClassMgr.getCategory(categoryId, model);
//                    if(category!=null)
//                        idea.setCategory(category);
//                //}
//            }
        }else if( Action_SELECT.equals(action) ) {
            String selected = request.getParameter("cat");
            String ideaId = request.getParameter("idea");
            Idea idea = Idea.ClassMgr.getIdea(ideaId, model);
            if( selected!=null && !selected.isEmpty() )
                idea.select(Boolean.parseBoolean(selected));
//            wp = idea.getWp();
//            if( wp instanceof Challenge && selected!=null && !selected.isEmpty() ) {
//                Challenge challenge = (Challenge)wp;
//                Phases phase = Phases.valueOf(challenge.getPhase());
//                //if( Phases.Selecting==phase ) {
//                    idea.setSelected(Boolean.parseBoolean(selected));
//                //}
//            }
        }
    }

    private Boolean userCanEdit(User user) {
//        Role role = Role.ClassMgr.getRole(base.getAttribute("roleId"), wp.getWebSite());
//        User user = paramRequest.getUser();
//        final boolean canEdit = true;//user.hasRole(role);
        return true;
    }
}
