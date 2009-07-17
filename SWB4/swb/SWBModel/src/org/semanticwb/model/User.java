package org.semanticwb.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Date;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.base.*;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.platform.SemanticVocabulary;

public class User extends UserBase implements Principal
{

    static Logger log = SWBUtils.getLogger(User.class);
    private Device device = null;
    private String ip = null;
    private boolean login = false;

    public User(SemanticObject base)
    {
        super(base);
    }

    public String getName()
    {
        return getLogin();
    }

    @Override
    public void setPassword(String password)
    {
        //System.out.println("setPassword:"+password);
        String tmpPasswd = null;
        try
        {
            tmpPasswd = SWBUtils.CryptoWrapper.passwordDigest(password);
            //System.out.println("tmpPasswd:"+tmpPasswd);
            super.setPassword(tmpPasswd);
            setPasswordChanged(new Date());
        } catch (Exception ex)
        //NoSuchAlgorithmException & UnsupportedEncodingException,
        //Wrapped up, it doesn't matter which one, we just can't do anything else
        {
            log.error("User: Can't set a crypted Password", ex);
        }
    }

    public Device getDevice()
    {
        return device;
    }

    public void setDevice(Device device)
    {
        this.device = device;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public boolean isSigned()
    {
        return login;
    }

    public boolean isRegistered()
    {
        return !(getSemanticObject().isVirtual());
    }

    public void checkCredential(Object credential) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        if (getUserRepository().isExternal())
        {
            this.login = getUserRepository().getBridge().validateCredential(getLogin(), credential);
        } else
        {
            this.login = getPassword().equals(SWBUtils.CryptoWrapper.comparablePassword(new String((char[]) credential)));
        }

    }

    public void setUserTypeAttribute(String userType, String name, Object value) throws SWBException
    {
        SemanticProperty prop = null;
        Iterator<SemanticClass> itsc = getSemanticObject().listSemanticClasses();
        SemanticClass current = null;
        while (itsc.hasNext())
        {
            current = itsc.next();
            if (current.getName().equals(userType))
            {
                break;
            }
        }
        if (current.getName().equals(userType))
        {
            prop = current.getProperty(name);
        }
        setExtendedAttribute(prop, value);
    }

    public void setExtendedAttribute(String name, Object value) throws SWBException
    {
        SemanticProperty prop = getSemanticObject().getSemanticClass().getProperty(name);
        if (null == prop)
        {
            prop = getSemanticObject().getModel().getSemanticProperty(getUserRepository().getId() + "#" + name);
        }
        setExtendedAttribute(prop, value);
    }

    public void setExtendedAttribute(SemanticProperty prop, Object value) throws SWBException
    {
        if (null == value)
        {
            throw new SWBException("Can't set a null value");
        }
        if (null != prop && null != prop.getRange())
        {
            if (SemanticVocabulary.XMLS_BOOLEAN.equals(prop.getRange().toString()))
            {
                if (value instanceof Boolean)
                {
                    getSemanticObject().setBooleanProperty(prop, ((Boolean) value).booleanValue());
                } else
                {
                    throw new SWBException("Boolean is not equal to " + value.getClass());
                }
            }
            if (SemanticVocabulary.XMLS_STRING.equals(prop.getRange().toString()))
            {
                if (value instanceof String)
                {
                    getSemanticObject().setProperty(prop, (String) value);
                } else
                {
                    throw new SWBException("String is not equal to " + value.getClass());
                }
            }
            if (SemanticVocabulary.XMLS_INT.equals(prop.getRange().toString()))
            {
                if (value instanceof Integer)
                {
                    getSemanticObject().setIntProperty(prop, ((Integer) value).intValue());
                } else
                {
                    throw new SWBException("Integer is not equal to " + value.getClass());
                }
            }
            if (SemanticVocabulary.XMLS_LONG.equals(prop.getRange().toString()))
            {
                if (value instanceof Long)
                {
                    getSemanticObject().setLongProperty(prop, ((Long) value).longValue());
                } else
                {
                    throw new SWBException("Long is not equal to " + value.getClass());
                }
            }
            if (SemanticVocabulary.XMLS_DATETIME.equals(prop.getRange().toString()))
            {
                if (value instanceof java.util.Date)
                {
                    getSemanticObject().setDateProperty(prop, (java.util.Date) value);
                } else
                {
                    throw new SWBException("java.util.Date is not equal to " + value.getClass());
                }
            }
            if (SemanticVocabulary.XMLS_FLOAT.equals(prop.getRange().toString()))
            {
                if (value instanceof Float)
                {
                    getSemanticObject().setFloatProperty(prop, ((Float) value).floatValue());
                } else
                {
                    throw new SWBException("Float is not equal to " + value.getClass());
                }
            }
            if (SemanticVocabulary.XMLS_DOUBLE.equals(prop.getRange().toString()))
            {
                if (value instanceof Double)
                {
                    getSemanticObject().setDoubleProperty(prop, ((Double) value).doubleValue());
                } else
                {
                    throw new SWBException(" is not equal to " + value.getClass());
                }
            }
        }
    }

