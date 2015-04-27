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
public class YoutubeVideoElementStatus {
    JSONObject videoDetailStatus;   
    public static String PRIVACY_STATUS_PRIVATE = "PRIVACY_STATUS_PRIVATE";
    public static String PRIVACY_STATUS_PUBLIC = "PRIVACY_STATUS_PUBLIC";
    public static String PRIVACY_STATUS_UNLIST = "PRIVACY_STATUS_UNLIST";

    public YoutubeVideoElementStatus(JSONObject videoDetailStatus) {
        this.videoDetailStatus = videoDetailStatus;
    }
    
     public String getPrivacyStatus() {
        String privacyStatus = null;
        try {
            if( videoDetailStatus != null){
                if(videoDetailStatus.has("privacyStatus")){
                     privacyStatus = videoDetailStatus.getString("privacyStatus");
                }
            }
        } catch (JSONException ex) {
            
        }
        return privacyStatus;
    }
    
    
     
}
