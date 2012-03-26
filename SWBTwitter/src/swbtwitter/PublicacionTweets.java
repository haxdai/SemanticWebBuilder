/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swbtwitter;

/**
 *
 * @author adriana.rodriguez
 */
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class PublicacionTweets extends GenericAdmResource {

    static Logger log = (Logger) SWBUtils.getLogger(PublicacionTweets.class);
    private final String CALLBACK_URL = "http://adriana.mx:8080/es_mx/Beca_SEP/Post_Tweets/";
    //  SWBResourceURL posted = paramRequest.getRenderUrl().setMode("callback");
    //User us = null;
    Twitter twitter = null;
    RequestToken requestToken = null;

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        System.out.println("OAUTH PublicacionTweets: " + getResourceBase().getAttribute("oauth"));
        //PrintWriter out = response.getWriter();
        // us = paramRequest.getUser();
        //  System.out.println("OAUTH: " + us.getProperty("oauth"));

        String oauth = getResourceBase().getAttribute("oauth");
        String verifier = request.getParameter("oauth_verifier");
        System.out.println("\nVERIFIER: " + verifier);
         String urlCallback = paramRequest.getResourceBase().getAttribute("urlCallback");
        System.out.println("URL ADMINISTRACION:"+urlCallback);
        
       
        if (urlCallback != null) {
            if (oauth == null) {
                if (verifier == null) {
                    try {
                        twitter = new TwitterFactory().getInstance();
                        request.getSession().setAttribute("twitter", twitter);
                        //us.getProperty("oauth");
                        SWBResourceURL callback = paramRequest.getRenderUrl().setMode("callback");
                        System.out.println("CALLBACK: " + callback);
                        //requestToken = twitter.getOAuthRequestToken(CALLBACK_URL);
                        requestToken = twitter.getOAuthRequestToken(urlCallback);
                        System.out.println(" ");
                        request.getSession().setAttribute("requestToken", requestToken);
                        response.sendRedirect(requestToken.getAuthorizationURL());
                    } catch (TwitterException ex) {
                        java.util.logging.Logger.getLogger(PublicacionTweets.class.getName()).log(Level.SEVERE, null, ex);
//                        if (401 == ex.getStatusCode()) {
//                            System.out.println("access no valido");
//                        }
                    }
                } else {
                    try {
                        AccessToken ac = twitter.getOAuthAccessToken(requestToken, verifier);
                        // us.setProperty("oauth", ac.getToken() + "|" + ac.getTokenSecret());
                        getResourceBase().setAttribute("oauth", ac.getToken() + "|" + ac.getTokenSecret());
                        SWBResourceURL posted = paramRequest.getRenderUrl().setMode("post");
                        System.out.println("\n\n" + posted);
                        response.sendRedirect(request.getContextPath() + posted);
                    } catch (TwitterException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                SWBResourceURL posted = paramRequest.getRenderUrl().setMode("post");
                System.out.println("\n\n" + posted);
                response.sendRedirect(request.getContextPath() + posted);
            }
        }
    }
//
//    public void doCallback(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
//
//        String verifier = request.getParameter("oauth_verifier");
//        System.out.println("verifier " + verifier);
//        try {
//            AccessToken ac = twitter.getOAuthAccessToken(requestToken, verifier);
//            us.setProperty("oauth", ac.getToken() + "|" + ac.getTokenSecret());
//            SWBResourceURL posted = paramRequest.getRenderUrl().setMode("post");
//            System.out.println("\n\n" + posted);
//            response.sendRedirect(request.getContextPath() + posted);
//        } catch (TwitterException e) {
//            e.printStackTrace();
//        }
////        PrintWriter out=response.getWriter();
////        out.println("ajajajajajajaja");
//
//    }

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
        //String oauth = us.getProperty("oauth");
        String oauth = getResourceBase().getAttribute("oauth");
        System.out.println("OAUTH: " + oauth);
        String token = oauth.substring(0, oauth.indexOf("|"));
        String secretToken = oauth.substring(oauth.indexOf("|") + 1, oauth.length());
        AccessToken ac = new AccessToken(token, secretToken);
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthAccessToken(ac);
        System.out.println("es valido");

        request.setCharacterEncoding("UTF-8");
        String estado = request.getParameter("estado");
        try {
            twitter.setOAuthAccessToken(ac);
            twitter.updateStatus(estado);
        } catch (TwitterException ex) {
            if (401 == ex.getStatusCode()) {
                //us.setProperty("oauth", null);
                getResourceBase().setAttribute("oauth", null);
                response.setMode(SWBResourceURL.Mode_VIEW);
            }
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if (paramRequest.getMode().equals("callback")) {
            //doCallback(request, response, paramRequest);
        } else if (paramRequest.getMode().equals("post")) {
            doPost(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }    
}
