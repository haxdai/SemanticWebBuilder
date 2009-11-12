package org.semanticwb.repository.base;


public class UnstructuredBase extends org.semanticwb.repository.BaseNode 
{
       public static final org.semanticwb.platform.SemanticClass nt_Unstructured=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#unstructured");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#unstructured");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.repository.Unstructured> listUnstructureds(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.Unstructured>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.repository.Unstructured> listUnstructureds()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.Unstructured>(it, true);
       }

       public static org.semanticwb.repository.Unstructured createUnstructured(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.repository.Unstructured.ClassMgr.createUnstructured(String.valueOf(id), model);
       }

       public static org.semanticwb.repository.Unstructured getUnstructured(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.repository.Unstructured)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.repository.Unstructured createUnstructured(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.repository.Unstructured)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeUnstructured(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasUnstructured(String id, org.semanticwb.model.SWBModel model)
       {
           return (getUnstructured(id, model)!=null);
       }
    }

    public UnstructuredBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.repository.Workspace getWorkspace()
    {
        return (org.semanticwb.repository.Workspace)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
