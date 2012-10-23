package com.infotec.cvi.swb.base;


   /**
   * Elemento para guardar información del candidato, como son lo días hábiles para estar disponible para el trabajo, su situación laboral actual y su disponibilidad 
   */
public abstract class CandidatoBase extends org.semanticwb.model.SWBClass implements com.infotec.cvi.swb.CVable
{
   /**
   * Días hábiles para estar disponible
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_diasHabilesDisponibles=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#diasHabilesDisponibles");
   /**
   * Situación laboral actual del candidato
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_situacionLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#situacionLaboral");
   /**
   * Disponibilidad del candidato
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_disponibilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#disponibilidad");
   /**
   * Elemento para guardar información del candidato, como son lo días hábiles para estar disponible para el trabajo, su situación laboral actual y su disponibilidad
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Candidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Candidato");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Candidato");

    public static class ClassMgr
    {
       /**
       * Returns a list of Candidato for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Candidato
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Candidato> listCandidatos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Candidato>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Candidato for all models
       * @return Iterator of com.infotec.cvi.swb.Candidato
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Candidato> listCandidatos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Candidato>(it, true);
        }

        public static com.infotec.cvi.swb.Candidato createCandidato(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Candidato.ClassMgr.createCandidato(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Candidato
       * @param id Identifier for com.infotec.cvi.swb.Candidato
       * @param model Model of the com.infotec.cvi.swb.Candidato
       * @return A com.infotec.cvi.swb.Candidato
       */
        public static com.infotec.cvi.swb.Candidato getCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Candidato)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Candidato
       * @param id Identifier for com.infotec.cvi.swb.Candidato
       * @param model Model of the com.infotec.cvi.swb.Candidato
       * @return A com.infotec.cvi.swb.Candidato
       */
        public static com.infotec.cvi.swb.Candidato createCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Candidato)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Candidato
       * @param id Identifier for com.infotec.cvi.swb.Candidato
       * @param model Model of the com.infotec.cvi.swb.Candidato
       */
        public static void removeCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Candidato
       * @param id Identifier for com.infotec.cvi.swb.Candidato
       * @param model Model of the com.infotec.cvi.swb.Candidato
       * @return true if the com.infotec.cvi.swb.Candidato exists, false otherwise
       */

        public static boolean hasCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCandidato(id, model)!=null);
        }
    }

    public static CandidatoBase.ClassMgr getCandidatoClassMgr()
    {
        return new CandidatoBase.ClassMgr();
    }

   /**
   * Constructs a CandidatoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Candidato
   */
    public CandidatoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the DiasHabilesDisponibles property
* @return String with the DiasHabilesDisponibles
*/
    public String getDiasHabilesDisponibles()
    {
        return getSemanticObject().getProperty(intranet_diasHabilesDisponibles);
    }

/**
* Sets the DiasHabilesDisponibles property
* @param value long with the DiasHabilesDisponibles
*/
    public void setDiasHabilesDisponibles(String value)
    {
        getSemanticObject().setProperty(intranet_diasHabilesDisponibles, value);
    }

/**
* Gets the SituacionLaboral property
* @return int with the SituacionLaboral
*/
    public int getSituacionLaboral()
    {
        return getSemanticObject().getIntProperty(intranet_situacionLaboral);
    }

/**
* Sets the SituacionLaboral property
* @param value long with the SituacionLaboral
*/
    public void setSituacionLaboral(int value)
    {
        getSemanticObject().setIntProperty(intranet_situacionLaboral, value);
    }

/**
* Gets the Disponibilidad property
* @return int with the Disponibilidad
*/
    public int getDisponibilidad()
    {
        return getSemanticObject().getIntProperty(intranet_disponibilidad);
    }

/**
* Sets the Disponibilidad property
* @param value long with the Disponibilidad
*/
    public void setDisponibilidad(int value)
    {
        getSemanticObject().setIntProperty(intranet_disponibilidad, value);
    }
}
