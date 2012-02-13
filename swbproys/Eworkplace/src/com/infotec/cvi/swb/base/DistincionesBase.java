package com.infotec.cvi.swb.base;


public abstract class DistincionesBase extends com.infotec.cvi.swb.ExperienciaProfesional implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaDistincion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaDistincion");
    public static final org.semanticwb.platform.SemanticProperty intranet_otorgante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#otorgante");
    public static final org.semanticwb.platform.SemanticClass intranet_Distinciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Distinciones");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Distinciones");

    public static class ClassMgr
    {
       /**
       * Returns a list of Distinciones for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Distinciones
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Distinciones> listDistincioneses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distinciones>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Distinciones for all models
       * @return Iterator of com.infotec.cvi.swb.Distinciones
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Distinciones> listDistincioneses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distinciones>(it, true);
        }

        public static com.infotec.cvi.swb.Distinciones createDistinciones(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Distinciones.ClassMgr.createDistinciones(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Distinciones
       * @param id Identifier for com.infotec.cvi.swb.Distinciones
       * @param model Model of the com.infotec.cvi.swb.Distinciones
       * @return A com.infotec.cvi.swb.Distinciones
       */
        public static com.infotec.cvi.swb.Distinciones getDistinciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Distinciones)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Distinciones
       * @param id Identifier for com.infotec.cvi.swb.Distinciones
       * @param model Model of the com.infotec.cvi.swb.Distinciones
       * @return A com.infotec.cvi.swb.Distinciones
       */
        public static com.infotec.cvi.swb.Distinciones createDistinciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Distinciones)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Distinciones
       * @param id Identifier for com.infotec.cvi.swb.Distinciones
       * @param model Model of the com.infotec.cvi.swb.Distinciones
       */
        public static void removeDistinciones(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Distinciones
       * @param id Identifier for com.infotec.cvi.swb.Distinciones
       * @param model Model of the com.infotec.cvi.swb.Distinciones
       * @return true if the com.infotec.cvi.swb.Distinciones exists, false otherwise
       */

        public static boolean hasDistinciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDistinciones(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Distinciones with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Distinciones
       * @return Iterator with all the com.infotec.cvi.swb.Distinciones
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Distinciones> listDistincionesByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distinciones> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Distinciones with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Distinciones
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Distinciones> listDistincionesByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distinciones> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Distinciones with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Distinciones
       * @return Iterator with all the com.infotec.cvi.swb.Distinciones
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Distinciones> listDistincionesByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distinciones> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Distinciones with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Distinciones
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Distinciones> listDistincionesByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distinciones> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DistincionesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Distinciones
   */
    public DistincionesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the FechaDistincion property
* @return java.util.Date with the FechaDistincion
*/
    public java.util.Date getFechaDistincion()
    {
        return getSemanticObject().getDateProperty(intranet_fechaDistincion);
    }

/**
* Sets the FechaDistincion property
* @param value long with the FechaDistincion
*/
    public void setFechaDistincion(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaDistincion, value);
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
* Gets the Otorgante property
* @return String with the Otorgante
*/
    public String getOtorgante()
    {
        return getSemanticObject().getProperty(intranet_otorgante);
    }

/**
* Sets the Otorgante property
* @param value long with the Otorgante
*/
    public void setOtorgante(String value)
    {
        getSemanticObject().setProperty(intranet_otorgante, value);
    }
}
