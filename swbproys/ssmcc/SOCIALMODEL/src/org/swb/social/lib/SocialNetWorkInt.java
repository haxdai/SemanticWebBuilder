/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.swb.social.lib;

import org.semanticwb.SWBException;
import org.swb.social.lib.Exception.SWBSocialException;
import org.swb.social.lib.Exception.SWBSocialNetworkException;

/**
 *
 * @author jorge.jimenez
 */
public interface SocialNetWorkInt {

    //Publica un post
    public void sendPost() throws SWBSocialNetworkException;

    //Obtiene permisos de conexión
    public void connect() throws SWBSocialNetworkException;

    //Desconecta la conexión
    public void disConnect() throws SWBSocialNetworkException;

    //set

    public void setMsg(String msg);

    public void setPhoto(String photo);

    public void setVideo(String video);

    //gets

    public String getMsg();

    public String getPhoto();

    public String getVideo();

}
