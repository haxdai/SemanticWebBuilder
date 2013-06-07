package org.semanticwb.model.survey.base;


public abstract class TramiteBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.survey.Unidad
{
    public static final org.semanticwb.platform.SemanticClass cts_Tramite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#Tramite");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#Tramite");

    public static class ClassMgr
    {
       /**
       * Returns a list of Tramite for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.Tramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.Tramite> listTramites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.Tramite>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.Tramite for all models
       * @return Iterator of org.semanticwb.model.survey.Tramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.Tramite> listTramites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.Tramite>(it, true);
        }
       /**
       * Gets a org.semanticwb.model.survey.Tramite
       * @param id Identifier for org.semanticwb.model.survey.Tramite
       * @param model Model of the org.semanticwb.model.survey.Tramite
       * @return A org.semanticwb.model.survey.Tramite
       */
        public static org.semanticwb.model.survey.Tramite getTramite(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.Tramite)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.Tramite
       * @param id Identifier for org.semanticwb.model.survey.Tramite
       * @param model Model of the org.semanticwb.model.survey.Tramite
       * @return A org.semanticwb.model.survey.Tramite
       */
        public static org.semanticwb.model.survey.Tramite createTramite(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.Tramite)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.Tramite
       * @param id Identifier for org.semanticwb.model.survey.Tramite
       * @param model Model of the org.semanticwb.model.survey.Tramite
       */
        public static void removeTramite(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.Tramite
       * @param id Identifier for org.semanticwb.model.survey.Tramite
       * @param model Model of the org.semanticwb.model.survey.Tramite
       * @return true if the org.semanticwb.model.survey.Tramite exists, false otherwise
       */

        public static boolean hasTramite(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTramite(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.Tramite with a determined UnidadSustantiva
       * @param value UnidadSustantiva of the type org.semanticwb.model.survey.UnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.Tramite
       * @return Iterator with all the org.semanticwb.model.survey.Tramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.Tramite> listTramiteByUnidadSustantiva(org.semanticwb.model.survey.UnidadSustantiva value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.Tramite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_unidadSustantiva, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.Tramite with a determined UnidadSustantiva
       * @param value UnidadSustantiva of the type org.semanticwb.model.survey.UnidadSustantiva
       * @return Iterator with all the org.semanticwb.model.survey.Tramite
       */

        public static java.util.Iterator<org.semanticwb.model.survey.Tramite> listTramiteByUnidadSustantiva(org.semanticwb.model.survey.UnidadSustantiva value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.Tramite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_unidadSustantiva,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static TramiteBase.ClassMgr getTramiteClassMgr()
    {
        return new TramiteBase.ClassMgr();
    }

   /**
   * Constructs a TramiteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Tramite
   */
    public TramiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property UnidadSustantiva
   * @param value UnidadSustantiva to set
   */

    public void setUnidadSustantiva(org.semanticwb.model.survey.UnidadSustantiva value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cts_unidadSustantiva, value.getSemanticObject());
        }else
        {
            removeUnidadSustantiva();
        }
    }
   /**
   * Remove the value for UnidadSustantiva property
   */

    public void removeUnidadSustantiva()
    {
        getSemanticObject().removeProperty(cts_unidadSustantiva);
    }

   /**
   * Gets the UnidadSustantiva
   * @return a org.semanticwb.model.survey.UnidadSustantiva
   */
    public org.semanticwb.model.survey.UnidadSustantiva getUnidadSustantiva()
    {
         org.semanticwb.model.survey.UnidadSustantiva ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_unidadSustantiva);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.UnidadSustantiva)obj.createGenericInstance();
         }
         return ret;
    }
}
