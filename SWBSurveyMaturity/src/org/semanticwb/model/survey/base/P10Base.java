package org.semanticwb.model.survey.base;


public abstract class P10Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_p10_2_Renovaciones_Tecnologicas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_2_Renovaciones_Tecnologicas");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_10_Traiga_sus_Propios_Dispositivos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_10_Traiga_sus_Propios_Dispositivos");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_4_Salarios_de_TI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_4_Salarios_de_TI");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_8_Conexiones_de_Red=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_8_Conexiones_de_Red");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_12_Otros2=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_12_Otros2");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_7_ERP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_7_ERP");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_9_Energia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_9_Energia");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_11_Otros1=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_11_Otros1");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_6_Recuperación_de_Desastres=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_6_Recuperación_de_Desastres");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_1_Requerimientos_de_Areas_Sustantivas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_1_Requerimientos_de_Areas_Sustantivas");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_6_Movilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_6_Movilidad");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_3_Seguridad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_3_Seguridad");
    public static final org.semanticwb.platform.SemanticProperty cts_p10_5_Cumplimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p10_5_Cumplimiento");
    public static final org.semanticwb.platform.SemanticClass cts_P10=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P10");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P10");

    public static class ClassMgr
    {
       /**
       * Returns a list of P10 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P10
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P10> listP10s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P10>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P10 for all models
       * @return Iterator of org.semanticwb.model.survey.P10
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P10> listP10s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P10>(it, true);
        }

        public static org.semanticwb.model.survey.P10 createP10(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P10.ClassMgr.createP10(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P10
       * @param id Identifier for org.semanticwb.model.survey.P10
       * @param model Model of the org.semanticwb.model.survey.P10
       * @return A org.semanticwb.model.survey.P10
       */
        public static org.semanticwb.model.survey.P10 getP10(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P10)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P10
       * @param id Identifier for org.semanticwb.model.survey.P10
       * @param model Model of the org.semanticwb.model.survey.P10
       * @return A org.semanticwb.model.survey.P10
       */
        public static org.semanticwb.model.survey.P10 createP10(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P10)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P10
       * @param id Identifier for org.semanticwb.model.survey.P10
       * @param model Model of the org.semanticwb.model.survey.P10
       */
        public static void removeP10(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P10
       * @param id Identifier for org.semanticwb.model.survey.P10
       * @param model Model of the org.semanticwb.model.survey.P10
       * @return true if the org.semanticwb.model.survey.P10 exists, false otherwise
       */

        public static boolean hasP10(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP10(id, model)!=null);
        }
    }

    public static P10Base.ClassMgr getP10ClassMgr()
    {
        return new P10Base.ClassMgr();
    }

   /**
   * Constructs a P10Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P10
   */
    public P10Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the P10_2_Renovaciones_Tecnologicas property
* @return boolean with the P10_2_Renovaciones_Tecnologicas
*/
    public boolean isP10_2_Renovaciones_Tecnologicas()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_2_Renovaciones_Tecnologicas);
    }

/**
* Sets the P10_2_Renovaciones_Tecnologicas property
* @param value long with the P10_2_Renovaciones_Tecnologicas
*/
    public void setP10_2_Renovaciones_Tecnologicas(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_2_Renovaciones_Tecnologicas, value);
    }

/**
* Gets the P10_10_Traiga_sus_Propios_Dispositivos property
* @return boolean with the P10_10_Traiga_sus_Propios_Dispositivos
*/
    public boolean isP10_10_Traiga_sus_Propios_Dispositivos()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_10_Traiga_sus_Propios_Dispositivos);
    }

/**
* Sets the P10_10_Traiga_sus_Propios_Dispositivos property
* @param value long with the P10_10_Traiga_sus_Propios_Dispositivos
*/
    public void setP10_10_Traiga_sus_Propios_Dispositivos(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_10_Traiga_sus_Propios_Dispositivos, value);
    }

/**
* Gets the P10_4_Salarios_de_TI property
* @return boolean with the P10_4_Salarios_de_TI
*/
    public boolean isP10_4_Salarios_de_TI()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_4_Salarios_de_TI);
    }

/**
* Sets the P10_4_Salarios_de_TI property
* @param value long with the P10_4_Salarios_de_TI
*/
    public void setP10_4_Salarios_de_TI(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_4_Salarios_de_TI, value);
    }

