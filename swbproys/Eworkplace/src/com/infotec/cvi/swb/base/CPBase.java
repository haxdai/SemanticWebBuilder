package com.infotec.cvi.swb.base;


public abstract class CPBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_CP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CP");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CP");

    public static class ClassMgr
    {
       /**
       * Returns a list of CP for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.CP for all models
       * @return Iterator of com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP>(it, true);
        }

        public static com.infotec.cvi.swb.CP createCP(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.CP.ClassMgr.createCP(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return A com.infotec.cvi.swb.CP
       */
        public static com.infotec.cvi.swb.CP getCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CP)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return A com.infotec.cvi.swb.CP
       */
        public static com.infotec.cvi.swb.CP createCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CP)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       */
        public static void removeCP(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return true if the com.infotec.cvi.swb.CP exists, false otherwise
       */

        public static boolean hasCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCP(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CPBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CP
   */
    public CPBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
