/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.lib;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticModel;
import org.swb.social.lib.Exception.SWBSocialNetworkException;

/**
 *
 * @author jorge.jimenez
 */
public class SWBSocialMgr //extends SWBSocialNetWork
{
    private static Logger log = SWBUtils.getLogger(SWBSocialMgr.class);

    private SWBSocialNetWork socialNetworkClass=null;

   
    public SWBSocialMgr(String socialNetworkClassName) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
            Class classInstance=Class.forName(socialNetworkClassName);
            socialNetworkClass=(SWBSocialNetWork)classInstance.newInstance();
            if(socialNetworkClass==null) throw new ClassNotFoundException();
    }

  
    public void sendPost() throws SWBSocialNetworkException {
         socialNetworkClass.sendPost();
    }

    public void setMsg(String msg)
    {
        socialNetworkClass.setMsg(msg);
    }

    public void setPhoto(String photo)
    {
        socialNetworkClass.setPhoto(photo);
    }

    public void setVideo(String video){
        socialNetworkClass.setVideo(video);
    }

    public boolean connect() throws SWBSocialNetworkException {
        return socialNetworkClass.connect();
    }

    public boolean disConnect() throws SWBSocialNetworkException {
        return socialNetworkClass.disConnect();
    }

}
