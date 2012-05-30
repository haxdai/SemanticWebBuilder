package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para almacenar los diferentes Estudios Superiores 
   */
public abstract class EstudiosBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para las areas que agrupan a las carreras de los Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_AreaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaEstudio");
   /**
   * Área de Estudio a la cual pertenece el Estudio Superior
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_areaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaEstudio");
   /**
   * Catálogo utilizado para almacenar los diferentes Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Estudios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estudios");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estudios");

    public static class ClassMgr
    {
       /**
       * Returns a list of Estudios for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudioses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Estudios for all models
       * @return Iterator of com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudioses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios>(it, true);
        }

        public static com.infotec.cvi.swb.Estudios createEstudios(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Estudios.ClassMgr.createEstudios(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Estudios
       * @param id Identifier for com.infotec.cvi.swb.Estudios
       * @param model Model of the com.infotec.cvi.swb.Estudios
       * @return A com.infotec.cvi.swb.Estudios
       */
        public static com.infotec.cvi.swb.Estudios getEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Estudios)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Estudios
       * @param id Identifier for com.infotec.cvi.swb.Estudios
       * @param model Model of the com.infotec.cvi.swb.Estudios
       * @return A com.infotec.cvi.swb.Estudios
       */
        public static com.infotec.cvi.swb.Estudios createEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Estudios)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Estudios
       * @param id Identifier for com.infotec.cvi.swb.Estudios
       * @param model Model of the com.infotec.cvi.swb.Estudios
       */
        public static void removeEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Estudios
       * @param id Identifier for com.infotec.cvi.swb.Estudios
       * @param model Model of the com.infotec.cvi.swb.Estudios
       * @return true if the com.infotec.cvi.swb.Estudios exists, false otherwise
       */

        public static boolean hasEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEstudios(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Estudios with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Estudios
       * @return Iterator with all the com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudiosByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estudios with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudiosByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estudios with a determined AreaEstudio
       * @param value AreaEstudio of the type com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.Estudios
       * @return Iterator with all the com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudiosByAreaEstudio(com.infotec.cvi.swb.AreaEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_areaEstudio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estudios with a determined AreaEstudio
       * @param value AreaEstudio of the type com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudiosByAreaEstudio(com.infotec.cvi.swb.AreaEstudio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_areaEstudio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estudios with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Estudios
       * @return Iterator with all the com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudiosByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Estudios with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Estudios> listEstudiosByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EstudiosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Estudios
   */
    public EstudiosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property AreaEstudio
   * @param value AreaEstudio to set
   */

    public void setAreaEstudio(com.infotec.cvi.swb.AreaEstudio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_areaEstudio, value.getSemanticObject());
        }else
        {
            removeAreaEstudio();
        }
    }
   /**
   * Remove the value for AreaEstudio property
   */

    public void removeAreaEstudio()
    {
        getSemanticObject().removeProperty(intranet_areaEstudio);
    }

   /**
   * Gets the AreaEstudio
   * @return a com.infotec.cvi.swb.AreaEstudio
   */
    public com.infotec.cvi.swb.AreaEstudio getAreaEstudio()
    {
         com.infotec.cvi.swb.AreaEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_areaEstudio);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.AreaEstudio)obj.createGenericInstance();
         }
         return ret;
    }
}
