/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.segob.pressroom.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.resources.sem.pressroom.Category;

/**
 *
 * @author jorge.jimenez
 */
public class CategoryMgr extends GenericResource {

    private static Logger log = SWBUtils.getLogger(CategoryMgr.class);

    @Override
    public void processAction(HttpServletRequest request,
            SWBActionResponse response) throws SWBResourceException, IOException {

        String action = response.getAction();
        Category cat = null;

        if (action.equalsIgnoreCase(SWBResourceURL.Action_ADD)) {
            if (request.getParameter("nombre") != null) {
                cat = Category.ClassMgr.createCategory(response.getWebPage().getWebSite());
                cat.setTitle(request.getParameter("nombre"));
                cat.setDescription(request.getParameter("descripcion") != null
                        ? request.getParameter("descripcion") : "");
                cat.setCreated(new Date(System.currentTimeMillis()));
//            if (response.getUser() != null) {
//                cat.setCreator(response.getUser());
//            }
            }
            response.setMode(SWBResourceURL.Mode_VIEW);

        } else if (action.equalsIgnoreCase(SWBResourceURL.Action_EDIT)) {
            String uri = request.getParameter("uri");
            if (uri != null) {
                cat = (Category) SemanticObject.createSemanticObject(uri).getGenericInstance();
                cat.setTitle(request.getParameter("nombre"));
                cat.setDescription(request.getParameter("descripcion") != null
                        ? request.getParameter("descripcion") : "");
                cat.setUpdated(new Date(System.currentTimeMillis()));
//            if (response.getUser() != null) {
//                cat.setModifiedBy(response.getUser());
//            }
            }
            response.setMode(SWBResourceURL.Mode_VIEW);

        } else if (action.equalsIgnoreCase(SWBResourceURL.Action_REMOVE)) {
            String uri = request.getParameter("uri");
            if (uri != null) {
                cat = (Category) SemanticObject.createSemanticObject(uri).getGenericInstance();
                cat.removeAllContent();
                cat.remove();
            }
            response.setMode(SWBResourceURL.Mode_VIEW);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        if (paramRequest.getMode().equalsIgnoreCase("editCat")) {
            doEditCat(request, response, paramRequest);
        } else if (paramRequest.getMode().equalsIgnoreCase("addCat")) {
            doAddCat(request, response, paramRequest);
        } else if (paramRequest.getMode().equalsIgnoreCase("chngStatus")) {
            doChngStatus(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        Iterator<Category> itCat = Category.ClassMgr.listCategories(paramRequest.getWebPage().getWebSite());
        if (itCat != null) {
            itCat = SWBComparator.sortByDisplayName(itCat, "es");
        }


        String path = "/work/models/pressroom/jsp/CategoryMgr/ListCategories.jsp";
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("catIterator", itCat);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in CategoryMgr's view mode", e);
        }
    }

    public void doAddCat(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        String path = "/work/models/pressroom/jsp/CategoryMgr/EditCategory.jsp";
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            //request.setAttribute("category", null);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in CategoryMgr's category Addition", e);
        }
    }

    public void doEditCat(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        String path = "/work/models/pressroom/jsp/CategoryMgr/EditCategory.jsp";
        try {
            String uri = request.getParameter("uri");
            Category cat = (Category) SemanticObject.createSemanticObject(uri).getGenericInstance();
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("category", cat);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in CategoryMgr's category Edition", e);
        }
    }

    public void doChngStatus(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        String uri = request.getParameter("uri");
        Category cat = null;
        boolean isActive = false;
        PrintWriter out = response.getWriter();

        if (uri != null) {
            cat = (Category) SemanticObject.createSemanticObject(uri).getGenericInstance();
            isActive = !cat.isActive();
            cat.setActive(isActive);
            out.print(Boolean.toString(isActive));
        } else {
            out.print("Not OK");
        }
    }
}
