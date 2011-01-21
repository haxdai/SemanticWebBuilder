/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources.editorials;


import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.Canal;
import org.semanticwb.cptm.EditNote;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceCollection;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;


/**
 *
 * @author jose.jimenez
 */
public class FirstLevelEditorials extends GenericAdmResource {


    private static Logger log = SWBUtils.getLogger(FirstLevelEditorials.class);
    
    private static final String noteTypeId = "Primer_Nivel";


    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
        } catch (Exception e) {
            log.error("Error while setting resource base: " + base.getId() + "-" + base.getTitle(), e);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        WebSite site = paramsRequest.getWebPage().getWebSite();
        WebPage webPage = paramsRequest.getWebPage();
        Iterator<ResourceCollection> it = null;
        ResourceCollection col = null;
        Resource base = getResourceBase();
        TreeMap<Integer, EditNote> map = new TreeMap<Integer, EditNote>();
        String viewPath = SWBPortal.getWebWorkPath() + "/models/"
                + base.getWebSiteId() + "/jsp/visitmexico/editorials/FirstLevel.jsp";
        boolean showHomeDisplay = webPage.getId().equalsIgnoreCase("home") ? true : false;
        boolean showCanalDisplay = false;

        if (!showHomeDisplay) {
            showCanalDisplay = webPage instanceof Canal ? true : false;
        }
        try {
            it = site.listResourceCollections();
        } catch (Exception e) {
            FirstLevelEditorials.log.error("Error while getting collection.", e);
        }

        if (it != null) {
            //Se recorren las colecciones de recursos existentes en busca de la especificada en la admon. del recurso
            while (it.hasNext()) {
                col = it.next();
                if (col.getTitle().equalsIgnoreCase(base.getAttribute("collectionTitle"))) {
                    GenericIterator<Resource> resources = col.listResources();

                    //Se recorren los recursos de la colección especificada
                    while (resources.hasNext()) {
                        Resource res = resources.next();
                        SemanticObject so = res.getResourceData();
                        GenericObject go = so.createGenericInstance();
                        if (go instanceof EditNote) {
                            EditNote editorial = (EditNote) go;
                            String noteId = editorial.getNoteType() != null
                                    ? editorial.getNoteType().getId() : null;

                            //Se obtienen solo las notas de primer nivel
                            if (map.size() < 5 && noteId != null &&
                                    noteId.equalsIgnoreCase(FirstLevelEditorials.noteTypeId)) {
                                //Se seleccionan las notas de acuerdo a la página a mostrar (Home o algún canal)
                                if ((showHomeDisplay && editorial.isIsathome()) ||
                                        (showCanalDisplay && editorial.getNoteCanal() == webPage)) {
                                    map.put(editorial.getNoteHomeIndex(), editorial);
                                }
                            } else if (map.size() >= 5) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        request.setAttribute("editorials", map);
        request.setAttribute("collection", col);
        request.setAttribute("paramsRequest", paramsRequest);
        try {
            request.getRequestDispatcher(viewPath).include(request, response);
        } catch (ServletException se) {
            FirstLevelEditorials.log.error("Error at including JSP in request dispatching.", se);
        }
        
    }
    
}
