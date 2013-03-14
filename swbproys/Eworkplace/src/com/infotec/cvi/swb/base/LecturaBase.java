package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el porcentaje de manejo de lectura en Idiomas. 
   */
public abstract class LecturaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para indicar el porcentaje de manejo de lectura en Idiomas.
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Lectura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Lectura");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Lectura");

    public static class ClassMgr
    {
       /**
       * Returns a list of Lectura for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Lectura
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Lectura> listLecturas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Lectura>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Lectura for all models
       * @return Iterator of com.infotec.cvi.swb.Lectura
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Lectura> listLecturas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Lectura>(it, true);
        }

        public static com.infotec.cvi.swb.Lectura createLectura(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Lectura.ClassMgr.createLectura(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Lectura
       * @param id Identifier for com.infotec.cvi.swb.Lectura
       * @param model Model of the com.infotec.cvi.swb.Lectura
       * @return A com.infotec.cvi.swb.Lectura
       */
        public static com.infotec.cvi.swb.Lectura getLectura(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Lectura)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Lectura
       * @param id Identifier for com.infotec.cvi.swb.Lectura
       * @param model Model of the com.infotec.cvi.swb.Lectura
       * @return A com.infotec.cvi.swb.Lectura
       */
        public static com.infotec.cvi.swb.Lectura createLectura(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Lectura)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Lectura
       * @param id Identifier for com.infotec.cvi.swb.Lectura
       * @param model Model of the com.infotec.cvi.swb.Lectura
       */
        public static void removeLectura(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Lectura
       * @param id Identifier for com.infotec.cvi.swb.Lectura
       * @param model Model of the com.infotec.cvi.swb.Lectura
       * @return true if the com.infotec.cvi.swb.Lectura exists, false otherwise
       */

        public static boolean hasLectura(String id, org.semanticwb.model.SWBModel model)
        {
            return (getLectura(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Lectura with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Lectura
       * @return Iterator with all the com.infotec.cvi.swb.Lectura
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Lectura> listLecturaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Lectura> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Lectura with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Lectura
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Lectura> listLecturaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Lectura> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Lectura with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Lectura
       * @return Iterator with all the com.infotec.cvi.swb.Lectura
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Lectura> listLecturaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Lectura> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Lectura with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Lectura
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Lectura> listLecturaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Lectura> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static LecturaBase.ClassMgr getLecturaClassMgr()
    {
        return new LecturaBase.ClassMgr();
    }

   /**
   * Constructs a LecturaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Lectura
   */
    public LecturaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
