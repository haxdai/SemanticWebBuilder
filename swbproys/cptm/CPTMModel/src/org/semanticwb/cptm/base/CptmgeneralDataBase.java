package org.semanticwb.cptm.base;

   /**
   * Interface cptm 
   */
public interface CptmgeneralDataBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty cptm_photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photo");
   /**
   * Interface cptm 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CptmgeneralData=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#cptmgeneralData");

    public String getPhoto();

    public void setPhoto(String value);
}
