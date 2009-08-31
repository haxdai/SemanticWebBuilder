package org.semanticwb.model.base;


public class UserGroupBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Filterable
{
    public static final org.semanticwb.platform.SemanticClass swb_UserGroupable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserGroupable");
    public static final org.semanticwb.platform.SemanticProperty swb_hasGroupedUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasGroupedUser");
    public static final org.semanticwb.platform.SemanticClass swb_UserGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserGroup");
    public static final org.semanticwb.platform.SemanticProperty swb_usrgrpParent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrgrpParent");
    public static final org.semanticwb.platform.SemanticProperty swb_hasUsrGrpChild=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasUsrGrpChild");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserGroup");

    public UserGroupBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroups(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroups()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup>(it, true);
    }

    public static org.semanticwb.model.UserGroup getUserGroup(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.UserGroup)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.UserGroup createUserGroup(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.UserGroup)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeUserGroup(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasUserGroup(String id, org.semanticwb.model.SWBModel model)
    {
        return (getUserGroup(id, model)!=null);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupable> listUsers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupable>(getSemanticObject().listObjectProperties(swb_hasGroupedUser));
    }

    public boolean hasUser(org.semanticwb.model.UserGroupable usergroupable)
    {
        if(usergroupable==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasGroupedUser,usergroupable.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByUser(org.semanticwb.model.UserGroupable hasgroupeduser,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasGroupedUser, hasgroupeduser.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByUser(org.semanticwb.model.UserGroupable hasgroupeduser)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(hasgroupeduser.getSemanticObject().getModel().listSubjects(swb_hasGroupedUser,hasgroupeduser.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.UserGroupable getUser()
    {
         org.semanticwb.model.UserGroupable ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasGroupedUser);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserGroupable)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
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

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

    public void setParent(org.semanticwb.model.UserGroup value)
    {
        getSemanticObject().setObjectProperty(swb_usrgrpParent, value.getSemanticObject());
    }

    public void removeParent()
    {
        getSemanticObject().removeProperty(swb_usrgrpParent);
    }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByParent(org.semanticwb.model.UserGroup usrgrpparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_usrgrpParent, usrgrpparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByParent(org.semanticwb.model.UserGroup usrgrpparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(usrgrpparent.getSemanticObject().getModel().listSubjects(swb_usrgrpParent,usrgrpparent.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.UserGroup getParent()
    {
         org.semanticwb.model.UserGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_usrgrpParent);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserGroup)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> listChilds()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup>(getSemanticObject().listObjectProperties(swb_hasUsrGrpChild));
    }

    public boolean hasChild(org.semanticwb.model.UserGroup usergroup)
    {
        if(usergroup==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasUsrGrpChild,usergroup.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByChild(org.semanticwb.model.UserGroup hasusrgrpchild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasUsrGrpChild, hasusrgrpchild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByChild(org.semanticwb.model.UserGroup hasusrgrpchild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(hasusrgrpchild.getSemanticObject().getModel().listSubjects(swb_hasUsrGrpChild,hasusrgrpchild.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.UserGroup getChild()
    {
         org.semanticwb.model.UserGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasUsrGrpChild);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserGroup)obj.createGenericInstance();
         }
         return ret;
    }

    public void setCreator(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.UserGroup> listUserGroupByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
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

    public boolean isUndeleteable()
    {
        return getSemanticObject().getBooleanProperty(swb_undeleteable);
    }

    public void setUndeleteable(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_undeleteable, value);
    }

    public org.semanticwb.model.UserRepository getUserRepository()
    {
        return (org.semanticwb.model.UserRepository)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
