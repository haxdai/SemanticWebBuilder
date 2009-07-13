package org.semanticwb.security.auth;

import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;

/**
 *
 * @author serch
 */
public class SWB4GenericLDAPBridge extends ExtUserRepInt
{
    static Logger log = SWBUtils.getLogger(SWB4GenericLDAPBridge.class);
    private UserRepository userRep;
    private Properties props;
    private String seekField;
    private String userObjectClass;
    private String fieldFirstName;
    private String fieldLastName;
    private String fieldMiddleName;
    private String fieldEmail;
    private String valueLanguage;

    public SWB4GenericLDAPBridge(UserRepository UserRep, Properties props)
    {
        this.userRep = UserRep;
        this.props = props;
        this.seekField = props.getProperty("seekField", "uid");
        this.userObjectClass = props.getProperty("userObjectClass", "inetPerson");
        this.fieldFirstName = props.getProperty("fieldFirstName", "givenName");
        this.fieldLastName = props.getProperty("fieldLastName", "sn");
        this.fieldMiddleName = props.getProperty("fieldMiddleName", "null");
        this.fieldEmail = props.getProperty("fieldEmail", "mail");
        this.valueLanguage = props.getProperty("valueLanguage", "");

    }

    @Override
    public void syncUsers()
    {
        try
        {
            NamingEnumeration ne = getUserList();
            String currLog;
            while (ne.hasMore()){
                SearchResult sr = (SearchResult)ne.next();
                currLog = (String)sr.getAttributes().get(seekField).get();
                userRep.getUserByLogin(currLog);
            }
        } catch (NamingException ex)
        {
            log.error("Syncing Users for: "+userRep.getId(), ex);
        }
    }

    @Override
    public boolean validateCredential(String login, Object credential)
    {
        return AuthenticateLP(login, credential);
    }

    @Override
    public boolean syncUser(String login, User user)
    {
        log.trace("Syncing User:"+login+"-"+user);
        boolean ret = false;
        try
        {
            Attributes att = getUserAttributes(login);
            log.trace("Attrs: "+att);
            if (null!=att && att.size()>0){
            if (null == user)
            {
                user = userRep.createUser();
                user.setLogin(login);
                user.setActive(true);
            }
            loadAttrs2RecUser(att, user);
            ret = true;
            }
        } catch (NamingException ex)
        {
           log.debug("Error Syncing a User: "+login,ex);
        }

        return ret;
    }

    private Hashtable getPropertiesHash()
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                props.getProperty("factory", "com.sun.jndi.ldap.LdapCtxFactory"));
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://localhost"));
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty("principal", ""));
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty("credential", ""));
        return env;
    }

    private String getCNFromLogin(String login)
    {
        DirContext ctx = null;
        try
        {
            ctx = new InitialDirContext(getPropertiesHash());
        } catch (NamingException e)
        {
            return null; // Can't get the info of the repository so we leave
        }
        //System.out.println("ctx:" + ctx);
        NamingEnumeration answers = null;

        SearchControls ctls = new SearchControls();
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        try
        {
            answers = ctx.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls);

            return ((SearchResult) answers.next()).getName() + "," + props.getProperty("base", "");
        } catch (NamingException e)
        {
            return null; //We didn't found or we got an error so we leave
        }
    }

    private boolean AuthenticateLP(String login, Object credential)
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                props.getProperty("factory", "com.sun.jndi.ldap.LdapCtxFactory"));
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://localhost"));

        env.put(Context.SECURITY_PRINCIPAL, getCNFromLogin(login));

        env.put(Context.SECURITY_CREDENTIALS, credential);
        try
        {
            DirContext ctx = new InitialDirContext(env);
            ctx.close();
        } catch (NamingException e)
        {
            return false;
        }
        return true;
    }

    private NamingEnumeration getUserList() throws NamingException
    {
        Hashtable env = getPropertiesHash();
        DirContext ctx = new InitialDirContext(env);

        Attributes matchAttrs = new BasicAttributes(true); // ignore case
        matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
        // Search for objects that have those matching attributes
        NamingEnumeration answers = null;

        SearchControls ctls = new SearchControls();
        ctls.setReturningAttributes(new String[]{seekField});
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        answers = ctx.search(props.getProperty("base", ""),
                "objectClass=" + userObjectClass, ctls);

        /*SearchControls ctls = new SearchControls();
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration answers = ctx.search(DBUser.getInstance(repository).getProperty("container", ""),
        "objectClass=WBPerson"
        , ctls);*/
        ctx.close();
        return answers;
    }

    public Attributes getUserAttributes(String login) throws NamingException
    {
        DirContext ctx = new InitialDirContext(getPropertiesHash());
        String[] attrIDs =
        {
            "*"
        };
        Attributes answer = null;

        String cn = getCNFromLogin(login);
        //System.out.println("CN:" + cn);
        answer = ctx.getAttributes(cn, attrIDs);

        ctx.close();
        return answer;
    }

    public void loadAttrs2RecUser(Attributes attrs, User ru)
    {

        try
        {
            if (!"null".equals(fieldFirstName))
            {
                ru.setFirstName((String) attrs.get(fieldFirstName).get());
            }
        } catch (Exception ne)
        {
        }
        try
        {
            if (!"null".equals(fieldLastName))
            {
                ru.setLastName((String) attrs.get(fieldLastName).get());
            }
        } catch (Exception ne)
        {
        }
        try
        { //If there is no middlename go on
            if (!"null".equals(fieldMiddleName))
            {
                ru.setSecondLastName((String) attrs.get(fieldMiddleName).get());
            }
        } catch (Exception ne)
        {
        }
        try
        {
            if (!"null".equals(fieldEmail))
            {
                ru.setEmail((String) attrs.get(fieldEmail).get());
            }
        } catch (Exception ne)
        {
        }
        // If there is no language keep the default
        try
        {
            if (valueLanguage.startsWith("|"))
            {
                ru.setLanguage(valueLanguage.substring(1));
            } else
            {
                ru.setLanguage((String) attrs.get(valueLanguage).get());
            }
        } catch (Exception ne)
        {
        }

    }
}
