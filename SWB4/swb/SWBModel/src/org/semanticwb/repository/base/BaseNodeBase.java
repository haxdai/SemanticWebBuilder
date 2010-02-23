package org.semanticwb.repository.base;


public abstract class BaseNodeBase extends org.semanticwb.model.base.GenericObjectBase 
{
    public static final org.semanticwb.platform.SemanticClass nt_BaseNode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#base");
    public static final org.semanticwb.platform.SemanticProperty swbrep_parentNode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/repository#parentNode");
    public static final org.semanticwb.platform.SemanticProperty jcr_primaryType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#primaryType");
    public static final org.semanticwb.platform.SemanticProperty swbrep_path=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/repository#path");
    public static final org.semanticwb.platform.SemanticProperty swbrep_name=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/repository#name");
    public static final org.semanticwb.platform.SemanticProperty swbrep_hasNodes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/repository#hasNodes");
    public static final org.semanticwb.platform.SemanticProperty jcr_mixinTypes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#mixinTypes");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.jcp.org/jcr/nt/1.0#base");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.repository.BaseNode> listBaseNodes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.repository.BaseNode> listBaseNodes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode>(it, true);
        }

        public static org.semanticwb.repository.BaseNode getBaseNode(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.repository.BaseNode)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.repository.BaseNode createBaseNode(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.repository.BaseNode)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeBaseNode(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasBaseNode(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBaseNode(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.repository.BaseNode> listBaseNodeByParent(org.semanticwb.repository.BaseNode parentnode,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbrep_parentNode, parentnode.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.repository.BaseNode> listBaseNodeByParent(org.semanticwb.repository.BaseNode parentnode)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode> it=new org.semanticwb.model.GenericIterator(parentnode.getSemanticObject().getModel().listSubjects(swbrep_parentNode,parentnode.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.repository.BaseNode> listBaseNodeByNode(org.semanticwb.repository.BaseNode hasnodes,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbrep_hasNodes, hasnodes.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.repository.BaseNode> listBaseNodeByNode(org.semanticwb.repository.BaseNode hasnodes)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode> it=new org.semanticwb.model.GenericIterator(hasnodes.getSemanticObject().getModel().listSubjects(swbrep_hasNodes,hasnodes.getSemanticObject()));
            return it;
        }
    }

    public BaseNodeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setParent(org.semanticwb.repository.BaseNode value)
    {
        getSemanticObject().setObjectProperty(swbrep_parentNode, value.getSemanticObject());
    }

    public void removeParent()
    {
        getSemanticObject().removeProperty(swbrep_parentNode);
    }

    public org.semanticwb.repository.BaseNode getParent()
    {
         org.semanticwb.repository.BaseNode ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbrep_parentNode);
         if(obj!=null)
         {
             ret=(org.semanticwb.repository.BaseNode)obj.createGenericInstance();
         }
         return ret;
    }

    public String getPrimaryType()
    {
        return getSemanticObject().getProperty(jcr_primaryType);
    }

    public void setPrimaryType(String value)
    {
        getSemanticObject().setProperty(jcr_primaryType, value);
    }

    public String getPath()
    {
        return getSemanticObject().getProperty(swbrep_path);
    }

    public void setPath(String value)
    {
        getSemanticObject().setProperty(swbrep_path, value);
    }

    public String getName()
    {
        return getSemanticObject().getProperty(swbrep_name);
    }

    public void setName(String value)
    {
        getSemanticObject().setProperty(swbrep_name, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode> listNodes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.BaseNode>(getSemanticObject().listObjectProperties(swbrep_hasNodes));
    }

    public boolean hasNode(org.semanticwb.repository.BaseNode basenode)
    {
        boolean ret=false;
        if(basenode!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbrep_hasNodes,basenode.getSemanticObject());
        }
        return ret;
    }

    public org.semanticwb.repository.BaseNode getNode()
    {
         org.semanticwb.repository.BaseNode ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbrep_hasNodes);
         if(obj!=null)
         {
             ret=(org.semanticwb.repository.BaseNode)obj.createGenericInstance();
         }
         return ret;
    }

    public String getMixinTypes()
    {
        return getSemanticObject().getProperty(jcr_mixinTypes);
    }

    public void setMixinTypes(String value)
    {
        getSemanticObject().setProperty(jcr_mixinTypes, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }

    public org.semanticwb.repository.Workspace getWorkspace()
    {
        return (org.semanticwb.repository.Workspace)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
