package com.infotec.conorg.base;


public abstract class AccessLevelBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty conorg_permission=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#permission");
    public static final org.semanticwb.platform.SemanticClass conorg_AccessLevel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#AccessLevel");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#AccessLevel");

    public static class ClassMgr
    {
       /**
       * Returns a list of AccessLevel for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.AccessLevel
       */

        public static java.util.Iterator<com.infotec.conorg.AccessLevel> listAccessLevels(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.AccessLevel>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.AccessLevel for all models
       * @return Iterator of com.infotec.conorg.AccessLevel
       */

        public static java.util.Iterator<com.infotec.conorg.AccessLevel> listAccessLevels()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.AccessLevel>(it, true);
        }

        public static com.infotec.conorg.AccessLevel createAccessLevel(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.AccessLevel.ClassMgr.createAccessLevel(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.AccessLevel
       * @param id Identifier for com.infotec.conorg.AccessLevel
       * @param model Model of the com.infotec.conorg.AccessLevel
       * @return A com.infotec.conorg.AccessLevel
       */
        public static com.infotec.conorg.AccessLevel getAccessLevel(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.AccessLevel)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.AccessLevel
       * @param id Identifier for com.infotec.conorg.AccessLevel
       * @param model Model of the com.infotec.conorg.AccessLevel
       * @return A com.infotec.conorg.AccessLevel
       */
        public static com.infotec.conorg.AccessLevel createAccessLevel(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.AccessLevel)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.AccessLevel
       * @param id Identifier for com.infotec.conorg.AccessLevel
       * @param model Model of the com.infotec.conorg.AccessLevel
       */
        public static void removeAccessLevel(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.AccessLevel
       * @param id Identifier for com.infotec.conorg.AccessLevel
       * @param model Model of the com.infotec.conorg.AccessLevel
       * @return true if the com.infotec.conorg.AccessLevel exists, false otherwise
       */

        public static boolean hasAccessLevel(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAccessLevel(id, model)!=null);
        }
    }

   /**
   * Constructs a AccessLevelBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AccessLevel
   */
    public AccessLevelBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Permission property
* @return String with the Permission
*/
    public String getPermission()
    {
        return getSemanticObject().getProperty(conorg_permission);
    }

/**
* Sets the Permission property
* @param value long with the Permission
*/
    public void setPermission(String value)
    {
        getSemanticObject().setProperty(conorg_permission, value);
    }
}
