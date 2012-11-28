package com.infotec.conorg.base;


public abstract class PlaceBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Filterable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Localeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Countryable,org.semanticwb.model.Indexable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Trashable
{
    public static final org.semanticwb.platform.SemanticClass conorg_WorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasWorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasWorkSpace");
    public static final org.semanticwb.platform.SemanticClass conorg_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Topic");
    public static final org.semanticwb.platform.SemanticClass conorg_Place=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Place");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Place");

    public static class ClassMgr
    {
       /**
       * Returns a list of Place for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaces(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Place>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Place for all models
       * @return Iterator of com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaces()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Place>(it, true);
        }
       /**
       * Gets a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       * @return A com.infotec.conorg.Place
       */
        public static com.infotec.conorg.Place getPlace(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            com.infotec.conorg.Place ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    org.semanticwb.model.GenericObject gobj=obj.createGenericInstance();
                    if(gobj instanceof com.infotec.conorg.Place)
                    {
                        ret=(com.infotec.conorg.Place)gobj;
                    }
                }
            }
            return ret;
        }
       /**
       * Create a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       * @return A com.infotec.conorg.Place
       */
        public static com.infotec.conorg.Place createPlace(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (com.infotec.conorg.Place)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       */
        public static void removePlace(String id)
        {
            com.infotec.conorg.Place obj=getPlace(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       * @return true if the com.infotec.conorg.Place exists, false otherwise
       */

        public static boolean hasPlace(String id)
        {
            return (getPlace(id)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined WorkSpace
       * @param value WorkSpace of the type com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByWorkSpace(com.infotec.conorg.WorkSpace value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasWorkSpace, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined WorkSpace
       * @param value WorkSpace of the type com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByWorkSpace(com.infotec.conorg.WorkSpace value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasWorkSpace,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PlaceBase.ClassMgr getPlaceClassMgr()
    {
        return new PlaceBase.ClassMgr();
    }

   /**
   * Constructs a PlaceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Place
   */
    public PlaceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.conorg.WorkSpace
   * @return A GenericIterator with all the com.infotec.conorg.WorkSpace
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> listWorkSpaces()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace>(getSemanticObject().listObjectProperties(conorg_hasWorkSpace));
    }

   /**
   * Gets true if has a WorkSpace
   * @param value com.infotec.conorg.WorkSpace to verify
   * @return true if the com.infotec.conorg.WorkSpace exists, false otherwise
   */
    public boolean hasWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasWorkSpace,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a WorkSpace
   * @param value com.infotec.conorg.WorkSpace to add
   */

    public void addWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        getSemanticObject().addObjectProperty(conorg_hasWorkSpace, value.getSemanticObject());
    }
   /**
   * Removes all the WorkSpace
   */

    public void removeAllWorkSpace()
    {
        getSemanticObject().removeProperty(conorg_hasWorkSpace);
    }
   /**
   * Removes a WorkSpace
   * @param value com.infotec.conorg.WorkSpace to remove
   */

    public void removeWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasWorkSpace,value.getSemanticObject());
    }

   /**
   * Gets the WorkSpace
   * @return a com.infotec.conorg.WorkSpace
   */
    public com.infotec.conorg.WorkSpace getWorkSpace()
    {
         com.infotec.conorg.WorkSpace ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasWorkSpace);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.WorkSpace)obj.createGenericInstance();
         }
         return ret;
    }

    public com.infotec.conorg.Topic getTopic(String id)
    {
        return com.infotec.conorg.Topic.ClassMgr.getTopic(id, this);
    }

    public java.util.Iterator<com.infotec.conorg.Topic> listTopics()
    {
        return com.infotec.conorg.Topic.ClassMgr.listTopics(this);
    }

    public com.infotec.conorg.Topic createTopic(String id)
    {
        return com.infotec.conorg.Topic.ClassMgr.createTopic(id,this);
    }

    public com.infotec.conorg.Topic createTopic()
    {
        long id=getSemanticObject().getModel().getCounter(conorg_Topic);
        return com.infotec.conorg.Topic.ClassMgr.createTopic(String.valueOf(id),this);
    } 

    public void removeTopic(String id)
    {
        com.infotec.conorg.Topic.ClassMgr.removeTopic(id, this);
    }
    public boolean hasTopic(String id)
    {
        return com.infotec.conorg.Topic.ClassMgr.hasTopic(id, this);
    }
}
