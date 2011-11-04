package com.infotec.eworkplace.swb.base;


public abstract class VacacionesBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable
{
   /**
   * Return to work date
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_presentandose=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#presentandose");
   /**
   * Termination date of the holiday
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_finVacaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#finVacaciones");
   /**
   * Start date of holiday
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_inicioVacaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#inicioVacaciones");
   /**
   * Years holiday period
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_periodo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#periodo");
    public static final org.semanticwb.platform.SemanticClass ewp_Vacaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Vacaciones");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Vacaciones");

    public static class ClassMgr
    {
       /**
       * Returns a list of Vacaciones for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacioneses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Vacaciones for all models
       * @return Iterator of com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacioneses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones>(it, true);
        }

        public static com.infotec.eworkplace.swb.Vacaciones createVacaciones(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Vacaciones.ClassMgr.createVacaciones(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return A com.infotec.eworkplace.swb.Vacaciones
       */
        public static com.infotec.eworkplace.swb.Vacaciones getVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Vacaciones)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return A com.infotec.eworkplace.swb.Vacaciones
       */
        public static com.infotec.eworkplace.swb.Vacaciones createVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Vacaciones)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       */
        public static void removeVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return true if the com.infotec.eworkplace.swb.Vacaciones exists, false otherwise
       */

        public static boolean hasVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVacaciones(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a VacacionesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Vacaciones
   */
    public VacacionesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Presentandose property
* @return java.util.Date with the Presentandose
*/
    public java.util.Date getPresentandose()
    {
        return getSemanticObject().getDateProperty(ewp_presentandose);
    }

/**
* Sets the Presentandose property
* @param value long with the Presentandose
*/
    public void setPresentandose(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_presentandose, value);
    }
   /**
   * Sets the value for the property Solicitante
   * @param value Solicitante to set
   */

    public void setSolicitante(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_solicitante, value.getSemanticObject());
        }else
        {
            removeSolicitante();
        }
    }
   /**
   * Remove the value for Solicitante property
   */

    public void removeSolicitante()
    {
        getSemanticObject().removeProperty(ewp_solicitante);
    }

   /**
   * Gets the Solicitante
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSolicitante()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_solicitante);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FinVacaciones property
* @return java.util.Date with the FinVacaciones
*/
    public java.util.Date getFinVacaciones()
    {
        return getSemanticObject().getDateProperty(ewp_finVacaciones);
    }

/**
* Sets the FinVacaciones property
* @param value long with the FinVacaciones
*/
    public void setFinVacaciones(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_finVacaciones, value);
    }

/**
* Gets the InicioVacaciones property
* @return java.util.Date with the InicioVacaciones
*/
    public java.util.Date getInicioVacaciones()
    {
        return getSemanticObject().getDateProperty(ewp_inicioVacaciones);
    }

/**
* Sets the InicioVacaciones property
* @param value long with the InicioVacaciones
*/
    public void setInicioVacaciones(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_inicioVacaciones, value);
    }

/**
* Gets the Periodo property
* @return String with the Periodo
*/
    public String getPeriodo()
    {
        return getSemanticObject().getProperty(ewp_periodo);
    }

/**
* Sets the Periodo property
* @param value long with the Periodo
*/
    public void setPeriodo(String value)
    {
        getSemanticObject().setProperty(ewp_periodo, value);
    }
}
