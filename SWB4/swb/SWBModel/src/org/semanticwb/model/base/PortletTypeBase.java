package org.semanticwb.model.base;

import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import org.semanticwb.model.*;
import com.hp.hpl.jena.rdf.model.*;
import org.semanticwb.*;
import org.semanticwb.platform.*;
import org.semanticwb.model.GenericIterator;

public class PortletTypeBase extends SWBClass implements Descriptiveable,Traceable
{

    public PortletTypeBase(SemanticObject base)
    {
        super(base);
    }

    public Date getCreated()
    {
        return getSemanticObject().getDateProperty(vocabulary.swb_created);
    }

    public void setCreated(Date created)
    {
        getSemanticObject().setDateProperty(vocabulary.swb_created, created);
    }

    public void setModifiedBy(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(vocabulary.swb_modifiedBy, user.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(vocabulary.swb_modifiedBy);
    }

    public User getModifiedBy()
    {
         User ret=null;
         SemanticObject obj=getSemanticObject().getObjectProperty(vocabulary.swb_modifiedBy);
         if(obj!=null)
         {
             ret=(User)obj.getSemanticClass().newGenericInstance(obj);
         }
         return ret;
    }

    public String getPortletBundle()
    {
        return getSemanticObject().getProperty(vocabulary.swb_portletBundle);
    }

    public void setPortletBundle(String portletBundle)
    {
        getSemanticObject().setProperty(vocabulary.swb_portletBundle, portletBundle);
    }

    public int getPortletCache()
    {
        return getSemanticObject().getIntProperty(vocabulary.swb_portletCache);
    }

    public void setPortletCache(int portletCache)
    {
        getSemanticObject().setLongProperty(vocabulary.swb_portletCache, portletCache);
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(vocabulary.swb_title);
    }

    public void setTitle(String title)
    {
        getSemanticObject().setProperty(vocabulary.swb_title, title);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(vocabulary.swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(vocabulary.swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(vocabulary.swb_title, title, lang);
    }

    public String getPortletClassName()
    {
        return getSemanticObject().getProperty(vocabulary.swb_portletClassName);
    }

    public void setPortletClassName(String portletClassName)
    {
        getSemanticObject().setProperty(vocabulary.swb_portletClassName, portletClassName);
    }

    public GenericIterator<org.semanticwb.model.Portlet> listPortlets()
    {
        StmtIterator stit=getSemanticObject().getModel().getRDFModel().listStatements(null, vocabulary.swb_hasPTPortlet.getInverse().getRDFProperty(), getSemanticObject().getRDFResource());
        return new GenericIterator<org.semanticwb.model.Portlet>(org.semanticwb.model.Portlet.class, stit,true);
    }

    public Portlet getPortlet()
    {
         Portlet ret=null;
         SemanticObject obj=getSemanticObject().getObjectProperty(vocabulary.swb_hasPTPortlet);
         if(obj!=null)
         {
             ret=(Portlet)obj.getSemanticClass().newGenericInstance(obj);
         }
         return ret;
    }

    public Date getUpdated()
    {
        return getSemanticObject().getDateProperty(vocabulary.swb_updated);
    }

    public void setUpdated(Date updated)
    {
        getSemanticObject().setDateProperty(vocabulary.swb_updated, updated);
    }

    public int getPortletMode()
    {
        return getSemanticObject().getIntProperty(vocabulary.swb_portletMode);
    }

    public void setPortletMode(int portletMode)
    {
        getSemanticObject().setLongProperty(vocabulary.swb_portletMode, portletMode);
    }

    public GenericIterator<org.semanticwb.model.PortletSubType> listSubTypes()
    {
        StmtIterator stit=getSemanticObject().getModel().getRDFModel().listStatements(null, vocabulary.swb_hasPTSubType.getInverse().getRDFProperty(), getSemanticObject().getRDFResource());
        return new GenericIterator<org.semanticwb.model.PortletSubType>(org.semanticwb.model.PortletSubType.class, stit,true);
    }

    public PortletSubType getSubType()
    {
         PortletSubType ret=null;
         SemanticObject obj=getSemanticObject().getObjectProperty(vocabulary.swb_hasPTSubType);
         if(obj!=null)
         {
             ret=(PortletSubType)obj.getSemanticClass().newGenericInstance(obj);
         }
         return ret;
    }

    public void setCreator(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(vocabulary.swb_creator, user.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(vocabulary.swb_creator);
    }

    public User getCreator()
    {
         User ret=null;
         SemanticObject obj=getSemanticObject().getObjectProperty(vocabulary.swb_creator);
         if(obj!=null)
         {
             ret=(User)obj.getSemanticClass().newGenericInstance(obj);
         }
         return ret;
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(vocabulary.swb_description);
    }

    public void setDescription(String description)
    {
        getSemanticObject().setProperty(vocabulary.swb_description, description);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(vocabulary.swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(vocabulary.swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(vocabulary.swb_description, description, lang);
    }

    public WebSite getWebSite()
    {
        return new WebSite(getSemanticObject().getModel().getModelObject());
    }
}
