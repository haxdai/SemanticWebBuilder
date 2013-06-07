package org.semanticwb.model.survey.base;


public abstract class P12Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_p12_5_Computo_de_Nube=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_5_Computo_de_Nube");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_10_Otros1=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_10_Otros1");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_9_Traiga_sus_Propios_Dispositivos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_9_Traiga_sus_Propios_Dispositivos");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_7_Administracion_de_Energia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_7_Administracion_de_Energia");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_1_Consolidacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_1_Consolidacion");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_4_Aplicaciones_comerciales_disponibles_en_el_mercado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_4_Aplicaciones_comerciales_disponibles_en_el_mercado");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_2_Outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_2_Outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_8_Salarios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_8_Salarios");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_3_Practicas_de_Administracion_de_Servicios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_3_Practicas_de_Administracion_de_Servicios");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_6_Administracion_de_Demanda=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_6_Administracion_de_Demanda");
    public static final org.semanticwb.platform.SemanticProperty cts_p12_11_Otros2=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p12_11_Otros2");
    public static final org.semanticwb.platform.SemanticClass cts_P12=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P12");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P12");

    public static class ClassMgr
    {
       /**
       * Returns a list of P12 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P12
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P12> listP12s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P12>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P12 for all models
       * @return Iterator of org.semanticwb.model.survey.P12
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P12> listP12s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P12>(it, true);
        }

        public static org.semanticwb.model.survey.P12 createP12(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P12.ClassMgr.createP12(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P12
       * @param id Identifier for org.semanticwb.model.survey.P12
       * @param model Model of the org.semanticwb.model.survey.P12
       * @return A org.semanticwb.model.survey.P12
       */
        public static org.semanticwb.model.survey.P12 getP12(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P12)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P12
       * @param id Identifier for org.semanticwb.model.survey.P12
       * @param model Model of the org.semanticwb.model.survey.P12
       * @return A org.semanticwb.model.survey.P12
       */
        public static org.semanticwb.model.survey.P12 createP12(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P12)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P12
       * @param id Identifier for org.semanticwb.model.survey.P12
       * @param model Model of the org.semanticwb.model.survey.P12
       */
        public static void removeP12(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P12
       * @param id Identifier for org.semanticwb.model.survey.P12
       * @param model Model of the org.semanticwb.model.survey.P12
       * @return true if the org.semanticwb.model.survey.P12 exists, false otherwise
       */

        public static boolean hasP12(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP12(id, model)!=null);
        }
    }

    public static P12Base.ClassMgr getP12ClassMgr()
    {
        return new P12Base.ClassMgr();
    }

   /**
   * Constructs a P12Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P12
   */
    public P12Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the P12_5_Computo_de_Nube property
* @return boolean with the P12_5_Computo_de_Nube
*/
    public boolean isP12_5_Computo_de_Nube()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_5_Computo_de_Nube);
    }

/**
* Sets the P12_5_Computo_de_Nube property
* @param value long with the P12_5_Computo_de_Nube
*/
    public void setP12_5_Computo_de_Nube(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_5_Computo_de_Nube, value);
    }

/**
* Gets the P12_10_Otros1 property
* @return boolean with the P12_10_Otros1
*/
    public boolean isP12_10_Otros1()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_10_Otros1);
    }

/**
* Sets the P12_10_Otros1 property
* @param value long with the P12_10_Otros1
*/
    public void setP12_10_Otros1(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_10_Otros1, value);
    }

/**
* Gets the P12_9_Traiga_sus_Propios_Dispositivos property
* @return boolean with the P12_9_Traiga_sus_Propios_Dispositivos
*/
    public boolean isP12_9_Traiga_sus_Propios_Dispositivos()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_9_Traiga_sus_Propios_Dispositivos);
    }

/**
* Sets the P12_9_Traiga_sus_Propios_Dispositivos property
* @param value long with the P12_9_Traiga_sus_Propios_Dispositivos
*/
    public void setP12_9_Traiga_sus_Propios_Dispositivos(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_9_Traiga_sus_Propios_Dispositivos, value);
    }

