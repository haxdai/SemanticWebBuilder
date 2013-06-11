package org.semanticwb.questionnaire.base;


public abstract class TitularBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty que_phone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#phone");
    public static final org.semanticwb.platform.SemanticProperty que_timePosition=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#timePosition");
    public static final org.semanticwb.platform.SemanticProperty que_email=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#email");
    public static final org.semanticwb.platform.SemanticProperty que_position=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#position");
    public static final org.semanticwb.platform.SemanticProperty que_name=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#name");
    public static final org.semanticwb.platform.SemanticClass que_Titular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Titular");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Titular");

    public static class ClassMgr
    {
       /**
       * Returns a list of Titular for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.Titular
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Titular> listTitulars(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Titular>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.Titular for all models
       * @return Iterator of org.semanticwb.questionnaire.Titular
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Titular> listTitulars()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Titular>(it, true);
        }

        public static org.semanticwb.questionnaire.Titular createTitular(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.Titular.ClassMgr.createTitular(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.Titular
       * @param id Identifier for org.semanticwb.questionnaire.Titular
       * @param model Model of the org.semanticwb.questionnaire.Titular
       * @return A org.semanticwb.questionnaire.Titular
       */
        public static org.semanticwb.questionnaire.Titular getTitular(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Titular)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.Titular
       * @param id Identifier for org.semanticwb.questionnaire.Titular
       * @param model Model of the org.semanticwb.questionnaire.Titular
       * @return A org.semanticwb.questionnaire.Titular
       */
        public static org.semanticwb.questionnaire.Titular createTitular(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Titular)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.Titular
       * @param id Identifier for org.semanticwb.questionnaire.Titular
       * @param model Model of the org.semanticwb.questionnaire.Titular
       */
        public static void removeTitular(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.Titular
       * @param id Identifier for org.semanticwb.questionnaire.Titular
       * @param model Model of the org.semanticwb.questionnaire.Titular
       * @return true if the org.semanticwb.questionnaire.Titular exists, false otherwise
       */

        public static boolean hasTitular(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTitular(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.Titular with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.questionnaire.Titular
       * @return Iterator with all the org.semanticwb.questionnaire.Titular
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Titular> listTitularByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Titular> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Titular with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.questionnaire.Titular
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Titular> listTitularByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Titular> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Titular with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.questionnaire.Titular
       * @return Iterator with all the org.semanticwb.questionnaire.Titular
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Titular> listTitularByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Titular> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Titular with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.questionnaire.Titular
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Titular> listTitularByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Titular> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static TitularBase.ClassMgr getTitularClassMgr()
    {
        return new TitularBase.ClassMgr();
    }

   /**
   * Constructs a TitularBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Titular
   */
    public TitularBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Phone property
* @return String with the Phone
*/
    public String getPhone()
    {
        return getSemanticObject().getProperty(que_phone);
    }

/**
* Sets the Phone property
* @param value long with the Phone
*/
    public void setPhone(String value)
    {
        getSemanticObject().setProperty(que_phone, value);
    }

/**
* Gets the TimePosition property
* @return String with the TimePosition
*/
    public String getTimePosition()
    {
        return getSemanticObject().getProperty(que_timePosition);
    }

/**
* Sets the TimePosition property
* @param value long with the TimePosition
*/
    public void setTimePosition(String value)
    {
        getSemanticObject().setProperty(que_timePosition, value);
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
* Gets the Email property
* @return String with the Email
*/
    public String getEmail()
    {
        return getSemanticObject().getProperty(que_email);
    }

/**
* Sets the Email property
* @param value long with the Email
*/
    public void setEmail(String value)
    {
        getSemanticObject().setProperty(que_email, value);
    }

/**
* Gets the Position property
* @return String with the Position
*/
    public String getPosition()
    {
        return getSemanticObject().getProperty(que_position);
    }

/**
* Sets the Position property
* @param value long with the Position
*/
    public void setPosition(String value)
    {
        getSemanticObject().setProperty(que_position, value);
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
* Gets the Name property
* @return String with the Name
*/
    public String getName()
    {
        return getSemanticObject().getProperty(que_name);
    }

/**
* Sets the Name property
* @param value long with the Name
*/
    public void setName(String value)
    {
        getSemanticObject().setProperty(que_name, value);
    }
}
