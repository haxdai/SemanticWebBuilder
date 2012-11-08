package com.infotec.conorg.base;


public abstract class ShelfBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,com.infotec.conorg.Tileable,org.semanticwb.model.Traceable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty conorg_owner=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#owner");
    public static final org.semanticwb.platform.SemanticClass conorg_Shelf=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Shelf");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Shelf");

    public static class ClassMgr
    {
       /**
       * Returns a list of Shelf for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Shelf for all models
       * @return Iterator of com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf>(it, true);
        }

        public static com.infotec.conorg.Shelf createShelf(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Shelf.ClassMgr.createShelf(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Shelf
       * @param id Identifier for com.infotec.conorg.Shelf
       * @param model Model of the com.infotec.conorg.Shelf
       * @return A com.infotec.conorg.Shelf
       */
        public static com.infotec.conorg.Shelf getShelf(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Shelf)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Shelf
       * @param id Identifier for com.infotec.conorg.Shelf
       * @param model Model of the com.infotec.conorg.Shelf
       * @return A com.infotec.conorg.Shelf
       */
        public static com.infotec.conorg.Shelf createShelf(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Shelf)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Shelf
       * @param id Identifier for com.infotec.conorg.Shelf
       * @param model Model of the com.infotec.conorg.Shelf
       */
        public static void removeShelf(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Shelf
       * @param id Identifier for com.infotec.conorg.Shelf
       * @param model Model of the com.infotec.conorg.Shelf
       * @return true if the com.infotec.conorg.Shelf exists, false otherwise
       */

        public static boolean hasShelf(String id, org.semanticwb.model.SWBModel model)
        {
            return (getShelf(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Shelf
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined Owner
       * @param value Owner of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Shelf
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByOwner(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_owner, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined Owner
       * @param value Owner of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByOwner(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_owner,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Shelf
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.Shelf
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByTile(com.infotec.conorg.Tile value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Shelf with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.Shelf
       */

        public static java.util.Iterator<com.infotec.conorg.Shelf> listShelfByTile(com.infotec.conorg.Tile value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Shelf> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ShelfBase.ClassMgr getShelfClassMgr()
    {
        return new ShelfBase.ClassMgr();
    }

   /**
   * Constructs a ShelfBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Shelf
   */
    public ShelfBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Sets the value for the property Owner
   * @param value Owner to set
   */

    public void setOwner(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_owner, value.getSemanticObject());
        }else
        {
            removeOwner();
        }
    }
   /**
   * Remove the value for Owner property
   */

    public void removeOwner()
    {
        getSemanticObject().removeProperty(conorg_owner);
    }

   /**
   * Gets the Owner
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getOwner()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_owner);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
   * Gets all the com.infotec.conorg.Tile
   * @return A GenericIterator with all the com.infotec.conorg.Tile
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> listTiles()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile>(getSemanticObject().listObjectProperties(conorg_hasTile));
    }

   /**
   * Gets true if has a Tile
   * @param value com.infotec.conorg.Tile to verify
   * @return true if the com.infotec.conorg.Tile exists, false otherwise
   */
    public boolean hasTile(com.infotec.conorg.Tile value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasTile,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Tile
   * @param value com.infotec.conorg.Tile to add
   */

    public void addTile(com.infotec.conorg.Tile value)
    {
        getSemanticObject().addObjectProperty(conorg_hasTile, value.getSemanticObject());
    }
   /**
   * Removes all the Tile
   */

    public void removeAllTile()
    {
        getSemanticObject().removeProperty(conorg_hasTile);
    }
   /**
   * Removes a Tile
   * @param value com.infotec.conorg.Tile to remove
   */

    public void removeTile(com.infotec.conorg.Tile value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasTile,value.getSemanticObject());
    }

   /**
   * Gets the Tile
   * @return a com.infotec.conorg.Tile
   */
    public com.infotec.conorg.Tile getTile()
    {
         com.infotec.conorg.Tile ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasTile);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Tile)obj.createGenericInstance();
         }
         return ret;
    }
}
