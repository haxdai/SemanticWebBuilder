package org.semanticwb.pymtur;

import org.semanticwb.SWBPortal;


public class ServiceProvider extends org.semanticwb.pymtur.base.ServiceProviderBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(ServiceProvider.class, new ServiceProviderParser());
        
    }

    public ServiceProvider(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
