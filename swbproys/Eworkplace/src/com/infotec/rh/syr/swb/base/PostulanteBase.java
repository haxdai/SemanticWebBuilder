package com.infotec.rh.syr.swb.base;


public abstract class PostulanteBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fuenteInformacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fuenteInformacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaEnvioCorreo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaEnvioCorreo");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioFuente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioFuente");
    public static final org.semanticwb.platform.SemanticProperty intranet_inhabilitadoSFP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#inhabilitadoSFP");
    public static final org.semanticwb.platform.SemanticProperty intranet_emailPostulante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#emailPostulante");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaNotificaRegistro=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaNotificaRegistro");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombrePostulante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombrePostulante");
    public static final org.semanticwb.platform.SemanticProperty intranet_cumplePerfil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cumplePerfil");
    public static final org.semanticwb.platform.SemanticProperty intranet_rfcRegistro=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#rfcRegistro");
    public static final org.semanticwb.platform.SemanticClass intranet_Postulante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Postulante");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Postulante");

    public static class ClassMgr
    {
       /**
       * Returns a list of Postulante for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.Postulante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Postulante> listPostulantes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.Postulante for all models
       * @return Iterator of com.infotec.rh.syr.swb.Postulante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Postulante> listPostulantes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante>(it, true);
        }

        public static com.infotec.rh.syr.swb.Postulante createPostulante(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.Postulante.ClassMgr.createPostulante(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.Postulante
       * @param id Identifier for com.infotec.rh.syr.swb.Postulante
       * @param model Model of the com.infotec.rh.syr.swb.Postulante
       * @return A com.infotec.rh.syr.swb.Postulante
       */
        public static com.infotec.rh.syr.swb.Postulante getPostulante(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Postulante)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.Postulante
       * @param id Identifier for com.infotec.rh.syr.swb.Postulante
       * @param model Model of the com.infotec.rh.syr.swb.Postulante
       * @return A com.infotec.rh.syr.swb.Postulante
       */
        public static com.infotec.rh.syr.swb.Postulante createPostulante(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Postulante)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.Postulante
       * @param id Identifier for com.infotec.rh.syr.swb.Postulante
       * @param model Model of the com.infotec.rh.syr.swb.Postulante
       */
        public static void removePostulante(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.Postulante
       * @param id Identifier for com.infotec.rh.syr.swb.Postulante
       * @param model Model of the com.infotec.rh.syr.swb.Postulante
       * @return true if the com.infotec.rh.syr.swb.Postulante exists, false otherwise
       */

        public static boolean hasPostulante(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPostulante(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Postulante with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Postulante
       * @return Iterator with all the com.infotec.rh.syr.swb.Postulante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Postulante> listPostulanteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Postulante with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Postulante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Postulante> listPostulanteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Postulante with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Postulante
       * @return Iterator with all the com.infotec.rh.syr.swb.Postulante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Postulante> listPostulanteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Postulante with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Postulante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Postulante> listPostulanteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PostulanteBase.ClassMgr getPostulanteClassMgr()
    {
        return new PostulanteBase.ClassMgr();
    }

   /**
   * Constructs a PostulanteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Postulante
   */
    public PostulanteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the FuenteInformacion property
* @return String with the FuenteInformacion
*/
    public String getFuenteInformacion()
    {
        return getSemanticObject().getProperty(intranet_fuenteInformacion);
    }

/**
* Sets the FuenteInformacion property
* @param value long with the FuenteInformacion
*/
    public void setFuenteInformacion(String value)
    {
        getSemanticObject().setProperty(intranet_fuenteInformacion, value);
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
* Gets the FechaEnvioCorreo property
* @return java.util.Date with the FechaEnvioCorreo
*/
    public java.util.Date getFechaEnvioCorreo()
    {
        return getSemanticObject().getDateProperty(intranet_fechaEnvioCorreo);
    }

/**
* Sets the FechaEnvioCorreo property
* @param value long with the FechaEnvioCorreo
*/
    public void setFechaEnvioCorreo(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaEnvioCorreo, value);
    }

/**
* Gets the FolioFuente property
* @return String with the FolioFuente
*/
    public String getFolioFuente()
    {
        return getSemanticObject().getProperty(intranet_folioFuente);
    }

/**
* Sets the FolioFuente property
* @param value long with the FolioFuente
*/
    public void setFolioFuente(String value)
    {
        getSemanticObject().setProperty(intranet_folioFuente, value);
    }

/**
* Gets the InhabilitadoSFP property
* @return boolean with the InhabilitadoSFP
*/
    public boolean isInhabilitadoSFP()
    {
        return getSemanticObject().getBooleanProperty(intranet_inhabilitadoSFP);
    }

/**
* Sets the InhabilitadoSFP property
* @param value long with the InhabilitadoSFP
*/
    public void setInhabilitadoSFP(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_inhabilitadoSFP, value);
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
* Gets the EmailPostulante property
* @return String with the EmailPostulante
*/
    public String getEmailPostulante()
    {
        return getSemanticObject().getProperty(intranet_emailPostulante);
    }

/**
* Sets the EmailPostulante property
* @param value long with the EmailPostulante
*/
    public void setEmailPostulante(String value)
    {
        getSemanticObject().setProperty(intranet_emailPostulante, value);
    }

/**
* Gets the FechaNotificaRegistro property
* @return java.util.Date with the FechaNotificaRegistro
*/
    public java.util.Date getFechaNotificaRegistro()
    {
        return getSemanticObject().getDateProperty(intranet_fechaNotificaRegistro);
    }

/**
* Sets the FechaNotificaRegistro property
* @param value long with the FechaNotificaRegistro
*/
    public void setFechaNotificaRegistro(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaNotificaRegistro, value);
    }

/**
* Gets the NombrePostulante property
* @return String with the NombrePostulante
*/
    public String getNombrePostulante()
    {
        return getSemanticObject().getProperty(intranet_nombrePostulante);
    }

/**
* Sets the NombrePostulante property
* @param value long with the NombrePostulante
*/
    public void setNombrePostulante(String value)
    {
        getSemanticObject().setProperty(intranet_nombrePostulante, value);
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
* Gets the CumplePerfil property
* @return boolean with the CumplePerfil
*/
    public boolean isCumplePerfil()
    {
        return getSemanticObject().getBooleanProperty(intranet_cumplePerfil);
    }

/**
* Sets the CumplePerfil property
* @param value long with the CumplePerfil
*/
    public void setCumplePerfil(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_cumplePerfil, value);
    }

/**
* Gets the RfcRegistro property
* @return String with the RfcRegistro
*/
    public String getRfcRegistro()
    {
        return getSemanticObject().getProperty(intranet_rfcRegistro);
    }

/**
* Sets the RfcRegistro property
* @param value long with the RfcRegistro
*/
    public void setRfcRegistro(String value)
    {
        getSemanticObject().setProperty(intranet_rfcRegistro, value);
    }
}
