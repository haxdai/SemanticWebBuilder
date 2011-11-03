package com.infotec.eworkplace.swb.base;


public abstract class CandidatoBase extends org.semanticwb.model.UserTypeDef implements com.infotec.eworkplace.swb.CVable
{
    public static final org.semanticwb.platform.SemanticProperty ewp_fechaSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#fechaSolicitud");
    public static final org.semanticwb.platform.SemanticClass ewp_Candidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Candidato");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Candidato");

    public static class ClassMgr
    {
       /**
       * Returns a list of Candidato for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Candidato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Candidato> listCandidatos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Candidato>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Candidato for all models
       * @return Iterator of com.infotec.eworkplace.swb.Candidato
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Candidato> listCandidatos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Candidato>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Candidato
       * @param id Identifier for com.infotec.eworkplace.swb.Candidato
       * @param model Model of the com.infotec.eworkplace.swb.Candidato
       * @return A com.infotec.eworkplace.swb.Candidato
       */
        public static com.infotec.eworkplace.swb.Candidato getCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Candidato)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Candidato
       * @param id Identifier for com.infotec.eworkplace.swb.Candidato
       * @param model Model of the com.infotec.eworkplace.swb.Candidato
       * @return A com.infotec.eworkplace.swb.Candidato
       */
        public static com.infotec.eworkplace.swb.Candidato createCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Candidato)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Candidato
       * @param id Identifier for com.infotec.eworkplace.swb.Candidato
       * @param model Model of the com.infotec.eworkplace.swb.Candidato
       */
        public static void removeCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Candidato
       * @param id Identifier for com.infotec.eworkplace.swb.Candidato
       * @param model Model of the com.infotec.eworkplace.swb.Candidato
       * @return true if the com.infotec.eworkplace.swb.Candidato exists, false otherwise
       */

        public static boolean hasCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCandidato(id, model)!=null);
        }
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
* Gets the FechaSolicitud property
* @return java.util.Date with the FechaSolicitud
*/
    public java.util.Date getFechaSolicitud()
    {
        return getSemanticObject().getDateProperty(ewp_fechaSolicitud);
    }

/**
* Sets the FechaSolicitud property
* @param value long with the FechaSolicitud
*/
    public void setFechaSolicitud(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_fechaSolicitud, value);
    }
}
