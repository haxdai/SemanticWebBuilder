package com.infotec.eworkplace.swb.base;


public abstract class ReservacionSalaBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable,org.semanticwb.model.Iconable,org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaFinal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaFinal");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereCafeSoluble=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereCafeSoluble");
    public static final org.semanticwb.platform.SemanticProperty intranet_horarioServicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#horarioServicio");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaInicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaInicio");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereComputo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereComputo");
    public static final org.semanticwb.platform.SemanticClass intranet_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sala");
    public static final org.semanticwb.platform.SemanticProperty intranet_sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sala");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivo");
    public static final org.semanticwb.platform.SemanticProperty intranet_pId=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#pId");
    public static final org.semanticwb.platform.SemanticProperty intranet_asistentes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#asistentes");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereProyector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereProyector");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereCafeGrano=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereCafeGrano");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereGalletas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereGalletas");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereServicioContinuo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereServicioContinuo");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoReunion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoReunion");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereAgua=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereAgua");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereRefrescos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereRefrescos");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoCafeteria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoCafeteria");
    public static final org.semanticwb.platform.SemanticProperty intranet_serviciosAdicionales=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#serviciosAdicionales");
    public static final org.semanticwb.platform.SemanticClass intranet_ReservacionSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionSala");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionSala");

    public static class ClassMgr
    {
       /**
       * Returns a list of ReservacionSala for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ReservacionSala for all models
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala>(it, true);
        }

        public static com.infotec.eworkplace.swb.ReservacionSala createReservacionSala(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.ReservacionSala.ClassMgr.createReservacionSala(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return A com.infotec.eworkplace.swb.ReservacionSala
       */
        public static com.infotec.eworkplace.swb.ReservacionSala getReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionSala)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return A com.infotec.eworkplace.swb.ReservacionSala
       */
        public static com.infotec.eworkplace.swb.ReservacionSala createReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionSala)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       */
        public static void removeReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return true if the com.infotec.eworkplace.swb.ReservacionSala exists, false otherwise
       */

        public static boolean hasReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReservacionSala(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Sala
       * @param value Sala of the type com.infotec.eworkplace.swb.Sala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaBySala(com.infotec.eworkplace.swb.Sala value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_sala, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Sala
       * @param value Sala of the type com.infotec.eworkplace.swb.Sala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaBySala(com.infotec.eworkplace.swb.Sala value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_sala,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ReservacionSalaBase.ClassMgr getReservacionSalaClassMgr()
    {
        return new ReservacionSalaBase.ClassMgr();
    }

   /**
   * Constructs a ReservacionSalaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservacionSala
   */
    public ReservacionSalaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the FechaFinal property
* @return java.util.Date with the FechaFinal
*/
    public java.util.Date getFechaFinal()
    {
        return getSemanticObject().getDateProperty(intranet_fechaFinal);
    }

/**
* Sets the FechaFinal property
* @param value long with the FechaFinal
*/
    public void setFechaFinal(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaFinal, value);
    }

/**
* Gets the NumeroEmpleado property
* @return int with the NumeroEmpleado
*/
    public int getNumeroEmpleado()
    {
        return getSemanticObject().getIntProperty(intranet_numeroEmpleado);
    }

/**
* Sets the NumeroEmpleado property
* @param value long with the NumeroEmpleado
*/
    public void setNumeroEmpleado(int value)
    {
        getSemanticObject().setIntProperty(intranet_numeroEmpleado, value);
    }
   /**
   * Sets the value for the property Solicitante
   * @param value Solicitante to set
   */

    public void setSolicitante(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitante, value.getSemanticObject());
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
        getSemanticObject().removeProperty(intranet_solicitante);
    }

   /**
   * Gets the Solicitante
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSolicitante()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitante);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FechaSolicita property
* @return java.util.Date with the FechaSolicita
*/
    public java.util.Date getFechaSolicita()
    {
        return getSemanticObject().getDateProperty(intranet_fechaSolicita);
    }

/**
* Sets the FechaSolicita property
* @param value long with the FechaSolicita
*/
    public void setFechaSolicita(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaSolicita, value);
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the RequiereCafeSoluble property
* @return boolean with the RequiereCafeSoluble
*/
    public boolean isRequiereCafeSoluble()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereCafeSoluble);
    }

/**
* Sets the RequiereCafeSoluble property
* @param value long with the RequiereCafeSoluble
*/
    public void setRequiereCafeSoluble(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereCafeSoluble, value);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

