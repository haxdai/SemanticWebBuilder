package org.semanticwb.model.survey.base;


public abstract class P13Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office");
    public static final org.semanticwb.platform.SemanticProperty cts_p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office");
    public static final org.semanticwb.platform.SemanticClass cts_P13=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P13");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P13");

    public static class ClassMgr
    {
       /**
       * Returns a list of P13 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P13
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P13> listP13s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P13>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P13 for all models
       * @return Iterator of org.semanticwb.model.survey.P13
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P13> listP13s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P13>(it, true);
        }

        public static org.semanticwb.model.survey.P13 createP13(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P13.ClassMgr.createP13(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P13
       * @param id Identifier for org.semanticwb.model.survey.P13
       * @param model Model of the org.semanticwb.model.survey.P13
       * @return A org.semanticwb.model.survey.P13
       */
        public static org.semanticwb.model.survey.P13 getP13(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P13)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P13
       * @param id Identifier for org.semanticwb.model.survey.P13
       * @param model Model of the org.semanticwb.model.survey.P13
       * @return A org.semanticwb.model.survey.P13
       */
        public static org.semanticwb.model.survey.P13 createP13(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P13)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P13
       * @param id Identifier for org.semanticwb.model.survey.P13
       * @param model Model of the org.semanticwb.model.survey.P13
       */
        public static void removeP13(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P13
       * @param id Identifier for org.semanticwb.model.survey.P13
       * @param model Model of the org.semanticwb.model.survey.P13
       * @return true if the org.semanticwb.model.survey.P13 exists, false otherwise
       */

        public static boolean hasP13(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP13(id, model)!=null);
        }
    }

    public static P13Base.ClassMgr getP13ClassMgr()
    {
        return new P13Base.ClassMgr();
    }

   /**
   * Constructs a P13Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P13
   */
    public P13Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office property
* @return int with the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office
*/
    public int getP13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office()
    {
        return getSemanticObject().getIntProperty(cts_p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office);
    }

/**
* Sets the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office property
* @param value long with the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office
*/
    public void setP13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office(int value)
    {
        getSemanticObject().setIntProperty(cts_p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office, value);
    }

/**
* Gets the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office property
* @return int with the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office
*/
    public int getP13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office()
    {
        return getSemanticObject().getIntProperty(cts_p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office);
    }

/**
* Sets the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office property
* @param value long with the P13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office
*/
    public void setP13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office(int value)
    {
        getSemanticObject().setIntProperty(cts_p13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office, value);
    }
}
