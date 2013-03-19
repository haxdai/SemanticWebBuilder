package com.infotec.eworkplace.swb.base;


public abstract class NivelEstudioContratoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_NivelEstudioContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#NivelEstudioContrato");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#NivelEstudioContrato");

    public static class ClassMgr
    {
       /**
       * Returns a list of NivelEstudioContrato for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.NivelEstudioContrato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.NivelEstudioContrato> listNivelEstudioContratos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.NivelEstudioContrato>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.NivelEstudioContrato for all models
       * @return Iterator of com.infotec.eworkplace.swb.NivelEstudioContrato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.NivelEstudioContrato> listNivelEstudioContratos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.NivelEstudioContrato>(it, true);
        }

        public static com.infotec.eworkplace.swb.NivelEstudioContrato createNivelEstudioContrato(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.NivelEstudioContrato.ClassMgr.createNivelEstudioContrato(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param id Identifier for com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param model Model of the com.infotec.eworkplace.swb.NivelEstudioContrato
       * @return A com.infotec.eworkplace.swb.NivelEstudioContrato
       */
        public static com.infotec.eworkplace.swb.NivelEstudioContrato getNivelEstudioContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.NivelEstudioContrato)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param id Identifier for com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param model Model of the com.infotec.eworkplace.swb.NivelEstudioContrato
       * @return A com.infotec.eworkplace.swb.NivelEstudioContrato
       */
        public static com.infotec.eworkplace.swb.NivelEstudioContrato createNivelEstudioContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.NivelEstudioContrato)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param id Identifier for com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param model Model of the com.infotec.eworkplace.swb.NivelEstudioContrato
       */
        public static void removeNivelEstudioContrato(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param id Identifier for com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param model Model of the com.infotec.eworkplace.swb.NivelEstudioContrato
       * @return true if the com.infotec.eworkplace.swb.NivelEstudioContrato exists, false otherwise
       */

        public static boolean hasNivelEstudioContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNivelEstudioContrato(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.NivelEstudioContrato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.NivelEstudioContrato
       * @return Iterator with all the com.infotec.eworkplace.swb.NivelEstudioContrato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.NivelEstudioContrato> listNivelEstudioContratoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.NivelEstudioContrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.NivelEstudioContrato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.NivelEstudioContrato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.NivelEstudioContrato> listNivelEstudioContratoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.NivelEstudioContrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.NivelEstudioContrato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.NivelEstudioContrato
       * @return Iterator with all the com.infotec.eworkplace.swb.NivelEstudioContrato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.NivelEstudioContrato> listNivelEstudioContratoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.NivelEstudioContrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.NivelEstudioContrato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.NivelEstudioContrato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.NivelEstudioContrato> listNivelEstudioContratoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.NivelEstudioContrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static NivelEstudioContratoBase.ClassMgr getNivelEstudioContratoClassMgr()
    {
        return new NivelEstudioContratoBase.ClassMgr();
    }

   /**
   * Constructs a NivelEstudioContratoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the NivelEstudioContrato
   */
    public NivelEstudioContratoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
