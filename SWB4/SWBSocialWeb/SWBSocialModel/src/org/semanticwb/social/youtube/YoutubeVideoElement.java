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
public class YoutubeVideoElement{
        JSONObject videoDetail;

        public YoutubeVideoElement(JSONObject videoDetail) {
            this.videoDetail = videoDetail;
        }
        
        public String getId(){
            String id = null;
            try {
                if( videoDetail != null){
                    if(videoDetail.has("id")){
                        id = videoDetail.getString("id");
                    }
                }
            } catch (JSONException ex) {

            }
            return id;
        }
        
        public YoutubeVideoElementSnippet getSnippet(){
            YoutubeVideoElementSnippet snippet = null;
            try {
                if( videoDetail != null){
                    if(videoDetail.has("snippet")){
                        snippet  = new YoutubeVideoElementSnippet( videoDetail.getJSONObject("snippet"));
                    }
                }
            } catch (JSONException ex) {

            }
            return snippet;
        }
      
        public YoutubeVideoElementStatistics getStatistics(){
            YoutubeVideoElementStatistics statistics = null;
            try {
                if( videoDetail != null){
                    if(videoDetail.has("statistics")){
                        statistics  = new YoutubeVideoElementStatistics( videoDetail.getJSONObject("snippet"));
                    }
                }
            } catch (JSONException ex) {

            }
            return statistics;
        }
        
        public YoutubeVideoElementStatus getStatus(){
            YoutubeVideoElementStatus status = null;
            try {
                if( videoDetail != null){
                    if(videoDetail.has("status")){
                        status  = new YoutubeVideoElementStatus( videoDetail.getJSONObject("status"));
                    }
                }
            } catch (JSONException ex) {

            }
            return status;
        }
    }