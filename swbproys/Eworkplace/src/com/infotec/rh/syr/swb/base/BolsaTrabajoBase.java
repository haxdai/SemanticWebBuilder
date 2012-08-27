package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula las propiedades de una bolsa de trabajo para publicación de vacantes 
   */
public abstract class BolsaTrabajoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Encapsula las propiedades de una bolsa de trabajo para publicación de vacantes
   */
    public static final org.semanticwb.platform.SemanticClass intranet_BolsaTrabajo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#BolsaTrabajo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#BolsaTrabajo");

    public static class ClassMgr
    {
       /**
       * Returns a list of BolsaTrabajo for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.BolsaTrabajo
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.BolsaTrabajo> listBolsaTrabajos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.BolsaTrabajo>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.BolsaTrabajo for all models
       * @return Iterator of com.infotec.rh.syr.swb.BolsaTrabajo
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.BolsaTrabajo> listBolsaTrabajos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.BolsaTrabajo>(it, true);
        }

        public static com.infotec.rh.syr.swb.BolsaTrabajo createBolsaTrabajo(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.BolsaTrabajo.ClassMgr.createBolsaTrabajo(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.BolsaTrabajo
       * @param id Identifier for com.infotec.rh.syr.swb.BolsaTrabajo
       * @param model Model of the com.infotec.rh.syr.swb.BolsaTrabajo
       * @return A com.infotec.rh.syr.swb.BolsaTrabajo
       */
        public static com.infotec.rh.syr.swb.BolsaTrabajo getBolsaTrabajo(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.BolsaTrabajo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.BolsaTrabajo
       * @param id Identifier for com.infotec.rh.syr.swb.BolsaTrabajo
       * @param model Model of the com.infotec.rh.syr.swb.BolsaTrabajo
       * @return A com.infotec.rh.syr.swb.BolsaTrabajo
       */
        public static com.infotec.rh.syr.swb.BolsaTrabajo createBolsaTrabajo(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.BolsaTrabajo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.BolsaTrabajo
       * @param id Identifier for com.infotec.rh.syr.swb.BolsaTrabajo
       * @param model Model of the com.infotec.rh.syr.swb.BolsaTrabajo
       */
        public static void removeBolsaTrabajo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.BolsaTrabajo
       * @param id Identifier for com.infotec.rh.syr.swb.BolsaTrabajo
       * @param model Model of the com.infotec.rh.syr.swb.BolsaTrabajo
       * @return true if the com.infotec.rh.syr.swb.BolsaTrabajo exists, false otherwise
       */

        public static boolean hasBolsaTrabajo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBolsaTrabajo(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.BolsaTrabajo with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.BolsaTrabajo
       * @return Iterator with all the com.infotec.rh.syr.swb.BolsaTrabajo
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.BolsaTrabajo> listBolsaTrabajoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.BolsaTrabajo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.BolsaTrabajo with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.BolsaTrabajo
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.BolsaTrabajo> listBolsaTrabajoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.BolsaTrabajo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.BolsaTrabajo with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.BolsaTrabajo
       * @return Iterator with all the com.infotec.rh.syr.swb.BolsaTrabajo
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.BolsaTrabajo> listBolsaTrabajoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.BolsaTrabajo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.BolsaTrabajo with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.BolsaTrabajo
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.BolsaTrabajo> listBolsaTrabajoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.BolsaTrabajo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a BolsaTrabajoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BolsaTrabajo
   */
    public BolsaTrabajoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
