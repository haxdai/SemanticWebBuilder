package org.semanticwb.pymtur.base;


public abstract class AlimentosRateBase extends org.semanticwb.pymtur.Rate 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_tableNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#tableNumber");
    public static final org.semanticwb.platform.SemanticClass pymtur_AlimentosRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#AlimentosRate");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#AlimentosRate");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.AlimentosRate> listAlimentosRates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.AlimentosRate>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.AlimentosRate> listAlimentosRates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.AlimentosRate>(it, true);
        }

        public static org.semanticwb.pymtur.AlimentosRate createAlimentosRate(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.AlimentosRate.ClassMgr.createAlimentosRate(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.AlimentosRate getAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.AlimentosRate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.AlimentosRate createAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.AlimentosRate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAlimentosRate(id, model)!=null);
        }
    }

    public AlimentosRateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public int getTableNumber()
    {
        return getSemanticObject().getIntProperty(pymtur_tableNumber);
    }

    public void setTableNumber(int value)
    {
        getSemanticObject().setIntProperty(pymtur_tableNumber, value);
    }
}
