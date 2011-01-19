package org.semanticwb.ecosikan.innova.base;


   /**
   * Sitio EcoSikan 
   */
public abstract class BorraSiteBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Localeable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Trashable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Undeleteable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable
{
    public static final org.semanticwb.platform.SemanticClass ecoskn_Challenge=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Challenge");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Theme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Theme");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Dependencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Dependencia");
   /**
   * Sitio EcoSikan
   */
    public static final org.semanticwb.platform.SemanticClass ecoskn_BorraSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#BorraSite");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#BorraSite");

    public static class ClassMgr
    {
       /**
       * Returns a list of BorraSite for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.BorraSite for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite>(it, true);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.BorraSite
       * @param id Identifier for org.semanticwb.ecosikan.innova.BorraSite
       * @return A org.semanticwb.ecosikan.innova.BorraSite
       */
        public static org.semanticwb.ecosikan.innova.BorraSite getBorraSite(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.ecosikan.innova.BorraSite ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    ret=(org.semanticwb.ecosikan.innova.BorraSite)obj.createGenericInstance();
                }
            }
            return ret;
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.BorraSite
       * @param id Identifier for org.semanticwb.ecosikan.innova.BorraSite
       * @return A org.semanticwb.ecosikan.innova.BorraSite
       */
        public static org.semanticwb.ecosikan.innova.BorraSite createBorraSite(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (org.semanticwb.ecosikan.innova.BorraSite)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.BorraSite
       * @param id Identifier for org.semanticwb.ecosikan.innova.BorraSite
       */
        public static void removeBorraSite(String id)
        {
            org.semanticwb.ecosikan.innova.BorraSite obj=getBorraSite(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.BorraSite
       * @param id Identifier for org.semanticwb.ecosikan.innova.BorraSite
       * @return true if the org.semanticwb.ecosikan.innova.BorraSite exists, false otherwise
       */

        public static boolean hasBorraSite(String id)
        {
            return (getBorraSite(id)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the org.semanticwb.ecosikan.innova.BorraSite
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.BorraSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the org.semanticwb.ecosikan.innova.BorraSite
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.BorraSite> listBorraSiteByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.BorraSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a BorraSiteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BorraSite
   */
    public BorraSiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.ecosikan.innova.Challenge getChallenge(String id)
    {
        return org.semanticwb.ecosikan.innova.Challenge.ClassMgr.getChallenge(id, this);
    }

    public java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallenges()
    {
        return org.semanticwb.ecosikan.innova.Challenge.ClassMgr.listChallenges(this);
    }

    public org.semanticwb.ecosikan.innova.Challenge createChallenge(String id)
    {
        return org.semanticwb.ecosikan.innova.Challenge.ClassMgr.createChallenge(id,this);
    }

    public org.semanticwb.ecosikan.innova.Challenge createChallenge()
    {
        long id=getSemanticObject().getModel().getCounter(ecoskn_Challenge);
        return org.semanticwb.ecosikan.innova.Challenge.ClassMgr.createChallenge(String.valueOf(id),this);
    } 

    public void removeChallenge(String id)
    {
        org.semanticwb.ecosikan.innova.Challenge.ClassMgr.removeChallenge(id, this);
    }
    public boolean hasChallenge(String id)
    {
        return org.semanticwb.ecosikan.innova.Challenge.ClassMgr.hasChallenge(id, this);
    }

    public org.semanticwb.ecosikan.innova.Theme getTheme(String id)
    {
        return org.semanticwb.ecosikan.innova.Theme.ClassMgr.getTheme(id, this);
    }

    public java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemes()
    {
        return org.semanticwb.ecosikan.innova.Theme.ClassMgr.listThemes(this);
    }

    public org.semanticwb.ecosikan.innova.Theme createTheme(String id)
    {
        return org.semanticwb.ecosikan.innova.Theme.ClassMgr.createTheme(id,this);
    }

    public org.semanticwb.ecosikan.innova.Theme createTheme()
    {
        long id=getSemanticObject().getModel().getCounter(ecoskn_Theme);
        return org.semanticwb.ecosikan.innova.Theme.ClassMgr.createTheme(String.valueOf(id),this);
    } 

    public void removeTheme(String id)
    {
        org.semanticwb.ecosikan.innova.Theme.ClassMgr.removeTheme(id, this);
    }
    public boolean hasTheme(String id)
    {
        return org.semanticwb.ecosikan.innova.Theme.ClassMgr.hasTheme(id, this);
    }

    public org.semanticwb.ecosikan.innova.Dependencia getDependencia(String id)
    {
        return org.semanticwb.ecosikan.innova.Dependencia.ClassMgr.getDependencia(id, this);
    }

    public java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependencias()
    {
        return org.semanticwb.ecosikan.innova.Dependencia.ClassMgr.listDependencias(this);
    }

    public org.semanticwb.ecosikan.innova.Dependencia createDependencia(String id)
    {
        return org.semanticwb.ecosikan.innova.Dependencia.ClassMgr.createDependencia(id,this);
    }

    public org.semanticwb.ecosikan.innova.Dependencia createDependencia()
    {
        long id=getSemanticObject().getModel().getCounter(ecoskn_Dependencia);
        return org.semanticwb.ecosikan.innova.Dependencia.ClassMgr.createDependencia(String.valueOf(id),this);
    } 

    public void removeDependencia(String id)
    {
        org.semanticwb.ecosikan.innova.Dependencia.ClassMgr.removeDependencia(id, this);
    }
    public boolean hasDependencia(String id)
    {
        return org.semanticwb.ecosikan.innova.Dependencia.ClassMgr.hasDependencia(id, this);
    }
}
