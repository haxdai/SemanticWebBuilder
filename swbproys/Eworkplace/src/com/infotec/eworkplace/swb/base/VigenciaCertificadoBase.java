package com.infotec.eworkplace.swb.base;


public abstract class VigenciaCertificadoBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_VigenciaCertificado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#VigenciaCertificado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#VigenciaCertificado");

    public static class ClassMgr
    {
       /**
       * Returns a list of VigenciaCertificado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.VigenciaCertificado> listVigenciaCertificados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.VigenciaCertificado>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.VigenciaCertificado for all models
       * @return Iterator of com.infotec.eworkplace.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.VigenciaCertificado> listVigenciaCertificados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.VigenciaCertificado>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.VigenciaCertificado
       * @return A com.infotec.eworkplace.swb.VigenciaCertificado
       */
        public static com.infotec.eworkplace.swb.VigenciaCertificado getVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.VigenciaCertificado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.VigenciaCertificado
       * @return A com.infotec.eworkplace.swb.VigenciaCertificado
       */
        public static com.infotec.eworkplace.swb.VigenciaCertificado createVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.VigenciaCertificado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.VigenciaCertificado
       */
        public static void removeVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.VigenciaCertificado
       * @return true if the com.infotec.eworkplace.swb.VigenciaCertificado exists, false otherwise
       */

        public static boolean hasVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVigenciaCertificado(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.VigenciaCertificado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.eworkplace.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.VigenciaCertificado> listVigenciaCertificadoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.VigenciaCertificado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.VigenciaCertificado> listVigenciaCertificadoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.VigenciaCertificado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.eworkplace.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.VigenciaCertificado> listVigenciaCertificadoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.VigenciaCertificado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.VigenciaCertificado> listVigenciaCertificadoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a VigenciaCertificadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the VigenciaCertificado
   */
    public VigenciaCertificadoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
