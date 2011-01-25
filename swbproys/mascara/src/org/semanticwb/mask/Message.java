package org.semanticwb.mask;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;


public class Message extends org.semanticwb.mask.base.MessageBase {
    private static Logger log = SWBUtils.getLogger(Message.class);

    public Message(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
