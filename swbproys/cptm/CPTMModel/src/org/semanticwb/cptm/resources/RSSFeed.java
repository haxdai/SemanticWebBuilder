/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

/**
 *
 * @author miguel.ortiz
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.*;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RSSFeed extends GenericAdmResource {

    private static Logger logger = SWBUtils.getLogger(RSSFeed.class);

    @Override
    public void doXML(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        Document doc = SWBUtils.XML.getNewDocument();
        String lang = paramsRequest.getUser().getLanguage();

        try {
            WebPage wp = paramsRequest.getWebPage();
            int i = 0;
            //toma 1 dia como el default
            int nDias = Integer.parseInt(paramsRequest.getResourceBase(
                    ).getAttribute("nDias", paramsRequest.getArgument("Dias", "1")));
            Element rss = doc.createElement("rss");

            rss.setAttribute("version", "2.0");
            doc.appendChild(rss);

            Element channel = doc.createElement("channel");
            String servidor = request.getScheme() + "://" + request.getServerName()
                    + ((request.getServerPort() != 80)? (":" + request.getServerPort()) : "");

            addAttribute(channel, "title", this.getResourceBase().getDisplayTitle(lang));
            addAttribute(channel, "link", "http://www.visitmexico.com");
            addAttribute(channel, "description", this.getResourceBase().getDisplayDescription(lang));

            Element image = doc.createElement("image");
            addAttribute(image, "url", servidor + SWBPortal.getWebWorkPath()
                    + "/models/" + wp.getWebSite().getId() + "/css/images/mexico.jpg");
            addAttribute(image, "width", "140");
            addAttribute(image, "height", "60");
            addAttribute(image, "link", "http://www.visitmexico.com");
            addAttribute(image, "title", this.getResourceBase().getDisplayTitle(lang));
            channel.appendChild(image);

            ArrayList<Object> listaNoticias = new ArrayList<Object>();
            Iterator actividades = Activity.ClassMgr.listActivities(wp.getWebSite());
            Iterator actividadesRef = ActivityRef.ClassMgr.listActivityRefs(wp.getWebSite());
            Iterator eventos = Event.ClassMgr.listEvents(wp.getWebSite());
            Iterator experiencias = Experience.ClassMgr.listExperiences(wp.getWebSite());
            Iterator experienciasRef = ExperienceRef.ClassMgr.listExperienceRefs(wp.getWebSite());
            Iterator notas = EditNote.ClassMgr.listEditNotes(wp.getWebSite());
            Iterator destinos = GeographicPoint.ClassMgr.listGeographicPoints(wp.getWebSite());

            Iterator[] iteradores = {actividades, actividadesRef, eventos,
                                     experiencias, experienciasRef, notas, destinos};
            String[][] titulos = {{"Actividades", null},
                                  {"Actividades por Destinos", null},
                                  {"Eventos", null},
                                  {"Experiencias", null},
                                  {"Experiencias por Destinos", null},
                                  {"Notas", null},
                                  {"Destinos", null},
                                 };

            Date hoy = new Date();
            for (i = 0; i < iteradores.length; i++) {
                while (iteradores[i].hasNext()) {
                    long diasTrans = 0; //diferencia de dias entre hoy y cuando fue actualizada la noticia
                    Object noticia = iteradores[i].next();
                    Date updatedAt = null;

                    if (noticia instanceof Event) {
                        updatedAt = ((Event) noticia).getUpdated() != null
                                   ? ((Event) noticia).getUpdated()
                                   : ((Event) noticia).getCreated();
                        if (updatedAt != null) {
                            diasTrans =  (hoy.getTime() - updatedAt.getTime()) / 1000 / 60 / 60 / 24; // se obtienen milisegundos y se dividen hasta quedar dias
/*                        } else {
                            logger.error("Evento sin fechas de modificacion o creacion: " + ((Event)noticia).getURI());
                            continue; */
                        }
                    } else {
                        updatedAt = ((WebPage)noticia).getUpdated() != null
                                   ? ((WebPage)noticia).getUpdated()
                                   : ((WebPage)noticia).getCreated();
                        if (updatedAt != null) {
                            diasTrans =  (hoy.getTime() - updatedAt.getTime()) / 1000 / 60 / 60 / 24;
/*                        } else {
                            logger.error("Objeto sin fechas de modificacion o creacion: " + ((WebPage)noticia).getURI());
                            continue; */
                        }
                    }
                    
                    if (updatedAt != null && diasTrans <= nDias) { //si esta dentro del rango se ingresa al feed
                        //Se agrega el elemento para el titulo de separacion en el feed
                        if (titulos[i][1] == null) {
                            titulos[i][1] = "agregado";
                            listaNoticias.add(titulos[i][0]);
                        }
                        listaNoticias.add(noticia);
                    }
                }
            }

            WebPage mostrarEvento = WebPage.ClassMgr.getWebPage("Mostrar-Evento", wp.getWebSite());
            int elementosPorCanal = 0;
            if (mostrarEvento == null) {
                mostrarEvento = WebPage.ClassMgr.getWebPage("Mostrar_Evento", wp.getWebSite());
            }
            for (i = 0; i < listaNoticias.size(); i++) { //añadimos los feeds para desplegar en el rss
                Object noticia = listaNoticias.get(i);
                Element item = doc.createElement("item");
                StringBuilder content = new StringBuilder(128);
                String description = null;

                if (noticia instanceof String) {
                    description = (String) noticia;
                    addAttribute(item, "description", description != null && !"null".equalsIgnoreCase(description) ? description : "");
                    elementosPorCanal = 0;
                } else if (noticia instanceof Event) {
                    if (mostrarEvento != null) {
                        description = ((Event) noticia).getDisplayDescription(lang);
                        addAttribute(item, "title", ((Event) noticia).getDisplayTitle(lang));
                        addAttribute(item, "link", servidor + mostrarEvento.getRealUrl(paramsRequest.getUser().getLanguage()) + "?id=" + ((Event) noticia).getId() + "&show=event");
                        content.append("\n         <table width=\"100%\">");
                        content.append("\n           <tr>");
                        content.append("\n             <td align=\"left\">");
                        if (((Event) noticia).getPhoto() != null) {
                            content.append("\n               <img width=\"150\" height=\"100\" src=\"" + servidor + SWBPortal.getWebWorkPath() + ((Event) noticia).getWorkPath() + "/" + CptmgeneralData.cptm_photo.getName() + "_" + ((Event) noticia).getId() + "_" + ((Event) noticia).getPhoto() + "\">");
                        }
                        content.append("\n             </td>");
                        //content.append("\n             <td align=\"left\">");
                        content.append("\n             <td valign=\"bottom\" align=\"justify\">");
                        content.append("\n             " + description != null && !"null".equalsIgnoreCase(description) ? description : "");
                        content.append("\n             </td>");
                        content.append("\n           </tr>");
                        content.append("\n         </table> ");
                        addAttribute(item, "description", content.toString());
                    }
                } else {
                    description = ((WebPage) noticia).getDisplayDescription(lang);
                    addAttribute(item, "title", ((WebPage) noticia).getDisplayName(lang));
                    addAttribute(item, "link", servidor + ((WebPage) noticia).getRealUrl());
                    content.append("\n         <table width=\"100%\">");
                    content.append("\n           <tr>");
                    content.append("\n             <td align=\"left\">");
                    if (((WebPage) noticia).getSemanticObject().getProperty(CptmgeneralData.cptm_photo) != null) {
                        content.append("\n               <img width=\"150\" height=\"100\" src=\"" + servidor + SWBPortal.getWebWorkPath() + ((WebPage) noticia).getWorkPath() + "/" + CptmgeneralData.cptm_photo.getName() + "_" + ((WebPage) noticia).getId() + "_" + ((WebPage) noticia).getSemanticObject().getProperty(CptmgeneralData.cptm_photo) + "\">");
                    }
                    content.append("\n             </td>");
                    //content.append("\n             <td align=\"left\">");
                    content.append("\n             <td valign=\"bottom\" align=\"justify\">");
                    content.append("\n             " + description != null && !"null".equalsIgnoreCase(description) ? description : "");
                    content.append("\n             </td>");
                    content.append("\n           </tr>");
                    content.append("\n         </table> ");
                    addAttribute(item, "description", content.toString());

                }

                elementosPorCanal++;
                channel.appendChild(item);
            }

            rss.appendChild(channel);

        } catch (Exception e) {
            logger.error("Error al generar rss", e);
        }

        String xml = SWBUtils.XML.domToXml(doc, true);
        out.print(xml);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        doXML(request, response, paramsRequest);
    }

    private Element addAttribute(Element ele, String name, String value) {

        Document doc = ele.getOwnerDocument();
        Element n = doc.createElement(name);

        ele.appendChild(n);
        n.appendChild(doc.createTextNode(value));

        return n;
    }
 }
