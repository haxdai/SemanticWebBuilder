package org.semanticwb.cptm.base;


   /**
   * Clase para administrar tipos de Destinos, pudiendo ser: Destinos, Pueblos Mágicos ó Atractivos 
   */
public abstract class DestinationTypeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Estados de la República (Ej. Tamaulipas, Morelos)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#State");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasStateDestinationTypeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasStateDestinationTypeInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Puntos Geográficos (Cancun, Tampico, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeographicPoint");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestinationTypeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestinationTypeInv");
   /**
   * Clase para administrar tipos de Destinos, pudiendo ser: Destinos, Pueblos Mágicos ó Atractivos
   */
    public static final org.semanticwb.platform.SemanticClass cptm_DestinationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#DestinationType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#DestinationType");

    public static class ClassMgr
    {
       /**
       * Returns a list of DestinationType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.DestinationType for all models
       * @return Iterator of org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.DestinationType
       * @param id Identifier for org.semanticwb.cptm.DestinationType
       * @param model Model of the org.semanticwb.cptm.DestinationType
       * @return A org.semanticwb.cptm.DestinationType
       */
        public static org.semanticwb.cptm.DestinationType getDestinationType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.DestinationType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.DestinationType
       * @param id Identifier for org.semanticwb.cptm.DestinationType
       * @param model Model of the org.semanticwb.cptm.DestinationType
       * @return A org.semanticwb.cptm.DestinationType
       */
        public static org.semanticwb.cptm.DestinationType createDestinationType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.DestinationType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.DestinationType
       * @param id Identifier for org.semanticwb.cptm.DestinationType
       * @param model Model of the org.semanticwb.cptm.DestinationType
       */
        public static void removeDestinationType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.DestinationType
       * @param id Identifier for org.semanticwb.cptm.DestinationType
       * @param model Model of the org.semanticwb.cptm.DestinationType
       * @return true if the org.semanticwb.cptm.DestinationType exists, false otherwise
       */

        public static boolean hasDestinationType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDestinationType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.DestinationType
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined StateDestinationTypeInv
       * @param value StateDestinationTypeInv of the type org.semanticwb.cptm.State
       * @param model Model of the org.semanticwb.cptm.DestinationType
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByStateDestinationTypeInv(org.semanticwb.cptm.State value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasStateDestinationTypeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined StateDestinationTypeInv
       * @param value StateDestinationTypeInv of the type org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByStateDestinationTypeInv(org.semanticwb.cptm.State value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasStateDestinationTypeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined DestinationTypeInv
       * @param value DestinationTypeInv of the type org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.DestinationType
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByDestinationTypeInv(org.semanticwb.cptm.GeographicPoint value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTypeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined DestinationTypeInv
       * @param value DestinationTypeInv of the type org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByDestinationTypeInv(org.semanticwb.cptm.GeographicPoint value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTypeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.DestinationType
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.DestinationType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.DestinationType
       */

        public static java.util.Iterator<org.semanticwb.cptm.DestinationType> listDestinationTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DestinationTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DestinationType
   */
    public DestinationTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Gets all the org.semanticwb.cptm.State
   * @return A GenericIterator with all the org.semanticwb.cptm.State
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> listStateDestinationTypeInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State>(getSemanticObject().listObjectProperties(cptm_hasStateDestinationTypeInv));
    }

   /**
   * Gets true if has a StateDestinationTypeInv
   * @param value org.semanticwb.cptm.State to verify
   * @return true if the org.semanticwb.cptm.State exists, false otherwise
   */
    public boolean hasStateDestinationTypeInv(org.semanticwb.cptm.State value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasStateDestinationTypeInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the StateDestinationTypeInv
   * @return a org.semanticwb.cptm.State
   */
    public org.semanticwb.cptm.State getStateDestinationTypeInv()
    {
         org.semanticwb.cptm.State ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasStateDestinationTypeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.State)obj.createGenericInstance();
         }
         return ret;
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
   * Gets all the org.semanticwb.cptm.GeographicPoint
   * @return A GenericIterator with all the org.semanticwb.cptm.GeographicPoint
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> listDestinationTypeInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint>(getSemanticObject().listObjectProperties(cptm_hasDestinationTypeInv));
    }

   /**
   * Gets true if has a DestinationTypeInv
   * @param value org.semanticwb.cptm.GeographicPoint to verify
   * @return true if the org.semanticwb.cptm.GeographicPoint exists, false otherwise
   */
    public boolean hasDestinationTypeInv(org.semanticwb.cptm.GeographicPoint value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasDestinationTypeInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the DestinationTypeInv
   * @return a org.semanticwb.cptm.GeographicPoint
   */
    public org.semanticwb.cptm.GeographicPoint getDestinationTypeInv()
    {
         org.semanticwb.cptm.GeographicPoint ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasDestinationTypeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeographicPoint)obj.createGenericInstance();
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
}
