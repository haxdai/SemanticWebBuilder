package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class FilesBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty swbpress_nameFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#nameFile");
    public static final org.semanticwb.platform.SemanticClass swbpress_Files=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Files");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Files");

    public static class ClassMgr
    {
       /**
       * Returns a list of Files for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Files
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Files> listFileses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Files>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.portal.resources.sem.pressroom.Files for all models
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Files
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Files> listFileses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Files>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Files createFiles(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.Files.ClassMgr.createFiles(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.portal.resources.sem.pressroom.Files
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Files
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Files
       * @return A org.semanticwb.portal.resources.sem.pressroom.Files
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Files getFiles(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Files)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.portal.resources.sem.pressroom.Files
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Files
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Files
       * @return A org.semanticwb.portal.resources.sem.pressroom.Files
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Files createFiles(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Files)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.portal.resources.sem.pressroom.Files
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Files
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Files
       */
        public static void removeFiles(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.portal.resources.sem.pressroom.Files
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Files
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Files
       * @return true if the org.semanticwb.portal.resources.sem.pressroom.Files exists, false otherwise
       */

        public static boolean hasFiles(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFiles(id, model)!=null);
        }
    }

   /**
   * Constructs a FilesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Files
   */
    public FilesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NameFile property
* @return String with the NameFile
*/
    public String getNameFile()
    {
        return getSemanticObject().getProperty(swbpress_nameFile);
    }

/**
* Sets the NameFile property
* @param value long with the NameFile
*/
    public void setNameFile(String value)
    {
        getSemanticObject().setProperty(swbpress_nameFile, value);
    }
}
