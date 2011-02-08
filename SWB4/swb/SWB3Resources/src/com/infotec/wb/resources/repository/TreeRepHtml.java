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
 * TreeRepHtml.java
 *
 * Created on 20 de abril de 2004, 12:25 PM
 */

package com.infotec.wb.resources.repository;


import javax.servlet.http.*;
import com.infotec.wb.core.*;
import com.infotec.wb.util.*;
import com.infotec.appfw.exception.*;
import com.infotec.wb.lib.*;
import com.infotec.appfw.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.*;
import javax.xml.transform.*;
import com.infotec.topicmaps.*;


/** Muestra el �rbol de los diferentes sub carpetas de las que est� compuesto el
 * repositorio, permitiendo seleccionar la sub carpeta o carpeta principal para ver
 * la lista de documentos existentes.
 *
 * Shows the tree of the differents sub folders from wich is the repository
 * compound, allowing to select sub folder or main folder to see the existing
 * document list.
 * @author Jorge Alberto Jim�nez
 */
public class TreeRepHtml {

    Resource base=null;

    String webpath=(String)WBUtils.getInstance().getWebPath();

    Templates plt;
    Transformer trans;
    DocumentBuilderFactory dbf=null;
    DocumentBuilder db=null;
    String strRes="";
    String strWorkPath="";
    Vector vTopic= new Vector();
    int intMaxLevel=1;

    /** Creates a new instance of TreeRepHtml */
    public TreeRepHtml() {

    }


    /**
     * Asigna la informaci�n de la base de datos al recurso.
     *
     * @param     base  La informaci�n del recurso en memoria.
     */
    public void setResourceBase(Resource base) {
        this.base=base;
    }



    /**
     * User view in html format
     * @param request The input parameters
     * @param response The answer to the user request
     * @param user The WBUser object
     * @param topicrec a Topic object
     * @param arguments A list of parameters
     * @param topic A Topic object
     * @param paramsRequest A list of objects (topic, user, action, ...)
     * @throws AFException An Application Framework exception
     * @return The user html view of the directory structure
     */
    public String getHtml(HttpServletRequest request, HttpServletResponse response, WBUser user, Topic topicrec, HashMap arguments,Topic topic, WBParamRequest paramsRequest) throws AFException {
        Document dcmDom=base.getDom();
        if(dcmDom==null)throw new AFException("Dom nulo","getHtml()");
        StringBuffer sbfRet=new StringBuffer();

        WBResourceURLImp url1 = (WBResourceURLImp)paramsRequest.getRenderUrl();
        url1.setMode(url1.Mode_VIEW);
        url1.setAdminTopic(paramsRequest.getAdminTopic());
        try {
            TopicMap tm   =topic.getMap();
            Document dom=null;
            Topic tpid=null;
            Vector vctPath=new Vector();
            int intLevel=4, intWidth=10;
            String idhome=null;
            String dir=topic.getId();
            int widthsize=15;
            String backg=" bgcolor=\"FFFFFF\"";
            String color="666666";
            String path=WBUtils.getInstance().getWorkPath()+base.getResourceWorkPath();
            String path1=""+webpath+"wbadmin/resources/Repository/images/";

            if(request.getParameter("reptp")!=null && !request.getParameter("reptp").trim().equals("")) {
                tpid=tm.getTopic(request.getParameter("reptp"));
                vctPath=getMapPath(tpid);
            }else
            {
                tpid=paramsRequest.getTopic();
                vctPath=getMapPath(tpid);
            }

            if(dir!=null){
                idhome = dir;
            }

            Topic tpsite=null;
            if(idhome!=null) {
                tpsite=tm.getTopic(idhome);
                if(tpsite==null) tpsite=tm.getHome();
            }
            else tpsite=tm.getHome();


            sbfRet.append("<TABLE border=\"0\" cellPadding=\"0\" cellSpacing=\"0\" width=\"100%\">");
            sbfRet.append("<TR>");
            sbfRet.append("<TD>");
            sbfRet.append("<FONT class=\"Estilo6\" face=\"Verdana, Arial, Helvetica, sans-serif\">"+paramsRequest.getLocaleString("msgFolders") +"...</FONT>");
            sbfRet.append("</TD>");
            sbfRet.append("</TR>");


            if((tpid!=null && tpid.getId().equals(topic.getId())) || (tpid==null)) {
                backg=" bgcolor=\"B48222\"";
                color="FFFFFF";
            }

            sbfRet.append("<TR>");
            sbfRet.append("<TD"+backg+" >");
            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"minus.gif\"/>");
            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"openfolder.gif\"></IMG>");
            url1.setTopic(topic);
            sbfRet.append("<A href=\""+url1+"\">");
            sbfRet.append("<FONT face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\" style=\"text-decoration: none\" color=\""+color+"\">&nbsp;&nbsp;"+topic.getDisplayName(user.getLanguage()));
            sbfRet.append("</FONT>");
            sbfRet.append("</A>");
            sbfRet.append("</TD>");
            sbfRet.append("</TR>");

