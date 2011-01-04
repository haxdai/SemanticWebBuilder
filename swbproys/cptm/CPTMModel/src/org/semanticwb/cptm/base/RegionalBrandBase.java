package org.semanticwb.cptm.base;


   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya) 
   */
public abstract class RegionalBrandBase extends org.semanticwb.model.SWBClass implements org.semanticwb.cptm.LocalityInt,org.semanticwb.model.Descriptiveable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeographicPoint");
   /**
   * Destinos con los que esta conformada la "Marca Regional".Pudiera ser cualaquier subclase de la clase "GeographicPoint"
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasRegGeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasRegGeographicPoint");
   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_RegionalBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");

    public static class ClassMgr
    {
       /**
       * Returns a list of RegionalBrand for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrands(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.RegionalBrand for all models
       * @return Iterator of org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrands()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return A org.semanticwb.cptm.RegionalBrand
       */
        public static org.semanticwb.cptm.RegionalBrand getRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.RegionalBrand)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return A org.semanticwb.cptm.RegionalBrand
       */
        public static org.semanticwb.cptm.RegionalBrand createRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.RegionalBrand)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       */
        public static void removeRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return true if the org.semanticwb.cptm.RegionalBrand exists, false otherwise
       */

        public static boolean hasRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRegionalBrand(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByNewGeographicPointInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByNewGeographicPointInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegGeographicPoint
       * @param value RegGeographicPoint of the type org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPoint, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegGeographicPoint
       * @param value RegGeographicPoint of the type org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPoint,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined GeographicPointProxInv
       * @param value GeographicPointProxInv of the type org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByGeographicPointProxInv(org.semanticwb.cptm.Proximity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointProxInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined GeographicPointProxInv
       * @param value GeographicPointProxInv of the type org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByGeographicPointProxInv(org.semanticwb.cptm.Proximity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointProxInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByEventGeographicPointInv(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_eventGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByEventGeographicPointInv(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_eventGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined PromotionInv
       * @param value PromotionInv of the type org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByPromotionInv(org.semanticwb.cptm.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotionInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined PromotionInv
       * @param value PromotionInv of the type org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByPromotionInv(org.semanticwb.cptm.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotionInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a RegionalBrandBase with a SemanticObject
   * @param base The SemanticObject with the properties for the RegionalBrand
   */
    public RegionalBrandBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.New
   * @return A GenericIterator with all the org.semanticwb.cptm.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New> listNewGeographicPointInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New>(getSemanticObject().listObjectProperties(cptm_hasNewGeographicPointInv));
    }

   /**
   * Gets true if has a NewGeographicPointInv
   * @param value org.semanticwb.cptm.New to verify
   * @return true if the org.semanticwb.cptm.New exists, false otherwise
   */
    public boolean hasNewGeographicPointInv(org.semanticwb.cptm.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNewGeographicPointInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NewGeographicPointInv
   * @return a org.semanticwb.cptm.New
   */
    public org.semanticwb.cptm.New getNewGeographicPointInv()
    {
         org.semanticwb.cptm.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNewGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.New)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.GeographicPoint
   * @return A GenericIterator with all the org.semanticwb.cptm.GeographicPoint
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> listRegGeographicPoints()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint>(getSemanticObject().listObjectProperties(cptm_hasRegGeographicPoint));
    }

   /**
   * Gets true if has a RegGeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to verify
   * @return true if the org.semanticwb.cptm.GeographicPoint exists, false otherwise
   */
    public boolean hasRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasRegGeographicPoint,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a RegGeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to add
   */

    public void addRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        getSemanticObject().addObjectProperty(cptm_hasRegGeographicPoint, value.getSemanticObject());
    }
   /**
   * Removes all the RegGeographicPoint
   */

    public void removeAllRegGeographicPoint()
    {
        getSemanticObject().removeProperty(cptm_hasRegGeographicPoint);
    }
   /**
   * Removes a RegGeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to remove
   */

    public void removeRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasRegGeographicPoint,value.getSemanticObject());
    }

   /**
   * Gets the RegGeographicPoint
   * @return a org.semanticwb.cptm.GeographicPoint
   */
    public org.semanticwb.cptm.GeographicPoint getRegGeographicPoint()
    {
         org.semanticwb.cptm.GeographicPoint ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasRegGeographicPoint);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeographicPoint)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Proximity
   * @return A GenericIterator with all the org.semanticwb.cptm.Proximity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> listGeographicPointProxInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity>(getSemanticObject().listObjectProperties(cptm_hasGeographicPointProxInv));
    }

   /**
   * Gets true if has a GeographicPointProxInv
   * @param value org.semanticwb.cptm.Proximity to verify
   * @return true if the org.semanticwb.cptm.Proximity exists, false otherwise
   */
    public boolean hasGeographicPointProxInv(org.semanticwb.cptm.Proximity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasGeographicPointProxInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the GeographicPointProxInv
   * @return a org.semanticwb.cptm.Proximity
   */
    public org.semanticwb.cptm.Proximity getGeographicPointProxInv()
    {
         org.semanticwb.cptm.Proximity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasGeographicPointProxInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Proximity)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EventGeographicPointInv
   * @param value EventGeographicPointInv to set
   */

    public void setEventGeographicPointInv(org.semanticwb.cptm.Event value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_eventGeographicPointInv, value.getSemanticObject());
        }else
        {
            removeEventGeographicPointInv();
        }
    }
   /**
   * Remove the value for EventGeographicPointInv property
   */

    public void removeEventGeographicPointInv()
    {
        getSemanticObject().removeProperty(cptm_eventGeographicPointInv);
    }

   /**
   * Gets the EventGeographicPointInv
   * @return a org.semanticwb.cptm.Event
   */
    public org.semanticwb.cptm.Event getEventGeographicPointInv()
    {
         org.semanticwb.cptm.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_eventGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Event)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Promotion
   * @return A GenericIterator with all the org.semanticwb.cptm.Promotion
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> listPromotionInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion>(getSemanticObject().listObjectProperties(cptm_hasPromotionInv));
    }

   /**
   * Gets true if has a PromotionInv
   * @param value org.semanticwb.cptm.Promotion to verify
   * @return true if the org.semanticwb.cptm.Promotion exists, false otherwise
   */
    public boolean hasPromotionInv(org.semanticwb.cptm.Promotion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasPromotionInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the PromotionInv
   * @return a org.semanticwb.cptm.Promotion
   */
    public org.semanticwb.cptm.Promotion getPromotionInv()
    {
         org.semanticwb.cptm.Promotion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasPromotionInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Promotion)obj.createGenericInstance();
         }
         return ret;
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
   * Gets all the org.semanticwb.cptm.TravelRoute
   * @return A GenericIterator with all the org.semanticwb.cptm.TravelRoute
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> listTravelRouteInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute>(getSemanticObject().listObjectProperties(cptm_hasTravelRouteInv));
    }

   /**
   * Gets true if has a TravelRouteInv
   * @param value org.semanticwb.cptm.TravelRoute to verify
   * @return true if the org.semanticwb.cptm.TravelRoute exists, false otherwise
   */
    public boolean hasTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasTravelRouteInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the TravelRouteInv
   * @return a org.semanticwb.cptm.TravelRoute
   */
    public org.semanticwb.cptm.TravelRoute getTravelRouteInv()
    {
         org.semanticwb.cptm.TravelRoute ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasTravelRouteInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TravelRoute)obj.createGenericInstance();
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
}
