package org.semanticwb.pymtur.base;


public abstract class RateLowSeasonBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_lowEndDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#lowEndDate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_lowStartDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#lowStartDate");
    public static final org.semanticwb.platform.SemanticClass pymtur_RateLowSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateLowSeason");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateLowSeason");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.RateLowSeason> listRateLowSeasons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateLowSeason>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.RateLowSeason> listRateLowSeasons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateLowSeason>(it, true);
        }

        public static org.semanticwb.pymtur.RateLowSeason createRateLowSeason(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.RateLowSeason.ClassMgr.createRateLowSeason(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.RateLowSeason getRateLowSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateLowSeason)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.RateLowSeason createRateLowSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateLowSeason)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRateLowSeason(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRateLowSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRateLowSeason(id, model)!=null);
        }
    }

    public RateLowSeasonBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Date getLowEndDate()
    {
        return getSemanticObject().getDateProperty(pymtur_lowEndDate);
    }

    public void setLowEndDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_lowEndDate, value);
    }

    public java.util.Date getLowStartDate()
    {
        return getSemanticObject().getDateProperty(pymtur_lowStartDate);
    }

    public void setLowStartDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_lowStartDate, value);
    }
}
