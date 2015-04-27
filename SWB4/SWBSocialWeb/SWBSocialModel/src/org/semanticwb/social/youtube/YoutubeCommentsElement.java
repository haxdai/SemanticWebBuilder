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
public class YoutubeCommentsElement {
    JSONObject commentsDetail;

    public YoutubeCommentsElement(JSONObject commentsDetail) {
        this.commentsDetail = commentsDetail;
    }
    
     public String getId() {
       String id = null;
        try {
            if (commentsDetail != null) {
                if (commentsDetail.has("id")) {
                    id = commentsDetail.getString("id");
                }
            }
        } catch (JSONException ex) {

        }
        return id;
    }
    
     public YoutubeCommentsElementSnippet getSnippet() {
        YoutubeCommentsElementSnippet snippet = null;
        try {
            if (commentsDetail != null) {
                if (commentsDetail.has("snippet")) {
                    snippet = new YoutubeCommentsElementSnippet(commentsDetail.getJSONObject("snippet"));
                }
            }
        } catch (JSONException ex) {

        }
        return snippet;
    }

   
    
}
