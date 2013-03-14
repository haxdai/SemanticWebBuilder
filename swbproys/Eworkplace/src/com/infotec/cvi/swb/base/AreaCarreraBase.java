package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para las areas que agrupan a las carreras 
   */
public abstract class AreaCarreraBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para las carreras utilizadas para la captura de Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCarreraInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCarreraInv");
   /**
   * Catálogo utilizado para indicar el Tipo de Carrera utilizado en Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoCarrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoCarrera");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoCarreraInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoCarreraInv");
   /**
   * Catálogo utilizado para las areas que agrupan a las carreras
   */
    public static final org.semanticwb.platform.SemanticClass intranet_AreaCarrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaCarrera");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaCarrera");

    public static class ClassMgr
    {
       /**
       * Returns a list of AreaCarrera for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreras(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.AreaCarrera for all models
       * @return Iterator of com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreras()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera>(it, true);
        }

        public static com.infotec.cvi.swb.AreaCarrera createAreaCarrera(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.AreaCarrera.ClassMgr.createAreaCarrera(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return A com.infotec.cvi.swb.AreaCarrera
       */
        public static com.infotec.cvi.swb.AreaCarrera getAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaCarrera)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return A com.infotec.cvi.swb.AreaCarrera
       */
        public static com.infotec.cvi.swb.AreaCarrera createAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaCarrera)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       */
        public static void removeAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.AreaCarrera
       * @param id Identifier for com.infotec.cvi.swb.AreaCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return true if the com.infotec.cvi.swb.AreaCarrera exists, false otherwise
       */

        public static boolean hasAreaCarrera(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAreaCarrera(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined CarreraInv
       * @param value CarreraInv of the type com.infotec.cvi.swb.Carrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByCarreraInv(com.infotec.cvi.swb.Carrera value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCarreraInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined CarreraInv
       * @param value CarreraInv of the type com.infotec.cvi.swb.Carrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByCarreraInv(com.infotec.cvi.swb.Carrera value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCarreraInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined TipoCarreraInv
       * @param value TipoCarreraInv of the type com.infotec.cvi.swb.TipoCarrera
       * @param model Model of the com.infotec.cvi.swb.AreaCarrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByTipoCarreraInv(com.infotec.cvi.swb.TipoCarrera value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoCarreraInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaCarrera with a determined TipoCarreraInv
       * @param value TipoCarreraInv of the type com.infotec.cvi.swb.TipoCarrera
       * @return Iterator with all the com.infotec.cvi.swb.AreaCarrera
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaCarrera> listAreaCarreraByTipoCarreraInv(com.infotec.cvi.swb.TipoCarrera value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaCarrera> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoCarreraInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static AreaCarreraBase.ClassMgr getAreaCarreraClassMgr()
    {
        return new AreaCarreraBase.ClassMgr();
    }

   /**
   * Constructs a AreaCarreraBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AreaCarrera
   */
    public AreaCarreraBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.Carrera
   * @return A GenericIterator with all the com.infotec.cvi.swb.Carrera
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera> listCarreraInvs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Carrera>(getSemanticObject().listObjectProperties(intranet_hasCarreraInv));
    }

   /**
   * Gets true if has a CarreraInv
   * @param value com.infotec.cvi.swb.Carrera to verify
   * @return true if the com.infotec.cvi.swb.Carrera exists, false otherwise
   */
    public boolean hasCarreraInv(com.infotec.cvi.swb.Carrera value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCarreraInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the CarreraInv
   * @return a com.infotec.cvi.swb.Carrera
   */
    public com.infotec.cvi.swb.Carrera getCarreraInv()
    {
         com.infotec.cvi.swb.Carrera ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCarreraInv);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Carrera)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property TipoCarreraInv
   * @param value TipoCarreraInv to set
   */

    public void setTipoCarreraInv(com.infotec.cvi.swb.TipoCarrera value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_tipoCarreraInv, value.getSemanticObject());
        }else
        {
            removeTipoCarreraInv();
        }
    }
   /**
   * Remove the value for TipoCarreraInv property
   */

    public void removeTipoCarreraInv()
    {
        getSemanticObject().removeProperty(intranet_tipoCarreraInv);
    }

   /**
   * Gets the TipoCarreraInv
   * @return a com.infotec.cvi.swb.TipoCarrera
   */
    public com.infotec.cvi.swb.TipoCarrera getTipoCarreraInv()
    {
         com.infotec.cvi.swb.TipoCarrera ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_tipoCarreraInv);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoCarrera)obj.createGenericInstance();
         }
         return ret;
    }
}
