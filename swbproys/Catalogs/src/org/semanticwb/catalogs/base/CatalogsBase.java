package org.semanticwb.catalogs.base;


   /**
   * Objeto que define un Sitio Web de Catálogos 
   */
public abstract class CatalogsBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Countryable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Indexable,org.semanticwb.model.Activeable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.OntologyDepable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass cat_CP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#CP");
    public static final org.semanticwb.platform.SemanticClass cat_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#Municipio");
   /**
   * Define una Collección de objetos de una clase especificada con la propiedad "collectionClass"
   */
    public static final org.semanticwb.platform.SemanticClass swb_Collection=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Collection");
    public static final org.semanticwb.platform.SemanticClass cat_Estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#Estado");
   /**
   * Objeto que define un Sitio Web de Catálogos
   */
    public static final org.semanticwb.platform.SemanticClass cat_Catalogs=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#Catalogs");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#Catalogs");

    public static class ClassMgr
    {
       /**
       * Returns a list of Catalogs for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.catalogs.Catalogs for all models
       * @return Iterator of org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs>(it, true);
        }
       /**
       * Gets a org.semanticwb.catalogs.Catalogs
       * @param id Identifier for org.semanticwb.catalogs.Catalogs
       * @return A org.semanticwb.catalogs.Catalogs
       */
        public static org.semanticwb.catalogs.Catalogs getCatalogs(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.catalogs.Catalogs ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    ret=(org.semanticwb.catalogs.Catalogs)obj.createGenericInstance();
                }
            }
            return ret;
        }
       /**
       * Create a org.semanticwb.catalogs.Catalogs
       * @param id Identifier for org.semanticwb.catalogs.Catalogs
       * @return A org.semanticwb.catalogs.Catalogs
       */
        public static org.semanticwb.catalogs.Catalogs createCatalogs(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (org.semanticwb.catalogs.Catalogs)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.catalogs.Catalogs
       * @param id Identifier for org.semanticwb.catalogs.Catalogs
       */
        public static void removeCatalogs(String id)
        {
            org.semanticwb.catalogs.Catalogs obj=getCatalogs(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a org.semanticwb.catalogs.Catalogs
       * @param id Identifier for org.semanticwb.catalogs.Catalogs
       * @return true if the org.semanticwb.catalogs.Catalogs exists, false otherwise
       */

        public static boolean hasCatalogs(String id)
        {
            return (getCatalogs(id)!=null);
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the org.semanticwb.catalogs.Catalogs
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Catalogs with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the org.semanticwb.catalogs.Catalogs
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Catalogs> listCatalogsByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Catalogs> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CatalogsBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Catalogs
   */
    public CatalogsBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.catalogs.CP getCP(String id)
    {
        return org.semanticwb.catalogs.CP.ClassMgr.getCP(id, this);
    }

    public java.util.Iterator<org.semanticwb.catalogs.CP> listCPs()
    {
        return org.semanticwb.catalogs.CP.ClassMgr.listCPs(this);
    }

    public org.semanticwb.catalogs.CP createCP(String id)
    {
        return org.semanticwb.catalogs.CP.ClassMgr.createCP(id,this);
    }

    public org.semanticwb.catalogs.CP createCP()
    {
        long id=getSemanticObject().getModel().getCounter(cat_CP);
        return org.semanticwb.catalogs.CP.ClassMgr.createCP(String.valueOf(id),this);
    } 

    public void removeCP(String id)
    {
        org.semanticwb.catalogs.CP.ClassMgr.removeCP(id, this);
    }
    public boolean hasCP(String id)
    {
        return org.semanticwb.catalogs.CP.ClassMgr.hasCP(id, this);
    }

    public org.semanticwb.catalogs.Municipio getMunicipio(String id)
    {
        return org.semanticwb.catalogs.Municipio.ClassMgr.getMunicipio(id, this);
    }

    public java.util.Iterator<org.semanticwb.catalogs.Municipio> listMunicipios()
    {
        return org.semanticwb.catalogs.Municipio.ClassMgr.listMunicipios(this);
    }

    public org.semanticwb.catalogs.Municipio createMunicipio(String id)
    {
        return org.semanticwb.catalogs.Municipio.ClassMgr.createMunicipio(id,this);
    }

    public org.semanticwb.catalogs.Municipio createMunicipio()
    {
        long id=getSemanticObject().getModel().getCounter(cat_Municipio);
        return org.semanticwb.catalogs.Municipio.ClassMgr.createMunicipio(String.valueOf(id),this);
    } 

    public void removeMunicipio(String id)
    {
        org.semanticwb.catalogs.Municipio.ClassMgr.removeMunicipio(id, this);
    }
    public boolean hasMunicipio(String id)
    {
        return org.semanticwb.catalogs.Municipio.ClassMgr.hasMunicipio(id, this);
    }

    public org.semanticwb.model.Collection getCollection(String id)
    {
        return org.semanticwb.model.Collection.ClassMgr.getCollection(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Collection> listCollections()
    {
        return org.semanticwb.model.Collection.ClassMgr.listCollections(this);
    }

    public org.semanticwb.model.Collection createCollection(String id)
    {
        return org.semanticwb.model.Collection.ClassMgr.createCollection(id,this);
    }

    public org.semanticwb.model.Collection createCollection()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Collection);
        return org.semanticwb.model.Collection.ClassMgr.createCollection(String.valueOf(id),this);
    } 

    public void removeCollection(String id)
    {
        org.semanticwb.model.Collection.ClassMgr.removeCollection(id, this);
    }
    public boolean hasCollection(String id)
    {
        return org.semanticwb.model.Collection.ClassMgr.hasCollection(id, this);
    }

    public org.semanticwb.catalogs.Estado getEstado(String id)
    {
        return org.semanticwb.catalogs.Estado.ClassMgr.getEstado(id, this);
    }

    public java.util.Iterator<org.semanticwb.catalogs.Estado> listEstados()
    {
        return org.semanticwb.catalogs.Estado.ClassMgr.listEstados(this);
    }

    public org.semanticwb.catalogs.Estado createEstado(String id)
    {
        return org.semanticwb.catalogs.Estado.ClassMgr.createEstado(id,this);
    }

    public org.semanticwb.catalogs.Estado createEstado()
    {
        long id=getSemanticObject().getModel().getCounter(cat_Estado);
        return org.semanticwb.catalogs.Estado.ClassMgr.createEstado(String.valueOf(id),this);
    } 

    public void removeEstado(String id)
    {
        org.semanticwb.catalogs.Estado.ClassMgr.removeEstado(id, this);
    }
    public boolean hasEstado(String id)
    {
        return org.semanticwb.catalogs.Estado.ClassMgr.hasEstado(id, this);
    }
}
