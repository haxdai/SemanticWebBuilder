package com.infotec.eworkplace.swb.base;


public abstract class InfotecBase extends org.semanticwb.model.UserGroup implements org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Filterable,org.semanticwb.model.FilterableClass
{
    public static final org.semanticwb.platform.SemanticClass intranet_Infotec=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Infotec");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Infotec");

    public static class ClassMgr
    {
       /**
       * Returns a list of Infotec for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Infotec for all models
       * @return Iterator of com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec>(it, true);
        }

        public static com.infotec.eworkplace.swb.Infotec createInfotec(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Infotec.ClassMgr.createInfotec(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Infotec
       * @param id Identifier for com.infotec.eworkplace.swb.Infotec
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return A com.infotec.eworkplace.swb.Infotec
       */
        public static com.infotec.eworkplace.swb.Infotec getInfotec(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Infotec)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Infotec
       * @param id Identifier for com.infotec.eworkplace.swb.Infotec
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return A com.infotec.eworkplace.swb.Infotec
       */
        public static com.infotec.eworkplace.swb.Infotec createInfotec(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Infotec)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Infotec
       * @param id Identifier for com.infotec.eworkplace.swb.Infotec
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       */
        public static void removeInfotec(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Infotec
       * @param id Identifier for com.infotec.eworkplace.swb.Infotec
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return true if the com.infotec.eworkplace.swb.Infotec exists, false otherwise
       */

        public static boolean hasInfotec(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInfotec(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined Child
       * @param value Child of the type org.semanticwb.model.UserGroup
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByChild(org.semanticwb.model.UserGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUsrGrpChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined Child
       * @param value Child of the type org.semanticwb.model.UserGroup
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByChild(org.semanticwb.model.UserGroup value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUsrGrpChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined Parent
       * @param value Parent of the type org.semanticwb.model.UserGroup
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByParent(org.semanticwb.model.UserGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_usrgrpParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined Parent
       * @param value Parent of the type org.semanticwb.model.UserGroup
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByParent(org.semanticwb.model.UserGroup value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_usrgrpParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined User
       * @param value User of the type org.semanticwb.model.UserGroupable
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByUser(org.semanticwb.model.UserGroupable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasGroupedUser, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined User
       * @param value User of the type org.semanticwb.model.UserGroupable
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByUser(org.semanticwb.model.UserGroupable value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasGroupedUser,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Infotec
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Infotec with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Infotec
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Infotec> listInfotecByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Infotec> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a InfotecBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Infotec
   */
    public InfotecBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
