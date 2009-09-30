package org.semanticwb.repository.base;


public class WorkspaceBase extends org.semanticwb.model.SWBModel implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass nt_BaseNode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#base");
    public static final org.semanticwb.platform.SemanticProperty jcr_root=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#root");
    public static final org.semanticwb.platform.SemanticClass nt_Unstructured=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#unstructured");
    public static final org.semanticwb.platform.SemanticClass swbrep_Workspace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/repository#Workspace");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/repository#Workspace");

    public WorkspaceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.repository.Workspace> listWorkspaces(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.Workspace>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.repository.Workspace> listWorkspaces()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.Workspace>(it, true);
    }

    public static org.semanticwb.repository.Workspace getWorkspace(String id)
    {
       org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
       org.semanticwb.repository.Workspace ret=null;
       org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
       if(model!=null)
       {
           org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
           if(obj!=null)
           {
               ret=(org.semanticwb.repository.Workspace)obj.createGenericInstance();
           }
       }
       return ret;
    }

    public static org.semanticwb.repository.Workspace createWorkspace(String id, String namespace)
    {
        org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
        org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
        return (org.semanticwb.repository.Workspace)model.createGenericObject(model.getObjectUri(id, sclass), sclass);
    }

    public static void removeWorkspace(String id)
    {
       org.semanticwb.repository.Workspace obj=getWorkspace(id);
       if(obj!=null)
       {
           obj.remove();
       }
    }

    public static boolean hasWorkspace(String id)
    {
        return (getWorkspace(id)!=null);
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

    public void setRoot(org.semanticwb.repository.BaseNode value)
    {
        getSemanticObject().setObjectProperty(jcr_root, value.getSemanticObject());
    }

    public void removeRoot()
    {
        getSemanticObject().removeProperty(jcr_root);
    }

   public static java.util.Iterator<org.semanticwb.repository.Workspace> listWorkspaceByRoot(org.semanticwb.repository.BaseNode root,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.repository.Workspace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(jcr_root, root.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.repository.Workspace> listWorkspaceByRoot(org.semanticwb.repository.BaseNode root)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.repository.Workspace> it=new org.semanticwb.model.GenericIterator(root.getSemanticObject().getModel().listSubjects(jcr_root,root.getSemanticObject()));
       return it;
   }

    public org.semanticwb.repository.BaseNode getRoot()
    {
         org.semanticwb.repository.BaseNode ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(jcr_root);
         if(obj!=null)
         {
             ret=(org.semanticwb.repository.BaseNode)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.repository.BaseNode getBaseNode(String id)
    {
        return org.semanticwb.repository.BaseNode.getBaseNode(id, this);
    }

    public java.util.Iterator<org.semanticwb.repository.BaseNode> listBaseNodes()
    {
        return org.semanticwb.repository.BaseNode.listBaseNodes(this);
    }

    public org.semanticwb.repository.BaseNode createBaseNode(String id)
    {
        return org.semanticwb.repository.BaseNode.createBaseNode(id,this);
    }

    public void removeBaseNode(String id)
    {
        org.semanticwb.repository.BaseNode.removeBaseNode(id, this);
    }
    public boolean hasBaseNode(String id)
    {
        return org.semanticwb.repository.BaseNode.hasBaseNode(id, this);
    }

    public org.semanticwb.repository.Unstructured getUnstructured(String id)
    {
        return org.semanticwb.repository.Unstructured.getUnstructured(id, this);
    }

    public java.util.Iterator<org.semanticwb.repository.Unstructured> listUnstructureds()
    {
        return org.semanticwb.repository.Unstructured.listUnstructureds(this);
    }

    public org.semanticwb.repository.Unstructured createUnstructured(String id)
    {
        return org.semanticwb.repository.Unstructured.createUnstructured(id,this);
    }

    public org.semanticwb.repository.Unstructured createUnstructured()
    {
        long id=getSemanticObject().getModel().getCounter(nt_Unstructured);
        return org.semanticwb.repository.Unstructured.createUnstructured(String.valueOf(id),this);
    } 

    public void removeUnstructured(String id)
    {
        org.semanticwb.repository.Unstructured.removeUnstructured(id, this);
    }
    public boolean hasUnstructured(String id)
    {
        return org.semanticwb.repository.Unstructured.hasUnstructured(id, this);
    }
}
