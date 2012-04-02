package com.infotec.eworkplace.swb.base;

   /**
   * Interfaz utilizada para definir las propiedades del Kit de Nuevo Ingreso 
   */
public interface KitSolicitableBase extends org.semanticwb.model.GenericObject
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso. 
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * Propiedad que almacena el usuario relacionado al Kit de Nuevo Ingreso 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_recursoKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#recursoKit");
   /**
   * Propiedad utilizada para almacenar el tipo de contratación de la persona 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoContratacionKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoContratacionKit");
   /**
   * Propiedad utilizada para almacenar el número de empleado 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_numeroEmpleadoKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numeroEmpleadoKit");
   /**
   * Almacena la adscripción del Kit de Nuevo Ingreso 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_adscripcionKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#adscripcionKit");
   /**
   * Almacena la información del Jefe Inmediato de la persona del Kit de Nuevo Ingreso 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_jefeInmediatoKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#jefeInmediatoKit");
   /**
   * Propiedad utilizada para almacenar la información del perfil asignado 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_perfilAsignado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#perfilAsignado");
   /**
   * Interfaz utilizada para definir las propiedades del Kit de Nuevo Ingreso 
   */
    public static final org.semanticwb.platform.SemanticClass intranet_KitSolicitable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#KitSolicitable");

   /**
   * Sets a value from the property RecursoKit
   * @param value An instance of org.semanticwb.model.User
   */
    public void setRecursoKit(org.semanticwb.model.User value);

   /**
   * Remove the value from the property RecursoKit
   */
    public void removeRecursoKit();

    public org.semanticwb.model.User getRecursoKit();

    public String getTipoContratacionKit();

    public void setTipoContratacionKit(String value);

    public String getNumeroEmpleadoKit();

    public void setNumeroEmpleadoKit(String value);

    public String getAdscripcionKit();

    public void setAdscripcionKit(String value);

    public String getJefeInmediatoKit();

    public void setJefeInmediatoKit(String value);

    public String getPerfilAsignado();

    public void setPerfilAsignado(String value);
}
