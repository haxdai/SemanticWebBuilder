/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.lib;

/**
 *
 * @author jorge.jimenez
 */


public abstract class SWBSocialNetWork implements SocialNetWorkInt{
 
    public String msg=null;
    String photo=null;
    String video=null;

    //Sets
    public void setMsg(String msg) {
        this.msg=msg;
    }

    public void setPhoto(String photo) {
        this.photo=photo;
    }

    public void setVideo(String video) {
        this.video=video;
    }

    //Gets

    public String getMsg() {
        return msg;
    }

    public String getPhoto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getVideo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
