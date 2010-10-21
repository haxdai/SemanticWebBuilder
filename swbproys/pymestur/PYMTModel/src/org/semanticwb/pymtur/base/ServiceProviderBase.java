package org.semanticwb.pymtur.base;


   /**
   * Clase principal del sistema de pymes turisticas. Una instancia de esta clase es en donde se almacena toda la información de una mipyme especifica. 
   */
public abstract class ServiceProviderBase extends org.semanticwb.portal.community.DirectoryObject implements org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.portal.community.Contactable,org.semanticwb.model.Rankable,org.semanticwb.model.Searchable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Interactiveable
{
   /**
   * (Requerido para funcionamiento adecuado del portal,establecido por el sistema) : Contador, número de fotos que se lleven registrados para una mipyme (Dado que se determino que tendrían hasta cierta cantidad por tipo de paquete y esta cantidad sería parametrizable). El número de fotos en esta propiedad es la suma de todas las fotos que haya subido la mipyme en las secciones de: a)Fotos de instalaciones, b)Fotos del establecimiento, c)Fotos del Giro,  d)Mas fotos
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTotPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTotPhotos");
   /**
   * Clase que se encarga de administrar servicios del catalogo
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
   /**
   * (Opcional) : Servicios que presta la mypyme, registrados por la misma en base a las que se encuentran registradas para su giro y a su vez estas con base al catalogo general de servicios.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasService");
   /**
   * Estado de la republica en el que se encuentra el domicilio fiscal de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcState=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcState");
   /**
   * (Opcional) : Cometarios registrados por la mipyme referente a sus promociones registradas
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spPromotionsComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spPromotionsComment");
   /**
   * (Opcional) : Teléfono para reservaciones registrado por la mipyme para sus servicios.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spReservationPhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spReservationPhone");
   /**
   * Código postal de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_sp_zipcode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#sp_zipcode");
   /**
   * Número celular registrado por la mipyme y por el cual se podran poner en contacto los usurios del portal con la misma mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCelularPhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCelularPhone");
   /**
   * (Opcional) : Descripción registrada por la mipyme referente a sus instalaciones
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsDescr");
   /**
   * (Opcional) : Propiedad en la que se almacena una descripción detallada de como  llegar a la mipyme - (Opcional)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeArrive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeArrive");
   /**
   * (Opcional) : Lada nacional para el marcado télefonico a la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_ladaNacional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#ladaNacional");
   /**
   * (Opcional) : Colonia en la que se encuentra hubicada  la mipyme, forma parte de su dirección fiscal
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcSuburb=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcSuburb");
   /**
   * Clase que se encarga de administrar temporadas (altas y bajas para las tarifas)
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_RateSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateSeason");
   /**
   * (Opcional) : Registro de fechas de temporadas baja que considere la mipyme, sirve como aclaración al registro de tarifas con las que cuente
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasRateLowSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasRateLowSeason");
   /**
   * Clase que se encarga de administrar fotos
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_PymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");
   /**
   * (Opcional) : Fotos  registradas del establecimiento de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasEstablishmentPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasEstablishmentPymePhoto");
   /**
   * (Requerido si se desea desabilitar el anuncio despues de cierta fecha Enddate,establecido por el sistema) : Periodo contratado por la mipyme (Se definio que por defecto fuera 12 meses)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spContractPeiod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spContractPeiod");
   /**
   * Clase que hereda de WebPage.Mediante esta se administran las variantes en cuanto a diseño (CSS) que tiene cada tipo de plantilla (PaqTemplate).
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_VariantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VariantPaqTemplate");
   /**
   * (Requerido para funcionamiento adecuado del portal) : Variante de estilo para la presentación de la plantilla de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_variantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#variantPaqTemplate");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
   /**
   * (Opcional) : Destino secundario al cual se puede registrar la mipyme, se definio por si acaso en lo futuro se requería
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_destinationSec=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destinationSec");
   /**
   * (Opcional) : Régimen fiscal de la mypyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcPersonType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcPersonType");
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Actividades.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Activity");
   /**
   * (Opcional) : Actividades que se realicen en la mypyme, registrados por la misma en base a las que se encuentran registradas para su destino y a su vez estas con base al catalogo general de Actividades.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasSPActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasSPActivity");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * (Requerido para funcionamiento adecuado del portal,establecido por el sistema) : Usuario creador de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCreator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCreator");
   /**
   * Colonia a la que pertenece la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spSuburb=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSuburb");
   /**
   * (Opcional) : Canal de youtube que la mipyme registre
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spYouTubeChannel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spYouTubeChannel");
   /**
   * (Opcional) : Cometarios registrados por la mipyme referente al apartado de  sus servicios y equipamiento.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spServicesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spServicesDescr");
   /**
   * (Requerido para funcionamiento adecuado del portal,establecido por el sistema) : Número de promociones que se lleven registradas para una mipyme (Dado que se determino que tendrían hasta cierta cantidad por tipo de paquete y esta cantidad sería parametrizable)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTotPromotions=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTotPromotions");
   /**
   * (Opcional) : Ciudad del rfc de la mipyme, forma parte de su dirección fiscal
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcCity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcCity");
   /**
   * Clase que se encarga de administrar cupones
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Cupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");
   /**
   * (Opcional) : Lista de cupones que puede registrar la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasCupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCupon");
   /**
   * Fecha en la que fue aceptada a la miPyme para ser publicada en el portal concentrador, fecha registrada en automatico por el sistema
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spAcceptedDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spAcceptedDate");
   /**
   * (Opcional) : Código postal en el que se encuentra hubicada  la mipyme, forma parte de su dirección fiscal
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcZipCode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcZipCode");
   /**
   * Un servidor DNS permite conectarse con la máquina sin necesidad de conocer su dirección IP. En SemanticWebBuilder el DNS local es el nombre asociado al sitio. Al ser invocado el DNS presentará una sección específica a manera de página de inicio.
   */
    public static final org.semanticwb.platform.SemanticClass swb_Dns=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Dns");
   /**
   * (Opcional) : Subdominio generado para la mipyme, en webbuilder se genera un objeto tipo DNS., se acordó que se hiba a configuarar el servidor para porder usar subdominios en base a wildcards. (ej. mihotelito.pymestur.infotec.com.mx)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeSubDomainWildCard=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeSubDomainWildCard");
   /**
   * (Requerido para funcionamiento adecuado del portal,establecido por el sistema) : Contador, número de cupones que se lleven registrados para una mipyme (Dado que se determino que tendrían hasta cierta cantidad por tipo de paquete y esta cantidad sería parametrizable)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTotCupones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTotCupones");
   /**
   * (Opcional) : Cometarios registrados por la mipyme referente a sus fotos de sus instalaciones
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsPymePhotosComments");
    public static final org.semanticwb.platform.SemanticClass pymtur_OmnibusLines=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#OmnibusLines");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasOmnibusLine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasOmnibusLine");
   /**
   * (Requerido para funcionamiento adecuado del portal,establecido por el sistema de acuerdo a paquete contratado por la mipyme) : Este es el tipo de paquete con el que se registre o contrate la mipyme (1.Directorio, 2.Ficha, 3. Micrositio, 4.Premier o Página Web). Se definió que solo iban a operar el 2.Ficha y 4.Premier.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymePaqueteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymePaqueteType");
   /**
   * (Opcional) : Fotos registradas por la mipyme para su giro especifico (ej. Hospedaje)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasSpCategoryPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasSpCategoryPymePhoto");
   /**
   * (Opcional) : Cuenta de skype registrada por la mipyme como manera de que los usuarios la contacten.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spSkypeAccount=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSkypeAccount");
   /**
   * Clase que extiende de swbcomm:MicroSite, la cual extiende a su vez de Webpage. Cada que una pyme contrata un paquete de tipo "Micrositio" o "Premier-Página web" se crea una instancia de esta clase para albergar el microsito de dicha pyme.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_MicroSitePyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MicroSitePyme");
   /**
   * (Requerido para funcionamiento adecuado del portal,establecido por el sistema) : Inversa de micrositePyme, mediante esta inversa se puede saber cual es la página de webbuilder (WebPage) de tipo micrositepyme es la que tiene todos los datos de la mipyme (micrositio de la mipyme). Esto solo aplica para las que tienen un micrositio (en este momento solo para el paquete Premier o también conocido como Página web)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_microSitePymeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#microSitePymeInv");
   /**
   * (Opcional) : Eslogan registrado por la mipyme.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spSlogan=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSlogan");
   /**
   * Clase que que encarga de administrar instalaciones
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Instalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Instalation");
   /**
   * (Opcional) : Instalaciones con las que cuenta la mipyme, las cuales son registradas por la misma en base al catalogo de instalaciones por giro
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalation");
   /**
   * (Requerido para funcionamiento adecuado del portal,establecido por el sistema) : Estatus en el que se encuentra la mipyme, por el momento solo existen los sig: 1.Registrado . 4.Activado  6.Rechazado, Falta definición del resto (Modulo de administración)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spStatus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spStatus");
   /**
   * (Opcional) : Número exterior del rfc de la mipyme, forma parte de su dirección fiscal
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcExternalNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcExternalNumber");
   /**
   * (Opcional) : Comentarios para los cupones generados por la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCuponsComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCuponsComment");
   /**
   * (Opcional) : Razón social de la mipyme (Campo de RFC)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcRazonSocial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcRazonSocial");
   /**
   * (Opcional) : Municipio o delegación del rfc de la mipyme, forma parte de su dirección fiscal
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcCityCouncil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcCityCouncil");
   /**
   * Clase que se encarga de administrar promociones
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");
   /**
   * (Opcional) : Promociones que registre la mipyme y que quiera dar a conocer a los usuarios de su página
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasPromotion");
   /**
   * (Opcional) : Fotos adicionales que registre la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasMorePymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasMorePymePhoto");
   /**
   * Segundo apellido del usuario de contacto para la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_contactSecondName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#contactSecondName");
   /**
   * (Requerido para funcionamiento adecuado del portal) : Página web externa con la que ya cuente la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeWebSite");
   /**
   * (Requerido si se desea tener una fecha de finalización de anunciol,establecido por el sistema) : Fecha fin de publicación de anuncio de la mipyme, fecha registrada automaticamente por el sistema en base a la fecha de activación mas el periodo del contrato contratado por la mipyme (por defecto 12 meses)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spEndAnnuncePeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spEndAnnuncePeriod");
   /**
   * (Opcional) : Fotos de las instalaciones que registre la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalationsPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalationsPymePhoto");
   /**
   * Clase que se encarga de administrar lugares cercanos (cernanias)
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Nearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Nearest");
   /**
   * (Opcional) : Lugares cercanos con las que cuenta la mypyme, registrados por la misma en base al catalogo de carcanias
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasNearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasNearest");
   /**
   * (Opcional) : Cantidad maxima de sus cuotas para los servicios que presta
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_MaxRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MaxRate");
   /**
   * (Opcional) : Usuario de facebook de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spFacebookUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spFacebookUser");
   /**
   * (Requerido para funcionamiento adecuado) : Destino en el que se registra la mipyme, es util para el buscador por destinos
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destination");
   /**
   * Clase que se encarga de administrar el código de videos hospedados en youtube
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_VideoYouTube=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VideoYouTube");
   /**
   * (Opcional) : Propiedad para que la miPyme pueda agregar un video de youtube a su página, solo para paquetes Premier (página web) de acuerdo a definición
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spVideoYouTube=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spVideoYouTube");
   /**
   * (Opcional) : Descripción de sus cercanias
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_NearestDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#NearestDescr");
   /**
   * (Opcional) : Número interior del rfc de la mipyme, forma parte de su dirección fiscal
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcInternalNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcInternalNumber");
   /**
   * (Opcional) : Usuario de twitter de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTwitterUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTwitterUser");
   /**
   * (Opcional) : Comentarios a las fotos del giro especifico de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_SpCategoryPymePhotoCommens=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#SpCategoryPymePhotoCommens");
   /**
   * Comentarios referentes a las actividades registradas para la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spActivitiesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spActivitiesDescr");
   /**
   * (Establecido por el sistema y por el administrador de pymes) : ultimo comentario registrado por un administrador en los cambios de estatus (ej. el porque fue rechazada una mipyme)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spStatusComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spStatusComment");
   /**
   * (Opcional) : Comentarios registrador por la mipyme para sus fotos de sus establecimiento
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spEstablishmentPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spEstablishmentPymePhotosComments");
   /**
   * (Opcional) : Dominio registrado para la mipyme, mediante este se genera un objeto DNS, teoricamente este es un dominio con el que cuenta  la emprasa en algún servidor de dominios (ej. Nick)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeDomain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeDomain");
   /**
   * (Opcional) : Rfc de la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfc");
   /**
   * Primer apellido del usuario de contacto para la mipyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_contactFirstName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#contactFirstName");
   /**
   * (Opcional) : Cometarios registrados por la mipyme referente a sus fotos agregadas (mas fotos)
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spMorePymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spMorePymePhotosComments");
   /**
   * (Opcional) : Cometarios registrados por la mipyme referente a sus tarifas registradas
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spRatesComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spRatesComments");
   /**
   * (Opcional) : Cantidad minima de sus cuotas para los servicios que presta
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_MinRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MinRate");
   /**
   * (Opcional) : Calle o avenida en la que se encuentra hubicada  la mipyme, forma parte de su dirección fiscal
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcStreet=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcStreet");
   /**
   * (Opcional) :  Registro de fechas de temporadas alta que considere la mipyme, sirve como aclaración al registro de tarifas con las que cuente
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasRateHighSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasRateHighSeason");
    public static final org.semanticwb.platform.SemanticClass pymtur_Certificates=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Certificates");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasCertificate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCertificate");
   /**
   * (Opcional) : Foto que se usa como logo de la miPyme
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_PhotoLogo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoLogo");
   /**
   * Clase que se encarga de administrar tarifas
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Rate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Rate");
   /**
   * (Opcional) : Tarifas que registre la mipyme, esto con la finalidad de que las de a conocer a los usuarios de su página
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasRate");
   /**
   * Clase principal del sistema de pymes turisticas. Una instancia de esta clase es en donde se almacena toda la información de una mipyme especifica.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");

    public static class ClassMgr
    {
       /**
       * Returns a list of ServiceProvider for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.ServiceProvider for all models
       * @return Iterator of org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.ServiceProvider
       * @param id Identifier for org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return A org.semanticwb.pymtur.ServiceProvider
       */
        public static org.semanticwb.pymtur.ServiceProvider getServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.ServiceProvider)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.ServiceProvider
       * @param id Identifier for org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return A org.semanticwb.pymtur.ServiceProvider
       */
        public static org.semanticwb.pymtur.ServiceProvider createServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.ServiceProvider)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.ServiceProvider
       * @param id Identifier for org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       */
        public static void removeServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.ServiceProvider
       * @param id Identifier for org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return true if the org.semanticwb.pymtur.ServiceProvider exists, false otherwise
       */

        public static boolean hasServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            return (getServiceProvider(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Service
       * @param value Service of the type org.semanticwb.pymtur.Service
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Service
       * @param value Service of the type org.semanticwb.pymtur.Service
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined RateLowSeason
       * @param value RateLowSeason of the type org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateLowSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined RateLowSeason
       * @param value RateLowSeason of the type org.semanticwb.pymtur.RateSeason
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateLowSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined EstablishmentPymePhoto
       * @param value EstablishmentPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined EstablishmentPymePhoto
       * @param value EstablishmentPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined VariantPaqTemplate
       * @param value VariantPaqTemplate of the type org.semanticwb.pymtur.VariantPaqTemplate
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined VariantPaqTemplate
       * @param value VariantPaqTemplate of the type org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined DestinationSec
       * @param value DestinationSec of the type org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined DestinationSec
       * @param value DestinationSec of the type org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SPActivity
       * @param value SPActivity of the type org.semanticwb.pymtur.Activity
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySPActivity(org.semanticwb.pymtur.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SPActivity
       * @param value SPActivity of the type org.semanticwb.pymtur.Activity
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySPActivity(org.semanticwb.pymtur.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SpCreator
       * @param value SpCreator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SpCreator
       * @param value SpCreator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Cupon
       * @param value Cupon of the type org.semanticwb.pymtur.Cupon
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Cupon
       * @param value Cupon of the type org.semanticwb.pymtur.Cupon
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined PymeSubDomainWildCard
       * @param value PymeSubDomainWildCard of the type org.semanticwb.model.Dns
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeSubDomainWildCard(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined PymeSubDomainWildCard
       * @param value PymeSubDomainWildCard of the type org.semanticwb.model.Dns
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeSubDomainWildCard(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined TopicWebPage
       * @param value TopicWebPage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined TopicWebPage
       * @param value TopicWebPage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined OmnibusLine
       * @param value OmnibusLine of the type org.semanticwb.pymtur.OmnibusLines
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByOmnibusLine(org.semanticwb.pymtur.OmnibusLines value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasOmnibusLine, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined OmnibusLine
       * @param value OmnibusLine of the type org.semanticwb.pymtur.OmnibusLines
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByOmnibusLine(org.semanticwb.pymtur.OmnibusLines value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasOmnibusLine,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SpCategoryPymePhoto
       * @param value SpCategoryPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SpCategoryPymePhoto
       * @param value SpCategoryPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined MicroSitePymeInv
       * @param value MicroSitePymeInv of the type org.semanticwb.pymtur.MicroSitePyme
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined MicroSitePymeInv
       * @param value MicroSitePymeInv of the type org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Instalation
       * @param value Instalation of the type org.semanticwb.pymtur.Instalation
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalation(org.semanticwb.pymtur.Instalation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Instalation
       * @param value Instalation of the type org.semanticwb.pymtur.Instalation
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalation(org.semanticwb.pymtur.Instalation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined DirectoryResource
       * @param value DirectoryResource of the type org.semanticwb.portal.community.DirectoryResource
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined DirectoryResource
       * @param value DirectoryResource of the type org.semanticwb.portal.community.DirectoryResource
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Profile
       * @param value Profile of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Profile
       * @param value Profile of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Promotion
       * @param value Promotion of the type org.semanticwb.pymtur.Promotion
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Promotion
       * @param value Promotion of the type org.semanticwb.pymtur.Promotion
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined MorePymePhoto
       * @param value MorePymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined MorePymePhoto
       * @param value MorePymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined InstalationsPymePhoto
       * @param value InstalationsPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined InstalationsPymePhoto
       * @param value InstalationsPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Nearest
       * @param value Nearest of the type org.semanticwb.pymtur.Nearest
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Nearest
       * @param value Nearest of the type org.semanticwb.pymtur.Nearest
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Destination
       * @param value Destination of the type org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Destination
       * @param value Destination of the type org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SpVideoYouTube
       * @param value SpVideoYouTube of the type org.semanticwb.pymtur.VideoYouTube
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined SpVideoYouTube
       * @param value SpVideoYouTube of the type org.semanticwb.pymtur.VideoYouTube
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined PymeDomain
       * @param value PymeDomain of the type org.semanticwb.model.Dns
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeDomain(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined PymeDomain
       * @param value PymeDomain of the type org.semanticwb.model.Dns
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeDomain(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined RateHighSeason
       * @param value RateHighSeason of the type org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateHighSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined RateHighSeason
       * @param value RateHighSeason of the type org.semanticwb.pymtur.RateSeason
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateHighSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Certificate
       * @param value Certificate of the type org.semanticwb.pymtur.Certificates
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCertificate(org.semanticwb.pymtur.Certificates value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCertificate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Certificate
       * @param value Certificate of the type org.semanticwb.pymtur.Certificates
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCertificate(org.semanticwb.pymtur.Certificates value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCertificate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Comment
       * @param value Comment of the type org.semanticwb.portal.community.Comment
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Comment
       * @param value Comment of the type org.semanticwb.portal.community.Comment
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Rate
       * @param value Rate of the type org.semanticwb.pymtur.Rate
       * @param model Model of the org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.ServiceProvider with a determined Rate
       * @param value Rate of the type org.semanticwb.pymtur.Rate
       * @return Iterator with all the org.semanticwb.pymtur.ServiceProvider
       */

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ServiceProviderBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ServiceProvider
   */
    public ServiceProviderBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the SpTotPhotos property
* @return int with the SpTotPhotos
*/
    public int getSpTotPhotos()
    {
        return getSemanticObject().getIntProperty(pymtur_spTotPhotos);
    }

/**
* Sets the SpTotPhotos property
* @param value long with the SpTotPhotos
*/
    public void setSpTotPhotos(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spTotPhotos, value);
    }

/**
* Gets the ContactName property
* @return String with the ContactName
*/
    public String getContactName()
    {
        return getSemanticObject().getProperty(swbcomm_contactName);
    }

/**
* Sets the ContactName property
* @param value long with the ContactName
*/
    public void setContactName(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactName, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.Service
   * @return A GenericIterator with all the org.semanticwb.pymtur.Service
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> listServices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service>(getSemanticObject().listObjectProperties(pymtur_hasService));
    }

   /**
   * Gets true if has a Service
   * @param value org.semanticwb.pymtur.Service to verify
   * @return true if the org.semanticwb.pymtur.Service exists, false otherwise
   */
    public boolean hasService(org.semanticwb.pymtur.Service value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasService,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Service
   * @param value org.semanticwb.pymtur.Service to add
   */

    public void addService(org.semanticwb.pymtur.Service value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasService, value.getSemanticObject());
    }
   /**
   * Removes all the Service
   */

    public void removeAllService()
    {
        getSemanticObject().removeProperty(pymtur_hasService);
    }
   /**
   * Removes a Service
   * @param value org.semanticwb.pymtur.Service to remove
   */

    public void removeService(org.semanticwb.pymtur.Service value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasService,value.getSemanticObject());
    }

   /**
   * Gets the Service
   * @return a org.semanticwb.pymtur.Service
   */
    public org.semanticwb.pymtur.Service getService()
    {
         org.semanticwb.pymtur.Service ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasService);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Service)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RfcState property
* @return String with the RfcState
*/
    public String getRfcState()
    {
        return getSemanticObject().getProperty(pymtur_rfcState);
    }

/**
* Sets the RfcState property
* @param value long with the RfcState
*/
    public void setRfcState(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcState, value);
    }

/**
* Gets the SpPromotionsComment property
* @return String with the SpPromotionsComment
*/
    public String getSpPromotionsComment()
    {
        return getSemanticObject().getProperty(pymtur_spPromotionsComment);
    }

/**
* Sets the SpPromotionsComment property
* @param value long with the SpPromotionsComment
*/
    public void setSpPromotionsComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spPromotionsComment, value);
    }

/**
* Gets the SpReservationPhone property
* @return String with the SpReservationPhone
*/
    public String getSpReservationPhone()
    {
        return getSemanticObject().getProperty(pymtur_spReservationPhone);
    }

/**
* Sets the SpReservationPhone property
* @param value long with the SpReservationPhone
*/
    public void setSpReservationPhone(String value)
    {
        getSemanticObject().setProperty(pymtur_spReservationPhone, value);
    }

/**
* Gets the State property
* @return String with the State
*/
    public String getState()
    {
        return getSemanticObject().getProperty(swbcomm_state);
    }

/**
* Sets the State property
* @param value long with the State
*/
    public void setState(String value)
    {
        getSemanticObject().setProperty(swbcomm_state, value);
    }

/**
* Gets the Sp_zipcode property
* @return String with the Sp_zipcode
*/
    public String getSp_zipcode()
    {
        return getSemanticObject().getProperty(pymtur_sp_zipcode);
    }

/**
* Sets the Sp_zipcode property
* @param value long with the Sp_zipcode
*/
    public void setSp_zipcode(String value)
    {
        getSemanticObject().setProperty(pymtur_sp_zipcode, value);
    }

/**
* Gets the SpCelularPhone property
* @return String with the SpCelularPhone
*/
    public String getSpCelularPhone()
    {
        return getSemanticObject().getProperty(pymtur_spCelularPhone);
    }

/**
* Sets the SpCelularPhone property
* @param value long with the SpCelularPhone
*/
    public void setSpCelularPhone(String value)
    {
        getSemanticObject().setProperty(pymtur_spCelularPhone, value);
    }

/**
* Gets the SpInstalationsDescr property
* @return String with the SpInstalationsDescr
*/
    public String getSpInstalationsDescr()
    {
        return getSemanticObject().getProperty(pymtur_spInstalationsDescr);
    }

/**
* Sets the SpInstalationsDescr property
* @param value long with the SpInstalationsDescr
*/
    public void setSpInstalationsDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_spInstalationsDescr, value);
    }

/**
* Gets the PymeArrive property
* @return String with the PymeArrive
*/
    public String getPymeArrive()
    {
        return getSemanticObject().getProperty(pymtur_pymeArrive);
    }

/**
* Sets the PymeArrive property
* @param value long with the PymeArrive
*/
    public void setPymeArrive(String value)
    {
        getSemanticObject().setProperty(pymtur_pymeArrive, value);
    }

/**
* Gets the LadaNacional property
* @return String with the LadaNacional
*/
    public String getLadaNacional()
    {
        return getSemanticObject().getProperty(pymtur_ladaNacional);
    }

/**
* Sets the LadaNacional property
* @param value long with the LadaNacional
*/
    public void setLadaNacional(String value)
    {
        getSemanticObject().setProperty(pymtur_ladaNacional, value);
    }

/**
* Gets the City property
* @return String with the City
*/
    public String getCity()
    {
        return getSemanticObject().getProperty(swbcomm_city);
    }

/**
* Sets the City property
* @param value long with the City
*/
    public void setCity(String value)
    {
        getSemanticObject().setProperty(swbcomm_city, value);
    }

/**
* Gets the RfcSuburb property
* @return String with the RfcSuburb
*/
    public String getRfcSuburb()
    {
        return getSemanticObject().getProperty(pymtur_rfcSuburb);
    }

/**
* Sets the RfcSuburb property
* @param value long with the RfcSuburb
*/
    public void setRfcSuburb(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcSuburb, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.RateSeason
   * @return A GenericIterator with all the org.semanticwb.pymtur.RateSeason
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason> listRateLowSeasons()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(getSemanticObject().listObjectProperties(pymtur_hasRateLowSeason));
    }

   /**
   * Gets true if has a RateLowSeason
   * @param value org.semanticwb.pymtur.RateSeason to verify
   * @return true if the org.semanticwb.pymtur.RateSeason exists, false otherwise
   */
    public boolean hasRateLowSeason(org.semanticwb.pymtur.RateSeason value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRateLowSeason,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a RateLowSeason
   * @param value org.semanticwb.pymtur.RateSeason to add
   */

    public void addRateLowSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasRateLowSeason, value.getSemanticObject());
    }
   /**
   * Removes all the RateLowSeason
   */

    public void removeAllRateLowSeason()
    {
        getSemanticObject().removeProperty(pymtur_hasRateLowSeason);
    }
   /**
   * Removes a RateLowSeason
   * @param value org.semanticwb.pymtur.RateSeason to remove
   */

    public void removeRateLowSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRateLowSeason,value.getSemanticObject());
    }

   /**
   * Gets the RateLowSeason
   * @return a org.semanticwb.pymtur.RateSeason
   */
    public org.semanticwb.pymtur.RateSeason getRateLowSeason()
    {
         org.semanticwb.pymtur.RateSeason ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasRateLowSeason);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.RateSeason)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.PymePhoto
   * @return A GenericIterator with all the org.semanticwb.pymtur.PymePhoto
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listEstablishmentPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasEstablishmentPymePhoto));
    }

   /**
   * Gets true if has a EstablishmentPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to verify
   * @return true if the org.semanticwb.pymtur.PymePhoto exists, false otherwise
   */
    public boolean hasEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EstablishmentPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to add
   */

    public void addEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasEstablishmentPymePhoto, value.getSemanticObject());
    }
   /**
   * Removes all the EstablishmentPymePhoto
   */

    public void removeAllEstablishmentPymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasEstablishmentPymePhoto);
    }
   /**
   * Removes a EstablishmentPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to remove
   */

    public void removeEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject());
    }

   /**
   * Gets the EstablishmentPymePhoto
   * @return a org.semanticwb.pymtur.PymePhoto
   */
    public org.semanticwb.pymtur.PymePhoto getEstablishmentPymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasEstablishmentPymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property VariantPaqTemplate
   * @param value VariantPaqTemplate to set
   */

    public void setVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_variantPaqTemplate, value.getSemanticObject());
        }else
        {
            removeVariantPaqTemplate();
        }
    }
   /**
   * Remove the value for VariantPaqTemplate property
   */

    public void removeVariantPaqTemplate()
    {
        getSemanticObject().removeProperty(pymtur_variantPaqTemplate);
    }

   /**
   * Gets the VariantPaqTemplate
   * @return a org.semanticwb.pymtur.VariantPaqTemplate
   */
    public org.semanticwb.pymtur.VariantPaqTemplate getVariantPaqTemplate()
    {
         org.semanticwb.pymtur.VariantPaqTemplate ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_variantPaqTemplate);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.VariantPaqTemplate)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property DestinationSec
   * @param value DestinationSec to set
   */

    public void setDestinationSec(org.semanticwb.pymtur.Destination value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_destinationSec, value.getSemanticObject());
        }else
        {
            removeDestinationSec();
        }
    }
   /**
   * Remove the value for DestinationSec property
   */

    public void removeDestinationSec()
    {
        getSemanticObject().removeProperty(pymtur_destinationSec);
    }

   /**
   * Gets the DestinationSec
   * @return a org.semanticwb.pymtur.Destination
   */
    public org.semanticwb.pymtur.Destination getDestinationSec()
    {
         org.semanticwb.pymtur.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_destinationSec);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Destination)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RfcPersonType property
