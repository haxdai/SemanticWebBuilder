package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class PhotosBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty swbpress_namePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#namePhoto");
    public static final org.semanticwb.platform.SemanticClass swbpress_Photos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Photos");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Photos");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Photos> listPhotoses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Photos> listPhotoses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Photos createPhotos(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.Photos.ClassMgr.createPhotos(String.valueOf(id), model);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Photos getPhotos(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Photos)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Photos createPhotos(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Photos)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static void removePhotos(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasPhotos(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPhotos(id, model)!=null);
        }
    }

    public PhotosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getNamePhoto()
    {
        return getSemanticObject().getProperty(swbpress_namePhoto);
    }

    public void setNamePhoto(String value)
    {
        getSemanticObject().setProperty(swbpress_namePhoto, value);
    }
}
