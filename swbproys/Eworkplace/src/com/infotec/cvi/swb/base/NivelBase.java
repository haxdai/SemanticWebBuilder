package com.infotec.cvi.swb.base;


public abstract class NivelBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Nivel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Nivel");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Nivel");

    public static class ClassMgr
    {
       /**
       * Returns a list of Nivel for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Nivel
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Nivel> listNivels(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Nivel>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Nivel for all models
       * @return Iterator of com.infotec.cvi.swb.Nivel
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Nivel> listNivels()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Nivel>(it, true);
        }
       /**
       * Gets a com.infotec.cvi.swb.Nivel
       * @param id Identifier for com.infotec.cvi.swb.Nivel
       * @param model Model of the com.infotec.cvi.swb.Nivel
       * @return A com.infotec.cvi.swb.Nivel
       */
        public static com.infotec.cvi.swb.Nivel getNivel(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Nivel)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Nivel
       * @param id Identifier for com.infotec.cvi.swb.Nivel
       * @param model Model of the com.infotec.cvi.swb.Nivel
       * @return A com.infotec.cvi.swb.Nivel
       */
        public static com.infotec.cvi.swb.Nivel createNivel(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Nivel)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Nivel
       * @param id Identifier for com.infotec.cvi.swb.Nivel
       * @param model Model of the com.infotec.cvi.swb.Nivel
       */
        public static void removeNivel(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Nivel
       * @param id Identifier for com.infotec.cvi.swb.Nivel
       * @param model Model of the com.infotec.cvi.swb.Nivel
       * @return true if the com.infotec.cvi.swb.Nivel exists, false otherwise
       */

        public static boolean hasNivel(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNivel(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Nivel with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Nivel
       * @return Iterator with all the com.infotec.cvi.swb.Nivel
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Nivel> listNivelByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Nivel> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Nivel with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Nivel
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Nivel> listNivelByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Nivel> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Nivel with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Nivel
       * @return Iterator with all the com.infotec.cvi.swb.Nivel
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Nivel> listNivelByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Nivel> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Nivel with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Nivel
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Nivel> listNivelByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Nivel> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a NivelBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Nivel
   */
    public NivelBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
