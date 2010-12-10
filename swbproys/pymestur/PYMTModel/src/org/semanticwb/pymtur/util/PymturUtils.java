/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.pymtur.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.TemplateImp;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author jorge.jimenez
 */
public class PymturUtils {

    //PAQUETES
    public static final int PAQ_DIRECTORIO = 1;
    public static final int PAQ_FICHA = 2;
    public static final int PAQ_MICROSITIO = 3;
    public static final int PAQ_PREMIER = 4;
    //ESTATUS
    public static final int ESTATUS_REGISTRADO = 1;
    public static final int ESTATUS_ACEPTADO = 2;
    public static final int ESTATUS_RECHAZADO = 3;
    public static final int ESTATUS_PAGADO = 4;
    public static final int ESTATUS_PUBLICADO = 5;
    public static final int ESTATUS_BORRADO = 6;
    public static final int ESTATUS_VENCIDA = 7;

    //COMMENT TYPES
    public static final int COMMENT_STATUS = 1;
    public static final int COMMENT_USER = 2;
    public static final int COMMENT_ELEMENT = 3;

    private static Logger log = SWBUtils.getLogger(PymturUtils.class);


    public static boolean logServiceProvider(ServiceProvider serviceProvider,
            User user, String elementUri, int status, int commenttype,
            String comment) {

        Connection con = null;
        try {
            Timestamp created = new Timestamp(new java.util.Date().getTime());
            con = SWBUtils.DB.getDefaultConnection("PymturUtils:logServiceProvider");

            String query = "insert into swb_pymesturlog (sprovuri, usruri, "
                    + "elementuri, status, commenttype, comment, date) values "
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, serviceProvider.getURI());
            st.setString(2, user != null ? user.getURI() : "");
            st.setString(3, elementUri);
            st.setInt(4, status);
            st.setInt(5, commenttype);
            st.setString(6, comment);
            st.setTimestamp(7, created);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception e) {
            log.error(e);
        }

        /*
        try
        {
            con = SWBUtils.DB.getDefaultConnection();
            String query = "select * from swb_pymesturlog";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            int cont=1;
            while (rs.next())
            {
                System.out.println(cont+".-sprovuri:"+rs.getString("sprovuri"));
                System.out.println(cont+".-usruri:"+rs.getString("usruri"));
                System.out.println(cont+".-elementuri:"+rs.getString("elementuri"));
                System.out.println(cont+".-comment:"+rs.getString("comment"));
                System.out.println(cont+".-modified:"+rs.getString("modified"));
                cont++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e)
        {
            log.event(e);
        }*/
        
