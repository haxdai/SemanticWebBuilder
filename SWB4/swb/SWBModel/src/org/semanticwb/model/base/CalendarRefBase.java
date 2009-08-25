package org.semanticwb.model.base;


public class CalendarRefBase extends org.semanticwb.model.Reference implements org.semanticwb.model.Activeable
{
    public static final org.semanticwb.platform.SemanticClass swb_Calendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Calendar");
    public static final org.semanticwb.platform.SemanticProperty swb_calendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#calendar");
    public static final org.semanticwb.platform.SemanticClass swb_CalendarRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#CalendarRef");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#CalendarRef");

    public CalendarRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefs(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefs()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef>(it, true);
    }

    public static org.semanticwb.model.CalendarRef createCalendarRef(org.semanticwb.model.SWBModel model)
    {
        long id=model.getSemanticObject().getModel().getCounter(sclass);
        return org.semanticwb.model.CalendarRef.createCalendarRef(String.valueOf(id), model);
    }

    public static org.semanticwb.model.CalendarRef getCalendarRef(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.CalendarRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.CalendarRef createCalendarRef(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.CalendarRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeCalendarRef(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasCalendarRef(String id, org.semanticwb.model.SWBModel model)
    {
        return (getCalendarRef(id, model)!=null);
    }

    public void setCalendar(org.semanticwb.model.Calendar value)
    {
        getSemanticObject().setObjectProperty(swb_calendar, value.getSemanticObject());
    }

    public void removeCalendar()
    {
        getSemanticObject().removeProperty(swb_calendar);
    }

   public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefByCalendar(org.semanticwb.model.Calendar calendar,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_calendar, calendar.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefByCalendar(org.semanticwb.model.Calendar calendar)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef> it=new org.semanticwb.model.GenericIterator(calendar.getSemanticObject().getModel().listSubjects(swb_calendar,calendar.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.Calendar getCalendar()
    {
         org.semanticwb.model.Calendar ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_calendar);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Calendar)obj.createGenericInstance();
         }
         return ret;
    }
}
