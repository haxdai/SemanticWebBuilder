/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources.sem.base;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.PartialResultException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.UserRepository;

/**
 *
 * @author gabriela.rosales
 */
public class Autentificacion
{
    public static String GENERICLDAP_PROPERTIES = "/genericLDAP.properties";
    //public static final String PREFIX_INMUJERES="@inmujeres.local";

    public static String PREFIX_INMUJERES = "@inmujeres.local";
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
    //NamingEnumeration answers = null;

    static
    {

        try
        {
            String ip = InetAddress.getLocalHost().toString();
            //System.out.println("ip: "+ip);
            if (ip.startsWith("gdnps.infotec.com.mx"))
            {
                GENERICLDAP_PROPERTIES="/genericLDAPInmujeres.properties";
                PREFIX_INMUJERES = "";
            }
            else
            {
                GENERICLDAP_PROPERTIES="/genericLDAP.properties";
                PREFIX_INMUJERES = "@inmujeres.local";
                
            }

        }
        catch (Exception e)
        {
            GENERICLDAP_PROPERTIES="/genericLDAP.properties";
            PREFIX_INMUJERES = "@inmujeres.local";
            
        }
    }

    public Autentificacion()
    {

        //System.out.println("PREFIX_INMUJERES: "+PREFIX_INMUJERES);

        props = SWBUtils.TEXT.getPropertyFile(GENERICLDAP_PROPERTIES); //archivo de configuracion externa
        this.userObjectClass = props.getProperty("userObjectClass", "person"); //clase objeto para buscar usuario
        this.seekField = props.getProperty("seekField", "sAmAccountName");// campo llave para busqueda

    }

    public Autentificacion(String properties)
    {
        props = SWBUtils.TEXT.getPropertyFile(properties); //archivo de configuracion externa
        this.userObjectClass = props.getProperty("userObjectClass", "person"); //clase objeto para buscar usuario
        this.seekField = props.getProperty("seekField", "sAmAccountName");// campo llave para busqueda

    }

    public static String getNivel(String nivel)
    {
        StringBuilder sb = new StringBuilder();
        if (Character.isDigit(nivel.toCharArray()[0]))
        {
            return nivel;
        }
        for (Character _char : nivel.toCharArray())
        {
            if (!Character.isDigit(_char))
            {
                sb.append(_char);
            }
        }
        return sb.toString();
    }

