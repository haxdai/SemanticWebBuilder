/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur;

import java.io.*;
import java.util.*;
import java.net.*;

import java.util.Properties;
import javax.servlet.http.*;

import org.w3c.dom.*;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.admin.admresources.util.XmlBundle;

import com.arthurdo.parser.*;
import javax.servlet.RequestDispatcher;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.api.SWBParamRequestImp;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.lib.SWBResponse;

/**
 *
 * @author jorge.jimenez
 */
public class pymesURLContent extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(pymesURLContent.class);

    String xml=null;
    XmlBundle bundle=null;
    static Properties recproperties = null;
    String msg1 = null,msg2 = null;
    String host = "";
    String file = "";
    String paramfromUrl = "";
    String nameClass="pymesUrlContent";

    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        FileInputStream fptr = null;
        recproperties = new Properties();
        try {
                int pos=-1;
                pos=this.getClass().getName().lastIndexOf(".");
                if(pos>-1){
                    nameClass=this.getClass().getName().substring(pos+1);
                }
                try {
                    fptr =  new FileInputStream(SWBPortal.getWorkPath()+"/sites/"+base.getWebSiteId()+"/config/resources/"+nameClass+".properties");
                }catch(Exception e) {
                }
                if(fptr==null) { //busca en raiz de work/config
                    try {
                        fptr = new FileInputStream(SWBPortal.getWorkPath()+"/work/config/resources/"+nameClass+".properties");
                    }catch(Exception e) {
                    }
                }
                if (fptr != null) {
                    recproperties.load(fptr);
                    msg1 = recproperties.getProperty("FuneteOriginal");
                    msg2 = recproperties.getProperty("InfoOriginal");
                }
        }catch(Exception e){
            log.error("Error while loading resource properties file: "+base.getId() +"-"+ base.getTitle(), e);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base=getResourceBase();
        if(base.getAttribute("msg1")!=null) msg1=base.getAttribute("msg1");
        if(base.getAttribute("msg2")!=null) msg2=base.getAttribute("msg2");
        if(msg1==null) msg1 = paramRequest.getLocaleString("msg1") + ":";
        if(msg2==null) msg2 = paramRequest.getLocaleString("msg2") + ":";
        StringBuffer ret = new StringBuffer();
        try{
            Document dom = SWBUtils.XML.xmlToDom(base.getXml());
            if(dom == null) {
                throw new SWBResourceException("Dom nulo");
            }
            ret.append("<!-- <content id=\"" + base.getId() + "\"/> -->");
            String param = "";
            StringBuffer othersparam = new StringBuffer();
            try {
                if(request.getParameter("urlwb") == null) {
                    NodeList url = dom.getElementsByTagName("url");
                    if(url.getLength() > 0 && url.item(0).getChildNodes()!=null && url.item(0).getChildNodes().item(0)!=null) {
                        String surl = url.item(0).getChildNodes().item(0).getNodeValue();
                        if(surl!=null && surl.startsWith("http://")){
                            ret.append(CorrigeRuta(surl, paramRequest.getWebPage(), param, othersparam, request,paramRequest));
                        }
                    }else{
                            WebPage page=paramRequest.getWebPage();
                            Iterator <Resource> itResources=page.listResources();
                            while(itResources.hasNext()){
                                Resource resource=itResources.next();
                                String resTypeUri=resource.getResourceType().getURI();
                                if(!resource.isActive() && resTypeUri.endsWith(":WordContent"))
                                { //Solo si es un contenido que no esta activo y sea de tipo word
                                    //if(resource.isValid() && paramRequest.getUser().haveAccess(resource))
                                    {
                                        ((SWBParamRequestImp)paramRequest).setResourceBase(resource);
                                        ((SWBParamRequestImp)paramRequest).setVirtualResource(resource);
                                        SWBResource res=SWBPortal.getResourceMgr().getResource(page.getWebSite().getId(), resource.getId());
                                        SWBResponse resp=new SWBResponse(response);
                                        res.render(request, resp, paramRequest);
                                        ret.append(resp.toString());
                                    }
                                }
                            }
                    }
                }
            }catch (Exception f) {
                ret.append("page is not in well formed..");
                ret.append("<nocache/>");
                log.error("Error in UrlContent resource while decoding page: "+paramRequest.getWebPage().getId(), f);
            }
        }catch (Exception e) {
            log.error("Error in resource WBUrlContent while bringing HTML ", e);
        }

        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId();
        RequestDispatcher dis = request.getRequestDispatcher(siteWorkDir + "/jsp/pymestur/pymesURLContent.jsp");
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("ret", ret.toString());
            dis.include(request, response);
        }catch (Exception e)
        {
            log.error(e);
        }
    }


    /**
     * Parsea el flujo del contenido remoto parseando rutas y ligas y generando el
     * resultado final del mismo
     * @param surl
     * @param topic
     * @param param
     * @param othersparam
     * @param request
     * @param paramsRequest
     * @throws SWBResourceException
     * @return
     */
    public StringBuffer CorrigeRuta(String surl, WebPage topic, String param, StringBuffer othersparam, HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException {
        Resource base=getResourceBase();
        String OriPath = surl;
        String cadCod = null;

        Document dom = SWBUtils.XML.xmlToDom(base.getXml());

        HtmlTag tag = new HtmlTag();
        int pos = -1;
        host = "";
        file = "";
        paramfromUrl = "";
        String para = "";
        String urlfin = "";
        String surlHex = "";
        String hostHex = "";
        String valueHex = "";
        String surlfile = "";
        String surlfileHex = "";
        StringBuffer ret = new StringBuffer();
        String envia = paramRequest.getRenderUrl().toString();
        if (!surl.toLowerCase().startsWith("http://") && !surl.toLowerCase().startsWith("https://"))
            surl = "http://" + surl;

        pos = -1;
        if (surl.startsWith("http://"))
            pos = surl.indexOf("/", 7);
        else if (surl.startsWith("https://"))
            pos = surl.indexOf("/", 8);
        if (pos != -1) {
            host = surl.substring(0, pos);
        } else {
            host = surl + "/";
        }

        surl+="/_lang/"+paramRequest.getUser().getLanguage();

        String ssign = "";
        if (!param.equals(""))
            ssign = "?";
        String sothersparam = "";
        if (othersparam != null)
            sothersparam = othersparam.toString();

        sothersparam = sothersparam.replaceAll(" ", "%20");
        

        if (file.indexOf("?") > -1 && sothersparam != null && sothersparam.length() > 0 && sothersparam.charAt(0) == '?') sothersparam = "&" + sothersparam.substring(1);


        if (request.getMethod().equals("POST"))
            urlfin = surl + file + sothersparam;
        else
            urlfin = surl + file + ssign + param + sothersparam;

        pos = -1;
        pos = file.indexOf("?");
        if (pos > -1) {
            surlfile = surl + file.substring(0, pos);
        } else
            surlfile = surl + file;

        try {
            URL pagina = new URL(urlfin);
            String hostCookie = pagina.getHost();
            String cookie = (String) request.getSession().getAttribute("Cookie:" + hostCookie);
            String sheader = request.getHeader("user-agent");

            URLConnection conex = pagina.openConnection();
            if (cookie != null) conex.setRequestProperty("Cookie", cookie);
            if (sheader != null) conex.setRequestProperty("user-agent", sheader);

            DataInputStream datos = new DataInputStream(conex.getInputStream());
            HtmlStreamTokenizer tok = new HtmlStreamTokenizer(datos);
            boolean findstar=false;
            int contP=0;
            while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF) {
                int ttype = tok.getTokenType();
                if (ttype == HtmlStreamTokenizer.TT_TAG || ttype == HtmlStreamTokenizer.TT_COMMENT) {
                    tok.parseTag(tok.getStringValue(), tag);
                    if (tok.getRawString().toLowerCase().startsWith("<!--[if")) continue;
                    if (!findstar && tag.getTagString().toLowerCase().equals("div")){ //busca <div class=Section1>
                        Enumeration en = tag.getParamNames();
                        while(en.hasMoreElements()){
                            String name = (String) en.nextElement();
                            String value = tag.getParam(name);
                            if(name.equalsIgnoreCase("class") && value.equalsIgnoreCase("Section1")){
                                findstar=true;
                                ret.append(tok.getRawString());
                            }
                        }                        
                    }else if(!findstar){
                        ret.append(tok.getRawString());
                        continue;
                    }else if(findstar && contP<3){ //busca las primeras dos <p>
                        if(tag.getTagString().toLowerCase().equals("p")){
                            if (tag.isEndTag()) {
                                contP++;
                            }
                            continue;
                        }                        
                    }else if(contP>=3){
                    if (tag.getTagString().toLowerCase().equals("img")
                    || tag.getTagString().toLowerCase().equals("applet")
                    || tag.getTagString().toLowerCase().equals("script")
                    || tag.getTagString().toLowerCase().equals("link")
                    || tag.getTagString().toLowerCase().equals("td")
                    || tag.getTagString().toLowerCase().equals("table")
                    || tag.getTagString().toLowerCase().equals("body")
                    || tag.getTagString().toLowerCase().equals("input")
                    || tag.getTagString().toLowerCase().equals("a")
                    || tag.getTagString().toLowerCase().equals("form")
                    || tag.getTagString().toLowerCase().equals("area")
                    || tag.getTagString().toLowerCase().equals("meta")
                    ) {
                        if (!tag.isEndTag()) {
                            ret.append("<");
                            ret.append(tag.getTagString());
                            ret.append(" ");
                            Enumeration en = tag.getParamNames();
                            String name = "";
                            String value = "";
                           
                            String actionval = "";
                            boolean flag = false;
                            while (en.hasMoreElements()) {
                                flag = false;
                                boolean fJs = false;
                                name = (String) en.nextElement();
                                value = tag.getParam(name);
                                pos = value.indexOf("?");
                                paramfromUrl = "";
                                para = "";
                                if (pos != -1 && pos > 0) {
                                    paramfromUrl = value.substring(pos + 1);
                                    value = value.substring(0, pos);
                                }
                                if (value.startsWith("http://localhost") || value.startsWith("https://localhost")) {
                                    pos = -1;
                                    pos = value.indexOf("/", 7); 
                                    if (pos != -1)
                                        value = host + value.substring(pos + 1);
                                }
                                if (paramfromUrl != "") para = CodificaCadena(paramfromUrl);
                                if (surl != null) surlHex = CodificaCadena(surl);
                                if (host != null) hostHex = CodificaCadena(host);
                                if (value != null) valueHex = CodificaCadena(value);
                                if (surlfile != null) surlfileHex = CodificaCadena(surlfile);
                                ret.append(name);
                                ret.append("=\"");
                                boolean hexa = true;
                                String cadena = null;
                                int lenghthost = 0;
                                if (value != null && value.startsWith("http://") && host != null && value.length() >= host.length() ) {
                                    lenghthost = host.length();
                                    cadena = value.substring(0, lenghthost);
                                    if (!host.equals(cadena))
                                        hexa = false;
                                } else if (value != null && value.startsWith("http://") && host != null && value.length() < host.length())
                                    hexa = false;

                                //Para imprimir codificaci�n correcta
                                if (tag.getTagString().toLowerCase().equals("meta")) {
                                    int posCodifica = -1;
                                    posCodifica = tag.toString().indexOf("charset=");
                                    if (posCodifica != -1) {
                                        cadCod = tag.toString();
                                    }
                                }

                                //Para eliminar ../
                                value = takeOffString(value, "../", 2);

                                if ((name.toLowerCase().equals("src") || name.toLowerCase().equals("background") || name.toLowerCase().equals("codebase") || (tag.getTagString().toLowerCase().equals("link") && name.toLowerCase().equals("href"))) && !value.startsWith("http://") && !value.startsWith("https://") && !value.startsWith("/")) {
                                    ret.append(surl);
                                } else if ((name.toLowerCase().equals("src") || name.toLowerCase().equals("background") || name.toLowerCase().equals("codebase")) && value.startsWith("/")) {
                                    ret.append(host);
                                } else if (name.toLowerCase().equals("href") && !value.endsWith(".pdf") && !value.endsWith(".doc") && !value.endsWith(".zip")) {
                                    if ((name.toLowerCase().equals("href")) && !value.startsWith("http://") && !value.startsWith("https://") && !value.startsWith("/") && !value.startsWith("mailto:") && !value.startsWith("javascript:") && !value.startsWith("ftp:") && !value.startsWith("telnet:") && !value.startsWith("#") && !value.startsWith("?"))
                                        ret.append(envia + "?urlwb=" + surlHex);
                                    else if ((name.toLowerCase().equals("href")) && value.startsWith("/"))
                                        ret.append(envia + "?urlwb=" + hostHex);
                                    else if ((name.toLowerCase().equals("href")) && (value.startsWith("http://") || value.startsWith("https://")) && hexa)
                                        ret.append(envia + "?urlwb=");
                                    else if (name.toLowerCase().equals("href") && value.startsWith("?")) {
                                        ret.append(envia + "?urlwb=" + surlfileHex);
                                    }
                                } else if (name.toLowerCase().equals("href") && (value.endsWith(".pdf") || value.endsWith(".doc") || value.endsWith(".zip"))) {
                                    if ((name.toLowerCase().equals("href")) && !value.startsWith("http://") && !value.startsWith("https://") && !value.startsWith("/") && !value.toLowerCase().startsWith("javascript:"))
                                        ret.append(surl);
                                    else if ((name.toLowerCase().equals("href")) && value.startsWith("/")) ret.append(host);
                                    hexa = false;
                                } else if ((name.toLowerCase().equals("action")) && !value.startsWith("http://") && !value.startsWith("https://") && !value.startsWith("/") && !value.toLowerCase().startsWith("javascript:")) {
                                    if (value.equals("")) {
                                        ret.append(envia + "?urlwb=" + urlfin.replace('?', '&'));
                                        actionval = "<input type=hidden name=urlwb value=" + surlHex + valueHex + ">";
                                    } else
                                        ret.append(envia + "?urlwb=" + surlHex);
                                    actionval = "<input type=hidden name=urlwb value=" + surlHex + valueHex + ">";
                                } else if (name.toLowerCase().equals("action") && value.startsWith("/")) {
                                    ret.append(envia + "?urlwb=" + hostHex);
                                    actionval = "<input type=hidden name=urlwb value=" + hostHex + valueHex + ">";
                                } else if (name.toLowerCase().equals("action") && (value.startsWith("http://") || value.startsWith("https://"))) {
                                    ret.append(envia + "?urlwb=");
                                    actionval = "<input type=hidden name=urlwb value=>";
                                } else if (name.toLowerCase().equals("onmouseover") || name.toLowerCase().equals("onload") || name.toLowerCase().equals("onmouseout") || name.toLowerCase().equals("onclick")) {
                                    if (value.indexOf(".gif") > -1 || value.indexOf(".jpg") > -1) {
                                        if(value.startsWith("/"))
                                        {
                                            String out = findImagesInScript(value, ".gif'", host);
                                            out = findImagesInScript(out, ".jpg'", host);
                                            value = out;
                                        }else
                                        {
                                            String out = findImagesInScript(value, ".gif'", surl);
                                            out = findImagesInScript(out, ".jpg'", surl);
                                            value = out;
                                        }
                                    } else
                                        fJs = true;
                                }
                                if (((name.toLowerCase().equals("href") && !tag.getTagString().toLowerCase().equals("link")) || name.toLowerCase().equals("action")) && !value.startsWith("mailto:") && !value.startsWith("javascript:") && !value.startsWith("ftp:") && !value.startsWith("telnet:") && !value.startsWith("#") && hexa) {
                                    ret.append(valueHex);
                                    flag = true;
                                } else {
                                    ret.append(value);
                                }
                                if (!fJs && !paramfromUrl.equals("") && !para.toString().equals("")) {
                                    ret.append("&param=" + para);
                                }
                                if (flag) {
                                    ret.append("&wbresid=" + base.getId());
                                }
                                if (fJs && paramfromUrl != null && paramfromUrl != "")
                                    ret.append("?" + paramfromUrl);
                                ret.append("\" ");
                            }
                            ret.append(">");
                            if (tag.getTagString().toLowerCase().equals("form")) ret.append(actionval);
                        } else {
                            ret.append(tok.getRawString());
                        }
                    } else {
                        if (tok.getRawString().indexOf("location=") > -1) {
                            String v = takeOffString(tok.getRawString(), "../", 2);
                            ret.append(ParseWord(v, "location=", envia + "?urlwb=" + surl));
                        } else
                            ret.append(tok.getRawString());
                    }
                 }
                } else if (ttype == HtmlStreamTokenizer.TT_TEXT) {
                    if (tok.getRawString().indexOf("location=") > -1) {
                        ret.append(ParseWord(tok.getRawString(), "location=", envia + "?urlwb=" + CodificaCadena(surl)));
                    } else if(contP>=3){
                        ret.append(tok.getRawString());
                    }
                }
            }
            if (conex.getHeaderField("Set-Cookie") != null) {
                cookie = conex.getHeaderField("Set-Cookie");
                if (cookie != null)
                    request.getSession().setAttribute("Cookie:" + hostCookie, cookie.substring(0, cookie.indexOf(';')));
            }
        } catch (MalformedURLException e) {
            log.error("External page error: "+topic.getId(), e);
            ret.append(paramRequest.getLocaleLogString("externalpagenotavailable"));
            ret.append("<nocache/>");
        } catch (IOException g) {
            log.error("External page not available: "+topic.getId(), g);
            ret.append(paramRequest.getLocaleLogString("externalpagenotavailable"));
            ret.append("<nocache/>");
        } catch (NumberFormatException f) {
            log.error("Error while decoding external page", f);
            ret.append(paramRequest.getLocaleLogString("externalpagenotavailable"));
            ret.append("<nocache/>");
        } catch (Exception e) {
            log.error("Error while getting external page", e);
            ret.append(paramRequest.getLocaleLogString("externalpagenotavailable"));
            return null;
        }
        if (cadCod != null) {
            StringBuffer ret1 = new StringBuffer();
            pos = cadCod.indexOf("charset=");
            if (pos != -1) {
                try {
                    if(base.getAttribute("charset")==null){
                        String Codif = cadCod.substring(pos + 8, cadCod.indexOf("\"", pos + 8));
                        if (Codif == null || Codif.equals("")) Codif = "iso-8859-1";
                        ret1.append(SWBUtils.TEXT.decode(ret.toString(), Codif));
                    }else{
                        ret1.append(SWBUtils.TEXT.decode(ret.toString(), base.getAttribute("charset")));
                    }
                } catch (Exception e) {
                    log.error("Error while coding external page.. ", e);
                }
            }
            if (ret1 != null){  return ret1; }
        }else if(base.getAttribute("charset")!=null){
            StringBuffer ret1 = new StringBuffer();
            try {
                ret1.append(SWBUtils.TEXT.decode(ret.toString(), base.getAttribute("charset")));
            } catch (Exception e) {
                    log.error("Error while coding external page.. ", e);
            }
            if (ret1 != null){ return ret1; }
        }
        return ret;
    }


    /**
     * Parsea ciertas cadenas de strings
     * @param value
     * @param takeOff
     * @param itakeOff
     * @return
     */
    public String takeOffString(String value, String takeOff, int itakeOff) {
        int pos = value.indexOf(takeOff);
        if (pos != -1) {
            int i = 0;
            String valueCad = null;
            do {
                pos = -1;
                pos = value.indexOf(takeOff, i);
                if (pos != -1) {
                    valueCad = value.substring(0, i) + value.substring(i, pos) + value.substring(pos + itakeOff);
                    value = valueCad;
                }
                i = pos + itakeOff;
            } while (pos != -1);
        }
        return value;
    }

    String ParseWord(String value, String ext, String ruta) { // Parsea locations de javascript.
        StringBuffer aux = new StringBuffer(value.length());
        int off = 0;
        int f = 0;
        int i = 0;
        int h = -1;
        String cadena = null,cadcomplet = null;
        do {
            f = value.indexOf(ext, off);
            i = value.indexOf(";", f);
            if (f > 0 && i >= 0) {
                i++;
                int flag = 0;
                if ((value.charAt(f + 9) == '"' || value.charAt(f + 9) == '\'') && !value.substring(f + 10).startsWith("http")) {
                    String s = "'\");";
                    if (value.charAt(i - 2) == '\"') {
                        cadena = value.substring(f + 10, i - 2);
                        flag = 1;
                    } else if (value.substring(i - 4, i).equals(s)) {
                        cadena = value.substring(f + 10, i - 4);
                        flag = 2;
                    } else {
                        cadena = value.substring(f + 10, i - 1);
                    }
                    int pos = cadena.indexOf("?");
                    String paramfromUrl = null;
                    String para = null;
                    if (pos != -1) {
                        paramfromUrl = cadena.substring(pos + 1);
                        cadena = cadena.substring(0, pos);
                    }

                    if (paramfromUrl != null) para = paramfromUrl;
                    cadena = CodificaCadena(cadena);
                    if (para != null) cadena = cadena + "&param=" + para;
                    cadcomplet = value.substring(off, f + 10) + ruta + cadena;
                    if (flag == 1)
                        cadcomplet += "\"";
                    else if (flag == 2) cadcomplet += "\'\")";
                    cadcomplet += ";";
                } else if (value.charAt(f + 9) != '"' && !value.substring(f + 9).startsWith("http")) {
                    cadena = value.substring(f + 9, i);
                    cadcomplet = value.substring(off, f + 9) + ruta + cadena;
                } else //Para rutas que empiezen con http o https
                    cadcomplet = value.substring(off, i);

                aux.append(cadcomplet);
                off = i;
            }
        } while (f > 0);
        aux.append(value.substring(off));
        return aux.toString();
    }


    /**
     * Busca imagenes en javascripts, si las encuentra parsea sus rutas
     */
    private String findImagesInScript(String value, String ext, String ruta) {
        StringBuffer aux = new StringBuffer(value.length());
        int off = 0;
        int f = 0;
        int i = 0;
        int j = 0;
        do {
            f = value.indexOf(ext, off);
            i = value.lastIndexOf("'", f);
            j = value.lastIndexOf("/", f);
            if (f > 0 && i >= 0) {
                i++;
                if (value.startsWith("http://", i)) {
                    aux.append(value.substring(off, f + ext.length()));
                } else {
                    //aux.append(value.substring(off,i)+ruta+value.substring(j+1,f+ext.length()));
                    aux.append(value.substring(off, i) + ruta + value.substring(i, f + ext.length()));
                }
                /*
                else if(value.startsWith("/",i)){
                    aux.append(value.substring(off,i)+ruta+value.substring(i,f+ext.length()));
                }
                 */
                off = f + ext.length();
            }
        } while (f > 0 && i > 0);
        aux.append(value.substring(off));
        return aux.toString();
    }


    /**
     * Codifica un String.
     * @param cadena El String a codificar.
     * @return Regresa la representaci�n en String del argumento en hexadecimal (base 16).
     * @see java.lang.Integer#toHexString(int)
     */
    public String CodificaCadena(String cadena) {
        StringBuffer cadeCodHex = new StringBuffer();
        byte[] cadenaB = cadena.getBytes();
        for (int i = 0; i < cadenaB.length; i++) {
            Integer numbyte = new Integer(cadenaB[i]);
            cadeCodHex.append(Integer.toHexString(numbyte.intValue()).toUpperCase());
        }
        return cadeCodHex.toString();
    }

    /**
     * Decodifica un string
     * @param cadena
     * @param topic
     * @throws SWBResourceException
     * @return
     */
    public String DeCodificaCadena(String cadena, WebPage topic) throws SWBResourceException {
        StringBuffer cadeDecoHex = new StringBuffer();
        try {
            for (int i = 0; i < cadena.length(); i = i + 2) {
                int pedazo = Integer.parseInt(cadena.substring(i, i + 2), 16);
                cadeDecoHex.append((char) pedazo);
            }
        } catch (NumberFormatException h) {
            log.error("Error while coding external page:"+topic.getId(), h);
            return cadena;
        }
        return cadeDecoHex.toString();
    }

    String getUrlEncodeParams(String params) {
        //String post = "_url_gracias=" + URLEncoder.encode( "gracias.html" ) + "&que=" + URLEncoder.encode( "Comentario" );
        if (params != null && params.length() > 1) {
            if (params.charAt(0) == '?') params = params.substring(1);
            StringTokenizer st = new StringTokenizer(params, "&");
            while (st.hasMoreElements()) {
                String token = st.nextToken();
                if (token == null) {
                    continue;
                }
                StringTokenizer st1 = new StringTokenizer(token, "=");
                while (st1.hasMoreElements()) {
                    String token1 = st1.nextToken();
                    if (token1 == null) {
                        continue;
                    }
                }
            }
        }
        return params;
    }
}