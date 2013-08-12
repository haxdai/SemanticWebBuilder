/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */
/*
 * Notification.java
 *
 * Created on 19 de abril de 2004, 18:53
 */
package com.infotec.wb.resources.repository;

//import com.infotec.appfw.exception.AFException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.*;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SWBMail;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/** Envia notificaciones a los usuarios que esten suscritos a los cambios
 * que se hagan a documentos en alguna carpeta o a un documento espec�fico.
 *
 * Send notification to subcribed users when a documents have changes to
 * an specific sub folder or an specific document.
 *
 * @author :INFOTEC
 * @version 1.0
 * @see infotec.wb2.core.Resource
 */
public class Notification {

    /**
     * Default constructor.
     *
     */
    org.semanticwb.model.Resource base = null;

    /**
     * Creates a new instance of Notification
     */
    public Notification() {
    }

    /** The User HTML view
     * @param request the input parameters
     * @param response The answer to the request
     * @param user A WBUser object
     * @param topic A topic object
     * @param arguments A list of arguments
     * @param tp A topic object
     * @param paramsRequest A list of objects (topic, user, action, ...)
     * @throws AFException An Application framework exception
     * @return The HTML view for the user
     */
    public String getHtml(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap arguments, WebPage tp, SWBParamRequest paramsRequest) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        String strRepacc = request.getParameter("repacc");
        String repobj = request.getParameter("repobj");

