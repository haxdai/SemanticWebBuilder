/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.segob.pressroom.resources;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author jose.jimenez
 */
public class CategoryMgr extends GenericResource {

    private static Logger log = SWBUtils.getLogger(CategoryMgr.class);

    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        if (paramRequest.getMode().equalsIgnoreCase("editCat")) {
            doEditCat(request,response,paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        String path = "/work/models/pressroom/jsp/CategoryMgr/ListCategories.jsp";
        try {
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in CategoryMgr's view mode", e);
        }
    }

    public void doEditCat(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        String path = "/work/models/pressroom/jsp/CategoryMgr/EditCategory.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
    }

}
