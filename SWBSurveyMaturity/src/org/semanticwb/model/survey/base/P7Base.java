package org.semanticwb.model.survey.base;


public abstract class P7Base extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass cts_CostoTramite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoTramite");
    public static final org.semanticwb.platform.SemanticProperty cts_hasCostosTramites=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#hasCostosTramites");
    public static final org.semanticwb.platform.SemanticClass cts_P7=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P7");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#P7");

    public static class ClassMgr
    {
       /**
       * Returns a list of P7 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.P7
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P7> listP7s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P7>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.P7 for all models
       * @return Iterator of org.semanticwb.model.survey.P7
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P7> listP7s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P7>(it, true);
        }

        public static org.semanticwb.model.survey.P7 createP7(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.P7.ClassMgr.createP7(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.P7
       * @param id Identifier for org.semanticwb.model.survey.P7
       * @param model Model of the org.semanticwb.model.survey.P7
       * @return A org.semanticwb.model.survey.P7
       */
        public static org.semanticwb.model.survey.P7 getP7(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P7)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.P7
       * @param id Identifier for org.semanticwb.model.survey.P7
       * @param model Model of the org.semanticwb.model.survey.P7
       * @return A org.semanticwb.model.survey.P7
       */
        public static org.semanticwb.model.survey.P7 createP7(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.P7)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.P7
       * @param id Identifier for org.semanticwb.model.survey.P7
       * @param model Model of the org.semanticwb.model.survey.P7
       */
        public static void removeP7(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.P7
       * @param id Identifier for org.semanticwb.model.survey.P7
       * @param model Model of the org.semanticwb.model.survey.P7
       * @return true if the org.semanticwb.model.survey.P7 exists, false otherwise
       */

        public static boolean hasP7(String id, org.semanticwb.model.SWBModel model)
        {
            return (getP7(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.P7 with a determined CostosTramites
       * @param value CostosTramites of the type org.semanticwb.model.survey.CostoTramite
       * @param model Model of the org.semanticwb.model.survey.P7
       * @return Iterator with all the org.semanticwb.model.survey.P7
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P7> listP7ByCostosTramites(org.semanticwb.model.survey.CostoTramite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P7> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostosTramites, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.P7 with a determined CostosTramites
       * @param value CostosTramites of the type org.semanticwb.model.survey.CostoTramite
       * @return Iterator with all the org.semanticwb.model.survey.P7
       */

        public static java.util.Iterator<org.semanticwb.model.survey.P7> listP7ByCostosTramites(org.semanticwb.model.survey.CostoTramite value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.P7> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostosTramites,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static P7Base.ClassMgr getP7ClassMgr()
    {
        return new P7Base.ClassMgr();
    }

   /**
   * Constructs a P7Base with a SemanticObject
   * @param base The SemanticObject with the properties for the P7
   */
    public P7Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.model.survey.CostoTramite
   * @return A GenericIterator with all the org.semanticwb.model.survey.CostoTramite
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoTramite> listCostosTramiteses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoTramite>(getSemanticObject().listObjectProperties(cts_hasCostosTramites));
    }

   /**
   * Gets true if has a CostosTramites
   * @param value org.semanticwb.model.survey.CostoTramite to verify
   * @return true if the org.semanticwb.model.survey.CostoTramite exists, false otherwise
   */
    public boolean hasCostosTramites(org.semanticwb.model.survey.CostoTramite value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cts_hasCostosTramites,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CostosTramites
   * @param value org.semanticwb.model.survey.CostoTramite to add
   */

    public void addCostosTramites(org.semanticwb.model.survey.CostoTramite value)
    {
        getSemanticObject().addObjectProperty(cts_hasCostosTramites, value.getSemanticObject());
    }
   /**
   * Removes all the CostosTramites
   */

    public void removeAllCostosTramites()
    {
        getSemanticObject().removeProperty(cts_hasCostosTramites);
    }
   /**
   * Removes a CostosTramites
   * @param value org.semanticwb.model.survey.CostoTramite to remove
   */

    public void removeCostosTramites(org.semanticwb.model.survey.CostoTramite value)
    {
        getSemanticObject().removeObjectProperty(cts_hasCostosTramites,value.getSemanticObject());
    }

   /**
   * Gets the CostosTramites
   * @return a org.semanticwb.model.survey.CostoTramite
   */
    public org.semanticwb.model.survey.CostoTramite getCostosTramites()
    {
         org.semanticwb.model.survey.CostoTramite ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_hasCostosTramites);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.CostoTramite)obj.createGenericInstance();
         }
         return ret;
    }
}
