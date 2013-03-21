package mx.gob.inmujeres.swb.base;


public abstract class CursoEvaluacionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty inm_nombreCurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#nombreCurso");
    public static final org.semanticwb.platform.SemanticProperty inm_justificacionObjetivoRelacionado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#justificacionObjetivoRelacionado");
    public static final org.semanticwb.platform.SemanticClass inm_Trimestre=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Trimestre");
    public static final org.semanticwb.platform.SemanticProperty inm_trimestreAnioAplicar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#trimestreAnioAplicar");
    public static final org.semanticwb.platform.SemanticClass inm_CursoEvaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#CursoEvaluacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#CursoEvaluacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of CursoEvaluacion for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.CursoEvaluacion for all models
       * @return Iterator of mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion>(it, true);
        }

        public static mx.gob.inmujeres.swb.CursoEvaluacion createCursoEvaluacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.CursoEvaluacion.ClassMgr.createCursoEvaluacion(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.CursoEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.CursoEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.CursoEvaluacion
       * @return A mx.gob.inmujeres.swb.CursoEvaluacion
       */
        public static mx.gob.inmujeres.swb.CursoEvaluacion getCursoEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.CursoEvaluacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.CursoEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.CursoEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.CursoEvaluacion
       * @return A mx.gob.inmujeres.swb.CursoEvaluacion
       */
        public static mx.gob.inmujeres.swb.CursoEvaluacion createCursoEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.CursoEvaluacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.CursoEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.CursoEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.CursoEvaluacion
       */
        public static void removeCursoEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.CursoEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.CursoEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.CursoEvaluacion
       * @return true if the mx.gob.inmujeres.swb.CursoEvaluacion exists, false otherwise
       */

        public static boolean hasCursoEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCursoEvaluacion(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.CursoEvaluacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.CursoEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.CursoEvaluacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.CursoEvaluacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.CursoEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.CursoEvaluacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.CursoEvaluacion with a determined TrimestreAnioAplicar
       * @param value TrimestreAnioAplicar of the type mx.gob.inmujeres.swb.Trimestre
       * @param model Model of the mx.gob.inmujeres.swb.CursoEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacionByTrimestreAnioAplicar(mx.gob.inmujeres.swb.Trimestre value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_trimestreAnioAplicar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.CursoEvaluacion with a determined TrimestreAnioAplicar
       * @param value TrimestreAnioAplicar of the type mx.gob.inmujeres.swb.Trimestre
       * @return Iterator with all the mx.gob.inmujeres.swb.CursoEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoEvaluacionByTrimestreAnioAplicar(mx.gob.inmujeres.swb.Trimestre value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_trimestreAnioAplicar,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CursoEvaluacionBase.ClassMgr getCursoEvaluacionClassMgr()
    {
        return new CursoEvaluacionBase.ClassMgr();
    }

   /**
   * Constructs a CursoEvaluacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CursoEvaluacion
   */
    public CursoEvaluacionBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the NombreCurso property
* @return String with the NombreCurso
*/
    public String getNombreCurso()
    {
        return getSemanticObject().getProperty(inm_nombreCurso);
    }

/**
* Sets the NombreCurso property
* @param value long with the NombreCurso
*/
    public void setNombreCurso(String value)
    {
        getSemanticObject().setProperty(inm_nombreCurso, value);
    }

/**
* Gets the JustificacionObjetivoRelacionado property
* @return String with the JustificacionObjetivoRelacionado
*/
    public String getJustificacionObjetivoRelacionado()
    {
        return getSemanticObject().getProperty(inm_justificacionObjetivoRelacionado);
    }

/**
* Sets the JustificacionObjetivoRelacionado property
* @param value long with the JustificacionObjetivoRelacionado
*/
    public void setJustificacionObjetivoRelacionado(String value)
    {
        getSemanticObject().setProperty(inm_justificacionObjetivoRelacionado, value);
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
   * Sets the value for the property TrimestreAnioAplicar
   * @param value TrimestreAnioAplicar to set
   */

    public void setTrimestreAnioAplicar(mx.gob.inmujeres.swb.Trimestre value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_trimestreAnioAplicar, value.getSemanticObject());
        }else
        {
            removeTrimestreAnioAplicar();
        }
    }
   /**
   * Remove the value for TrimestreAnioAplicar property
   */

    public void removeTrimestreAnioAplicar()
    {
        getSemanticObject().removeProperty(inm_trimestreAnioAplicar);
    }

   /**
   * Gets the TrimestreAnioAplicar
   * @return a mx.gob.inmujeres.swb.Trimestre
   */
    public mx.gob.inmujeres.swb.Trimestre getTrimestreAnioAplicar()
    {
         mx.gob.inmujeres.swb.Trimestre ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_trimestreAnioAplicar);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Trimestre)obj.createGenericInstance();
         }
         return ret;
    }
}