    public Object getExtendedAttribute(String name)
    {
        SemanticProperty prop = getSemanticObject().getSemanticClass().getProperty(name);
        if (null == prop)
        {
            prop = new SemanticProperty(getSemanticObject().getModel().getRDFModel().getProperty(getUserRepository().getId() + "#" + name));
        }

        return getExtendedAttribute(prop);
    }

    public String getFullName()
    {
        String fn = getFirstName();
        if (fn == null)
        {
            fn = "";
        }
        String ln = getLastName();
        if (ln == null)
        {
            ln = "";
        } else
        {
            ln = " " + ln;
        }
        String sln = getSecondLastName();
        if (sln == null)
        {
            sln = "";
        } else
        {
            sln = " " + sln;
        }
        return fn + ln + sln;
    }

    public Object getExtendedAttribute(SemanticProperty prop)
    {
        Object obj = null;
        if (null != prop && null != prop.getRange())
        {
            if (SemanticVocabulary.XMLS_BOOLEAN.equals(prop.getRange().toString()))
            {
                obj = Boolean.valueOf(getSemanticObject().getBooleanProperty(prop));
            }
            if (SemanticVocabulary.XMLS_STRING.equals(prop.getRange().toString()))
            {
                obj = getSemanticObject().getProperty(prop);
            }
            if (SemanticVocabulary.XMLS_INT.equals(prop.getRange().toString()))
            {
                obj = Integer.valueOf(getSemanticObject().getIntProperty(prop));
            }
            if (SemanticVocabulary.XMLS_LONG.equals(prop.getRange().toString()))
            {
                obj = Long.valueOf(getSemanticObject().getLongProperty(prop));
            }
            if (SemanticVocabulary.XMLS_DATETIME.equals(prop.getRange().toString()))
            {
                obj = getSemanticObject().getDateProperty(prop);
            }
            if (SemanticVocabulary.XMLS_FLOAT.equals(prop.getRange().toString()))
            {
                obj = new Float(getSemanticObject().getFloatProperty(prop));
            }
            if (SemanticVocabulary.XMLS_DOUBLE.equals(prop.getRange().toString()))
            {
                obj = new Double(getSemanticObject().getDoubleProperty(prop));
            }
        }
        return obj;
    }

    public void removeExtendedAttribute(String name) throws SWBException
    {
        SemanticProperty prop = getSemanticObject().getSemanticClass().getProperty(name);
        removeExtendedAttribute(prop);
    }

