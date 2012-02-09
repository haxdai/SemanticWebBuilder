package com.infotec.eworkplace.swb.base;


public abstract class CartasRecomendacionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Iconable,com.infotec.eworkplace.swb.Documento,org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_CartasRecomendacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CartasRecomendacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CartasRecomendacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of CartasRecomendacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CartasRecomendacion> listCartasRecomendacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CartasRecomendacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.CartasRecomendacion for all models
       * @return Iterator of com.infotec.eworkplace.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CartasRecomendacion> listCartasRecomendacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CartasRecomendacion>(it, true);
        }

        public static com.infotec.eworkplace.swb.CartasRecomendacion createCartasRecomendacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.CartasRecomendacion.ClassMgr.createCartasRecomendacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.eworkplace.swb.CartasRecomendacion
       * @param model Model of the com.infotec.eworkplace.swb.CartasRecomendacion
       * @return A com.infotec.eworkplace.swb.CartasRecomendacion
       */
        public static com.infotec.eworkplace.swb.CartasRecomendacion getCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CartasRecomendacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.eworkplace.swb.CartasRecomendacion
       * @param model Model of the com.infotec.eworkplace.swb.CartasRecomendacion
       * @return A com.infotec.eworkplace.swb.CartasRecomendacion
       */
        public static com.infotec.eworkplace.swb.CartasRecomendacion createCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CartasRecomendacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.eworkplace.swb.CartasRecomendacion
       * @param model Model of the com.infotec.eworkplace.swb.CartasRecomendacion
       */
        public static void removeCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.eworkplace.swb.CartasRecomendacion
       * @param model Model of the com.infotec.eworkplace.swb.CartasRecomendacion
       * @return true if the com.infotec.eworkplace.swb.CartasRecomendacion exists, false otherwise
       */

        public static boolean hasCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCartasRecomendacion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CartasRecomendacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CartasRecomendacion
       * @return Iterator with all the com.infotec.eworkplace.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CartasRecomendacion> listCartasRecomendacionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CartasRecomendacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CartasRecomendacion> listCartasRecomendacionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CartasRecomendacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CartasRecomendacion
       * @return Iterator with all the com.infotec.eworkplace.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CartasRecomendacion> listCartasRecomendacionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CartasRecomendacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CartasRecomendacion> listCartasRecomendacionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CartasRecomendacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CartasRecomendacion
   */
    public CartasRecomendacionBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the IconClass property
* @return String with the IconClass
*/
    public String getIconClass()
    {
        return getSemanticObject().getProperty(swb_iconClass);
    }

/**
* Sets the IconClass property
* @param value long with the IconClass
*/
    public void setIconClass(String value)
    {
        getSemanticObject().setProperty(swb_iconClass, value);
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
* Gets the Filename property
* @return String with the Filename
*/
    public String getFilename()
    {
        return getSemanticObject().getProperty(intranet_filename);
    }

/**
* Sets the Filename property
* @param value long with the Filename
*/
    public void setFilename(String value)
    {
        getSemanticObject().setProperty(intranet_filename, value);
    }
}
