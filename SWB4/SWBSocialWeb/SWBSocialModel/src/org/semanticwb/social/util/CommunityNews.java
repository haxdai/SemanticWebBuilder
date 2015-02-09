/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.util;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author jorge.jimenez
 */
public class CommunityNews {
    
    String title;
    String description;
    String link;
    String guid;
    String pubDate;
    String mediaContent;

    public CommunityNews(){
        title=null;
        description=null;
        link=null;
        guid=null;
        pubDate=null;
        mediaContent=null;
    }

    public void setNode(Node itemNode){
        NodeList nChilds=itemNode.getChildNodes();
        for(int i=0;i<=nChilds.getLength();i++){
            if(nChilds.item(i)!=null)
            {
                if(nChilds.item(i).getNodeName().equalsIgnoreCase("title")){
                    setTitle(nChilds.item(i).getFirstChild().getNodeValue());
                }else if(nChilds.item(i).getNodeName().equalsIgnoreCase("description")){
                    setDescription(nChilds.item(i).getFirstChild().getNodeValue());
                }else if(nChilds.item(i).getNodeName().equalsIgnoreCase("link")){
                    setLink(nChilds.item(i).getFirstChild().getNodeValue());
                }/*else if(nChilds.item(i).getNodeName().equalsIgnoreCase("guid")){
                    setGuid(nChilds.item(i).getFirstChild().getNodeValue());
                }*/else if(nChilds.item(i).getNodeName().equalsIgnoreCase("pubDate")){
                    setPubDate(nChilds.item(i).getFirstChild().getNodeValue());
                }else if(nChilds.item(i).getNodeName().equalsIgnoreCase("media:content")){
                    NamedNodeMap attributes=nChilds.item(i).getAttributes();
                    Node urlNode=attributes.getNamedItem("url");
                    setMediaContent(urlNode.getNodeValue());
                } 
            }
        }
    }

    public void setTitle(String title){
        this.title=title;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setLink(String link){
        this.link=link;
    }/*
    public void setGuid(String guid){
        this.guid=guid;
    }*/
    public void setPubDate(String pubDate){
        this.pubDate=pubDate;
    }
    
    public void setMediaContent(String mediaContent){
        this.mediaContent=mediaContent;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getLink(){
        return link;
    }/*
    public String getGuid(){
        return guid;
    }*/
    public String getPubDate(){
        return pubDate;
    }
    
    public String getMediaContent(){
        return mediaContent;
    }
   
}
