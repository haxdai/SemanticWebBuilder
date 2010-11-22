package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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

    public ChallengeManager()
    {
    }

   /**
   * Constructs a ChallengeManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ChallengeManager
   */
    public ChallengeManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        WebSite model = paramRequest.getWebPage().getWebSite();
//        Challenge challenge = Challenge.ClassMgr.createChallenge(model);
//        challenge.setParent(model.getHomePage());
//        challenge.setTitle("Erradicar el crimen organizado");
//        challenge.setDescription("Erradicar el cancer de la droga y sus cárteles");
//        challenge.setActive(true);
        
        RequestDispatcher dis;

        Boolean userCanEdit = userCanEdit(paramRequest.getUser());
        String path = "/work/models/"+model.getId()+"/jsp/challenges/categories.jsp";
        dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("userCanEdit", userCanEdit);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
        }
        path = "/work/models/"+model.getId()+"/jsp/challenges/desires.jsp";
        dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("userCanEdit", userCanEdit);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
        path = "/work/models/"+model.getId()+"/jsp/challenges/stakeholders.jsp";
        dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("userCanEdit", userCanEdit);
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
    }

    private Boolean userCanEdit(User user) {
        return true;
    }

}
