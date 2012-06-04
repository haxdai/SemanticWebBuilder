/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.listener;

import java.net.SocketException;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.social.MessageIn;
import org.semanticwb.social.PhotoIn;
import org.semanticwb.social.Post;
import org.semanticwb.social.PostIn;
import org.semanticwb.social.VideoIn;
import org.semanticwb.social.util.SendPostThread;

/**
 *
 * @author jorge.jimenez
 */
public class ClassifierThread extends java.lang.Thread {

    /** The log. */
    private static Logger log = SWBUtils.getLogger(SendPostThread.class);
    /** The emails. */
    PostIn post = null;

    /**
     * Creates a new instance of WBMessageServer.
     *
     * @throws SocketException the socket exception
     */
    public ClassifierThread(PostIn post) throws java.net.SocketException {
        this.post = post;
    }

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run()
    {
        try
        {
            String words2classify = null;
            if (post instanceof MessageIn) {
                MessageIn messageIn = (MessageIn) post;
                words2classify = messageIn.getMsg_Text();
                if(words2classify!=null && words2classify.trim().length()>0)
                {
                    new SentimentalDataClassifier(messageIn, words2classify);
                }
            } else if (post instanceof PhotoIn) {
                PhotoIn photoIn = (PhotoIn) post;
                words2classify = photoIn.getTitle() + photoIn.getDescription();
                if(words2classify!=null && words2classify.trim().length()>0)
                {
                    new SentimentalDataClassifier(photoIn, words2classify);
                }
            } else if (post instanceof VideoIn) {
                VideoIn videoIn = (VideoIn) post;
                words2classify = videoIn.getTitle() + videoIn.getDescription();
                if(words2classify!=null && words2classify.trim().length()>0)
                {
                    new SentimentalDataClassifier(videoIn, words2classify);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
    }
}
