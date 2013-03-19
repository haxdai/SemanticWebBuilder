package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar la ubicación física dentro del edificio 
   */
public abstract class UbicacionFisicaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para indicar la ubicación física dentro del edificio
   */
    public static final org.semanticwb.platform.SemanticClass intranet_UbicacionFisica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#UbicacionFisica");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#UbicacionFisica");

    public static class ClassMgr
    {
       /**
       * Returns a list of UbicacionFisica for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.UbicacionFisica
       */

        public static java.util.Iterator<com.infotec.cvi.swb.UbicacionFisica> listUbicacionFisicas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UbicacionFisica>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.UbicacionFisica for all models
       * @return Iterator of com.infotec.cvi.swb.UbicacionFisica
       */

        public static java.util.Iterator<com.infotec.cvi.swb.UbicacionFisica> listUbicacionFisicas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UbicacionFisica>(it, true);
        }

        public static com.infotec.cvi.swb.UbicacionFisica createUbicacionFisica(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.UbicacionFisica.ClassMgr.createUbicacionFisica(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.UbicacionFisica
       * @param id Identifier for com.infotec.cvi.swb.UbicacionFisica
       * @param model Model of the com.infotec.cvi.swb.UbicacionFisica
       * @return A com.infotec.cvi.swb.UbicacionFisica
       */
        public static com.infotec.cvi.swb.UbicacionFisica getUbicacionFisica(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.UbicacionFisica)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.UbicacionFisica
       * @param id Identifier for com.infotec.cvi.swb.UbicacionFisica
       * @param model Model of the com.infotec.cvi.swb.UbicacionFisica
       * @return A com.infotec.cvi.swb.UbicacionFisica
       */
        public static com.infotec.cvi.swb.UbicacionFisica createUbicacionFisica(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.UbicacionFisica)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.UbicacionFisica
       * @param id Identifier for com.infotec.cvi.swb.UbicacionFisica
       * @param model Model of the com.infotec.cvi.swb.UbicacionFisica
       */
        public static void removeUbicacionFisica(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.UbicacionFisica
       * @param id Identifier for com.infotec.cvi.swb.UbicacionFisica
       * @param model Model of the com.infotec.cvi.swb.UbicacionFisica
       * @return true if the com.infotec.cvi.swb.UbicacionFisica exists, false otherwise
       */

        public static boolean hasUbicacionFisica(String id, org.semanticwb.model.SWBModel model)
        {
            return (getUbicacionFisica(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.UbicacionFisica with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.UbicacionFisica
       * @return Iterator with all the com.infotec.cvi.swb.UbicacionFisica
       */

        public static java.util.Iterator<com.infotec.cvi.swb.UbicacionFisica> listUbicacionFisicaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UbicacionFisica> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.UbicacionFisica with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.UbicacionFisica
       */

        public static java.util.Iterator<com.infotec.cvi.swb.UbicacionFisica> listUbicacionFisicaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UbicacionFisica> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.UbicacionFisica with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.UbicacionFisica
       * @return Iterator with all the com.infotec.cvi.swb.UbicacionFisica
       */

        public static java.util.Iterator<com.infotec.cvi.swb.UbicacionFisica> listUbicacionFisicaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UbicacionFisica> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.UbicacionFisica with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.UbicacionFisica
       */

        public static java.util.Iterator<com.infotec.cvi.swb.UbicacionFisica> listUbicacionFisicaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UbicacionFisica> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static UbicacionFisicaBase.ClassMgr getUbicacionFisicaClassMgr()
    {
        return new UbicacionFisicaBase.ClassMgr();
    }

   /**
   * Constructs a UbicacionFisicaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UbicacionFisica
   */
    public UbicacionFisicaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
