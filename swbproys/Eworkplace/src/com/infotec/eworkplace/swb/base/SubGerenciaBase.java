package com.infotec.eworkplace.swb.base;


public abstract class SubGerenciaBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Titular,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass ewp_SubGerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#SubGerencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#SubGerencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of SubGerencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SubGerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SubGerencia> listSubGerencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SubGerencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SubGerencia for all models
       * @return Iterator of com.infotec.eworkplace.swb.SubGerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SubGerencia> listSubGerencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SubGerencia>(it, true);
        }

        public static com.infotec.eworkplace.swb.SubGerencia createSubGerencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.SubGerencia.ClassMgr.createSubGerencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       * @return A com.infotec.eworkplace.swb.SubGerencia
       */
        public static com.infotec.eworkplace.swb.SubGerencia getSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SubGerencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       * @return A com.infotec.eworkplace.swb.SubGerencia
       */
        public static com.infotec.eworkplace.swb.SubGerencia createSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SubGerencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       */
        public static void removeSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       * @return true if the com.infotec.eworkplace.swb.SubGerencia exists, false otherwise
       */

        public static boolean hasSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubGerencia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SubGerencia with a determined Incharge
       * @param value Incharge of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       * @return Iterator with all the com.infotec.eworkplace.swb.SubGerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SubGerencia> listSubGerenciaByIncharge(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SubGerencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_incharge, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SubGerencia with a determined Incharge
       * @param value Incharge of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SubGerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SubGerencia> listSubGerenciaByIncharge(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SubGerencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_incharge,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SubGerenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SubGerencia
   */
    public SubGerenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Incharge
   * @param value Incharge to set
   */

    public void setIncharge(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_incharge, value.getSemanticObject());
        }else
        {
            removeIncharge();
        }
    }
   /**
   * Remove the value for Incharge property
   */

    public void removeIncharge()
    {
        getSemanticObject().removeProperty(ewp_incharge);
    }

   /**
   * Gets the Incharge
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getIncharge()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_incharge);
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
}
