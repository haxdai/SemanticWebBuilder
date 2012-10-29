package com.infotec.conorg.base;


public abstract class ColleagueBase extends org.semanticwb.model.UserTypeDef 
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasColleagues=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasColleagues");
    public static final org.semanticwb.platform.SemanticClass conorg_Colleague=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Colleague");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Colleague");

    public static class ClassMgr
    {
       /**
       * Returns a list of Colleague for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Colleague
       */

        public static java.util.Iterator<com.infotec.conorg.Colleague> listColleagues(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Colleague>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Colleague for all models
       * @return Iterator of com.infotec.conorg.Colleague
       */

        public static java.util.Iterator<com.infotec.conorg.Colleague> listColleagues()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Colleague>(it, true);
        }
       /**
       * Gets a com.infotec.conorg.Colleague
       * @param id Identifier for com.infotec.conorg.Colleague
       * @param model Model of the com.infotec.conorg.Colleague
       * @return A com.infotec.conorg.Colleague
       */
        public static com.infotec.conorg.Colleague getColleague(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Colleague)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Colleague
       * @param id Identifier for com.infotec.conorg.Colleague
       * @param model Model of the com.infotec.conorg.Colleague
       * @return A com.infotec.conorg.Colleague
       */
        public static com.infotec.conorg.Colleague createColleague(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Colleague)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Colleague
       * @param id Identifier for com.infotec.conorg.Colleague
       * @param model Model of the com.infotec.conorg.Colleague
       */
        public static void removeColleague(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Colleague
       * @param id Identifier for com.infotec.conorg.Colleague
       * @param model Model of the com.infotec.conorg.Colleague
       * @return true if the com.infotec.conorg.Colleague exists, false otherwise
       */

        public static boolean hasColleague(String id, org.semanticwb.model.SWBModel model)
        {
            return (getColleague(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Colleague with a determined Colleagues
       * @param value Colleagues of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Colleague
       * @return Iterator with all the com.infotec.conorg.Colleague
       */

        public static java.util.Iterator<com.infotec.conorg.Colleague> listColleagueByColleagues(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Colleague> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasColleagues, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Colleague with a determined Colleagues
       * @param value Colleagues of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Colleague
       */

        public static java.util.Iterator<com.infotec.conorg.Colleague> listColleagueByColleagues(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Colleague> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasColleagues,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ColleagueBase.ClassMgr getColleagueClassMgr()
    {
        return new ColleagueBase.ClassMgr();
    }

   /**
   * Constructs a ColleagueBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Colleague
   */
    public ColleagueBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listColleagueses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(conorg_hasColleagues));
    }

   /**
   * Gets true if has a Colleagues
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasColleagues(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasColleagues,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Colleagues
   * @param value org.semanticwb.model.User to add
   */

    public void addColleagues(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(conorg_hasColleagues, value.getSemanticObject());
    }
   /**
   * Removes all the Colleagues
   */

    public void removeAllColleagues()
    {
        getSemanticObject().removeProperty(conorg_hasColleagues);
    }
   /**
   * Removes a Colleagues
   * @param value org.semanticwb.model.User to remove
   */

    public void removeColleagues(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasColleagues,value.getSemanticObject());
    }

   /**
   * Gets the Colleagues
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getColleagues()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasColleagues);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
