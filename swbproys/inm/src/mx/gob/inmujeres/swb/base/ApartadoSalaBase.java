package mx.gob.inmujeres.swb.base;


   /**
   * Representa una reservación de una sala de juntas 
   */
public abstract class ApartadoSalaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Iconable,org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty inm_observaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#observaciones");
    public static final org.semanticwb.platform.SemanticProperty inm_motivoReunion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#motivoReunion");
    public static final org.semanticwb.platform.SemanticProperty inm_voboJefeDirecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#voboJefeDirecto");
    public static final org.semanticwb.platform.SemanticProperty inm_fechaInicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#fechaInicio");
    public static final org.semanticwb.platform.SemanticProperty inm_requiereRotafolio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereRotafolio");
   /**
   * Representa una sala de juntas
   */
    public static final org.semanticwb.platform.SemanticClass inm_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Sala");
    public static final org.semanticwb.platform.SemanticProperty inm_sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#sala");
    public static final org.semanticwb.platform.SemanticClass inm_UnidadResponsable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#UnidadResponsable");
    public static final org.semanticwb.platform.SemanticProperty inm_unidadResponsable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#unidadResponsable");
    public static final org.semanticwb.platform.SemanticProperty inm_requiereProyector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereProyector");
    public static final org.semanticwb.platform.SemanticProperty inm_participantesInmujeres=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#participantesInmujeres");
    public static final org.semanticwb.platform.SemanticProperty inm_requiereSonido=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereSonido");
    public static final org.semanticwb.platform.SemanticClass inm_Montaje=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Montaje");
    public static final org.semanticwb.platform.SemanticProperty inm_montaje=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#montaje");
    public static final org.semanticwb.platform.SemanticProperty inm_fechaFin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#fechaFin");
    public static final org.semanticwb.platform.SemanticProperty inm_participantesOtros=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#participantesOtros");
    public static final org.semanticwb.platform.SemanticProperty inm_servicioAdicional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#servicioAdicional");
    public static final org.semanticwb.platform.SemanticProperty inm_requiereGalletas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereGalletas");
    public static final org.semanticwb.platform.SemanticProperty inm_requiereTe=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereTe");
   /**
   * Café incluye: crema, azúcar, vasos, cucharas y servilletas
   */
    public static final org.semanticwb.platform.SemanticProperty inm_requiereCafe=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereCafe");
    public static final org.semanticwb.platform.SemanticProperty inm_requierePodium=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requierePodium");
    public static final org.semanticwb.platform.SemanticProperty inm_requiereAgua=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereAgua");
    public static final org.semanticwb.platform.SemanticProperty inm_requierePersonificadores=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requierePersonificadores");
    public static final org.semanticwb.platform.SemanticProperty inm_archivoApartado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#archivoApartado");
    public static final org.semanticwb.platform.SemanticProperty inm_folioSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#folioSolicitud");
    public static final org.semanticwb.platform.SemanticProperty inm_otroApoyo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#otroApoyo");
   /**
   * extensión telefónica
   */
    public static final org.semanticwb.platform.SemanticProperty inm_extension=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#extension");
    public static final org.semanticwb.platform.SemanticProperty inm_requierePantalla=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requierePantalla");
   /**
   * Representa una reservación de una sala de juntas
   */
    public static final org.semanticwb.platform.SemanticClass inm_ApartadoSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#ApartadoSala");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#ApartadoSala");

    public static class ClassMgr
    {
       /**
       * Returns a list of ApartadoSala for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.ApartadoSala for all models
       * @return Iterator of mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala>(it, true);
        }

        public static mx.gob.inmujeres.swb.ApartadoSala createApartadoSala(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.ApartadoSala.ClassMgr.createApartadoSala(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.ApartadoSala
       * @param id Identifier for mx.gob.inmujeres.swb.ApartadoSala
       * @param model Model of the mx.gob.inmujeres.swb.ApartadoSala
       * @return A mx.gob.inmujeres.swb.ApartadoSala
       */
        public static mx.gob.inmujeres.swb.ApartadoSala getApartadoSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.ApartadoSala)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.ApartadoSala
       * @param id Identifier for mx.gob.inmujeres.swb.ApartadoSala
       * @param model Model of the mx.gob.inmujeres.swb.ApartadoSala
       * @return A mx.gob.inmujeres.swb.ApartadoSala
       */
        public static mx.gob.inmujeres.swb.ApartadoSala createApartadoSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.ApartadoSala)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.ApartadoSala
       * @param id Identifier for mx.gob.inmujeres.swb.ApartadoSala
       * @param model Model of the mx.gob.inmujeres.swb.ApartadoSala
       */
        public static void removeApartadoSala(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.ApartadoSala
       * @param id Identifier for mx.gob.inmujeres.swb.ApartadoSala
       * @param model Model of the mx.gob.inmujeres.swb.ApartadoSala
       * @return true if the mx.gob.inmujeres.swb.ApartadoSala exists, false otherwise
       */

        public static boolean hasApartadoSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (getApartadoSala(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.ApartadoSala with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.ApartadoSala
       * @return Iterator with all the mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.ApartadoSala with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.ApartadoSala with a determined Sala
       * @param value Sala of the type mx.gob.inmujeres.swb.Sala
       * @param model Model of the mx.gob.inmujeres.swb.ApartadoSala
       * @return Iterator with all the mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalaBySala(mx.gob.inmujeres.swb.Sala value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_sala, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.ApartadoSala with a determined Sala
       * @param value Sala of the type mx.gob.inmujeres.swb.Sala
       * @return Iterator with all the mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalaBySala(mx.gob.inmujeres.swb.Sala value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_sala,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.ApartadoSala with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.ApartadoSala
       * @return Iterator with all the mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.ApartadoSala with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.ApartadoSala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.ApartadoSala> listApartadoSalaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.ApartadoSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ApartadoSalaBase.ClassMgr getApartadoSalaClassMgr()
    {
        return new ApartadoSalaBase.ClassMgr();
    }

   /**
   * Constructs a ApartadoSalaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ApartadoSala
   */
    public ApartadoSalaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Observaciones property
* @return String with the Observaciones
*/
    public String getObservaciones()
    {
        return getSemanticObject().getProperty(inm_observaciones);
    }

/**
* Sets the Observaciones property
* @param value long with the Observaciones
*/
    public void setObservaciones(String value)
    {
        getSemanticObject().setProperty(inm_observaciones, value);
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
* Gets the MotivoReunion property
* @return String with the MotivoReunion
*/
    public String getMotivoReunion()
    {
        return getSemanticObject().getProperty(inm_motivoReunion);
    }

/**
* Sets the MotivoReunion property
* @param value long with the MotivoReunion
*/
    public void setMotivoReunion(String value)
    {
        getSemanticObject().setProperty(inm_motivoReunion, value);
    }

/**
* Gets the VoboJefeDirecto property
* @return String with the VoboJefeDirecto
*/
    public String getVoboJefeDirecto()
    {
        return getSemanticObject().getProperty(inm_voboJefeDirecto);
    }

/**
* Sets the VoboJefeDirecto property
* @param value long with the VoboJefeDirecto
*/
    public void setVoboJefeDirecto(String value)
    {
        getSemanticObject().setProperty(inm_voboJefeDirecto, value);
    }

/**
* Gets the FechaInicio property
* @return java.util.Date with the FechaInicio
*/
    public java.util.Date getFechaInicio()
    {
        return getSemanticObject().getDateProperty(inm_fechaInicio);
    }

/**
* Sets the FechaInicio property
* @param value long with the FechaInicio
*/
    public void setFechaInicio(java.util.Date value)
    {
        getSemanticObject().setDateProperty(inm_fechaInicio, value);
    }

/**
* Gets the RequiereRotafolio property
* @return boolean with the RequiereRotafolio
*/
    public boolean isRequiereRotafolio()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereRotafolio);
    }

/**
* Sets the RequiereRotafolio property
* @param value long with the RequiereRotafolio
*/
    public void setRequiereRotafolio(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereRotafolio, value);
    }
   /**
   * Sets the value for the property Sala
   * @param value Sala to set
   */

    public void setSala(mx.gob.inmujeres.swb.Sala value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_sala, value.getSemanticObject());
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
        getSemanticObject().removeProperty(inm_sala);
    }

   /**
   * Gets the Sala
   * @return a mx.gob.inmujeres.swb.Sala
   */
    public mx.gob.inmujeres.swb.Sala getSala()
    {
         mx.gob.inmujeres.swb.Sala ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_sala);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Sala)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property UnidadResponsable
   * @param value UnidadResponsable to set
   */

    public void setUnidadResponsable(mx.gob.inmujeres.swb.UnidadResponsable value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_unidadResponsable, value.getSemanticObject());
        }else
        {
            removeUnidadResponsable();
        }
    }
   /**
   * Remove the value for UnidadResponsable property
   */

    public void removeUnidadResponsable()
    {
        getSemanticObject().removeProperty(inm_unidadResponsable);
    }

   /**
   * Gets the UnidadResponsable
   * @return a mx.gob.inmujeres.swb.UnidadResponsable
   */
    public mx.gob.inmujeres.swb.UnidadResponsable getUnidadResponsable()
    {
         mx.gob.inmujeres.swb.UnidadResponsable ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_unidadResponsable);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.UnidadResponsable)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RequiereProyector property
