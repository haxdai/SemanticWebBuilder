package org.semanticwb.promexico.base;


public abstract class CalendarPromBase extends org.semanticwb.portal.resources.sem.calendar.Calendar implements org.semanticwb.model.Traceable,org.semanticwb.model.Trashable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Referensable
{
    public static final org.semanticwb.platform.SemanticProperty cal_previousYear=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#previousYear");
    public static final org.semanticwb.platform.SemanticProperty cal_roleForAdmin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#roleForAdmin");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty swb_modifiedBy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#modifiedBy");
    public static final org.semanticwb.platform.SemanticProperty swb_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#created");
    public static final org.semanticwb.platform.SemanticProperty swb_updated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#updated");
    public static final org.semanticwb.platform.SemanticClass cal_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/calendar#Event");
    public static final org.semanticwb.platform.SemanticProperty cal_hasEvents=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#hasEvents");
    public static final org.semanticwb.platform.SemanticProperty cal_JspStrategy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#JspStrategy");
    public static final org.semanticwb.platform.SemanticProperty swb_deleted=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#deleted");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass swb_Language=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Language");
    public static final org.semanticwb.platform.SemanticProperty swb_language=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#language");
    public static final org.semanticwb.platform.SemanticProperty cal_idPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#idPage");
    public static final org.semanticwb.platform.SemanticProperty cal_nextYear=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#nextYear");
    public static final org.semanticwb.platform.SemanticProperty swb_creator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#creator");
    public static final org.semanticwb.platform.SemanticClass promx_EventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#eventType");
    public static final org.semanticwb.platform.SemanticProperty promx_EvtType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#EvtType");
    public static final org.semanticwb.platform.SemanticProperty cal_numberNearEvents=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#numberNearEvents");
    public static final org.semanticwb.platform.SemanticProperty cal_paginationEvents=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#paginationEvents");
    public static final org.semanticwb.platform.SemanticClass swb_UserGroupRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserGroupRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasUserGroupRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasUserGroupRef");
    public static final org.semanticwb.platform.SemanticClass swb_RoleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RoleRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRoleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRoleRef");
    public static final org.semanticwb.platform.SemanticProperty cal_JspView=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/calendar#JspView");
    public static final org.semanticwb.platform.SemanticClass promx_CalendarProm=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#CalendarProm");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#CalendarProm");

    public CalendarPromBase()
    {
    }

