package com.infotec.eworkplace.swb.base;


public abstract class ExperienciaLaboralBase extends com.infotec.eworkplace.swb.ExperienciaProfesional implements com.infotec.eworkplace.swb.Telefoneable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaFin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaFin");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaIni=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaIni");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombrePuestoJefe=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombrePuestoJefe");
    public static final org.semanticwb.platform.SemanticProperty intranet_empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#empresa");
    public static final org.semanticwb.platform.SemanticProperty intranet_actual=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#actual");
    public static final org.semanticwb.platform.SemanticClass intranet_ExperienciaLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ExperienciaLaboral");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ExperienciaLaboral");

    public static class ClassMgr
    {
       /**
       * Returns a list of ExperienciaLaboral for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaborals(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ExperienciaLaboral for all models
       * @return Iterator of com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaborals()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral>(it, true);
        }

        public static com.infotec.eworkplace.swb.ExperienciaLaboral createExperienciaLaboral(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.ExperienciaLaboral.ClassMgr.createExperienciaLaboral(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param id Identifier for com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param model Model of the com.infotec.eworkplace.swb.ExperienciaLaboral
       * @return A com.infotec.eworkplace.swb.ExperienciaLaboral
       */
        public static com.infotec.eworkplace.swb.ExperienciaLaboral getExperienciaLaboral(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ExperienciaLaboral)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param id Identifier for com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param model Model of the com.infotec.eworkplace.swb.ExperienciaLaboral
       * @return A com.infotec.eworkplace.swb.ExperienciaLaboral
       */
        public static com.infotec.eworkplace.swb.ExperienciaLaboral createExperienciaLaboral(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ExperienciaLaboral)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param id Identifier for com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param model Model of the com.infotec.eworkplace.swb.ExperienciaLaboral
       */
        public static void removeExperienciaLaboral(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param id Identifier for com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param model Model of the com.infotec.eworkplace.swb.ExperienciaLaboral
       * @return true if the com.infotec.eworkplace.swb.ExperienciaLaboral exists, false otherwise
       */

        public static boolean hasExperienciaLaboral(String id, org.semanticwb.model.SWBModel model)
        {
            return (getExperienciaLaboral(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ExperienciaLaboral with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ExperienciaLaboral
       * @return Iterator with all the com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaboralByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ExperienciaLaboral with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaboralByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ExperienciaLaboral with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ExperienciaLaboral
       * @return Iterator with all the com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaboralByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ExperienciaLaboral with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaboralByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ExperienciaLaboral with a determined Telefono
       * @param value Telefono of the type com.infotec.eworkplace.swb.Telefono
       * @param model Model of the com.infotec.eworkplace.swb.ExperienciaLaboral
       * @return Iterator with all the com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaboralByTelefono(com.infotec.eworkplace.swb.Telefono value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_telefono, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ExperienciaLaboral with a determined Telefono
       * @param value Telefono of the type com.infotec.eworkplace.swb.Telefono
       * @return Iterator with all the com.infotec.eworkplace.swb.ExperienciaLaboral
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaboralByTelefono(com.infotec.eworkplace.swb.Telefono value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_telefono,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ExperienciaLaboralBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ExperienciaLaboral
   */
    public ExperienciaLaboralBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the FechaFin property
* @return java.util.Date with the FechaFin
*/
    public java.util.Date getFechaFin()
    {
        return getSemanticObject().getDateProperty(intranet_fechaFin);
    }

/**
* Sets the FechaFin property
* @param value long with the FechaFin
*/
    public void setFechaFin(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaFin, value);
    }

/**
* Gets the FechaIni property
* @return java.util.Date with the FechaIni
*/
    public java.util.Date getFechaIni()
    {
        return getSemanticObject().getDateProperty(intranet_fechaIni);
    }

/**
* Sets the FechaIni property
* @param value long with the FechaIni
*/
    public void setFechaIni(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaIni, value);
    }
   /**
   * Sets the value for the property Telefono
   * @param value Telefono to set
   */

    public void setTelefono(com.infotec.eworkplace.swb.Telefono value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_telefono, value.getSemanticObject());
        }else
        {
            removeTelefono();
        }
    }
   /**
   * Remove the value for Telefono property
   */

    public void removeTelefono()
    {
        getSemanticObject().removeProperty(intranet_telefono);
    }

   /**
   * Gets the Telefono
   * @return a com.infotec.eworkplace.swb.Telefono
   */
    public com.infotec.eworkplace.swb.Telefono getTelefono()
    {
         com.infotec.eworkplace.swb.Telefono ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_telefono);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Telefono)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NombrePuestoJefe property
* @return String with the NombrePuestoJefe
*/
    public String getNombrePuestoJefe()
    {
        return getSemanticObject().getProperty(intranet_nombrePuestoJefe);
    }

/**
* Sets the NombrePuestoJefe property
* @param value long with the NombrePuestoJefe
*/
    public void setNombrePuestoJefe(String value)
    {
        getSemanticObject().setProperty(intranet_nombrePuestoJefe, value);
    }

/**
* Gets the Empresa property
* @return String with the Empresa
*/
    public String getEmpresa()
    {
        return getSemanticObject().getProperty(intranet_empresa);
    }

/**
* Sets the Empresa property
* @param value long with the Empresa
*/
    public void setEmpresa(String value)
    {
        getSemanticObject().setProperty(intranet_empresa, value);
    }

/**
* Gets the Actual property
* @return boolean with the Actual
*/
    public boolean isActual()
    {
        return getSemanticObject().getBooleanProperty(intranet_actual);
    }

/**
* Sets the Actual property
* @param value long with the Actual
*/
    public void setActual(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_actual, value);
    }
}