* @return String with the RfcPersonType
*/
    public String getRfcPersonType()
    {
        return getSemanticObject().getProperty(pymtur_rfcPersonType);
    }

/**
* Sets the RfcPersonType property
* @param value long with the RfcPersonType
*/
    public void setRfcPersonType(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcPersonType, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.Activity
   * @return A GenericIterator with all the org.semanticwb.pymtur.Activity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity> listSPActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity>(getSemanticObject().listObjectProperties(pymtur_hasSPActivity));
    }

   /**
   * Gets true if has a SPActivity
   * @param value org.semanticwb.pymtur.Activity to verify
   * @return true if the org.semanticwb.pymtur.Activity exists, false otherwise
   */
    public boolean hasSPActivity(org.semanticwb.pymtur.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasSPActivity,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a SPActivity
   * @param value org.semanticwb.pymtur.Activity to add
   */

    public void addSPActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasSPActivity, value.getSemanticObject());
    }
   /**
   * Removes all the SPActivity
   */

    public void removeAllSPActivity()
    {
        getSemanticObject().removeProperty(pymtur_hasSPActivity);
    }
   /**
   * Removes a SPActivity
   * @param value org.semanticwb.pymtur.Activity to remove
   */

    public void removeSPActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasSPActivity,value.getSemanticObject());
    }

   /**
   * Gets the SPActivity
   * @return a org.semanticwb.pymtur.Activity
   */
    public org.semanticwb.pymtur.Activity getSPActivity()
    {
         org.semanticwb.pymtur.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasSPActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Activity)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Step property
