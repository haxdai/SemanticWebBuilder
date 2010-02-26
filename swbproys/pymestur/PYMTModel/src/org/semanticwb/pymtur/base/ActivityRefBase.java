package org.semanticwb.pymtur.base;


public abstract class ActivityRefBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_arPriority=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#arPriority");
    public static final org.semanticwb.platform.SemanticClass pymtur_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Activity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_arActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#arActivity");
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticProperty pymtur_arServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#arServiceProviderInv");
    public static final org.semanticwb.platform.SemanticClass pymtur_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ActivityRef");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ActivityRef");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.ActivityRef> listActivityRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ActivityRef> listActivityRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef>(it, true);
        }

        public static org.semanticwb.pymtur.ActivityRef createActivityRef(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.ActivityRef.ClassMgr.createActivityRef(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.ActivityRef getActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.ActivityRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.ActivityRef createActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.ActivityRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActivityRef(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ActivityRef> listActivityRefByActivity(org.semanticwb.pymtur.Activity aractivity,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_arActivity, aractivity.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ActivityRef> listActivityRefByActivity(org.semanticwb.pymtur.Activity aractivity)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef> it=new org.semanticwb.model.GenericIterator(aractivity.getSemanticObject().getModel().listSubjects(pymtur_arActivity,aractivity.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ActivityRef> listActivityRefByServiceProvider(org.semanticwb.pymtur.ServiceProvider arserviceproviderinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_arServiceProviderInv, arserviceproviderinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ActivityRef> listActivityRefByServiceProvider(org.semanticwb.pymtur.ServiceProvider arserviceproviderinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef> it=new org.semanticwb.model.GenericIterator(arserviceproviderinv.getSemanticObject().getModel().listSubjects(pymtur_arServiceProviderInv,arserviceproviderinv.getSemanticObject()));
            return it;
        }
    }

    public ActivityRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public int getPriority()
    {
        return getSemanticObject().getIntProperty(pymtur_arPriority);
    }

    public void setPriority(int value)
    {
        getSemanticObject().setIntProperty(pymtur_arPriority, value);
    }

    public void setActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().setObjectProperty(pymtur_arActivity, value.getSemanticObject());
    }

    public void removeActivity()
    {
        getSemanticObject().removeProperty(pymtur_arActivity);
    }

    public org.semanticwb.pymtur.Activity getActivity()
    {
         org.semanticwb.pymtur.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_arActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Activity)obj.createGenericInstance();
         }
         return ret;
    }

    public void setServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
    {
        getSemanticObject().setObjectProperty(pymtur_arServiceProviderInv, value.getSemanticObject());
    }

    public void removeServiceProvider()
    {
        getSemanticObject().removeProperty(pymtur_arServiceProviderInv);
    }

    public org.semanticwb.pymtur.ServiceProvider getServiceProvider()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_arServiceProviderInv);
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
