package org.semanticwb.portal.resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

public class AudioPublisher extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(VideoPublisher.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        final String webWorkPath = SWBPortal.getWebWorkPath()+base.getWorkPath()+"/";

        String clsid, codebase;
        String filename = webWorkPath + base.getAttribute("audio");
        String width = base.getAttribute("width", "320");
        String height = base.getAttribute("height", "240");
        String align = base.getAttribute("align");
        String standby = base.getAttribute("standby", "Loading Microsoft Windows Media Player components...");
        boolean automatic = Boolean.parseBoolean(base.getAttribute("automatic"));
        boolean controls = Boolean.parseBoolean(base.getAttribute("controls"));
        boolean loop = Boolean.parseBoolean(base.getAttribute("loop"));

        if(filename.endsWith(".au")) {
            clsid = "clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B";
            codebase = "http://www.apple.com/qtactivex/qtplugin.cab";
            out.println("<object id=\"audio_"+base.getId()+"\" class=\"swb-audio\" classid=\""+clsid+"\" codebase=\""+codebase+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("  <param name=\"src\" value=\""+filename+"\">");
            out.println("  <param name=\"autoplay\" value=\""+automatic+"\">");
            out.println("  <param name=\"autostart\" value=\""+(automatic?1:0)+"\">");
            out.println("  <param name=\"controller\" value=\""+controls+"\">");
            out.println("  <param name=\"pluginspage\" value=\"http://www.apple.com/quicktime/download/\">");
            out.println("    <!--[if !IE]> <-->");
            out.println("    <object type=\"audio/x-mpeg\" data=\""+filename+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("    <param name=\"autoplay\" value=\""+automatic+"\">");
            out.println("    <param name=\"pluginurl\" value=\"http://www.apple.com/quicktime/download/\">");
            out.println("    <param name=\"autostart\" value=\""+(automatic?1:0)+"\">");
            out.println("    <param name=\"controller\" value=\""+controls+"\">");
            out.println("    </object>");
            out.println("    <!--> <![endif]-->");
//                out.println("  <embed src=\""+filename+"\" type=\"audio/x-mpeg\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\" autostart=\""+automatic+"\" controller=\""+controls+"\"></embed>");
            out.println("</object>");
        }else if( filename.endsWith(".wav") ) {
            clsid = "clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B";
            codebase = "http://www.apple.com/qtactivex/qtplugin.cab";
            out.println("<object id=\"audio_"+base.getId()+"\" class=\"swb-audio\" classid=\""+clsid+"\" codebase=\""+codebase+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("  <param name=\"src\" value=\""+filename+"\"/>");
            out.println("  <param name=\"autoplay\" value=\""+automatic+"\"/>");
            out.println("  <param name=\"autostart\" value=\""+(automatic?1:0)+"\"/>");
            out.println("  <param name=\"controller\" value=\""+controls+"\"/>");
            out.println("  <param name=\"pluginspage\" value=\"http://www.apple.com/quicktime/download/\">");
            out.println("    <!--[if !IE]> <-->");
            out.println("    <object type=\"audio/x-wav\" data=\""+filename+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("    <param name=\"autoplay\" value=\""+automatic+"\">");
            out.println("    <param name=\"pluginurl\" value=\"http://www.apple.com/quicktime/download/\">");
            out.println("    <param name=\"autostart\" value=\""+(automatic?1:0)+"\">");
            out.println("    <param name=\"controller\" value=\""+controls+"\">");
            out.println("    </object>");
            out.println("    <!--> <![endif]-->");
//                out.println("  <embed src=\""+filename+"\" type=\"audio/x-wav\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\" autostart=\""+automatic+"\" controller=\""+controls+"\"></embed>");
            out.println("</object>");
        }else if(filename.endsWith(".ra")) {
            out.print("El formato RA no es soportado.");
        }else if(filename.endsWith(".mp3")) {
            clsid = "clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B";
            codebase = "http://www.apple.com/qtactivex/qtplugin.cab";
            out.println("<object id=\"audio_"+base.getId()+"\" class=\"swb-audio\" classid=\""+clsid+"\" codebase=\""+codebase+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("  <param name=\"src\" value=\""+filename+"\"/>");
            out.println("  <param name=\"autoplay\" value=\""+automatic+"\"/>");
            out.println("  <param name=\"autostart\" value=\""+(automatic?1:0)+"\"/>");
            out.println("  <param name=\"controller\" value=\""+controls+"\"/>");
            out.println("  <param name=\"pluginspage\" value=\"http://www.apple.com/quicktime/download/\">");
            out.println("    <!--[if !IE]> <-->");
            out.println("    <object type=\"audio/x-mpeg\" data=\""+filename+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("    <param name=\"autoplay\" value=\""+automatic+"\">");
            out.println("    <param name=\"pluginurl\" value=\"http://www.apple.com/quicktime/download/\">");
            out.println("    <param name=\"autostart\" value=\""+(automatic?1:0)+"\">");
            out.println("    <param name=\"controller\" value=\""+controls+"\">");
            out.println("    </object>");
            out.println("    <!--> <![endif]-->");
//                out.println("  <embed src=\""+filename+"\" type=\"audio/x-mpeg\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\" autostart=\""+automatic+"\" controller=\""+controls+"\"></embed>");
            out.println("</object>");
        }else if(filename.endsWith(".wma")) {
            clsid = "clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95";
            codebase = "http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6,0,02,902";
            out.println("<object id=\"audio_"+base.getId()+"\" class=\"swb-audio\" classid=\""+clsid+"\" codebase=\""+codebase+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("  <param name=\"src\" value=\""+filename+"\"/>");
            out.println("  <param name=\"autoplay\" value=\""+automatic+"\"/>");
            out.println("  <param name=\"autostart\" value=\""+(automatic?1:0)+"\"/>");
            out.println("  <param name=\"controller\" value=\""+controls+"\"/>");
            out.println("  <param name=\"pluginspage\" value=\"http://www.apple.com/quicktime/download/\"/>");
            out.println("    <!--[if !IE]> <-->");
            out.println("    <object type=\"audio/x-ms-wma\" data=\""+filename+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("    <param name=\"autoplay\" value=\""+automatic+"\">");
            out.println("    <param name=\"pluginurl\" value=\"http://www.apple.com/quicktime/download/\">");
            out.println("    <param name=\"autostart\" value=\""+(automatic?1:0)+"\">");
            out.println("    <param name=\"controller\" value=\""+controls+"\">");
            out.println("    </object>");
            out.println("    <!--> <![endif]-->");
//                out.println("  <embed src=\""+filename+"\" type=\"audio/x-ms-wma\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\" autostart=\""+automatic+"\" controller=\""+controls+"\"></embed>");
            out.println("  </embed>");
            out.println("</object>");
        }else if(filename.endsWith(".rm")) {
            clsid = "clsid:CFCDAA03-8BE4-11CF-B84B-0020AFBBCCFA";
            //codebase = "http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6,0,02,902";
            out.println("<object id=\"RVOCX\" class=\"swb-audio\" classid=\""+clsid+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("  <param name=\"src\" value=\""+filename+"\"/>");
            out.println("  <param name=\"autoplay\" value=\""+automatic+"\"/>");
            out.println("  <param name=\"autostart\" value=\""+(automatic?1:0)+"\"/>");
            if(controls)
                out.println("  <param name=\"controls\" value=\"ControlPanel\"/>");
            out.println("    <!--[if !IE]> <-->");
            out.println("    <object type=\"audio/x-pn-realaudio\" data=\""+filename+"\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\">");
            out.println("    <param name=\"autoplay\" value=\""+automatic+"\">");
            out.println("    <param name=\"autostart\" value=\""+(automatic?1:0)+"\">");
            if(controls)
                out.println("    <param name=\"controls\" value=\"ControlPanel\">");
            out.println("    </object>");
            out.println("    <!--> <![endif]-->");
//                out.println("  <embed src=\""+filename+"\" type=\"audio/x-pn-realaudio\" width=\""+width+"\" height=\""+height+"\" align=\""+align+"\" autostart=\""+automatic+"\" controller=\""+controls+"\"></embed>");
            out.println("</object>");
        }else {
            out.print("Formato no soportado.");
        }

        out.flush();
        out.close();
    }
}
