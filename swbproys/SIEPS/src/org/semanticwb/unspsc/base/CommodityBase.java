package org.semanticwb.unspsc.base;


public abstract class CommodityBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty unspsc_unspsc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ontoview.org/schema/unspsc/1#unspsc");
    public static final org.semanticwb.platform.SemanticClass unspsc_Commodity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ontoview.org/schema/unspsc/1#Commodity");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ontoview.org/schema/unspsc/1#Commodity");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.unspsc.Commodity> listCommodities(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.unspsc.Commodity>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.unspsc.Commodity> listCommodities()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.unspsc.Commodity>(it, true);
        }

        public static org.semanticwb.unspsc.Commodity getCommodity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.unspsc.Commodity)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.unspsc.Commodity createCommodity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.unspsc.Commodity)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeCommodity(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasCommodity(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCommodity(id, model)!=null);
        }
    }

    public CommodityBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getUnspsc()
    {
        return getSemanticObject().getProperty(unspsc_unspsc);
    }

    public void setUnspsc(String value)
    {
        getSemanticObject().setProperty(unspsc_unspsc, value);
    }
}
