package org.semanticwb.process.model.base;


public abstract class SignalStartEventBase extends org.semanticwb.process.model.StartEvent implements org.semanticwb.process.model.Assignable,org.semanticwb.process.model.Catchable,org.semanticwb.model.Descriptiveable
{
       public static final org.semanticwb.platform.SemanticClass swp_SignalStartEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/swp#SignalStartEvent");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/swp#SignalStartEvent");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEvents(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEvents()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent>(it, true);
       }

       public static org.semanticwb.process.model.SignalStartEvent createSignalStartEvent(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.process.model.SignalStartEvent.ClassMgr.createSignalStartEvent(String.valueOf(id), model);
       }

       public static org.semanticwb.process.model.SignalStartEvent getSignalStartEvent(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.process.model.SignalStartEvent)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.process.model.SignalStartEvent createSignalStartEvent(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.process.model.SignalStartEvent)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeSignalStartEvent(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasSignalStartEvent(String id, org.semanticwb.model.SWBModel model)
       {
           return (getSignalStartEvent(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEventByTrigger(org.semanticwb.process.model.EventDetail hastrigger,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swp_hasTrigger, hastrigger.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEventByTrigger(org.semanticwb.process.model.EventDetail hastrigger)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent> it=new org.semanticwb.model.GenericIterator(hastrigger.getSemanticObject().getModel().listSubjects(swp_hasTrigger,hastrigger.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEventByAssignment(org.semanticwb.process.model.Assignment hasassignment,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swp_hasAssignment, hasassignment.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEventByAssignment(org.semanticwb.process.model.Assignment hasassignment)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent> it=new org.semanticwb.model.GenericIterator(hasassignment.getSemanticObject().getModel().listSubjects(swp_hasAssignment,hasassignment.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEventByCategory(org.semanticwb.process.model.Category hascategory,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swp_hasCategory, hascategory.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.process.model.SignalStartEvent> listSignalStartEventByCategory(org.semanticwb.process.model.Category hascategory)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.SignalStartEvent> it=new org.semanticwb.model.GenericIterator(hascategory.getSemanticObject().getModel().listSubjects(swp_hasCategory,hascategory.getSemanticObject()));
       return it;
   }
    }

    public SignalStartEventBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.process.model.EventDetail> listTriggers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.EventDetail>(getSemanticObject().listObjectProperties(swp_hasTrigger));
    }

    public boolean hasTrigger(org.semanticwb.process.model.EventDetail eventdetail)
    {
        if(eventdetail==null)return false;
        return getSemanticObject().hasObjectProperty(swp_hasTrigger,eventdetail.getSemanticObject());
    }

    public void addTrigger(org.semanticwb.process.model.EventDetail value)
    {
        getSemanticObject().addObjectProperty(swp_hasTrigger, value.getSemanticObject());
    }

    public void removeAllTrigger()
    {
        getSemanticObject().removeProperty(swp_hasTrigger);
    }

    public void removeTrigger(org.semanticwb.process.model.EventDetail eventdetail)
    {
        getSemanticObject().removeObjectProperty(swp_hasTrigger,eventdetail.getSemanticObject());
    }


    public org.semanticwb.process.model.EventDetail getTrigger()
    {
         org.semanticwb.process.model.EventDetail ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swp_hasTrigger);
         if(obj!=null)
         {
             ret=(org.semanticwb.process.model.EventDetail)obj.createGenericInstance();
         }
         return ret;
    }
}
