package com.infotec.eworkplace.swb.base;


public abstract class MunicipioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Municipio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Municipio");

    public static class ClassMgr
    {
       /**
       * Returns a list of Municipio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Municipio> listMunicipios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Municipio>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Municipio for all models
       * @return Iterator of com.infotec.eworkplace.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Municipio> listMunicipios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Municipio>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       * @return A com.infotec.eworkplace.swb.Municipio
       */
        public static com.infotec.eworkplace.swb.Municipio getMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Municipio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       * @return A com.infotec.eworkplace.swb.Municipio
       */
        public static com.infotec.eworkplace.swb.Municipio createMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Municipio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       */
        public static void removeMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       * @return true if the com.infotec.eworkplace.swb.Municipio exists, false otherwise
       */

        public static boolean hasMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMunicipio(id, model)!=null);
        }
    }

   /**
   * Constructs a MunicipioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Municipio
   */
    public MunicipioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
