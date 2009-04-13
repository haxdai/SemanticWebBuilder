/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.DisplayProperty;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebSite;
import org.semanticwb.office.interfaces.PropertyInfo;
import org.semanticwb.office.interfaces.RepositoryInfo;
import org.semanticwb.office.interfaces.SiteInfo;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticIterator;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.repository.office.OfficeCategory;
import org.semanticwb.repository.office.OfficeContent;
import org.semanticwb.repository.office.OfficeDocument;

/**
 *
 * @author victor.lorenzana
 */
public class SWBOfficeManager implements OfficeManager
{

    private final SWBRepositoryManager manager;
    private static final String DESCRIPTION_BY_DEFAULT = "Sin descripción";
    private static final String LANGUAGE_BY_DEFAULT = "es";
    private static Logger log = SWBUtils.getLogger(SWBOfficeManager.class);
    private final SemanticClass cm_content = OfficeContent.office_OfficeContent;

    public SWBOfficeManager(SWBRepositoryManager manager)
    {
        log.event("Initializing SWBOfficeManager ...");
        this.manager = manager;
        HashMap<String, String> types = getContentTypes();
        for (String type : types.keySet())
        {
            log.event("Type of office content " + type + " " + types.get(type));
        }
    }

    public HashMap<String, String> getContentTypes()
    {
        HashMap<String, String> types = new HashMap<String, String>();

        String label = DESCRIPTION_BY_DEFAULT + "(" + cm_content.getPrefix() + ":" + cm_content.getName() + ")";
        String literal = cm_content.getDisplayName(LANGUAGE_BY_DEFAULT);
        if (literal != null)
        {
            label = literal;
        }
        types.put(cm_content.getPrefix() + ":" + cm_content.getName(), label);
        Iterator<SemanticClass> childClases = cm_content.listSubClasses();
        while (childClases.hasNext())
        {
            SemanticClass clazz = childClases.next();
            label = DESCRIPTION_BY_DEFAULT + "(" + clazz.getPrefix() + ":" + clazz.getName() + ")";
            literal = clazz.getDisplayName(LANGUAGE_BY_DEFAULT);
            if (literal != null)
            {
                label = literal;
            }
            types.put(clazz.getPrefix() + ":" + clazz.getName(), label);
        }
        return types;
    }

    public String getCategoryType()
    {
        return OfficeCategory.office_OfficeCategory.getPrefix() + ":" + OfficeCategory.office_OfficeCategory.getName();
    }

    public String getPropertyTitleType()
    {
        return OfficeCategory.office_title.getPrefix() + ":" + OfficeCategory.office_title.getName();
    }

    public String getPropertyDescriptionType()
    {
        return OfficeCategory.office_description.getPrefix() + ":" + OfficeCategory.office_description.getName();
    }

    public String getPropertyFileType()
    {
        return OfficeDocument.office_file.getPrefix() + ":" + OfficeDocument.office_file.getName();
    }

    public String getPropertyType()
    {
        return OfficeContent.office_officetype.getPrefix() + ":" + OfficeContent.office_officetype.getName();
    }

    public String getUserType()
    {
        return OfficeDocument.office_user.getPrefix() + ":" + OfficeDocument.office_user.getName();
    }

    public Collection<RepositoryInfo> getWorkspaces()
    {
        HashMap<String, RepositoryInfo> workspaces = new HashMap<String, RepositoryInfo>();
        Iterator<WebSite> sites = SWBContext.listWebSites();
        while (sites.hasNext())
        {
            WebSite site = sites.next();
            SemanticIterator<SemanticObject> models = site.listSubModels();
            while (models.hasNext())
            {
                SemanticObject model = models.next();
                if (model.getSemanticClass().equals(Workspace.sclass) || model.getSemanticClass().isSubClass(Workspace.sclass))
                {
                    String name = model.getId() + "@" + manager.getName();
                    RepositoryInfo info = new RepositoryInfo(name);
                    info.exclusive = true;
                    info.siteInfo = new SiteInfo();
                    info.siteInfo.description = site.getDescription();
                    info.siteInfo.title = site.getTitle();
                    info.siteInfo.id = site.getId();
                    workspaces.put(name, info);
                }
            }
        }
        // Shared
        for (String repository : manager.getWorkspaces())
        {
            String name = repository + "@" + manager.getName();
            if (!workspaces.containsKey(name))
            {
                RepositoryInfo info = new RepositoryInfo(name);
                info.exclusive = false;
                workspaces.put(name, info);
            }
        }
        return workspaces.values();
    }