    //Devuelve una lista con los 5 campos del usuario loggeado
    public UserLogin getCamposLogin(String login)
    {
        String login_user = login;
        if (login.indexOf("@") == -1)
        {
            login += PREFIX_INMUJERES;
        }

        DirContext dir = null;
        javax.naming.directory.Attributes atts = null;
        UserLogin userLogin = new UserLogin();

        try
        {
            dir = AuthenticateLP();

            SearchControls ctls = new SearchControls(); //metodo de java, recuperar, peticion de atributos
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login_user + "))", ctls); //recibe nombre, filtro y un search

            if (answers.hasMoreElements())
            {
                atts = answers.next().getAttributes();

                /*if (atts.get("departmentNumber") != null && atts.get("departmentNumber").get() != null)
                {
                    userLogin.setAreaAdscripcion(atts.get("departmentNumber").get().toString());
                }*/
                if (atts.get("department") != null && atts.get("department").get() != null)
                {
                    userLogin.setAreaAdscripcion(atts.get("department").get().toString());
                }
                if (atts.get("telephoneNumber") != null && atts.get("telephoneNumber").get() != null)
                {
                    userLogin.setExtension(atts.get("telephoneNumber").get().toString());
                }
                if (atts.get("description") != null && atts.get("description").get() != null)
                {
                    String nivel = atts.get("description").get().toString();
                    nivel = getNivel(nivel);
                    userLogin.setNivel(nivel);
                }
                if (atts.get("initials") != null && atts.get("initials").get() != null)
                {
                    userLogin.setNoEmpleado(atts.get("initials").get().toString());
                }
                
                
                if (atts.get("title") != null && atts.get("title").get() != null)
                {
                    userLogin.setPuesto(atts.get("title").get().toString());
                }
                if (atts.get("givenName") != null && atts.get("givenName").get() != null)
                {
                    userLogin.setNombre(atts.get("givenName").get().toString() + " " + atts.get("sn").get().toString());
                }
                if (atts.get("pager") != null && atts.get("pager").get() != null)
                {
                    userLogin.setRfc(atts.get("pager").get().toString());
                }
            }
            else
            {
                log.error("No se encontro el usuario: login:" + login + " loginuser:" + login_user);
            }
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            try
            {
                dir.close();
            }
            catch (Exception e2)
            {
                log.error(e2);
            }
        }
        return userLogin;
    }

    //metodo que devuelve una lista de usuarios subordinados al loggeado
    public List<UserSubordinado> getSubordinados(String login)
    {
        List<UserSubordinado> getSubordinados = new ArrayList<UserSubordinado>();
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();

            String cn = getCNFromLogin(login);


            NamingEnumeration<SearchResult> answers = null;
            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""), "(&(objectClass=" + userObjectClass + ")(manager=" + cn + "))", ctls);
            String uid = null;
            String givenName = null;
            String sn = null;
            while (answers.hasMore())
            {
                SearchResult result = answers.next();

                if (result.getAttributes().get(seekField) != null)
                {

                    if (result.getAttributes().get(seekField) != null && result.getAttributes().get(seekField).get() != null)
                    {
                        uid = result.getAttributes().get(seekField).get().toString();
                        int pos = uid.indexOf("@");
                        if (pos != -1)
                        {
                            uid = uid.substring(0, pos);
                        }
                    }
                    else
                    {
                        uid = "";
                    }
                    if (result.getAttributes().get("givenName") != null && result.getAttributes().get("givenName").get() != null)
                    {
                        givenName = result.getAttributes().get("givenName").get().toString();

                    }
                    else
                    {
                        givenName = "";
                    }

                    if (result.getAttributes().get("sn") != null && result.getAttributes().get("sn").get() != null)
                    {
                        sn = result.getAttributes().get("sn").get().toString();

                    }
                    else
                    {
                        sn = "";
                    }

                    UserSubordinado us = new UserSubordinado(uid, givenName + " " + sn);
                    getSubordinados.add(us);

                }
            }
        }
        catch (PartialResultException pne)
        {
            //log.debug(pne);
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            try
            {
                dir.close();
            }
            catch (Exception e2)
            {
                log.error(e2);
            }
        }
        return getSubordinados;
    }

    private DirContext AuthenticateLP() throws NamingException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.REFERRAL, "follow");
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty("principal", PRINCIPAL)); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty("credential", PASSWORD));
        DirContext ctx = new InitialDirContext(env);
        return ctx;
    }

    private String getCNFromLogin(String login)
    {
        DirContext dir = null;
        NamingEnumeration answers = null;
        try
        {
            dir = AuthenticateLP();
            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String name = props.getProperty("base", BASE);
            answers = dir.search(name, "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls);
            return ((SearchResult) answers.next()).getName() + "," + props.getProperty("base", BASE);

        }
        catch (PartialResultException ue)
        {
            //log.debug(ue);
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            if (dir != null)
            {
                try
                {
                    dir.close();
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        return null;
    }

    public static void main(String args[]) throws IOException
    {
        String login = "oscar.gutierrez";
        String nivel = "27";
        nivel = getNivel(nivel);

        Autentificacion i = new Autentificacion();
        List<UserSubordinado> us = new ArrayList<UserSubordinado>();
        us = i.getSubordinados(login);

        Iterator ii = us.iterator();

        while (ii.hasNext())
        {
            System.out.println(ii.next());
        }


    }
}
