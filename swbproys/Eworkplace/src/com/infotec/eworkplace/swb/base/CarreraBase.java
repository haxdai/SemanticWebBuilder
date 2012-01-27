package com.infotec.eworkplace.swb.base;


public abstract class CarreraBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");

    public static class ClassMgr
    {
       /**
       * Returns a list of Carrera for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Carrera> listCarreras(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Carrera>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Carrera for all models
       * @return Iterator of com.infotec.eworkplace.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Carrera> listCarreras()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Carrera>(it, true);
        }

        public static com.infotec.eworkplace.swb.Carrera createCarrera(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Carrera.ClassMgr.createCarrera(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Carrera
       * @param id Identifier for com.infotec.eworkplace.swb.Carrera
       * @param model Model of the com.infotec.eworkplace.swb.Carrera
       * @return A com.infotec.eworkplace.swb.Carrera
       */
        public static com.infotec.eworkplace.swb.Carrera getCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Carrera)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Carrera
       * @param id Identifier for com.infotec.eworkplace.swb.Carrera
       * @param model Model of the com.infotec.eworkplace.swb.Carrera
       * @return A com.infotec.eworkplace.swb.Carrera
       */
        public static com.infotec.eworkplace.swb.Carrera createCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Carrera)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Carrera
       * @param id Identifier for com.infotec.eworkplace.swb.Carrera
       * @param model Model of the com.infotec.eworkplace.swb.Carrera
       */
        public static void removeCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Carrera
       * @param id Identifier for com.infotec.eworkplace.swb.Carrera
       * @param model Model of the com.infotec.eworkplace.swb.Carrera
       * @return true if the com.infotec.eworkplace.swb.Carrera exists, false otherwise
       */

        public static boolean hasCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCarrera(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Carrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Carrera
       * @return Iterator with all the com.infotec.eworkplace.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Carrera> listCarreraByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Carrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Carrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Carrera> listCarreraByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Carrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Carrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Carrera
       * @return Iterator with all the com.infotec.eworkplace.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Carrera> listCarreraByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Carrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Carrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Carrera> listCarreraByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Carrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CarreraBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Carrera
   */
    public CarreraBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
