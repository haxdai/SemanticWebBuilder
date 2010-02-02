package org.semanticwb.pymtur.base;


public abstract class MiPymeSiteBase extends org.semanticwb.portal.community.MicroSiteClass 
{
       public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
       public static final org.semanticwb.platform.SemanticProperty pymtur_serviceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#serviceProvider");
       public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSite");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSite");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSite> listMiPymeSites(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSite>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSite> listMiPymeSites()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSite>(it, true);
       }

       public static org.semanticwb.pymtur.MiPymeSite getMiPymeSite(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.MiPymeSite)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.pymtur.MiPymeSite createMiPymeSite(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.MiPymeSite)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeMiPymeSite(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasMiPymeSite(String id, org.semanticwb.model.SWBModel model)
       {
           return (getMiPymeSite(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSite> listMiPymeSiteByServiceProvider(org.semanticwb.pymtur.ServiceProvider serviceprovider,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_serviceProvider, serviceprovider.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSite> listMiPymeSiteByServiceProvider(org.semanticwb.pymtur.ServiceProvider serviceprovider)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSite> it=new org.semanticwb.model.GenericIterator(serviceprovider.getSemanticObject().getModel().listSubjects(pymtur_serviceProvider,serviceprovider.getSemanticObject()));
       return it;
   }
    }

    public MiPymeSiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
    {
        getSemanticObject().setObjectProperty(pymtur_serviceProvider, value.getSemanticObject());
    }

    public void removeServiceProvider()
    {
        getSemanticObject().removeProperty(pymtur_serviceProvider);
    }


    public org.semanticwb.pymtur.ServiceProvider getServiceProvider()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_serviceProvider);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
