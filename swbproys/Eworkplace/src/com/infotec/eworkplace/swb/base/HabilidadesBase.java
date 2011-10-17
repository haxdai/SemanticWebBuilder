package com.infotec.eworkplace.swb.base;


public abstract class HabilidadesBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty ewp_domain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#domain");
    public static final org.semanticwb.platform.SemanticProperty ewp_experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#experience");
    public static final org.semanticwb.platform.SemanticProperty ewp_skill=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#skill");
    public static final org.semanticwb.platform.SemanticClass ewp_Habilidades=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Habilidades");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Habilidades");

    public static class ClassMgr
    {
       /**
       * Returns a list of Habilidades for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Habilidades
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Habilidades> listHabilidadeses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidades>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Habilidades for all models
       * @return Iterator of com.infotec.eworkplace.swb.Habilidades
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Habilidades> listHabilidadeses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidades>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Habilidades
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidades
       * @param model Model of the com.infotec.eworkplace.swb.Habilidades
       * @return A com.infotec.eworkplace.swb.Habilidades
       */
        public static com.infotec.eworkplace.swb.Habilidades getHabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Habilidades)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Habilidades
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidades
       * @param model Model of the com.infotec.eworkplace.swb.Habilidades
       * @return A com.infotec.eworkplace.swb.Habilidades
       */
        public static com.infotec.eworkplace.swb.Habilidades createHabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Habilidades)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Habilidades
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidades
       * @param model Model of the com.infotec.eworkplace.swb.Habilidades
       */
        public static void removeHabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Habilidades
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidades
       * @param model Model of the com.infotec.eworkplace.swb.Habilidades
       * @return true if the com.infotec.eworkplace.swb.Habilidades exists, false otherwise
       */

        public static boolean hasHabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHabilidades(id, model)!=null);
        }
    }

   /**
   * Constructs a HabilidadesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Habilidades
   */
    public HabilidadesBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the Skill property
* @return String with the Skill
*/
    public String getSkill()
    {
        return getSemanticObject().getProperty(ewp_skill);
    }

/**
* Sets the Skill property
* @param value long with the Skill
*/
    public void setSkill(String value)
    {
        getSemanticObject().setProperty(ewp_skill, value);
    }

   /**
   * Gets the InfotecIntranet
   * @return a instance of com.infotec.eworkplace.swb.InfotecIntranet
   */
    public com.infotec.eworkplace.swb.InfotecIntranet getInfotecIntranet()
    {
        return (com.infotec.eworkplace.swb.InfotecIntranet)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
