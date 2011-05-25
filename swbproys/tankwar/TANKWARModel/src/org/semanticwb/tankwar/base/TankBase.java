package org.semanticwb.tankwar.base;


   /**
   * Clase principal. Es la clase que representa a cada uno de los Tanques 
   */
public abstract class TankBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty tank_wonGames=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#wonGames");
   /**
   * Puntuación
   */
    public static final org.semanticwb.platform.SemanticProperty tank_score=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#score");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty tank_hasUserFavorite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#hasUserFavorite");
   /**
   * Cantidad de Juegos Empatados
   */
    public static final org.semanticwb.platform.SemanticProperty tank_tieGames=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#tieGames");
   /**
   * usuario al que pertenece el tanque
   */
    public static final org.semanticwb.platform.SemanticProperty tank_tankUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#tankUser");
    public static final org.semanticwb.platform.SemanticProperty tank_tankImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#tankImage");
   /**
   * Cantidad de Juegos Perdidos
   */
    public static final org.semanticwb.platform.SemanticProperty tank_lostGames=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#lostGames");
   /**
   * Comentarios de un Tanque
   */
    public static final org.semanticwb.platform.SemanticClass tank_TankComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#TankComment");
    public static final org.semanticwb.platform.SemanticProperty tank_hasCommTankInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#hasCommTankInv");
   /**
   * Tipo de Tanque
   */
    public static final org.semanticwb.platform.SemanticClass tank_TankType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#TankType");
   /**
   * Tipo de Tanque
   */
    public static final org.semanticwb.platform.SemanticProperty tank_tankType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#tankType");
   /**
   * Clase principal. Es la clase que representa a cada uno de los Tanques
   */
    public static final org.semanticwb.platform.SemanticClass tank_Tank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#Tank");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#Tank");

    public static class ClassMgr
    {
       /**
       * Returns a list of Tank for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTanks(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.tankwar.Tank for all models
       * @return Iterator of org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTanks()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank>(it, true);
        }
       /**
       * Gets a org.semanticwb.tankwar.Tank
       * @param id Identifier for org.semanticwb.tankwar.Tank
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return A org.semanticwb.tankwar.Tank
       */
        public static org.semanticwb.tankwar.Tank getTank(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.Tank)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.tankwar.Tank
       * @param id Identifier for org.semanticwb.tankwar.Tank
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return A org.semanticwb.tankwar.Tank
       */
        public static org.semanticwb.tankwar.Tank createTank(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.Tank)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.tankwar.Tank
       * @param id Identifier for org.semanticwb.tankwar.Tank
       * @param model Model of the org.semanticwb.tankwar.Tank
       */
        public static void removeTank(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.tankwar.Tank
       * @param id Identifier for org.semanticwb.tankwar.Tank
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return true if the org.semanticwb.tankwar.Tank exists, false otherwise
       */

        public static boolean hasTank(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTank(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined UserFavorite
       * @param value UserFavorite of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByUserFavorite(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(tank_hasUserFavorite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined UserFavorite
       * @param value UserFavorite of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByUserFavorite(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(tank_hasUserFavorite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined TankUser
       * @param value TankUser of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByTankUser(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(tank_tankUser, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined TankUser
       * @param value TankUser of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByTankUser(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(tank_tankUser,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined CommTankInv
       * @param value CommTankInv of the type org.semanticwb.tankwar.TankComment
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByCommTankInv(org.semanticwb.tankwar.TankComment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(tank_hasCommTankInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined CommTankInv
       * @param value CommTankInv of the type org.semanticwb.tankwar.TankComment
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByCommTankInv(org.semanticwb.tankwar.TankComment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(tank_hasCommTankInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined TankType
       * @param value TankType of the type org.semanticwb.tankwar.TankType
       * @param model Model of the org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByTankType(org.semanticwb.tankwar.TankType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(tank_tankType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.Tank with a determined TankType
       * @param value TankType of the type org.semanticwb.tankwar.TankType
       * @return Iterator with all the org.semanticwb.tankwar.Tank
       */

        public static java.util.Iterator<org.semanticwb.tankwar.Tank> listTankByTankType(org.semanticwb.tankwar.TankType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(tank_tankType,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TankBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Tank
   */
    public TankBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the WonGames property
* @return int with the WonGames
*/
    public int getWonGames()
    {
        return getSemanticObject().getIntProperty(tank_wonGames);
    }

/**
* Sets the WonGames property
* @param value long with the WonGames
*/
    public void setWonGames(int value)
    {
        getSemanticObject().setIntProperty(tank_wonGames, value);
    }

/**
* Gets the Score property
* @return int with the Score
*/
    public int getScore()
    {
        return getSemanticObject().getIntProperty(tank_score);
    }

/**
* Sets the Score property
* @param value long with the Score
*/
    public void setScore(int value)
    {
        getSemanticObject().setIntProperty(tank_score, value);
    }

/**
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }
   /**
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listUserFavorites()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(tank_hasUserFavorite));
    }

   /**
   * Gets true if has a UserFavorite
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasUserFavorite(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(tank_hasUserFavorite,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a UserFavorite
   * @param value org.semanticwb.model.User to add
   */

    public void addUserFavorite(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(tank_hasUserFavorite, value.getSemanticObject());
    }
   /**
   * Removes all the UserFavorite
   */

    public void removeAllUserFavorite()
    {
        getSemanticObject().removeProperty(tank_hasUserFavorite);
    }
   /**
   * Removes a UserFavorite
   * @param value org.semanticwb.model.User to remove
   */

    public void removeUserFavorite(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(tank_hasUserFavorite,value.getSemanticObject());
    }

   /**
   * Gets the UserFavorite
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUserFavorite()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(tank_hasUserFavorite);
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
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the TieGames property
* @return int with the TieGames
*/
    public int getTieGames()
    {
        return getSemanticObject().getIntProperty(tank_tieGames);
    }

/**
* Sets the TieGames property
* @param value long with the TieGames
*/
    public void setTieGames(int value)
    {
        getSemanticObject().setIntProperty(tank_tieGames, value);
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
   * Sets the value for the property TankUser
   * @param value TankUser to set
   */

    public void setTankUser(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(tank_tankUser, value.getSemanticObject());
        }else
        {
            removeTankUser();
        }
    }
   /**
   * Remove the value for TankUser property
   */

    public void removeTankUser()
    {
        getSemanticObject().removeProperty(tank_tankUser);
    }

   /**
   * Gets the TankUser
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getTankUser()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(tank_tankUser);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the TankImage property
* @return String with the TankImage
*/
    public String getTankImage()
    {
        return getSemanticObject().getProperty(tank_tankImage);
    }

/**
* Sets the TankImage property
* @param value long with the TankImage
*/
    public void setTankImage(String value)
    {
        getSemanticObject().setProperty(tank_tankImage, value);
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
* Gets the LostGames property
* @return int with the LostGames
*/
    public int getLostGames()
    {
        return getSemanticObject().getIntProperty(tank_lostGames);
    }

/**
* Sets the LostGames property
* @param value long with the LostGames
*/
    public void setLostGames(int value)
    {
        getSemanticObject().setIntProperty(tank_lostGames, value);
    }
   /**
   * Gets all the org.semanticwb.tankwar.TankComment
   * @return A GenericIterator with all the org.semanticwb.tankwar.TankComment
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankComment> listCommTankInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankComment>(getSemanticObject().listObjectProperties(tank_hasCommTankInv));
    }

   /**
   * Gets true if has a CommTankInv
   * @param value org.semanticwb.tankwar.TankComment to verify
   * @return true if the org.semanticwb.tankwar.TankComment exists, false otherwise
   */
    public boolean hasCommTankInv(org.semanticwb.tankwar.TankComment value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(tank_hasCommTankInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the CommTankInv
   * @return a org.semanticwb.tankwar.TankComment
   */
    public org.semanticwb.tankwar.TankComment getCommTankInv()
    {
         org.semanticwb.tankwar.TankComment ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(tank_hasCommTankInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.tankwar.TankComment)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }
   /**
   * Sets the value for the property TankType
   * @param value TankType to set
   */

    public void setTankType(org.semanticwb.tankwar.TankType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(tank_tankType, value.getSemanticObject());
        }else
        {
            removeTankType();
        }
    }
   /**
   * Remove the value for TankType property
   */

    public void removeTankType()
    {
        getSemanticObject().removeProperty(tank_tankType);
    }

   /**
   * Gets the TankType
   * @return a org.semanticwb.tankwar.TankType
   */
    public org.semanticwb.tankwar.TankType getTankType()
    {
         org.semanticwb.tankwar.TankType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(tank_tankType);
         if(obj!=null)
         {
             ret=(org.semanticwb.tankwar.TankType)obj.createGenericInstance();
         }
         return ret;
    }
}
