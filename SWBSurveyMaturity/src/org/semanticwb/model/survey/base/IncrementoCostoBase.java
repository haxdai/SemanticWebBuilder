package org.semanticwb.model.survey.base;


public abstract class IncrementoCostoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_anio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#anio");
    public static final org.semanticwb.platform.SemanticProperty cts_Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones");
    public static final org.semanticwb.platform.SemanticProperty cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos");
    public static final org.semanticwb.platform.SemanticProperty cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion");
    public static final org.semanticwb.platform.SemanticProperty cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios");
    public static final org.semanticwb.platform.SemanticProperty cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios");
    public static final org.semanticwb.platform.SemanticClass cts_IncrementoCosto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#IncrementoCosto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#IncrementoCosto");

    public static class ClassMgr
    {
       /**
       * Returns a list of IncrementoCosto for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.IncrementoCosto
       */

        public static java.util.Iterator<org.semanticwb.model.survey.IncrementoCosto> listIncrementoCostos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.IncrementoCosto>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.IncrementoCosto for all models
       * @return Iterator of org.semanticwb.model.survey.IncrementoCosto
       */

        public static java.util.Iterator<org.semanticwb.model.survey.IncrementoCosto> listIncrementoCostos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.IncrementoCosto>(it, true);
        }

        public static org.semanticwb.model.survey.IncrementoCosto createIncrementoCosto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.IncrementoCosto.ClassMgr.createIncrementoCosto(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.IncrementoCosto
       * @param id Identifier for org.semanticwb.model.survey.IncrementoCosto
       * @param model Model of the org.semanticwb.model.survey.IncrementoCosto
       * @return A org.semanticwb.model.survey.IncrementoCosto
       */
        public static org.semanticwb.model.survey.IncrementoCosto getIncrementoCosto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.IncrementoCosto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.IncrementoCosto
       * @param id Identifier for org.semanticwb.model.survey.IncrementoCosto
       * @param model Model of the org.semanticwb.model.survey.IncrementoCosto
       * @return A org.semanticwb.model.survey.IncrementoCosto
       */
        public static org.semanticwb.model.survey.IncrementoCosto createIncrementoCosto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.IncrementoCosto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.IncrementoCosto
       * @param id Identifier for org.semanticwb.model.survey.IncrementoCosto
       * @param model Model of the org.semanticwb.model.survey.IncrementoCosto
       */
        public static void removeIncrementoCosto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.IncrementoCosto
       * @param id Identifier for org.semanticwb.model.survey.IncrementoCosto
       * @param model Model of the org.semanticwb.model.survey.IncrementoCosto
       * @return true if the org.semanticwb.model.survey.IncrementoCosto exists, false otherwise
       */

        public static boolean hasIncrementoCosto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIncrementoCosto(id, model)!=null);
        }
    }

    public static IncrementoCostoBase.ClassMgr getIncrementoCostoClassMgr()
    {
        return new IncrementoCostoBase.ClassMgr();
    }

   /**
   * Constructs a IncrementoCostoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the IncrementoCosto
   */
    public IncrementoCostoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Anio property
* @return int with the Anio
*/
    public int getAnio()
    {
        return getSemanticObject().getIntProperty(cts_anio);
    }

/**
* Sets the Anio property
* @param value long with the Anio
*/
    public void setAnio(int value)
    {
        getSemanticObject().setIntProperty(cts_anio, value);
    }

/**
* Gets the Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones property
* @return int with the Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones
*/
    public int getCambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones()
    {
        return getSemanticObject().getIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones);
    }

/**
* Sets the Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones property
* @param value long with the Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones
*/
    public void setCambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones(int value)
    {
        getSemanticObject().setIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones, value);
    }

/**
* Gets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos property
* @return int with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos
*/
    public int getCambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos()
    {
        return getSemanticObject().getIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos);
    }

/**
* Sets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos property
* @param value long with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos
*/
    public void setCambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos(int value)
    {
        getSemanticObject().setIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos, value);
    }

/**
* Gets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion property
* @return int with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion
*/
    public int getCambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion()
    {
        return getSemanticObject().getIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion);
    }

/**
* Sets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion property
* @param value long with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion
*/
    public void setCambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion(int value)
    {
        getSemanticObject().setIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion, value);
    }

/**
* Gets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios property
* @return int with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios
*/
    public int getCambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios()
    {
        return getSemanticObject().getIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios);
    }

/**
* Sets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios property
* @param value long with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios
*/
    public void setCambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios(int value)
    {
        getSemanticObject().setIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios, value);
    }

/**
* Gets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios property
* @return int with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios
*/
    public int getCambio_porcentual_anual_del_Portafolio_de_Servicios_Propios()
    {
        return getSemanticObject().getIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios);
    }

/**
* Sets the Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios property
* @param value long with the Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios
*/
    public void setCambio_porcentual_anual_del_Portafolio_de_Servicios_Propios(int value)
    {
        getSemanticObject().setIntProperty(cts_Cambio_porcentual_anual_del_Portafolio_de_Servicios_Propios, value);
    }
}
