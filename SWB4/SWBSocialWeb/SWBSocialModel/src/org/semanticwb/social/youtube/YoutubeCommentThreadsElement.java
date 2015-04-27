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
public class YoutubeCommentThreadsElement {
     JSONObject commentThreadsDetail;

    public YoutubeCommentThreadsElement(JSONObject commentThreadsDetail) {
        this.commentThreadsDetail = commentThreadsDetail;
    }
    
    public String getId(){
        String id = null;
        try {
            if( commentThreadsDetail != null){
                if(commentThreadsDetail.has("id")){
                    id = commentThreadsDetail.getString("id");
                }
            }
        } catch (JSONException ex) {

        }
        return id;
    }
    
    public YoutubeCommentThreadsElementSnippet getSnippet(){
         YoutubeCommentThreadsElementSnippet snippet = null;
            try {
                if( commentThreadsDetail != null){
                    if(commentThreadsDetail.has("snippet")){
                        snippet  = new YoutubeCommentThreadsElementSnippet( commentThreadsDetail.getJSONObject("snippet"));
                    }
                }
            } catch (JSONException ex) {

            }
            return snippet;
    }
     
}
