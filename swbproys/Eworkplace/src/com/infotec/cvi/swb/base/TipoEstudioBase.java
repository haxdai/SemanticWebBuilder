package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar los diferentes tipos de Estudios Superiores 
   */
public abstract class TipoEstudioBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Sortable
{
   /**
   * Catálogo utilizado para indicar las diferentes disciplinas de los Estudios Superiores.
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DisciplinaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DisciplinaEstudio");
   /**
   * Lista de disciplinas asociadas al tipo de Estudio Superior
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDisciplina=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDisciplina");
   /**
   * Catálogo utilizado para indicar los diferentes tipos de Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoEstudio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoEstudio");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoEstudio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.TipoEstudio for all models
       * @return Iterator of com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio>(it, true);
        }

        public static com.infotec.cvi.swb.TipoEstudio createTipoEstudio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.TipoEstudio.ClassMgr.createTipoEstudio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.TipoEstudio
       * @param id Identifier for com.infotec.cvi.swb.TipoEstudio
       * @param model Model of the com.infotec.cvi.swb.TipoEstudio
       * @return A com.infotec.cvi.swb.TipoEstudio
       */
        public static com.infotec.cvi.swb.TipoEstudio getTipoEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoEstudio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.TipoEstudio
       * @param id Identifier for com.infotec.cvi.swb.TipoEstudio
       * @param model Model of the com.infotec.cvi.swb.TipoEstudio
       * @return A com.infotec.cvi.swb.TipoEstudio
       */
        public static com.infotec.cvi.swb.TipoEstudio createTipoEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoEstudio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.TipoEstudio
       * @param id Identifier for com.infotec.cvi.swb.TipoEstudio
       * @param model Model of the com.infotec.cvi.swb.TipoEstudio
       */
        public static void removeTipoEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.TipoEstudio
       * @param id Identifier for com.infotec.cvi.swb.TipoEstudio
       * @param model Model of the com.infotec.cvi.swb.TipoEstudio
       * @return true if the com.infotec.cvi.swb.TipoEstudio exists, false otherwise
       */

        public static boolean hasTipoEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoEstudio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoEstudio
       * @return Iterator with all the com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoEstudio with a determined Disciplina
       * @param value Disciplina of the type com.infotec.cvi.swb.DisciplinaEstudio
       * @param model Model of the com.infotec.cvi.swb.TipoEstudio
       * @return Iterator with all the com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudioByDisciplina(com.infotec.cvi.swb.DisciplinaEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDisciplina, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoEstudio with a determined Disciplina
       * @param value Disciplina of the type com.infotec.cvi.swb.DisciplinaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudioByDisciplina(com.infotec.cvi.swb.DisciplinaEstudio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDisciplina,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoEstudio
       * @return Iterator with all the com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoEstudio> listTipoEstudioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static TipoEstudioBase.ClassMgr getTipoEstudioClassMgr()
    {
        return new TipoEstudioBase.ClassMgr();
    }

   /**
   * Constructs a TipoEstudioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoEstudio
   */
    public TipoEstudioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        return getSemanticObject().getIntProperty(swb_index);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(swb_index, value);
    }
   /**
   * Gets all the com.infotec.cvi.swb.DisciplinaEstudio
   * @return A GenericIterator with all the com.infotec.cvi.swb.DisciplinaEstudio
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio> listDisciplinas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DisciplinaEstudio>(getSemanticObject().listObjectProperties(intranet_hasDisciplina));
    }

   /**
   * Gets true if has a Disciplina
   * @param value com.infotec.cvi.swb.DisciplinaEstudio to verify
   * @return true if the com.infotec.cvi.swb.DisciplinaEstudio exists, false otherwise
   */
    public boolean hasDisciplina(com.infotec.cvi.swb.DisciplinaEstudio value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasDisciplina,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Disciplina
   * @param value com.infotec.cvi.swb.DisciplinaEstudio to add
   */

    public void addDisciplina(com.infotec.cvi.swb.DisciplinaEstudio value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDisciplina, value.getSemanticObject());
    }
   /**
   * Removes all the Disciplina
   */

    public void removeAllDisciplina()
    {
        getSemanticObject().removeProperty(intranet_hasDisciplina);
    }
   /**
   * Removes a Disciplina
   * @param value com.infotec.cvi.swb.DisciplinaEstudio to remove
   */

    public void removeDisciplina(com.infotec.cvi.swb.DisciplinaEstudio value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDisciplina,value.getSemanticObject());
    }

   /**
   * Gets the Disciplina
   * @return a com.infotec.cvi.swb.DisciplinaEstudio
   */
    public com.infotec.cvi.swb.DisciplinaEstudio getDisciplina()
    {
         com.infotec.cvi.swb.DisciplinaEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDisciplina);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.DisciplinaEstudio)obj.createGenericInstance();
         }
         return ret;
    }
}
