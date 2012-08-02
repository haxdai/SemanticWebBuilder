package com.infotec.rh.syr.swb.base;


public abstract class ContratoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_colaboradoAnteriormente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#colaboradoAnteriormente");
    public static final org.semanticwb.platform.SemanticProperty intranet_clabeInterbancaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#clabeInterbancaria");
   /**
   * Elemento que contiene la información del perfil del usuario requerido
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudRecursoContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudRecursoContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_documentosPresentados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentosPresentados");
    public static final org.semanticwb.platform.SemanticClass intranet_Banco=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Banco");
    public static final org.semanticwb.platform.SemanticProperty intranet_banco=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#banco");
    public static final org.semanticwb.platform.SemanticProperty intranet_numeroPagos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numeroPagos");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_numEmpleado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numEmpleado");
    public static final org.semanticwb.platform.SemanticProperty intranet_seguridadSocial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#seguridadSocial");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_encargadoCotejo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#encargadoCotejo");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoDeContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoDeContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereKit");
    public static final org.semanticwb.platform.SemanticClass intranet_Contrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Contrato");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Contrato");

    public static class ClassMgr
    {
       /**
       * Returns a list of Contrato for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.Contrato for all models
       * @return Iterator of com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato>(it, true);
        }

        public static com.infotec.rh.syr.swb.Contrato createContrato(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.Contrato.ClassMgr.createContrato(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return A com.infotec.rh.syr.swb.Contrato
       */
        public static com.infotec.rh.syr.swb.Contrato getContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Contrato)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return A com.infotec.rh.syr.swb.Contrato
       */
        public static com.infotec.rh.syr.swb.Contrato createContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Contrato)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       */
        public static void removeContrato(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return true if the com.infotec.rh.syr.swb.Contrato exists, false otherwise
       */

        public static boolean hasContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (getContrato(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudRecursoContrato
       * @param value SolicitudRecursoContrato of the type com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudRecursoContrato(com.infotec.cvi.swb.SolicitudRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecursoContrato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudRecursoContrato
       * @param value SolicitudRecursoContrato of the type com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudRecursoContrato(com.infotec.cvi.swb.SolicitudRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecursoContrato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Banco
       * @param value Banco of the type com.infotec.eworkplace.swb.Banco
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByBanco(com.infotec.eworkplace.swb.Banco value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_banco, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Banco
       * @param value Banco of the type com.infotec.eworkplace.swb.Banco
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByBanco(com.infotec.eworkplace.swb.Banco value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_banco,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined EncargadoCotejo
       * @param value EncargadoCotejo of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByEncargadoCotejo(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoCotejo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined EncargadoCotejo
       * @param value EncargadoCotejo of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByEncargadoCotejo(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoCotejo,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ContratoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Contrato
   */
    public ContratoBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the ColaboradoAnteriormente property
* @return boolean with the ColaboradoAnteriormente
*/
    public boolean isColaboradoAnteriormente()
    {
        return getSemanticObject().getBooleanProperty(intranet_colaboradoAnteriormente);
    }

/**
* Sets the ColaboradoAnteriormente property
* @param value long with the ColaboradoAnteriormente
*/
    public void setColaboradoAnteriormente(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_colaboradoAnteriormente, value);
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
* Gets the ClabeInterbancaria property
* @return String with the ClabeInterbancaria
*/
    public String getClabeInterbancaria()
    {
        return getSemanticObject().getProperty(intranet_clabeInterbancaria);
    }

/**
* Sets the ClabeInterbancaria property
* @param value long with the ClabeInterbancaria
*/
    public void setClabeInterbancaria(String value)
    {
        getSemanticObject().setProperty(intranet_clabeInterbancaria, value);
    }
   /**
   * Sets the value for the property SolicitudRecursoContrato
   * @param value SolicitudRecursoContrato to set
   */

    public void setSolicitudRecursoContrato(com.infotec.cvi.swb.SolicitudRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudRecursoContrato, value.getSemanticObject());
        }else
        {
            removeSolicitudRecursoContrato();
        }
    }
   /**
   * Remove the value for SolicitudRecursoContrato property
   */

    public void removeSolicitudRecursoContrato()
    {
        getSemanticObject().removeProperty(intranet_solicitudRecursoContrato);
    }

   /**
   * Gets the SolicitudRecursoContrato
   * @return a com.infotec.cvi.swb.SolicitudRecurso
   */
    public com.infotec.cvi.swb.SolicitudRecurso getSolicitudRecursoContrato()
    {
         com.infotec.cvi.swb.SolicitudRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudRecursoContrato);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.SolicitudRecurso)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DocumentosPresentados property
* @return String with the DocumentosPresentados
*/
    public String getDocumentosPresentados()
    {
        return getSemanticObject().getProperty(intranet_documentosPresentados);
    }

/**
* Sets the DocumentosPresentados property
* @param value long with the DocumentosPresentados
*/
    public void setDocumentosPresentados(String value)
    {
        getSemanticObject().setProperty(intranet_documentosPresentados, value);
    }
   /**
   * Sets the value for the property Banco
   * @param value Banco to set
   */

    public void setBanco(com.infotec.eworkplace.swb.Banco value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_banco, value.getSemanticObject());
        }else
        {
            removeBanco();
        }
    }
   /**
   * Remove the value for Banco property
   */

    public void removeBanco()
    {
        getSemanticObject().removeProperty(intranet_banco);
    }

   /**
   * Gets the Banco
   * @return a com.infotec.eworkplace.swb.Banco
   */
    public com.infotec.eworkplace.swb.Banco getBanco()
    {
         com.infotec.eworkplace.swb.Banco ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_banco);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Banco)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NumeroPagos property
* @return int with the NumeroPagos
*/
    public int getNumeroPagos()
    {
        return getSemanticObject().getIntProperty(intranet_numeroPagos);
    }

/**
* Sets the NumeroPagos property
* @param value long with the NumeroPagos
*/
    public void setNumeroPagos(int value)
    {
        getSemanticObject().setIntProperty(intranet_numeroPagos, value);
    }

/**
* Gets the FolioContrato property
* @return String with the FolioContrato
*/
    public String getFolioContrato()
    {
        return getSemanticObject().getProperty(intranet_folioContrato);
    }

/**
* Sets the FolioContrato property
* @param value long with the FolioContrato
*/
    public void setFolioContrato(String value)
    {
        getSemanticObject().setProperty(intranet_folioContrato, value);
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
* Gets the NumEmpleado property
* @return int with the NumEmpleado
*/
    public int getNumEmpleado()
    {
        return getSemanticObject().getIntProperty(intranet_numEmpleado);
    }

/**
* Sets the NumEmpleado property
* @param value long with the NumEmpleado
*/
    public void setNumEmpleado(int value)
    {
        getSemanticObject().setIntProperty(intranet_numEmpleado, value);
    }

/**
* Gets the SeguridadSocial property
* @return String with the SeguridadSocial
*/
    public String getSeguridadSocial()
    {
        return getSemanticObject().getProperty(intranet_seguridadSocial);
    }

/**
* Sets the SeguridadSocial property
* @param value long with the SeguridadSocial
*/
    public void setSeguridadSocial(String value)
    {
        getSemanticObject().setProperty(intranet_seguridadSocial, value);
    }
   /**
   * Sets the value for the property EncargadoCotejo
   * @param value EncargadoCotejo to set
   */

    public void setEncargadoCotejo(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_encargadoCotejo, value.getSemanticObject());
        }else
        {
            removeEncargadoCotejo();
        }
    }
   /**
   * Remove the value for EncargadoCotejo property
   */

    public void removeEncargadoCotejo()
    {
        getSemanticObject().removeProperty(intranet_encargadoCotejo);
    }

   /**
   * Gets the EncargadoCotejo
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEncargadoCotejo()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_encargadoCotejo);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
* Gets the TipoDeContrato property
* @return int with the TipoDeContrato
*/
    public int getTipoDeContrato()
    {
        return getSemanticObject().getIntProperty(intranet_tipoDeContrato);
    }

/**
* Sets the TipoDeContrato property
* @param value long with the TipoDeContrato
*/
    public void setTipoDeContrato(int value)
    {
        getSemanticObject().setIntProperty(intranet_tipoDeContrato, value);
    }

/**
* Gets the RequiereKit property
* @return boolean with the RequiereKit
*/
    public boolean isRequiereKit()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereKit);
    }

/**
* Sets the RequiereKit property
* @param value long with the RequiereKit
*/
    public void setRequiereKit(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereKit, value);
    }
}
