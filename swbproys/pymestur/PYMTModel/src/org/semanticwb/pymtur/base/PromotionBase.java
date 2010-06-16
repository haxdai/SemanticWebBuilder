package org.semanticwb.pymtur.base;


public abstract class PromotionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoServiceProviderInv");
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoImg=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoImg");
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoPeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoPeriod");
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.Promotion> listPromotions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Promotion> listPromotions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion>(it, true);
        }

        public static org.semanticwb.pymtur.Promotion createPromotion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.Promotion.ClassMgr.createPromotion(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.Promotion getPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Promotion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.Promotion createPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Promotion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removePromotion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPromotion(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Promotion> listPromotionByPromoServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_promoServiceProviderInv, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Promotion> listPromotionByPromoServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_promoServiceProviderInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public PromotionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setPromoServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value)
    {
        getSemanticObject().setObjectProperty(pymtur_promoServiceProviderInv, value.getSemanticObject());
    }

    public void removePromoServiceProviderInv()
    {
        getSemanticObject().removeProperty(pymtur_promoServiceProviderInv);
    }

    public org.semanticwb.pymtur.ServiceProvider getPromoServiceProviderInv()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_promoServiceProviderInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }

    public String getPromoImg()
    {
        return getSemanticObject().getProperty(pymtur_promoImg);
    }

    public void setPromoImg(String value)
    {
        getSemanticObject().setProperty(pymtur_promoImg, value);
    }

    public String getPromoPeriod()
    {
        return getSemanticObject().getProperty(pymtur_promoPeriod);
    }

    public void setPromoPeriod(String value)
    {
        getSemanticObject().setProperty(pymtur_promoPeriod, value);
    }

    public String getPromoType()
    {
        return getSemanticObject().getProperty(pymtur_promoType);
    }

    public void setPromoType(String value)
    {
        getSemanticObject().setProperty(pymtur_promoType, value);
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }
}
