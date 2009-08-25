package org.semanticwb.model.base;


public class RoleBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty swb_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#created");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty swb_modifiedBy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#modifiedBy");
    public static final org.semanticwb.platform.SemanticProperty swb_title=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#title");
    public static final org.semanticwb.platform.SemanticClass swb_RoleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RoleRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRoleRefInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRoleRefInv");
    public static final org.semanticwb.platform.SemanticClass swb_Role=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Role");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRoleChild=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRoleChild");
    public static final org.semanticwb.platform.SemanticProperty swb_updated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#updated");
    public static final org.semanticwb.platform.SemanticClass swb_Permission=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Permission");
    public static final org.semanticwb.platform.SemanticProperty swb_hasPermission=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasPermission");
    public static final org.semanticwb.platform.SemanticProperty swb_creator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#creator");
    public static final org.semanticwb.platform.SemanticProperty swb_description=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#description");
    public static final org.semanticwb.platform.SemanticProperty swb_undeleteable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#undeleteable");
    public static final org.semanticwb.platform.SemanticProperty swb_roleParent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#roleParent");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Role");

    public RoleBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.Role> listRoles(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Role>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.Role> listRoles()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Role>(it, true);
    }

    public static org.semanticwb.model.Role getRole(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.Role)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.Role createRole(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.Role)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeRole(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasRole(String id, org.semanticwb.model.SWBModel model)
    {
        return (getRole(id, model)!=null);
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

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef> listRoleRefInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef>(getSemanticObject().listObjectProperties(swb_hasRoleRefInv));
    }

    public boolean hasRoleRefInv(org.semanticwb.model.RoleRef roleref)
    {
        if(roleref==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasRoleRefInv,roleref.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByRoleRefInv(org.semanticwb.model.RoleRef hasrolerefinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRoleRefInv, hasrolerefinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByRoleRefInv(org.semanticwb.model.RoleRef hasrolerefinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(hasrolerefinv.getSemanticObject().getModel().listSubjects(swb_hasRoleRefInv,hasrolerefinv.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.RoleRef getRoleRefInv()
    {
         org.semanticwb.model.RoleRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRoleRefInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.RoleRef)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> listChilds()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Role>(getSemanticObject().listObjectProperties(swb_hasRoleChild));
    }

    public boolean hasChild(org.semanticwb.model.Role role)
    {
        if(role==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasRoleChild,role.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByChild(org.semanticwb.model.Role hasrolechild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRoleChild, hasrolechild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByChild(org.semanticwb.model.Role hasrolechild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(hasrolechild.getSemanticObject().getModel().listSubjects(swb_hasRoleChild,hasrolechild.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.Role getChild()
    {
         org.semanticwb.model.Role ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRoleChild);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Role)obj.createGenericInstance();
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Permission> listPermissions()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Permission>(getSemanticObject().listObjectProperties(swb_hasPermission));
    }

    public boolean hasPermission(org.semanticwb.model.Permission permission)
    {
        if(permission==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasPermission,permission.getSemanticObject());
    }

    public void addPermission(org.semanticwb.model.Permission value)
    {
        getSemanticObject().addObjectProperty(swb_hasPermission, value.getSemanticObject());
    }

    public void removeAllPermission()
    {
        getSemanticObject().removeProperty(swb_hasPermission);
    }

    public void removePermission(org.semanticwb.model.Permission permission)
    {
        getSemanticObject().removeObjectProperty(swb_hasPermission,permission.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByPermission(org.semanticwb.model.Permission haspermission,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasPermission, haspermission.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByPermission(org.semanticwb.model.Permission haspermission)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(haspermission.getSemanticObject().getModel().listSubjects(swb_hasPermission,haspermission.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.Permission getPermission()
    {
         org.semanticwb.model.Permission ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasPermission);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Permission)obj.createGenericInstance();
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

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
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

    public void setParent(org.semanticwb.model.Role value)
    {
        getSemanticObject().setObjectProperty(swb_roleParent, value.getSemanticObject());
    }

    public void removeParent()
    {
        getSemanticObject().removeProperty(swb_roleParent);
    }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByParent(org.semanticwb.model.Role roleparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_roleParent, roleparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Role> listRoleByParent(org.semanticwb.model.Role roleparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> it=new org.semanticwb.model.GenericIterator(roleparent.getSemanticObject().getModel().listSubjects(swb_roleParent,roleparent.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.Role getParent()
    {
         org.semanticwb.model.Role ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_roleParent);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Role)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.UserRepository getUserRepository()
    {
        return (org.semanticwb.model.UserRepository)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
