package org.semanticwb.pymtur.base;


   /**
   * Tipo de comunidad. Se asignan webpageutils a un micrositio de acuerdo al tipo de comunidad. Este tipo especifico es el de:paquete 4.Premier/Página web 
   */
public abstract class MiPymeSitePlusBase extends org.semanticwb.pymtur.MiPymeSite 
{
   /**
   * Tipo de comunidad. Se asignan webpageutils a un micrositio de acuerdo al tipo de comunidad. Este tipo especifico es el de:paquete 4.Premier/Página web
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSitePlus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSitePlus");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSitePlus");

    public static class ClassMgr
    {
       /**
       * Returns a list of MiPymeSitePlus for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.MiPymeSitePlus
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSitePlus> listMiPymeSitePluses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSitePlus>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.MiPymeSitePlus for all models
       * @return Iterator of org.semanticwb.pymtur.MiPymeSitePlus
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSitePlus> listMiPymeSitePluses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSitePlus>(it, true);
        }

        public static org.semanticwb.pymtur.MiPymeSitePlus createMiPymeSitePlus(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.createMiPymeSitePlus(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.MiPymeSitePlus
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSitePlus
       * @param model Model of the org.semanticwb.pymtur.MiPymeSitePlus
       * @return A org.semanticwb.pymtur.MiPymeSitePlus
       */
        public static org.semanticwb.pymtur.MiPymeSitePlus getMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MiPymeSitePlus)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.MiPymeSitePlus
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSitePlus
       * @param model Model of the org.semanticwb.pymtur.MiPymeSitePlus
       * @return A org.semanticwb.pymtur.MiPymeSitePlus
       */
        public static org.semanticwb.pymtur.MiPymeSitePlus createMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MiPymeSitePlus)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.MiPymeSitePlus
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSitePlus
       * @param model Model of the org.semanticwb.pymtur.MiPymeSitePlus
       */
        public static void removeMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.MiPymeSitePlus
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSitePlus
       * @param model Model of the org.semanticwb.pymtur.MiPymeSitePlus
       * @return true if the org.semanticwb.pymtur.MiPymeSitePlus exists, false otherwise
       */

        public static boolean hasMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMiPymeSitePlus(id, model)!=null);
        }
    }

   /**
   * Constructs a MiPymeSitePlusBase with a SemanticObject
   * @param base The SemanticObject with the properties for the MiPymeSitePlus
   */
    public MiPymeSitePlusBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
