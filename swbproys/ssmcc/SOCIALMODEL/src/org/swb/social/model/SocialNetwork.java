package org.swb.social.model;

import org.swb.social.lib.Exception.SWBSocialNetworkException;
import org.swb.social.lib.SocialNetWorkInt;


   /**
   * Objeto que se encarga de almacenar todos los datos de una red social 
   */
public class SocialNetwork extends org.swb.social.model.base.SocialNetworkBase implements SocialNetWorkInt
{
    public String msg=null;
    String photo=null;
    String video=null;

    public SocialNetwork(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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

    public void sendPost() throws SWBSocialNetworkException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void connect() throws SWBSocialNetworkException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void disConnect() throws SWBSocialNetworkException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}
