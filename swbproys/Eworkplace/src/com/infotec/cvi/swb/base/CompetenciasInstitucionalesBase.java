package com.infotec.cvi.swb.base;


public abstract class CompetenciasInstitucionalesBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasInstitucionales=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasInstitucionales");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasInstitucionales");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompetenciasInstitucionales for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.CompetenciasInstitucionales
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasInstitucionales> listCompetenciasInstitucionaleses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasInstitucionales>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.CompetenciasInstitucionales for all models
       * @return Iterator of com.infotec.cvi.swb.CompetenciasInstitucionales
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasInstitucionales> listCompetenciasInstitucionaleses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasInstitucionales>(it, true);
        }

        public static com.infotec.cvi.swb.CompetenciasInstitucionales createCompetenciasInstitucionales(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.CompetenciasInstitucionales.ClassMgr.createCompetenciasInstitucionales(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param model Model of the com.infotec.cvi.swb.CompetenciasInstitucionales
       * @return A com.infotec.cvi.swb.CompetenciasInstitucionales
       */
        public static com.infotec.cvi.swb.CompetenciasInstitucionales getCompetenciasInstitucionales(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CompetenciasInstitucionales)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param model Model of the com.infotec.cvi.swb.CompetenciasInstitucionales
       * @return A com.infotec.cvi.swb.CompetenciasInstitucionales
       */
        public static com.infotec.cvi.swb.CompetenciasInstitucionales createCompetenciasInstitucionales(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CompetenciasInstitucionales)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param model Model of the com.infotec.cvi.swb.CompetenciasInstitucionales
       */
        public static void removeCompetenciasInstitucionales(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasInstitucionales
       * @param model Model of the com.infotec.cvi.swb.CompetenciasInstitucionales
       * @return true if the com.infotec.cvi.swb.CompetenciasInstitucionales exists, false otherwise
       */

        public static boolean hasCompetenciasInstitucionales(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompetenciasInstitucionales(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasInstitucionales with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CompetenciasInstitucionales
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasInstitucionales
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasInstitucionales> listCompetenciasInstitucionalesByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasInstitucionales> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasInstitucionales with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasInstitucionales
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasInstitucionales> listCompetenciasInstitucionalesByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasInstitucionales> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasInstitucionales with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CompetenciasInstitucionales
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasInstitucionales
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasInstitucionales> listCompetenciasInstitucionalesByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasInstitucionales> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasInstitucionales with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasInstitucionales
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasInstitucionales> listCompetenciasInstitucionalesByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasInstitucionales> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompetenciasInstitucionalesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompetenciasInstitucionales
   */
    public CompetenciasInstitucionalesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
