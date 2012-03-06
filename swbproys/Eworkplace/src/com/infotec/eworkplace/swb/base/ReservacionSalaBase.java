package com.infotec.eworkplace.swb.base;


public abstract class ReservacionSalaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,com.infotec.eworkplace.swb.Solicitable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_responsable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#responsable");
    public static final org.semanticwb.platform.SemanticClass intranet_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sala");
    public static final org.semanticwb.platform.SemanticProperty intranet_sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sala");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivo");
    public static final org.semanticwb.platform.SemanticProperty intranet_asistentes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#asistentes");
    public static final org.semanticwb.platform.SemanticProperty intranet_cafeteria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cafeteria");
    public static final org.semanticwb.platform.SemanticProperty intranet_de=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#de");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoReunion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoReunion");
    public static final org.semanticwb.platform.SemanticClass intranet_Date=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Date");
    public static final org.semanticwb.platform.SemanticProperty intranet_fecha=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fecha");
    public static final org.semanticwb.platform.SemanticProperty intranet_a=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#a");
    public static final org.semanticwb.platform.SemanticProperty intranet_otroServicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#otroServicio");
    public static final org.semanticwb.platform.SemanticProperty intranet_servicios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#servicios");
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
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Responsable
       * @param value Responsable of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByResponsable(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_responsable, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Responsable
       * @param value Responsable of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByResponsable(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_responsable,value.getSemanticObject(),sclass));
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
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Fecha
       * @param value Fecha of the type com.infotec.eworkplace.swb.Date
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByFecha(com.infotec.eworkplace.swb.Date value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_fecha, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Fecha
       * @param value Fecha of the type com.infotec.eworkplace.swb.Date
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByFecha(com.infotec.eworkplace.swb.Date value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_fecha,value.getSemanticObject(),sclass));
            return it;
        }
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
   * Sets the value for the property Responsable
   * @param value Responsable to set
   */

    public void setResponsable(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_responsable, value.getSemanticObject());
        }else
        {
            removeResponsable();
        }
    }
   /**
   * Remove the value for Responsable property
   */

    public void removeResponsable()
    {
        getSemanticObject().removeProperty(intranet_responsable);
    }

   /**
   * Gets the Responsable
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getResponsable()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_responsable);
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
* Gets the Cafeteria property
* @return String with the Cafeteria
*/
    public String getCafeteria()
    {
        return getSemanticObject().getProperty(intranet_cafeteria);
    }

/**
* Sets the Cafeteria property
* @param value long with the Cafeteria
*/
    public void setCafeteria(String value)
    {
        getSemanticObject().setProperty(intranet_cafeteria, value);
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
* Gets the De property
* @return int with the De
*/
    public int getDe()
    {
        return getSemanticObject().getIntProperty(intranet_de);
    }

/**
* Sets the De property
* @param value long with the De
*/
    public void setDe(int value)
    {
        getSemanticObject().setIntProperty(intranet_de, value);
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
   * Sets the value for the property Fecha
   * @param value Fecha to set
   */

    public void setFecha(com.infotec.eworkplace.swb.Date value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_fecha, value.getSemanticObject());
        }else
        {
            removeFecha();
        }
    }
   /**
   * Remove the value for Fecha property
   */

    public void removeFecha()
    {
        getSemanticObject().removeProperty(intranet_fecha);
    }

   /**
   * Gets the Fecha
   * @return a com.infotec.eworkplace.swb.Date
   */
    public com.infotec.eworkplace.swb.Date getFecha()
    {
         com.infotec.eworkplace.swb.Date ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_fecha);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Date)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the A property
* @return int with the A
*/
    public int getA()
    {
        return getSemanticObject().getIntProperty(intranet_a);
    }

/**
* Sets the A property
* @param value long with the A
*/
    public void setA(int value)
    {
        getSemanticObject().setIntProperty(intranet_a, value);
    }

/**
* Gets the OtroServicio property
* @return String with the OtroServicio
*/
    public String getOtroServicio()
    {
        return getSemanticObject().getProperty(intranet_otroServicio);
    }

/**
* Sets the OtroServicio property
* @param value long with the OtroServicio
*/
    public void setOtroServicio(String value)
    {
        getSemanticObject().setProperty(intranet_otroServicio, value);
    }

/**
* Gets the Servicios property
* @return String with the Servicios
*/
    public String getServicios()
    {
        return getSemanticObject().getProperty(intranet_servicios);
    }

/**
* Sets the Servicios property
* @param value long with the Servicios
*/
    public void setServicios(String value)
    {
        getSemanticObject().setProperty(intranet_servicios, value);
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
}
