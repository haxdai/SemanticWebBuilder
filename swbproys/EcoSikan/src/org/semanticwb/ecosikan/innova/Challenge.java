package org.semanticwb.ecosikan.innova;


import org.semanticwb.ecosikan.innova.util.LastComments;

public class Challenge extends org.semanticwb.ecosikan.innova.base.ChallengeBase {
    LastComments lastComments;

    public Challenge(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
        lastComments = new LastComments(3);
    }
}
