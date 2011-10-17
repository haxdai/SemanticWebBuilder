package com.infotec.eworkplace.swb.base;


public abstract class ConocimientosBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty ewp_knowledge=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#knowledge");
    public static final org.semanticwb.platform.SemanticProperty ewp_domain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#domain");
    public static final org.semanticwb.platform.SemanticProperty ewp_experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#experience");
    public static final org.semanticwb.platform.SemanticClass ewp_Conocimientos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Conocimientos");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Conocimientos");

    public static class ClassMgr
    {
       /**
       * Returns a list of Conocimientos for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Conocimientos
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conocimientos> listConocimientoses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conocimientos>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Conocimientos for all models
       * @return Iterator of com.infotec.eworkplace.swb.Conocimientos
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conocimientos> listConocimientoses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conocimientos>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Conocimientos
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimientos
       * @param model Model of the com.infotec.eworkplace.swb.Conocimientos
       * @return A com.infotec.eworkplace.swb.Conocimientos
       */
        public static com.infotec.eworkplace.swb.Conocimientos getConocimientos(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Conocimientos)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Conocimientos
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimientos
       * @param model Model of the com.infotec.eworkplace.swb.Conocimientos
       * @return A com.infotec.eworkplace.swb.Conocimientos
       */
        public static com.infotec.eworkplace.swb.Conocimientos createConocimientos(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Conocimientos)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Conocimientos
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimientos
       * @param model Model of the com.infotec.eworkplace.swb.Conocimientos
       */
        public static void removeConocimientos(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Conocimientos
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimientos
       * @param model Model of the com.infotec.eworkplace.swb.Conocimientos
       * @return true if the com.infotec.eworkplace.swb.Conocimientos exists, false otherwise
       */

        public static boolean hasConocimientos(String id, org.semanticwb.model.SWBModel model)
        {
            return (getConocimientos(id, model)!=null);
        }
    }

   /**
   * Constructs a ConocimientosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Conocimientos
   */
    public ConocimientosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Knowledge property
* @return String with the Knowledge
*/
    public String getKnowledge()
    {
        return getSemanticObject().getProperty(ewp_knowledge);
    }

/**
* Sets the Knowledge property
* @param value long with the Knowledge
*/
    public void setKnowledge(String value)
    {
        getSemanticObject().setProperty(ewp_knowledge, value);
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
   * Gets the InfotecIntranet
   * @return a instance of com.infotec.eworkplace.swb.InfotecIntranet
   */
    public com.infotec.eworkplace.swb.InfotecIntranet getInfotecIntranet()
    {
        return (com.infotec.eworkplace.swb.InfotecIntranet)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
