/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci?n e integraci?n para Internet,
 * la cual, es una creaci?n original del Fondo de Informaci?n y Documentaci?n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P?blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi?n 1; No. 03-2003-012112473900 para la versi?n 2, y No. 03-2006-012012004000-01
 * para la versi?n 3, respectivamente.
 *
 * INFOTEC pone a su disposici?n la herramienta INFOTEC WebBuilder a trav?s de su licenciamiento abierto al p?blico (?open source?),
 * en virtud del cual, usted podr? usarlo en las mismas condiciones con que INFOTEC lo ha dise?ado y puesto a su disposici?n;
 * aprender de ?l; distribuirlo a terceros; acceder a su c?digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t?rminos y condiciones de la LICENCIA ABIERTA AL P?BLICO que otorga INFOTEC para la utilizaci?n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant?a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl?cita ni expl?cita,
 * siendo usted completamente responsable de la utilizaci?n que le d? y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici?n la siguiente
 * direcci?n electr?nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * Poll.java
 *
 * Created on 20 de junio de 2002, 16:38
 */

package org.semanticwb.portal.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.admin.admresources.util.WBAdmResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.semanticwb.portal.util.SWBCookieMgr;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.util.FileUpload;

/**
 * Objeto que se encarga de desplegar y administrar una encuesta de opinion bajo
 * ciertos criterios(configuraci?n de recurso).
 *
 * Object that is in charge to unfold and to administer a survey of opinion under
 * certain criteria (resource configuration).
 * @author :Jorge Alberto Jim?nez Sandoval (JAJS)
 */

public class Poll extends GenericResource 
{
    private static Logger log = SWBUtils.getLogger(Poll.class);
    private static String poll = "poll_";
    
    HashMap hashSec;
    HashMap hashPrim;    
    String workPath = "";
    String webWorkPath= "/work";
    String restype = "";
    private SWBCookieMgr MngCookie;
    WBAdmResourceUtils admResUtils=new WBAdmResourceUtils();
    
    
     /**
     * Inicializa el recurso
     * @param base
     */    
    @Override
    public void setResourceBase(Resource base)
    {
        try 
        {
            super.setResourceBase(base);
            hashSec = new HashMap();
            hashPrim = new HashMap();
            workPath = (String) SWBPlatform.getWorkPath() +  base;
            webWorkPath = (String) SWBPlatform.getWebWorkPath() +  base.getWorkPath();
            restype= base.getResourceType().getResourceClassName();
        }
        catch(Exception e) { log.error("Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);  }
    }
    
    /**
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException
     */    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if(paramRequest.getMode().equals("showResults")) {
            doShowPollResults(request,response,paramRequest);
        }else {
            super.processRequest(request, response, paramRequest);
        }
    }
   
    /**
     * Muestra el html al usuario final
     * @param request
     * @param response
     * @param reqParams
     * @throws AFException
     * @throws IOException
     */    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
        response.setHeader("Pragma","no-cache"); //HTTP 1.0
        response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
        
        Resource base=getResourceBase();
        
        StringBuffer ret = new StringBuffer("");
        //String action = null != request.getParameter("enc_act") && !"".equals(request.getParameter("enc_act").trim()) ? request.getParameter("enc_act").trim() : "enc_step1";
        
        try 
        {
            Document dom=SWBUtils.XML.xmlToDom(base.getXml());
            if(dom!=null) {
                NodeList node = dom.getElementsByTagName("option");            
                if (!"".equals(base.getAttribute("question", "").trim()) && node.getLength() > 1) {                    
                    ret.append("\n<div id=\"swb-encuesta\">");
                    ret.append("\n<form name=\"frmEncuesta\" id=\"frmEncuesta\" action=\""+paramRequest.getRenderUrl()+"\" method=\"post\">\n");
                    if (!"".equals(base.getAttribute("imgencuesta", "").trim()))
                    {
                        ret.append("<p>");
                        ret.append("<img src=\"");
                        ret.append(webWorkPath +"/"+ base.getAttribute("imgencuesta").trim());
                        ret.append("\" border=\"0\"/>");
                        ret.append("</p>");
                    }
                    ret.append("<h1>");
                    ret.append(base.getAttribute("question").trim());
                    ret.append("</h1>");
                    for (int i = 0; i < node.getLength(); i++)
                    {
                        ret.append("<label><input type=\"radio\" name=\"radiobutton\" value=\"enc_votos" + (i + 1) + "\" />");
                        ret.append(node.item(i).getChildNodes().item(0).getNodeValue().trim() +"</label><br />");
                    }
                    ret.append("<p>");
                    if (!"".equals(base.getAttribute("button", "").trim())) {
                        ret.append("<input type=\"image\" name=\"votar\" src=\"" + webWorkPath +"/"+ base.getAttribute("button").trim() +"\" onClick=\"buscaCookie(this.form); return false;\"/>");
                    }else {
                        ret.append("<input type=\"button\" name=\"votar\" value=\"" + base.getAttribute("msg_tovote",paramRequest.getLocaleString("msg_tovote")) +"\" onClick=\"buscaCookie(this.form);\"/>");
                    }
                    ret.append("</p>");

                    SWBResourceURLImp url=new SWBResourceURLImp(request, base, paramRequest.getTopic(),SWBResourceURL.UrlType_RENDER);
                    url.setResourceBase(base);
                    url.setMode("showResults");
                    url.setWindowState(SWBResourceURLImp.WinState_MAXIMIZED);
                    url.setParameter("NombreCookie","VotosEncuesta"+ base.getId());
                    url.setTopic(paramRequest.getTopic());
                    url.setCallMethod(paramRequest.Call_DIRECT);

                    boolean display = Boolean.valueOf(base.getAttribute("display","true")).booleanValue();
                    if(display){
                        ret.append("<p>");
                        ret.append("<a href=\"javascript:abreresultados(\'" + url.toString(true) + "\')\">" + base.getAttribute("msg_viewresults",paramRequest.getLocaleString("msg_viewresults")) + "</a>");
                        ret.append("</p>");
                        
                        if("1".equals(base.getAttribute("wherelinks", "").trim()) || "3".equals(base.getAttribute("wherelinks", "").trim())) {
                            ret.append("<p>");
                            ret.append(getLinks(dom.getElementsByTagName("link"), paramRequest.getLocaleString("usrmsg_Encuesta_doView_relatedLink")));
                            ret.append("</p>");
                        }                        
                        ret.append("<p>");
                        ret.append("<input type=\"hidden\" name=\"NombreCookie\" value=\"VotosEncuesta"+ base.getId() +"\"/>");
                        ret.append("</p>");
                        ret.append("</form>");
                    }else {
                        ret.append("<p>");
                        ret.append("<a href=\"javascript:;\" onmousedown=\"getHtml('"+url.toString(true)+"','"+poll+base.getId()+"'); $('#"+poll+base.getId()+"').slideDown('normal');\">" + base.getAttribute("msg_viewresults",paramRequest.getLocaleString("msg_viewresults")) + "</a>");
                        ret.append("<div id=\""+poll+base.getId()+"\" ");
                        ret.append("style=\"display:none; overflow:hidden; height:"+base.getAttribute("height", "350").trim()+"px; ");
                        ret.append("\">");
                        ret.append("</div>");
                        ret.append("<br /></p>");                        
                        if("1".equals(base.getAttribute("wherelinks", "").trim()) || "3".equals(base.getAttribute("wherelinks", "").trim())) {
                            ret.append("<p>");
                            ret.append(getLinks(dom.getElementsByTagName("link"), paramRequest.getLocaleString("usrmsg_Encuesta_doView_relatedLink")));
                            ret.append("</p>");
                        }                        
                        ret.append("<p>");
                        ret.append("<input type=\"hidden\" name=\"NombreCookie\" value=\"VotosEncuesta"+ base.getId() +"\"/>");
                        ret.append("</p>");
                        ret.append("\n</form>");
                        ret.append("\n</div>");
                    }

                    String win = "menubar="+ base.getAttribute("menubar", "no").trim();
                    win += ",toolbar="+ base.getAttribute("toolbar", "no").trim();
                    win += ",status="+ base.getAttribute("status", "no").trim();
                    win += ",location="+ base.getAttribute("location", "no").trim();
                    win += ",directories="+ base.getAttribute("directories", "no").trim();
                    win += ",scrollbars="+ base.getAttribute("scrollbars", "no").trim();
                    win += ",resizable="+ base.getAttribute("resizable", "no").trim();
                    win += ",width="+ base.getAttribute("width", "360").trim();
                    win += ",height="+ base.getAttribute("height", "350").trim();
                    win += ",top="+ base.getAttribute("top", "125").trim();
                    win += ",left="+ base.getAttribute("left", "220").trim();

                    ret.append("\n<script type=\"text/javascript\">");

                    ret.append("\nfunction buscaCookie(forma)");
                    ret.append("{");
                    ret.append("    var numcom = getCookie(forma.NombreCookie.value); ");
                    ret.append("    if (numcom == \"SI\") { ");
                    if("true".equals(base.getAttribute("oncevote", "true").trim()) && !"0".equals(base.getAttribute("vmode", "0").trim())) {
                        ret.append("    alert('"+ paramRequest.getLocaleString("usrmsg_Encuesta_doView_msgVote") +"'); ");
                    }
                    ret.append("     } ");
                    ret.append("    else ");
                    ret.append("    { ");
                    ret.append("    } ");
                    ret.append("    Grabaencuesta(forma); ");
                    ret.append("} ");
                    ret.append("\nfunction setCookie(name) ");
                    ret.append("{ ");
                    ret.append("    document.cookie = name; ");
                    ret.append("    var expDate = new Date(); ");
                    ret.append("    expDate.setTime(expDate.getTime() + ( 720 * 60 * 60 * 1000) ); ");
                    ret.append("    expDate = expDate.toGMTString(); ");
                    ret.append("    var str1 = name +\"=SI; expires=\" + expDate + \";Path=/\"; ");
                    ret.append("    document.cookie = str1; ");
                    ret.append("} ");
                    ret.append("\nfunction getCookie (name) ");
                    ret.append("{ ");
                    ret.append("    var arg = name + \"=\"; ");
                    ret.append("    var alen = arg.length; ");
                    ret.append("    var clen = document.cookie.length; ");
                    ret.append("    var i = 0; ");
                    ret.append("    while (i < clen) ");
                    ret.append("    { ");
                    ret.append("        var j = i + alen; ");
                    ret.append("        if (document.cookie.substring(i, j) == arg) ");
                    ret.append("            return getCookieVal (j); ");
                    ret.append("        i = document.cookie.indexOf(\" \", i) + 1; ");
                    ret.append("        if (i == 0) break; ");
                    ret.append("    } ");
                    ret.append("    return null; ");
                    ret.append("} ");
                    ret.append("\nfunction getCookieVal (offset) ");
                    ret.append("{ ");
                    ret.append("    var endstr = document.cookie.indexOf (\";\", offset); ");
                    ret.append("    if (endstr == -1) ");
                    ret.append("        endstr = document.cookie.length; ");
                    ret.append("    return unescape(document.cookie.substring(offset, endstr)); ");
                    ret.append("} ");
                    ret.append("\nfunction Grabaencuesta(forma) ");
                    ret.append("{ ");
                    ret.append("    var radiobutton; ");
                    ret.append("    for(var i=0; i< forma.length; i++) ");
                    ret.append("    { ");
                    ret.append("        if(forma.elements[i].type == \"radio\") ");
                    ret.append("            if(forma.elements[i].checked) ");
                    ret.append("                radiobutton=forma.elements[i].value; ");
                    ret.append("    } ");
                    ret.append("    if(radiobutton!=null) { ");
                    if(display) {
                        ret.append("  window.open(\'"+ url.toString() +"&radiobutton=\' + radiobutton,\'_newenc\',\'"+ win + "\'); ");
                    }else {
                        ret.append("  getHtml('"+url.toString()+"&radiobutton='+radiobutton,'"+poll+base.getId()+"'); $('#"+poll+base.getId()+"').slideDown('normal');");
                    }
                    ret.append("    } ");
                    ret.append("    else { alert('"+ paramRequest.getLocaleString("usrmsg_Encuesta_doView_msgAnswer") +"'); } ");
                    ret.append("} ");

                    ret.append("\nfunction abreresultados(ruta) ");
                    ret.append("{ ");
                    ret.append("    window.open(ruta,\'_newenc\',\'"+ win +"\'); ");
                    ret.append("} ");

                    ret.append("\nfunction getHtml(url, tagid) { ");
                    ret.append("    $('#'+tagid).load(url);");
                    ret.append("} ");
                    ret.append("\n</script>");
                }
            }
        }catch (Exception e) {
            log.error(paramRequest.getLocaleString("error_Encuesta_doView_resource") +" "+ restype +" "+ paramRequest.getLocaleString("error_Encuesta_doView_method"), e);
        }        
        PrintWriter out=response.getWriter();        
        out.print(ret.toString());
    }
    
