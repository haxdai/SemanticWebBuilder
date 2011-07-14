package org.semanticwb.promexico.base;


   /**
   * Eventos de ProMéxico 
   */
public abstract class ProMxEventBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Eventos de ProMéxico
   */
    public static final org.semanticwb.platform.SemanticClass promx_ProMxEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxEvent");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxEvent");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProMxEvent for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.ProMxEvent
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxEvent> listProMxEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxEvent>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.ProMxEvent for all models
       * @return Iterator of org.semanticwb.promexico.ProMxEvent
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxEvent> listProMxEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxEvent>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.ProMxEvent
       * @param id Identifier for org.semanticwb.promexico.ProMxEvent
       * @param model Model of the org.semanticwb.promexico.ProMxEvent
       * @return A org.semanticwb.promexico.ProMxEvent
       */
        public static org.semanticwb.promexico.ProMxEvent getProMxEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProMxEvent)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.ProMxEvent
       * @param id Identifier for org.semanticwb.promexico.ProMxEvent
       * @param model Model of the org.semanticwb.promexico.ProMxEvent
       * @return A org.semanticwb.promexico.ProMxEvent
       */
        public static org.semanticwb.promexico.ProMxEvent createProMxEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProMxEvent)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.ProMxEvent
       * @param id Identifier for org.semanticwb.promexico.ProMxEvent
       * @param model Model of the org.semanticwb.promexico.ProMxEvent
       */
        public static void removeProMxEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.ProMxEvent
       * @param id Identifier for org.semanticwb.promexico.ProMxEvent
       * @param model Model of the org.semanticwb.promexico.ProMxEvent
       * @return true if the org.semanticwb.promexico.ProMxEvent exists, false otherwise
       */

        public static boolean hasProMxEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProMxEvent(id, model)!=null);
        }
    }

   /**
   * Constructs a ProMxEventBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProMxEvent
   */
    public ProMxEventBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