* @return int with the Step
*/
    public int getStep()
    {
        return getSemanticObject().getIntProperty(swb_geoStep);
    }

/**
* Sets the Step property
* @param value long with the Step
*/
    public void setStep(int value)
    {
        getSemanticObject().setIntProperty(swb_geoStep, value);
    }
   /**
   * Sets the value for the property SpCreator
   * @param value SpCreator to set
   */

    public void setSpCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_spCreator, value.getSemanticObject());
        }else
        {
            removeSpCreator();
        }
    }
   /**
   * Remove the value for SpCreator property
   */

    public void removeSpCreator()
    {
        getSemanticObject().removeProperty(pymtur_spCreator);
    }

   /**
   * Gets the SpCreator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSpCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_spCreator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the IntNumber property
* @return String with the IntNumber
*/
    public String getIntNumber()
    {
        return getSemanticObject().getProperty(swbcomm_intNumber);
    }

/**
* Sets the IntNumber property
* @param value long with the IntNumber
*/
    public void setIntNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_intNumber, value);
    }

/**
* Gets the SpSuburb property
* @return String with the SpSuburb
*/
    public String getSpSuburb()
    {
        return getSemanticObject().getProperty(pymtur_spSuburb);
    }

/**
* Sets the SpSuburb property
* @param value long with the SpSuburb
*/
    public void setSpSuburb(String value)
    {
        getSemanticObject().setProperty(pymtur_spSuburb, value);
    }

