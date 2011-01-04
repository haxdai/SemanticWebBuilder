package org.semanticwb.cptm.base;


public abstract class TravelStyleRefBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Clase que se encarga del catalogo de "Estilos de Viaje"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelStyle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyle");
    public static final org.semanticwb.platform.SemanticProperty cptm_tsrefTravelStyle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#tsrefTravelStyle");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_tsrefLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#tsrefLocality");
    public static final org.semanticwb.platform.SemanticClass cptm_TravelStyleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyleRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyleRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of TravelStyleRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.TravelStyleRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleRef> listTravelStyleRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.TravelStyleRef for all models
       * @return Iterator of org.semanticwb.cptm.TravelStyleRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleRef> listTravelStyleRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleRef>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.TravelStyleRef
       * @param id Identifier for org.semanticwb.cptm.TravelStyleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleRef
       * @return A org.semanticwb.cptm.TravelStyleRef
       */
        public static org.semanticwb.cptm.TravelStyleRef getTravelStyleRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelStyleRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.TravelStyleRef
       * @param id Identifier for org.semanticwb.cptm.TravelStyleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleRef
       * @return A org.semanticwb.cptm.TravelStyleRef
       */
        public static org.semanticwb.cptm.TravelStyleRef createTravelStyleRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelStyleRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.TravelStyleRef
       * @param id Identifier for org.semanticwb.cptm.TravelStyleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleRef
       */
        public static void removeTravelStyleRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.TravelStyleRef
       * @param id Identifier for org.semanticwb.cptm.TravelStyleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleRef
       * @return true if the org.semanticwb.cptm.TravelStyleRef exists, false otherwise
       */

        public static boolean hasTravelStyleRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTravelStyleRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleRef with a determined TsrefTravelStyle
       * @param value TsrefTravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.TravelStyleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleRef> listTravelStyleRefByTsrefTravelStyle(org.semanticwb.cptm.TravelStyle value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_tsrefTravelStyle, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleRef with a determined TsrefTravelStyle
       * @param value TsrefTravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleRef> listTravelStyleRefByTsrefTravelStyle(org.semanticwb.cptm.TravelStyle value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_tsrefTravelStyle,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleRef with a determined TsrefLocality
       * @param value TsrefLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.TravelStyleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleRef> listTravelStyleRefByTsrefLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_tsrefLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleRef with a determined TsrefLocality
       * @param value TsrefLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleRef> listTravelStyleRefByTsrefLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_tsrefLocality,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TravelStyleRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TravelStyleRef
   */
    public TravelStyleRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property TsrefTravelStyle
   * @param value TsrefTravelStyle to set
   */

    public void setTsrefTravelStyle(org.semanticwb.cptm.TravelStyle value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_tsrefTravelStyle, value.getSemanticObject());
        }else
        {
            removeTsrefTravelStyle();
        }
    }
   /**
   * Remove the value for TsrefTravelStyle property
   */

    public void removeTsrefTravelStyle()
    {
        getSemanticObject().removeProperty(cptm_tsrefTravelStyle);
    }

   /**
   * Gets the TsrefTravelStyle
   * @return a org.semanticwb.cptm.TravelStyle
   */
    public org.semanticwb.cptm.TravelStyle getTsrefTravelStyle()
    {
         org.semanticwb.cptm.TravelStyle ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_tsrefTravelStyle);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TravelStyle)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property TsrefLocality
   * @param value TsrefLocality to set
   */

    public void setTsrefLocality(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_tsrefLocality, value.getSemanticObject());
        }else
        {
            removeTsrefLocality();
        }
    }
   /**
   * Remove the value for TsrefLocality property
   */

    public void removeTsrefLocality()
    {
        getSemanticObject().removeProperty(cptm_tsrefLocality);
    }

   /**
   * Gets the TsrefLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getTsrefLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_tsrefLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
}
