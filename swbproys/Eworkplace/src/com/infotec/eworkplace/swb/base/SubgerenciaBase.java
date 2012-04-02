package com.infotec.eworkplace.swb.base;


public abstract class SubgerenciaBase extends com.infotec.eworkplace.swb.Organo implements com.infotec.eworkplace.swb.Mision,com.infotec.eworkplace.swb.Orden,com.infotec.eworkplace.swb.Extensible,org.semanticwb.model.Descriptiveable,com.infotec.eworkplace.swb.Vision
{
    public static final org.semanticwb.platform.SemanticClass intranet_Subgerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Subgerencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Subgerencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Subgerencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Subgerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Subgerencia> listSubgerencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Subgerencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Subgerencia for all models
       * @return Iterator of com.infotec.eworkplace.swb.Subgerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Subgerencia> listSubgerencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Subgerencia>(it, true);
        }

        public static com.infotec.eworkplace.swb.Subgerencia createSubgerencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Subgerencia.ClassMgr.createSubgerencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Subgerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Subgerencia
       * @param model Model of the com.infotec.eworkplace.swb.Subgerencia
       * @return A com.infotec.eworkplace.swb.Subgerencia
       */
        public static com.infotec.eworkplace.swb.Subgerencia getSubgerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Subgerencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Subgerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Subgerencia
       * @param model Model of the com.infotec.eworkplace.swb.Subgerencia
       * @return A com.infotec.eworkplace.swb.Subgerencia
       */
        public static com.infotec.eworkplace.swb.Subgerencia createSubgerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Subgerencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Subgerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Subgerencia
       * @param model Model of the com.infotec.eworkplace.swb.Subgerencia
       */
        public static void removeSubgerencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Subgerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Subgerencia
       * @param model Model of the com.infotec.eworkplace.swb.Subgerencia
       * @return true if the com.infotec.eworkplace.swb.Subgerencia exists, false otherwise
       */

        public static boolean hasSubgerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubgerencia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Subgerencia with a determined PerteneceA
       * @param value PerteneceA of the type com.infotec.eworkplace.swb.Organo
       * @param model Model of the com.infotec.eworkplace.swb.Subgerencia
       * @return Iterator with all the com.infotec.eworkplace.swb.Subgerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Subgerencia> listSubgerenciaByPerteneceA(com.infotec.eworkplace.swb.Organo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Subgerencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_perteneceA, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Subgerencia with a determined PerteneceA
       * @param value PerteneceA of the type com.infotec.eworkplace.swb.Organo
       * @return Iterator with all the com.infotec.eworkplace.swb.Subgerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Subgerencia> listSubgerenciaByPerteneceA(com.infotec.eworkplace.swb.Organo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Subgerencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_perteneceA,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SubgerenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Subgerencia
   */
    public SubgerenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property PerteneceA
   * @param value PerteneceA to set
   */

    public void setPerteneceA(com.infotec.eworkplace.swb.Organo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_perteneceA, value.getSemanticObject());
        }else
        {
            removePerteneceA();
        }
    }
   /**
   * Remove the value for PerteneceA property
   */

    public void removePerteneceA()
    {
        getSemanticObject().removeProperty(intranet_perteneceA);
    }

   /**
   * Gets the PerteneceA
   * @return a com.infotec.eworkplace.swb.Organo
   */
    public com.infotec.eworkplace.swb.Organo getPerteneceA()
    {
         com.infotec.eworkplace.swb.Organo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_perteneceA);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Organo)obj.createGenericInstance();
         }
         return ret;
    }
}
