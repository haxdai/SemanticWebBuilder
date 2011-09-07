package org.semanticwb.cptm.base;


   /**
   * TreeSelect 
   */
public abstract class TreeSelectBase extends org.semanticwb.model.base.FormElementBase 
{
   /**
   * TreeSelect
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TreeSelect=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TreeSelect");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TreeSelect");

    public static class ClassMgr
    {
       /**
       * Returns a list of TreeSelect for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.TreeSelect
       */

        public static java.util.Iterator<org.semanticwb.cptm.TreeSelect> listTreeSelects(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TreeSelect>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.TreeSelect for all models
       * @return Iterator of org.semanticwb.cptm.TreeSelect
       */

        public static java.util.Iterator<org.semanticwb.cptm.TreeSelect> listTreeSelects()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TreeSelect>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.TreeSelect
       * @param id Identifier for org.semanticwb.cptm.TreeSelect
       * @param model Model of the org.semanticwb.cptm.TreeSelect
       * @return A org.semanticwb.cptm.TreeSelect
       */
        public static org.semanticwb.cptm.TreeSelect getTreeSelect(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TreeSelect)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.TreeSelect
       * @param id Identifier for org.semanticwb.cptm.TreeSelect
       * @param model Model of the org.semanticwb.cptm.TreeSelect
       * @return A org.semanticwb.cptm.TreeSelect
       */
        public static org.semanticwb.cptm.TreeSelect createTreeSelect(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TreeSelect)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.TreeSelect
       * @param id Identifier for org.semanticwb.cptm.TreeSelect
       * @param model Model of the org.semanticwb.cptm.TreeSelect
       */
        public static void removeTreeSelect(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.TreeSelect
       * @param id Identifier for org.semanticwb.cptm.TreeSelect
       * @param model Model of the org.semanticwb.cptm.TreeSelect
       * @return true if the org.semanticwb.cptm.TreeSelect exists, false otherwise
       */

        public static boolean hasTreeSelect(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTreeSelect(id, model)!=null);
        }
    }

   /**
   * Constructs a TreeSelectBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TreeSelect
   */
    public TreeSelectBase(org.semanticwb.platform.SemanticObject base)
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
