package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar cupones 
   */
public abstract class CuponBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Para guardar el tipo de cupon del catalogo (CuponType), en este momento no se guarda, pero podria guardarse para algún fin fururo.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponType");
   /**
   * (Opcinal) : Imagen de algíun aliado de la mipyme con el que comparta la responsabilidad de lo ofrecido en el  cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponPartnerImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponPartnerImage");
   /**
   * (Opcional) : Imagen para el cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponImg=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponImg");
   /**
   * (Opcional) : Condiciones que aplican para el cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponConditions=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponConditions");
   /**
   * (Opcional) : Fecha de terminación de la promoción (ofrecido) del cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponPeriodFin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponPeriodFin");
   /**
   * Dirección (domicilio) de la empresa dónde se puede hacer efectivo el cupón
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponAddress=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponAddress");
   /**
   * Clase principal del sistema de pymes turisticas. Una instancia de esta clase es en donde se almacena toda la información de una mipyme especifica.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
   /**
   * Inversa.Mediante esta se puede saber a que mipyme pertenece cada cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponServiceProviderInv");
   /**
   * (Opcional) : Fecha de inicio de la promoción (ofrecido) del cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponPeriodIni=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponPeriodIni");
   /**
   * Clase que se encarga de administrar cupones
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Cupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");

    public static class ClassMgr
    {
       /**
       * Returns a list of Cupon for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Cupon
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCupons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Cupon for all models
       * @return Iterator of org.semanticwb.pymtur.Cupon
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCupons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon>(it, true);
        }

        public static org.semanticwb.pymtur.Cupon createCupon(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.Cupon.ClassMgr.createCupon(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.Cupon
       * @param id Identifier for org.semanticwb.pymtur.Cupon
       * @param model Model of the org.semanticwb.pymtur.Cupon
       * @return A org.semanticwb.pymtur.Cupon
       */
        public static org.semanticwb.pymtur.Cupon getCupon(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Cupon)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Cupon
       * @param id Identifier for org.semanticwb.pymtur.Cupon
       * @param model Model of the org.semanticwb.pymtur.Cupon
       * @return A org.semanticwb.pymtur.Cupon
       */
        public static org.semanticwb.pymtur.Cupon createCupon(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Cupon)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Cupon
       * @param id Identifier for org.semanticwb.pymtur.Cupon
       * @param model Model of the org.semanticwb.pymtur.Cupon
       */
        public static void removeCupon(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Cupon
       * @param id Identifier for org.semanticwb.pymtur.Cupon
       * @param model Model of the org.semanticwb.pymtur.Cupon
       * @return true if the org.semanticwb.pymtur.Cupon exists, false otherwise
       */

        public static boolean hasCupon(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCupon(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.Cupon with a determined CuponServiceProviderInv
       * @param value CuponServiceProviderInv of the type org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.Cupon
       * @return Iterator with all the org.semanticwb.pymtur.Cupon
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCuponByCuponServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_cuponServiceProviderInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Cupon with a determined CuponServiceProviderInv
       * @param value CuponServiceProviderInv of the type org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.Cupon
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCuponByCuponServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_cuponServiceProviderInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CuponBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Cupon
   */
    public CuponBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the CuponType property
* @return String with the CuponType
*/
    public String getCuponType()
    {
        return getSemanticObject().getProperty(pymtur_cuponType);
    }

/**
* Sets the CuponType property
* @param value long with the CuponType
*/
    public void setCuponType(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponType, value);
    }

/**
* Gets the CuponPartnerImage property
* @return String with the CuponPartnerImage
*/
    public String getCuponPartnerImage()
    {
        return getSemanticObject().getProperty(pymtur_cuponPartnerImage);
    }

/**
* Sets the CuponPartnerImage property
* @param value long with the CuponPartnerImage
*/
    public void setCuponPartnerImage(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponPartnerImage, value);
    }

/**
* Gets the CuponImg property
* @return String with the CuponImg
*/
    public String getCuponImg()
    {
        return getSemanticObject().getProperty(pymtur_cuponImg);
    }

/**
* Sets the CuponImg property
* @param value long with the CuponImg
*/
    public void setCuponImg(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponImg, value);
    }

/**
* Gets the CuponConditions property
* @return String with the CuponConditions
*/
    public String getCuponConditions()
    {
        return getSemanticObject().getProperty(pymtur_cuponConditions);
    }

/**
* Sets the CuponConditions property
* @param value long with the CuponConditions
*/
    public void setCuponConditions(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponConditions, value);
    }

/**
* Gets the CuponPeriodFin property
* @return String with the CuponPeriodFin
*/
    public String getCuponPeriodFin()
    {
        return getSemanticObject().getProperty(pymtur_cuponPeriodFin);
    }

/**
* Sets the CuponPeriodFin property
* @param value long with the CuponPeriodFin
*/
    public void setCuponPeriodFin(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponPeriodFin, value);
    }

/**
* Gets the CuponAddress property
* @return String with the CuponAddress
*/
    public String getCuponAddress()
    {
        return getSemanticObject().getProperty(pymtur_cuponAddress);
    }

/**
* Sets the CuponAddress property
* @param value long with the CuponAddress
*/
    public void setCuponAddress(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponAddress, value);
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }
   /**
   * Sets the value for the property CuponServiceProviderInv
   * @param value CuponServiceProviderInv to set
   */

    public void setCuponServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_cuponServiceProviderInv, value.getSemanticObject());
        }else
        {
            removeCuponServiceProviderInv();
        }
    }
   /**
   * Remove the value for CuponServiceProviderInv property
   */

    public void removeCuponServiceProviderInv()
    {
        getSemanticObject().removeProperty(pymtur_cuponServiceProviderInv);
    }

   /**
   * Gets the CuponServiceProviderInv
   * @return a org.semanticwb.pymtur.ServiceProvider
   */
    public org.semanticwb.pymtur.ServiceProvider getCuponServiceProviderInv()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_cuponServiceProviderInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

/**
* Gets the CuponPeriodIni property
* @return String with the CuponPeriodIni
*/
    public String getCuponPeriodIni()
    {
        return getSemanticObject().getProperty(pymtur_cuponPeriodIni);
    }

/**
* Sets the CuponPeriodIni property
* @param value long with the CuponPeriodIni
*/
    public void setCuponPeriodIni(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponPeriodIni, value);
    }
}