    /**
     * Muestra los resultados de la encuesta en especifico
     * @param request
     * @param response
     * @param reqParams
     * @throws AFException
     * @throws IOException
     */    
    public void doShowPollResults(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        StringBuffer ret = new StringBuffer("");
        Resource base=getResourceBase();
        try {
            String data = base.getData();
            Document dom = null;
            if(data != null) {
                dom = SWBUtils.XML.xmlToDom(data);
            }
            //if(request.getParameter("radiobutton")!=null && request.getParameter("radiobutton").length()>9)
            if(request.getParameter("radiobutton")!=null)
            {
                boolean flag=false;
                int validateMode=Integer.parseInt(base.getAttribute("vmode", "0"));
                if(validateMode==0){
                    flag=validateIPAddress(request);
                }else{
                    flag=validateCookie(request);
                    //Pone cookie
                    MngCookie = new SWBCookieMgr();
                    String value = (String) MngCookie.SearchCookie("VotosEncuesta"+ base.getId(), request);
                    MngCookie.AddCookie("VotosEncuesta"+ base.getId(), "SI",  true, true, request, response);
                }
                
                if ("false".equals(base.getAttribute("oncevote", "true").trim()) || !flag) // Es un usuario que paso la prueba de las IPs
                {
                    int valor = 0;
                    try { 
                        valor=Integer.parseInt(request.getParameter("radiobutton").substring(9)); 
                    }catch(Exception e) { 
                        valor=0; 
                        log.error("Respuesta de encuesta en cero. ", e); 
                    }
                    
                    if(valor > 0)
                    {
                        String varia = "enc_votos";
                        if (data == null)
                        {
                            try {
                                dom = SWBUtils.XML.getNewDocument();
                                Element root = dom.createElement("resource");
                                dom.appendChild(root);
                                Element option = dom.createElement(varia + valor);
                                option.appendChild(dom.createTextNode("1"));
                                root.appendChild(option);
                                base.setData(SWBUtils.XML.domToXml(dom));
                            }catch (Exception e) {
                                log.error(paramRequest.getLocaleString("error_Encuesta_doView_setData") +" "+ restype +" " + paramRequest.getLocaleString("error_Encuesta_doView_id") +" "+ base.getId() +" - "+ base.getTitle(), e); 
                            }
                        } 
                        else
                        {
                            try
                            {
                                NodeList nlist = dom.getElementsByTagName(varia + valor);
                                boolean exist = false;
                                for (int i = 0; i < nlist.getLength(); i++)
                                {
                                    exist = true;
                                    int votosOption = -1;
                                    votosOption = Integer.parseInt(nlist.item(i).getChildNodes().item(0).getNodeValue());
                                    if (votosOption != -1)
                                    {
                                        votosOption = votosOption + 1;
                                        nlist.item(i).getChildNodes().item(0).setNodeValue(String.valueOf(votosOption));
                                    }
                                }
                                if (!exist)
                                {
                                    Node nres = dom.getFirstChild();
                                    Element option = dom.createElement(varia + valor);
                                    option.appendChild(dom.createTextNode("1"));
                                    nres.appendChild(option);
                                }
                                base.setData(SWBUtils.XML.domToXml(dom));
                                base.addHit(request, paramRequest.getUser(), paramRequest.getTopic());
                            } 
                            catch (Exception e) { log.error(paramRequest.getLocaleString("error_Encuesta_doView_setData") +" "+ restype +" " + paramRequest.getLocaleString("error_Encuesta_doView_id") +" "+ base.getId() +" - "+ base.getTitle(), e); }
                        }
                    }
                }
            } 
            ret.append(getPollResults(request, paramRequest, dom));
        }catch(Exception e) { 
            log.error(e); 
        }
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
        response.setHeader("Pragma","no-cache"); //HTTP 1.0
        response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
        response.getWriter().print(ret.toString());
    }
    
    
    /**
     * Metodo que valida si se encuentra la cookie de la encuensta registrada en la maquina del usuario
     * @param request
     */
    private boolean validateCookie(javax.servlet.http.HttpServletRequest request){
        for(int i=0;i<request.getCookies().length;i++){
            javax.servlet.http.Cookie cookie=request.getCookies() [i];
            if(request.getParameter("NombreCookie").equals(cookie.getName()) && cookie.getValue().equals("SI")) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Metodo que valida si la ip del usuario final ya voto
     * @param request
     */
    private boolean validateIPAddress(javax.servlet.http.HttpServletRequest request)
    {
        boolean flag = false;
        int minutes;
        try { 
            minutes=Integer.parseInt(getResourceBase().getAttribute("time", "20").trim()); 
        }catch(Exception e){ 
            minutes=20; 
        }
        Date firstTime = new Date();
        Timestamp fctual = new Timestamp(firstTime.getTime());
        GregorianCalendar newTime = new GregorianCalendar();
        newTime.setTime(firstTime);
        newTime.add(GregorianCalendar.MINUTE, minutes);
        Timestamp Tfctualmoretime = new Timestamp(newTime.getTimeInMillis());
        if (hashPrim != null && hashSec != null && hashPrim.size() > 0 && hashSec.size() > 0)
        { // Existe hash primario
            Iterator IHmP = hashPrim.keySet().iterator();
            while (IHmP.hasNext())
            {
                HashMap Hm = (HashMap) IHmP.next();
                if (Hm != null && Hm == hashSec)
                {
                    Timestamp f1 = (Timestamp) hashPrim.get(Hm);
                    if (f1 != null && fctual.before(f1))
                    { // La fecha actual es menor que la que trae el hash primario, entonces se siguen
                      // almacenando IPs en hash secundario. Aqu? entrar?a como segundo paso.
                        if (!hashSec.containsKey(request.getRemoteAddr()))
                        {
                            hashSec.put(request.getRemoteAddr(), fctual);
                            hashPrim.clear();
                            if (hashPrim.isEmpty()) hashPrim.put(hashSec, f1);
                        } 
                        else flag = true;
                    } 
                    else if (f1 != null && (fctual.equals(f1) || fctual.after(f1)))
                    { // La fecha actual es mayor a la que trae el hash primario, entonces 
                      // se elimina hashes y se crean de nuevo. Aqu? entrar?a como tercer paso.
                        hashSec = new HashMap();
                        hashSec.put(request.getRemoteAddr(), fctual);
                        hashPrim = new HashMap();
                        hashPrim.put(hashSec, Tfctualmoretime);
                    }                     
                } 
                else if (Hm == null || Hm != hashSec)
                {
                    hashPrim.remove(Hm);
                }
            }
        } 
        else if (hashPrim != null && hashPrim.size() == 0)
        { // No existe hash primario. Aqu? entraria como primer paso.
            hashSec = new HashMap();
            hashSec.put(request.getRemoteAddr(), fctual);
            hashPrim = new HashMap();
            hashPrim.put(hashSec, Tfctualmoretime);
        }
        return flag;
    }
    
    /**
     * Muestra los resultados de la encuesta
     * @param request
     * @param reqParams
     * @param data
     * @throws AFException
     * @throws IOException
     */    
    private String getPollResults(HttpServletRequest request, SWBParamRequest paramRequest, Document data) throws SWBResourceException, IOException
    {
        StringBuffer ret = new StringBuffer("");
        Resource base=getResourceBase();
        boolean display = Boolean.valueOf(base.getAttribute("display","true")).booleanValue();
        try
        {            
            Document dom=SWBUtils.XML.xmlToDom(base.getXml());
            if(dom==null) {
                return ret.toString();
            }
            if(display) {
                ret.append("<html> ");
                ret.append("<head> ");
                ret.append("<title>" + paramRequest.getLocaleString("usrmsg_Encuesta_getResultEnc_title") + "</title> ");
                ret.append("</head> ");
                ret.append("<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\"");
                if (!"".equals(base.getAttribute("textcolorres", "").trim())) {
                    ret.append(" text=\"" + base.getAttribute("textcolorres").trim() + "\"");
                }
                if (!"".equals(base.getAttribute("backimgres", "").trim())) {
                    ret.append(" background=\"" + webWorkPath +"/"+ base.getAttribute("backimgres").trim() + "\"");
                }
                ret.append("> ");
                /*
                 * Se calcula el n?mero de saltos que se proporcion? en la admon. del recurso
                 * y se procede a generar la cadena de <BR> respectivos.
                 */
                int count =1;
                try { 
                    Integer.parseInt(base.getAttribute("branches", "1")); 
                }catch(Exception e) {
                    count=1; 
                }
                for (int i = 0; i < count; i++) {
                    ret.append("<br />");
                }
            }

            NodeList node = dom.getElementsByTagName("option");
            
            if(display) {
                ret.append("<table border=\"0\" cellpadding=\"5\" cellspacing=\"5\" align=\"center\"> ");
            }else {
                ret.append("<table border=\"0\" cellpadding=\"5\" cellspacing=\"5\" align=\"center\" style=\"");
                if (!"".equals(base.getAttribute("textcolorres", "").trim())) {
                    ret.append("color:" + base.getAttribute("textcolorres").trim() + "; ");
                }
                if (!"".equals(base.getAttribute("backimgres", "").trim())) {
                    ret.append("background-image:url(" + webWorkPath +"/"+ base.getAttribute("backimgres").trim() + "); ");
                }
                ret.append("\"> ");
            }
            
            if (!"".equals(base.getAttribute("question", "").trim()) && node.getLength() > 1)            
            {
                ret.append("<tr><td><strong>" + base.getAttribute("question").trim() + "</strong></td></tr> ");
                if (data != null)
                {
                    //Suma el total de votos para calcular el porcentaje
                    long intTotalVotos = 0;
                    long intAjuste = 0;
                    Node nodoFC = data.getFirstChild();
                    NodeList nlOption = nodoFC.getChildNodes();
                    for (int j = 0; j < nlOption.getLength(); j++)
                    {
                        if (nlOption.item(j).getChildNodes().getLength() > 0)
                        {
                            intTotalVotos = intTotalVotos + Integer.parseInt(nlOption.item(j).getChildNodes().item(0).getNodeValue());
                            Integer votos = new Integer(nlOption.item(j).getChildNodes().item(0).getNodeValue());
                            intAjuste = intAjuste + ((votos.longValue() * 100) / intTotalVotos);
                        }
                    }
                    if (intAjuste > 0) {
                        intAjuste = 100 - intAjuste;
                    }

                    long intVotos = 0;
                    long falta;
                    float intPorcentaje = 0;
                    float largo = 0;
                    ret.append("<tr><td> ");                    
                    if(display) {
                        ret.append("  <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"3\"> ");
                    }else {
                        ret.append("  <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"3\" style=\"");
                        if (!"".equals(base.getAttribute("textcolorres", "").trim())) {
                            ret.append("color:" + base.getAttribute("textcolorres").trim() + "; ");
                        }
                        if (!"".equals(base.getAttribute("backimgres", "").trim())) {
                            ret.append("background-image:url(" + webWorkPath +"/"+ base.getAttribute("backimgres").trim() + "); ");
                        }
                        ret.append("\"> ");
                    }
                    
                    boolean porcent = Boolean.valueOf(base.getAttribute("porcent","true")).booleanValue();
                    boolean totvote = Boolean.valueOf(base.getAttribute("totvote","true")).booleanValue();
                    for (int i = 0; i < node.getLength(); i++)
                    {
                        int num = i + 1;
                        ret.append("<tr valign=\"top\"><td align=\"right\"> ");
                        ret.append(node.item(i).getChildNodes().item(0).getNodeValue());
                        ret.append(":</td><td width=\"150\"> ");
                        String varia = "enc_votos";
                        NodeList nlist = data.getElementsByTagName(varia + num);
                        for (int j = 0; j < nlist.getLength(); j++)
                        {
                            String key = nlist.item(j).getNodeName();
                            String nume = key.substring(9);
                            Integer votos = new Integer(nlist.item(j).getChildNodes().item(0).getNodeValue());
                            intVotos = votos.intValue();
                            intPorcentaje = ((float) votos.intValue() * 100) / (float) intTotalVotos;
                            intPorcentaje = (intPorcentaje * 10);
                            intPorcentaje += .5;
                            intPorcentaje = (int) intPorcentaje;
                            intPorcentaje = intPorcentaje / 10;

                            if (Integer.parseInt(nume) == num)
                            {
                                largo = intPorcentaje;
                                falta = 100 - (int) largo;
                                ret.append("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/linealleno.gif\" width=\"" + largo + "\" height=\"5\"/> ");
                                ret.append("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/lineavacio.gif\" width=\"" + falta + "\" height=\"5\"/> ");
                                ret.append("<br /><center><strong> ");
                                if (porcent) {
                                    ret.append(largo + "%");
                                }
                                if (porcent && totvote) {
                                    ret.append(" : ");
                                }
                                if (totvote) {
                                    ret.append(intVotos + " " + base.getAttribute("msg_vote",paramRequest.getLocaleString("msg_vote")) + "(s)");
                                }
                                ret.append("</strong></center> ");
                            }
                        }
                        ret.append("</td></tr> ");
                    }
                    intAjuste = 0;
                    ret.append("  </table> ");
                    ret.append("</td></tr> ");
                    if (totvote) ret.append("<tr><td align=\"right\">"+ base.getAttribute("msg_totvotes",paramRequest.getLocaleString("msg_totvotes")) + ": " + intTotalVotos + "</td></tr> ");
                }else {
                    ret.append("<tr><td>" + paramRequest.getLocaleString("usrmsg_Encuesta_getResultEnc_noVotes") +"</td></tr> ");
                }
                ret.append("<tr><td align=\"center\"> ");
                if("2".equals(base.getAttribute("wherelinks", "").trim()) || "3".equals(base.getAttribute("wherelinks", "").trim()))
                {
                    ret.append("<br />"+getLinks(dom.getElementsByTagName("link"), paramRequest.getLocaleString("usrmsg_Encuesta_doView_relatedLink")));
                }
                ret.append("</td></tr> ");
                                
                if(display){
                    ret.append("<tr><td align=\"center\"><br /><a href=\"javascript:window.close();\">" + base.getAttribute("msg_closewin",paramRequest.getLocaleString("msg_closewin")) + "</a></td></tr> ");
                }else {
                    ret.append("<tr><td align=\"center\"><br /><a href=\"javascript:;\" onmousedown=\"$('#"+poll+base.getId()+"').slideUp('normal');\">" + base.getAttribute("msg_closewin",paramRequest.getLocaleString("msg_closewin")) + "</a></td></tr> ");
                }
                ret.append("</table>");
                
                if(display){
                    ret.append("</body>");
                    ret.append("</html>");
                }
            }
        } 
        catch (Exception e) { 
            log.error(paramRequest.getLocaleString("getPollResults") + " " + restype + " " + paramRequest.getLocaleString("error_Encuesta_doView_method"), e); 
        }
        return ret.toString();
    }
   
    private String getLinks(NodeList links, String comment)
    {
        StringBuffer ret = new StringBuffer("");
        if (links==null) return ret.toString();
        String _comment=comment;
        for (int i = 0; i < links.getLength(); i++)
        {
            String value = links.item(i).getChildNodes().item(0).getNodeValue().trim();
            if(!"".equals(value.trim())) 
            {
                int idx = value.indexOf(" /wblink/ ");
                if (idx > -1)
                {
                    _comment = value.substring(idx + 10);
                    value = value.substring(0, idx);
                }
                ret.append("<a href=\"" + value + "\" target=\"_newlink\">"+ _comment + "</a><br /> \n");
                _comment=comment;
            }
        }
        return ret.toString();
    }
    
    /**
     * Metodo que despliega la administraci?n del recurso
     * @param request
     * @param response
     * @param paramsRequest
     * @throws AFException
     * @throws IOException
     */    
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        StringBuffer ret = new StringBuffer("");
        Resource base=getResourceBase();
        String msg=paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_undefinedOperation");
        String action = null != request.getParameter("act") && !"".equals(request.getParameter("act").trim()) ? request.getParameter("act").trim() : paramRequest.getAction();

        if(action.equals("add") || action.equals("edit")) {
            ret.append(getForm(request, paramRequest));
        }else if(action.equals("update")) {            
            FileUpload fup = new FileUpload();
            try
            {
                fup.getFiles(request, response);                    
                String value = null != fup.getValue("question") && !"".equals(fup.getValue("question").trim()) ? fup.getValue("question").trim() : null;
                String option = null != fup.getValue("option") && !"".equals(fup.getValue("option").trim()) ? fup.getValue("option").trim() : null;
                if (value!=null && option!=null)
                {
                    base.setAttribute("question", value);
                    value = null != fup.getValue("noimgencuesta") && !"".equals(fup.getValue("noimgencuesta").trim()) ? fup.getValue("noimgencuesta").trim() : "0";
                    if ("1".equals(value) && !"".equals(base.getAttribute("imgencuesta", "").trim()))
                    {
                        SWBUtils.IO.removeDirectory(workPath + "/" + base.getAttribute("imgencuesta").trim());
                        base.removeAttribute("imgencuesta");
                    }
                    else
                    {
                        value = null != fup.getFileName("imgencuesta") && !"".equals(fup.getFileName("imgencuesta").trim()) ? fup.getFileName("imgencuesta").trim() : null;
                        if (value!=null)
                        {
                            String file = admResUtils.getFileName(base, value);
                            if (file != null && !file.trim().equals(""))
                            {
                                if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif|png")){
                                    msg=paramRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif, png</i>: " + file;
                                }
                                else
                                {
                                    if (admResUtils.uploadFile(base, fup, "imgencuesta")){
                                        base.setAttribute("imgencuesta", file);
                                    }
                                    else {
                                        msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                                    }
                                }
                            }
                            else {
                                msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                            }
                        } 
                    } 

                    value = null != fup.getValue("nobutton") && !"".equals(fup.getValue("nobutton").trim()) ? fup.getValue("nobutton").trim() : "0";
                    if ("1".equals(value) && !"".equals(base.getAttribute("button", "").trim()))
                    {
                        SWBUtils.IO.removeDirectory(workPath + "/" + base.getAttribute("button").trim());
                        base.removeAttribute("button");
                    }
                    else
                    {
                        value = null != fup.getFileName("button") && !"".equals(fup.getFileName("button").trim()) ? fup.getFileName("button").trim() : null;
                        if (value!=null)
                        {
                            String file = admResUtils.getFileName(base, value);
                            if (file != null && !file.trim().equals(""))
                            {
                                if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif|png")) {
                                    msg=paramRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif, png</i>: " + file;
                                }
                                else
                                {
                                    if (admResUtils.uploadFile(base, fup, "button")) {
                                        base.setAttribute("button", file);
                                    }
                                    else {
                                        msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                                    }
                                }
                            }
                            else {
                                msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                            }
                        } 
                    }                     
                    
                    value = null != fup.getValue("nobackimgres") && !"".equals(fup.getValue("nobackimgres").trim()) ? fup.getValue("nobackimgres").trim() : "0";
                    if ("1".equals(value) && !"".equals(base.getAttribute("backimgres", "").trim()))
                    {
                        SWBUtils.IO.removeDirectory(workPath + "/" + base.getAttribute("backimgres").trim());
                        base.removeAttribute("backimgres");
                    }
                    else
                    {
                        value = null != fup.getFileName("backimgres") && !"".equals(fup.getFileName("backimgres").trim()) ? fup.getFileName("backimgres").trim() : null;
                        if (value!=null)
                        {
                            String file = admResUtils.getFileName(base, value);
                            if (file != null && !file.trim().equals(""))
                            {
                                if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif|png")) {
                                    msg=paramRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif, png</i>: " + file;
                                }
                                else
                                {
                                    if (admResUtils.uploadFile(base, fup, "backimgres")){
                                        base.setAttribute("backimgres", file);
                                    }
                                    else {
                                        msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                                    }
                                }
                            }
                            else msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                        } 
                    }
                    
                    value = null != fup.getValue("branches") && !"".equals(fup.getValue("branches").trim()) ? fup.getValue("branches").trim() : "1";
                    base.setAttribute("branches", value);
                    value = null != fup.getValue("time") && !"".equals(fup.getValue("time").trim()) ? fup.getValue("time").trim() : "20";
                    base.setAttribute("time", value);
                    setAttribute(base, fup, "wherelinks");
                    setAttribute(base, fup, "textcolor");
                    setAttribute(base, fup, "oncevote");
                    setAttribute(base, fup, "vmode");
                    setAttribute(base, fup, "display");
                    setAttribute(base, fup, "porcent");
                    setAttribute(base, fup, "totvote");
                    setAttribute(base, fup, "textcolorres");
                    setAttribute(base, fup, "menubar", "yes");
                    setAttribute(base, fup, "toolbar", "yes");
                    setAttribute(base, fup, "status", "yes");
                    setAttribute(base, fup, "location", "yes");
                    setAttribute(base, fup, "directories", "yes");
                    setAttribute(base, fup, "scrollbars", "yes");
                    setAttribute(base, fup, "resizable", "yes");
                    setAttribute(base, fup, "width");
                    setAttribute(base, fup, "height");
                    setAttribute(base, fup, "top");
                    setAttribute(base, fup, "left");
                    setAttribute(base, fup, "msg_viewresults");
                    setAttribute(base, fup, "msg_vote");
                    setAttribute(base, fup, "msg_closewin");
                    setAttribute(base, fup, "msg_totvotes");
                    setAttribute(base, fup, "msg_tovote");

                    base.updateAttributesToDB();
                    //Document dom=base.getDom();
                    Document dom=SWBUtils.XML.xmlToDom(base.getXml());
                    if(dom!=null) {
                        removeAllNodes(dom, Node.ELEMENT_NODE, "option");
                    }
                    else
                    {
                        dom = SWBUtils.XML.getNewDocument();
                        Element root = dom.createElement("resource");
                        dom.appendChild(root);
                    }
                    value = null != fup.getValue("option") && !"".equals(fup.getValue("option").trim()) ? fup.getValue("option").trim() : null;
                    if(value!=null)
                    {
                        StringTokenizer stk = new StringTokenizer(value, "|");
                        while (stk.hasMoreTokens())
                        {
                            value = stk.nextToken();
                            Element emn = dom.createElement("option");
                            emn.appendChild(dom.createTextNode(value));
                            dom.getFirstChild().appendChild(emn);
                        }
                    }
                    removeAllNodes(dom, Node.ELEMENT_NODE, "link");
                    value = null != fup.getValue("link") && !"".equals(fup.getValue("link").trim()) ? fup.getValue("link").trim() : null;
                    if(value!=null)
                    {
                        StringTokenizer stk = new StringTokenizer(value, "|");
                        while (stk.hasMoreTokens())
                        {
                            value = stk.nextToken();
                            Element emn = dom.createElement("link");
                            emn.appendChild(dom.createTextNode(value));
                            dom.getFirstChild().appendChild(emn);
                        }
                    }                    
                    base.setXml(SWBUtils.XML.domToXml(dom));
                    //base.getRecResource().update(paramsRequest.getUser().getId(), "Resource with identifier "+base.getId()+" was updated successfully ");
                    
                    msg=paramRequest.getLocaleString("msgOkUpdateResource") +" "+ base.getId();
                    ret.append(
                        "<script type=\"text/javascript\" language=\"JavaScript\">\n"+
                        "   alert('"+msg+"');\n"+
                        "   location='"+paramRequest.getRenderUrl().setAction("edit").toString()+"';\n"+
                        "</script>\n"); 
                }
                else msg=paramRequest.getLocaleString("msgDataRequired");
            } 
            catch(Exception e) { log.error(e); msg=paramRequest.getLocaleString("msgErrUpdateResource") +" "+ base.getId(); }
        }
        else if(action.equals("remove")) 
        {
            msg=admResUtils.removeResource(base);  
            ret.append(
                "<script type=\"text/javascript\" language=\"JavaScript\">\n"+
                "   alert('"+msg+"');\n"+
                "</script>\n");             
        }
        response.getWriter().print(ret.toString());        
    }
    
     /**
     * @param base
     * @param fup
     * @param att
     */  
    protected void setAttribute(Resource base, FileUpload fup, String att)
    {
        try
        {
            if(null != fup.getValue(att) && !"".equals(fup.getValue(att).trim())) {
                base.setAttribute(att, fup.getValue(att).trim());
            }
            else {
                base.removeAttribute(att);
            }        
        }
        catch(Exception e) {  log.error("Error while setting resource attribute: "+att + ", "+base.getId() +"-"+ base.getTitle(), e); }
    }
    
    /**
     * @param base
     * @param fup
     * @param att
     * @param value
     */  
    protected void setAttribute(Resource base, FileUpload fup, String att, String value)
    {
        try
        {
            if(null != fup.getValue(att) && value.equals(fup.getValue(att).trim())) {
                base.setAttribute(att, fup.getValue(att).trim());
            }
            else {
                base.removeAttribute(att);
            }        
        }
        catch(Exception e) {  log.error("Error while setting resource attribute: "+att + ", "+base.getId() +"-"+ base.getTitle(), e); }
    }    
    
    /*
     * @param dom
     * @param nodeType
     * @param name
     */     
    /**
     * Metodo que remueve nodos en un dom-document
     */    
    private void removeAllNodes(Document dom, short nodeType, String name)
    {
        NodeList list = dom.getElementsByTagName(name);
        for (int i = 0; i < list.getLength(); i++)
        {
            Node node=list.item(i);
            if (node.getNodeType() == nodeType)
            {
                node.getParentNode().removeChild(node);
                if(node.hasChildNodes()) {
                    removeAllNodes(dom, nodeType, name);
                }
            }
        }
    }

    /**
     * Metodo que muestra la forma de la encuesta de opini?n en html
     * @param request
     * @param paramsRequest
     */      
    private String getForm(javax.servlet.http.HttpServletRequest request, SWBParamRequest paramRequest)
    {
        StringBuffer ret=new StringBuffer("");
        Resource base=getResourceBase();
        try
        {
            SWBResourceURL url = paramRequest.getRenderUrl().setMode(paramRequest.Mode_ADMIN);
            url.setAction("update");
            
            ret.append("<div class=\"swbform\"> \n");
            ret.append("<form name=\"frmResource\" method=\"post\" enctype=\"multipart/form-data\" action=\""+ url.toString()+"\"> \n");            
            ret.append("<fieldset> \n");
            ret.append("<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> \n");
            ret.append("<tr> \n");
            ret.append("<td colspan=\"2\"> \n");
            ret.append(paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_section1"));
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("\n<tr>");
            ret.append("\n<td>* " + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_question") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"text\" size=\"50\" name=\"question\" ");
            if (!"".equals(base.getAttribute("question", "").trim())) {
                ret.append(" value=\"" + base.getAttribute("question").trim().replaceAll("\"", "&#34;") + "\"");
            }
            ret.append("/></td> \n");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>* " + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_option") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"text\" size=\"50\" name=\"txtOption\"/><input type=\"hidden\" name=\"option\" ");
            if (!"".equals(base.getAttribute("option", "").trim())) {
                ret.append(" value=\"" + base.getAttribute("option").trim().replaceAll("\"", "&#34;") + "\"");
            }
            ret.append("/>");
            ret.append("\n<input type=\"button\" name=\"btnAdd\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnAdd") + "\" onClick=\"addOption(this.form.selOption, this.form.txtOption)\"/>");
            ret.append("\n<input type=\"button\" name=\"btnEdit\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnEdit") + "\" onClick=\"updateOption(this.form.selOption, this.form.txtOption)\"/>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td>&nbsp;</td> \n");
            ret.append("<td>");
            ret.append("\n<select name=\"selOption\" size=\"5\" multiple=\"multiple\" onChange=\"editOption(this.form.selOption, this.form.txtOption)\">");
            String value="";
            //Document dom=base.getDom();
            Document dom=SWBUtils.XML.xmlToDom(base.getXml());
            if(dom!=null)
            {
                NodeList node = dom.getElementsByTagName("option");
                if (node.getLength() > 0)
                {
                    for (int i = 0; i < node.getLength(); i++)
                    {
                        value = node.item(i).getChildNodes().item(0).getNodeValue().trim();
                        if(!"".equals(value.trim())) {
                            ret.append("\n<option value=\"" + value.trim().replaceAll("\"", "&#34;") + "\">" + value.trim() + "</option>");
                        }
                    }
                }                  
            }            
            ret.append("\n</select>");
            ret.append("\n<input type=\"button\" name=\"btnDel\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnDelete") + "\" onClick=\"deleteOption(this.form.selOption, this.form.txtOption)\" />");
            ret.append("</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_link") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"text\" size=\"50\" name=\"txtLink\"/><input type=\"hidden\" name=\"link\" ");
            if(!"".equals(base.getAttribute("link", "").trim())) {
                ret.append(" value=\"" + base.getAttribute("link").trim().replaceAll("\"", "&#34;") + "\"");
            }
            ret.append("/>");
            ret.append("\n<input type=\"button\" name=\"btnAdd\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnAdd") + "\" onClick=\"addOption(this.form.selLink, this.form.txtLink)\" />");
            ret.append("\n<input type=\"button\" name=\"btnEdit\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnEdit") + "\" onClick=\"updateOption(this.form.selLink, this.form.txtLink)\" />");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td>&nbsp;</td> \n");
            ret.append("<td>");
            ret.append("\n<select name=\"selLink\" size=\"5\" multiple=\"multiple\" onChange=\"editOption(this.form.selLink, this.form.txtLink)\">");
            if(dom!=null)
            {
                NodeList node = dom.getElementsByTagName("link");
                if (node.getLength() > 0)
                {
                    for (int i = 0; i < node.getLength(); i++)
                    {
                        value = node.item(i).getChildNodes().item(0).getNodeValue().trim();
                        if(!"".equals(value.trim())) {
                            ret.append("\n<option value=\"" + value.trim().replaceAll("\"", "&#34;") + "\">" + value.trim() + "</option>");
                        }
                    }
                }                  
            }            
            ret.append("\n</select>");
            ret.append("\n<input type=\"button\" name=\"btnDel\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnDelete") + "\" onClick=\"deleteOption(this.form.selLink, this.form.txtLink)\" />");
            ret.append("</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_displayLinks") + "</td>");
            ret.append("\n<td>");
            value=base.getAttribute("wherelinks", "1").trim();
            ret.append("\n<input type=\"radio\" name=\"wherelinks\" value=\"1\" ");
            if("1".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_onPoll")+"<br />");
            ret.append("\n<input type=\"radio\" name=\"wherelinks\" value=\"2\" ");
            if("2".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_onPollResults")+"<br />");
            ret.append("\n<input type=radio name=\"wherelinks\" value=\"3\" ");
            if("3".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_onBoth")+"<br /></td>");
            ret.append("</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_textcolor") + "</td>");
            ret.append("\n<td>");            
            ret.append("<table>\n");
            ret.append("<tr>\n");
            ret.append("<td>\n");
            ret.append("<input type=\"text\" size=\"7\" maxlength=\"7\" id=\"textcolor\" name=\"textcolor\" value=\""+base.getAttribute("textcolor", "#000000").trim()+"\">\n");
            ret.append("</td>\n");            
            ret.append("<td bgcolor=\"" + base.getAttribute("textcolor", "#000000") + "\" width=\"20\">&nbsp;</td>\n");
            ret.append("</tr>\n");
            ret.append("</table>\n");
            ret.append("</td> \n");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_otherTextcolor") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_hexadecimal") + "):</font></td>");
            ret.append("\n<td>");
            ret.append("<div id=\"cptextcolor\"></div>");
            ret.append("<script src='/swb/swbadmin/js/jquery/colorpicker.js' type='text/javascript'></script>\n");
            ret.append("<script type=\"text/javascript\">");
            ret.append("var colors=new Array('#ffffff', '#fff5ee', '#fff8dc', '#fffacd', '#ffffe0', '#98fb98', '#afeeee', '#e0ffff', '#e6e6fa', '#dda0dd', \n");
            ret.append("                   '#d3d3d3', '#ffc0cb', '#ffe4c4', '#ffe4b5', '#f0e68c', '#90ee90', '#20b2aa', '#87cefa', '#6495ed', '#ee82ee', \n");
            ret.append("                   '#c0c0c0', '#f08080', '#f4a460', '#ffa500', '#eee8aa', '#7fff00', '#48d1cc', '#87ceeb', '#7b68ee', '#da70d6', \n");
            ret.append("                   '#808080', '#ff0000', '#ff4500', '#ff8c00', '#ffff00', '#32cd32', '#8fbc8f', '#4169e1', '#6a5acd', '#ba55d3', \n");
            ret.append("                   '#696969', '#dc143c', '#d2691e', '#ff7f50', '#ffd700', '#228b22', '#2e8b57', '#0000ff', '#8a2be2', '#9932cc', \n");
            ret.append("                   '#2f4f4f', '#b22222', '#8b4513', '#a0522d', '#808000', '#008000', '#008b8b', '#0000cd', '#483d8b', '#8b008b', \n");
            ret.append("                   '#000000', '#8b0000', '#800000', '#a52a2a', '#556b2f', '#006400', '#006400', '#000080', '#4b0082', '#800080'); \n");            
            ret.append("$(document).ready(function(){ \n");
            ret.append("    $('#cptextcolor').colorPicker( \n");
            ret.append("    { \n");
            ret.append("        color:colors, \n");
            ret.append("        defaultColor:colors.indexOf('"+base.getAttribute("textcolor", "#000000").toLowerCase()+"'), // index of the default color \n");
            ret.append("        columns:10,     // number of columns \n");
            ret.append("        click:function(c){ \n");
            ret.append("            $('#textcolor').val(c); \n");
            ret.append("        } \n");
            ret.append("    }); \n");
            ret.append("}); \n");
            ret.append("</script> \n");
            ret.append("</td>");
            ret.append("\n</tr>");            
            ret.append("\n<tr>");
            ret.append("\n<td>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_imgTitle") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(bmp, gif, jpg, jpeg):</font></td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"file\" size=\"40\" name=\"imgencuesta\" onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\"/>");
            if(!"".equals(base.getAttribute("imgencuesta", "").trim())) {
                ret.append("<p>"+admResUtils.displayImage(base, base.getAttribute("imgencuesta").trim(), "imgencuesta") +"<input type=\"checkbox\" name=\"noimgencuesta\" value=\"1\"/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cutImage") + " <i>" + base.getAttribute("imgencuesta").trim() + "</i></p>");
            }
            ret.append("\n</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_imgVote") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(bmp, gif, jpg, jpeg):</font></td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"file\" size=\"40\" name=\"button\" onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\"/>");
            if(!"".equals(base.getAttribute("button", "").trim())) {
                ret.append("<p>"+admResUtils.displayImage(base, base.getAttribute("button").trim(), "button") +"<input type=\"checkbox\" name=\"nobutton\" value=\"1\"/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cutImage") + " <i>" + base.getAttribute("button").trim() + "</i></p>");
            }
            ret.append("\n</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_voteOnce") + "</td>");
            ret.append("\n<td>");
            value=base.getAttribute("oncevote", "true").trim();
            ret.append("\n<input type=\"radio\" name=\"oncevote\" value=\"true\" ");
            if("true".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_yes") +" ");
            ret.append("\n<input type=\"radio\" name=\"oncevote\" value=\"false\" ");
            if("false".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_no") +"</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_vmode") + "</td>");
            ret.append("\n<td>");
            value=base.getAttribute("vmode", "0").trim();
            ret.append("\n<input type=\"radio\" name=\"vmode\" value=\"0\" ");
            if("0".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_ipMode") +" ");
            ret.append("\n<input type=\"radio\" name=\"vmode\" value=\"1\" ");
            if("1".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cookieMode") +"</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_time") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_minutes") + "):</font></td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"text\" size=\"6\" maxlength=\"5\" name=\"time\" dir=\"rtl\" ");
            ret.append(" value=\"" + base.getAttribute("time", "20").trim() + "\"");
            ret.append("/></td>");
            ret.append("\n</tr>");            
            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append(paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_section2"));
            ret.append("</td> \n");
            ret.append("</tr> \n");
            
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_display_results") + "</td>");
            ret.append("\n<td>");
            value=base.getAttribute("display", "true").trim();
            ret.append("\n<input type=\"radio\" name=\"display\" value=\"true\" ");
            if ("true".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_window") + " ");
            ret.append("\n<input type=\"radio\" name=\"display\" value=\"false\" ");
            if ("false".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_collapseDiv") + "</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_spaceLine") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"text\" size=\"2\" maxlength=\"2\" name=\"branches\" ");
            ret.append(" value=\"" + base.getAttribute("branches", "1").trim() + "\"");
            ret.append("/></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_percentage") + "</td>");
            ret.append("\n<td>");
            value=base.getAttribute("porcent", "true").trim();
            ret.append("\n<input type=\"radio\" name=\"porcent\" value=\"true\" ");
            if("true".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_yes") + " ");
            ret.append("\n<input type=\"radio\" name=\"porcent\" value=\"false\" ");
            if("false".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_no") + "</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_total") + "</td>");
            ret.append("\n<td>");
            value=base.getAttribute("totvote", "true").trim();
            ret.append("\n<input type=\"radio\" name=\"totvote\" value=\"true\" ");
            if("true".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_yes") + " ");
            ret.append("\n<input type=\"radio\" name=\"totvote\" value=\"false\" ");
            if("false".equals(value)) {
                ret.append(" checked=\"checked\"");
            }
            ret.append("/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_no") + "</td>");
            ret.append("\n</tr>");
            
            ret.append("<tr> \n");
            ret.append("<td>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_textcolor")+"</td> \n");
            ret.append("<td>");
            ret.append("<table>\n");
            ret.append("<tr>\n");
            ret.append("<td>\n");
            ret.append("<input type=\"text\" size=\"7\" maxlength=\"7\" id=\"textcolorres\" name=\"textcolorres\" value=\""+base.getAttribute("textcolorres", "#000000").trim()+"\">\n");
            ret.append("</td>\n");            
            ret.append("<td bgcolor=\"" + base.getAttribute("textcolorres", "#000000") + "\" width=\"20\">&nbsp;</td>\n");
            ret.append("</tr>\n");
            ret.append("</table>\n");
            ret.append("</td> \n");
            ret.append("\n</tr>");
                         
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_otherTextcolor") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_hexadecimal") + "):</font></td>");
            ret.append("\n<td>");
            ret.append("<div id=\"cptextcolorres\"></div>\n");
            ret.append("<script src='/swb/swbadmin/js/jquery/colorpicker.js' type='text/javascript'></script>\n");
            ret.append("<script type=\"text/javascript\">\n");
            ret.append("$(document).ready(function(){ \n");
            ret.append("    $('#cptextcolorres').colorPicker( \n");
            ret.append("    { \n");
            ret.append("        color:colors, \n");
            ret.append("        defaultColor:colors.indexOf('"+base.getAttribute("textcolorres", "#000000").toLowerCase()+"'), // index of the default color \n");
            ret.append("        columns:10,     // number of columns \n");
            ret.append("        click:function(c){ \n");
            ret.append("            $('#textcolorres').val(c); \n");
            ret.append("        } \n");
            ret.append("    }); \n");
            ret.append("}); \n");
            ret.append("</script> \n");
            ret.append("</td>");
            ret.append("\n</tr>");            
            
            ret.append("\n<tr>");
            ret.append("\n<td>"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_imgBackground") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(bmp, gif, jpg, jpeg):</font></td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"file\" size=\"40\" name=\"backimgres\" onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\"/>");
            if(!"".equals(base.getAttribute("backimgres", "").trim())) {
                ret.append("<p>"+admResUtils.displayImage(base, base.getAttribute("backimgres").trim(), "backimgres") +"<input type=\"checkbox\" name=\"nobackimgres\" value=\"1\"/>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cutImage") + " <i>" + base.getAttribute("backimgres").trim() + "</i></p>");
            }
            ret.append("\n</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_msgResults")+" :</td>");
            ret.append("<td>");
            ret.append("<input type=\"text\" name=\"msg_viewresults\"");
            if(!"".equals(base.getAttribute("msg_viewresults", "").trim())) {
                ret.append( "value=\""+base.getAttribute("msg_viewresults").trim()+"\"");
            }
            ret.append("/></td>"); 
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_numVotes")+":</td>");
            ret.append("<td>");
            ret.append("<input type=\"text\" name=\"msg_vote\"");
            if(!"".equals(base.getAttribute("msg_vote", "").trim())) {
                ret.append(" value=\""+base.getAttribute("msg_vote").trim()+"\"");
            }
            ret.append("/></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_windowClose")+":</td>");
            ret.append("<td>");
            ret.append("<input type=\"text\" name=\"msg_closewin\"");
            if(!"".equals(base.getAttribute("msg_closewin", "").trim())) {
                ret.append(" value=\""+base.getAttribute("msg_closewin").trim()+ "\"");
            }
            ret.append("/></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_totalVotes")+":</td>");
            ret.append("<td>");
            ret.append("<input type=\"text\" name=\"msg_totvotes\"");
            if(!"".equals(base.getAttribute("msg_totvotes", "").trim())) {
                ret.append(" value=\""+base.getAttribute("msg_totvotes").trim()+"\"");
            }
            ret.append("/></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td>"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_vote")+":</td>");
            ret.append("<td>");
            ret.append("<input type=\"text\" name=\"msg_tovote\"");
            if(!"".equals(base.getAttribute("msg_tovote", "").trim())) {
                ret.append(" value=\""+base.getAttribute("msg_tovote").trim()+"\"");
            }
            ret.append("/></td>");
            ret.append("\n</tr>");            
            ret.append(admResUtils.loadWindowConfiguration(base, paramRequest));
            ret.append("</table> \n");
            ret.append("</fieldset>");
            
            ret.append("<fieldset>");
            ret.append("<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> \n");
            ret.append("<tr> \n");
            ret.append("<td> \n");
            ret.append("<input type=\"submit\" name=\"btnSave\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_submit") + "\" onClick=\"if(jsValida(this.form)) return true; else return false;\"/>&nbsp; \n");
            ret.append("<input type=\"reset\" name=\"btnReset\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_reset") + "\"/> \n");
            ret.append("</td> \n");
            ret.append("</tr> \n");            
            ret.append("</table> \n");
            ret.append("</fieldset>");
            ret.append("</form> \n");            
            ret.append("* " + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_required"));
            ret.append("</div>");
            ret.append(getScript(request, paramRequest));
        }
        catch(Exception e) {  log.error(e); }
        return ret.toString();
    }             
    
    /**
     * Metodo de validaci?n en javascript para la encuesta
     * @param request
     * @param paramsRequest
     */     
    private String getScript(HttpServletRequest request, SWBParamRequest paramsRequest)
    {
        StringBuffer ret = new StringBuffer("");
        try
        {
            ret.append("\n<script type=\"text/javascript\">");
            ret.append("\nvar swOk=0, optionObj;");
            ret.append("\nfunction jsValida(pForm)");
            ret.append("\n{");
            ret.append("\n   if(pForm.question.value==null || pForm.question.value=='' || pForm.question.value==' ')");
            ret.append("\n   {");
            ret.append("\n       alert('" + paramsRequest.getLocaleString("usrmsg_Encuesta_doAdmin_msgQuestion") + "');");
            ret.append("\n       pForm.question.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   if(pForm.selOption.length < 2)");
            ret.append("\n   {");
            ret.append("\n       alert('" + paramsRequest.getLocaleString("usrmsg_Encuesta_doAdmin_msgOption") + "');");
            ret.append("\n       pForm.txtOption.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   if (!setPrefix(pForm.selLink, 'http://')) return false;");            
            ret.append("\n   if(!isFileType(pForm.imgencuesta, 'bmp|jpg|jpeg|gif')) return false;");
            ret.append("\n   if(!isFileType(pForm.button, 'bmp|jpg|jpeg|gif')) return false;");
            ret.append("\n   if(!isFileType(pForm.backimgres, 'bmp|jpg|jpeg|gif')) return false;");
            ret.append("\n   if(pForm.textcolor.value==null || pForm.textcolor.value=='' || pForm.textcolor.value==' ')");
            ret.append("\n       pForm.textcolor.value='#'+ document.selColor.getColor();");
            ret.append("\n   if(!isHexadecimal(pForm.textcolor)) return false;");
            ret.append("\n   if(pForm.textcolorres.value==null || pForm.textcolorres.value=='' || pForm.textcolorres.value==' ')");
            ret.append("\n       pForm.textcolorres.value='#'+ document.selColorBack.getColor();");
            ret.append("\n   if(!isHexadecimal(pForm.textcolorres)) return false;");
            ret.append("\n   if(!isNumber(pForm.time)) return false;");
            ret.append("\n   if(!isNumber(pForm.branches)) return false;");
            ret.append("\n   if(!isNumber(pForm.width)) return false;");
            ret.append("\n   if(!isNumber(pForm.height)) return false;");
            ret.append("\n   if(!isNumber(pForm.top)) return false;");
            ret.append("\n   if(!isNumber(pForm.left)) return false;");            
            ret.append("\n   pForm.option.value='';");
            ret.append("\n   for(var i=0; i<pForm.selOption.length; i++)");
            ret.append("\n   {");
            ret.append("\n       if(i>0) pForm.option.value+=\"|\";");
            ret.append("\n       pForm.option.value+=pForm.selOption.options[i].value;");
            ret.append("\n   }");
            ret.append("\n   pForm.link.value='';");
            ret.append("\n   for(var i=0; i<pForm.selLink.length; i++)");
            ret.append("\n   {");
            ret.append("\n       if(i>0) pForm.link.value+=\"|\";");
            ret.append("\n       pForm.link.value+=pForm.selLink.options[i].value;");
            ret.append("\n   }");
            ret.append("\n   return true;");
            ret.append("\n}");
            ret.append(admResUtils.loadAddOption());            
            ret.append(admResUtils.loadEditOption());
            ret.append(admResUtils.loadUpdateOption());
            ret.append(admResUtils.loadDeleteOption());
            ret.append(admResUtils.loadDuplicateOption());
            ret.append(admResUtils.loadIsFileType());
            ret.append(admResUtils.loadIsNumber());
            ret.append(admResUtils.loadSetPrefix());
            ret.append(admResUtils.loadIsHexadecimal());            
            ret.append("\n</script>");
        }
        catch(Exception e) {  log.error(e); }
        return ret.toString();
    }        
    
}