/**
* Gets the SpYouTubeChannel property
* @return String with the SpYouTubeChannel
*/
    public String getSpYouTubeChannel()
    {
        return getSemanticObject().getProperty(pymtur_spYouTubeChannel);
    }

/**
* Sets the SpYouTubeChannel property
* @param value long with the SpYouTubeChannel
*/
    public void setSpYouTubeChannel(String value)
    {
        getSemanticObject().setProperty(pymtur_spYouTubeChannel, value);
    }

/**
* Gets the SpServicesDescr property
* @return String with the SpServicesDescr
*/
    public String getSpServicesDescr()
    {
        return getSemanticObject().getProperty(pymtur_spServicesDescr);
    }

/**
* Sets the SpServicesDescr property
* @param value long with the SpServicesDescr
*/
    public void setSpServicesDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_spServicesDescr, value);
    }

/**
* Gets the SpTotPromotions property
* @return int with the SpTotPromotions
*/
    public int getSpTotPromotions()
    {
        return getSemanticObject().getIntProperty(pymtur_spTotPromotions);
    }

/**
* Sets the SpTotPromotions property
* @param value long with the SpTotPromotions
*/
    public void setSpTotPromotions(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spTotPromotions, value);
    }

/**
* Gets the RfcCity property
* @return String with the RfcCity
*/
    public String getRfcCity()
    {
        return getSemanticObject().getProperty(pymtur_rfcCity);
    }