            Iterator it=tpsite.getSortChild(false);
            while(it.hasNext()){
                intLevel=1;
                Topic tp=(Topic)it.next();
                if(user.haveAccess(tp) && tp.getId()!=null) {
                    backg=" bgcolor=\"FFFFFF\"";
                    color="666666";
                    if(tpid!=null && tpid.getId().equals(tp.getId())){
                        backg=" bgcolor=\"B48222\"";
                        color="FFFFFF";
                    }
                    sbfRet.append("<TR>");
                    sbfRet.append("<TD>");
                    sbfRet.append("<TABLE border=\"0\" cellPadding=\"0\" cellSpacing=\"0\">");
                    sbfRet.append("<TR>");
                    sbfRet.append("<TD>");
                    sbfRet.append("	<IMG height=\"5\" width=\"5\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                    sbfRet.append("</TD>");
                    sbfRet.append("<TD width=\"50\">");
                    if(tp.getSortChild(false).hasNext() || vctPath.contains(tp.getId())){
                        if(tpid!=null && (tpid.getId().equals(tp.getId()) || vctPath.contains(tp.getId()))){
                            url1.setTopic(tp);
                            sbfRet.append("<A href=\""+url1+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\"10\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"minus.gif\"/>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"openfolder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }else{
                            url1.setTopic(tp);
                            sbfRet.append("<A href=\""+url1+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\"10\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"plus.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }

                    }
                    else{
                        url1.setTopic(tp);
                        sbfRet.append("<A href=\""+url1+"\">");
                        sbfRet.append("<IMG height=\"10\" width=\"10\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG height=\"10\" width=\"15\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                        sbfRet.append("</A>");
                    }
                    sbfRet.append("</TD>");

                    sbfRet.append("<TD"+backg+">");
                    url1.setTopic(tp);
                    sbfRet.append("<A href=\""+url1+"\">");
                    sbfRet.append("<FONT face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\" style=\"text-decoration: none\" color=\""+color+"\">&nbsp;"+tp.getDisplayName()+"</FONT></A>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    sbfRet.append("</TABLE>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    if((intLevel < intMaxLevel || (tpid!=null && tp.getId().equals(tpid.getId())) ||
                    vctPath.contains(tp.getId())) && tp.getSortChild(false).hasNext()){
                        sbfRet.append(getChilds(tpid, tp, user, vctPath, intLevel+1, intWidth,"",widthsize, paramsRequest));
                    }
                }
            }

            sbfRet.append("</TABLE>");

        }
        catch(Exception e) {
            AFUtils.log(e,"Error in resource "+"TreeRepHtml:getHtml",true);
        }
        return sbfRet.toString();
    }


    /** Obtiene los t�picos hijo relacionados al t�pico solicitado bajo una estructura jer�rquica.
     ** @param tpid Topic object thats represents a directory
     * @param tpc Topic object thats represents a directory
     * @param user The WBUser object in session
     * @param vctPath A Vector object that hold the topic parents
     * @param intLevel Level of the user
     * @param intWidth The width size value
     * @param topicrec Topic object thats represents a directory
     * @param widthsize The image size
     * @param paramsRequest A list of objects (topic, user, action, ...)
     * @return The directory structure
     */
    public String getChilds(Topic tpid, Topic tpc, WBUser user, Vector vctPath, int intLevel, int intWidth,String topicrec,int widthsize, WBParamRequest paramsRequest) {

        Document dcmDom=base.getDom();
        String strResmaptopic=null;

        StringBuffer sbfRet=new StringBuffer();
        try{
            String path1=""+webpath+"wbadmin/resources/Repository/images/";
            String path=WBUtils.getInstance().getWorkPath()+base.getResourceWorkPath();

            WBResourceURLImp url1 = (WBResourceURLImp)paramsRequest.getRenderUrl();
            url1.setMode(url1.Mode_VIEW);
            url1.setAdminTopic(paramsRequest.getAdminTopic());
            Iterator it=tpc.getSortChild(false);
            while(it.hasNext()) {
                Topic tpsub=(Topic)it.next();
                if(tpsub.getId()!=null && user.haveAccess(tpsub)) {
                    if(vTopic.contains(tpsub)) break;
                    vTopic.addElement(tpsub);

                    String backg=" bgcolor=\"FFFFFF\"";
                    String color="666666";
                    if(tpid!=null && tpsub.getId().equals(tpid.getId())) {
                        backg=" bgcolor=\"B48222\"";
                        color="FFFFFF";
                    }

                    sbfRet.append("<TR>");
                    sbfRet.append("<TD>");
                    sbfRet.append("<TABLE border=\"0\" cellPadding=\"0\" cellSpacing=\"0\">");
                    sbfRet.append("<TR>");

                    for(int i=0; i < intLevel-1; i++) {
                        sbfRet.append("<TD>");
                        sbfRet.append("<IMG height=\"5\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif></IMG>");
                        sbfRet.append("</TD>");
                    }
                    sbfRet.append("<TD width=\"30\">");

                    if(isMapParent(tpid, tpsub, vctPath) || vctPath.contains(tpsub.getId())){
                        if((tpid!=null && tpsub.getId().equals(tpid.getId()) || vctPath.contains(tpsub.getId()))){
                            url1.setTopic(tpsub);
                            sbfRet.append("<A href=\""+url1+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"minus.gif\"/>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"openfolder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }else{
                            url1.setTopic(tpsub);
                            sbfRet.append("<A href=\""+url1+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"plus.gif\"/>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }
                    }
                    else{
                        url1.setTopic(tpsub);
                        sbfRet.append("<A href=\""+url1+"\">");
                        sbfRet.append("<IMG height=\"10\" width=\""+15+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG height=\"10\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                        sbfRet.append("</A>");
                    }
                    sbfRet.append("<IMG height=\"10\" width=\""+5+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                    sbfRet.append("</TD>");
                    sbfRet.append("<TD"+backg+">");
                    url1.setTopic(tpsub);
                    sbfRet.append("<A href=\""+url1+"\">");
                    sbfRet.append("<FONT face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\" style=\"text-decoration: none\" color=\""+color+"\">&nbsp;"+tpsub.getDisplayName()+"</FONT></A>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    sbfRet.append("</TABLE>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    if((intLevel < intMaxLevel ||  (tpid!=null && tpsub.getId().equals(tpid.getId())) ||
                    vctPath.contains(tpsub.getId())) && tpsub.getSortChild(false).hasNext()){
                        sbfRet.append(getChilds(tpid, tpsub, user, vctPath, intLevel+1, intWidth,"",widthsize+10,paramsRequest));
                    }
                    vTopic.removeElement(tpsub);
                }
            }
        }catch(Exception e){
            AFUtils.log(e,"Error in resource "+"TreeRepHtml:getChilds",true);
        }
        return sbfRet.toString();
    }

    /**
     * Calcula los t�picos padre de un t�pico.
     *
     * @param     tpid      El t�pico que solicita el recurso.
     * @return    Regresa un objeto Vector que contiene los t�picos padre del t�pico requerido.
     * @see       infotec.topicmaps.Topic
     */
    public Vector getMapPath(Topic tpid) {
        Vector vctPath=new Vector();
        if(tpid.getMap().getHome()!=tpid) {
            Iterator aux=tpid.getTypes();
            while(aux.hasNext()) {
                Topic tp=(Topic)aux.next();
                vctPath.addElement(tp.getId());
                aux=tp.getTypes();
                if(tpid.getMap().getHome()==tp)break;
            }
        }
        return vctPath;
    }

    /**
     * Calcula si un t�pico tiene t�picos hijo sin referencias c�clicas.
     *
     * @param     tpid      El t�pico que solicita el recurso.
     * @param     tpsub     El t�pico hijo de acuerdo al nivel de recursividad presente en la generaci�n
     *                      de la estructura jer�rquica.
     * @param     vctPath   El vector que almacena los t�picos padre del t�pico requerido.
     * @return    Regresa si el t�pico solicitado contiene o no t�picos hijo con referencias c�clicas.
     * @see       infotec.topicmaps.Topic
     */
    public boolean isMapParent(Topic tpid, Topic tpsub, Vector vctPath) {
        boolean bParent=false;
        Iterator hit=tpsub.getSortChild(false);
        if(hit.hasNext()) {
            do {
                Topic htp=(Topic)hit.next();
                if(tpid!=null) {
                    if(htp.getId()!=null && !tpid.getId().equals(htp.getId()) && !vctPath.contains(htp.getId())) {
                        bParent=true;
                        break;
                    }
                }
                else {
                    if(htp.getId()!=null && !vctPath.contains(htp.getId())) {
                        bParent=true;
                        break;
                    }
                }
            } while(hit.hasNext());
        }
        else bParent=false;

        return bParent;
    }

    /**
     * Get the directory tree of the repository
     * @param request the input parameters
     * @param response the answer to the user request
     * @param user a WBUser object
     * @param topicrec Topic object
     * @param arguments a list of parameters
     * @param topic a topic object
     * @param paramsRequest a list of objects (topic, user, action, ...)
     * @throws AFException An application Framework exception
     * @return The directory structure
     */
    public String getDirs(HttpServletRequest request, HttpServletResponse response, WBUser user, Topic topicrec, HashMap arguments,Topic topic, WBParamRequest paramsRequest) throws AFException {
        //System.out.println("get Dirs");
        Document dcmDom=base.getDom();
        if(dcmDom==null)throw new AFException("Dom nulo","getDirs()");
        StringBuffer sbfRet=new StringBuffer();
        response.setContentType("text/html");
        WBResourceURL url1 = paramsRequest.getRenderUrl();
        url1.setMode(url1.Mode_VIEW);
        url1.setParameter("repobj","MoveDoc");
        if(request.getParameter("reptp_original")!=null) url1.setParameter("reptp_original",request.getParameter("reptp_original"));
        if(request.getParameter("repiddoc")!=null) url1.setParameter("repiddoc",request.getParameter("repiddoc"));
        String strUrl = url1.toString();
        try {
            TopicMap tm   =topic.getMap();
            Document dom=null;
            Topic tpid=null;
            Vector vctPath=new Vector();
            int intLevel=4, intWidth=10;
            String idhome=null;
            String dir=topic.getId();
            int widthsize=15;
            String backg=" bgcolor=\"FFFFFF\"";
            String color="666666";
            String path=WBUtils.getInstance().getWorkPath()+base.getResourceWorkPath();
            String path1=""+webpath+"wbadmin/resources/Repository/images/";

            if(request.getParameter("reptp")!=null && !request.getParameter("reptp").trim().equals("")) {
                tpid=tm.getTopic(request.getParameter("reptp"));
                vctPath=getMapPath(tpid);
            }

            if(dir!=null){
                idhome = dir;
            }

            Topic tpsite=null;
            if(idhome!=null) {
                tpsite=tm.getTopic(idhome);
                if(tpsite==null) tpsite=tm.getHome();
            }
            else tpsite=tm.getHome();


            sbfRet.append("<TABLE border=\"0\" cellPadding=\"0\" cellSpacing=\"0\" width=\"100%\">");
            sbfRet.append("<TR>");
            sbfRet.append("<TD>");
            sbfRet.append("<FONT class=\"Estilo6\" face=\"Verdana, Arial, Helvetica, sans-serif\">"+paramsRequest.getLocaleString("msgFolders") +"...</FONT>");
            sbfRet.append("</TD>");
            sbfRet.append("</TR>");

            if((tpid!=null && tpid.getId().equals(topic.getId())) || (tpid==null)) {
                backg=" bgcolor=\"B48222\"";
                color="FFFFFF";
            }

            sbfRet.append("<TR>");
            sbfRet.append("<TD"+backg+" >");
            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"minus.gif\"/>");
            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"openfolder.gif\"></IMG>");
            sbfRet.append("<A href=\""+strUrl + "&reptp=" + topic.getId()+"\">");
            sbfRet.append("<FONT face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\" style=\"text-decoration: none\" color=\""+color+"\">&nbsp;&nbsp;"+topic.getDisplayName(user.getLanguage()));
            sbfRet.append("</FONT>");
            sbfRet.append("</A>");
            sbfRet.append("</TD>");
            sbfRet.append("</TR>");
            Iterator it=tpsite.getSortChild(false);
            while(it.hasNext()){
                intLevel=1;
                Topic tp=(Topic)it.next();

                if(tp.getId()!=null) {
                    backg=" bgcolor=\"FFFFFF\"";
                    color="666666";
                    if(tpid!=null && tpid.getId().equals(tp.getId())){
                        backg=" bgcolor=\"B48222\"";
                        color="FFFFFF";
                    }
                    sbfRet.append("<TR>");
                    sbfRet.append("<TD>");
                    sbfRet.append("<TABLE border=\"0\" cellPadding=\"0\" cellSpacing=\"0\">");
                    sbfRet.append("<TR>");
                    sbfRet.append("<TD>");
                    sbfRet.append("	<IMG height=\"5\" width=\"5\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                    sbfRet.append("</TD>");
                    sbfRet.append("<TD width=\"50\">");
                    if(tp.getSortChild(false).hasNext() || vctPath.contains(tp.getId())){
                        if(tpid!=null && (tpid.getId().equals(tp.getId()) || vctPath.contains(tp.getId()))){
                            sbfRet.append("<A href=\""+strUrl + "&reptp=" + tp.getType().getId()+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\"10\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"minus.gif\"/>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"openfolder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }else{
                            sbfRet.append("<A href=\""+strUrl + "&reptp=" + tp.getId()+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\"10\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"plus.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }
                    }
                    else{
                        sbfRet.append("<A href=\""+strUrl + "&reptp=" + tp.getId()+"\">");
                        sbfRet.append("<IMG height=\"10\" width=\"10\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG height=\"10\" width=\"15\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                        sbfRet.append("</A>");
                    }
                    sbfRet.append("</TD>");
                    sbfRet.append("<TD"+backg+">");
                    sbfRet.append("<A href=\""+strUrl + "&reptp=" + tp.getId()+"\">");
                    sbfRet.append("<FONT face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\" style=\"text-decoration: none\" color=\""+color+"\">&nbsp;"+tp.getDisplayName(user.getLanguage())+"</FONT></A>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    sbfRet.append("</TABLE>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    if((intLevel < intMaxLevel || (tpid!=null && tp.getId().equals(tpid.getId())) ||
                    vctPath.contains(tp.getId())) && tp.getSortChild(false).hasNext()){
                        sbfRet.append(getChilds2(tpid, tp, user, vctPath, intLevel+1, intWidth,"",widthsize, paramsRequest,0,request));
                    }
                }
            }
            sbfRet.append("</TABLE>");
            sbfRet.append("\n<script language=javascript>");
            sbfRet.append("\n function enviar(frm){");
            sbfRet.append("\n   ");
            sbfRet.append("\n    window.opener.regresa(frm.repfiddoc.value,frm.reptp_original.value,frm.reptp.value,frm.repobj.value,frm.repiddoc.value);");
            sbfRet.append("\n    window.close();");
            sbfRet.append("\n   }");
            sbfRet.append("\n</script>");
            WBResourceURL urlAction = paramsRequest.getRenderUrl();
            urlAction.setCallMethod(urlAction.Call_CONTENT);
            if(user.isLoged()) sbfRet.append("<form name=\"frmSnd\" action=\""+urlAction.toString()+"\" method=post>");
            sbfRet.append("<input type=hidden name=\"repfiddoc\" value=\"movedoctodir\">");
            sbfRet.append("<input type=hidden name=\"reptp_original\" value=\""+request.getParameter("reptp_original")+"\">");
            sbfRet.append("<input type=hidden name=\"reptp\" value=\""+request.getParameter("reptp")+"\">");
            sbfRet.append("<input type=hidden name=\"repobj\" value=\"MoveDoc\">");
            sbfRet.append("<input type=hidden name=\"repiddoc\" value=\""+request.getParameter("repiddoc")+"\">");
            sbfRet.append("<TABLE width=100% cellpadding=0 cellspacing=0>");
            sbfRet.append("<TR><TD align=center><HR noshade size=1>");
            if(user.isLoged()) sbfRet.append("<input type=button name=\"mover\" value=\""+paramsRequest.getLocaleString("msgBTNMove")+"\" onclick=\"if(confirm('"+paramsRequest.getLocaleString("msgConfirmShureMove")+"?')) {enviar(frmSnd);} else { return(false);}\">&nbsp;<input type=\"button\" name=\"btn_cancel\" value=\""+paramsRequest.getLocaleString("msgBTNCancel")+"\" onclick=\"javascript:window.close();\">");
            sbfRet.append("</TD></TR>");
            sbfRet.append("</TABLE>");
            if(user.isLoged()) sbfRet.append("</form>");
        }
        catch(Exception e) {
            AFUtils.log(e,"Error in resource "+"TreeRepHtml:getHtml",true);
        }
        return sbfRet.toString();
    }

    /**
     * Shows the directory tree for move a selected file
     * @param tpid Topic object thats represents a directory
     * @param tpc Topic object thats represents a directory
     * @param user The WBUser object in session
     * @param vctPath A Vector object that hold the topic parents
     * @param intLevel Level of the user
     * @param intWidth The width size value
     * @param topicrec Topic object thats represents a directory
     * @param widthsize The image size
     * @param paramsRequest A list of objects (topic, user, action, ...)
     * @param direct An integer value
     * @param request Rhe input parameters
     * @return The directory structure
     */
    public String getChilds2(Topic tpid, Topic tpc, WBUser user, Vector vctPath, int intLevel, int intWidth,String topicrec,int widthsize, WBParamRequest paramsRequest, int direct, HttpServletRequest request) {

        Document dcmDom=base.getDom();
        StringBuffer sbfRet=new StringBuffer();
        try{
            String path1=""+webpath+"wbadmin/resources/Repository/images/";
            String path=WBUtils.getInstance().getWorkPath()+base.getResourceWorkPath();
            String strUrl =tpc.getMap().getHome().getUrl();
            WBResourceURL url1 = paramsRequest.getRenderUrl();
            url1.setMode(url1.Mode_VIEW);
            url1.setParameter("repobj","MoveDoc");
            if(request.getParameter("reptp_original")!=null) url1.setParameter("reptp_original",request.getParameter("reptp_original"));
            if(request.getParameter("repiddoc")!=null) url1.setParameter("repiddoc",request.getParameter("repiddoc"));
            strUrl = url1.toString();
            Iterator it=tpc.getSortChild(false);

            while(it.hasNext()) {
                Topic tpsub=(Topic)it.next();

                if(tpsub.getId()!=null && user.haveAccess(tpsub)) {
                    if(vTopic.contains(tpsub)) break;
                    vTopic.addElement(tpsub);
                    String backg=" bgcolor=\"FFFFFF\"";
                    String color="666666";
                    if(tpid!=null && tpsub.getId().equals(tpid.getId())) {
                        backg=" bgcolor=\"B48222\"";
                        color="FFFFFF";
                    }

                    sbfRet.append("<TR>");
                    sbfRet.append("<TD>");
                    sbfRet.append("<TABLE border=\"0\" cellPadding=\"0\" cellSpacing=\"0\">");
                    sbfRet.append("<TR>");

                    for(int i=0; i < intLevel-1; i++) {
                        sbfRet.append("<TD>");
                        sbfRet.append("<IMG height=\"5\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif></IMG>");
                        sbfRet.append("</TD>");
                    }
                    sbfRet.append("<TD width=\"30\">");
                    if(isMapParent(tpid, tpsub, vctPath) || vctPath.contains(tpsub.getId())){
                        if((tpid!=null && tpsub.getId().equals(tpid.getId()) || vctPath.contains(tpsub.getId()))){
                            sbfRet.append("<A href=\""+strUrl + "&reptp=" + tpsub.getType().getId()+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"minus.gif\"/>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"openfolder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }else{
                            sbfRet.append("<A href=\""+strUrl + "&reptp=" + tpsub.getId()+"\">");
                            sbfRet.append("<IMG height=\"10\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"15\" src=\""+path1+"plus.gif\"/>");
                            sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                            sbfRet.append("</A>");
                        }
                    }
                    else{
                        sbfRet.append("<A href=\""+strUrl + "&reptp=" + tpsub.getId()+"\">");
                        sbfRet.append("<IMG height=\"10\" width=\""+15+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG height=\"10\" width=\""+widthsize+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                        sbfRet.append("<IMG border=\"0\" height=\"20\" width=\"20\" src=\""+path1+"folder.gif\"></IMG>");
                        sbfRet.append("</A>");
                    }
                    sbfRet.append("<IMG height=\"10\" width=\""+5+"\" border=\"0\" src=\""+path1+"pixel.gif\"></IMG>");
                    sbfRet.append("</TD>");
                    sbfRet.append("<TD"+backg+">");
                    sbfRet.append("<A href=\""+strUrl + "&reptp=" + tpsub.getId()+"\">");
                    sbfRet.append("<FONT face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\" style=\"text-decoration: none\" color=\""+color+"\">&nbsp;"+tpsub.getDisplayName()+"</FONT></A>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    sbfRet.append("</TABLE>");
                    sbfRet.append("</TD>");
                    sbfRet.append("</TR>");
                    if((intLevel < intMaxLevel ||  (tpid!=null && tpsub.getId().equals(tpid.getId())) ||
                    vctPath.contains(tpsub.getId())) && tpsub.getSortChild(false).hasNext()){
                        sbfRet.append(getChilds2(tpid, tpsub, user, vctPath, intLevel+1, intWidth,"",widthsize+10,paramsRequest,1,request));
                    }
                    vTopic.removeElement(tpsub);
                }
            }
        }catch(Exception e){
            AFUtils.log(e,"Error in resource "+"TreeRepHtml:getChilds",true);
        }
        return sbfRet.toString();
    }
}
