/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.infotec.intranet.login;

import com.infotec.cvi.swb.TipoContratacion;
import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.SWProfile;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticProperty;

import org.semanticwb.security.auth.ExtUserRepInt;

/**
 *
 * @author victor.lorenzana
 */
public class IntranetLoginBrigde extends ExtUserRepInt
{

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
    private static final String BASE = "DC=wininfotec,DC=com,DC=mx";
    private static final String PRINCIPAL = "CN=Arturo Ortega Atristain,OU=Dirección Adjunta Competitividad,OU=Corporativo,DC=wininfotec,DC=com,DC=mx";
    private static final String HOST = "192.168.105.126";
    private static final String PASSWORD = "1qaz!QAZ";
    private static final int PORT = 389;
    static Logger log = SWBUtils.getLogger(IntranetLoginBrigde.class);

    public IntranetLoginBrigde(UserRepository UserRep, Properties props)
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

    public void loadAttrs2RecUserInit(Attributes attrs, User ru)
    {

        try
        {
            if (!"null".equals(fieldFirstName))
            {
                ru.setFirstName((String) attrs.get(fieldFirstName).get());
            }
        }
        catch (Exception ne)
        {
        }
        try
        {
            if (!"null".equals(fieldLastName))
            {
                ru.setLastName((String) attrs.get(fieldLastName).get());
            }
        }
        catch (Exception ne)
        {
        }
        try
        { //If there is no middlename go on
            if (!"null".equals(fieldMiddleName))
            {
                ru.setSecondLastName((String) attrs.get(fieldMiddleName).get());
            }
        }
        catch (Exception ne)
        {
        }
        try
        {
            if (!"null".equals(fieldEmail))
            {
                ru.setEmail((String) attrs.get(fieldEmail).get());
            }
        }
        catch (Exception ne)
        {
        }
        // If there is no language keep the default
        try
        {
            if (valueLanguage.startsWith("|"))
            {
                ru.setLanguage(valueLanguage.substring(1));
            }
            else
            {
                ru.setLanguage((String) attrs.get(valueLanguage).get());
            }
        }
        catch (Exception ne)
        {
        }

    }

    public void loadAttrs2RecUser(javax.naming.directory.Attributes attrs, User ru)
    {
        loadAttrs2RecUserInit(attrs, ru); // Agrega fieldFirstName , fieldLastName , fieldMiddleName , fieldEmail ,valueLanguage

        WebSite parentWebSite = ru.getUserRepository().getParentWebSite();
        if (ru.getUserRepository().getId().equals(SWBContext.getAdminRepository().getId()))
        {
            parentWebSite = SWBContext.getAdminWebSite();
        }

        Persona persona = Persona.ClassMgr.getPersona(ru.getId(), parentWebSite);
        if (persona == null)
        {
            persona = Persona.ClassMgr.createPersona(ru.getId(), parentWebSite);
            persona.setOwner(ru);
        }


        SWProfile profile = SWProfile.ClassMgr.getSWProfile(ru.getId(), parentWebSite);
        if (profile == null)
        {
            profile = SWProfile.ClassMgr.createSWProfile(ru.getId(), parentWebSite);
            profile.setCreator(ru);
        }
        else
        {
            profile.setCreator(ru);
        }
        // debe agregar los campos restantes

        /**
         *
         * extensionattribute1	1er Nombre
        extensionattribute2	2do Nombre
        extensionattribute3	1er Apellido //Ya
        extensionattribute4	2do Apellido //YA
        extensionattribute5	CURP
        extensionattribute6	RFC
        extensionattribute7	Genero
        extensionattribute8	Área de adscripción
         *
         *
        Nombre –givenName	String                      YA
        primer apellido – Se está separando	String      YA
        segundo apellido – Se está separando	String      YA
        nombre para mostrar -displayName	String      N/A para intranet
        tipo de contratación -description	Catálogo    YA
        puesto/función - title	Catálogo                    YA
        correo electrónico -mail	String              YA
        sede - streetAddress	Catálogo                    YA
        área de adscripción -department	Catálogo            YA/ se utilizo la OU
        nombre de inicio de sesión de usuario - samaccountname	String  N/A
        Rfc 	String                                      YA
        Curp	String                                      YA
        Género	Catálogo                                    ya
        Extensión telefónica - telephoneNumber	integer(4) ya
        Ubicación - physicalDeliveryOfficeName	Catálogo    ya

        Número especialidad	Catálogo    ExtensionAttribute9   //YA
        Número proyecto	Catálogo            ExtensionAttribute10  //YA
        número de empleado	Integer   employeeNumber  //YA
         * 
         *
         *
         *
        En lista de distribución de personal interno	Boolean N/A
        en lista de distribución en sitio	Boolean         N/A
        Acceso a project server	Boolean                         N/A
        
        Número de área	Catálogo        Cambiarlo a la Unidad Organizacional
        
        Foto	Binario
        jefe inmediato	objeto da
         *
         */
        setTipoContratacion(attrs, ru); // ya
        setPuesto(attrs, ru, profile);   // ya
        setSede(attrs, ru);             //ya
        setArea(attrs, ru);             // ya
        setNoEmpleado(attrs, ru);       // YA
        //setNoArea(attrs, ru);
        setRFC(attrs, ru);              // ya
        setCURP(attrs, ru, persona);   // ya
        setGerenero(attrs, ru, persona); //ya
        setExtTel(attrs, ru);           //Ya
        setUbicacion(attrs, ru, profile); //ya
        setMunExpecialidad(attrs, ru); //Ya
        setNumProyecto(attrs, ru);  //YA
        setManager(attrs, ru);

        /*UserGroup Empleado_insitu = UserGroup.ClassMgr.getUserGroup("Empleado_insitu", userRep);
        if(Empleado_insitu!=null)
        {
        if(!ru.hasUserGroup(Empleado_insitu))
        {
        ru.addUserGroup(Empleado_insitu);

        }
        }*/
    }

