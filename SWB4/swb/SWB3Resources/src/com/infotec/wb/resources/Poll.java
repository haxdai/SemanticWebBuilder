/**  
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
**/ 
 


/*
 * Poll.java
 *
 * Created on 20 de junio de 2002, 16:38
 */

package com.infotec.wb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
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
 * ciertos criterios(configuraci�n de recurso).
 *
 * Object that is in charge to unfold and to administer a survey of opinion under
 * certain criteria (resource configuration).
 * @author :Jorge Alberto Jim�nez Sandoval (JAJS)
 */

public class Poll extends org.semanticwb.portal.api.GenericResource
{
    private static Logger log = SWBUtils.getLogger(Poll.class);
    
    
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
            workPath = (String) SWBPortal.getWorkPath() +  base;
            webWorkPath = (String) SWBPortal.getWebWorkPath() +  base.getWorkPath();
            restype= base.getResourceType().getResourceClassName();
        }
        catch(Exception e) { log.error("Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);  }
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
        StringBuffer ret = new StringBuffer("");
        String action = null != request.getParameter("enc_act") && !"".equals(request.getParameter("enc_act").trim()) ? request.getParameter("enc_act").trim() : "enc_step1";
        if("enc_step2".equals(action))  showPollResults(request, response, paramRequest); // Resultados de la encuesta
        else 
        { // Encuesta
            Resource base=getResourceBase();
            try 
            {
                Document dom=SWBUtils.XML.xmlToDom(base.getXml());
                if(dom==null) {
                    ret.append("<br><a href=\"" + paramRequest.getRenderUrl().setMode(paramRequest.Mode_ADMIN) + "\">admin</a>");
                    response.getWriter().print(ret.toString());
                    return;
                }
                NodeList node = dom.getElementsByTagName("option");            
                if (!"".equals(base.getAttribute("question", "").trim()) && node.getLength() > 1)            
                {
                    ret.append("<form action=\""+paramRequest.getRenderUrl()+"\" method=\"POST\" name=\"frmEncuesta\" id=\"frmEncuesta\"> \n");
                    ret.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" style=\"font-family: Verdana; font-size: 12px; text-decoration: none; color: ");
                    ret.append(base.getAttribute("textcolor", "#000000").trim()+"\"> \n");
                    if (!"".equals(base.getAttribute("imgencuesta", "").trim()))
                    {
                        ret.append("<tr><td colspan=\"2\"> \n");
                        ret.append("<img src=\"");
                        ret.append(webWorkPath +"/"+ base.getAttribute("imgencuesta").trim());
                        ret.append("\" border=\"0\"> \n");
                        ret.append("</td></tr> \n");
                    }
                    ret.append("<tr><td colspan=\"2\"> \n");
                    ret.append(base.getAttribute("question").trim() + "</td></tr> \n");
                    for (int i = 0; i < node.getLength(); i++)
                    {
                        ret.append("<tr><td width=\"5\"><input type=\"radio\" name=\"radiobutton\" value=\"enc_votos" + (i + 1) + "\"></td> \n");
                        ret.append("<td>" + node.item(i).getChildNodes().item(0).getNodeValue().trim() +"</td></tr> \n");
                    }
                    ret.append("<tr><td align=\"center\" colspan=\"2\"> \n");
                    if (!"".equals(base.getAttribute("button", "").trim()))
                    {
                        ret.append("<input type=\"image\" name=\"votar\" src=\"" + webWorkPath +"/"+ base.getAttribute("button").trim() +"\" onClick=\"buscaCookie(this.form); return false;\"> \n");
                    } 
                    else ret.append("<input type=\"button\" name=\"votar\" value=\"" + base.getAttribute("msg_tovote",paramRequest.getLocaleString("msg_tovote")) +"\" onClick=\"buscaCookie(this.form);\"> \n");
                    ret.append("</td></tr> \n");
                    ret.append("<tr><td align=\"center\" colspan=\"2\"> \n");

                    SWBResourceURLImp url=new SWBResourceURLImp(request, base, paramRequest.getWebPage(),SWBResourceURL.UrlType_RENDER);
                    url.setResourceBase(base);
                    url.setMode(url.Mode_VIEW);
                    url.setWindowState(url.WinState_MAXIMIZED);
                    url.setParameter("enc_act","enc_step2");
                    url.setParameter("NombreCookie","VotosEncuesta"+ base.getId());
                    url.setTopic(paramRequest.getWebPage());
                    url.setCallMethod(paramRequest.Call_DIRECT);

                    ret.append("\n<a href=\"javascript:abreresultados(\'" + url.toString(true) + "\')\">" + base.getAttribute("msg_viewresults",paramRequest.getLocaleString("msg_viewresults")) + "</a> \n");
                    ret.append("<br><br></td></tr> \n");
                    ret.append("<tr><td align=\"center\" colspan=\"2\"> \n");
                    if("1".equals(base.getAttribute("wherelinks", "").trim()) || "3".equals(base.getAttribute("wherelinks", "").trim()))
                    {
                        ret.append(getLinks(dom.getElementsByTagName("link"), paramRequest.getLocaleString("usrmsg_Encuesta_doView_relatedLink")));
                    }
                    ret.append("</td></tr> \n");
                    ret.append("</table> \n");
                    ret.append("<input type=\"hidden\" name=\"NombreCookie\" value=\"VotosEncuesta"+ base.getId() +"\"> \n");
                    ret.append("</form> \n");

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
                    ret.append("<script type=\"text/javascript\"> \n");
                    ret.append("function buscaCookie(forma) \n");
                    ret.append("{ \n");
                    ret.append("    var numcom = getCookie(forma.NombreCookie.value); \n");
                    ret.append("    if (numcom == \"SI\") { \n");
                    if ("true".equals(base.getAttribute("oncevote", "true").trim()) && !"0".equals(base.getAttribute("vmode", "0").trim())){
                        ret.append("        alert('"+ paramRequest.getLocaleString("usrmsg_Encuesta_doView_msgVote") +"'); \n");
                    }
                    ret.append("     } ");
                    ret.append("    else \n");
                    ret.append("    { \n");
                    //if ("true".equals(base.getAttribute("oncevote", "true").trim()))
                    //ret.append("        setCookie(forma.NombreCookie.value); \n");
                    ret.append("    } \n");
                    ret.append("        Grabaencuesta(forma); \n");
                    ret.append("} \n");
                    ret.append("function setCookie(name) \n");
                    ret.append("{ \n");
                    ret.append("    document.cookie = name; \n");
                    ret.append("    var expDate = new Date(); \n");
                    ret.append("    expDate.setTime(expDate.getTime() + ( 720 * 60 * 60 * 1000) ); \n");
                    ret.append("    expDate = expDate.toGMTString(); \n");
                    ret.append("    var str1 = name +\"=SI; expires=\" + expDate + \";Path=/\"; \n");
                    ret.append("    document.cookie = str1; \n");
                    ret.append("} \n");
                    ret.append("function getCookie (name) \n");
                    ret.append("{ \n");
                    ret.append("    var arg = name + \"=\"; \n");
                    ret.append("    var alen = arg.length; \n");
                    ret.append("    var clen = document.cookie.length; \n");
                    ret.append("    var i = 0; \n");
                    ret.append("    while (i < clen)\n");
                    ret.append("    { \n");
                    ret.append("        var j = i + alen; \n");
                    ret.append("        if (document.cookie.substring(i, j) == arg) \n");
                    ret.append("            return getCookieVal (j); \n");
                    ret.append("        i = document.cookie.indexOf(\" \", i) + 1; \n");
                    ret.append("        if (i == 0) break; \n");
                    ret.append("    } \n");
                    ret.append("    return null; \n");
                    ret.append("} \n");
                    ret.append("function getCookieVal (offset) \n");
                    ret.append("{ \n");
                    ret.append("    var endstr = document.cookie.indexOf (\";\", offset); \n");
                    ret.append("    if (endstr == -1) \n");
                    ret.append("        endstr = document.cookie.length; \n");
                    ret.append("    return unescape(document.cookie.substring(offset, endstr)); \n");
                    ret.append("} \n");
                    ret.append("function Grabaencuesta(forma) \n");
                    ret.append("{ \n");
                    ret.append("    var radiobutton; \n");
                    ret.append("    for(var i=0; i< forma.length; i++) \n");
                    ret.append("    { \n");
                    ret.append("        if(forma.elements[i].type == \"radio\") \n");
                    ret.append("            if(forma.elements[i].checked) \n");
                    ret.append("                radiobutton=forma.elements[i].value; \n");
                    ret.append("    } \n");
                    ret.append("    if(radiobutton!=null) { \n");
                    ret.append("        window.open(\'"+ url.toString() +"&radiobutton=\' + radiobutton,\'_newsave\',\'"+ win + "\'); \n");
                    ret.append("    } \n");
                    ret.append("    else { alert('"+ paramRequest.getLocaleString("usrmsg_Encuesta_doView_msgAnswer") +"'); } \n");
                    ret.append("} \n");
                    ret.append("function abreresultados(ruta) \n");
                    ret.append("{ \n");
                    ret.append("    window.open(ruta,\'_newenc\',\'"+ win +"\'); \n");
                    ret.append("} \n");
                    ret.append("</script> \n");
                }
            } 
            catch (Exception e) { log.error(paramRequest.getLocaleString("error_Encuesta_doView_resource") +" "+ restype +" "+ paramRequest.getLocaleString("error_Encuesta_doView_method"), e); }
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
    public void showPollResults(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        StringBuffer ret = new StringBuffer("");
        Resource base=getResourceBase();
        try
        {
            String data = base.getData();
            Document dom = null;
            if(data != null) {
                dom = SWBUtils.XML.xmlToDom(data);
            }
            if (request.getParameter("radiobutton") != null && request.getParameter("radiobutton").length()>9)
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
                    try{ valor=Integer.parseInt(request.getParameter("radiobutton").substring(9)); }
                    catch(Exception e) { valor=0; log.error("", e); }
                    if(valor > 0)
                    {
                        String varia = "enc_votos";
                        if (data == null)
                        {
                            try
                            {
                                dom = SWBUtils.XML.getNewDocument();
                                Element root = dom.createElement("resource");
                                dom.appendChild(root);
                                Element option = dom.createElement(varia + valor);
                                option.appendChild(dom.createTextNode("1"));
                                root.appendChild(option);
                                base.setData(SWBUtils.XML.domToXml(dom));
                            } 
                            catch (Exception e) { log.error(paramRequest.getLocaleString("error_Encuesta_doView_setData") +" "+ restype +" " + paramRequest.getLocaleString("error_Encuesta_doView_id") +" "+ base.getId() +" - "+ base.getTitle(), e); }
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
                                base.addHit(request, paramRequest.getUser(), paramRequest.getWebPage());
                            } 
                            catch (Exception e) { log.error(paramRequest.getLocaleString("error_Encuesta_doView_setData") +" "+ restype +" " + paramRequest.getLocaleString("error_Encuesta_doView_id") +" "+ base.getId() +" - "+ base.getTitle(), e); }
                        }
                    }
                }
            } 
            ret.append(getPollResults(request, paramRequest, dom));
        }
        catch(Exception e)  { log.error(e); }
        response.getWriter().print(ret.toString());
    }
    
    
    /**
     * Metodo que valida si se encuentra la cookie de la encuensta registrada en la maquina del usuario
     * @param request
     */
    private boolean validateCookie(javax.servlet.http.HttpServletRequest request){
        for(int i=0;i<request.getCookies().length;i++){
            javax.servlet.http.Cookie cookie=request.getCookies() [i];
            if(request.getParameter("NombreCookie").equals(cookie.getName()) && cookie.getValue().equals("SI")) return true;
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
        int minutes=20;
        try { minutes=Integer.parseInt(getResourceBase().getAttribute("time", "20").trim()); }
        catch(Exception e){ minutes=20; }
        Date date = new Date();
        Timestamp fctual = new Timestamp(date.getTime());
        date = new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes() + minutes, date.getSeconds());
        Timestamp Tfctualmoretime = new Timestamp(date.getTime());
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
                      // almacenando IPs en hash secundario. Aqu� entrar�a como segundo paso.
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
                      // se elimina hashes y se crean de nuevo. Aqu� entrar�a como tercer paso.
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
        { // No existe hash primario. Aqu� entraria como primer paso.
            hashSec = new HashMap();
            hashSec.put(request.getRemoteAddr(), fctual);
            hashPrim = new HashMap();
            hashPrim.put(hashSec, Tfctualmoretime);
        }
        return flag;
    }
    
    /*
     * @param request
     * @param reqParams
     * @param data
     * @throws AFException
     * @throws IOException
     */ 
    /**
     * Muestra los resultados de la encuesta
     */    
    private String getPollResults(HttpServletRequest request, SWBParamRequest paramRequest, Document data) throws SWBResourceException, IOException
    {
        StringBuffer ret = new StringBuffer("");
        Resource base=getResourceBase();
        try
        {
            Document dom=SWBUtils.XML.xmlToDom(base.getXml());
            if(dom==null) {
                return ret.toString();
            }
            ret.append("<html> \n");
            ret.append("<head> \n");
            ret.append("<title>" + paramRequest.getLocaleString("usrmsg_Encuesta_getResultEnc_title") + "</title> \n");
            ret.append("</head> \n");
            ret.append("<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\"");
            if (!"".equals(base.getAttribute("textcolores", "").trim())) {
                ret.append(" text=\"" + base.getAttribute("textcolores").trim() + "\"");
            }
            if (!"".equals(base.getAttribute("backimgres", "").trim())) {
                ret.append(" background=\"" + webWorkPath +"/"+ base.getAttribute("backimgres").trim() + "\"");
            }
            ret.append("><br><br> \n");
            /*
             * Se calcula el n�mero de saltos que se proporcion� en la admon. del recurso
             * y se procede a generar la cadena de <BR> respectivos.
             */
            int count =1;
            try { Integer.parseInt(base.getAttribute("branches", "1")); } 
            catch(Exception e) { count=1; }
            for (int i = 0; i < count; i++) {
                ret.append("<br>");
            }

            NodeList node = dom.getElementsByTagName("option");            
            ret.append("<table border=\"0\" cellpadding=\"5\" cellspacing=\"5\" align=\"center\" style=\"font-family: Verdana; font-size: 12px; text-decoration: none;\"> \n");
            if (!"".equals(base.getAttribute("question", "").trim()) && node.getLength() > 1)            
            {
                ret.append("<tr><td><b>" + base.getAttribute("question").trim() + "</b></td></tr> \n");
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
                    ret.append("<tr><td> \n");
                    ret.append("<table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"3\" style=\"font-family: Verdana; font-size: 12px; text-decoration: none;\"> \n");
                    
                    boolean porcent = Boolean.valueOf(base.getAttribute("porcent","true")).booleanValue();
                    boolean totvote = Boolean.valueOf(base.getAttribute("totvote","true")).booleanValue();
                    for (int i = 0; i < node.getLength(); i++)
                    {
                        int num = i + 1;
                        ret.append("<tr valign=top><td align=right> \n");
                        ret.append(node.item(i).getChildNodes().item(0).getNodeValue());
                        ret.append(":</td><td width=150> \n");
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
                                ret.append("<img src=\"" + SWBPlatform.getContextPath() + "swbadmin/images/linealleno1.gif\" width=" + largo + " height=\"5\"> \n");
                                ret.append("<img src=\"" + SWBPlatform.getContextPath() + "swbadmin/images/lineavacio.gif\" width=\"" + falta + "\" height=\"5\"> \n");
                                ret.append("<br><center><b> \n");
                                if (porcent) {
                                    ret.append(largo + "%");
                                }
                                if (porcent && totvote) {
                                    ret.append(" : ");
                                }
                                if (totvote) {
                                    ret.append(intVotos + " " + base.getAttribute("msg_vote",paramRequest.getLocaleString("msg_vote")) + "(s)");
                                }
                                ret.append("</b></center> \n");
                            }
                        }
                        ret.append("</td></tr> \n");
                    }
                    intAjuste = 0;
                    ret.append("</table> \n");
                    ret.append("</td></tr> \n");
                    if (totvote) ret.append("<tr><td align=\"right\">"+ base.getAttribute("msg_totvotes",paramRequest.getLocaleString("msg_totvotes")) + ": " + intTotalVotos + "</td></tr>");
                } 
                else ret.append("<tr><td>" + paramRequest.getLocaleString("usrmsg_Encuesta_getResultEnc_noVotes") +"</td></tr> \n");
                ret.append("<tr><td align=\"center\"> \n");
                if("2".equals(base.getAttribute("wherelinks", "").trim()) || "3".equals(base.getAttribute("wherelinks", "").trim()))
                {
                    ret.append("<br>"+getLinks(dom.getElementsByTagName("link"), paramRequest.getLocaleString("usrmsg_Encuesta_doView_relatedLink")));
                }
                ret.append("</td></tr> \n");
                ret.append("<tr><td align=\"center\"><br><a href=\"javascript:window.close();\">" + base.getAttribute("msg_closewin",paramRequest.getLocaleString("msg_closewin")) + "</a></td></tr> \n");
                ret.append("</table>");
                ret.append("</body>");
                ret.append("</html>");
            }
        } 
        catch (Exception e) { log.error(paramRequest.getLocaleString("error_Encuesta_doView_resource") +" "+ restype +" "+ paramRequest.getLocaleString("error_Encuesta_doView_method"), e); }
        return ret.toString();
    }

    
    /*
     * @param links
     * @param comment
     */ 
    /**
     * obtiene el html de los links relacionados con la encuesta, que fueron
     * proporcionados desde la administraci�n
     */    
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
                ret.append("<a href=\"" + value + "\" target=\"_newlink\">"+ _comment + "</a><br> \n");
                _comment=comment;
            }
        }
        return ret.toString();
    }
    
    /**
     * Metodo que despliega la administraci�n del recurso
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

        if(action.equals("add") || action.equals("edit"))  ret.append(getForm(request, paramRequest));
        else if(action.equals("update"))
        {            
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
                                if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif")){
                                    msg=paramRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif</i>: " + file;
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
                                if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif")) {
                                    msg=paramRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif</i>: " + file;
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
                                if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif")) {
                                    msg=paramRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif</i>: " + file;
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
                    setAttribute(base, fup, "porcent");
                    setAttribute(base, fup, "totvote");
                    setAttribute(base, fup, "textcolores");
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
     * Metodo que muestra la forma de la encuesta de opini�n en html
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
            ret.append("<form name=\"frmResource\" method=\"post\" enctype=\"multipart/form-data\" action=\""+ url.toString()+"\"> \n");            
            //ret.append("<div class=box>");
            ret.append("<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\">");
            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append("<font style=\"color: #428AD4; text-decoration: none; font-family: Verdana; font-size: 12px; font-weight: normal;\">");
            ret.append(paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_section1") +"</font>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">* " + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_question") + "</td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=text size=50 name=question ");
            if (!"".equals(base.getAttribute("question", "").trim()))  ret.append(" value=\"" + base.getAttribute("question").trim().replaceAll("\"", "&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">* " + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_option") + "</td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=text size=50 name=txtOption><input type=hidden name=option ");
            if (!"".equals(base.getAttribute("option", "").trim())) ret.append(" value=\"" + base.getAttribute("option").trim().replaceAll("\"", "&#34;") + "\"");
            ret.append(">");
            ret.append("\n<input type=button name=btnAdd  class=\"boton\" value=" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnAdd") + " onClick=\"addOption(this.form.selOption, this.form.txtOption)\">");
            ret.append("\n<input type=button name=btnEdit class=\"boton\" value=" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnEdit") + " onClick=\"updateOption(this.form.selOption, this.form.txtOption)\">");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td>&nbsp;</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("\n<select name=\"selOption\" size=5 multiple onChange=\"editOption(this.form.selOption, this.form.txtOption)\">");
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
            ret.append("\n<input type=button name=btnDel class=\"boton\" value=" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnDelete") + " onClick=\"deleteOption(this.form.selOption, this.form.txtOption)\" >");
            ret.append("</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_link") + "</td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=text size=50 name=txtLink><input type=hidden name=link ");
            if (!"".equals(base.getAttribute("link", "").trim())) ret.append(" value=\"" + base.getAttribute("link").trim().replaceAll("\"", "&#34;") + "\"");
            ret.append(">");
            ret.append("\n<input type=button name=btnAdd  class=\"boton\" value=" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnAdd") + " onClick=\"addOption(this.form.selLink, this.form.txtLink)\" >");
            ret.append("\n<input type=button name=btnEdit class=\"boton\" value=" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnEdit") + "  onClick=\"updateOption(this.form.selLink, this.form.txtLink)\" >");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td>&nbsp;</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("\n<select name=\"selLink\" size=5 multiple onChange=\"editOption(this.form.selLink, this.form.txtLink)\">");
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
            ret.append("\n<input type=button name=btnDel class=\"boton\" value=" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_btnDelete") + " onClick=\"deleteOption(this.form.selLink, this.form.txtLink)\" >");
            ret.append("</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_displayLinks") + "</td>");
            ret.append("\n<td class=\"valores\">");
            value=base.getAttribute("wherelinks", "1").trim();
            ret.append("\n<input type=radio name=\"wherelinks\" value=\"1\" ");
            if ("1".equals(value)) ret.append(" checked");
            ret.append(">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_onPoll")+"<br>");
            ret.append("\n<input type=radio name=\"wherelinks\" value=\"2\" ");
            if ("2".equals(value)) ret.append(" checked");
            ret.append(">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_onPollResults")+"<br>");
            ret.append("\n<input type=radio name=\"wherelinks\" value=\"3\" ");
            if ("3".equals(value)) ret.append(" checked");
            ret.append(">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_onBoth")+"<br></td>");
            ret.append("</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_textcolor") + "</td>");
            ret.append("\n<td class=\"valores\">");
          
            HashMap param=new HashMap();
            param.put("id", "selColor");
            param.put("session", request.getSession().getId());
            param.put("linkcolor",  base.getAttribute("textcolor", "#000000").trim().substring(1));
            param.put("linkactual", base.getAttribute("textcolor", "#000000").trim().substring(1));
            ret.append(admResUtils.loadColorApplet(param));
           

//            ret.append("<script type=\"text/javascript\">");
//            ret.append("   dojo.require(\"dijit.ColorPalette\");");
//            ret.append("   dojo.addOnLoad(function(){ ");
//            ret.append("   var myPalette = new dijit.ColorPalette({ ");
//            ret.append("   palette: \"7x10\", ");
//            ret.append("   onChange: function(val){ document.frmResource.textcolor.value=val;}  ");
//            ret.append("   }, \"placeHolder\" ); ");
//            ret.append("   }); ");
//            ret.append("</script>");
//            ret.append("<span id=\"placeHolder\"></span>");
//            ret.append("</td> \n");
//            ret.append("\n</tr>");
            
             
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_otherTextcolor") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_hexadecimal") + "):</font></td>");
            ret.append("\n<td>");
            ret.append("\n<table>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=\"text\" size=\"7\" maxlength=\"7\" id=\"textcolor\" name=\"textcolor\" value=\""+base.getAttribute("textcolor", "#000000").trim().substring(1)+"\">");
            ret.append("</td>");
            ret.append("<td class=\"datos\">");
            ret.append("-"+paramRequest.getLocaleString("actual_color") + "</td><td bgcolor=\""+base.getAttribute("textcolor", "#000000")+"\" width=\"5\">&nbsp;</td>");
             ret.append("</tr>");
             ret.append("</table>");
            ret.append("</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_imgTitle") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(bmp, gif, jpg, jpeg):</font></td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=file size=40 name=imgencuesta onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\">");
            if (!"".equals(base.getAttribute("imgencuesta", "").trim())) ret.append("<p>"+admResUtils.displayImage(base, base.getAttribute("imgencuesta").trim(), "imgencuesta") +"<input type=checkbox name=noimgencuesta value=1>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cutImage") + " <i>" + base.getAttribute("imgencuesta").trim() + "</i></p>");
            ret.append("\n</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_imgVote") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(bmp, gif, jpg, jpeg):</font></td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=file size=40 name=button onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\">");
            if (!"".equals(base.getAttribute("button", "").trim())) ret.append("<p>"+admResUtils.displayImage(base, base.getAttribute("button").trim(), "button") +"<input type=checkbox name=nobutton value=1>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cutImage") + " <i>" + base.getAttribute("button").trim() + "</i></p>");
            ret.append("\n</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_voteOnce") + "</td>");
            ret.append("\n<td class=\"valores\">");
            value=base.getAttribute("oncevote", "true").trim();
            ret.append("\n<input type=radio name=oncevote value=true ");
            if ("true".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_yes") +" ");
            ret.append("\n<input type=radio name=oncevote value=false ");
            if ("false".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_no") +"</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_vmode") + "</td>");
            ret.append("\n<td class=\"valores\">");
            value=base.getAttribute("vmode", "0").trim();
            ret.append("\n<input type=radio name=vmode value=0 ");
            if ("0".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_ipMode") +" ");
            ret.append("\n<input type=radio name=vmode value=1 ");
            if ("1".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cookieMode") +"</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_time") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_minutes") + "):</font></td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=text size=6 maxlength=5 name=time dir=rtl ");
            ret.append(" value=\"" + base.getAttribute("time", "20").trim() + "\"");
            ret.append("></td>");
            ret.append("\n</tr>");            
            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append("<br><br><font style=\"color: #428AD4; text-decoration: none; font-family: Verdana; font-size: 12px; font-weight: normal;\">");
            ret.append(paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_section2") +"</font>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_spaceLine") + "</td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=text size=2 maxlength=2 name=branches ");
            ret.append(" value=\"" + base.getAttribute("branches", "1").trim() + "\"");
            ret.append("></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_percentage") + "</td>");
            ret.append("\n<td class=\"valores\">");
            value=base.getAttribute("porcent", "true").trim();
            ret.append("\n<input type=radio name=porcent value=true ");
            if ("true".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_yes") + " ");
            ret.append("\n<input type=radio name=porcent value=false ");
            if ("false".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_no") + "</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_total") + "</td>");
            ret.append("\n<td class=\"valores\">");
            value=base.getAttribute("totvote", "true").trim();
            ret.append("\n<input type=radio name=totvote value=true ");
            if ("true".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_yes") + " ");
            ret.append("\n<input type=radio name=totvote value=false ");
            if ("false".equals(value)) ret.append(" checked");
            ret.append(">" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_no") + "</td>");
            ret.append("\n</tr>");
            
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_textcolor")+"</td> \n");
            ret.append("<td class=\"valores\">");
           
            param.put("id", "selColorBack");
            param.put("linkcolor",  base.getAttribute("textcolores", "#000000").trim().substring(1));
            param.put("linkactual", base.getAttribute("textcolores", "#000000").trim().substring(1));
            ret.append(admResUtils.loadColorApplet(param));
           
            
//            ret.append("<script type=\"text/javascript\">");
//            ret.append("   dojo.require(\"dijit.ColorPalette\");");
//            ret.append("   dojo.addOnLoad(function(){ ");
//            ret.append("   var myPalette = new dijit.ColorPalette({ ");
//            ret.append("   palette: \"7x10\", ");
//            ret.append("   onChange: function(val){ document.frmResource.textcolores.value=val;}  ");
//            ret.append("   }, \"placeHolder1\" ); ");
//            ret.append("   }); ");
//            ret.append("</script>");
//            ret.append("<span id=\"placeHolder1\"></span>");
//            ret.append("</td> \n");
//            ret.append("\n</tr>");
                         
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_otherTextcolor") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_hexadecimal") + "):</font></td>");
            ret.append("\n<td>");
            ret.append("\n<table>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=\"text\" size=\"7\" maxlength=\"7\" id=\"textcolores\" name=\"textcolores\" value=\""+base.getAttribute("textcolores", "#000000").trim().substring(1)+"\">");
            ret.append("</td>");
            ret.append("<td class=\"datos\">");
            ret.append("-"+paramRequest.getLocaleString("actual_color") + "</td><td bgcolor=\""+base.getAttribute("textcolores", "#000000")+"\" width=\"5\">&nbsp;</td>");
            ret.append("</tr>");
            ret.append("</table>");
            ret.append("</td>");
            ret.append("\n</tr>");
            
            
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+ paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_imgBackground") + "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\">(bmp, gif, jpg, jpeg):</font></td>");
            ret.append("\n<td class=\"valores\">");
            ret.append("\n<input type=file size=40 name=backimgres onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\">");
            if (!"".equals(base.getAttribute("backimgres", "").trim())) ret.append("<p>"+admResUtils.displayImage(base, base.getAttribute("backimgres").trim(), "backimgres") +"<input type=checkbox name=nobackimgres value=1>" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_cutImage") + " <i>" + base.getAttribute("backimgres").trim() + "</i></p>");
            ret.append("\n</td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_msgResults")+" :</td>");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"text\" name=\"msg_viewresults\"");
            if (!"".equals(base.getAttribute("msg_viewresults", "").trim())) ret.append( "value=\""+base.getAttribute("msg_viewresults").trim()+"\"");
            ret.append("></td>"); 
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_numVotes")+":</td>");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"text\" name=\"msg_vote\"");
            if (!"".equals(base.getAttribute("msg_vote", "").trim())) ret.append(" value=\""+base.getAttribute("msg_vote").trim()+"\"");
            ret.append("></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_windowClose")+":</td>");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"text\" name=\"msg_closewin\"");
            if (!"".equals(base.getAttribute("msg_closewin", "").trim())) ret.append(" value=\""+base.getAttribute("msg_closewin").trim()+ "\"");
            ret.append("></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_totalVotes")+":</td>");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"text\" name=\"msg_totvotes\"");
            if (!"".equals(base.getAttribute("msg_totvotes", "").trim())) ret.append(" value=\""+base.getAttribute("msg_totvotes").trim()+"\"");
            ret.append("></td>");
            ret.append("\n</tr>");
            ret.append("\n<tr>");
            ret.append("\n<td class=\"datos\">"+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_message")+" "+paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_vote")+":</td>");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"text\" name=\"msg_tovote\"");
            if (!"".equals(base.getAttribute("msg_tovote", "").trim())) ret.append(" value=\""+base.getAttribute("msg_tovote").trim()+"\"");
            ret.append("></td>");
            ret.append("\n</tr>");            
            ret.append(admResUtils.loadWindowConfiguration(base, paramRequest));
            ret.append("\n<tr>");
            ret.append("\n<td colspan=2 align=right>");
            ret.append("<br><hr size=1 noshade> \n");
            ret.append("\n<input type=submit name=btnSave class=\"boton\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_submit") + "\" onClick=\"if(jsValida(this.form)) return true; else return false;\">&nbsp;");
            ret.append("<input type=reset name=btnReset class=\"boton\" value=\"" + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_reset") + "\">");
            ret.append("\n</td>");
            ret.append("\n</tr>");
            ret.append("<tr> \n");
            ret.append("<td colspan=2 class=datos><br><font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\"> \n");
            ret.append("* " + paramRequest.getLocaleString("usrmsg_Encuesta_doAdmin_required"));
            ret.append("</font></td> \n");
            ret.append("</tr> \n");
            ret.append("</table> \n");
            //ret.append("</div> \n");
            ret.append("</form> \n");
            ret.append(getScript(request, paramRequest));
        }
        catch(Exception e) {  log.error(e); }
        return ret.toString();
    }             
    
    /**
     * Metodo de validaci�n en javascript para la encuesta
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
            ret.append("\n   if(pForm.textcolores.value==null || pForm.textcolores.value=='' || pForm.textcolores.value==' ')");
            ret.append("\n       pForm.textcolores.value='#'+ document.selColorBack.getColor();");
            ret.append("\n   if(!isHexadecimal(pForm.textcolores)) return false;");
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
