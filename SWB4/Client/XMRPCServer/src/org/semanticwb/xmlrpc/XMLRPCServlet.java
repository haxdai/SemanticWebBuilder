/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.xmlrpc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import static org.semanticwb.xmlrpc.XmlRpcSerializer.*;

/**
 *
 * @author victor.lorenzana
 */
public abstract class XMLRPCServlet extends HttpServlet
{
    private static Logger log = SWBUtils.getLogger(XMLRPCServlet.class);
    private static final String RETURN = "\r\n";
    private static Hashtable<String, Object> cacheObjects = new Hashtable<String, Object>();
    private static final String PREFIX_PROPERTY_PATH = "org.semanticwb.xmlrpc.";
    private static final String XMLRPC_DOCUMENT = "xmlrpc";        
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {            
            Document xmlrpcDocument;
            Set<Part> parts = new HashSet<Part>();
            if ( isMultipart(request) )
            {
                WBFileUpload upload = new WBFileUpload();
                upload.getFiles(request);
                for ( String name : upload.getFileNames() )
                {
                    if ( !name.equals(XMLRPC_DOCUMENT) )
                    {
                        byte[] content = upload.getFileData(name);
                        Part part = new Part(content, name, upload.getFileName(name));
                        parts.add(part);
                    }
                }
                xmlrpcDocument = getDocument(upload.getFileData(XMLRPC_DOCUMENT));
            }
            else
            {
                xmlrpcDocument = getDocument(request);
                writeDocumentToConsole(xmlrpcDocument);
            }

            try
            {             

                    String methodName = getMethodName(xmlrpcDocument);
                    ArrayList<Method> methods = getMethods(methodName);
                    Object[] parameters = deserializeRequest(xmlrpcDocument, methods);
                    Method method = getMethod(methodName,methods);
                    String objectName = method.getDeclaringClass().getName();
                    Object objResponse = execute(objectName, method, parameters, parts);
                    Document docResponse = serializeResponse(objResponse);
                    sendResponse(response, docResponse);
                
            }
            catch ( Exception cne )
            {
                try
                {
                    Document docResponse = XMLRPCServlet.getException(cne);
                    sendResponse(response, docResponse);
                }
                catch ( IOException ioeSendResponse )
                {
                    Document docResponse = XMLRPCServlet.getException(ioeSendResponse);
                    sendResponse(response, docResponse);
                }
            }
        }
        catch ( Exception jde )
        {
            try
            {
                Document docResponse = XMLRPCServlet.getException(jde);
                sendResponse(response, docResponse);
            }
            catch ( Exception ex )
            {
                // No se puede hacer nada, no puede seralizar la respuesta, debe guardar el error en el log
                // TODO:
                ex.printStackTrace(System.out);
            }
        }

    }
    private static void writeDocumentToConsole(Document document) 
    {
        try
        {
            XMLOutputter xMLOutputter = new XMLOutputter();
            xMLOutputter.output(document, System.out);
        }
        catch(Exception ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    protected void beforeExecute(Object objToExecute, Set<Part> parts) throws Exception
    {
        if ( objToExecute instanceof XmlRpcObject )
        {
            XmlRpcObject xmlRpcObject = ( XmlRpcObject ) objToExecute;
            xmlRpcObject.init(this.getServletConfig());
            xmlRpcObject.setParts(parts);
        }
    }

    protected void afterExecute(Object objToExecute)
    {
        if ( objToExecute instanceof XmlRpcObject )
        {
            XmlRpcObject xmlRpcObject = ( XmlRpcObject ) objToExecute;
            xmlRpcObject.clearParts();
        }
    }

    

    private static Method getMethod(String methodName, ArrayList<Method> methods) throws NoSuchMethodException
    {
        switch ( methods.size() )
        {
            case 1:
                return methods.get(0);
            default:
        }
        throw new NoSuchMethodException("The method " + methodName + " was not found");
    }

    

    private static void sendResponse(ServletResponse response, Document docResponse) throws IOException
    {
        response.setContentType("text/xml");
        ServletOutputStream out = response.getOutputStream();
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(docResponse, out);
        out.flush();
        out.close();
    }

    private static String getClassFullPath(String objectName) throws ClassNotFoundException
    {
        String classFullPath = System.getProperty(PREFIX_PROPERTY_PATH + objectName, null);
        if ( classFullPath == null )
        {
            throw new ClassNotFoundException("The class for the Object Name: " + objectName + " was not found");
        }
        return classFullPath;
    }

    private Object execute(String objectName, Method method, Object[] parameters, Set<Part> parts) throws ClassNotFoundException, XmlRpcException, InstantiationException, IllegalAccessException, NoSuchMethodException
    {
        Class clazz = method.getDeclaringClass();

        Object objToExecute = cacheObjects.get(objectName);
        if ( objToExecute == null )
        {
            cacheObjects.put(objectName, clazz.newInstance());
            objToExecute = cacheObjects.get(objectName);
        }
        synchronized ( objToExecute )
        {
            try
            {
                beforeExecute(objToExecute, parts);
            }
            catch ( Exception e )
            {
                throw new XmlRpcException("The object can not be inizialited into the method setupObject, cause: " + e.getLocalizedMessage(), e);
            }
            try
            {
                Object objectToReturn = method.invoke(objToExecute, parameters);
                afterExecute(objToExecute);
                return objectToReturn;
            }
            catch ( InvocationTargetException inte )
            {
                throw new XmlRpcException(inte.getTargetException().getLocalizedMessage(), inte.getTargetException());
            }
        }
    }

    private static String getMethodName(Document document) throws XmlRpcException, JDOMException, ClassNotFoundException
    {
        Element methodNameElement = ( Element ) XPath.selectSingleNode(document.getRootElement(), "/methodCall/methodName");
        if ( methodNameElement == null )
        {
            throw new XmlRpcException("The methodName tag was not found");
        }
        return methodNameElement.getText();
    }

    private static ArrayList<Method> getMethods(String pCallMethod) throws XmlRpcException, JDOMException, ClassNotFoundException
    {
        String[] values = pCallMethod.split("\\.");
        if ( values.length != 2 )
        {
            throw new XmlRpcException("The callMethos is incorrect");
        }
        String objectName = values[0];
        String methodName = values[1];
        String classFullPath = getClassFullPath(objectName);
        Class clazz = Class.forName(classFullPath);
        ArrayList<Method> methods = new ArrayList<Method>();
        for ( Method m : clazz.getMethods() )
        {
            if ( m.getName().equals(methodName) )
            {
                methods.add(m);
            }
        }
        return methods;
    }

    private static void addElement(Element element,String name,int value) throws JDOMException, IOException
    {
        Element emember=new Element("member");
        Element ename=new Element("name");
        ename.setText(name);
        Element evalue=new Element("value");
        Element eint=new Element("int");
        evalue.addContent(eint);
        eint.setText(String.valueOf(value));
        element.addContent(emember);
        emember.addContent(ename);
        emember.addContent(evalue);
    }
    private static void addElement(Element element,String name,String value) throws JDOMException, IOException
    {
        Element emember=new Element("member");
        Element ename=new Element("name");
        ename.setText(name);
        Element evalue=new Element("value");
        Element eint=new Element("string");
        eint.setText(value);
        evalue.addContent(eint);
        element.addContent(emember);
        emember.addContent(ename);
        emember.addContent(evalue);
    }
    private static Document getException(Exception e) throws JDOMException, IOException
    {
        StringBuilder messageError = new StringBuilder(e.getLocalizedMessage() + RETURN);
        for ( StackTraceElement element : e.getStackTrace() )
        {
            messageError.append(element.toString() + RETURN);
        }
        if ( e.getCause() != null )
        {
            messageError.append(" cause: \r\n");
            messageError.append(e.getCause().getLocalizedMessage() + RETURN);
            for ( StackTraceElement element : e.getCause().getStackTrace() )
            {
                messageError.append(element.toString() + RETURN);
            }
        }

        Document doc=new Document();
        Element methodResponse=new Element("methodResponse");
        doc.addContent(methodResponse);
        Element fault=new Element("fault");
        methodResponse.addContent(fault);
        Element value=new Element("value");
        Element struct=new Element("struct");
        fault.addContent(value);
        value.addContent(struct);
        addElement(struct, "faultCode", e.hashCode());
        addElement(struct, "faultString", messageError.toString());
        return doc;

    }

    private static Document getDocument(byte[] document) throws JDOMException, IOException
    {
        ByteArrayInputStream in = new ByteArrayInputStream(document);
        SAXBuilder builder = new SAXBuilder();
        return builder.build(in);
    }

    private static Document getDocument(HttpServletRequest request) throws IOException, JDOMException
    {
        ServletInputStream in = request.getInputStream();
        SAXBuilder builder = new SAXBuilder();
        Document docToReturn=builder.build(in);
        in.close();
        return docToReturn;
    }

    private static boolean isMultipart(HttpServletRequest request)
    {
        boolean isMultipart = false;
        if ( request.getContentType().indexOf("multipart/form-data") != -1 )
        {
            isMultipart = true;
        }
        return isMultipart;
    }

    public static void addMappingType(String objectName, Class clazz)
    {
        System.setProperty(PREFIX_PROPERTY_PATH + objectName, clazz.getName());
    }

    public static void addMappingType(Map<String, Class> mapType)
    {
        for ( String objectName : mapType.keySet() )
        {
            Class clazz = mapType.get(objectName);
            addMappingType(objectName, clazz);
        }
    }
}
