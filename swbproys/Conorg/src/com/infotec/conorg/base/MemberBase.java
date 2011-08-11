package com.infotec.conorg.base;


public abstract class MemberBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty conorg_memberType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#memberType");
    public static final org.semanticwb.platform.SemanticClass conorg_MemberPermission=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#MemberPermission");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasMemberPermission=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasMemberPermission");
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
       * Gets all com.infotec.conorg.Member with a determined MemberPermission
       * @param value MemberPermission of the type com.infotec.conorg.MemberPermission
       * @param model Model of the com.infotec.conorg.Member
       * @return Iterator with all the com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMemberByMemberPermission(com.infotec.conorg.MemberPermission value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasMemberPermission, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Member with a determined MemberPermission
       * @param value MemberPermission of the type com.infotec.conorg.MemberPermission
       * @return Iterator with all the com.infotec.conorg.Member
       */

        public static java.util.Iterator<com.infotec.conorg.Member> listMemberByMemberPermission(com.infotec.conorg.MemberPermission value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasMemberPermission,value.getSemanticObject(),sclass));
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
   * Gets all the com.infotec.conorg.MemberPermission
   * @return A GenericIterator with all the com.infotec.conorg.MemberPermission
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission> listMemberPermissions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.MemberPermission>(getSemanticObject().listObjectProperties(conorg_hasMemberPermission));
    }

   /**
   * Gets true if has a MemberPermission
   * @param value com.infotec.conorg.MemberPermission to verify
   * @return true if the com.infotec.conorg.MemberPermission exists, false otherwise
   */
    public boolean hasMemberPermission(com.infotec.conorg.MemberPermission value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasMemberPermission,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a MemberPermission
   * @param value com.infotec.conorg.MemberPermission to add
   */

    public void addMemberPermission(com.infotec.conorg.MemberPermission value)
    {
        getSemanticObject().addObjectProperty(conorg_hasMemberPermission, value.getSemanticObject());
    }
   /**
   * Removes all the MemberPermission
   */

    public void removeAllMemberPermission()
    {
        getSemanticObject().removeProperty(conorg_hasMemberPermission);
    }
   /**
   * Removes a MemberPermission
   * @param value com.infotec.conorg.MemberPermission to remove
   */

    public void removeMemberPermission(com.infotec.conorg.MemberPermission value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasMemberPermission,value.getSemanticObject());
    }

   /**
   * Gets the MemberPermission
   * @return a com.infotec.conorg.MemberPermission
   */
    public com.infotec.conorg.MemberPermission getMemberPermission()
    {
         com.infotec.conorg.MemberPermission ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasMemberPermission);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.MemberPermission)obj.createGenericInstance();
         }
         return ret;
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
