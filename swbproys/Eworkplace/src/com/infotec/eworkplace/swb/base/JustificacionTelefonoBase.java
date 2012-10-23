package com.infotec.eworkplace.swb.base;


   /**
   * Elemento utilizado para la Justificación de un Teléfono para la persona 
   */
public abstract class JustificacionTelefonoBase extends org.semanticwb.model.SWBClass implements com.infotec.cvi.swb.EquipoJustificacion
{
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereTelefono");
   /**
   * Elemento utilizado para la Justificación de un Teléfono para la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_JustificacionTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#JustificacionTelefono");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#JustificacionTelefono");

    public static class ClassMgr
    {
       /**
       * Returns a list of JustificacionTelefono for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.JustificacionTelefono
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.JustificacionTelefono> listJustificacionTelefonos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.JustificacionTelefono>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.JustificacionTelefono for all models
       * @return Iterator of com.infotec.eworkplace.swb.JustificacionTelefono
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.JustificacionTelefono> listJustificacionTelefonos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.JustificacionTelefono>(it, true);
        }

        public static com.infotec.eworkplace.swb.JustificacionTelefono createJustificacionTelefono(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.JustificacionTelefono.ClassMgr.createJustificacionTelefono(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.JustificacionTelefono
       * @param id Identifier for com.infotec.eworkplace.swb.JustificacionTelefono
       * @param model Model of the com.infotec.eworkplace.swb.JustificacionTelefono
       * @return A com.infotec.eworkplace.swb.JustificacionTelefono
       */
        public static com.infotec.eworkplace.swb.JustificacionTelefono getJustificacionTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.JustificacionTelefono)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.JustificacionTelefono
       * @param id Identifier for com.infotec.eworkplace.swb.JustificacionTelefono
       * @param model Model of the com.infotec.eworkplace.swb.JustificacionTelefono
       * @return A com.infotec.eworkplace.swb.JustificacionTelefono
       */
        public static com.infotec.eworkplace.swb.JustificacionTelefono createJustificacionTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.JustificacionTelefono)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.JustificacionTelefono
       * @param id Identifier for com.infotec.eworkplace.swb.JustificacionTelefono
       * @param model Model of the com.infotec.eworkplace.swb.JustificacionTelefono
       */
        public static void removeJustificacionTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.JustificacionTelefono
       * @param id Identifier for com.infotec.eworkplace.swb.JustificacionTelefono
       * @param model Model of the com.infotec.eworkplace.swb.JustificacionTelefono
       * @return true if the com.infotec.eworkplace.swb.JustificacionTelefono exists, false otherwise
       */

        public static boolean hasJustificacionTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            return (getJustificacionTelefono(id, model)!=null);
        }
    }

    public static JustificacionTelefonoBase.ClassMgr getJustificacionTelefonoClassMgr()
    {
        return new JustificacionTelefonoBase.ClassMgr();
    }

   /**
   * Constructs a JustificacionTelefonoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the JustificacionTelefono
   */
    public JustificacionTelefonoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the RequiereTelefono property
* @return boolean with the RequiereTelefono
*/
    public boolean isRequiereTelefono()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereTelefono);
    }

/**
* Sets the RequiereTelefono property
* @param value long with the RequiereTelefono
*/
    public void setRequiereTelefono(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereTelefono, value);
    }

/**
* Gets the Justificacion property
* @return String with the Justificacion
*/
    public String getJustificacion()
    {
        return getSemanticObject().getProperty(intranet_justificacion);
    }

/**
* Sets the Justificacion property
* @param value long with the Justificacion
*/
    public void setJustificacion(String value)
    {
        getSemanticObject().setProperty(intranet_justificacion, value);
    }
}
