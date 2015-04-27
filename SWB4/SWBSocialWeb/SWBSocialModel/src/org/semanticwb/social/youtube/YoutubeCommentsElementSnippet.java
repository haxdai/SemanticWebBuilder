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
public class YoutubeCommentsElementSnippet {
    JSONObject commentDetailSnippet; 

    public YoutubeCommentsElementSnippet(JSONObject commentDetailSnippet) {
        this.commentDetailSnippet = commentDetailSnippet;
    }
    
     public String getChannelId(){
        String channelId = null;
        try {
            if( commentDetailSnippet != null){
                if(commentDetailSnippet.has("channelId")){
                    channelId = commentDetailSnippet.getString("channelId");
                }
            }
        } catch (JSONException ex) {

        }
        return channelId;
    }
     
    public String getVideoId(){
        String videoId = null;
        try {
            if( commentDetailSnippet != null){
                if(commentDetailSnippet.has("videoId")){
                    videoId = commentDetailSnippet.getString("videoId");
                }
            }
        } catch (JSONException ex) {

        }
        return videoId;
    }
    
    public String getText(){
        String text = null;
        try {
            if( commentDetailSnippet != null){
                if(commentDetailSnippet.has("textDisplay")){
                    text = commentDetailSnippet.getString("textDisplay");
                }
            }
        } catch (JSONException ex) {

        }
        return text;
    }
    
     public String getAuthorName(){
        String name = null;
        try {
            if( commentDetailSnippet != null){
                if(commentDetailSnippet.has("authorDisplayName")){
                    name = commentDetailSnippet.getString("authorDisplayName");
                }
            }
        } catch (JSONException ex) {

        }
        return name;
    }

    public String getauthorImageUrl(){
        String imageUrl = null;
        try {
            if( commentDetailSnippet != null){
                if(commentDetailSnippet.has("authorProfileImageUrl")){
                    imageUrl = commentDetailSnippet.getString("authorProfileImageUrl");
                }
            }
        } catch (JSONException ex) {

        }
        return imageUrl;
    }
    
    public String getauthorChannelId(){
        String authorChannelId = null;
        try {
            if( commentDetailSnippet != null){
                if(commentDetailSnippet.has("authorChannelId")){
                    JSONObject authorChannel = commentDetailSnippet.getJSONObject("authorChannelId");
                    if( authorChannel != null){
                        if(authorChannel.has("value")){
                            authorChannelId = commentDetailSnippet.getString("value");

                        }
                    }
                }
            }
        } catch (JSONException ex) {

        }
        return authorChannelId;
    }

     public String getpublishedDate(){
        String publishedDate = null;
        try {
            if( commentDetailSnippet != null){
                if(commentDetailSnippet.has("publishedAt")){
                    publishedDate = commentDetailSnippet.getString("publishedAt");
                }
            }
        } catch (JSONException ex) {

        }
        return publishedDate;
    }
    
}
