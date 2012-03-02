package com.infotec.cvi.swb.base;


public abstract class MunicipioBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
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
       * @return Iterator of com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Municipio for all models
       * @return Iterator of com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio>(it, true);
        }
       /**
       * Gets a com.infotec.cvi.swb.Municipio
       * @param id Identifier for com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return A com.infotec.cvi.swb.Municipio
       */
        public static com.infotec.cvi.swb.Municipio getMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Municipio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Municipio
       * @param id Identifier for com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return A com.infotec.cvi.swb.Municipio
       */
        public static com.infotec.cvi.swb.Municipio createMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Municipio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Municipio
       * @param id Identifier for com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.cvi.swb.Municipio
       */
        public static void removeMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Municipio
       * @param id Identifier for com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return true if the com.infotec.cvi.swb.Municipio exists, false otherwise
       */

        public static boolean hasMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMunicipio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
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
