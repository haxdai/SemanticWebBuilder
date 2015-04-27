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
public class YoutubeVideoElementStatistics {
     JSONObject videoDetailStatistics;

    public YoutubeVideoElementStatistics(JSONObject videoDetailStatistics) {
        this.videoDetailStatistics = videoDetailStatistics;
    }
    
    public int getViewCount() {
        int viewCount = 0;
        try {
            if( videoDetailStatistics != null){
                if(videoDetailStatistics.has("viewCount")){
                     viewCount = videoDetailStatistics.getInt("viewCount");
                }
            }
        } catch (JSONException ex) {
            
        }
        return viewCount;
    }
    
    public int getLikeCount() {
        int likeCount = 0;
        try {
            if( videoDetailStatistics != null){
                if(videoDetailStatistics.has("likeCount")){
                     likeCount = videoDetailStatistics.getInt("likeCount");
                }
            }
        } catch (JSONException ex) {
            
        }
        return likeCount;
    }
        
    public int getDislikeCount() {
        int dislikeCount = 0;
        try {
            if( videoDetailStatistics != null){
                if(videoDetailStatistics.has("dislikeCount")){
                     dislikeCount = videoDetailStatistics.getInt("dislikeCount");
                }
            }
        } catch (JSONException ex) {
            
        }
        return dislikeCount;
    }
            
    public int getFavoriteCount() {
        int favoriteCount = 0;
        try {
            if( videoDetailStatistics != null){
                if(videoDetailStatistics.has("favoriteCount")){
                     favoriteCount = videoDetailStatistics.getInt("favoriteCount");
                }
            }
        } catch (JSONException ex) {
            
        }
        return favoriteCount;
    }
                
    public int getCommentCount() {
        int commentCount = 0;
        try {
            if( videoDetailStatistics != null){
                if(videoDetailStatistics.has("commentCount")){
                     commentCount = videoDetailStatistics.getInt("commentCount");
                }
            }
        } catch (JSONException ex) {
            
        }
        return commentCount;
    }
    
}
