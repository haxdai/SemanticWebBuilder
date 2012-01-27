package com.infotec.eworkplace.swb.base;


public abstract class GerenciaBase extends com.infotec.eworkplace.swb.Organo implements com.infotec.eworkplace.swb.Vision,com.infotec.eworkplace.swb.Mision,com.infotec.eworkplace.swb.Extensible,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Subgerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Subgerencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasSubgerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasSubgerencia");
    public static final org.semanticwb.platform.SemanticClass intranet_Gerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Gerencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Gerencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Gerencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Gerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Gerencia> listGerencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Gerencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Gerencia for all models
       * @return Iterator of com.infotec.eworkplace.swb.Gerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Gerencia> listGerencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Gerencia>(it, true);
        }

        public static com.infotec.eworkplace.swb.Gerencia createGerencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Gerencia.ClassMgr.createGerencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Gerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Gerencia
       * @param model Model of the com.infotec.eworkplace.swb.Gerencia
       * @return A com.infotec.eworkplace.swb.Gerencia
       */
        public static com.infotec.eworkplace.swb.Gerencia getGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Gerencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Gerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Gerencia
       * @param model Model of the com.infotec.eworkplace.swb.Gerencia
       * @return A com.infotec.eworkplace.swb.Gerencia
       */
        public static com.infotec.eworkplace.swb.Gerencia createGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Gerencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Gerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Gerencia
       * @param model Model of the com.infotec.eworkplace.swb.Gerencia
       */
        public static void removeGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Gerencia
       * @param id Identifier for com.infotec.eworkplace.swb.Gerencia
       * @param model Model of the com.infotec.eworkplace.swb.Gerencia
       * @return true if the com.infotec.eworkplace.swb.Gerencia exists, false otherwise
       */

        public static boolean hasGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGerencia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Gerencia with a determined Subgerencia
       * @param value Subgerencia of the type com.infotec.eworkplace.swb.Subgerencia
       * @param model Model of the com.infotec.eworkplace.swb.Gerencia
       * @return Iterator with all the com.infotec.eworkplace.swb.Gerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Gerencia> listGerenciaBySubgerencia(com.infotec.eworkplace.swb.Subgerencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Gerencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasSubgerencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Gerencia with a determined Subgerencia
       * @param value Subgerencia of the type com.infotec.eworkplace.swb.Subgerencia
       * @return Iterator with all the com.infotec.eworkplace.swb.Gerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Gerencia> listGerenciaBySubgerencia(com.infotec.eworkplace.swb.Subgerencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Gerencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasSubgerencia,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GerenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Gerencia
   */
    public GerenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Subgerencia
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Subgerencia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Subgerencia> listSubgerencias()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Subgerencia>(getSemanticObject().listObjectProperties(intranet_hasSubgerencia));
    }

   /**
   * Gets true if has a Subgerencia
   * @param value com.infotec.eworkplace.swb.Subgerencia to verify
   * @return true if the com.infotec.eworkplace.swb.Subgerencia exists, false otherwise
   */
    public boolean hasSubgerencia(com.infotec.eworkplace.swb.Subgerencia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasSubgerencia,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Subgerencia
   * @param value com.infotec.eworkplace.swb.Subgerencia to add
   */

    public void addSubgerencia(com.infotec.eworkplace.swb.Subgerencia value)
    {
        getSemanticObject().addObjectProperty(intranet_hasSubgerencia, value.getSemanticObject());
    }
   /**
   * Removes all the Subgerencia
   */

    public void removeAllSubgerencia()
    {
        getSemanticObject().removeProperty(intranet_hasSubgerencia);
    }
   /**
   * Removes a Subgerencia
   * @param value com.infotec.eworkplace.swb.Subgerencia to remove
   */

    public void removeSubgerencia(com.infotec.eworkplace.swb.Subgerencia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasSubgerencia,value.getSemanticObject());
    }

   /**
   * Gets the Subgerencia
   * @return a com.infotec.eworkplace.swb.Subgerencia
   */
    public com.infotec.eworkplace.swb.Subgerencia getSubgerencia()
    {
         com.infotec.eworkplace.swb.Subgerencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasSubgerencia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Subgerencia)obj.createGenericInstance();
         }
         return ret;
    }
}