        if ("Notification".equals(repobj) && (strRepacc == null || (strRepacc != null && strRepacc.trim().equals("")))) {
            return sbfRet.toString();
        }
        if (strRepacc.equals("addtodir")) {
            sbfRet.append(subscribeToDirectory(request, response, user, topic, arguments, tp, paramsRequest));
        }
        if (strRepacc.equals("addtodoc")) {
            sbfRet.append(subscribeToDocument(request, response, user, topic, arguments, tp, paramsRequest));
        }
        if (strRepacc.equals("create")) {
            sbfRet.append(create(request, response, user, topic, arguments, tp, paramsRequest));
        }
        if (strRepacc.equals("rmtodir")) {
            sbfRet.append(unsubscribeToDirectory(request, response, user, topic, arguments, tp, paramsRequest));
        }
        if (strRepacc.equals("rmtodoc")) {
            sbfRet.append(unsubscribeToDocument(request, response, user, topic, arguments, tp, paramsRequest));
        }
        if (strRepacc.equals("remove")) {
            sbfRet.append(remove(request, response, user, topic, arguments, tp, paramsRequest));
        }
        return sbfRet.toString();
    }

    /**
     * Subscribe user to directory.
     * @return Regresa un nuevo String que contiene el c�digo html.
     * @param tp a topic object
     * @param paramsRequest a list of objects (topic, user, action, ...)
     * @param request El servlet container crea un objeto HttpServletRequest y
     *                      se pasa como argumento al m�todo del servlet.
     * @param response El servlet container crea un objeto HttpServletResponse y
     *                      se pasa como argumento al m�todo del servlet.
     * @param user El usuario concurrente que solicita el t�pico.
     * @param topic El t�pico que solicita el recurso.
     * @param arguments Argumentos del recurso en el template.
     * @throws AFException An Application Framework exception
     */
    public String subscribeToDirectory(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap arguments, WebPage tp, SWBParamRequest paramsRequest) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        sbfRet.append("<p>" + paramsRequest.getLocaleString("msgSubscribe2Dir") + "</p>");
        if (user == null || (user != null && user.getEmail() == null)) {
            sbfRet.append("<p>" + paramsRequest.getLocaleString("msgMustSign2Subscribe") + ".</p>");
            return sbfRet.toString();
        }
        String strReptp = request.getParameter("reptp");
        if (strReptp == null || (strReptp != null && strReptp.trim().equals(""))) {
            sbfRet.append("<p>" + paramsRequest.getLocaleString("msgSelectDir2Subscribe") + ".</p>");
            return sbfRet.toString();
        }

        sbfRet.append("\n<div id=\"suscribir\">");
        SWBResourceURL urlBack = paramsRequest.getRenderUrl();
        urlBack.setParameter("reptp", strReptp);
        sbfRet.append("\n<form method=\"get\">");
        sbfRet.append("\n<p><em>" + paramsRequest.getLocaleString("msgEmailNotify") + "</em></p>");
        sbfRet.append(showNotification(request, response, user, tp, paramsRequest, false));


        if (getLevelUser(user) == 3) {
            sbfRet.append(getRepositoryRoles(tp, request, paramsRequest, false));
        }
         sbfRet.append("\n <p class=\"botones\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"repacc\" value=\"create\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"repobj\" value=\"Notification\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"reptp\" value=\"" + strReptp + "\">");
        sbfRet.append("\n<input type=\"submit\" value=\"" + paramsRequest.getLocaleString("msgBTNSuscribe") + "\" >");
        sbfRet.append("\n<input type=\"button\" value=\"" + paramsRequest.getLocaleString("msgBTNCancel") + "\" onclick=\"javascript:window.location='" + urlBack.toString() + "';\" >");
        sbfRet.append("\n </p>");
         sbfRet.append("\n</div>");
        return sbfRet.toString();
    }

    /**
     * Subscribe user to document.
     *
     * @return Regresa un nuevo String que contiene el c�digo html.
     * @param tp A topic object
     * @param paramsRequest A list of object (topic, user, action, ...)
     * @param request El servlet container crea un objeto HttpServletRequest y
     *                      se pasa como argumento al m�todo del servlet.
     * @param response El servlet container crea un objeto HttpServletResponse y
     *                      se pasa como argumento al m�todo del servlet.
     * @param user El usuario concurrente que solicita el t�pico.
     * @param topic El t�pico que solicita el recurso.
     * @param arguments Argumentos del recurso en el template.
     * @throws AFException An Application Framework exception
     */
    public String subscribeToDocument(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap arguments, WebPage tp, SWBParamRequest paramsRequest) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        sbfRet.append("<p align=center class=Estilo6><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSubscribe2Doc") + "</font></p>");
        if (user == null || (user != null && user.getEmail() == null)) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgMustSign2Subscribe") + ".</font></p>");
            return sbfRet.toString();
        }
        String strReptp = request.getParameter("reptp");
        if (strReptp == null || (strReptp != null && strReptp.trim().equals(""))) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSelectDir2Subscribe") + ".</font></p>");
            return sbfRet.toString();
        }
        String strRepdocid = request.getParameter("repdocid");
        if (strRepdocid == null || (strRepdocid != null && strRepdocid.trim().equals(""))) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSelectDoc2Suscribe") + ".</font></p>");
            return sbfRet.toString();
        }

        SWBResourceURL urlBack = paramsRequest.getRenderUrl();
        urlBack.setParameter("reptp", strReptp);
        sbfRet.append("\n<form method=\"post\">");
        sbfRet.append("\n<table border=0 width=\"100%\"><tr><td align=center><font size=1 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgEmailNotify") + "</font></td></tr></table>");
        sbfRet.append(showNotification(request, response, user, tp, paramsRequest, false));
        sbfRet.append("\n<table border=0 width=\"100%\"><tr><td align=center><form method=\"post\">");
        if (getLevelUser(user) == 3) {
            sbfRet.append(getRepositoryRoles(tp, request, paramsRequest, false));
        }
        sbfRet.append("\n<input type=\"hidden\" name=\"repacc\" value=\"create\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"repobj\" value=\"Notification\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"reptp\" value=\"" + strReptp + "\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"repdocid\" value=\"" + strRepdocid + "\">");
        sbfRet.append("\n<input type=\"submit\" value=\"" + paramsRequest.getLocaleString("msgBTNSubscribe") + "\" >");
        sbfRet.append("\n<input type=\"button\" value=\"" + paramsRequest.getLocaleString("msgBTNCancel") + "\" onclick=\"javascript:window.location='" + urlBack.toString() + "';\" >");
        sbfRet.append("\n</td></tr></table></form>");
        return sbfRet.toString();
    }

    /**
     * Commits a new Notification to the database.
     *
     * @param tp a topic object
     * @param paramsRequest a list of objects (topic, user, action, ...)
     * @param request El servlet container crea un objeto HttpServletRequest y
     *                      se pasa como argumento al m�todo del servlet.
     * @param response El servlet container crea un objeto HttpServletResponse y
     *                      se pasa como argumento al m�todo del servlet.
     * @param user El usuario concurrente que solicita el t�pico.
     * @param topic El t�pico que solicita el recurso.
     * @param arguments Argumentos del recurso en el template.
     * @throws AFException An AF exception
     * @return The create action
     */
    public String create(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap arguments, WebPage tp, SWBParamRequest paramsRequest) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        Connection conn = null;
        PreparedStatement st = null;
        long id = 0;
        int count = 0;

        if (user == null || (user != null && user.getEmail() == null)) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgMustSign2Subscribe") + ".</font></p>");
            return sbfRet.toString();
        }

        try {
            if (request.getParameter("suscribe") != null && request.getParameter("suscribe").equals("1")) {
                String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
                conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.create()");
                st = conn.prepareStatement("INSERT INTO resrepositorynotify (rep_docid, idtm, topic, rep_email, rep_role) VALUES (?,?,?,?,?)");
                id = 0;
                try {
                    if (request.getParameter("repdocid") != null) {
                        id = Long.parseLong(request.getParameter("repdocid"));
                    }
                } catch (Exception noe) {
                    Repository.log.error("Error while trying to create a repository suscription.", noe);
                }
                st.setLong(1, id);
                st.setString(2, tp.getWebSiteId());
                st.setString(3, tp.getId());
                st.setString(4, user.getId());
                st.setInt(5, 0);
                count = st.executeUpdate();
                st.close();
                conn.close();
            } else {
                String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
                conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.create() -else-");
                st = conn.prepareStatement("DELETE from resrepositorynotify where rep_docid=? and idtm=? and topic=? and rep_email=?");
                id = 0;
                try {
                    if (request.getParameter("repdocid") != null) {
                        id = Long.parseLong(request.getParameter("repdocid"));
                    }
                } catch (Exception noe) {
                    Repository.log.error("Error while trying to delete a repository suscription.", noe);
                }
                st.setLong(1, id);
                st.setString(2, tp.getWebSiteId());
                st.setString(3, tp.getId());
                st.setString(4, user.getId());
                count = st.executeUpdate();
                st.close();
                conn.close();
            }
            updateRoleList(request, tp);

            if (count > 0) {
                sbfRet.append("\n<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSubscriptionRegisteredSuccessfully") + ":</font></p>");
            } else {
                sbfRet.append("\n<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgErrorRegisterSubscription") + ": </font></p>");
            }
            sbfRet.append(showNotification(request, response, user, tp, paramsRequest, true));
            sbfRet.append("\n<p align=center>");
            sbfRet.append("\n<form>");
            if (getLevelUser(user) == 3) {
                sbfRet.append(getRepositoryRoles(tp, request, paramsRequest, true));
            }
            sbfRet.append("\n<input type=\"hidden\" name=\"reptp\" value=\"" + tp.getId() + "\">");
            sbfRet.append("\n<table border=0 width=\"100%\"><tr><td align=center><input type=\"submit\" value=\"" + paramsRequest.getLocaleString("msgBTNAccept") + "\" ></td></tr></table>");
            sbfRet.append("\n</form>");

        } catch (SQLException e) {
            Repository.log.error(e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    conn = null;
                }
                conn = null;
            } catch (Exception e) {
            }
        }
        return sbfRet.toString();
    }

    /**
     * Cancel subscription on directory.
     *
     * @return Regresa un nuevo String que contiene el c�digo html.
     * @param tp A topic object
     * @param paramsRequest A list of object (topic, user, action, ...)
     * @param request El servlet container crea un objeto HttpServletRequest y
     *                      se pasa como argumento al m�todo del servlet.
     * @param response El servlet container crea un objeto HttpServletResponse y
     *                      se pasa como argumento al m�todo del servlet.
     * @param user El usuario concurrente que solicita el t�pico.
     * @param topic El t�pico que solicita el recurso.
     * @param arguments Argumentos del recurso en el template.
     * @throws AFException An Application Framework Exception
     */
    public String unsubscribeToDirectory(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap arguments, WebPage tp, SWBParamRequest paramsRequest) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        sbfRet.append("<p align=center class=Estilo6><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgCancelSubscriptionDirectory") + "</font></p>");
        if (user == null || (user != null && user.getEmail() == null)) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgMustSign2CancelSubscription") + ".</font></p>");
            return sbfRet.toString();
        }
        String strReptp = request.getParameter("reptp");
        if (strReptp == null || (strReptp != null && strReptp.trim().equals(""))) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSelectDirectory2CancelSubscription") + ".</font></p>");
            return sbfRet.toString();
        }

        SWBResourceURL urlBack = paramsRequest.getRenderUrl();
        urlBack.setParameter("reptp", strReptp);
        sbfRet.append("\n<form method=\"post\">");
        sbfRet.append("\n<table border=0 width=\"100%\"><tr><td align=center><font size=1 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgCancelEmailNotify") + "</font></td></tr></table>");
        sbfRet.append(showNotification(request, response, user, tp, paramsRequest, false));
        sbfRet.append("\n<table border=0 width=\"100%\"><tr><td align=center>");
        if (getLevelUser(user) == 3) {
            sbfRet.append(getRepositoryRoles(tp, request, paramsRequest, false));
        }
        sbfRet.append("\n<input type=\"hidden\" name=\"repacc\" value=\"remove\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"repobj\" value=\"Notification\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"reptp\" value=\"" + strReptp + "\">");
        sbfRet.append("\n<input type=\"submit\" value=\"" + paramsRequest.getLocaleString("msgBTNAccept") + "\" >");
        sbfRet.append("\n<input type=\"button\" value=\"" + paramsRequest.getLocaleString("msgBTNCancel") + "\" onclick=\"javascript:window.location='" + urlBack.toString() + "';\" >");
        sbfRet.append("\n</td></tr></table></form>");
        return sbfRet.toString();
    }

    /**
     * Cancel subscription on document.
     *
     * @return Regresa un nuevo String que contiene el c�digo html.
     * @param tp A topic object
     * @param paramsRequest A list of object (topic, user, action, ...)
     * @param request El servlet container crea un objeto HttpServletRequest y
     *                      se pasa como argumento al m�todo del servlet.
     * @param response El servlet container crea un objeto HttpServletResponse y
     *                      se pasa como argumento al m�todo del servlet.
     * @param user El usuario concurrente que solicita el t�pico.
     * @param topic El t�pico que solicita el recurso.
     * @param arguments Argumentos del recurso en el template.
     * @throws AFException An Application Framework Exception
     */
    public String unsubscribeToDocument(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap arguments, WebPage tp, SWBParamRequest paramsRequest) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        sbfRet.append("<p align=center class=Estilo6><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgCancelSubscriptionDoc") + "</font></p>");
        if (user == null || (user != null && user.getEmail() == null)) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgMustSign2CancelSubscription") + ".</font></p>");
            return sbfRet.toString();
        }
        String strReptp = request.getParameter("reptp");
        if (strReptp == null || (strReptp != null && strReptp.trim().equals(""))) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSelectDirectory2CancelSubscription") + ".</font></p>");
            return sbfRet.toString();
        }
        String strRepdocid = request.getParameter("repdocid");
        if (strRepdocid == null || (strRepdocid != null && strRepdocid.trim().equals(""))) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSelectDo2CancelSubscription") + ".</font></p>");
            return sbfRet.toString();
        }

        SWBResourceURL urlBack = paramsRequest.getRenderUrl();
        urlBack.setParameter("reptp", strReptp);
        sbfRet.append("\n<form method=\"post\">");
        sbfRet.append("\n<table border=0 width=\"100%\"><tr><td align=center><font size=1 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgCancelEmailNotify") + "</font></td></tr></table>");
        sbfRet.append(showNotification(request, response, user, tp, paramsRequest, false));
        sbfRet.append("\n<table border=0 width=\"100%\"><tr><td align=center>");
        if (getLevelUser(user) == 3) {
            sbfRet.append(getRepositoryRoles(tp, request, paramsRequest, false));
        }
        sbfRet.append("\n<input type=\"hidden\" name=\"repacc\" value=\"remove\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"repobj\" value=\"Notification\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"reptp\" value=\"" + strReptp + "\">");
        sbfRet.append("\n<input type=\"hidden\" name=\"repdocid\" value=\"" + strRepdocid + "\">");
        sbfRet.append("\n<input type=\"submit\" value=\"" + paramsRequest.getLocaleString("msgBTNAccept") + "\" >");
        sbfRet.append("\n<input type=\"button\" value=\"" + paramsRequest.getLocaleString("msgBTNCancel") + "\" onclick=\"javascript:window.location='" + urlBack.toString() + "';\" >");
        sbfRet.append("\n</td></tr></table></form>");
        return sbfRet.toString();
    }

    /**
     * Deletes a Notification from the database
     * @param tp A topic object
     * @param paramsRequest A list of object (topic, user, action, ...)
     * @param request El servlet container crea un objeto HttpServletRequest y
     *                      se pasa como argumento al m�todo del servlet.
     * @param response El servlet container crea un objeto HttpServletResponse y
     *                      se pasa como argumento al m�todo del servlet.
     * @param user El usuario concurrente que solicita el t�pico.
     * @param topic El t�pico que solicita el recurso.
     * @param arguments Argumentos del recurso en el template.
     * @throws AFException An Application Framework Exception
     * @return The remove of the suscription roles action
     */
    public String remove(HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap arguments, WebPage tp, SWBParamRequest paramsRequest) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        if (user == null || (user != null && user.getEmail() == null)) {
            sbfRet.append("<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgMustSign2CancelSubscription") + ".</font></p>");
            return sbfRet.toString();
        }
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            int count = 0;
            if (request.getParameter("suscribe") == null) {
                String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
                conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.remove()");
                pst = conn.prepareStatement("DELETE FROM resrepositorynotify WHERE rep_email=? and rep_docid=? and idtm=? and topic=?");

                long id = 0;
                try {
                    if (request.getParameter("repdocid") != null) {
                        id = Long.parseLong(request.getParameter("repdocid"));
                    }
                } catch (Exception noe) {
                    Repository.log.error("Error while trying to remove a repository suscription.", noe);
                }

                pst.setString(1, user.getId());
                pst.setLong(2, id);
                pst.setString(3, tp.getWebSiteId());
                pst.setString(4, tp.getId());
                count = pst.executeUpdate();
                pst.close();
                conn.close();
            }
            updateRoleList(request, tp);
            if (count > 0) {
                sbfRet.append("\n<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgSubscriptionCanceledSuccessfully") + ": </font></p>");
            } else {
                sbfRet.append("\n<p align=center><font size=2 face=\"Verdana, Arial, Helvetica, sans-serif\">" + paramsRequest.getLocaleString("msgErrorCancelSubscription") + ": </font></p>");
            }
            sbfRet.append("\n<form>");
            sbfRet.append(showNotification(request, response, user, tp, paramsRequest, true));
            if (getLevelUser(user) == 3) {
                sbfRet.append(getRepositoryRoles(tp, request, paramsRequest, true));
            }
            sbfRet.append("\n<input type=\"hidden\" name=\"reptp\" value=\"" + tp.getId() + "\">");
            sbfRet.append("\n<table border=\"0\" width=\"100%\">");
            sbfRet.append("\n<tr><td align=center><input type=\"submit\" value=\"" + paramsRequest.getLocaleString("msgBTNAcceptLast") + "\" ></td></tr>");
            sbfRet.append("\n</table>");
            sbfRet.append("\n</form>");
        } catch (SQLException e) {
            Repository.log.error(e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    conn = null;
                }
                conn = null;
            } catch (Exception e) {
            }
        }
        return sbfRet.toString();
    }

    /**
     * Get the suscribed roles form
     * @param bloquear a true or false value if needs disable html control
     * @param request Input parameters
     * @param response The answer to the request
     * @param user a WBUser object
     * @param tp A topic object
     * @param paramsRequest a list of objects (topic, user, action, ...)
     * @throws AFException An exception of type AF (Application Framework)
     * @return a list of the suscribed roles
     */
    public String showNotification(HttpServletRequest request, HttpServletResponse response, User user, WebPage tp, SWBParamRequest paramsRequest, boolean bloquear) throws  SWBResourceException, IOException {
        StringBuffer sbfRet = new StringBuffer();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String strbloqueado = "";
        if (bloquear) {
            strbloqueado = " disabled ";
        }


        if (request.getParameter("repdocid") == null || (request.getParameter("repdocid") != null && request.getParameter("repdocid").trim().length() == 0)) {
            try {

                String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
                conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.showNotification()");
                String strQuery = "select * from resrepositorynotify where idtm=? and topic=? and rep_email=? and rep_docId=?";
                pst = conn.prepareStatement(strQuery);
                pst.setString(1, tp.getWebSiteId());
                pst.setString(2, tp.getId());
                pst.setString(3, user.getId());
                pst.setLong(4, 0);
                rs = pst.executeQuery();
                String strSelect = "";
                if (rs.next()) {
                    strSelect = " checked ";
                }
                rs.close();
                pst.close();
                conn.close();
                sbfRet.append("\n<p><strong>" + paramsRequest.getLocaleString("msgUser") + ":</strong>");
                sbfRet.append("\n<input type=\"checkbox\" name=\"suscribe\" value=\"1\" " + strSelect + " " + strbloqueado + " id=\"" + user.getEmail() + "\" /><label for=\"" + user.getEmail() + "\">" + user.getEmail() + "</label></p>");
                sbfRet.append("\n<p><strong>" + paramsRequest.getLocaleString("msgDirectory") + ":</strong>");
                sbfRet.append("\n"+ tp.getDisplayName() + "</p>");
            } catch (Exception e) {
                Repository.log.error("Error while check the user directory suscription. ",e);
            }
        }
        if (request.getParameter("repdocid") != null && request.getParameter("repdocid").trim().length() > 0) {
            try {

                String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
                conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.showNotification() -2-");
                pst = conn.prepareStatement("select * from resrepositorynotify where rep_docId=? and idtm=? and topic=? and rep_email=? ");
                pst.setInt(1, Integer.parseInt(request.getParameter("repdocid")));
                pst.setString(2, tp.getWebSiteId());
                pst.setString(3, tp.getId());
                pst.setString(4, user.getId());
                rs = pst.executeQuery();

                String strSelect = "";
                if (rs.next()) {
                    strSelect = " checked ";
                }
                rs.close();
                pst.close();
                conn.close();

                pst = conn.prepareStatement("select * from resrepository where rep_docid=? and idtm=? ");
                pst.setInt(1, Integer.parseInt(request.getParameter("repdocid")));
                pst.setString(2, tp.getWebSiteId());
                rs = pst.executeQuery();
                String titledoc = "";

                if (rs.next()) {
                    titledoc = rs.getString("rep_title");
                }
                rs.close();
                pst.close();
                conn.close();

                sbfRet.append("\n<p><strong>" + paramsRequest.getLocaleString("msgUser") + ":</strong>");
                sbfRet.append("\n<input type=\"checkbox\" name=\"suscribe\" value=\"1\" " + strSelect + " " + strbloqueado + "  id=\"" + user.getEmail() + "\" /><label for=\"" + user.getEmail() + "\">" + user.getEmail() + "</label></p>");
                sbfRet.append("\n<p><strong>" + paramsRequest.getLocaleString("msgDirectory") + ":</strong>");
                sbfRet.append("\n" + tp.getDisplayName() + "</p>");
                if (titledoc.trim().length() > 0) {
                    sbfRet.append("\n<p><strong>" + paramsRequest.getLocaleString("msgDocTitle") + ":</strong>" + titledoc + "</p>");
                }

            } catch (Exception e) {
                Repository.log.error("Error while trying to get repository document title. Notification.showNotification()",e);
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                        conn = null;
                    }
                    conn = null;
                } catch (Exception e) {
                }
            }
        }

        sbfRet.append("\n</table>");
        return sbfRet.toString();
    }

    /**
     * Get the list of the files suscriptions
     * @param user A WBUser object
     * @param dir A topic that represents a directory
     * @return An array list with the files ids
     */
    public ArrayList getSubscriptions(User user, WebPage dir) {
        ArrayList arr = new ArrayList();
        if (user == null || (user != null && (user.getEmail() == null)) || dir == null) {
            return arr;
        }
        try {
            String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
            Connection conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.getSubscriptions()");
            PreparedStatement pst = conn.prepareStatement("SELECT rep_docId FROM resrepositorynotify WHERE rep_email=? AND idtm=? AND topic=?");
            pst.setString(1, user.getId());
            pst.setString(2, dir.getWebSiteId());
            pst.setString(3, dir.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("rep_docId");
                arr.add(new Long(id));

            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            Repository.log.error(e);
        }

        return arr;
    }

    /**
     * Get the role suscription form
     * @param dir A topic object that represents a directory or a folder
     * @param request input parameters
     * @param paramsRequest a list of objects (topic, user, action, ...)
     * @param readonly a flag that indicates if it's read only or not
     * @return A role suscription form
     */
    public String getRepositoryRoles(WebPage dir, HttpServletRequest request, SWBParamRequest paramsRequest, boolean readonly) {

        HashMap hmroles = getDirRoles(dir, request);
        StringBuffer ret = new StringBuffer();
        User usr = paramsRequest.getUser();
        String rep = paramsRequest.getUser().getUserRepository().getId();
        UserRepository usrRep = paramsRequest.getUser().getUserRepository();
        Iterator<Role> enuRoles = Role.ClassMgr.listRoles((SWBModel)usrRep);
        try {
            if (!readonly) {
                ret.append("\n<p><strong>" + paramsRequest.getLocaleString("msgRoleEmailNotify") + "<br/>");
                ret.append("\n" + paramsRequest.getLocaleString("msgCancelRoleEmailNotify") + ".</strong></p>");
            }
            ret.append("\n<p><strong>" + paramsRequest.getLocaleString("msgSelectRoles") + ": </strong></p>");
        } catch (Exception e) {
            Repository.log.error(e);
        }
        String blocked = "";
        if (readonly) {
            blocked = " disabled ";
        }
        while (enuRoles.hasNext()) {
            Role rRol = enuRoles.next();
            String strSelect = "";
            if (hmroles.get(rRol.getId()) != null) {
                strSelect = " checked ";
            }
            ret.append("\n<p><input name=\"roleid" + rRol.getId() + "\" type=\"checkbox\" value=\"" + rRol.getId() + "\" " + strSelect + " " + blocked + "  id=\"" + rRol.getId() + "\"> <label for=\"" + rRol.getId() + "\">" + rRol.getDisplayTitle(usr.getLanguage()) + "</label></p>");
        }
        return ret.toString();
    }

    /**
     * Get a list of roles
     * @param dir A topic object that represents a directory or a folder
     * @param request input parameters
     * @return A Hashmap with the roles ids
     */
    public HashMap getDirRoles(WebPage dir, HttpServletRequest request) {

        HashMap hmroles = new HashMap();
        Connection conn = null;
        PreparedStatement st = null;

        String docid = request.getParameter("repdocid");
        if (docid == null || (docid != null && docid.trim().length() == 0)) {
            docid = "0";
        }
        long ldocid = Long.parseLong(docid);
        try {
            String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
            conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.getDirRoles()");
            st = conn.prepareStatement("SELECT rep_role FROM resrepositorynotify WHERE idtm=? and topic=? and rep_role<>? and rep_docid=?");
            st.setString(1, dir.getWebSiteId());
            st.setString(2, dir.getId());
            st.setInt(3, 0);
            st.setLong(4, ldocid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("rep_role");
                hmroles.put(Integer.toString(id), Integer.toString(id));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            Repository.log.error("Error while get directory roles",e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    conn = null;
                }
                conn = null;
            } catch (Exception e) {
            }
        }
        return hmroles;
    }

    /**
     * Evaluate if the role list need to be updated
     * @param request The input parameters
     * @param dir A topic object that represents a folder
     * @return True or false if the action has completed
     */
    private boolean updateRoleList(HttpServletRequest request, WebPage dir) {
        Connection conn = null;
        PreparedStatement st = null;
        PreparedStatement st2 = null;
        String docid = request.getParameter("repdocid");
        if (docid == null || (docid != null && docid.trim().length() == 0)) {
            docid = "0";
        }
        long ldocid = Long.parseLong(docid);
        try {
            String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
            conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.updateRoleList()");
            st = conn.prepareStatement("DELETE from resrepositorynotify where rep_docid=? and idtm=? and topic=? and rep_role<>?");
            st.setLong(1, ldocid);
            st.setString(2, dir.getWebSiteId());
            st.setString(3, dir.getWebSiteId());
            st.setInt(4, 0);
            st.executeUpdate();
            st.close();
            Enumeration enuParams = request.getParameterNames();
            while (enuParams.hasMoreElements()) {
                String parametro = (String) enuParams.nextElement();

                if (parametro.startsWith("roleid")) {
                    String token = request.getParameter(parametro);
                    st2 = conn.prepareStatement("INSERT INTO resrepositorynotify (rep_docid, idtm, topic, rep_email, rep_role) VALUES (?, ?, ?, ?, ?)");
                    st2.setLong(1, ldocid);
                    st2.setString(2, dir.getWebSiteId());
                    st2.setString(3, dir.getWebSiteId());
                    st2.setString(4, "0");
                    st2.setInt(5, Integer.parseInt(token));
                    st2.executeUpdate();
                    st2.close();
                }
            }
            conn.close();
        } catch (Exception e) {
            Repository.log.error("Error while updating role list in Repository.Notification.updateRoleList",e);
            return false;
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    conn = null;
                }
                conn = null;
            } catch (Exception e) {
            }
        }

        return true;
    }

    /*
    public boolean subscribedToDocument(HttpServletRequest request, HttpServletResponse response, User user, Topic topic)
    {
    String strReptp=request.getParameter("reptp");
    String strRepdocid=request.getParameter("repdocid");
    return subscribedToDocument(strReptp, strRepdocid, user, topic);
    }

    public boolean subscribedToDocument(String reptp, String repdocid, User user, Topic topic)
    {
    boolean bOk=false;
    if(reptp==null || (reptp!=null && reptp.trim().equals("")) ||
    repdocid==null || (repdocid!=null && repdocid.trim().equals("")) ||
    user==null || (user!=null && user.getEmail()==null) ||
    topic==null) return bOk;
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    try
    {
    conn = WBUtils.getInstance().getDBConnection();
    stmt = conn.createStatement ();
    String dbQuery = "SELECT count(*) FROM resrepositorynotify WHERE ";
    dbQuery += " rep_email='"+ user.getEmail() + "'";
    dbQuery += " AND rep_docid="+ repdocid;
    dbQuery += " AND topic='"+ topic.getMap().getId()+"|"+ reptp +"'";
    rs = stmt.executeQuery (dbQuery);
    int count=0;
    while(rs.next()) count=rs.getInt("count(*)");
    rs.close();
    stmt.close();
    conn.close();
    if(count > 0) bOk=true;
    } catch(SQLException e) { WBUtils.getInstance().log(e,"",true); }
    finally
    {
    try
    {
    if(rs!=null) rs.close();
    if(stmt!=null) stmt.close();
    if(conn!=null) conn.close();
    } catch (SQLException e) { WBUtils.getInstance().log(e,"",true); }
    }
    return bOk;
    }
     */
    /**
     * Send files changes notifications to the suscribed users
     * @param user The WBUser object
     * @param base The resource object
     * @param docid The file identifier
     * @param title The title of the document
     * @param description The description of the document
     * @param filename The file name asociated
     * @param comment Aditional comments
     * @param fileDate The creation date of the file
     * @param version The file version
     * @param action The action performed
     * @param dir The topic object that represent a directory
     * @param paramsRequest a list of object (topic, user, action, ...)
     * @throws AFException An exception of type AF (Application framework)
     */
    public void sendNotification(User user, org.semanticwb.model.Resource base, long docid, String title, String description, String filename, String comment, String fileDate, int version, String action, WebPage dir, SWBParamRequest paramsRequest, HttpServletRequest request) throws  SWBResourceException, IOException {

        WebSite wsite = paramsRequest.getWebPage().getWebSite();
        UserRepository urepo = wsite.getUserRepository();
        HashMap hmemails = new HashMap();
        String repositorio = paramsRequest.getUser().getUserRepository().getId();
        String strNotify = base.getAttribute("notify" + action, paramsRequest.getLocaleString("msgTheDocument") + " {getDocTitle} " + paramsRequest.getLocaleString("msgWasChanged") + " (" + action + ")");
        strNotify = strNotify.replaceAll("\\{getUserName\\}", "<b>" + user.getName() + "</b>");
        if (user.getEmail() != null) {
            strNotify = strNotify.replaceAll("\\{getUserEmail\\}", "<b><a href=\"mailto:" + user.getEmail() + "\">" + user.getEmail() + "</a></b>");
        } else {
            strNotify = strNotify.replaceAll("\\{getUserEmail\\}", "no_email");
        }
        strNotify = strNotify.replaceAll("\\{getDirectoryName\\}", "<b>" + dir.getDisplayName() + "</b>");
        strNotify = strNotify.replaceAll("\\{getFileName\\}", "<b>" + filename + "</b>");
        strNotify = strNotify.replaceAll("\\{getDocTitle\\}", "<b>" + title + "</b>");
        strNotify = strNotify.replaceAll("\\{getDocDesc\\}", "<b>" + description + "</b>");
        strNotify = strNotify.replaceAll("\\{getDocVersion\\}", "<b>" + version + "</b>");
        SWBResourceURL urlline = paramsRequest.getRenderUrl();
        urlline.setCallMethod(urlline.Call_DIRECT);
        String host_name = request.getServerName();

        String port = "";
        if (request.getServerPort() != 80) {
            port += ":" + request.getServerPort();
        }

        String liga_archivo = "<b>" + "<a target='_new' href='http://" + host_name + port + urlline + "/" + filename + "?repfop=view&reptp=" + dir.getId() + "&repfiddoc=" + Long.toString(docid) + "&repinline=true'>" + filename + "</a></b>";
        strNotify = strNotify.replaceAll("\\{getDocLink\\}", liga_archivo);
        strNotify = strNotify.replaceAll("\\{getLastUpdate\\}", "<b>" + fileDate + "</b>");
        strNotify = strNotify.replaceAll("\\{getComments\\}", "<b>" + comment + "</b>");

        try {

            // encontrando usuarios suscritos al directorio o documento para notificaci�n

            String tmp_conn = SWBPlatform.getEnv("wb/db/nameconn", "wb");
            Connection conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.sendNotification()");
            PreparedStatement pst = conn.prepareStatement("select rep_email from resrepositorynotify where idtm=? and topic=? and (rep_docid=0 or rep_docid=?) and rep_role=? group by rep_email");
            pst.setString(1, dir.getWebSiteId());
            pst.setString(2, dir.getId());
            pst.setLong(3, docid);
            pst.setInt(4, 0);
            ResultSet rs = pst.executeQuery();

            // agregando emails de usuarios suscritos
            int encontrados = 0;
            while (rs.next()) {
                User ruser = urepo.getUser(rs.getString("rep_email"));
                if (ruser.isActive()) {
                    hmemails.put(ruser.getEmail(), ruser.getEmail());
                    encontrados++;
                }

            }
            rs.close();
            pst.close();
            conn.close();

            // se revisa si hereda notificaci�n de una carpeta padre

            conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.sendNotification() -2-");
            pst = conn.prepareStatement("select idtm, topic, rep_email from resrepositorynotify where (rep_docid=0 or rep_docid=?) and rep_role=? and idtm=?");
            pst.setLong(1, docid);
            pst.setInt(2, 0);
            pst.setString(3, dir.getWebSiteId());
            rs = pst.executeQuery();
            // agregando emails de usuarios suscritos

            while (rs.next()) {
                String strTopic = rs.getString("topic");

                //Topic tp2 = dir.getMap().getTopic(strTopic.substring(strTopic.lastIndexOf("|")+1));
                WebPage tp2 = dir.getWebSite().getWebPage(strTopic);
                if (dir.isChildof(tp2)) {
                    User ruser = urepo.getUser(rs.getString("rep_email"));
                    if (ruser.isActive()) {
                        hmemails.put(ruser.getEmail(), ruser.getEmail());
                        //hmemails.put(DBUser.getInstance().getUserById(rs.getString("rep_email")).getEmail(),DBUser.getInstance().getUserById(rs.getString("rep_email")).getEmail());
                    }
                }
            }
            rs.close();
            pst.close();
            conn.close();

            // encontrando roles suscritos al directorio o documento para enviar la notificaci�n
            encontrados = 0;

            conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.sendNotification() -3-");
            pst = conn.prepareStatement("select rep_role from resrepositorynotify where idtm=? and topic=? and (rep_docid=0 or rep_docid=?) and rep_email=? group by rep_role");
            pst.setString(1, dir.getWebSiteId());
            pst.setString(2, dir.getId());
            pst.setLong(3, docid);
            pst.setString(4, "0");
            rs = pst.executeQuery();

            // encontrando usuarios que tengan el rol suscrito al documento o al directorio

            User usr = user;

            while (rs.next()) {
                String strrole = rs.getString("rep_role");
                Role rol = usr.getUserRepository().getRole(strrole);
                Iterator<User> enuUsers = usr.getUserRepository().listUsers();
                while (enuUsers.hasNext()) {
                    User rUser = enuUsers.next();

                    if (rUser.isActive() && rUser.hasRole(rol)) {
                        hmemails.put(rUser.getEmail(), rUser.getEmail());
                        encontrados++;
                    }
                }
            }

            rs.close();
            pst.close();
            conn.close();

            // encontrando roles suscritos al directorio o documento para enviar la notificaci�n, HEREDADOS

            conn = SWBUtils.DB.getConnection(tmp_conn, "Notification.sendNotification() -4-");
            pst = conn.prepareStatement("select rep_role, topic  from resrepositorynotify where (rep_docid=0 or rep_docid=?) and rep_email=? and idtm=? group by rep_role, topic");

            pst.setLong(1, docid);
            pst.setString(2, "0");
            pst.setString(3, dir.getWebSiteId());
            rs = pst.executeQuery();

            // encontrando usuarios que tengan el rol suscrito al documento o al directorio

            while (rs.next()) {
                String strTopic = rs.getString("topic");
                //Topic tp2 = dir.getMap().getTopic(strTopic.substring(strTopic.lastIndexOf("|")+1));
                WebPage tp2 = dir.getWebSite().getWebPage(strTopic);
                if (dir.isChildof(tp2)) {
                    String strrole = rs.getString("rep_role");
                    Role rol = usr.getUserRepository().getRole(strrole);
                    Iterator<User> enuUsers = usr.getUserRepository().listUsers();
                    while (enuUsers.hasNext()) {
                        User rUser = enuUsers.next();
                        if (rUser.isActive() && rUser.hasRole(rol)) {
                            hmemails.put(rUser.getEmail(), rUser.getEmail());
                        }
                    }
                }
            }

            rs.close();
            pst.close();
            conn.close();



            // generando lista de emails para enviar la notificaci�n
            String from = SWBPlatform.getEnv("af/adminEmail", "webbuilder@infotec.com.mx");
            StringBuffer send2emails = new StringBuffer();
            Iterator iteemails = hmemails.keySet().iterator();
            while (iteemails.hasNext()) {
                String email2send = (String) iteemails.next();

                //Set the email pattern string
                Pattern p = Pattern.compile("[a-zA-Z]*[0-9]*@[a-zA-Z]*.[a-zA-Z]*");

                //Match the given string with the pattern
                Matcher m = p.matcher(email2send);

                //check whether match is found
                boolean matchFound = m.matches();

                if (matchFound)
                {
                    try {
                        SWBMail mm = new SWBMail();
                        mm.setSubject(paramsRequest.getLocaleString("msgDocChanges") + " " + base.getTitle() + " " + paramsRequest.getLocaleString("msgFromSite") + " " + base.getWebSite().getTitle());
                        mm.setFromEmail(from);
                        mm.addAddress(email2send);
                        strNotify = "<table border=0 cellpadding=5 cellspacing=0><tr><td align=left>" + strNotify + "</td></tr></table>";
                        mm.setData(strNotify);

                        try {
                            SWBUtils.EMAIL.sendBGEmail(mm);
                        } catch (Exception e) {
                            Repository.log.error("Error while trying to send a Notification e-mail. Repository.Notification.sendNotification() to email:" + email2send,e);
                        }
                        //AFUtils.getInstance().sendBGEmail(email2send,paramsRequest.getLocaleString("msgDocChanges")+" "+base.getTitle()+" "+paramsRequest.getLocaleString("msgFromSite")+" "+base.getTopicMap().getDbdata().getTitle(),strNotify);
                    }
                    catch (Exception exc) {
                        Repository.log.error("Error while trying to send a Notification e-mail. Repository.Notification.sendNotification()", exc);
                    }
                }
                //send2emails.append(email2send);
                //send2emails.append(", ");
            }
            //String listaEmails ="";

            //listaEmails = send2emails.toString();



            //if(listaEmails!=null && listaEmails.trim().length()>0)
            //{
            //listaEmails = listaEmails.substring(0,listaEmails.lastIndexOf(", "));
            //AFUtils.getInstance().sendBGEmail(send2emails.toString(),paramsRequest.getLocaleString("msgDocChanges")+" "+base.getTitle()+" "+paramsRequest.getLocaleString("msgFromSite")+" "+base.getTopicMap().getDbdata().getTitle(),strNotify);
            //}

        } catch (SQLException e) {
            Repository.log.error("Error while trying to send a Changes Repository Notification.",e);
        }

        //strNotify.replaceAll("{getUserName}", user.getFirstName() +" "+ user.getLastName());
    }

    /**
     * Get the user level in the repository
     * @param user A user object
     * @return The number of the user level
     */
    public int getLevelUser(User user) {
        int level=0;
        String adm=base.getAttribute("admin");
        User usr = user;
        UserRepository usrRep = usr.getUserRepository();
        Role rol = null;
        if(adm!=null)
        {
            rol = usrRep.getRole(adm);
            //int r=Integer.parseInt(adm);
            if(user.hasRole(rol)) level=3;
        }
        else level=3;

        if(level==0)
        {
            String mdy=base.getAttribute("modify");
            if(mdy!=null)
            {
                rol = usrRep.getRole(mdy);
                //int r=Integer.parseInt(mdy);
                if(user.hasRole(rol)) level=2;
            }
            else level=2;
        }

        if(level==0)
        {
            String viw=base.getAttribute("view");
            if(viw!=null)
            {
                rol = usrRep.getRole(viw);
                //int r=Integer.parseInt(viw);
                 if(user.hasRole(rol)) level=1;
            }
            else level=1;
        }
        return level;
    }

    /**
     * Load the resource object information
     * @param base The resource object
     */
    public void setResourceBase(org.semanticwb.model.Resource base) {
        try {
            this.base = base;
        } catch (Exception e) {
            Repository.log.error("Error in set resource base of Notification", e);
        }
    }
}
