/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.swb.social.lib;

import org.swb.social.lib.Exception.SWBSocialNetworkException;

/**
 *
 * @author jorge.jimenez
 */
public interface SocialNetWorkInt {

    public void init(String className);

    public String getUser();

    public String getPassword();

    //Publica un post
    public void sendPost() throws SWBSocialNetworkException;

    //Obtiene permisos de conexión
    public boolean connect() throws SWBSocialNetworkException;

    //Desconecta la conexión
    public boolean disConnect() throws SWBSocialNetworkException;

    //set

    public void setMsg(String msg);

    public void setPhoto(String photo);

    public void setVideo(String video);

    //gets

    public String getMsg();

    public String getPhoto();

    public String getVideo();

}
