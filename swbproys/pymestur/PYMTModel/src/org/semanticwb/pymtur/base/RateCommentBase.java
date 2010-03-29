package org.semanticwb.pymtur.base;


public abstract class RateCommentBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_rateComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rateComment");
    public static final org.semanticwb.platform.SemanticClass pymtur_RateComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateComment");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateComment");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.RateComment> listRateComments(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateComment>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.RateComment> listRateComments()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateComment>(it, true);
        }

        public static org.semanticwb.pymtur.RateComment createRateComment(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.RateComment.ClassMgr.createRateComment(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.RateComment getRateComment(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateComment)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.RateComment createRateComment(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateComment)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRateComment(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRateComment(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRateComment(id, model)!=null);
        }
    }

    public RateCommentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getRateComment()
    {
        return getSemanticObject().getProperty(pymtur_rateComment);
    }

    public void setRateComment(String value)
    {
        getSemanticObject().setProperty(pymtur_rateComment, value);
    }
}
