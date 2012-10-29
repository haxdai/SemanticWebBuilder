package com.infotec.conorg.base;


public abstract class EditorsBase extends com.infotec.conorg.Author 
{
    public static final org.semanticwb.platform.SemanticClass conorg_Editors=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Editors");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Editors");

    public static class ClassMgr
    {
       /**
       * Returns a list of Editors for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Editors
       */

        public static java.util.Iterator<com.infotec.conorg.Editors> listEditorses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Editors>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Editors for all models
       * @return Iterator of com.infotec.conorg.Editors
       */

        public static java.util.Iterator<com.infotec.conorg.Editors> listEditorses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Editors>(it, true);
        }
       /**
       * Gets a com.infotec.conorg.Editors
       * @param id Identifier for com.infotec.conorg.Editors
       * @param model Model of the com.infotec.conorg.Editors
       * @return A com.infotec.conorg.Editors
       */
        public static com.infotec.conorg.Editors getEditors(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Editors)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Editors
       * @param id Identifier for com.infotec.conorg.Editors
       * @param model Model of the com.infotec.conorg.Editors
       * @return A com.infotec.conorg.Editors
       */
        public static com.infotec.conorg.Editors createEditors(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Editors)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Editors
       * @param id Identifier for com.infotec.conorg.Editors
       * @param model Model of the com.infotec.conorg.Editors
       */
        public static void removeEditors(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Editors
       * @param id Identifier for com.infotec.conorg.Editors
       * @param model Model of the com.infotec.conorg.Editors
       * @return true if the com.infotec.conorg.Editors exists, false otherwise
       */

        public static boolean hasEditors(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEditors(id, model)!=null);
        }
    }

    public static EditorsBase.ClassMgr getEditorsClassMgr()
    {
        return new EditorsBase.ClassMgr();
    }

   /**
   * Constructs a EditorsBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Editors
   */
    public EditorsBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
