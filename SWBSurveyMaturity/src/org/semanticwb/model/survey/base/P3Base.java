package org.semanticwb.model.survey.base;


public abstract class P3Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_costo_total_de_otros_costos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#costo_total_de_otros_costos");
    public static final org.semanticwb.platform.SemanticProperty cts_p3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal");
    public static final org.semanticwb.platform.SemanticProperty cts_costo_total_de_outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#costo_total_de_outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_p3_costo_total_de_personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p3_costo_total_de_personal");
    public static final org.semanticwb.platform.SemanticClass cts_P3=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P3");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P3");

    public static class ClassMgr
    {
       /**
       * Returns a list of P3 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P3
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P3> listP3s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P3>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P3 for all models
       * @return Iterator of org.semanticwb.model.survey.P3
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P3> listP3s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P3>(it, true);
        }

        public static org.semanticwb.model.survey.P3 createP3(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P3.ClassMgr.createP3(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P3
       * @param id Identifier for org.semanticwb.model.survey.P3
       * @param model Model of the org.semanticwb.model.survey.P3
       * @return A org.semanticwb.model.survey.P3
       */
        public static org.semanticwb.model.survey.P3 getP3(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P3)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P3
       * @param id Identifier for org.semanticwb.model.survey.P3
       * @param model Model of the org.semanticwb.model.survey.P3
       * @return A org.semanticwb.model.survey.P3
       */
        public static org.semanticwb.model.survey.P3 createP3(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P3)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P3
       * @param id Identifier for org.semanticwb.model.survey.P3
       * @param model Model of the org.semanticwb.model.survey.P3
       */
        public static void removeP3(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P3
       * @param id Identifier for org.semanticwb.model.survey.P3
       * @param model Model of the org.semanticwb.model.survey.P3
       * @return true if the org.semanticwb.model.survey.P3 exists, false otherwise
       */

        public static boolean hasP3(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP3(id, model)!=null);
        }
    }

    public static P3Base.ClassMgr getP3ClassMgr()
    {
        return new P3Base.ClassMgr();
    }

   /**
   * Constructs a P3Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P3
   */
    public P3Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Costo_total_de_otros_costos property
* @return int with the Costo_total_de_otros_costos
*/
    public int getCosto_total_de_otros_costos()
    {
        return getSemanticObject().getIntProperty(cts_costo_total_de_otros_costos);
    }

/**
* Sets the Costo_total_de_otros_costos property
* @param value long with the Costo_total_de_otros_costos
*/
    public void setCosto_total_de_otros_costos(int value)
    {
        getSemanticObject().setIntProperty(cts_costo_total_de_otros_costos, value);
    }

/**
* Gets the P3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal property
* @return int with the P3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal
*/
    public int getP3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal()
    {
        return getSemanticObject().getIntProperty(cts_p3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal);
    }

/**
* Sets the P3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal property
* @param value long with the P3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal
*/
    public void setP3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal(int value)
    {
        getSemanticObject().setIntProperty(cts_p3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal, value);
    }

/**
* Gets the Costo_total_de_outsourcing property
* @return int with the Costo_total_de_outsourcing
*/
    public int getCosto_total_de_outsourcing()
    {
        return getSemanticObject().getIntProperty(cts_costo_total_de_outsourcing);
    }

/**
* Sets the Costo_total_de_outsourcing property
* @param value long with the Costo_total_de_outsourcing
*/
    public void setCosto_total_de_outsourcing(int value)
    {
        getSemanticObject().setIntProperty(cts_costo_total_de_outsourcing, value);
    }

/**
* Gets the P3_costo_total_de_personal property
* @return int with the P3_costo_total_de_personal
*/
    public int getP3_costo_total_de_personal()
    {
        return getSemanticObject().getIntProperty(cts_p3_costo_total_de_personal);
    }

/**
* Sets the P3_costo_total_de_personal property
* @param value long with the P3_costo_total_de_personal
*/
    public void setP3_costo_total_de_personal(int value)
    {
        getSemanticObject().setIntProperty(cts_p3_costo_total_de_personal, value);
    }
}
