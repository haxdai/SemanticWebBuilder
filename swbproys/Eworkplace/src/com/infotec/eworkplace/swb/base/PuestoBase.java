package com.infotec.eworkplace.swb.base;


public abstract class PuestoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass ewp_Puesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Puesto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Puesto");

    public static class ClassMgr
    {
       /**
       * Returns a list of Puesto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Puesto> listPuestos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Puesto>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Puesto for all models
       * @return Iterator of com.infotec.eworkplace.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Puesto> listPuestos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Puesto>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Puesto
       * @param id Identifier for com.infotec.eworkplace.swb.Puesto
       * @param model Model of the com.infotec.eworkplace.swb.Puesto
       * @return A com.infotec.eworkplace.swb.Puesto
       */
        public static com.infotec.eworkplace.swb.Puesto getPuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Puesto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Puesto
       * @param id Identifier for com.infotec.eworkplace.swb.Puesto
       * @param model Model of the com.infotec.eworkplace.swb.Puesto
       * @return A com.infotec.eworkplace.swb.Puesto
       */
        public static com.infotec.eworkplace.swb.Puesto createPuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Puesto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Puesto
       * @param id Identifier for com.infotec.eworkplace.swb.Puesto
       * @param model Model of the com.infotec.eworkplace.swb.Puesto
       */
        public static void removePuesto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Puesto
       * @param id Identifier for com.infotec.eworkplace.swb.Puesto
       * @param model Model of the com.infotec.eworkplace.swb.Puesto
       * @return true if the com.infotec.eworkplace.swb.Puesto exists, false otherwise
       */

        public static boolean hasPuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPuesto(id, model)!=null);
        }
    }

   /**
   * Constructs a PuestoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Puesto
   */
    public PuestoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
