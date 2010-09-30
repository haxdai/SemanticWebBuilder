package org.semanticwb.pymtur.base;


   /**
   * Tipo de comunidad. Se asignan webpageutils a un micrositio de acuerdo al tipo de comunidad. Este tipo especifico es el de:paquete 3.Microsite 
   */
public abstract class MiPymeSiteBase extends org.semanticwb.portal.community.MicroSiteClass 
{
   /**
   * Tipo de comunidad. Se asignan webpageutils a un micrositio de acuerdo al tipo de comunidad. Este tipo especifico es el de:paquete 3.Microsite
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSite");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSite");

    public static class ClassMgr
    {
       /**
       * Returns a list of MiPymeSite for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.MiPymeSite
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSite> listMiPymeSites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSite>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.MiPymeSite for all models
       * @return Iterator of org.semanticwb.pymtur.MiPymeSite
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSite> listMiPymeSites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSite>(it, true);
        }

        public static org.semanticwb.pymtur.MiPymeSite createMiPymeSite(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.MiPymeSite.ClassMgr.createMiPymeSite(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.MiPymeSite
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSite
       * @param model Model of the org.semanticwb.pymtur.MiPymeSite
       * @return A org.semanticwb.pymtur.MiPymeSite
       */
        public static org.semanticwb.pymtur.MiPymeSite getMiPymeSite(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MiPymeSite)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.MiPymeSite
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSite
       * @param model Model of the org.semanticwb.pymtur.MiPymeSite
       * @return A org.semanticwb.pymtur.MiPymeSite
       */
        public static org.semanticwb.pymtur.MiPymeSite createMiPymeSite(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MiPymeSite)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.MiPymeSite
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSite
       * @param model Model of the org.semanticwb.pymtur.MiPymeSite
       */
        public static void removeMiPymeSite(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.MiPymeSite
       * @param id Identifier for org.semanticwb.pymtur.MiPymeSite
       * @param model Model of the org.semanticwb.pymtur.MiPymeSite
       * @return true if the org.semanticwb.pymtur.MiPymeSite exists, false otherwise
       */

        public static boolean hasMiPymeSite(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMiPymeSite(id, model)!=null);
        }
    }

   /**
   * Constructs a MiPymeSiteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the MiPymeSite
   */
    public MiPymeSiteBase(org.semanticwb.platform.SemanticObject base)
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
