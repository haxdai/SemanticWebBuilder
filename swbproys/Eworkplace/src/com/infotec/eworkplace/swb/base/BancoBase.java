package com.infotec.eworkplace.swb.base;


public abstract class BancoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Banco=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Banco");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Banco");

    public static class ClassMgr
    {
       /**
       * Returns a list of Banco for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Banco
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Banco> listBancos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Banco>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Banco for all models
       * @return Iterator of com.infotec.eworkplace.swb.Banco
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Banco> listBancos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Banco>(it, true);
        }

        public static com.infotec.eworkplace.swb.Banco createBanco(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Banco.ClassMgr.createBanco(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Banco
       * @param id Identifier for com.infotec.eworkplace.swb.Banco
       * @param model Model of the com.infotec.eworkplace.swb.Banco
       * @return A com.infotec.eworkplace.swb.Banco
       */
        public static com.infotec.eworkplace.swb.Banco getBanco(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Banco)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Banco
       * @param id Identifier for com.infotec.eworkplace.swb.Banco
       * @param model Model of the com.infotec.eworkplace.swb.Banco
       * @return A com.infotec.eworkplace.swb.Banco
       */
        public static com.infotec.eworkplace.swb.Banco createBanco(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Banco)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Banco
       * @param id Identifier for com.infotec.eworkplace.swb.Banco
       * @param model Model of the com.infotec.eworkplace.swb.Banco
       */
        public static void removeBanco(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Banco
       * @param id Identifier for com.infotec.eworkplace.swb.Banco
       * @param model Model of the com.infotec.eworkplace.swb.Banco
       * @return true if the com.infotec.eworkplace.swb.Banco exists, false otherwise
       */

        public static boolean hasBanco(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBanco(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Banco with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Banco
       * @return Iterator with all the com.infotec.eworkplace.swb.Banco
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Banco> listBancoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Banco> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Banco with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Banco
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Banco> listBancoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Banco> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Banco with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Banco
       * @return Iterator with all the com.infotec.eworkplace.swb.Banco
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Banco> listBancoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Banco> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Banco with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Banco
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Banco> listBancoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Banco> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static BancoBase.ClassMgr getBancoClassMgr()
    {
        return new BancoBase.ClassMgr();
    }

   /**
   * Constructs a BancoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Banco
   */
    public BancoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
