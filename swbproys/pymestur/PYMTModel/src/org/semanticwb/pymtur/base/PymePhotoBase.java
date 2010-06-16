package org.semanticwb.pymtur.base;


public abstract class PymePhotoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_photoSize=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#photoSize");
    public static final org.semanticwb.platform.SemanticProperty pymtur_photoThumbnail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#photoThumbnail");
    public static final org.semanticwb.platform.SemanticProperty pymtur_photoMimeType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#photoMimeType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_PhotoImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoImage");
    public static final org.semanticwb.platform.SemanticClass pymtur_PymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.PymePhoto> listPymePhotos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PymePhoto> listPymePhotos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(it, true);
        }

        public static org.semanticwb.pymtur.PymePhoto createPymePhoto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.PymePhoto.ClassMgr.createPymePhoto(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.PymePhoto getPymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.PymePhoto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.PymePhoto createPymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.PymePhoto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removePymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasPymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPymePhoto(id, model)!=null);
        }
    }

    public PymePhotoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public float getPhotoSize()
    {
        return getSemanticObject().getFloatProperty(pymtur_photoSize);
    }

    public void setPhotoSize(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_photoSize, value);
    }

    public String getPhotoThumbnail()
    {
        return getSemanticObject().getProperty(pymtur_photoThumbnail);
    }

    public void setPhotoThumbnail(String value)
    {
        getSemanticObject().setProperty(pymtur_photoThumbnail, value);
    }

    public String getPhotoMimeType()
    {
        return getSemanticObject().getProperty(pymtur_photoMimeType);
    }

    public void setPhotoMimeType(String value)
    {
        getSemanticObject().setProperty(pymtur_photoMimeType, value);
    }

    public String getPhotoImage()
    {
        return getSemanticObject().getProperty(pymtur_PhotoImage);
    }

    public void setPhotoImage(String value)
    {
        getSemanticObject().setProperty(pymtur_PhotoImage, value);
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
