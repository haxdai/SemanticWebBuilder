package org.semanticwb.model.base;


public class HerarquicalNodeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Sortable,org.semanticwb.model.Iconable,org.semanticwb.model.Filterable
{
    public static class ClassMgr
    {
       public static final org.semanticwb.platform.SemanticProperty swb_index=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#index");
       public static final org.semanticwb.platform.SemanticProperty swbxf_heTreeController=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#heTreeController");
       public static final org.semanticwb.platform.SemanticProperty swb_title=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#title");
       public static final org.semanticwb.platform.SemanticProperty swb_iconClass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#iconClass");
       public static final org.semanticwb.platform.SemanticClass swb_Class=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Class");
       public static final org.semanticwb.platform.SemanticProperty swbxf_heClass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#heClass");
       public static final org.semanticwb.platform.SemanticProperty swbxf_hePropertyFilter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#hePropertyFilter");
       public static final org.semanticwb.platform.SemanticClass swb_SWBModel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#SWBModel");
       public static final org.semanticwb.platform.SemanticProperty swbxf_heModel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#heModel");
       public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
       public static final org.semanticwb.platform.SemanticProperty swb_description=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#description");
       public static final org.semanticwb.platform.SemanticClass swbxf_HerarquicalNode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#HerarquicalNode");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#HerarquicalNode");

       public static java.util.Iterator<org.semanticwb.model.HerarquicalNode> listHerarquicalNodes(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.model.HerarquicalNode>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.model.HerarquicalNode> listHerarquicalNodes()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.model.HerarquicalNode>(it, true);
       }

       public static org.semanticwb.model.HerarquicalNode getHerarquicalNode(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.model.HerarquicalNode)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.model.HerarquicalNode createHerarquicalNode(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.model.HerarquicalNode)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeHerarquicalNode(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasHerarquicalNode(String id, org.semanticwb.model.SWBModel model)
       {
           return (getHerarquicalNode(id, model)!=null);
       }
    }

    public HerarquicalNodeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public int getIndex()
    {
        return getSemanticObject().getIntProperty(ClassMgr.swb_index);
    }

    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(ClassMgr.swb_index, value);
    }

    public String getTreeController()
    {
        return getSemanticObject().getProperty(ClassMgr.swbxf_heTreeController);
    }

    public void setTreeController(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swbxf_heTreeController, value);
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(ClassMgr.swb_title);
    }

    public void setTitle(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(ClassMgr.swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(ClassMgr.swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(ClassMgr.swb_title, title, lang);
    }

    public String getIconClass()
    {
        return getSemanticObject().getProperty(ClassMgr.swb_iconClass);
    }

    public void setIconClass(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swb_iconClass, value);
    }

    public void setHClass(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swbxf_heClass, value);
    }

    public void removeHClass()
    {
        getSemanticObject().removeProperty(ClassMgr.swbxf_heClass);
    }

    public org.semanticwb.platform.SemanticObject getHClass()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(ClassMgr.swbxf_heClass);
         return ret;
    }

    public String getPropertyFilter()
    {
        return getSemanticObject().getProperty(ClassMgr.swbxf_hePropertyFilter);
    }

    public void setPropertyFilter(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swbxf_hePropertyFilter, value);
    }

    public void setModel(org.semanticwb.model.SWBModel value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swbxf_heModel, value.getSemanticObject());
    }

    public void removeModel()
    {
        getSemanticObject().removeProperty(ClassMgr.swbxf_heModel);
    }

   public static java.util.Iterator<org.semanticwb.model.HerarquicalNode> listHerarquicalNodeByModel(org.semanticwb.model.SWBModel hemodel,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.HerarquicalNode> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swbxf_heModel, hemodel.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.HerarquicalNode> listHerarquicalNodeByModel(org.semanticwb.model.SWBModel hemodel)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.HerarquicalNode> it=new org.semanticwb.model.GenericIterator(hemodel.getSemanticObject().getModel().listSubjects(ClassMgr.swbxf_heModel,hemodel.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.SWBModel getModel()
    {
         org.semanticwb.model.SWBModel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swbxf_heModel);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.SWBModel)obj.createGenericInstance();
         }
         return ret;
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(ClassMgr.swb_description);
    }

    public void setDescription(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(ClassMgr.swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(ClassMgr.swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(ClassMgr.swb_description, description, lang);
    }
}