        return true;
    }

    public static String replaceTagsRegistry(String str,
            HttpServletRequest request, SWBActionResponse paramRequest,
            User newUser, String siteName, ServiceProvider sprovider) {

        if (str == null || str.trim().length() == 0) {
            return "";
        }
        str = str.trim();
        int ipaquete = sprovider.getPymePaqueteType();
        String staticText = "";
        if (ipaquete == PAQ_FICHA) {
            staticText = staticText + " la ficha, con los datos de tu empresa, en el portal \"Siente México\". <br/><br/>";
        } else if (ipaquete == PAQ_MICROSITIO) {
            staticText = staticText + " tu Micrositio.<br/><br/>";
        } else if (ipaquete == PAQ_PREMIER) {
            staticText = staticText + " tu página web.<br/><br/>";
        }
        str = SWBUtils.TEXT.replaceAll(str, "{pyme.type}", staticText);
        return replaceTags(str, request, paramRequest, newUser, siteName, sprovider);
    }

    public static String replaceTagsAcceptRegistry(String str,
            HttpServletRequest request, SWBActionResponse paramRequest,
            User newUser, String siteName, ServiceProvider sprovider,
            WebPage pageFicha) {

        if (str == null || str.trim().length() == 0) {
            return "";
        }
        str = str.trim();

        String staticText = "";
        int ipaquete = sprovider.getPymePaqueteType();
        if (ipaquete == PAQ_FICHA) {
            staticText = staticText + " la ficha";
        } else if (ipaquete == PAQ_MICROSITIO) {
            staticText = staticText + " tu Micrositio";
        } else if (ipaquete == PAQ_PREMIER) {
            staticText = staticText + " tu página web";
        }
        str = SWBUtils.TEXT.replaceAll(str, "{pyme.type}", staticText);

        if (sprovider.getPymePaqueteType() == PAQ_FICHA && pageFicha != null) {
            String server = "http://" + request.getServerName() + ":" + request.getServerPort();
            str = SWBUtils.TEXT.replaceAll(str, "{pyme.link}",
                    server + pageFicha.getUrl() + "?uri="
                    + sprovider.getEncodedURI() + "&act=detail<br/><br/>");
        } else if (sprovider.getPymePaqueteType() == PAQ_PREMIER) {
            String server = "http://" + request.getServerName() + ":" + request.getServerPort();
            str = SWBUtils.TEXT.replaceAll(str, "{pyme.link}",
                    server + sprovider.getMicroSitePymeInv().getUrl() + "<br/><br/>");
        }

        if (sprovider.getPymePaqueteType() > PAQ_MICROSITIO && sprovider.getPymeDomain() != null) {
            str = SWBUtils.TEXT.replaceAll(str, "{pyme.dns}",
                    "-El dominio registrado es:<br/><br/>" + sprovider.getPymeDomain() + "<br/><br/>");
        } else {
            str = SWBUtils.TEXT.replaceAll(str, "{pyme.dns}", " ");
        }
        return replaceTags(str, request, paramRequest, newUser, siteName, sprovider);
    }

    public static String replaceTagsRejectRegistry(String str, 
            HttpServletRequest request, SWBActionResponse paramRequest,
            User newUser, String siteName, ServiceProvider sprovider) {

        if (str == null || str.trim().length() == 0) {
            return "";
        }
        str = str.trim();

        String StatusReject = sprovider.getSpStatusComment();
        if (StatusReject != null && StatusReject.trim().length() > 0) {
            str = SWBUtils.TEXT.replaceAll(str, "{pyme.msgreject}", "<br/>" + StatusReject);
        } else {
            str = SWBUtils.TEXT.replaceAll(str, "{pyme.msgreject}",
                    "<br/>-	Su empresa no es considerada una empresa turística <br/> -Sus datos están incompletos o son erróneos<br/>");
        }
        return replaceTags(str, request, paramRequest, newUser, siteName, sprovider);
    }

    public static String replaceTags(String str, HttpServletRequest request,
            SWBActionResponse paramRequest, User newUser, String siteName,
            ServiceProvider sprovider) {

        if (str == null || str.trim().length() == 0) {
            return "";
        }

        str = str.trim();

        Iterator it = SWBUtils.TEXT.findInterStr(str, "{request.getParameter(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str, "{request.getParameter(\"" + s + "\")}",
                    request.getParameter(replaceTags(s, request, paramRequest,
                                         newUser, siteName, sprovider)));
        }

        it = SWBUtils.TEXT.findInterStr(str, "{session.getAttribute(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str, "{session.getAttribute(\"" + s + "\")}",
                    (String) request.getSession().getAttribute(replaceTags(s,
                            request, paramRequest, newUser, siteName, sprovider)));
        }

        it = SWBUtils.TEXT.findInterStr(str, "{getEnv(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str, "{getEnv(\"" + s + "\")}",
                    SWBPlatform.getEnv(replaceTags(s, request, paramRequest,
                                       newUser, siteName, sprovider)));
        }

        str = SWBUtils.TEXT.replaceAll(str, "{user.login}", paramRequest.getUser().getLogin());
        str = SWBUtils.TEXT.replaceAll(str, "{user.email}", paramRequest.getUser().getEmail());
        str = SWBUtils.TEXT.replaceAll(str, "{user.language}", paramRequest.getUser().getLanguage());
        str = SWBUtils.TEXT.replaceAll(str, "{webpath}", SWBPortal.getContextPath());
        str = SWBUtils.TEXT.replaceAll(str, "{distpath}", SWBPortal.getDistributorPath());
        str = SWBUtils.TEXT.replaceAll(str, "{webworkpath}", SWBPortal.getWebWorkPath());
        str = SWBUtils.TEXT.replaceAll(str, "{workpath}", SWBPortal.getWorkPath());
        str = SWBUtils.TEXT.replaceAll(str, "{websiteid}", paramRequest.getWebPage().getWebSiteId());
        str = SWBUtils.TEXT.replaceAll(str, "{user}", newUser.getFullName());
        str = SWBUtils.TEXT.replaceAll(str, "{siteName}", siteName);
        str = SWBUtils.TEXT.replaceAll(str, "{pyme.title}", sprovider.getTitle());

        if (str.indexOf("{templatepath}") > -1) {
            //TODO:pasar template por paramrequest
            TemplateImp template = (TemplateImp) SWBPortal.getTemplateMgr().getTemplate(
                        paramRequest.getUser(), paramRequest.getWebPage());
            str = SWBUtils.TEXT.replaceAll(str, "{templatepath}", template.getActualPath());
        }
        return str;
    }

    public static int countEnterChars(String data, int max) {

        int cont = 0;
        if (data != null) {
            int indexA = 0;
            while (indexA != -1 ) {
                indexA = data.indexOf("\n", indexA);
                if (indexA <= max) {
                    if (indexA != -1 ) {
                        indexA++;
                        cont++;
                        max++;
                    }
                } else {
                    indexA = -1;
                }
            }
        }
        return cont;
    }

    public static boolean validateRegExp(String textSource, String regExp) {

        Pattern p = Pattern.compile(regExp);//regular expression
        Matcher m = p.matcher(textSource); // the text source
        return m.find();
    }
}
