package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para Desarrollo de Software 
   */
public abstract class DesarrolloSWBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para Desarrollo de Software
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DesarrolloSW=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DesarrolloSW");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DesarrolloSW");

    public static class ClassMgr
    {
       /**
       * Returns a list of DesarrolloSW for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.DesarrolloSW
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DesarrolloSW> listDesarrolloSWs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DesarrolloSW>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.DesarrolloSW for all models
       * @return Iterator of com.infotec.cvi.swb.DesarrolloSW
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DesarrolloSW> listDesarrolloSWs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DesarrolloSW>(it, true);
        }

        public static com.infotec.cvi.swb.DesarrolloSW createDesarrolloSW(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.DesarrolloSW.ClassMgr.createDesarrolloSW(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.DesarrolloSW
       * @param id Identifier for com.infotec.cvi.swb.DesarrolloSW
       * @param model Model of the com.infotec.cvi.swb.DesarrolloSW
       * @return A com.infotec.cvi.swb.DesarrolloSW
       */
        public static com.infotec.cvi.swb.DesarrolloSW getDesarrolloSW(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.DesarrolloSW)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.DesarrolloSW
       * @param id Identifier for com.infotec.cvi.swb.DesarrolloSW
       * @param model Model of the com.infotec.cvi.swb.DesarrolloSW
       * @return A com.infotec.cvi.swb.DesarrolloSW
       */
        public static com.infotec.cvi.swb.DesarrolloSW createDesarrolloSW(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.DesarrolloSW)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.DesarrolloSW
       * @param id Identifier for com.infotec.cvi.swb.DesarrolloSW
       * @param model Model of the com.infotec.cvi.swb.DesarrolloSW
       */
        public static void removeDesarrolloSW(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.DesarrolloSW
       * @param id Identifier for com.infotec.cvi.swb.DesarrolloSW
       * @param model Model of the com.infotec.cvi.swb.DesarrolloSW
       * @return true if the com.infotec.cvi.swb.DesarrolloSW exists, false otherwise
       */

        public static boolean hasDesarrolloSW(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDesarrolloSW(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.DesarrolloSW with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.DesarrolloSW
       * @return Iterator with all the com.infotec.cvi.swb.DesarrolloSW
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DesarrolloSW> listDesarrolloSWByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DesarrolloSW> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DesarrolloSW with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.DesarrolloSW
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DesarrolloSW> listDesarrolloSWByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DesarrolloSW> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DesarrolloSW with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.DesarrolloSW
       * @return Iterator with all the com.infotec.cvi.swb.DesarrolloSW
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DesarrolloSW> listDesarrolloSWByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DesarrolloSW> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DesarrolloSW with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.DesarrolloSW
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DesarrolloSW> listDesarrolloSWByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DesarrolloSW> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DesarrolloSWBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DesarrolloSW
   */
    public DesarrolloSWBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
