/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.infotec.intranet.login;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.AttributeInUseException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.NoSuchAttributeException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.semanticwb.Logger;

import org.semanticwb.SWBUtils;
import sun.misc.BASE64Encoder;

/**
 *
 * @author victor.lorenzana
 */
public class LDAPManager
{

    private static final int UF_ACCOUNTDISABLE = 0x0002;
    private static final int UF_PASSWORD_NOTREQD = 0x0020;
    private static final int UF_PASSWORD_CANT_CHANGE = 0x0040;
    private static final int UF_NORMAL_ACCOUNT = 0x0200;
    private static final int UF_DONT_EXPIRE_PASSWD = 0x10000;
    private static final int UF_PASSWORD_EXPIRED = 0x800000;
    static Logger log = SWBUtils.getLogger(LDAPManager.class);
    /** The OU (organizational unit) to add users to */
    /*private static final String USERS_OU =
    "OU=Contraloria Interna,OU=Corporativo,DC=wininfotec,DC=com,DC=mx";*/
    /** The OU (organizational unit) to add groups to */
    private static final String GROUPS_OU =
            "ou=Groups,o=forethought.com";
    /** The OU (organizational unit) to add permissions to */
    private static final String PERMISSIONS_OU =
            "ou=Permissions,o=forethought.com";
    /** The default LDAP port */
    private static final int DEFAULT_PORT = 389;
    /** The LDAPManager instance object */
    private static Map instances = new HashMap();
    /** The connection, through a <code>DirContext</code>, to LDAP */
    private DirContext context;
    /** The hostname connected to */
    private String hostname;
    /** The port connected to */
    private int port;
    private String USERS_OU;

    protected LDAPManager(String hostname, int port,
            String username, String password)
            throws NamingException
    {

        context = getInitialContext(hostname, port, username, password);

        // Only save data if we got connected
        this.hostname = hostname;
        this.port = port;
    }

