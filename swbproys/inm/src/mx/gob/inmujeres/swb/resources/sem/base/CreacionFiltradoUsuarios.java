/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources.sem.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.UserRepository;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.security.auth.ExtUserRepInt;

/**
 *
 * @author gabriela.rosales
 */
public class CreacionFiltradoUsuarios extends ExtUserRepInt {

    /** The user rep. */
    protected UserRepository userRep;
    /** The props. */
    protected Properties props;
    /** The seek field. */
    protected String seekField;
    /** The user object class. */
    protected String userObjectClass;
    /** The field first name. */
    protected String fieldFirstName;
    /** The field last name. */
    protected String fieldLastName;
    /** The field middle name. */
    protected String fieldMiddleName;
    /** The field email. */
    protected String fieldEmail;
    /** The value language. */
    protected String valueLanguage;
    protected String group;
    protected String uid;
    private static final String INTRANETURI = "http://www.infotec.com.mx/intranet#";
    private static final String BASE = "dc=maxcrc,dc=com";
    private static final String PRINCIPAL = "cn=manager,dc=maxcrc,dc=com";
    private static final String HOST = "localhost";
    private static final String PASSWORD = "secret";
    private static final int PORT = 389;
    static Logger log = SWBUtils.getLogger(CreacionFiltradoUsuarios.class);

    //si
    public CreacionFiltradoUsuarios() {
        userRep = SWBContext.getDefaultRepository();
        props = SWBUtils.TEXT.getPropertyFile("/genericLDAP.properties"); //archivo de configuracion externa
        this.userObjectClass = props.getProperty("userObjectClass", "person"); //clase objeto para buscar usuario
        this.seekField = props.getProperty("seekField", "sAmAccountName");// campo llave para busqueda
    }

    public CreacionFiltradoUsuarios(UserRepository UserRep, Properties props) {
        this.userRep = UserRep;
        this.props = props;
        this.seekField = props.getProperty("seekField", "uid");
        this.userObjectClass = props.getProperty("userObjectClass", "inetPerson");
        this.fieldFirstName = props.getProperty("fieldFirstName", "givenName");
        this.fieldLastName = props.getProperty("fieldLastName", "sn");
        this.fieldMiddleName = props.getProperty("fieldMiddleName", "null");
        this.fieldEmail = props.getProperty("fieldEmail", "mail");
        this.valueLanguage = props.getProperty("valueLanguage", "");
        this.group = props.getProperty("group", "ou");


    }
    //si

    public void loadAttrs2RecUserInit(Attributes attrs, User ru) {

        try {
            if (!"null".equals(uid)) {

                ru.setLogin((String) attrs.get(uid).get());
            }
        } catch (Exception ne) {
        }
        try {
            if (!"null".equals(fieldFirstName)) {

                ru.setFirstName((String) attrs.get(fieldFirstName).get());
            }
        } catch (Exception ne) {
        }
        try {
            if (!"null".equals(fieldLastName)) {
                ru.setLastName((String) attrs.get(fieldLastName).get());
            }
        } catch (Exception ne) {
        }
        try { //If there is no middlename go on
            if (!"null".equals(fieldMiddleName)) {
                ru.setSecondLastName((String) attrs.get(fieldMiddleName).get());
            }
        } catch (Exception ne) {
        }
        try {
            if (!"null".equals(fieldEmail)) {
                ru.setEmail((String) attrs.get(fieldEmail).get());
            }
        } catch (Exception ne) {
        }
        // If there is no language keep the default
        try {
            if (valueLanguage.startsWith("|")) {
                ru.setLanguage(valueLanguage.substring(1));
            } else {
                ru.setLanguage((String) attrs.get(valueLanguage).get());
            }
        } catch (Exception ne) {
        }

    }

