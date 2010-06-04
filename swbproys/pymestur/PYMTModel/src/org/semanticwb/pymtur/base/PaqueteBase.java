package org.semanticwb.pymtur.base;


public abstract class PaqueteBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_Price=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_Price");
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_NumMaxCupones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_NumMaxCupones");
    public static final org.semanticwb.platform.SemanticProperty pymtur_termsOfUse=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#termsOfUse");
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_NumMaxPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_NumMaxPhotos");
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_NumMaxPromotions=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_NumMaxPromotions");
    public static final org.semanticwb.platform.SemanticClass pymtur_Paquete=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Paquete");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Paquete");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaquetes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaquetes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete>(it, true);
        }

        public static org.semanticwb.pymtur.Paquete getPaquete(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Paquete)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.Paquete createPaquete(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Paquete)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removePaquete(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasPaquete(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPaquete(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public PaqueteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public float getPaq_Price()
    {
        return getSemanticObject().getFloatProperty(pymtur_paq_Price);
    }

    public void setPaq_Price(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_paq_Price, value);
    }

    public int getPaq_NumMaxCupones()
    {
        return getSemanticObject().getIntProperty(pymtur_paq_NumMaxCupones);
    }

    public void setPaq_NumMaxCupones(int value)
    {
        getSemanticObject().setIntProperty(pymtur_paq_NumMaxCupones, value);
    }

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

    public String getTermsOfUse()
    {
        return getSemanticObject().getProperty(pymtur_termsOfUse);
    }

    public void setTermsOfUse(String value)
    {
        getSemanticObject().setProperty(pymtur_termsOfUse, value);
    }

    public void setCreator(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public int getPaq_NumMaxPhotos()
    {
        return getSemanticObject().getIntProperty(pymtur_paq_NumMaxPhotos);
    }

    public void setPaq_NumMaxPhotos(int value)
    {
        getSemanticObject().setIntProperty(pymtur_paq_NumMaxPhotos, value);
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

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

    public int getPaq_NumMaxPromotions()
    {
        return getSemanticObject().getIntProperty(pymtur_paq_NumMaxPromotions);
    }

    public void setPaq_NumMaxPromotions(int value)
    {
        getSemanticObject().setIntProperty(pymtur_paq_NumMaxPromotions, value);
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

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
