package com.infotec.lodp.swb.base;


public abstract class CommentBase extends org.semanticwb.model.base.GenericObjectBase implements com.infotec.lodp.swb.Approveable
{
    public static final org.semanticwb.platform.SemanticProperty lodp_inappropriate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#inappropriate");
    public static final org.semanticwb.platform.SemanticProperty lodp_comment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#comment");
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticProperty lodp_commUserEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#commUserEmail");
    public static final org.semanticwb.platform.SemanticProperty lodp_commVisible=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#commVisible");
    public static final org.semanticwb.platform.SemanticProperty lodp_commUserName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#commUserName");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Comment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Comment");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Comment");

    public static class ClassMgr
    {
       /**
       * Returns a list of Comment for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Comment
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Comment> listComments(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Comment>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Comment for all models
       * @return Iterator of com.infotec.lodp.swb.Comment
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Comment> listComments()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Comment>(it, true);
        }

        public static com.infotec.lodp.swb.Comment createComment(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Comment.ClassMgr.createComment(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Comment
       * @param id Identifier for com.infotec.lodp.swb.Comment
       * @param model Model of the com.infotec.lodp.swb.Comment
       * @return A com.infotec.lodp.swb.Comment
       */
        public static com.infotec.lodp.swb.Comment getComment(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Comment)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Comment
       * @param id Identifier for com.infotec.lodp.swb.Comment
       * @param model Model of the com.infotec.lodp.swb.Comment
       * @return A com.infotec.lodp.swb.Comment
       */
        public static com.infotec.lodp.swb.Comment createComment(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Comment)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Comment
       * @param id Identifier for com.infotec.lodp.swb.Comment
       * @param model Model of the com.infotec.lodp.swb.Comment
       */
        public static void removeComment(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Comment
       * @param id Identifier for com.infotec.lodp.swb.Comment
       * @param model Model of the com.infotec.lodp.swb.Comment
       * @return true if the com.infotec.lodp.swb.Comment exists, false otherwise
       */

        public static boolean hasComment(String id, org.semanticwb.model.SWBModel model)
        {
            return (getComment(id, model)!=null);
        }
    }

    public static CommentBase.ClassMgr getCommentClassMgr()
    {
        return new CommentBase.ClassMgr();
    }

   /**
   * Constructs a CommentBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Comment
   */
    public CommentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Approved property
* @return boolean with the Approved
*/
    public boolean isApproved()
    {
        return getSemanticObject().getBooleanProperty(lodp_approved);
    }

/**
* Sets the Approved property
* @param value long with the Approved
*/
    public void setApproved(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_approved, value);
    }

/**
* Gets the Inappropriate property
* @return int with the Inappropriate
*/
    public int getInappropriate()
    {
        return getSemanticObject().getIntProperty(lodp_inappropriate);
    }

/**
* Sets the Inappropriate property
* @param value long with the Inappropriate
*/
    public void setInappropriate(int value)
    {
        getSemanticObject().setIntProperty(lodp_inappropriate, value);
    }

/**
* Gets the Comment property
* @return String with the Comment
*/
    public String getComment()
    {
        return getSemanticObject().getProperty(lodp_comment);
    }

/**
* Sets the Comment property
* @param value long with the Comment
*/
    public void setComment(String value)
    {
        getSemanticObject().setProperty(lodp_comment, value);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in Comment object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in Comment object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

/**
* Gets the Reviewed property
* @return boolean with the Reviewed
*/
    public boolean isReviewed()
    {
        return getSemanticObject().getBooleanProperty(lodp_reviewed);
    }

/**
* Sets the Reviewed property
* @param value long with the Reviewed
*/
    public void setReviewed(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_reviewed, value);
    }

/**
* Gets the CommUserEmail property
* @return String with the CommUserEmail
*/
    public String getCommUserEmail()
    {
        return getSemanticObject().getProperty(lodp_commUserEmail);
    }

/**
* Sets the CommUserEmail property
* @param value long with the CommUserEmail
*/
    public void setCommUserEmail(String value)
    {
        getSemanticObject().setProperty(lodp_commUserEmail, value);
    }

/**
* Gets the CommVisible property
* @return boolean with the CommVisible
*/
    public boolean isCommVisible()
    {
        return getSemanticObject().getBooleanProperty(lodp_commVisible);
    }

/**
* Sets the CommVisible property
* @param value long with the CommVisible
*/
    public void setCommVisible(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_commVisible, value);
    }

/**
* Gets the CommUserName property
* @return String with the CommUserName
*/
    public String getCommUserName()
    {
        return getSemanticObject().getProperty(lodp_commUserName);
    }

/**
* Sets the CommUserName property
* @param value long with the CommUserName
*/
    public void setCommUserName(String value)
    {
        getSemanticObject().setProperty(lodp_commUserName, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