   /**
   * Constructs a CalendarPromBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CalendarProm
   */
    public CalendarPromBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /*
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() 
    {
        return getSemanticObject().hashCode();
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) 
    {
        if(obj==null)return false;
        return hashCode()==obj.hashCode();
    }

/**
* Gets the PreviousYear property
* @return boolean with the PreviousYear
*/
    public boolean isPreviousYear()
    {
        return getSemanticObject().getBooleanProperty(cal_previousYear);
    }

/**
* Sets the PreviousYear property
* @param value long with the PreviousYear
*/
    public void setPreviousYear(boolean value)
    {
        getSemanticObject().setBooleanProperty(cal_previousYear, value);
    }

/**
* Gets the RoleForAdmin property
* @return String with the RoleForAdmin
*/
    public String getRoleForAdmin()
    {
        return getSemanticObject().getProperty(cal_roleForAdmin);
    }

/**
* Sets the RoleForAdmin property
* @param value long with the RoleForAdmin
*/
    public void setRoleForAdmin(String value)
    {
        getSemanticObject().setProperty(cal_roleForAdmin, value);
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }
   /**
   * Gets all the org.semanticwb.portal.resources.sem.calendar.Event
   * @return A GenericIterator with all the org.semanticwb.portal.resources.sem.calendar.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.calendar.Event> listEventses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.calendar.Event>(getSemanticObject().listObjectProperties(cal_hasEvents));
    }

   /**
   * Gets true if has a Events
   * @param value org.semanticwb.portal.resources.sem.calendar.Event to verify
   * @return true if the org.semanticwb.portal.resources.sem.calendar.Event exists, false otherwise
   */
    public boolean hasEvents(org.semanticwb.portal.resources.sem.calendar.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cal_hasEvents,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Events
   * @param value org.semanticwb.portal.resources.sem.calendar.Event to add
   */

    public void addEvents(org.semanticwb.portal.resources.sem.calendar.Event value)
    {
        getSemanticObject().addObjectProperty(cal_hasEvents, value.getSemanticObject());
    }
   /**
   * Removes all the Events
   */

    public void removeAllEvents()
    {
        getSemanticObject().removeProperty(cal_hasEvents);
    }
   /**
   * Removes a Events
   * @param value org.semanticwb.portal.resources.sem.calendar.Event to remove
   */

    public void removeEvents(org.semanticwb.portal.resources.sem.calendar.Event value)
    {
        getSemanticObject().removeObjectProperty(cal_hasEvents,value.getSemanticObject());
    }

   /**
   * Gets the Events
   * @return a org.semanticwb.portal.resources.sem.calendar.Event
   */
    public org.semanticwb.portal.resources.sem.calendar.Event getEvents()
    {
         org.semanticwb.portal.resources.sem.calendar.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cal_hasEvents);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.calendar.Event)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the JspStrategy property
* @return String with the JspStrategy
*/
    public String getJspStrategy()
    {
        return getSemanticObject().getProperty(cal_JspStrategy);
    }

/**
* Sets the JspStrategy property
* @param value long with the JspStrategy
*/
    public void setJspStrategy(String value)
    {
        getSemanticObject().setProperty(cal_JspStrategy, value);
    }

/**
* Gets the Deleted property
* @return boolean with the Deleted
*/
    public boolean isDeleted()
    {
        return getSemanticObject().getBooleanProperty(swb_deleted);
    }

/**
* Sets the Deleted property
* @param value long with the Deleted
*/
    public void setDeleted(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_deleted, value);
    }
   /**
   * Sets the value for the property Resource
   * @param value Resource to set
   */

    public void setResource(org.semanticwb.model.Resource value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_semanticResourceInv, value.getSemanticObject());
        }else
        {
            removeResource();
        }
    }
   /**
   * Remove the value for Resource property
   */

    public void removeResource()
    {
        getSemanticObject().removeProperty(swb_semanticResourceInv);
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_semanticResourceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Language
   * @param value Language to set
   */

    public void setLanguage(org.semanticwb.model.Language value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_language, value.getSemanticObject());
        }else
        {
            removeLanguage();
        }
    }
   /**
   * Remove the value for Language property
   */

    public void removeLanguage()
    {
        getSemanticObject().removeProperty(swb_language);
    }

   /**
   * Gets the Language
   * @return a org.semanticwb.model.Language
   */
    public org.semanticwb.model.Language getLanguage()
    {
         org.semanticwb.model.Language ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_language);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Language)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the IdPage property
* @return String with the IdPage
*/
    public String getIdPage()
    {
        return getSemanticObject().getProperty(cal_idPage);
    }

/**
* Sets the IdPage property
* @param value long with the IdPage
*/
    public void setIdPage(String value)
    {
        getSemanticObject().setProperty(cal_idPage, value);
    }

/**
* Gets the NextYear property
* @return boolean with the NextYear
*/
    public boolean isNextYear()
    {
        return getSemanticObject().getBooleanProperty(cal_nextYear);
    }

/**
* Sets the NextYear property
* @param value long with the NextYear
*/
    public void setNextYear(boolean value)
    {
        getSemanticObject().setBooleanProperty(cal_nextYear, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EvtType
   * @param value EvtType to set
   */

    public void setEvtType(org.semanticwb.promexico.EventType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(promx_EvtType, value.getSemanticObject());
        }else
        {
            removeEvtType();
        }
    }
   /**
   * Remove the value for EvtType property
   */

    public void removeEvtType()
    {
        getSemanticObject().removeProperty(promx_EvtType);
    }

   /**
   * Gets the EvtType
   * @return a org.semanticwb.promexico.EventType
   */
    public org.semanticwb.promexico.EventType getEvtType()
    {
         org.semanticwb.promexico.EventType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_EvtType);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.EventType)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NumberNearEvents property
* @return int with the NumberNearEvents
*/
    public int getNumberNearEvents()
    {
        return getSemanticObject().getIntProperty(cal_numberNearEvents);
    }

/**
* Sets the NumberNearEvents property
* @param value long with the NumberNearEvents
*/
    public void setNumberNearEvents(int value)
    {
        getSemanticObject().setIntProperty(cal_numberNearEvents, value);
    }

