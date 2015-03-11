/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class LDAPLoadUsers extends GenericResource
{

    private static final Logger log = SWBUtils.getLogger(LDAPLoadUsers.class);

    class UserInformationComparator implements Comparator<UserInformation>
    {

        @Override
        public int compare(UserInformation u1, UserInformation u2)
        {
            return u1.name.compareToIgnoreCase(u2.name);
        }
    }

    class ConfigurationError extends Exception
    {

        public ConfigurationError(String message)
        {
            super(message);
        }
    }

    private class UserInformation
    {

        public String login, name;

        public UserInformation(String login, String name)
        {
            this.login = login;
            this.name = name;
        }
    }

    private class Util
    {

        private final UserRepository userRep;

        /**
         * The props.
         */
        private final Properties props;

        /**
         * The seek field.
         */
        private final String seekField;

        /**
         * The user object class.
         */
        private final String userObjectClass;

        /**
         * The field first name.
         */
        private final String fieldFirstName;

        /**
         * The field last name.
         */
        private final String fieldLastName;

        /**
         * The field middle name.
         */
        private final String fieldMiddleName;

        /**
         * The field email.
         */
        private final String fieldEmail;

        /**
         * The value language.
         */
        private final String valueLanguage;

        public Util(UserRepository UserRep, Properties props)
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

        public void loadAttrs2RecUser(Attributes attrs, User ru)
        {

            try
            {
                if (!"null".equals(fieldFirstName))
                {
                    if (attrs != null && attrs.get(fieldFirstName) != null && attrs.get(fieldFirstName).get() != null)
                    {
                        ru.setFirstName((String) attrs.get(fieldFirstName).get());
                    }
                }
            }
            catch (NamingException ne)
            {
            }
            try
            {
                if (!"null".equals(fieldLastName))
                {
                    if (attrs != null && attrs.get(fieldLastName) != null && attrs.get(fieldLastName).get() != null)
                    {
                        ru.setLastName((String) attrs.get(fieldLastName).get());
                    }
                }
            }
            catch (NamingException ne)
            {
            }
            try
            { //If there is no middlename go on
                if (!"null".equals(fieldMiddleName))
                {
                    if (attrs != null && attrs.get(fieldMiddleName) != null && attrs.get(fieldMiddleName).get() != null)
                    {
                        ru.setSecondLastName((String) attrs.get(fieldMiddleName).get());
                    }
                }
            }
            catch (NamingException ne)
            {
                log.error(ne);
            }
            try
            {
                if (!"null".equals(fieldEmail))
                {
                    if (attrs != null && attrs.get(fieldEmail) != null && attrs.get(fieldEmail).get() != null)
                    {
                        ru.setEmail((String) attrs.get(fieldEmail).get());
                    }
                }
            }
            catch (NamingException ne)
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
            catch (NamingException ne)
            {
            }

        }

        public String getName(Attributes attrs)
        {
            StringBuilder sb = new StringBuilder();
            try
            {
                if (!"null".equals(fieldFirstName))
                {
                    //ru.setFirstName((String) attrs.get(fieldFirstName).get());
                    if (attrs != null && attrs.get(fieldFirstName) != null && attrs.get(fieldFirstName).get() != null)
                    {
                        sb.append(" ");
                        sb.append(attrs.get(fieldFirstName).get().toString());
                    }
                }
            }
            catch (NamingException ne)
            {
                log.error(ne);
            }
            try
            {
                if (!"null".equals(fieldLastName))
                {
                    //ru.setLastName((String) attrs.get(fieldLastName).get());
                    if (attrs != null && attrs.get(fieldLastName) != null && attrs.get(fieldLastName).get() != null)
                    {
                        sb.append(" ");
                        sb.append(attrs.get(fieldLastName).get().toString());

                    }
                }
            }
            catch (NamingException ne)
            {
                log.error(ne);
            }
            try
            { //If there is no middlename go on
                if (!"null".equals(fieldMiddleName))
                {
                    //ru.setSecondLastName((String) attrs.get(fieldMiddleName).get());

                    if (attrs != null && attrs.get(fieldMiddleName) != null && attrs.get(fieldMiddleName).get() != null)
                    {
                        sb.append(" ");
                        sb.append(attrs.get(fieldMiddleName).get().toString());
                    }

                }
            }
            catch (NamingException ne)
            {
                log.error(ne);
            }
            return sb.toString().trim();

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

        private String getCNFromLogin(String login) throws NamingException
        {
            DirContext ctx = new InitialDirContext(getPropertiesHash());
            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            try
            {
                NamingEnumeration answers = ctx.search(props.getProperty("base", ""),
                        "(&(objectClass=" + userObjectClass + ")(" + seekField + "=" + login + "))", ctls);

                return ((SearchResult) answers.next()).getName() + "," + props.getProperty("base", "");
            }
            catch (NamingException e)
            {
                log.trace(e);
                return null; //We didn't found or we got an error so we leave
            }
        }

        public Attributes getUserAttributes(String login) throws NamingException
        {
            DirContext ctx = new InitialDirContext(getPropertiesHash());
            String[] attrIDs =
            {
                "*"
            };
            String cn = getCNFromLogin(login);
            Attributes answer = ctx.getAttributes(cn, attrIDs);
            ctx.close();
            return answer;
        }

        private NamingEnumeration search(String firstName, String lastName, String middleName, String email) throws NamingException
        {
            DirContext ctx = new InitialDirContext(getPropertiesHash());

            Attributes matchAttrs = new BasicAttributes(true); // ignore case
            matchAttrs.put(new BasicAttribute("objectClass", userObjectClass));
            // Search for objects that have those matching attributes

            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            ctls.setReturningAttributes(new String[]
            {
                seekField
            });
            StringBuilder query = new StringBuilder("(&");
            query.append("(objectClass=").append(userObjectClass).append(")");
            if (firstName != null && !firstName.isEmpty() && !"null".equals(fieldFirstName))
            {
                query.append("(").append(fieldFirstName).append("=").append("*").append(firstName).append("*").append(")");
            }
            if (lastName != null && !lastName.isEmpty() && !"null".equals(fieldLastName))
            {
                query.append("(").append(fieldLastName).append("=").append("*").append(lastName).append("*").append(")");
            }
            if (middleName != null && !middleName.isEmpty() && !"null".equals(fieldMiddleName))
            {
                query.append("(").append(fieldMiddleName).append("=").append("*").append(middleName).append("*").append(")");
            }
            if (email != null && !email.isEmpty() && !"null".equals(fieldEmail))
            {
                query.append("(").append(fieldEmail).append("=").append("*").append(email).append("*").append(")");
            }
            query.append(")");

            NamingEnumeration answers = ctx.search(props.getProperty("base", ""),
                    query.toString(), ctls);
            ctx.close();
            return answers;
        }

        public String loadUser(String login)
        {

            User user = userRep.getUserByLogin(login);
            try
            {
                Attributes atts = getUserAttributes(login);
                if (user == null)
                {
                    user = userRep.createUser();
                    user.setLogin(login);
                    user.setActive(true);
                }
                loadAttrs2RecUser(atts, user);
                return user.getFullName();
            }
            catch (NamingException ne)
            {
                log.error(ne);
            }
            return null;
        }

        public Map<String, String> findUsers(String firstName, String lastName, String middleName, String email)
        {
            Map<String, String> findUsers = new HashMap<String, String>();
            try
            {
                NamingEnumeration answers = search(firstName, lastName, middleName, email);
                while (answers.hasMore())
                {
                    Object answer = answers.next();
                    if (answer instanceof SearchResult)
                    {
                        SearchResult searchResult = (SearchResult) answer;
                        if (searchResult.getAttributes() != null && searchResult.getAttributes().get(seekField) != null && searchResult.getAttributes().get(seekField).get() != null)
                        {
                            String login = searchResult.getAttributes().get(seekField).get().toString();
                            Attributes atts = getUserAttributes(login);
                            String name = getName(atts);
                            findUsers.put(login, name);
                        }
                    }
                }
            }
            catch (NamingException ne)
            {
                log.error(ne);
            }
            return findUsers;
        }

    }

    public Map<String, String> findUsers(String firstName, String lastName, String middleName, String email, UserRepository rep, String propsFile) throws ConfigurationError
    {
        Map<String, String> findUsers = new HashMap<String, String>();
        try
        {
            Properties props = new Properties();
            InputStream inProps = this.getClass().getClassLoader().getResourceAsStream(propsFile);
            if (inProps == null)
            {
                throw new ConfigurationError("No se encontro el archivo de propiedades");
            }
            props.load(inProps);
            Util util = new Util(rep, props);
            findUsers = util.findUsers(firstName, lastName, middleName, email);
        }
        catch (IOException e)
        {
            log.error(e);
        }
        return findUsers;
    }

    public void showLoad(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String ldapFile = paramRequest.getResourceBase().getAttribute("file", "/genericLDAP.properties");
        if (paramRequest.getWebPage().getWebSite().getUserRepository().getUserRepExternalConfigFile() != null)
        {
            ldapFile = paramRequest.getWebPage().getWebSite().getUserRepository().getUserRepExternalConfigFile();
        }
        PrintWriter out = response.getWriter();
        String url = paramRequest.getRenderUrl().setAction("search").toString();
        out.println("<div class=\"swbform\">");

        out.println("<form class=\"swbform\" action=\"" + url + "\" method=\"post\">");
        out.println("<fieldset name=\"frmAdmRes\">");
        out.println("<legend>Busqueda de usuarios</legend>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td align=\"right\">");
        out.println("<label for=\"file\">");
        out.println("Archivo de configuración LDAP:");
        out.println("</label>");
        out.println("</td>");
        out.println("<td>");
        out.println("<span>");
        out.println("<input size=\"80\" type=\"text\" name=\"file\" value=\"" + ldapFile + "\">");
        out.println("</span>");
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td align=\"right\">");
        out.println("<label for=\"name\">");
        out.println("Nombre:");
        out.println("</label>");
        out.println("</td>");
        out.println("<td>");
        out.println("<span>");
        out.println("<input type=\"text\" size=\"80\" name=\"firstName\" >");
        out.println("</span>");
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td align=\"right\">");
        out.println("<label>");
        out.println("Primer Apellido:");
        out.println("</label>");
        out.println("</td>");
        out.println("<td>");
        out.println("<span>");
        out.println("<input type=\"text\" size=\"80\" name=\"lastName\" >");
        out.println("</span>");
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td align=\"right\">");
        out.println("<label>");
        out.println("Segundo Apellido:");
        out.println("</label>");
        out.println("</td>");
        out.println("<td>");
        out.println("<span>");
        out.println("<input type=\"text\" size=\"80\" name=\"middleName\" >");
        out.println("</span>");
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td align=\"right\">");
        out.println("<label>");
        out.println("Correo Electrónico:");
        out.println("</label>");
        out.println("</td>");
        out.println("<td>");
        out.println("<span>");
        out.println("<input type=\"text\" size=\"80\" name=\"email\" >");
        out.println("</span>");
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td colspan=\"2\">");
        out.println("<fieldset>");
        out.println("<button dojoType='dijit.form.Button' type=\"submit\">Buscar</button>");
        out.println("</fieldset>");
        out.println("</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("</fieldset>");
        out.println("</form>");
        out.println("</div>");

        if ("sync".equals(paramRequest.getAction()) && request.getParameter("file") != null && !request.getParameter("file").isEmpty())
        {
            String file = request.getParameter("file");
            paramRequest.getResourceBase().setAttribute("file", file);
            try
            {
                paramRequest.getResourceBase().updateAttributesToDB();
            }
            catch (SWBException e)
            {
                log.error(e);
            }

            try
            {
                InputStream inProps = this.getClass().getClassLoader().getResourceAsStream(file);
                if (inProps == null)
                {
                    throw new NullPointerException("El archivo de propiedades no se encontró");
                }
                Properties props = new Properties();
                props.load(inProps);
                Util util = new Util(paramRequest.getWebPage().getWebSite().getUserRepository(), props);
                String[] values = request.getParameterValues("login");

                if (values != null)
                {
                    out.println("<fieldset name=\"frmAdmRes\">");
                    out.println("<legend>Usuarios agregados</legend>");
                    for (String login : values)
                    {

                        String name = util.loadUser(login);
                        if (name == null)
                        {
                            out.println("<p>No se pudo cargar el usuario con login " + login + "</p>");
                        }
                        else
                        {
                            out.println("<p>" + name + "</p>");
                        }

                    }
                    out.println("</fieldset>");
                }
            }
            catch (IOException e)
            {
                log.error(e);
            }
        }
        if ("search".equals(paramRequest.getAction()) && request.getParameter("file") != null && !request.getParameter("file").isEmpty())
        {
            String file = request.getParameter("file");
            paramRequest.getResourceBase().setAttribute("file", file);
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String middleName = request.getParameter("middleName");
            String email = request.getParameter("email");
            if (firstName == null)
            {
                firstName = "";
            }
            if (lastName == null)
            {
                lastName = "";
            }
            if (middleName == null)
            {
                middleName = "";
            }
            if (email == null)
            {
                email = "";
            }
            String q = firstName + lastName + middleName + email;
            if (q.trim().isEmpty())
            {
                out.println("<p>No se puede ejecutar esta consulta, intente de nuevo</p>");
                return;
            }
            try
            {
                Map<String, String> findUsers = findUsers(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("middleName"), request.getParameter("email"), paramRequest.getWebPage().getWebSite().getUserRepository(), request.getParameter("file"));
                if (findUsers.isEmpty())
                {
                    out.println("<p>No se encontraron usuarios</p>");
                }
                else
                {
                    paramRequest.getResourceBase().setAttribute("file", file);
                    try
                    {
                        paramRequest.getResourceBase().updateAttributesToDB();
                    }
                    catch (SWBException e)
                    {
                        log.error(e);
                    }
                    url = paramRequest.getRenderUrl().setAction("sync").toString();
                    out.println("<fieldset name=\"frmAdmRes\">");
                    out.println("<legend>Usuarios encontrados</legend>");
                    out.println("<form class=\"swbform\" action=\"" + url + "\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"file\" value=\"" + request.getParameter("file") + "\" >");
                    /*for (String login : findUsers.keySet())
                     {
                     String name = findUsers.get(login);
                     out.println("<input type=\"checkbox\" name=\"login\" value=\"" + login + "\" checked>" + name + "<br>");
                     }*/
                    List<UserInformation> users = new ArrayList<UserInformation>();
                    for (String login : findUsers.keySet())
                    {
                        String name = findUsers.get(login);
                        users.add(new UserInformation(login, name));
                    }
                    Collections.sort(users, new UserInformationComparator());
                    for (UserInformation user : users)
                    {
                        out.println("<input type=\"checkbox\" name=\"login\" value=\"" + user.login + "\" checked>" + user.name + "<br>");
                    }
                    out.println("<br><br><button dojoType='dijit.form.Button' type=\"submit\">Agregar</button>");
                    //out.println("<input type=\"submit\" name=\"buscar\" value=\"Agregar\"><br>");
                    out.println("</form>");
                    out.println("</fieldset>");
                }
            }
            catch (ConfigurationError ioe)
            {
                out.println("<p>Error al buscar usuarios: " + ioe.getMessage() + "</p>");
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getWebPage().getWebSiteId().equalsIgnoreCase(SWBContext.getAdminWebSite().getId()))
        {
            showLoad(request, response, paramRequest);
        }

    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (!paramRequest.getWebPage().getWebSiteId().equalsIgnoreCase(SWBContext.getAdminWebSite().getId()))
        {
            showLoad(request, response, paramRequest);
        }
    }

}
