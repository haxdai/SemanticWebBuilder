package org.semanticwb.model.survey.base;


public abstract class P11Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_p11_4_Consolidacion_de_Hardware=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_4_Consolidacion_de_Hardware");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_9_VOIP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_9_VOIP");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_3_Incrementos_de_Productividad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_3_Incrementos_de_Productividad");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_5_Reduccion_de_Costos_de_Tecnologia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_5_Reduccion_de_Costos_de_Tecnologia");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_6_Proveeduria_Abierta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_6_Proveeduria_Abierta");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_8_Reduccion_de_la_Demanda_de_TI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_8_Reduccion_de_la_Demanda_de_TI");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_12_Otros2=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_12_Otros2");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_11_Otros1=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_11_Otros1");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_7_Retiros_de_Aplicaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_7_Retiros_de_Aplicaciones");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_2_Outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_2_Outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_p11_10_Traiga_sus_Propios_Dispositivos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p11_10_Traiga_sus_Propios_Dispositivos");
    public static final org.semanticwb.platform.SemanticClass cts_P11=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P11");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P11");

    public static class ClassMgr
    {
       /**
       * Returns a list of P11 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P11
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P11> listP11s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P11>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P11 for all models
       * @return Iterator of org.semanticwb.model.survey.P11
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P11> listP11s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P11>(it, true);
        }

        public static org.semanticwb.model.survey.P11 createP11(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P11.ClassMgr.createP11(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P11
       * @param id Identifier for org.semanticwb.model.survey.P11
       * @param model Model of the org.semanticwb.model.survey.P11
       * @return A org.semanticwb.model.survey.P11
       */
        public static org.semanticwb.model.survey.P11 getP11(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P11)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P11
       * @param id Identifier for org.semanticwb.model.survey.P11
       * @param model Model of the org.semanticwb.model.survey.P11
       * @return A org.semanticwb.model.survey.P11
       */
        public static org.semanticwb.model.survey.P11 createP11(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P11)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P11
       * @param id Identifier for org.semanticwb.model.survey.P11
       * @param model Model of the org.semanticwb.model.survey.P11
       */
        public static void removeP11(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P11
       * @param id Identifier for org.semanticwb.model.survey.P11
       * @param model Model of the org.semanticwb.model.survey.P11
       * @return true if the org.semanticwb.model.survey.P11 exists, false otherwise
       */

        public static boolean hasP11(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP11(id, model)!=null);
        }
    }

    public static P11Base.ClassMgr getP11ClassMgr()
    {
        return new P11Base.ClassMgr();
    }

   /**
   * Constructs a P11Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P11
   */
    public P11Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the P11_4_Consolidacion_de_Hardware property
* @return boolean with the P11_4_Consolidacion_de_Hardware
*/
    public boolean isP11_4_Consolidacion_de_Hardware()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_4_Consolidacion_de_Hardware);
    }

/**
* Sets the P11_4_Consolidacion_de_Hardware property
* @param value long with the P11_4_Consolidacion_de_Hardware
*/
    public void setP11_4_Consolidacion_de_Hardware(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_4_Consolidacion_de_Hardware, value);
    }

/**
* Gets the P11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC property
* @return boolean with the P11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC
*/
    public boolean isP11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC);
    }

/**
* Sets the P11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC property
* @param value long with the P11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC
*/
    public void setP11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_1_Demandas_de_la_Institucion_para_Reduccion_de_Costos_de_TIC, value);
    }

/**
* Gets the P11_9_VOIP property
* @return boolean with the P11_9_VOIP
*/
    public boolean isP11_9_VOIP()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_9_VOIP);
    }

/**
* Sets the P11_9_VOIP property
* @param value long with the P11_9_VOIP
*/
    public void setP11_9_VOIP(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_9_VOIP, value);
    }

/**
* Gets the P11_3_Incrementos_de_Productividad property
* @return boolean with the P11_3_Incrementos_de_Productividad
*/
    public boolean isP11_3_Incrementos_de_Productividad()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_3_Incrementos_de_Productividad);
    }

/**
* Sets the P11_3_Incrementos_de_Productividad property
* @param value long with the P11_3_Incrementos_de_Productividad
*/
    public void setP11_3_Incrementos_de_Productividad(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_3_Incrementos_de_Productividad, value);
    }

