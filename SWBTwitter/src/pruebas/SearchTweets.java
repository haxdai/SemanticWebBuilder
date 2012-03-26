/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author adriana.rodriguez
 */
public class SearchTweets extends GenericAdmResource {

    @Override
    /*
     Place puede venir nulo
     */
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        Query query = new Query("CFE Mexico");
        query.setRpp(20);
        //query.setSince("2011-01-01");
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            //QueryResult result = twitter.search(new Query("hola"));
            QueryResult result = twitter.search(query);
            List<Tweet> tweets = result.getTweets();
            for (Tweet tweet : tweets) {
                // System.out.println("@" + tweet.getFromUser() + " - " + tweet.getText()+);

                out.print("<p> @" + tweet.getFromUser() + " " + tweet.getText()
                        + "\n Fecha " + tweet.getCreatedAt().toString() + "\nCreado a" + tweet.getCreatedAt() + "</p>");
                
            }

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());

        }
    }
}
