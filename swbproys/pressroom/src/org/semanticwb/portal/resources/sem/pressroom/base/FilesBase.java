package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class FilesBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty swbpress_nameFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#nameFile");
    public static final org.semanticwb.platform.SemanticClass swbpress_Files=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Files");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Files");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Files> listFileses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Files>(it, true);
        }

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

        public static org.semanticwb.portal.resources.sem.pressroom.Files getFiles(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Files)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Files createFiles(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Files)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static void removeFiles(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasFiles(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFiles(id, model)!=null);
        }
    }

    public FilesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getNameFile()
    {
        return getSemanticObject().getProperty(swbpress_nameFile);
    }

    public void setNameFile(String value)
    {
        getSemanticObject().setProperty(swbpress_nameFile, value);
    }
}
