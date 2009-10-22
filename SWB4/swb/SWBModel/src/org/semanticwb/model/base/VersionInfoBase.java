package org.semanticwb.model.base;


public class VersionInfoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static class ClassMgr
    {
       public static final org.semanticwb.platform.SemanticProperty swb_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#created");
       public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
       public static final org.semanticwb.platform.SemanticProperty swb_modifiedBy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#modifiedBy");
       public static final org.semanticwb.platform.SemanticProperty swb_versionValue=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#versionValue");
       public static final org.semanticwb.platform.SemanticClass swb_VersionInfo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#VersionInfo");
       public static final org.semanticwb.platform.SemanticProperty swb_previousVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#previousVersion");
       public static final org.semanticwb.platform.SemanticProperty swb_versionComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#versionComment");
       public static final org.semanticwb.platform.SemanticProperty swb_updated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#updated");
       public static final org.semanticwb.platform.SemanticProperty swb_nextVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#nextVersion");
       public static final org.semanticwb.platform.SemanticProperty swb_versionLockedBy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#versionLockedBy");
       public static final org.semanticwb.platform.SemanticProperty swb_versionFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#versionFile");
       public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
       public static final org.semanticwb.platform.SemanticProperty swb_creator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#creator");
       public static final org.semanticwb.platform.SemanticProperty swb_versionNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#versionNumber");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#VersionInfo");

       public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfos(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfos()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo>(it, true);
       }

       public static org.semanticwb.model.VersionInfo createVersionInfo(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.model.VersionInfo.ClassMgr.createVersionInfo(String.valueOf(id), model);
       }

       public static org.semanticwb.model.VersionInfo getVersionInfo(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.model.VersionInfo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.model.VersionInfo createVersionInfo(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.model.VersionInfo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeVersionInfo(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasVersionInfo(String id, org.semanticwb.model.SWBModel model)
       {
           return (getVersionInfo(id, model)!=null);
       }
    }

    public VersionInfoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(ClassMgr.swb_created);
    }

    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ClassMgr.swb_created, value);
    }

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swb_modifiedBy, value.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(ClassMgr.swb_modifiedBy);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(ClassMgr.swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public String getVersionValue()
    {
        return getSemanticObject().getProperty(ClassMgr.swb_versionValue);
    }

    public void setVersionValue(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swb_versionValue, value);
    }

    public void setPreviousVersion(org.semanticwb.model.VersionInfo value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swb_previousVersion, value.getSemanticObject());
    }

    public void removePreviousVersion()
    {
        getSemanticObject().removeProperty(ClassMgr.swb_previousVersion);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByPreviousVersion(org.semanticwb.model.VersionInfo previousversion,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swb_previousVersion, previousversion.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByPreviousVersion(org.semanticwb.model.VersionInfo previousversion)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(previousversion.getSemanticObject().getModel().listSubjects(ClassMgr.swb_previousVersion,previousversion.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.VersionInfo getPreviousVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swb_previousVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }

    public String getVersionComment()
    {
        return getSemanticObject().getProperty(ClassMgr.swb_versionComment);
    }

    public void setVersionComment(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swb_versionComment, value);
    }

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(ClassMgr.swb_updated);
    }

    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ClassMgr.swb_updated, value);
    }

    public void setNextVersion(org.semanticwb.model.VersionInfo value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swb_nextVersion, value.getSemanticObject());
    }

    public void removeNextVersion()
    {
        getSemanticObject().removeProperty(ClassMgr.swb_nextVersion);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByNextVersion(org.semanticwb.model.VersionInfo nextversion,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swb_nextVersion, nextversion.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByNextVersion(org.semanticwb.model.VersionInfo nextversion)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(nextversion.getSemanticObject().getModel().listSubjects(ClassMgr.swb_nextVersion,nextversion.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.VersionInfo getNextVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swb_nextVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }

    public void setVersionLockedBy(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swb_versionLockedBy, value.getSemanticObject());
    }

    public void removeVersionLockedBy()
    {
        getSemanticObject().removeProperty(ClassMgr.swb_versionLockedBy);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByVersionLockedBy(org.semanticwb.model.User versionlockedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swb_versionLockedBy, versionlockedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByVersionLockedBy(org.semanticwb.model.User versionlockedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(versionlockedby.getSemanticObject().getModel().listSubjects(ClassMgr.swb_versionLockedBy,versionlockedby.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getVersionLockedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swb_versionLockedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public String getVersionFile()
    {
        return getSemanticObject().getProperty(ClassMgr.swb_versionFile);
    }

    public void setVersionFile(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swb_versionFile, value);
    }

    public void setCreator(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swb_creator, value.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(ClassMgr.swb_creator);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(ClassMgr.swb_creator,creator.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public int getVersionNumber()
    {
        return getSemanticObject().getIntProperty(ClassMgr.swb_versionNumber);
    }

    public void setVersionNumber(int value)
    {
        getSemanticObject().setIntProperty(ClassMgr.swb_versionNumber, value);
    }

    public org.semanticwb.model.WebSite getWebSite()
    {
        return (org.semanticwb.model.WebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
