/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.sep.becas.ws;

import gob.sep.becas.DatosFromCURPSEP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author serch
 */
public class ValidaCURPSEP
{

    String url = SWBPortal.getEnv("becas/url", "http://168.255.101.95:7074/wsrenaposep/wsConsultaCURPSEP");
    String host = "zrenapo:7071";

    public DatosFromCURPSEP checa(String CURP) throws Exception
    {
        DatosFromCURPSEP datos = null;
        String wsdata = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:typ=\"urn:wsConsultaCURPSEP/types\">"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                + "<typ:consultaxCURP>"
                + "<String_1>"
                + CURP.toUpperCase()
                + "</String_1>"
                + "</typ:consultaxCURP>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
        WSInvoker wsInvoker = new WSInvoker();
        wsInvoker.setHost(host); //System.out.println("HOST:"+host);
        wsInvoker.setUrl(url); //System.out.println("URL:"+url);
        wsInvoker.setSoapaction("");
        String result = wsInvoker.invoke(wsdata);
        if (!result.contains("<statusOper>NO EXITOSO</statusOper>")){
            datos = new DatosFromCURPSEP();
            Document doc = SWBUtils.XML.xmlToDom(result);
            Node nombres= doc.getElementsByTagName("nombres").item(0);
            if (null!=nombres) datos.setNombres(nombres.getTextContent());
            Node apellido1= doc.getElementsByTagName("apellido1").item(0);
            if (null!=apellido1) datos.setApellido1(apellido1.getTextContent());
            Node apellido2= doc.getElementsByTagName("apellido2").item(0);
            if (null!=apellido2) datos.setApellido2(apellido2.getTextContent());
            Node cveNac= doc.getElementsByTagName("cveEntidadNac").item(0);
            if (null!=cveNac) datos.setCveEdoNac(cveNac.getTextContent());
            Node fechaNac= doc.getElementsByTagName("fechNac").item(0);
            if (null!=fechaNac) datos.setFechaNac(fechaNac.getTextContent());
            Node sexo= doc.getElementsByTagName("sexo").item(0);
            if (null!=sexo) datos.setSexo(sexo.getTextContent());
        }
        return datos;
    }
}

class WSInvoker
{

    private URL url;
    private String content_type = "text/xml; charset=utf-8";
    private String soapaction = "\"\"";
    private String host = null;

    public WSInvoker()
    {
    }

    public String invoke(String xml) throws Exception
    {
        //AFUtils.debug("WSInvoker:url:" + getUrl());
        //AFUtils.debug("WSInvoker:invoke:" + xml);
        //System.out.println("iURL:"+url);
        String ret = null;
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", content_type);
        con.setRequestProperty("SOAPAction", soapaction);
        if (host != null)
        {
            con.setRequestProperty("Host", host);
        }
        con.setDoOutput(true);
        OutputStream out = con.getOutputStream();
        out.write(xml.getBytes());
        out.flush();
        out.close();
        int resc = con.getResponseCode();
        String resm = con.getResponseMessage();
//        System.out.println("ResponseMessage:" + resm);
        InputStream in = null;

        try
        {
            in = con.getInputStream();
        } catch (IOException e)
        {
            in = con.getErrorStream();
        }

        ret = SWBUtils.IO.readInputStream(in);
        //AFUtils.getInstance().readInputStream(in);

        if (resc != 200)
        {
            throw new Exception(resm + "\n" + ret);
        }
        return ret;
    }

    /** Getter for property url.
     * @return Value of property url.
     *
     */
    public URL getUrl()
    {
        return url;
    }

    /** Setter for property url.
     * @param url New value of property url.
     *
     */
    public void setUrl(java.lang.String url) throws MalformedURLException
    {
        this.url = new URL(url);
    }

    /** Setter for property url.
     * @param url New value of property url.
     *
     */
    public void setUrl(URL url)
    {
        this.url = url;
    }

    /** Getter for property soapaction.
     * @return Value of property soapaction.
     *
     */
    public java.lang.String getSoapaction()
    {
        return soapaction;
    }

    /** Setter for property soapaction.
     * @param soapaction New value of property soapaction.
     *
     */
    public void setSoapaction(java.lang.String soapaction)
    {
        if (soapaction != null)
        {
            this.soapaction = soapaction.trim();
            if (soapaction.startsWith("\""))
            {
                this.soapaction = soapaction;
            } else
            {
                this.soapaction = "\"" + soapaction + "\"";
            }
        }
    }

    /**
     * Getter for property host.
     * @return Value of property host.
     */
    public java.lang.String getHost()
    {
        return host;
    }

    /**
     * Setter for property host.
     * @param host New value of property host.
     */
    public void setHost(java.lang.String host)
    {
        this.host = host;
    }
}
