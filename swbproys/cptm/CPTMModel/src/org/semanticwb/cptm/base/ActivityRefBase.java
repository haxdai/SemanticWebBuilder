package org.semanticwb.cptm.base;


   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class ActivityRefBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefActivity");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefLocality");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of ActivityRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ActivityRef for all models
       * @return Iterator of org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return A org.semanticwb.cptm.ActivityRef
       */
        public static org.semanticwb.cptm.ActivityRef getActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return A org.semanticwb.cptm.ActivityRef
       */
        public static org.semanticwb.cptm.ActivityRef createActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       */
        public static void removeActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return true if the org.semanticwb.cptm.ActivityRef exists, false otherwise
       */

        public static boolean hasActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActivityRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ArefActivity
       * @param value ArefActivity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByArefActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ArefActivity
       * @param value ArefActivity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByArefActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ArefLocality
       * @param value ArefLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByArefLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ArefLocality
       * @param value ArefLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByArefLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocality,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ActivityRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ActivityRef
   */
    public ActivityRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ArefActivity
   * @param value ArefActivity to set
   */

    public void setArefActivity(org.semanticwb.cptm.Activity value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefActivity, value.getSemanticObject());
        }else
        {
            removeArefActivity();
        }
    }
   /**
   * Remove the value for ArefActivity property
   */

    public void removeArefActivity()
    {
        getSemanticObject().removeProperty(cptm_arefActivity);
    }

   /**
   * Gets the ArefActivity
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getArefActivity()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Activity)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ArefLocality
   * @param value ArefLocality to set
   */

    public void setArefLocality(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefLocality, value.getSemanticObject());
        }else
        {
            removeArefLocality();
        }
    }
   /**
   * Remove the value for ArefLocality property
   */

    public void removeArefLocality()
    {
        getSemanticObject().removeProperty(cptm_arefLocality);
    }

   /**
   * Gets the ArefLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getArefLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
}
