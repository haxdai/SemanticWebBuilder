package com.infotec.eworkplace.swb.base;


public abstract class ClienteBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Cliente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Cliente");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Cliente");

    public static class ClassMgr
    {
       /**
       * Returns a list of Cliente for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Cliente
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Cliente> listClientes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Cliente>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Cliente for all models
       * @return Iterator of com.infotec.eworkplace.swb.Cliente
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Cliente> listClientes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Cliente>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Cliente
       * @param id Identifier for com.infotec.eworkplace.swb.Cliente
       * @param model Model of the com.infotec.eworkplace.swb.Cliente
       * @return A com.infotec.eworkplace.swb.Cliente
       */
        public static com.infotec.eworkplace.swb.Cliente getCliente(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Cliente)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Cliente
       * @param id Identifier for com.infotec.eworkplace.swb.Cliente
       * @param model Model of the com.infotec.eworkplace.swb.Cliente
       * @return A com.infotec.eworkplace.swb.Cliente
       */
        public static com.infotec.eworkplace.swb.Cliente createCliente(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Cliente)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Cliente
       * @param id Identifier for com.infotec.eworkplace.swb.Cliente
       * @param model Model of the com.infotec.eworkplace.swb.Cliente
       */
        public static void removeCliente(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Cliente
       * @param id Identifier for com.infotec.eworkplace.swb.Cliente
       * @param model Model of the com.infotec.eworkplace.swb.Cliente
       * @return true if the com.infotec.eworkplace.swb.Cliente exists, false otherwise
       */

        public static boolean hasCliente(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCliente(id, model)!=null);
        }
    }

    public static ClienteBase.ClassMgr getClienteClassMgr()
    {
        return new ClienteBase.ClassMgr();
    }

   /**
   * Constructs a ClienteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Cliente
   */
    public ClienteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
