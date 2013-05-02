package com.infotec.lodp.swb.base;

public interface CommentableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass lodpcg_Comment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Comment");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasComment");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Commentable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Commentable");

    public org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Comment> listComments();
    public boolean hasComment(com.infotec.lodp.swb.Comment value);

   /**
   * Adds the Comment
   * @param value An instance of com.infotec.lodp.swb.Comment
   */
    public void addComment(com.infotec.lodp.swb.Comment value);

   /**
   * Remove all the values for the property Comment
   */
    public void removeAllComment();

   /**
   * Remove a value from the property Comment
   * @param value An instance of com.infotec.lodp.swb.Comment
   */
    public void removeComment(com.infotec.lodp.swb.Comment value);

/**
* Gets the Comment
* @return a instance of com.infotec.lodp.swb.Comment
*/
    public com.infotec.lodp.swb.Comment getComment();
}
