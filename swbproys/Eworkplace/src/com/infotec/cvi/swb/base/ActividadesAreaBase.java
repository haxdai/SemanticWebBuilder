package com.infotec.cvi.swb.base;


   /**
   * Adminsitra las actividades para CCO; DCP, ACD de RH 
   */
public abstract class ActividadesAreaBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_notaAutorizacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaAutorizacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaValida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaValida");
    public static final org.semanticwb.platform.SemanticProperty intranet_FechaAprobación=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#FechaAprobación");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_responsableAprobacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#responsableAprobacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_adjuntarArchivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#adjuntarArchivo");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaAprobacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaAprobacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_responsableElaboracion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#responsableElaboracion");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaValidacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaValidacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_apruebaDocumento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#apruebaDocumento");
    public static final org.semanticwb.platform.SemanticProperty intranet_responsableValida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#responsableValida");
    public static final org.semanticwb.platform.SemanticProperty intranet_validaDocumento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validaDocumento");
    public static final org.semanticwb.platform.SemanticProperty intranet_FechaAutorización=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#FechaAutorización");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaDocumento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaDocumento");
   /**
   * Adminsitra las actividades para CCO; DCP, ACD de RH
   */
    public static final org.semanticwb.platform.SemanticClass intranet_ActividadesArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ActividadesArea");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ActividadesArea");

    public static class ClassMgr
    {
       /**
       * Returns a list of ActividadesArea for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.ActividadesArea for all models
       * @return Iterator of com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(it, true);
        }

        public static com.infotec.cvi.swb.ActividadesArea createActividadesArea(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.ActividadesArea.ClassMgr.createActividadesArea(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.ActividadesArea
       * @param id Identifier for com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return A com.infotec.cvi.swb.ActividadesArea
       */
        public static com.infotec.cvi.swb.ActividadesArea getActividadesArea(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ActividadesArea)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.ActividadesArea
       * @param id Identifier for com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return A com.infotec.cvi.swb.ActividadesArea
       */
        public static com.infotec.cvi.swb.ActividadesArea createActividadesArea(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ActividadesArea)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.ActividadesArea
       * @param id Identifier for com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       */
        public static void removeActividadesArea(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.ActividadesArea
       * @param id Identifier for com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
       */

        public static boolean hasActividadesArea(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActividadesArea(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ResponsableAprobacion
       * @param value ResponsableAprobacion of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByResponsableAprobacion(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_responsableAprobacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ResponsableAprobacion
       * @param value ResponsableAprobacion of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByResponsableAprobacion(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_responsableAprobacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ResponsableElaboracion
       * @param value ResponsableElaboracion of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByResponsableElaboracion(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_responsableElaboracion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ResponsableElaboracion
       * @param value ResponsableElaboracion of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByResponsableElaboracion(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_responsableElaboracion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ResponsableValida
       * @param value ResponsableValida of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByResponsableValida(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_responsableValida, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined ResponsableValida
       * @param value ResponsableValida of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByResponsableValida(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_responsableValida,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ActividadesArea with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ActividadesArea
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ActividadesArea> listActividadesAreaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ActividadesAreaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ActividadesArea
   */
    public ActividadesAreaBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the NotaAutorizacion property
* @return String with the NotaAutorizacion
*/
    public String getNotaAutorizacion()
    {
        return getSemanticObject().getProperty(intranet_notaAutorizacion);
    }

/**
* Sets the NotaAutorizacion property
* @param value long with the NotaAutorizacion
*/
    public void setNotaAutorizacion(String value)
    {
        getSemanticObject().setProperty(intranet_notaAutorizacion, value);
    }

/**
* Gets the FechaValida property
* @return java.util.Date with the FechaValida
*/
    public java.util.Date getFechaValida()
    {
        return getSemanticObject().getDateProperty(intranet_fechaValida);
    }

/**
* Sets the FechaValida property
* @param value long with the FechaValida
*/
    public void setFechaValida(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaValida, value);
    }

/**
* Gets the FechaAprobación property
* @return java.util.Date with the FechaAprobación
*/
    public java.util.Date getFechaAprobación()
    {
        return getSemanticObject().getDateProperty(intranet_FechaAprobación);
    }

/**
* Sets the FechaAprobación property
* @param value long with the FechaAprobación
*/
    public void setFechaAprobación(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_FechaAprobación, value);
    }
   /**
   * Sets the value for the property ResponsableAprobacion
   * @param value ResponsableAprobacion to set
   */

    public void setResponsableAprobacion(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_responsableAprobacion, value.getSemanticObject());
        }else
        {
            removeResponsableAprobacion();
        }
    }
   /**
   * Remove the value for ResponsableAprobacion property
   */

    public void removeResponsableAprobacion()
    {
        getSemanticObject().removeProperty(intranet_responsableAprobacion);
    }

   /**
   * Gets the ResponsableAprobacion
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getResponsableAprobacion()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_responsableAprobacion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
* Gets the AdjuntarArchivo property
* @return String with the AdjuntarArchivo
*/
    public String getAdjuntarArchivo()
    {
        return getSemanticObject().getProperty(intranet_adjuntarArchivo);
    }

/**
* Sets the AdjuntarArchivo property
* @param value long with the AdjuntarArchivo
*/
    public void setAdjuntarArchivo(String value)
    {
        getSemanticObject().setProperty(intranet_adjuntarArchivo, value);
    }

/**
* Gets the NotaAprobacion property
* @return String with the NotaAprobacion
*/
    public String getNotaAprobacion()
    {
        return getSemanticObject().getProperty(intranet_notaAprobacion);
    }

/**
* Sets the NotaAprobacion property
* @param value long with the NotaAprobacion
*/
    public void setNotaAprobacion(String value)
    {
        getSemanticObject().setProperty(intranet_notaAprobacion, value);
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
   * Sets the value for the property ResponsableElaboracion
   * @param value ResponsableElaboracion to set
   */

    public void setResponsableElaboracion(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_responsableElaboracion, value.getSemanticObject());
        }else
        {
            removeResponsableElaboracion();
        }
    }
   /**
   * Remove the value for ResponsableElaboracion property
   */

    public void removeResponsableElaboracion()
    {
        getSemanticObject().removeProperty(intranet_responsableElaboracion);
    }

   /**
   * Gets the ResponsableElaboracion
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getResponsableElaboracion()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_responsableElaboracion);
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
* Gets the NotaValidacion property
* @return String with the NotaValidacion
*/
    public String getNotaValidacion()
    {
        return getSemanticObject().getProperty(intranet_notaValidacion);
    }

/**
* Sets the NotaValidacion property
* @param value long with the NotaValidacion
*/
    public void setNotaValidacion(String value)
    {
        getSemanticObject().setProperty(intranet_notaValidacion, value);
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
* Gets the ApruebaDocumento property
* @return boolean with the ApruebaDocumento
*/
    public boolean isApruebaDocumento()
    {
        return getSemanticObject().getBooleanProperty(intranet_apruebaDocumento);
    }

/**
* Sets the ApruebaDocumento property
* @param value long with the ApruebaDocumento
*/
    public void setApruebaDocumento(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_apruebaDocumento, value);
    }
   /**
   * Sets the value for the property ResponsableValida
   * @param value ResponsableValida to set
   */

    public void setResponsableValida(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_responsableValida, value.getSemanticObject());
        }else
        {
            removeResponsableValida();
        }
    }
   /**
   * Remove the value for ResponsableValida property
   */

    public void removeResponsableValida()
    {
        getSemanticObject().removeProperty(intranet_responsableValida);
    }

   /**
   * Gets the ResponsableValida
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getResponsableValida()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_responsableValida);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ValidaDocumento property
* @return boolean with the ValidaDocumento
*/
    public boolean isValidaDocumento()
    {
        return getSemanticObject().getBooleanProperty(intranet_validaDocumento);
    }

/**
* Sets the ValidaDocumento property
* @param value long with the ValidaDocumento
*/
    public void setValidaDocumento(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validaDocumento, value);
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
* Gets the FechaAutorización property
* @return java.util.Date with the FechaAutorización
*/
    public java.util.Date getFechaAutorización()
    {
        return getSemanticObject().getDateProperty(intranet_FechaAutorización);
    }

/**
* Sets the FechaAutorización property
* @param value long with the FechaAutorización
*/
    public void setFechaAutorización(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_FechaAutorización, value);
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
* Gets the AutorizaDocumento property
* @return boolean with the AutorizaDocumento
*/
    public boolean isAutorizaDocumento()
    {
        return getSemanticObject().getBooleanProperty(intranet_autorizaDocumento);
    }

/**
* Sets the AutorizaDocumento property
* @param value long with the AutorizaDocumento
*/
    public void setAutorizaDocumento(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_autorizaDocumento, value);
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
