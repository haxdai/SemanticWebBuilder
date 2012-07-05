package com.infotec.conorg.base;


public abstract class MemberBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass conorg_WorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");
    public static final org.semanticwb.platform.SemanticProperty conorg_workspace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#workspace");
    public static final org.semanticwb.platform.SemanticProperty conorg_memberType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#memberType");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty conorg_user=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#user");
    public static final org.semanticwb.platform.SemanticClass conorg_Member=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Member");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Member");

    public static class ClassMgr
    {
       /**
       * Returns a list of Member for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMembers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Member>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Member for all models
       * @return Iterator of com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMembers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Member>(it, true);
        }

        public static com.infotec.conorg.Member createMember(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Member.ClassMgr.createMember(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Member
       * @param id Identifier for com.infotec.conorg.Member
       * @param model Model of the com.infotec.conorg.Member
       * @return A com.infotec.conorg.Member
       */
        public static com.infotec.conorg.Member getMember(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Member)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Member
       * @param id Identifier for com.infotec.conorg.Member
       * @param model Model of the com.infotec.conorg.Member
       * @return A com.infotec.conorg.Member
       */
        public static com.infotec.conorg.Member createMember(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Member)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Member
       * @param id Identifier for com.infotec.conorg.Member
       * @param model Model of the com.infotec.conorg.Member
       */
        public static void removeMember(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Member
       * @param id Identifier for com.infotec.conorg.Member
       * @param model Model of the com.infotec.conorg.Member
       * @return true if the com.infotec.conorg.Member exists, false otherwise
       */

        public static boolean hasMember(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMember(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Member with a determined Workspace
       * @param value Workspace of the type com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.Member
       * @return Iterator with all the com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMemberByWorkspace(com.infotec.conorg.WorkSpace value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_workspace, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Member with a determined Workspace
       * @param value Workspace of the type com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMemberByWorkspace(com.infotec.conorg.WorkSpace value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_workspace,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Member with a determined User
       * @param value User of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Member
       * @return Iterator with all the com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMemberByUser(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_user, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Member with a determined User
       * @param value User of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMemberByUser(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_user,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a MemberBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Member
   */
    public MemberBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Workspace
   * @param value Workspace to set
   */

    public void setWorkspace(com.infotec.conorg.WorkSpace value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_workspace, value.getSemanticObject());
        }else
        {
            removeWorkspace();
        }
    }
   /**
   * Remove the value for Workspace property
   */

    public void removeWorkspace()
    {
        getSemanticObject().removeProperty(conorg_workspace);
    }

   /**
   * Gets the Workspace
   * @return a com.infotec.conorg.WorkSpace
   */
    public com.infotec.conorg.WorkSpace getWorkspace()
    {
         com.infotec.conorg.WorkSpace ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_workspace);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.WorkSpace)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the MemberType property
* @return String with the MemberType
*/
    public String getMemberType()
    {
        return getSemanticObject().getProperty(conorg_memberType);
    }

/**
* Sets the MemberType property
* @param value long with the MemberType
*/
    public void setMemberType(String value)
    {
        getSemanticObject().setProperty(conorg_memberType, value);
    }
   /**
   * Sets the value for the property User
   * @param value User to set
   */

    public void setUser(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_user, value.getSemanticObject());
        }else
        {
            removeUser();
        }
    }
   /**
   * Remove the value for User property
   */

    public void removeUser()
    {
        getSemanticObject().removeProperty(conorg_user);
    }

   /**
   * Gets the User
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUser()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_user);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
