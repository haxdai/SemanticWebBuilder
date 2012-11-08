package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.TileParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Tile extends com.infotec.conorg.base.TileBase 
{
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Tile.class, new TileParser());
        }
    }
    public Tile(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
