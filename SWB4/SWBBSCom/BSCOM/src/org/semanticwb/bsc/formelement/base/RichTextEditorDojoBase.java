package org.semanticwb.bsc.formelement.base;


   /**
   * FormElement que presenta un Editor, utilizando la clase dijit/Editor de Dojo 
   */
public abstract class RichTextEditorDojoBase extends org.semanticwb.model.TextArea 
{
   /**
   * FormElement que presenta un Editor, utilizando la clase dijit/Editor de Dojo
   */
    public static final org.semanticwb.platform.SemanticClass bsc_RichTextEditorDojo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#RichTextEditorDojo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#RichTextEditorDojo");

    public static class ClassMgr
    {
       /**
       * Returns a list of RichTextEditorDojo for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.formelement.RichTextEditorDojo
       */

        public static java.util.Iterator<org.semanticwb.bsc.formelement.RichTextEditorDojo> listRichTextEditorDojos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.formelement.RichTextEditorDojo>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.formelement.RichTextEditorDojo for all models
       * @return Iterator of org.semanticwb.bsc.formelement.RichTextEditorDojo
       */

        public static java.util.Iterator<org.semanticwb.bsc.formelement.RichTextEditorDojo> listRichTextEditorDojos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.formelement.RichTextEditorDojo>(it, true);
        }
       /**
       * Gets a org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param id Identifier for org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param model Model of the org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @return A org.semanticwb.bsc.formelement.RichTextEditorDojo
       */
        public static org.semanticwb.bsc.formelement.RichTextEditorDojo getRichTextEditorDojo(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.formelement.RichTextEditorDojo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param id Identifier for org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param model Model of the org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @return A org.semanticwb.bsc.formelement.RichTextEditorDojo
       */
        public static org.semanticwb.bsc.formelement.RichTextEditorDojo createRichTextEditorDojo(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.formelement.RichTextEditorDojo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param id Identifier for org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param model Model of the org.semanticwb.bsc.formelement.RichTextEditorDojo
       */
        public static void removeRichTextEditorDojo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param id Identifier for org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @param model Model of the org.semanticwb.bsc.formelement.RichTextEditorDojo
       * @return true if the org.semanticwb.bsc.formelement.RichTextEditorDojo exists, false otherwise
       */

        public static boolean hasRichTextEditorDojo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRichTextEditorDojo(id, model)!=null);
        }
    }

    public static RichTextEditorDojoBase.ClassMgr getRichTextEditorDojoClassMgr()
    {
        return new RichTextEditorDojoBase.ClassMgr();
    }

   /**
   * Constructs a RichTextEditorDojoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the RichTextEditorDojo
   */
    public RichTextEditorDojoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
