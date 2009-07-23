/*
 * PortletDefinition.java
 *
 * Created on 22 de agosto de 2005, 01:33 PM
 */
package org.semanticwb.portal.portlet;

import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.io.InputStream;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;



/**
 *
 * @author Javier Solis Gonzalez
 */
public interface WBPortletDefinition
{
    /**
     * Getter for property id.
     * @return Value of property id.
     */
    public String getId();
    
    /**
     * Getter for property site.
     * @return Value of property site.
     */
    public java.lang.String getSite();
    
    /**
     * Returns the class name
     *
     * @return the class name
     */
    public String getClassName();
    
    /**
     * Getter for property context.
     * @return Value of property context.
     */
    public java.lang.String getContext();
    
    /**
     * Getter for property portletName.
     * @return Value of property portletName.
     */
    public java.lang.String getName();
    
    /**
     * Getter for property portlet.
     * @return Value of property portlet.
     */
    public javax.portlet.Portlet getPortlet();
    
    /**
     * Setter for property portlet.
     * @param portlet New value of property portlet.
     */
    public void setPortlet(javax.portlet.Portlet portlet);
    
    /**
     * Returns the description for the given locale
     * The return value may be NULL.
     *
     * @return the description
     */
    
    //    public Description getDescription(Locale locale);
    
    /**
     * Returns all resource information of this portlet
     *
     * @return the portlet resources
     */
    
    //    public LanguageSet getLanguageSet();
    
    /**
     * Returns all parameters of this portlet
     * The return value cannot be NULL.
     *
     * @return the parameter set
     */
    
    //    public ParameterSet getInitParameterSet();
    
    /**
     * Returns all SecurityRoleRefs of this portlet
     *
     * @return the SecurityRoleRef set
     */
    
    //    public SecurityRoleRefSet getInitSecurityRoleRefSet();
    
    /**
     * Returns all preferences of this portlet
     *
     * @return the preference set
     */
    
    //    public PreferenceSet getPreferenceSet();
    
    /**
     * Returns all supported content types of this portlet
     *
     * @return the content type set
     */
    
    //    public ContentTypeSet getContentTypeSet();
    
    /**
     * Returns the PortletApplication object in which this portlet resides
     * The return value cannot be NULL.
     *
     * @return the PortletApplication object of this portlet
     */
    
    //    public PortletApplicationDefinition getPortletApplicationDefinition();
    
    /**
     * Returns the corresponding servlet to this portlet
     * The return value cannot be NULL.
     *
     * @return a servlet object
     */
    
    //    public ServletDefinition getServletDefinition();
    
    /**
     * Returns the display name of this portlet for the given locale.
     * The return value may be NULL.
     *
     * @return display name for the given locale
     */
    
    //    public DisplayName getDisplayName(Locale locale);
    
    /**
     * Returns duration (in seconds) of expiration cache
     *
     * @return duration of expiration cache
     */
    
    //    public String getExpirationCache();
    
    /**
     * Returns the class loader of the portlet
     * The return value may be NULL
     * if the class loader is not yet available.
     *
     * @return java.util.ClassLoader
     */
    public ClassLoader getPortletClassLoader();
    
    public void setPortletClassLoader(java.lang.ClassLoader portletClassLoader);
    
    /**
     * Getter for property servletConfig.
     * @return Value of property servletConfig.
     */
    public javax.servlet.ServletConfig getServletConfig();
    
    /**
     * Setter for property servletConfig.
     * @param servletConfig New value of property servletConfig.
     */
    public void setServletConfig(javax.servlet.ServletConfig servletConfig);
    
    /**
     * Getter for property portletConfig.
     * @return Value of property portletConfig.
     */
    public javax.portlet.PortletConfig getPortletConfig();
    
    /**
     * Setter for property portletConfig.
     * @param portletConfig New value of property portletConfig.
     */
    public void setPortletConfig(javax.portlet.PortletConfig portletConfig);
    
    /**
     * Getter for property resourceBundle.
     * @return Value of property resourceBundle.
     */
    public java.lang.String getResourceBundleString();
    
    public java.util.ResourceBundle getResourceBundle(Locale locale);
    
    public List getSupportedLocales();
    
    public Hashtable getInitParams();
    
    /**
     * Getter for property defaultPreferences.
     * @return Value of property defaultPreferences.
     */
    public PortletPreferences getDefaultPreferences();
    
    /**
     * Getter for property preferencesValidator.
     * @return Value of property preferencesValidator.
     */
    public PreferencesValidator getPreferencesValidator();
    
    public Hashtable getPortletRoles();
    
    public void loadDefinition(InputStream in);
    
    /**
     * Getter for property support.
     * @return Value of property support.
     */
    public PortletModesSupport getPortletModesSupport();
}
