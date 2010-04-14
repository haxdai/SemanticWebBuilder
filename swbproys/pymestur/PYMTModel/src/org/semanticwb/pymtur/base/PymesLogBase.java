package org.semanticwb.pymtur.base;


public abstract class PymesLogBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_spLogStatus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spLogStatus");
    public static final org.semanticwb.platform.SemanticProperty pymtur_logDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#logDate");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty pymtur_logUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#logUser");
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticProperty pymtur_serviceProviderLog=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#serviceProviderLog");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spLogStatusComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spLogStatusComment");
    public static final org.semanticwb.platform.SemanticClass pymtur_PymesLog=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymesLog");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymesLog");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.PymesLog> listPymesLogs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymesLog>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PymesLog> listPymesLogs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymesLog>(it, true);
        }

        public static org.semanticwb.pymtur.PymesLog createPymesLog(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.PymesLog.ClassMgr.createPymesLog(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.PymesLog getPymesLog(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.PymesLog)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.PymesLog createPymesLog(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.PymesLog)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removePymesLog(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasPymesLog(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPymesLog(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PymesLog> listPymesLogByLogUser(org.semanticwb.model.User loguser,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymesLog> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_logUser, loguser.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PymesLog> listPymesLogByLogUser(org.semanticwb.model.User loguser)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymesLog> it=new org.semanticwb.model.GenericIterator(loguser.getSemanticObject().getModel().listSubjectsByClass(pymtur_logUser,loguser.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PymesLog> listPymesLogByServiceProviderLog(org.semanticwb.pymtur.ServiceProvider serviceproviderlog,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymesLog> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_serviceProviderLog, serviceproviderlog.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PymesLog> listPymesLogByServiceProviderLog(org.semanticwb.pymtur.ServiceProvider serviceproviderlog)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymesLog> it=new org.semanticwb.model.GenericIterator(serviceproviderlog.getSemanticObject().getModel().listSubjectsByClass(pymtur_serviceProviderLog,serviceproviderlog.getSemanticObject(),sclass));
            return it;
        }
    }

    public PymesLogBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public int getSpLogStatus()
    {
        return getSemanticObject().getIntProperty(pymtur_spLogStatus);
    }

    public void setSpLogStatus(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spLogStatus, value);
    }

    public java.util.Date getLogDate()
    {
        return getSemanticObject().getDateProperty(pymtur_logDate);
    }

    public void setLogDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_logDate, value);
    }

    public void setLogUser(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(pymtur_logUser, value.getSemanticObject());
    }

    public void removeLogUser()
    {
        getSemanticObject().removeProperty(pymtur_logUser);
    }

    public org.semanticwb.model.User getLogUser()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_logUser);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public void setServiceProviderLog(org.semanticwb.pymtur.ServiceProvider value)
    {
        getSemanticObject().setObjectProperty(pymtur_serviceProviderLog, value.getSemanticObject());
    }

    public void removeServiceProviderLog()
    {
        getSemanticObject().removeProperty(pymtur_serviceProviderLog);
    }

    public org.semanticwb.pymtur.ServiceProvider getServiceProviderLog()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_serviceProviderLog);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }

    public String getSpLogStatusComment()
    {
        return getSemanticObject().getProperty(pymtur_spLogStatusComment);
    }

    public void setSpLogStatusComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spLogStatusComment, value);
    }
}
