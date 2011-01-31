package org.semanticwb.mask;

import java.util.Comparator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;


public class Message extends org.semanticwb.mask.base.MessageBase {
    private static Logger log = SWBUtils.getLogger(Message.class);

    public Message(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static class MessageSortByCreatedDate implements Comparator<Message> {
        public int compare(Message msg1, Message msg2) {
            return msg1.getCreated().compareTo(msg2.getCreated())*-1;
        }
    }
}
