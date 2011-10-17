package com.infotec.eworkplace.swb.base;


public abstract class InfotecIntranetBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Undeleteable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Indexable,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Localeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Countryable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Trashable
{
    public static final org.semanticwb.platform.SemanticClass ewp_Gerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Gerencia");
    public static final org.semanticwb.platform.SemanticClass ewp_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Proyecto");
    public static final org.semanticwb.platform.SemanticClass ewp_Conocimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Conocimiento");
    public static final org.semanticwb.platform.SemanticClass ewp_Domicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Domicilio");
    public static final org.semanticwb.platform.SemanticClass ewp_SubGerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#SubGerencia");
    public static final org.semanticwb.platform.SemanticClass ewp_Habilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Habilidad");
    public static final org.semanticwb.platform.SemanticClass ewp_TemaInteres=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#TemaInteres");
    public static final org.semanticwb.platform.SemanticClass ewp_InfotecIntranet=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#InfotecIntranet");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#InfotecIntranet");

    public static class ClassMgr
    {
       /**
       * Returns a list of InfotecIntranet for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranets(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.InfotecIntranet for all models
       * @return Iterator of com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranets()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.InfotecIntranet
       * @param id Identifier for com.infotec.eworkplace.swb.InfotecIntranet
       * @return A com.infotec.eworkplace.swb.InfotecIntranet
       */
        public static com.infotec.eworkplace.swb.InfotecIntranet getInfotecIntranet(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            com.infotec.eworkplace.swb.InfotecIntranet ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    ret=(com.infotec.eworkplace.swb.InfotecIntranet)obj.createGenericInstance();
                }
            }
            return ret;
        }
       /**
       * Create a com.infotec.eworkplace.swb.InfotecIntranet
       * @param id Identifier for com.infotec.eworkplace.swb.InfotecIntranet
       * @return A com.infotec.eworkplace.swb.InfotecIntranet
       */
        public static com.infotec.eworkplace.swb.InfotecIntranet createInfotecIntranet(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (com.infotec.eworkplace.swb.InfotecIntranet)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.InfotecIntranet
       * @param id Identifier for com.infotec.eworkplace.swb.InfotecIntranet
       */
        public static void removeInfotecIntranet(String id)
        {
            com.infotec.eworkplace.swb.InfotecIntranet obj=getInfotecIntranet(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.InfotecIntranet
       * @param id Identifier for com.infotec.eworkplace.swb.InfotecIntranet
       * @return true if the com.infotec.eworkplace.swb.InfotecIntranet exists, false otherwise
       */

        public static boolean hasInfotecIntranet(String id)
        {
            return (getInfotecIntranet(id)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the com.infotec.eworkplace.swb.InfotecIntranet
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.InfotecIntranet with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the com.infotec.eworkplace.swb.InfotecIntranet
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InfotecIntranet> listInfotecIntranetByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InfotecIntranet> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a InfotecIntranetBase with a SemanticObject
   * @param base The SemanticObject with the properties for the InfotecIntranet
   */
    public InfotecIntranetBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public com.infotec.eworkplace.swb.Gerencia getGerencia(String id)
    {
        return com.infotec.eworkplace.swb.Gerencia.ClassMgr.getGerencia(id, this);
    }

    public java.util.Iterator<com.infotec.eworkplace.swb.Gerencia> listGerencias()
    {
        return com.infotec.eworkplace.swb.Gerencia.ClassMgr.listGerencias(this);
    }

    public com.infotec.eworkplace.swb.Gerencia createGerencia(String id)
    {
        return com.infotec.eworkplace.swb.Gerencia.ClassMgr.createGerencia(id,this);
    }

    public com.infotec.eworkplace.swb.Gerencia createGerencia()
    {
        long id=getSemanticObject().getModel().getCounter(ewp_Gerencia);
        return com.infotec.eworkplace.swb.Gerencia.ClassMgr.createGerencia(String.valueOf(id),this);
    } 

    public void removeGerencia(String id)
    {
        com.infotec.eworkplace.swb.Gerencia.ClassMgr.removeGerencia(id, this);
    }
    public boolean hasGerencia(String id)
    {
        return com.infotec.eworkplace.swb.Gerencia.ClassMgr.hasGerencia(id, this);
    }

    public com.infotec.eworkplace.swb.Proyecto getProyecto(String id)
    {
        return com.infotec.eworkplace.swb.Proyecto.ClassMgr.getProyecto(id, this);
    }

    public java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectos()
    {
        return com.infotec.eworkplace.swb.Proyecto.ClassMgr.listProyectos(this);
    }

    public com.infotec.eworkplace.swb.Proyecto createProyecto(String id)
    {
        return com.infotec.eworkplace.swb.Proyecto.ClassMgr.createProyecto(id,this);
    }

    public com.infotec.eworkplace.swb.Proyecto createProyecto()
    {
        long id=getSemanticObject().getModel().getCounter(ewp_Proyecto);
        return com.infotec.eworkplace.swb.Proyecto.ClassMgr.createProyecto(String.valueOf(id),this);
    } 

    public void removeProyecto(String id)
    {
        com.infotec.eworkplace.swb.Proyecto.ClassMgr.removeProyecto(id, this);
    }
    public boolean hasProyecto(String id)
    {
        return com.infotec.eworkplace.swb.Proyecto.ClassMgr.hasProyecto(id, this);
    }

    public com.infotec.eworkplace.swb.Conocimiento getConocimiento(String id)
    {
        return com.infotec.eworkplace.swb.Conocimiento.ClassMgr.getConocimiento(id, this);
    }

    public java.util.Iterator<com.infotec.eworkplace.swb.Conocimiento> listConocimientos()
    {
        return com.infotec.eworkplace.swb.Conocimiento.ClassMgr.listConocimientos(this);
    }

    public com.infotec.eworkplace.swb.Conocimiento createConocimiento(String id)
    {
        return com.infotec.eworkplace.swb.Conocimiento.ClassMgr.createConocimiento(id,this);
    }

    public com.infotec.eworkplace.swb.Conocimiento createConocimiento()
    {
        long id=getSemanticObject().getModel().getCounter(ewp_Conocimiento);
        return com.infotec.eworkplace.swb.Conocimiento.ClassMgr.createConocimiento(String.valueOf(id),this);
    } 

    public void removeConocimiento(String id)
    {
        com.infotec.eworkplace.swb.Conocimiento.ClassMgr.removeConocimiento(id, this);
    }
    public boolean hasConocimiento(String id)
    {
        return com.infotec.eworkplace.swb.Conocimiento.ClassMgr.hasConocimiento(id, this);
    }

    public com.infotec.eworkplace.swb.Domicilio getDomicilio(String id)
    {
        return com.infotec.eworkplace.swb.Domicilio.ClassMgr.getDomicilio(id, this);
    }

    public java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilios()
    {
        return com.infotec.eworkplace.swb.Domicilio.ClassMgr.listDomicilios(this);
    }

    public com.infotec.eworkplace.swb.Domicilio createDomicilio(String id)
    {
        return com.infotec.eworkplace.swb.Domicilio.ClassMgr.createDomicilio(id,this);
    }

    public com.infotec.eworkplace.swb.Domicilio createDomicilio()
    {
        long id=getSemanticObject().getModel().getCounter(ewp_Domicilio);
        return com.infotec.eworkplace.swb.Domicilio.ClassMgr.createDomicilio(String.valueOf(id),this);
    } 

    public void removeDomicilio(String id)
    {
        com.infotec.eworkplace.swb.Domicilio.ClassMgr.removeDomicilio(id, this);
    }
    public boolean hasDomicilio(String id)
    {
        return com.infotec.eworkplace.swb.Domicilio.ClassMgr.hasDomicilio(id, this);
    }

    public com.infotec.eworkplace.swb.SubGerencia getSubGerencia(String id)
    {
        return com.infotec.eworkplace.swb.SubGerencia.ClassMgr.getSubGerencia(id, this);
    }

    public java.util.Iterator<com.infotec.eworkplace.swb.SubGerencia> listSubGerencias()
    {
        return com.infotec.eworkplace.swb.SubGerencia.ClassMgr.listSubGerencias(this);
    }

    public com.infotec.eworkplace.swb.SubGerencia createSubGerencia(String id)
    {
        return com.infotec.eworkplace.swb.SubGerencia.ClassMgr.createSubGerencia(id,this);
    }

    public com.infotec.eworkplace.swb.SubGerencia createSubGerencia()
    {
        long id=getSemanticObject().getModel().getCounter(ewp_SubGerencia);
        return com.infotec.eworkplace.swb.SubGerencia.ClassMgr.createSubGerencia(String.valueOf(id),this);
    } 

    public void removeSubGerencia(String id)
    {
        com.infotec.eworkplace.swb.SubGerencia.ClassMgr.removeSubGerencia(id, this);
    }
    public boolean hasSubGerencia(String id)
    {
        return com.infotec.eworkplace.swb.SubGerencia.ClassMgr.hasSubGerencia(id, this);
    }

    public com.infotec.eworkplace.swb.Habilidad getHabilidad(String id)
    {
        return com.infotec.eworkplace.swb.Habilidad.ClassMgr.getHabilidad(id, this);
    }

    public java.util.Iterator<com.infotec.eworkplace.swb.Habilidad> listHabilidads()
    {
        return com.infotec.eworkplace.swb.Habilidad.ClassMgr.listHabilidads(this);
    }

    public com.infotec.eworkplace.swb.Habilidad createHabilidad(String id)
    {
        return com.infotec.eworkplace.swb.Habilidad.ClassMgr.createHabilidad(id,this);
    }

    public com.infotec.eworkplace.swb.Habilidad createHabilidad()
    {
        long id=getSemanticObject().getModel().getCounter(ewp_Habilidad);
        return com.infotec.eworkplace.swb.Habilidad.ClassMgr.createHabilidad(String.valueOf(id),this);
    } 

    public void removeHabilidad(String id)
    {
        com.infotec.eworkplace.swb.Habilidad.ClassMgr.removeHabilidad(id, this);
    }
    public boolean hasHabilidad(String id)
    {
        return com.infotec.eworkplace.swb.Habilidad.ClassMgr.hasHabilidad(id, this);
    }

    public com.infotec.eworkplace.swb.TemaInteres getTemaInteres(String id)
    {
        return com.infotec.eworkplace.swb.TemaInteres.ClassMgr.getTemaInteres(id, this);
    }

    public java.util.Iterator<com.infotec.eworkplace.swb.TemaInteres> listTemaIntereses()
    {
        return com.infotec.eworkplace.swb.TemaInteres.ClassMgr.listTemaIntereses(this);
    }

    public com.infotec.eworkplace.swb.TemaInteres createTemaInteres(String id)
    {
        return com.infotec.eworkplace.swb.TemaInteres.ClassMgr.createTemaInteres(id,this);
    }

    public com.infotec.eworkplace.swb.TemaInteres createTemaInteres()
    {
        long id=getSemanticObject().getModel().getCounter(ewp_TemaInteres);
        return com.infotec.eworkplace.swb.TemaInteres.ClassMgr.createTemaInteres(String.valueOf(id),this);
    } 

    public void removeTemaInteres(String id)
    {
        com.infotec.eworkplace.swb.TemaInteres.ClassMgr.removeTemaInteres(id, this);
    }
    public boolean hasTemaInteres(String id)
    {
        return com.infotec.eworkplace.swb.TemaInteres.ClassMgr.hasTemaInteres(id, this);
    }
}
