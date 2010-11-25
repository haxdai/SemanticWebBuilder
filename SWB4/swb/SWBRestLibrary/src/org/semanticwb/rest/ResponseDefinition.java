/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.rest;

import java.util.ArrayList;
import javax.xml.XMLConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author victor.lorenzana
 */
public final class ResponseDefinition
{

    private final int status;
    private final String mediaType;
    private Element responseDefinition;
    private ResponseDefinition(int status,String mediaType,Element responseDefinition)
    {
        this.status = status;
        this.mediaType=mediaType;
        this.responseDefinition=responseDefinition;
    }

    public int getStatus()
    {
        return status;
    }
    private static Element getElementDefinition(Document doc,String localname,String namespace)
    {
        NodeList schemas=doc.getElementsByTagNameNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "schema");
        for(int i=0;i<schemas.getLength();i++)
        {
            Element schema=(Element)schemas.item(i);
            String targetNamespace=schema.getAttribute("targetNamespace");
            if(namespace.equals(targetNamespace))
            {
                // this is the schema
                NodeList childs=schema.getChildNodes();
                for(int j=0;j<childs.getLength();j++)
                {
                    Node child=childs.item(j);
                    if(child instanceof Element && XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(child.getNamespaceURI()))
                    {
                        Element eDefinition=(Element)child;
                        if(eDefinition.getLocalName().equals("element"))
                        {                            
                            String name=eDefinition.getAttribute("name");
                            if(localname.equals(name))
                            {
                                return eDefinition;
                            }

                        }

                    }
                }
            }
        }
        return null;
    }
    public static ResponseDefinition[] createResponseDefinition(Element response, Method method) throws RestException
    {
        ArrayList<ResponseDefinition> definitions=new ArrayList<ResponseDefinition>();
        int istatus = 200;
        String status = response.getAttribute("status");
        if (status != null && !status.trim().equals(""))
        {
            istatus = Integer.parseInt(status);
        }
        NodeList childs = response.getChildNodes();
        for (int i = 0; i < childs.getLength(); i++)
        {
            if (childs.item(i) instanceof Element && ((Element) childs.item(i)).getNamespaceURI() != null && ((Element) childs.item(i)).getNamespaceURI().equals(response.getNamespaceURI()))
            {
                if (((Element) childs.item(i)).getTagName().equals("representation"))
                {
                    Element representation = (Element) childs.item(i);
                    if(representation.getAttribute("mediaType")==null || representation.getAttribute("mediaType").trim().equals(""))
                    {
                        throw new RestException("The attribute mediaType was not found");
                    }
                    String mediaType=representation.getAttribute("mediaType");
                    Element responseDefinition=null;
                    if(representation.getAttribute("element")!=null && !representation.getAttribute("element").trim().equals(""))
                    {
                        String element=representation.getAttribute("element");
                        String namespace=method.getResource().getServiceInfo().getNamespaceURI();
                        int pos=element.indexOf(":");
                        if(pos!=-1)
                        {
                            String prefix=element.substring(0,pos);
                            element=element.substring(pos+1);
                            namespace=response.getOwnerDocument().getDocumentElement().getAttribute("xmlns:"+prefix);
                        }
                        // busca el elemento  en los schemas
                        responseDefinition=getElementDefinition(response.getOwnerDocument(),element,namespace);
                    }
                    ResponseDefinition definition=new ResponseDefinition(istatus,mediaType,responseDefinition);
                    
                }
            }
        }
        return definitions.toArray(new ResponseDefinition[definitions.size()]);
    }
}
