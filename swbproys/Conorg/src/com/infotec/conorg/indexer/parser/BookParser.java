/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.indexer.parser;

import com.infotec.conorg.Book;
import com.infotec.conorg.Document;
import com.infotec.conorg.Topic;
import com.infotec.conorg.WorkSpace;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author juan.fernandez
 */
public class BookParser  extends GenericParser {

    private static Logger log = SWBUtils.getLogger(BookParser.class);
    public static String CONFIG_IDSHELF = "wpshelf";
    public static String CONFIG_IDWORKSPACE = "wpworkspace";
    public static String CONFIG_SHELF = "http://www.infotec.com/conorg.owl#Shelf";
    public static String CONFIG_WORKSPACE = "http://www.infotec.com/conorg.owl#WorkSpace";
    public static String CONFIG_AS = "resconf";

    @Override
    public boolean canIndex(Searchable gen) {
        return true;
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Book) gen).getDescription();
    }

    @Override
    public String getIndexTitle(Searchable gen) {
        String ret = ((Book) gen).getTitle();
        //Indexar el nombre del autor
        //System.out.println("BOOK: index title");
        if (((Book) gen).getCreator() != null) {
            ret += "\n" + ((Book) gen).getCreator().getFullName();
        }
        //Indexar el nombre de las líneas temáticas
        Iterator<Topic> refs = ((Book) gen).listTopics();
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
        return ((Book) gen).getDescription();
    }

    @Override
    public String getUrl(Searchable gen) {
        
        Book doc = (Book)gen;
        Resource res = doc.getResource();
        WebSite wsite = res.getWebSite();
        Resourceable resable =((WebPage)res.getResourceable());
        String urlDoc = ((WebPage)res.getResourceable()).getUrl();
        
        String strConfig = res.getAttribute(CONFIG_AS,CONFIG_SHELF);
        String strIDShelf = res.getAttribute(CONFIG_IDSHELF);
        String strIDWorkSpace = res.getAttribute(CONFIG_IDWORKSPACE);
        if(CONFIG_WORKSPACE.equals(strConfig)&&null!=strIDWorkSpace){
             urlDoc = wsite.getWebPage(strIDWorkSpace).getUrl();
        } else  if(CONFIG_SHELF.equals(strConfig)&&null!=strIDShelf){
             urlDoc = wsite.getWebPage(strIDShelf).getUrl();
        }
        urlDoc +="/_rid/"+res.getId()+"?id="+doc.getId()+"&suri="+doc.getEncodedURI();
        if(CONFIG_WORKSPACE.equals(strConfig)){
            Iterator<WorkSpace> itws = WorkSpace.ClassMgr.listWorkSpaceByTile(doc);
            while (itws.hasNext()) {
                WorkSpace workSpace = itws.next();
                 urlDoc += "&wsid=" + workSpace.getId();
                 break;
            }
           
        }
        return urlDoc;
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        Document doc = (Document)gen;
        Resource res = doc.getResource();
        if(res!=null) ret = ((WebPage)res.getResourceable()).getPath(arg);
        return ret;
    }

    @Override
    public String getType(Searchable gen) {
        return "book";
    }

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Libro";
    }

        @Override
    public String getIndexCategory(Searchable gen) {
        String ret = "";
        WebPage page = getWebPage((Book)gen);
        if(page!=null) {
            ret = super.getIndexCategory(page);
        }
        return ret;
    }
    
        private WebPage getWebPage(Book repFile) {
        WebPage ret = null;
        Resource res = repFile.getResource();
        if(res!=null)
            ret =((WebPage)res.getResourceable());
        return ret;
    }
}