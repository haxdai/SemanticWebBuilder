package org.semanticwb.cptm.base;

public interface VideoableBase extends org.semanticwb.model.GenericObject
{
   /**
   * Id de video de youtube 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_videoyoutube=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#videoyoutube");
    public static final org.semanticwb.platform.SemanticClass cptm_Videoable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#videoable");

    public String getVideoyoutube();

    public void setVideoyoutube(String value);
}
