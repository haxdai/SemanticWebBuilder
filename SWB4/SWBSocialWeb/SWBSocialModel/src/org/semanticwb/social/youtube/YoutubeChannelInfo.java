/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.youtube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class YoutubeChannelInfo {
      JSONObject info;

    public YoutubeChannelInfo(JSONObject info) {
        this.info = info;
    }
      
     public YoutubeChannelElement  getChannel(){
        YoutubeChannelElement infoItem = null;
        try {
            if( info != null){
                if(info.has("items")){
                    JSONArray channelInfoList = info.getJSONArray("items");
                    if(channelInfoList.length()>0){
                        infoItem = new YoutubeChannelElement (channelInfoList.getJSONObject(0));
                    }
                }
            }
        } catch (JSONException ex) {

        }
        return infoItem;
    }
      
      
}
