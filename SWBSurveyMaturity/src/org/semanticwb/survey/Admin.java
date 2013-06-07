/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.survey;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class Admin extends GenericResource
{

    public static final String MODE_ADMON_QUESTION = "admonquestion";
    public static final String MODE_ADMON_SURVEY = "admonSurvey";
    public static final String MODE_ADMON_SECTION = "admonSection";
    public static final String MODE_ADMON_PART = "admonParte";
    private static final Logger log = SWBUtils.getLogger(SurveyMaturity.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        
    }
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equals(MODE_ADMON_QUESTION))
        {
            doReload(request, response, paramRequest, MODE_ADMON_QUESTION);
        }
        else if (paramRequest.getMode().equals(MODE_ADMON_SURVEY))
        {
            doReload(request, response, paramRequest, MODE_ADMON_SURVEY);
        }
        else if (paramRequest.getMode().equals(MODE_ADMON_SECTION))
        {
            doReload(request, response, paramRequest, MODE_ADMON_SECTION);
        }
        else if (paramRequest.getMode().equals(MODE_ADMON_PART))
        {
            doReload(request, response, paramRequest, MODE_ADMON_PART);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doReload(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, String jsp) throws SWBResourceException, IOException
    {

        String siteId = paramRequest.getWebPage().getWebSiteId();
        String path = "/work/models/" + siteId + "/jsp/" + SurveyMaturity.class.getSimpleName() + "/admon/" + jsp + ".jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        String siteId = paramRequest.getWebPage().getWebSiteId();
        String path = "/work/models/" + siteId + "/jsp/" + SurveyMaturity.class.getSimpleName() + "/admon/view.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }
}
