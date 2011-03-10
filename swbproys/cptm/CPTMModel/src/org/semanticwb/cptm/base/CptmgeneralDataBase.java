package org.semanticwb.cptm.base;

   /**
   * Interface cptm 
   */
public interface CptmgeneralDataBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty cptm_photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photo");
   /**
   * Texto alterno para imagen de Escudo, localizable 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_photoEscudoAlt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoEscudoAlt");
   /**
   * Nombre del autor de la foto principal 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_photoAuthor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoAuthor");
   /**
   * Campo para capturar algún texto alterno para la foto, este es localizado 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_photoAlt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoAlt");
   /**
   * Fotos 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasMorePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasMorePhoto");
    public static final org.semanticwb.platform.SemanticProperty cptm_photoEscudo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoEscudo");
   /**
   * Interface cptm 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CptmgeneralData=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#cptmgeneralData");

    public String getPhoto();

    public void setPhoto(String value);

    public String getPhotoEscudoAlt();

    public void setPhotoEscudoAlt(String value);

    public String getPhotoEscudoAlt(String lang);

    public String getDisplayPhotoEscudoAlt(String lang);

    public void setPhotoEscudoAlt(String photoEscudoAlt, String lang);

    public String getPhotoAuthor();

    public void setPhotoAuthor(String value);

    public String getPhotoAlt();

    public void setPhotoAlt(String value);

    public String getPhotoAlt(String lang);

    public String getDisplayPhotoAlt(String lang);

    public void setPhotoAlt(String photoAlt, String lang);

    public java.util.Iterator<String> listMorePhotos();

    public void addMorePhoto(String value);
    public void removeAllMorePhoto();
    public void removeMorePhoto(String value);

    public String getPhotoEscudo();

    public void setPhotoEscudo(String value);
}
