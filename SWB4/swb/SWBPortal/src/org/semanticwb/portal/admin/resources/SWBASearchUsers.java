/*
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica:
 *  http://www.semanticwebbuilder.org
 */
package org.semanticwb.portal.admin.resources;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SWBASearchUsers.
 *
 * @author juan.fernandez
 */
public class SWBASearchUsers extends GenericResource
{

    /**
     * The log.
     */
    private final Logger log = SWBUtils.getLogger(SWBASearchUsers.class);

    /**
     * The pagezise.
     */
    private final int pagezise = 10;

    /**
     * Instantiates a new sWBA search users.
     */
    public SWBASearchUsers()
    {
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#doView(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.semanticwb.portal.api.SWBParamRequest)
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        StringBuilder ret = new StringBuilder("");
        SWBResourceURL url = paramRequest.getRenderUrl();
        User user = paramRequest.getUser();
        url.setMode("search");
        Iterator<UserRepository> itur = SWBContext.listUserRepositories();
        ret.append("<script type=\"text/javascript\">\n"
                + "           dojo.require(\"dojo.parser\");\n"
                + "                   dojo.require(\"dijit.layout.ContentPane\");\n"
                + "                   dojo.require(\"dijit.form.FilteringSelect\");\n"
                + "                   dojo.require(\"dijit.form.CheckBox\");\n"
                + "        </script>\n");

        ret.append("  <form class=\"swbform\" id=\"SWBASearchUsers\" name=\"SWBASearchUsers\" method=\"post\" action=\"").append(url).append("\">\n");
        ret.append("<fieldset>\n");
        // ret.append("  <legend>Busqueda usuarios</legend>\n");
        ret.append("<table>\n");
        url.setMode("roles");
        url.setCallMethod(SWBResourceURL.Call_DIRECT);
        ret.append("    <tr><td width=\"200px\">").append(paramRequest.getLocaleString("UsrRep")).append("</td>\n");
        ret.append("    <td><select dojoType=\"dijit.form.FilteringSelect\" autocomplete=\"false\" name=\"userRepository\" id=\"userRepository\" >\n");
        while (itur.hasNext())
        {
            UserRepository ur = itur.next();
            if (ur.getParentWebSite() == null || (ur.getParentWebSite() != null && !ur.getParentWebSite().isDeleted()))
            {
                ret.append("        <option value=\"").append(ur.getId()).append("\">").append(ur.getDisplayTitle(user.getLanguage())).append("</option>\n"); //todo Add Language
            }
        }
        ret.append("<script type=\"dojo/method\" event=\"onChange\" args=\"suri\">\n");
        ret.append("    var lpan = dijit.byId('SWBASearchUsers_R');\n");
        ret.append("    lpan.attr('href', '").append(url).append("?userRepository='+suri);\n");
        ret.append("    lpan.refresh();\n");
        url.setMode("groups");
        ret.append("    lpan = dijit.byId('SWBASearchUsers_G');\n");
        ret.append("    lpan.attr('href', '").append(url).append("?userRepository='+suri);\n");
        ret.append("    lpan.refresh();\n");
        ret.append("</script> \n");

        ret.append("    </select>\n");
        ret.append("    </td></tr>\n");
        ret.append("    <tr><td>").append(paramRequest.getLocaleString("UsrRepMail")).append("</td>\n");
        ret.append("    <td><input type=\"text\" name=\"usrEMail\" id=\"usrEMail\" dojoType=\"dijit.form.TextBox\" />\n");
        ret.append("    </td></tr>\n");
        ret.append("    <tr><td>").append(paramRequest.getLocaleString("UsrRepName")).append("</td>\n");
        ret.append("    <td><input type=\"text\" name=\"usrFirstName\" id=\"usrFirstName\" dojoType=\"dijit.form.TextBox\" />\n");
        ret.append("    </td></tr>\n");
        ret.append("    <tr><td>").append(paramRequest.getLocaleString("UsrRepFApp")).append("</td>\n");
        ret.append("    <td><input type=\"text\" name=\"usrLastName\" id=\"usrLastName\" dojoType=\"dijit.form.TextBox\" />\n");
        ret.append("    </td></tr>\n");
        ret.append("    <tr><td>").append(paramRequest.getLocaleString("UsrRepSApp")).append("</td>\n");
        ret.append("    <td><input type=\"text\" name=\"usrSecondLastName\" id=\"usrSecondLastName\" dojoType=\"dijit.form.TextBox\" />\n");
        ret.append("    </td></tr>\n");
        ret.append("    <tr><td>" + paramRequest.getLocaleString("UsrRepAct") + "</td>\n");
        ret.append("    <td><span><label for=\"activetrue\">"
                + "<input dojoType=\"dijit.form.RadioButton\" id=\"activetrue\" name=\"active\" value=\"true\" type=\"radio\" />" + paramRequest.getLocaleString("UsrRepAct") + "</label></span>"
                + "<span><label for=\"activefalse\">"
                + "<input dojoType=\"dijit.form.RadioButton\" id=\"activefalse\" name=\"active\" value=\"false\" type=\"radio\" />" + paramRequest.getLocaleString("UsrRepInA") + "</label>"
                + "</span>\n");
        ret.append("    </td></tr>\n");
        ret.append("<div id=\"SWBASearchUsers_GR\" name=\"SWBASearchUsers_GR\" dojoType=\"dijit.layout.ContentPane\">\n");
        Iterator<Role> itroles = SWBContext.getDefaultRepository().listRoles();
        ret.append("    <tr><td>").append(paramRequest.getLocaleString("UsrRepRol")).append("</td>\n");
        ret.append("    <td><div id=\"SWBASearchUsers_R\" name=\"SWBASearchUsers_GR\" dojoType=\"dijit.layout.ContentPane\">\n<select name=\"userRoles\" id=\"userRolesdef\" dojoType=\"dijit.form.FilteringSelect\" autocomplete=\"false\" >\n");
        ret.append("        <option value=\"\"></option>\n");
        while (itroles.hasNext())
        {
            Role role = itroles.next();
            ret.append("        <option value=\"").append(role.getId()).append("\">").append(role.getDisplayTitle(user.getLanguage())).append("</option>\n"); //todo Add Language
        }
        ret.append("    </select><div>\n");
        ret.append("    </td></tr>\n");
        Iterator<UserGroup> itgroup = SWBContext.getDefaultRepository().listUserGroups();
        ret.append("    <tr><td>").append(paramRequest.getLocaleString("UsrRepGrp")).append("</td>\n");
        ret.append("    <td><div id=\"SWBASearchUsers_G\" name=\"SWBASearchUsers_GR\" dojoType=\"dijit.layout.ContentPane\">\n<select name=\"userGroups\" id=\"userGroupsdef\" dojoType=\"dijit.form.FilteringSelect\" autocomplete=\"false\" >\n");
        ret.append("        <option value=\"\"></option>\n");
        while (itgroup.hasNext())
        {
            UserGroup group = itgroup.next();
            ret.append("        <option value=\"" + group.getId() + "\">" + group.getDisplayTitle(user.getLanguage()) + "</option>\n"); //todo Add Language
        }
        ret.append("    </select></div>\n");
        ret.append("    </td></tr>\n");
        ret.append("</table>");
        ret.append("</div>\n");
        ret.append("</fieldset>\n");
        ret.append("<fieldset>\n");
        ret.append("    <button  dojoType=\"dijit.form.Button\" type=\"submit\" >" + paramRequest.getLocaleString("BtnSrch") + "</button>\n");
        ret.append("</fieldset>\n");
        ret.append("  </form>\n");
        response.getWriter().write(ret.toString());
    }

