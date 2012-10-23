package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar las diferentes disciplinas de los Estudios Superiores. 
   */
public abstract class DisciplinaEstudioBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para indicar los diferentes tipos de Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoEstudio");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoEstudioInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoEstudioInv");
   /**
   * Catálogo utilizado para las areas que agrupan a las carreras de los Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_AreaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaEstudio");
   /**
   * Lista de Áreas de estudio asociadas a una Disciplina en Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasAreaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasAreaEstudio");
   /**
   * Catálogo utilizado para indicar las diferentes disciplinas de los Estudios Superiores.
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DisciplinaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DisciplinaEstudio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DisciplinaEstudio");

    public static class ClassMgr
    {
       /**
       * Returns a list of DisciplinaEstudio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.DisciplinaEstudio for all models
       * @return Iterator of com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio>(it, true);
        }

        public static com.infotec.cvi.swb.DisciplinaEstudio createDisciplinaEstudio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.DisciplinaEstudio.ClassMgr.createDisciplinaEstudio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.DisciplinaEstudio
       * @param id Identifier for com.infotec.cvi.swb.DisciplinaEstudio
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       * @return A com.infotec.cvi.swb.DisciplinaEstudio
       */
        public static com.infotec.cvi.swb.DisciplinaEstudio getDisciplinaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.DisciplinaEstudio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.DisciplinaEstudio
       * @param id Identifier for com.infotec.cvi.swb.DisciplinaEstudio
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       * @return A com.infotec.cvi.swb.DisciplinaEstudio
       */
        public static com.infotec.cvi.swb.DisciplinaEstudio createDisciplinaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.DisciplinaEstudio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.DisciplinaEstudio
       * @param id Identifier for com.infotec.cvi.swb.DisciplinaEstudio
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       */
        public static void removeDisciplinaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.DisciplinaEstudio
       * @param id Identifier for com.infotec.cvi.swb.DisciplinaEstudio
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       * @return true if the com.infotec.cvi.swb.DisciplinaEstudio exists, false otherwise
       */

        public static boolean hasDisciplinaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDisciplinaEstudio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined TipoEstudioInv
       * @param value TipoEstudioInv of the type com.infotec.cvi.swb.TipoEstudio
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByTipoEstudioInv(com.infotec.cvi.swb.TipoEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoEstudioInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined TipoEstudioInv
       * @param value TipoEstudioInv of the type com.infotec.cvi.swb.TipoEstudio
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByTipoEstudioInv(com.infotec.cvi.swb.TipoEstudio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoEstudioInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined AreaEstudio
       * @param value AreaEstudio of the type com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.DisciplinaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByAreaEstudio(com.infotec.cvi.swb.AreaEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasAreaEstudio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DisciplinaEstudio with a determined AreaEstudio
       * @param value AreaEstudio of the type com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.DisciplinaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinaEstudioByAreaEstudio(com.infotec.cvi.swb.AreaEstudio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasAreaEstudio,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DisciplinaEstudioBase.ClassMgr getDisciplinaEstudioClassMgr()
    {
        return new DisciplinaEstudioBase.ClassMgr();
    }

   /**
   * Constructs a DisciplinaEstudioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DisciplinaEstudio
   */
    public DisciplinaEstudioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property TipoEstudioInv
   * @param value TipoEstudioInv to set
   */

    public void setTipoEstudioInv(com.infotec.cvi.swb.TipoEstudio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_tipoEstudioInv, value.getSemanticObject());
        }else
        {
            removeTipoEstudioInv();
        }
    }
   /**
   * Remove the value for TipoEstudioInv property
   */

    public void removeTipoEstudioInv()
    {
        getSemanticObject().removeProperty(intranet_tipoEstudioInv);
    }

   /**
   * Gets the TipoEstudioInv
   * @return a com.infotec.cvi.swb.TipoEstudio
   */
    public com.infotec.cvi.swb.TipoEstudio getTipoEstudioInv()
    {
         com.infotec.cvi.swb.TipoEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_tipoEstudioInv);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoEstudio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.AreaEstudio
   * @return A GenericIterator with all the com.infotec.cvi.swb.AreaEstudio
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudios()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio>(getSemanticObject().listObjectProperties(intranet_hasAreaEstudio));
    }

   /**
   * Gets true if has a AreaEstudio
   * @param value com.infotec.cvi.swb.AreaEstudio to verify
   * @return true if the com.infotec.cvi.swb.AreaEstudio exists, false otherwise
   */
    public boolean hasAreaEstudio(com.infotec.cvi.swb.AreaEstudio value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasAreaEstudio,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a AreaEstudio
   * @param value com.infotec.cvi.swb.AreaEstudio to add
   */

    public void addAreaEstudio(com.infotec.cvi.swb.AreaEstudio value)
    {
        getSemanticObject().addObjectProperty(intranet_hasAreaEstudio, value.getSemanticObject());
    }
   /**
   * Removes all the AreaEstudio
   */

    public void removeAllAreaEstudio()
    {
        getSemanticObject().removeProperty(intranet_hasAreaEstudio);
    }
   /**
   * Removes a AreaEstudio
   * @param value com.infotec.cvi.swb.AreaEstudio to remove
   */

    public void removeAreaEstudio(com.infotec.cvi.swb.AreaEstudio value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasAreaEstudio,value.getSemanticObject());
    }

   /**
   * Gets the AreaEstudio
   * @return a com.infotec.cvi.swb.AreaEstudio
   */
    public com.infotec.cvi.swb.AreaEstudio getAreaEstudio()
    {
         com.infotec.cvi.swb.AreaEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasAreaEstudio);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.AreaEstudio)obj.createGenericInstance();
         }
         return ret;
    }
}
