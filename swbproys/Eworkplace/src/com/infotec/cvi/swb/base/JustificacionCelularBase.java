package com.infotec.cvi.swb.base;


   /**
   * Elemento utilizado para la Justificación del Celular para la persona 
   */
public abstract class JustificacionCelularBase extends org.semanticwb.model.SWBClass implements com.infotec.cvi.swb.EquipoJustificacion
{
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereCelular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereCelular");
   /**
   * Elemento utilizado para la Justificación del Celular para la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_JustificacionCelular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#JustificacionCelular");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#JustificacionCelular");

    public static class ClassMgr
    {
       /**
       * Returns a list of JustificacionCelular for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.JustificacionCelular
       */

        public static java.util.Iterator<com.infotec.cvi.swb.JustificacionCelular> listJustificacionCelulars(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.JustificacionCelular>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.JustificacionCelular for all models
       * @return Iterator of com.infotec.cvi.swb.JustificacionCelular
       */

        public static java.util.Iterator<com.infotec.cvi.swb.JustificacionCelular> listJustificacionCelulars()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.JustificacionCelular>(it, true);
        }
       /**
       * Gets a com.infotec.cvi.swb.JustificacionCelular
       * @param id Identifier for com.infotec.cvi.swb.JustificacionCelular
       * @param model Model of the com.infotec.cvi.swb.JustificacionCelular
       * @return A com.infotec.cvi.swb.JustificacionCelular
       */
        public static com.infotec.cvi.swb.JustificacionCelular getJustificacionCelular(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.JustificacionCelular)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.JustificacionCelular
       * @param id Identifier for com.infotec.cvi.swb.JustificacionCelular
       * @param model Model of the com.infotec.cvi.swb.JustificacionCelular
       * @return A com.infotec.cvi.swb.JustificacionCelular
       */
        public static com.infotec.cvi.swb.JustificacionCelular createJustificacionCelular(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.JustificacionCelular)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.JustificacionCelular
       * @param id Identifier for com.infotec.cvi.swb.JustificacionCelular
       * @param model Model of the com.infotec.cvi.swb.JustificacionCelular
       */
        public static void removeJustificacionCelular(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.JustificacionCelular
       * @param id Identifier for com.infotec.cvi.swb.JustificacionCelular
       * @param model Model of the com.infotec.cvi.swb.JustificacionCelular
       * @return true if the com.infotec.cvi.swb.JustificacionCelular exists, false otherwise
       */

        public static boolean hasJustificacionCelular(String id, org.semanticwb.model.SWBModel model)
        {
            return (getJustificacionCelular(id, model)!=null);
        }
    }

    public static JustificacionCelularBase.ClassMgr getJustificacionCelularClassMgr()
    {
        return new JustificacionCelularBase.ClassMgr();
    }

   /**
   * Constructs a JustificacionCelularBase with a SemanticObject
   * @param base The SemanticObject with the properties for the JustificacionCelular
   */
    public JustificacionCelularBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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

/**
* Gets the RequiereCelular property
* @return boolean with the RequiereCelular
*/
    public boolean isRequiereCelular()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereCelular);
    }

/**
* Sets the RequiereCelular property
* @param value long with the RequiereCelular
*/
    public void setRequiereCelular(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereCelular, value);
    }
}
