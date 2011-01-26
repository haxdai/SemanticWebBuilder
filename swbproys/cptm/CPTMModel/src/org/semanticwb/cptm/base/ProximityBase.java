package org.semanticwb.cptm.base;


   /**
   * Relación de cercanias entre dos puntos geográficos 
   */
public abstract class ProximityBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
   /**
   * Relación de cercania entre dos puntos geográficos
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasLocalityProx=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasLocalityProx");
   /**
   * Punto Geográfico a asociar cercanias
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_proxGeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#proxGeographicPoint");
   /**
   * Relación de cercanias entre dos puntos geográficos
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Proximity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Proximity");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Proximity");

    public static class ClassMgr
    {
       /**
       * Returns a list of Proximity for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximities(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Proximity for all models
       * @return Iterator of org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximities()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity>(it, true);
        }

        public static org.semanticwb.cptm.Proximity createProximity(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.cptm.Proximity.ClassMgr.createProximity(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return A org.semanticwb.cptm.Proximity
       */
        public static org.semanticwb.cptm.Proximity getProximity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Proximity)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return A org.semanticwb.cptm.Proximity
       */
        public static org.semanticwb.cptm.Proximity createProximity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Proximity)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       */
        public static void removeProximity(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return true if the org.semanticwb.cptm.Proximity exists, false otherwise
       */

        public static boolean hasProximity(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProximity(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined LocalityProx
       * @param value LocalityProx of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByLocalityProx(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityProx, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined LocalityProx
       * @param value LocalityProx of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByLocalityProx(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityProx,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined ProxGeographicPoint
       * @param value ProxGeographicPoint of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByProxGeographicPoint(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_proxGeographicPoint, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined ProxGeographicPoint
       * @param value ProxGeographicPoint of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByProxGeographicPoint(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_proxGeographicPoint,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProximityBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Proximity
   */
    public ProximityBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listLocalityProxes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasLocalityProx));
    }

   /**
   * Gets true if has a LocalityProx
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasLocalityProx(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasLocalityProx,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a LocalityProx
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addLocalityProx(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasLocalityProx, value.getSemanticObject());
    }
   /**
   * Removes all the LocalityProx
   */

    public void removeAllLocalityProx()
    {
        getSemanticObject().removeProperty(cptm_hasLocalityProx);
    }
   /**
   * Removes a LocalityProx
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeLocalityProx(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasLocalityProx,value.getSemanticObject());
    }

   /**
   * Gets the LocalityProx
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getLocalityProx()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasLocalityProx);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
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
   * Sets the value for the property ProxGeographicPoint
   * @param value ProxGeographicPoint to set
   */

    public void setProxGeographicPoint(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_proxGeographicPoint, value.getSemanticObject());
        }else
        {
            removeProxGeographicPoint();
        }
    }
   /**
   * Remove the value for ProxGeographicPoint property
   */

    public void removeProxGeographicPoint()
    {
        getSemanticObject().removeProperty(cptm_proxGeographicPoint);
    }

   /**
   * Gets the ProxGeographicPoint
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getProxGeographicPoint()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_proxGeographicPoint);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
}
