package com.infotec.conorg.base;


public abstract class AvisoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty conorg_fromUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#fromUser");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasToUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasToUser");
    public static final org.semanticwb.platform.SemanticClass conorg_WorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");
    public static final org.semanticwb.platform.SemanticProperty conorg_toWorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#toWorkSpace");
    public static final org.semanticwb.platform.SemanticClass conorg_Aviso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Aviso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Aviso");

    public static class ClassMgr
    {
       /**
       * Returns a list of Aviso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Aviso for all models
       * @return Iterator of com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso>(it, true);
        }

        public static com.infotec.conorg.Aviso createAviso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Aviso.ClassMgr.createAviso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Aviso
       * @param id Identifier for com.infotec.conorg.Aviso
       * @param model Model of the com.infotec.conorg.Aviso
       * @return A com.infotec.conorg.Aviso
       */
        public static com.infotec.conorg.Aviso getAviso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Aviso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Aviso
       * @param id Identifier for com.infotec.conorg.Aviso
       * @param model Model of the com.infotec.conorg.Aviso
       * @return A com.infotec.conorg.Aviso
       */
        public static com.infotec.conorg.Aviso createAviso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Aviso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Aviso
       * @param id Identifier for com.infotec.conorg.Aviso
       * @param model Model of the com.infotec.conorg.Aviso
       */
        public static void removeAviso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Aviso
       * @param id Identifier for com.infotec.conorg.Aviso
       * @param model Model of the com.infotec.conorg.Aviso
       * @return true if the com.infotec.conorg.Aviso exists, false otherwise
       */

        public static boolean hasAviso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAviso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined FromUser
       * @param value FromUser of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Aviso
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByFromUser(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_fromUser, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined FromUser
       * @param value FromUser of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByFromUser(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_fromUser,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Aviso
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Aviso
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined ToUser
       * @param value ToUser of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Aviso
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByToUser(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasToUser, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined ToUser
       * @param value ToUser of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByToUser(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasToUser,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined ToWorkSpace
       * @param value ToWorkSpace of the type com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.Aviso
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByToWorkSpace(com.infotec.conorg.WorkSpace value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_toWorkSpace, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Aviso with a determined ToWorkSpace
       * @param value ToWorkSpace of the type com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.Aviso
       */

        public static java.util.Iterator<com.infotec.conorg.Aviso> listAvisoByToWorkSpace(com.infotec.conorg.WorkSpace value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Aviso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_toWorkSpace,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AvisoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Aviso
   */
    public AvisoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property FromUser
   * @param value FromUser to set
   */

    public void setFromUser(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_fromUser, value.getSemanticObject());
        }else
        {
            removeFromUser();
        }
    }
   /**
   * Remove the value for FromUser property
   */

    public void removeFromUser()
    {
        getSemanticObject().removeProperty(conorg_fromUser);
    }

   /**
   * Gets the FromUser
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getFromUser()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_fromUser);
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
   /**
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listToUsers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(conorg_hasToUser));
    }

   /**
   * Gets true if has a ToUser
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasToUser(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasToUser,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ToUser
   * @param value org.semanticwb.model.User to add
   */

    public void addToUser(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(conorg_hasToUser, value.getSemanticObject());
    }
   /**
   * Removes all the ToUser
   */

    public void removeAllToUser()
    {
        getSemanticObject().removeProperty(conorg_hasToUser);
    }
   /**
   * Removes a ToUser
   * @param value org.semanticwb.model.User to remove
   */

    public void removeToUser(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasToUser,value.getSemanticObject());
    }

   /**
   * Gets the ToUser
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getToUser()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasToUser);
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
   * Sets the value for the property ToWorkSpace
   * @param value ToWorkSpace to set
   */

    public void setToWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_toWorkSpace, value.getSemanticObject());
        }else
        {
            removeToWorkSpace();
        }
    }
   /**
   * Remove the value for ToWorkSpace property
   */

    public void removeToWorkSpace()
    {
        getSemanticObject().removeProperty(conorg_toWorkSpace);
    }

   /**
   * Gets the ToWorkSpace
   * @return a com.infotec.conorg.WorkSpace
   */
    public com.infotec.conorg.WorkSpace getToWorkSpace()
    {
         com.infotec.conorg.WorkSpace ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_toWorkSpace);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.WorkSpace)obj.createGenericInstance();
         }
         return ret;
    }
}
