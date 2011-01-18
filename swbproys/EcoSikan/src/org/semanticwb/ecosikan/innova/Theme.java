package org.semanticwb.ecosikan.innova;

import org.semanticwb.ecosikan.innova.util.LastComments;

public class Theme extends org.semanticwb.ecosikan.innova.base.ThemeBase 
{
    LastComments lastComments;
    public Theme(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
        lastComments = new LastComments(3);
    }
    
}
