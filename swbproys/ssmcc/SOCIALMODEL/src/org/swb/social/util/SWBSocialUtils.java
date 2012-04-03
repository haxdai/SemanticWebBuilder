/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.util;

import java.util.Iterator;
import org.swb.social.lib.SWBSocialNetWork;
import org.swb.social.model.SocialNetwork;

/**
 *
 * @author jorge.jimenez
 */
public class SWBSocialUtils {


    public static SocialNetworkConectionData getConectionData(org.semanticwb.model.SWBModel model, String socialNetwork)
    {
        SocialNetworkConectionData socialData=null;
        Iterator<SocialNetwork> itSocialNetworks=SocialNetwork.listSocialNetworkByClassName(socialNetwork, model);
        if(itSocialNetworks.hasNext())
        {
            SocialNetwork socialNetworkTmp=itSocialNetworks.next();
            socialData=new SocialNetworkConectionData();
            socialData.setUser(socialNetworkTmp.getSn_login());
            socialData.setPassword(socialNetworkTmp.getSn_password());
        }
        return socialData;
    }

}
