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
public class YoutubeChannelElement {

    JSONObject channelDetail;

    public YoutubeChannelElement(JSONObject videoDetail) {
        this.channelDetail = videoDetail;
    }

    public String getId() {
        String id = null;
        try {
            if (channelDetail != null) {
                if (channelDetail.has("id")) {
                    id = channelDetail.getString("id");
                }
            }
        } catch (JSONException ex) {

        }
        return id;
    }

    public YoutubeChannelElementSnippet getSnippet() {
        YoutubeChannelElementSnippet snippet = null;
        try {
            if (channelDetail != null) {
                if (channelDetail.has("snippet")) {
                    snippet = new YoutubeChannelElementSnippet(channelDetail.getJSONObject("snippet"));
                }
            }
        } catch (JSONException ex) {

        }
        return snippet;
    }
}
