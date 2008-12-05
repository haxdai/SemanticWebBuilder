/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.xmlrpc;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import static org.semanticwb.xmlrpc.Base64.encode;
import static java.net.HttpURLConnection.*;
import static org.semanticwb.xmlrpc.XmlRpcSerializer.*;
/**
 *
 * @author victor.lorenzana
 */
class XmlRpcClient
{

    private Map<String, List<String>> responseProperties = new HashMap<String, List<String>>();
    private static String boundary = "gc0p4Jq0M2Yt08jU534c0p";    
    private XmlRpcClientConfig config;

    public XmlRpcClient(XmlRpcClientConfig config)
    {
        this.config = config;
    }

    public void setConfig(XmlRpcClientConfig config)
    {
        this.config = config;
    }

    public XmlRpcClientConfig getClientConfig()
    {
        return config;
    }

    public Map<String, List<String>> getResponseProperties()
    {
        return responseProperties;
    }

    public <T> T execute(Class<T> clazz, String methodName, Object[] parameters, Set<Attachment> attachments) throws XmlRpcException, HttpException
    {
        for ( Attachment attachment : attachments )
        {
            if ( attachment.getFile().isDirectory() )
            {
                throw new XmlRpcException("The attachment '" + attachment.getName() + "' is a directory");
            }
            if ( !attachment.getFile().exists() )
            {
                throw new XmlRpcException("The attachment '" + attachment.getName() + "' does not exist");
            }
        }
        Document requestDoc = serializeRequest(methodName, parameters);           
        Document responseDoc = request(requestDoc, attachments);
        /*try
        {
            XMLOutputter out=new XMLOutputter();
            out.output(responseDoc, System.out);
        }
        catch(Exception e){}*/
        try
        {
            
            return (T)deserializeResponse(clazz, responseDoc);
        }
        catch ( ParseException pe )
        {
            throw new XmlRpcException(pe.getMessage(), pe);
        }
    }

    private static Document getDocument(InputStream in) throws XmlRpcException
    {
        SAXBuilder builder = new SAXBuilder();
        try
        {
            return builder.build(in);
        }
        catch ( Exception jde )
        {
            throw new XmlRpcException("It was not possible to contruct the document from the InputStream");
        }
    }

    private static OutputStream sendHeaders(HttpURLConnection connection) throws IOException
    {
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        OutputStream out = connection.getOutputStream();
        return out;
    }

    private static void sendFile(File file, String name, OutputStream out) throws IOException
    {
        String newBoundary = "\r\n--" + boundary + "\r\n";
        String contentDisposition = "Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + file.getName() + "\"\r\n\r\n";
        out.write(newBoundary.getBytes());
        out.write(contentDisposition.getBytes());
        FileInputStream in = new FileInputStream(file);
        byte[] buffer = new byte[2048];
        int read = in.read(buffer);
        while (read != -1)
        {
            out.write(buffer, 0, read);
            read = in.read(buffer);
        }
        in.close();
    }

    private static void writeEnd(OutputStream out) throws IOException
    {
        String newBoundary = "\r\n--" + boundary + "\r\n";
        out.write(newBoundary.getBytes());
    }

    private static void sendXmlDocumentPart(Document requestDoc, OutputStream out) throws IOException
    {
        String newBoundary = "--" + boundary + "\r\n";
        String contentDisposition = "Content-Disposition: form-data; name=\"xmlrpc\"; filename=\"xmlrpc.xml\"\r\n\r\n";
        out.write(newBoundary.getBytes());
        out.write(contentDisposition.getBytes());
        XMLOutputter outp = new XMLOutputter();
        outp.output(requestDoc, out);
    }

    private String getUserPassWordEncoded()
    {
        String userPassword = config.getUserName() + ":" + config.getPassword();
        String encoded = new String(encode(userPassword.getBytes()));
        return encoded;
    }

    private Document request(Document requestDoc, Set<Attachment> attachments) throws XmlRpcException, HttpException
    {
        OutputStream out = null;
        try
        {
            Proxy proxy;
            if ( config.usesProxyServer() )
            {
                proxy = new Proxy(Type.HTTP, new InetSocketAddress(config.getProxyServer().toString(), config.getProxyPort()));
            }
            else
            {
                proxy = Proxy.NO_PROXY;
            }
            HttpURLConnection connection = ( HttpURLConnection ) config.getWebAddress().toURL().openConnection(proxy);
            HttpURLConnection.setFollowRedirects(true);
            if ( config.hasUserPassWord() )
            {
                connection.setRequestProperty("Authorization", "Basic " + getUserPassWordEncoded());
            }
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            out = sendHeaders(connection);
            sendXmlDocumentPart(requestDoc, out);
            for ( Attachment attachment : attachments )
            {
                File file = attachment.getFile();
                String name = attachment.getName();
                sendFile(file, name, out);
            }
            writeEnd(out);
            out.close();
            int responseCode = connection.getResponseCode();
            String contentType = connection.getHeaderField("Content-Type");
            InputStream error = connection.getErrorStream();
            switch ( responseCode )
            {
                case HTTP_OK:
                    this.responseProperties = connection.getHeaderFields();
                    return getResponse(connection.getInputStream(), contentType);
                case HTTP_NOT_FOUND:
                    throw new HttpException("The path " + connection.getURL() + " was not found", HTTP_NOT_FOUND, getDetail(error, contentType));
                default:
                    throw new HttpException(connection.getResponseMessage(), HTTP_NOT_FOUND, getDetail(error, contentType));
            }
        }
        catch ( MalformedURLException mfe )
        {
            throw new XmlRpcException(mfe);
        }
        catch ( IOException ioe )
        {
            throw new XmlRpcException(ioe);
        }
        finally
        {
            if ( out != null )
            {
                try
                {
                    out.close();
                }
                catch ( IOException ioe )
                {                
                    throw new XmlRpcException(ioe);
                }
            }
        }
    }

    private static String getDetail(InputStream in, String contentType) throws XmlRpcException
    {
        StringBuilder sb = new StringBuilder();

        String charSet = "utf-8";
        if ( contentType != null )
        {
            int posInit = contentType.indexOf("charset=");
            if ( posInit != -1 )
            {
                charSet = contentType.substring(posInit + 8);
            }
        }
        try
        {

            byte[] buffer = new byte[2048];
            int read = in.read(buffer);
            while (read != -1)
            {
                sb.append(new String(buffer, 0, read, charSet));
                read = in.read(buffer);
            }
        }
        catch ( IOException ioe )
        {
            throw new XmlRpcException("Error gettting the detail of response", ioe);
        }
        finally
        {
            if ( in != null )
            {
                try
                {
                    in.close();
                }
                catch ( IOException ioe )
                {
                    throw new XmlRpcException("Error closing conexi�n in the detail of response", ioe);
                }
            }
        }
        return sb.toString();
    }

    private static Document getResponse(InputStream in, String contentType) throws XmlRpcException
    {
        if ( contentType == null )
        {
            throw new XmlRpcException("The content-Type is not valid");
        }
        if ( !contentType.startsWith("text/xml") )
        {
            throw new XmlRpcException("The content-Type is not text/xml");
        }
        Document doc = getDocument(in);
        try
        {
            in.close();
        }
        catch ( IOException ioe )
        {
            throw new XmlRpcException("Error getting the response document", ioe);
        }
        return doc;
    }
    
    
}
