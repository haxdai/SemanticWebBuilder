package com.infotec.eworkplace.swb.base;


public abstract class DireccionAdjuntaBase extends com.infotec.eworkplace.swb.Organo implements org.semanticwb.model.Descriptiveable,com.infotec.eworkplace.swb.Mision,com.infotec.eworkplace.swb.Vision,com.infotec.eworkplace.swb.Extensible
{
    public static final org.semanticwb.platform.SemanticClass intranet_Gerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Gerencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasGerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasGerencia");
    public static final org.semanticwb.platform.SemanticClass intranet_DireccionAdjunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DireccionAdjunta");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DireccionAdjunta");

    public static class ClassMgr
    {
       /**
       * Returns a list of DireccionAdjunta for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.DireccionAdjunta
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionAdjunta> listDireccionAdjuntas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionAdjunta>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.DireccionAdjunta for all models
       * @return Iterator of com.infotec.eworkplace.swb.DireccionAdjunta
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionAdjunta> listDireccionAdjuntas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionAdjunta>(it, true);
        }

        public static com.infotec.eworkplace.swb.DireccionAdjunta createDireccionAdjunta(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.DireccionAdjunta.ClassMgr.createDireccionAdjunta(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.DireccionAdjunta
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionAdjunta
       * @param model Model of the com.infotec.eworkplace.swb.DireccionAdjunta
       * @return A com.infotec.eworkplace.swb.DireccionAdjunta
       */
        public static com.infotec.eworkplace.swb.DireccionAdjunta getDireccionAdjunta(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.DireccionAdjunta)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.DireccionAdjunta
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionAdjunta
       * @param model Model of the com.infotec.eworkplace.swb.DireccionAdjunta
       * @return A com.infotec.eworkplace.swb.DireccionAdjunta
       */
        public static com.infotec.eworkplace.swb.DireccionAdjunta createDireccionAdjunta(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.DireccionAdjunta)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.DireccionAdjunta
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionAdjunta
       * @param model Model of the com.infotec.eworkplace.swb.DireccionAdjunta
       */
        public static void removeDireccionAdjunta(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.DireccionAdjunta
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionAdjunta
       * @param model Model of the com.infotec.eworkplace.swb.DireccionAdjunta
       * @return true if the com.infotec.eworkplace.swb.DireccionAdjunta exists, false otherwise
       */

        public static boolean hasDireccionAdjunta(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDireccionAdjunta(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DireccionAdjunta with a determined Gerencia
       * @param value Gerencia of the type com.infotec.eworkplace.swb.Gerencia
       * @param model Model of the com.infotec.eworkplace.swb.DireccionAdjunta
       * @return Iterator with all the com.infotec.eworkplace.swb.DireccionAdjunta
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionAdjunta> listDireccionAdjuntaByGerencia(com.infotec.eworkplace.swb.Gerencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionAdjunta> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGerencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DireccionAdjunta with a determined Gerencia
       * @param value Gerencia of the type com.infotec.eworkplace.swb.Gerencia
       * @return Iterator with all the com.infotec.eworkplace.swb.DireccionAdjunta
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionAdjunta> listDireccionAdjuntaByGerencia(com.infotec.eworkplace.swb.Gerencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionAdjunta> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGerencia,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DireccionAdjuntaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DireccionAdjunta
   */
    public DireccionAdjuntaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Gerencia
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Gerencia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Gerencia> listGerencias()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Gerencia>(getSemanticObject().listObjectProperties(intranet_hasGerencia));
    }

   /**
   * Gets true if has a Gerencia
   * @param value com.infotec.eworkplace.swb.Gerencia to verify
   * @return true if the com.infotec.eworkplace.swb.Gerencia exists, false otherwise
   */
    public boolean hasGerencia(com.infotec.eworkplace.swb.Gerencia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasGerencia,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Gerencia
   * @param value com.infotec.eworkplace.swb.Gerencia to add
   */

    public void addGerencia(com.infotec.eworkplace.swb.Gerencia value)
    {
        getSemanticObject().addObjectProperty(intranet_hasGerencia, value.getSemanticObject());
    }
   /**
   * Removes all the Gerencia
   */

    public void removeAllGerencia()
    {
        getSemanticObject().removeProperty(intranet_hasGerencia);
    }
   /**
   * Removes a Gerencia
   * @param value com.infotec.eworkplace.swb.Gerencia to remove
   */

    public void removeGerencia(com.infotec.eworkplace.swb.Gerencia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasGerencia,value.getSemanticObject());
    }

   /**
   * Gets the Gerencia
   * @return a com.infotec.eworkplace.swb.Gerencia
   */
    public com.infotec.eworkplace.swb.Gerencia getGerencia()
    {
         com.infotec.eworkplace.swb.Gerencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasGerencia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Gerencia)obj.createGenericInstance();
         }
         return ret;
    }
}
