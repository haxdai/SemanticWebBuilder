package org.semanticwb.model.survey.base;


public abstract class CostoUnidadSustantivaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.survey.CostoUnidad,org.semanticwb.model.survey.Unidad
{
    public static final org.semanticwb.platform.SemanticClass cts_CostoUnidadSustantiva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoUnidadSustantiva");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoUnidadSustantiva");

    public static class ClassMgr
    {
       /**
       * Returns a list of CostoUnidadSustantiva for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.CostoUnidadSustantiva
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoUnidadSustantiva> listCostoUnidadSustantivas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoUnidadSustantiva>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.CostoUnidadSustantiva for all models
       * @return Iterator of org.semanticwb.model.survey.CostoUnidadSustantiva
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoUnidadSustantiva> listCostoUnidadSustantivas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoUnidadSustantiva>(it, true);
        }

        public static org.semanticwb.model.survey.CostoUnidadSustantiva createCostoUnidadSustantiva(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.CostoUnidadSustantiva.ClassMgr.createCostoUnidadSustantiva(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.CostoUnidadSustantiva
       * @return A org.semanticwb.model.survey.CostoUnidadSustantiva
       */
        public static org.semanticwb.model.survey.CostoUnidadSustantiva getCostoUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoUnidadSustantiva)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.CostoUnidadSustantiva
       * @return A org.semanticwb.model.survey.CostoUnidadSustantiva
       */
        public static org.semanticwb.model.survey.CostoUnidadSustantiva createCostoUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoUnidadSustantiva)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.CostoUnidadSustantiva
       */
        public static void removeCostoUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.CostoUnidadSustantiva
       * @return true if the org.semanticwb.model.survey.CostoUnidadSustantiva exists, false otherwise
       */

        public static boolean hasCostoUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCostoUnidadSustantiva(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoUnidadSustantiva with a determined UnidadSustantiva
       * @param value UnidadSustantiva of the type org.semanticwb.model.survey.UnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.CostoUnidadSustantiva
       * @return Iterator with all the org.semanticwb.model.survey.CostoUnidadSustantiva
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoUnidadSustantiva> listCostoUnidadSustantivaByUnidadSustantiva(org.semanticwb.model.survey.UnidadSustantiva value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoUnidadSustantiva> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_unidadSustantiva, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoUnidadSustantiva with a determined UnidadSustantiva
       * @param value UnidadSustantiva of the type org.semanticwb.model.survey.UnidadSustantiva
       * @return Iterator with all the org.semanticwb.model.survey.CostoUnidadSustantiva
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoUnidadSustantiva> listCostoUnidadSustantivaByUnidadSustantiva(org.semanticwb.model.survey.UnidadSustantiva value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoUnidadSustantiva> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_unidadSustantiva,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CostoUnidadSustantivaBase.ClassMgr getCostoUnidadSustantivaClassMgr()
    {
        return new CostoUnidadSustantivaBase.ClassMgr();
    }

   /**
   * Constructs a CostoUnidadSustantivaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CostoUnidadSustantiva
   */
    public CostoUnidadSustantivaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property UnidadSustantiva
   * @param value UnidadSustantiva to set
   */

    public void setUnidadSustantiva(org.semanticwb.model.survey.UnidadSustantiva value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cts_unidadSustantiva, value.getSemanticObject());
        }else
        {
            removeUnidadSustantiva();
        }
    }
   /**
   * Remove the value for UnidadSustantiva property
   */

    public void removeUnidadSustantiva()
    {
        getSemanticObject().removeProperty(cts_unidadSustantiva);
    }

   /**
   * Gets the UnidadSustantiva
   * @return a org.semanticwb.model.survey.UnidadSustantiva
   */
    public org.semanticwb.model.survey.UnidadSustantiva getUnidadSustantiva()
    {
         org.semanticwb.model.survey.UnidadSustantiva ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_unidadSustantiva);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.UnidadSustantiva)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Costos_del_Portafolio_de_Servicios_Propios property
* @return int with the Costos_del_Portafolio_de_Servicios_Propios
*/
    public int getCostos_del_Portafolio_de_Servicios_Propios()
    {
        return getSemanticObject().getIntProperty(cts_Costos_del_Portafolio_de_Servicios_Propios);
    }

/**
* Sets the Costos_del_Portafolio_de_Servicios_Propios property
* @param value long with the Costos_del_Portafolio_de_Servicios_Propios
*/
    public void setCostos_del_Portafolio_de_Servicios_Propios(int value)
    {
        getSemanticObject().setIntProperty(cts_Costos_del_Portafolio_de_Servicios_Propios, value);
    }

/**
* Gets the Costos_del_Portafolio_de_servicios property
* @return int with the Costos_del_Portafolio_de_servicios
*/
    public int getCostos_del_Portafolio_de_servicios()
    {
        return getSemanticObject().getIntProperty(cts_Costos_del_Portafolio_de_servicios);
    }

/**
* Sets the Costos_del_Portafolio_de_servicios property
* @param value long with the Costos_del_Portafolio_de_servicios
*/
    public void setCostos_del_Portafolio_de_servicios(int value)
    {
        getSemanticObject().setIntProperty(cts_Costos_del_Portafolio_de_servicios, value);
    }

/**
* Gets the Costos_del_Portafolio_de_Servicios_de_Gestion property
* @return int with the Costos_del_Portafolio_de_Servicios_de_Gestion
*/
    public int getCostos_del_Portafolio_de_Servicios_de_Gestion()
    {
        return getSemanticObject().getIntProperty(cts_Costos_del_Portafolio_de_Servicios_de_Gestion);
    }

/**
* Sets the Costos_del_Portafolio_de_Servicios_de_Gestion property
* @param value long with the Costos_del_Portafolio_de_Servicios_de_Gestion
*/
    public void setCostos_del_Portafolio_de_Servicios_de_Gestion(int value)
    {
        getSemanticObject().setIntProperty(cts_Costos_del_Portafolio_de_Servicios_de_Gestion, value);
    }

/**
* Gets the Costos_del_Portafolio_de_Servicios_de_Proyecto property
* @return int with the Costos_del_Portafolio_de_Servicios_de_Proyecto
*/
    public int getCostos_del_Portafolio_de_Servicios_de_Proyecto()
    {
        return getSemanticObject().getIntProperty(cts_Costos_del_Portafolio_de_Servicios_de_Proyecto);
    }

/**
* Sets the Costos_del_Portafolio_de_Servicios_de_Proyecto property
* @param value long with the Costos_del_Portafolio_de_Servicios_de_Proyecto
*/
    public void setCostos_del_Portafolio_de_Servicios_de_Proyecto(int value)
    {
        getSemanticObject().setIntProperty(cts_Costos_del_Portafolio_de_Servicios_de_Proyecto, value);
    }

/**
* Gets the Costos_del_Portafolio_de_Servicios_al_Usuario property
* @return int with the Costos_del_Portafolio_de_Servicios_al_Usuario
*/
    public int getCostos_del_Portafolio_de_Servicios_al_Usuario()
    {
        return getSemanticObject().getIntProperty(cts_Costos_del_Portafolio_de_Servicios_al_Usuario);
    }

/**
* Sets the Costos_del_Portafolio_de_Servicios_al_Usuario property
* @param value long with the Costos_del_Portafolio_de_Servicios_al_Usuario
*/
    public void setCostos_del_Portafolio_de_Servicios_al_Usuario(int value)
    {
        getSemanticObject().setIntProperty(cts_Costos_del_Portafolio_de_Servicios_al_Usuario, value);
    }
}
