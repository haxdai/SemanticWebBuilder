package org.semanticwb.model.base;


public class VersionInfoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
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
    public static final org.semanticwb.platform.SemanticProperty swb_creator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#creator");
    public static final org.semanticwb.platform.SemanticProperty swb_versionNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#versionNumber");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#VersionInfo");

    public VersionInfoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

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
        return org.semanticwb.model.VersionInfo.createVersionInfo(String.valueOf(id), model);
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

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

    public void setCreated(java.util.Date created)
    {
        getSemanticObject().setDateProperty(swb_created, created);
    }

    public void setModifiedBy(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(swb_modifiedBy, user.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
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

    public String getVersionValue()
    {
        return getSemanticObject().getProperty(swb_versionValue);
    }

    public void setVersionValue(String versionValue)
    {
        getSemanticObject().setProperty(swb_versionValue, versionValue);
    }

    public void setPreviousVersion(org.semanticwb.model.VersionInfo versioninfo)
    {
        getSemanticObject().setObjectProperty(swb_previousVersion, versioninfo.getSemanticObject());
    }

    public void removePreviousVersion()
    {
        getSemanticObject().removeProperty(swb_previousVersion);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByPreviousVersion(org.semanticwb.model.VersionInfo previousversion,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_previousVersion, previousversion.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByPreviousVersion(org.semanticwb.model.VersionInfo previousversion)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(previousversion.getSemanticObject().getModel().listSubjects(swb_previousVersion,previousversion.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.VersionInfo getPreviousVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_previousVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }

    public String getVersionComment()
    {
        return getSemanticObject().getProperty(swb_versionComment);
    }

    public void setVersionComment(String versionComment)
    {
        getSemanticObject().setProperty(swb_versionComment, versionComment);
    }

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date updated)
    {
        getSemanticObject().setDateProperty(swb_updated, updated);
    }

    public void setNextVersion(org.semanticwb.model.VersionInfo versioninfo)
    {
        getSemanticObject().setObjectProperty(swb_nextVersion, versioninfo.getSemanticObject());
    }

    public void removeNextVersion()
    {
        getSemanticObject().removeProperty(swb_nextVersion);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByNextVersion(org.semanticwb.model.VersionInfo nextversion,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_nextVersion, nextversion.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByNextVersion(org.semanticwb.model.VersionInfo nextversion)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(nextversion.getSemanticObject().getModel().listSubjects(swb_nextVersion,nextversion.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.VersionInfo getNextVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_nextVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }

    public void setVersionLockedBy(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(swb_versionLockedBy, user.getSemanticObject());
    }

    public void removeVersionLockedBy()
    {
        getSemanticObject().removeProperty(swb_versionLockedBy);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByVersionLockedBy(org.semanticwb.model.User versionlockedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_versionLockedBy, versionlockedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByVersionLockedBy(org.semanticwb.model.User versionlockedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(versionlockedby.getSemanticObject().getModel().listSubjects(swb_versionLockedBy,versionlockedby.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getVersionLockedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_versionLockedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public String getVersionFile()
    {
        return getSemanticObject().getProperty(swb_versionFile);
    }

    public void setVersionFile(String versionFile)
    {
        getSemanticObject().setProperty(swb_versionFile, versionFile);
    }

    public void setCreator(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(swb_creator, user.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfoByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.VersionInfo> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
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

    public int getVersionNumber()
    {
        return getSemanticObject().getIntProperty(swb_versionNumber);
    }

    public void setVersionNumber(int versionNumber)
    {
        getSemanticObject().setIntProperty(swb_versionNumber, versionNumber);
    }

    public org.semanticwb.model.WebSite getWebSite()
    {
        return (org.semanticwb.model.WebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
