package mx.gob.stps.portalempleo.swb.base;


   /**
   * Portal del Empleo de la STPS 
   */
public abstract class EmpleoWebSiteBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Localeable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Trashable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Countryable
{
    public static final org.semanticwb.platform.SemanticClass portalempleo_Year=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Year");
    public static final org.semanticwb.platform.SemanticClass portalempleo_Month=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Month");
   /**
   * Portal del Empleo de la STPS
   */
    public static final org.semanticwb.platform.SemanticClass portalempleo_EmpleoWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#EmpleoWebSite");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#EmpleoWebSite");

    public static class ClassMgr
    {
       /**
       * Returns a list of EmpleoWebSite for a model
       * @param model Model to find
       * @return Iterator of mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite>(it, true);
        }
       /**
       * Returns a list of mx.gob.stps.portalempleo.swb.EmpleoWebSite for all models
       * @return Iterator of mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite>(it, true);
        }
       /**
       * Gets a mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @param id Identifier for mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return A mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */
        public static mx.gob.stps.portalempleo.swb.EmpleoWebSite getEmpleoWebSite(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            mx.gob.stps.portalempleo.swb.EmpleoWebSite ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    ret=(mx.gob.stps.portalempleo.swb.EmpleoWebSite)obj.createGenericInstance();
                }
            }
            return ret;
        }
       /**
       * Create a mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @param id Identifier for mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return A mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */
        public static mx.gob.stps.portalempleo.swb.EmpleoWebSite createEmpleoWebSite(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (mx.gob.stps.portalempleo.swb.EmpleoWebSite)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @param id Identifier for mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */
        public static void removeEmpleoWebSite(String id)
        {
            mx.gob.stps.portalempleo.swb.EmpleoWebSite obj=getEmpleoWebSite(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @param id Identifier for mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return true if the mx.gob.stps.portalempleo.swb.EmpleoWebSite exists, false otherwise
       */

        public static boolean hasEmpleoWebSite(String id)
        {
            return (getEmpleoWebSite(id)!=null);
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.EmpleoWebSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.EmpleoWebSite
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> listEmpleoWebSiteByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.EmpleoWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EmpleoWebSiteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EmpleoWebSite
   */
    public EmpleoWebSiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public mx.gob.stps.portalempleo.swb.Year getYear(String id)
    {
        return mx.gob.stps.portalempleo.swb.Year.ClassMgr.getYear(id, this);
    }

    public java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYears()
    {
        return mx.gob.stps.portalempleo.swb.Year.ClassMgr.listYears(this);
    }

    public mx.gob.stps.portalempleo.swb.Year createYear(String id)
    {
        return mx.gob.stps.portalempleo.swb.Year.ClassMgr.createYear(id,this);
    }

    public void removeYear(String id)
    {
        mx.gob.stps.portalempleo.swb.Year.ClassMgr.removeYear(id, this);
    }
    public boolean hasYear(String id)
    {
        return mx.gob.stps.portalempleo.swb.Year.ClassMgr.hasYear(id, this);
    }

    public mx.gob.stps.portalempleo.swb.Month getMonth(String id)
    {
        return mx.gob.stps.portalempleo.swb.Month.ClassMgr.getMonth(id, this);
    }

    public java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonths()
    {
        return mx.gob.stps.portalempleo.swb.Month.ClassMgr.listMonths(this);
    }

    public mx.gob.stps.portalempleo.swb.Month createMonth(String id)
    {
        return mx.gob.stps.portalempleo.swb.Month.ClassMgr.createMonth(id,this);
    }

    public void removeMonth(String id)
    {
        mx.gob.stps.portalempleo.swb.Month.ClassMgr.removeMonth(id, this);
    }
    public boolean hasMonth(String id)
    {
        return mx.gob.stps.portalempleo.swb.Month.ClassMgr.hasMonth(id, this);
    }
}
