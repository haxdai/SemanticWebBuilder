package org.semanticwb.portal.community.base;


public class EventElementBase extends org.semanticwb.portal.community.MicroSiteElement implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.Viewable
{
    public static final org.semanticwb.platform.SemanticProperty swbcomm_endTime=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#endTime");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_eventThumbnail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#eventThumbnail");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_audienceType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#audienceType");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_latitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#latitude");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_endDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#endDate");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_startDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#startDate");
    public static final org.semanticwb.platform.SemanticClass swb_WebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebPage");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_eventWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#eventWebPage");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_eventImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#eventImage");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_longitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#longitude");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_startTime=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#startTime");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_place=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#place");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_hasAttendant=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#hasAttendant");
    public static final org.semanticwb.platform.SemanticClass swbcomm_EventElement=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#EventElement");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#EventElement");

    public EventElementBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.portal.community.EventElement> listEventElements(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.EventElement>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.portal.community.EventElement> listEventElements()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.EventElement>(it, true);
    }

    public static org.semanticwb.portal.community.EventElement createEventElement(org.semanticwb.model.SWBModel model)
    {
        long id=model.getSemanticObject().getModel().getCounter(sclass);
        return org.semanticwb.portal.community.EventElement.createEventElement(String.valueOf(id), model);
    }

    public static org.semanticwb.portal.community.EventElement getEventElement(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.portal.community.EventElement)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.portal.community.EventElement createEventElement(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.portal.community.EventElement)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeEventElement(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasEventElement(String id, org.semanticwb.model.SWBModel model)
    {
        return (getEventElement(id, model)!=null);
    }

    public java.util.Date getEndTime()
    {
        return getSemanticObject().getDateProperty(swbcomm_endTime);
    }

    public void setEndTime(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbcomm_endTime, value);
    }

    public String getEventThumbnail()
    {
        return getSemanticObject().getProperty(swbcomm_eventThumbnail);
    }

    public void setEventThumbnail(String value)
    {
        getSemanticObject().setProperty(swbcomm_eventThumbnail, value);
    }

    public String getAudienceType()
    {
        return getSemanticObject().getProperty(swbcomm_audienceType);
    }

    public void setAudienceType(String value)
    {
        getSemanticObject().setProperty(swbcomm_audienceType, value);
    }

    public String getLatitude()
    {
        return getSemanticObject().getProperty(swbcomm_latitude);
    }

    public void setLatitude(String value)
    {
        getSemanticObject().setProperty(swbcomm_latitude, value);
    }

    public java.util.Date getEndDate()
    {
        return getSemanticObject().getDateProperty(swbcomm_endDate);
    }

    public void setEndDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbcomm_endDate, value);
    }

    public java.util.Date getStartDate()
    {
        return getSemanticObject().getDateProperty(swbcomm_startDate);
    }

    public void setStartDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbcomm_startDate, value);
    }

    public void setEventWebPage(org.semanticwb.model.WebPage value)
    {
        getSemanticObject().setObjectProperty(swbcomm_eventWebPage, value.getSemanticObject());
    }

    public void removeEventWebPage()
    {
        getSemanticObject().removeProperty(swbcomm_eventWebPage);
    }

   public static java.util.Iterator<org.semanticwb.portal.community.EventElement> listEventElementByEventWebPage(org.semanticwb.model.WebPage eventwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.EventElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_eventWebPage, eventwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.EventElement> listEventElementByEventWebPage(org.semanticwb.model.WebPage eventwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.EventElement> it=new org.semanticwb.model.GenericIterator(eventwebpage.getSemanticObject().getModel().listSubjects(swbcomm_eventWebPage,eventwebpage.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.WebPage getEventWebPage()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbcomm_eventWebPage);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

    public String getEventImage()
    {
        return getSemanticObject().getProperty(swbcomm_eventImage);
    }

    public void setEventImage(String value)
    {
        getSemanticObject().setProperty(swbcomm_eventImage, value);
    }

    public String getLongitude()
    {
        return getSemanticObject().getProperty(swbcomm_longitude);
    }

    public void setLongitude(String value)
    {
        getSemanticObject().setProperty(swbcomm_longitude, value);
    }

    public java.util.Date getStartTime()
    {
        return getSemanticObject().getDateProperty(swbcomm_startTime);
    }

    public void setStartTime(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbcomm_startTime, value);
    }

    public String getPlace()
    {
        return getSemanticObject().getProperty(swbcomm_place);
    }

    public void setPlace(String value)
    {
        getSemanticObject().setProperty(swbcomm_place, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listAttendants()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(swbcomm_hasAttendant));
    }

    public boolean hasAttendant(org.semanticwb.model.User user)
    {
        if(user==null)return false;
        return getSemanticObject().hasObjectProperty(swbcomm_hasAttendant,user.getSemanticObject());
    }

    public void addAttendant(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(swbcomm_hasAttendant, value.getSemanticObject());
    }

    public void removeAllAttendant()
    {
        getSemanticObject().removeProperty(swbcomm_hasAttendant);
    }

    public void removeAttendant(org.semanticwb.model.User user)
    {
        getSemanticObject().removeObjectProperty(swbcomm_hasAttendant,user.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.portal.community.EventElement> listEventElementByAttendant(org.semanticwb.model.User hasattendant,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.EventElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasAttendant, hasattendant.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.EventElement> listEventElementByAttendant(org.semanticwb.model.User hasattendant)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.EventElement> it=new org.semanticwb.model.GenericIterator(hasattendant.getSemanticObject().getModel().listSubjects(swbcomm_hasAttendant,hasattendant.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getAttendant()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbcomm_hasAttendant);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
