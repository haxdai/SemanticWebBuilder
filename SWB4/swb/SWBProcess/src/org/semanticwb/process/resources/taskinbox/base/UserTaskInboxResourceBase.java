package org.semanticwb.process.resources.taskinbox.base;


public abstract class UserTaskInboxResourceBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticProperty utinbox_itemsPerPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/process/resources/UserTaskInbox#itemsPerPage");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticProperty utinbox_displayCols=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/process/resources/UserTaskInbox#displayCols");
    public static final org.semanticwb.platform.SemanticClass utinbox_UserTaskInboxResource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/process/resources/UserTaskInbox#UserTaskInboxResource");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/process/resources/UserTaskInbox#UserTaskInboxResource");

    public UserTaskInboxResourceBase()
    {
    }

   /**
   * Constructs a UserTaskInboxResourceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UserTaskInboxResource
   */
    public UserTaskInboxResourceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /*
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() 
    {
        return getSemanticObject().hashCode();
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) 
    {
        if(obj==null)return false;
        return hashCode()==obj.hashCode();
    }

/**
* Gets the ItemsPerPage property
* @return int with the ItemsPerPage
*/
    public int getItemsPerPage()
    {
        return getSemanticObject().getIntProperty(utinbox_itemsPerPage);
    }

/**
* Sets the ItemsPerPage property
* @param value long with the ItemsPerPage
*/
    public void setItemsPerPage(int value)
    {
        getSemanticObject().setIntProperty(utinbox_itemsPerPage, value);
    }
   /**
   * Sets the value for the property Resource
   * @param value Resource to set
   */

    public void setResource(org.semanticwb.model.Resource value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_semanticResourceInv, value.getSemanticObject());
        }else
        {
            removeResource();
        }
    }
   /**
   * Remove the value for Resource property
   */

    public void removeResource()
    {
        getSemanticObject().removeProperty(swb_semanticResourceInv);
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_semanticResourceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DisplayCols property
* @return String with the DisplayCols
*/
    public String getDisplayCols()
    {
        return getSemanticObject().getProperty(utinbox_displayCols);
    }

/**
* Sets the DisplayCols property
* @param value long with the DisplayCols
*/
    public void setDisplayCols(String value)
    {
        getSemanticObject().setProperty(utinbox_displayCols, value);
    }
}
