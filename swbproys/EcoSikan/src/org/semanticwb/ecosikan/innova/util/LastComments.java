package org.semanticwb.ecosikan.innova.util;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.semanticwb.ecosikan.innova.Comment;

public class LastComments {
    private final int length;
    private final ConcurrentLinkedQueue q;
    public LastComments(int length) throws IllegalArgumentException {
        if(length<0)
            throw new IllegalArgumentException("Longitud inválida");
        this.length = length;
        q = new ConcurrentLinkedQueue();
    }

    public synchronized boolean offer(Comment c) {
        boolean res = Boolean.FALSE;
        if(q.size()<length) {
            res = q.offer(c);
        }else {
            q.poll();
            res = q.offer(c);
        }
        return res;
    }

    public Iterator<Comment> iterator() {
        return q.iterator();
    }
}
