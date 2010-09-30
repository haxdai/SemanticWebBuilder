package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar tipos de turismo 
   */
public abstract class TourismTypeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
   /**
   * Inversa. Mediante esta se puede determinar en que destinos se encuentra un tipo de turismo especifico
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestinationTourismTypeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestinationTourismTypeInv");
   /**
   * Clase que se encarga de administrar tipos de turismo
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_TourismType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#TourismType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#TourismType");

    public static class ClassMgr
    {
       /**
       * Returns a list of TourismType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.TourismType for all models
       * @return Iterator of org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType>(it, true);
        }

        public static org.semanticwb.pymtur.TourismType createTourismType(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.TourismType.ClassMgr.createTourismType(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.TourismType
       * @param id Identifier for org.semanticwb.pymtur.TourismType
       * @param model Model of the org.semanticwb.pymtur.TourismType
       * @return A org.semanticwb.pymtur.TourismType
       */
        public static org.semanticwb.pymtur.TourismType getTourismType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.TourismType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.TourismType
       * @param id Identifier for org.semanticwb.pymtur.TourismType
       * @param model Model of the org.semanticwb.pymtur.TourismType
       * @return A org.semanticwb.pymtur.TourismType
       */
        public static org.semanticwb.pymtur.TourismType createTourismType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.TourismType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.TourismType
       * @param id Identifier for org.semanticwb.pymtur.TourismType
       * @param model Model of the org.semanticwb.pymtur.TourismType
       */
        public static void removeTourismType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.TourismType
       * @param id Identifier for org.semanticwb.pymtur.TourismType
       * @param model Model of the org.semanticwb.pymtur.TourismType
       * @return true if the org.semanticwb.pymtur.TourismType exists, false otherwise
       */

        public static boolean hasTourismType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTourismType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.TourismType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.TourismType
       * @return Iterator with all the org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.TourismType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.TourismType with a determined DestinationTourismTypeInv
       * @param value DestinationTourismTypeInv of the type org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.TourismType
       * @return Iterator with all the org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypeByDestinationTourismTypeInv(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationTourismTypeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.TourismType with a determined DestinationTourismTypeInv
       * @param value DestinationTourismTypeInv of the type org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypeByDestinationTourismTypeInv(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationTourismTypeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.TourismType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.TourismType
       * @return Iterator with all the org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.TourismType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.TourismType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TourismTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TourismType
   */
    public TourismTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Gets all the org.semanticwb.pymtur.Destination
   * @return A GenericIterator with all the org.semanticwb.pymtur.Destination
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> listDestinationTourismTypeInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination>(getSemanticObject().listObjectProperties(pymtur_hasDestinationTourismTypeInv));
    }

   /**
   * Gets true if has a DestinationTourismTypeInv
   * @param value org.semanticwb.pymtur.Destination to verify
   * @return true if the org.semanticwb.pymtur.Destination exists, false otherwise
   */
    public boolean hasDestinationTourismTypeInv(org.semanticwb.pymtur.Destination value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestinationTourismTypeInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the DestinationTourismTypeInv
   * @return a org.semanticwb.pymtur.Destination
   */
    public org.semanticwb.pymtur.Destination getDestinationTourismTypeInv()
    {
         org.semanticwb.pymtur.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestinationTourismTypeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Destination)obj.createGenericInstance();
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
