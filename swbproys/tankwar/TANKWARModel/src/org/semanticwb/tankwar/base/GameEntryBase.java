package org.semanticwb.tankwar.base;


public abstract class GameEntryBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty tank_entryResult=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#entryResult");
   /**
   * Clase principal. Define la estructura de datos de cada uno de los Tanques
   */
    public static final org.semanticwb.platform.SemanticClass tank_Tank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#Tank");
    public static final org.semanticwb.platform.SemanticProperty tank_entryTank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#entryTank");
    public static final org.semanticwb.platform.SemanticClass tank_GameEntry=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#GameEntry");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#GameEntry");

    public static class ClassMgr
    {
       /**
       * Returns a list of GameEntry for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.tankwar.GameEntry
       */

        public static java.util.Iterator<org.semanticwb.tankwar.GameEntry> listGameEntries(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.GameEntry>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.tankwar.GameEntry for all models
       * @return Iterator of org.semanticwb.tankwar.GameEntry
       */

        public static java.util.Iterator<org.semanticwb.tankwar.GameEntry> listGameEntries()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.GameEntry>(it, true);
        }

        public static org.semanticwb.tankwar.GameEntry createGameEntry(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.tankwar.GameEntry.ClassMgr.createGameEntry(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.tankwar.GameEntry
       * @param id Identifier for org.semanticwb.tankwar.GameEntry
       * @param model Model of the org.semanticwb.tankwar.GameEntry
       * @return A org.semanticwb.tankwar.GameEntry
       */
        public static org.semanticwb.tankwar.GameEntry getGameEntry(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.GameEntry)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.tankwar.GameEntry
       * @param id Identifier for org.semanticwb.tankwar.GameEntry
       * @param model Model of the org.semanticwb.tankwar.GameEntry
       * @return A org.semanticwb.tankwar.GameEntry
       */
        public static org.semanticwb.tankwar.GameEntry createGameEntry(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.GameEntry)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.tankwar.GameEntry
       * @param id Identifier for org.semanticwb.tankwar.GameEntry
       * @param model Model of the org.semanticwb.tankwar.GameEntry
       */
        public static void removeGameEntry(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.tankwar.GameEntry
       * @param id Identifier for org.semanticwb.tankwar.GameEntry
       * @param model Model of the org.semanticwb.tankwar.GameEntry
       * @return true if the org.semanticwb.tankwar.GameEntry exists, false otherwise
       */

        public static boolean hasGameEntry(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGameEntry(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.tankwar.GameEntry with a determined EntryTank
       * @param value EntryTank of the type org.semanticwb.tankwar.Tank
       * @param model Model of the org.semanticwb.tankwar.GameEntry
       * @return Iterator with all the org.semanticwb.tankwar.GameEntry
       */

        public static java.util.Iterator<org.semanticwb.tankwar.GameEntry> listGameEntryByEntryTank(org.semanticwb.tankwar.Tank value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.GameEntry> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(tank_entryTank, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.GameEntry with a determined EntryTank
       * @param value EntryTank of the type org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.GameEntry
       */

        public static java.util.Iterator<org.semanticwb.tankwar.GameEntry> listGameEntryByEntryTank(org.semanticwb.tankwar.Tank value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.GameEntry> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(tank_entryTank,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GameEntryBase with a SemanticObject
   * @param base The SemanticObject with the properties for the GameEntry
   */
    public GameEntryBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the EntryResult property
* @return String with the EntryResult
*/
    public String getEntryResult()
    {
        return getSemanticObject().getProperty(tank_entryResult);
    }

/**
* Sets the EntryResult property
* @param value long with the EntryResult
*/
    public void setEntryResult(String value)
    {
        getSemanticObject().setProperty(tank_entryResult, value);
    }
   /**
   * Sets the value for the property EntryTank
   * @param value EntryTank to set
   */

    public void setEntryTank(org.semanticwb.tankwar.Tank value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(tank_entryTank, value.getSemanticObject());
        }else
        {
            removeEntryTank();
        }
    }
   /**
   * Remove the value for EntryTank property
   */

    public void removeEntryTank()
    {
        getSemanticObject().removeProperty(tank_entryTank);
    }

   /**
   * Gets the EntryTank
   * @return a org.semanticwb.tankwar.Tank
   */
    public org.semanticwb.tankwar.Tank getEntryTank()
    {
         org.semanticwb.tankwar.Tank ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(tank_entryTank);
         if(obj!=null)
         {
             ret=(org.semanticwb.tankwar.Tank)obj.createGenericInstance();
         }
         return ret;
    }
}