/**
* Sets the RfcCity property
* @param value long with the RfcCity
*/
    public void setRfcCity(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcCity, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.Cupon
   * @return A GenericIterator with all the org.semanticwb.pymtur.Cupon
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon> listCupons()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon>(getSemanticObject().listObjectProperties(pymtur_hasCupon));
    }

   /**
   * Gets true if has a Cupon
   * @param value org.semanticwb.pymtur.Cupon to verify
   * @return true if the org.semanticwb.pymtur.Cupon exists, false otherwise
   */
    public boolean hasCupon(org.semanticwb.pymtur.Cupon value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasCupon,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Cupon
   * @param value org.semanticwb.pymtur.Cupon to add
   */

    public void addCupon(org.semanticwb.pymtur.Cupon value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasCupon, value.getSemanticObject());
    }
   /**
   * Removes all the Cupon
   */

    public void removeAllCupon()
    {
        getSemanticObject().removeProperty(pymtur_hasCupon);
    }
   /**
   * Removes a Cupon
   * @param value org.semanticwb.pymtur.Cupon to remove
   */

    public void removeCupon(org.semanticwb.pymtur.Cupon value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasCupon,value.getSemanticObject());
    }

   /**
   * Gets the Cupon
   * @return a org.semanticwb.pymtur.Cupon
   */
    public org.semanticwb.pymtur.Cupon getCupon()
    {
         org.semanticwb.pymtur.Cupon ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasCupon);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Cupon)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SpAcceptedDate property
* @return java.util.Date with the SpAcceptedDate
*/
    public java.util.Date getSpAcceptedDate()
    {
        return getSemanticObject().getDateProperty(pymtur_spAcceptedDate);
    }

/**
* Sets the SpAcceptedDate property
* @param value long with the SpAcceptedDate
*/
    public void setSpAcceptedDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_spAcceptedDate, value);
    }

/**
* Gets the RfcZipCode property
* @return String with the RfcZipCode
*/
    public String getRfcZipCode()
    {
        return getSemanticObject().getProperty(pymtur_rfcZipCode);
    }

/**
* Sets the RfcZipCode property
* @param value long with the RfcZipCode
*/
    public void setRfcZipCode(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcZipCode, value);
    }
   /**
   * Sets the value for the property PymeSubDomainWildCard
   * @param value PymeSubDomainWildCard to set
   */

    public void setPymeSubDomainWildCard(org.semanticwb.model.Dns value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_pymeSubDomainWildCard, value.getSemanticObject());
        }else
        {
            removePymeSubDomainWildCard();
        }
    }
   /**
   * Remove the value for PymeSubDomainWildCard property
   */

    public void removePymeSubDomainWildCard()
    {
        getSemanticObject().removeProperty(pymtur_pymeSubDomainWildCard);
    }

   /**
   * Gets the PymeSubDomainWildCard
   * @return a org.semanticwb.model.Dns
   */
    public org.semanticwb.model.Dns getPymeSubDomainWildCard()
    {
         org.semanticwb.model.Dns ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_pymeSubDomainWildCard);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Dns)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SpTotCupones property
* @return int with the SpTotCupones
*/
    public int getSpTotCupones()
    {
        return getSemanticObject().getIntProperty(pymtur_spTotCupones);
    }

/**
* Sets the SpTotCupones property
* @param value long with the SpTotCupones
*/
    public void setSpTotCupones(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spTotCupones, value);
    }

/**
* Gets the SpInstalationsPymePhotosComments property
* @return String with the SpInstalationsPymePhotosComments
*/
    public String getSpInstalationsPymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spInstalationsPymePhotosComments);
    }

/**
* Sets the SpInstalationsPymePhotosComments property
* @param value long with the SpInstalationsPymePhotosComments
*/
    public void setSpInstalationsPymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spInstalationsPymePhotosComments, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.OmnibusLines
   * @return A GenericIterator with all the org.semanticwb.pymtur.OmnibusLines
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.OmnibusLines> listOmnibusLines()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.OmnibusLines>(getSemanticObject().listObjectProperties(pymtur_hasOmnibusLine));
    }

   /**
   * Gets true if has a OmnibusLine
   * @param value org.semanticwb.pymtur.OmnibusLines to verify
   * @return true if the org.semanticwb.pymtur.OmnibusLines exists, false otherwise
   */
    public boolean hasOmnibusLine(org.semanticwb.pymtur.OmnibusLines value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasOmnibusLine,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a OmnibusLine
   * @param value org.semanticwb.pymtur.OmnibusLines to add
   */

    public void addOmnibusLine(org.semanticwb.pymtur.OmnibusLines value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasOmnibusLine, value.getSemanticObject());
    }
   /**
   * Removes all the OmnibusLine
   */

    public void removeAllOmnibusLine()
    {
        getSemanticObject().removeProperty(pymtur_hasOmnibusLine);
    }
   /**
   * Removes a OmnibusLine
   * @param value org.semanticwb.pymtur.OmnibusLines to remove
   */

    public void removeOmnibusLine(org.semanticwb.pymtur.OmnibusLines value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasOmnibusLine,value.getSemanticObject());
    }

   /**
   * Gets the OmnibusLine
   * @return a org.semanticwb.pymtur.OmnibusLines
   */
    public org.semanticwb.pymtur.OmnibusLines getOmnibusLine()
    {
         org.semanticwb.pymtur.OmnibusLines ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasOmnibusLine);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.OmnibusLines)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PymePaqueteType property
* @return int with the PymePaqueteType
*/
    public int getPymePaqueteType()
    {
        return getSemanticObject().getIntProperty(pymtur_pymePaqueteType);
    }

/**
* Sets the PymePaqueteType property
* @param value long with the PymePaqueteType
*/
    public void setPymePaqueteType(int value)
    {
        getSemanticObject().setIntProperty(pymtur_pymePaqueteType, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.PymePhoto
   * @return A GenericIterator with all the org.semanticwb.pymtur.PymePhoto
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listSpCategoryPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasSpCategoryPymePhoto));
    }

   /**
   * Gets true if has a SpCategoryPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to verify
   * @return true if the org.semanticwb.pymtur.PymePhoto exists, false otherwise
   */
    public boolean hasSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a SpCategoryPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to add
   */

    public void addSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasSpCategoryPymePhoto, value.getSemanticObject());
    }
   /**
   * Removes all the SpCategoryPymePhoto
   */

    public void removeAllSpCategoryPymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasSpCategoryPymePhoto);
    }
   /**
   * Removes a SpCategoryPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to remove
   */

    public void removeSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject());
    }

   /**
   * Gets the SpCategoryPymePhoto
   * @return a org.semanticwb.pymtur.PymePhoto
   */
    public org.semanticwb.pymtur.PymePhoto getSpCategoryPymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasSpCategoryPymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SpSkypeAccount property
* @return String with the SpSkypeAccount
*/
    public String getSpSkypeAccount()
    {
        return getSemanticObject().getProperty(pymtur_spSkypeAccount);
    }

