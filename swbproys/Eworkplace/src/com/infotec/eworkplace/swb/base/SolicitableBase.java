package com.infotec.eworkplace.swb.base;

public interface SolicitableBase extends org.semanticwb.model.GenericObject
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso. 
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitante");
    public static final org.semanticwb.platform.SemanticClass intranet_Solicitable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Solicitable");

   /**
   * Sets a value from the property Solicitante
   * @param value An instance of org.semanticwb.model.User
   */
    public void setSolicitante(org.semanticwb.model.User value);

   /**
   * Remove the value from the property Solicitante
   */
    public void removeSolicitante();

    public org.semanticwb.model.User getSolicitante();
}
