package org.semanticwb.promexico.base;


   /**
   * Clase que hereda de swb:WebSite. Es un tipo de website para ProMéxico. De esta manera se puede contar con todos los elementos en el arbol de navegación en la administración, y otros elementos utiles para ProMéxico. 
   */
public abstract class ProMexicoBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Traceable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Countryable,org.semanticwb.model.FilterableClass,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.Localeable,org.semanticwb.model.Activeable
{
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
    public static final org.semanticwb.platform.SemanticClass promx_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#New");
    public static final org.semanticwb.platform.SemanticClass promx_Region=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Region");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxWebPage");
   /**
   * Eventos de ProMéxico
   */
    public static final org.semanticwb.platform.SemanticClass promx_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Event");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideo");
    public static final org.semanticwb.platform.SemanticClass promx_Mercado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Mercado");
   /**
   * Clase que hereda de swb:WebSite. Es un tipo de website para ProMéxico. De esta manera se puede contar con todos los elementos en el arbol de navegación en la administración, y otros elementos utiles para ProMéxico.
   */
    public static final org.semanticwb.platform.SemanticClass promx_ProMexico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMexico");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMexico");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProMexico for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.ProMexico for all models
       * @return Iterator of org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.ProMexico
       * @param id Identifier for org.semanticwb.promexico.ProMexico
       * @return A org.semanticwb.promexico.ProMexico
       */
        public static org.semanticwb.promexico.ProMexico getProMexico(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.promexico.ProMexico ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    ret=(org.semanticwb.promexico.ProMexico)obj.createGenericInstance();
                }
            }
            return ret;
        }
       /**
       * Create a org.semanticwb.promexico.ProMexico
       * @param id Identifier for org.semanticwb.promexico.ProMexico
       * @return A org.semanticwb.promexico.ProMexico
       */
        public static org.semanticwb.promexico.ProMexico createProMexico(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (org.semanticwb.promexico.ProMexico)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.ProMexico
       * @param id Identifier for org.semanticwb.promexico.ProMexico
       */
        public static void removeProMexico(String id)
        {
            org.semanticwb.promexico.ProMexico obj=getProMexico(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.ProMexico
       * @param id Identifier for org.semanticwb.promexico.ProMexico
       * @return true if the org.semanticwb.promexico.ProMexico exists, false otherwise
       */

        public static boolean hasProMexico(String id)
        {
            return (getProMexico(id)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the org.semanticwb.promexico.ProMexico
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMexico with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the org.semanticwb.promexico.ProMexico
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMexico> listProMexicoByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMexico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProMexicoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProMexico
   */
    public ProMexicoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.promexico.Sector getSector(String id)
    {
        return org.semanticwb.promexico.Sector.ClassMgr.getSector(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Sector> listSectors()
    {
        return org.semanticwb.promexico.Sector.ClassMgr.listSectors(this);
    }

    public org.semanticwb.promexico.Sector createSector(String id)
    {
        return org.semanticwb.promexico.Sector.ClassMgr.createSector(id,this);
    }

    public void removeSector(String id)
    {
        org.semanticwb.promexico.Sector.ClassMgr.removeSector(id, this);
    }
    public boolean hasSector(String id)
    {
        return org.semanticwb.promexico.Sector.ClassMgr.hasSector(id, this);
    }

    public org.semanticwb.promexico.New getNew(String id)
    {
        return org.semanticwb.promexico.New.ClassMgr.getNew(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.New> listNews()
    {
        return org.semanticwb.promexico.New.ClassMgr.listNews(this);
    }

    public org.semanticwb.promexico.New createNew(String id)
    {
        return org.semanticwb.promexico.New.ClassMgr.createNew(id,this);
    }

    public void removeNew(String id)
    {
        org.semanticwb.promexico.New.ClassMgr.removeNew(id, this);
    }
    public boolean hasNew(String id)
    {
        return org.semanticwb.promexico.New.ClassMgr.hasNew(id, this);
    }

    public org.semanticwb.promexico.Region getRegion(String id)
    {
        return org.semanticwb.promexico.Region.ClassMgr.getRegion(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Region> listRegions()
    {
        return org.semanticwb.promexico.Region.ClassMgr.listRegions(this);
    }

    public org.semanticwb.promexico.Region createRegion(String id)
    {
        return org.semanticwb.promexico.Region.ClassMgr.createRegion(id,this);
    }

    public void removeRegion(String id)
    {
        org.semanticwb.promexico.Region.ClassMgr.removeRegion(id, this);
    }
    public boolean hasRegion(String id)
    {
        return org.semanticwb.promexico.Region.ClassMgr.hasRegion(id, this);
    }

    public org.semanticwb.promexico.ProMxWebPage getProMxWebPage(String id)
    {
        return org.semanticwb.promexico.ProMxWebPage.ClassMgr.getProMxWebPage(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.ProMxWebPage> listProMxWebPages()
    {
        return org.semanticwb.promexico.ProMxWebPage.ClassMgr.listProMxWebPages(this);
    }

    public org.semanticwb.promexico.ProMxWebPage createProMxWebPage(String id)
    {
        return org.semanticwb.promexico.ProMxWebPage.ClassMgr.createProMxWebPage(id,this);
    }

    public void removeProMxWebPage(String id)
    {
        org.semanticwb.promexico.ProMxWebPage.ClassMgr.removeProMxWebPage(id, this);
    }
    public boolean hasProMxWebPage(String id)
    {
        return org.semanticwb.promexico.ProMxWebPage.ClassMgr.hasProMxWebPage(id, this);
    }

    public org.semanticwb.promexico.Event getEvent(String id)
    {
        return org.semanticwb.promexico.Event.ClassMgr.getEvent(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Event> listEvents()
    {
        return org.semanticwb.promexico.Event.ClassMgr.listEvents(this);
    }

    public org.semanticwb.promexico.Event createEvent(String id)
    {
        return org.semanticwb.promexico.Event.ClassMgr.createEvent(id,this);
    }

    public org.semanticwb.promexico.Event createEvent()
    {
        long id=getSemanticObject().getModel().getCounter(promx_Event);
        return org.semanticwb.promexico.Event.ClassMgr.createEvent(String.valueOf(id),this);
    } 

    public void removeEvent(String id)
    {
        org.semanticwb.promexico.Event.ClassMgr.removeEvent(id, this);
    }
    public boolean hasEvent(String id)
    {
        return org.semanticwb.promexico.Event.ClassMgr.hasEvent(id, this);
    }

    public org.semanticwb.promexico.ProMxVideo getProMxVideo(String id)
    {
        return org.semanticwb.promexico.ProMxVideo.ClassMgr.getProMxVideo(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideos()
    {
        return org.semanticwb.promexico.ProMxVideo.ClassMgr.listProMxVideos(this);
    }

    public org.semanticwb.promexico.ProMxVideo createProMxVideo(String id)
    {
        return org.semanticwb.promexico.ProMxVideo.ClassMgr.createProMxVideo(id,this);
    }

    public void removeProMxVideo(String id)
    {
        org.semanticwb.promexico.ProMxVideo.ClassMgr.removeProMxVideo(id, this);
    }
    public boolean hasProMxVideo(String id)
    {
        return org.semanticwb.promexico.ProMxVideo.ClassMgr.hasProMxVideo(id, this);
    }

    public org.semanticwb.promexico.Mercado getMercado(String id)
    {
        return org.semanticwb.promexico.Mercado.ClassMgr.getMercado(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Mercado> listMercados()
    {
        return org.semanticwb.promexico.Mercado.ClassMgr.listMercados(this);
    }

    public org.semanticwb.promexico.Mercado createMercado(String id)
    {
        return org.semanticwb.promexico.Mercado.ClassMgr.createMercado(id,this);
    }

    public void removeMercado(String id)
    {
        org.semanticwb.promexico.Mercado.ClassMgr.removeMercado(id, this);
    }
    public boolean hasMercado(String id)
    {
        return org.semanticwb.promexico.Mercado.ClassMgr.hasMercado(id, this);
    }
}
