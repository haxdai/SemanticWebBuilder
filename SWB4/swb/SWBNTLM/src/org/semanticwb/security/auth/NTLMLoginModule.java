/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.security.auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBSessionUser;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;
import org.semanticwb.servlet.internal.NTLMServlet;


/**
 *
 * @author serch
 */
public class NTLMLoginModule implements LoginModule{

    /** The log. */
    static Logger log = SWBUtils.getLogger(NTLMLoginModule.class);

    /** The subject. */
    protected Subject subject;

    /** The callback handler. */
    protected CallbackHandler callbackHandler;

    /** The shared state. */
    protected Map sharedState;

    /** The options. */
    protected Map options;

    /** The loginflag. */
    protected boolean loginflag = false;

    /** The principal. */
    protected User principal = null;

    /** The credential. */
    protected Object credential = null;

    /** The website. */
    protected String website = null;

    /* (non-Javadoc)
     * @see javax.security.auth.spi.LoginModule#initialize(javax.security.auth.Subject, javax.security.auth.callback.CallbackHandler, java.util.Map, java.util.Map)
     */
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options)
    {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
        log.debug("Initialized...");
    }

    public boolean login() throws LoginException
    {
        if (callbackHandler == null)
        {
            throw new LoginException("No callbackHandler or not adecuate callbackHandler supplied");
        }

        String connectionid;
        Callback[] callbacks = new Callback[3];
        callbacks[0] = new NameCallback("login");
        callbacks[1] = new PasswordCallback("password", false);
        callbacks[2] = new TextInputCallback("Site");
        try
        {
            log.trace("callback:"+callbackHandler);
            callbackHandler.handle(callbacks);
            connectionid = ((NameCallback) callbacks[0]).getName();
            credential = ((PasswordCallback) callbacks[1]).getPassword();
            ((PasswordCallback) callbacks[1]).clearPassword();
            website = ((TextInputCallback) callbacks[2]).getText();
        } catch (IOException ex)
        {
            log.error("IO Error Login a user", ex);
            throw new LoginException("IO Error: " + ex.getMessage());
        } catch (UnsupportedCallbackException ex)
        {
            log.error("UnsupportedCallbackException Error Login a user", ex);
            throw new LoginException("UnsupportedCallbackException Error: " + ex.getMessage());
        }
        log.trace("WebSite id: "+website);
        WebSite ws = SWBContext.getWebSite(website);
        String login = NTLMServlet.secContx.get(connectionid).getIdentity().getFqn();
        login = login.substring(login.indexOf('\\')+1); //System.out.println("Login:"+login);
        UserRepository ur = ws.getUserRepository();
        principal = ur.getUserByLogin(login);
        log.debug("principal:"+principal);
        if (null == principal)
        {
            throw new LoginException("User inexistent");
        }

        log.debug("isvalid:"+principal.isValid());

        if (!principal.isValid())
        {
            throw new LoginException("User invalid");
        }


        loginflag = true;
        return loginflag;
    }

    /* (non-Javadoc)
     * @see javax.security.auth.spi.LoginModule#commit()
     */
    public boolean commit() throws LoginException
    {
        boolean flag = false;
        if (!loginflag)
        {
            return false;
        }
        Iterator it = subject.getPrincipals().iterator();
        User tmp = null;
        while(it.hasNext())
        {
            tmp=(User)it.next();
            if(principal.getUserRepository().equals(tmp.getUserRepository()))
            {
                break;
            }
        }
        if (null != tmp)
        {
            ((SWBSessionUser)tmp).updateUser(principal);
            flag = true;
        } else
        {
            subject.getPrincipals().add(principal);
        }
        subject.getPrivateCredentials().add(credential);
        try
        {
            principal.checkCredential(credential);
            if (flag) tmp.checkCredential(credential);
        } catch (java.security.NoSuchAlgorithmException ex)
        {
            log.error("Can't set Signed status", ex);
        }
        return loginflag;
    }

    /* (non-Javadoc)
     * @see javax.security.auth.spi.LoginModule#abort()
     */
    public boolean abort() throws LoginException
    {
        if (subject != null)
        {
            subject.getPrincipals().clear();
            subject.getPrivateCredentials().clear();
            subject.getPublicCredentials().clear();
        }
        return true;
    }

    /* (non-Javadoc)
     * @see javax.security.auth.spi.LoginModule#logout()
     */
    public boolean logout() throws LoginException
    {
        if (subject != null)
        {
            subject.getPrincipals().clear();
            subject.getPrivateCredentials().clear();
            subject.getPublicCredentials().clear();
        }
        return true;
    }

}
