package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para las carreras utilizadas para la captura de Grado Académico 
   */
public abstract class CarreraBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para las areas que agrupan a las carreras
   */
    public static final org.semanticwb.platform.SemanticClass intranet_AreaCarrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaCarrera");
   /**
   * Indica el área a la cual está relacionada.
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_areaCarrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaCarrera");
   /**
   * Catálogo utilizado para las carreras utilizadas para la captura de Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");

    public static class ClassMgr
    {
       /**
       * Returns a list of Carrera for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreras(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Carrera for all models
       * @return Iterator of com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreras()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera>(it, true);
        }

        public static com.infotec.cvi.swb.Carrera createCarrera(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Carrera.ClassMgr.createCarrera(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Carrera
       * @param id Identifier for com.infotec.cvi.swb.Carrera
       * @param model Model of the com.infotec.cvi.swb.Carrera
       * @return A com.infotec.cvi.swb.Carrera
       */
        public static com.infotec.cvi.swb.Carrera getCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Carrera)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Carrera
       * @param id Identifier for com.infotec.cvi.swb.Carrera
       * @param model Model of the com.infotec.cvi.swb.Carrera
       * @return A com.infotec.cvi.swb.Carrera
       */
        public static com.infotec.cvi.swb.Carrera createCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Carrera)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Carrera
       * @param id Identifier for com.infotec.cvi.swb.Carrera
       * @param model Model of the com.infotec.cvi.swb.Carrera
       */
        public static void removeCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Carrera
       * @param id Identifier for com.infotec.cvi.swb.Carrera
       * @param model Model of the com.infotec.cvi.swb.Carrera
       * @return true if the com.infotec.cvi.swb.Carrera exists, false otherwise
       */

        public static boolean hasCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCarrera(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Carrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Carrera
       * @return Iterator with all the com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreraByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Carrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreraByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Carrera with a determined AreaCarrera
       * @param value AreaCarrera of the type com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.Carrera
       * @return Iterator with all the com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreraByAreaCarrera(com.infotec.cvi.swb.AreaCarrera value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_areaCarrera, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Carrera with a determined AreaCarrera
       * @param value AreaCarrera of the type com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreraByAreaCarrera(com.infotec.cvi.swb.AreaCarrera value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_areaCarrera,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Carrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Carrera
       * @return Iterator with all the com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreraByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Carrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Carrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Carrera> listCarreraByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CarreraBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Carrera
   */
    public CarreraBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property AreaCarrera
   * @param value AreaCarrera to set
   */

    public void setAreaCarrera(com.infotec.cvi.swb.AreaCarrera value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_areaCarrera, value.getSemanticObject());
        }else
        {
            removeAreaCarrera();
        }
    }
   /**
   * Remove the value for AreaCarrera property
   */

    public void removeAreaCarrera()
    {
        getSemanticObject().removeProperty(intranet_areaCarrera);
    }

   /**
   * Gets the AreaCarrera
   * @return a com.infotec.cvi.swb.AreaCarrera
   */
    public com.infotec.cvi.swb.AreaCarrera getAreaCarrera()
    {
         com.infotec.cvi.swb.AreaCarrera ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_areaCarrera);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.AreaCarrera)obj.createGenericInstance();
         }
         return ret;
    }
}
