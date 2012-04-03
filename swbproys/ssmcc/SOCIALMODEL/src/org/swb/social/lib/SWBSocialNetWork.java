/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.lib;

import org.semanticwb.model.SWBModel;
import org.swb.social.util.SWBSocialUtils;
import org.swb.social.util.SocialNetworkConectionData;

/**
 *
 * @author jorge.jimenez
 */


public abstract class SWBSocialNetWork implements SocialNetWorkInt
{
 
    public String msg=null;
    String photo=null;
    String video=null;
    SWBModel model=null;
    String user;
    String password;


    public SWBSocialNetWork(SWBModel model)
    {
        this.model=model;
    }

    public void init(String className)
    {
        /*
        SocialNetworkConectionData socialNetworkData=SWBSocialUtils.getConectionData(model, className);
        if(socialNetworkData!=null)
        {
            user=socialNetworkData.getUser();
            password=socialNetworkData.getPassword();
        }
         * */
         user="myUser";
         password="myPassw";
    }

   
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

    public String getUser()
    {
        return user;
    }

    public String getPassword()
    {
        return password;
    }
}
