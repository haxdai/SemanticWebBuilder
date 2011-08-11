package com.infotec.conorg.base;


public abstract class MemberPermissionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass conorg_WorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");
    public static final org.semanticwb.platform.SemanticProperty conorg_workSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#workSpace");
    public static final org.semanticwb.platform.SemanticClass conorg_AccessLevel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#AccessLevel");
    public static final org.semanticwb.platform.SemanticProperty conorg_accessLevel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#accessLevel");
    public static final org.semanticwb.platform.SemanticClass conorg_MemberPermission=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#MemberPermission");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#MemberPermission");

    public static class ClassMgr
    {
       /**
       * Returns a list of MemberPermission for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.MemberPermission
       */

        public static java.util.Iterator<com.infotec.conorg.MemberPermission> listMemberPermissions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.MemberPermission for all models
       * @return Iterator of com.infotec.conorg.MemberPermission
       */

        public static java.util.Iterator<com.infotec.conorg.MemberPermission> listMemberPermissions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission>(it, true);
        }

        public static com.infotec.conorg.MemberPermission createMemberPermission(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.MemberPermission.ClassMgr.createMemberPermission(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.MemberPermission
       * @param id Identifier for com.infotec.conorg.MemberPermission
       * @param model Model of the com.infotec.conorg.MemberPermission
       * @return A com.infotec.conorg.MemberPermission
       */
        public static com.infotec.conorg.MemberPermission getMemberPermission(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.MemberPermission)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.MemberPermission
       * @param id Identifier for com.infotec.conorg.MemberPermission
       * @param model Model of the com.infotec.conorg.MemberPermission
       * @return A com.infotec.conorg.MemberPermission
       */
        public static com.infotec.conorg.MemberPermission createMemberPermission(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.MemberPermission)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.MemberPermission
       * @param id Identifier for com.infotec.conorg.MemberPermission
       * @param model Model of the com.infotec.conorg.MemberPermission
       */
        public static void removeMemberPermission(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.MemberPermission
       * @param id Identifier for com.infotec.conorg.MemberPermission
       * @param model Model of the com.infotec.conorg.MemberPermission
       * @return true if the com.infotec.conorg.MemberPermission exists, false otherwise
       */

        public static boolean hasMemberPermission(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMemberPermission(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.MemberPermission with a determined WorkSpace
       * @param value WorkSpace of the type com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.MemberPermission
       * @return Iterator with all the com.infotec.conorg.MemberPermission
       */

        public static java.util.Iterator<com.infotec.conorg.MemberPermission> listMemberPermissionByWorkSpace(com.infotec.conorg.WorkSpace value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_workSpace, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.MemberPermission with a determined WorkSpace
       * @param value WorkSpace of the type com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.MemberPermission
       */

        public static java.util.Iterator<com.infotec.conorg.MemberPermission> listMemberPermissionByWorkSpace(com.infotec.conorg.WorkSpace value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_workSpace,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.MemberPermission with a determined AccessLevel
       * @param value AccessLevel of the type com.infotec.conorg.AccessLevel
       * @param model Model of the com.infotec.conorg.MemberPermission
       * @return Iterator with all the com.infotec.conorg.MemberPermission
       */

        public static java.util.Iterator<com.infotec.conorg.MemberPermission> listMemberPermissionByAccessLevel(com.infotec.conorg.AccessLevel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_accessLevel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.MemberPermission with a determined AccessLevel
       * @param value AccessLevel of the type com.infotec.conorg.AccessLevel
       * @return Iterator with all the com.infotec.conorg.MemberPermission
       */

        public static java.util.Iterator<com.infotec.conorg.MemberPermission> listMemberPermissionByAccessLevel(com.infotec.conorg.AccessLevel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_accessLevel,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a MemberPermissionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the MemberPermission
   */
    public MemberPermissionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property WorkSpace
   * @param value WorkSpace to set
   */

    public void setWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_workSpace, value.getSemanticObject());
        }else
        {
            removeWorkSpace();
        }
    }
   /**
   * Remove the value for WorkSpace property
   */

    public void removeWorkSpace()
    {
        getSemanticObject().removeProperty(conorg_workSpace);
    }

   /**
   * Gets the WorkSpace
   * @return a com.infotec.conorg.WorkSpace
   */
    public com.infotec.conorg.WorkSpace getWorkSpace()
    {
         com.infotec.conorg.WorkSpace ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_workSpace);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.WorkSpace)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property AccessLevel
   * @param value AccessLevel to set
   */

    public void setAccessLevel(com.infotec.conorg.AccessLevel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_accessLevel, value.getSemanticObject());
        }else
        {
            removeAccessLevel();
        }
    }
   /**
   * Remove the value for AccessLevel property
   */

    public void removeAccessLevel()
    {
        getSemanticObject().removeProperty(conorg_accessLevel);
    }

   /**
   * Gets the AccessLevel
   * @return a com.infotec.conorg.AccessLevel
   */
    public com.infotec.conorg.AccessLevel getAccessLevel()
    {
         com.infotec.conorg.AccessLevel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_accessLevel);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.AccessLevel)obj.createGenericInstance();
         }
         return ret;
    }
}
