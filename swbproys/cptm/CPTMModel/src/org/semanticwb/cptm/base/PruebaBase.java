package org.semanticwb.cptm.base;


public abstract class PruebaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cptm_hasfiles=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasfiles");
    public static final org.semanticwb.platform.SemanticClass cptm_Prueba=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Prueba");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Prueba");

    public static class ClassMgr
    {
       /**
       * Returns a list of Prueba for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Prueba
       */

        public static java.util.Iterator<org.semanticwb.cptm.Prueba> listPruebas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Prueba>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Prueba for all models
       * @return Iterator of org.semanticwb.cptm.Prueba
       */

        public static java.util.Iterator<org.semanticwb.cptm.Prueba> listPruebas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Prueba>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Prueba
       * @param id Identifier for org.semanticwb.cptm.Prueba
       * @param model Model of the org.semanticwb.cptm.Prueba
       * @return A org.semanticwb.cptm.Prueba
       */
        public static org.semanticwb.cptm.Prueba getPrueba(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Prueba)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Prueba
       * @param id Identifier for org.semanticwb.cptm.Prueba
       * @param model Model of the org.semanticwb.cptm.Prueba
       * @return A org.semanticwb.cptm.Prueba
       */
        public static org.semanticwb.cptm.Prueba createPrueba(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Prueba)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Prueba
       * @param id Identifier for org.semanticwb.cptm.Prueba
       * @param model Model of the org.semanticwb.cptm.Prueba
       */
        public static void removePrueba(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Prueba
       * @param id Identifier for org.semanticwb.cptm.Prueba
       * @param model Model of the org.semanticwb.cptm.Prueba
       * @return true if the org.semanticwb.cptm.Prueba exists, false otherwise
       */

        public static boolean hasPrueba(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPrueba(id, model)!=null);
        }
    }

   /**
   * Constructs a PruebaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Prueba
   */
    public PruebaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Iterator<String> listfileses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(cptm_hasfiles);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addfiles(String value)
    {
        getSemanticObject().addLiteralProperty(cptm_hasfiles, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllfiles()
    {
        getSemanticObject().removeProperty(cptm_hasfiles);
    }

    public void removefiles(String value)
    {
        getSemanticObject().removeLiteralProperty(cptm_hasfiles,new org.semanticwb.platform.SemanticLiteral(value));
    }
}
