package com.infotec.conorg.indexer.parser;

import com.infotec.conorg.Tile;
import com.infotec.conorg.Topic;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author juan.fernandez
 */
public class TileParser extends GenericParser {
    private static Logger log = SWBUtils.getLogger(TileParser.class);

    @Override
    public boolean canIndex(Searchable gen) {
        return true;
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Tile)gen).getDescription();
    }
    
    @Override
    public String getIndexTitle(Searchable gen) {
        String ret = ((Tile)gen).getTitle();
        //Indexar el nombre del autor
        if (((Tile)gen).getCreator() != null) {
            ret += "\n" + ((Tile)gen).getCreator().getFullName();
        }
        //Indexar el nombre de las líneas temáticas
        Iterator<Topic> refs = ((Tile)gen).listTopics();
        while (refs.hasNext()) {
            Topic topic = refs.next();
            if (topic.getTitle() != null) {
                ret += "\n" + topic.getTitle();
            }
        }
        
        return ret;
    }
    
    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Tile)gen).getDescription();
    }
    
    private WebPage getWebPage(Tile repFile) {
        WebPage ret = null;
        Resource res = repFile.getRepositoryResource().getResource();
        if (res.getResourceType() != null && res.getResourceType().getResourceMode() == ResourceType.MODE_CONTENT) {
            Iterator<Resourceable> it = res.listResourceables();
            while (it.hasNext()) {
                Resourceable ob = it.next();
                if (ob instanceof WebPage) {
                    ret = (WebPage) ob;
                    break;
                }
            }
        }
        return ret;
    }
    
    @Override
    public String getUrl(Searchable gen) {
        return ((Tile)gen).getURL();
    }
    
    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        WebPage page = getWebPage((Tile) gen);
        if (page != null) {
            ret = page.getPath(arg);
        }
        return ret;
    }
    
    @Override
    public String getType(Searchable gen) {
        return "File";
    }
    
    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Archivo del repositorio";
    }
    
    @Override
    public String getIndexCategory(Searchable gen) {
        String ret = "";
        WebPage page = getWebPage((Tile)gen);
        if(page!=null) {
            ret = super.getIndexCategory(page);
        }
        return ret;
    }
}
