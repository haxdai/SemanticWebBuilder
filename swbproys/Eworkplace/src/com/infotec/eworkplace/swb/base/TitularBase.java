package com.infotec.eworkplace.swb.base;

public interface TitularBase extends org.semanticwb.model.GenericObject
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso. 
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_titular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#titular");
    public static final org.semanticwb.platform.SemanticClass intranet_Titular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Titular");

   /**
   * Sets a value from the property Titular
   * @param value An instance of org.semanticwb.model.User
   */
    public void setTitular(org.semanticwb.model.User value);

   /**
   * Remove the value from the property Titular
   */
    public void removeTitular();

    public org.semanticwb.model.User getTitular();
}
