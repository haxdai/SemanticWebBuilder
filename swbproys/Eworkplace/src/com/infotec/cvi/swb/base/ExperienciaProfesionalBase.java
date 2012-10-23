package com.infotec.cvi.swb.base;


   /**
   * Elemento que almacena la Experiencia Profesional de la persona 
   */
public abstract class ExperienciaProfesionalBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
   /**
   * Elemento que almacena la Experiencia Profesional de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_ExperienciaProfesional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ExperienciaProfesional");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ExperienciaProfesional");

    public static class ClassMgr
    {
       /**
       * Returns a list of ExperienciaProfesional for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.ExperienciaProfesional
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ExperienciaProfesional> listExperienciaProfesionals(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaProfesional>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.ExperienciaProfesional for all models
       * @return Iterator of com.infotec.cvi.swb.ExperienciaProfesional
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ExperienciaProfesional> listExperienciaProfesionals()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaProfesional>(it, true);
        }

        public static com.infotec.cvi.swb.ExperienciaProfesional createExperienciaProfesional(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.ExperienciaProfesional.ClassMgr.createExperienciaProfesional(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.ExperienciaProfesional
       * @param id Identifier for com.infotec.cvi.swb.ExperienciaProfesional
       * @param model Model of the com.infotec.cvi.swb.ExperienciaProfesional
       * @return A com.infotec.cvi.swb.ExperienciaProfesional
       */
        public static com.infotec.cvi.swb.ExperienciaProfesional getExperienciaProfesional(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ExperienciaProfesional)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.ExperienciaProfesional
       * @param id Identifier for com.infotec.cvi.swb.ExperienciaProfesional
       * @param model Model of the com.infotec.cvi.swb.ExperienciaProfesional
       * @return A com.infotec.cvi.swb.ExperienciaProfesional
       */
        public static com.infotec.cvi.swb.ExperienciaProfesional createExperienciaProfesional(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ExperienciaProfesional)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.ExperienciaProfesional
       * @param id Identifier for com.infotec.cvi.swb.ExperienciaProfesional
       * @param model Model of the com.infotec.cvi.swb.ExperienciaProfesional
       */
        public static void removeExperienciaProfesional(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.ExperienciaProfesional
       * @param id Identifier for com.infotec.cvi.swb.ExperienciaProfesional
       * @param model Model of the com.infotec.cvi.swb.ExperienciaProfesional
       * @return true if the com.infotec.cvi.swb.ExperienciaProfesional exists, false otherwise
       */

        public static boolean hasExperienciaProfesional(String id, org.semanticwb.model.SWBModel model)
        {
            return (getExperienciaProfesional(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.ExperienciaProfesional with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ExperienciaProfesional
       * @return Iterator with all the com.infotec.cvi.swb.ExperienciaProfesional
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ExperienciaProfesional> listExperienciaProfesionalByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaProfesional> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ExperienciaProfesional with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ExperienciaProfesional
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ExperienciaProfesional> listExperienciaProfesionalByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaProfesional> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ExperienciaProfesional with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ExperienciaProfesional
       * @return Iterator with all the com.infotec.cvi.swb.ExperienciaProfesional
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ExperienciaProfesional> listExperienciaProfesionalByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaProfesional> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ExperienciaProfesional with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ExperienciaProfesional
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ExperienciaProfesional> listExperienciaProfesionalByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaProfesional> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ExperienciaProfesionalBase.ClassMgr getExperienciaProfesionalClassMgr()
    {
        return new ExperienciaProfesionalBase.ClassMgr();
    }

   /**
   * Constructs a ExperienciaProfesionalBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ExperienciaProfesional
   */
    public ExperienciaProfesionalBase(org.semanticwb.platform.SemanticObject base)
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
