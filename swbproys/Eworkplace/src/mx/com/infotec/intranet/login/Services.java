/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.infotec.intranet.login;

import com.infotec.cvi.swb.util.UtilsCVI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;

/**
 *
 * @author victor.lorenzana
 */
public class Services
{

    private static String HOST = "192.168.105.126";
    private static final String PASSWORD = "123456";
    private static final int PORT = 389;
    public static final EnumMap<FIELD, String> names = new EnumMap(FIELD.class);
    static Logger log = SWBUtils.getLogger(Services.class);
    private static final String BASE = "DC=wininfotec,DC=com,DC=mx";
    private static final String PRINCIPAL = "CN=Actualiza ad,OU=Direccion Ejecutiva,OU=Corporativo,DC=wininfotec,DC=com,DC=mx";
    private Properties props;
    private String userObjectClass;
    private String seekField;

    static
    {

        names.put(FIELD.PRIMER_NOMBRE, "extensionattribute1");
        names.put(FIELD.SEGUNDO_NOMBRE, "extensionattribute2");

        names.put(FIELD.NOMBRE_JUNTO, "givenName");
        names.put(FIELD.PRIMER_APELLIDO, "extensionattribute3");
        names.put(FIELD.SEGUNDO_APELLIDO, "extensionattribute4");
        names.put(FIELD.APELLIDOS_JUNTOS, "sn");
        names.put(FIELD.TIPO_CONTRATACION, "employeeType");
        names.put(FIELD.CORREO_ELECTRONICO, "mail");
        names.put(FIELD.NO_EMPLEADO, "employeeNumber");
        names.put(FIELD.CURP, "extensionattribute5");
        names.put(FIELD.RFC, "extensionattribute6");
        names.put(FIELD.ESPECIALIDAD, "ExtensionAttribute9");
        names.put(FIELD.GENERO, "extensionattribute7");



        names.put(FIELD.PROYECTO, "ExtensionAttribute10");
        names.put(FIELD.EXT_TEL, "telephoneNumber");
        names.put(FIELD.EMAIL, "email");
        names.put(FIELD.JEFE_INMEDIATO, "manager");
        names.put(FIELD.PUESTO_FUNCION, "title");
        names.put(FIELD.SEDE, "streetAddress");
    }

    public Services()
    {
        props = SWBUtils.TEXT.getPropertyFile("/genericLDAP.properties");
        this.userObjectClass = props.getProperty("userObjectClass", "person");
        this.seekField = props.getProperty("seekField", "sAmAccountName");
        try
        {
            URL url=new URL(props.getProperty("url"));
            HOST=url.getHost();

        }
        catch(Exception e)
        {

        }
    }

    public static String getName(FIELD field)
    {
        if (names.containsKey(field))
        {
            return names.get(field);
        }
        else
        {
            return field.toString();
        }
    }

    public void checkAdd(String login, String correo, String rfc, String curp, Integer noEmpleado) throws ServiceException
    {
        if (existsUser(login))
        {
            throw new ServiceException("El login ya existe: " + login, login);
        }
        if (correo != null && existsEmail(correo))
        {
            throw new ServiceException("El email ya existe: " + login, login);
        }
        if (existsCURP(correo))
        {
            throw new ServiceException("El CURP ya existe: " + login, login);
        }
        if (noEmpleado != null && existsNoEmpleado(noEmpleado))
        {
            throw new ServiceException("El No. empleado ya existe: " + login, login);
        }
        if (existsRFC(rfc))
        {
            throw new ServiceException("El rfc ya existe: " + login, login);
        }
    }

    private String getUserDN(String username, String ou)
    {
        return new StringBuffer().append("uid=").append(username).append(",").append(ou).toString();
    }

    public String getLoginByRFC(String rfc) throws Exception
    {
        String name = null;
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            NamingEnumeration answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + getName(FIELD.RFC) + "=" + rfc + "))", ctls);



