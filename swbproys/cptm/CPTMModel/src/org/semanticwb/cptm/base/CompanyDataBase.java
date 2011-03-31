package org.semanticwb.cptm.base;

   /**
   * Interface para datos generales de Cadenas, Marcas y Empresas 
   */
public interface CompanyDataBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyLine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyLine");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompanyLine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompanyLine");
    public static final org.semanticwb.platform.SemanticClass cptm_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Promotion");
   /**
   * Promociones de la Compañia 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasPromotion");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompLocality");
   /**
   * Interface para datos generales de Cadenas, Marcas y Empresas 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyData=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyData");

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyLine> listCompanyLines();
    public boolean hasCompanyLine(org.semanticwb.cptm.CompanyLine value);

   /**
   * Adds the CompanyLine
   * @param value An instance of org.semanticwb.cptm.CompanyLine
   */
    public void addCompanyLine(org.semanticwb.cptm.CompanyLine value);

   /**
   * Remove all the values for the property CompanyLine
   */
    public void removeAllCompanyLine();

   /**
   * Remove a value from the property CompanyLine
   * @param value An instance of org.semanticwb.cptm.CompanyLine
   */
    public void removeCompanyLine(org.semanticwb.cptm.CompanyLine value);

/**
* Gets the CompanyLine
* @return a instance of org.semanticwb.cptm.CompanyLine
*/
    public org.semanticwb.cptm.CompanyLine getCompanyLine();

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> listPromotions();
    public boolean hasPromotion(org.semanticwb.cptm.Promotion value);

   /**
   * Adds the Promotion
   * @param value An instance of org.semanticwb.cptm.Promotion
   */
    public void addPromotion(org.semanticwb.cptm.Promotion value);

   /**
   * Remove all the values for the property Promotion
   */
    public void removeAllPromotion();

   /**
   * Remove a value from the property Promotion
   * @param value An instance of org.semanticwb.cptm.Promotion
   */
    public void removePromotion(org.semanticwb.cptm.Promotion value);

/**
* Gets the Promotion
* @return a instance of org.semanticwb.cptm.Promotion
*/
    public org.semanticwb.cptm.Promotion getPromotion();

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listCompLocalities();
    public boolean hasCompLocality(org.semanticwb.cptm.LocalityInt value);

   /**
   * Adds the CompLocality
   * @param value An instance of org.semanticwb.cptm.LocalityInt
   */
    public void addCompLocality(org.semanticwb.cptm.LocalityInt value);

   /**
   * Remove all the values for the property CompLocality
   */
    public void removeAllCompLocality();

   /**
   * Remove a value from the property CompLocality
   * @param value An instance of org.semanticwb.cptm.LocalityInt
   */
    public void removeCompLocality(org.semanticwb.cptm.LocalityInt value);

/**
* Gets the CompLocality
* @return a instance of org.semanticwb.cptm.LocalityInt
*/
    public org.semanticwb.cptm.LocalityInt getCompLocality();
}
