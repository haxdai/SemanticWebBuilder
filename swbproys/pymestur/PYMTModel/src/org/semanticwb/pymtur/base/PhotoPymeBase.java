package org.semanticwb.pymtur.base;


public abstract class PhotoPymeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
       public static final org.semanticwb.platform.SemanticProperty pymtur_imagen=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#imagen");
       public static final org.semanticwb.platform.SemanticClass pymtur_PhotoPyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoPyme");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoPyme");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.pymtur.PhotoPyme> listPhotoPymes(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PhotoPyme>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.pymtur.PhotoPyme> listPhotoPymes()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PhotoPyme>(it, true);
       }

       public static org.semanticwb.pymtur.PhotoPyme getPhotoPyme(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.PhotoPyme)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.pymtur.PhotoPyme createPhotoPyme(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.PhotoPyme)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removePhotoPyme(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasPhotoPyme(String id, org.semanticwb.model.SWBModel model)
       {
           return (getPhotoPyme(id, model)!=null);
       }
    }

    public PhotoPymeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
}
