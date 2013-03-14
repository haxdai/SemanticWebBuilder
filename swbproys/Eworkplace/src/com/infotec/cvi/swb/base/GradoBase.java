package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el Grado Académico alcanzado. 
   */
public abstract class GradoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Sortable
{
   /**
   * Catálogo utilizado para indicar el Grado Académico alcanzado.
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Grado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Grado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Grado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Grado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Grado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Grado> listGrados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Grado>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Grado for all models
       * @return Iterator of com.infotec.cvi.swb.Grado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Grado> listGrados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Grado>(it, true);
        }

        public static com.infotec.cvi.swb.Grado createGrado(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Grado.ClassMgr.createGrado(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Grado
       * @param id Identifier for com.infotec.cvi.swb.Grado
       * @param model Model of the com.infotec.cvi.swb.Grado
       * @return A com.infotec.cvi.swb.Grado
       */
        public static com.infotec.cvi.swb.Grado getGrado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Grado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Grado
       * @param id Identifier for com.infotec.cvi.swb.Grado
       * @param model Model of the com.infotec.cvi.swb.Grado
       * @return A com.infotec.cvi.swb.Grado
       */
        public static com.infotec.cvi.swb.Grado createGrado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Grado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Grado
       * @param id Identifier for com.infotec.cvi.swb.Grado
       * @param model Model of the com.infotec.cvi.swb.Grado
       */
        public static void removeGrado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Grado
       * @param id Identifier for com.infotec.cvi.swb.Grado
       * @param model Model of the com.infotec.cvi.swb.Grado
       * @return true if the com.infotec.cvi.swb.Grado exists, false otherwise
       */

        public static boolean hasGrado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGrado(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Grado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Grado
       * @return Iterator with all the com.infotec.cvi.swb.Grado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Grado> listGradoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Grado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Grado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Grado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Grado> listGradoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Grado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Grado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Grado
       * @return Iterator with all the com.infotec.cvi.swb.Grado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Grado> listGradoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Grado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Grado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Grado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Grado> listGradoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Grado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static GradoBase.ClassMgr getGradoClassMgr()
    {
        return new GradoBase.ClassMgr();
    }

   /**
   * Constructs a GradoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Grado
   */
    public GradoBase(org.semanticwb.platform.SemanticObject base)
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
}