/**
* Gets the HorarioServicio property
* @return String with the HorarioServicio
*/
    public String getHorarioServicio()
    {
        return getSemanticObject().getProperty(intranet_horarioServicio);
    }

/**
* Sets the HorarioServicio property
* @param value long with the HorarioServicio
*/
    public void setHorarioServicio(String value)
    {
        getSemanticObject().setProperty(intranet_horarioServicio, value);
    }

/**
* Gets the FechaInicio property
* @return java.util.Date with the FechaInicio
*/
    public java.util.Date getFechaInicio()
    {
        return getSemanticObject().getDateProperty(intranet_fechaInicio);
    }

/**
* Sets the FechaInicio property
* @param value long with the FechaInicio
*/
    public void setFechaInicio(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaInicio, value);
    }

/**
* Gets the RequiereComputo property
* @return boolean with the RequiereComputo
*/
    public boolean isRequiereComputo()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereComputo);
    }

/**
* Sets the RequiereComputo property
* @param value long with the RequiereComputo
*/
    public void setRequiereComputo(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereComputo, value);
    }
   /**
   * Sets the value for the property Sala
   * @param value Sala to set
   */

    public void setSala(com.infotec.eworkplace.swb.Sala value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_sala, value.getSemanticObject());
        }else
        {
            removeSala();
        }
    }
   /**
   * Remove the value for Sala property
   */

    public void removeSala()
    {
        getSemanticObject().removeProperty(intranet_sala);
    }

   /**
   * Gets the Sala
   * @return a com.infotec.eworkplace.swb.Sala
   */
    public com.infotec.eworkplace.swb.Sala getSala()
    {
         com.infotec.eworkplace.swb.Sala ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_sala);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Sala)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Motivo property
* @return String with the Motivo
*/
    public String getMotivo()
    {
        return getSemanticObject().getProperty(intranet_motivo);
    }

/**
* Sets the Motivo property
* @param value long with the Motivo
*/
    public void setMotivo(String value)
    {
        getSemanticObject().setProperty(intranet_motivo, value);
    }

/**
* Gets the PId property
* @return String with the PId
*/
    public String getPId()
    {
        return getSemanticObject().getProperty(intranet_pId);
    }

/**
* Sets the PId property
* @param value long with the PId
*/
    public void setPId(String value)
    {
        getSemanticObject().setProperty(intranet_pId, value);
    }

/**
* Gets the CargoSolicitante property
* @return String with the CargoSolicitante
*/
    public String getCargoSolicitante()
    {
        return getSemanticObject().getProperty(intranet_cargoSolicitante);
    }

/**
* Sets the CargoSolicitante property
* @param value long with the CargoSolicitante
*/
    public void setCargoSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_cargoSolicitante, value);
    }

/**
* Gets the AdscripcionSolicitante property
* @return String with the AdscripcionSolicitante
*/
    public String getAdscripcionSolicitante()
    {
        return getSemanticObject().getProperty(intranet_adscripcionSolicitante);
    }

/**
* Sets the AdscripcionSolicitante property
* @param value long with the AdscripcionSolicitante
*/
    public void setAdscripcionSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_adscripcionSolicitante, value);
    }

/**
* Gets the Folio property
* @return String with the Folio
*/
    public String getFolio()
    {
        return getSemanticObject().getProperty(intranet_folio);
    }

/**
* Sets the Folio property
* @param value long with the Folio
*/
    public void setFolio(String value)
    {
        getSemanticObject().setProperty(intranet_folio, value);
    }

/**
* Gets the Asistentes property
* @return int with the Asistentes
*/
    public int getAsistentes()
    {
        return getSemanticObject().getIntProperty(intranet_asistentes);
    }

/**
* Sets the Asistentes property
* @param value long with the Asistentes
*/
    public void setAsistentes(int value)
    {
        getSemanticObject().setIntProperty(intranet_asistentes, value);
    }

/**
* Gets the RequiereProyector property
* @return boolean with the RequiereProyector
*/
    public boolean isRequiereProyector()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereProyector);
    }

/**
* Sets the RequiereProyector property
* @param value long with the RequiereProyector
*/
    public void setRequiereProyector(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereProyector, value);
    }

/**
* Gets the RequiereCafeGrano property
* @return boolean with the RequiereCafeGrano
*/
    public boolean isRequiereCafeGrano()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereCafeGrano);
    }

/**
* Sets the RequiereCafeGrano property
* @param value long with the RequiereCafeGrano
*/
    public void setRequiereCafeGrano(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereCafeGrano, value);
    }

/**
* Gets the IconClass property
* @return String with the IconClass
*/
    public String getIconClass()
    {
        return getSemanticObject().getProperty(swb_iconClass);
    }

