package com.infotec.swb.base;


public abstract class PortalInfotecWebSiteBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.FilterableNode,org.semanticwb.model.FilterableClass,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Activeable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Trashable,org.semanticwb.model.Countryable
{
    public static final org.semanticwb.platform.SemanticClass infotec_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx#Event");
    public static final org.semanticwb.platform.SemanticClass infotec_PortalInfotecWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx#PortalInfotecWebSite");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx#PortalInfotecWebSite");

    public static class ClassMgr
    {
       /**
       * Returns a list of PortalInfotecWebSite for a model
       * @param model Model to find
       * @return Iterator of com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite>(it, true);
        }
       /**
       * Returns a list of com.infotec.swb.PortalInfotecWebSite for all models
       * @return Iterator of com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite>(it, true);
        }
       /**
       * Gets a com.infotec.swb.PortalInfotecWebSite
       * @param id Identifier for com.infotec.swb.PortalInfotecWebSite
       * @return A com.infotec.swb.PortalInfotecWebSite
       */
        public static com.infotec.swb.PortalInfotecWebSite getPortalInfotecWebSite(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            com.infotec.swb.PortalInfotecWebSite ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    ret=(com.infotec.swb.PortalInfotecWebSite)obj.createGenericInstance();
                }
            }
            return ret;
        }
       /**
       * Create a com.infotec.swb.PortalInfotecWebSite
       * @param id Identifier for com.infotec.swb.PortalInfotecWebSite
       * @return A com.infotec.swb.PortalInfotecWebSite
       */
        public static com.infotec.swb.PortalInfotecWebSite createPortalInfotecWebSite(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (com.infotec.swb.PortalInfotecWebSite)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.swb.PortalInfotecWebSite
       * @param id Identifier for com.infotec.swb.PortalInfotecWebSite
       */
        public static void removePortalInfotecWebSite(String id)
        {
            com.infotec.swb.PortalInfotecWebSite obj=getPortalInfotecWebSite(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a com.infotec.swb.PortalInfotecWebSite
       * @param id Identifier for com.infotec.swb.PortalInfotecWebSite
       * @return true if the com.infotec.swb.PortalInfotecWebSite exists, false otherwise
       */

        public static boolean hasPortalInfotecWebSite(String id)
        {
            return (getPortalInfotecWebSite(id)!=null);
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the com.infotec.swb.PortalInfotecWebSite
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.PortalInfotecWebSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the com.infotec.swb.PortalInfotecWebSite
       */

        public static java.util.Iterator<com.infotec.swb.PortalInfotecWebSite> listPortalInfotecWebSiteByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.PortalInfotecWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PortalInfotecWebSiteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PortalInfotecWebSite
   */
    public PortalInfotecWebSiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public com.infotec.swb.resources.eventcalendar.Event getEvent(String id)
    {
        return com.infotec.swb.resources.eventcalendar.Event.ClassMgr.getEvent(id, this);
    }

    public java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEvents()
    {
        return com.infotec.swb.resources.eventcalendar.Event.ClassMgr.listEvents(this);
    }

    public com.infotec.swb.resources.eventcalendar.Event createEvent(String id)
    {
        return com.infotec.swb.resources.eventcalendar.Event.ClassMgr.createEvent(id,this);
    }

    public com.infotec.swb.resources.eventcalendar.Event createEvent()
    {
        long id=getSemanticObject().getModel().getCounter(infotec_Event);
        return com.infotec.swb.resources.eventcalendar.Event.ClassMgr.createEvent(String.valueOf(id),this);
    } 

    public void removeEvent(String id)
    {
        com.infotec.swb.resources.eventcalendar.Event.ClassMgr.removeEvent(id, this);
    }
    public boolean hasEvent(String id)
    {
        return com.infotec.swb.resources.eventcalendar.Event.ClassMgr.hasEvent(id, this);
    }
}