* @return boolean with the RequiereProyector
*/
    public boolean isRequiereProyector()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereProyector);
    }

/**
* Sets the RequiereProyector property
* @param value long with the RequiereProyector
*/
    public void setRequiereProyector(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereProyector, value);
    }

/**
* Gets the ParticipantesInmujeres property
* @return int with the ParticipantesInmujeres
*/
    public int getParticipantesInmujeres()
    {
        return getSemanticObject().getIntProperty(inm_participantesInmujeres);
    }

/**
* Sets the ParticipantesInmujeres property
* @param value long with the ParticipantesInmujeres
*/
    public void setParticipantesInmujeres(int value)
    {
        getSemanticObject().setIntProperty(inm_participantesInmujeres, value);
    }

/**
* Gets the RequiereSonido property
* @return boolean with the RequiereSonido
*/
    public boolean isRequiereSonido()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereSonido);
    }

/**
* Sets the RequiereSonido property
* @param value long with the RequiereSonido
*/
    public void setRequiereSonido(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereSonido, value);
    }
   /**
   * Sets the value for the property Montaje
   * @param value Montaje to set
   */

    public void setMontaje(mx.gob.inmujeres.swb.Montaje value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_montaje, value.getSemanticObject());
        }else
        {
            removeMontaje();
        }
    }
   /**
   * Remove the value for Montaje property
   */

    public void removeMontaje()
    {
        getSemanticObject().removeProperty(inm_montaje);
    }

   /**
   * Gets the Montaje
   * @return a mx.gob.inmujeres.swb.Montaje
   */
    public mx.gob.inmujeres.swb.Montaje getMontaje()
    {
         mx.gob.inmujeres.swb.Montaje ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_montaje);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Montaje)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FechaFin property
