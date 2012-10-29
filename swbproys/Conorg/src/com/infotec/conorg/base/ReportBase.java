package com.infotec.conorg.base;


public abstract class ReportBase extends com.infotec.conorg.Document implements org.semanticwb.model.Indexable,org.semanticwb.model.Versionable,org.semanticwb.model.Traceable,com.infotec.conorg.Topicable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Calendarable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_reportVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#reportVersion");
    public static final org.semanticwb.platform.SemanticClass conorg_Report=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Report");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Report");

    public static class ClassMgr
    {
       /**
       * Returns a list of Report for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReports(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Report>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Report for all models
       * @return Iterator of com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReports()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Report>(it, true);
        }

        public static com.infotec.conorg.Report createReport(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Report.ClassMgr.createReport(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Report
       * @param id Identifier for com.infotec.conorg.Report
       * @param model Model of the com.infotec.conorg.Report
       * @return A com.infotec.conorg.Report
       */
        public static com.infotec.conorg.Report getReport(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Report)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Report
       * @param id Identifier for com.infotec.conorg.Report
       * @param model Model of the com.infotec.conorg.Report
       * @return A com.infotec.conorg.Report
       */
        public static com.infotec.conorg.Report createReport(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Report)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Report
       * @param id Identifier for com.infotec.conorg.Report
       * @param model Model of the com.infotec.conorg.Report
       */
        public static void removeReport(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Report
       * @param id Identifier for com.infotec.conorg.Report
       * @param model Model of the com.infotec.conorg.Report
       * @return true if the com.infotec.conorg.Report exists, false otherwise
       */

        public static boolean hasReport(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReport(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Report
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Report
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Report
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Report
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Report
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Report
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Report with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Report
       */

        public static java.util.Iterator<com.infotec.conorg.Report> listReportByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Report> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ReportBase.ClassMgr getReportClassMgr()
    {
        return new ReportBase.ClassMgr();
    }

   /**
   * Constructs a ReportBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Report
   */
    public ReportBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ReportVersion property
* @return String with the ReportVersion
*/
    public String getReportVersion()
    {
        return getSemanticObject().getProperty(conorg_reportVersion);
    }

/**
* Sets the ReportVersion property
* @param value long with the ReportVersion
*/
    public void setReportVersion(String value)
    {
        getSemanticObject().setProperty(conorg_reportVersion, value);
    }
}
