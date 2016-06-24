package org.semanticwb.bsc.formelement.base;


public abstract class EditorElementBase extends org.semanticwb.model.base.FormElementBase 
{
    public static final org.semanticwb.platform.SemanticClass bsc_EditorElement=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#EditorElement");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#EditorElement");

    public static class ClassMgr
    {
       /**
       * Returns a list of EditorElement for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.formelement.EditorElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.formelement.EditorElement> listEditorElements(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.formelement.EditorElement>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.formelement.EditorElement for all models
       * @return Iterator of org.semanticwb.bsc.formelement.EditorElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.formelement.EditorElement> listEditorElements()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.formelement.EditorElement>(it, true);
        }
       /**
       * Gets a org.semanticwb.bsc.formelement.EditorElement
       * @param id Identifier for org.semanticwb.bsc.formelement.EditorElement
       * @param model Model of the org.semanticwb.bsc.formelement.EditorElement
       * @return A org.semanticwb.bsc.formelement.EditorElement
       */
        public static org.semanticwb.bsc.formelement.EditorElement getEditorElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.formelement.EditorElement)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.formelement.EditorElement
       * @param id Identifier for org.semanticwb.bsc.formelement.EditorElement
       * @param model Model of the org.semanticwb.bsc.formelement.EditorElement
       * @return A org.semanticwb.bsc.formelement.EditorElement
       */
        public static org.semanticwb.bsc.formelement.EditorElement createEditorElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.formelement.EditorElement)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.formelement.EditorElement
       * @param id Identifier for org.semanticwb.bsc.formelement.EditorElement
       * @param model Model of the org.semanticwb.bsc.formelement.EditorElement
       */
        public static void removeEditorElement(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.formelement.EditorElement
       * @param id Identifier for org.semanticwb.bsc.formelement.EditorElement
       * @param model Model of the org.semanticwb.bsc.formelement.EditorElement
       * @return true if the org.semanticwb.bsc.formelement.EditorElement exists, false otherwise
       */

        public static boolean hasEditorElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEditorElement(id, model)!=null);
        }
    }

    public static EditorElementBase.ClassMgr getEditorElementClassMgr()
    {
        return new EditorElementBase.ClassMgr();
    }

   /**
   * Constructs a EditorElementBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EditorElement
   */
    public EditorElementBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
