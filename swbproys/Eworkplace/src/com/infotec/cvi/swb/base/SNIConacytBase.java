package com.infotec.cvi.swb.base;


public abstract class SNIConacytBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_SNIConacyt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SNIConacyt");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SNIConacyt");

    public static class ClassMgr
    {
       /**
       * Returns a list of SNIConacyt for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.SNIConacyt
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SNIConacyt> listSNIConacyts(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SNIConacyt>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.SNIConacyt for all models
       * @return Iterator of com.infotec.cvi.swb.SNIConacyt
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SNIConacyt> listSNIConacyts()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SNIConacyt>(it, true);
        }

        public static com.infotec.cvi.swb.SNIConacyt createSNIConacyt(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.SNIConacyt.ClassMgr.createSNIConacyt(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.SNIConacyt
       * @param id Identifier for com.infotec.cvi.swb.SNIConacyt
       * @param model Model of the com.infotec.cvi.swb.SNIConacyt
       * @return A com.infotec.cvi.swb.SNIConacyt
       */
        public static com.infotec.cvi.swb.SNIConacyt getSNIConacyt(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.SNIConacyt)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.SNIConacyt
       * @param id Identifier for com.infotec.cvi.swb.SNIConacyt
       * @param model Model of the com.infotec.cvi.swb.SNIConacyt
       * @return A com.infotec.cvi.swb.SNIConacyt
       */
        public static com.infotec.cvi.swb.SNIConacyt createSNIConacyt(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.SNIConacyt)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.SNIConacyt
       * @param id Identifier for com.infotec.cvi.swb.SNIConacyt
       * @param model Model of the com.infotec.cvi.swb.SNIConacyt
       */
        public static void removeSNIConacyt(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.SNIConacyt
       * @param id Identifier for com.infotec.cvi.swb.SNIConacyt
       * @param model Model of the com.infotec.cvi.swb.SNIConacyt
       * @return true if the com.infotec.cvi.swb.SNIConacyt exists, false otherwise
       */

        public static boolean hasSNIConacyt(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSNIConacyt(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.SNIConacyt with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SNIConacyt
       * @return Iterator with all the com.infotec.cvi.swb.SNIConacyt
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SNIConacyt> listSNIConacytByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SNIConacyt> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SNIConacyt with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SNIConacyt
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SNIConacyt> listSNIConacytByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SNIConacyt> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SNIConacyt with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SNIConacyt
       * @return Iterator with all the com.infotec.cvi.swb.SNIConacyt
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SNIConacyt> listSNIConacytByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SNIConacyt> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SNIConacyt with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SNIConacyt
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SNIConacyt> listSNIConacytByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SNIConacyt> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SNIConacytBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SNIConacyt
   */
    public SNIConacytBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
