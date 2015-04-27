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
public class YoutubeCommentThreadsElementSnippet {
    JSONObject commentThreadsDetailSnippet;

    public YoutubeCommentThreadsElementSnippet(JSONObject commentThreadsDetailSnippet) {
        this.commentThreadsDetailSnippet = commentThreadsDetailSnippet;
    }
    
    public YoutubeCommentsElement getTopComment(){
        YoutubeCommentsElement commentsElement = null;
        try {
            if( commentThreadsDetailSnippet != null){
                if(commentThreadsDetailSnippet.has("topLevelComment")){
                    commentsElement = new YoutubeCommentsElement( commentThreadsDetailSnippet.getJSONObject("topLevelComment"));
                }
            }
        } catch (JSONException ex) {

        }
        return commentsElement;
    }
}