    public void removeExtendedAttribute(SemanticProperty prop) throws SWBException
    {
        if (null != prop && null != prop.getRange())
        {
            getSemanticObject().removeProperty(prop);
        } else
        {
            throw new SWBException("Property null or maybe not an extended attribute");
        }
    }
    /*
    public void addUserType(String userType)
    {
    if (null!=userType && !"".equals(userType.trim()) && !hasUserType(userType))
    {
    getSemanticObject().addSemanticClass(getUserRepository().getUserType(userType));
    }
    }

    public void removeUserType(String userType)
    {
    if (hasUserType(userType))
    {
    getSemanticObject().removeSemanticClass(getUserRepository().getUserType(userType));
    }
    }

    public boolean hasUserType(String userType)
    {
    Iterator<SemanticClass> itse = getSemanticObject().listSemanticClasses();
    SemanticClass current = null;
    while (itse.hasNext())
    {
    current = itse.next();
    if (userType.equals(current.getName()))
    {
    break;
    }
    }
    return userType.equals(current.getName());
    }
     */

    public boolean hasUserType(String userType)
    {
        boolean ret = false;
        Iterator<String> its = this.listUserTypes();
        while (its.hasNext())
        {
            String currUT = its.next();
            if (currUT.equals(userType))
            {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public boolean hasFavorite(SemanticObject obj)
    {
        boolean ret = false;
        UserFavorite fav = getUserFavorite();
        if (fav != null)
        {
            ret = fav.getSemanticObject().hasObjectProperty(fav.swb_usrfHasObject, obj);
        }
        return ret;
    }

    public boolean haveAccess(GenericObject obj)
    {
        //System.out.println(this+" haveAccess:"+obj);
        boolean ret = true;
        if (obj instanceof RoleRefable)
        {
            Iterator<RoleRef> it = ((RoleRefable) obj).listInheritRoleRefs();
            while (it.hasNext())
            {
                RoleRef ref = it.next();
                //System.out.println("ref:"+ref+" role:"+ref.getRole());
                if (!hasRole(ref.getRole()))
                {
                    ret = false;
                    //System.out.println("hasRole:false");
                    break;
                }
            }
        }
        if (ret && obj instanceof RuleRefable)
        {
            Iterator<RuleRef> it = ((RuleRefable) obj).listInheritRuleRefs();
            while (it.hasNext())
            {
                RuleRef ref = it.next();
                //System.out.println("ref:"+ref+" role:"+ref.getRole());
                Rule rule = ref.getRule();
                if (rule != null)
                {
                    ret = Rule.getRuleMgr().eval(this, rule.getURI());
                    if (!ret)
                    {
                        break;
                    }
                }
            }
        }
        if (ret && obj instanceof UserGroupRefable)
        {
            Iterator<UserGroupRef> it = ((UserGroupRefable) obj).listInheritUserGroupRefs();
            while (it.hasNext())
            {
                UserGroupRef ref = it.next();
                //System.out.println("ref:"+ref+" role:"+ref.getRole());
                UserGroup usrgrp = ref.getUserGroup();
                if (!hasUserGroup(usrgrp))
                {
                    ret = false;
                    break;
                }
            }
        }
        //System.out.println("User:"+this+" haveAccess:"+obj+" "+ret);
        return ret;
    }

    @Override
    public boolean hasRole(Role role)
    {
        boolean ret = false;
        while (role != null)
        {
            if (super.hasRole(role))
            {
                ret = true;
                break;
            } else
            {
                role = role.getParent();
            }
        }
        return ret;
    }

    public boolean hasDevice(Device device)
    {
        boolean ret = false;
        Device act = getDevice();
        //System.out.println(act+" "+device);
        if (act != null)
        {
            while (act != null)
            {
                if (device == act)
                {
                    ret = true;
                    break;
                } else
                {
                    act = act.getParent();
                }
            }
        }
        return ret;
    }

    @Override
    public boolean hasUserGroup(UserGroup group)
    {
        boolean ret = false;
        Iterator<UserGroup> grpit = listUserGroups();
        while (grpit.hasNext())
        {
            UserGroup grp = grpit.next();
            while (grp != null)
            {
                if (grp.equals(group))
                {
                    ret = true;
                    break;
                } else
                {
                    grp = grp.getParent();
                }
            }
        }
        return ret;
    }
}
