package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula las propiedades de una publicación de una vacante en las bolsas de trabajo 
   */
public abstract class PublicacionVacanteBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
   /**
   * Encapsula las propiedades relacionadas con una bolsa de trabajo para publicación de vacantes de empleo
   */
    public static final org.semanticwb.platform.SemanticClass intranet_BolsaTrabajo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#BolsaTrabajo");
    public static final org.semanticwb.platform.SemanticProperty intranet_bolsaTrabajo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#bolsaTrabajo");
    public static final org.semanticwb.platform.SemanticProperty intranet_archivoPublicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#archivoPublicacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaPublicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaPublicacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioPublicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioPublicacion");
   /**
   * Encapsula las propiedades de una publicación de una vacante en las bolsas de trabajo
   */
    public static final org.semanticwb.platform.SemanticClass intranet_PublicacionVacante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PublicacionVacante");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PublicacionVacante");

    public static class ClassMgr
    {
       /**
       * Returns a list of PublicacionVacante for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacantes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.PublicacionVacante for all models
       * @return Iterator of com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacantes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante>(it, true);
        }

        public static com.infotec.rh.syr.swb.PublicacionVacante createPublicacionVacante(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.PublicacionVacante.ClassMgr.createPublicacionVacante(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.PublicacionVacante
       * @param id Identifier for com.infotec.rh.syr.swb.PublicacionVacante
       * @param model Model of the com.infotec.rh.syr.swb.PublicacionVacante
       * @return A com.infotec.rh.syr.swb.PublicacionVacante
       */
        public static com.infotec.rh.syr.swb.PublicacionVacante getPublicacionVacante(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.PublicacionVacante)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.PublicacionVacante
       * @param id Identifier for com.infotec.rh.syr.swb.PublicacionVacante
       * @param model Model of the com.infotec.rh.syr.swb.PublicacionVacante
       * @return A com.infotec.rh.syr.swb.PublicacionVacante
       */
        public static com.infotec.rh.syr.swb.PublicacionVacante createPublicacionVacante(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.PublicacionVacante)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.PublicacionVacante
       * @param id Identifier for com.infotec.rh.syr.swb.PublicacionVacante
       * @param model Model of the com.infotec.rh.syr.swb.PublicacionVacante
       */
        public static void removePublicacionVacante(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.PublicacionVacante
       * @param id Identifier for com.infotec.rh.syr.swb.PublicacionVacante
       * @param model Model of the com.infotec.rh.syr.swb.PublicacionVacante
       * @return true if the com.infotec.rh.syr.swb.PublicacionVacante exists, false otherwise
       */

        public static boolean hasPublicacionVacante(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPublicacionVacante(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PublicacionVacante with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.PublicacionVacante
       * @return Iterator with all the com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacanteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PublicacionVacante with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacanteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PublicacionVacante with a determined BolsaTrabajo
       * @param value BolsaTrabajo of the type com.infotec.rh.syr.swb.BolsaTrabajo
       * @param model Model of the com.infotec.rh.syr.swb.PublicacionVacante
       * @return Iterator with all the com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacanteByBolsaTrabajo(com.infotec.rh.syr.swb.BolsaTrabajo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_bolsaTrabajo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PublicacionVacante with a determined BolsaTrabajo
       * @param value BolsaTrabajo of the type com.infotec.rh.syr.swb.BolsaTrabajo
       * @return Iterator with all the com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacanteByBolsaTrabajo(com.infotec.rh.syr.swb.BolsaTrabajo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_bolsaTrabajo,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PublicacionVacante with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.PublicacionVacante
       * @return Iterator with all the com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacanteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PublicacionVacante with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.PublicacionVacante
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacanteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PublicacionVacanteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PublicacionVacante
   */
    public PublicacionVacanteBase(org.semanticwb.platform.SemanticObject base)
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
   * Sets the value for the property BolsaTrabajo
   * @param value BolsaTrabajo to set
   */

    public void setBolsaTrabajo(com.infotec.rh.syr.swb.BolsaTrabajo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_bolsaTrabajo, value.getSemanticObject());
        }else
        {
            removeBolsaTrabajo();
        }
    }
   /**
   * Remove the value for BolsaTrabajo property
   */

    public void removeBolsaTrabajo()
    {
        getSemanticObject().removeProperty(intranet_bolsaTrabajo);
    }

   /**
   * Gets the BolsaTrabajo
   * @return a com.infotec.rh.syr.swb.BolsaTrabajo
   */
    public com.infotec.rh.syr.swb.BolsaTrabajo getBolsaTrabajo()
    {
         com.infotec.rh.syr.swb.BolsaTrabajo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_bolsaTrabajo);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.BolsaTrabajo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ArchivoPublicacion property
* @return String with the ArchivoPublicacion
*/
    public String getArchivoPublicacion()
    {
        return getSemanticObject().getProperty(intranet_archivoPublicacion);
    }

/**
* Sets the ArchivoPublicacion property
* @param value long with the ArchivoPublicacion
*/
    public void setArchivoPublicacion(String value)
    {
        getSemanticObject().setProperty(intranet_archivoPublicacion, value);
    }

/**
* Gets the FechaPublicacion property
* @return java.util.Date with the FechaPublicacion
*/
    public java.util.Date getFechaPublicacion()
    {
        return getSemanticObject().getDateProperty(intranet_fechaPublicacion);
    }

/**
* Sets the FechaPublicacion property
* @param value long with the FechaPublicacion
*/
    public void setFechaPublicacion(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaPublicacion, value);
    }

/**
* Gets the FolioPublicacion property
* @return String with the FolioPublicacion
*/
    public String getFolioPublicacion()
    {
        return getSemanticObject().getProperty(intranet_folioPublicacion);
    }

/**
* Sets the FolioPublicacion property
* @param value long with the FolioPublicacion
*/
    public void setFolioPublicacion(String value)
    {
        getSemanticObject().setProperty(intranet_folioPublicacion, value);
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
