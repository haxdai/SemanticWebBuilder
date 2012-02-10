package com.infotec.eworkplace.swb.base;


public abstract class DocumentoProbatorioBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Documento,org.semanticwb.model.Traceable,org.semanticwb.model.Iconable
{
    public static final org.semanticwb.platform.SemanticClass intranet_DocumentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");

    public static class ClassMgr
    {
       /**
       * Returns a list of DocumentoProbatorio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DocumentoProbatorio> listDocumentoProbatorios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.DocumentoProbatorio for all models
       * @return Iterator of com.infotec.eworkplace.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DocumentoProbatorio> listDocumentoProbatorios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio>(it, true);
        }

        public static com.infotec.eworkplace.swb.DocumentoProbatorio createDocumentoProbatorio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.DocumentoProbatorio.ClassMgr.createDocumentoProbatorio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.eworkplace.swb.DocumentoProbatorio
       * @return A com.infotec.eworkplace.swb.DocumentoProbatorio
       */
        public static com.infotec.eworkplace.swb.DocumentoProbatorio getDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.DocumentoProbatorio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.eworkplace.swb.DocumentoProbatorio
       * @return A com.infotec.eworkplace.swb.DocumentoProbatorio
       */
        public static com.infotec.eworkplace.swb.DocumentoProbatorio createDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.DocumentoProbatorio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.eworkplace.swb.DocumentoProbatorio
       */
        public static void removeDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.eworkplace.swb.DocumentoProbatorio
       * @return true if the com.infotec.eworkplace.swb.DocumentoProbatorio exists, false otherwise
       */

        public static boolean hasDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDocumentoProbatorio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DocumentoProbatorio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.eworkplace.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DocumentoProbatorio> listDocumentoProbatorioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DocumentoProbatorio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DocumentoProbatorio> listDocumentoProbatorioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DocumentoProbatorio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.eworkplace.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DocumentoProbatorio> listDocumentoProbatorioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DocumentoProbatorio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DocumentoProbatorio> listDocumentoProbatorioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DocumentoProbatorioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DocumentoProbatorio
   */
    public DocumentoProbatorioBase(org.semanticwb.platform.SemanticObject base)
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
