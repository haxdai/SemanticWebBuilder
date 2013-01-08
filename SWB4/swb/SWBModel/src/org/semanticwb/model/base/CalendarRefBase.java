package org.semanticwb.model.base;


   /**
   * Referencia a un objeto de tipo Calendar 
   */
public abstract class CalendarRefBase extends org.semanticwb.model.Reference implements org.semanticwb.model.Activeable
{
   /**
   * Objeto de calendarización que permite configurar una página o un recurso para desplegarse en cierta fecha, entre un rango de fechas o incluso en periodos de tiempo definidos.
   */
    public static final org.semanticwb.platform.SemanticClass swb_Calendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Calendar");
    public static final org.semanticwb.platform.SemanticProperty swb_calendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#calendar");
   /**
   * Referencia a un objeto de tipo Calendar
   */
    public static final org.semanticwb.platform.SemanticClass swb_CalendarRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#CalendarRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#CalendarRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of CalendarRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.CalendarRef
       */

        public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.CalendarRef for all models
       * @return Iterator of org.semanticwb.model.CalendarRef
       */

        public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef>(it, true);
        }

        public static org.semanticwb.model.CalendarRef createCalendarRef(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.CalendarRef.ClassMgr.createCalendarRef(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.CalendarRef
       * @param id Identifier for org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.model.CalendarRef
       * @return A org.semanticwb.model.CalendarRef
       */
        public static org.semanticwb.model.CalendarRef getCalendarRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.CalendarRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.CalendarRef
       * @param id Identifier for org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.model.CalendarRef
       * @return A org.semanticwb.model.CalendarRef
       */
        public static org.semanticwb.model.CalendarRef createCalendarRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.CalendarRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.CalendarRef
       * @param id Identifier for org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.model.CalendarRef
       */
        public static void removeCalendarRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.CalendarRef
       * @param id Identifier for org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.model.CalendarRef
       * @return true if the org.semanticwb.model.CalendarRef exists, false otherwise
       */

        public static boolean hasCalendarRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCalendarRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.CalendarRef with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.model.CalendarRef
       */

        public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_calendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.CalendarRef with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the org.semanticwb.model.CalendarRef
       */

        public static java.util.Iterator<org.semanticwb.model.CalendarRef> listCalendarRefByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.CalendarRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_calendar,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CalendarRefBase.ClassMgr getCalendarRefClassMgr()
    {
        return new CalendarRefBase.ClassMgr();
    }

   /**
   * Constructs a CalendarRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CalendarRef
   */
    public CalendarRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Calendar
   * @param value Calendar to set
   */

    public void setCalendar(org.semanticwb.model.Calendar value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_calendar, value.getSemanticObject());
        }else
        {
            removeCalendar();
        }
    }
   /**
   * Remove the value for Calendar property
   */

    public void removeCalendar()
    {
        getSemanticObject().removeProperty(swb_calendar);
    }

   /**
   * Gets the Calendar
   * @return a org.semanticwb.model.Calendar
   */
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

   /**
   * Gets the WebSite
   * @return a instance of org.semanticwb.model.WebSite
   */
    public org.semanticwb.model.WebSite getWebSite()
    {
        return (org.semanticwb.model.WebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
