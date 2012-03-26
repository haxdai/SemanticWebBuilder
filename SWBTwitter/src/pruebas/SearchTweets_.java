/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.List;

/**
 *
 * @author adriana.rodriguez
 */
public class SearchTweets_ {
    public static void main(String[] args) {
        System.out.println("args" +args.length);
        
//        if (args.length < 1) {
//            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
//            System.exit(-1);
//        }
        
        Query query = new Query("hola");
query.setRpp(100);
query.setSince("2011-01-01");
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            //QueryResult result = twitter.search(new Query("hola"));
            QueryResult result=twitter.search(query);
            List<Tweet> tweets = result.getTweets();
            for (Tweet tweet : tweets) {
                System.out.println("@" + tweet.getFromUser() + " - " + tweet.getText());
            }
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
    
    
    /*
     public void retrieve() {
logger.info("Retrieving tweets...");
Twitter twitter = new TwitterFactory().getInstance();
String user = "TheJavaTutorial";
29.
32.try {
33.QueryResult result = twitter.search(query);
34.System.out.println("Count : " + result.getTweets().size()) ;
35.for (Tweet tweet : result.getTweets()) {
36.System.out.println("text : " + tweet.getText());
37.}
38.} catch (TwitterException e) {
39.e.printStackTrace();
40.}
41.logger.info("done! ");
42.}
     */
    
}
