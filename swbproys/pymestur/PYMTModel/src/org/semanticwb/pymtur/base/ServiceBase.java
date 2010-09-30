package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar servicios del catalogo 
   */
public abstract class ServiceBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Clase principal del sistema de pymes turisticas. Una instancia de esta clase es en donde se almacena toda la información de una mipyme especifica.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
   /**
   * Inversa. Mediante esta se puede determinar que mipymes cuentan con cada servicio en especifico
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasSrvServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasSrvServiceProviderInv");
   /**
   * Clase que se encarga de administrar servicios del catalogo
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");

    public static class ClassMgr
    {
       /**
       * Returns a list of Service for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServices(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Service for all models
       * @return Iterator of org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServices()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service>(it, true);
        }

        public static org.semanticwb.pymtur.Service createService(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.Service.ClassMgr.createService(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.Service
       * @param id Identifier for org.semanticwb.pymtur.Service
       * @param model Model of the org.semanticwb.pymtur.Service
       * @return A org.semanticwb.pymtur.Service
       */
        public static org.semanticwb.pymtur.Service getService(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Service)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Service
       * @param id Identifier for org.semanticwb.pymtur.Service
       * @param model Model of the org.semanticwb.pymtur.Service
       * @return A org.semanticwb.pymtur.Service
       */
        public static org.semanticwb.pymtur.Service createService(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Service)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Service
       * @param id Identifier for org.semanticwb.pymtur.Service
       * @param model Model of the org.semanticwb.pymtur.Service
       */
        public static void removeService(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Service
       * @param id Identifier for org.semanticwb.pymtur.Service
       * @param model Model of the org.semanticwb.pymtur.Service
       * @return true if the org.semanticwb.pymtur.Service exists, false otherwise
       */

        public static boolean hasService(String id, org.semanticwb.model.SWBModel model)
        {
            return (getService(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.Service with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Service
       * @return Iterator with all the org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServiceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Service with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServiceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Service with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Service
       * @return Iterator with all the org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServiceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Service with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServiceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Service with a determined ServiceProvider
       * @param value ServiceProvider of the type org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.Service
       * @return Iterator with all the org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServiceByServiceProvider(org.semanticwb.pymtur.ServiceProvider value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSrvServiceProviderInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Service with a determined ServiceProvider
       * @param value ServiceProvider of the type org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.Service
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Service> listServiceByServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSrvServiceProviderInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ServiceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Service
   */
    public ServiceBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.pymtur.ServiceProvider
   * @return A GenericIterator with all the org.semanticwb.pymtur.ServiceProvider
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(getSemanticObject().listObjectProperties(pymtur_hasSrvServiceProviderInv));
    }

   /**
   * Gets true if has a ServiceProvider
   * @param value org.semanticwb.pymtur.ServiceProvider to verify
   * @return true if the org.semanticwb.pymtur.ServiceProvider exists, false otherwise
   */
    public boolean hasServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasSrvServiceProviderInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the ServiceProvider
   * @return a org.semanticwb.pymtur.ServiceProvider
   */
    public org.semanticwb.pymtur.ServiceProvider getServiceProvider()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasSrvServiceProviderInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
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
