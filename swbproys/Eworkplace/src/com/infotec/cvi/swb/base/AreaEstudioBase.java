package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para las areas que agrupan a las carreras de los Estudios Superiores 
   */
public abstract class AreaEstudioBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para almacenar los diferentes Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Estudios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estudios");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasEstudiosInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasEstudiosInv");
   /**
   * Catálogo utilizado para indicar las diferentes disciplinas de los Estudios Superiores.
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DisciplinaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DisciplinaEstudio");
    public static final org.semanticwb.platform.SemanticProperty intranet_disciplinaInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#disciplinaInv");
   /**
   * Catálogo utilizado para las areas que agrupan a las carreras de los Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_AreaEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaEstudio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaEstudio");

    public static class ClassMgr
    {
       /**
       * Returns a list of AreaEstudio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.AreaEstudio for all models
       * @return Iterator of com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio>(it, true);
        }

        public static com.infotec.cvi.swb.AreaEstudio createAreaEstudio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.AreaEstudio.ClassMgr.createAreaEstudio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return A com.infotec.cvi.swb.AreaEstudio
       */
        public static com.infotec.cvi.swb.AreaEstudio getAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaEstudio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return A com.infotec.cvi.swb.AreaEstudio
       */
        public static com.infotec.cvi.swb.AreaEstudio createAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaEstudio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       */
        public static void removeAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.AreaEstudio
       * @param id Identifier for com.infotec.cvi.swb.AreaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return true if the com.infotec.cvi.swb.AreaEstudio exists, false otherwise
       */

        public static boolean hasAreaEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAreaEstudio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined EstudiosInv
       * @param value EstudiosInv of the type com.infotec.cvi.swb.Estudios
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByEstudiosInv(com.infotec.cvi.swb.Estudios value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstudiosInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined EstudiosInv
       * @param value EstudiosInv of the type com.infotec.cvi.swb.Estudios
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByEstudiosInv(com.infotec.cvi.swb.Estudios value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstudiosInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined DisciplinaInv
       * @param value DisciplinaInv of the type com.infotec.cvi.swb.DisciplinaEstudio
       * @param model Model of the com.infotec.cvi.swb.AreaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByDisciplinaInv(com.infotec.cvi.swb.DisciplinaEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_disciplinaInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaEstudio with a determined DisciplinaInv
       * @param value DisciplinaInv of the type com.infotec.cvi.swb.DisciplinaEstudio
       * @return Iterator with all the com.infotec.cvi.swb.AreaEstudio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaEstudio> listAreaEstudioByDisciplinaInv(com.infotec.cvi.swb.DisciplinaEstudio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaEstudio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_disciplinaInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AreaEstudioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AreaEstudio
   */
    public AreaEstudioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.Estudios
   * @return A GenericIterator with all the com.infotec.cvi.swb.Estudios
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios> listEstudiosInvs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Estudios>(getSemanticObject().listObjectProperties(intranet_hasEstudiosInv));
    }

   /**
   * Gets true if has a EstudiosInv
   * @param value com.infotec.cvi.swb.Estudios to verify
   * @return true if the com.infotec.cvi.swb.Estudios exists, false otherwise
   */
    public boolean hasEstudiosInv(com.infotec.cvi.swb.Estudios value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasEstudiosInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EstudiosInv
   * @return a com.infotec.cvi.swb.Estudios
   */
    public com.infotec.cvi.swb.Estudios getEstudiosInv()
    {
         com.infotec.cvi.swb.Estudios ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasEstudiosInv);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Estudios)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property DisciplinaInv
   * @param value DisciplinaInv to set
   */

    public void setDisciplinaInv(com.infotec.cvi.swb.DisciplinaEstudio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_disciplinaInv, value.getSemanticObject());
        }else
        {
            removeDisciplinaInv();
        }
    }
   /**
   * Remove the value for DisciplinaInv property
   */

    public void removeDisciplinaInv()
    {
        getSemanticObject().removeProperty(intranet_disciplinaInv);
    }

   /**
   * Gets the DisciplinaInv
   * @return a com.infotec.cvi.swb.DisciplinaEstudio
   */
    public com.infotec.cvi.swb.DisciplinaEstudio getDisciplinaInv()
    {
         com.infotec.cvi.swb.DisciplinaEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_disciplinaInv);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.DisciplinaEstudio)obj.createGenericInstance();
         }
         return ret;
    }
}
