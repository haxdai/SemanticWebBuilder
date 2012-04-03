/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.util;

/**
 *
 * @author jorge.jimenez
 */
public class SocialNetworkConectionData {

    private String user=null;
    private String password=null;

    public void setUser(String user)
    {
        this.user=user;
    }

    public void setPassword(String password)
    {
       this.password=password;
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
