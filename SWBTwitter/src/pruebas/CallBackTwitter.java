/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author adriana.rodriguez
 */
public class CallBackTwitter extends GenericAdmResource {

    private String token = "";
    private String secretToken = "";

    
    public void doViewes(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        //PrintWriter out = response.getWriter();
        request.setAttribute("paramRequest", paramRequest);
        
        
        Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
        RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        String verifier = request.getParameter("oauth_verifier");
        try {
            //twitter.getOAuthAccessToken(requestToken, verifier);
            //request.getSession().removeAttribute("requestToken");
            AccessToken ac = twitter.getOAuthAccessToken(requestToken, verifier);
            token = ac.getToken();
            secretToken = ac.getTokenSecret();

            System.out.println("token: " + ac.getToken());
            System.out.println("token secret: " + ac.getTokenSecret());
            /****************************************************************/
            // get ResourceBase().setAttribute("oauth", ac.getToken()+"|"+ac.getTokenSecret());
            User us = paramRequest.getUser();
            if (us.isSigned()) {
                System.out.println("hahahahahahaha ");
                us.setProperty("oauth", ac.getToken() + "|" + ac.getTokenSecret());
            }

            /*
            token: 516979733-9p28SuGyhVV6uMcESuWPpZBrI4ZKUrxkz7xiB9F5
            token secret: LCs9QGhSmrHtvT44I2lyf3DzGizWL7CSIyimbo8Qfs
             */


        } catch (TwitterException e) {
            // throw new ServletException(e);
            e.printStackTrace();
        }

        //
        SWBResourceURL posted = paramRequest.getRenderUrl().setMode("post");
        System.out.println("\n\n" + posted);
        response.sendRedirect(request.getContextPath() + posted);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        try {
            request.setAttribute("requestToken", request);
            request.setAttribute("paramRequest", paramRequest);
            String path = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/twitter/PublicacionTweets.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        //  RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        // AccessToken access= new AccessToken(requestToken.getToken(),requestToken.getTokenSecret());
//        System.out.println("USer Id "+access.getUserId());
//        access.getUserId();
        System.out.println("oauth " + getResourceBase().getAttribute("oauth"));
        AccessToken ac = null;
        if (ac == null) {
            //ac = new AccessToken(base.getAttribute("oauth_token"),base.getAttribute("auth_token_secret"));
        } else {
            // System.out.println("ac token"+ac.getToken());
            /*token: 516979733-9p28SuGyhVV6uMcESuWPpZBrI4ZKUrxkz7xiB9F5
            token secret: LCs9QGhSmrHtvT44I2lyf3DzGizWL7CSIyimbo8Qfs*/
        }

        request.setCharacterEncoding("UTF-8");
        String estado = request.getParameter("estado");
        System.out.println("EStado " + estado);
        
        
            Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
            try {
                //System.out.println("reuesttoken " + requestToken.getToken());
                twitter.updateStatus(estado);
               //System.out.println("reuesttoken " + requestToken.getToken());
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        //response.sendRedirect(request.getContextPath()+ "/");        

        //String text=request.getParameter("");
        System.out.println("OAUTH: " + getResourceBase().getAttribute("oauth"));
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if (paramRequest.getMode().equals("post")) {
            doPost(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
    
   
}
