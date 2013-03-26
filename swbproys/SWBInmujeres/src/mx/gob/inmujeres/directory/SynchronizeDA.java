package mx.gob.inmujeres.directory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimerTask;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;

import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 *
 * @author victor.lorenzana
 */
public class SynchronizeDA extends TimerTask
{

    public static final Map<String, String> attsNames = new HashMap<String, String>();
    private static final Set<String> users = new HashSet<String>();
//    private static final String OU[] =
//    {
//        "OU=Normal,OU=Users,OU=INMUJERES,DC=inmujeres,DC=local", "OU=Power,OU=Normal,OU=Users,OU=INMUJERES,DC=Inmujeres,DC=local"
//    };
//    private static final String OUEXECPTIONS[] =
//    {
//        "OU=Special,OU=Normal,OU=Users,OU=INMUJERES,DC=Inmujeres,DC=local", "OU=Disabled,OU=Normal,OU=Users,OU=INMUJERES,DC=Inmujeres,DC=local"
//    };
    //private static final String OU="OU=Contraloria Interna,OU=Corporativo,DC=wininfotec,DC=com,DC=mx";
    private final List<String> filters = new ArrayList<String>();
    private final List<String> exceptions = new ArrayList<String>();

    static
    {
        // El primer nombre es el atributo en DA, el segundo valor es el campo a actualizar en la tabla
        //General
        attsNames.put("givenName", "givenName");
        attsNames.put("sn", "sn");
        attsNames.put("initials", "initials");
        attsNames.put("displayName", "displayName");
        attsNames.put("description", "description");
        attsNames.put("mail", "mail");
        attsNames.put("telephoneNumber", "telephoneNumber");
        attsNames.put("wWWHomePage", "url");
        attsNames.put("physicaldeliveryofficename", "physicaldeliveryofficename");


        //Address
        attsNames.put("street", "street");
        attsNames.put("co", "co"); // country
        attsNames.put("st", "st"); // estado
        attsNames.put("postOfficeBox", "postOfficeBox");
        attsNames.put("l", "l"); // city
        attsNames.put("postalCode", "postalCode");


        //Telephones
        attsNames.put("mobile", "mobile");
        attsNames.put("Ipphone", "Ipphone");
        attsNames.put("pager", "pager");
        attsNames.put("facsimileTelephoneNumber", "facsimileTelephoneNumber");
        attsNames.put("homePhone", "homePhone");


        //Organization
        attsNames.put("title", "title");
        attsNames.put("department", "department");
        attsNames.put("company", "company");
        attsNames.put("manager", "manager");
        attsNames.put("Directreports", "Directreports");
    }
    private String tableName;

