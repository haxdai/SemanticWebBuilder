package org.semanticwb.pymtur.base;


public abstract class RateCommentsBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_rateCommLowSeasson=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rateCommLowSeasson");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rateComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rateComment");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rateCommHighSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rateCommHighSeason");
    public static final org.semanticwb.platform.SemanticClass pymtur_RateComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateComments");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateComments");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.RateComments> listRateCommentses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateComments>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.RateComments> listRateCommentses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateComments>(it, true);
        }

        public static org.semanticwb.pymtur.RateComments createRateComments(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.RateComments.ClassMgr.createRateComments(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.RateComments getRateComments(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateComments)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.RateComments createRateComments(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateComments)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRateComments(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRateComments(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRateComments(id, model)!=null);
        }
    }

    public RateCommentsBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getRateCommLowSeasson()
    {
        return getSemanticObject().getProperty(pymtur_rateCommLowSeasson);
    }

    public void setRateCommLowSeasson(String value)
    {
        getSemanticObject().setProperty(pymtur_rateCommLowSeasson, value);
    }

    public String getRateComment()
    {
        return getSemanticObject().getProperty(pymtur_rateComment);
    }

    public void setRateComment(String value)
    {
        getSemanticObject().setProperty(pymtur_rateComment, value);
    }

    public String getRateCommHighSeason()
    {
        return getSemanticObject().getProperty(pymtur_rateCommHighSeason);
    }

    public void setRateCommHighSeason(String value)
    {
        getSemanticObject().setProperty(pymtur_rateCommHighSeason, value);
    }
}
