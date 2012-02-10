package com.infotec.cvi.swb.base;


public abstract class IdiomasBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Idiomas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idiomas");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idiomas");

    public static class ClassMgr
    {
       /**
       * Returns a list of Idiomas for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Idiomas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Idiomas> listIdiomases(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idiomas>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Idiomas for all models
       * @return Iterator of com.infotec.cvi.swb.Idiomas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Idiomas> listIdiomases()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idiomas>(it, true);
        }

        public static com.infotec.cvi.swb.Idiomas createIdiomas(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Idiomas.ClassMgr.createIdiomas(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Idiomas
       * @param id Identifier for com.infotec.cvi.swb.Idiomas
       * @param model Model of the com.infotec.cvi.swb.Idiomas
       * @return A com.infotec.cvi.swb.Idiomas
       */
        public static com.infotec.cvi.swb.Idiomas getIdiomas(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Idiomas)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Idiomas
       * @param id Identifier for com.infotec.cvi.swb.Idiomas
       * @param model Model of the com.infotec.cvi.swb.Idiomas
       * @return A com.infotec.cvi.swb.Idiomas
       */
        public static com.infotec.cvi.swb.Idiomas createIdiomas(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Idiomas)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Idiomas
       * @param id Identifier for com.infotec.cvi.swb.Idiomas
       * @param model Model of the com.infotec.cvi.swb.Idiomas
       */
        public static void removeIdiomas(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Idiomas
       * @param id Identifier for com.infotec.cvi.swb.Idiomas
       * @param model Model of the com.infotec.cvi.swb.Idiomas
       * @return true if the com.infotec.cvi.swb.Idiomas exists, false otherwise
       */

        public static boolean hasIdiomas(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIdiomas(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Idiomas with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Idiomas
       * @return Iterator with all the com.infotec.cvi.swb.Idiomas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Idiomas> listIdiomasByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idiomas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Idiomas with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Idiomas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Idiomas> listIdiomasByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idiomas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Idiomas with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Idiomas
       * @return Iterator with all the com.infotec.cvi.swb.Idiomas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Idiomas> listIdiomasByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idiomas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Idiomas with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Idiomas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Idiomas> listIdiomasByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idiomas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a IdiomasBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Idiomas
   */
    public IdiomasBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
