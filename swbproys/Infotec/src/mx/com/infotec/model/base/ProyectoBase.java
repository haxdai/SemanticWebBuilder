package mx.com.infotec.model.base;


public abstract class ProyectoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty info_seguimientoRiesgos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#seguimientoRiesgos");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty info_apResponsable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#apResponsable");
    public static final org.semanticwb.platform.SemanticProperty info_comentarios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#comentarios");
    public static final org.semanticwb.platform.SemanticProperty info_accionesProx=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#accionesProx");
    public static final org.semanticwb.platform.SemanticProperty info_ingresoProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#ingresoProyecto");
    public static final org.semanticwb.platform.SemanticProperty info_situacionFacturacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#situacionFacturacion");
    public static final org.semanticwb.platform.SemanticProperty info_montoProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#montoProyecto");
    public static final org.semanticwb.platform.SemanticProperty info_situacionCobro=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#situacionCobro");
    public static final org.semanticwb.platform.SemanticProperty info_situacionContractual=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#situacionContractual");
    public static final org.semanticwb.platform.SemanticProperty info_probabilidadOcurrir=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#probabilidadOcurrir");
    public static final org.semanticwb.platform.SemanticProperty info_statusGralProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#statusGralProyecto");
    public static final org.semanticwb.platform.SemanticProperty info_proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#proyecto");
    public static final org.semanticwb.platform.SemanticProperty info_cliente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#cliente");
    public static final org.semanticwb.platform.SemanticProperty info_numProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#numProyecto");
    public static final org.semanticwb.platform.SemanticProperty info_entregablesRealizados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#entregablesRealizados");
    public static final org.semanticwb.platform.SemanticProperty info_riesgosDetectados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#riesgosDetectados");
    public static final org.semanticwb.platform.SemanticClass info_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/ontology#Proyecto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/ontology#Proyecto");

    public static class ClassMgr
    {
       /**
       * Returns a list of Proyecto for a model
       * @param model Model to find
       * @return Iterator of mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto>(it, true);
        }
       /**
       * Returns a list of mx.com.infotec.model.Proyecto for all models
       * @return Iterator of mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto>(it, true);
        }

        public static mx.com.infotec.model.Proyecto createProyecto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.com.infotec.model.Proyecto.ClassMgr.createProyecto(String.valueOf(id), model);
        }
       /**
       * Gets a mx.com.infotec.model.Proyecto
       * @param id Identifier for mx.com.infotec.model.Proyecto
       * @param model Model of the mx.com.infotec.model.Proyecto
       * @return A mx.com.infotec.model.Proyecto
       */
        public static mx.com.infotec.model.Proyecto getProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.com.infotec.model.Proyecto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.com.infotec.model.Proyecto
       * @param id Identifier for mx.com.infotec.model.Proyecto
       * @param model Model of the mx.com.infotec.model.Proyecto
       * @return A mx.com.infotec.model.Proyecto
       */
        public static mx.com.infotec.model.Proyecto createProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.com.infotec.model.Proyecto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.com.infotec.model.Proyecto
       * @param id Identifier for mx.com.infotec.model.Proyecto
       * @param model Model of the mx.com.infotec.model.Proyecto
       */
        public static void removeProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.com.infotec.model.Proyecto
       * @param id Identifier for mx.com.infotec.model.Proyecto
       * @param model Model of the mx.com.infotec.model.Proyecto
       * @return true if the mx.com.infotec.model.Proyecto exists, false otherwise
       */

        public static boolean hasProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProyecto(id, model)!=null);
        }
       /**
       * Gets all mx.com.infotec.model.Proyecto with a determined ApResponsable
       * @param value ApResponsable of the type org.semanticwb.model.User
       * @param model Model of the mx.com.infotec.model.Proyecto
       * @return Iterator with all the mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectoByApResponsable(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(info_apResponsable, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Proyecto with a determined ApResponsable
       * @param value ApResponsable of the type org.semanticwb.model.User
       * @return Iterator with all the mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectoByApResponsable(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(info_apResponsable,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Proyecto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.com.infotec.model.Proyecto
       * @return Iterator with all the mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Proyecto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Proyecto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.com.infotec.model.Proyecto
       * @return Iterator with all the mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Proyecto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.com.infotec.model.Proyecto
       */

        public static java.util.Iterator<mx.com.infotec.model.Proyecto> listProyectoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Proyecto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProyectoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Proyecto
   */
    public ProyectoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the SeguimientoRiesgos property
* @return String with the SeguimientoRiesgos
*/
    public String getSeguimientoRiesgos()
    {
        return getSemanticObject().getProperty(info_seguimientoRiesgos);
    }

/**
* Sets the SeguimientoRiesgos property
* @param value long with the SeguimientoRiesgos
*/
    public void setSeguimientoRiesgos(String value)
    {
        getSemanticObject().setProperty(info_seguimientoRiesgos, value);
    }
   /**
   * Sets the value for the property ApResponsable
   * @param value ApResponsable to set
   */

    public void setApResponsable(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(info_apResponsable, value.getSemanticObject());
        }else
        {
            removeApResponsable();
        }
    }
   /**
   * Remove the value for ApResponsable property
   */

    public void removeApResponsable()
    {
        getSemanticObject().removeProperty(info_apResponsable);
    }

   /**
   * Gets the ApResponsable
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getApResponsable()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(info_apResponsable);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Comentarios property
* @return String with the Comentarios
*/
    public String getComentarios()
    {
        return getSemanticObject().getProperty(info_comentarios);
    }

