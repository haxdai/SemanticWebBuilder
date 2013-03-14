package com.infotec.cvi.swb.base;


public abstract class PeriodoPagosBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Sortable
{
    public static final org.semanticwb.platform.SemanticClass intranet_PeriodoPagos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PeriodoPagos");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PeriodoPagos");

    public static class ClassMgr
    {
       /**
       * Returns a list of PeriodoPagos for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.PeriodoPagos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.PeriodoPagos> listPeriodoPagoses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.PeriodoPagos>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.PeriodoPagos for all models
       * @return Iterator of com.infotec.cvi.swb.PeriodoPagos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.PeriodoPagos> listPeriodoPagoses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.PeriodoPagos>(it, true);
        }

        public static com.infotec.cvi.swb.PeriodoPagos createPeriodoPagos(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.PeriodoPagos.ClassMgr.createPeriodoPagos(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.PeriodoPagos
       * @param id Identifier for com.infotec.cvi.swb.PeriodoPagos
       * @param model Model of the com.infotec.cvi.swb.PeriodoPagos
       * @return A com.infotec.cvi.swb.PeriodoPagos
       */
        public static com.infotec.cvi.swb.PeriodoPagos getPeriodoPagos(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.PeriodoPagos)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.PeriodoPagos
       * @param id Identifier for com.infotec.cvi.swb.PeriodoPagos
       * @param model Model of the com.infotec.cvi.swb.PeriodoPagos
       * @return A com.infotec.cvi.swb.PeriodoPagos
       */
        public static com.infotec.cvi.swb.PeriodoPagos createPeriodoPagos(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.PeriodoPagos)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.PeriodoPagos
       * @param id Identifier for com.infotec.cvi.swb.PeriodoPagos
       * @param model Model of the com.infotec.cvi.swb.PeriodoPagos
       */
        public static void removePeriodoPagos(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.PeriodoPagos
       * @param id Identifier for com.infotec.cvi.swb.PeriodoPagos
       * @param model Model of the com.infotec.cvi.swb.PeriodoPagos
       * @return true if the com.infotec.cvi.swb.PeriodoPagos exists, false otherwise
       */

        public static boolean hasPeriodoPagos(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPeriodoPagos(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.PeriodoPagos with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.PeriodoPagos
       * @return Iterator with all the com.infotec.cvi.swb.PeriodoPagos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.PeriodoPagos> listPeriodoPagosByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.PeriodoPagos> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.PeriodoPagos with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.PeriodoPagos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.PeriodoPagos> listPeriodoPagosByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.PeriodoPagos> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.PeriodoPagos with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.PeriodoPagos
       * @return Iterator with all the com.infotec.cvi.swb.PeriodoPagos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.PeriodoPagos> listPeriodoPagosByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.PeriodoPagos> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.PeriodoPagos with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.PeriodoPagos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.PeriodoPagos> listPeriodoPagosByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.PeriodoPagos> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PeriodoPagosBase.ClassMgr getPeriodoPagosClassMgr()
    {
        return new PeriodoPagosBase.ClassMgr();
    }

   /**
   * Constructs a PeriodoPagosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PeriodoPagos
   */
    public PeriodoPagosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        return getSemanticObject().getIntProperty(swb_index);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(swb_index, value);
    }
}
