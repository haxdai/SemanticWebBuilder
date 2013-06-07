package org.semanticwb.model.survey.base;


public abstract class P2Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_p2_costo_outsourcing=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p2_costo_outsourcing");
    public static final org.semanticwb.platform.SemanticProperty cts_p2_costo_otros=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p2_costo_otros");
    public static final org.semanticwb.platform.SemanticProperty cts_p2_costo_personal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#p2_costo_personal");
    public static final org.semanticwb.platform.SemanticClass cts_P2=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P2");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P2");

    public static class ClassMgr
    {
       /**
       * Returns a list of P2 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P2
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P2> listP2s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P2>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P2 for all models
       * @return Iterator of org.semanticwb.model.survey.P2
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P2> listP2s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P2>(it, true);
        }

        public static org.semanticwb.model.survey.P2 createP2(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P2.ClassMgr.createP2(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P2
       * @param id Identifier for org.semanticwb.model.survey.P2
       * @param model Model of the org.semanticwb.model.survey.P2
       * @return A org.semanticwb.model.survey.P2
       */
        public static org.semanticwb.model.survey.P2 getP2(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P2)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P2
       * @param id Identifier for org.semanticwb.model.survey.P2
       * @param model Model of the org.semanticwb.model.survey.P2
       * @return A org.semanticwb.model.survey.P2
       */
        public static org.semanticwb.model.survey.P2 createP2(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P2)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P2
       * @param id Identifier for org.semanticwb.model.survey.P2
       * @param model Model of the org.semanticwb.model.survey.P2
       */
        public static void removeP2(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P2
       * @param id Identifier for org.semanticwb.model.survey.P2
       * @param model Model of the org.semanticwb.model.survey.P2
       * @return true if the org.semanticwb.model.survey.P2 exists, false otherwise
       */

        public static boolean hasP2(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP2(id, model)!=null);
        }
    }

    public static P2Base.ClassMgr getP2ClassMgr()
    {
        return new P2Base.ClassMgr();
    }

   /**
   * Constructs a P2Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P2
   */
    public P2Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the P2_costo_outsourcing property
* @return int with the P2_costo_outsourcing
*/
    public int getP2_costo_outsourcing()
    {
        return getSemanticObject().getIntProperty(cts_p2_costo_outsourcing);
    }

/**
* Sets the P2_costo_outsourcing property
* @param value long with the P2_costo_outsourcing
*/
    public void setP2_costo_outsourcing(int value)
    {
        getSemanticObject().setIntProperty(cts_p2_costo_outsourcing, value);
    }

/**
* Gets the P2_costo_otros property
* @return int with the P2_costo_otros
*/
    public int getP2_costo_otros()
    {
        return getSemanticObject().getIntProperty(cts_p2_costo_otros);
    }

/**
* Sets the P2_costo_otros property
* @param value long with the P2_costo_otros
*/
    public void setP2_costo_otros(int value)
    {
        getSemanticObject().setIntProperty(cts_p2_costo_otros, value);
    }

/**
* Gets the P2_costo_personal property
* @return int with the P2_costo_personal
*/
    public int getP2_costo_personal()
    {
        return getSemanticObject().getIntProperty(cts_p2_costo_personal);
    }

/**
* Sets the P2_costo_personal property
* @param value long with the P2_costo_personal
*/
    public void setP2_costo_personal(int value)
    {
        getSemanticObject().setIntProperty(cts_p2_costo_personal, value);
    }
}
