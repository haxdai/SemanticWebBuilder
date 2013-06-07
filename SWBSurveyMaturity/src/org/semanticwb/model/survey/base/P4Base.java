package org.semanticwb.model.survey.base;


public abstract class P4Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Soporte_a_Usuarios_Costo_de_Personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Soporte_a_Usuarios_Costo_de_Personal");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Administracion_de_TIC_Costo_de_Personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Administracion_de_TIC_Costo_de_Personal");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Operaciones_e_Infraestructura_Otros_Costos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Operaciones_e_Infraestructura_Otros_Costos");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal");
    public static final org.semanticwb.platform.SemanticProperty cts_actividades_de_aplicacion_otros_costos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#actividades_de_aplicacion_otros_costos");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_actividades_de_aplicacion_costo_de_personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#actividades_de_aplicacion_costo_de_personal");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Desarrollo_de_Proyecto_Otros_Costos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Desarrollo_de_Proyecto_Otros_Costos");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Administracion_de_TIC_Otros_Costos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Administracion_de_TIC_Otros_Costos");
    public static final org.semanticwb.platform.SemanticProperty cts_actividades_de_aplicacion_costos_de_outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#actividades_de_aplicacion_costos_de_outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_Actividades_de_Soporte_a_Usuarios_Otros_Costos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Actividades_de_Soporte_a_Usuarios_Otros_Costos");
    public static final org.semanticwb.platform.SemanticClass cts_P4=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P4");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P4");

    public static class ClassMgr
    {
       /**
       * Returns a list of P4 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P4
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P4> listP4s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P4>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P4 for all models
       * @return Iterator of org.semanticwb.model.survey.P4
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P4> listP4s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P4>(it, true);
        }

        public static org.semanticwb.model.survey.P4 createP4(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P4.ClassMgr.createP4(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P4
       * @param id Identifier for org.semanticwb.model.survey.P4
       * @param model Model of the org.semanticwb.model.survey.P4
       * @return A org.semanticwb.model.survey.P4
       */
        public static org.semanticwb.model.survey.P4 getP4(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P4)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P4
       * @param id Identifier for org.semanticwb.model.survey.P4
       * @param model Model of the org.semanticwb.model.survey.P4
       * @return A org.semanticwb.model.survey.P4
       */
        public static org.semanticwb.model.survey.P4 createP4(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P4)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P4
       * @param id Identifier for org.semanticwb.model.survey.P4
       * @param model Model of the org.semanticwb.model.survey.P4
       */
        public static void removeP4(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P4
       * @param id Identifier for org.semanticwb.model.survey.P4
       * @param model Model of the org.semanticwb.model.survey.P4
       * @return true if the org.semanticwb.model.survey.P4 exists, false otherwise
       */

        public static boolean hasP4(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP4(id, model)!=null);
        }
    }

    public static P4Base.ClassMgr getP4ClassMgr()
    {
        return new P4Base.ClassMgr();
    }

   /**
   * Constructs a P4Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P4
   */
    public P4Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Actividades_de_Soporte_a_Usuarios_Costo_de_Personal property
* @return int with the Actividades_de_Soporte_a_Usuarios_Costo_de_Personal
*/
    public int getActividades_de_Soporte_a_Usuarios_Costo_de_Personal()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Soporte_a_Usuarios_Costo_de_Personal);
    }

/**
* Sets the Actividades_de_Soporte_a_Usuarios_Costo_de_Personal property
* @param value long with the Actividades_de_Soporte_a_Usuarios_Costo_de_Personal
*/
    public void setActividades_de_Soporte_a_Usuarios_Costo_de_Personal(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Soporte_a_Usuarios_Costo_de_Personal, value);
    }

/**
* Gets the Actividades_de_Administracion_de_TIC_Costo_de_Personal property
* @return int with the Actividades_de_Administracion_de_TIC_Costo_de_Personal
*/
    public int getActividades_de_Administracion_de_TIC_Costo_de_Personal()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Administracion_de_TIC_Costo_de_Personal);
    }

/**
* Sets the Actividades_de_Administracion_de_TIC_Costo_de_Personal property
* @param value long with the Actividades_de_Administracion_de_TIC_Costo_de_Personal
*/
    public void setActividades_de_Administracion_de_TIC_Costo_de_Personal(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Administracion_de_TIC_Costo_de_Personal, value);
    }

/**
* Gets the Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing property
* @return int with the Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing
*/
    public int getActividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing);
    }

/**
* Sets the Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing property
* @param value long with the Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing
*/
    public void setActividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing, value);
    }

/**
* Gets the Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing property
* @return int with the Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing
*/
    public int getActividades_de_Administracion_de_TIC_Costos_de_Outsourcing()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing);
    }

/**
* Sets the Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing property
* @param value long with the Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing
*/
    public void setActividades_de_Administracion_de_TIC_Costos_de_Outsourcing(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Administracion_de_TIC_Costos_de_Outsourcing, value);
    }

/**
* Gets the Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing property
* @return int with the Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing
*/
    public int getActividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing);
    }

/**
* Sets the Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing property
* @param value long with the Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing
*/
    public void setActividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing, value);
    }

/**
* Gets the Actividades_de_Operaciones_e_Infraestructura_Otros_Costos property
* @return int with the Actividades_de_Operaciones_e_Infraestructura_Otros_Costos
*/
    public int getActividades_de_Operaciones_e_Infraestructura_Otros_Costos()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Operaciones_e_Infraestructura_Otros_Costos);
    }

