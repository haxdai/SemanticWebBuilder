package com.infotec.eworkplace.swb.base;


public abstract class ReservaSalaBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable,com.infotec.eworkplace.swb.Status,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty ewp_observaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#observaciones");
    public static final org.semanticwb.platform.SemanticProperty ewp_totalAsistentes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#totalAsistentes");
    public static final org.semanticwb.platform.SemanticClass ewp_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Sala");
    public static final org.semanticwb.platform.SemanticProperty ewp_sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#sala");
    public static final org.semanticwb.platform.SemanticProperty ewp_tipoReunion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#tipoReunion");
    public static final org.semanticwb.platform.SemanticProperty ewp_horarioInicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#horarioInicio");
    public static final org.semanticwb.platform.SemanticProperty ewp_finReserva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#finReserva");
    public static final org.semanticwb.platform.SemanticProperty ewp_inicioReserva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#inicioReserva");
    public static final org.semanticwb.platform.SemanticProperty ewp_horarioFin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#horarioFin");
    public static final org.semanticwb.platform.SemanticClass ewp_ReservaSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#ReservaSala");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#ReservaSala");

    public static class ClassMgr
    {
       /**
       * Returns a list of ReservaSala for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ReservaSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaSala> listReservaSalas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ReservaSala for all models
       * @return Iterator of com.infotec.eworkplace.swb.ReservaSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaSala> listReservaSalas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ReservaSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservaSala
       * @return A com.infotec.eworkplace.swb.ReservaSala
       */
        public static com.infotec.eworkplace.swb.ReservaSala getReservaSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservaSala)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ReservaSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservaSala
       * @return A com.infotec.eworkplace.swb.ReservaSala
       */
        public static com.infotec.eworkplace.swb.ReservaSala createReservaSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservaSala)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ReservaSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservaSala
       */
        public static void removeReservaSala(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ReservaSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservaSala
       * @return true if the com.infotec.eworkplace.swb.ReservaSala exists, false otherwise
       */

        public static boolean hasReservaSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReservaSala(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservaSala with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservaSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservaSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaSala> listReservaSalaBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservaSala with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservaSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaSala> listReservaSalaBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservaSala with a determined Sala
       * @param value Sala of the type com.infotec.eworkplace.swb.Sala
       * @param model Model of the com.infotec.eworkplace.swb.ReservaSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservaSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaSala> listReservaSalaBySala(com.infotec.eworkplace.swb.Sala value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_sala, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservaSala with a determined Sala
       * @param value Sala of the type com.infotec.eworkplace.swb.Sala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservaSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaSala> listReservaSalaBySala(com.infotec.eworkplace.swb.Sala value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_sala,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ReservaSalaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaSala
   */
    public ReservaSalaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Observaciones property
* @return String with the Observaciones
*/
    public String getObservaciones()
    {
        return getSemanticObject().getProperty(ewp_observaciones);
    }

/**
* Sets the Observaciones property
* @param value long with the Observaciones
*/
    public void setObservaciones(String value)
    {
        getSemanticObject().setProperty(ewp_observaciones, value);
    }

/**
* Gets the TotalAsistentes property
* @return int with the TotalAsistentes
*/
    public int getTotalAsistentes()
    {
        return getSemanticObject().getIntProperty(ewp_totalAsistentes);
    }

/**
* Sets the TotalAsistentes property
* @param value long with the TotalAsistentes
*/
    public void setTotalAsistentes(int value)
    {
        getSemanticObject().setIntProperty(ewp_totalAsistentes, value);
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
* Gets the Status property
* @return String with the Status
*/
    public String getStatus()
    {
        return getSemanticObject().getProperty(ewp_status);
    }

/**
* Sets the Status property
* @param value long with the Status
*/
    public void setStatus(String value)
    {
        getSemanticObject().setProperty(ewp_status, value);
    }
   /**
   * Sets the value for the property Sala
   * @param value Sala to set
   */

    public void setSala(com.infotec.eworkplace.swb.Sala value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_sala, value.getSemanticObject());
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
        getSemanticObject().removeProperty(ewp_sala);
    }

   /**
   * Gets the Sala
   * @return a com.infotec.eworkplace.swb.Sala
   */
    public com.infotec.eworkplace.swb.Sala getSala()
    {
         com.infotec.eworkplace.swb.Sala ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_sala);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Sala)obj.createGenericInstance();
         }
         return ret;
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
        return getSemanticObject().getProperty(ewp_tipoReunion);
    }

/**
* Sets the TipoReunion property
* @param value long with the TipoReunion
*/
    public void setTipoReunion(String value)
    {
        getSemanticObject().setProperty(ewp_tipoReunion, value);
    }

/**
* Gets the HorarioInicio property
* @return String with the HorarioInicio
*/
    public String getHorarioInicio()
    {
        return getSemanticObject().getProperty(ewp_horarioInicio);
    }

/**
* Sets the HorarioInicio property
* @param value long with the HorarioInicio
*/
    public void setHorarioInicio(String value)
    {
        getSemanticObject().setProperty(ewp_horarioInicio, value);
    }

/**
* Gets the FinReserva property
* @return java.util.Date with the FinReserva
*/
    public java.util.Date getFinReserva()
    {
        return getSemanticObject().getDateProperty(ewp_finReserva);
    }

/**
* Sets the FinReserva property
* @param value long with the FinReserva
*/
    public void setFinReserva(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_finReserva, value);
    }

/**
* Gets the InicioReserva property
* @return java.util.Date with the InicioReserva
*/
    public java.util.Date getInicioReserva()
    {
        return getSemanticObject().getDateProperty(ewp_inicioReserva);
    }

/**
* Sets the InicioReserva property
* @param value long with the InicioReserva
*/
    public void setInicioReserva(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_inicioReserva, value);
    }

/**
* Gets the HorarioFin property
* @return String with the HorarioFin
*/
    public String getHorarioFin()
    {
        return getSemanticObject().getProperty(ewp_horarioFin);
    }

/**
* Sets the HorarioFin property
* @param value long with the HorarioFin
*/
    public void setHorarioFin(String value)
    {
        getSemanticObject().setProperty(ewp_horarioFin, value);
    }
}
