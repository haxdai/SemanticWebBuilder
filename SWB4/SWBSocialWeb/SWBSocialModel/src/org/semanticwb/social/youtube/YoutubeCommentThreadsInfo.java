/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.youtube;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author oscar.paredes
 */
public class YoutubeCommentThreadsInfo {
    JSONObject info ;

    public YoutubeCommentThreadsInfo(JSONObject info) {
        this.info = info;
    }
    
    public List<YoutubeCommentThreadsElement> getListCommentThreads(){
        List<YoutubeCommentThreadsElement> infoListItem = null;
        try {
            if( info != null){
                if(info.has("items")){
                    JSONArray channelInfoList = info.getJSONArray("items");
                    if(channelInfoList.length()>0){
                        infoListItem = new ArrayList<YoutubeCommentThreadsElement>();
                        for(int i = 0; i<channelInfoList.length();i++){
                            infoListItem.add(new YoutubeCommentThreadsElement (channelInfoList.getJSONObject(i)));
                        }
                    }
                }
            }
        } catch (JSONException ex) {

        }
        return infoListItem;
    }
    
    
}
