package org.semanticwb.cptm.base;


   /**
   * Relación de cercanias entre dos puntos geográficos 
   */
public abstract class ProximityBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
   /**
   * Relación de cercania entre dos puntos geográficos
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasLocalityProx=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasLocalityProx");
   /**
   * Relación de cercanias entre dos puntos geográficos
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Proximity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Proximity");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Proximity");

    public static class ClassMgr
    {
       /**
       * Returns a list of Proximity for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximities(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Proximity for all models
       * @return Iterator of org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximities()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity>(it, true);
        }

        public static org.semanticwb.cptm.Proximity createProximity(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.cptm.Proximity.ClassMgr.createProximity(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return A org.semanticwb.cptm.Proximity
       */
        public static org.semanticwb.cptm.Proximity getProximity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Proximity)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return A org.semanticwb.cptm.Proximity
       */
        public static org.semanticwb.cptm.Proximity createProximity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Proximity)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       */
        public static void removeProximity(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Proximity
       * @param id Identifier for org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return true if the org.semanticwb.cptm.Proximity exists, false otherwise
       */

        public static boolean hasProximity(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProximity(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined LocalityProx
       * @param value LocalityProx of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByLocalityProx(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityProx, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Proximity with a determined LocalityProx
       * @param value LocalityProx of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Proximity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Proximity> listProximityByLocalityProx(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityProx,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProximityBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Proximity
   */
    public ProximityBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listLocalityProxes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasLocalityProx));
    }

   /**
   * Gets true if has a LocalityProx
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasLocalityProx(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasLocalityProx,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a LocalityProx
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addLocalityProx(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasLocalityProx, value.getSemanticObject());
    }
   /**
   * Removes all the LocalityProx
   */

    public void removeAllLocalityProx()
    {
        getSemanticObject().removeProperty(cptm_hasLocalityProx);
    }
   /**
   * Removes a LocalityProx
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeLocalityProx(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasLocalityProx,value.getSemanticObject());
    }

   /**
   * Gets the LocalityProx
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getLocalityProx()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasLocalityProx);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
}
