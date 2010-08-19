package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class ContentBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty swbpress_numConsecutivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#numConsecutivo");
    public static final org.semanticwb.platform.SemanticClass swbpress_Photos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Photos");
    public static final org.semanticwb.platform.SemanticProperty swbpress_hasPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#hasPhoto");
    public static final org.semanticwb.platform.SemanticProperty swbpress_startDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#startDate");
    public static final org.semanticwb.platform.SemanticClass swbpress_Files=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Files");
    public static final org.semanticwb.platform.SemanticProperty swbpress_hasFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#hasFile");
    public static final org.semanticwb.platform.SemanticProperty swbpress_priority=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#priority");
    public static final org.semanticwb.platform.SemanticClass swbpress_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Category");
    public static final org.semanticwb.platform.SemanticProperty swbpress_category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#category");
    public static final org.semanticwb.platform.SemanticProperty swbpress_content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#content");
    public static final org.semanticwb.platform.SemanticProperty swbpress_endDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#endDate");
    public static final org.semanticwb.platform.SemanticClass swbpress_Content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Content");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Content");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Content createContent(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.Content.ClassMgr.createContent(String.valueOf(id), model);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Content getContent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Content)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Content createContent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Content)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static void removeContent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasContent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getContent(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasPhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasPhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByFile(org.semanticwb.portal.resources.sem.pressroom.Files value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasFile, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasFile,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCategory(org.semanticwb.portal.resources.sem.pressroom.Category value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_category, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_category,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public ContentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

    public int getNumConsecutivo()
    {
        return getSemanticObject().getIntProperty(swbpress_numConsecutivo);
    }

    public void setNumConsecutivo(int value)
    {
        getSemanticObject().setIntProperty(swbpress_numConsecutivo, value);
    }

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos> listPhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos>(getSemanticObject().listObjectProperties(swbpress_hasPhoto));
    }

    public boolean hasPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbpress_hasPhoto,value.getSemanticObject());
        }
        return ret;
    }

    public void addPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
    {
        getSemanticObject().addObjectProperty(swbpress_hasPhoto, value.getSemanticObject());
    }

    public void removeAllPhoto()
    {
        getSemanticObject().removeProperty(swbpress_hasPhoto);
    }

    public void removePhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
    {
        getSemanticObject().removeObjectProperty(swbpress_hasPhoto,value.getSemanticObject());
    }

    public org.semanticwb.portal.resources.sem.pressroom.Photos getPhoto()
    {
         org.semanticwb.portal.resources.sem.pressroom.Photos ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_hasPhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Photos)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Date getStartDate()
    {
        return getSemanticObject().getDateProperty(swbpress_startDate);
    }

    public void setStartDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbpress_startDate, value);
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Files> listFiles()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Files>(getSemanticObject().listObjectProperties(swbpress_hasFile));
    }

    public boolean hasFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbpress_hasFile,value.getSemanticObject());
        }
        return ret;
    }

    public void addFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
    {
        getSemanticObject().addObjectProperty(swbpress_hasFile, value.getSemanticObject());
    }

    public void removeAllFile()
    {
        getSemanticObject().removeProperty(swbpress_hasFile);
    }

    public void removeFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
    {
        getSemanticObject().removeObjectProperty(swbpress_hasFile,value.getSemanticObject());
    }

    public org.semanticwb.portal.resources.sem.pressroom.Files getFile()
    {
         org.semanticwb.portal.resources.sem.pressroom.Files ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_hasFile);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Files)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

    public int getPriority()
    {
        return getSemanticObject().getIntProperty(swbpress_priority);
    }

    public void setPriority(int value)
    {
        getSemanticObject().setIntProperty(swbpress_priority, value);
    }

    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
    }

    public void setCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swbpress_category, value.getSemanticObject());
        }else
        {
            removeCategory();
        }
    }

    public void removeCategory()
    {
        getSemanticObject().removeProperty(swbpress_category);
    }

    public org.semanticwb.portal.resources.sem.pressroom.Category getCategory()
    {
         org.semanticwb.portal.resources.sem.pressroom.Category ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_category);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Category)obj.createGenericInstance();
         }
         return ret;
    }

    public String getContent()
    {
        return getSemanticObject().getProperty(swbpress_content);
    }

    public void setContent(String value)
    {
        getSemanticObject().setProperty(swbpress_content, value);
    }

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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

    public java.util.Date getEndDate()
    {
        return getSemanticObject().getDateProperty(swbpress_endDate);
    }

    public void setEndDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbpress_endDate, value);
    }
}
