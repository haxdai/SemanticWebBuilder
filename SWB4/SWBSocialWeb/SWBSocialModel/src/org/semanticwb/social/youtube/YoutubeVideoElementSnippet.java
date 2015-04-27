/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.youtube;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author oscar.paredes
 */
public class YoutubeVideoElementSnippet {
    
    JSONObject videoDetailSnippet;

    public YoutubeVideoElementSnippet(JSONObject videoDetailSnippet) {
        this.videoDetailSnippet = videoDetailSnippet;
    }
    
    
    
    public String getChannelId() {
        String channelId = null;
        try {
            if( videoDetailSnippet != null){
                if(videoDetailSnippet.has("channelId")){
                     channelId = videoDetailSnippet.getString("channelId");
                }
            }
        } catch (JSONException ex) {
            
        }
        return channelId;
    }
    
    public String getTitle() {
        String title = null;
        try {
            if( videoDetailSnippet != null){
                if(videoDetailSnippet.has("title")){
                     title = videoDetailSnippet.getString("title");
                }
            }
        } catch (JSONException ex) {
            
        }
        return title;
    }
    
    public String getPublishedDate() {
        String publishedDate = null;
        try {
            if( videoDetailSnippet != null){
                if(videoDetailSnippet.has("publishedAt")){
                     publishedDate = videoDetailSnippet.getString("publishedAt");
                }
            }
        } catch (JSONException ex) {
            
        }
        return publishedDate;
    }

    public String getDescription() {
        String description = null;
        try {
            if( videoDetailSnippet != null){
                if(videoDetailSnippet.has("description")){
                     description = videoDetailSnippet.getString("description");
                }
            }
        } catch (JSONException ex) {
            
        }
        return description;
    }
    

     public YoutubeVideoElementSnippetThumbnail getThumbnail(String size){
        YoutubeVideoElementSnippetThumbnail thumbnail = null;
        try {
            if( videoDetailSnippet != null){
                if(videoDetailSnippet.has("thumbnails")){
                    JSONObject thumbnails = null;
                    thumbnails = videoDetailSnippet.getJSONObject("thumbnails");
                    if(thumbnails.has(size)){
                        thumbnails = thumbnails.getJSONObject(size);
                        if(thumbnails.has("url")&&thumbnails.has("width")&&thumbnails.has("height")){
                            thumbnail = new YoutubeVideoElementSnippetThumbnail(
                                    thumbnails.getString("url"),
                                    thumbnails.getInt("width"),
                                    thumbnails.getInt("height"));
                        }
                    }
                }
            }
        } catch (JSONException ex) {

        }
        return thumbnail;
    }
     
       
}
