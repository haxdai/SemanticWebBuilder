package com.infotec.eworkplace.swb.base;


public abstract class DireccionEjecutivaBase extends com.infotec.eworkplace.swb.Organo implements org.semanticwb.model.Descriptiveable,com.infotec.eworkplace.swb.Vision,com.infotec.eworkplace.swb.Extensible,com.infotec.eworkplace.swb.Mision
{
    public static final org.semanticwb.platform.SemanticClass intranet_DireccionAdjunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DireccionAdjunta");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDireccionAdjunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDireccionAdjunta");
    public static final org.semanticwb.platform.SemanticClass intranet_DireccionEjecutiva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DireccionEjecutiva");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DireccionEjecutiva");

    public static class ClassMgr
    {
       /**
       * Returns a list of DireccionEjecutiva for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.DireccionEjecutiva
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionEjecutiva> listDireccionEjecutivas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionEjecutiva>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.DireccionEjecutiva for all models
       * @return Iterator of com.infotec.eworkplace.swb.DireccionEjecutiva
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionEjecutiva> listDireccionEjecutivas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionEjecutiva>(it, true);
        }

        public static com.infotec.eworkplace.swb.DireccionEjecutiva createDireccionEjecutiva(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.DireccionEjecutiva.ClassMgr.createDireccionEjecutiva(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param model Model of the com.infotec.eworkplace.swb.DireccionEjecutiva
       * @return A com.infotec.eworkplace.swb.DireccionEjecutiva
       */
        public static com.infotec.eworkplace.swb.DireccionEjecutiva getDireccionEjecutiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.DireccionEjecutiva)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param model Model of the com.infotec.eworkplace.swb.DireccionEjecutiva
       * @return A com.infotec.eworkplace.swb.DireccionEjecutiva
       */
        public static com.infotec.eworkplace.swb.DireccionEjecutiva createDireccionEjecutiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.DireccionEjecutiva)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param model Model of the com.infotec.eworkplace.swb.DireccionEjecutiva
       */
        public static void removeDireccionEjecutiva(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param id Identifier for com.infotec.eworkplace.swb.DireccionEjecutiva
       * @param model Model of the com.infotec.eworkplace.swb.DireccionEjecutiva
       * @return true if the com.infotec.eworkplace.swb.DireccionEjecutiva exists, false otherwise
       */

        public static boolean hasDireccionEjecutiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDireccionEjecutiva(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DireccionEjecutiva with a determined DireccionAdjunta
       * @param value DireccionAdjunta of the type com.infotec.eworkplace.swb.DireccionAdjunta
       * @param model Model of the com.infotec.eworkplace.swb.DireccionEjecutiva
       * @return Iterator with all the com.infotec.eworkplace.swb.DireccionEjecutiva
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionEjecutiva> listDireccionEjecutivaByDireccionAdjunta(com.infotec.eworkplace.swb.DireccionAdjunta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionEjecutiva> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDireccionAdjunta, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.DireccionEjecutiva with a determined DireccionAdjunta
       * @param value DireccionAdjunta of the type com.infotec.eworkplace.swb.DireccionAdjunta
       * @return Iterator with all the com.infotec.eworkplace.swb.DireccionEjecutiva
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.DireccionEjecutiva> listDireccionEjecutivaByDireccionAdjunta(com.infotec.eworkplace.swb.DireccionAdjunta value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionEjecutiva> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDireccionAdjunta,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DireccionEjecutivaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DireccionEjecutiva
   */
    public DireccionEjecutivaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.DireccionAdjunta
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.DireccionAdjunta
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionAdjunta> listDireccionAdjuntas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DireccionAdjunta>(getSemanticObject().listObjectProperties(intranet_hasDireccionAdjunta));
    }

   /**
   * Gets true if has a DireccionAdjunta
   * @param value com.infotec.eworkplace.swb.DireccionAdjunta to verify
   * @return true if the com.infotec.eworkplace.swb.DireccionAdjunta exists, false otherwise
   */
    public boolean hasDireccionAdjunta(com.infotec.eworkplace.swb.DireccionAdjunta value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasDireccionAdjunta,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DireccionAdjunta
   * @param value com.infotec.eworkplace.swb.DireccionAdjunta to add
   */

    public void addDireccionAdjunta(com.infotec.eworkplace.swb.DireccionAdjunta value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDireccionAdjunta, value.getSemanticObject());
    }
   /**
   * Removes all the DireccionAdjunta
   */

    public void removeAllDireccionAdjunta()
    {
        getSemanticObject().removeProperty(intranet_hasDireccionAdjunta);
    }
   /**
   * Removes a DireccionAdjunta
   * @param value com.infotec.eworkplace.swb.DireccionAdjunta to remove
   */

    public void removeDireccionAdjunta(com.infotec.eworkplace.swb.DireccionAdjunta value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDireccionAdjunta,value.getSemanticObject());
    }

   /**
   * Gets the DireccionAdjunta
   * @return a com.infotec.eworkplace.swb.DireccionAdjunta
   */
    public com.infotec.eworkplace.swb.DireccionAdjunta getDireccionAdjunta()
    {
         com.infotec.eworkplace.swb.DireccionAdjunta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDireccionAdjunta);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.DireccionAdjunta)obj.createGenericInstance();
         }
         return ret;
    }
}