/**
* Sets the Comentarios property
* @param value long with the Comentarios
*/
    public void setComentarios(String value)
    {
        getSemanticObject().setProperty(info_comentarios, value);
    }

/**
* Gets the AccionesProx property
* @return String with the AccionesProx
*/
    public String getAccionesProx()
    {
        return getSemanticObject().getProperty(info_accionesProx);
    }

/**
* Sets the AccionesProx property
* @param value long with the AccionesProx
*/
    public void setAccionesProx(String value)
    {
        getSemanticObject().setProperty(info_accionesProx, value);
    }

/**
* Gets the IngresoProyecto property
* @return String with the IngresoProyecto
*/
    public String getIngresoProyecto()
    {
        return getSemanticObject().getProperty(info_ingresoProyecto);
    }

/**
* Sets the IngresoProyecto property
* @param value long with the IngresoProyecto
*/
    public void setIngresoProyecto(String value)
    {
        getSemanticObject().setProperty(info_ingresoProyecto, value);
    }

/**
* Gets the SituacionFacturacion property
* @return String with the SituacionFacturacion
*/
    public String getSituacionFacturacion()
    {
        return getSemanticObject().getProperty(info_situacionFacturacion);
    }

/**
* Sets the SituacionFacturacion property
* @param value long with the SituacionFacturacion
*/
    public void setSituacionFacturacion(String value)
    {
        getSemanticObject().setProperty(info_situacionFacturacion, value);
    }

/**
* Gets the MontoProyecto property
* @return String with the MontoProyecto
*/
    public String getMontoProyecto()
    {
        return getSemanticObject().getProperty(info_montoProyecto);
    }

/**
* Sets the MontoProyecto property
* @param value long with the MontoProyecto
*/
    public void setMontoProyecto(String value)
    {
        getSemanticObject().setProperty(info_montoProyecto, value);
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
* Gets the SituacionCobro property
* @return String with the SituacionCobro
*/
    public String getSituacionCobro()
    {
        return getSemanticObject().getProperty(info_situacionCobro);
    }

/**
* Sets the SituacionCobro property
* @param value long with the SituacionCobro
*/
    public void setSituacionCobro(String value)
    {
        getSemanticObject().setProperty(info_situacionCobro, value);
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
* Gets the SituacionContractual property
* @return String with the SituacionContractual
*/
    public String getSituacionContractual()
    {
        return getSemanticObject().getProperty(info_situacionContractual);
    }

/**
* Sets the SituacionContractual property
* @param value long with the SituacionContractual
*/
    public void setSituacionContractual(String value)
    {
        getSemanticObject().setProperty(info_situacionContractual, value);
    }

/**
* Gets the ProbabilidadOcurrir property
* @return String with the ProbabilidadOcurrir
*/
    public String getProbabilidadOcurrir()
    {
        return getSemanticObject().getProperty(info_probabilidadOcurrir);
    }

/**
* Sets the ProbabilidadOcurrir property
* @param value long with the ProbabilidadOcurrir
*/
    public void setProbabilidadOcurrir(String value)
    {
        getSemanticObject().setProperty(info_probabilidadOcurrir, value);
    }

/**
* Gets the StatusGralProyecto property
* @return String with the StatusGralProyecto
*/
    public String getStatusGralProyecto()
    {
        return getSemanticObject().getProperty(info_statusGralProyecto);
    }

/**
* Sets the StatusGralProyecto property
* @param value long with the StatusGralProyecto
*/
    public void setStatusGralProyecto(String value)
    {
        getSemanticObject().setProperty(info_statusGralProyecto, value);
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
* Gets the Proyecto property
* @return String with the Proyecto
*/
    public String getProyecto()
    {
        return getSemanticObject().getProperty(info_proyecto);
    }

/**
* Sets the Proyecto property
* @param value long with the Proyecto
*/
    public void setProyecto(String value)
    {
        getSemanticObject().setProperty(info_proyecto, value);
    }

/**
* Gets the Cliente property
* @return String with the Cliente
*/
    public String getCliente()
    {
        return getSemanticObject().getProperty(info_cliente);
    }

/**
* Sets the Cliente property
* @param value long with the Cliente
*/
    public void setCliente(String value)
    {
        getSemanticObject().setProperty(info_cliente, value);
    }

/**
* Gets the NumProyecto property
* @return String with the NumProyecto
*/
    public String getNumProyecto()
    {
        return getSemanticObject().getProperty(info_numProyecto);
    }

/**
* Sets the NumProyecto property
* @param value long with the NumProyecto
*/
    public void setNumProyecto(String value)
    {
        getSemanticObject().setProperty(info_numProyecto, value);
    }

/**
* Gets the EntregablesRealizados property
* @return String with the EntregablesRealizados
*/
    public String getEntregablesRealizados()
    {
        return getSemanticObject().getProperty(info_entregablesRealizados);
    }

/**
* Sets the EntregablesRealizados property
* @param value long with the EntregablesRealizados
*/
    public void setEntregablesRealizados(String value)
    {
        getSemanticObject().setProperty(info_entregablesRealizados, value);
    }

/**
* Gets the RiesgosDetectados property
* @return String with the RiesgosDetectados
*/
    public String getRiesgosDetectados()
    {
        return getSemanticObject().getProperty(info_riesgosDetectados);
    }

/**
* Sets the RiesgosDetectados property
* @param value long with the RiesgosDetectados
*/
    public void setRiesgosDetectados(String value)
    {
        getSemanticObject().setProperty(info_riesgosDetectados, value);
    }
}
