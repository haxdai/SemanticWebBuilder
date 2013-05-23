/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.DatasetLog;
import com.infotec.lodp.swb.DatasetVersion;
import static com.infotec.lodp.swb.resources.DataSetResource.DEFAULT_MIME_TYPE;
import static com.infotec.lodp.swb.resources.DataSetResource.META_FORMAT_JSON;
import static com.infotec.lodp.swb.resources.DataSetResource.META_FORMAT_RDF;
import static com.infotec.lodp.swb.resources.DataSetResource.MODE_FILE;
import static com.infotec.lodp.swb.resources.DataSetResource.sortByCreated;
import static com.infotec.lodp.swb.resources.DataSetResource.sortByDownloads;
import static com.infotec.lodp.swb.resources.DataSetResource.sortByViews;
import com.infotec.lodp.swb.utils.LODPUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author juan.fernandez
 */
public class DSHomeResource extends GenericAdmResource {

    public static final Logger log = SWBUtils.getLogger(DSHomeResource.class);
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        //super.doView(request, response, paramsRequest); //To change body of generated methods, choose Tools | Templates.

        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        //System.out.println("basePath:"+path);
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }


}
