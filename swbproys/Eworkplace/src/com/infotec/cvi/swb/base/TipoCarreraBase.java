package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el Tipo de Carrera utilizado en Grado Académico 
   */
public abstract class TipoCarreraBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para las areas que agrupan a las carreras
   */
    public static final org.semanticwb.platform.SemanticClass intranet_AreaCarrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaCarrera");
   /**
   * Lista de las Áreas asociadas al tipo de Carrera.
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasArea");
   /**
   * Catálogo utilizado para indicar el Tipo de Carrera utilizado en Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoCarrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoCarrera");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoCarrera");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoCarrera for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreras(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.TipoCarrera for all models
       * @return Iterator of com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreras()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera>(it, true);
        }

        public static com.infotec.cvi.swb.TipoCarrera createTipoCarrera(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.TipoCarrera.ClassMgr.createTipoCarrera(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.TipoCarrera
       * @param id Identifier for com.infotec.cvi.swb.TipoCarrera
       * @param model Model of the com.infotec.cvi.swb.TipoCarrera
       * @return A com.infotec.cvi.swb.TipoCarrera
       */
        public static com.infotec.cvi.swb.TipoCarrera getTipoCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoCarrera)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.TipoCarrera
       * @param id Identifier for com.infotec.cvi.swb.TipoCarrera
       * @param model Model of the com.infotec.cvi.swb.TipoCarrera
       * @return A com.infotec.cvi.swb.TipoCarrera
       */
        public static com.infotec.cvi.swb.TipoCarrera createTipoCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoCarrera)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.TipoCarrera
       * @param id Identifier for com.infotec.cvi.swb.TipoCarrera
       * @param model Model of the com.infotec.cvi.swb.TipoCarrera
       */
        public static void removeTipoCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.TipoCarrera
       * @param id Identifier for com.infotec.cvi.swb.TipoCarrera
       * @param model Model of the com.infotec.cvi.swb.TipoCarrera
       * @return true if the com.infotec.cvi.swb.TipoCarrera exists, false otherwise
       */

        public static boolean hasTipoCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoCarrera(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoCarrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoCarrera
       * @return Iterator with all the com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreraByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoCarrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreraByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoCarrera with a determined Area
       * @param value Area of the type com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.TipoCarrera
       * @return Iterator with all the com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreraByArea(com.infotec.cvi.swb.AreaCarrera value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasArea, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoCarrera with a determined Area
       * @param value Area of the type com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreraByArea(com.infotec.cvi.swb.AreaCarrera value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasArea,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoCarrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoCarrera
       * @return Iterator with all the com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreraByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoCarrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoCarrera> listTipoCarreraByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static TipoCarreraBase.ClassMgr getTipoCarreraClassMgr()
    {
        return new TipoCarreraBase.ClassMgr();
    }

   /**
   * Constructs a TipoCarreraBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoCarrera
   */
    public TipoCarreraBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.AreaCarrera
   * @return A GenericIterator with all the com.infotec.cvi.swb.AreaCarrera
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> listAreas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera>(getSemanticObject().listObjectProperties(intranet_hasArea));
    }

   /**
   * Gets true if has a Area
   * @param value com.infotec.cvi.swb.AreaCarrera to verify
   * @return true if the com.infotec.cvi.swb.AreaCarrera exists, false otherwise
   */
    public boolean hasArea(com.infotec.cvi.swb.AreaCarrera value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasArea,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Area
   * @param value com.infotec.cvi.swb.AreaCarrera to add
   */

    public void addArea(com.infotec.cvi.swb.AreaCarrera value)
    {
        getSemanticObject().addObjectProperty(intranet_hasArea, value.getSemanticObject());
    }
   /**
   * Removes all the Area
   */

    public void removeAllArea()
    {
        getSemanticObject().removeProperty(intranet_hasArea);
    }
   /**
   * Removes a Area
   * @param value com.infotec.cvi.swb.AreaCarrera to remove
   */

    public void removeArea(com.infotec.cvi.swb.AreaCarrera value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasArea,value.getSemanticObject());
    }

   /**
   * Gets the Area
   * @return a com.infotec.cvi.swb.AreaCarrera
   */
    public com.infotec.cvi.swb.AreaCarrera getArea()
    {
         com.infotec.cvi.swb.AreaCarrera ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasArea);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.AreaCarrera)obj.createGenericInstance();
         }
         return ret;
    }
}
