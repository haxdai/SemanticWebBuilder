/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.lib;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.swb.social.lib.Exception.SWBSocialException;
import org.swb.social.lib.Exception.SWBSocialNetworkException;

/**
 *
 * @author jorge.jimenez
 */
public class SWBSocialMgr {

    private static Logger log = SWBUtils.getLogger(SWBSocialMgr.class);

    SocialNetWorkInt socialNetworkClass=null;

    public SWBSocialMgr(SocialNetWorkInt socialNetworkClass) throws SWBSocialException
    {
        if(socialNetworkClass==null) throw new SWBSocialException("The socialNetworkClass is null");
        this.socialNetworkClass=socialNetworkClass;
    }

    public void sendPost() throws SWBSocialNetworkException {
        if(socialNetworkClass!=null)
        {
            try{
                socialNetworkClass.sendPost();
            }catch(SWBSocialNetworkException e){
                log.error(e);
            }
        }
    }

}
