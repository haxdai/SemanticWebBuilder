package org.semanticwb.model.survey.base;


public abstract class AplicacionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_nombreAplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#nombreAplicacion");
    public static final org.semanticwb.platform.SemanticProperty cts_claveAplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#claveAplicacion");
    public static final org.semanticwb.platform.SemanticClass cts_Aplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#Aplicacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#Aplicacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Aplicacion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.Aplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.Aplicacion> listAplicacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.Aplicacion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.Aplicacion for all models
       * @return Iterator of org.semanticwb.model.survey.Aplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.Aplicacion> listAplicacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.Aplicacion>(it, true);
        }
       /**
       * Gets a org.semanticwb.model.survey.Aplicacion
       * @param id Identifier for org.semanticwb.model.survey.Aplicacion
       * @param model Model of the org.semanticwb.model.survey.Aplicacion
       * @return A org.semanticwb.model.survey.Aplicacion
       */
        public static org.semanticwb.model.survey.Aplicacion getAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.Aplicacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.Aplicacion
       * @param id Identifier for org.semanticwb.model.survey.Aplicacion
       * @param model Model of the org.semanticwb.model.survey.Aplicacion
       * @return A org.semanticwb.model.survey.Aplicacion
       */
        public static org.semanticwb.model.survey.Aplicacion createAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.Aplicacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.Aplicacion
       * @param id Identifier for org.semanticwb.model.survey.Aplicacion
       * @param model Model of the org.semanticwb.model.survey.Aplicacion
       */
        public static void removeAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.Aplicacion
       * @param id Identifier for org.semanticwb.model.survey.Aplicacion
       * @param model Model of the org.semanticwb.model.survey.Aplicacion
       * @return true if the org.semanticwb.model.survey.Aplicacion exists, false otherwise
       */

        public static boolean hasAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAplicacion(id, model)!=null);
        }
    }

    public static AplicacionBase.ClassMgr getAplicacionClassMgr()
    {
        return new AplicacionBase.ClassMgr();
    }

   /**
   * Constructs a AplicacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Aplicacion
   */
    public AplicacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NombreAplicacion property
* @return String with the NombreAplicacion
*/
    public String getNombreAplicacion()
    {
        return getSemanticObject().getProperty(cts_nombreAplicacion);
    }

/**
* Sets the NombreAplicacion property
* @param value long with the NombreAplicacion
*/
    public void setNombreAplicacion(String value)
    {
        getSemanticObject().setProperty(cts_nombreAplicacion, value);
    }

/**
* Gets the ClaveAplicacion property
* @return String with the ClaveAplicacion
*/
    public String getClaveAplicacion()
    {
        return getSemanticObject().getProperty(cts_claveAplicacion);
    }

/**
* Sets the ClaveAplicacion property
* @param value long with the ClaveAplicacion
*/
    public void setClaveAplicacion(String value)
    {
        getSemanticObject().setProperty(cts_claveAplicacion, value);
    }
}
