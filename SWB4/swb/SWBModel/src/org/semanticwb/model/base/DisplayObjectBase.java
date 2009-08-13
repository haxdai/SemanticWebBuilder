package org.semanticwb.model.base;


public class DisplayObjectBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Iconable
{
    public static final org.semanticwb.platform.SemanticProperty swb_iconClass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#iconClass");
    public static final org.semanticwb.platform.SemanticProperty swbxf_doDispatcher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#doDispatcher");
    public static final org.semanticwb.platform.SemanticProperty swbxf_dragSupport=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#dragSupport");
    public static final org.semanticwb.platform.SemanticProperty swbxf_doTreeController=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#doTreeController");
    public static final org.semanticwb.platform.SemanticProperty swbxf_dropMatchLevel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#dropMatchLevel");
    public static final org.semanticwb.platform.SemanticClass swbxf_DisplayObject=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#DisplayObject");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#DisplayObject");

    public DisplayObjectBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.DisplayObject> listDisplayObjects(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.DisplayObject>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.DisplayObject> listDisplayObjects()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.DisplayObject>(it, true);
    }

    public static org.semanticwb.model.DisplayObject getDisplayObject(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.DisplayObject)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.DisplayObject createDisplayObject(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.DisplayObject)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeDisplayObject(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasDisplayObject(String id, org.semanticwb.model.SWBModel model)
    {
        return (getDisplayObject(id, model)!=null);
    }

    public String getIconClass()
    {
        return getSemanticObject().getProperty(swb_iconClass);
    }

    public void setIconClass(String iconClass)
    {
        getSemanticObject().setProperty(swb_iconClass, iconClass);
    }

    public String getDoDispatcher()
    {
        return getSemanticObject().getProperty(swbxf_doDispatcher);
    }

    public void setDoDispatcher(String doDispatcher)
    {
        getSemanticObject().setProperty(swbxf_doDispatcher, doDispatcher);
    }

    public boolean isDragSupport()
    {
        return getSemanticObject().getBooleanProperty(swbxf_dragSupport);
    }

    public void setDragSupport(boolean dragSupport)
    {
        getSemanticObject().setBooleanProperty(swbxf_dragSupport, dragSupport);
    }

    public String getTreeController()
    {
        return getSemanticObject().getProperty(swbxf_doTreeController);
    }

    public void setTreeController(String doTreeController)
    {
        getSemanticObject().setProperty(swbxf_doTreeController, doTreeController);
    }

    public int getDropMatchLevel()
    {
        return getSemanticObject().getIntProperty(swbxf_dropMatchLevel);
    }

    public void setDropMatchLevel(int dropMatchLevel)
    {
        getSemanticObject().setIntProperty(swbxf_dropMatchLevel, dropMatchLevel);
    }
}
