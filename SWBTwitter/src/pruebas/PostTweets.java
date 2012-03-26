/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import swbtwitter.PublicacionTweets;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author adriana.rodriguez
 * Juntando todas la clase callback y sign in en una para mayor comodidad
 */
public class PostTweets extends GenericAdmResource {

    private final String CALLBACK_URL = "http://adriana.mx:8080/swb/Beca_SEP/callback";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        if (getResourceBase().getAttribute("oauth") == null) {
            try {
                Twitter twitter = new TwitterFactory().getInstance();
                request.getSession().setAttribute("twitter", twitter);
                request.getParameter("oauth_verifier");
                StringBuffer callbackURL = request.getRequestURL();
                int index = callbackURL.lastIndexOf("/");
                callbackURL.replace(index, callbackURL.length(), "").append("/callback");
                RequestToken requestToken = twitter.getOAuthRequestToken(CALLBACK_URL);
                request.getSession().setAttribute("requestToken", requestToken);
                response.sendRedirect(requestToken.getAuthorizationURL());

            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(PublicacionTweets.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //PrintWriter out = response.getWriter();
            request.setAttribute("paramRequest", paramsRequest);
            Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
            RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
            String verifier = request.getParameter("oauth_verifier");
            try {

                AccessToken ac = twitter.getOAuthAccessToken(requestToken, verifier);
                System.out.println("token: " + ac.getToken());
                System.out.println("token secret: " + ac.getTokenSecret());
                /****************************************************************/
                getResourceBase().setAttribute("oauth", ac.getToken() + "|" + ac.getTokenSecret());
            } catch (TwitterException ex) {
                Logger.getLogger(PostTweets.class.getName()).log(Level.SEVERE, null, ex);
            }

            //
            SWBResourceURL posted = paramsRequest.getRenderUrl().setMode("post");
            System.out.println("\n\n" + posted);
            response.sendRedirect(request.getContextPath() + posted);

        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        super.processRequest(request, response, paramRequest);

    }

    public void doAutenticacion(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        try {
            Twitter twitter = TwitterFactory.getSingleton();

            request.getSession().setAttribute("twitter", twitter);
            System.out.println("twitter autorization : " + twitter.getAuthorization());
            request.getParameter("oauth_verifier");
            StringBuffer callbackURL = request.getRequestURL();
            int index = callbackURL.lastIndexOf("/");
            callbackURL.replace(index, callbackURL.length(), "").append("/callback");
            System.out.println("nueva callbackURL\n" + callbackURL + "\n");
            RequestToken requestToken = twitter.getOAuthRequestToken(CALLBACK_URL);
            request.getSession().setAttribute("requestToken", requestToken);
            String verifier = request.getParameter("oauth_verifier");
            String authtoken = request.getParameter("oauth_token");
            System.out.println("verifiier   " + verifier + "\nAuthToken_ " + authtoken);

            System.out.println("reuesttoken " + requestToken.getToken());
            /***************************************************************************
            
             ****************************************************************************/
//            Resource base = getResourceBase();
//            base.getAttribute("oauth_token");
//            base.getAttribute("oauth_token_secret");
//            System.out.println("OAuth_token=" + base.getAttribute("oauth_token") + "\n\nOAuth_Token_secret="+base.getAttribute("oauth_token_secret"));
            /*****************************************************************************
             *****************************************************************************/
            if (request.getAttribute("") != null) {
            } else {
                response.sendRedirect(requestToken.getAuthorizationURL());
            }
        } catch (TwitterException ex) {
            
            java.util.logging.Logger.getLogger(PublicacionTweets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
