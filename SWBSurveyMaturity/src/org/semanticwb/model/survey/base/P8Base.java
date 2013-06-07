package org.semanticwb.model.survey.base;


public abstract class P8Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass cts_IncrementoCosto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#IncrementoCosto");
    public static final org.semanticwb.platform.SemanticProperty cts_hasIncrementoCosto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#hasIncrementoCosto");
    public static final org.semanticwb.platform.SemanticClass cts_P8=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P8");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P8");

    public static class ClassMgr
    {
       /**
       * Returns a list of P8 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P8
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P8> listP8s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P8>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P8 for all models
       * @return Iterator of org.semanticwb.model.survey.P8
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P8> listP8s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P8>(it, true);
        }

        public static org.semanticwb.model.survey.P8 createP8(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P8.ClassMgr.createP8(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P8
       * @param id Identifier for org.semanticwb.model.survey.P8
       * @param model Model of the org.semanticwb.model.survey.P8
       * @return A org.semanticwb.model.survey.P8
       */
        public static org.semanticwb.model.survey.P8 getP8(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P8)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P8
       * @param id Identifier for org.semanticwb.model.survey.P8
       * @param model Model of the org.semanticwb.model.survey.P8
       * @return A org.semanticwb.model.survey.P8
       */
        public static org.semanticwb.model.survey.P8 createP8(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P8)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P8
       * @param id Identifier for org.semanticwb.model.survey.P8
       * @param model Model of the org.semanticwb.model.survey.P8
       */
        public static void removeP8(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P8
       * @param id Identifier for org.semanticwb.model.survey.P8
       * @param model Model of the org.semanticwb.model.survey.P8
       * @return true if the org.semanticwb.model.survey.P8 exists, false otherwise
       */

        public static boolean hasP8(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP8(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.P8 with a determined IncrementoCosto
       * @param value IncrementoCosto of the type org.semanticwb.model.survey.IncrementoCosto
       * @param model Model of the org.semanticwb.model.survey.P8
       * @return Iterator with all the org.semanticwb.model.survey.P8
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P8> listP8ByIncrementoCosto(org.semanticwb.model.survey.IncrementoCosto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P8> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_hasIncrementoCosto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.P8 with a determined IncrementoCosto
       * @param value IncrementoCosto of the type org.semanticwb.model.survey.IncrementoCosto
       * @return Iterator with all the org.semanticwb.model.survey.P8
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P8> listP8ByIncrementoCosto(org.semanticwb.model.survey.IncrementoCosto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P8> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_hasIncrementoCosto,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static P8Base.ClassMgr getP8ClassMgr()
    {
        return new P8Base.ClassMgr();
    }

   /**
   * Constructs a P8Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P8
   */
    public P8Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.model.survey.IncrementoCosto
   * @return A GenericIterator with all the org.semanticwb.model.survey.IncrementoCosto
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.IncrementoCosto> listIncrementoCostos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.IncrementoCosto>(getSemanticObject().listObjectProperties(cts_hasIncrementoCosto));
    }

   /**
   * Gets true if has a IncrementoCosto
   * @param value org.semanticwb.model.survey.IncrementoCosto to verify
   * @return true if the org.semanticwb.model.survey.IncrementoCosto exists, false otherwise
   */
    public boolean hasIncrementoCosto(org.semanticwb.model.survey.IncrementoCosto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cts_hasIncrementoCosto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a IncrementoCosto
   * @param value org.semanticwb.model.survey.IncrementoCosto to add
   */

    public void addIncrementoCosto(org.semanticwb.model.survey.IncrementoCosto value)
    {
        getSemanticObject().addObjectProperty(cts_hasIncrementoCosto, value.getSemanticObject());
    }
   /**
   * Removes all the IncrementoCosto
   */

    public void removeAllIncrementoCosto()
    {
        getSemanticObject().removeProperty(cts_hasIncrementoCosto);
    }
   /**
   * Removes a IncrementoCosto
   * @param value org.semanticwb.model.survey.IncrementoCosto to remove
   */

    public void removeIncrementoCosto(org.semanticwb.model.survey.IncrementoCosto value)
    {
        getSemanticObject().removeObjectProperty(cts_hasIncrementoCosto,value.getSemanticObject());
    }

   /**
   * Gets the IncrementoCosto
   * @return a org.semanticwb.model.survey.IncrementoCosto
   */
    public org.semanticwb.model.survey.IncrementoCosto getIncrementoCosto()
    {
         org.semanticwb.model.survey.IncrementoCosto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_hasIncrementoCosto);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.IncrementoCosto)obj.createGenericInstance();
         }
         return ret;
    }
}
