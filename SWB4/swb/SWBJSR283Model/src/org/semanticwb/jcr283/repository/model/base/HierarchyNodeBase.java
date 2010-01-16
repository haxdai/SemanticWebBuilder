package org.semanticwb.jcr283.repository.model.base;


public abstract class HierarchyNodeBase extends org.semanticwb.jcr283.repository.model.Base 
{
       public static final org.semanticwb.platform.SemanticClass nt_HierarchyNode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#hierarchyNode");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#hierarchyNode");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.jcr283.repository.model.HierarchyNode> listHierarchyNodes(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.jcr283.repository.model.HierarchyNode>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.jcr283.repository.model.HierarchyNode> listHierarchyNodes()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.jcr283.repository.model.HierarchyNode>(it, true);
       }

       public static org.semanticwb.jcr283.repository.model.HierarchyNode getHierarchyNode(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.jcr283.repository.model.HierarchyNode)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.jcr283.repository.model.HierarchyNode createHierarchyNode(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.jcr283.repository.model.HierarchyNode)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeHierarchyNode(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasHierarchyNode(String id, org.semanticwb.model.SWBModel model)
       {
           return (getHierarchyNode(id, model)!=null);
       }
    }

    public HierarchyNodeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