            name = ((SearchResult) answers.next()).getAttributes().get(seekField).toString();
            if (name != null)
            {
                int pos = name.indexOf(":");
                if (pos != -1)
                {
                    name = name.substring(pos + 1).trim();
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

    public String getLoginByCURP(String curp) throws Exception
    {
        String name = null;
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            NamingEnumeration answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=" + userObjectClass + ")(" + getName(FIELD.CURP) + "=" + curp + "))", ctls);



            name = ((SearchResult) answers.next()).getAttributes().get(seekField).toString();
            if (name != null)
            {
                int pos = name.indexOf(":");
                if (pos != -1)
                {
                    name = name.substring(pos + 1).trim();
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

    private String getOU(String area) throws Exception
    {
        String name = null;
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", "organizationalUnit"));
            NamingEnumeration answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=organizationalUnit)(description=" + area + "))", ctls);


            name = ((SearchResult) answers.next()).getAttributes().get("distinguishedName").toString();
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

    private String getCNOU(String OU) throws Exception
    {
        String name = null;
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", "organizationalUnit"));
            NamingEnumeration answers = null;

            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = dir.search(props.getProperty("base", ""),
                    "(&(objectClass=organizationalUnit)(ou=" + OU + "))", ctls);


            name = ((SearchResult) answers.next()).getName();
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

    public void add(UserInformation user, String intranetID, String extranetWebSiteID, String candidateLogin) throws ServiceException
    {

        if (user.getLogin() == null)
        {
            throw new ServiceException("El login es nulo, no se puede dar de alta el usuario");
        }
        String managerUpdate = user.getJefeInmediato();
        if (managerUpdate != null && !managerUpdate.toLowerCase().startsWith("cn="))
        {
            String cnManager = getCNFromLogin(managerUpdate);
            user.setJefeInmediato(cnManager);
        }
        String area = String.valueOf(user.getArea());
        try
        {
            String ou = getOU(area);
            if (ou == null)
            {
                throw new ServiceException("El número de área no existe");
            }
            int pos = ou.indexOf(":");
            if (pos != -1)
            {
                ou = ou.substring(pos + 1).trim();
            }

            user.check();
            checkAdd(user.getLogin(), user.getEmail(), user.getRFC(), user.getCURP(), user.getNoEmpleado());

            try
            {
                String host = props.getProperty("url").replace("ldap", "http");
                URL url = new URL(host);
                host = url.getHost();
                String principal = props.getProperty("principal", PRINCIPAL);
                String password = props.getProperty("password", PASSWORD);
                String givenName = user.getPrimerNombre();
                if (user.getSegundoNombre() != null)
                {
                    givenName += " " + user.getSegundoNombre();
                }
                String displayName = user.getPrimerNombre();
                if (user.getSegundoNombre() != null)
                {
                    displayName += " " + user.getSegundoNombre();
                }
                if (user.getPApellido() != null)
                {
                    displayName += " " + user.getPApellido();
                }
                if (user.getSApellido() != null)
                {
                    displayName += " " + user.getSApellido();
                }
                String apellidos = "";
                if (user.getPApellido() != null)
                {
                    apellidos += " " + user.getPApellido();
                }
                if (user.getSApellido() != null)
                {
                    apellidos += " " + user.getSApellido();
                }
                Map<String, String> atts = user.getMapAttributes();
                String sAMAccountname = user.getLogin();

                LDAPManager manager = new LDAPManager(props.getProperty("url"), principal, password);
                String domain = getDomain();
                manager.addUser(domain, user.getLogin(), givenName, user.getPApellido(), user.getLogin(), ou, apellidos, displayName, sAMAccountname, atts);
                try
                {
                    WebSite siteIntranet = WebSite.ClassMgr.getWebSite(intranetID);
                    WebSite siteExtranet = WebSite.ClassMgr.getWebSite(extranetWebSiteID);
                    if (siteIntranet != null && siteExtranet != null)
                    {
                        UserRepository repo = siteIntranet.getUserRepository();
                        org.semanticwb.model.User userRepo = repo.createUser();
                        userRepo.setLogin(user.getLogin());
                        userRepo.setActive(true);
                        String name = user.getPrimerNombre();
                        if (user.getSegundoNombre() != null)
                        {
                            name += " " + user.getSegundoNombre();
                        }
                        userRepo.setFirstName(name);
                        userRepo.setLastName(user.getPApellido());
                        userRepo.setSecondLastName(user.getSApellido());
                        org.semanticwb.model.User userCand = siteExtranet.getUserRepository().getUserByLogin(candidateLogin);
//                        org.semanticwb.model.User usIntranet = siteIntranet.getUserRepository().getUserByLogin(user.getLogin());
                        if (userCand != null && userRepo != null)
                        {
                            UtilsCVI.copyUser(userCand, siteExtranet, userRepo, siteIntranet);
                        }
                    }
                }
                catch (Exception e)
                {
                    log.error(e);
                }

            }
            catch (Exception e)
            {
                log.error(e);
                throw new ServiceException("No se puede agregar usuario", e);
            }
        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede agregar usuario", e);
        }
    }

    public void removeUserByRFC(String rfc, String site) throws ServiceException
    {
        String ou = getCNFromRFC(rfc);
        try
        {
            String host = props.getProperty("url").replace("ldap", "http");
            URL url = new URL(host);
            host = url.getHost();
            String principal = props.getProperty("principal", PRINCIPAL);
            String password = props.getProperty("credential", PASSWORD);
            LDAPManager manager = new LDAPManager(host, PORT, principal, password);
            String login = getLoginByRFC(rfc);
            manager.setOU(ou);
            manager.deleteUser(ou);
            removeUserFromSite(site, login);




        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public void removeUserByCURP(String curp, String site) throws ServiceException
    {
        String ou = getCNFromCURP(curp);
        try
        {
            String host = props.getProperty("url").replace("ldap", "http");
            URL url = new URL(host);
            host = url.getHost();
            String principal = props.getProperty("principal", PRINCIPAL);
            String password = props.getProperty("credential", PASSWORD);
            LDAPManager manager = new LDAPManager(host, PORT, principal, password);
            String login = getLoginByCURP(curp);
            manager.setOU(ou);
            manager.deleteUser(ou);
            removeUserFromSite(site, login);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void removeUserFromSite(String siteId, String login)
    {
        WebSite site = WebSite.ClassMgr.getWebSite(siteId);
        if (site != null)
        {
            UserRepository rep = site.getUserRepository();
            Iterator<org.semanticwb.model.User> users = rep.listUsers();
            while (users.hasNext())
            {
                org.semanticwb.model.User user = users.next();
                if (user.getLogin().equals(login))
                {
                    user.setActive(false);
                    break;
                }
            }

        }
    }

    public void remove(String login, String site) throws ServiceException
    {

        String ou = getCNFromLogin(login);
        try
        {
            String host = props.getProperty("url").replace("ldap", "http");
            URL url = new URL(host);
            host = url.getHost();
            String principal = props.getProperty("principal", PRINCIPAL);
            String password = props.getProperty("credential", PASSWORD);
            LDAPManager manager = new LDAPManager(host, PORT, principal, password);
            manager.setOU(ou);
            manager.deleteUser(ou);
            removeUserFromSite(site, login);


        }
        catch (Exception e)
        {
            log.error(e);
        }

    }

    public void modifyEmail(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("El email no puede ser nulo");
        }
        modify(login, FIELD.CORREO_ELECTRONICO, value);
    }

    public void modifyExtension(String login, int value) throws ServiceException
    {
        if (value <= 0)
        {
            throw new ServiceException("La extensión no puede ser negativo o cero");
        }
        modify(login, FIELD.EXT_TEL, String.valueOf(value));
    }

    public void modifyPuesto(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("El puesto no puede ser nulo");
        }
        modify(login, FIELD.PUESTO_FUNCION, value);
    }

    public void modifyEspecialidad(String login, int value) throws ServiceException
    {
        if (value <= 0)
        {
            throw new ServiceException("El número de especialidad no puede ser negativo o cero");
        }
        modify(login, FIELD.ESPECIALIDAD, String.valueOf(value));
    }

    public void modifyRFC(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("El RFC no puede ser nulo");
        }
        modify(login, FIELD.RFC, value);
    }

    public void modifyCURP(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("El CURP no puede ser nulo");
        }
        modify(login, FIELD.CURP, value);
    }

    public void modifyApellidoPaterno(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("El apellido paterno no puede ser nulo");
        }
        try
        {
            Attributes atts = getUserAttributes(login);
            String sApellido = atts.get(getName(FIELD.SEGUNDO_APELLIDO)).get().toString();
            String nombre = atts.get(getName(FIELD.NOMBRE_JUNTO)).get().toString();
            String apellidos = value + " " + sApellido;
            Map<String, String> values = new HashMap<String, String>();
            String displayName = nombre + " " + apellidos;
            values.put("displayName", displayName);
            values.put("sn", apellidos);
            values.put(getName(FIELD.SEGUNDO_APELLIDO), value);
            modifyAttributes(values, login);
        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede modificar el nombre", e);
        }
    }

    public void modifyJefeInmediato(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("El jefe inmediato no puede ser nulo");
        }
        String managerCN = getCNFromLogin(value);
        modify(login, FIELD.JEFE_INMEDIATO, managerCN);
    }

    public void modifyNumProyecto(String login, int value) throws ServiceException
    {
        if (value <= 0)
        {
            throw new ServiceException("El número de proyecto no puede ser negativo o cero");
        }
        modify(login, FIELD.PROYECTO, String.valueOf(value));
    }

    public void modifyNumEmpleado(String login, int value) throws ServiceException
    {
        if (value <= 0)
        {
            throw new ServiceException("El número de empleado no puede ser cero o negativo");
        }
        modify(login, FIELD.NO_EMPLEADO, String.valueOf(value));
    }

    public void modifyGenero(String login, boolean genero) throws ServiceException
    {
        String value = "Hombre";
        if (genero)
        {
            value = "Hombre";
        }
        else
        {
            value = "Mujer";
        }
        modify(login, FIELD.GENERO, String.valueOf(value));
    }

    public void modifyArea(String login, int area) throws ServiceException
    {
        if (area <= 0)
        {
            throw new ServiceException("El área no puede ser cero o negativo");
        }
        String cn = getCNFromLogin(login);
        try
        {
            String newOU = getOU(String.valueOf(area));
            int pos = newOU.indexOf(":");
            if (pos != -1)
            {
                newOU = newOU.substring(pos + 1).trim();
            }

            pos = cn.indexOf(",");
            if (pos != -1)
            {
                String value = cn.substring(0, pos);
                String newCN = value + "," + newOU;
                DirContext dir = AuthenticateLP();
                dir.rename(cn, newCN);

            }
        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede asignar la nueva área " + area, e);
        }
    }

    public void modifySede(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("La sede no puede ser nulo");
        }
        modify(login, FIELD.SEDE, value);
    }

