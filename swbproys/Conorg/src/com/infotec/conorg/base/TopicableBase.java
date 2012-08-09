package com.infotec.conorg.base;

public interface TopicableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass conorg_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Topic");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasTopic");
    public static final org.semanticwb.platform.SemanticClass conorg_Topicable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Topicable");

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> listTopics();
    public boolean hasTopic(com.infotec.conorg.Topic value);

   /**
   * Adds the Topic
   * @param value An instance of com.infotec.conorg.Topic
   */
    public void addTopic(com.infotec.conorg.Topic value);

   /**
   * Remove all the values for the property Topic
   */
    public void removeAllTopic();

   /**
   * Remove a value from the property Topic
   * @param value An instance of com.infotec.conorg.Topic
   */
    public void removeTopic(com.infotec.conorg.Topic value);

/**
* Gets the Topic
* @return a instance of com.infotec.conorg.Topic
*/
    public com.infotec.conorg.Topic getTopic();
}
