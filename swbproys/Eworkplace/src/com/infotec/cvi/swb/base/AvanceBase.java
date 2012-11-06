package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el grado de avance del Estudio 
   */
public abstract class AvanceBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Sortable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para indicar el grado de avance del Estudio
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Avance");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Avance");

    public static class ClassMgr
    {
       /**
       * Returns a list of Avance for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Avance
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Avance> listAvances(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Avance>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Avance for all models
       * @return Iterator of com.infotec.cvi.swb.Avance
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Avance> listAvances()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Avance>(it, true);
        }

        public static com.infotec.cvi.swb.Avance createAvance(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Avance.ClassMgr.createAvance(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Avance
       * @param id Identifier for com.infotec.cvi.swb.Avance
       * @param model Model of the com.infotec.cvi.swb.Avance
       * @return A com.infotec.cvi.swb.Avance
       */
        public static com.infotec.cvi.swb.Avance getAvance(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Avance)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Avance
       * @param id Identifier for com.infotec.cvi.swb.Avance
       * @param model Model of the com.infotec.cvi.swb.Avance
       * @return A com.infotec.cvi.swb.Avance
       */
        public static com.infotec.cvi.swb.Avance createAvance(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Avance)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Avance
       * @param id Identifier for com.infotec.cvi.swb.Avance
       * @param model Model of the com.infotec.cvi.swb.Avance
       */
        public static void removeAvance(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Avance
       * @param id Identifier for com.infotec.cvi.swb.Avance
       * @param model Model of the com.infotec.cvi.swb.Avance
       * @return true if the com.infotec.cvi.swb.Avance exists, false otherwise
       */

        public static boolean hasAvance(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAvance(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Avance with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Avance
       * @return Iterator with all the com.infotec.cvi.swb.Avance
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Avance> listAvanceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Avance> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Avance with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Avance
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Avance> listAvanceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Avance> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Avance with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Avance
       * @return Iterator with all the com.infotec.cvi.swb.Avance
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Avance> listAvanceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Avance> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Avance with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Avance
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Avance> listAvanceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Avance> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static AvanceBase.ClassMgr getAvanceClassMgr()
    {
        return new AvanceBase.ClassMgr();
    }

   /**
   * Constructs a AvanceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Avance
   */
    public AvanceBase(org.semanticwb.platform.SemanticObject base)
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
