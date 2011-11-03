package com.infotec.eworkplace.swb.base;


public abstract class ConocimientoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Capacidad
{
    public static final org.semanticwb.platform.SemanticProperty ewp_materia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#materia");
    public static final org.semanticwb.platform.SemanticClass ewp_Conocimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Conocimiento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Conocimiento");

    public static class ClassMgr
    {
       /**
       * Returns a list of Conocimiento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Conocimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conocimiento> listConocimientos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conocimiento>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Conocimiento for all models
       * @return Iterator of com.infotec.eworkplace.swb.Conocimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conocimiento> listConocimientos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conocimiento>(it, true);
        }

        public static com.infotec.eworkplace.swb.Conocimiento createConocimiento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Conocimiento.ClassMgr.createConocimiento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Conocimiento
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimiento
       * @param model Model of the com.infotec.eworkplace.swb.Conocimiento
       * @return A com.infotec.eworkplace.swb.Conocimiento
       */
        public static com.infotec.eworkplace.swb.Conocimiento getConocimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Conocimiento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Conocimiento
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimiento
       * @param model Model of the com.infotec.eworkplace.swb.Conocimiento
       * @return A com.infotec.eworkplace.swb.Conocimiento
       */
        public static com.infotec.eworkplace.swb.Conocimiento createConocimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Conocimiento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Conocimiento
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimiento
       * @param model Model of the com.infotec.eworkplace.swb.Conocimiento
       */
        public static void removeConocimiento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Conocimiento
       * @param id Identifier for com.infotec.eworkplace.swb.Conocimiento
       * @param model Model of the com.infotec.eworkplace.swb.Conocimiento
       * @return true if the com.infotec.eworkplace.swb.Conocimiento exists, false otherwise
       */

        public static boolean hasConocimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getConocimiento(id, model)!=null);
        }
    }

   /**
   * Constructs a ConocimientoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Conocimiento
   */
    public ConocimientoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Materia property
* @return String with the Materia
*/
    public String getMateria()
    {
        return getSemanticObject().getProperty(ewp_materia);
    }

/**
* Sets the Materia property
* @param value long with the Materia
*/
    public void setMateria(String value)
    {
        getSemanticObject().setProperty(ewp_materia, value);
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
}
