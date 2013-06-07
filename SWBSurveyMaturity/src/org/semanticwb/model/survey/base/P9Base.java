package org.semanticwb.model.survey.base;


public abstract class P9Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass cts_CostoAplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoAplicacion");
    public static final org.semanticwb.platform.SemanticProperty cts_hasCostoAplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#hasCostoAplicacion");
    public static final org.semanticwb.platform.SemanticClass cts_P9=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P9");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P9");

    public static class ClassMgr
    {
       /**
       * Returns a list of P9 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P9
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P9> listP9s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P9>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P9 for all models
       * @return Iterator of org.semanticwb.model.survey.P9
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P9> listP9s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P9>(it, true);
        }

        public static org.semanticwb.model.survey.P9 createP9(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P9.ClassMgr.createP9(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P9
       * @param id Identifier for org.semanticwb.model.survey.P9
       * @param model Model of the org.semanticwb.model.survey.P9
       * @return A org.semanticwb.model.survey.P9
       */
        public static org.semanticwb.model.survey.P9 getP9(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P9)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P9
       * @param id Identifier for org.semanticwb.model.survey.P9
       * @param model Model of the org.semanticwb.model.survey.P9
       * @return A org.semanticwb.model.survey.P9
       */
        public static org.semanticwb.model.survey.P9 createP9(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P9)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P9
       * @param id Identifier for org.semanticwb.model.survey.P9
       * @param model Model of the org.semanticwb.model.survey.P9
       */
        public static void removeP9(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P9
       * @param id Identifier for org.semanticwb.model.survey.P9
       * @param model Model of the org.semanticwb.model.survey.P9
       * @return true if the org.semanticwb.model.survey.P9 exists, false otherwise
       */

        public static boolean hasP9(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP9(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.P9 with a determined CostoAplicacion
       * @param value CostoAplicacion of the type org.semanticwb.model.survey.CostoAplicacion
       * @param model Model of the org.semanticwb.model.survey.P9
       * @return Iterator with all the org.semanticwb.model.survey.P9
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P9> listP9ByCostoAplicacion(org.semanticwb.model.survey.CostoAplicacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P9> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostoAplicacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.P9 with a determined CostoAplicacion
       * @param value CostoAplicacion of the type org.semanticwb.model.survey.CostoAplicacion
       * @return Iterator with all the org.semanticwb.model.survey.P9
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P9> listP9ByCostoAplicacion(org.semanticwb.model.survey.CostoAplicacion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P9> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostoAplicacion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static P9Base.ClassMgr getP9ClassMgr()
    {
        return new P9Base.ClassMgr();
    }

   /**
   * Constructs a P9Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P9
   */
    public P9Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.model.survey.CostoAplicacion
   * @return A GenericIterator with all the org.semanticwb.model.survey.CostoAplicacion
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion> listCostoAplicacions()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion>(getSemanticObject().listObjectProperties(cts_hasCostoAplicacion));
    }

   /**
   * Gets true if has a CostoAplicacion
   * @param value org.semanticwb.model.survey.CostoAplicacion to verify
   * @return true if the org.semanticwb.model.survey.CostoAplicacion exists, false otherwise
   */
    public boolean hasCostoAplicacion(org.semanticwb.model.survey.CostoAplicacion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cts_hasCostoAplicacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CostoAplicacion
   * @param value org.semanticwb.model.survey.CostoAplicacion to add
   */

    public void addCostoAplicacion(org.semanticwb.model.survey.CostoAplicacion value)
    {
        getSemanticObject().addObjectProperty(cts_hasCostoAplicacion, value.getSemanticObject());
    }
   /**
   * Removes all the CostoAplicacion
   */

    public void removeAllCostoAplicacion()
    {
        getSemanticObject().removeProperty(cts_hasCostoAplicacion);
    }
   /**
   * Removes a CostoAplicacion
   * @param value org.semanticwb.model.survey.CostoAplicacion to remove
   */

    public void removeCostoAplicacion(org.semanticwb.model.survey.CostoAplicacion value)
    {
        getSemanticObject().removeObjectProperty(cts_hasCostoAplicacion,value.getSemanticObject());
    }

   /**
   * Gets the CostoAplicacion
   * @return a org.semanticwb.model.survey.CostoAplicacion
   */
    public org.semanticwb.model.survey.CostoAplicacion getCostoAplicacion()
    {
         org.semanticwb.model.survey.CostoAplicacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_hasCostoAplicacion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.CostoAplicacion)obj.createGenericInstance();
         }
         return ret;
    }
}
