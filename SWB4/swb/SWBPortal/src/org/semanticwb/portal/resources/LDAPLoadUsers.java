/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
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
import org.semanticwb.SWBUtils;
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
                    ru.setFirstName((String) attrs.get(fieldFirstName).get());
                }
            }
            catch (NamingException ne)
            {
            }
            try
            {
                if (!"null".equals(fieldLastName))
                {
                    ru.setLastName((String) attrs.get(fieldLastName).get());
                }
            }
            catch (NamingException ne)
            {
            }
            try
            { //If there is no middlename go on
                if (!"null".equals(fieldMiddleName))
                {
                    ru.setSecondLastName((String) attrs.get(fieldMiddleName).get());
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
                    ru.setEmail((String) attrs.get(fieldEmail).get());
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
                    sb.append(" ");
                    sb.append(attrs.get(fieldFirstName).get().toString());
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
                    sb.append(" ");
                    sb.append(attrs.get(fieldLastName).get().toString());
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
                    sb.append(" ");
                    sb.append(attrs.get(fieldMiddleName).get().toString());
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

        private NamingEnumeration search(String firstName, String lastName) throws NamingException
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
            if (firstName != null && !firstName.isEmpty())
            {
                query.append("(").append(fieldFirstName).append("=").append("*").append(firstName).append("*").append(")");
            }
            if (lastName != null && !lastName.isEmpty())
            {
                query.append("(").append(fieldLastName).append("=").append("*").append(lastName).append("*").append(")");
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

        public Map<String, String> findUsers(String firstName, String lastName)
        {
            Map<String, String> findUsers = new HashMap<String, String>();
            try
            {
                NamingEnumeration answers = search(firstName, lastName);
                while (answers.hasMore())
                {
                    Object answer = answers.next();
                    if (answer instanceof SearchResult)
                    {
                        SearchResult searchResult = (SearchResult) answer;
                        String login = searchResult.getAttributes().get(seekField).get().toString();
                        Attributes atts = getUserAttributes(login);
                        String name = getName(atts);
                        findUsers.put(login, name);
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

    public Map<String, String> findUsers(String firstName, String lastName, UserRepository rep, String propsFile)
    {
        Map<String, String> findUsers = new HashMap<String, String>();
        try
        {
            Properties props = new Properties();
            InputStream inProps = this.getClass().getClassLoader().getResourceAsStream(propsFile);
            props.load(inProps);
            Util util = new Util(rep, props);
            findUsers = util.findUsers(firstName, lastName);
        }
        catch (IOException e)
        {
            log.error(e);
        }
        return findUsers;
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        doAdmin(request, response, paramRequest);
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String ldapFile = paramRequest.getResourceBase().getAttribute("file", "/genericLDAP.properties");
        if (paramRequest.getWebPage().getWebSite().getUserRepository().getUserRepExternalConfigFile() != null)
        {
            ldapFile = paramRequest.getWebPage().getWebSite().getUserRepository().getUserRepExternalConfigFile();
        }
        PrintWriter out = response.getWriter();
        String url = paramRequest.getRenderUrl().setAction("search").toString();
        out.println("<form class=\"swbform\" action=\"" + url + "\" method=\"post\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td align=\"right\">");
        out.println("<label>");
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
        out.println("<label>");
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
        out.println("Apellido:");
        out.println("</label>");
        out.println("</td>");
        out.println("<td>");
        out.println("<span>");
        out.println("<input type=\"text\" size=\"80\" name=\"lastName\" >");
        out.println("</span>");
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td colspan=\"2\">");
        out.println("<span>");
        out.println("<input type=\"submit\" name=\"buscar\" value=\"Buscar\">");
        out.println("</span>");
        out.println("</td>");
        out.println("</tr>");

        out.println("</table>");
        out.println("</form><br><br>");

        if ("sync".equals(paramRequest.getAction()) && request.getParameter("file") != null && !request.getParameter("file").isEmpty())
        {
            String file = request.getParameter("file");
            paramRequest.getResourceBase().setAttribute("file", file);

            try
            {
                InputStream inProps = this.getClass().getClassLoader().getResourceAsStream(file);
                Properties props = new Properties();
                props.load(inProps);
                Util util = new Util(paramRequest.getWebPage().getWebSite().getUserRepository(), props);
                String[] values = request.getParameterValues("login");
                if (values != null)
                {
                    for (String login : values)
                    {

                        String name = util.loadUser(login);
                        if (name == null)
                        {
                            out.println("<p>No se pudo cargar el usuario con login " + login + "</p>");
                        }
                        else
                        {
                            out.println("<p>Usuario agregado " + name + "</p>");
                        }

                    }
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
            Map<String, String> findUsers = findUsers(request.getParameter("firstName"), request.getParameter("lastName"), paramRequest.getWebPage().getWebSite().getUserRepository(), request.getParameter("file"));
            if (findUsers.isEmpty())
            {
                out.println("<p>No se encontraron usuarios</p>");
            }
            else
            {
                url = paramRequest.getRenderUrl().setAction("sync").toString();
                out.println("<form class=\"swbform\" action=\"" + url + "\" method=\"post\">");
                out.println("<input type=\"hidden\" name=\"file\" value=\"" + request.getParameter("file") + "\" >");
                for (String login : findUsers.keySet())
                {
                    String name = findUsers.get(login);
                    out.println("<input type=\"checkbox\" name=\"login\" value=\"" + login + "\" checked>" + name + "<br>");
                }
                out.println("<input type=\"submit\" name=\"buscar\" value=\"Agregar\"><br>");
                out.println("</form><br><br>");
            }
        }
    }

}