/**
* Gets the P11_5_Reduccion_de_Costos_de_Tecnologia property
* @return boolean with the P11_5_Reduccion_de_Costos_de_Tecnologia
*/
    public boolean isP11_5_Reduccion_de_Costos_de_Tecnologia()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_5_Reduccion_de_Costos_de_Tecnologia);
    }

/**
* Sets the P11_5_Reduccion_de_Costos_de_Tecnologia property
* @param value long with the P11_5_Reduccion_de_Costos_de_Tecnologia
*/
    public void setP11_5_Reduccion_de_Costos_de_Tecnologia(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_5_Reduccion_de_Costos_de_Tecnologia, value);
    }

/**
* Gets the P11_6_Proveeduria_Abierta property
* @return boolean with the P11_6_Proveeduria_Abierta
*/
    public boolean isP11_6_Proveeduria_Abierta()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_6_Proveeduria_Abierta);
    }

/**
* Sets the P11_6_Proveeduria_Abierta property
* @param value long with the P11_6_Proveeduria_Abierta
*/
    public void setP11_6_Proveeduria_Abierta(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_6_Proveeduria_Abierta, value);
    }

/**
* Gets the P11_8_Reduccion_de_la_Demanda_de_TI property
* @return boolean with the P11_8_Reduccion_de_la_Demanda_de_TI
*/
    public boolean isP11_8_Reduccion_de_la_Demanda_de_TI()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_8_Reduccion_de_la_Demanda_de_TI);
    }

/**
* Sets the P11_8_Reduccion_de_la_Demanda_de_TI property
* @param value long with the P11_8_Reduccion_de_la_Demanda_de_TI
*/
    public void setP11_8_Reduccion_de_la_Demanda_de_TI(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_8_Reduccion_de_la_Demanda_de_TI, value);
    }

/**
* Gets the P11_12_Otros2 property
* @return boolean with the P11_12_Otros2
*/
    public boolean isP11_12_Otros2()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_12_Otros2);
    }

/**
* Sets the P11_12_Otros2 property
* @param value long with the P11_12_Otros2
*/
    public void setP11_12_Otros2(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_12_Otros2, value);
    }

/**
* Gets the P11_11_Otros1 property
* @return boolean with the P11_11_Otros1
*/
    public boolean isP11_11_Otros1()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_11_Otros1);
    }

/**
* Sets the P11_11_Otros1 property
* @param value long with the P11_11_Otros1
*/
    public void setP11_11_Otros1(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_11_Otros1, value);
    }

/**
* Gets the P11_7_Retiros_de_Aplicaciones property
* @return boolean with the P11_7_Retiros_de_Aplicaciones
*/
    public boolean isP11_7_Retiros_de_Aplicaciones()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_7_Retiros_de_Aplicaciones);
    }

/**
* Sets the P11_7_Retiros_de_Aplicaciones property
* @param value long with the P11_7_Retiros_de_Aplicaciones
*/
    public void setP11_7_Retiros_de_Aplicaciones(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_7_Retiros_de_Aplicaciones, value);
    }

/**
* Gets the P11_2_Outsourcing property
* @return boolean with the P11_2_Outsourcing
*/
    public boolean isP11_2_Outsourcing()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_2_Outsourcing);
    }

/**
* Sets the P11_2_Outsourcing property
* @param value long with the P11_2_Outsourcing
*/
    public void setP11_2_Outsourcing(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_2_Outsourcing, value);
    }

/**
* Gets the P11_10_Traiga_sus_Propios_Dispositivos property
* @return boolean with the P11_10_Traiga_sus_Propios_Dispositivos
*/
    public boolean isP11_10_Traiga_sus_Propios_Dispositivos()
    {
        return getSemanticObject().getBooleanProperty(cts_p11_10_Traiga_sus_Propios_Dispositivos);
    }

/**
* Sets the P11_10_Traiga_sus_Propios_Dispositivos property
* @param value long with the P11_10_Traiga_sus_Propios_Dispositivos
*/
    public void setP11_10_Traiga_sus_Propios_Dispositivos(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p11_10_Traiga_sus_Propios_Dispositivos, value);
    }
}
