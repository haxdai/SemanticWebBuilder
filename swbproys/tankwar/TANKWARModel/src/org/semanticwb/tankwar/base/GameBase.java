package org.semanticwb.tankwar.base;


public abstract class GameBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty tank_date=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#date");
    public static final org.semanticwb.platform.SemanticClass tank_GameEntry=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#GameEntry");
    public static final org.semanticwb.platform.SemanticProperty tank_hasGameEntry=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#hasGameEntry");
    public static final org.semanticwb.platform.SemanticClass tank_Game=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#Game");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#Game");

    public static class ClassMgr
    {
       /**
       * Returns a list of Game for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.tankwar.Game
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Game> listGames(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Game>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.tankwar.Game for all models
       * @return Iterator of org.semanticwb.tankwar.Game
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Game> listGames()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Game>(it, true);
        }

        public static org.semanticwb.tankwar.Game createGame(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.tankwar.Game.ClassMgr.createGame(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.tankwar.Game
       * @param id Identifier for org.semanticwb.tankwar.Game
       * @param model Model of the org.semanticwb.tankwar.Game
       * @return A org.semanticwb.tankwar.Game
       */
        public static org.semanticwb.tankwar.Game getGame(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.Game)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.tankwar.Game
       * @param id Identifier for org.semanticwb.tankwar.Game
       * @param model Model of the org.semanticwb.tankwar.Game
       * @return A org.semanticwb.tankwar.Game
       */
        public static org.semanticwb.tankwar.Game createGame(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.Game)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.tankwar.Game
       * @param id Identifier for org.semanticwb.tankwar.Game
       * @param model Model of the org.semanticwb.tankwar.Game
       */
        public static void removeGame(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.tankwar.Game
       * @param id Identifier for org.semanticwb.tankwar.Game
       * @param model Model of the org.semanticwb.tankwar.Game
       * @return true if the org.semanticwb.tankwar.Game exists, false otherwise
       */

        public static boolean hasGame(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGame(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.tankwar.Game with a determined GameEntry
       * @param value GameEntry of the type org.semanticwb.tankwar.GameEntry
       * @param model Model of the org.semanticwb.tankwar.Game
       * @return Iterator with all the org.semanticwb.tankwar.Game
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Game> listGameByGameEntry(org.semanticwb.tankwar.GameEntry value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Game> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(tank_hasGameEntry, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Game with a determined GameEntry
       * @param value GameEntry of the type org.semanticwb.tankwar.GameEntry
       * @return Iterator with all the org.semanticwb.tankwar.Game
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Game> listGameByGameEntry(org.semanticwb.tankwar.GameEntry value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Game> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(tank_hasGameEntry,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GameBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Game
   */
    public GameBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Date property
* @return java.util.Date with the Date
*/
    public java.util.Date getDate()
    {
        return getSemanticObject().getDateProperty(tank_date);
    }

/**
* Sets the Date property
* @param value long with the Date
*/
    public void setDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(tank_date, value);
    }
   /**
   * Gets all the org.semanticwb.tankwar.GameEntry
   * @return A GenericIterator with all the org.semanticwb.tankwar.GameEntry
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.GameEntry> listGameEntries()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.GameEntry>(getSemanticObject().listObjectProperties(tank_hasGameEntry));
    }

   /**
   * Gets true if has a GameEntry
   * @param value org.semanticwb.tankwar.GameEntry to verify
   * @return true if the org.semanticwb.tankwar.GameEntry exists, false otherwise
   */
    public boolean hasGameEntry(org.semanticwb.tankwar.GameEntry value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(tank_hasGameEntry,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a GameEntry
   * @param value org.semanticwb.tankwar.GameEntry to add
   */

    public void addGameEntry(org.semanticwb.tankwar.GameEntry value)
    {
        getSemanticObject().addObjectProperty(tank_hasGameEntry, value.getSemanticObject());
    }
   /**
   * Removes all the GameEntry
   */

    public void removeAllGameEntry()
    {
        getSemanticObject().removeProperty(tank_hasGameEntry);
    }
   /**
   * Removes a GameEntry
   * @param value org.semanticwb.tankwar.GameEntry to remove
   */

    public void removeGameEntry(org.semanticwb.tankwar.GameEntry value)
    {
        getSemanticObject().removeObjectProperty(tank_hasGameEntry,value.getSemanticObject());
    }

   /**
   * Gets the GameEntry
   * @return a org.semanticwb.tankwar.GameEntry
   */
    public org.semanticwb.tankwar.GameEntry getGameEntry()
    {
         org.semanticwb.tankwar.GameEntry ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(tank_hasGameEntry);
         if(obj!=null)
         {
             ret=(org.semanticwb.tankwar.GameEntry)obj.createGenericInstance();
         }
         return ret;
    }
}
