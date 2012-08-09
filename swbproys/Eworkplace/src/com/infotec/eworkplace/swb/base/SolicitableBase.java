package com.infotec.eworkplace.swb.base;

public interface SolicitableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_extensionSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#extensionSolicitante");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso. 
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_usuarioAutoriza=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#usuarioAutoriza");
    public static final org.semanticwb.platform.SemanticProperty intranet_autoriza=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autoriza");
    public static final org.semanticwb.platform.SemanticProperty intranet_numeroEmpleado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numeroEmpleado");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaSolicita=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaSolicita");
    public static final org.semanticwb.platform.SemanticProperty intranet_cargoSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cargoSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_adscripcionSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#adscripcionSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_folio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folio");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreSolicitante");
    public static final org.semanticwb.platform.SemanticClass intranet_Solicitable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Solicitable");

    public String getExtensionSolicitante();

    public void setExtensionSolicitante(String value);

   /**
   * Sets a value from the property UsuarioAutoriza
   * @param value An instance of org.semanticwb.model.User
   */
    public void setUsuarioAutoriza(org.semanticwb.model.User value);

   /**
   * Remove the value from the property UsuarioAutoriza
   */
    public void removeUsuarioAutoriza();

    public org.semanticwb.model.User getUsuarioAutoriza();

    public String getAutoriza();

    public void setAutoriza(String value);

    public int getNumeroEmpleado();

    public void setNumeroEmpleado(int value);

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

    public java.util.Date getFechaSolicita();

    public void setFechaSolicita(java.util.Date value);

    public String getCargoSolicitante();

    public void setCargoSolicitante(String value);

    public String getAdscripcionSolicitante();

    public void setAdscripcionSolicitante(String value);

    public String getFolio();

    public void setFolio(String value);

    public String getNombreSolicitante();

    public void setNombreSolicitante(String value);
}
