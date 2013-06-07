package org.semanticwb.model.survey.base;


public abstract class P5Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de");
    public static final org.semanticwb.platform.SemanticProperty cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios");
    public static final org.semanticwb.platform.SemanticProperty cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones");
    public static final org.semanticwb.platform.SemanticProperty cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura");
    public static final org.semanticwb.platform.SemanticProperty cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto");
    public static final org.semanticwb.platform.SemanticClass cts_P5=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P5");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P5");

    public static class ClassMgr
    {
       /**
       * Returns a list of P5 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P5
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P5> listP5s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P5>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P5 for all models
       * @return Iterator of org.semanticwb.model.survey.P5
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P5> listP5s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P5>(it, true);
        }

        public static org.semanticwb.model.survey.P5 createP5(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P5.ClassMgr.createP5(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P5
       * @param id Identifier for org.semanticwb.model.survey.P5
       * @param model Model of the org.semanticwb.model.survey.P5
       * @return A org.semanticwb.model.survey.P5
       */
        public static org.semanticwb.model.survey.P5 getP5(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P5)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P5
       * @param id Identifier for org.semanticwb.model.survey.P5
       * @param model Model of the org.semanticwb.model.survey.P5
       * @return A org.semanticwb.model.survey.P5
       */
        public static org.semanticwb.model.survey.P5 createP5(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P5)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P5
       * @param id Identifier for org.semanticwb.model.survey.P5
       * @param model Model of the org.semanticwb.model.survey.P5
       */
        public static void removeP5(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P5
       * @param id Identifier for org.semanticwb.model.survey.P5
       * @param model Model of the org.semanticwb.model.survey.P5
       * @return true if the org.semanticwb.model.survey.P5 exists, false otherwise
       */

        public static boolean hasP5(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP5(id, model)!=null);
        }
    }

    public static P5Base.ClassMgr getP5ClassMgr()
    {
        return new P5Base.ClassMgr();
    }

   /**
   * Constructs a P5Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P5
   */
    public P5Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de property
* @return int with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de
*/
    public int getCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de()
    {
        return getSemanticObject().getIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de);
    }

/**
* Sets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de property
* @param value long with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de
*/
    public void setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de(int value)
    {
        getSemanticObject().setIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de, value);
    }

/**
* Gets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios property
* @return int with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios
*/
    public int getCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios()
    {
        return getSemanticObject().getIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios);
    }

/**
* Sets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios property
* @param value long with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios
*/
    public void setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios(int value)
    {
        getSemanticObject().setIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios, value);
    }

/**
* Gets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones property
* @return int with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones
*/
    public int getCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones()
    {
        return getSemanticObject().getIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones);
    }

/**
* Sets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones property
* @param value long with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones
*/
    public void setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones(int value)
    {
        getSemanticObject().setIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones, value);
    }

/**
* Gets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura property
* @return int with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura
*/
    public int getCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura()
    {
        return getSemanticObject().getIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura);
    }

/**
* Sets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura property
* @param value long with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura
*/
    public void setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura(int value)
    {
        getSemanticObject().setIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura, value);
    }

/**
* Gets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto property
* @return int with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto
*/
    public int getCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto()
    {
        return getSemanticObject().getIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto);
    }

/**
* Sets the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto property
* @param value long with the Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto
*/
    public void setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto(int value)
    {
        getSemanticObject().setIntProperty(cts_Costo_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto, value);
    }
}
