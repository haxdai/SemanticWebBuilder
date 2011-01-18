package org.semanticwb.ecosikan.innova;

import java.util.Comparator;


public class Comment extends org.semanticwb.ecosikan.innova.base.CommentBase 
{
    public Comment(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static class CommentsSortByCreatedDate implements Comparator<Comment>{
        public int compare(Comment c1, Comment c2) {
            return c1.getCreated().compareTo( c2.getCreated() );
        }
    }
}
