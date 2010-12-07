package org.semanticwb.ecosikan.innova;

import java.util.Comparator;


public class Idea extends org.semanticwb.ecosikan.innova.base.IdeaBase {

    public Idea(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static class IdeasSortByPositiveVotes implements Comparator<Idea>{
        public int compare(Idea idea1, Idea idea2) {
            return new Long(idea1.getVotesP()).compareTo(new Long(idea2.getVotesP()));
        }
    }

    public static class IdeasSortByCreatedDate implements Comparator<Idea>{
        public int compare(Idea idea1, Idea idea2) {
            return idea1.getCreated().compareTo( idea2.getCreated() );
        }
    }
}
