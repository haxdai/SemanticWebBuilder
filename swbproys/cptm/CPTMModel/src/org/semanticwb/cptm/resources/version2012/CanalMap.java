
package org.semanticwb.cptm.resources.version2012;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import org.semanticwb.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.Activity;
import org.semanticwb.cptm.ActivityType;
import org.semanticwb.cptm.ExperienceType;
import org.semanticwb.cptm.GeographicPoint;
import org.semanticwb.cptm.LocalityInt;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 * Muestra las ubicaciones en que se pueden realizar actividades o vivir experiencias,
 * de acuerdo al catálogo creado, dentro de un mapa de Google.
 * @author jose.jimenez
 * 20/03/2012
 */
public class CanalMap extends GenericResource {


    private static Logger log = SWBUtils.getLogger(CanalMap.class);

    /**
     * Controla el flujo a seguir en la respuesta de las peticiones. El flujo
     * se determina de acuerdo al valor del par&aacute;metro {@code mode} recibido.
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param response la respuesta HTTP generada para la petici&oacute;n atendida
     * @param paramRequest contiene objetos generados por SWB para la atenci&oacute;n de las peticiones
     * @throws SWBResourceException generada en caso de suceder alg&uacute;n comportamiento no v&aacute;lido
     * @throws IOException generada en caso de alg&uacute;n problema con la generaci&oacute;n de la respuesta
     */
    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        if (paramRequest.getMode().equalsIgnoreCase("fetchLocations")) {
            doFetchLocations(request, response, paramRequest);
        } else if (paramRequest.getMode().equalsIgnoreCase("fetchDetails")) {
            doFetchDetails(request, response, paramRequest);
        } else if (paramRequest.getMode().equalsIgnoreCase("sendMail")) {
            doSendMail(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    /**
     * Presenta la interfaz del mapa en la que se mostrar&aacute; la informaci&oacute;n. Contiene
     * la funcionalidad para representar las ubicaciones necesarias, de acuerdo a la
     * informaci&oacute;n representada en el mapa.
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param response la respuesta HTTP generada para la petici&oacute;n atendida
     * @param paramRequest contiene objetos generados por SWB para la atenci&oacute;n de las peticiones
     * @throws SWBResourceException generada en caso de suceder alg&uacute;n comportamiento no v&aacute;lido
     * @throws IOException generada en caso de alg&uacute;n problema con la generaci&oacute;n de la respuesta
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String path = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId() + "/jsp/ShowNavigator.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }

    public static String getOptionList(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest) {
        
        String lang = paramRequest.getUser().getLanguage();
        WebPage wp = paramRequest.getWebPage();
        User user = paramRequest.getUser();
        StringBuilder output = new StringBuilder(128);

        output.append("\n    <ul>");
        if (wp != null && (wp.getId().equalsIgnoreCase("Actividades") ||
                wp.getId().equalsIgnoreCase("Experiencias"))) {

            Iterator<WebPage> childs = wp.listVisibleChilds(lang);
            while (childs.hasNext()) {
                WebPage childWP = childs.next();
                ActivityType actType = null;
                ExperienceType expType = null;
                if (childWP instanceof ActivityType) {
                    actType = (ActivityType) childWP;
                    output.append("\n        <li id=\"type_" + actType.getId() + "\">");
                    output.append("\n          " + actType.getDisplayTitle(lang));
                    output.append("\n          <ul id=\"group_" + actType.getId() + "\">");

                    Iterator<Activity> acts = Activity.ClassMgr.listActivityByParent(actType, actType.getWebSite());
                    while (acts.hasNext()) {
                        Activity act = acts.next();
                        if (act.isVisible() && user.haveAccess(act)) {
                            output.append("\n            <li id=\"elem_");
                            output.append(act.getId());
                            output.append("\" onclick=\"javascript:requestLocations('");
                            output.append(act.getId());
                            output.append("', '");
                            output.append(act.getClass().getName());
                            output.append("');\" onmouseover=\"this.style.backgroundColor='#FFA500';\" onmouseout=\"this.style.backgroundColor='#E6E6FA';\">");
                            output.append(act.getDisplayName(lang));
                            output.append("</li>");
                        }
                    }
                    output.append("\n          </ul>");
                    output.append("\n        </li>");
                } else if (childWP instanceof ExperienceType) {
                    expType = (ExperienceType) childWP;
                    output.append("\n        <li>TODO: Implementar lo mismo que para las actividades.</li>");
                }
            }
        }
        output.append("</ul>");
        return output.toString();
    }

    /**
     * Devuelve un listado de objetos JSON, con las ubicaciones en que se puede
     * realizar una actividad o vivir una experiencia.
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param response la respuesta HTTP generada para la petici&oacute;n atendida
     * @param paramRequest contiene objetos generados por SWB para la atenci&oacute;n de las peticiones
     */
    public void doFetchLocations(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest) {

        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        String path = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId() + "/jsp/GetLocations.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }

        /*
        String elementsToShow = request.getParameter("elements");
        String elementId = request.getParameter("locsOf");
        String lang = paramRequest.getUser().getLanguage();
        JSONObject mainObject = new JSONObject();
        JSONArray array = new JSONArray();
        PrintWriter out = null;

        if (elementsToShow.equalsIgnoreCase("acts") && elementId != null) {
            Activity act = Activity.ClassMgr.getActivity(elementId,
                    paramRequest.getWebPage().getWebSite());
            GenericIterator<LocalityInt> localities = act.listActLocalities();
            while (localities.hasNext()) {
                LocalityInt locality = localities.next();
                if (locality instanceof GeographicPoint) {
                    GeographicPoint geoPoint = (GeographicPoint) locality;
                    JSONObject location = new JSONObject();
                    try {
                        location.put("name", geoPoint.getDisplayName(lang));
                        location.put("latitude", geoPoint.getLatitude());
                        location.put("longitude", geoPoint.getLongitude());
                        location.put("url", geoPoint.getUrl(lang));
                        location.put("id", geoPoint.getId());
                        location.put("objType", geoPoint.getClass().getSimpleName());
                        array.put(location);
                        //mainObject.append("locations", location);
                    } catch (JSONException jsone) {
                        CanalMap.log.error("En la creacion de objetos JSON", jsone);
                    }
                }
            }
        }

        try {
            out = response.getWriter();
            out.print(array.toString(2));
        } catch (Exception e) {
            if (out != null) {
                out.print("Ocurrio un problema al escribir la respuesta.");
            }
        }
         */

    }

    /**
     * Devuelve el c&oacute;digo HTML que se mostrar&aacute; en la ventana de informaci&oacute;n
     * correspondiente a un punto marcado en el mapa.
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param response la respuesta HTTP generada para la petici&oacute;n atendida
     * @param paramRequest contiene objetos generados por SWB para la atenci&oacute;n de las peticiones
     */
    public void doFetchDetails(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest) {

        String path = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId() + "/jsp/GetInfoWinData.jsp";
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }

    /**
     * Genera un correo electr&oacute;nico con el detalle del itinerario.
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param response la respuesta HTTP generada para la petici&oacute;n atendida
     * @param paramRequest contiene objetos generados por SWB para la atenci&oacute;n de las peticiones
     */
    public void doSendMail(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest) {

        String path = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId() + "/jsp/SendItineraryMail.jsp";
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }
}
