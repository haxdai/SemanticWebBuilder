package com.infotec.cvi.swb.base;


public abstract class ColoniaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Colonia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Colonia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Colonia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Colonia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Colonia> listColonias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Colonia for all models
       * @return Iterator of com.infotec.cvi.swb.Colonia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Colonia> listColonias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia>(it, true);
        }

        public static com.infotec.cvi.swb.Colonia createColonia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Colonia.ClassMgr.createColonia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Colonia
       * @param id Identifier for com.infotec.cvi.swb.Colonia
       * @param model Model of the com.infotec.cvi.swb.Colonia
       * @return A com.infotec.cvi.swb.Colonia
       */
        public static com.infotec.cvi.swb.Colonia getColonia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Colonia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Colonia
       * @param id Identifier for com.infotec.cvi.swb.Colonia
       * @param model Model of the com.infotec.cvi.swb.Colonia
       * @return A com.infotec.cvi.swb.Colonia
       */
        public static com.infotec.cvi.swb.Colonia createColonia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Colonia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Colonia
       * @param id Identifier for com.infotec.cvi.swb.Colonia
       * @param model Model of the com.infotec.cvi.swb.Colonia
       */
        public static void removeColonia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Colonia
       * @param id Identifier for com.infotec.cvi.swb.Colonia
       * @param model Model of the com.infotec.cvi.swb.Colonia
       * @return true if the com.infotec.cvi.swb.Colonia exists, false otherwise
       */

        public static boolean hasColonia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getColonia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Colonia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Colonia
       * @return Iterator with all the com.infotec.cvi.swb.Colonia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Colonia> listColoniaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Colonia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Colonia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Colonia> listColoniaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Colonia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Colonia
       * @return Iterator with all the com.infotec.cvi.swb.Colonia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Colonia> listColoniaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Colonia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Colonia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Colonia> listColoniaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ColoniaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Colonia
   */
    public ColoniaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
