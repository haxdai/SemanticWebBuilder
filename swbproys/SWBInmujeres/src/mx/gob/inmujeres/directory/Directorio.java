package mx.gob.inmujeres.directory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class Directorio extends GenericResource
{
    public static final String RH = "Personal";

    static Logger log = SWBUtils.getLogger(Directorio.class);
    protected static Properties props;
    public final static String userObjectClass;
    public final static String seekField;
    public final static String base;
    private final static String principal;
    private final static String credentials;
    private final static String url;
    public final static String tableName;
    private static Timer timer;
    private static final long HORA = 1000 * 60 * 60;  // 24 horas
    private static long period = HORA * 24;  // 24 horas
    private static int STARTS = 1;  // 1 horas
    private static final String filters;
    private static final String exceptions;

    static
    {
        log.info("Inicializando directorio...");
        props = SWBUtils.TEXT.getPropertyFile("/genericLDAP.properties");
        userObjectClass = props.getProperty("userObjectClass", "person");
        seekField = props.getProperty("seekField", "sAmAccountName");

        tableName = props.getProperty("tableName", "directorio");
        if (tableName.isEmpty())
        {
            log.error("El valor poolname es vacio");
        }

        base = props.getProperty("base", "");
        if (base.isEmpty())
        {
            log.error("El valor base es vacio");
        }

        principal = props.getProperty("principal", "");
        if (principal.isEmpty())
        {
            log.error("El valor principal es vacio");
        }

        url = props.getProperty("url", "");
        if (url.isEmpty())
        {
            log.error("El valor url es vacio");
        }
        credentials = props.getProperty("credential", "");
        if (credentials.isEmpty())
        {
            log.error("El valor credentials es vacio");
        }
        timer = new Timer();
        if (props.getProperty("period") != null)
        {
            try
            {
                int horas = Integer.parseInt(props.getProperty("period"));
                period = HORA * horas;
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }

        if (props.getProperty("starts") != null)
        {
            try
            {
                STARTS = Integer.parseInt(props.getProperty("starts"));
                if (STARTS <= 0 || STARTS >= 24)
                {
                    STARTS = 1;
                }

            }
            catch (Exception e)
            {
                log.error(e);

            }
        }
        filters = props.getProperty("filter", "OU=Normal,OU=Users,OU=INMUJERES,DC=inmujeres,DC=local;OU=Power,OU=Normal,OU=Users,OU=INMUJERES,DC=Inmujeres,DC=local");
        exceptions = props.getProperty("exceptions", "OU=Special,OU=Normal,OU=Users,OU=INMUJERES,DC=Inmujeres,DC=local;OU=Disabled,OU=Normal,OU=Users,OU=INMUJERES,DC=Inmujeres,DC=local");
        log.info("Periodo de sincronización es de " + period);
        log.info("sincronización inicia a las " + STARTS);


    }

    public static void start()
    {

        Calendar cal = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 1);
        if (now.after(cal))
        {
            cal.add(Calendar.DATE, 1);
        }
        long delay = cal.getTimeInMillis() - now.getTimeInMillis();

        //long delay = 1000 * 60 * 30; // 30 minutos

        if (timer == null)
        {
            timer.schedule(new SynchronizeDA(tableName, filters, exceptions), delay, period);
        }

        log.info("Timer iniciado delay: " + delay + " ms periodo: " + period);
        SynchronizeDA task = new SynchronizeDA(tableName, filters, exceptions);
        task.run();
    }

    public static void stop()
    {
        if (timer != null)
        {
            timer.cancel();
        }
    }

    static DirContext AuthenticateLP() throws ServiceException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        //env.put(Context.PROVIDER_URL, props.getProperty("url", "ldap://" + HOST + ":" + PORT));
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, principal); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, credentials);
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

    public static boolean isRHUser(User user, UserRepository rep)
    {
        Role group = Role.ClassMgr.getRole( RH, rep);
        if (group != null)
        {
            return user.hasRole(group);
        }
        else
        {
            return false;
        }
    }

    public static boolean showDocuments(String login, User user, UserRepository rep)
    {
        if (user == null || user.getLogin() == null || !user.isSigned())
        {
            return false;
        }
        login = checklogin(login);
        String login2 = checklogin(user.getLogin());
        if (user != null && (isRHUser(user, rep) || login2.equalsIgnoreCase(login)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if ("AddDocument".equals(paramRequest.getMode()))
        {
            doAddDocument(request, response, paramRequest);
        }
        else if ("error".equals(paramRequest.getMode()))
        {
            doError(request, response, paramRequest);
        }
        else if ("search".equals(paramRequest.getMode()))
        {
            doSearchUser(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doError(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String jsp = "/work/models/" + siteId + "/jsp/" + Directorio.class.getSimpleName() + "/error.jsp";

        request.setAttribute("paramRequest", paramRequest);
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try
        {
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public void doSearchUser(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String cadena = request.getParameter("cadena");
        if (cadena == null)
        {
            return;
        }
        List<UserInformation> users = busca(cadena);
        users = UserInformation.ordena(users);
        // despliega usuarios
        try
        {
            String jsp = "/work/models/" + siteId + "/jsp/" + Directorio.class.getSimpleName() + "/results.jsp";
            request.setAttribute("users", users);
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);

        }
    }

    public static Integer insertDocument(String login, String title, String created, String extension) throws SQLException
    {
        Connection con = null;
        login = checklogin(login);
        try
        {
            con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
            PreparedStatement ps = con.prepareStatement("insert into documentos (sAmAccountName,titulo,created,extension) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, login);
            ps.setString(2, title);
            ps.setString(3, created);
            ps.setString(4, extension);
            int rows = ps.executeUpdate();
            if (rows != 1)
            {
                throw new SQLException("No se pudo insertar en la base de datos");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
            {
                return rs.getInt(1);
            }
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
        return null;
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if ("deleteDoc".equals(response.getMode()))
        {
            String siteId = response.getWebPage().getWebSiteId();
            response.setMode(response.Mode_VIEW);
            String user = request.getParameter("user");
            if (user != null)
            {
                String id = request.getParameter("id");
                if (id != null)
                {
                    try
                    {
                        String login = user;
                        String path = SWBUtils.getApplicationPath() + "/work/models/" + siteId + "/jsp/" + login + "/" + id;
                        borraArchivo(user, id);
                        File file = new File(path);
                        if (file.exists())
                        {
                            file.delete();
                        }
                    }
                    catch (Exception e)
                    {
                        log.error(e);
                    }
                }
                response.setRenderParameter("user", user);
            }
            return;
        }
        String siteId = response.getWebPage().getWebSiteId();
        String msgError = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fu = new ServletFileUpload(factory);
        java.util.List<FileItem> items = null;
        try
        {
            items = fu.parseRequest(request);
        }
        catch (Exception e)
        {
            log.error(e);
            msgError = "(Ver log de errores)Error al insertar documento:" + e.getMessage();
        }
        String titulo = null;
        String login = null;
        FileItem file = null;
        for (FileItem item : items)
        {
            if (item.getFieldName().equals("titulo"))
            {
                titulo = item.getString();
            }
            if (item.getFieldName().equals("user"))
            {
                login = item.getString();
            }
            if (item.getFieldName().equals("doc"))
            {
                file = item;
            }

        }
        if (login != null && titulo != null && file != null)
        {
            if (!isRHUser(response.getUser(), response.getUser().getUserRepository()))
            {
                msgError = "Solo un usuario de RH puede agregar documentos";
            }
            else
            {

                if (login.trim().isEmpty() || titulo.trim().isEmpty())
                {
                    msgError = "El valor de título o usuario es vácio";
                }
                else
                {
                    if (existe(login))
                    {
                        try
                        {

                            String extension = "";
                            String name = file.getName();
                            int pos = name.lastIndexOf(".");
                            String finalName = name;
                            if (pos != -1)
                            {
                                extension = name.substring(pos);
                            }
                            Integer id = insertDocument(login, titulo, response.getUser().getLogin(), extension);
                            String path = SWBUtils.getApplicationPath() + "/work/models/" + siteId + "/jsp/" + login + "/";
                            File dir = new File(path);
                            dir.mkdirs();
                            path += id + extension;
                            saveFile(file, path);
                        }
                        catch (Exception e)
                        {
                            log.error(e);
                            msgError = "Error al registrar documento (vease log): " + e.getMessage();
                        }
                    }
                    else
                    {
                        // error
                        msgError = "El valor de título o usuario es nulo";
                    }
                }

            }

        }
        else
        {
            msgError = "Los datos son incorrectos, vuelva a intentar";
        }
        if (msgError != null)
        {
            // manda pantalla de error;
            response.setMode("error");
        }
        else
        {
            response.setRenderParameter("user", login);
            response.setMode(response.Mode_VIEW);
        }




    }

    public static void doAddDocument(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String jsp = "/work/models/" + siteId + "/jsp/" + Directorio.class.getSimpleName() + "/addFile.jsp";
        request.setAttribute("paramRequest", paramRequest);
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try
        {
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();
        // vista detalle
        boolean isRH = isRHUser(paramRequest.getUser(), paramRequest.getWebPage().getWebSite().getUserRepository());

        if (request.getParameter("user") != null)
        {
            String login = request.getParameter("user").trim();
            boolean showDocuments = showDocuments(login, paramRequest.getUser(), paramRequest.getWebPage().getWebSite().getUserRepository());
            try
            {
                vistaDetalle(paramRequest, login, request, response, isRH, showDocuments);
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
        else
        {
            // vista de directorio
            try
            {
                String jsp = "/work/models/" + siteId + "/jsp/" + Directorio.class.getSimpleName() + "/view.jsp";
                request.setAttribute("paramRequest", paramRequest);
                RequestDispatcher rd = request.getRequestDispatcher(jsp);
                rd.include(request, response);
            }
            catch (Exception e)
            {
                log.error(e);

            }
        }

    }

    public static void vistaDetalle(SWBParamRequest paramRequest, String login, HttpServletRequest request, HttpServletResponse response, boolean isRH, boolean showDocuments) throws ServletException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String jsp = "/work/models/" + siteId + "/jsp/" + Directorio.class.getSimpleName() + "/detail.jsp";
        request.setAttribute("paramRequest", paramRequest);
        request.setAttribute("user", getInfo(login));
        request.setAttribute("isRH", isRH);
        request.setAttribute("showDocuments", showDocuments);
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.include(request, response);
    }

    public static List<UserInformation> getUsers(Character letra)
    {
        Connection con = null;
        List<UserInformation> users = new ArrayList<UserInformation>();
        try
        {
            con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
            PreparedStatement ps = con.prepareStatement("select * from " + tableName + " where sn like CONCAT(? ,'%')");
            ps.setString(1, letra.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Map<String, String> values = new HashMap<String, String>();
                for (String key : SynchronizeDA.attsNames.keySet())
                {
                    String value = rs.getString(SynchronizeDA.attsNames.get(key));
                    values.put(key, value);
                }
                String login = rs.getString("sAmAccountName");
                UserInformation user = UserInformation.getUserInformation(login, values);
                users.add(user);
            }

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
        users = UserInformation.ordena(users);
        return users;
    }

    public static List<UserInformation> busca(String cadena)
    {
        Connection con = null;
        List<UserInformation> users = new ArrayList<UserInformation>();
        try
        {
            con = SWBUtils.DB.getDefaultConnection("Directorio de DA");
            PreparedStatement ps = con.prepareStatement("select * from " + tableName + " where sn like CONCAT('%', ? ,'%') or givenName like CONCAT('%', ? ,'%') ");
            ps.setString(1, cadena);
            ps.setString(2, cadena);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Map<String, String> values = new HashMap<String, String>();
                for (String key : SynchronizeDA.attsNames.keySet())
                {
                    String value = rs.getString(SynchronizeDA.attsNames.get(key));
                    values.put(key, value);
                }
                String login = rs.getString("sAmAccountName");
                UserInformation user = UserInformation.getUserInformation(login, values);
                users.add(user);
            }

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
        if (!users.isEmpty())
        {
            users = UserInformation.ordena(users);
        }
        return users;
    }

    public static boolean existe(String login)
    {
        Connection con = null;

        try
        {
            con = SWBUtils.DB.getDefaultConnection("Busqueda usuario");
            PreparedStatement ps = con.prepareStatement("select * from " + tableName + " where sAmAccountName=?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return true;
            }

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
        return false;
    }

    private static String checklogin(String login)
    {
        if (login != null)
        {
            int pos = login.indexOf("@inmujeres.local");
            if (pos == -1)
            {
                login += "@inmujeres.local";
            }
        }
        return login;
    }

    private static UserInformation getInfo(String login)
    {
        Connection con = null;
        login = checklogin(login);
        try
        {
            con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
            PreparedStatement ps = con.prepareStatement("select * from " + tableName + " where sAmAccountName=?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Map<String, String> values = new HashMap<String, String>();
                for (String key : SynchronizeDA.attsNames.keySet())
                {
                    String value = rs.getString(SynchronizeDA.attsNames.get(key));
                    values.put(key, value);
                }
                UserInformation user = UserInformation.getUserInformation(login, values);
                return user;
            }

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
        return null;
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        /*SynchronizeDA da = new SynchronizeDA(tableName,filters,exceptions);
        da.run();*/
    }

    public static void saveFile(FileItem item, String path) throws IOException
    {
        byte[] buffer = new byte[1024];
        InputStream in = item.getInputStream();
        File file = new File(path);
        FileOutputStream out = new FileOutputStream(file);
        int read = in.read(buffer);
        while (read != -1)
        {
            out.write(buffer, 0, read);
            read = in.read(buffer);
        }
        in.close();
        out.close();
    }

    public static void borraArchivo(String login, String id) throws Exception
    {
        int pos = id.indexOf(".");
        if (pos != -1)
        {
            id = id.substring(0, pos);
        }
        Connection con = null;

        try
        {
            con = SWBUtils.DB.getDefaultConnection("Sincronización de DA");
            PreparedStatement ps = con.prepareStatement("delete  from documentos where id=? and sAmAccountName=?");
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, login);
            int res = ps.executeUpdate();
            if (res != 1)
            {
                throw new Exception("Documento no se encontro");
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