    //si
    public String getOUFromLogin(String login) {
        String name = null;
        DirContext dir = null;
        try {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", "organizationalUnit"));
            NamingEnumeration answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]{
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls); //recibe nombre, filtro y un search

            name = ((SearchResult) answers.next()).getAttributes().get("ou").get().toString();

            if (name == null) {
                name = "";
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                dir.close();
            } catch (NamingException ex) {
                log.error(ex);
            }
        }
        return name;
    }
    //si

    public void createGroupUser(String login, User u, String ou) throws NamingException {
        UserGroup g;
        UserGroup gPadre = null;
        HashSet us;
        String rutaLogin;
        String parent = null;
        UserRepository rep = userRep;


        g = rep.getUserGroup(ou);
        us = getAllManagerRuta();
        rutaLogin = getManagerLogin(login);

        Iterator i = us.iterator();
        while (i.hasNext()) {
            String h = i.next().toString();
            if (h.equals(rutaLogin)) {
                int d = rutaLogin.indexOf(",");
                parent = rutaLogin.substring(3, d);
            }
        }

      
        if (parent != null) {
            gPadre = rep.getUserGroup(parent);
            if (gPadre == null) {
                rep.createUserGroup(parent);
                gPadre = rep.getUserGroup(parent);
            }
        }

        if (g == null) {
            g = rep.createUserGroup(ou);
        }

        if (u.getUserGroup() != g) {
            g.setTitle(ou);
            u.addUserGroup(g);
            g.setValid(true);
            if (parent != null) {
                g.setParent(gPadre);
            }
         }
    }

    public static void main(String args[]) {
    }

