package com.infotec.conorg.base;


public abstract class MosaicBase extends com.infotec.conorg.Tile implements com.infotec.conorg.Topicable,com.infotec.conorg.Tileable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.Calendarable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Mosaic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Mosaic");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Mosaic");

    public static class ClassMgr
    {
       /**
       * Returns a list of Mosaic for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaics(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Mosaic for all models
       * @return Iterator of com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaics()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic>(it, true);
        }

        public static com.infotec.conorg.Mosaic createMosaic(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Mosaic.ClassMgr.createMosaic(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Mosaic
       * @param id Identifier for com.infotec.conorg.Mosaic
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return A com.infotec.conorg.Mosaic
       */
        public static com.infotec.conorg.Mosaic getMosaic(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Mosaic)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Mosaic
       * @param id Identifier for com.infotec.conorg.Mosaic
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return A com.infotec.conorg.Mosaic
       */
        public static com.infotec.conorg.Mosaic createMosaic(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Mosaic)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Mosaic
       * @param id Identifier for com.infotec.conorg.Mosaic
       * @param model Model of the com.infotec.conorg.Mosaic
       */
        public static void removeMosaic(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Mosaic
       * @param id Identifier for com.infotec.conorg.Mosaic
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return true if the com.infotec.conorg.Mosaic exists, false otherwise
       */

        public static boolean hasMosaic(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMosaic(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_resource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_resource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.Mosaic
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByTile(com.infotec.conorg.Tile value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Mosaic with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.Mosaic
       */

        public static java.util.Iterator<com.infotec.conorg.Mosaic> listMosaicByTile(com.infotec.conorg.Tile value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Mosaic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static MosaicBase.ClassMgr getMosaicClassMgr()
    {
        return new MosaicBase.ClassMgr();
    }

   /**
   * Constructs a MosaicBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Mosaic
   */
    public MosaicBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