    public SynchronizeDA(String tableName, String filters, String exceptions)
    {
        this.tableName = tableName;
        users.clear();
        if (filters != null)
        {
            StringTokenizer st = new StringTokenizer(filters, ";");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken().trim();
                if (token != null && !"".equals(token))
                {
                    this.filters.add(token);
                }

            }
        }
        if (exceptions != null)
        {
            StringTokenizer st = new StringTokenizer(exceptions, ";");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken().trim();
                if (token != null && !"".equals(token))
                {
                    this.exceptions.add(token);
                }

            }
        }
    }
    static Logger log = SWBUtils.getLogger(SynchronizeDA.class);

    private void procesaUsuario(Attributes atts)
    {
        Map<String, String> values = new HashMap<String, String>();
        try
        {
            String userKey = atts.get(Directorio.seekField).get().toString();
            users.add(userKey.toLowerCase());
            for (String key : attsNames.keySet())
            {
                try
                {
                    if (atts.get(key) != null)
                    {
                        Object obj = atts.get(key).get();
                        if (obj != null)
                        {
                            values.put(key, obj.toString());
                        }
                        else
                        {
                            log.warn("El valor del campo " + key + " es nulo para el usuario: " + userKey);
                        }
                    }
                    else
                    {
                        log.warn("El valor del campo: " + key + " es nulo para usuario: " + userKey);
                    }
                }
                catch (Exception e)
                {
                    log.error("No se puede actualizar los datos del usuario: " + userKey, e);
                }

            }
            actualizaInserta(values, userKey);
        }
        catch (Exception e)
        {
            log.error("No se puede actualizar los datos de usuario: ", e);
        }

    }

    private boolean addUser(Attributes atts)
    {
        boolean addUser = true;
        try
        {
            if (atts.get("distinguishedName") != null && atts.get("distinguishedName").get() != null)
            {
                String distinguishedName = atts.get("distinguishedName").get().toString();
                for (String ouex : exceptions)
                {
                    int pos = ouex.indexOf(",");
                    if (pos != -1)
                    {
                        String firstOU = ouex.substring(0, pos).trim();
                        if (distinguishedName.toLowerCase().indexOf(firstOU.toLowerCase()) != -1)
                        {
                            addUser = false;
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
        return addUser;
    }

    private void sincroniza(DirContext dir) throws ServiceException
    {
        log.info("Iniciando sincronización de usuarios a directorio...");

        SearchControls ctls = new SearchControls();
        ctls.setReturningAttributes(new String[]
                {
                    "*"
                });
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration answers = null;
        try
        {
            for (String ou : filters)
            {
                try
                {
                    answers = dir.search(ou, "(objectClass=" + Directorio.userObjectClass + ")", ctls);
                    if (!answers.hasMore())
                    {
                        log.warn("No se encontrarón usuarios en el DA");
                    }
                    while (answers.hasMore())
                    {
                        SearchResult result = (SearchResult) answers.next();
                        Attributes atts = result.getAttributes();
                        if (addUser(atts))
                        {
                            procesaUsuario(atts);
                        }
                    }
                }
                catch (Exception e)
                {
                    log.error("Error al buscar usuarios en DA", e);
                }
            }

        }
        catch (Exception e)
        {
            log.error("Error al buscar usuarios en DA", e);
        } finally
        {
            eliminaUser();
        }

        log.info("Finalización de sincronización de usuarios a directorio");

    }

    @Override
    public void run()
    {
        DirContext dir = null;
        try
        {
            dir = Directorio.AuthenticateLP();
            sincroniza(dir);
        }
        catch (Exception e)
        {
            log.error("Error tratando de sincronizar usuarios de DA", e);
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
                    log.error("Error tratando de cerrar conexión a DA", e);
                }
            }
        }
    }

    private boolean existeUser(String userKey)
    {
        boolean existeUser = false;
        Connection con = null;
        try
        {
            con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
            PreparedStatement ps = con.prepareStatement("Select * from " + tableName + " where " + "sAmAccountName=?");
            ps.setString(1, userKey);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                existeUser = true;
            }
            ps.close();
            rs.close();
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
        return existeUser;
    }

    private void actualizaInserta(Map<String, String> values, String userKey)
    {

        if (existeUser(userKey))
        {
            actualizaUser(values, userKey);
        }
        else
        {
            insertaUser(userKey);
            actualizaUser(values, userKey);
        }


    }

    public String getCNManager(String CNManager)
    {
        DirContext dir = null;
        //NamingEnumeration answers = null;
        try
        {

            dir = Directorio.AuthenticateLP();

            Attributes atts = dir.getAttributes(CNManager);
            return atts.get(Directorio.seekField).get().toString();
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

    private void actualizaUser(Map<String, String> values, String userKey)
    {
        for (String key : attsNames.keySet())
        {
            String columnName = attsNames.get(key);
            String value = values.get(key);
            if (value != null)
            {

                if (key.equalsIgnoreCase("manager") || key.equalsIgnoreCase("Directreports"))
                {
                    value = getCNManager(value);
                }

                Connection con = null;
                try
                {
                    con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
                    PreparedStatement ps = con.prepareStatement("update " + tableName + " set " + columnName + "=? where " + "sAmAccountName=?");
                    ps.setString(1, value);
                    ps.setString(2, userKey);
                    int rows = ps.executeUpdate();
                    if (rows != 1)
                    {
                        log.warn("No se actualizo correctamente el usuario: " + userKey + " el campo: " + key + " columna: " + columnName);
                    }
                    ps.close();
                }
                catch (Exception e)
                {
                    log.error(e);
                } finally
                {
                    try
                    {
                        con.close();
                    }
                    catch (Exception e)
                    {
                        log.error(e);
                    }
                }
            }
            else
            {
                log.warn("El valor del campo " + key + " es nulo");
                Connection con = null;
                try
                {
                    con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");

                    PreparedStatement ps = con.prepareStatement("update " + tableName + " set " + columnName + "=null where sAmAccountName=?");
                    ps.setString(1, userKey);
                    int rows = ps.executeUpdate();
                    if (rows != 1)
                    {
                        log.warn("No se actualizo correctamente el usuario: " + userKey + " el campo: " + key + " columna: " + columnName);
                    }
                    ps.close();
                }
                catch (Exception e)
                {
                    log.error(e);
                } finally
                {
                    try
                    {
                        con.close();
                    }
                    catch (Exception e)
                    {
                        log.error(e);
                    }
                }
            }
        }
    }

    private void insertaUser(String userKey)
    {
        Connection con = null;
        try
        {
            con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
            PreparedStatement ps = con.prepareStatement("insert into " + tableName + " (sAmAccountName) values(?)");
            ps.setString(1, userKey);
            int rows = ps.executeUpdate();
            if (rows != 1)
            {
                log.warn("No se inserto correctamente el usuario: " + userKey);
            }
            ps.close();
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
    }

    private void eliminaUser()
    {
        Set<String> delete = new HashSet<String>();
        Connection con = null;
        try
        {
            con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
            PreparedStatement ps = con.prepareStatement("select sAmAccountName from " + tableName);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String login = rs.getString("sAmAccountName");
                if (!users.contains(login.toLowerCase()))
                {
                    delete.add(login);
                }
            }
            rs.close();
            ps.close();
        }
        catch (Exception e)
        {
            log.error(e);
        } finally
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
        for (String login : delete)
        {
            try
            {
                con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
                PreparedStatement ps = con.prepareStatement("delete  from " + tableName + " where sAmAccountName=?");
                ps.setString(1, login);
                int rows = ps.executeUpdate();
                if (rows != 1)
                {
                    log.warn("No se pudo borra el usuario: " + login);
                }
                ps.close();
            }
            catch (Exception e)
            {
                log.error(e);
            } finally
            {
                try
                {
                    con.close();
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
    }
}
