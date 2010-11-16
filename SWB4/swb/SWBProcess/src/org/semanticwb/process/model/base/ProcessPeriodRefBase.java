package org.semanticwb.process.model.base;


public abstract class ProcessPeriodRefBase extends org.semanticwb.model.Reference implements org.semanticwb.model.Activeable
{
    public static final org.semanticwb.platform.SemanticClass swp_ProcessPeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ProcessPeriod");
    public static final org.semanticwb.platform.SemanticProperty swp_processPeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/process#processPeriod");
    public static final org.semanticwb.platform.SemanticClass swp_ProcessPeriodRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ProcessPeriodRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ProcessPeriodRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProcessPeriodRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.ProcessPeriodRef
       */

        public static java.util.Iterator<org.semanticwb.process.model.ProcessPeriodRef> listProcessPeriodRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ProcessPeriodRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.ProcessPeriodRef for all models
       * @return Iterator of org.semanticwb.process.model.ProcessPeriodRef
       */

        public static java.util.Iterator<org.semanticwb.process.model.ProcessPeriodRef> listProcessPeriodRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ProcessPeriodRef>(it, true);
        }

        public static org.semanticwb.process.model.ProcessPeriodRef createProcessPeriodRef(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.model.ProcessPeriodRef.ClassMgr.createProcessPeriodRef(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.process.model.ProcessPeriodRef
       * @param id Identifier for org.semanticwb.process.model.ProcessPeriodRef
       * @param model Model of the org.semanticwb.process.model.ProcessPeriodRef
       * @return A org.semanticwb.process.model.ProcessPeriodRef
       */
        public static org.semanticwb.process.model.ProcessPeriodRef getProcessPeriodRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.ProcessPeriodRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.ProcessPeriodRef
       * @param id Identifier for org.semanticwb.process.model.ProcessPeriodRef
       * @param model Model of the org.semanticwb.process.model.ProcessPeriodRef
       * @return A org.semanticwb.process.model.ProcessPeriodRef
       */
        public static org.semanticwb.process.model.ProcessPeriodRef createProcessPeriodRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.ProcessPeriodRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.ProcessPeriodRef
       * @param id Identifier for org.semanticwb.process.model.ProcessPeriodRef
       * @param model Model of the org.semanticwb.process.model.ProcessPeriodRef
       */
        public static void removeProcessPeriodRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.ProcessPeriodRef
       * @param id Identifier for org.semanticwb.process.model.ProcessPeriodRef
       * @param model Model of the org.semanticwb.process.model.ProcessPeriodRef
       * @return true if the org.semanticwb.process.model.ProcessPeriodRef exists, false otherwise
       */

        public static boolean hasProcessPeriodRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProcessPeriodRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.ProcessPeriodRef with a determined ProcessPeriod
       * @param value ProcessPeriod of the type org.semanticwb.process.model.ProcessPeriod
       * @param model Model of the org.semanticwb.process.model.ProcessPeriodRef
       * @return Iterator with all the org.semanticwb.process.model.ProcessPeriodRef
       */

        public static java.util.Iterator<org.semanticwb.process.model.ProcessPeriodRef> listProcessPeriodRefByProcessPeriod(org.semanticwb.process.model.ProcessPeriod value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ProcessPeriodRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_processPeriod, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ProcessPeriodRef with a determined ProcessPeriod
       * @param value ProcessPeriod of the type org.semanticwb.process.model.ProcessPeriod
       * @return Iterator with all the org.semanticwb.process.model.ProcessPeriodRef
       */

        public static java.util.Iterator<org.semanticwb.process.model.ProcessPeriodRef> listProcessPeriodRefByProcessPeriod(org.semanticwb.process.model.ProcessPeriod value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ProcessPeriodRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_processPeriod,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProcessPeriodRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProcessPeriodRef
   */
    public ProcessPeriodRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ProcessPeriod
   * @param value ProcessPeriod to set
   */

    public void setProcessPeriod(org.semanticwb.process.model.ProcessPeriod value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swp_processPeriod, value.getSemanticObject());
        }else
        {
            removeProcessPeriod();
        }
    }
   /**
   * Remove the value for ProcessPeriod property
   */

    public void removeProcessPeriod()
    {
        getSemanticObject().removeProperty(swp_processPeriod);
    }

   /**
   * Gets the ProcessPeriod
   * @return a org.semanticwb.process.model.ProcessPeriod
   */
    public org.semanticwb.process.model.ProcessPeriod getProcessPeriod()
    {
         org.semanticwb.process.model.ProcessPeriod ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swp_processPeriod);
         if(obj!=null)
         {
             ret=(org.semanticwb.process.model.ProcessPeriod)obj.createGenericInstance();
         }
         return ret;
    }
}
