package org.semanticwb.cptm.base;

   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional 
   */
public interface LocalityIntBase extends org.semanticwb.model.GenericObject
{
   /**
   * Catálogo de Noticias 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#New");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasNewGeographicPointInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasNewGeographicPointInv");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefLocalityInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefLocalityInv");
    public static final org.semanticwb.platform.SemanticProperty cptm_latitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#latitude");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
   /**
   * Cercanias 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasProximity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasProximity");
    public static final org.semanticwb.platform.SemanticProperty cptm_longitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#longitude");
   /**
   * Catalogo de Atractivos Generales (Playa, Ruinas Arqueologicas, etc). Administrado desde una colección. Los Destinos tendran este tipo de atributos 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeneralAttractive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeneralAttractive");
   /**
   * Atributos Generales que tiene un Destino (Playa, Ruinas Arqueologicas, etc). Del Catalogo del objeto GeneralAttractive 
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasGeneralAttribute=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasGeneralAttribute");
   /**
   * Notas Editoriales 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EditNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasLocalityEditNoteInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasLocalityEditNoteInv");
   /**
   * Clase que se encarga de administrar el catálogo de Actividades (Buceo, Pesca, etc) 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasActLocalityInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasActLocalityInv");
   /**
   * Clase que se encarga de manejar el catálogo de "Rutas de Viaje" (Ej. Ruta del Vino, Ruta Morelos, etc) 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelRoute=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRoute");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasTravelRouteInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasTravelRouteInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos. 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Event");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEventGeographicPointInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEventGeographicPointInv");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");
    public static final org.semanticwb.platform.SemanticProperty cptm_ExpLocalityInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#ExpLocalityInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias (Ej. Bodas, Parejas) 
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasExperienceLocalityInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasExperienceLocalityInv");

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New> listNewGeographicPointInvs();
    public boolean hasNewGeographicPointInv(org.semanticwb.cptm.New value);

   /**
   * Sets a value from the property ArefLocalityInv
   * @param value An instance of org.semanticwb.cptm.ActivityRef
   */
    public void setArefLocalityInv(org.semanticwb.cptm.ActivityRef value);

   /**
   * Remove the value from the property ArefLocalityInv
   */
    public void removeArefLocalityInv();

    public org.semanticwb.cptm.ActivityRef getArefLocalityInv();

    public double getLatitude();

    public void setLatitude(double value);

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listProximities();
    public boolean hasProximity(org.semanticwb.cptm.LocalityInt value);

   /**
   * Adds the Proximity
   * @param value An instance of org.semanticwb.cptm.LocalityInt
   */
    public void addProximity(org.semanticwb.cptm.LocalityInt value);

   /**
   * Remove all the values for the property Proximity
   */
    public void removeAllProximity();

   /**
   * Remove a value from the property Proximity
   * @param value An instance of org.semanticwb.cptm.LocalityInt
   */
    public void removeProximity(org.semanticwb.cptm.LocalityInt value);

/**
* Gets the Proximity
* @return a instance of org.semanticwb.cptm.LocalityInt
*/
    public org.semanticwb.cptm.LocalityInt getProximity();

    public double getLongitude();

    public void setLongitude(double value);

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralAttractive> listGeneralAttributes();
    public boolean hasGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value);

   /**
   * Adds the GeneralAttribute
   * @param value An instance of org.semanticwb.cptm.GeneralAttractive
   */
    public void addGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value);

   /**
   * Remove all the values for the property GeneralAttribute
   */
    public void removeAllGeneralAttribute();

   /**
   * Remove a value from the property GeneralAttribute
   * @param value An instance of org.semanticwb.cptm.GeneralAttractive
   */
    public void removeGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value);

/**
* Gets the GeneralAttribute
* @return a instance of org.semanticwb.cptm.GeneralAttractive
*/
    public org.semanticwb.cptm.GeneralAttractive getGeneralAttribute();

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> listLocalityEditNoteInvs();
    public boolean hasLocalityEditNoteInv(org.semanticwb.cptm.EditNote value);

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> listActLocalityInvs();
    public boolean hasActLocalityInv(org.semanticwb.cptm.Activity value);

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> listTravelRouteInvs();
    public boolean hasTravelRouteInv(org.semanticwb.cptm.TravelRoute value);

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> listEventGeographicPointInvs();
    public boolean hasEventGeographicPointInv(org.semanticwb.cptm.Event value);

   /**
   * Sets a value from the property ExpLocalityInv
   * @param value An instance of org.semanticwb.cptm.ExperienceRef
   */
    public void setExpLocalityInv(org.semanticwb.cptm.ExperienceRef value);

   /**
   * Remove the value from the property ExpLocalityInv
   */
    public void removeExpLocalityInv();

    public org.semanticwb.cptm.ExperienceRef getExpLocalityInv();

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> listExperienceLocalityInvs();
    public boolean hasExperienceLocalityInv(org.semanticwb.cptm.Experience value);
}