/**
* Sets the SpSkypeAccount property
* @param value long with the SpSkypeAccount
*/
    public void setSpSkypeAccount(String value)
    {
        getSemanticObject().setProperty(pymtur_spSkypeAccount, value);
    }
   /**
   * Sets the value for the property MicroSitePymeInv
   * @param value MicroSitePymeInv to set
   */

    public void setMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_microSitePymeInv, value.getSemanticObject());
        }else
        {
            removeMicroSitePymeInv();
        }
    }
   /**
   * Remove the value for MicroSitePymeInv property
   */

    public void removeMicroSitePymeInv()
    {
        getSemanticObject().removeProperty(pymtur_microSitePymeInv);
    }

   /**
   * Gets the MicroSitePymeInv
   * @return a org.semanticwb.pymtur.MicroSitePyme
   */
    public org.semanticwb.pymtur.MicroSitePyme getMicroSitePymeInv()
    {
         org.semanticwb.pymtur.MicroSitePyme ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_microSitePymeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.MicroSitePyme)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ExtNumber property
* @return String with the ExtNumber
*/
    public String getExtNumber()
    {
        return getSemanticObject().getProperty(swbcomm_extNumber);
    }

/**
* Sets the ExtNumber property
* @param value long with the ExtNumber
*/
    public void setExtNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_extNumber, value);
    }

/**
* Gets the SpSlogan property
* @return String with the SpSlogan
*/
    public String getSpSlogan()
    {
        return getSemanticObject().getProperty(pymtur_spSlogan);
    }

/**
* Sets the SpSlogan property
* @param value long with the SpSlogan
*/
    public void setSpSlogan(String value)
    {
        getSemanticObject().setProperty(pymtur_spSlogan, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.Instalation
   * @return A GenericIterator with all the org.semanticwb.pymtur.Instalation
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation> listInstalations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation>(getSemanticObject().listObjectProperties(pymtur_hasInstalation));
    }

   /**
   * Gets true if has a Instalation
   * @param value org.semanticwb.pymtur.Instalation to verify
   * @return true if the org.semanticwb.pymtur.Instalation exists, false otherwise
   */
    public boolean hasInstalation(org.semanticwb.pymtur.Instalation value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasInstalation,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Instalation
   * @param value org.semanticwb.pymtur.Instalation to add
   */

    public void addInstalation(org.semanticwb.pymtur.Instalation value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasInstalation, value.getSemanticObject());
    }
   /**
   * Removes all the Instalation
   */

    public void removeAllInstalation()
    {
        getSemanticObject().removeProperty(pymtur_hasInstalation);
    }
   /**
   * Removes a Instalation
   * @param value org.semanticwb.pymtur.Instalation to remove
   */

    public void removeInstalation(org.semanticwb.pymtur.Instalation value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasInstalation,value.getSemanticObject());
    }

   /**
   * Gets the Instalation
   * @return a org.semanticwb.pymtur.Instalation
   */
    public org.semanticwb.pymtur.Instalation getInstalation()
    {
         org.semanticwb.pymtur.Instalation ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasInstalation);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Instalation)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SpStatus property
* @return int with the SpStatus
*/
    public int getSpStatus()
    {
        return getSemanticObject().getIntProperty(pymtur_spStatus);
    }

/**
* Sets the SpStatus property
* @param value long with the SpStatus
*/
    public void setSpStatus(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spStatus, value);
    }

/**
* Gets the RfcExternalNumber property
* @return String with the RfcExternalNumber
*/
    public String getRfcExternalNumber()
    {
        return getSemanticObject().getProperty(pymtur_rfcExternalNumber);
    }

/**
* Sets the RfcExternalNumber property
* @param value long with the RfcExternalNumber
*/
    public void setRfcExternalNumber(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcExternalNumber, value);
    }

/**
* Gets the SpCuponsComment property
* @return String with the SpCuponsComment
*/
    public String getSpCuponsComment()
    {
        return getSemanticObject().getProperty(pymtur_spCuponsComment);
    }

/**
* Sets the SpCuponsComment property
* @param value long with the SpCuponsComment
*/
    public void setSpCuponsComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spCuponsComment, value);
    }

/**
* Gets the RfcRazonSocial property
* @return String with the RfcRazonSocial
*/
    public String getRfcRazonSocial()
    {
        return getSemanticObject().getProperty(pymtur_rfcRazonSocial);
    }

/**
* Sets the RfcRazonSocial property
* @param value long with the RfcRazonSocial
*/
    public void setRfcRazonSocial(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcRazonSocial, value);
    }

/**
* Gets the RfcCityCouncil property
* @return String with the RfcCityCouncil
*/
    public String getRfcCityCouncil()
    {
        return getSemanticObject().getProperty(pymtur_rfcCityCouncil);
    }

/**
* Sets the RfcCityCouncil property
* @param value long with the RfcCityCouncil
*/
    public void setRfcCityCouncil(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcCityCouncil, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.Promotion
   * @return A GenericIterator with all the org.semanticwb.pymtur.Promotion
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion> listPromotions()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion>(getSemanticObject().listObjectProperties(pymtur_hasPromotion));
    }

   /**
   * Gets true if has a Promotion
   * @param value org.semanticwb.pymtur.Promotion to verify
   * @return true if the org.semanticwb.pymtur.Promotion exists, false otherwise
   */
    public boolean hasPromotion(org.semanticwb.pymtur.Promotion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasPromotion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Promotion
   * @param value org.semanticwb.pymtur.Promotion to add
   */

    public void addPromotion(org.semanticwb.pymtur.Promotion value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasPromotion, value.getSemanticObject());
    }
   /**
   * Removes all the Promotion
   */

    public void removeAllPromotion()
    {
        getSemanticObject().removeProperty(pymtur_hasPromotion);
    }
   /**
   * Removes a Promotion
   * @param value org.semanticwb.pymtur.Promotion to remove
   */

    public void removePromotion(org.semanticwb.pymtur.Promotion value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasPromotion,value.getSemanticObject());
    }

   /**
   * Gets the Promotion
   * @return a org.semanticwb.pymtur.Promotion
   */
    public org.semanticwb.pymtur.Promotion getPromotion()
    {
         org.semanticwb.pymtur.Promotion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasPromotion);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Promotion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.PymePhoto
   * @return A GenericIterator with all the org.semanticwb.pymtur.PymePhoto
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listMorePymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasMorePymePhoto));
    }

   /**
   * Gets true if has a MorePymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to verify
   * @return true if the org.semanticwb.pymtur.PymePhoto exists, false otherwise
   */
    public boolean hasMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasMorePymePhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a MorePymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to add
   */

    public void addMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasMorePymePhoto, value.getSemanticObject());
    }
   /**
   * Removes all the MorePymePhoto
   */

    public void removeAllMorePymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasMorePymePhoto);
    }
   /**
   * Removes a MorePymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to remove
   */

    public void removeMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasMorePymePhoto,value.getSemanticObject());
    }

   /**
   * Gets the MorePymePhoto
   * @return a org.semanticwb.pymtur.PymePhoto
   */
    public org.semanticwb.pymtur.PymePhoto getMorePymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasMorePymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ContactSecondName property
* @return String with the ContactSecondName
*/
    public String getContactSecondName()
    {
        return getSemanticObject().getProperty(pymtur_contactSecondName);
    }

/**
* Sets the ContactSecondName property
* @param value long with the ContactSecondName
*/
    public void setContactSecondName(String value)
    {
        getSemanticObject().setProperty(pymtur_contactSecondName, value);
    }

/**
* Gets the PymeWebSite property
* @return String with the PymeWebSite
*/
    public String getPymeWebSite()
    {
        return getSemanticObject().getProperty(pymtur_pymeWebSite);
    }

/**
* Sets the PymeWebSite property
* @param value long with the PymeWebSite
*/
    public void setPymeWebSite(String value)
    {
        getSemanticObject().setProperty(pymtur_pymeWebSite, value);
    }

/**
* Gets the SpEndAnnuncePeriod property
* @return java.util.Date with the SpEndAnnuncePeriod
*/
    public java.util.Date getSpEndAnnuncePeriod()
    {
        return getSemanticObject().getDateProperty(pymtur_spEndAnnuncePeriod);
    }

