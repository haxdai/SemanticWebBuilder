package com.infotec.eworkplace.swb.base;


public abstract class IdiomaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Idioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idioma");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idioma");

    public static class ClassMgr
    {
       /**
       * Returns a list of Idioma for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Idioma for all models
       * @return Iterator of com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return A com.infotec.eworkplace.swb.Idioma
       */
        public static com.infotec.eworkplace.swb.Idioma getIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Idioma)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return A com.infotec.eworkplace.swb.Idioma
       */
        public static com.infotec.eworkplace.swb.Idioma createIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Idioma)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       */
        public static void removeIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return true if the com.infotec.eworkplace.swb.Idioma exists, false otherwise
       */

        public static boolean hasIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIdioma(id, model)!=null);
        }
    }

   /**
   * Constructs a IdiomaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Idioma
   */
    public IdiomaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
