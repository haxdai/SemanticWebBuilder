package com.infotec.cvi.swb.base;


public abstract class AreaCarreraBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_AreaCarrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaCarrera");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaCarrera");

    public static class ClassMgr
    {
       /**
       * Returns a list of AreaCarrera for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreras(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.AreaCarrera for all models
       * @return Iterator of com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreras()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera>(it, true);
        }

        public static com.infotec.cvi.swb.AreaCarrera createAreaCarrera(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.AreaCarrera.ClassMgr.createAreaCarrera(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return A com.infotec.cvi.swb.AreaCarrera
       */
        public static com.infotec.cvi.swb.AreaCarrera getAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaCarrera)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return A com.infotec.cvi.swb.AreaCarrera
       */
        public static com.infotec.cvi.swb.AreaCarrera createAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaCarrera)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       */
        public static void removeAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return true if the com.infotec.cvi.swb.AreaCarrera exists, false otherwise
       */

        public static boolean hasAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAreaCarrera(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AreaCarreraBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AreaCarrera
   */
    public AreaCarreraBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
