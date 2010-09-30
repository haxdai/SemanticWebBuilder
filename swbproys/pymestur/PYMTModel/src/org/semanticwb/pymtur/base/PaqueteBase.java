package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar parametros para los diferentes tipos de paquetes (En este momento los que existen que son:3.Fichas y 4.Premier/Páginas web) 
   */
public abstract class PaqueteBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Precio especificado por un administrador para el paquete especifico
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_Price=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_Price");
   /**
   * Número máximo de cupones que la mipyme podría registrar
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_NumMaxCupones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_NumMaxCupones");
   /**
   * Terminos de uso para cada paquete
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_termsOfUse=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#termsOfUse");
   /**
   * Número máximo de fotos que la mipyme podría registrar
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_NumMaxPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_NumMaxPhotos");
   /**
   * Número máximo de promociones que la mipyme podría registrar
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_paq_NumMaxPromotions=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#paq_NumMaxPromotions");
   /**
   * Clase que se encarga de administrar parametros para los diferentes tipos de paquetes (En este momento los que existen que son:3.Fichas y 4.Premier/Páginas web)
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Paquete=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Paquete");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Paquete");

    public static class ClassMgr
    {
       /**
       * Returns a list of Paquete for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Paquete
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaquetes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Paquete for all models
       * @return Iterator of org.semanticwb.pymtur.Paquete
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaquetes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.Paquete
       * @param id Identifier for org.semanticwb.pymtur.Paquete
       * @param model Model of the org.semanticwb.pymtur.Paquete
       * @return A org.semanticwb.pymtur.Paquete
       */
        public static org.semanticwb.pymtur.Paquete getPaquete(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Paquete)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Paquete
       * @param id Identifier for org.semanticwb.pymtur.Paquete
       * @param model Model of the org.semanticwb.pymtur.Paquete
       * @return A org.semanticwb.pymtur.Paquete
       */
        public static org.semanticwb.pymtur.Paquete createPaquete(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Paquete)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Paquete
       * @param id Identifier for org.semanticwb.pymtur.Paquete
       * @param model Model of the org.semanticwb.pymtur.Paquete
       */
        public static void removePaquete(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Paquete
       * @param id Identifier for org.semanticwb.pymtur.Paquete
       * @param model Model of the org.semanticwb.pymtur.Paquete
       * @return true if the org.semanticwb.pymtur.Paquete exists, false otherwise
       */

        public static boolean hasPaquete(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPaquete(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.Paquete with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Paquete
       * @return Iterator with all the org.semanticwb.pymtur.Paquete
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Paquete with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Paquete
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Paquete with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Paquete
       * @return Iterator with all the org.semanticwb.pymtur.Paquete
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Paquete with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Paquete
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaqueteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Paquete> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PaqueteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Paquete
   */
    public PaqueteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Paq_Price property
* @return float with the Paq_Price
*/
    public float getPaq_Price()
    {
        return getSemanticObject().getFloatProperty(pymtur_paq_Price);
    }

/**
* Sets the Paq_Price property
* @param value long with the Paq_Price
*/
    public void setPaq_Price(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_paq_Price, value);
    }

/**
* Gets the Paq_NumMaxCupones property
* @return int with the Paq_NumMaxCupones
*/
    public int getPaq_NumMaxCupones()
    {
        return getSemanticObject().getIntProperty(pymtur_paq_NumMaxCupones);
    }

/**
* Sets the Paq_NumMaxCupones property
* @param value long with the Paq_NumMaxCupones
*/
    public void setPaq_NumMaxCupones(int value)
    {
        getSemanticObject().setIntProperty(pymtur_paq_NumMaxCupones, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the TermsOfUse property
* @return String with the TermsOfUse
*/
    public String getTermsOfUse()
    {
        return getSemanticObject().getProperty(pymtur_termsOfUse);
    }

/**
* Sets the TermsOfUse property
* @param value long with the TermsOfUse
*/
    public void setTermsOfUse(String value)
    {
        getSemanticObject().setProperty(pymtur_termsOfUse, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
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
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
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

/**
* Gets the Paq_NumMaxPhotos property
* @return int with the Paq_NumMaxPhotos
*/
    public int getPaq_NumMaxPhotos()
    {
        return getSemanticObject().getIntProperty(pymtur_paq_NumMaxPhotos);
    }

/**
* Sets the Paq_NumMaxPhotos property
* @param value long with the Paq_NumMaxPhotos
*/
    public void setPaq_NumMaxPhotos(int value)
    {
        getSemanticObject().setIntProperty(pymtur_paq_NumMaxPhotos, value);
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
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

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Paq_NumMaxPromotions property
* @return int with the Paq_NumMaxPromotions
*/
    public int getPaq_NumMaxPromotions()
    {
        return getSemanticObject().getIntProperty(pymtur_paq_NumMaxPromotions);
    }

/**
* Sets the Paq_NumMaxPromotions property
* @param value long with the Paq_NumMaxPromotions
*/
    public void setPaq_NumMaxPromotions(int value)
    {
        getSemanticObject().setIntProperty(pymtur_paq_NumMaxPromotions, value);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
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

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
