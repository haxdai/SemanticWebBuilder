/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.indexer.parser;

import com.infotec.conorg.Topic;
import com.infotec.conorg.WorkSpace;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Searchable;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author juan.fernandez
 */
public class WorkSpaceParser extends GenericParser {

    private static Logger log = SWBUtils.getLogger(WorkSpaceParser.class);

    @Override
    public boolean canIndex(Searchable gen) {
        return true;
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((WorkSpace) gen).getDescription();
    }

    @Override
    public String getIndexTitle(Searchable gen) {
        String ret = ((WorkSpace) gen).getTitle();
        //Indexar el nombre del autor
        if (((WorkSpace) gen).getCreator() != null) {
            ret += "\n" + ((WorkSpace) gen).getCreator().getFullName();
        }
        //Indexar el nombre de las líneas temáticas
        Iterator<Topic> refs = ((WorkSpace) gen).listTopics();
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
        return ((WorkSpace) gen).getDescription();
    }

    @Override
    public String getUrl(Searchable gen) {
        return ((WorkSpace) gen).getUrl() + "?wsid=" + ((WorkSpace) gen).getId();
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        ret = ((WorkSpace) gen).getPath(arg);
        return ret;
    }

    @Override
    public String getType(Searchable gen) {
        return "workspace";
    }

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Espacio de trabajo";
    }

    @Override
    public String getIndexCategory(Searchable gen) {
        String ret = "";
        ret = super.getIndexCategory((WorkSpace) gen);
        return ret;
    }
}
