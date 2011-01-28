package org.semanticwb.cptm.base;

   /**
   * Interface cptm 
   */
public interface CptmgeneralDataBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty cptm_photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photo");
   /**
   * Fotos para mostrar del destino 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasMorePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasMorePhoto");
    public static final org.semanticwb.platform.SemanticProperty cptm_photoEscudo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoEscudo");
   /**
   * Interface cptm 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CptmgeneralData=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#cptmgeneralData");

    public String getPhoto();

    public void setPhoto(String value);

    public java.util.Iterator<String> listMorePhotos();

    public void addMorePhoto(String value);
    public void removeAllMorePhoto();
    public void removeMorePhoto(String value);

    public String getPhotoEscudo();

    public void setPhotoEscudo(String value);
}
