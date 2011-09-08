package org.semanticwb.promexico.base;


   /**
   * Clase que hereda de swb:WebSite. Es un tipo de website para ProMéxico. De esta manera se puede contar con todos los elementos en el arbol de navegación en la administración, y otros elementos utiles para ProMéxico. 
   */
public abstract class ProMexicoBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.FilterableNode,org.semanticwb.model.Traceable,org.semanticwb.model.Trashable,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Filterable,org.semanticwb.model.Localeable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Countryable,org.semanticwb.model.Descriptiveable
{
   /**
   * Tipos de Regiones (Nacionales, Internacionales, etc)
   */
    public static final org.semanticwb.platform.SemanticClass promx_RegionType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#RegionType");
   /**
   * Temas de Preguntas Frecuentes
   */
    public static final org.semanticwb.platform.SemanticClass promx_FaqTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#FaqTopic");
   /**
   * Objeto controlador de oficinas
   */
    public static final org.semanticwb.platform.SemanticClass promx_Office=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Office");
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
    public static final org.semanticwb.platform.SemanticClass promx_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#New");
    public static final org.semanticwb.platform.SemanticClass promx_Region=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Region");
    public static final org.semanticwb.platform.SemanticClass promx_Magazine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Magazine");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxWebPage");
   /**
   * Tipos de Noticias
   */
    public static final org.semanticwb.platform.SemanticClass promx_NewType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#NewType");
   /**
   * Subtipos de Eventos, despues cambiar la manera de presentar en la administración por combos anidados, es decir, de acuerdo al tipo (Nacional o Internacional), presentar los subtipos.
   */
    public static final org.semanticwb.platform.SemanticClass promx_EventSubType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#EventSubType");
   /**
   * Canales del sitio (Empresa Mexicana, Empresa Extranjera, etc)
   */
    public static final org.semanticwb.platform.SemanticClass promx_Canal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Canal");
   /**
   * Preguntas Frecuentes
   */
    public static final org.semanticwb.platform.SemanticClass promx_Faq=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Faq");
   /**
   * Eventos de ProMéxico
   */
    public static final org.semanticwb.platform.SemanticClass promx_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Event");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideo");
   /**
   * Servicios
   */
    public static final org.semanticwb.platform.SemanticClass promx_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Service");
   /**
   * Catalogo de Mercados
   */
    public static final org.semanticwb.platform.SemanticClass promx_Market=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Market");
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

    public org.semanticwb.promexico.RegionType getRegionType(String id)
    {
        return org.semanticwb.promexico.RegionType.ClassMgr.getRegionType(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.RegionType> listRegionTypes()
    {
        return org.semanticwb.promexico.RegionType.ClassMgr.listRegionTypes(this);
    }

    public org.semanticwb.promexico.RegionType createRegionType(String id)
    {
        return org.semanticwb.promexico.RegionType.ClassMgr.createRegionType(id,this);
    }

    public void removeRegionType(String id)
    {
        org.semanticwb.promexico.RegionType.ClassMgr.removeRegionType(id, this);
    }
    public boolean hasRegionType(String id)
    {
        return org.semanticwb.promexico.RegionType.ClassMgr.hasRegionType(id, this);
    }

    public org.semanticwb.promexico.FaqTopic getFaqTopic(String id)
    {
        return org.semanticwb.promexico.FaqTopic.ClassMgr.getFaqTopic(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.FaqTopic> listFaqTopics()
    {
        return org.semanticwb.promexico.FaqTopic.ClassMgr.listFaqTopics(this);
    }

    public org.semanticwb.promexico.FaqTopic createFaqTopic(String id)
    {
        return org.semanticwb.promexico.FaqTopic.ClassMgr.createFaqTopic(id,this);
    }

    public org.semanticwb.promexico.FaqTopic createFaqTopic()
    {
        long id=getSemanticObject().getModel().getCounter(promx_FaqTopic);
        return org.semanticwb.promexico.FaqTopic.ClassMgr.createFaqTopic(String.valueOf(id),this);
    } 

    public void removeFaqTopic(String id)
    {
        org.semanticwb.promexico.FaqTopic.ClassMgr.removeFaqTopic(id, this);
    }
    public boolean hasFaqTopic(String id)
    {
        return org.semanticwb.promexico.FaqTopic.ClassMgr.hasFaqTopic(id, this);
    }

    public org.semanticwb.promexico.Office getOffice(String id)
    {
        return org.semanticwb.promexico.Office.ClassMgr.getOffice(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Office> listOffices()
    {
        return org.semanticwb.promexico.Office.ClassMgr.listOffices(this);
    }

    public org.semanticwb.promexico.Office createOffice(String id)
    {
        return org.semanticwb.promexico.Office.ClassMgr.createOffice(id,this);
    }

    public void removeOffice(String id)
    {
        org.semanticwb.promexico.Office.ClassMgr.removeOffice(id, this);
    }
    public boolean hasOffice(String id)
    {
        return org.semanticwb.promexico.Office.ClassMgr.hasOffice(id, this);
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

    public org.semanticwb.promexico.New createNew()
    {
        long id=getSemanticObject().getModel().getCounter(promx_New);
        return org.semanticwb.promexico.New.ClassMgr.createNew(String.valueOf(id),this);
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

    public org.semanticwb.promexico.Magazine getMagazine(String id)
    {
        return org.semanticwb.promexico.Magazine.ClassMgr.getMagazine(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Magazine> listMagazines()
    {
        return org.semanticwb.promexico.Magazine.ClassMgr.listMagazines(this);
    }

    public org.semanticwb.promexico.Magazine createMagazine(String id)
    {
        return org.semanticwb.promexico.Magazine.ClassMgr.createMagazine(id,this);
    }

    public org.semanticwb.promexico.Magazine createMagazine()
    {
        long id=getSemanticObject().getModel().getCounter(promx_Magazine);
        return org.semanticwb.promexico.Magazine.ClassMgr.createMagazine(String.valueOf(id),this);
    } 

    public void removeMagazine(String id)
    {
        org.semanticwb.promexico.Magazine.ClassMgr.removeMagazine(id, this);
    }
    public boolean hasMagazine(String id)
    {
        return org.semanticwb.promexico.Magazine.ClassMgr.hasMagazine(id, this);
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

    public org.semanticwb.promexico.NewType getNewType(String id)
    {
        return org.semanticwb.promexico.NewType.ClassMgr.getNewType(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypes()
    {
        return org.semanticwb.promexico.NewType.ClassMgr.listNewTypes(this);
    }

    public org.semanticwb.promexico.NewType createNewType(String id)
    {
        return org.semanticwb.promexico.NewType.ClassMgr.createNewType(id,this);
    }

    public org.semanticwb.promexico.NewType createNewType()
    {
        long id=getSemanticObject().getModel().getCounter(promx_NewType);
        return org.semanticwb.promexico.NewType.ClassMgr.createNewType(String.valueOf(id),this);
    } 

    public void removeNewType(String id)
    {
        org.semanticwb.promexico.NewType.ClassMgr.removeNewType(id, this);
    }
    public boolean hasNewType(String id)
    {
        return org.semanticwb.promexico.NewType.ClassMgr.hasNewType(id, this);
    }

    public org.semanticwb.promexico.EventSubType getEventSubType(String id)
    {
        return org.semanticwb.promexico.EventSubType.ClassMgr.getEventSubType(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.EventSubType> listEventSubTypes()
    {
        return org.semanticwb.promexico.EventSubType.ClassMgr.listEventSubTypes(this);
    }

    public org.semanticwb.promexico.EventSubType createEventSubType(String id)
    {
        return org.semanticwb.promexico.EventSubType.ClassMgr.createEventSubType(id,this);
    }

    public org.semanticwb.promexico.EventSubType createEventSubType()
    {
        long id=getSemanticObject().getModel().getCounter(promx_EventSubType);
        return org.semanticwb.promexico.EventSubType.ClassMgr.createEventSubType(String.valueOf(id),this);
    } 

    public void removeEventSubType(String id)
    {
        org.semanticwb.promexico.EventSubType.ClassMgr.removeEventSubType(id, this);
    }
    public boolean hasEventSubType(String id)
    {
        return org.semanticwb.promexico.EventSubType.ClassMgr.hasEventSubType(id, this);
    }

    public org.semanticwb.promexico.Canal getCanal(String id)
    {
        return org.semanticwb.promexico.Canal.ClassMgr.getCanal(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Canal> listCanals()
    {
        return org.semanticwb.promexico.Canal.ClassMgr.listCanals(this);
    }

    public org.semanticwb.promexico.Canal createCanal(String id)
    {
        return org.semanticwb.promexico.Canal.ClassMgr.createCanal(id,this);
    }

    public void removeCanal(String id)
    {
        org.semanticwb.promexico.Canal.ClassMgr.removeCanal(id, this);
    }
    public boolean hasCanal(String id)
    {
        return org.semanticwb.promexico.Canal.ClassMgr.hasCanal(id, this);
    }

    public org.semanticwb.promexico.Faq getFaq(String id)
    {
        return org.semanticwb.promexico.Faq.ClassMgr.getFaq(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Faq> listFaqs()
    {
        return org.semanticwb.promexico.Faq.ClassMgr.listFaqs(this);
    }

    public org.semanticwb.promexico.Faq createFaq(String id)
    {
        return org.semanticwb.promexico.Faq.ClassMgr.createFaq(id,this);
    }

    public org.semanticwb.promexico.Faq createFaq()
    {
        long id=getSemanticObject().getModel().getCounter(promx_Faq);
        return org.semanticwb.promexico.Faq.ClassMgr.createFaq(String.valueOf(id),this);
    } 

    public void removeFaq(String id)
    {
        org.semanticwb.promexico.Faq.ClassMgr.removeFaq(id, this);
    }
    public boolean hasFaq(String id)
    {
        return org.semanticwb.promexico.Faq.ClassMgr.hasFaq(id, this);
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

    public org.semanticwb.promexico.ProMxVideo createProMxVideo()
    {
        long id=getSemanticObject().getModel().getCounter(promx_ProMxVideo);
        return org.semanticwb.promexico.ProMxVideo.ClassMgr.createProMxVideo(String.valueOf(id),this);
    } 

    public void removeProMxVideo(String id)
    {
        org.semanticwb.promexico.ProMxVideo.ClassMgr.removeProMxVideo(id, this);
    }
    public boolean hasProMxVideo(String id)
    {
        return org.semanticwb.promexico.ProMxVideo.ClassMgr.hasProMxVideo(id, this);
    }

    public org.semanticwb.promexico.Service getService(String id)
    {
        return org.semanticwb.promexico.Service.ClassMgr.getService(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Service> listServices()
    {
        return org.semanticwb.promexico.Service.ClassMgr.listServices(this);
    }

    public org.semanticwb.promexico.Service createService(String id)
    {
        return org.semanticwb.promexico.Service.ClassMgr.createService(id,this);
    }

    public void removeService(String id)
    {
        org.semanticwb.promexico.Service.ClassMgr.removeService(id, this);
    }
    public boolean hasService(String id)
    {
        return org.semanticwb.promexico.Service.ClassMgr.hasService(id, this);
    }

    public org.semanticwb.promexico.Market getMarket(String id)
    {
        return org.semanticwb.promexico.Market.ClassMgr.getMarket(id, this);
    }

    public java.util.Iterator<org.semanticwb.promexico.Market> listMarkets()
    {
        return org.semanticwb.promexico.Market.ClassMgr.listMarkets(this);
    }

    public org.semanticwb.promexico.Market createMarket(String id)
    {
        return org.semanticwb.promexico.Market.ClassMgr.createMarket(id,this);
    }

    public org.semanticwb.promexico.Market createMarket()
    {
        long id=getSemanticObject().getModel().getCounter(promx_Market);
        return org.semanticwb.promexico.Market.ClassMgr.createMarket(String.valueOf(id),this);
    } 

    public void removeMarket(String id)
    {
        org.semanticwb.promexico.Market.ClassMgr.removeMarket(id, this);
    }
    public boolean hasMarket(String id)
    {
        return org.semanticwb.promexico.Market.ClassMgr.hasMarket(id, this);
    }
}