* @return java.util.Date with the FechaFin
*/
    public java.util.Date getFechaFin()
    {
        return getSemanticObject().getDateProperty(inm_fechaFin);
    }

/**
* Sets the FechaFin property
* @param value long with the FechaFin
*/
    public void setFechaFin(java.util.Date value)
    {
        getSemanticObject().setDateProperty(inm_fechaFin, value);
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
* Gets the ParticipantesOtros property
* @return int with the ParticipantesOtros
*/
    public int getParticipantesOtros()
    {
        return getSemanticObject().getIntProperty(inm_participantesOtros);
    }

/**
* Sets the ParticipantesOtros property
* @param value long with the ParticipantesOtros
*/
    public void setParticipantesOtros(int value)
    {
        getSemanticObject().setIntProperty(inm_participantesOtros, value);
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
* Gets the ServicioAdicional property
* @return String with the ServicioAdicional
*/
    public String getServicioAdicional()
    {
        return getSemanticObject().getProperty(inm_servicioAdicional);
    }

/**
* Sets the ServicioAdicional property
* @param value long with the ServicioAdicional
*/
    public void setServicioAdicional(String value)
    {
        getSemanticObject().setProperty(inm_servicioAdicional, value);
    }

/**
* Gets the RequiereGalletas property
* @return boolean with the RequiereGalletas
*/
    public boolean isRequiereGalletas()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereGalletas);
    }