    /**
     * Do search.
     *
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doSearch(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        StringBuilder ret = new StringBuilder("");
        String usrep = request.getParameter("userRepository");
        String usrFirstName = request.getParameter("usrFirstName");
        String usrLastName = request.getParameter("usrLastName");
        String usrSecondLastName = request.getParameter("usrSecondLastName");
        String usrEmail = request.getParameter("usrEMail");
        String Role = request.getParameter("userRoles");
        String Group = request.getParameter("userGroups");
        String active = request.getParameter("active");
        //System.out.println("active: " + active);
        UserRepository ur = SWBContext.getUserRepository(usrep);
        
        String[] loginValues=request.getParameterValues("login");
        if(loginValues!=null)
        {
            for(String login : loginValues)
            {
                try
                {
                    ur.getUserByLogin(login);
                }
                catch(Exception e)
                {
                    log.error(e);                    
                }
            }
        }
        
        Iterator<String> itst = ur.searchUsersBy(usrFirstName, usrLastName, usrSecondLastName, usrEmail, Role, Group, active);
        ArrayList<String> arusr = new ArrayList<String>();
        while (itst.hasNext())
        {
            arusr.add(itst.next());
        }
        request.getSession(true).setAttribute("iteraUsers", arusr.toArray(new String[arusr.size()]));
        request.getSession(true).setAttribute("iteraUsersRep", ur.getId());
        SWBResourceURL url = paramRequest.getRenderUrl().setMode("jsonData").setCallMethod(SWBResourceURL.Call_DIRECT);
        ret.append("<script type=\"text/javascript\">\n"
                + "           dojo.require(\"dojox.grid.DataGrid\");\n"
                + "           dojo.require(\"dojox.data.QueryReadStore\");\n"
                + "                   dojo.require(\"dijit.form.CheckBox\");\n"
                + "           dojo.require(\"dojo.parser\");\n"
                + "       // data grid layout: a grid view is a group of columns\n"
                + "       var page= 0;\n"
                + "       var start= 0;\n"
                + "       var batchSize=" + pagezise + ";                        \n"
                + "               // Data Grid layout\n"
                + "               // A grid view is a group of columns\n"
                + "       var view1 = [\n"
                + "                    {name: '" + paramRequest.getLocaleString("UsrRepUID") + "',width:'20%', field: \"login\"},\n"
                + "                    {name: '" + paramRequest.getLocaleString("UsrRepName") + "',width:'20%', field: \"name\"},\n"
                + "                    {name: '" + paramRequest.getLocaleString("UsrRepFApp") + "',width:'20%',field: \"papellid\"},\n "
                + "                    {name: '" + paramRequest.getLocaleString("UsrRepSApp") + "',width:'20%',field: \"sapellid\"},\n "
                + "                    {name: '" + paramRequest.getLocaleString("UsrRepMail") + "',width:'20%',field: \"email\"}\n                "
                + "            ]\n ;"
                + "       var layout = [ view1 ];\n"
                + //  "       model = new dojox.grid.data.Objects([{key: \"login\"}, {key: \"name\"},{key: \"papellid\"},{key: \"sapellid\"},{key: \"email\"}], null);\n" +
                "       \n"
                + "       dojo.addOnLoad(function(){\n"
                + "   	model = new dojox.data.QueryReadStore({\n"
                + "				url:\"" + url + "\",\n"
                + "		requestMethod:\"post\"\n"
                + "	});\n\n"
                + "       grid1.setStore(model);\n"
                + "       grid1.setStructure(layout);\n"
                + "       });\n"
                + "       function openOther(evt){\n"
                + "           var row=evt.rowIndex;\n"
                + "           var curItem = grid1.getItem(row);\n"
                + "           var rowID=model.getValue(curItem,\"@uri\");\n"
                + "           eval(rowID);\n"
                + "           return false;\n"
                + "       }\n"
                + "           \n"
                + "        </script>\n");

        ret.append("<div id=\"grid1\" jsid=\"grid1\" dojoType=\"dojox.grid.DataGrid\" model=\"model\" structure=\"layout\" onRowDblClick=\"openOther\" autoWidth_=\"true\" rowsPerPage=\"10\" >\n</div>");

        url = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
        ret.append("<fieldset><button dojoType=\"dijit.form.Button\" onClick=location='" + url + "'>" + paramRequest.getLocaleString("BtnOSrch") + "</button></fieldset></div>");
        response.getWriter().write(ret.toString());
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/swbadmin/jsp/" + SWBASearchUsers.class.getSimpleName() + "/admin.jsp");            
            dispatcher.include(request, response);
        }
        catch (IOException e)
        {
            log.error(e);
        }
        catch (ServletException e)
        {
            log.error(e);
        }
    }

    /**
     * Do json data.
     *
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doJsonData(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html;charset=ISO-8859-1");
        String[] lista = (String[]) request.getSession(true).getAttribute("iteraUsers");
        //String repName = (String) request.getSession(true).getAttribute("iteraUsersRep");
        //UserRepository ur = SWBContext.getUserRepository(repName);
        JSONObject jobj = new JSONObject();
        JSONArray jarr = new JSONArray();
        try
        {
            JSONObject tjson = new JSONObject();
            jobj.put("numRows", lista.length);

            jobj.put("items", jarr);
        }
        catch (JSONException njse)
        {
        }
        int start = 0;
        int pag = pagezise;
        try
        {
            start = Integer.parseInt(request.getParameter("start"));
            pag = Integer.parseInt(request.getParameter("count"));
        }
        catch (NumberFormatException ne)
        {
        }
        int end = start + pag;
        while (start < end && start < lista.length)
        {
            // String[] valores = lista[start].split("\\|\\|");

            User usr = (User) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(lista[start]);
            //System.out.println(""+lista[start]+" - "+usr);
            JSONObject obj = new JSONObject();
            try
            {
                obj.put("@uri", "javascript:parent.addNewTab('" + lista[start] + "',null,'" + usr.getLogin() + "')");
                obj.put("login", usr.getLogin());
                obj.put("name", usr.getFirstName());
                obj.put("papellid", usr.getLastName());
                obj.put("sapellid", usr.getSecondLastName());
                obj.put("email", usr.getEmail());
                jarr.put(obj);
            }
            catch (JSONException jsone)
            {
            }
            start++;
        }
        response.getOutputStream().println(jobj.toString());
    }

    /**
     * Do roles.
     *
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doRoles(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        StringBuilder ret = new StringBuilder("");
        String usrep = request.getParameter("userRepository");
        User user = paramRequest.getUser();
        Iterator<Role> itroles = SWBContext.getUserRepository(usrep).listRoles();
        ret.append("<select name=\"userRoles\" id=\"userRoles" + usrep + "\" dojoType=\"dijit.form.FilteringSelect\" autocomplete=\"false\" >\n");
        ret.append("        <option value=\"\"></option>\n");
        while (itroles.hasNext())
        {
            Role role = itroles.next();
            ret.append("        <option value=\"" + role.getId() + "\">" + role.getDisplayTitle(user.getLanguage()) + "</option>\n"); //todo Add Language
        }
        ret.append("    </select>\n");
        response.getWriter().write(ret.toString());
    }

    /**
     * Do groups.
     *
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doGroups(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        StringBuilder ret = new StringBuilder("");
        String usrep = request.getParameter("userRepository");
        User user = paramRequest.getUser();
        Iterator<UserGroup> itgroup = SWBContext.getUserRepository(usrep).listUserGroups();
        ret.append("<select name=\"userGroups\" id=\"userGroups" + usrep + "\" dojoType=\"dijit.form.FilteringSelect\" autocomplete=\"false\" >\n");
        ret.append("        <option value=\"\"></option>\n");
        while (itgroup.hasNext())
        {
            UserGroup group = itgroup.next();
            ret.append("        <option value=\"" + group.getId() + "\">" + group.getDisplayTitle(user.getLanguage()) + "</option>\n"); //todo Add Language
        }
        ret.append("    </select>\n");
        response.getWriter().write(ret.toString());
    }


    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#processRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.semanticwb.portal.api.SWBParamRequest)
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        if (paramRequest.getMode().equals("search"))
        {
            doSearch(request, response, paramRequest);
        }
        else if (paramRequest.getMode().equals("roles"))
        {
            doRoles(request, response, paramRequest);
        }
        else if (paramRequest.getMode().equals("groups"))
        {
            doGroups(request, response, paramRequest);
        }
        else if (paramRequest.getMode().equals("jsonData"))
        {
            doJsonData(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }
}
