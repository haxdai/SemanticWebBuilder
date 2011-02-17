package mx.com.infotec.model.base;


public abstract class AusenciaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty info_fechaInicial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#fechaInicial");
    public static final org.semanticwb.platform.SemanticProperty info_tipo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#tipo");
    public static final org.semanticwb.platform.SemanticProperty info_fechaFin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#fechaFin");
    public static final org.semanticwb.platform.SemanticProperty info_descripcion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/ontology#descripcion");
    public static final org.semanticwb.platform.SemanticClass info_Ausencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/ontology#Ausencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/ontology#Ausencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Ausencia for a model
       * @param model Model to find
       * @return Iterator of mx.com.infotec.model.Ausencia
       */

        public static java.util.Iterator<mx.com.infotec.model.Ausencia> listAusencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.com.infotec.model.Ausencia>(it, true);
        }
       /**
       * Returns a list of mx.com.infotec.model.Ausencia for all models
       * @return Iterator of mx.com.infotec.model.Ausencia
       */

        public static java.util.Iterator<mx.com.infotec.model.Ausencia> listAusencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.com.infotec.model.Ausencia>(it, true);
        }

        public static mx.com.infotec.model.Ausencia createAusencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.com.infotec.model.Ausencia.ClassMgr.createAusencia(String.valueOf(id), model);
        }
       /**
       * Gets a mx.com.infotec.model.Ausencia
       * @param id Identifier for mx.com.infotec.model.Ausencia
       * @param model Model of the mx.com.infotec.model.Ausencia
       * @return A mx.com.infotec.model.Ausencia
       */
        public static mx.com.infotec.model.Ausencia getAusencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.com.infotec.model.Ausencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.com.infotec.model.Ausencia
       * @param id Identifier for mx.com.infotec.model.Ausencia
       * @param model Model of the mx.com.infotec.model.Ausencia
       * @return A mx.com.infotec.model.Ausencia
       */
        public static mx.com.infotec.model.Ausencia createAusencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.com.infotec.model.Ausencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.com.infotec.model.Ausencia
       * @param id Identifier for mx.com.infotec.model.Ausencia
       * @param model Model of the mx.com.infotec.model.Ausencia
       */
        public static void removeAusencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.com.infotec.model.Ausencia
       * @param id Identifier for mx.com.infotec.model.Ausencia
       * @param model Model of the mx.com.infotec.model.Ausencia
       * @return true if the mx.com.infotec.model.Ausencia exists, false otherwise
       */

        public static boolean hasAusencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAusencia(id, model)!=null);
        }
       /**
       * Gets all mx.com.infotec.model.Ausencia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.com.infotec.model.Ausencia
       * @return Iterator with all the mx.com.infotec.model.Ausencia
       */

        public static java.util.Iterator<mx.com.infotec.model.Ausencia> listAusenciaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Ausencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Ausencia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.com.infotec.model.Ausencia
       */

        public static java.util.Iterator<mx.com.infotec.model.Ausencia> listAusenciaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Ausencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Ausencia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.com.infotec.model.Ausencia
       * @return Iterator with all the mx.com.infotec.model.Ausencia
       */

        public static java.util.Iterator<mx.com.infotec.model.Ausencia> listAusenciaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Ausencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.com.infotec.model.Ausencia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.com.infotec.model.Ausencia
       */

        public static java.util.Iterator<mx.com.infotec.model.Ausencia> listAusenciaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.com.infotec.model.Ausencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AusenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Ausencia
   */
    public AusenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the FechaInicial property
* @return java.util.Date with the FechaInicial
*/
    public java.util.Date getFechaInicial()
    {
        return getSemanticObject().getDateProperty(info_fechaInicial);
    }

/**
* Sets the FechaInicial property
* @param value long with the FechaInicial
*/
    public void setFechaInicial(java.util.Date value)
    {
        getSemanticObject().setDateProperty(info_fechaInicial, value);
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
* Gets the TipoAusencia property
* @return String with the TipoAusencia
*/
    public String getTipoAusencia()
    {
        return getSemanticObject().getProperty(info_tipo);
    }

/**
* Sets the TipoAusencia property
* @param value long with the TipoAusencia
*/
    public void setTipoAusencia(String value)
    {
        getSemanticObject().setProperty(info_tipo, value);
    }

/**
* Gets the FechaFin property
* @return java.util.Date with the FechaFin
*/
    public java.util.Date getFechaFin()
    {
        return getSemanticObject().getDateProperty(info_fechaFin);
    }

/**
* Sets the FechaFin property
* @param value long with the FechaFin
*/
    public void setFechaFin(java.util.Date value)
    {
        getSemanticObject().setDateProperty(info_fechaFin, value);
    }

/**
* Gets the Descripcion property
* @return String with the Descripcion
*/
    public String getDescripcion()
    {
        return getSemanticObject().getProperty(info_descripcion);
    }

/**
* Sets the Descripcion property
* @param value long with the Descripcion
*/
    public void setDescripcion(String value)
    {
        getSemanticObject().setProperty(info_descripcion, value);
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
}
