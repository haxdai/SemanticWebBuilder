package com.infotec.conorg.base;

public interface TileableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass conorg_Tile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Tile");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasTile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasTile");
    public static final org.semanticwb.platform.SemanticClass conorg_Tileable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Tileable");

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> listTiles();
    public boolean hasTile(com.infotec.conorg.Tile value);

   /**
   * Adds the Tile
   * @param value An instance of com.infotec.conorg.Tile
   */
    public void addTile(com.infotec.conorg.Tile value);

   /**
   * Remove all the values for the property Tile
   */
    public void removeAllTile();

   /**
   * Remove a value from the property Tile
   * @param value An instance of com.infotec.conorg.Tile
   */
    public void removeTile(com.infotec.conorg.Tile value);

/**
* Gets the Tile
* @return a instance of com.infotec.conorg.Tile
*/
    public com.infotec.conorg.Tile getTile();
}
