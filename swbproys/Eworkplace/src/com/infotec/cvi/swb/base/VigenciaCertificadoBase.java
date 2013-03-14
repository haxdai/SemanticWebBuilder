package com.infotec.cvi.swb.base;


   /**
   * Catálogo  utilizado para almacenar las diferentes vigencias de certificado. 
   */
public abstract class VigenciaCertificadoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo  utilizado para almacenar las diferentes vigencias de certificado.
   */
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
       * @return Iterator of com.infotec.cvi.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.VigenciaCertificado> listVigenciaCertificados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.VigenciaCertificado>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.VigenciaCertificado for all models
       * @return Iterator of com.infotec.cvi.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.VigenciaCertificado> listVigenciaCertificados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.VigenciaCertificado>(it, true);
        }
       /**
       * Gets a com.infotec.cvi.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.cvi.swb.VigenciaCertificado
       * @param model Model of the com.infotec.cvi.swb.VigenciaCertificado
       * @return A com.infotec.cvi.swb.VigenciaCertificado
       */
        public static com.infotec.cvi.swb.VigenciaCertificado getVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.VigenciaCertificado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.cvi.swb.VigenciaCertificado
       * @param model Model of the com.infotec.cvi.swb.VigenciaCertificado
       * @return A com.infotec.cvi.swb.VigenciaCertificado
       */
        public static com.infotec.cvi.swb.VigenciaCertificado createVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.VigenciaCertificado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.cvi.swb.VigenciaCertificado
       * @param model Model of the com.infotec.cvi.swb.VigenciaCertificado
       */
        public static void removeVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.VigenciaCertificado
       * @param id Identifier for com.infotec.cvi.swb.VigenciaCertificado
       * @param model Model of the com.infotec.cvi.swb.VigenciaCertificado
       * @return true if the com.infotec.cvi.swb.VigenciaCertificado exists, false otherwise
       */

        public static boolean hasVigenciaCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVigenciaCertificado(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.VigenciaCertificado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.cvi.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.VigenciaCertificado> listVigenciaCertificadoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.VigenciaCertificado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.VigenciaCertificado> listVigenciaCertificadoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.VigenciaCertificado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.cvi.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.VigenciaCertificado> listVigenciaCertificadoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.VigenciaCertificado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.VigenciaCertificado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.VigenciaCertificado> listVigenciaCertificadoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.VigenciaCertificado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static VigenciaCertificadoBase.ClassMgr getVigenciaCertificadoClassMgr()
    {
        return new VigenciaCertificadoBase.ClassMgr();
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
