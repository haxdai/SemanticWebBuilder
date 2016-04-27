package org.semanticwb.process.model.base;


public abstract class CodeEditorBase extends org.semanticwb.model.TextArea 
{
    public static final org.semanticwb.platform.SemanticClass swp_CodeEditor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#CodeEditor");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#CodeEditor");

    public static class ClassMgr
    {
       /**
       * Returns a list of CodeEditor for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.CodeEditor
       */

        public static java.util.Iterator<org.semanticwb.process.model.CodeEditor> listCodeEditors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CodeEditor>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.CodeEditor for all models
       * @return Iterator of org.semanticwb.process.model.CodeEditor
       */

        public static java.util.Iterator<org.semanticwb.process.model.CodeEditor> listCodeEditors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CodeEditor>(it, true);
        }
       /**
       * Gets a org.semanticwb.process.model.CodeEditor
       * @param id Identifier for org.semanticwb.process.model.CodeEditor
       * @param model Model of the org.semanticwb.process.model.CodeEditor
       * @return A org.semanticwb.process.model.CodeEditor
       */
        public static org.semanticwb.process.model.CodeEditor getCodeEditor(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.CodeEditor)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.CodeEditor
       * @param id Identifier for org.semanticwb.process.model.CodeEditor
       * @param model Model of the org.semanticwb.process.model.CodeEditor
       * @return A org.semanticwb.process.model.CodeEditor
       */
        public static org.semanticwb.process.model.CodeEditor createCodeEditor(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.CodeEditor)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.CodeEditor
       * @param id Identifier for org.semanticwb.process.model.CodeEditor
       * @param model Model of the org.semanticwb.process.model.CodeEditor
       */
        public static void removeCodeEditor(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.CodeEditor
       * @param id Identifier for org.semanticwb.process.model.CodeEditor
       * @param model Model of the org.semanticwb.process.model.CodeEditor
       * @return true if the org.semanticwb.process.model.CodeEditor exists, false otherwise
       */

        public static boolean hasCodeEditor(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCodeEditor(id, model)!=null);
        }
    }

    public static CodeEditorBase.ClassMgr getCodeEditorClassMgr()
    {
        return new CodeEditorBase.ClassMgr();
    }

   /**
   * Constructs a CodeEditorBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CodeEditor
   */
    public CodeEditorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
