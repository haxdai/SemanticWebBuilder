package org.semanticwb.pymtur.base;


public abstract class RateSeasonBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_seasonStartDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#seasonStartDate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_seasonEndDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#seasonEndDate");
    public static final org.semanticwb.platform.SemanticClass pymtur_RateSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateSeason");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateSeason");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.RateSeason> listRateSeasons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.RateSeason> listRateSeasons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(it, true);
        }

        public static org.semanticwb.pymtur.RateSeason createRateSeason(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.RateSeason.ClassMgr.createRateSeason(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.RateSeason getRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateSeason)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.RateSeason createRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateSeason)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRateSeason(id, model)!=null);
        }
    }

    public RateSeasonBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Date getSeasonStartDate()
    {
        return getSemanticObject().getDateProperty(pymtur_seasonStartDate);
    }

    public void setSeasonStartDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_seasonStartDate, value);
    }

    public java.util.Date getSeasonEndDate()
    {
        return getSemanticObject().getDateProperty(pymtur_seasonEndDate);
    }

    public void setSeasonEndDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_seasonEndDate, value);
    }
}
