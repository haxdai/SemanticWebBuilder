package org.semanticwb.cptm.base;


public abstract class Prueba2Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass cptm_Prueba2=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Prueba2");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Prueba2");

    public static class ClassMgr
    {
       /**
       * Returns a list of Prueba2 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Prueba2
       */

        public static java.util.Iterator<org.semanticwb.cptm.Prueba2> listPrueba2s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Prueba2>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Prueba2 for all models
       * @return Iterator of org.semanticwb.cptm.Prueba2
       */

        public static java.util.Iterator<org.semanticwb.cptm.Prueba2> listPrueba2s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Prueba2>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Prueba2
       * @param id Identifier for org.semanticwb.cptm.Prueba2
       * @param model Model of the org.semanticwb.cptm.Prueba2
       * @return A org.semanticwb.cptm.Prueba2
       */
        public static org.semanticwb.cptm.Prueba2 getPrueba2(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Prueba2)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Prueba2
       * @param id Identifier for org.semanticwb.cptm.Prueba2
       * @param model Model of the org.semanticwb.cptm.Prueba2
       * @return A org.semanticwb.cptm.Prueba2
       */
        public static org.semanticwb.cptm.Prueba2 createPrueba2(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Prueba2)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Prueba2
       * @param id Identifier for org.semanticwb.cptm.Prueba2
       * @param model Model of the org.semanticwb.cptm.Prueba2
       */
        public static void removePrueba2(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Prueba2
       * @param id Identifier for org.semanticwb.cptm.Prueba2
       * @param model Model of the org.semanticwb.cptm.Prueba2
       * @return true if the org.semanticwb.cptm.Prueba2 exists, false otherwise
       */

        public static boolean hasPrueba2(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPrueba2(id, model)!=null);
        }
    }

   /**
   * Constructs a Prueba2Base with a SemanticObject
   * @param base The SemanticObject with the properties for the Prueba2
   */
    public Prueba2Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
