package org.semanticwb.ecosikan.innova;


public class GobiernoDelEstado extends org.semanticwb.ecosikan.innova.base.GobiernoDelEstadoBase 
{
    private static GobiernoDelEstado instance;
    private GobiernoDelEstado(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public GobiernoDelEstado getInstance() {
        return instance;
    }
}
