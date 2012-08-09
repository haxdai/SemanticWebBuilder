package com.infotec.eworkplace.swb.base;


public abstract class SelectOneUserByUserGroupBase extends org.semanticwb.model.SelectOne 
{
    public static final org.semanticwb.platform.SemanticProperty intranet_so_userGroupId=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#so_userGroupId");
    public static final org.semanticwb.platform.SemanticProperty intranet_so_roleIds=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#so_roleIds");
    public static final org.semanticwb.platform.SemanticClass intranet_SelectOneUserByUserGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SelectOneUserByUserGroup");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SelectOneUserByUserGroup");

    public static class ClassMgr
    {
       /**
       * Returns a list of SelectOneUserByUserGroup for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SelectOneUserByUserGroup> listSelectOneUserByUserGroups(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SelectOneUserByUserGroup>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SelectOneUserByUserGroup for all models
       * @return Iterator of com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SelectOneUserByUserGroup> listSelectOneUserByUserGroups()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SelectOneUserByUserGroup>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param id Identifier for com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param model Model of the com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @return A com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       */
        public static com.infotec.eworkplace.swb.SelectOneUserByUserGroup getSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SelectOneUserByUserGroup)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param id Identifier for com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param model Model of the com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @return A com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       */
        public static com.infotec.eworkplace.swb.SelectOneUserByUserGroup createSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SelectOneUserByUserGroup)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param id Identifier for com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param model Model of the com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       */
        public static void removeSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param id Identifier for com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @param model Model of the com.infotec.eworkplace.swb.SelectOneUserByUserGroup
       * @return true if the com.infotec.eworkplace.swb.SelectOneUserByUserGroup exists, false otherwise
       */

        public static boolean hasSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSelectOneUserByUserGroup(id, model)!=null);
        }
    }

   /**
   * Constructs a SelectOneUserByUserGroupBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SelectOneUserByUserGroup
   */
    public SelectOneUserByUserGroupBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the FilterUserGroupId property
* @return String with the FilterUserGroupId
*/
    public String getFilterUserGroupId()
    {
        return getSemanticObject().getProperty(intranet_so_userGroupId);
    }

/**
* Sets the FilterUserGroupId property
* @param value long with the FilterUserGroupId
*/
    public void setFilterUserGroupId(String value)
    {
        getSemanticObject().setProperty(intranet_so_userGroupId, value);
    }

/**
* Gets the FilterRoleIds property
* @return String with the FilterRoleIds
*/
    public String getFilterRoleIds()
    {
        return getSemanticObject().getProperty(intranet_so_roleIds);
    }

/**
* Sets the FilterRoleIds property
* @param value long with the FilterRoleIds
*/
    public void setFilterRoleIds(String value)
    {
        getSemanticObject().setProperty(intranet_so_roleIds, value);
    }
}
