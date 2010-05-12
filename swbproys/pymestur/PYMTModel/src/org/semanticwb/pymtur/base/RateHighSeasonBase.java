package org.semanticwb.pymtur.base;


public abstract class RateHighSeasonBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_highStartDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#highStartDate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_highEndDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#highEndDate");
    public static final org.semanticwb.platform.SemanticClass pymtur_RateHighSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateHighSeason");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateHighSeason");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.RateHighSeason> listRateHighSeasons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateHighSeason>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.RateHighSeason> listRateHighSeasons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateHighSeason>(it, true);
        }

        public static org.semanticwb.pymtur.RateHighSeason createRateHighSeason(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.RateHighSeason.ClassMgr.createRateHighSeason(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.RateHighSeason getRateHighSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateHighSeason)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.RateHighSeason createRateHighSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateHighSeason)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRateHighSeason(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRateHighSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRateHighSeason(id, model)!=null);
        }
    }

    public RateHighSeasonBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Date getHighStartDate()
    {
        return getSemanticObject().getDateProperty(pymtur_highStartDate);
    }

    public void setHighStartDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_highStartDate, value);
    }

    public java.util.Date getHighEndDate()
    {
        return getSemanticObject().getDateProperty(pymtur_highEndDate);
    }

    public void setHighEndDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_highEndDate, value);
    }
}
