/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.opensocial.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.JDOMException;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebSite;
import org.semanticwb.opensocial.model.Gadget;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;

/**
 *
 * @author victor.lorenzana
 */
public class MakeRequest
{

    private static final Logger log = SWBUtils.getLogger(MakeRequest.class);

    private void sendResponse(String objresponse, HttpServletResponse response) throws IOException
    {
        Charset utf8 = Charset.forName("utf-8");
        response.setContentType("application/json;charset=" + utf8.name());
        OutputStream out = response.getOutputStream();
        out.write("throw 1; < don't be evil' >".getBytes());
        out.write(objresponse.getBytes(utf8));
        out.close();
    }

    private void getDocument(URL url, String headers, HttpServletResponse response) throws IOException, JDOMException, JSONException
    {        
        try
        {            
            int code=500;
            String xml="";
            try
            {
                Document doc=SocialContainer.getXML(url);
                Charset charset=Charset.defaultCharset();
                xml =SWBUtils.XML.domToXml(doc, charset.name(), true);
                System.out.println("xml:");
                System.out.println(xml);
                code=200;
            }
            catch(RequestException e)
            {
                code=e.getCode();
            }

            JSONObject responseJSONObject = new JSONObject();
            response.setContentType("application/json");
            JSONObject body = new JSONObject();
            body.put("body", xml);
            responseJSONObject.put(url.toString(), body);
            responseJSONObject.put("rc", code);
            sendResponse(responseJSONObject.toString(4), response);
        }
        catch (IOException e)
        {            
            log.debug(e);
            throw e;
        }
        /*catch (JDOMException e)
        {
        log.debug(e);
        throw e;
        }*/
        catch (JSONException e)
        {
            log.debug(e);
            throw e;
        }

    }

    private void sendResponse(Document objresponse, HttpServletResponse response) throws IOException
    {
        Charset defaultCharset = Charset.defaultCharset();
        response.setContentType("text/xml;charset=" + defaultCharset.name());
        OutputStream out = response.getOutputStream();
        String xml = SWBUtils.XML.domToXml(objresponse, defaultCharset.name(), false);        
        out.write(xml.getBytes());
        out.close();
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        WebSite site = paramRequest.getWebPage().getWebSite();        
        System.out.println("MakeRequest request.getQueryString(): " + request.getQueryString());
        System.out.println("MakeRequest request.getContentType(): " + request.getContentType());
        String refresh = request.getParameter("refresh");
        System.out.println("refresh: " + refresh);
        String url = request.getParameter("url");
        System.out.println("url: " + url);
        String httpMethod = request.getParameter("httpMethod");
        System.out.println("httpMethod: " + httpMethod);
        String headers = request.getParameter("headers");
        System.out.println("headers: " + headers);
        String postData = request.getParameter("postData");
        System.out.println("postData: " + postData);
        String st = request.getParameter("st");
        System.out.println("MakeRequest st: " + st);
        String authz = request.getParameter("authz");
        System.out.println("authz: " + authz);
        String contentType = request.getParameter("contentType");
        System.out.println("contentType: " + contentType);
        String numEntries = request.getParameter("numEntries");
        System.out.println("numEntries: " + numEntries);
        String getSummaries = request.getParameter("getSummaries");
        System.out.println("getSummaries: " + getSummaries);
        String signOwner = request.getParameter("signOwner");
        System.out.println("signOwner: " + signOwner);
        String container = request.getParameter("container");
        System.out.println("container: " + container);
        String bypassSpecCache = request.getParameter("bypassSpecCache");
        System.out.println("bypassSpecCache: " + bypassSpecCache);
        String getFullHeaders = request.getParameter("getFullHeaders");
        System.out.println("getFullHeaders: " + getFullHeaders);
        String gadget = request.getParameter("gadget");
        System.out.println(gadget);
        Gadget g = SocialContainer.getGadget(gadget, site);
        if (g != null)
        {
            if (httpMethod.trim().equalsIgnoreCase("GET"))
            {
                if ("DOM".equals(contentType.trim()))
                {
                    try
                    {
                        getDocument(new URL(url), headers, response);

                        return;
                    }
                    catch (Exception e)
                    {
                        log.debug(e);
                        response.sendError(505, e.getLocalizedMessage());
                        return;
                    }
                }
                else if ("FEED".equals(contentType.trim()))
                {
                }
                else if ("FEED".equals(contentType.trim()))
                {
                }

            }
            else
            {
                response.sendError(404);
            }
        }
        response.sendError(404);
    }
}
