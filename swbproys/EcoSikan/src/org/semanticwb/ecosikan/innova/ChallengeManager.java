package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.base.ChallengeBase;
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
        Boolean userCanEdit = userCanEdit(paramRequest.getUser());

        request.setAttribute("paramRequest", paramRequest);
        RequestDispatcher dis;
        if(wp==model.getHomePage() && userCanEdit) {
            Boolean userCanAdd = true;
            Iterator<Challenge> challenges = ChallengeBase.ClassMgr.listChallenges(model);
            while( challenges.hasNext()&&userCanAdd ) {
                Challenge challenge = challenges.next();
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
            if(userCanAdd) {
                request.setAttribute("userCanEdit", userCanAdd);
                dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/add.jsp");
                try {
                    dis.include(request, response);
                }catch (Exception e) {
                    log.error(e);
                }
            }
        }else if(wp instanceof Challenge) {
            request.setAttribute("userCanEdit", userCanEdit);
            Challenge challenge = (Challenge)wp;
            Phases phase;
            try {
                phase = Phases.valueOf(challenge.getPhase());
            }catch(IllegalArgumentException iae) {
                phase = Phases.Closed;
                challenge.setPhase(phase.name());
                userCanEdit = false;
            }

            if( phase==Phases.Opened && challenge.getExpiration().before(new Date()) ) {
                challenge.setPhase(phase.next().name());
            }

            PrintWriter out = response.getWriter();
            out.println("<p>"+challenge.getTitle()+"</p>");
            out.println("<p>"+challenge.getDescription()+"</p>");
            if(userCanEdit)
                out.println("<p><a href=\"\">Editar</a></p>");

            if(userCanEdit) {
                dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/phases.jsp");
                try {
                    dis.include(request, response);
                }catch (Exception e) {
                    log.error(e);
                }
            }
            try {
                if( phase.ordinal()<Phases.Selecting.ordinal() ) {
                    dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/categories.jsp");
                    try {
                        dis.include(request, response);
                    }catch (Exception e) {
                        log.error(e);
                    }
                }
            }catch(IllegalArgumentException iae) {
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
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = wp.getWebSiteId();
        Boolean userCanEdit = userCanEdit(paramRequest.getUser());

        if(userCanEdit && wp instanceof Challenge ) {
            Challenge challenge = (Challenge)wp;
            RequestDispatcher dis;
            dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/challenges/edit.jsp");
            try {
                dis.include(request, response);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }


    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        WebPage wp = response.getWebPage();
        WebSite model = wp.getWebSite();
        final boolean userCanEdit = userCanEdit(response.getUser());

        String action = response.getAction();
        if(response.Action_ADD.equals(action)&&userCanEdit) {
            boolean userCanAdd = true;
            Iterator<Challenge> challenges = ChallengeBase.ClassMgr.listChallenges(model);
            while(challenges.hasNext()&&userCanAdd) {
                Challenge challenge = challenges.next();
                Phases phase = Phases.Closed;
                try {
                    phase = Phases.valueOf(challenge.getPhase());
                }catch(IllegalArgumentException iae) {
                }
                userCanAdd = userCanAdd && phase==Phases.Closed;
            }
            if( userCanAdd && request.getParameter("title")!=null&&!request.getParameter("title").isEmpty() && request.getParameter("desc")!=null&&!request.getParameter("desc").isEmpty() && request.getParameter("expire")!=null&&!request.getParameter("expire").isEmpty()) {
                Challenge challenge = Challenge.ClassMgr.createChallenge(model);
                challenge.setParent(model.getHomePage());
                challenge.setTitle(request.getParameter("title").trim());
                challenge.setDescription(request.getParameter("desc").trim());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
                try {
                    System.out.println("adding reto... expire="+request.getParameter("expire")+" 12:00");
                    challenge.setExpiration(sdf.parse(request.getParameter("expire")+" 12:00"));
                }catch(ParseException pe) {
                    GregorianCalendar expire = new GregorianCalendar();
                    expire.add(GregorianCalendar.MONTH, 1);
                    challenge.setExpiration(expire.getTime());
                }
                challenge.setActive(true);
                challenge.setPhase(Phases.Opened.name());
                response.sendRedirect(challenge.getRealUrl());
            }
        }else if(response.Action_EDIT.equals(action)&&userCanEdit) {

        }else if(response.Action_REMOVE.equals(action)&&userCanEdit) {

        }

        else if(Action_ADDCATEGORY.equals(action)&&userCanEdit) {
            if(request.getParameter("catname")!=null&&!request.getParameter("catname").isEmpty()&&request.getParameter("catdesc")!=null&&!request.getParameter("catdesc").isEmpty()) {
                Category category = Category.ClassMgr.createCategory(model);
                category.setTitle(request.getParameter("catname").replaceAll(" ", ""));
                category.setDescription(request.getParameter("catdesc"));
                Challenge challenge = (Challenge)wp;
                challenge.addCategory(category);
                response.setAction(null);
            }
        }else if(Action_EDITCATEGORY.equals(action)&&userCanEdit) {
            if(request.getParameter("catname")!=null&!request.getParameter("catname").isEmpty()&&request.getParameter("catdesc")!=null&&!request.getParameter("catdesc").isEmpty()) {
                String categoryId = request.getParameter("cat");
                Category category = Category.ClassMgr.getCategory(categoryId, model);
                Challenge challenge = (Challenge)wp;
                if(challenge.hasCategory(category)) {
                    category.setTitle(request.getParameter("catname").replaceAll(" ", ""));
                    category.setDescription(request.getParameter("catdesc"));
                }
                response.setAction(null);
            }
        }else if(Action_REMOVECATEGORY.equals(action)&&userCanEdit) {
            String categoryId = request.getParameter("cat");
            Category category = Category.ClassMgr.getCategory(categoryId, model);
            category.remove();
            response.setAction(null);
        }

        else if(Action_ADDDESIRE.equals(action)&&userCanEdit) {
            if(request.getParameter("des")!=null&!request.getParameter("des").isEmpty()) {
                Challenge challenge = (Challenge)wp;
                challenge.addDesire(request.getParameter("des"));
                response.setAction(null);
            }
        }else if(Action_EDITDESIRE.equals(action)&&userCanEdit) {
            if(request.getParameter("des")!=null&!request.getParameter("des").isEmpty()) {
                String curDesire = request.getParameter("hdes");
                Challenge challenge = (Challenge)wp;
                challenge.removeDesire(curDesire);
                challenge.addDesire(request.getParameter("des"));
                response.setAction(null);
            }
        }else if(Action_REMOVEDESIRE.equals(action)&&userCanEdit) {
            Challenge challenge = (Challenge)wp;
            challenge.removeDesire(request.getParameter("des"));
            response.setAction(null);
        }

        else if(Action_ADDSTKHLDR.equals(action)&&userCanEdit) {
            if(request.getParameter("stkhldr")!=null&!request.getParameter("stkhldr").isEmpty()) {
                Challenge challenge = (Challenge)wp;
                challenge.addStakeholder(request.getParameter("stkhldr"));
                response.setAction(null);
            }
        }else if(Action_EDITSTKHLDR.equals(action)&&userCanEdit) {
            if(request.getParameter("stkhldr")!=null&!request.getParameter("stkhldr").isEmpty()) {
                String curDesire = request.getParameter("hstkhldr");
                Challenge challenge = (Challenge)wp;
                challenge.removeStakeholder(curDesire);
                challenge.addStakeholder(request.getParameter("stkhldr"));
                response.setAction(null);
            }
        }else if(Action_REMOVESTKHLDR.equals(action)&&userCanEdit) {
            Challenge challenge = (Challenge)wp;
            challenge.removeStakeholder(request.getParameter("stkhldr"));
            response.setAction(null);
        }

        else if(Action_UPDATEPHASE.equals(action)&&userCanEdit) {
            Challenge challenge = (Challenge)wp;
            Phases phase = Phases.Closed;
            try {
                phase = Phases.valueOf(challenge.getPhase());
            }catch(IllegalArgumentException iae) {
            }
            if(phase.hasNext()) {
                challenge.setPhase(phase.next().name());
            }
        }
    }

    private Boolean userCanEdit(User user) {
//        boolean userCanEdit = false;
//        String roleId = getResourceBase().getAttribute("editChallengeRole");
//        Role role = null;
//
//        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
//        try {
//            GenericObject gobj = ont.getGenericObject(roleId);
//            if( gobj!=null && gobj instanceof Role && user.hasRole(role) ) {
//                userCanEdit = true;
//            }
//        }catch (Exception e) {
//            log.error(e);
//        }
//        return userCanEdit;
        return true;
    }

}
