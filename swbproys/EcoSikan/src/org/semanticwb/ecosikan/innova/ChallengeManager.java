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
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        WebPage wp = response.getWebPage();
        WebSite model = wp.getWebSite();
        
        String action = response.getAction();
        if(Action_ADDCATEGORY.equals(action)) {
            if(request.getParameter("name")!=null&!request.getParameter("name").isEmpty()&&request.getParameter("desc")!=null&&!request.getParameter("desc").isEmpty()) {
                Category category = Category.ClassMgr.createCategory(model);
                category.setTitle(request.getParameter("name").replaceAll(" ", ""));
                category.setDescription(request.getParameter("desc"));
                Challenge challenge = (Challenge)wp;
                challenge.addCategory(category);
                response.setAction(null);
            }
        }else if(Action_EDITCATEGORY.equals(action)) {
            if(request.getParameter("name")!=null&!request.getParameter("name").isEmpty()&&request.getParameter("desc")!=null&&!request.getParameter("desc").isEmpty()) {
                String categoryId = request.getParameter("cat");
                Category category = Category.ClassMgr.getCategory(categoryId, model);
                Challenge challenge = (Challenge)wp;
                if(challenge.hasCategory(category)) {
                    category.setTitle(request.getParameter("name").replaceAll(" ", ""));
                    category.setDescription(request.getParameter("desc"));
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
        }else if(Action_EDITDESIRE.equals(action)) {
        }else if(Action_REMOVEDESIRE.equals(action)) {
        }
        else if(Action_ADDSTKHLDR.equals(action)) {
        }else if(Action_EDITSTKHLDR.equals(action)) {
        }else if(Action_REMOVESTKHLDR.equals(action)) {
        }
    }

    private Boolean userCanEdit(User user) {
        return true;
    }

}