    private User fillBasicUser(String login, User ru)
    {
        DirContext dir = null;
        User user = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            NamingEnumeration<SearchResult> answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls);



            javax.naming.directory.Attributes atts = answers.next().getAttributes();
            if (!ru.getUserRepository().hasUser(login))
            {
                user = ru.getUserRepository().createUser(login);
                loadAttrs2RecUserInit(atts, ru);
            }
            // nombre,


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
        return user;
    }

    private void removeOUGroups(User ru)
    {
        GenericIterator<UserGroup> groups = ru.listUserGroups();
        while (groups.hasNext())
        {
            UserGroup group = groups.next();
            if (group!=null && group.getId()!=null && group.getId().startsWith("OU:"))
            {
                ru.removeUserGroup(group);
            }
        }
    }

    private void setManager(Attributes attrs, User ru)
    {
        try
        {
            javax.naming.directory.Attribute att = attrs.get("manager");
            if (att != null && att.get() != null)
            {
                String cnManager = att.get().toString();
                String login = getLogin(cnManager);
                if (login != null)
                {
                    int pos = login.indexOf(":");
                    if (pos != -1)
                    {
                        login = login.substring(pos + 1).trim();
                    }
                    final String uri = INTRANETURI + "manager";
                    SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);
                    User manager = ru.getUserRepository().getUserByLogin(login);
                    if (manager == null)
                    {

                        manager = fillBasicUser(login, ru);
                    }
                    if (prop != null && manager != null && manager.getSemanticObject() != null)
                    {
                        //ru.setExtendedAttribute(prop, manager);
                        ru.getSemanticObject().setObjectProperty(prop, manager.getSemanticObject());
                    }
                    if (prop != null && manager == null) // en caso de que ya no tenga manager
                    {
                        ru.getSemanticObject().removeProperty(prop);
                    }

                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setUbicacion(Attributes attrs, User ru, SWProfile profile)
    {

        //tipo de contratación
        try
        {
            javax.naming.directory.Attribute att = attrs.get("physicalDeliveryOfficeName");
            if (att != null && att.get() != null)
            {
                String ubicacion = att.get().toString();
                profile.setUbicacion(ubicacion);

                /*SemanticProperty prop = null;
                try
                {
                ru.setExtendedAttribute(prop, tipo);
                }
                catch (Exception e)
                {
                log.error(e);
                }*/
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setNoEmpleado(Attributes attrs, User ru)
    {


        try
        {
            javax.naming.directory.Attribute objextensionName = attrs.get("employeeNumber");
            if (objextensionName != null)
            {
                String ext = objextensionName.get().toString();
                final String uri = INTRANETURI + "noe";
                SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);

                try
                {
                    Integer iext = Integer.valueOf(ext);
                    ru.setExtendedAttribute(prop, iext);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setMunExpecialidad(Attributes attrs, User ru)
    {


        try
        {
            javax.naming.directory.Attribute objextensionName = attrs.get("ExtensionAttribute9");
            if (objextensionName != null)
            {
                String ext = objextensionName.get().toString();
                final String uri = INTRANETURI + "numespecialidad";
                SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);

                try
                {

                    int pos = ext.indexOf(" ");
                    if (pos != -1)
                    {
                        ext = ext.substring(0, pos).trim();
                    }
                    Integer iext = Integer.valueOf(ext);
                    ru.setExtendedAttribute(prop, iext);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setNumProyecto(Attributes attrs, User ru)
    {


        try
        {
            javax.naming.directory.Attribute objextensionName = attrs.get("ExtensionAttribute10");
            if (objextensionName != null)
            {
                String ext = objextensionName.get().toString();
                final String uri = INTRANETURI + "numproyecto";
                SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);

                try
                {
                    Integer iext = Integer.valueOf(ext);
                    ru.setExtendedAttribute(prop, iext);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setExtTel(Attributes attrs, User ru)
    {


        try
        {
            javax.naming.directory.Attribute objextensionName = attrs.get("homePhone");
            if (objextensionName != null)
            {
                String ext = objextensionName.get().toString();
                final String uri = INTRANETURI + "extension";
                SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);

                try
                {
                    Integer iext = Integer.valueOf(ext);
                    ru.setExtendedAttribute(prop, iext);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setGerenero(Attributes attrs, User ru, Persona persona)
    {

        //tipo de contratación
        try
        {
            Attribute att = attrs.get("extensionattribute7");
            if (att != null && att.get() != null)
            {
                String tipo = att.get().toString();
                Boolean gender = GENERO.getGenero(tipo);
                persona.setGenero(gender);
            }
            else
            {
                log.error("El usuario " + ru.getLogin() + " no tiene genero en el DA");
            }

        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setCURP(Attributes attrs, User ru, Persona persona)
    {

        //tipo de contratación
        try
        {
            Attribute att = attrs.get("extensionattribute5");
            if (att != null && att.get() != null)
            {
                String curp = att.get().toString();
                persona.setCurp(curp);
            }
            else
            {
                log.error("El usuario " + ru.getLogin() + " no tiene curp en el DA");
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setRFC(Attributes attrs, User ru)
    {

        //tipo de contratación
        try
        {
            Attribute att = attrs.get("extensionattribute6");
            if (att != null && att.get() != null)
            {
                String rfc = att.get().toString();

                final String uri = INTRANETURI + "rfc";
                SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);
                try
                {
                    ru.setExtendedAttribute(prop, rfc);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
            else
            {
                log.error("El usuario " + ru.getLogin() + " no tiene rfc en el DA");
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private String getLogin(String cn) throws Exception
    {
        String name = null;

        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            NamingEnumeration<SearchResult> answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(distinguishedName=" + cn + "))", ctls);


            name =  answers.next().getAttributes().get(seekField).toString();
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            dir.close();
        }
        return name;
    }

    private String getNameOU(String OU) throws Exception
    {
        String name = null;
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", "organizationalUnit"));
            NamingEnumeration<SearchResult> answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=organizationalUnit)(ou=" + OU + "))", ctls);


            name = answers.next().getAttributes().get("name").toString();
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            dir.close();
        }
        return name;
    }

    private String getNumberOU(String OU) throws Exception
    {
        String name = null;
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", "organizationalUnit"));
            NamingEnumeration<SearchResult> answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=organizationalUnit)(ou=" + OU + "))", ctls);
            if (answers.hasMore())
            {
                SearchResult result = answers.next();
                if (result != null && result.getAttributes().get("description") != null)
                {
                    name = result.getAttributes().get("description").toString();
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            dir.close();
        }
        return name;
    }

    private void setArea(Attributes attrs, User ru)
    {

        String cn = getCNFromLogin(ru.getLogin());
        int pos = cn.indexOf("OU");

        if (pos != -1)
        {
            int pos2 = cn.indexOf(",", pos + 1);
            if (pos != -1)
            {
                String OU = cn.substring(pos + 2, pos2);
                if (OU.startsWith("="))
                {
                    OU = OU.substring(1);
                }
                try
                {
                    String numarea = getNumberOU(OU);
                    String name = getNameOU(OU);
                    pos = name.indexOf(":");
                    if (pos != -1)
                    {
                        name = name.substring(pos + 1).trim();
                    }
                    if (numarea != null)
                    {
                        pos = numarea.indexOf(":");
                        if (pos != -1)
                        {
                            numarea = numarea.substring(pos + 1).trim();
                        }
                        final String uri = INTRANETURI + "noarea";
                        SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);
                        ru.setExtendedAttribute(prop, numarea);
                    }
                    else
                    {
                        log.error("La OU " + OU + " no tiene numero de ou (campo description)");
                    }
                    addUserGroups(cn, ru);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }

    }

    private void addUserGroups(String cn, User ru)
    {
        removeOUGroups(ru);
        StringTokenizer st = new StringTokenizer(cn, ",");
        String lastOU = null;
        while (st.hasMoreTokens())
        {
            String value = st.nextToken();
            if (value.startsWith("OU"))
            {

                int pos = value.indexOf("=");
                if (pos != -1)
                {
                    String OU = value.substring(pos + 1).trim();

                    try
                    {
                        String title = getNameOU(OU);
                        if (title != null)
                        {
                            pos = title.indexOf(":");
                            if (pos != -1)
                            {
                                title = title.substring(pos + 1).trim();
                            }
                            UserGroup ougroup = checkUserGroup(OU, title, userRep);
                            if (lastOU != null)
                            {
                                String titleLastOU = getNameOU(lastOU);
                                UserGroup lastOUGroup = checkUserGroup(lastOU, titleLastOU, userRep);
                                lastOUGroup.setParent(ougroup);
                            }
                            if (lastOU == null)
                            {
                                asignUserGroup(ougroup, ru);
                            }
                            lastOU = OU;
                        }
                    }
                    catch (Exception e)
                    {
                        log.error(e);
                    }
                }
            }
        }
    }

    private void asignUserGroup(UserGroup ougroup, User ru)
    {
        if (ougroup != null)
        {
            if (!ru.hasUserGroup(ougroup))
            {
                ru.addUserGroup(ougroup);
            }
        }
    }

    private UserGroup checkUserGroup(String id, String title, UserRepository rep)
    {
        UserGroup ug = null;
        id = "OU:" + id;
        if (!UserGroup.ClassMgr.hasUserGroup(id, rep))
        {
            ug = UserGroup.ClassMgr.createUserGroup(id, rep);
        }
        else
        {
            ug = UserGroup.ClassMgr.getUserGroup(id, rep);
        }
        ug.setTitle(title);
        return ug;
    }

    private void setSede(Attributes attrs, User ru)
    {

        //tipo de contratación
        try
        {
            javax.naming.directory.Attribute objstreetAddres = attrs.get("streetAddress");
            if (objstreetAddres != null)
            {
                String streetAddress = objstreetAddres.get().toString();
                final String uri = INTRANETURI + "sede";
                SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);
                try
                {
                    ru.setExtendedAttribute(prop, streetAddress);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setPuesto(Attributes attrs, User ru, SWProfile profile)
    {

        //tipo de contratación
        try
        {
            javax.naming.directory.Attribute otitle = attrs.get("title");
            if (otitle != null)
            {
                String puesto = otitle.get().toString();
                profile.setPuesto(puesto);
            }

            /*final String uri=INTRANETURI+"puesto";
            SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);
            try
            {
            ru.setExtendedAttribute(prop, tipo);
            }
            catch (Exception e)
            {
            log.error(e);
            }*/
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void setTipoContratacion(Attributes attrs, User ru)
    {

        //tipo de contratación
        try
        {
            javax.naming.directory.Attribute att = attrs.get("employeeType");
            if (att != null)
            {
                Object obj = att.get();
                if (obj != null)
                {
                    String tipo = obj.toString();
                    final String uri = INTRANETURI + "tipoContratacion";
                    Integer iTipo = Services.getTipo(tipo);
                    WebSite parentWebSite = ru.getUserRepository().getParentWebSite();
                    if (ru.getUserRepository().getId().equals(SWBContext.getAdminRepository().getId()))
                    {
                        parentWebSite = SWBContext.getAdminWebSite();
                    }
                    TipoContratacion objTipo = TipoContratacion.ClassMgr.getTipoContratacion(iTipo.toString(), parentWebSite);
                    if (objTipo == null)
                    {
                        objTipo = TipoContratacion.ClassMgr.createTipoContratacion(iTipo.toString(), parentWebSite);
                        objTipo.setTitle(tipo);
                    }
                    SemanticProperty prop = ru.getSemanticObject().getModel().getSemanticProperty(uri);

                    try
                    {
                        ru.setExtendedAttribute(prop, objTipo);
                    }
                    catch (Exception e)
                    {
                        log.error(e);
                    }
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private DirContext AuthenticateLP() throws ServiceException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty("principal", PRINCIPAL)); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty("credential", PASSWORD));
        try
        {
            DirContext ctx = new InitialDirContext(env);
            return ctx;
        }
        catch (NamingException e)
        {
            throw new ServiceException(null, e, null);
        }
    }

    private String getCNFromLogin(String login)
    {
        DirContext dir = null;
        NamingEnumeration<SearchResult> answers = null;
        try
        {

            dir = AuthenticateLP();

            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String name = props.getProperty("base", BASE);
            answers = dir.search(name, "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls);
            String nameUser=answers.next().getName();
            return nameUser + "," + props.getProperty("base", BASE);
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

    private User checkUser(User user, Attributes atts, String login)
    {
        javax.naming.directory.Attribute att = atts.get("extensionattribute6");
        if (att != null)
        {
            try
            {
                Object value = att.get();
                if (value != null)
                {
                    String rfc = value.toString().toLowerCase();
                    Iterator<User> users = userRep.listUsers();
                    while (users.hasNext())
                    {
                        User usr = users.next();
                        if (rfc.equalsIgnoreCase(usr.getLogin()))
                        {
                            user = usr;
                            user.setLogin(login);
                            break;
                        }
                    }


                    rfc = value.toString().toUpperCase();
                    users = userRep.listUsers();
                    while (users.hasNext())
                    {
                        User usr = users.next();
                        if (rfc.equalsIgnoreCase(usr.getLogin()))
                        {
                            user = usr;
                            user.setLogin(login);
                            break;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
        return user;
    }

    @Override
    public boolean syncUser(String login, User user)
    {
        log.trace("Syncing User:" + login + "-" + user);
        boolean ret = false;
        try
        {
            Attributes att = getUserAttributes(login);
            log.trace("Attrs: " + att);
            if (null != att && att.size() > 0)
            {
                if (null == user)
                {
                    user = checkUser(user, att, login);
                    if (null == user)
                    {
                        user = userRep.createUser();
                        user.setLogin(login);
                        user.setActive(true);
                    }
                }
                loadAttrs2RecUser(att, user);
                ret = true;
            }
        }
        catch (NamingException ex)
        {
            log.debug("Error Syncing a User: " + login, ex);
        }

        return ret;
    }

    @Override
    public boolean validateCredential(String login, Object credential)
    {
//        String lcred = null;
//        if (credential instanceof char[]) lcred= new String((char[])credential);
//        else lcred = (String)credential;
        return AuthenticateLP(login, credential);
    }

    private boolean AuthenticateLP(String login, Object credential)
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                props.getProperty("factory", "com.sun.jndi.ldap.LdapCtxFactory"));
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://localhost"));

        //env.put(Context.SECURITY_PRINCIPAL, getCNFromLogin(login));
        env.put(Context.SECURITY_PRINCIPAL, login);

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

    @Override
    public void syncUsers()
    {
        try
        {
            NamingEnumeration<SearchResult> ne = getUserList();
            String currLog;
            while (ne.hasMore())
            {
                SearchResult sr = ne.next();
                currLog = (String) sr.getAttributes().get(seekField).get();
                userRep.getUserByLogin(currLog);
            }
        }
        catch (NamingException ex)
        {
            log.error("Syncing Users for: " + userRep.getId(), ex);
        }
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
        ctls.setReturningAttributes(new String[]
                {
                    seekField
                });
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        answers = ctx.search(props.getProperty("base", ""),
                "objectClass=" + userObjectClass, ctls);        
        ctx.close();
        return answers;
    }
}
