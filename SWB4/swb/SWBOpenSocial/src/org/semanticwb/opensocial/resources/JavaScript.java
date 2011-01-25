/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.opensocial.resources;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author victor.lorenzana
 */
public final class JavaScript
{

    private static final Logger log = SWBUtils.getLogger(JavaScript.class);
    private static Map<String, String> scripts = Collections.synchronizedMap(new HashMap<String, String>());

    public void doProcess(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        boolean debug=false;
        String script = request.getParameter("script");
        String _debug=request.getParameter("debug");
        if("1".equals(_debug))
        {
            debug=true;
        }
        if (script != null && script.endsWith(".js"))
        {
            if(!scripts.containsKey(script) || debug)
            {
                String path = SWBUtils.getApplicationPath() + "swbadmin/jsp/opensocial/" + script;
                File file = new File(path);
                if (file.exists())
                {
                    try
                    {
                        InputStreamReader reader = new FileReader(file);
                        StringBuilder sb = new StringBuilder();
                        char[] buffer = new char[1024 * 8];
                        int read = reader.read(buffer);
                        while (read != -1)
                        {
                            String data = new String(buffer, 0, read);
                            read = reader.read(buffer);
                            sb.append(data);
                        }
                        log.debug("file: "+file.getAbsolutePath()+" is loaded");
                        scripts.put(file.getName(), sb.toString());
                    }
                    catch(Exception e)
                    {
                        log.debug(e);
                    }
                } 
            }
            String js=scripts.get(script);
            if (js != null && !"".equals("js"))
            {

                SWBResourceURL makeRequest = paramRequest.getRenderUrl();
                makeRequest.setMode(SocialContainer.Mode_MAKE_REQUEST);
                makeRequest.setCallMethod(SWBResourceURL.Call_DIRECT);

                SWBResourceURL proxy = paramRequest.getRenderUrl();
                proxy.setMode(SocialContainer.Mode_PROXY);
                proxy.setCallMethod(SWBResourceURL.Call_DIRECT);

                SWBResourceURL rpc = paramRequest.getRenderUrl();
                rpc.setMode(SocialContainer.Mode_RPC);
                rpc.setCallMethod(SWBResourceURL.Call_DIRECT);


                SWBResourceURL ifr = paramRequest.getRenderUrl();
                ifr.setMode(SocialContainer.Mode_IFRAME);
                ifr.setCallMethod(SWBResourceURL.Call_DIRECT);                
                String relaypath = paramRequest.getResourceBase().getWorkPath()+"/rpc_relay.html";


                SWBResourceURL baseurl = paramRequest.getRenderUrl();
                baseurl.setMode(SWBResourceURL.Mode_VIEW);
                baseurl.setCallMethod(SWBResourceURL.Call_CONTENT);
                baseurl.setWindowState(SWBResourceURL.WinState_MAXIMIZED);

                SWBResourceURL javascript = paramRequest.getRenderUrl();
                javascript.setMode(SocialContainer.Mode_METADATA);
                javascript.setCallMethod(SWBResourceURL.Call_DIRECT);
                String port = "";
                if (request.getServerPort() != 80)
                {
                    port = ":" + request.getServerPort();
                }
                String host = request.getServerName();
                /*if("localhost".equals(host))
                {
                host="127.0.0.1";
                }*/
                String baserequest = request.getScheme() + "://" + host + port;

                js = js.replace("<%=baseurl%>", baserequest + baseurl.toString());
                js = js.replace("<%=metadata%>", baserequest + javascript.toString());
                js = js.replace("<%=ifr%>", baserequest + ifr.toString());
                js = js.replace("<%=rpc%>", baserequest + rpc.toString());
                js = js.replace("<%=proxy%>", baserequest + proxy.toString());
                js = js.replace("<%=makerequest%>", baserequest + makeRequest.toString());
                js = js.replace("<%=rpc_relay%>", baserequest + relaypath);                
                Charset charset = Charset.defaultCharset();
                response.setContentType("text/javascript;charset=" + charset.name());
                OutputStream out = response.getOutputStream();
                out.write(js.getBytes(charset));
                out.close();


            }

        }
        else
        {
            response.setStatus(404);
        }
    }
}
