package com.infotec.conorg.indexer.parser;

import com.infotec.conorg.Article;
import com.infotec.conorg.Audio;
import com.infotec.conorg.Book;
import com.infotec.conorg.ChapterBook;
import com.infotec.conorg.Contact;
import com.infotec.conorg.Document;
import com.infotec.conorg.Image;
import com.infotec.conorg.Manual;
import com.infotec.conorg.Member;
import com.infotec.conorg.Mosaic;
import com.infotec.conorg.Presentation;
import com.infotec.conorg.Report;
import com.infotec.conorg.Shelf;
import com.infotec.conorg.Tile;
import com.infotec.conorg.Topic;
import com.infotec.conorg.URL;
import com.infotec.conorg.Video;
import com.infotec.conorg.WorkSpace;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author juan.fernandez
 */
public class TileParser extends GenericParser {
    private static Logger log = SWBUtils.getLogger(TileParser.class);
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
        return ((Tile)gen).getDescription();
    }
    
    @Override
    public String getIndexTitle(Searchable gen) {
        String ret = ((Tile)gen).getTitle();
        //Indexar el nombre del autor
       // System.out.println("TILE: Indexando Titulo");
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

    @Override
    public boolean canUserView(Searchable gen, User user) {
       Tile doc = (Tile)gen;
        Resource res = doc.getResource();
        WebSite wsite = res.getWebSite();
        Resourceable resable =((WebPage)res.getResourceable());
        String urlDoc = ((WebPage)res.getResourceable()).getUrl();
        
        String strConfig = res.getAttribute(CONFIG_AS,CONFIG_SHELF);
        String strIDShelf = res.getAttribute(CONFIG_IDSHELF);
        String strIDWorkSpace = res.getAttribute(CONFIG_IDWORKSPACE);
        
         Shelf shelf = Shelf.ClassMgr.getShelf(user.getId(), wsite);
         
         shelf.hasTile(doc);
        
        boolean haveAccess = Boolean.FALSE;
        if(CONFIG_SHELF.equals(strConfig)&&null!=strIDShelf){
             urlDoc = wsite.getWebPage(strIDShelf).getUrl();
             haveAccess = Boolean.TRUE;
        }
         if(CONFIG_WORKSPACE.equals(strConfig)){
            Iterator<WorkSpace> itws = WorkSpace.ClassMgr.listWorkSpaceByTile(doc);
            while (itws.hasNext()) {
                WorkSpace workSpace = itws.next();
                Iterator<Member> itmem = workSpace.listMembers();
                while (itmem.hasNext()) {
                    Member member = itmem.next();
                    if(member.getUser().equals(user)){
                        haveAccess = Boolean.TRUE;
                        break;
                    }
                }
                 urlDoc += "&wsid=" + workSpace.getId();
                 if(haveAccess) break;
            }
           
        }

        return haveAccess;
    }

    
    
    @Override
    public String getUrl(Searchable gen) {
       Tile doc = (Tile)gen;
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
        Tile doc = (Tile)gen;
        Resource res = doc.getResource();
        if(res!=null) ret = ((WebPage)res.getResourceable()).getPath(arg);
        return ret;
    }
    
    @Override
    public String getType(Searchable gen) {
        Tile tile = (Tile)gen;
        return getTileTypeName(tile);
    }
    
    @Override
    public String getTypeDisplayLabel(Searchable gen) {
       Tile tile = (Tile)gen;
        return getTileTypeName(tile);
    }
    
    private WebPage getWebPage(Tile repFile) {
        WebPage ret = null;
        Resource res = repFile.getResource();
        //System.out.println("Encontrando WebPage - Tile: "+res==null?"null":res.getId());
        if(res!=null)  ret =((WebPage)res.getResourceable());
        return ret;
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
         
         public String getTileTypeName(Tile tile) {

        String ret = "Azulejo";
        if (tile instanceof Contact) {
            ret = "Contacto";
        } else if (tile instanceof Mosaic) {
            ret = "Mosaico";
        } else if (tile instanceof com.infotec.conorg.Resource) {
            ret = "Recurso";
        } else if (tile instanceof URL) {
            ret = "URL";
        } else if (tile instanceof Article) {
            ret = "Articulo";
        } else if (tile instanceof Audio) {
            ret = "Audio";
        } else if (tile instanceof Book) {
            ret = "Libro";
        } else if (tile instanceof ChapterBook) {
            ret = "Capitulo";
        } else if (tile instanceof Image) {
            ret = "Imagen";
        } else if (tile instanceof Manual) {
            ret = "Manual";
        } else if (tile instanceof Presentation) {
            ret = "Presentación";
        } else if (tile instanceof com.infotec.conorg.Reference) {
            ret = "Referencia";
        } else if (tile instanceof Report) {
            ret = "Reporte";
        } else if (tile instanceof Video) {
            ret = "Video";
        } else if (tile instanceof com.infotec.conorg.File) {
            ret = "Archivo";
        } else if (tile instanceof Document) {
            ret = "Documento";
        }
        return ret;
    }
         
}
