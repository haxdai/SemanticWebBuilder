package com.infotec.rh.syr.swb.base;


public abstract class TipoBajaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_TipoBaja=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoBaja");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoBaja");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoBaja for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.TipoBaja
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.TipoBaja> listTipoBajas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.TipoBaja>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.TipoBaja for all models
       * @return Iterator of com.infotec.rh.syr.swb.TipoBaja
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.TipoBaja> listTipoBajas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.TipoBaja>(it, true);
        }

        public static com.infotec.rh.syr.swb.TipoBaja createTipoBaja(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.TipoBaja.ClassMgr.createTipoBaja(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.TipoBaja
       * @param id Identifier for com.infotec.rh.syr.swb.TipoBaja
       * @param model Model of the com.infotec.rh.syr.swb.TipoBaja
       * @return A com.infotec.rh.syr.swb.TipoBaja
       */
        public static com.infotec.rh.syr.swb.TipoBaja getTipoBaja(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.TipoBaja)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.TipoBaja
       * @param id Identifier for com.infotec.rh.syr.swb.TipoBaja
       * @param model Model of the com.infotec.rh.syr.swb.TipoBaja
       * @return A com.infotec.rh.syr.swb.TipoBaja
       */
        public static com.infotec.rh.syr.swb.TipoBaja createTipoBaja(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.TipoBaja)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.TipoBaja
       * @param id Identifier for com.infotec.rh.syr.swb.TipoBaja
       * @param model Model of the com.infotec.rh.syr.swb.TipoBaja
       */
        public static void removeTipoBaja(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.TipoBaja
       * @param id Identifier for com.infotec.rh.syr.swb.TipoBaja
       * @param model Model of the com.infotec.rh.syr.swb.TipoBaja
       * @return true if the com.infotec.rh.syr.swb.TipoBaja exists, false otherwise
       */

        public static boolean hasTipoBaja(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoBaja(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.TipoBaja with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.TipoBaja
       * @return Iterator with all the com.infotec.rh.syr.swb.TipoBaja
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.TipoBaja> listTipoBajaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.TipoBaja> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.TipoBaja with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.TipoBaja
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.TipoBaja> listTipoBajaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.TipoBaja> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.TipoBaja with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.TipoBaja
       * @return Iterator with all the com.infotec.rh.syr.swb.TipoBaja
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.TipoBaja> listTipoBajaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.TipoBaja> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.TipoBaja with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.TipoBaja
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.TipoBaja> listTipoBajaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.TipoBaja> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TipoBajaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoBaja
   */
    public TipoBajaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