    protected LDAPManager(String url,
            String username, String password)
            throws NamingException
    {

        context = getInitialContext(url, username, password);

        // Only save data if we got connected
        try
        {
            url=url.replace("ldap", "http");
            URL urlHost = new URL(url);
            this.hostname = urlHost.getHost();
            if (url.startsWith("ldaps"))
            {
                this.port = 636;
            }
            else
            {
                this.port = 389;
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public static LDAPManager getInstance(String hostname,
            int port,
            String username,
            String password)
            throws NamingException
    {

        // Construct the key for the supplied information
        String key = new StringBuffer().append(hostname).append(":").append(port).append("|").append((username == null ? "" : username)).append("|").append((password == null ? "" : password)).toString();

        if (!instances.containsKey(key))
        {
            synchronized (LDAPManager.class)
            {
                if (!instances.containsKey(key))
                {
                    LDAPManager instance =
                            new LDAPManager(hostname, port,
                            username, password);
                    instances.put(key, instance);
                    return instance;
                }
            }
        }

        return (LDAPManager) instances.get(key);
    }

    public static LDAPManager getInstance(String url,
            String username,
            String password)
            throws NamingException
    {

        // Construct the key for the supplied information
        String key = new StringBuffer().append(url).append("|").append((username == null ? "" : username)).append("|").append((password == null ? "" : password)).toString();

        if (!instances.containsKey(key))
        {
            synchronized (LDAPManager.class)
            {
                if (!instances.containsKey(key))
                {
                    LDAPManager instance =
                            new LDAPManager(url,
                            username, password);
                    instances.put(key, instance);
                    return instance;
                }
            }
        }

        return (LDAPManager) instances.get(key);
    }

    public static LDAPManager getInstance(String hostname, int port)
            throws NamingException
    {

        return getInstance(hostname, port, null, null);
    }

    public static LDAPManager getInstance(String hostname)
            throws NamingException
    {

        return getInstance(hostname, DEFAULT_PORT, null, null);
    }

    public void setOU(String ou)
    {
        this.USERS_OU = ou;
    }

    private byte[] toUnicodeBytes(String str)
    {
        byte[] unicodeBytes = null;
        try
        {
            byte[] unicodeBytesWithQuotes = str.getBytes("Unicode");
            unicodeBytes = new byte[unicodeBytesWithQuotes.length - 2];
            System.arraycopy(unicodeBytesWithQuotes, 2, unicodeBytes, 0,
                    unicodeBytesWithQuotes.length - 2);
        }
        catch (UnsupportedEncodingException e)
        {
            // This should never happen.
            e.printStackTrace();
        }
        return unicodeBytes;
    }

    public void addUser(String domain, String username, String sgivenName,
            String lastName, String password, String ou, String apellidos, String displayName, String sAMAccountname, Map<String, String> atts)
            throws NamingException
    {

        // Create a container set of attributes
        Attributes container = new BasicAttributes();

        this.USERS_OU = ou;
        // Create the objectclass to add
        Attribute objClasses = new BasicAttribute("objectClass");
        objClasses.add("top");
        objClasses.add("person");
        objClasses.add("organizationalPerson");
        objClasses.add("inetOrgPerson");
        for (String key : atts.keySet())
        {
            Attribute att = new BasicAttribute(key);
            att.add(atts.get(key));
            container.put(att);
        }
        // Assign the username, first name, and last name
        //String cnValue = new StringBuffer(firstName).append(" ").append(lastName).toString();
        //Attribute cn = new BasicAttribute("cn", cnValue);
        Attribute login = new BasicAttribute("sAMAccountname", sAMAccountname);
        Attribute givenName = new BasicAttribute("givenName", sgivenName);
        Attribute sn = new BasicAttribute("sn", apellidos.trim());
        Attribute dn = new BasicAttribute("displayName", displayName);
        domain = sAMAccountname + "@" + domain;
        //Attribute userPrincipalName = new BasicAttribute("userPrincipalName", domain);
        //container.put(userPrincipalName);

        //Attribute userAccountControl = new BasicAttribute("userAccountControl", Integer.toString(66048));
        Attribute userAccountControl = new BasicAttribute("userAccountControl", Integer.toString(544));
        container.put(userAccountControl);


        Attribute userPrincipalName = new BasicAttribute("userPrincipalName", domain);
        container.put(userPrincipalName);

        Attribute uid = new BasicAttribute("uid", username);
        // Add password
        //Attribute userPassword = new BasicAttribute("userpassword", password);
        //try
        {
            //Attribute userPassword = new BasicAttribute("edsapassword", digest("DSA", "123456"));


            //DirContext def=context.getSchemaClassDefinition("edsapassword");
            //Attribute edsapassword = new BasicAttribute("edsapassword", toUnicodeBytes(password));


            /*String newQuotedPassword = "\"" + password + "\"";
            try
            {
                byte[] newUnicodePassword = newQuotedPassword.getBytes("UTF-16LE");
                Attribute edsapassword = new BasicAttribute("edsapassword", newUnicodePassword);
                container.put(edsapassword);
            }
            catch (Exception e)
            {
            }*/

            // Add these to the container
            container.put(objClasses);
            
            container.put(sn);
            container.put(givenName);
            container.put(uid);
            
            container.put(dn);
            container.put(login);
            //container.put(edsapassword);

            // Create the entry
            Object obj = context.lookup(ou);
            if (obj instanceof DirContext)
            {
                DirContext raiz = (DirContext) obj;
                raiz.createSubcontext("CN=" + displayName, container);
                // fire copia CV
            }
            else
            {
                throw new NamingException("No se puede crear al usuario OU no encontrada OU: " + ou);
            }
        }
        //catch (NoSuchAlgorithmException e)
        {
            //throw new NamingException("No se puede crear al usuario error algoritmo md5");
        }
    }

    private String digest(String algorithm, String password) throws NoSuchAlgorithmException
    {
        String r = null;
        byte[] b = null;
        MessageDigest md = MessageDigest.getInstance(algorithm);
        BASE64Encoder encoder;

        md.update(password.getBytes());
        b = md.digest();

        encoder = new BASE64Encoder();

        System.out.println(encoder.encode(b));

        r = encoder.encode(b);

        return r;
    }

    public void deleteUser(String username) throws NamingException
    {
        try
        {
            //String userDN=getUserDN(username);
            context.destroySubcontext(username);
        }
        catch (NameNotFoundException e)
        {
            // If the user is not found, ignore the error
            log.error(e);

        }
    }

    public boolean isValidUser(String username, String password)
            throws UserNotFoundException
    {
        try
        {
            DirContext context =
                    getInitialContext(hostname, port, getUserDN(username),
                    password);
            return true;
        }
        catch (javax.naming.NameNotFoundException e)
        {
            throw new UserNotFoundException(username);
        }
        catch (NamingException e)
        {
            // Any other error indicates couldn't log user in
            return false;
        }
    }

    public void addGroup(String name, String description)
            throws NamingException
    {

        // Create a container set of attributes
        Attributes container = new BasicAttributes();

        // Create the objectclass to add
        Attribute objClasses = new BasicAttribute("objectClass");
        objClasses.add("top");
        objClasses.add("groupOfUniqueNames");
        objClasses.add("groupOfForethoughtNames");

        // Assign the name and description to the group
        Attribute cn = new BasicAttribute("cn", name);
        Attribute desc = new BasicAttribute("description", description);

        // Add these to the container
        container.put(objClasses);
        container.put(cn);
        container.put(desc);

        // Create the entry
        context.createSubcontext(getGroupDN(name), container);
    }

    public void deleteGroup(String name) throws NamingException
    {
        try
        {
            context.destroySubcontext(getGroupDN(name));
        }
        catch (NameNotFoundException e)
        {
            // If the group is not found, ignore the error
        }
    }

    public void addPermission(String name, String description)
            throws NamingException
    {

        // Create a container set of attributes
        Attributes container = new BasicAttributes();

        // Create the objectclass to add
        Attribute objClasses = new BasicAttribute("objectClass");
        objClasses.add("top");
        objClasses.add("forethoughtPermission");

        // Assign the name and description to the group
        Attribute cn = new BasicAttribute("cn", name);
        Attribute desc = new BasicAttribute("description", description);

        // Add these to the container
        container.put(objClasses);
        container.put(cn);
        container.put(desc);

        // Create the entry
        context.createSubcontext(getPermissionDN(name), container);
    }

    public void deletePermission(String name) throws NamingException
    {
        try
        {
            context.destroySubcontext(getPermissionDN(name));
        }
        catch (NameNotFoundException e)
        {
            // If the permission is not found, ignore the error
        }
    }

    public void assignUser(String username, String groupName)
            throws NamingException
    {

        try
        {
            ModificationItem[] mods = new ModificationItem[1];

            Attribute mod =
                    new BasicAttribute("uniqueMember",
                    getUserDN(username));
            mods[0] =
                    new ModificationItem(DirContext.ADD_ATTRIBUTE, mod);
            context.modifyAttributes(getGroupDN(groupName), mods);
        }
        catch (AttributeInUseException e)
        {
            // If user is already added, ignore exception
        }
    }

    public void removeUser(String username, String groupName)
            throws NamingException
    {

        try
        {
            ModificationItem[] mods = new ModificationItem[1];
            String userDN = getUserDN(username);
            Attribute mod = new BasicAttribute("uniqueMember", userDN);
            mods[0] =
                    new ModificationItem(DirContext.REMOVE_ATTRIBUTE, mod);
            String dn = getGroupDN(groupName);
            context.modifyAttributes(groupName, mods);
        }
        catch (NoSuchAttributeException e)
        {
            // If user is not assigned, ignore the error
        }
    }

    public boolean userInGroup(String username, String groupName)
            throws NamingException
    {

        // Set up attributes to search for
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "uniqueMember";

        Attributes attributes =
                context.getAttributes(getGroupDN(groupName),
                searchAttributes);
        if (attributes != null)
        {
            Attribute memberAtts = attributes.get("uniqueMember");
            if (memberAtts != null)
            {
                for (NamingEnumeration vals = memberAtts.getAll();
                        vals.hasMoreElements();)
                {
                    if (username.equalsIgnoreCase(
                            getUserUID((String) vals.nextElement())))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public List getMembers(String groupName) throws NamingException
    {
        List members = new LinkedList();

        // Set up attributes to search for
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "uniqueMember";

        Attributes attributes =
                context.getAttributes(getGroupDN(groupName),
                searchAttributes);
        if (attributes != null)
        {
            Attribute memberAtts = attributes.get("uniqueMember");
            if (memberAtts != null)
            {
                for (NamingEnumeration vals = memberAtts.getAll();
                        vals.hasMoreElements();
                        members.add(
                                getUserUID((String) vals.nextElement())));
            }
        }

        return members;
    }

    public List getGroups(String username) throws NamingException
    {
        List groups = new LinkedList();

        // Set up criteria to search on
        String filter = new StringBuffer().append("(&").append("(objectClass=groupOfForethoughtNames)").append("(uniqueMember=").append(getUserDN(username)).append(")").append(")").toString();

        // Set up search constraints
        SearchControls cons = new SearchControls();
        cons.setSearchScope(SearchControls.ONELEVEL_SCOPE);

        NamingEnumeration results =
                context.search(GROUPS_OU, filter, cons);

        while (results.hasMore())
        {
            SearchResult result = (SearchResult) results.next();
            groups.add(getGroupCN(result.getName()));
        }

        return groups;
    }

    public void assignPermission(String groupName, String permissionName)
            throws NamingException
    {

        try
        {
            ModificationItem[] mods = new ModificationItem[1];

            Attribute mod =
                    new BasicAttribute("uniquePermission",
                    getPermissionDN(permissionName));
            mods[0] =
                    new ModificationItem(DirContext.ADD_ATTRIBUTE, mod);
            context.modifyAttributes(getGroupDN(groupName), mods);
        }
        catch (AttributeInUseException e)
        {
            // Ignore the attribute if it is already assigned
        }
    }

    public void revokePermission(String groupName, String permissionName)
            throws NamingException
    {

        try
        {
            ModificationItem[] mods = new ModificationItem[1];

            Attribute mod =
                    new BasicAttribute("uniquePermission",
                    getPermissionDN(permissionName));
            mods[0] =
                    new ModificationItem(DirContext.REMOVE_ATTRIBUTE, mod);
            context.modifyAttributes(getGroupDN(groupName), mods);
        }
        catch (NoSuchAttributeException e)
        {
            // Ignore errors if the attribute doesn't exist
        }
    }

    public boolean hasPermission(String groupName, String permissionName)
            throws NamingException
    {

        // Set up attributes to search for
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "uniquePermission";

        Attributes attributes =
                context.getAttributes(getGroupDN(groupName),
                searchAttributes);
        if (attributes != null)
        {
            Attribute permAtts = attributes.get("uniquePermission");
            if (permAtts != null)
            {
                for (NamingEnumeration vals = permAtts.getAll();
                        vals.hasMoreElements();)
                {
                    if (permissionName.equalsIgnoreCase(
                            getPermissionCN((String) vals.nextElement())))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public List getPermissions(String groupName) throws NamingException
    {
        List permissions = new LinkedList();

        // Set up attributes to search for
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "uniquePermission";

        Attributes attributes =
                context.getAttributes(getGroupDN(groupName),
                searchAttributes);
        if (attributes != null)
        {
            Attribute permAtts = attributes.get("uniquePermission");
            if (permAtts != null)
            {
                for (NamingEnumeration vals = permAtts.getAll();
                        vals.hasMoreElements();
                        permissions.add(
                                getPermissionCN((String) vals.nextElement())));
            }
        }

        return permissions;
    }

    private String getUserDN(String username)
    {

        //return new StringBuffer().append("uid=").append(username).append(",").append(USERS_OU).toString();
        return new StringBuffer().append("CN=").append(username).append(",").append(USERS_OU).toString();
    }

    private String getUserUID(String userDN)
    {
        int start = userDN.indexOf("=");
        int end = userDN.indexOf(",");

        if (end == -1)
        {
            end = userDN.length();
        }

        return userDN.substring(start + 1, end);
    }

    private String getGroupDN(String name)
    {
        return new StringBuffer().append("cn=").append(name).append(",").append(GROUPS_OU).toString();
    }

    private String getGroupCN(String groupDN)
    {
        int start = groupDN.indexOf("=");
        int end = groupDN.indexOf(",");

        if (end == -1)
        {
            end = groupDN.length();
        }

        return groupDN.substring(start + 1, end);
    }

    private String getPermissionDN(String name)
    {
        return new StringBuffer().append("cn=").append(name).append(",").append(PERMISSIONS_OU).toString();
    }

    private String getPermissionCN(String permissionDN)
    {
        int start = permissionDN.indexOf("=");
        int end = permissionDN.indexOf(",");

        if (end == -1)
        {
            end = permissionDN.length();
        }

        return permissionDN.substring(start + 1, end);
    }

    private DirContext getInitialContext(String hostname, int port,
            String username, String password)
            throws NamingException
    {

        //String providerURL = new StringBuffer("ldap://").append(hostname).append(":").append(port).toString();
        String providerURL = new StringBuffer("ldap://").append(hostname).append(":").append(port).toString();

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, providerURL);

        if ((username != null) && (!username.equals("")))
        {
            //props.put(Context.SECURITY_AUTHENTICATION, "simple");
            props.put(Context.SECURITY_AUTHENTICATION, "simple");
            props.put(Context.SECURITY_PRINCIPAL, username);
            props.put(Context.SECURITY_CREDENTIALS,
                    ((password == null) ? "" : password));
        }

        return new InitialDirContext(props);
    }

    private DirContext getInitialContext(String providerURL,
            String username, String password)
            throws NamingException
    {

        //String providerURL = new StringBuffer("ldap://").append(hostname).append(":").append(port).toString();


        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, providerURL);

        if ((username != null) && (!username.equals("")))
        {
            //props.put(Context.SECURITY_AUTHENTICATION, "simple");
            props.put(Context.SECURITY_AUTHENTICATION, "simple");
            props.put(Context.SECURITY_PRINCIPAL, username);
            props.put(Context.SECURITY_CREDENTIALS,
                    ((password == null) ? "" : password));
        }

        return new InitialDirContext(props);
    }

    public void close()
    {
        try
        {
            context.close();
        }
        catch (NamingException e)
        {
            log.trace(e);
        }
    }
}
