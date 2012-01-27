package org.semanticwb.cptm.base;


   /**
   * Relación de una sección con otra sección de otro modelo 
   */
public abstract class ModelRelationBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cptm_remoteWebPageRel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#remoteWebPageRel");
    public static final org.semanticwb.platform.SemanticClass cptm_RemoteFuntionalityCat=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RemoteFuntionalityCat");
    public static final org.semanticwb.platform.SemanticProperty cptm_remoteFuntionality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#remoteFuntionality");
    public static final org.semanticwb.platform.SemanticProperty cptm_remoteModelRel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#remoteModelRel");
   /**
   * Relación de una sección con otra sección de otro modelo
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ModelRelation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ModelRelation");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ModelRelation");

    public static class ClassMgr
    {
       /**
       * Returns a list of ModelRelation for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ModelRelation
       */

        public static java.util.Iterator<org.semanticwb.cptm.ModelRelation> listModelRelations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ModelRelation>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ModelRelation for all models
       * @return Iterator of org.semanticwb.cptm.ModelRelation
       */

        public static java.util.Iterator<org.semanticwb.cptm.ModelRelation> listModelRelations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ModelRelation>(it, true);
        }

        public static org.semanticwb.cptm.ModelRelation createModelRelation(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.cptm.ModelRelation.ClassMgr.createModelRelation(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.cptm.ModelRelation
       * @param id Identifier for org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.ModelRelation
       * @return A org.semanticwb.cptm.ModelRelation
       */
        public static org.semanticwb.cptm.ModelRelation getModelRelation(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ModelRelation)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ModelRelation
       * @param id Identifier for org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.ModelRelation
       * @return A org.semanticwb.cptm.ModelRelation
       */
        public static org.semanticwb.cptm.ModelRelation createModelRelation(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ModelRelation)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ModelRelation
       * @param id Identifier for org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.ModelRelation
       */
        public static void removeModelRelation(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ModelRelation
       * @param id Identifier for org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.ModelRelation
       * @return true if the org.semanticwb.cptm.ModelRelation exists, false otherwise
       */

        public static boolean hasModelRelation(String id, org.semanticwb.model.SWBModel model)
        {
            return (getModelRelation(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ModelRelation with a determined RemoteFuntionality
       * @param value RemoteFuntionality of the type org.semanticwb.cptm.RemoteFuntionalityCat
       * @param model Model of the org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.ModelRelation
       */

        public static java.util.Iterator<org.semanticwb.cptm.ModelRelation> listModelRelationByRemoteFuntionality(org.semanticwb.cptm.RemoteFuntionalityCat value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ModelRelation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_remoteFuntionality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ModelRelation with a determined RemoteFuntionality
       * @param value RemoteFuntionality of the type org.semanticwb.cptm.RemoteFuntionalityCat
       * @return Iterator with all the org.semanticwb.cptm.ModelRelation
       */

        public static java.util.Iterator<org.semanticwb.cptm.ModelRelation> listModelRelationByRemoteFuntionality(org.semanticwb.cptm.RemoteFuntionalityCat value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ModelRelation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_remoteFuntionality,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ModelRelationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ModelRelation
   */
    public ModelRelationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the RemoteWebPageRel property
* @return String with the RemoteWebPageRel
*/
    public String getRemoteWebPageRel()
    {
        return getSemanticObject().getProperty(cptm_remoteWebPageRel);
    }

/**
* Sets the RemoteWebPageRel property
* @param value long with the RemoteWebPageRel
*/
    public void setRemoteWebPageRel(String value)
    {
        getSemanticObject().setProperty(cptm_remoteWebPageRel, value);
    }
   /**
   * Sets the value for the property RemoteFuntionality
   * @param value RemoteFuntionality to set
   */

    public void setRemoteFuntionality(org.semanticwb.cptm.RemoteFuntionalityCat value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_remoteFuntionality, value.getSemanticObject());
        }else
        {
            removeRemoteFuntionality();
        }
    }
   /**
   * Remove the value for RemoteFuntionality property
   */

    public void removeRemoteFuntionality()
    {
        getSemanticObject().removeProperty(cptm_remoteFuntionality);
    }

   /**
   * Gets the RemoteFuntionality
   * @return a org.semanticwb.cptm.RemoteFuntionalityCat
   */
    public org.semanticwb.cptm.RemoteFuntionalityCat getRemoteFuntionality()
    {
         org.semanticwb.cptm.RemoteFuntionalityCat ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_remoteFuntionality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.RemoteFuntionalityCat)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RemoteModelRel property
* @return String with the RemoteModelRel
*/
    public String getRemoteModelRel()
    {
        return getSemanticObject().getProperty(cptm_remoteModelRel);
    }

/**
* Sets the RemoteModelRel property
* @param value long with the RemoteModelRel
*/
    public void setRemoteModelRel(String value)
    {
        getSemanticObject().setProperty(cptm_remoteModelRel, value);
    }
}
