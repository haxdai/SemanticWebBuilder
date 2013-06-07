package org.semanticwb.model.survey.base;


public abstract class P6Base extends org.semanticwb.model.SWBClass implements org.semanticwb.model.survey.CostoUnidad
{
    public static final org.semanticwb.platform.SemanticClass cts_CostoUnidadSustantiva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoUnidadSustantiva");
    public static final org.semanticwb.platform.SemanticProperty cts_hasCostosUnidades=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#hasCostosUnidades");
    public static final org.semanticwb.platform.SemanticClass cts_P6=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P6");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P6");

    public static class ClassMgr
    {
       /**
       * Returns a list of P6 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P6
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P6> listP6s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P6>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P6 for all models
       * @return Iterator of org.semanticwb.model.survey.P6
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P6> listP6s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P6>(it, true);
        }

        public static org.semanticwb.model.survey.P6 createP6(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P6.ClassMgr.createP6(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P6
       * @param id Identifier for org.semanticwb.model.survey.P6
       * @param model Model of the org.semanticwb.model.survey.P6
       * @return A org.semanticwb.model.survey.P6
       */
        public static org.semanticwb.model.survey.P6 getP6(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P6)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P6
       * @param id Identifier for org.semanticwb.model.survey.P6
       * @param model Model of the org.semanticwb.model.survey.P6
       * @return A org.semanticwb.model.survey.P6
       */
        public static org.semanticwb.model.survey.P6 createP6(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P6)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P6
       * @param id Identifier for org.semanticwb.model.survey.P6
       * @param model Model of the org.semanticwb.model.survey.P6
       */
        public static void removeP6(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P6
       * @param id Identifier for org.semanticwb.model.survey.P6
       * @param model Model of the org.semanticwb.model.survey.P6
       * @return true if the org.semanticwb.model.survey.P6 exists, false otherwise
       */

        public static boolean hasP6(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP6(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.P6 with a determined CostosUnidades
       * @param value CostosUnidades of the type org.semanticwb.model.survey.CostoUnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.P6
       * @return Iterator with all the org.semanticwb.model.survey.P6
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P6> listP6ByCostosUnidades(org.semanticwb.model.survey.CostoUnidadSustantiva value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P6> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostosUnidades, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.P6 with a determined CostosUnidades
       * @param value CostosUnidades of the type org.semanticwb.model.survey.CostoUnidadSustantiva
       * @return Iterator with all the org.semanticwb.model.survey.P6
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P6> listP6ByCostosUnidades(org.semanticwb.model.survey.CostoUnidadSustantiva value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P6> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostosUnidades,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static P6Base.ClassMgr getP6ClassMgr()
    {
        return new P6Base.ClassMgr();
    }

   /**
   * Constructs a P6Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P6
   */
    public P6Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Gets all the org.semanticwb.model.survey.CostoUnidadSustantiva
   * @return A GenericIterator with all the org.semanticwb.model.survey.CostoUnidadSustantiva
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoUnidadSustantiva> listCostosUnidadeses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoUnidadSustantiva>(getSemanticObject().listObjectProperties(cts_hasCostosUnidades));
    }

   /**
   * Gets true if has a CostosUnidades
   * @param value org.semanticwb.model.survey.CostoUnidadSustantiva to verify
   * @return true if the org.semanticwb.model.survey.CostoUnidadSustantiva exists, false otherwise
   */
    public boolean hasCostosUnidades(org.semanticwb.model.survey.CostoUnidadSustantiva value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cts_hasCostosUnidades,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CostosUnidades
   * @param value org.semanticwb.model.survey.CostoUnidadSustantiva to add
   */

    public void addCostosUnidades(org.semanticwb.model.survey.CostoUnidadSustantiva value)
    {
        getSemanticObject().addObjectProperty(cts_hasCostosUnidades, value.getSemanticObject());
    }
   /**
   * Removes all the CostosUnidades
   */

    public void removeAllCostosUnidades()
    {
        getSemanticObject().removeProperty(cts_hasCostosUnidades);
    }
   /**
   * Removes a CostosUnidades
   * @param value org.semanticwb.model.survey.CostoUnidadSustantiva to remove
   */

    public void removeCostosUnidades(org.semanticwb.model.survey.CostoUnidadSustantiva value)
    {
        getSemanticObject().removeObjectProperty(cts_hasCostosUnidades,value.getSemanticObject());
    }

   /**
   * Gets the CostosUnidades
   * @return a org.semanticwb.model.survey.CostoUnidadSustantiva
   */
    public org.semanticwb.model.survey.CostoUnidadSustantiva getCostosUnidades()
    {
         org.semanticwb.model.survey.CostoUnidadSustantiva ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_hasCostosUnidades);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.CostoUnidadSustantiva)obj.createGenericInstance();
         }
         return ret;
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
