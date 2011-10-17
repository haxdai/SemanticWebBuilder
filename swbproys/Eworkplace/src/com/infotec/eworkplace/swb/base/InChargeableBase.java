package com.infotec.eworkplace.swb.base;

public interface InChargeableBase extends org.semanticwb.model.GenericObject
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso. 
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty ewp_incharge=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#incharge");
    public static final org.semanticwb.platform.SemanticClass ewp_InChargeable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#InChargeable");

   /**
   * Sets a value from the property Incharge
   * @param value An instance of org.semanticwb.model.User
   */
    public void setIncharge(org.semanticwb.model.User value);

   /**
   * Remove the value from the property Incharge
   */
    public void removeIncharge();

    public org.semanticwb.model.User getIncharge();
}
