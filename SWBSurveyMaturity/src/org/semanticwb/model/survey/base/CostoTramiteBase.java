package org.semanticwb.model.survey.base;


public abstract class CostoTramiteBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_Costos_de_Servicio_de_Infraestructura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costos_de_Servicio_de_Infraestructura");
    public static final org.semanticwb.platform.SemanticProperty cts_Numero_de_Tramites_Anuales=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Numero_de_Tramites_Anuales");
    public static final org.semanticwb.platform.SemanticProperty cts_Costos_de_Servicio_de_Aplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costos_de_Servicio_de_Aplicacion");
    public static final org.semanticwb.platform.SemanticProperty cts_Tramite_apoyado_por_TIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Tramite_apoyado_por_TIC");
    public static final org.semanticwb.platform.SemanticClass cts_Tramite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#Tramite");
    public static final org.semanticwb.platform.SemanticProperty cts_tramite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#tramite");
    public static final org.semanticwb.platform.SemanticClass cts_CostoTramite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoTramite");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoTramite");

    public static class ClassMgr
    {
       /**
       * Returns a list of CostoTramite for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.CostoTramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoTramite> listCostoTramites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoTramite>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.CostoTramite for all models
       * @return Iterator of org.semanticwb.model.survey.CostoTramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoTramite> listCostoTramites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoTramite>(it, true);
        }

        public static org.semanticwb.model.survey.CostoTramite createCostoTramite(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.CostoTramite.ClassMgr.createCostoTramite(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.CostoTramite
       * @param id Identifier for org.semanticwb.model.survey.CostoTramite
       * @param model Model of the org.semanticwb.model.survey.CostoTramite
       * @return A org.semanticwb.model.survey.CostoTramite
       */
        public static org.semanticwb.model.survey.CostoTramite getCostoTramite(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoTramite)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.CostoTramite
       * @param id Identifier for org.semanticwb.model.survey.CostoTramite
       * @param model Model of the org.semanticwb.model.survey.CostoTramite
       * @return A org.semanticwb.model.survey.CostoTramite
       */
        public static org.semanticwb.model.survey.CostoTramite createCostoTramite(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoTramite)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.CostoTramite
       * @param id Identifier for org.semanticwb.model.survey.CostoTramite
       * @param model Model of the org.semanticwb.model.survey.CostoTramite
       */
        public static void removeCostoTramite(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.CostoTramite
       * @param id Identifier for org.semanticwb.model.survey.CostoTramite
       * @param model Model of the org.semanticwb.model.survey.CostoTramite
       * @return true if the org.semanticwb.model.survey.CostoTramite exists, false otherwise
       */

        public static boolean hasCostoTramite(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCostoTramite(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoTramite with a determined Tramite
       * @param value Tramite of the type org.semanticwb.model.survey.Tramite
       * @param model Model of the org.semanticwb.model.survey.CostoTramite
       * @return Iterator with all the org.semanticwb.model.survey.CostoTramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoTramite> listCostoTramiteByTramite(org.semanticwb.model.survey.Tramite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoTramite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_tramite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoTramite with a determined Tramite
       * @param value Tramite of the type org.semanticwb.model.survey.Tramite
       * @return Iterator with all the org.semanticwb.model.survey.CostoTramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoTramite> listCostoTramiteByTramite(org.semanticwb.model.survey.Tramite value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoTramite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_tramite,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CostoTramiteBase.ClassMgr getCostoTramiteClassMgr()
    {
        return new CostoTramiteBase.ClassMgr();
    }

   /**
   * Constructs a CostoTramiteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CostoTramite
   */
    public CostoTramiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Costos_de_Servicio_de_Infraestructura property
* @return int with the Costos_de_Servicio_de_Infraestructura
*/
    public int getCostos_de_Servicio_de_Infraestructura()
    {
        return getSemanticObject().getIntProperty(cts_Costos_de_Servicio_de_Infraestructura);
    }

/**
* Sets the Costos_de_Servicio_de_Infraestructura property
* @param value long with the Costos_de_Servicio_de_Infraestructura
*/
    public void setCostos_de_Servicio_de_Infraestructura(int value)
    {
        getSemanticObject().setIntProperty(cts_Costos_de_Servicio_de_Infraestructura, value);
    }

/**
* Gets the Numero_de_Tramites_Anuales property
* @return int with the Numero_de_Tramites_Anuales
*/
    public int getNumero_de_Tramites_Anuales()
    {
        return getSemanticObject().getIntProperty(cts_Numero_de_Tramites_Anuales);
    }

/**
* Sets the Numero_de_Tramites_Anuales property
* @param value long with the Numero_de_Tramites_Anuales
*/
    public void setNumero_de_Tramites_Anuales(int value)
    {
        getSemanticObject().setIntProperty(cts_Numero_de_Tramites_Anuales, value);
    }

/**
* Gets the Costos_de_Servicio_de_Aplicacion property
* @return int with the Costos_de_Servicio_de_Aplicacion
*/
    public int getCostos_de_Servicio_de_Aplicacion()
    {
        return getSemanticObject().getIntProperty(cts_Costos_de_Servicio_de_Aplicacion);
    }

/**
* Sets the Costos_de_Servicio_de_Aplicacion property
* @param value long with the Costos_de_Servicio_de_Aplicacion
*/
    public void setCostos_de_Servicio_de_Aplicacion(int value)
    {
        getSemanticObject().setIntProperty(cts_Costos_de_Servicio_de_Aplicacion, value);
    }

/**
* Gets the Tramite_apoyado_por_TIC property
* @return int with the Tramite_apoyado_por_TIC
*/
    public int getTramite_apoyado_por_TIC()
    {
        return getSemanticObject().getIntProperty(cts_Tramite_apoyado_por_TIC);
    }

/**
* Sets the Tramite_apoyado_por_TIC property
* @param value long with the Tramite_apoyado_por_TIC
*/
    public void setTramite_apoyado_por_TIC(int value)
    {
        getSemanticObject().setIntProperty(cts_Tramite_apoyado_por_TIC, value);
    }
   /**
   * Sets the value for the property Tramite
   * @param value Tramite to set
   */

    public void setTramite(org.semanticwb.model.survey.Tramite value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cts_tramite, value.getSemanticObject());
        }else
        {
            removeTramite();
        }
    }
   /**
   * Remove the value for Tramite property
   */

    public void removeTramite()
    {
        getSemanticObject().removeProperty(cts_tramite);
    }

   /**
   * Gets the Tramite
   * @return a org.semanticwb.model.survey.Tramite
   */
    public org.semanticwb.model.survey.Tramite getTramite()
    {
         org.semanticwb.model.survey.Tramite ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_tramite);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.Tramite)obj.createGenericInstance();
         }
         return ret;
    }
}
