package com.infotec.eworkplace.swb.base;


public abstract class CompetenciaTICBase extends com.infotec.eworkplace.swb.Competencia 
{
    public static final org.semanticwb.platform.SemanticClass intranet_IngSistemas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#IngSistemas");
    public static final org.semanticwb.platform.SemanticProperty intranet_ingenieroSistemas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ingenieroSistemas");
    public static final org.semanticwb.platform.SemanticClass intranet_ArqSistema=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ArqSistema");
    public static final org.semanticwb.platform.SemanticProperty intranet_ArquitectoSistemas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ArquitectoSistemas");
    public static final org.semanticwb.platform.SemanticClass intranet_DesarrolloSW=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DesarrolloSW");
    public static final org.semanticwb.platform.SemanticProperty intranet_desarrolloSW=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#desarrolloSW");
    public static final org.semanticwb.platform.SemanticClass intranet_Emprendedor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Emprendedor");
    public static final org.semanticwb.platform.SemanticProperty intranet_emprendedor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#emprendedor");
    public static final org.semanticwb.platform.SemanticClass intranet_AdminProyectoProceso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AdminProyectoProceso");
    public static final org.semanticwb.platform.SemanticProperty intranet_adminProyectoProceso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#adminProyectoProceso");
    public static final org.semanticwb.platform.SemanticProperty intranet_cerVigAP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cerVigAP");
    public static final org.semanticwb.platform.SemanticProperty intranet_cerVigArq=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cerVigArq");
    public static final org.semanticwb.platform.SemanticClass intranet_Nivel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Nivel");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelAP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelAP");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelDesaSW=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelDesaSW");
    public static final org.semanticwb.platform.SemanticProperty intranet_cerVigIngSis=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cerVigIngSis");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelIngSistemas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelIngSistemas");
    public static final org.semanticwb.platform.SemanticProperty intranet_cerVigDesaSW=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cerVigDesaSW");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelArq=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelArq");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelEmprendedor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelEmprendedor");
    public static final org.semanticwb.platform.SemanticProperty intranet_cerVigEmprendedor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cerVigEmprendedor");
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciaTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciaTIC");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciaTIC");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompetenciaTIC for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.CompetenciaTIC for all models
       * @return Iterator of com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC>(it, true);
        }

        public static com.infotec.eworkplace.swb.CompetenciaTIC createCompetenciaTIC(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.CompetenciaTIC.ClassMgr.createCompetenciaTIC(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.CompetenciaTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciaTIC
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return A com.infotec.eworkplace.swb.CompetenciaTIC
       */
        public static com.infotec.eworkplace.swb.CompetenciaTIC getCompetenciaTIC(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CompetenciaTIC)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.CompetenciaTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciaTIC
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return A com.infotec.eworkplace.swb.CompetenciaTIC
       */
        public static com.infotec.eworkplace.swb.CompetenciaTIC createCompetenciaTIC(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CompetenciaTIC)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.CompetenciaTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciaTIC
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       */
        public static void removeCompetenciaTIC(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.CompetenciaTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciaTIC
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return true if the com.infotec.eworkplace.swb.CompetenciaTIC exists, false otherwise
       */

        public static boolean hasCompetenciaTIC(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompetenciaTIC(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined IngenieroSistemas
       * @param value IngenieroSistemas of the type com.infotec.eworkplace.swb.IngSistemas
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByIngenieroSistemas(com.infotec.eworkplace.swb.IngSistemas value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_ingenieroSistemas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined IngenieroSistemas
       * @param value IngenieroSistemas of the type com.infotec.eworkplace.swb.IngSistemas
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByIngenieroSistemas(com.infotec.eworkplace.swb.IngSistemas value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_ingenieroSistemas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined ArquitectoSistemas
       * @param value ArquitectoSistemas of the type com.infotec.eworkplace.swb.ArqSistema
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByArquitectoSistemas(com.infotec.eworkplace.swb.ArqSistema value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_ArquitectoSistemas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined ArquitectoSistemas
       * @param value ArquitectoSistemas of the type com.infotec.eworkplace.swb.ArqSistema
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByArquitectoSistemas(com.infotec.eworkplace.swb.ArqSistema value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_ArquitectoSistemas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined DesarrolloSW
       * @param value DesarrolloSW of the type com.infotec.eworkplace.swb.DesarrolloSW
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByDesarrolloSW(com.infotec.eworkplace.swb.DesarrolloSW value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_desarrolloSW, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined DesarrolloSW
       * @param value DesarrolloSW of the type com.infotec.eworkplace.swb.DesarrolloSW
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByDesarrolloSW(com.infotec.eworkplace.swb.DesarrolloSW value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_desarrolloSW,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined Emprendedor
       * @param value Emprendedor of the type com.infotec.eworkplace.swb.Emprendedor
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByEmprendedor(com.infotec.eworkplace.swb.Emprendedor value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_emprendedor, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined Emprendedor
       * @param value Emprendedor of the type com.infotec.eworkplace.swb.Emprendedor
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByEmprendedor(com.infotec.eworkplace.swb.Emprendedor value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_emprendedor,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined AdminProyectoProceso
       * @param value AdminProyectoProceso of the type com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByAdminProyectoProceso(com.infotec.eworkplace.swb.AdminProyectoProceso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_adminProyectoProceso, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined AdminProyectoProceso
       * @param value AdminProyectoProceso of the type com.infotec.eworkplace.swb.AdminProyectoProceso
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByAdminProyectoProceso(com.infotec.eworkplace.swb.AdminProyectoProceso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_adminProyectoProceso,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelAP
       * @param value NivelAP of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelAP(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelAP, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelAP
       * @param value NivelAP of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelAP(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelAP,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelDesaSW
       * @param value NivelDesaSW of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelDesaSW(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelDesaSW, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelDesaSW
       * @param value NivelDesaSW of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelDesaSW(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelDesaSW,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelIngSistemas
       * @param value NivelIngSistemas of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelIngSistemas(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelIngSistemas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelIngSistemas
       * @param value NivelIngSistemas of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelIngSistemas(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelIngSistemas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelArq
       * @param value NivelArq of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelArq(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelArq, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelArq
       * @param value NivelArq of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelArq(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelArq,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelEmprendedor
       * @param value NivelEmprendedor of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciaTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelEmprendedor(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelEmprendedor, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciaTIC with a determined NivelEmprendedor
       * @param value NivelEmprendedor of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciaTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciaTIC> listCompetenciaTICByNivelEmprendedor(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciaTIC> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelEmprendedor,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompetenciaTICBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompetenciaTIC
   */
    public CompetenciaTICBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property IngenieroSistemas
   * @param value IngenieroSistemas to set
   */

    public void setIngenieroSistemas(com.infotec.eworkplace.swb.IngSistemas value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_ingenieroSistemas, value.getSemanticObject());
        }else
        {
            removeIngenieroSistemas();
        }
    }
   /**
   * Remove the value for IngenieroSistemas property
   */

    public void removeIngenieroSistemas()
    {
        getSemanticObject().removeProperty(intranet_ingenieroSistemas);
    }

   /**
   * Gets the IngenieroSistemas
   * @return a com.infotec.eworkplace.swb.IngSistemas
   */
    public com.infotec.eworkplace.swb.IngSistemas getIngenieroSistemas()
    {
         com.infotec.eworkplace.swb.IngSistemas ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_ingenieroSistemas);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.IngSistemas)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ArquitectoSistemas
   * @param value ArquitectoSistemas to set
   */

    public void setArquitectoSistemas(com.infotec.eworkplace.swb.ArqSistema value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_ArquitectoSistemas, value.getSemanticObject());
        }else
        {
            removeArquitectoSistemas();
        }
    }
   /**
   * Remove the value for ArquitectoSistemas property
   */

    public void removeArquitectoSistemas()
    {
        getSemanticObject().removeProperty(intranet_ArquitectoSistemas);
    }

   /**
   * Gets the ArquitectoSistemas
   * @return a com.infotec.eworkplace.swb.ArqSistema
   */
    public com.infotec.eworkplace.swb.ArqSistema getArquitectoSistemas()
    {
         com.infotec.eworkplace.swb.ArqSistema ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_ArquitectoSistemas);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.ArqSistema)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property DesarrolloSW
   * @param value DesarrolloSW to set
   */

    public void setDesarrolloSW(com.infotec.eworkplace.swb.DesarrolloSW value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_desarrolloSW, value.getSemanticObject());
        }else
        {
            removeDesarrolloSW();
        }
    }
   /**
   * Remove the value for DesarrolloSW property
   */

    public void removeDesarrolloSW()
    {
        getSemanticObject().removeProperty(intranet_desarrolloSW);
    }

   /**
   * Gets the DesarrolloSW
   * @return a com.infotec.eworkplace.swb.DesarrolloSW
   */
    public com.infotec.eworkplace.swb.DesarrolloSW getDesarrolloSW()
    {
         com.infotec.eworkplace.swb.DesarrolloSW ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_desarrolloSW);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.DesarrolloSW)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Emprendedor
   * @param value Emprendedor to set
   */

    public void setEmprendedor(com.infotec.eworkplace.swb.Emprendedor value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_emprendedor, value.getSemanticObject());
        }else
        {
            removeEmprendedor();
        }
    }
   /**
   * Remove the value for Emprendedor property
   */

    public void removeEmprendedor()
    {
        getSemanticObject().removeProperty(intranet_emprendedor);
    }

   /**
   * Gets the Emprendedor
   * @return a com.infotec.eworkplace.swb.Emprendedor
   */
    public com.infotec.eworkplace.swb.Emprendedor getEmprendedor()
    {
         com.infotec.eworkplace.swb.Emprendedor ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_emprendedor);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Emprendedor)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property AdminProyectoProceso
   * @param value AdminProyectoProceso to set
   */

    public void setAdminProyectoProceso(com.infotec.eworkplace.swb.AdminProyectoProceso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_adminProyectoProceso, value.getSemanticObject());
        }else
        {
            removeAdminProyectoProceso();
        }
    }
   /**
   * Remove the value for AdminProyectoProceso property
   */

    public void removeAdminProyectoProceso()
    {
        getSemanticObject().removeProperty(intranet_adminProyectoProceso);
    }

   /**
   * Gets the AdminProyectoProceso
   * @return a com.infotec.eworkplace.swb.AdminProyectoProceso
   */
    public com.infotec.eworkplace.swb.AdminProyectoProceso getAdminProyectoProceso()
    {
         com.infotec.eworkplace.swb.AdminProyectoProceso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_adminProyectoProceso);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.AdminProyectoProceso)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the CerVigAP property
* @return String with the CerVigAP
*/
    public String getCerVigAP()
    {
        return getSemanticObject().getProperty(intranet_cerVigAP);
    }

/**
* Sets the CerVigAP property
* @param value long with the CerVigAP
*/
    public void setCerVigAP(String value)
    {
        getSemanticObject().setProperty(intranet_cerVigAP, value);
    }

/**
* Gets the CerVigArq property
* @return String with the CerVigArq
*/
    public String getCerVigArq()
    {
        return getSemanticObject().getProperty(intranet_cerVigArq);
    }

/**
* Sets the CerVigArq property
* @param value long with the CerVigArq
*/
    public void setCerVigArq(String value)
    {
        getSemanticObject().setProperty(intranet_cerVigArq, value);
    }
   /**
   * Sets the value for the property NivelAP
   * @param value NivelAP to set
   */

    public void setNivelAP(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelAP, value.getSemanticObject());
        }else
        {
            removeNivelAP();
        }
    }
   /**
   * Remove the value for NivelAP property
   */

    public void removeNivelAP()
    {
        getSemanticObject().removeProperty(intranet_nivelAP);
    }

   /**
   * Gets the NivelAP
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelAP()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelAP);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NivelDesaSW
   * @param value NivelDesaSW to set
   */

    public void setNivelDesaSW(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelDesaSW, value.getSemanticObject());
        }else
        {
            removeNivelDesaSW();
        }
    }
   /**
   * Remove the value for NivelDesaSW property
   */

    public void removeNivelDesaSW()
    {
        getSemanticObject().removeProperty(intranet_nivelDesaSW);
    }

   /**
   * Gets the NivelDesaSW
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelDesaSW()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelDesaSW);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the CerVigIngSis property
* @return String with the CerVigIngSis
*/
    public String getCerVigIngSis()
    {
        return getSemanticObject().getProperty(intranet_cerVigIngSis);
    }

/**
* Sets the CerVigIngSis property
* @param value long with the CerVigIngSis
*/
    public void setCerVigIngSis(String value)
    {
        getSemanticObject().setProperty(intranet_cerVigIngSis, value);
    }
   /**
   * Sets the value for the property NivelIngSistemas
   * @param value NivelIngSistemas to set
   */

    public void setNivelIngSistemas(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelIngSistemas, value.getSemanticObject());
        }else
        {
            removeNivelIngSistemas();
        }
    }
   /**
   * Remove the value for NivelIngSistemas property
   */

    public void removeNivelIngSistemas()
    {
        getSemanticObject().removeProperty(intranet_nivelIngSistemas);
    }

   /**
   * Gets the NivelIngSistemas
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelIngSistemas()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelIngSistemas);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the CerVigDesaSW property
* @return String with the CerVigDesaSW
*/
    public String getCerVigDesaSW()
    {
        return getSemanticObject().getProperty(intranet_cerVigDesaSW);
    }

/**
* Sets the CerVigDesaSW property
* @param value long with the CerVigDesaSW
*/
    public void setCerVigDesaSW(String value)
    {
        getSemanticObject().setProperty(intranet_cerVigDesaSW, value);
    }
   /**
   * Sets the value for the property NivelArq
   * @param value NivelArq to set
   */

    public void setNivelArq(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelArq, value.getSemanticObject());
        }else
        {
            removeNivelArq();
        }
    }
   /**
   * Remove the value for NivelArq property
   */

    public void removeNivelArq()
    {
        getSemanticObject().removeProperty(intranet_nivelArq);
    }

   /**
   * Gets the NivelArq
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelArq()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelArq);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NivelEmprendedor
   * @param value NivelEmprendedor to set
   */

    public void setNivelEmprendedor(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelEmprendedor, value.getSemanticObject());
        }else
        {
            removeNivelEmprendedor();
        }
    }
   /**
   * Remove the value for NivelEmprendedor property
   */

    public void removeNivelEmprendedor()
    {
        getSemanticObject().removeProperty(intranet_nivelEmprendedor);
    }

   /**
   * Gets the NivelEmprendedor
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelEmprendedor()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelEmprendedor);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the CerVigEmprendedor property
* @return String with the CerVigEmprendedor
*/
    public String getCerVigEmprendedor()
    {
        return getSemanticObject().getProperty(intranet_cerVigEmprendedor);
    }

/**
* Sets the CerVigEmprendedor property
* @param value long with the CerVigEmprendedor
*/
    public void setCerVigEmprendedor(String value)
    {
        getSemanticObject().setProperty(intranet_cerVigEmprendedor, value);
    }
}
