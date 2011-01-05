package org.semanticwb.mask.base;


public abstract class FriendshipProspectBase extends org.semanticwb.mask.UserRelationship 
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty mascara_friendShipRequester=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#friendShipRequester");
    public static final org.semanticwb.platform.SemanticProperty mascara_friendShipRequested=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#friendShipRequested");
    public static final org.semanticwb.platform.SemanticClass mascara_FriendshipProspect=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#FriendshipProspect");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#FriendshipProspect");

    public static class ClassMgr
    {
       /**
       * Returns a list of FriendshipProspect for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspects(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.mask.FriendshipProspect for all models
       * @return Iterator of org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspects()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect>(it, true);
        }

        public static org.semanticwb.mask.FriendshipProspect createFriendshipProspect(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.mask.FriendshipProspect.ClassMgr.createFriendshipProspect(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return A org.semanticwb.mask.FriendshipProspect
       */
        public static org.semanticwb.mask.FriendshipProspect getFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.FriendshipProspect)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return A org.semanticwb.mask.FriendshipProspect
       */
        public static org.semanticwb.mask.FriendshipProspect createFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.FriendshipProspect)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       */
        public static void removeFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return true if the org.semanticwb.mask.FriendshipProspect exists, false otherwise
       */

        public static boolean hasFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFriendshipProspect(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.mask.FriendshipProspect with a determined FriendShipRequester
       * @param value FriendShipRequester of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return Iterator with all the org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspectByFriendShipRequester(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(mascara_friendShipRequester, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.mask.FriendshipProspect with a determined FriendShipRequester
       * @param value FriendShipRequester of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspectByFriendShipRequester(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(mascara_friendShipRequester,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.mask.FriendshipProspect with a determined FriendShipRequested
       * @param value FriendShipRequested of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return Iterator with all the org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspectByFriendShipRequested(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(mascara_friendShipRequested, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.mask.FriendshipProspect with a determined FriendShipRequested
       * @param value FriendShipRequested of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspectByFriendShipRequested(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(mascara_friendShipRequested,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a FriendshipProspectBase with a SemanticObject
   * @param base The SemanticObject with the properties for the FriendshipProspect
   */
    public FriendshipProspectBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property FriendShipRequester
   * @param value FriendShipRequester to set
   */

    public void setFriendShipRequester(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(mascara_friendShipRequester, value.getSemanticObject());
        }else
        {
            removeFriendShipRequester();
        }
    }
   /**
   * Remove the value for FriendShipRequester property
   */

    public void removeFriendShipRequester()
    {
        getSemanticObject().removeProperty(mascara_friendShipRequester);
    }

   /**
   * Gets the FriendShipRequester
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getFriendShipRequester()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(mascara_friendShipRequester);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property FriendShipRequested
   * @param value FriendShipRequested to set
   */

    public void setFriendShipRequested(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(mascara_friendShipRequested, value.getSemanticObject());
        }else
        {
            removeFriendShipRequested();
        }
    }
   /**
   * Remove the value for FriendShipRequested property
   */

    public void removeFriendShipRequested()
    {
        getSemanticObject().removeProperty(mascara_friendShipRequested);
    }

   /**
   * Gets the FriendShipRequested
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getFriendShipRequested()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(mascara_friendShipRequested);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
