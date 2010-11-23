package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class ChallengeManager extends org.semanticwb.ecosikan.innova.base.ChallengeManagerBase {
    private static Logger log = SWBUtils.getLogger(ChallengeManager.class);
    
    public static final String Action_EDITALLCATEGORIES = "editAllCategories";
    public static final String Action_ADDCATEGORY = "addCategory";
    public static final String Action_EDITCATEGORY = "editCategory";
    public static final String Action_REMOVECATEGORY = "removeCategory";
    
    public static final String Action_EDITALLDESIRES = "editAllDesires";
    public static final String Action_ADDDESIRE = "addDesire";
    public static final String Action_EDITDESIRE = "editDesire";
    public static final String Action_REMOVEDESIRE = "removeDesire";

    public static final String Action_EDITALLSTKHLDRS = "editAllStkHldrs";
    public static final String Action_ADDSTKHLDR = "addStkHldr";
    public static final String Action_EDITSTKHLDR = "editStkHldr";
    public static final String Action_REMOVESTKHLDR = "removeStkHldr";

    public static final String Action_UPDATEPHASE = "updatePhase";

    public ChallengeManager() {
    }

   /**
   * Constructs a ChallengeManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ChallengeManager
   */
    public ChallengeManager(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    public enum Phases {
        Opened("Abierto"),
        Categorizing("Categorización"),
        Selecting("Selección"),
        Solution("Generación de solucón"),
        Closed("Cerrado");
        private String description;
        Phases(String description) {
            this.description = description;
        }
        public String getDescription() {
            return this.description;
        }
        public Phases next() {
            switch(this) {
                case Opened:
                    return Categorizing;
                case Categorizing:
                    return Selecting;
                case Selecting:
                    return Solution;
                case Solution:
                    return Closed;
                case Closed:
                default:
                    return Closed;
            }
        }
        public boolean hasNext() {
            switch(this) {
                case Closed:
                    return false;
                default:
                    return true;
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = wp.getWebSiteId();
        final Boolean userCanEdit = userCanEdit(paramRequest.getUser());

        request.setAttribute("paramRequest", paramRequest);
        request.setAttribute("userCanEdit", userCanEdit);
        
//        Challenge challenge = Challenge.ClassMgr.createChallenge(model);
//        challenge.setParent(model.getHomePage());
//        challenge.setTitle("Erradicar el crimen organizado");
//        challenge.setDescription("Erradicar el cancer de la droga y sus cárteles");
//        challenge.setActive(true);
//        challenge.setPhase(Phases.Opened.name());

        RequestDispatcher dis;
        String path;
        Challenge challenge = (Challenge)wp;

        if(userCanEdit) {
            dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/phases.jsp");
            try {
                dis.include(request, response);
            }catch (Exception e) {
                log.error(e);
            }
        }

//        if( Phases.Opened==Phases.valueOf(challenge.getPhase()) ) {
//        }else if( Phases.Categorizing==Phases.valueOf(challenge.getPhase()) ) {
//        }else if( Phases.Selecting==Phases.valueOf(challenge.getPhase()) ) {
//        }else if( Phases.Solution==Phases.valueOf(challenge.getPhase()) ) {
//        }else if( Phases.Closed==Phases.valueOf(challenge.getPhase()) ) {
//        }else {
//        }

        
        dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/categories.jsp");
        try {
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
        }
        
        dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/desires.jsp");
        try {
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
        
        dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/stakeholders.jsp");
        try {
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        WebPage wp = response.getWebPage();
        WebSite model = wp.getWebSite();
        Challenge challenge = (Challenge)wp;
        
        String action = response.getAction();
        if(Action_ADDCATEGORY.equals(action)) {
            if(request.getParameter("catname")!=null&!request.getParameter("catname").isEmpty()&&request.getParameter("catdesc")!=null&&!request.getParameter("catdesc").isEmpty()) {
                Category category = Category.ClassMgr.createCategory(model);
                category.setTitle(request.getParameter("catname").replaceAll(" ", ""));
                category.setDescription(request.getParameter("catdesc"));
                challenge.addCategory(category);
                response.setAction(null);
            }
        }else if(Action_EDITCATEGORY.equals(action)) {
            if(request.getParameter("catname")!=null&!request.getParameter("catname").isEmpty()&&request.getParameter("catdesc")!=null&&!request.getParameter("catdesc").isEmpty()) {
                String categoryId = request.getParameter("cat");
                Category category = Category.ClassMgr.getCategory(categoryId, model);
                if(challenge.hasCategory(category)) {
                    category.setTitle(request.getParameter("catname").replaceAll(" ", ""));
                    category.setDescription(request.getParameter("catdesc"));
                }
                response.setAction(null);
            }
        }else if(Action_REMOVECATEGORY.equals(action)) {
            String categoryId = request.getParameter("cat");
            Category category = Category.ClassMgr.getCategory(categoryId, model);
            category.remove();
            response.setAction(null);
        }

        else if(Action_ADDDESIRE.equals(action)) {
            if(request.getParameter("des")!=null&!request.getParameter("des").isEmpty()) {
                challenge.addDesire(request.getParameter("des"));
                response.setAction(null);
            }
        }else if(Action_EDITDESIRE.equals(action)) {
            if(request.getParameter("des")!=null&!request.getParameter("des").isEmpty()) {
                String curDesire = request.getParameter("hdes");
                challenge.removeDesire(curDesire);
                challenge.addDesire(request.getParameter("des"));
                response.setAction(null);
            }
        }else if(Action_REMOVEDESIRE.equals(action)) {
            challenge.removeDesire(request.getParameter("des"));
            response.setAction(null);
        }
        
        else if(Action_ADDSTKHLDR.equals(action)) {
            if(request.getParameter("stkhldr")!=null&!request.getParameter("stkhldr").isEmpty()) {
                challenge.addStakeholder(request.getParameter("stkhldr"));
                response.setAction(null);
            }
        }else if(Action_EDITSTKHLDR.equals(action)) {
            if(request.getParameter("stkhldr")!=null&!request.getParameter("stkhldr").isEmpty()) {
                String curDesire = request.getParameter("hstkhldr");
                challenge.removeStakeholder(curDesire);
                challenge.addStakeholder(request.getParameter("stkhldr"));
                response.setAction(null);
            }
        }else if(Action_REMOVESTKHLDR.equals(action)) {
            challenge.removeStakeholder(request.getParameter("stkhldr"));
            response.setAction(null);
        }

        else if(Action_UPDATEPHASE.equals(action)) {
            Phases phase = Phases.valueOf(challenge.getPhase());
            if(phase.hasNext())
                challenge.setPhase(phase.next().name());
        }
    }

    private Boolean userCanEdit(User user) {
//        Role role = Role.ClassMgr.getRole(base.getAttribute("roleId"), wp.getWebSite());
//        User user = paramRequest.getUser();
//        final boolean canEdit = true;//user.hasRole(role);
        return true;
    }

}
