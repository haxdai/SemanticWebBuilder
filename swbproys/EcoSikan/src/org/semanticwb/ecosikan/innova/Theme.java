package org.semanticwb.ecosikan.innova;

import java.util.Iterator;
import org.semanticwb.ecosikan.innova.util.LastComments;

public class Theme extends org.semanticwb.ecosikan.innova.base.ThemeBase 
{
    private LastComments lastComments;
    public Theme(org.semanticwb.platform.SemanticObject base)
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
}