/**
* Sets the SpEndAnnuncePeriod property
* @param value long with the SpEndAnnuncePeriod
*/
    public void setSpEndAnnuncePeriod(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_spEndAnnuncePeriod, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.PymePhoto
   * @return A GenericIterator with all the org.semanticwb.pymtur.PymePhoto
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listInstalationsPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasInstalationsPymePhoto));
    }

   /**
   * Gets true if has a InstalationsPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to verify
   * @return true if the org.semanticwb.pymtur.PymePhoto exists, false otherwise
   */
    public boolean hasInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasInstalationsPymePhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a InstalationsPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to add
   */

    public void addInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasInstalationsPymePhoto, value.getSemanticObject());
    }
   /**
   * Removes all the InstalationsPymePhoto
   */

    public void removeAllInstalationsPymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasInstalationsPymePhoto);
    }
   /**
   * Removes a InstalationsPymePhoto
   * @param value org.semanticwb.pymtur.PymePhoto to remove
   */

    public void removeInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasInstalationsPymePhoto,value.getSemanticObject());
    }

   /**
   * Gets the InstalationsPymePhoto
   * @return a org.semanticwb.pymtur.PymePhoto
   */
    public org.semanticwb.pymtur.PymePhoto getInstalationsPymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasInstalationsPymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.Nearest
   * @return A GenericIterator with all the org.semanticwb.pymtur.Nearest
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Nearest> listNearests()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Nearest>(getSemanticObject().listObjectProperties(pymtur_hasNearest));
    }

   /**
   * Gets true if has a Nearest
   * @param value org.semanticwb.pymtur.Nearest to verify
   * @return true if the org.semanticwb.pymtur.Nearest exists, false otherwise
   */
    public boolean hasNearest(org.semanticwb.pymtur.Nearest value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasNearest,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Nearest
   * @param value org.semanticwb.pymtur.Nearest to add
   */

    public void addNearest(org.semanticwb.pymtur.Nearest value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasNearest, value.getSemanticObject());
    }
   /**
   * Removes all the Nearest
   */

    public void removeAllNearest()
    {
        getSemanticObject().removeProperty(pymtur_hasNearest);
    }
   /**
   * Removes a Nearest
   * @param value org.semanticwb.pymtur.Nearest to remove
   */

    public void removeNearest(org.semanticwb.pymtur.Nearest value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasNearest,value.getSemanticObject());
    }

   /**
   * Gets the Nearest
   * @return a org.semanticwb.pymtur.Nearest
   */
    public org.semanticwb.pymtur.Nearest getNearest()
    {
         org.semanticwb.pymtur.Nearest ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasNearest);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Nearest)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the MaxRate property
* @return float with the MaxRate
*/
    public float getMaxRate()
    {
        return getSemanticObject().getFloatProperty(pymtur_MaxRate);
    }

/**
* Sets the MaxRate property
* @param value long with the MaxRate
*/
    public void setMaxRate(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_MaxRate, value);
    }

/**
* Gets the SpFacebookUser property
* @return String with the SpFacebookUser
*/
    public String getSpFacebookUser()
    {
        return getSemanticObject().getProperty(pymtur_spFacebookUser);
    }

/**
* Sets the SpFacebookUser property
* @param value long with the SpFacebookUser
*/
    public void setSpFacebookUser(String value)
    {
        getSemanticObject().setProperty(pymtur_spFacebookUser, value);
    }
   /**
   * Sets the value for the property Destination
   * @param value Destination to set
   */

    public void setDestination(org.semanticwb.pymtur.Destination value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_destination, value.getSemanticObject());
        }else
        {
            removeDestination();
        }
    }
   /**
   * Remove the value for Destination property
   */

    public void removeDestination()
    {
        getSemanticObject().removeProperty(pymtur_destination);
    }

   /**
   * Gets the Destination
   * @return a org.semanticwb.pymtur.Destination
   */
    public org.semanticwb.pymtur.Destination getDestination()
    {
         org.semanticwb.pymtur.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_destination);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Destination)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property SpVideoYouTube
   * @param value SpVideoYouTube to set
   */

    public void setSpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_spVideoYouTube, value.getSemanticObject());
        }else
        {
            removeSpVideoYouTube();
        }
    }
   /**
   * Remove the value for SpVideoYouTube property
   */

    public void removeSpVideoYouTube()
    {
        getSemanticObject().removeProperty(pymtur_spVideoYouTube);
    }

   /**
   * Gets the SpVideoYouTube
   * @return a org.semanticwb.pymtur.VideoYouTube
   */
    public org.semanticwb.pymtur.VideoYouTube getSpVideoYouTube()
    {
         org.semanticwb.pymtur.VideoYouTube ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_spVideoYouTube);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.VideoYouTube)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NearestDescr property
* @return String with the NearestDescr
*/
    public String getNearestDescr()
    {
        return getSemanticObject().getProperty(pymtur_NearestDescr);
    }

/**
* Sets the NearestDescr property
* @param value long with the NearestDescr
*/
    public void setNearestDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_NearestDescr, value);
    }

/**
* Gets the ContactPhoneNumber property
* @return String with the ContactPhoneNumber
*/
    public String getContactPhoneNumber()
    {
        return getSemanticObject().getProperty(swbcomm_contactPhoneNumber);
    }

/**
* Sets the ContactPhoneNumber property
* @param value long with the ContactPhoneNumber
*/
    public void setContactPhoneNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactPhoneNumber, value);
    }

/**
* Gets the RfcInternalNumber property
* @return String with the RfcInternalNumber
*/
    public String getRfcInternalNumber()
    {
        return getSemanticObject().getProperty(pymtur_rfcInternalNumber);
    }

/**
* Sets the RfcInternalNumber property
* @param value long with the RfcInternalNumber
*/
    public void setRfcInternalNumber(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcInternalNumber, value);
    }

/**
* Gets the SpTwitterUser property
* @return String with the SpTwitterUser
*/
    public String getSpTwitterUser()
    {
        return getSemanticObject().getProperty(pymtur_spTwitterUser);
    }

/**
* Sets the SpTwitterUser property
* @param value long with the SpTwitterUser
*/
    public void setSpTwitterUser(String value)
    {
        getSemanticObject().setProperty(pymtur_spTwitterUser, value);
    }

/**
* Gets the SpCategoryPymePhotoCommens property
* @return String with the SpCategoryPymePhotoCommens
*/
    public String getSpCategoryPymePhotoCommens()
    {
        return getSemanticObject().getProperty(pymtur_SpCategoryPymePhotoCommens);
    }

/**
* Sets the SpCategoryPymePhotoCommens property
* @param value long with the SpCategoryPymePhotoCommens
*/
    public void setSpCategoryPymePhotoCommens(String value)
    {
        getSemanticObject().setProperty(pymtur_SpCategoryPymePhotoCommens, value);
    }

/**
* Gets the SpActivitiesDescr property
* @return String with the SpActivitiesDescr
*/
    public String getSpActivitiesDescr()
    {
        return getSemanticObject().getProperty(pymtur_spActivitiesDescr);
    }

/**
* Sets the SpActivitiesDescr property
* @param value long with the SpActivitiesDescr
*/
    public void setSpActivitiesDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_spActivitiesDescr, value);
    }

/**
* Gets the SpStatusComment property
* @return String with the SpStatusComment
*/
    public String getSpStatusComment()
    {
        return getSemanticObject().getProperty(pymtur_spStatusComment);
    }

/**
* Sets the SpStatusComment property
* @param value long with the SpStatusComment
*/
    public void setSpStatusComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spStatusComment, value);
    }

/**
* Gets the SpEstablishmentPymePhotosComments property
* @return String with the SpEstablishmentPymePhotosComments
*/
    public String getSpEstablishmentPymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spEstablishmentPymePhotosComments);
    }

/**
* Sets the SpEstablishmentPymePhotosComments property
* @param value long with the SpEstablishmentPymePhotosComments
*/
    public void setSpEstablishmentPymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spEstablishmentPymePhotosComments, value);
    }
   /**
   * Sets the value for the property PymeDomain
   * @param value PymeDomain to set
   */

    public void setPymeDomain(org.semanticwb.model.Dns value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_pymeDomain, value.getSemanticObject());
        }else
        {
            removePymeDomain();
        }
    }
   /**
   * Remove the value for PymeDomain property
   */

    public void removePymeDomain()
    {
        getSemanticObject().removeProperty(pymtur_pymeDomain);
    }

   /**
   * Gets the PymeDomain
   * @return a org.semanticwb.model.Dns
   */
    public org.semanticwb.model.Dns getPymeDomain()
    {
         org.semanticwb.model.Dns ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_pymeDomain);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Dns)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Rfc property
