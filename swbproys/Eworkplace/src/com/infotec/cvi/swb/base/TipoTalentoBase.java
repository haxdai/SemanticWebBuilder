package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para almacenar los tipos de talentos utilizados en Habilidades 
   */
public abstract class TipoTalentoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para almacenar los tipos de talentos utilizados en Habilidades
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoTalento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoTalento");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoTalento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.TipoTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoTalento> listTipoTalentos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoTalento>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.TipoTalento for all models
       * @return Iterator of com.infotec.cvi.swb.TipoTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoTalento> listTipoTalentos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoTalento>(it, true);
        }

        public static com.infotec.cvi.swb.TipoTalento createTipoTalento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.TipoTalento.ClassMgr.createTipoTalento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.TipoTalento
       * @param id Identifier for com.infotec.cvi.swb.TipoTalento
       * @param model Model of the com.infotec.cvi.swb.TipoTalento
       * @return A com.infotec.cvi.swb.TipoTalento
       */
        public static com.infotec.cvi.swb.TipoTalento getTipoTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoTalento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.TipoTalento
       * @param id Identifier for com.infotec.cvi.swb.TipoTalento
       * @param model Model of the com.infotec.cvi.swb.TipoTalento
       * @return A com.infotec.cvi.swb.TipoTalento
       */
        public static com.infotec.cvi.swb.TipoTalento createTipoTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoTalento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.TipoTalento
       * @param id Identifier for com.infotec.cvi.swb.TipoTalento
       * @param model Model of the com.infotec.cvi.swb.TipoTalento
       */
        public static void removeTipoTalento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.TipoTalento
       * @param id Identifier for com.infotec.cvi.swb.TipoTalento
       * @param model Model of the com.infotec.cvi.swb.TipoTalento
       * @return true if the com.infotec.cvi.swb.TipoTalento exists, false otherwise
       */

        public static boolean hasTipoTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoTalento(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoTalento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoTalento
       * @return Iterator with all the com.infotec.cvi.swb.TipoTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoTalento> listTipoTalentoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoTalento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoTalento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoTalento> listTipoTalentoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoTalento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoTalento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoTalento
       * @return Iterator with all the com.infotec.cvi.swb.TipoTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoTalento> listTipoTalentoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoTalento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoTalento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoTalento> listTipoTalentoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoTalento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TipoTalentoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoTalento
   */
    public TipoTalentoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
