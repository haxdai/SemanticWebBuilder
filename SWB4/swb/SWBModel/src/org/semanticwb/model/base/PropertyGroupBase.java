package org.semanticwb.model.base;


public class PropertyGroupBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Sortable
{
    public static final org.semanticwb.platform.SemanticProperty swb_index=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#index");
    public static final org.semanticwb.platform.SemanticClass swbxf_PropertyGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#PropertyGroup");


    public static org.semanticwb.model.PropertyGroup createPropertyGroup(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.PropertyGroup)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, swbxf_PropertyGroup), swbxf_PropertyGroup);
    }

    public PropertyGroupBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public int getIndex()
    {
        return getSemanticObject().getIntProperty(swb_index);
    }

    public void setIndex(int index)
    {
        getSemanticObject().setLongProperty(swb_index, index);
    }
}