/**
* Gets the PaginationEvents property
* @return int with the PaginationEvents
*/
    public int getPaginationEvents()
    {
        return getSemanticObject().getIntProperty(cal_paginationEvents);
    }

/**
* Sets the PaginationEvents property
* @param value long with the PaginationEvents
*/
    public void setPaginationEvents(int value)
    {
        getSemanticObject().setIntProperty(cal_paginationEvents, value);
    }
   /**
   * Gets all the org.semanticwb.model.UserGroupRef
   * @return A GenericIterator with all the org.semanticwb.model.UserGroupRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef> listUserGroupRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef>(getSemanticObject().listObjectProperties(swb_hasUserGroupRef));
    }

   /**
   * Gets true if has a UserGroupRef
   * @param value org.semanticwb.model.UserGroupRef to verify
   * @return true if the org.semanticwb.model.UserGroupRef exists, false otherwise
   */
    public boolean hasUserGroupRef(org.semanticwb.model.UserGroupRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasUserGroupRef,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets all the UserGroupRefs inherits
   * @return A GenericIterator with all the org.semanticwb.model.UserGroupRef
   */
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef> listInheritUserGroupRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef>(getSemanticObject().listInheritProperties(swb_hasUserGroupRef));
    }
   /**
   * Adds a UserGroupRef
   * @param value org.semanticwb.model.UserGroupRef to add
   */

    public void addUserGroupRef(org.semanticwb.model.UserGroupRef value)
    {
        getSemanticObject().addObjectProperty(swb_hasUserGroupRef, value.getSemanticObject());
    }
   /**
   * Removes all the UserGroupRef
   */

    public void removeAllUserGroupRef()
    {
        getSemanticObject().removeProperty(swb_hasUserGroupRef);
    }
   /**
   * Removes a UserGroupRef
   * @param value org.semanticwb.model.UserGroupRef to remove
   */

    public void removeUserGroupRef(org.semanticwb.model.UserGroupRef value)
    {
        getSemanticObject().removeObjectProperty(swb_hasUserGroupRef,value.getSemanticObject());
    }

   /**
   * Gets the UserGroupRef
   * @return a org.semanticwb.model.UserGroupRef
   */
    public org.semanticwb.model.UserGroupRef getUserGroupRef()
    {
         org.semanticwb.model.UserGroupRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasUserGroupRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserGroupRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.model.RoleRef
   * @return A GenericIterator with all the org.semanticwb.model.RoleRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef> listRoleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef>(getSemanticObject().listObjectProperties(swb_hasRoleRef));
    }

   /**
   * Gets true if has a RoleRef
   * @param value org.semanticwb.model.RoleRef to verify
   * @return true if the org.semanticwb.model.RoleRef exists, false otherwise
   */
    public boolean hasRoleRef(org.semanticwb.model.RoleRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasRoleRef,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets all the RoleRefs inherits
   * @return A GenericIterator with all the org.semanticwb.model.RoleRef
   */
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef> listInheritRoleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef>(getSemanticObject().listInheritProperties(swb_hasRoleRef));
    }
   /**
   * Adds a RoleRef
   * @param value org.semanticwb.model.RoleRef to add
   */

    public void addRoleRef(org.semanticwb.model.RoleRef value)
    {
        getSemanticObject().addObjectProperty(swb_hasRoleRef, value.getSemanticObject());
    }
   /**
   * Removes all the RoleRef
   */

    public void removeAllRoleRef()
    {
        getSemanticObject().removeProperty(swb_hasRoleRef);
    }
   /**
   * Removes a RoleRef
   * @param value org.semanticwb.model.RoleRef to remove
   */

    public void removeRoleRef(org.semanticwb.model.RoleRef value)
    {
        getSemanticObject().removeObjectProperty(swb_hasRoleRef,value.getSemanticObject());
    }

   /**
   * Gets the RoleRef
   * @return a org.semanticwb.model.RoleRef
   */
    public org.semanticwb.model.RoleRef getRoleRef()
    {
         org.semanticwb.model.RoleRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRoleRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.RoleRef)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the JspView property
* @return String with the JspView
*/
    public String getJspView()
    {
        return getSemanticObject().getProperty(cal_JspView);
    }

/**
* Sets the JspView property
* @param value long with the JspView
*/
    public void setJspView(String value)
    {
        getSemanticObject().setProperty(cal_JspView, value);
    }
}
