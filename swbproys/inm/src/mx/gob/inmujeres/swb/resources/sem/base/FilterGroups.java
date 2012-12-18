/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources.sem.base;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
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

/**
 *
 * @author gabriela.rosales
 */
public class FilterGroups {

    protected UserRepository userRep;
    protected Properties props;
    protected String seekField;
    protected String userObjectClass;
    private static final String BASE = "dc=maxcrc,dc=com";
    private static final String PRINCIPAL = "cn=manager,dc=maxcrc,dc=com";
    private static final String HOST = "localhost";
    private static final String PASSWORD = "secret";
    private static final int PORT = 389;
    static Logger log = SWBUtils.getLogger(Autentificacion.class);

    public FilterGroups() {
        props = SWBUtils.TEXT.getPropertyFile("/genericLDAP.properties"); //archivo de configuracion externa
        this.userObjectClass = props.getProperty("userObjectClass", "person"); //clase objeto para buscar usuario
        this.seekField = props.getProperty("seekField", "sAmAccountName");// campo llave para busqueda

    }

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

    public boolean validateCredential(String login, Object credential) {
        return AuthenticateLP(login, credential);
    }

    private boolean AuthenticateLP(String login, Object credential) {
        String cadena;
        String ouLogin;
        String[] arreglo;
        List<String> arr = new ArrayList<String>();
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, props.getProperty("factory", "com.sun.jndi.ldap.LdapCtxFactory"));
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://localhost"));
        env.put(Context.SECURITY_PRINCIPAL, getCNFromLogin(login));
        env.put(Context.SECURITY_CREDENTIALS, credential);

        try {
            DirContext ctx = new InitialDirContext(env);
            ctx.close();
            ouLogin = getOUFromLogin(login);
            System.out.println("OULOGIN:" + ouLogin);

            if (props.get("filterAccept") != null) {
                cadena = props.get("filterAccept").toString().toLowerCase();
            } else {
                return true;
            }
            System.out.println("FILTER ACCEPT:" + cadena);
            arreglo = cadena.split(",");

            for (int i = 0; i < arreglo.length; i++) {
                if (ouLogin.toLowerCase().equals(arreglo[i].toLowerCase())) {
                    arr.add(arreglo[i]);
                }
            }

            if (arr.isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (NamingException e) {
            return false;
        }
    }

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
            log.error(e);
        } finally {
            if (dir != null) {
                try {
                    dir.close();
                } catch (Exception ex) {
                    log.error(ex);
                }
            }
        }
        return null;
    }

    public static void main(String args[]) {
        String login = "ana";
        FilterGroups i = new FilterGroups();
        System.out.println(i.validateCredential(login, "ana"));
    }
}
