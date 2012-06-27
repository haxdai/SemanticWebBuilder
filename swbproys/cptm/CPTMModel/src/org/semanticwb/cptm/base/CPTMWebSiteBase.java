package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de swb:WebSite. Es un tipo de website para CPTM. De esta manera se puede contar con todos los elementos en el arbol de navegación en la administración, y otros elementos utiles para CPTM. 
   */
public abstract class CPTMWebSiteBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.OntologyDepable,org.semanticwb.model.Activeable,org.semanticwb.model.Localeable,org.semanticwb.model.Countryable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.FilterableClass
{
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Estados de la República (Ej. Tamaulipas, Morelos)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#State");
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de tipos de actividades (Ej. Aventura y Ecoturismo, Cultura)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityType");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Regiones. (Ej. Norte, Centro, Peninsula de Yucatan, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Region=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Region");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de tipos de  experiencias (Ej. Romance, Sol y Playa)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceType");
   /**
   * Catálogo de Marcas Regionales (Ej. Riviera Maya, Riviera Nayarit, etc). Estos contienen Puntos Geográficos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_RegionalBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Puntos Geográficos (Cancun, Tampico, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeographicPoint");
    public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSite");
   /**
   * Clase que se encarga de administrar el Catálogo de secciones que se despliegan en el menú "Como Viajar".
   */
    public static final org.semanticwb.platform.SemanticClass cptm_How2Travel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#How2Travel");
    public static final org.semanticwb.platform.SemanticClass cptm_EditNoteBase=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNoteBase");
   /**
   * Objeto que se encarga de administrar el catálogo de Canales del sitio (Ej. Destinos, Actividades).
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Canal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Canal");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Event");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de tipos de eventos.pueden ser Ej. "Carnavales", "Congresos", etc
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EventType");
   /**
   * Notas Editoriales
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EditNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");
    public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSiteWebPageUtil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSiteWebPageUtil");
   /**
   * Clase que se encarga de administrar el cátalogo de "Tipos de Rutas de Viaje" (Ej. Rutas Turisticas, Rutas Bicentenario, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelRouteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRouteType");
   /**
   * Clase que se encarga de manejar el catálogo de "Rutas de Viaje" (Ej. Ruta del Vino, Ruta Morelos, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelRoute=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRoute");
   /**
   * Clase que se encarga de administrar el catálogo de Actividades (Buceo, Pesca, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias (Ej. Bodas, Parejas)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
   /**
   * Páginas web para Puntos Geográficos, se agrego esta clase para que solo se pudieran agregar Puntos geográficos en un elemento de tipo "Estado/State"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CPTMWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMWebPage");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");
   /**
   * Clase que hereda de swb:WebSite. Es un tipo de website para CPTM. De esta manera se puede contar con todos los elementos en el arbol de navegación en la administración, y otros elementos utiles para CPTM.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CPTMWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMWebSite");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMWebSite");

    public static class ClassMgr
    {
       /**
       * Returns a list of CPTMWebSite for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CPTMWebSite for all models
       * @return Iterator of org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CPTMWebSite
       * @param id Identifier for org.semanticwb.cptm.CPTMWebSite
       * @return A org.semanticwb.cptm.CPTMWebSite
       */
        public static org.semanticwb.cptm.CPTMWebSite getCPTMWebSite(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.cptm.CPTMWebSite ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    org.semanticwb.model.GenericObject gobj=obj.createGenericInstance();
                    if(gobj instanceof org.semanticwb.cptm.CPTMWebSite)
                    {
                        ret=(org.semanticwb.cptm.CPTMWebSite)gobj;
                    }
                }
            }
            return ret;
        }
       /**
       * Create a org.semanticwb.cptm.CPTMWebSite
       * @param id Identifier for org.semanticwb.cptm.CPTMWebSite
       * @return A org.semanticwb.cptm.CPTMWebSite
       */
        public static org.semanticwb.cptm.CPTMWebSite createCPTMWebSite(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (org.semanticwb.cptm.CPTMWebSite)model.createGenericObject(model.getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CPTMWebSite
       * @param id Identifier for org.semanticwb.cptm.CPTMWebSite
       */
        public static void removeCPTMWebSite(String id)
        {
            org.semanticwb.cptm.CPTMWebSite obj=getCPTMWebSite(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CPTMWebSite
       * @param id Identifier for org.semanticwb.cptm.CPTMWebSite
       * @return true if the org.semanticwb.cptm.CPTMWebSite exists, false otherwise
       */

        public static boolean hasCPTMWebSite(String id)
        {
            return (getCPTMWebSite(id)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined SubModel
       * @param value SubModel of the type org.semanticwb.model.SWBModel
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined DefaultTemplate
       * @param value DefaultTemplate of the type org.semanticwb.model.Template
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined HomePage
       * @param value HomePage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined UserRepository
       * @param value UserRepository of the type org.semanticwb.model.UserRepository
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined ParentWebSite
       * @param value ParentWebSite of the type org.semanticwb.model.WebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByModelProperty(org.semanticwb.model.ModelProperty value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined ModelProperty
       * @param value ModelProperty of the type org.semanticwb.model.ModelProperty
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByModelProperty(org.semanticwb.model.ModelProperty value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasModelProperty,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @param model Model of the org.semanticwb.cptm.CPTMWebSite
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByOntology(org.semanticwb.model.Ontology value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebSite with a determined Ontology
       * @param value Ontology of the type org.semanticwb.model.Ontology
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebSite
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebSite> listCPTMWebSiteByOntology(org.semanticwb.model.Ontology value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasOntology,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CPTMWebSiteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CPTMWebSite
   */
    public CPTMWebSiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.cptm.State getState(String id)
    {
        return org.semanticwb.cptm.State.ClassMgr.getState(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.State> listStates()
    {
        return org.semanticwb.cptm.State.ClassMgr.listStates(this);
    }

    public org.semanticwb.cptm.State createState(String id)
    {
        return org.semanticwb.cptm.State.ClassMgr.createState(id,this);
    }

    public void removeState(String id)
    {
        org.semanticwb.cptm.State.ClassMgr.removeState(id, this);
    }
    public boolean hasState(String id)
    {
        return org.semanticwb.cptm.State.ClassMgr.hasState(id, this);
    }

    public org.semanticwb.cptm.ActivityType getActivityType(String id)
    {
        return org.semanticwb.cptm.ActivityType.ClassMgr.getActivityType(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypes()
    {
        return org.semanticwb.cptm.ActivityType.ClassMgr.listActivityTypes(this);
    }

    public org.semanticwb.cptm.ActivityType createActivityType(String id)
    {
        return org.semanticwb.cptm.ActivityType.ClassMgr.createActivityType(id,this);
    }

    public void removeActivityType(String id)
    {
        org.semanticwb.cptm.ActivityType.ClassMgr.removeActivityType(id, this);
    }
    public boolean hasActivityType(String id)
    {
        return org.semanticwb.cptm.ActivityType.ClassMgr.hasActivityType(id, this);
    }

    public org.semanticwb.cptm.Region getRegion(String id)
    {
        return org.semanticwb.cptm.Region.ClassMgr.getRegion(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.Region> listRegions()
    {
        return org.semanticwb.cptm.Region.ClassMgr.listRegions(this);
    }

    public org.semanticwb.cptm.Region createRegion(String id)
    {
        return org.semanticwb.cptm.Region.ClassMgr.createRegion(id,this);
    }

    public void removeRegion(String id)
    {
        org.semanticwb.cptm.Region.ClassMgr.removeRegion(id, this);
    }
    public boolean hasRegion(String id)
    {
        return org.semanticwb.cptm.Region.ClassMgr.hasRegion(id, this);
    }

    public org.semanticwb.cptm.ExperienceType getExperienceType(String id)
    {
        return org.semanticwb.cptm.ExperienceType.ClassMgr.getExperienceType(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.ExperienceType> listExperienceTypes()
    {
        return org.semanticwb.cptm.ExperienceType.ClassMgr.listExperienceTypes(this);
    }

    public org.semanticwb.cptm.ExperienceType createExperienceType(String id)
    {
        return org.semanticwb.cptm.ExperienceType.ClassMgr.createExperienceType(id,this);
    }

    public void removeExperienceType(String id)
    {
        org.semanticwb.cptm.ExperienceType.ClassMgr.removeExperienceType(id, this);
    }
    public boolean hasExperienceType(String id)
    {
        return org.semanticwb.cptm.ExperienceType.ClassMgr.hasExperienceType(id, this);
    }

    public org.semanticwb.cptm.RegionalBrand getRegionalBrand(String id)
    {
        return org.semanticwb.cptm.RegionalBrand.ClassMgr.getRegionalBrand(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrands()
    {
        return org.semanticwb.cptm.RegionalBrand.ClassMgr.listRegionalBrands(this);
    }

    public org.semanticwb.cptm.RegionalBrand createRegionalBrand(String id)
    {
        return org.semanticwb.cptm.RegionalBrand.ClassMgr.createRegionalBrand(id,this);
    }

    public void removeRegionalBrand(String id)
    {
        org.semanticwb.cptm.RegionalBrand.ClassMgr.removeRegionalBrand(id, this);
    }
    public boolean hasRegionalBrand(String id)
    {
        return org.semanticwb.cptm.RegionalBrand.ClassMgr.hasRegionalBrand(id, this);
    }

    public org.semanticwb.cptm.GeographicPoint getGeographicPoint(String id)
    {
        return org.semanticwb.cptm.GeographicPoint.ClassMgr.getGeographicPoint(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPoints()
    {
        return org.semanticwb.cptm.GeographicPoint.ClassMgr.listGeographicPoints(this);
    }

    public org.semanticwb.cptm.GeographicPoint createGeographicPoint(String id)
    {
        return org.semanticwb.cptm.GeographicPoint.ClassMgr.createGeographicPoint(id,this);
    }

    public void removeGeographicPoint(String id)
    {
        org.semanticwb.cptm.GeographicPoint.ClassMgr.removeGeographicPoint(id, this);
    }
    public boolean hasGeographicPoint(String id)
    {
        return org.semanticwb.cptm.GeographicPoint.ClassMgr.hasGeographicPoint(id, this);
    }

    public org.semanticwb.portal.community.MicroSite getMicroSite(String id)
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.getMicroSite(id, this);
    }

    public java.util.Iterator<org.semanticwb.portal.community.MicroSite> listMicroSites()
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.listMicroSites(this);
    }

    public org.semanticwb.portal.community.MicroSite createMicroSite(String id)
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.createMicroSite(id,this);
    }

    public void removeMicroSite(String id)
    {
        org.semanticwb.portal.community.MicroSite.ClassMgr.removeMicroSite(id, this);
    }
    public boolean hasMicroSite(String id)
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.hasMicroSite(id, this);
    }

    public org.semanticwb.cptm.How2Travel getHow2Travel(String id)
    {
        return org.semanticwb.cptm.How2Travel.ClassMgr.getHow2Travel(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.How2Travel> listHow2Travels()
    {
        return org.semanticwb.cptm.How2Travel.ClassMgr.listHow2Travels(this);
    }

    public org.semanticwb.cptm.How2Travel createHow2Travel(String id)
    {
        return org.semanticwb.cptm.How2Travel.ClassMgr.createHow2Travel(id,this);
    }

    public void removeHow2Travel(String id)
    {
        org.semanticwb.cptm.How2Travel.ClassMgr.removeHow2Travel(id, this);
    }
    public boolean hasHow2Travel(String id)
    {
        return org.semanticwb.cptm.How2Travel.ClassMgr.hasHow2Travel(id, this);
    }

    public org.semanticwb.cptm.EditNoteBase getEditNoteBase(String id)
    {
        return org.semanticwb.cptm.EditNoteBase.ClassMgr.getEditNoteBase(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.EditNoteBase> listEditNoteBases()
    {
        return org.semanticwb.cptm.EditNoteBase.ClassMgr.listEditNoteBases(this);
    }

    public org.semanticwb.cptm.EditNoteBase createEditNoteBase(String id)
    {
        return org.semanticwb.cptm.EditNoteBase.ClassMgr.createEditNoteBase(id,this);
    }

    public void removeEditNoteBase(String id)
    {
        org.semanticwb.cptm.EditNoteBase.ClassMgr.removeEditNoteBase(id, this);
    }
    public boolean hasEditNoteBase(String id)
    {
        return org.semanticwb.cptm.EditNoteBase.ClassMgr.hasEditNoteBase(id, this);
    }

    public org.semanticwb.cptm.Canal getCanal(String id)
    {
        return org.semanticwb.cptm.Canal.ClassMgr.getCanal(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.Canal> listCanals()
    {
        return org.semanticwb.cptm.Canal.ClassMgr.listCanals(this);
    }

    public org.semanticwb.cptm.Canal createCanal(String id)
    {
        return org.semanticwb.cptm.Canal.ClassMgr.createCanal(id,this);
    }

    public void removeCanal(String id)
    {
        org.semanticwb.cptm.Canal.ClassMgr.removeCanal(id, this);
    }
    public boolean hasCanal(String id)
    {
        return org.semanticwb.cptm.Canal.ClassMgr.hasCanal(id, this);
    }

    public org.semanticwb.cptm.Event getEvent(String id)
    {
        return org.semanticwb.cptm.Event.ClassMgr.getEvent(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.Event> listEvents()
    {
        return org.semanticwb.cptm.Event.ClassMgr.listEvents(this);
    }

    public org.semanticwb.cptm.Event createEvent(String id)
    {
        return org.semanticwb.cptm.Event.ClassMgr.createEvent(id,this);
    }

    public void removeEvent(String id)
    {
        org.semanticwb.cptm.Event.ClassMgr.removeEvent(id, this);
    }
    public boolean hasEvent(String id)
    {
        return org.semanticwb.cptm.Event.ClassMgr.hasEvent(id, this);
    }

    public org.semanticwb.cptm.EventType getEventType(String id)
    {
        return org.semanticwb.cptm.EventType.ClassMgr.getEventType(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.EventType> listEventTypes()
    {
        return org.semanticwb.cptm.EventType.ClassMgr.listEventTypes(this);
    }

    public org.semanticwb.cptm.EventType createEventType(String id)
    {
        return org.semanticwb.cptm.EventType.ClassMgr.createEventType(id,this);
    }

    public void removeEventType(String id)
    {
        org.semanticwb.cptm.EventType.ClassMgr.removeEventType(id, this);
    }
    public boolean hasEventType(String id)
    {
        return org.semanticwb.cptm.EventType.ClassMgr.hasEventType(id, this);
    }

    public org.semanticwb.cptm.EditNote getEditNote(String id)
    {
        return org.semanticwb.cptm.EditNote.ClassMgr.getEditNote(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNotes()
    {
        return org.semanticwb.cptm.EditNote.ClassMgr.listEditNotes(this);
    }

    public org.semanticwb.cptm.EditNote createEditNote(String id)
    {
        return org.semanticwb.cptm.EditNote.ClassMgr.createEditNote(id,this);
    }

    public void removeEditNote(String id)
    {
        org.semanticwb.cptm.EditNote.ClassMgr.removeEditNote(id, this);
    }
    public boolean hasEditNote(String id)
    {
        return org.semanticwb.cptm.EditNote.ClassMgr.hasEditNote(id, this);
    }

    public org.semanticwb.portal.community.MicroSiteWebPageUtil getMicroSiteWebPageUtil(String id)
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.getMicroSiteWebPageUtil(id, this);
    }

    public java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtils()
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.listMicroSiteWebPageUtils(this);
    }

    public org.semanticwb.portal.community.MicroSiteWebPageUtil createMicroSiteWebPageUtil(String id)
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.createMicroSiteWebPageUtil(id,this);
    }

    public void removeMicroSiteWebPageUtil(String id)
    {
        org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.removeMicroSiteWebPageUtil(id, this);
    }
    public boolean hasMicroSiteWebPageUtil(String id)
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.hasMicroSiteWebPageUtil(id, this);
    }

    public org.semanticwb.cptm.TravelRouteType getTravelRouteType(String id)
    {
        return org.semanticwb.cptm.TravelRouteType.ClassMgr.getTravelRouteType(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypes()
    {
        return org.semanticwb.cptm.TravelRouteType.ClassMgr.listTravelRouteTypes(this);
    }

    public org.semanticwb.cptm.TravelRouteType createTravelRouteType(String id)
    {
        return org.semanticwb.cptm.TravelRouteType.ClassMgr.createTravelRouteType(id,this);
    }

    public void removeTravelRouteType(String id)
    {
        org.semanticwb.cptm.TravelRouteType.ClassMgr.removeTravelRouteType(id, this);
    }
    public boolean hasTravelRouteType(String id)
    {
        return org.semanticwb.cptm.TravelRouteType.ClassMgr.hasTravelRouteType(id, this);
    }

    public org.semanticwb.cptm.TravelRoute getTravelRoute(String id)
    {
        return org.semanticwb.cptm.TravelRoute.ClassMgr.getTravelRoute(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRoutes()
    {
        return org.semanticwb.cptm.TravelRoute.ClassMgr.listTravelRoutes(this);
    }

    public org.semanticwb.cptm.TravelRoute createTravelRoute(String id)
    {
        return org.semanticwb.cptm.TravelRoute.ClassMgr.createTravelRoute(id,this);
    }

    public void removeTravelRoute(String id)
    {
        org.semanticwb.cptm.TravelRoute.ClassMgr.removeTravelRoute(id, this);
    }
    public boolean hasTravelRoute(String id)
    {
        return org.semanticwb.cptm.TravelRoute.ClassMgr.hasTravelRoute(id, this);
    }

    public org.semanticwb.cptm.Activity getActivity(String id)
    {
        return org.semanticwb.cptm.Activity.ClassMgr.getActivity(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.Activity> listActivities()
    {
        return org.semanticwb.cptm.Activity.ClassMgr.listActivities(this);
    }

    public org.semanticwb.cptm.Activity createActivity(String id)
    {
        return org.semanticwb.cptm.Activity.ClassMgr.createActivity(id,this);
    }

    public void removeActivity(String id)
    {
        org.semanticwb.cptm.Activity.ClassMgr.removeActivity(id, this);
    }
    public boolean hasActivity(String id)
    {
        return org.semanticwb.cptm.Activity.ClassMgr.hasActivity(id, this);
    }

    public org.semanticwb.cptm.Experience getExperience(String id)
    {
        return org.semanticwb.cptm.Experience.ClassMgr.getExperience(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.Experience> listExperiences()
    {
        return org.semanticwb.cptm.Experience.ClassMgr.listExperiences(this);
    }

    public org.semanticwb.cptm.Experience createExperience(String id)
    {
        return org.semanticwb.cptm.Experience.ClassMgr.createExperience(id,this);
    }

    public void removeExperience(String id)
    {
        org.semanticwb.cptm.Experience.ClassMgr.removeExperience(id, this);
    }
    public boolean hasExperience(String id)
    {
        return org.semanticwb.cptm.Experience.ClassMgr.hasExperience(id, this);
    }

    public org.semanticwb.cptm.ActivityRef getActivityRef(String id)
    {
        return org.semanticwb.cptm.ActivityRef.ClassMgr.getActivityRef(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefs()
    {
        return org.semanticwb.cptm.ActivityRef.ClassMgr.listActivityRefs(this);
    }

    public org.semanticwb.cptm.ActivityRef createActivityRef(String id)
    {
        return org.semanticwb.cptm.ActivityRef.ClassMgr.createActivityRef(id,this);
    }

    public void removeActivityRef(String id)
    {
        org.semanticwb.cptm.ActivityRef.ClassMgr.removeActivityRef(id, this);
    }
    public boolean hasActivityRef(String id)
    {
        return org.semanticwb.cptm.ActivityRef.ClassMgr.hasActivityRef(id, this);
    }

    public org.semanticwb.cptm.CPTMWebPage getCPTMWebPage(String id)
    {
        return org.semanticwb.cptm.CPTMWebPage.ClassMgr.getCPTMWebPage(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPages()
    {
        return org.semanticwb.cptm.CPTMWebPage.ClassMgr.listCPTMWebPages(this);
    }

    public org.semanticwb.cptm.CPTMWebPage createCPTMWebPage(String id)
    {
        return org.semanticwb.cptm.CPTMWebPage.ClassMgr.createCPTMWebPage(id,this);
    }

    public void removeCPTMWebPage(String id)
    {
        org.semanticwb.cptm.CPTMWebPage.ClassMgr.removeCPTMWebPage(id, this);
    }
    public boolean hasCPTMWebPage(String id)
    {
        return org.semanticwb.cptm.CPTMWebPage.ClassMgr.hasCPTMWebPage(id, this);
    }

    public org.semanticwb.cptm.ExperienceRef getExperienceRef(String id)
    {
        return org.semanticwb.cptm.ExperienceRef.ClassMgr.getExperienceRef(id, this);
    }

    public java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefs()
    {
        return org.semanticwb.cptm.ExperienceRef.ClassMgr.listExperienceRefs(this);
    }

    public org.semanticwb.cptm.ExperienceRef createExperienceRef(String id)
    {
        return org.semanticwb.cptm.ExperienceRef.ClassMgr.createExperienceRef(id,this);
    }

    public void removeExperienceRef(String id)
    {
        org.semanticwb.cptm.ExperienceRef.ClassMgr.removeExperienceRef(id, this);
    }
    public boolean hasExperienceRef(String id)
    {
        return org.semanticwb.cptm.ExperienceRef.ClassMgr.hasExperienceRef(id, this);
    }
}