/**
* Sets the Actividades_de_Operaciones_e_Infraestructura_Otros_Costos property
* @param value long with the Actividades_de_Operaciones_e_Infraestructura_Otros_Costos
*/
    public void setActividades_de_Operaciones_e_Infraestructura_Otros_Costos(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Operaciones_e_Infraestructura_Otros_Costos, value);
    }

/**
* Gets the Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal property
* @return int with the Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal
*/
    public int getActividades_de_Operaciones_e_Infraestructura_Costo_de_Personal()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal);
    }

/**
* Sets the Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal property
* @param value long with the Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal
*/
    public void setActividades_de_Operaciones_e_Infraestructura_Costo_de_Personal(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Operaciones_e_Infraestructura_Costo_de_Personal, value);
    }

/**
* Gets the Actividades_de_aplicacion_otros_costos property
* @return int with the Actividades_de_aplicacion_otros_costos
*/
    public int getActividades_de_aplicacion_otros_costos()
    {
        return getSemanticObject().getIntProperty(cts_actividades_de_aplicacion_otros_costos);
    }

/**
* Sets the Actividades_de_aplicacion_otros_costos property
* @param value long with the Actividades_de_aplicacion_otros_costos
*/
    public void setActividades_de_aplicacion_otros_costos(int value)
    {
        getSemanticObject().setIntProperty(cts_actividades_de_aplicacion_otros_costos, value);
    }

/**
* Gets the Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing property
* @return int with the Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing
*/
    public int getActividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing);
    }

/**
* Sets the Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing property
* @param value long with the Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing
*/
    public void setActividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing, value);
    }

/**
* Gets the Actividades_de_aplicacion_costo_de_personal property
* @return int with the Actividades_de_aplicacion_costo_de_personal
*/
    public int getActividades_de_aplicacion_costo_de_personal()
    {
        return getSemanticObject().getIntProperty(cts_actividades_de_aplicacion_costo_de_personal);
    }

/**
* Sets the Actividades_de_aplicacion_costo_de_personal property
* @param value long with the Actividades_de_aplicacion_costo_de_personal
*/
    public void setActividades_de_aplicacion_costo_de_personal(int value)
    {
        getSemanticObject().setIntProperty(cts_actividades_de_aplicacion_costo_de_personal, value);
    }

/**
* Gets the Actividades_de_Desarrollo_de_Proyecto_Otros_Costos property
* @return int with the Actividades_de_Desarrollo_de_Proyecto_Otros_Costos
*/
    public int getActividades_de_Desarrollo_de_Proyecto_Otros_Costos()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Desarrollo_de_Proyecto_Otros_Costos);
    }

/**
* Sets the Actividades_de_Desarrollo_de_Proyecto_Otros_Costos property
* @param value long with the Actividades_de_Desarrollo_de_Proyecto_Otros_Costos
*/
    public void setActividades_de_Desarrollo_de_Proyecto_Otros_Costos(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Desarrollo_de_Proyecto_Otros_Costos, value);
    }

/**
* Gets the Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal property
* @return int with the Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal
*/
    public int getActividades_de_Desarrollo_de_Proyecto_Costo_de_Personal()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal);
    }

/**
* Sets the Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal property
* @param value long with the Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal
*/
    public void setActividades_de_Desarrollo_de_Proyecto_Costo_de_Personal(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Desarrollo_de_Proyecto_Costo_de_Personal, value);
    }

/**
* Gets the Actividades_de_Administracion_de_TIC_Otros_Costos property
* @return int with the Actividades_de_Administracion_de_TIC_Otros_Costos
*/
    public int getActividades_de_Administracion_de_TIC_Otros_Costos()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Administracion_de_TIC_Otros_Costos);
    }

/**
* Sets the Actividades_de_Administracion_de_TIC_Otros_Costos property
* @param value long with the Actividades_de_Administracion_de_TIC_Otros_Costos
*/
    public void setActividades_de_Administracion_de_TIC_Otros_Costos(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Administracion_de_TIC_Otros_Costos, value);
    }

/**
* Gets the Actividades_de_aplicacion_costos_de_outsourcing property
* @return int with the Actividades_de_aplicacion_costos_de_outsourcing
*/
    public int getActividades_de_aplicacion_costos_de_outsourcing()
    {
        return getSemanticObject().getIntProperty(cts_actividades_de_aplicacion_costos_de_outsourcing);
    }

/**
* Sets the Actividades_de_aplicacion_costos_de_outsourcing property
* @param value long with the Actividades_de_aplicacion_costos_de_outsourcing
*/
    public void setActividades_de_aplicacion_costos_de_outsourcing(int value)
    {
        getSemanticObject().setIntProperty(cts_actividades_de_aplicacion_costos_de_outsourcing, value);
    }

/**
* Gets the Actividades_de_Soporte_a_Usuarios_Otros_Costos property
* @return int with the Actividades_de_Soporte_a_Usuarios_Otros_Costos
*/
    public int getActividades_de_Soporte_a_Usuarios_Otros_Costos()
    {
        return getSemanticObject().getIntProperty(cts_Actividades_de_Soporte_a_Usuarios_Otros_Costos);
    }

/**
* Sets the Actividades_de_Soporte_a_Usuarios_Otros_Costos property
* @param value long with the Actividades_de_Soporte_a_Usuarios_Otros_Costos
*/
    public void setActividades_de_Soporte_a_Usuarios_Otros_Costos(int value)
    {
        getSemanticObject().setIntProperty(cts_Actividades_de_Soporte_a_Usuarios_Otros_Costos, value);
    }
}
