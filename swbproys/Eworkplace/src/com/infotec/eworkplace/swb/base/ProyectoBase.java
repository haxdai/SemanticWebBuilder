package com.infotec.eworkplace.swb.base;


public abstract class ProyectoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");

    public static class ClassMgr
    {
       /**
       * Returns a list of Proyecto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Proyecto for all models
       * @return Iterator of com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return A com.infotec.eworkplace.swb.Proyecto
       */
        public static com.infotec.eworkplace.swb.Proyecto getProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Proyecto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return A com.infotec.eworkplace.swb.Proyecto
       */
        public static com.infotec.eworkplace.swb.Proyecto createProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Proyecto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       */
        public static void removeProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return true if the com.infotec.eworkplace.swb.Proyecto exists, false otherwise
       */

        public static boolean hasProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProyecto(id, model)!=null);
        }
    }

   /**
   * Constructs a ProyectoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Proyecto
   */
    public ProyectoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
