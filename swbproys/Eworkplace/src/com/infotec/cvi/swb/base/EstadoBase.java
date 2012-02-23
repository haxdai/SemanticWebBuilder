package com.infotec.cvi.swb.base;


public abstract class EstadoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Estado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Estado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estado> listEstados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estado>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Estado for all models
       * @return Iterator of com.infotec.cvi.swb.Estado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estado> listEstados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estado>(it, true);
        }
       /**
       * Gets a com.infotec.cvi.swb.Estado
       * @param id Identifier for com.infotec.cvi.swb.Estado
       * @param model Model of the com.infotec.cvi.swb.Estado
       * @return A com.infotec.cvi.swb.Estado
       */
        public static com.infotec.cvi.swb.Estado getEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Estado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Estado
       * @param id Identifier for com.infotec.cvi.swb.Estado
       * @param model Model of the com.infotec.cvi.swb.Estado
       * @return A com.infotec.cvi.swb.Estado
       */
        public static com.infotec.cvi.swb.Estado createEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Estado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Estado
       * @param id Identifier for com.infotec.cvi.swb.Estado
       * @param model Model of the com.infotec.cvi.swb.Estado
       */
        public static void removeEstado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Estado
       * @param id Identifier for com.infotec.cvi.swb.Estado
       * @param model Model of the com.infotec.cvi.swb.Estado
       * @return true if the com.infotec.cvi.swb.Estado exists, false otherwise
       */

        public static boolean hasEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEstado(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Estado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Estado
       * @return Iterator with all the com.infotec.cvi.swb.Estado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estado> listEstadoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Estado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estado> listEstadoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Estado
       * @return Iterator with all the com.infotec.cvi.swb.Estado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estado> listEstadoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Estado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estado> listEstadoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EstadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Estado
   */
    public EstadoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
