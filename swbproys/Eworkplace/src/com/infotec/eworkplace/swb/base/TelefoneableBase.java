package com.infotec.eworkplace.swb.base;

public interface TelefoneableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass intranet_Telefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Telefono");
    public static final org.semanticwb.platform.SemanticProperty intranet_telefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#telefono");
    public static final org.semanticwb.platform.SemanticClass intranet_Telefoneable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Telefoneable");

   /**
   * Sets a value from the property Telefono
   * @param value An instance of com.infotec.eworkplace.swb.Telefono
   */
    public void setTelefono(com.infotec.eworkplace.swb.Telefono value);

   /**
   * Remove the value from the property Telefono
   */
    public void removeTelefono();

    public com.infotec.eworkplace.swb.Telefono getTelefono();
}
