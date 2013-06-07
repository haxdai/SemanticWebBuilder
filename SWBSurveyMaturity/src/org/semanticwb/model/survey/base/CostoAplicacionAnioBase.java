package org.semanticwb.model.survey.base;


public abstract class CostoAplicacionAnioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_anio_costo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#anio_costo");
    public static final org.semanticwb.platform.SemanticProperty cts_costoapp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#costoapp");
    public static final org.semanticwb.platform.SemanticClass cts_CostoAplicacionAnio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoAplicacionAnio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoAplicacionAnio");

    public static class ClassMgr
    {
       /**
       * Returns a list of CostoAplicacionAnio for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.CostoAplicacionAnio
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacionAnio> listCostoAplicacionAnios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacionAnio>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.CostoAplicacionAnio for all models
       * @return Iterator of org.semanticwb.model.survey.CostoAplicacionAnio
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacionAnio> listCostoAplicacionAnios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacionAnio>(it, true);
        }

        public static org.semanticwb.model.survey.CostoAplicacionAnio createCostoAplicacionAnio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.CostoAplicacionAnio.ClassMgr.createCostoAplicacionAnio(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.CostoAplicacionAnio
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacionAnio
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacionAnio
       * @return A org.semanticwb.model.survey.CostoAplicacionAnio
       */
        public static org.semanticwb.model.survey.CostoAplicacionAnio getCostoAplicacionAnio(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoAplicacionAnio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.CostoAplicacionAnio
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacionAnio
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacionAnio
       * @return A org.semanticwb.model.survey.CostoAplicacionAnio
       */
        public static org.semanticwb.model.survey.CostoAplicacionAnio createCostoAplicacionAnio(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoAplicacionAnio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.CostoAplicacionAnio
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacionAnio
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacionAnio
       */
        public static void removeCostoAplicacionAnio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.CostoAplicacionAnio
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacionAnio
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacionAnio
       * @return true if the org.semanticwb.model.survey.CostoAplicacionAnio exists, false otherwise
       */

        public static boolean hasCostoAplicacionAnio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCostoAplicacionAnio(id, model)!=null);
        }
    }

    public static CostoAplicacionAnioBase.ClassMgr getCostoAplicacionAnioClassMgr()
    {
        return new CostoAplicacionAnioBase.ClassMgr();
    }

   /**
   * Constructs a CostoAplicacionAnioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CostoAplicacionAnio
   */
    public CostoAplicacionAnioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Anio_costo property
* @return int with the Anio_costo
*/
    public int getAnio_costo()
    {
        return getSemanticObject().getIntProperty(cts_anio_costo);
    }

/**
* Sets the Anio_costo property
* @param value long with the Anio_costo
*/
    public void setAnio_costo(int value)
    {
        getSemanticObject().setIntProperty(cts_anio_costo, value);
    }

/**
* Gets the Costoapp property
* @return int with the Costoapp
*/
    public int getCostoapp()
    {
        return getSemanticObject().getIntProperty(cts_costoapp);
    }

/**
* Sets the Costoapp property
* @param value long with the Costoapp
*/
    public void setCostoapp(int value)
    {
        getSemanticObject().setIntProperty(cts_costoapp, value);
    }
}
