package com.infotec.eworkplace.swb.base;


public abstract class EmpDomicilioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ewp_EmpDomicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#EmpDomicilio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#EmpDomicilio");

    public static class ClassMgr
    {
       /**
       * Returns a list of EmpDomicilio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.EmpDomicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EmpDomicilio> listEmpDomicilios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EmpDomicilio>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.EmpDomicilio for all models
       * @return Iterator of com.infotec.eworkplace.swb.EmpDomicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EmpDomicilio> listEmpDomicilios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EmpDomicilio>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.EmpDomicilio
       * @param id Identifier for com.infotec.eworkplace.swb.EmpDomicilio
       * @param model Model of the com.infotec.eworkplace.swb.EmpDomicilio
       * @return A com.infotec.eworkplace.swb.EmpDomicilio
       */
        public static com.infotec.eworkplace.swb.EmpDomicilio getEmpDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EmpDomicilio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.EmpDomicilio
       * @param id Identifier for com.infotec.eworkplace.swb.EmpDomicilio
       * @param model Model of the com.infotec.eworkplace.swb.EmpDomicilio
       * @return A com.infotec.eworkplace.swb.EmpDomicilio
       */
        public static com.infotec.eworkplace.swb.EmpDomicilio createEmpDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EmpDomicilio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.EmpDomicilio
       * @param id Identifier for com.infotec.eworkplace.swb.EmpDomicilio
       * @param model Model of the com.infotec.eworkplace.swb.EmpDomicilio
       */
        public static void removeEmpDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.EmpDomicilio
       * @param id Identifier for com.infotec.eworkplace.swb.EmpDomicilio
       * @param model Model of the com.infotec.eworkplace.swb.EmpDomicilio
       * @return true if the com.infotec.eworkplace.swb.EmpDomicilio exists, false otherwise
       */

        public static boolean hasEmpDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEmpDomicilio(id, model)!=null);
        }
    }

   /**
   * Constructs a EmpDomicilioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EmpDomicilio
   */
    public EmpDomicilioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

   /**
   * Gets the InfotecIntranet
   * @return a instance of com.infotec.eworkplace.swb.InfotecIntranet
   */
    public com.infotec.eworkplace.swb.InfotecIntranet getInfotecIntranet()
    {
        return (com.infotec.eworkplace.swb.InfotecIntranet)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
