/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources.sem.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import javax.naming.Context;
import org.semanticwb.Logger;
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
import org.semanticwb.security.auth.ExtUserRepInt;

/**
 *
 * @author gabriela.rosales
 */
public class Autentificacion extends ExtUserRepInt
{

    protected UserRepository userRep;
    protected Properties props;
    protected String seekField;
    protected String userObjectClass;
    protected String fieldFirstName;
    protected String fieldLastName;
    protected String fieldMiddleName;
    protected String fieldEmail;
    protected String valueLanguage;
    private static final String BASE = "dc=maxcrc,dc=com";
    private static final String PRINCIPAL = "cn=manager,dc=maxcrc,dc=com";
    private static final String HOST = "localhost";
    private static final String PASSWORD = "secret";
    private static final int PORT = 389;
    static Logger log = SWBUtils.getLogger(Autentificacion.class);
    //NamingEnumeration answers = null;

    public Autentificacion()
    {
        props = SWBUtils.TEXT.getPropertyFile("/genericLDAP.properties"); //archivo de configuracion externa
        this.userObjectClass = props.getProperty("userObjectClass", "person"); //clase objeto para buscar usuario
        this.seekField = props.getProperty("seekField", "sAmAccountName");// campo llave para busqueda

    }

    //Devuelve una lista con los 5 campos del usuario loggeado
    public List getCamposLogin(String login)
    {

        DirContext dir = null;
        List<String> imprimir = new ArrayList<String>();
        javax.naming.directory.Attributes atts = null;
        String nombre = "";
        String nombre1 = "";
        String nombre2 = "";
        String noEmpleado = "";
        String areaAdscripcion = "";
        String puesto = "";
        String nivel = "";
        String extension = "";

        List<String> datos = new ArrayList<String>();
        datos.add("Nombre");
        datos.add("No. Empleado");
        datos.add("Area Adscripción");
        datos.add("Puesto");
        datos.add("Nivel");
        datos.add("Extension");


        try
        {
            dir = AuthenticateLP();

            SearchControls ctls = new SearchControls(); //metodo de java, recuperar, peticion de atributos
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls); //recibe nombre, filtro y un search


            atts = ((SearchResult) answers.next()).getAttributes();

            nombre1 = atts.get("givenName").get().toString();
            nombre2 = atts.get("sn").get().toString();
            nombre = nombre1 + " " + nombre2;
            noEmpleado = atts.get("initials").get().toString();
            areaAdscripcion = atts.get("departmentNumber").get().toString();
            puesto = atts.get("title").get().toString();
            nivel = atts.get("description").get().toString();
            extension = atts.get("telephoneNumber").get().toString();

            imprimir.add(nombre);
            imprimir.add(noEmpleado);
            imprimir.add(areaAdscripcion);
            imprimir.add(puesto);
            imprimir.add(nivel);
            imprimir.add(extension);

            Iterator i = imprimir.iterator();

            while (i.hasNext())
            {
                for (int x = 0; x < datos.size(); x++)
                {
                    System.out.println(datos.get(x) + ":" + " " + i.next() + "\n");
                }
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
        return imprimir;
    }

    //metodo que devuelve una lista de usuarios subordinados al loggeado
    public List<String> getSubordinados(String login)
    {
        List<String> getSubordinados = new ArrayList<String>();
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            String cn = getCNFromLogin(login);
            NamingEnumeration<SearchResult> answers=null;
            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        seekField
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),"(&(objectClass=" + userObjectClass + ")(manager="+ cn +"))", ctls);
            while(answers.hasMore())
            {
                SearchResult result=answers.next();
                if(result.getAttributes().get(seekField)!=null)
                {
                    String loginSubordinado=result.getAttributes().get(seekField).toString();
                    getSubordinados.add(loginSubordinado);
                }
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
        return getSubordinados;
    }
    /*public void getSubordinados(String login) {
    DirContext dir = null;
    String atributo = null;
    String atributoManager;
    int posicionCnLogin;
    String cnLoginComparar = null;
    List<Attributes> dependen = new ArrayList<Attributes>();

    try {
    dir = AuthenticateLP();

    SearchControls ctls = new SearchControls(); //metodo de java, recuperar, peticion de atributos
    ctls.setReturningAttributes(new String[]{
    "*"
    });
    ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

    answers = dir.search(props.getProperty("base", ""),
    "(&(objectClass=" + userObjectClass + "))", ctls); //recibe nombre, filtro y un search

    while (answers.hasMore()) {

    javax.naming.directory.Attributes attss = ((SearchResult) answers.next()).getAttributes();

    if (attss.get("manager") != null) {
    atributoManager = attss.get("manager").get().toString();
    int posicion = obtenerUltimaPosicion(atributoManager);
    atributo = atributoManager.substring(3, posicion);

    String cnLogin = getCNFromLogin(login);

    posicionCnLogin = obtenerUltimaPosicion(cnLogin);

    cnLoginComparar = cnLogin.substring(3, posicionCnLogin);

    }
    if (cnLoginComparar.equals(atributo)) {
    dependen.add(attss);
    }
    }

    Iterator iterator = dependen.iterator();

    System.out.println("Subordinados:");
    while (iterator.hasNext()) {
    Attributes xx = (Attributes) iterator.next(); //Obtengo el elemento contenido
    System.out.print(xx.get("givenName").get() + " " + xx.get("sn").get());
    System.out.println();
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

    }*/

    public int obtenerUltimaPosicion(String cadena)
    {
        char c;
        int i;
        int z = 0;

        for (i = 0; i < cadena.length(); i++)
        {
            c = cadena.charAt(i);
            if (c == 44)
            {
                z = i;
                break;
            }
        }
        return z;
    }

    private DirContext AuthenticateLP() throws NamingException
    {

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
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

    @Override
    public void syncUsers()
    {
    }

    @Override
    public boolean syncUser(String string, User user)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean validateCredential(String login, Object credential)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String args[]) throws IOException
    {
        String login = "ana";

        Autentificacion i = new Autentificacion();
        i.getCamposLogin(login);
        i.getSubordinados(login);


    }
}
