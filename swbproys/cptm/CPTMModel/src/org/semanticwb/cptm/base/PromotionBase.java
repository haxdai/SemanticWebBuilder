package org.semanticwb.cptm.base;


public abstract class PromotionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Calendarable,org.semanticwb.model.Descriptiveable
{
   /**
   * Interface para datos generales de Cadenas, Marcas y Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeneralCompany=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeneralCompany");
    public static final org.semanticwb.platform.SemanticProperty cptm_promoCompanyInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#promoCompanyInv");
    public static final org.semanticwb.platform.SemanticProperty cptm_URLTargetPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#URLTargetPromotion");
   /**
   * Clase principal del sistema de visit-méxico. Una instancia de esta clase es en donde se almacena toda la información de un proveedor de servicios especifico.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Company=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Company");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasPromoCompany=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasPromoCompany");
    public static final org.semanticwb.platform.SemanticProperty cptm_URLpromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#URLpromotion");
    public static final org.semanticwb.platform.SemanticClass cptm_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Promotion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Promotion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Promotion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Promotion for all models
       * @return Iterator of org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return A org.semanticwb.cptm.Promotion
       */
        public static org.semanticwb.cptm.Promotion getPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Promotion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return A org.semanticwb.cptm.Promotion
       */
        public static org.semanticwb.cptm.Promotion createPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Promotion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       */
        public static void removePromotion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return true if the org.semanticwb.cptm.Promotion exists, false otherwise
       */

        public static boolean hasPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPromotion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined PromoCompanyInv
       * @param value PromoCompanyInv of the type org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByPromoCompanyInv(org.semanticwb.cptm.GeneralCompany value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_promoCompanyInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined PromoCompanyInv
       * @param value PromoCompanyInv of the type org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByPromoCompanyInv(org.semanticwb.cptm.GeneralCompany value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_promoCompanyInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined PromoCompany
       * @param value PromoCompany of the type org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByPromoCompany(org.semanticwb.cptm.Company value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromoCompany, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined PromoCompany
       * @param value PromoCompany of the type org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByPromoCompany(org.semanticwb.cptm.Company value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromoCompany,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
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
   * Sets the value for the property PromoCompanyInv
   * @param value PromoCompanyInv to set
   */

    public void setPromoCompanyInv(org.semanticwb.cptm.GeneralCompany value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_promoCompanyInv, value.getSemanticObject());
        }else
        {
            removePromoCompanyInv();
        }
    }
   /**
   * Remove the value for PromoCompanyInv property
   */

    public void removePromoCompanyInv()
    {
        getSemanticObject().removeProperty(cptm_promoCompanyInv);
    }

   /**
   * Gets the PromoCompanyInv
   * @return a org.semanticwb.cptm.GeneralCompany
   */
    public org.semanticwb.cptm.GeneralCompany getPromoCompanyInv()
    {
         org.semanticwb.cptm.GeneralCompany ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_promoCompanyInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeneralCompany)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the URLTargetPromotion property
* @return String with the URLTargetPromotion
*/
    public String getURLTargetPromotion()
    {
        return getSemanticObject().getProperty(cptm_URLTargetPromotion);
    }

/**
* Sets the URLTargetPromotion property
* @param value long with the URLTargetPromotion
*/
    public void setURLTargetPromotion(String value)
    {
        getSemanticObject().setProperty(cptm_URLTargetPromotion, value);
    }

/**
* Gets the PhotoEscudoAlt property
* @return String with the PhotoEscudoAlt
*/
    public String getPhotoEscudoAlt()
    {
        return getSemanticObject().getProperty(cptm_photoEscudoAlt);
    }

/**
* Sets the PhotoEscudoAlt property
* @param value long with the PhotoEscudoAlt
*/
    public void setPhotoEscudoAlt(String value)
    {
        getSemanticObject().setProperty(cptm_photoEscudoAlt, value);
    }

    public String getPhotoEscudoAlt(String lang)
    {
        return getSemanticObject().getProperty(cptm_photoEscudoAlt, null, lang);
    }

    public String getDisplayPhotoEscudoAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_photoEscudoAlt, lang);
    }

