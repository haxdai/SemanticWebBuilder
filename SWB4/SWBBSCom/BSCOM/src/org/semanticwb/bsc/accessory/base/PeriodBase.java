package org.semanticwb.bsc.accessory.base;


   /**
   * Período de medición. 
   */
public abstract class PeriodBase extends org.semanticwb.bsc.accessory.BSCAccessory implements org.semanticwb.bsc.Help,org.semanticwb.model.Referensable,org.semanticwb.model.Activeable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Undeleteable,org.semanticwb.model.RoleRefable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.bsc.Sortable,org.semanticwb.bsc.Machinable
{
    public static final org.semanticwb.platform.SemanticClass bsc_PeriodGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#PeriodGroup");
    public static final org.semanticwb.platform.SemanticProperty bsc_periodGroupInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#periodGroupInv");
   /**
   * Indica la fecha incial del periodo representado
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_start=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#start");
   /**
   * Cualquier elemento BSC al que se le puedan asignar períodos de medición
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Seasonable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Seasonable");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasSeasonableInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasSeasonableInv");
   /**
   * Indica la fecha de término del periodo representado
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_end=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#end");
   /**
   * Período de medición.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Period=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Period");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Period");

    public static class ClassMgr
    {
       /**
       * Returns a list of Period for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriods(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.accessory.Period for all models
       * @return Iterator of org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriods()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period>(it, true);
        }

        public static org.semanticwb.bsc.accessory.Period createPeriod(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.accessory.Period.ClassMgr.createPeriod(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.accessory.Period
       * @param id Identifier for org.semanticwb.bsc.accessory.Period
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return A org.semanticwb.bsc.accessory.Period
       */
        public static org.semanticwb.bsc.accessory.Period getPeriod(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.accessory.Period)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.accessory.Period
       * @param id Identifier for org.semanticwb.bsc.accessory.Period
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return A org.semanticwb.bsc.accessory.Period
       */
        public static org.semanticwb.bsc.accessory.Period createPeriod(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.accessory.Period)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.accessory.Period
       * @param id Identifier for org.semanticwb.bsc.accessory.Period
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       */
        public static void removePeriod(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.accessory.Period
       * @param id Identifier for org.semanticwb.bsc.accessory.Period
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return true if the org.semanticwb.bsc.accessory.Period exists, false otherwise
       */

        public static boolean hasPeriod(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPeriod(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined PeriodGroup
       * @param value PeriodGroup of the type org.semanticwb.bsc.accessory.PeriodGroup
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByPeriodGroup(org.semanticwb.bsc.accessory.PeriodGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_periodGroupInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined PeriodGroup
       * @param value PeriodGroup of the type org.semanticwb.bsc.accessory.PeriodGroup
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByPeriodGroup(org.semanticwb.bsc.accessory.PeriodGroup value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_periodGroupInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Previus
       * @param value Previus of the type org.semanticwb.bsc.Machinable
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByPrevius(org.semanticwb.bsc.Machinable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_previus, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Previus
       * @param value Previus of the type org.semanticwb.bsc.Machinable
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByPrevius(org.semanticwb.bsc.Machinable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_previus,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Next
       * @param value Next of the type org.semanticwb.bsc.Machinable
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByNext(org.semanticwb.bsc.Machinable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_next, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Next
       * @param value Next of the type org.semanticwb.bsc.Machinable
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByNext(org.semanticwb.bsc.Machinable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_next,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Seasonable
       * @param value Seasonable of the type org.semanticwb.bsc.Seasonable
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodBySeasonable(org.semanticwb.bsc.Seasonable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasSeasonableInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined Seasonable
       * @param value Seasonable of the type org.semanticwb.bsc.Seasonable
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodBySeasonable(org.semanticwb.bsc.Seasonable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasSeasonableInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.Period with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.bsc.accessory.Period
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.Period> listPeriodByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PeriodBase.ClassMgr getPeriodClassMgr()
    {
        return new PeriodBase.ClassMgr();
    }

   /**
   * Constructs a PeriodBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Period
   */
    public PeriodBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property PeriodGroup
   * @param value PeriodGroup to set
   */

    public void setPeriodGroup(org.semanticwb.bsc.accessory.PeriodGroup value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_periodGroupInv, value.getSemanticObject());
        }else
        {
            removePeriodGroup();
        }
    }
   /**
   * Remove the value for PeriodGroup property
   */

    public void removePeriodGroup()
    {
        getSemanticObject().removeProperty(bsc_periodGroupInv);
    }

   /**
   * Gets the PeriodGroup
   * @return a org.semanticwb.bsc.accessory.PeriodGroup
   */
    public org.semanticwb.bsc.accessory.PeriodGroup getPeriodGroup()
    {
         org.semanticwb.bsc.accessory.PeriodGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_periodGroupInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.accessory.PeriodGroup)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        //Override this method in Period object
        return getSemanticObject().getIntProperty(bsc_index,false);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        //Override this method in Period object
        getSemanticObject().setIntProperty(bsc_index, value,false);
    }
   /**
   * Sets the value for the property Previus
   * @param value Previus to set
   */

    public void setPrevius(org.semanticwb.bsc.Machinable value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_previus, value.getSemanticObject());
        }else
        {
            removePrevius();
        }
    }
   /**
   * Remove the value for Previus property
   */

    public void removePrevius()
    {
        getSemanticObject().removeProperty(bsc_previus);
    }

   /**
   * Gets the Previus
   * @return a org.semanticwb.bsc.Machinable
   */
    public org.semanticwb.bsc.Machinable getPrevius()
    {
         org.semanticwb.bsc.Machinable ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_previus);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.Machinable)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Start property
* @return java.util.Date with the Start
*/
    public java.util.Date getStart()
    {
        return getSemanticObject().getDateProperty(bsc_start);
    }

/**
* Sets the Start property
* @param value long with the Start
*/
    public void setStart(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_start, value);
    }
   /**
   * Sets the value for the property Next
   * @param value Next to set
   */

    public void setNext(org.semanticwb.bsc.Machinable value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_next, value.getSemanticObject());
        }else
        {
            removeNext();
        }
    }
   /**
   * Remove the value for Next property
   */

    public void removeNext()
    {
        getSemanticObject().removeProperty(bsc_next);
    }

   /**
   * Gets the Next
   * @return a org.semanticwb.bsc.Machinable
   */
    public org.semanticwb.bsc.Machinable getNext()
    {
         org.semanticwb.bsc.Machinable ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_next);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.Machinable)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.bsc.Seasonable
   * @return A GenericIterator with all the org.semanticwb.bsc.Seasonable
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Seasonable> listSeasonables()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Seasonable>(getSemanticObject().listObjectProperties(bsc_hasSeasonableInv));
    }

   /**
   * Gets true if has a Seasonable
   * @param value org.semanticwb.bsc.Seasonable to verify
   * @return true if the org.semanticwb.bsc.Seasonable exists, false otherwise
   */
    public boolean hasSeasonable(org.semanticwb.bsc.Seasonable value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasSeasonableInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the Seasonable
   * @return a org.semanticwb.bsc.Seasonable
   */
    public org.semanticwb.bsc.Seasonable getSeasonable()
    {
         org.semanticwb.bsc.Seasonable ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasSeasonableInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.Seasonable)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the End property
* @return java.util.Date with the End
*/
    public java.util.Date getEnd()
    {
        return getSemanticObject().getDateProperty(bsc_end);
    }

/**
* Sets the End property
* @param value long with the End
*/
    public void setEnd(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_end, value);
    }

   /**
   * Gets the BSC
   * @return a instance of org.semanticwb.bsc.BSC
   */
    public org.semanticwb.bsc.BSC getBSC()
    {
        return (org.semanticwb.bsc.BSC)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
