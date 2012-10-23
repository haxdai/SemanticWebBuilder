package com.infotec.cvi.swb.base;


   /**
   * Elemento para la Investigación y Docencia del CVI 
   */
public abstract class InvestigacionDocenciaBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Elemento para la Investigación y Docencia del CVI
   */
    public static final org.semanticwb.platform.SemanticClass intranet_InvestigacionDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#InvestigacionDocencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#InvestigacionDocencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of InvestigacionDocencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.InvestigacionDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.InvestigacionDocencia> listInvestigacionDocencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.InvestigacionDocencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.InvestigacionDocencia for all models
       * @return Iterator of com.infotec.cvi.swb.InvestigacionDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.InvestigacionDocencia> listInvestigacionDocencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.InvestigacionDocencia>(it, true);
        }

        public static com.infotec.cvi.swb.InvestigacionDocencia createInvestigacionDocencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.InvestigacionDocencia.ClassMgr.createInvestigacionDocencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.InvestigacionDocencia
       * @param id Identifier for com.infotec.cvi.swb.InvestigacionDocencia
       * @param model Model of the com.infotec.cvi.swb.InvestigacionDocencia
       * @return A com.infotec.cvi.swb.InvestigacionDocencia
       */
        public static com.infotec.cvi.swb.InvestigacionDocencia getInvestigacionDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.InvestigacionDocencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.InvestigacionDocencia
       * @param id Identifier for com.infotec.cvi.swb.InvestigacionDocencia
       * @param model Model of the com.infotec.cvi.swb.InvestigacionDocencia
       * @return A com.infotec.cvi.swb.InvestigacionDocencia
       */
        public static com.infotec.cvi.swb.InvestigacionDocencia createInvestigacionDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.InvestigacionDocencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.InvestigacionDocencia
       * @param id Identifier for com.infotec.cvi.swb.InvestigacionDocencia
       * @param model Model of the com.infotec.cvi.swb.InvestigacionDocencia
       */
        public static void removeInvestigacionDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.InvestigacionDocencia
       * @param id Identifier for com.infotec.cvi.swb.InvestigacionDocencia
       * @param model Model of the com.infotec.cvi.swb.InvestigacionDocencia
       * @return true if the com.infotec.cvi.swb.InvestigacionDocencia exists, false otherwise
       */

        public static boolean hasInvestigacionDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInvestigacionDocencia(id, model)!=null);
        }
    }

    public static InvestigacionDocenciaBase.ClassMgr getInvestigacionDocenciaClassMgr()
    {
        return new InvestigacionDocenciaBase.ClassMgr();
    }

   /**
   * Constructs a InvestigacionDocenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the InvestigacionDocencia
   */
    public InvestigacionDocenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
