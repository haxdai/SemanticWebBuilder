package org.semanticwb.model.base;


public class UserBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.UserGroupable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.Roleable
{
    public static final org.semanticwb.platform.SemanticClass swb_UserFavorite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserFavorite");
    public static final org.semanticwb.platform.SemanticProperty swb_userFavorite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#userFavorite");
    public static final org.semanticwb.platform.SemanticProperty swb_usrLastName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrLastName");
    public static final org.semanticwb.platform.SemanticProperty swb_active=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#active");
    public static final org.semanticwb.platform.SemanticProperty swb_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#created");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty swb_modifiedBy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#modifiedBy");
    public static final org.semanticwb.platform.SemanticProperty swb_usrSecondLastName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrSecondLastName");
    public static final org.semanticwb.platform.SemanticClass swb_UserGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserGroup");
    public static final org.semanticwb.platform.SemanticProperty swb_hasUserGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasUserGroup");
    public static final org.semanticwb.platform.SemanticProperty swb_usrEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrEmail");
    public static final org.semanticwb.platform.SemanticProperty swb_usrFirstName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrFirstName");
    public static final org.semanticwb.platform.SemanticProperty swb_updated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#updated");
    public static final org.semanticwb.platform.SemanticProperty swb_usrLanguage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrLanguage");
    public static final org.semanticwb.platform.SemanticProperty swb_usrPasswordChanged=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrPasswordChanged");
    public static final org.semanticwb.platform.SemanticClass swb_AdminFilter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#AdminFilter");
    public static final org.semanticwb.platform.SemanticProperty swb_hasAdminFilter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasAdminFilter");
    public static final org.semanticwb.platform.SemanticProperty swb_usrLastLogin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrLastLogin");
    public static final org.semanticwb.platform.SemanticProperty swb_creator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#creator");
    public static final org.semanticwb.platform.SemanticProperty swb_usrPassword=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrPassword");
    public static final org.semanticwb.platform.SemanticProperty swb_usrLogin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrLogin");
    public static final org.semanticwb.platform.SemanticClass swb_Role=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Role");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRole=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRole");
    public static final org.semanticwb.platform.SemanticProperty swb_usrSecurityQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrSecurityQuestion");
    public static final org.semanticwb.platform.SemanticProperty swb_usrSecurityAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#usrSecurityAnswer");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");

    public UserBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.User> listUsers(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.User> listUsers()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(it, true);
    }

    public static org.semanticwb.model.User createUser(org.semanticwb.model.SWBModel model)
    {
        long id=model.getSemanticObject().getModel().getCounter(sclass);
        return org.semanticwb.model.User.createUser(String.valueOf(id), model);
    }

    public static org.semanticwb.model.User getUser(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.User)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.User createUser(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.User)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeUser(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasUser(String id, org.semanticwb.model.SWBModel model)
    {
        return (getUser(id, model)!=null);
    }

    public void setUserFavorite(org.semanticwb.model.UserFavorite userfavorite)
    {
        getSemanticObject().setObjectProperty(swb_userFavorite, userfavorite.getSemanticObject());
    }

    public void removeUserFavorite()
    {
        getSemanticObject().removeProperty(swb_userFavorite);
    }

    public org.semanticwb.model.UserFavorite getUserFavorite()
    {
         org.semanticwb.model.UserFavorite ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_userFavorite);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserFavorite)obj.createGenericInstance();
         }
         return ret;
    }

    public String getLastName()
    {
        return getSemanticObject().getProperty(swb_usrLastName);
    }

    public void setLastName(String usrLastName)
    {
        getSemanticObject().setProperty(swb_usrLastName, usrLastName);
    }

    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

    public void setActive(boolean active)
    {
        getSemanticObject().setBooleanProperty(swb_active, active);
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

    public String getSecondLastName()
    {
        return getSemanticObject().getProperty(swb_usrSecondLastName);
    }

    public void setSecondLastName(String usrSecondLastName)
    {
        getSemanticObject().setProperty(swb_usrSecondLastName, usrSecondLastName);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup> listUserGroups()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroup>(getSemanticObject().listObjectProperties(swb_hasUserGroup));
    }

    public boolean hasUserGroup(org.semanticwb.model.UserGroup usergroup)
    {
        if(usergroup==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasUserGroup,usergroup.getSemanticObject());
    }

    public void addUserGroup(org.semanticwb.model.UserGroup usergroup)
    {
        getSemanticObject().addObjectProperty(swb_hasUserGroup, usergroup.getSemanticObject());
    }

    public void removeAllUserGroup()
    {
        getSemanticObject().removeProperty(swb_hasUserGroup);
    }

    public void removeUserGroup(org.semanticwb.model.UserGroup usergroup)
    {
        getSemanticObject().removeObjectProperty(swb_hasUserGroup,usergroup.getSemanticObject());
    }

    public org.semanticwb.model.UserGroup getUserGroup()
    {
         org.semanticwb.model.UserGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasUserGroup);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserGroup)obj.createGenericInstance();
         }
         return ret;
    }

    public String getEmail()
    {
        return getSemanticObject().getProperty(swb_usrEmail);
    }

    public void setEmail(String usrEmail)
    {
        getSemanticObject().setProperty(swb_usrEmail, usrEmail);
    }

    public String getFirstName()
    {
        return getSemanticObject().getProperty(swb_usrFirstName);
    }

    public void setFirstName(String usrFirstName)
    {
        getSemanticObject().setProperty(swb_usrFirstName, usrFirstName);
    }

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date updated)
    {
        getSemanticObject().setDateProperty(swb_updated, updated);
    }

    public String getLanguage()
    {
        return getSemanticObject().getProperty(swb_usrLanguage);
    }

    public void setLanguage(String usrLanguage)
    {
        getSemanticObject().setProperty(swb_usrLanguage, usrLanguage);
    }

    public java.util.Date getPasswordChanged()
    {
        return getSemanticObject().getDateProperty(swb_usrPasswordChanged);
    }

    public void setPasswordChanged(java.util.Date usrPasswordChanged)
    {
        getSemanticObject().setDateProperty(swb_usrPasswordChanged, usrPasswordChanged);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.AdminFilter> listAdminFilters()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.AdminFilter>(getSemanticObject().listObjectProperties(swb_hasAdminFilter));
    }

    public boolean hasAdminFilter(org.semanticwb.model.AdminFilter adminfilter)
    {
        if(adminfilter==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasAdminFilter,adminfilter.getSemanticObject());
    }

    public void addAdminFilter(org.semanticwb.model.AdminFilter adminfilter)
    {
        getSemanticObject().addObjectProperty(swb_hasAdminFilter, adminfilter.getSemanticObject());
    }

    public void removeAllAdminFilter()
    {
        getSemanticObject().removeProperty(swb_hasAdminFilter);
    }

    public void removeAdminFilter(org.semanticwb.model.AdminFilter adminfilter)
    {
        getSemanticObject().removeObjectProperty(swb_hasAdminFilter,adminfilter.getSemanticObject());
    }

    public org.semanticwb.model.AdminFilter getAdminFilter()
    {
         org.semanticwb.model.AdminFilter ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasAdminFilter);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.AdminFilter)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Date getLastLogin()
    {
        return getSemanticObject().getDateProperty(swb_usrLastLogin);
    }

    public void setLastLogin(java.util.Date usrLastLogin)
    {
        getSemanticObject().setDateProperty(swb_usrLastLogin, usrLastLogin);
    }

    public void setCreator(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(swb_creator, user.getSemanticObject());
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

    public String getPassword()
    {
        //Override this method in User object
        return getSemanticObject().getProperty(swb_usrPassword,false);
    }

    public void setPassword(String usrPassword)
    {
        //Override this method in User object
        getSemanticObject().setProperty(swb_usrPassword, usrPassword,false);
    }

    public String getLogin()
    {
        return getSemanticObject().getProperty(swb_usrLogin);
    }

    public void setLogin(String usrLogin)
    {
        getSemanticObject().setProperty(swb_usrLogin, usrLogin);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> listRoles()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Role>(getSemanticObject().listObjectProperties(swb_hasRole));
    }

    public boolean hasRole(org.semanticwb.model.Role role)
    {
        if(role==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasRole,role.getSemanticObject());
    }

    public void addRole(org.semanticwb.model.Role role)
    {
        getSemanticObject().addObjectProperty(swb_hasRole, role.getSemanticObject());
    }

    public void removeAllRole()
    {
        getSemanticObject().removeProperty(swb_hasRole);
    }

    public void removeRole(org.semanticwb.model.Role role)
    {
        getSemanticObject().removeObjectProperty(swb_hasRole,role.getSemanticObject());
    }

    public org.semanticwb.model.Role getRole()
    {
         org.semanticwb.model.Role ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRole);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Role)obj.createGenericInstance();
         }
         return ret;
    }

    public int getSecurityQuestion()
    {
        return getSemanticObject().getIntProperty(swb_usrSecurityQuestion);
    }

    public void setSecurityQuestion(int usrSecurityQuestion)
    {
        getSemanticObject().setLongProperty(swb_usrSecurityQuestion, usrSecurityQuestion);
    }

    public String getSecurityAnswer()
    {
        return getSemanticObject().getProperty(swb_usrSecurityAnswer);
    }

    public void setSecurityAnswer(String usrSecurityAnswer)
    {
        getSemanticObject().setProperty(swb_usrSecurityAnswer, usrSecurityAnswer);
    }

    public org.semanticwb.model.UserRepository getUserRepository()
    {
        return (org.semanticwb.model.UserRepository)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