/**
* Gets the P10_8_Conexiones_de_Red property
* @return boolean with the P10_8_Conexiones_de_Red
*/
    public boolean isP10_8_Conexiones_de_Red()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_8_Conexiones_de_Red);
    }

/**
* Sets the P10_8_Conexiones_de_Red property
* @param value long with the P10_8_Conexiones_de_Red
*/
    public void setP10_8_Conexiones_de_Red(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_8_Conexiones_de_Red, value);
    }

/**
* Gets the P10_12_Otros2 property
* @return boolean with the P10_12_Otros2
*/
    public boolean isP10_12_Otros2()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_12_Otros2);
    }

/**
* Sets the P10_12_Otros2 property
* @param value long with the P10_12_Otros2
*/
    public void setP10_12_Otros2(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_12_Otros2, value);
    }

/**
* Gets the P10_7_ERP property
* @return boolean with the P10_7_ERP
*/
    public boolean isP10_7_ERP()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_7_ERP);
    }

/**
* Sets the P10_7_ERP property
* @param value long with the P10_7_ERP
*/
    public void setP10_7_ERP(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_7_ERP, value);
    }

/**
* Gets the P10_9_Energia property
* @return boolean with the P10_9_Energia
*/
    public boolean isP10_9_Energia()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_9_Energia);
    }

/**
* Sets the P10_9_Energia property
* @param value long with the P10_9_Energia
*/
    public void setP10_9_Energia(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_9_Energia, value);
    }

/**
* Gets the P10_11_Otros1 property
* @return boolean with the P10_11_Otros1
*/
    public boolean isP10_11_Otros1()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_11_Otros1);
    }

/**
* Sets the P10_11_Otros1 property
* @param value long with the P10_11_Otros1
*/
    public void setP10_11_Otros1(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_11_Otros1, value);
    }

/**
* Gets the P10_6_Recuperación_de_Desastres property
* @return boolean with the P10_6_Recuperación_de_Desastres
*/
    public boolean isP10_6_Recuperación_de_Desastres()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_6_Recuperación_de_Desastres);
    }

/**
* Sets the P10_6_Recuperación_de_Desastres property
* @param value long with the P10_6_Recuperación_de_Desastres
*/
    public void setP10_6_Recuperación_de_Desastres(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_6_Recuperación_de_Desastres, value);
    }

/**
* Gets the P10_1_Requerimientos_de_Areas_Sustantivas property
* @return boolean with the P10_1_Requerimientos_de_Areas_Sustantivas
*/
    public boolean isP10_1_Requerimientos_de_Areas_Sustantivas()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_1_Requerimientos_de_Areas_Sustantivas);
    }

/**
* Sets the P10_1_Requerimientos_de_Areas_Sustantivas property
* @param value long with the P10_1_Requerimientos_de_Areas_Sustantivas
*/
    public void setP10_1_Requerimientos_de_Areas_Sustantivas(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_1_Requerimientos_de_Areas_Sustantivas, value);
    }

/**
* Gets the P10_6_Movilidad property
* @return boolean with the P10_6_Movilidad
*/
    public boolean isP10_6_Movilidad()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_6_Movilidad);
    }

/**
* Sets the P10_6_Movilidad property
* @param value long with the P10_6_Movilidad
*/
    public void setP10_6_Movilidad(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_6_Movilidad, value);
    }

/**
* Gets the P10_3_Seguridad property
* @return boolean with the P10_3_Seguridad
*/
    public boolean isP10_3_Seguridad()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_3_Seguridad);
    }

/**
* Sets the P10_3_Seguridad property
* @param value long with the P10_3_Seguridad
*/
    public void setP10_3_Seguridad(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_3_Seguridad, value);
    }

/**
* Gets the P10_5_Cumplimiento property
* @return boolean with the P10_5_Cumplimiento
*/
    public boolean isP10_5_Cumplimiento()
    {
        return getSemanticObject().getBooleanProperty(cts_p10_5_Cumplimiento);
    }

/**
* Sets the P10_5_Cumplimiento property
* @param value long with the P10_5_Cumplimiento
*/
    public void setP10_5_Cumplimiento(boolean value)
    {
        getSemanticObject().setBooleanProperty(cts_p10_5_Cumplimiento, value);
    }
}
