package com.infotec.cvi.swb.base;


   /**
   * Elemento en el cual se almacena la certificación definida por el usuario 
   */
public abstract class CertificacionBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Elemento en el cual se almacena la certificación definida por el usuario
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Certificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Certificacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Certificacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Certificacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Certificacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Certificacion> listCertificacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Certificacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Certificacion for all models
       * @return Iterator of com.infotec.cvi.swb.Certificacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Certificacion> listCertificacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Certificacion>(it, true);
        }

        public static com.infotec.cvi.swb.Certificacion createCertificacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Certificacion.ClassMgr.createCertificacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Certificacion
       * @param id Identifier for com.infotec.cvi.swb.Certificacion
       * @param model Model of the com.infotec.cvi.swb.Certificacion
       * @return A com.infotec.cvi.swb.Certificacion
       */
        public static com.infotec.cvi.swb.Certificacion getCertificacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Certificacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Certificacion
       * @param id Identifier for com.infotec.cvi.swb.Certificacion
       * @param model Model of the com.infotec.cvi.swb.Certificacion
       * @return A com.infotec.cvi.swb.Certificacion
       */
        public static com.infotec.cvi.swb.Certificacion createCertificacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Certificacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Certificacion
       * @param id Identifier for com.infotec.cvi.swb.Certificacion
       * @param model Model of the com.infotec.cvi.swb.Certificacion
       */
        public static void removeCertificacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Certificacion
       * @param id Identifier for com.infotec.cvi.swb.Certificacion
       * @param model Model of the com.infotec.cvi.swb.Certificacion
       * @return true if the com.infotec.cvi.swb.Certificacion exists, false otherwise
       */

        public static boolean hasCertificacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCertificacion(id, model)!=null);
        }
    }

    public static CertificacionBase.ClassMgr getCertificacionClassMgr()
    {
        return new CertificacionBase.ClassMgr();
    }

   /**
   * Constructs a CertificacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Certificacion
   */
    public CertificacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
