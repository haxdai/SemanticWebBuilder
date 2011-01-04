package org.semanticwb.cptm.base;


public abstract class FestivityRefBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_festLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#festLocality");
   /**
   * Clase que se encarga de administrar Festividades. Ej. "Día de Muertos"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Festivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Festivity");
    public static final org.semanticwb.platform.SemanticProperty cptm_festFestivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#festFestivity");
    public static final org.semanticwb.platform.SemanticClass cptm_FestivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#FestivityRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#FestivityRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of FestivityRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.FestivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.FestivityRef> listFestivityRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.FestivityRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.FestivityRef for all models
       * @return Iterator of org.semanticwb.cptm.FestivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.FestivityRef> listFestivityRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.FestivityRef>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.FestivityRef
       * @param id Identifier for org.semanticwb.cptm.FestivityRef
       * @param model Model of the org.semanticwb.cptm.FestivityRef
       * @return A org.semanticwb.cptm.FestivityRef
       */
        public static org.semanticwb.cptm.FestivityRef getFestivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.FestivityRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.FestivityRef
       * @param id Identifier for org.semanticwb.cptm.FestivityRef
       * @param model Model of the org.semanticwb.cptm.FestivityRef
       * @return A org.semanticwb.cptm.FestivityRef
       */
        public static org.semanticwb.cptm.FestivityRef createFestivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.FestivityRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.FestivityRef
       * @param id Identifier for org.semanticwb.cptm.FestivityRef
       * @param model Model of the org.semanticwb.cptm.FestivityRef
       */
        public static void removeFestivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.FestivityRef
       * @param id Identifier for org.semanticwb.cptm.FestivityRef
       * @param model Model of the org.semanticwb.cptm.FestivityRef
       * @return true if the org.semanticwb.cptm.FestivityRef exists, false otherwise
       */

        public static boolean hasFestivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFestivityRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.FestivityRef with a determined FestLocality
       * @param value FestLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.FestivityRef
       * @return Iterator with all the org.semanticwb.cptm.FestivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.FestivityRef> listFestivityRefByFestLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.FestivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_festLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.FestivityRef with a determined FestLocality
       * @param value FestLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.FestivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.FestivityRef> listFestivityRefByFestLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.FestivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_festLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.FestivityRef with a determined FestFestivity
       * @param value FestFestivity of the type org.semanticwb.cptm.Festivity
       * @param model Model of the org.semanticwb.cptm.FestivityRef
       * @return Iterator with all the org.semanticwb.cptm.FestivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.FestivityRef> listFestivityRefByFestFestivity(org.semanticwb.cptm.Festivity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.FestivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_festFestivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.FestivityRef with a determined FestFestivity
       * @param value FestFestivity of the type org.semanticwb.cptm.Festivity
       * @return Iterator with all the org.semanticwb.cptm.FestivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.FestivityRef> listFestivityRefByFestFestivity(org.semanticwb.cptm.Festivity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.FestivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_festFestivity,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a FestivityRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the FestivityRef
   */
    public FestivityRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property FestLocality
   * @param value FestLocality to set
   */

    public void setFestLocality(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_festLocality, value.getSemanticObject());
        }else
        {
            removeFestLocality();
        }
    }
   /**
   * Remove the value for FestLocality property
   */

    public void removeFestLocality()
    {
        getSemanticObject().removeProperty(cptm_festLocality);
    }

   /**
   * Gets the FestLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getFestLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_festLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property FestFestivity
   * @param value FestFestivity to set
   */

    public void setFestFestivity(org.semanticwb.cptm.Festivity value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_festFestivity, value.getSemanticObject());
        }else
        {
            removeFestFestivity();
        }
    }
   /**
   * Remove the value for FestFestivity property
   */

    public void removeFestFestivity()
    {
        getSemanticObject().removeProperty(cptm_festFestivity);
    }

   /**
   * Gets the FestFestivity
   * @return a org.semanticwb.cptm.Festivity
   */
    public org.semanticwb.cptm.Festivity getFestFestivity()
    {
         org.semanticwb.cptm.Festivity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_festFestivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Festivity)obj.createGenericInstance();
         }
         return ret;
    }
}
