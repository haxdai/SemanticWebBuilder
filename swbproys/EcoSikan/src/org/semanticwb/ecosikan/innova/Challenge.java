package org.semanticwb.ecosikan.innova;


import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.util.LastComments;
import org.semanticwb.portal.api.SWBActionResponse;

public class Challenge extends org.semanticwb.ecosikan.innova.base.ChallengeBase {
    private static Logger log = SWBUtils.getLogger(Challenge.class);
    private static final String Template_ID = "10";
    private static final int List_Last = 3;
    private LastComments lastComments;

    public Challenge(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
        lastComments = new LastComments(3);
    }

    public boolean offer(Comment c) {
        return lastComments.offer(c);
    }

    public Iterator<Comment> listLastComments() {
        return lastComments.iterator();
    }

    public void addData(SWBActionResponse response, HashMap<String,String> params) throws Exception {

    }
}