/**
* Sets the RequiereGalletas property
* @param value long with the RequiereGalletas
*/
    public void setRequiereGalletas(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereGalletas, value);
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
* Gets the RequiereTe property
* @return boolean with the RequiereTe
*/
    public boolean isRequiereTe()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereTe);
    }

/**
* Sets the RequiereTe property
* @param value long with the RequiereTe
*/
    public void setRequiereTe(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereTe, value);
    }

/**
* Gets the RequiereCafe property
* @return boolean with the RequiereCafe
*/
    public boolean isRequiereCafe()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereCafe);
    }

/**
* Sets the RequiereCafe property
* @param value long with the RequiereCafe
*/
    public void setRequiereCafe(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereCafe, value);
    }

/**
* Gets the RequierePodium property
* @return boolean with the RequierePodium
*/
    public boolean isRequierePodium()
    {
        return getSemanticObject().getBooleanProperty(inm_requierePodium);
    }

/**
* Sets the RequierePodium property
* @param value long with the RequierePodium
*/
    public void setRequierePodium(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requierePodium, value);
    }

/**
* Gets the RequiereAgua property
* @return boolean with the RequiereAgua
*/
    public boolean isRequiereAgua()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereAgua);
    }

/**
* Sets the RequiereAgua property
* @param value long with the RequiereAgua
*/
    public void setRequiereAgua(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereAgua, value);
    }

/**
* Gets the RequierePersonificadores property
* @return boolean with the RequierePersonificadores
*/
    public boolean isRequierePersonificadores()
    {
        return getSemanticObject().getBooleanProperty(inm_requierePersonificadores);
    }

/**
* Sets the RequierePersonificadores property
* @param value long with the RequierePersonificadores
*/
    public void setRequierePersonificadores(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requierePersonificadores, value);
    }

/**
* Gets the ArchivoApartado property
* @return String with the ArchivoApartado
*/
    public String getArchivoApartado()
    {
        return getSemanticObject().getProperty(inm_archivoApartado);
    }

/**
* Sets the ArchivoApartado property
* @param value long with the ArchivoApartado
*/
    public void setArchivoApartado(String value)
    {
        getSemanticObject().setProperty(inm_archivoApartado, value);
    }

/**
* Gets the FolioSolicitud property
* @return String with the FolioSolicitud
*/
    public String getFolioSolicitud()
    {
        return getSemanticObject().getProperty(inm_folioSolicitud);
    }

/**
* Sets the FolioSolicitud property
* @param value long with the FolioSolicitud
*/
    public void setFolioSolicitud(String value)
    {
        getSemanticObject().setProperty(inm_folioSolicitud, value);
    }

/**
* Gets the OtroApoyo property
* @return String with the OtroApoyo
*/
    public String getOtroApoyo()
    {
        return getSemanticObject().getProperty(inm_otroApoyo);
    }

/**
* Sets the OtroApoyo property
* @param value long with the OtroApoyo
*/
    public void setOtroApoyo(String value)
    {
        getSemanticObject().setProperty(inm_otroApoyo, value);
    }

/**
* Gets the Extension property
* @return String with the Extension
*/
    public String getExtension()
    {
        return getSemanticObject().getProperty(inm_extension);
    }

/**
* Sets the Extension property
* @param value long with the Extension
*/
    public void setExtension(String value)
    {
        getSemanticObject().setProperty(inm_extension, value);
    }

/**
* Gets the RequierePantalla property
* @return boolean with the RequierePantalla
*/
    public boolean isRequierePantalla()
    {
        return getSemanticObject().getBooleanProperty(inm_requierePantalla);
    }

/**
* Sets the RequierePantalla property
* @param value long with the RequierePantalla
*/
    public void setRequierePantalla(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requierePantalla, value);
    }
}
