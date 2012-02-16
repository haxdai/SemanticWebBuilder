package com.infotec.cvi.swb.base;


public abstract class AreaEstudioBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_AreaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaEstudio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaEstudio");

    public static class ClassMgr
    {
       /**
       * Returns a list of AreaEstudio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.AreaEstudio for all models
       * @return Iterator of com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio>(it, true);
        }

        public static com.infotec.cvi.swb.AreaEstudio createAreaEstudio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.AreaEstudio.ClassMgr.createAreaEstudio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return A com.infotec.cvi.swb.AreaEstudio
       */
        public static com.infotec.cvi.swb.AreaEstudio getAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaEstudio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return A com.infotec.cvi.swb.AreaEstudio
       */
        public static com.infotec.cvi.swb.AreaEstudio createAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaEstudio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       */
        public static void removeAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return true if the com.infotec.cvi.swb.AreaEstudio exists, false otherwise
       */

        public static boolean hasAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAreaEstudio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AreaEstudioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AreaEstudio
   */
    public AreaEstudioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