/**
* Sets the IconClass property
* @param value long with the IconClass
*/
    public void setIconClass(String value)
    {
        getSemanticObject().setProperty(swb_iconClass, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RequiereGalletas property
* @return boolean with the RequiereGalletas
*/
    public boolean isRequiereGalletas()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereGalletas);
    }

/**
* Sets the RequiereGalletas property
* @param value long with the RequiereGalletas
*/
    public void setRequiereGalletas(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereGalletas, value);
    }

/**
* Gets the RequiereServicioContinuo property
* @return boolean with the RequiereServicioContinuo
*/
    public boolean isRequiereServicioContinuo()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereServicioContinuo);
    }

/**
* Sets the RequiereServicioContinuo property
* @param value long with the RequiereServicioContinuo
*/
    public void setRequiereServicioContinuo(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereServicioContinuo, value);
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the TipoReunion property
* @return String with the TipoReunion
*/
    public String getTipoReunion()
    {
        return getSemanticObject().getProperty(intranet_tipoReunion);
    }

/**
* Sets the TipoReunion property
* @param value long with the TipoReunion
*/
    public void setTipoReunion(String value)
    {
        getSemanticObject().setProperty(intranet_tipoReunion, value);
    }

/**
* Gets the RequiereAgua property
* @return boolean with the RequiereAgua
*/
    public boolean isRequiereAgua()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereAgua);
    }

/**
* Sets the RequiereAgua property
* @param value long with the RequiereAgua
*/
    public void setRequiereAgua(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereAgua, value);
    }

/**
* Gets the ExtensionSolicitante property
* @return String with the ExtensionSolicitante
*/
    public String getExtensionSolicitante()
    {
        return getSemanticObject().getProperty(intranet_extensionSolicitante);
    }

/**
* Sets the ExtensionSolicitante property
* @param value long with the ExtensionSolicitante
*/
    public void setExtensionSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_extensionSolicitante, value);
    }
   /**
   * Sets the value for the property UsuarioAutoriza
   * @param value UsuarioAutoriza to set
   */

    public void setUsuarioAutoriza(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_usuarioAutoriza, value.getSemanticObject());
        }else
        {
            removeUsuarioAutoriza();
        }
    }
   /**
   * Remove the value for UsuarioAutoriza property
   */

    public void removeUsuarioAutoriza()
    {
        getSemanticObject().removeProperty(intranet_usuarioAutoriza);
    }

   /**
   * Gets the UsuarioAutoriza
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUsuarioAutoriza()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_usuarioAutoriza);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NombreSolicitante property
* @return String with the NombreSolicitante
*/
    public String getNombreSolicitante()
    {
        return getSemanticObject().getProperty(intranet_nombreSolicitante);
    }

/**
* Sets the NombreSolicitante property
* @param value long with the NombreSolicitante
*/
    public void setNombreSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_nombreSolicitante, value);
    }

/**
* Gets the RequiereRefrescos property
* @return boolean with the RequiereRefrescos
*/
    public boolean isRequiereRefrescos()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereRefrescos);
    }

/**
* Sets the RequiereRefrescos property
* @param value long with the RequiereRefrescos
*/
    public void setRequiereRefrescos(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereRefrescos, value);
    }

/**
* Gets the Autoriza property
* @return String with the Autoriza
*/
    public String getAutoriza()
    {
        return getSemanticObject().getProperty(intranet_autoriza);
    }

/**
* Sets the Autoriza property
* @param value long with the Autoriza
*/
    public void setAutoriza(String value)
    {
        getSemanticObject().setProperty(intranet_autoriza, value);
    }

/**
* Gets the TipoCafeteria property
* @return String with the TipoCafeteria
*/
    public String getTipoCafeteria()
    {
        return getSemanticObject().getProperty(intranet_tipoCafeteria);
    }

/**
* Sets the TipoCafeteria property
* @param value long with the TipoCafeteria
*/
    public void setTipoCafeteria(String value)
    {
        getSemanticObject().setProperty(intranet_tipoCafeteria, value);
    }

/**
* Gets the ServiciosAdicionales property
* @return String with the ServiciosAdicionales
*/
    public String getServiciosAdicionales()
    {
        return getSemanticObject().getProperty(intranet_serviciosAdicionales);
    }

/**
* Sets the ServiciosAdicionales property
* @param value long with the ServiciosAdicionales
*/
    public void setServiciosAdicionales(String value)
    {
        getSemanticObject().setProperty(intranet_serviciosAdicionales, value);
    }
}
