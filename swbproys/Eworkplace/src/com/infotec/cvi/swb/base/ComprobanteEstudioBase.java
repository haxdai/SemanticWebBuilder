package com.infotec.cvi.swb.base;


public abstract class ComprobanteEstudioBase extends com.infotec.cvi.swb.DocumentoProbatorio implements com.infotec.cvi.swb.Documento,org.semanticwb.model.Traceable,org.semanticwb.model.Iconable
{
    public static final org.semanticwb.platform.SemanticClass intranet_ComprobanteEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ComprobanteEstudio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ComprobanteEstudio");

    public static class ClassMgr
    {
       /**
       * Returns a list of ComprobanteEstudio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.ComprobanteEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteEstudio> listComprobanteEstudios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteEstudio>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.ComprobanteEstudio for all models
       * @return Iterator of com.infotec.cvi.swb.ComprobanteEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteEstudio> listComprobanteEstudios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteEstudio>(it, true);
        }

        public static com.infotec.cvi.swb.ComprobanteEstudio createComprobanteEstudio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.ComprobanteEstudio.ClassMgr.createComprobanteEstudio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.ComprobanteEstudio
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteEstudio
       * @param model Model of the com.infotec.cvi.swb.ComprobanteEstudio
       * @return A com.infotec.cvi.swb.ComprobanteEstudio
       */
        public static com.infotec.cvi.swb.ComprobanteEstudio getComprobanteEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ComprobanteEstudio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.ComprobanteEstudio
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteEstudio
       * @param model Model of the com.infotec.cvi.swb.ComprobanteEstudio
       * @return A com.infotec.cvi.swb.ComprobanteEstudio
       */
        public static com.infotec.cvi.swb.ComprobanteEstudio createComprobanteEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ComprobanteEstudio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.ComprobanteEstudio
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteEstudio
       * @param model Model of the com.infotec.cvi.swb.ComprobanteEstudio
       */
        public static void removeComprobanteEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.ComprobanteEstudio
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteEstudio
       * @param model Model of the com.infotec.cvi.swb.ComprobanteEstudio
       * @return true if the com.infotec.cvi.swb.ComprobanteEstudio exists, false otherwise
       */

        public static boolean hasComprobanteEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getComprobanteEstudio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ComprobanteEstudio
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteEstudio> listComprobanteEstudioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteEstudio> listComprobanteEstudioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ComprobanteEstudio
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteEstudio> listComprobanteEstudioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteEstudio> listComprobanteEstudioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ComprobanteEstudioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ComprobanteEstudio
   */
    public ComprobanteEstudioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
