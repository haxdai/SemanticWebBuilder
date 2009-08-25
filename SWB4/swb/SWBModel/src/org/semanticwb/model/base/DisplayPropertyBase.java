package org.semanticwb.model.base;


public class DisplayPropertyBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Sortable
{
    public static final org.semanticwb.platform.SemanticProperty swb_index=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#index");
    public static final org.semanticwb.platform.SemanticProperty swbxf_propSelectValues=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#propSelectValues");
    public static final org.semanticwb.platform.SemanticProperty swbxf_propDisabled=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#propDisabled");
    public static final org.semanticwb.platform.SemanticProperty swbxf_propHidden=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#propHidden");
    public static final org.semanticwb.platform.SemanticProperty swbxf_propInvalidMessage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#propInvalidMessage");
    public static final org.semanticwb.platform.SemanticClass swb_SWBFormElement=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#SWBFormElement");
    public static final org.semanticwb.platform.SemanticProperty swbxf_formElement=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#formElement");
    public static final org.semanticwb.platform.SemanticClass swbxf_PropertyGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#PropertyGroup");
    public static final org.semanticwb.platform.SemanticProperty swbxf_propGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#propGroup");
    public static final org.semanticwb.platform.SemanticProperty swbxf_propPromptMessage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#propPromptMessage");
    public static final org.semanticwb.platform.SemanticClass swbxf_DisplayProperty=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#DisplayProperty");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#DisplayProperty");

    public DisplayPropertyBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.DisplayProperty> listDisplayPropertys(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.DisplayProperty>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.DisplayProperty> listDisplayPropertys()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.DisplayProperty>(it, true);
    }

    public static org.semanticwb.model.DisplayProperty getDisplayProperty(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.DisplayProperty)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.DisplayProperty createDisplayProperty(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.DisplayProperty)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeDisplayProperty(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasDisplayProperty(String id, org.semanticwb.model.SWBModel model)
    {
        return (getDisplayProperty(id, model)!=null);
    }

    public int getIndex()
    {
        return getSemanticObject().getIntProperty(swb_index);
    }

    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(swb_index, value);
    }

    public String getSelectValues()
    {
        return getSemanticObject().getProperty(swbxf_propSelectValues);
    }

    public void setSelectValues(String value)
    {
        getSemanticObject().setProperty(swbxf_propSelectValues, value);
    }

    public String getSelectValues(String lang)
    {
        return getSemanticObject().getProperty(swbxf_propSelectValues, null, lang);
    }

    public String getDisplaySelectValues(String lang)
    {
        return getSemanticObject().getLocaleProperty(swbxf_propSelectValues, lang);
    }

    public void setSelectValues(String propSelectValues, String lang)
    {
        getSemanticObject().setProperty(swbxf_propSelectValues, propSelectValues, lang);
    }

    public boolean isDisabled()
    {
        return getSemanticObject().getBooleanProperty(swbxf_propDisabled);
    }

    public void setDisabled(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbxf_propDisabled, value);
    }

    public boolean isHidden()
    {
        return getSemanticObject().getBooleanProperty(swbxf_propHidden);
    }

    public void setHidden(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbxf_propHidden, value);
    }

    public String getInvalidMessage()
    {
        return getSemanticObject().getProperty(swbxf_propInvalidMessage);
    }

    public void setInvalidMessage(String value)
    {
        getSemanticObject().setProperty(swbxf_propInvalidMessage, value);
    }

    public String getInvalidMessage(String lang)
    {
        return getSemanticObject().getProperty(swbxf_propInvalidMessage, null, lang);
    }

    public String getDisplayInvalidMessage(String lang)
    {
        return getSemanticObject().getLocaleProperty(swbxf_propInvalidMessage, lang);
    }

    public void setInvalidMessage(String propInvalidMessage, String lang)
    {
        getSemanticObject().setProperty(swbxf_propInvalidMessage, propInvalidMessage, lang);
    }

    public void setFormElement(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(swbxf_formElement, value);
    }

    public void removeFormElement()
    {
        getSemanticObject().removeProperty(swbxf_formElement);
    }

    public org.semanticwb.platform.SemanticObject getFormElement()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(swbxf_formElement);
         return ret;
    }

    public void setGroup(org.semanticwb.model.PropertyGroup value)
    {
        getSemanticObject().setObjectProperty(swbxf_propGroup, value.getSemanticObject());
    }

    public void removeGroup()
    {
        getSemanticObject().removeProperty(swbxf_propGroup);
    }

   public static java.util.Iterator<org.semanticwb.model.DisplayProperty> listDisplayPropertyByGroup(org.semanticwb.model.PropertyGroup propgroup,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.DisplayProperty> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbxf_propGroup, propgroup.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.DisplayProperty> listDisplayPropertyByGroup(org.semanticwb.model.PropertyGroup propgroup)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.DisplayProperty> it=new org.semanticwb.model.GenericIterator(propgroup.getSemanticObject().getModel().listSubjects(swbxf_propGroup,propgroup.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.PropertyGroup getGroup()
    {
         org.semanticwb.model.PropertyGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbxf_propGroup);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.PropertyGroup)obj.createGenericInstance();
         }
         return ret;
    }

    public String getPromptMessage()
    {
        return getSemanticObject().getProperty(swbxf_propPromptMessage);
    }

    public void setPromptMessage(String value)
    {
        getSemanticObject().setProperty(swbxf_propPromptMessage, value);
    }

    public String getPromptMessage(String lang)
    {
        return getSemanticObject().getProperty(swbxf_propPromptMessage, null, lang);
    }

    public String getDisplayPromptMessage(String lang)
    {
        return getSemanticObject().getLocaleProperty(swbxf_propPromptMessage, lang);
    }

    public void setPromptMessage(String propPromptMessage, String lang)
    {
        getSemanticObject().setProperty(swbxf_propPromptMessage, propPromptMessage, lang);
    }
}
