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

public class Autentificacion extends ExtUserRepInt{

    NamingEnumeration answers = null;
    List dependen = new ArrayList();
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
    private static final String INTRANETURI = "http://www.infotec.com.mx/intranet#";
    private static final String BASE = "dc=maxcrc,dc=com";
    private static final String PRINCIPAL = "cn=manager,dc=maxcrc,dc=com";
    private static final String HOST = "localhost";
    private static final String PASSWORD = "secret";
    private static final int PORT = 389;
    static Logger log = SWBUtils.getLogger(Autentificacion.class);
       List datos = new ArrayList();
      

    public Autentificacion()
    {     
        props = SWBUtils.TEXT.getPropertyFile("/genericLDAP.properties"); //archivo de configuracion externa
        this.userObjectClass = props.getProperty("userObjectClass", "person"); //clase objeto para buscar usuario
        this.seekField = props.getProperty("seekField", "sAmAccountName");// campo llave para busqueda

    }

    public Autentificacion(UserRepository UserRep, Properties props)
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

   
  

  javax.naming.directory.Attributes atts = null;
  List<String> imprimir = new ArrayList<String>() ;

  //Devuelve una lista con los 5 campos del usuario loggeado
     public List uniqueUser(String login)
    {
         
        DirContext dir = null;
        String nombre = "";
        String nombre1 ="";
        String nombre2="";
        String noEmpleado = "";
        String areaAdscripcion = "";
        String puesto ="";
        String nivel ="";
        String extension ="";

        
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
          //recuperar una enumeracion con todos los atributos
            SearchControls ctls = new SearchControls(); //metodo de java, recuperar, peticion de atributos
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls); //recibe nombre, filtro y un search
                     
           
            atts = ((SearchResult) answers.next()).getAttributes();
          
            nombre1 =  atts.get("givenName").get().toString();
            nombre2 =  atts.get("sn").get().toString();
            nombre = nombre1+" "+nombre2;
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


              Iterator ii = imprimir.iterator();

            datos.add("Nombre");
            datos.add("No. Empleado");
            datos.add("Area Adscripción");
            datos.add("Puesto");
            datos.add("Nivel");
            datos.add("Extension");

            while (ii.hasNext()) {
                for (int x = 0; x < datos.size(); x++) {
                    System.out.println(datos.get(x) + ":" + " " + ii.next() + "\n");
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

    
 String atributo;
 //metodo que devuelve una lista de usuarios subordinados al loggeado
     public List getSubordinados(String login)
    {
        DirContext dir = null;
         

        try
        {
            dir = AuthenticateLP();
           
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
           //recuperar una enumeracion con todos los atributos

            SearchControls ctls = new SearchControls(); //metodo de java, recuperar, peticion de atributos
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

             answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + "))", ctls); //recibe nombre, filtro y un search
             
                   while(answers.hasMore()){
                    
                      javax.naming.directory.Attributes attss = ((SearchResult) answers.next()).getAttributes();
                       if(attss.get("manager")!= null){
                       atributo = attss.get("manager").get().toString();
                   
                        atributo = "";
                       }else{

                       atributo ="";
                       }

                       if(atributo.equals(login)){
                        dependen.add(attss);
                       }

                   }



            Iterator iterator = dependen.iterator();


           System.out.println("Subordinados");
         while( iterator.hasNext() ) {


                Attributes xx = (Attributes) iterator.next(); //Obtengo el elemento contenido
                              System.out.print(xx.get("givenName").get() + " " + xx.get("sn").get());
                              System.out.println();


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
        return dependen;
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

    
    @Override
    public boolean validateCredential(String login, Object credential)
    {
        return AuthenticateLP(login, credential);
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
        }
        catch (NamingException e)
        {
            return false;
        }
        return true;
    }


    public static void main(String args[]) throws IOException{
        String login ="jaki";

         Autentificacion i = new Autentificacion();
         i.uniqueUser(login);

         i.getSubordinados(login);



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
            e.printStackTrace();
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
    public boolean syncUser(String string, User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }






}

