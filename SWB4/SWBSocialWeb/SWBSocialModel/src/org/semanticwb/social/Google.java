package org.semanticwb.social;

import java.util.HashMap;


   /**
   * Clase red social para Google+ 
   */
public class Google extends org.semanticwb.social.base.GoogleBase 
{
    public Google(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void postMsg(Message message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postVideo(Video video) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getUserKlout(String twitterUserID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postPhoto(Photo photo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HashMap<String, Long> monitorPostOutResponses(PostOut postOut) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