/**
* Gets the P12_7_Administracion_de_Energia property
* @return boolean with the P12_7_Administracion_de_Energia
*/
    public boolean isP12_7_Administracion_de_Energia()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_7_Administracion_de_Energia);
    }

/**
* Sets the P12_7_Administracion_de_Energia property
* @param value long with the P12_7_Administracion_de_Energia
*/
    public void setP12_7_Administracion_de_Energia(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_7_Administracion_de_Energia, value);
    }

/**
* Gets the P12_1_Consolidacion property
* @return boolean with the P12_1_Consolidacion
*/
    public boolean isP12_1_Consolidacion()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_1_Consolidacion);
    }

/**
* Sets the P12_1_Consolidacion property
* @param value long with the P12_1_Consolidacion
*/
    public void setP12_1_Consolidacion(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_1_Consolidacion, value);
    }

/**
* Gets the P12_4_Aplicaciones_comerciales_disponibles_en_el_mercado property
* @return boolean with the P12_4_Aplicaciones_comerciales_disponibles_en_el_mercado
*/
    public boolean isP12_4_Aplicaciones_comerciales_disponibles_en_el_mercado()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_4_Aplicaciones_comerciales_disponibles_en_el_mercado);
    }

/**
* Sets the P12_4_Aplicaciones_comerciales_disponibles_en_el_mercado property
* @param value long with the P12_4_Aplicaciones_comerciales_disponibles_en_el_mercado
*/
    public void setP12_4_Aplicaciones_comerciales_disponibles_en_el_mercado(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_4_Aplicaciones_comerciales_disponibles_en_el_mercado, value);
    }

/**
* Gets the P12_2_Outsourcing property
* @return boolean with the P12_2_Outsourcing
*/
    public boolean isP12_2_Outsourcing()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_2_Outsourcing);
    }

/**
* Sets the P12_2_Outsourcing property
* @param value long with the P12_2_Outsourcing
*/
    public void setP12_2_Outsourcing(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_2_Outsourcing, value);
    }

/**
* Gets the P12_8_Salarios property
* @return boolean with the P12_8_Salarios
*/
    public boolean isP12_8_Salarios()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_8_Salarios);
    }

/**
* Sets the P12_8_Salarios property
* @param value long with the P12_8_Salarios
*/
    public void setP12_8_Salarios(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_8_Salarios, value);
    }

/**
* Gets the P12_3_Practicas_de_Administracion_de_Servicios property
* @return boolean with the P12_3_Practicas_de_Administracion_de_Servicios
*/
    public boolean isP12_3_Practicas_de_Administracion_de_Servicios()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_3_Practicas_de_Administracion_de_Servicios);
    }

/**
* Sets the P12_3_Practicas_de_Administracion_de_Servicios property
* @param value long with the P12_3_Practicas_de_Administracion_de_Servicios
*/
    public void setP12_3_Practicas_de_Administracion_de_Servicios(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_3_Practicas_de_Administracion_de_Servicios, value);
    }

/**
* Gets the P12_6_Administracion_de_Demanda property
* @return boolean with the P12_6_Administracion_de_Demanda
*/
    public boolean isP12_6_Administracion_de_Demanda()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_6_Administracion_de_Demanda);
    }

/**
* Sets the P12_6_Administracion_de_Demanda property
* @param value long with the P12_6_Administracion_de_Demanda
*/
    public void setP12_6_Administracion_de_Demanda(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_6_Administracion_de_Demanda, value);
    }

/**
* Gets the P12_11_Otros2 property
* @return boolean with the P12_11_Otros2
*/
    public boolean isP12_11_Otros2()
    {
        return getSemanticObject().getBooleanProperty(cts_p12_11_Otros2);
    }

/**
* Sets the P12_11_Otros2 property
* @param value long with the P12_11_Otros2
*/
    public void setP12_11_Otros2(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p12_11_Otros2, value);
    }
}
