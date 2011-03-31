package org.semanticwb.cptm.base;

   /**
   * Interface cptm 
   */
public interface CptmgeneralDataBase extends org.semanticwb.model.GenericObject
{
   /**
   * Nombre del autor de la foto principal 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_photoAuthor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoAuthor");
   /**
   * Campo para capturar algún texto alterno para la foto, este es localizado 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_photoAlt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoAlt");
    public static final org.semanticwb.platform.SemanticProperty cptm_photoEscudo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoEscudo");
    public static final org.semanticwb.platform.SemanticProperty cptm_photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photo");
   /**
   * Texto alterno para imagen de Escudo, localizable 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_photoEscudoAlt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#photoEscudoAlt");
   /**
   * Clase generica para fotos 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Photo");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasMorePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasMorePhoto");
   /**
   * Interface cptm 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CptmgeneralData=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#cptmgeneralData");

    public String getPhotoAuthor();

    public void setPhotoAuthor(String value);

    public String getPhotoAlt();

    public void setPhotoAlt(String value);

    public String getPhotoAlt(String lang);

    public String getDisplayPhotoAlt(String lang);

    public void setPhotoAlt(String photoAlt, String lang);

    public String getPhotoEscudo();

    public void setPhotoEscudo(String value);

    public String getPhoto();

    public void setPhoto(String value);

    public String getPhotoEscudoAlt();

    public void setPhotoEscudoAlt(String value);

    public String getPhotoEscudoAlt(String lang);

    public String getDisplayPhotoEscudoAlt(String lang);

    public void setPhotoEscudoAlt(String photoEscudoAlt, String lang);

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo> listMorePhotos();
    public boolean hasMorePhoto(org.semanticwb.cptm.Photo value);

   /**
   * Adds the MorePhoto
   * @param value An instance of org.semanticwb.cptm.Photo
   */
    public void addMorePhoto(org.semanticwb.cptm.Photo value);

   /**
   * Remove all the values for the property MorePhoto
   */
    public void removeAllMorePhoto();

   /**
   * Remove a value from the property MorePhoto
   * @param value An instance of org.semanticwb.cptm.Photo
   */
    public void removeMorePhoto(org.semanticwb.cptm.Photo value);

/**
* Gets the MorePhoto
* @return a instance of org.semanticwb.cptm.Photo
*/
    public org.semanticwb.cptm.Photo getMorePhoto();
}
