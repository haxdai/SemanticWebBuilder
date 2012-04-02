package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para almacenar las Entidades Federativas utilizadas en Domicilio de la persona 
   */
public abstract class EntidadFederativaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para los Municipios de las Entidades Federativas
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Municipio");
   /**
   * Lista de municipios que pertenecen a una Entidad Federativa
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasMunicipios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasMunicipios");
   /**
   * Catálogo utilizado para almacenar las Entidades Federativas utilizadas en Domicilio de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_EntidadFederativa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EntidadFederativa");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EntidadFederativa");

    public static class ClassMgr
    {
       /**
       * Returns a list of EntidadFederativa for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.EntidadFederativa for all models
       * @return Iterator of com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa>(it, true);
        }
       /**
       * Gets a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return A com.infotec.cvi.swb.EntidadFederativa
       */
        public static com.infotec.cvi.swb.EntidadFederativa getEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.EntidadFederativa)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return A com.infotec.cvi.swb.EntidadFederativa
       */
        public static com.infotec.cvi.swb.EntidadFederativa createEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.EntidadFederativa)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       */
        public static void removeEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return true if the com.infotec.cvi.swb.EntidadFederativa exists, false otherwise
       */

        public static boolean hasEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEntidadFederativa(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined Municipios
       * @param value Municipios of the type com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByMunicipios(com.infotec.cvi.swb.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasMunicipios, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined Municipios
       * @param value Municipios of the type com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByMunicipios(com.infotec.cvi.swb.Municipio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasMunicipios,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EntidadFederativaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EntidadFederativa
   */
    public EntidadFederativaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.Municipio
   * @return A GenericIterator with all the com.infotec.cvi.swb.Municipio
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> listMunicipioses()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio>(getSemanticObject().listObjectProperties(intranet_hasMunicipios));
    }

   /**
   * Gets true if has a Municipios
   * @param value com.infotec.cvi.swb.Municipio to verify
   * @return true if the com.infotec.cvi.swb.Municipio exists, false otherwise
   */
    public boolean hasMunicipios(com.infotec.cvi.swb.Municipio value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasMunicipios,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Municipios
   * @param value com.infotec.cvi.swb.Municipio to add
   */

    public void addMunicipios(com.infotec.cvi.swb.Municipio value)
    {
        getSemanticObject().addObjectProperty(intranet_hasMunicipios, value.getSemanticObject());
    }
   /**
   * Removes all the Municipios
   */

    public void removeAllMunicipios()
    {
        getSemanticObject().removeProperty(intranet_hasMunicipios);
    }
   /**
   * Removes a Municipios
   * @param value com.infotec.cvi.swb.Municipio to remove
   */

    public void removeMunicipios(com.infotec.cvi.swb.Municipio value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasMunicipios,value.getSemanticObject());
    }

   /**
   * Gets the Municipios
   * @return a com.infotec.cvi.swb.Municipio
   */
    public com.infotec.cvi.swb.Municipio getMunicipios()
    {
         com.infotec.cvi.swb.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasMunicipios);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Municipio)obj.createGenericInstance();
         }
         return ret;
    }
}
