/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.util;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.ResourceType;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.util.db.GenericDB;

/**
 *
 * @author jorge.jimenez
 */
public class CreateLogTable extends GenericResource{

    private static Logger log = SWBUtils.getLogger(CreateLogTable.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        System.out.println("CreateLogTable:doView");
    }



    @Override
    public void install(ResourceType recobj) throws SWBResourceException {
        try{
            System.out.println("Comienza a instalar tabla swb_pymesturlog");
            GenericDB db = new GenericDB();
            String xml = SWBUtils.IO.getFileFromPath(SWBUtils.getApplicationPath() + "/WEB-INF/xml/swb_pymesturlog.xml");
            db.executeSQLScript(xml, SWBUtils.DB.getDatabaseName(), null);
            System.out.println("termina de instalar tabla swb_pymesturlog");
        }catch (SQLException e)
        {
            log.error(e);
        }
    }
}