    public void setPhotoEscudoAlt(String photoEscudoAlt, String lang)
    {
        getSemanticObject().setProperty(cptm_photoEscudoAlt, photoEscudoAlt, lang);
    }

/**
* Gets the PhotoAuthor property
* @return String with the PhotoAuthor
*/
    public String getPhotoAuthor()
    {
        return getSemanticObject().getProperty(cptm_photoAuthor);
    }

/**
* Sets the PhotoAuthor property
* @param value long with the PhotoAuthor
*/
    public void setPhotoAuthor(String value)
    {
        getSemanticObject().setProperty(cptm_photoAuthor, value);
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
* Gets the PhotoEscudo property
* @return String with the PhotoEscudo
*/
    public String getPhotoEscudo()
    {
        return getSemanticObject().getProperty(cptm_photoEscudo);
    }

/**
* Sets the PhotoEscudo property
* @param value long with the PhotoEscudo
*/
    public void setPhotoEscudo(String value)
    {
        getSemanticObject().setProperty(cptm_photoEscudo, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.Company
   * @return A GenericIterator with all the org.semanticwb.cptm.Company
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> listPromoCompanies()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company>(getSemanticObject().listObjectProperties(cptm_hasPromoCompany));
    }

   /**
   * Gets true if has a PromoCompany
   * @param value org.semanticwb.cptm.Company to verify
   * @return true if the org.semanticwb.cptm.Company exists, false otherwise
   */
    public boolean hasPromoCompany(org.semanticwb.cptm.Company value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasPromoCompany,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PromoCompany
   * @param value org.semanticwb.cptm.Company to add
   */

    public void addPromoCompany(org.semanticwb.cptm.Company value)
    {
        getSemanticObject().addObjectProperty(cptm_hasPromoCompany, value.getSemanticObject());
    }
   /**
   * Removes all the PromoCompany
   */

    public void removeAllPromoCompany()
    {
        getSemanticObject().removeProperty(cptm_hasPromoCompany);
    }
   /**
   * Removes a PromoCompany
   * @param value org.semanticwb.cptm.Company to remove
   */

    public void removePromoCompany(org.semanticwb.cptm.Company value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasPromoCompany,value.getSemanticObject());
    }

   /**
   * Gets the PromoCompany
   * @return a org.semanticwb.cptm.Company
   */
    public org.semanticwb.cptm.Company getPromoCompany()
    {
         org.semanticwb.cptm.Company ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasPromoCompany);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Company)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PhotoAlt property
* @return String with the PhotoAlt
*/
    public String getPhotoAlt()
    {
        return getSemanticObject().getProperty(cptm_photoAlt);
    }

/**
* Sets the PhotoAlt property
* @param value long with the PhotoAlt
*/
    public void setPhotoAlt(String value)
    {
        getSemanticObject().setProperty(cptm_photoAlt, value);
    }

    public String getPhotoAlt(String lang)
    {
        return getSemanticObject().getProperty(cptm_photoAlt, null, lang);
    }

    public String getDisplayPhotoAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_photoAlt, lang);
    }

    public void setPhotoAlt(String photoAlt, String lang)
    {
        getSemanticObject().setProperty(cptm_photoAlt, photoAlt, lang);
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
   * Gets all the org.semanticwb.model.Calendar
   * @return A GenericIterator with all the org.semanticwb.model.Calendar
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar> listCalendars()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar>(getSemanticObject().listObjectProperties(swb_hasCalendar));
    }

   /**
   * Gets true if has a Calendar
   * @param value org.semanticwb.model.Calendar to verify
   * @return true if the org.semanticwb.model.Calendar exists, false otherwise
   */
    public boolean hasCalendar(org.semanticwb.model.Calendar value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasCalendar,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Calendar
   * @param value org.semanticwb.model.Calendar to add
   */

    public void addCalendar(org.semanticwb.model.Calendar value)
    {
        getSemanticObject().addObjectProperty(swb_hasCalendar, value.getSemanticObject());
    }
   /**
   * Removes all the Calendar
   */

    public void removeAllCalendar()
    {
        getSemanticObject().removeProperty(swb_hasCalendar);
    }
   /**
   * Removes a Calendar
   * @param value org.semanticwb.model.Calendar to remove
   */

    public void removeCalendar(org.semanticwb.model.Calendar value)
    {
        getSemanticObject().removeObjectProperty(swb_hasCalendar,value.getSemanticObject());
    }

   /**
   * Gets the Calendar
   * @return a org.semanticwb.model.Calendar
   */
    public org.semanticwb.model.Calendar getCalendar()
    {
         org.semanticwb.model.Calendar ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasCalendar);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Calendar)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Photo
   * @return A GenericIterator with all the org.semanticwb.cptm.Photo
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo> listMorePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo>(getSemanticObject().listObjectProperties(cptm_hasMorePhoto));
    }

   /**
   * Gets true if has a MorePhoto
   * @param value org.semanticwb.cptm.Photo to verify
   * @return true if the org.semanticwb.cptm.Photo exists, false otherwise
   */
    public boolean hasMorePhoto(org.semanticwb.cptm.Photo value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasMorePhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a MorePhoto
   * @param value org.semanticwb.cptm.Photo to add
   */

    public void addMorePhoto(org.semanticwb.cptm.Photo value)
    {
        getSemanticObject().addObjectProperty(cptm_hasMorePhoto, value.getSemanticObject());
    }
   /**
   * Removes all the MorePhoto
   */

    public void removeAllMorePhoto()
    {
        getSemanticObject().removeProperty(cptm_hasMorePhoto);
    }
   /**
   * Removes a MorePhoto
   * @param value org.semanticwb.cptm.Photo to remove
   */

    public void removeMorePhoto(org.semanticwb.cptm.Photo value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasMorePhoto,value.getSemanticObject());
    }

   /**
   * Gets the MorePhoto
   * @return a org.semanticwb.cptm.Photo
   */
    public org.semanticwb.cptm.Photo getMorePhoto()
    {
         org.semanticwb.cptm.Photo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasMorePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Photo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Photo property
* @return String with the Photo
*/
    public String getPhoto()
    {
        return getSemanticObject().getProperty(cptm_photo);
    }

/**
* Sets the Photo property
* @param value long with the Photo
*/
    public void setPhoto(String value)
    {
        getSemanticObject().setProperty(cptm_photo, value);
    }

/**
* Gets the URLpromotion property
* @return String with the URLpromotion
*/
    public String getURLpromotion()
    {
        return getSemanticObject().getProperty(cptm_URLpromotion);
    }

/**
* Sets the URLpromotion property
* @param value long with the URLpromotion
*/
    public void setURLpromotion(String value)
    {
        getSemanticObject().setProperty(cptm_URLpromotion, value);
    }
}
