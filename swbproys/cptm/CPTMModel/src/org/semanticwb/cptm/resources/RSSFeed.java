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
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.*;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RSSFeed extends GenericAdmResource{
    @Override
    public void doXML(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        Document doc = SWBUtils.XML.getNewDocument();

        try{
            WebPage wp = paramsRequest.getWebPage();
            int i, nDias = Integer.parseInt(paramsRequest.getResourceBase().getAttribute("nDias" ,paramsRequest.getArgument("Dias", "1"))); //toma 1 dia como el default
            Element rss = doc.createElement("rss");

            rss.setAttribute("version", "2.0");
            doc.appendChild(rss);

            Element channel = doc.createElement("channel");
            String servidor = request.getScheme() + "://" + request.getServerName() + ((request.getServerPort() != 80)? (":" + request.getServerPort()) : "");

            addAttribute(channel, "title", "Noticias de los ultimos " + nDias + " Dias");
            //addAttribute(channel, "link", servidor + wp.getRealUrl());
            addAttribute(channel, "description", "Estas son las ultimas noticias..");

            ArrayList listaNoticias = new ArrayList();
            Iterator actividades = Activity.ClassMgr.listActivities(wp.getWebSite());
            Iterator actividadesRef = ActivityRef.ClassMgr.listActivityRefs(wp.getWebSite());
            Iterator eventos = Event.ClassMgr.listEvents(wp.getWebSite());
            Iterator experiencias = Experience.ClassMgr.listExperiences(wp.getWebSite());
            Iterator experienciasRef = ExperienceRef.ClassMgr.listExperienceRefs(wp.getWebSite());
            Iterator notas = EditNote.ClassMgr.listEditNotes(wp.getWebSite());
            Iterator destinos = GeographicPoint.ClassMgr.listGeographicPoints(wp.getWebSite());

            Iterator[] iteradores = {actividades, actividadesRef, eventos, experiencias, experienciasRef, notas, destinos};

            Date hoy = new Date();
            for(i = 0; i < iteradores.length; i++){
                while(iteradores[i].hasNext()){
                    long diasTrans; //diferencia de dias entre hoy y cuando fue actualizada la noticia
                    Object noticia = iteradores[i].next();

                    if(noticia instanceof Event){
                        diasTrans =  (hoy.getTime() - ((Event)noticia).getUpdated().getTime()) / 1000 / 60 / 60 / 24; // se obtienen milisegundos y se dividen hasta quedar dias
                    }else{
                        diasTrans =  (hoy.getTime() - ((WebPage)noticia).getUpdated().getTime()) / 1000 / 60 / 60 / 24;
                    }
                    
                    if(diasTrans <= nDias){ //si esta dentro del rango se ingresa al feed
                        listaNoticias.add(noticia);
                    }
                }
            }

            for(i = 0; i < listaNoticias.size(); i++){ //añadimos los feeds para desplegar en el rss
                Object noticia = listaNoticias.get(i);
                Element item = doc.createElement("item");
                Element image = doc.createElement("image");

                if(noticia instanceof Event){
                    WebPage mostrarEvento = WebPage.ClassMgr.getWebPage("Mostrar_Evento", wp.getWebSite());

                    addAttribute(item, "title", ((Event)noticia).getTitle());
                    addAttribute(item, "link", servidor + mostrarEvento.getRealUrl(paramsRequest.getUser().getLanguage()) + "?id=" + ((Event)noticia).getId() + "&show=event");
                    addAttribute(item, "description",  ((Event)noticia).getDescription());

                    addAttribute(image, "title", "");
                    addAttribute(image, "url", servidor + SWBPortal.getWebWorkPath() + ((Event)noticia).getWorkPath() + "/" + CptmgeneralData.cptm_photo.getName() + "_" + ((Event)noticia).getTitle() + "_" + ((Event)noticia).getPhoto());
                    addAttribute(item, "link", servidor + "/" + paramsRequest.getUser().getLanguage() + "/" + paramsRequest.getWebPage().getWebSiteId() + "/Mostrar_Evento?id=" + ((Event)noticia).getId() + "&show=event");
                }else{
                    addAttribute(item, "title", ((WebPage)noticia).getDisplayName());
                    addAttribute(item, "link", servidor + ((WebPage)noticia).getRealUrl());
                    addAttribute(item, "description", ((WebPage)noticia).getDescription());

                    addAttribute(image, "title", "");
                    addAttribute(image, "url", servidor + SWBPortal.getWebWorkPath() + ((WebPage)noticia).getWorkPath() + "/" + CptmgeneralData.cptm_photo.getName() + "_" + ((WebPage)noticia).getId() + "_" + ((WebPage)noticia).getSemanticObject().getProperty(CptmgeneralData.cptm_photo));
                    addAttribute(image, "link", servidor + ((WebPage)noticia).getRealUrl());
                }

                channel.appendChild(item);
                channel.appendChild(image);
            }

            rss.appendChild(channel);

        }catch(Exception e){
            throw new SWBResourceException("Error al generar rss", e);
        }

        String xml = SWBUtils.XML.domToXml(doc);
        out.print(xml);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException
    {
        doXML(request, response, paramsRequest);
    }

    private Element addAttribute(Element ele, String name, String value)
    {
        Document doc = ele.getOwnerDocument();
        Element n = doc.createElement(name);

        ele.appendChild(n);
        n.appendChild(doc.createTextNode(value));

        return n;
    }
 }
