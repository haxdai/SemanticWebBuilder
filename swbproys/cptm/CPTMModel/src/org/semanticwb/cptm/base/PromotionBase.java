package org.semanticwb.cptm.base;


   /**
   * Catálogo de promociones, las cuales pueden relacionarse con uno o varios Destinos, Estados y Empresas (Ver viabilidad) 
   */
public abstract class PromotionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Resourceable
{
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasLocalidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasLocalidad");
   /**
   * Catálogo de promociones, las cuales pueden relacionarse con uno o varios Destinos, Estados y Empresas (Ver viabilidad)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Promotion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Promotion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Promotion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Promotion for all models
       * @return Iterator of org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return A org.semanticwb.cptm.Promotion
       */
        public static org.semanticwb.cptm.Promotion getPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Promotion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return A org.semanticwb.cptm.Promotion
       */
        public static org.semanticwb.cptm.Promotion createPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Promotion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       */
        public static void removePromotion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Promotion
       * @param id Identifier for org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return true if the org.semanticwb.cptm.Promotion exists, false otherwise
       */

        public static boolean hasPromotion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPromotion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined Localidad
       * @param value Localidad of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByLocalidad(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalidad, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined Localidad
       * @param value Localidad of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByLocalidad(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalidad,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Promotion with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.Promotion
       */

        public static java.util.Iterator<org.semanticwb.cptm.Promotion> listPromotionByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PromotionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Promotion
   */
    public PromotionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listLocalidads()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasLocalidad));
    }

   /**
   * Gets true if has a Localidad
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasLocalidad(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasLocalidad,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Localidad
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addLocalidad(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasLocalidad, value.getSemanticObject());
    }
   /**
   * Removes all the Localidad
   */

    public void removeAllLocalidad()
    {
        getSemanticObject().removeProperty(cptm_hasLocalidad);
    }
   /**
   * Removes a Localidad
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeLocalidad(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasLocalidad,value.getSemanticObject());
    }

   /**
   * Gets the Localidad
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getLocalidad()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasLocalidad);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.model.Resource
   * @return A GenericIterator with all the org.semanticwb.model.Resource
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource> listResources()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource>(getSemanticObject().listObjectProperties(swb_hasResource));
    }

   /**
   * Gets true if has a Resource
   * @param value org.semanticwb.model.Resource to verify
   * @return true if the org.semanticwb.model.Resource exists, false otherwise
   */
    public boolean hasResource(org.semanticwb.model.Resource value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasResource,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Resource
   * @param value org.semanticwb.model.Resource to add
   */

    public void addResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().addObjectProperty(swb_hasResource, value.getSemanticObject());
    }
   /**
   * Removes all the Resource
   */

    public void removeAllResource()
    {
        getSemanticObject().removeProperty(swb_hasResource);
    }
   /**
   * Removes a Resource
   * @param value org.semanticwb.model.Resource to remove
   */

    public void removeResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().removeObjectProperty(swb_hasResource,value.getSemanticObject());
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasResource);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }
}
