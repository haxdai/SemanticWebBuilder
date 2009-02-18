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
 * WBConnection.java
 *
 * Created on 15 de febrero de 2006, 06:55 PM
 */

package applets.commons;

import java.applet.Applet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class WBConnection
{
    private Applet _applet=null;
    
    private static final String PRM_JSESS="jsess";
    private static final String PRM_CGIPATH="cgipath";    
    
    private String cgiPath="/gtw.jsp";
    private String jsess=null;                    //session del usuario
    private URL url=null;    
    
    /** Creates a new instance of WBConnection */
    public WBConnection(Applet applet)
    {
        setApplet(applet);
    }
    
    public void setApplet(Applet applet)
    {
        _applet=applet;
        configParams();
    }
    
    private void configParams()
    {
        jsess=_applet.getParameter(PRM_JSESS);
        cgiPath=_applet.getParameter(PRM_CGIPATH);
        try
        {
            url=new URL(_applet.getCodeBase().getProtocol(),_applet.getCodeBase().getHost(),_applet.getCodeBase().getPort(),cgiPath);
        }catch(Exception e){}
    }
    
    public Applet getApplet()
    {
        return _applet;
    }
    
    public WBTreeNode executeCommand(String cmd)
    {
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>"+cmd+"</cmd></req>";
        String data=getData(xml);
        if(data==null)return null;
        return new WBXMLParser().parse(data);
    }
    
    public String getData(String xml)
    {
        StringBuffer ret=new StringBuffer();
        try
        {
            //URL gurl=new URL(this.url,cgi);
            URLConnection urlconn=url.openConnection();
            urlconn.setUseCaches(false);
            if(jsess!=null)urlconn.setRequestProperty("Cookie", "JSESSIONID="+jsess);
            //System.out.println("JSESSIONID="+jsess);
            urlconn.setDoOutput(true);
            PrintWriter pout = new PrintWriter(urlconn.getOutputStream());
            pout.println(xml);
            pout.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                ret.append(inputLine);
                ret.append("\n");
                //System.out.println(inputLine);
            }
            in.close();
        }catch(Exception e){System.out.println("Error to open service..."+e);}
        return ret.toString();
    }       
    
}
