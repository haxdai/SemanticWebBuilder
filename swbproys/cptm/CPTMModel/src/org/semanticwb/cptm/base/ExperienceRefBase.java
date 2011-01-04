package org.semanticwb.cptm.base;


   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class ExperienceRefBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");
    public static final org.semanticwb.platform.SemanticProperty cptm_expExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#expExperience");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_ExpLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#ExpLocality");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of ExperienceRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ExperienceRef for all models
       * @return Iterator of org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return A org.semanticwb.cptm.ExperienceRef
       */
        public static org.semanticwb.cptm.ExperienceRef getExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ExperienceRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return A org.semanticwb.cptm.ExperienceRef
       */
        public static org.semanticwb.cptm.ExperienceRef createExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ExperienceRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       */
        public static void removeExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return true if the org.semanticwb.cptm.ExperienceRef exists, false otherwise
       */

        public static boolean hasExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getExperienceRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ExpExperience
       * @param value ExpExperience of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByExpExperience(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_expExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ExpExperience
       * @param value ExpExperience of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByExpExperience(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_expExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ExpLocality
       * @param value ExpLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByExpLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ExpLocality
       * @param value ExpLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByExpLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocality,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ExperienceRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ExperienceRef
   */
    public ExperienceRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ExpExperience
   * @param value ExpExperience to set
   */

    public void setExpExperience(org.semanticwb.cptm.Experience value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_expExperience, value.getSemanticObject());
        }else
        {
            removeExpExperience();
        }
    }
   /**
   * Remove the value for ExpExperience property
   */

    public void removeExpExperience()
    {
        getSemanticObject().removeProperty(cptm_expExperience);
    }

   /**
   * Gets the ExpExperience
   * @return a org.semanticwb.cptm.Experience
   */
    public org.semanticwb.cptm.Experience getExpExperience()
    {
         org.semanticwb.cptm.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_expExperience);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Experience)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ExpLocality
   * @param value ExpLocality to set
   */

    public void setExpLocality(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_ExpLocality, value.getSemanticObject());
        }else
        {
            removeExpLocality();
        }
    }
   /**
   * Remove the value for ExpLocality property
   */

    public void removeExpLocality()
    {
        getSemanticObject().removeProperty(cptm_ExpLocality);
    }

   /**
   * Gets the ExpLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getExpLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_ExpLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
}
