package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para los Municipios de las Entidades Federativas 
   */
public abstract class MunicipioBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para los Códigos Postales definidos en México
   */
    public static final org.semanticwb.platform.SemanticClass intranet_CP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CP");
   /**
   * Lista de Códigos Postales asociados al Municipio
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCP");
   /**
   * Catálogo utilizado para almacenar las Entidades Federativas utilizadas en Domicilio de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_EntidadFederativa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EntidadFederativa");
    public static final org.semanticwb.platform.SemanticProperty intranet_entidadInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#entidadInv");
   /**
   * Catálogo utilizado para las colonias existentes en México
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Colonia");
   /**
   * Lista de colonias asociadas al Municipio
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasColonias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasColonias");
   /**
   * Catálogo utilizado para los Municipios de las Entidades Federativas
   */
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
       * Gets all com.infotec.cvi.swb.Municipio with a determined CP
       * @param value CP of the type com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByCP(com.infotec.cvi.swb.CP value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCP, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined CP
       * @param value CP of the type com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByCP(com.infotec.cvi.swb.CP value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCP,value.getSemanticObject(),sclass));
            return it;
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
       * Gets all com.infotec.cvi.swb.Municipio with a determined EntidadInv
       * @param value EntidadInv of the type com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByEntidadInv(com.infotec.cvi.swb.EntidadFederativa value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_entidadInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined EntidadInv
       * @param value EntidadInv of the type com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByEntidadInv(com.infotec.cvi.swb.EntidadFederativa value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_entidadInv,value.getSemanticObject(),sclass));
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
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined Colonias
       * @param value Colonias of the type com.infotec.cvi.swb.Colonia
       * @param model Model of the com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByColonias(com.infotec.cvi.swb.Colonia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasColonias, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Municipio with a determined Colonias
       * @param value Colonias of the type com.infotec.cvi.swb.Colonia
       * @return Iterator with all the com.infotec.cvi.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Municipio> listMunicipioByColonias(com.infotec.cvi.swb.Colonia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Municipio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasColonias,value.getSemanticObject(),sclass));
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
   /**
   * Gets all the com.infotec.cvi.swb.CP
   * @return A GenericIterator with all the com.infotec.cvi.swb.CP
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> listCPs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP>(getSemanticObject().listObjectProperties(intranet_hasCP));
    }

   /**
   * Gets true if has a CP
   * @param value com.infotec.cvi.swb.CP to verify
   * @return true if the com.infotec.cvi.swb.CP exists, false otherwise
   */
    public boolean hasCP(com.infotec.cvi.swb.CP value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCP,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CP
   * @param value com.infotec.cvi.swb.CP to add
   */

    public void addCP(com.infotec.cvi.swb.CP value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCP, value.getSemanticObject());
    }
   /**
   * Removes all the CP
   */

    public void removeAllCP()
    {
        getSemanticObject().removeProperty(intranet_hasCP);
    }
   /**
   * Removes a CP
   * @param value com.infotec.cvi.swb.CP to remove
   */

    public void removeCP(com.infotec.cvi.swb.CP value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCP,value.getSemanticObject());
    }

   /**
   * Gets the CP
   * @return a com.infotec.cvi.swb.CP
   */
    public com.infotec.cvi.swb.CP getCP()
    {
         com.infotec.cvi.swb.CP ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCP);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.CP)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EntidadInv
   * @param value EntidadInv to set
   */

    public void setEntidadInv(com.infotec.cvi.swb.EntidadFederativa value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_entidadInv, value.getSemanticObject());
        }else
        {
            removeEntidadInv();
        }
    }
   /**
   * Remove the value for EntidadInv property
   */

    public void removeEntidadInv()
    {
        getSemanticObject().removeProperty(intranet_entidadInv);
    }

   /**
   * Gets the EntidadInv
   * @return a com.infotec.cvi.swb.EntidadFederativa
   */
    public com.infotec.cvi.swb.EntidadFederativa getEntidadInv()
    {
         com.infotec.cvi.swb.EntidadFederativa ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_entidadInv);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.EntidadFederativa)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.Colonia
   * @return A GenericIterator with all the com.infotec.cvi.swb.Colonia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia> listColoniases()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Colonia>(getSemanticObject().listObjectProperties(intranet_hasColonias));
    }

   /**
   * Gets true if has a Colonias
   * @param value com.infotec.cvi.swb.Colonia to verify
   * @return true if the com.infotec.cvi.swb.Colonia exists, false otherwise
   */
    public boolean hasColonias(com.infotec.cvi.swb.Colonia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasColonias,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Colonias
   * @param value com.infotec.cvi.swb.Colonia to add
   */

    public void addColonias(com.infotec.cvi.swb.Colonia value)
    {
        getSemanticObject().addObjectProperty(intranet_hasColonias, value.getSemanticObject());
    }
   /**
   * Removes all the Colonias
   */

    public void removeAllColonias()
    {
        getSemanticObject().removeProperty(intranet_hasColonias);
    }
   /**
   * Removes a Colonias
   * @param value com.infotec.cvi.swb.Colonia to remove
   */

    public void removeColonias(com.infotec.cvi.swb.Colonia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasColonias,value.getSemanticObject());
    }

   /**
   * Gets the Colonias
   * @return a com.infotec.cvi.swb.Colonia
   */
    public com.infotec.cvi.swb.Colonia getColonias()
    {
         com.infotec.cvi.swb.Colonia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasColonias);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Colonia)obj.createGenericInstance();
         }
         return ret;
    }
}
