package mx.gob.inmujeres.swb.base;


public abstract class GlosarioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty inm_contenido=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#contenido");
    public static final org.semanticwb.platform.SemanticClass inm_Glosario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Glosario");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Glosario");

    public static class ClassMgr
    {
       /**
       * Returns a list of Glosario for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Glosario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Glosario> listGlosarios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Glosario>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Glosario for all models
       * @return Iterator of mx.gob.inmujeres.swb.Glosario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Glosario> listGlosarios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Glosario>(it, true);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Glosario
       * @param id Identifier for mx.gob.inmujeres.swb.Glosario
       * @param model Model of the mx.gob.inmujeres.swb.Glosario
       * @return A mx.gob.inmujeres.swb.Glosario
       */
        public static mx.gob.inmujeres.swb.Glosario getGlosario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Glosario)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Glosario
       * @param id Identifier for mx.gob.inmujeres.swb.Glosario
       * @param model Model of the mx.gob.inmujeres.swb.Glosario
       * @return A mx.gob.inmujeres.swb.Glosario
       */
        public static mx.gob.inmujeres.swb.Glosario createGlosario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Glosario)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Glosario
       * @param id Identifier for mx.gob.inmujeres.swb.Glosario
       * @param model Model of the mx.gob.inmujeres.swb.Glosario
       */
        public static void removeGlosario(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Glosario
       * @param id Identifier for mx.gob.inmujeres.swb.Glosario
       * @param model Model of the mx.gob.inmujeres.swb.Glosario
       * @return true if the mx.gob.inmujeres.swb.Glosario exists, false otherwise
       */

        public static boolean hasGlosario(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGlosario(id, model)!=null);
        }
    }

    public static GlosarioBase.ClassMgr getGlosarioClassMgr()
    {
        return new GlosarioBase.ClassMgr();
    }

   /**
   * Constructs a GlosarioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Glosario
   */
    public GlosarioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Contenido property
* @return String with the Contenido
*/
    public String getContenido()
    {
        return getSemanticObject().getProperty(inm_contenido);
    }

/**
* Sets the Contenido property
* @param value long with the Contenido
*/
    public void setContenido(String value)
    {
        getSemanticObject().setProperty(inm_contenido, value);
    }
}
