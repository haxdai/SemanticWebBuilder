package com.infotec.eworkplace.swb.base;


public abstract class SWProfileBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,com.infotec.eworkplace.swb.Placeable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_contrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#contrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_misIdeas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#misIdeas");
    public static final org.semanticwb.platform.SemanticProperty intranet_misGustos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#misGustos");
    public static final org.semanticwb.platform.SemanticProperty intranet_puesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#puesto");
   /**
   * Breve descripción de hacienda o mensaje para recordar
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_postit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#postit");
    public static final org.semanticwb.platform.SemanticProperty intranet_miPersonalidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#miPersonalidad");
   /**
   * Encapsula las propiedades relacionadas con un proyecto del ProjectServer
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasProyecto");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_jefeInmediato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#jefeInmediato");
    public static final org.semanticwb.platform.SemanticClass intranet_TemaInteres=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TemaInteres");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasTemaInteres=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasTemaInteres");
    public static final org.semanticwb.platform.SemanticClass intranet_SWProfile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SWProfile");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SWProfile");

    public static class ClassMgr
    {
       /**
       * Returns a list of SWProfile for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfiles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SWProfile for all models
       * @return Iterator of com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfiles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SWProfile
       * @param id Identifier for com.infotec.eworkplace.swb.SWProfile
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return A com.infotec.eworkplace.swb.SWProfile
       */
        public static com.infotec.eworkplace.swb.SWProfile getSWProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SWProfile)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SWProfile
       * @param id Identifier for com.infotec.eworkplace.swb.SWProfile
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return A com.infotec.eworkplace.swb.SWProfile
       */
        public static com.infotec.eworkplace.swb.SWProfile createSWProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SWProfile)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SWProfile
       * @param id Identifier for com.infotec.eworkplace.swb.SWProfile
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       */
        public static void removeSWProfile(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SWProfile
       * @param id Identifier for com.infotec.eworkplace.swb.SWProfile
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return true if the com.infotec.eworkplace.swb.SWProfile exists, false otherwise
       */

        public static boolean hasSWProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSWProfile(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined Proyecto
       * @param value Proyecto of the type com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByProyecto(com.infotec.eworkplace.swb.Proyecto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasProyecto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined Proyecto
       * @param value Proyecto of the type com.infotec.eworkplace.swb.Proyecto
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByProyecto(com.infotec.eworkplace.swb.Proyecto value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasProyecto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined JefeInmediato
       * @param value JefeInmediato of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByJefeInmediato(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_jefeInmediato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined JefeInmediato
       * @param value JefeInmediato of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByJefeInmediato(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_jefeInmediato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined TemaInteres
       * @param value TemaInteres of the type com.infotec.eworkplace.swb.TemaInteres
       * @param model Model of the com.infotec.eworkplace.swb.SWProfile
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByTemaInteres(com.infotec.eworkplace.swb.TemaInteres value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasTemaInteres, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SWProfile with a determined TemaInteres
       * @param value TemaInteres of the type com.infotec.eworkplace.swb.TemaInteres
       * @return Iterator with all the com.infotec.eworkplace.swb.SWProfile
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SWProfile> listSWProfileByTemaInteres(com.infotec.eworkplace.swb.TemaInteres value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SWProfile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasTemaInteres,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SWProfileBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SWProfile
   */
    public SWProfileBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the Contrato property
* @return String with the Contrato
*/
    public String getContrato()
    {
        return getSemanticObject().getProperty(intranet_contrato);
    }

/**
* Sets the Contrato property
* @param value long with the Contrato
*/
    public void setContrato(String value)
    {
        getSemanticObject().setProperty(intranet_contrato, value);
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
* Gets the MisIdeas property
* @return String with the MisIdeas
*/
    public String getMisIdeas()
    {
        return getSemanticObject().getProperty(intranet_misIdeas);
    }

/**
* Sets the MisIdeas property
* @param value long with the MisIdeas
*/
    public void setMisIdeas(String value)
    {
        getSemanticObject().setProperty(intranet_misIdeas, value);
    }

/**
* Gets the MisGustos property
* @return String with the MisGustos
*/
    public String getMisGustos()
    {
        return getSemanticObject().getProperty(intranet_misGustos);
    }

/**
* Sets the MisGustos property
* @param value long with the MisGustos
*/
    public void setMisGustos(String value)
    {
        getSemanticObject().setProperty(intranet_misGustos, value);
    }

/**
* Gets the Puesto property
* @return String with the Puesto
*/
    public String getPuesto()
    {
        return getSemanticObject().getProperty(intranet_puesto);
    }

/**
* Sets the Puesto property
* @param value long with the Puesto
*/
    public void setPuesto(String value)
    {
        getSemanticObject().setProperty(intranet_puesto, value);
    }

/**
* Gets the Postit property
* @return String with the Postit
*/
    public String getPostit()
    {
        return getSemanticObject().getProperty(intranet_postit);
    }

/**
* Sets the Postit property
* @param value long with the Postit
*/
    public void setPostit(String value)
    {
        getSemanticObject().setProperty(intranet_postit, value);
    }

/**
* Gets the MiPersonalidad property
* @return String with the MiPersonalidad
*/
    public String getMiPersonalidad()
    {
        return getSemanticObject().getProperty(intranet_miPersonalidad);
    }

/**
* Sets the MiPersonalidad property
* @param value long with the MiPersonalidad
*/
    public void setMiPersonalidad(String value)
    {
        getSemanticObject().setProperty(intranet_miPersonalidad, value);
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
   * Gets all the com.infotec.eworkplace.swb.Proyecto
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Proyecto
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> listProyectos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto>(getSemanticObject().listObjectProperties(intranet_hasProyecto));
    }

   /**
   * Gets true if has a Proyecto
   * @param value com.infotec.eworkplace.swb.Proyecto to verify
   * @return true if the com.infotec.eworkplace.swb.Proyecto exists, false otherwise
   */
    public boolean hasProyecto(com.infotec.eworkplace.swb.Proyecto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasProyecto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Proyecto
   * @param value com.infotec.eworkplace.swb.Proyecto to add
   */

    public void addProyecto(com.infotec.eworkplace.swb.Proyecto value)
    {
        getSemanticObject().addObjectProperty(intranet_hasProyecto, value.getSemanticObject());
    }
   /**
   * Removes all the Proyecto
   */

    public void removeAllProyecto()
    {
        getSemanticObject().removeProperty(intranet_hasProyecto);
    }
   /**
   * Removes a Proyecto
   * @param value com.infotec.eworkplace.swb.Proyecto to remove
   */

    public void removeProyecto(com.infotec.eworkplace.swb.Proyecto value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasProyecto,value.getSemanticObject());
    }

   /**
   * Gets the Proyecto
   * @return a com.infotec.eworkplace.swb.Proyecto
   */
    public com.infotec.eworkplace.swb.Proyecto getProyecto()
    {
         com.infotec.eworkplace.swb.Proyecto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasProyecto);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Proyecto)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Ubicacion property
* @return String with the Ubicacion
*/
    public String getUbicacion()
    {
        return getSemanticObject().getProperty(intranet_ubicacion);
    }

/**
* Sets the Ubicacion property
* @param value long with the Ubicacion
*/
    public void setUbicacion(String value)
    {
        getSemanticObject().setProperty(intranet_ubicacion, value);
    }
   /**
   * Sets the value for the property JefeInmediato
   * @param value JefeInmediato to set
   */

    public void setJefeInmediato(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_jefeInmediato, value.getSemanticObject());
        }else
        {
            removeJefeInmediato();
        }
    }
   /**
   * Remove the value for JefeInmediato property
   */

    public void removeJefeInmediato()
    {
        getSemanticObject().removeProperty(intranet_jefeInmediato);
    }

   /**
   * Gets the JefeInmediato
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getJefeInmediato()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_jefeInmediato);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.TemaInteres
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.TemaInteres
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TemaInteres> listTemaIntereses()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TemaInteres>(getSemanticObject().listObjectProperties(intranet_hasTemaInteres));
    }

   /**
   * Gets true if has a TemaInteres
   * @param value com.infotec.eworkplace.swb.TemaInteres to verify
   * @return true if the com.infotec.eworkplace.swb.TemaInteres exists, false otherwise
   */
    public boolean hasTemaInteres(com.infotec.eworkplace.swb.TemaInteres value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasTemaInteres,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a TemaInteres
   * @param value com.infotec.eworkplace.swb.TemaInteres to add
   */

    public void addTemaInteres(com.infotec.eworkplace.swb.TemaInteres value)
    {
        getSemanticObject().addObjectProperty(intranet_hasTemaInteres, value.getSemanticObject());
    }
   /**
   * Removes all the TemaInteres
   */

    public void removeAllTemaInteres()
    {
        getSemanticObject().removeProperty(intranet_hasTemaInteres);
    }
   /**
   * Removes a TemaInteres
   * @param value com.infotec.eworkplace.swb.TemaInteres to remove
   */

    public void removeTemaInteres(com.infotec.eworkplace.swb.TemaInteres value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasTemaInteres,value.getSemanticObject());
    }

   /**
   * Gets the TemaInteres
   * @return a com.infotec.eworkplace.swb.TemaInteres
   */
    public com.infotec.eworkplace.swb.TemaInteres getTemaInteres()
    {
         com.infotec.eworkplace.swb.TemaInteres ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasTemaInteres);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.TemaInteres)obj.createGenericInstance();
         }
         return ret;
    }
}