    public void modifyApellidoMaterno(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("El apellido materno no puede ser nulo");
        }
        try
        {
            Attributes atts = getUserAttributes(login);
            String pApellido = atts.get(getName(FIELD.PRIMER_APELLIDO)).get().toString();
            String nombre = atts.get(getName(FIELD.NOMBRE_JUNTO)).get().toString();
            String apellidos = pApellido + " " + value;
            Map<String, String> values = new HashMap<String, String>();
            String displayName = nombre + " " + apellidos;
            values.put("displayName", displayName);
            values.put("sn", apellidos);
            values.put(getName(FIELD.SEGUNDO_APELLIDO), value);
            modifyAttributes(values, login);
        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede modificar el nombre", e);
        }
    }

    private void modifyAttributes(Map<String, String> values, String login) throws ServiceException
    {
        try
        {
            DirContext ctx = AuthenticateLP(login);
            ModificationItem[] items = new ModificationItem[values.size()];
            int i = 0;
            for (String key : values.keySet())
            {
                String value = values.get(key);
                Attribute att = new BasicAttribute(key, value);
                items[i] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, att);
                i++;
            }
            String cn = getCNFromLogin(login);
            ctx.modifyAttributes(cn, items);
        }
        catch (Exception e)
        {
            throw new ServiceException("No se pueden modificar las propiedades de usuario " + login, e);
        }

    }

    public void modifyPrimerNombre(String login, String pNombre) throws ServiceException
    {
        if (pNombre == null)
        {
            throw new ServiceException("El primer nombre no puede ser nulo");
        }
        try
        {
            Attributes atts = getUserAttributes(login);
            String segundo_nombre = atts.get(getName(FIELD.SEGUNDO_NOMBRE)).get().toString();
            String apellidos = atts.get("sn").get().toString();
            String nombre_junto = pNombre + " " + segundo_nombre;
            String displayName = nombre_junto + " " + apellidos;
            Map<String, String> values = new HashMap<String, String>();
            values.put("displayName", displayName);
            values.put(getName(FIELD.PRIMER_NOMBRE), pNombre);
            values.put(getName(FIELD.NOMBRE_JUNTO), nombre_junto);
            modifyAttributes(values, login);

        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede modificar el nombre", e);
        }
    }

    public void modifySegundoNombre(String login, String sNombre) throws ServiceException
    {
        if (sNombre == null)
        {
            throw new ServiceException("El segundo nombre no puede ser nulo");
        }
        try
        {
            Attributes atts = getUserAttributes(login);
            String primer_nombre = atts.get(getName(FIELD.PRIMER_NOMBRE)).get().toString();
            String apellidos = atts.get("sn").get().toString();
            String nombre_junto = primer_nombre + " " + sNombre;
            String displayName = nombre_junto + " " + apellidos;
            Map<String, String> values = new HashMap<String, String>();
            values.put("displayName", displayName);
            values.put(getName(FIELD.SEGUNDO_NOMBRE), sNombre);
            values.put(getName(FIELD.NOMBRE_JUNTO), nombre_junto);
            modifyAttributes(values, login);

        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede modificar el nombre", e);
        }
    }

    public void modifyUbicacion(String login, String value) throws ServiceException
    {
        if (value == null)
        {
            throw new ServiceException("La ubicación no puede ser nulo");
        }
        modify(login, FIELD.UBICACION, value);
    }

    public void removeNoEmpleado(String login) throws ServiceException
    {
        try
        {
            DirContext ctx = AuthenticateLP(login);
            //ModificationItem[] items = new ModificationItem[1];
            Attribute att = new BasicAttribute(getName(FIELD.NO_EMPLEADO));
            Attributes atts = new BasicAttributes(true);
            atts.put(att);
            //items[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, att);
            String cn = getCNFromLogin(login);
            ctx.modifyAttributes(cn, DirContext.REMOVE_ATTRIBUTE, atts);
        }
        catch (Exception e)
        {
            throw new ServiceException("No se pueden eliminar el no. de empleado para usuario " + login, e);
        }
    }

    public void removeField(String login, FIELD field) throws ServiceException
    {
        try
        {
            DirContext ctx = AuthenticateLP(login);

            Attribute att = new BasicAttribute(getName(field));
            Attributes atts = new BasicAttributes(true);
            atts.put(att);
            String cn = getCNFromLogin(login);
            ctx.modifyAttributes(cn, DirContext.REMOVE_ATTRIBUTE, atts);
        }
        catch (Exception e)
        {
            throw new ServiceException("No se pueden eliminar el atributo " + field.toString() + " para usuario " + login, e);
        }
    }

    public void modifyTipoContratacion(String login, TIPO_CONTRATACION tipo) throws ServiceException
    {
        if (tipo == null)
        {
            throw new ServiceException("El tipo de contratación no puede ser nulo");
        }
        String value = tipo.toString().toLowerCase();
        modify(login, FIELD.TIPO_CONTRATACION, value);
    }

    public String getCNFromCURP(String curp)
    {
        DirContext dir = null;
        NamingEnumeration answers = null;
        try
        {

            dir = AuthenticateLP();

            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String name = props.getProperty("base", BASE);
            answers = dir.search(name, "(&(objectClass=" + userObjectClass + ")(" + getName(FIELD.CURP) + "=" + curp + "))", ctls);
            if (answers.hasMoreElements())
            {
                return ((SearchResult) answers.next()).getName() + "," + props.getProperty("base", BASE);
            }
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
                }
            }
        }
        return null;
    }

    public String getCNFromRFC(String rfc)
    {
        DirContext dir = null;
        NamingEnumeration answers = null;
        try
        {

            dir = AuthenticateLP();

            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String name = props.getProperty("base", BASE);
            answers = dir.search(name, "(&(objectClass=" + userObjectClass + ")(" + getName(FIELD.RFC) + "=" + rfc + "))", ctls);
            if (answers.hasMoreElements())
            {
                return ((SearchResult) answers.next()).getName() + "," + props.getProperty("base", BASE);
            }
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
                }
            }
        }
        return null;
    }

    public String getCNFromLogin(String login)
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
            if (answers.hasMoreElements())
            {
                return ((SearchResult) answers.next()).getName() + "," + props.getProperty("base", BASE);
            }
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
                }
            }
        }
        return null;
    }

    private String getDomain()
    {
        DirContext dir = null;

        try
        {

            dir = AuthenticateLP();
            String cn = props.get("principal").toString();
            String userPrincipalName = dir.getAttributes(cn).get("userPrincipalName").get().toString();
            int pos = userPrincipalName.indexOf("@");
            return userPrincipalName.substring(pos + 1);
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
                }
            }
        }
        return null;
    }

    public boolean existsUser(String login) throws ServiceException
    {
        DirContext ctx = AuthenticateLP();
        String name = getCNFromLogin(login);
        if (name != null)
        {
            try
            {
                Object obj = ctx.lookup(name);
                return true;
            }
            catch (Exception e)
            {
                log.trace(e);
            }
        }
        return false;
    }

    public boolean existsRFC(String rfc) throws ServiceException
    {
        DirContext ctx = AuthenticateLP();

        try
        {
            NamingEnumeration answers = null;
            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = ctx.search(props.getProperty("base", ""),
                    "(&(objectClass=" + props.getProperty("userObjectClass") + ")(" + getName(FIELD.RFC) + "=" + rfc + "))", ctls);

            return answers.hasMore();
        }
        catch (Exception e)
        {
            log.trace(e);
            return false;
        } finally
        {
            try
            {
                if (ctx != null)
                {
                    ctx.close();
                }
            }
            catch (Exception e)
            {
                log.error(e);

            }
        }
    }

    public void login(String login, String password) throws ServiceException
    {
        String cn = getCNFromLogin(login);
        AuthenticateLP(cn, password);
    }

    public static void main(String[] args)
    {


        int value2 = Integer.parseInt("01");
        Services s = new Services();

        UserInformation userInformation = new UserInformation();

        String login = "sergio.carrera";

        try
        {
            String ext = s.getNoExtension(login);
            s.getAdscripciones("jose.tamayo");
            s.getAdscripciones();

            Integer value = s.getAreaAdscripcion("jose.tamayo");
            System.out.println("area: " + value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
//        try
//        {
//            UserInformation info = s.getUserInformation(login);
//            s.getLoginByCURP("logv7312187c8hdfrnc03");
//            s.removeNoEmpleado(login);
//        }
//        catch (Exception e)
//        {
//            log.error(e);
//        }

        userInformation = new UserInformation();
        userInformation.setLogin(login);
        userInformation.setEmail("victor.lorenzana@infotec.com.mx");
        userInformation.setPrimerNombre("Víctor");
        userInformation.setSegundoNombre("Hugo");
        userInformation.setpApellido("Lorenzana");
        userInformation.setsApellido("González");
        userInformation.setTipoContratacion(TIPO_CONTRATACION.Nómina_Institucional);
        userInformation.setPuestoFuncion("Consultor");
        userInformation.setRFC("logv7312187c8");
        userInformation.setCurp("logv7312187c8hdfrnc03");
        userInformation.setEspecialidad(1);

        //
        userInformation.setJefeInmediatoByRFC("WISM7611203L6");
        userInformation.setJefeInmediatoByCURP("WISM761120MNERZR08");
        userInformation.setJefeInmediato("sandra.varela");
        userInformation.setNoempleado(679);
        userInformation.setProyecto(52);
        userInformation.setSede("INFOTEC");
        userInformation.setArea(72);
        userInformation.setGenero(GENERO.HOMBRE);


        try
        {
            s.add(userInformation, "eworkplace", "extranet", "reje.jara");

            /*s.modifyPrimerNombre(login, "Vic");
            s.modifySegundoNombre(login, "milito");
            s.modifyExtension(login, 4624);
            s.modifyGenero(login, false);
            s.modifyArea(login, 50);
            s.modifySede(login, "Aguscalientes");
            s.modifyNumEmpleado(login, 86);
            s.modifyNumProyecto(login, 777);
            s.modifyJefeInmediato(login, "patricia.guerrero");
            s.modifyEspecialidad(login, 4624);
            s.modifyCURP(login, "Nueva curp");
            s.modifyRFC(login, "Nueva rfc");


            s.modifyPrimerNombre(login, "Víctor");
            s.modifyApellidoPaterno(login, "Lore");
            s.modifyApellidoMaterno(login, "Gonzá");

            s.modifyTipoContratacion(login, TIPO_CONTRATACION.EVENTUAL);
            s.modifyPuesto(login, "Consultor Asistente");*/



            //s.login("victor.lorenzana", "victor.lorenzana");
        }
        catch (Exception e)
        {
            log.error(e);
        }

        /*try
        {

        s.remove("victor.lorenzana");
        }
        catch (Exception e)
        {
        log.error(e);
        }*/
    }

    public boolean existsNoEmpleado(Integer noEmpleado) throws ServiceException
    {


        DirContext ctx = AuthenticateLP();

        try
        {
            NamingEnumeration answers = null;
            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = ctx.search(props.getProperty("base", ""),
                    "(&(objectClass=" + props.getProperty("userObjectClass") + ")(" + getName(FIELD.NO_EMPLEADO) + "=" + noEmpleado + "))", ctls);

            return answers.hasMore();
        }
        catch (Exception e)
        {
            log.trace(e);
            return false;
        } finally
        {
            try
            {
                if (ctx != null)
                {
                    ctx.close();
                }
            }
            catch (Exception e)
            {
                log.error(e);

            }
        }
    }

    public boolean existsCURP(String curp) throws ServiceException
    {
        DirContext ctx = AuthenticateLP();

        try
        {
            NamingEnumeration answers = null;
            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = ctx.search(props.getProperty("base", ""),
                    "(&(objectClass=" + props.getProperty("userObjectClass") + ")(" + getName(FIELD.CURP) + "=" + curp + "))", ctls);

            return answers.hasMore();
        }
        catch (Exception e)
        {
            log.trace(e);
            return false;
        } finally
        {
            try
            {
                if (ctx != null)
                {
                    ctx.close();
                }
            }
            catch (Exception e)
            {
                log.error(e);

            }
        }

    }

    public boolean existsEmail(String email) throws ServiceException
    {
        DirContext ctx = AuthenticateLP();

        try
        {
            NamingEnumeration answers = null;
            SearchControls ctls = new SearchControls();
            ctls.setReturningAttributes(new String[]
                    {
                        "*"
                    });
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            answers = ctx.search(props.getProperty("base", ""),
                    "(&(objectClass=" + props.getProperty("userObjectClass") + ")(" + getName(FIELD.EMAIL) + "=" + email + "))", ctls);

            return answers.hasMore();
        }
        catch (Exception e)
        {
            log.trace(e);
            return false;
        } finally
        {
            try
            {
                if (ctx != null)
                {
                    ctx.close();
                }
            }
            catch (Exception e)
            {
                log.error(e);

            }
        }
    }

    private void modify(String login, FIELD field, String value) throws ServiceException
    {
        if (login == null)
        {
            throw new ServiceException("El login es nulo, no se puede modificar el usuario");
        }
        DirContext ctx = AuthenticateLP(login);
        // agrega el usuario
        try
        {
            String name = getCNFromLogin(login);
            ModificationItem[] items = new ModificationItem[1];
            BasicAttribute att = new BasicAttribute(Services.getName(field));
            att.add(value);
            items[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, att);
            ctx.modifyAttributes(name, items);
        }
        catch (NamingException e)
        {
            throw new ServiceException("No se puede agregar el usuario", e, login);
        } finally
        {
            try
            {
                if (ctx != null)
                {
                    ctx.close();
                }
            }
            catch (Exception e)
            {
                log.error(e);

            }
        }
    }

    private void modify(String login, FIELD field, Boolean value) throws ServiceException
    {
        if (login == null)
        {
            throw new ServiceException("El login es nulo, no se puede modificar el usuario");
        }
        DirContext ctx = AuthenticateLP(login);
        // agrega el usuario
        try
        {
            String name = getCNFromLogin(login);
            ModificationItem[] items = new ModificationItem[1];
            BasicAttribute att = new BasicAttribute(Services.getName(field));
            att.add(value);
            items[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, att);
            ctx.modifyAttributes(name, items);
        }
        catch (NamingException e)
        {
            throw new ServiceException("No se puede agregar el usuario", e, login);
        } finally
        {
            if (ctx != null)
            {
                try
                {
                    ctx.close();
                }
                catch (Exception e)
                {
                    log.error(e);

                }
            }
        }
    }

    private void modify(String login, FIELD field, Integer value) throws ServiceException
    {
        if (login == null)
        {
            throw new ServiceException("El login es nulo, no se puede modificar el usuario");
        }
        DirContext ctx = AuthenticateLP(login);
        // agrega el usuario
        try
        {
            String name = getCNFromLogin(login);
            ModificationItem[] items = new ModificationItem[1];
            BasicAttribute att = new BasicAttribute(Services.getName(field));
            att.add(value);
            items[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, att);
            ctx.modifyAttributes(name, items);
        }
        catch (NamingException e)
        {
            throw new ServiceException("No se puede agregar el usuario", e, login);
        } finally
        {
            if (ctx != null)
            {
                try
                {
                    ctx.close();
                }
                catch (Exception e)
                {
                    log.error(e);

                }
            }
        }
    }

    public boolean authenticateUser(String login, Object credential)
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        String cn = getCNFromLogin(login);
        env.put(Context.SECURITY_PRINCIPAL, cn); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, credential);
        try
        {
            DirContext ctx = new InitialDirContext(env);
            ctx.close();
        }
        catch (NamingException e)
        {
            log.error(e);
            return false;
        }
        return true;
    }

    public Attributes getUserAttributes(String login) throws NamingException, ServiceException
    {
        DirContext ctx = AuthenticateLP();
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

    private DirContext AuthenticateLP(String login) throws ServiceException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty("principal", PRINCIPAL)); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty("password", PASSWORD));
        try
        {
            DirContext ctx = new InitialDirContext(env);
            return ctx;
        }
        catch (NamingException e)
        {
            throw new ServiceException(null, e, login);
        }
    }

    private DirContext AuthenticateLP(String cn, String password) throws ServiceException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, cn); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, password);
        try
        {
            DirContext ctx = new InitialDirContext(env);
            return ctx;
        }
        catch (NamingException e)
        {
            throw new ServiceException("No se puede autenticar al usuario " + cn, e);
        }
    }

    private DirContext AuthenticateLP() throws ServiceException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        //env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty("principal", PRINCIPAL)); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty("password", PASSWORD));
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

    public static int getTipo(String desc)
    {
        if (desc.equalsIgnoreCase(TIPO_CONTRATACION.Eventual.toString()))
        {
            return 1;
        }
        else if (desc.equalsIgnoreCase(TIPO_CONTRATACION.Nómina_Institucional.toString()))
        {
            return 2;
        }
        else
        {
            return 3;
        }

    }

    public UserInformation getUserInformation(String login) throws ServiceException
    {
        String cn = getCNFromLogin(login);
        DirContext dir = null;
        UserInformation user = null;
        try
        {
            dir = AuthenticateLP();
            Attributes atts = dir.getAttributes(cn);
            user = new UserInformation();
            user.setLogin(login);
            if (atts.get(getName(FIELD.PRIMER_NOMBRE)) != null && atts.get(getName(FIELD.PRIMER_NOMBRE)).get() != null)
            {
                user.setPrimerNombre(atts.get(getName(FIELD.PRIMER_NOMBRE)).get().toString());
            }
            if (atts.get(getName(FIELD.SEGUNDO_NOMBRE)) != null && atts.get(getName(FIELD.SEGUNDO_NOMBRE)).get() != null)
            {
                user.setSegundoNombre(atts.get(getName(FIELD.SEGUNDO_NOMBRE)).get().toString());
            }
            if (atts.get(getName(FIELD.PRIMER_APELLIDO)) != null && atts.get(getName(FIELD.PRIMER_APELLIDO)).get() != null)
            {
                user.setpApellido(atts.get(getName(FIELD.PRIMER_APELLIDO)).get().toString());
            }
            if (atts.get(getName(FIELD.SEGUNDO_APELLIDO)) != null && atts.get(getName(FIELD.SEGUNDO_APELLIDO)).get() != null)
            {
                user.setsApellido(atts.get(getName(FIELD.SEGUNDO_APELLIDO)).get().toString());
            }
            if (atts.get(getName(FIELD.EMAIL)) != null && atts.get(getName(FIELD.EMAIL)).get() != null)
            {
                user.setEmail(atts.get(getName(FIELD.EMAIL)).get().toString());
            }
            if (atts.get(getName(FIELD.RFC)) != null && atts.get(getName(FIELD.RFC)).get() != null)
            {
                user.setRFC(atts.get(getName(FIELD.RFC)).get().toString());
            }
            if (atts.get(getName(FIELD.CURP)) != null && atts.get(getName(FIELD.CURP)).get() != null)
            {
                user.setCurp(atts.get(getName(FIELD.CURP)).get().toString());
            }
            if (atts.get(getName(FIELD.SEDE)) != null && atts.get(getName(FIELD.SEDE)).get() != null)
            {
                user.setSede(atts.get(getName(FIELD.SEDE)).get().toString());
            }
            if (atts.get(getName(FIELD.ESPECIALIDAD)) != null && atts.get(getName(FIELD.ESPECIALIDAD)).get() != null)
            {
                String esp = atts.get(getName(FIELD.ESPECIALIDAD)).get().toString();
                int pos = esp.indexOf(" ");
                if (pos != -1)
                {
                    esp = esp.substring(0, pos).trim();
                }
                user.setEspecialidad(Integer.parseInt(esp));
            }
            if (atts.get(getName(FIELD.NO_EMPLEADO)) != null && atts.get(getName(FIELD.NO_EMPLEADO)).get() != null)
            {
                user.setNoempleado(Integer.parseInt(atts.get(getName(FIELD.NO_EMPLEADO)).get().toString()));
            }
            if (atts.get(getName(FIELD.PROYECTO)) != null && atts.get(getName(FIELD.PROYECTO)).get() != null)
            {
                user.setProyecto(Integer.parseInt(atts.get(getName(FIELD.PROYECTO)).get().toString()));
            }
            if (atts.get(getName(FIELD.PUESTO_FUNCION)) != null && atts.get(getName(FIELD.PUESTO_FUNCION)).get() != null)
            {
                user.setPuestoFuncion(atts.get(getName(FIELD.PUESTO_FUNCION)).get().toString());
            }
            if (atts.get(getName(FIELD.TIPO_CONTRATACION)) != null && atts.get(getName(FIELD.TIPO_CONTRATACION)).get() != null)
            {
                String stipo = atts.get(getName(FIELD.TIPO_CONTRATACION)).get().toString().replace(' ', '_');
                if ("Institucional".equalsIgnoreCase(stipo))
                {
                    user.setTipoContratacion(TIPO_CONTRATACION.Nómina_Institucional);
                }
                else
                {
                    TIPO_CONTRATACION tipo = TIPO_CONTRATACION.valueOf(stipo);
                    user.setTipoContratacion(tipo);
                }

            }

            if (atts.get(getName(FIELD.GENERO)) != null && atts.get(getName(FIELD.GENERO)).get() != null)
            {
                String sgenero = atts.get(getName(FIELD.GENERO)).get().toString().toUpperCase();
                GENERO tipo = GENERO.valueOf(sgenero);
                user.setGenero(tipo);
            }
            StringTokenizer st = new StringTokenizer(cn, ",");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                if (token.startsWith("OU="))
                {
                    String OU = token.substring(3).trim();
                    String cnou = getCNOU(OU) + "," + props.getProperty("base", "");
                    if (dir.getAttributes(cnou) != null && dir.getAttributes(cnou).get("description") != null && dir.getAttributes(cnou).get("description").get() != null)
                    {
                        String description = dir.getAttributes(cnou).get("description").get().toString();
                        if (!description.isEmpty())
                        {
                            user.setArea(Integer.parseInt(description));
                        }
                    }
                    break;
                }
            }
            if (atts.get(getName(FIELD.JEFE_INMEDIATO)) != null && atts.get(getName(FIELD.JEFE_INMEDIATO)).get() != null)
            {
                String cnManager = atts.get(getName(FIELD.JEFE_INMEDIATO)).get().toString();
                String loginManager = dir.getAttributes(cnManager).get(seekField).toString();
                if (loginManager != null)
                {
                    int pos = loginManager.indexOf(":");
                    if (pos != -1)
                    {
                        loginManager = loginManager.substring(pos + 1).trim();
                    }
                }
                user.setSimpleJefeInmediato(loginManager);

            }

            /*userInformation.setLogin(login);
            userInformation.setEmail("victor.lorenzana@infotec.com.mx");
            userInformation.setPrimerNombre("Víctor");
            userInformation.setSegundoNombre("Hugo");
            userInformation.setpApellido("Lorenzana");
            userInformation.setsApellido("González");
            userInformation.setTipoContratacion(TIPO_CONTRATACION.Nómina_Institucional);
            userInformation.setPuestoFuncion("Consultor");
            userInformation.setRFC("logv7312187c8");
            userInformation.setCurp("logv7312187c8hdfrnc03");
            userInformation.setEspecialidad(1);

            //
            userInformation.setJefeInmediatoByRFC("WISM7611203L6");
            userInformation.setJefeInmediatoByCURP("WISM761120MNERZR08");
            userInformation.setJefeInmediato("sandra.varela");
            userInformation.setNoempleado(679);
            userInformation.setProyecto(52);
            userInformation.setSede("INFOTEC");
            userInformation.setArea(72);
            userInformation.setGenero(GENERO.HOMBRE);*/

        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede obtener el user information de " + login, e);
        } finally
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
        return user;
    }

    public List<Area> getAdscripciones() throws ServiceException
    {
        ArrayList<Area> areas = new ArrayList<Area>();
        DirContext dir = null;
        try
        {
            dir = AuthenticateLP();
            String ou = "Corporativo";
            String cnPrincipal = props.get("principal").toString();
            int pos = cnPrincipal.lastIndexOf("OU=");
            if (pos != -1)
            {
                cnPrincipal = cnPrincipal.substring(pos + 3);
            }
            pos = cnPrincipal.indexOf(",");
            if (pos != -1)
            {
                ou = cnPrincipal.substring(0, pos).trim();
            }



            String cn = getCNOU(ou) + "," + props.getProperty("base", "");
            Object obj = dir.lookup(cn);
            if (obj != null)
            {
                if (obj instanceof DirContext)
                {
                    Attributes matchAttrs = new BasicAttributes(true); // ignore case
                    matchAttrs.put(new BasicAttribute("objectClass", "organizationalUnit"));
                    NamingEnumeration answers = null;

                    SearchControls ctls = new SearchControls();
                    ctls.setReturningAttributes(new String[]
                            {
                                "*"
                            });
                    ctls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
                    answers = dir.search(cn,
                            "(&(objectClass=organizationalUnit))", ctls);
                    while (answers.hasMore())
                    {
                        SearchResult result = (SearchResult) answers.next();
                        Area area = new Area();

                        Object descr = result.getAttributes().get("description");
                        if (descr != null)
                        {

                            String value = descr.toString();
                            pos = value.indexOf(":");
                            if (pos != -1)
                            {
                                value = value.substring(pos + 1).trim();
                            }
                            try
                            {
                                Integer ivalue = Integer.parseInt(value);
                                area.area = ivalue;

                            }
                            catch (NumberFormatException nfe)
                            {
                                log.trace(nfe);
                            }


                        }

                        Object displayName = result.getAttributes().get("name");
                        if (displayName != null)
                        {

                            String value = displayName.toString();
                            pos = value.indexOf(":");
                            if (pos != -1)
                            {
                                value = value.substring(pos + 1).trim();
                            }
                            area.titulo = value;
                        }
                        areas.add(area);
                    }
                }
            }
        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede obtener lista de OU", e);
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

        return areas;
    }

    public List<Area> getAdscripciones(String login) throws ServiceException
    {
        ArrayList<Area> areas = new ArrayList<Area>();
        Integer lastNumber = null;
        String cn = getCNFromLogin(login);
        if (cn != null)
        {
            StringTokenizer st = new StringTokenizer(cn, ",");

            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                if (token.startsWith("OU="))
                {
                    String OU = token.substring(3).trim();
                    DirContext dir = null;
                    try
                    {
                        String cnOU = getCNOU(OU) + "," + props.getProperty("base", "");

                        dir = AuthenticateLP();

                        Attribute att = dir.getAttributes(cnOU).get("description");
                        if (att != null)
                        {
                            Area area = new Area();
                            Object value = att.get();
                            if (value != null)
                            {
                                lastNumber = Integer.parseInt(value.toString());
                                area.area = lastNumber;
                            }
                            att = dir.getAttributes(cnOU).get("name");
                            if (att != null)
                            {
                                value = att.get();
                                if (value != null)
                                {
                                    area.titulo = value.toString();
                                }
                            }
                            areas.add(area);
                        }




                    }
                    catch (Exception e)
                    {
                        throw new ServiceException("No se puede obtener atributos de OU : " + OU, e);
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
                }
            }
        }
        Collections.sort(areas, new Comparator<Area>()
        {

            @Override
            public int compare(Area o1, Area o2)
            {
                return o1.titulo.compareToIgnoreCase(o2.titulo);
            }
        });
        return areas;
    }

    public Integer getAreaAdscripcion(String login) throws ServiceException
    {
        Integer lastNumber = null;
        String cn = getCNFromLogin(login);
        if (cn != null)
        {
            StringTokenizer st = new StringTokenizer(cn, ",");

            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                if (token.startsWith("OU="))
                {
                    String OU = token.substring(3).trim();
                    DirContext dir = null;
                    try
                    {
                        String cnOU = getCNOU(OU) + "," + props.getProperty("base", "");

                        dir = AuthenticateLP();
                        Attribute att = dir.getAttributes(cnOU).get("description");
                        if (att != null)
                        {
                            Object value = att.get();
                            if (value != null)
                            {
                                lastNumber = Integer.parseInt(value.toString());
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        throw new ServiceException("No se puede obtener atributos de OU : " + OU, e);
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
                }
            }
        }
        return lastNumber;
    }

    public String getNoExtension(String login) throws ServiceException
    {
        String cn = getCNFromLogin(login);
        try
        {
            DirContext dir = AuthenticateLP();
            Attributes atts = dir.getAttributes(cn);
            Attribute att = atts.get(getName(FIELD.EXT_TEL));
            if (att != null && att.get() != null)
            {
                return att.get().toString();
            }
        }
        catch (Exception e)
        {
            throw new ServiceException("No se puede obtener el no. de extensión", e);
        }
        return null;
    }
}
