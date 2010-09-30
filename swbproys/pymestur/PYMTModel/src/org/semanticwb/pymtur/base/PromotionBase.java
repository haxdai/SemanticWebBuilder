package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar promociones 
   */
public abstract class PromotionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Clase principal del sistema de pymes turisticas. Una instancia de esta clase es en donde se almacena toda la información de una mipyme especifica.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
   /**
   * Inversa. Mediante esta se puede saber que mipyme tiene registrado cada promocion
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoServiceProviderInv");
   /**
   * Imagen de la promoción
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoImg=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoImg");
   /**
   * Vigencia del promocional
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoPeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoPeriod");
   /**
   * Tipo de promoción
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_promoType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#promoType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_endDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#endDate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_startDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#startDate");
   /**
   * Clase que se encarga de administrar promociones
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Promotion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Promotion
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Promotion> listPromotions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Promotion for all models
       * @return Iterator of org.semanticwb.pymtur.Promotion
       */

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
       /**
       * Gets a org.semanticwb.pymtur.Promotion
       * @param id Identifier for org.semanticwb.pymtur.Promotion
       * @param model Model of the org.semanticwb.pymtur.Promotion
       * @return A org.semanticwb.pymtur.Promotion
       */
        public static org.semanticwb.pymtur.Promotion getPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Promotion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Promotion
       * @param id Identifier for org.semanticwb.pymtur.Promotion
       * @param model Model of the org.semanticwb.pymtur.Promotion
       * @return A org.semanticwb.pymtur.Promotion
       */
        public static org.semanticwb.pymtur.Promotion createPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Promotion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Promotion
       * @param id Identifier for org.semanticwb.pymtur.Promotion
       * @param model Model of the org.semanticwb.pymtur.Promotion
       */
        public static void removePromotion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Promotion
       * @param id Identifier for org.semanticwb.pymtur.Promotion
       * @param model Model of the org.semanticwb.pymtur.Promotion
       * @return true if the org.semanticwb.pymtur.Promotion exists, false otherwise
       */

        public static boolean hasPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPromotion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.Promotion with a determined PromoServiceProviderInv
       * @param value PromoServiceProviderInv of the type org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.Promotion
       * @return Iterator with all the org.semanticwb.pymtur.Promotion
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Promotion> listPromotionByPromoServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_promoServiceProviderInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Promotion with a determined PromoServiceProviderInv
       * @param value PromoServiceProviderInv of the type org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.Promotion
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Promotion> listPromotionByPromoServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_promoServiceProviderInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PromotionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Promotion
   */
    public PromotionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property PromoServiceProviderInv
   * @param value PromoServiceProviderInv to set
   */

    public void setPromoServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_promoServiceProviderInv, value.getSemanticObject());
        }else
        {
            removePromoServiceProviderInv();
        }
    }
   /**
   * Remove the value for PromoServiceProviderInv property
   */

    public void removePromoServiceProviderInv()
    {
        getSemanticObject().removeProperty(pymtur_promoServiceProviderInv);
    }

   /**
   * Gets the PromoServiceProviderInv
   * @return a org.semanticwb.pymtur.ServiceProvider
   */
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

/**
* Gets the PromoImg property
* @return String with the PromoImg
*/
    public String getPromoImg()
    {
        return getSemanticObject().getProperty(pymtur_promoImg);
    }

/**
* Sets the PromoImg property
* @param value long with the PromoImg
*/
    public void setPromoImg(String value)
    {
        getSemanticObject().setProperty(pymtur_promoImg, value);
    }

/**
* Gets the PromoPeriod property
* @return String with the PromoPeriod
*/
    public String getPromoPeriod()
    {
        return getSemanticObject().getProperty(pymtur_promoPeriod);
    }

/**
* Sets the PromoPeriod property
* @param value long with the PromoPeriod
*/
    public void setPromoPeriod(String value)
    {
        getSemanticObject().setProperty(pymtur_promoPeriod, value);
    }

/**
* Gets the PromoType property
* @return String with the PromoType
*/
    public String getPromoType()
    {
        return getSemanticObject().getProperty(pymtur_promoType);
    }

/**
* Sets the PromoType property
* @param value long with the PromoType
*/
    public void setPromoType(String value)
    {
        getSemanticObject().setProperty(pymtur_promoType, value);
    }

/**
* Gets the EndDate property
* @return String with the EndDate
*/
    public String getEndDate()
    {
        return getSemanticObject().getProperty(pymtur_endDate);
    }

/**
* Sets the EndDate property
* @param value long with the EndDate
*/
    public void setEndDate(String value)
    {
        getSemanticObject().setProperty(pymtur_endDate, value);
    }

/**
* Gets the StartDate property
* @return String with the StartDate
*/
    public String getStartDate()
    {
        return getSemanticObject().getProperty(pymtur_startDate);
    }

/**
* Sets the StartDate property
* @param value long with the StartDate
*/
    public void setStartDate(String value)
    {
        getSemanticObject().setProperty(pymtur_startDate, value);
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
}