* @return String with the Rfc
*/
    public String getRfc()
    {
        return getSemanticObject().getProperty(pymtur_rfc);
    }

/**
* Sets the Rfc property
* @param value long with the Rfc
*/
    public void setRfc(String value)
    {
        getSemanticObject().setProperty(pymtur_rfc, value);
    }

/**
* Gets the Latitude property
* @return double with the Latitude
*/
    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(swb_latitude);
    }

/**
* Sets the Latitude property
* @param value long with the Latitude
*/
    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_latitude, value);
    }

/**
* Gets the ContactFirstName property
* @return String with the ContactFirstName
*/
    public String getContactFirstName()
    {
        return getSemanticObject().getProperty(pymtur_contactFirstName);
    }

/**
* Sets the ContactFirstName property
* @param value long with the ContactFirstName
*/
    public void setContactFirstName(String value)
    {
        getSemanticObject().setProperty(pymtur_contactFirstName, value);
    }

/**
* Gets the SpMorePymePhotosComments property
* @return String with the SpMorePymePhotosComments
*/
    public String getSpMorePymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spMorePymePhotosComments);
    }

/**
* Sets the SpMorePymePhotosComments property
* @param value long with the SpMorePymePhotosComments
*/
    public void setSpMorePymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spMorePymePhotosComments, value);
    }

/**
* Gets the SpRatesComments property
* @return String with the SpRatesComments
*/
    public String getSpRatesComments()
    {
        return getSemanticObject().getProperty(pymtur_spRatesComments);
    }

/**
* Sets the SpRatesComments property
* @param value long with the SpRatesComments
*/
    public void setSpRatesComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spRatesComments, value);
    }

/**
* Gets the MinRate property
* @return float with the MinRate
*/
    public float getMinRate()
    {
        return getSemanticObject().getFloatProperty(pymtur_MinRate);
    }

/**
* Sets the MinRate property
* @param value long with the MinRate
*/
    public void setMinRate(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_MinRate, value);
    }

/**
* Gets the RfcStreet property
* @return String with the RfcStreet
*/
    public String getRfcStreet()
    {
        return getSemanticObject().getProperty(pymtur_rfcStreet);
    }

/**
* Sets the RfcStreet property
* @param value long with the RfcStreet
*/
    public void setRfcStreet(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcStreet, value);
    }

/**
* Gets the Longitude property
* @return double with the Longitude
*/
    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(swb_longitude);
    }

/**
* Sets the Longitude property
* @param value long with the Longitude
*/
    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_longitude, value);
    }

/**
* Gets the StreetName property
* @return String with the StreetName
*/
    public String getStreetName()
    {
        return getSemanticObject().getProperty(swbcomm_streetName);
    }

/**
* Sets the StreetName property
* @param value long with the StreetName
*/
    public void setStreetName(String value)
    {
        getSemanticObject().setProperty(swbcomm_streetName, value);
    }

/**
* Gets the CityCouncil property
* @return String with the CityCouncil
*/
    public String getCityCouncil()
    {
        return getSemanticObject().getProperty(swbcomm_cityCouncil);
    }

/**
* Sets the CityCouncil property
* @param value long with the CityCouncil
*/
    public void setCityCouncil(String value)
    {
        getSemanticObject().setProperty(swbcomm_cityCouncil, value);
    }

/**
* Gets the ContactEmail property
* @return String with the ContactEmail
*/
    public String getContactEmail()
    {
        return getSemanticObject().getProperty(swbcomm_contactEmail);
    }

/**
* Sets the ContactEmail property
* @param value long with the ContactEmail
*/
    public void setContactEmail(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactEmail, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.RateSeason
   * @return A GenericIterator with all the org.semanticwb.pymtur.RateSeason
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason> listRateHighSeasons()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(getSemanticObject().listObjectProperties(pymtur_hasRateHighSeason));
    }

   /**
   * Gets true if has a RateHighSeason
   * @param value org.semanticwb.pymtur.RateSeason to verify
   * @return true if the org.semanticwb.pymtur.RateSeason exists, false otherwise
   */
    public boolean hasRateHighSeason(org.semanticwb.pymtur.RateSeason value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRateHighSeason,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a RateHighSeason
   * @param value org.semanticwb.pymtur.RateSeason to add
   */

    public void addRateHighSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasRateHighSeason, value.getSemanticObject());
    }
   /**
   * Removes all the RateHighSeason
   */

    public void removeAllRateHighSeason()
    {
        getSemanticObject().removeProperty(pymtur_hasRateHighSeason);
    }
   /**
   * Removes a RateHighSeason
   * @param value org.semanticwb.pymtur.RateSeason to remove
   */

    public void removeRateHighSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRateHighSeason,value.getSemanticObject());
    }

   /**
   * Gets the RateHighSeason
   * @return a org.semanticwb.pymtur.RateSeason
   */
    public org.semanticwb.pymtur.RateSeason getRateHighSeason()
    {
         org.semanticwb.pymtur.RateSeason ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasRateHighSeason);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.RateSeason)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.Certificates
   * @return A GenericIterator with all the org.semanticwb.pymtur.Certificates
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Certificates> listCertificates()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Certificates>(getSemanticObject().listObjectProperties(pymtur_hasCertificate));
    }

   /**
   * Gets true if has a Certificate
   * @param value org.semanticwb.pymtur.Certificates to verify
   * @return true if the org.semanticwb.pymtur.Certificates exists, false otherwise
   */
    public boolean hasCertificate(org.semanticwb.pymtur.Certificates value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasCertificate,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Certificate
   * @param value org.semanticwb.pymtur.Certificates to add
   */

    public void addCertificate(org.semanticwb.pymtur.Certificates value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasCertificate, value.getSemanticObject());
    }
   /**
   * Removes all the Certificate
   */

    public void removeAllCertificate()
    {
        getSemanticObject().removeProperty(pymtur_hasCertificate);
    }
   /**
   * Removes a Certificate
   * @param value org.semanticwb.pymtur.Certificates to remove
   */

    public void removeCertificate(org.semanticwb.pymtur.Certificates value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasCertificate,value.getSemanticObject());
    }

   /**
   * Gets the Certificate
   * @return a org.semanticwb.pymtur.Certificates
   */
    public org.semanticwb.pymtur.Certificates getCertificate()
    {
         org.semanticwb.pymtur.Certificates ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasCertificate);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Certificates)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PhotoLogo property
* @return String with the PhotoLogo
*/
    public String getPhotoLogo()
    {
        return getSemanticObject().getProperty(pymtur_PhotoLogo);
    }

/**
* Sets the PhotoLogo property
* @param value long with the PhotoLogo
*/
    public void setPhotoLogo(String value)
    {
        getSemanticObject().setProperty(pymtur_PhotoLogo, value);
    }
   /**
   * Gets all the org.semanticwb.pymtur.Rate
   * @return A GenericIterator with all the org.semanticwb.pymtur.Rate
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate> listRates()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate>(getSemanticObject().listObjectProperties(pymtur_hasRate));
    }

   /**
   * Gets true if has a Rate
   * @param value org.semanticwb.pymtur.Rate to verify
   * @return true if the org.semanticwb.pymtur.Rate exists, false otherwise
   */
    public boolean hasRate(org.semanticwb.pymtur.Rate value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRate,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Rate
   * @param value org.semanticwb.pymtur.Rate to add
   */

    public void addRate(org.semanticwb.pymtur.Rate value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasRate, value.getSemanticObject());
    }
   /**
   * Removes all the Rate
   */

    public void removeAllRate()
    {
        getSemanticObject().removeProperty(pymtur_hasRate);
    }
   /**
   * Removes a Rate
   * @param value org.semanticwb.pymtur.Rate to remove
   */

    public void removeRate(org.semanticwb.pymtur.Rate value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRate,value.getSemanticObject());
    }

   /**
   * Gets the Rate
   * @return a org.semanticwb.pymtur.Rate
   */
    public org.semanticwb.pymtur.Rate getRate()
    {
         org.semanticwb.pymtur.Rate ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasRate);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Rate)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
