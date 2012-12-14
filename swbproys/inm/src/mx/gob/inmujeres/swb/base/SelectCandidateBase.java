package mx.gob.inmujeres.swb.base;


   /**
   * Seleciona un candidato a evaluar 
   */
public abstract class SelectCandidateBase extends org.semanticwb.model.SelectOne 
{
   /**
   * Seleciona un candidato a evaluar
   */
    public static final org.semanticwb.platform.SemanticClass inm_SelectCandidate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SelectCandidate");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SelectCandidate");

    public static class ClassMgr
    {
       /**
       * Returns a list of SelectCandidate for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.SelectCandidate
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SelectCandidate> listSelectCandidates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SelectCandidate>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.SelectCandidate for all models
       * @return Iterator of mx.gob.inmujeres.swb.SelectCandidate
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SelectCandidate> listSelectCandidates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SelectCandidate>(it, true);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.SelectCandidate
       * @param id Identifier for mx.gob.inmujeres.swb.SelectCandidate
       * @param model Model of the mx.gob.inmujeres.swb.SelectCandidate
       * @return A mx.gob.inmujeres.swb.SelectCandidate
       */
        public static mx.gob.inmujeres.swb.SelectCandidate getSelectCandidate(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SelectCandidate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.SelectCandidate
       * @param id Identifier for mx.gob.inmujeres.swb.SelectCandidate
       * @param model Model of the mx.gob.inmujeres.swb.SelectCandidate
       * @return A mx.gob.inmujeres.swb.SelectCandidate
       */
        public static mx.gob.inmujeres.swb.SelectCandidate createSelectCandidate(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SelectCandidate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.SelectCandidate
       * @param id Identifier for mx.gob.inmujeres.swb.SelectCandidate
       * @param model Model of the mx.gob.inmujeres.swb.SelectCandidate
       */
        public static void removeSelectCandidate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.SelectCandidate
       * @param id Identifier for mx.gob.inmujeres.swb.SelectCandidate
       * @param model Model of the mx.gob.inmujeres.swb.SelectCandidate
       * @return true if the mx.gob.inmujeres.swb.SelectCandidate exists, false otherwise
       */

        public static boolean hasSelectCandidate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSelectCandidate(id, model)!=null);
        }
    }

    public static SelectCandidateBase.ClassMgr getSelectCandidateClassMgr()
    {
        return new SelectCandidateBase.ClassMgr();
    }

   /**
   * Constructs a SelectCandidateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SelectCandidate
   */
    public SelectCandidateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
