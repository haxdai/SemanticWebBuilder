package com.infotec.rh.syr.swb.base;


public abstract class CentroCostoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_titularArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#titularArea");
    public static final org.semanticwb.platform.SemanticProperty intranet_numeroArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numeroArea");
    public static final org.semanticwb.platform.SemanticClass intranet_CentroCosto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CentroCosto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CentroCosto");

    public static class ClassMgr
    {
       /**
       * Returns a list of CentroCosto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.CentroCosto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CentroCosto> listCentroCostos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CentroCosto>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.CentroCosto for all models
       * @return Iterator of com.infotec.rh.syr.swb.CentroCosto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CentroCosto> listCentroCostos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CentroCosto>(it, true);
        }

        public static com.infotec.rh.syr.swb.CentroCosto createCentroCosto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.CentroCosto.ClassMgr.createCentroCosto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.CentroCosto
       * @param id Identifier for com.infotec.rh.syr.swb.CentroCosto
       * @param model Model of the com.infotec.rh.syr.swb.CentroCosto
       * @return A com.infotec.rh.syr.swb.CentroCosto
       */
        public static com.infotec.rh.syr.swb.CentroCosto getCentroCosto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.CentroCosto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.CentroCosto
       * @param id Identifier for com.infotec.rh.syr.swb.CentroCosto
       * @param model Model of the com.infotec.rh.syr.swb.CentroCosto
       * @return A com.infotec.rh.syr.swb.CentroCosto
       */
        public static com.infotec.rh.syr.swb.CentroCosto createCentroCosto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.CentroCosto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.CentroCosto
       * @param id Identifier for com.infotec.rh.syr.swb.CentroCosto
       * @param model Model of the com.infotec.rh.syr.swb.CentroCosto
       */
        public static void removeCentroCosto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.CentroCosto
       * @param id Identifier for com.infotec.rh.syr.swb.CentroCosto
       * @param model Model of the com.infotec.rh.syr.swb.CentroCosto
       * @return true if the com.infotec.rh.syr.swb.CentroCosto exists, false otherwise
       */

        public static boolean hasCentroCosto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCentroCosto(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CentroCosto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.CentroCosto
       * @return Iterator with all the com.infotec.rh.syr.swb.CentroCosto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CentroCosto> listCentroCostoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CentroCosto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CentroCosto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.CentroCosto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CentroCosto> listCentroCostoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CentroCosto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CentroCosto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.CentroCosto
       * @return Iterator with all the com.infotec.rh.syr.swb.CentroCosto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CentroCosto> listCentroCostoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CentroCosto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CentroCosto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.CentroCosto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CentroCosto> listCentroCostoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CentroCosto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CentroCostoBase.ClassMgr getCentroCostoClassMgr()
    {
        return new CentroCostoBase.ClassMgr();
    }

   /**
   * Constructs a CentroCostoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CentroCosto
   */
    public CentroCostoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the TitularArea property
* @return String with the TitularArea
*/
    public String getTitularArea()
    {
        return getSemanticObject().getProperty(intranet_titularArea);
    }

/**
* Sets the TitularArea property
* @param value long with the TitularArea
*/
    public void setTitularArea(String value)
    {
        getSemanticObject().setProperty(intranet_titularArea, value);
    }

/**
* Gets the NumeroArea property
* @return String with the NumeroArea
*/
    public String getNumeroArea()
    {
        return getSemanticObject().getProperty(intranet_numeroArea);
    }

/**
* Sets the NumeroArea property
* @param value long with the NumeroArea
*/
    public void setNumeroArea(String value)
    {
        getSemanticObject().setProperty(intranet_numeroArea, value);
    }
}
