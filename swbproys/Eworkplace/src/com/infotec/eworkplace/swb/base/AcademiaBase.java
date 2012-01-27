package com.infotec.eworkplace.swb.base;


public abstract class AcademiaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_GradoAcademico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#GradoAcademico");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasGradoAcademico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasGradoAcademico");
    public static final org.semanticwb.platform.SemanticClass intranet_EstudioSuperior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EstudioSuperior");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasEstudioSuperior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasEstudioSuperior");
    public static final org.semanticwb.platform.SemanticClass intranet_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Academia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Academia for all models
       * @return Iterator of com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia>(it, true);
        }

        public static com.infotec.eworkplace.swb.Academia createAcademia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Academia.ClassMgr.createAcademia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return A com.infotec.eworkplace.swb.Academia
       */
        public static com.infotec.eworkplace.swb.Academia getAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Academia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return A com.infotec.eworkplace.swb.Academia
       */
        public static com.infotec.eworkplace.swb.Academia createAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Academia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       */
        public static void removeAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return true if the com.infotec.eworkplace.swb.Academia exists, false otherwise
       */

        public static boolean hasAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAcademia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined GradoAcademico
       * @param value GradoAcademico of the type com.infotec.eworkplace.swb.GradoAcademico
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByGradoAcademico(com.infotec.eworkplace.swb.GradoAcademico value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGradoAcademico, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined GradoAcademico
       * @param value GradoAcademico of the type com.infotec.eworkplace.swb.GradoAcademico
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByGradoAcademico(com.infotec.eworkplace.swb.GradoAcademico value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGradoAcademico,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined EstudioSuperior
       * @param value EstudioSuperior of the type com.infotec.eworkplace.swb.EstudioSuperior
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByEstudioSuperior(com.infotec.eworkplace.swb.EstudioSuperior value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstudioSuperior, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined EstudioSuperior
       * @param value EstudioSuperior of the type com.infotec.eworkplace.swb.EstudioSuperior
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByEstudioSuperior(com.infotec.eworkplace.swb.EstudioSuperior value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstudioSuperior,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AcademiaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Academia
   */
    public AcademiaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.GradoAcademico
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.GradoAcademico
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.GradoAcademico> listGradoAcademicos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.GradoAcademico>(getSemanticObject().listObjectProperties(intranet_hasGradoAcademico));
    }

   /**
   * Gets true if has a GradoAcademico
   * @param value com.infotec.eworkplace.swb.GradoAcademico to verify
   * @return true if the com.infotec.eworkplace.swb.GradoAcademico exists, false otherwise
   */
    public boolean hasGradoAcademico(com.infotec.eworkplace.swb.GradoAcademico value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasGradoAcademico,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a GradoAcademico
   * @param value com.infotec.eworkplace.swb.GradoAcademico to add
   */

    public void addGradoAcademico(com.infotec.eworkplace.swb.GradoAcademico value)
    {
        getSemanticObject().addObjectProperty(intranet_hasGradoAcademico, value.getSemanticObject());
    }
   /**
   * Removes all the GradoAcademico
   */

    public void removeAllGradoAcademico()
    {
        getSemanticObject().removeProperty(intranet_hasGradoAcademico);
    }
   /**
   * Removes a GradoAcademico
   * @param value com.infotec.eworkplace.swb.GradoAcademico to remove
   */

    public void removeGradoAcademico(com.infotec.eworkplace.swb.GradoAcademico value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasGradoAcademico,value.getSemanticObject());
    }

   /**
   * Gets the GradoAcademico
   * @return a com.infotec.eworkplace.swb.GradoAcademico
   */
    public com.infotec.eworkplace.swb.GradoAcademico getGradoAcademico()
    {
         com.infotec.eworkplace.swb.GradoAcademico ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasGradoAcademico);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.GradoAcademico)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.EstudioSuperior
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.EstudioSuperior
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior> listEstudioSuperiors()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior>(getSemanticObject().listObjectProperties(intranet_hasEstudioSuperior));
    }

   /**
   * Gets true if has a EstudioSuperior
   * @param value com.infotec.eworkplace.swb.EstudioSuperior to verify
   * @return true if the com.infotec.eworkplace.swb.EstudioSuperior exists, false otherwise
   */
    public boolean hasEstudioSuperior(com.infotec.eworkplace.swb.EstudioSuperior value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasEstudioSuperior,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EstudioSuperior
   * @param value com.infotec.eworkplace.swb.EstudioSuperior to add
   */

    public void addEstudioSuperior(com.infotec.eworkplace.swb.EstudioSuperior value)
    {
        getSemanticObject().addObjectProperty(intranet_hasEstudioSuperior, value.getSemanticObject());
    }
   /**
   * Removes all the EstudioSuperior
   */

    public void removeAllEstudioSuperior()
    {
        getSemanticObject().removeProperty(intranet_hasEstudioSuperior);
    }
   /**
   * Removes a EstudioSuperior
   * @param value com.infotec.eworkplace.swb.EstudioSuperior to remove
   */

    public void removeEstudioSuperior(com.infotec.eworkplace.swb.EstudioSuperior value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasEstudioSuperior,value.getSemanticObject());
    }

   /**
   * Gets the EstudioSuperior
   * @return a com.infotec.eworkplace.swb.EstudioSuperior
   */
    public com.infotec.eworkplace.swb.EstudioSuperior getEstudioSuperior()
    {
         com.infotec.eworkplace.swb.EstudioSuperior ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasEstudioSuperior);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.EstudioSuperior)obj.createGenericInstance();
         }
         return ret;
    }
}