    private SemanticClass getSemanticClass(String type)
    {
        SemanticClass getSemanticClass = null;
        String stype = cm_content.getPrefix() + ":" + cm_content.getName();
        if (stype.equals(type))
        {
            return cm_content;

        }
        else
        {
            Iterator<SemanticClass> classes = cm_content.listSubClasses();
            while (classes.hasNext())
            {
                SemanticClass subclazz = classes.next();
                stype = subclazz.getPrefix() + ":" + subclazz.getName();
                if (stype.equals(type))
                {
                    return subclazz;
                }
            }
        }
        return null;
    }

    private boolean isSuperProperty(SemanticProperty prop, SemanticClass clazz)
    {
        Iterator<SemanticClass> classes = clazz.listSuperClasses();
        while (classes.hasNext())
        {
            SemanticClass superClazz = classes.next();
            if (superClazz.isSWBClass())
            {
                Iterator<SemanticProperty> propertiesClazz = superClazz.listProperties();
                while (propertiesClazz.hasNext())
                {
                    SemanticProperty propSuperClazz = propertiesClazz.next();
                    if (propSuperClazz.getURI().equals(prop.getURI()))
                    {
                        return true;
                    }
                    else
                    {
                        boolean res = isSuperProperty(prop, superClazz);
                        if (res == true)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public PropertyInfo[] getContentProperties(String type)
    {
        ArrayList<PropertyInfo> properties = new ArrayList<PropertyInfo>();
        SemanticClass clazz = getSemanticClass(type);
        if (clazz != null)
        {
            Iterator<SemanticProperty> propertiesClazz = clazz.listProperties();
            while (propertiesClazz.hasNext())
            {
                SemanticProperty prop = propertiesClazz.next();

                if (prop.isDataTypeProperty() && !prop.isBinary() && prop.getPrefix() != null)
                {

                    SemanticObject displayObj = prop.getDisplayProperty();
                    if (displayObj != null)
                    {
                        DisplayProperty propDisplay = new DisplayProperty(displayObj);
                        if (!propDisplay.isHidden())
                        {
                            PropertyInfo info = new PropertyInfo();
                            info.id = prop.getPrefix() + ":" + prop.getName();
                            info.isRequired = prop.isRequired();
                            info.title = prop.getDisplayName();
                            if (prop.isString())
                            {
                                info.type = "String";
                                properties.add(info);
                            }
                            else if (prop.isBoolean())
                            {
                                info.type = "Boolean";
                                properties.add(info);
                            }
                            else if (prop.isInt())
                            {
                                info.type = "Integer";
                                properties.add(info);
                            }
                        }
                    }
                }
            }
        }
        return properties.toArray(new PropertyInfo[properties.size()]);
    }

    public void validateContentValues(PropertyInfo[] properties, Object[] values, String type) throws Exception
    {
        SemanticClass clazz = getSemanticClass(type);
        if (clazz != null)
        {
            for (PropertyInfo prop : properties)
            {
                Iterator<SemanticProperty> propertiesClazz = clazz.listProperties();
                while (propertiesClazz.hasNext())
                {
                    SemanticProperty property = propertiesClazz.next();
                    if (property.getPrefix() != null)
                    {
                        String name = property.getPrefix() + ":" + property.getName();
                        if (name.equals(prop.id))
                        {
                        }
                    }

                }
            }
        }
    }
}
