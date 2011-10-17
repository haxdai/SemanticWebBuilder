package com.infotec.eworkplace.swb.base;


public abstract class HabilidadBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty ewp_domain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#domain");
    public static final org.semanticwb.platform.SemanticProperty ewp_experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#experience");
    public static final org.semanticwb.platform.SemanticProperty ewp_tema=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#tema");
    public static final org.semanticwb.platform.SemanticClass ewp_Habilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Habilidad");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Habilidad");

    public static class ClassMgr
    {
       /**
       * Returns a list of Habilidad for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Habilidad> listHabilidads(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidad>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Habilidad for all models
       * @return Iterator of com.infotec.eworkplace.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Habilidad> listHabilidads()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidad>(it, true);
        }

        public static com.infotec.eworkplace.swb.Habilidad createHabilidad(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Habilidad.ClassMgr.createHabilidad(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       * @return A com.infotec.eworkplace.swb.Habilidad
       */
        public static com.infotec.eworkplace.swb.Habilidad getHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Habilidad)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       * @return A com.infotec.eworkplace.swb.Habilidad
       */
        public static com.infotec.eworkplace.swb.Habilidad createHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Habilidad)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       */
        public static void removeHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       * @return true if the com.infotec.eworkplace.swb.Habilidad exists, false otherwise
       */

        public static boolean hasHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHabilidad(id, model)!=null);
        }
    }

   /**
   * Constructs a HabilidadBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Habilidad
   */
    public HabilidadBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Domain property
* @return String with the Domain
*/
    public String getDomain()
    {
        return getSemanticObject().getProperty(ewp_domain);
    }

/**
* Sets the Domain property
* @param value long with the Domain
*/
    public void setDomain(String value)
    {
        getSemanticObject().setProperty(ewp_domain, value);
    }

/**
* Gets the Experience property
* @return String with the Experience
*/
    public String getExperience()
    {
        return getSemanticObject().getProperty(ewp_experience);
    }

/**
* Sets the Experience property
* @param value long with the Experience
*/
    public void setExperience(String value)
    {
        getSemanticObject().setProperty(ewp_experience, value);
    }

/**
* Gets the Tema property
* @return String with the Tema
*/
    public String getTema()
    {
        return getSemanticObject().getProperty(ewp_tema);
    }

/**
* Sets the Tema property
* @param value long with the Tema
*/
    public void setTema(String value)
    {
        getSemanticObject().setProperty(ewp_tema, value);
    }
}