//si
    public String getLogin(String cn) throws Exception {
        String name = null;

        DirContext dir = null;
        try {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            NamingEnumeration answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]{
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(distinguishedName=" + cn + "))", ctls);


            name = ((SearchResult) answers.next()).getAttributes().get(seekField).toString();
        } catch (Exception e) {
            log.error(e);
        } finally {
            dir.close();
        }
        return name;
    }

    //si
    private DirContext AuthenticateLP() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty("principal", PRINCIPAL)); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty("credential", PASSWORD));
        DirContext ctx = new InitialDirContext(env);
        return ctx;
    }

    //si
    private String getCNFromLogin(String login) {
        DirContext dir = null;
        NamingEnumeration answers = null;
        try {

            dir = AuthenticateLP();

            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String name = props.getProperty("base", BASE);
            answers = dir.search(name, "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls);
            return ((SearchResult) answers.next()).getName() + "," + props.getProperty("base", BASE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dir != null) {
                try {
                    dir.close();
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    //si
    private User checkUser(User user, Attributes atts, String login) {
        javax.naming.directory.Attribute att = atts.get("extensionattribute6");
        if (att != null) {
            try {
                Object value = att.get();
                if (value != null) {
                    String rfc = value.toString().toLowerCase();
                    Iterator<User> users = userRep.listUsers();
                    while (users.hasNext()) {
                        User usr = users.next();
                        if (rfc.equalsIgnoreCase(usr.getLogin())) {
                            user = usr;
                            user.setLogin(login);
                            break;
                        }
                    }


                    rfc = value.toString().toUpperCase();
                    users = userRep.listUsers();
                    while (users.hasNext()) {
                        User usr = users.next();
                        if (rfc.equalsIgnoreCase(usr.getLogin())) {
                            user = usr;
                            user.setLogin(login);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        return user;
    }

    //si
    @Override
    public boolean syncUser(String login, User user) {
        log.trace("Syncing User:" + login + "-" + user);
        boolean ret = false;
        try {
            Attributes att = getUserAttributes(login);

            log.trace("Attrs: " + att);
            if (null != att && att.size() > 0) {
                if (null == user) {
                    user = checkUser(user, att, login);
                    if (null == user) {
                        user = userRep.createUser();
                        user.setLogin(login);
                        user.setActive(true);
                    }
                }
                loadAttrs2RecUser(att, user);
                ret = true;

            }
        } catch (NamingException ex) {
            log.debug("Error Syncing a User: " + login, ex);
        }

        return ret;
    }
    //si

    @Override
    public boolean validateCredential(String login, Object credential) {
        return AuthenticateLP(login, credential);
    }

    //si
    private boolean AuthenticateLP(String login, Object credential) {
        String validos = null;
        String restringidos = null;
        UserRepository rep = userRep;
        String imprimir2 = null;

        String ouLogin;
        String[] arregloValidos = null;
        String[] arregloRestringidos = null;
        User u = userRep.getUserByLogin(login);
        List<String> arrRestringidos = new ArrayList<String>();
        List<String> arr = new ArrayList<String>();

        List<String> arrRes = new ArrayList<String>();

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, props.getProperty("factory", "com.sun.jndi.ldap.LdapCtxFactory"));
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://localhost"));
        env.put(Context.SECURITY_PRINCIPAL, getCNFromLogin(login));
        env.put(Context.SECURITY_CREDENTIALS, credential);
        UserGroup imprimir;


        try {
            DirContext ctx = new InitialDirContext(env);
            ctx.close();
            ouLogin = getOUFromLogin(login);

            if (props.get("filterAccept") != null) {
                validos = props.get("filterAccept").toString().toLowerCase();
            }

            if (props.get("exception") != null) {
                restringidos = props.get("exception").toString().toLowerCase();
            }
            //validar String validos
            if (validos != null) {
                arregloValidos = validos.split(",");
                arr = arreglos(arregloValidos, ouLogin);
            }
            if (restringidos != null) {
                arregloRestringidos = restringidos.split(",");
                arrRestringidos = arreglos(arregloRestringidos, ouLogin);
            }

            //obtiene a el padre            
            if (rep.getUserGroup(ouLogin) != null) {
                imprimir = rep.getUserGroup(ouLogin).getParent();

                if (imprimir != null) {
                    imprimir2 = imprimir.getId();
                    if (arregloRestringidos != null) {
                        arrRes = arreglos(arregloRestringidos, imprimir2);
                    }
                }
                if (arrRes != null) {
                    Iterator i = arrRes.iterator();
                    while (i.hasNext()) {
                        arrRestringidos.add(i.next().toString());
                    }
                }
            }

         return filtros(validos, restringidos, login, ouLogin,arr, arrRestringidos,u);

        } catch (NamingException e) {
            log.error("Syncing Users for: " + userRep.getId(), e);
            return false;
        }
    }

    public boolean filtros(String validos, String restringidos, String login, String ouLogin,  List<String> arr,  List<String> arrRestringidos, User u) throws NamingException{

        if (validos != null && restringidos == null) {
                if (arr.isEmpty()) {
                    return false;
                } else {
                    createGroupUser(login, u, ouLogin);
                }
                return true;

            } else if (validos == null && restringidos != null) {
                if (arrRestringidos.isEmpty()) {
                    createGroupUser(login, u, ouLogin);
                    return true;
                } else {
                    return false;
                }

            } else if (validos != null && restringidos != null) {
                if (arrRestringidos.isEmpty()) {
                    if (!arr.isEmpty()) {
                        createGroupUser(login, u, ouLogin);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                createGroupUser(login, u, ouLogin);
                return true;
            }
    }


    public List<String> arreglos(String[] arreglo, String ouLogin) {
        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < arreglo.length; i++) {
            if (ouLogin.toLowerCase().equals(arreglo[i].toLowerCase())) {
                arr.add(arreglo[i]);
            }
        }
        return arr;
    }
    //si

    public Attributes getUserAttributes(String login) throws NamingException {
        DirContext ctx = new InitialDirContext(getPropertiesHash());
        String[] attrIDs = {
            "*"
        };
        Attributes answer = null;

        String cn = getCNFromLogin(login);

        answer = ctx.getAttributes(cn, attrIDs);

        ctx.close();
        return answer;
    }

    private Hashtable getPropertiesHash() {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, props.getProperty("factory", "com.sun.jndi.ldap.LdapCtxFactory"));
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://localhost"));
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty("principal", ""));
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty("credential", ""));
        return env;
    }

    @Override
    public void syncUsers() {
        try {
            NamingEnumeration ne = getUserList();
            String currLog;
            while (ne.hasMore()) {
                SearchResult sr = (SearchResult) ne.next();
                currLog = (String) sr.getAttributes().get(seekField).get();
                userRep.getUserByLogin(currLog);
            }
        } catch (NamingException ex) {
            log.error("Syncing Users for: " + userRep.getId(), ex);
        }
    }

    //si
    private NamingEnumeration getUserList() throws NamingException {
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

        ctx.close();
        return answers;
    }

    //si
    public void loadAttrs2RecUser(Attributes attrs, User ru) {

        try {
            if (!"null".equals(fieldFirstName)) {
                ru.setFirstName((String) attrs.get(fieldFirstName).get());
            }
        } catch (Exception ne) {
        }
        try {
            if (!"null".equals(fieldLastName)) {
                ru.setLastName((String) attrs.get(fieldLastName).get());
            }
        } catch (Exception ne) {
        }
        try { //If there is no middlename go on
            if (!"null".equals(fieldMiddleName)) {
                ru.setSecondLastName((String) attrs.get(fieldMiddleName).get());
            }
        } catch (Exception ne) {
        }
        try {
            if (!"null".equals(fieldEmail)) {
                ru.setEmail((String) attrs.get(fieldEmail).get());
            }
        } catch (Exception ne) {
        }
        // If there is no language keep the default
        try {
            if (valueLanguage.startsWith("|")) {
                ru.setLanguage(valueLanguage.substring(1));
            } else {
                ru.setLanguage((String) attrs.get(valueLanguage).get());
            }
        } catch (Exception ne) {
        }

    }

    public HashSet getAllManagerRuta() {
        DirContext dir = null;
        NamingEnumeration answers = null;
        HashSet map = new HashSet();
        HashSet map1 = new HashSet();

        try {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            //recuperar una enumeracion con todos los atributos

            SearchControls ctls = new SearchControls(); //metodo de java, recuperar, peticion de atributos
            ctls.setReturningAttributes(new String[]{
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + "))", ctls); //recibe nombre, filtro y un search

            while (answers.hasMore()) {
                String name;
                name = ((SearchResult) answers.next()).getAttributes().get("manager").toString();

                if (name == null) {
                    name = "";
                }
                int inicio = name.indexOf(",");
                String ma = name.substring(inicio + 1);
                //System.out.println(ma);
                map.add(ma);
            }

            Iterator z = map.iterator();
            int inicio1;
            String ruta;

            while (z.hasNext()) {
                ruta = z.next().toString();
                inicio1 = ruta.indexOf(",");
                map1.add(ruta.substring(inicio1 + 1));
                //System.out.println(ruta.substring(inicio1+1));
            }

        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                dir.close();
            } catch (Exception e2) {
                log.error(e2);
            }
        }
        return map;
    }

    public String getManagerLogin(String login) {
        DirContext dir = null;

        NamingEnumeration answers = null;
        String managerRuta = null;
        String ruta = null;
        String ruta1 = null;

        try {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            //recuperar una enumeracion con todos los atributos

            SearchControls ctls = new SearchControls(); //metodo de java, recuperar, peticion de atributos
            ctls.setReturningAttributes(new String[]{
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls); //recibe nombre, filtro y un search

            managerRuta = ((SearchResult) answers.next()).getAttributes().get("manager").toString();

            int inicio = managerRuta.indexOf(",");
            ruta = managerRuta.substring(inicio + 1);

            int inicio1 = ruta.indexOf(",");
            ruta1 = ruta.substring(inicio1 + 1);

        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                dir.close();
            } catch (Exception e2) {
                log.error(e2);
            }
        }
        return ruta1;
    }
}
