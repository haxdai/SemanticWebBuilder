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
public class YoutubeChannelElementSnippet {
     JSONObject channelDetailSnippet;

    public YoutubeChannelElementSnippet(JSONObject channelDetailSnippet) {
        this.channelDetailSnippet = channelDetailSnippet;
    }
    
    public String getTitle(){
        String title = null;
        try {
            if( channelDetailSnippet != null){
                if(channelDetailSnippet.has("title")){
                    title = channelDetailSnippet.getString("title");
                }
            }
        } catch (JSONException ex) {

        }
        return title;
    }
    public String getThumbnail(String size){
        String urlThumbnail = null;
        try {
            if( channelDetailSnippet != null){
                if(channelDetailSnippet.has("thumbnails")){
                    JSONObject thumbnails = null;
                    thumbnails = channelDetailSnippet.getJSONObject("thumbnails");
                    if(thumbnails.has(size)){
                        thumbnails = thumbnails.getJSONObject(size);
                        if(thumbnails.has("url")){
                            urlThumbnail =  thumbnails.getString("url");
                        }
                    }
                }
            }
        } catch (JSONException ex) {

        }
        return urlThumbnail;
    }
   
}
