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
 * SWBAFTP.java
 *
 * Created on 11 de noviembre de 2004, 10:51 AM
 */

package org.semanticwb.portal.admin.resources;


import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;
import org.semanticwb.portal.api.*;
import org.w3c.dom.*;

import java.util.*;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.GenericResource;

/** Recurso que despliega los archivos que se encuentran en el servidor, permitiendo
 * agregar archivos o carpetas, renombrarlos, eliminarlos y descargarlos.
 *
 * Resource that unfolds the archives that are in the servant, allowing to add
 * archives or folders, to rename, to eliminate and to download.
 * @author Victor Lorenzana
 */
public class SWBAFTP extends GenericResource{
    private Logger log = SWBUtils.getLogger(SWBAFTP.class);
    /** Creates a new instance of SWBAFTP */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals("gateway"))
        {
            doGateway(request,response,paramRequest);
        }        
        else if(paramRequest.getMode().equals("upload"))
        {
            doUpload(request,response,paramRequest);
        }
        else if(paramRequest.getMode().equals("download"))
        {
            doDownload(request,response,paramRequest);
        }        
        else super.processRequest(request,response,paramRequest);
        
        
    }
    /**
     * @param request, parameters, input data
     * @param response, an answer to the user request
     * @param paramsRequest, a list of objects (Action, user, WebPage, ...)
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     */    
    public void doDownload(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path=request.getHeader("PATHFILEWB");        
        if(path!=null)
        {
            try
            {
                File f=new File(path);      
                if(f.exists())
                {
                    response.setContentLength((int)f.length());
                    FileInputStream fin=new FileInputStream(f);            
                    OutputStream out=response.getOutputStream();
                    byte[] bcont=new byte[8192];
                    int ret=fin.read(bcont);
                    while(ret!=-1)
                    {
                        out.write(bcont,0, ret);
                        ret=fin.read(bcont);
                    }
                    fin.close();
                    out.close();
                }
                else
                {
                    response.sendError(500);
                }
            }
            catch(Exception e)
            {
                response.sendError(500,e.getMessage());
            }
        }
        else
        {
            response.sendError(500);
        }
    }
    /**
     * @param request, parameters, input data
     * @param response, an answer to the user request
     * @param paramsRequest, a list of objects (Action, user, WebPage, ...)
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     */    
    public void doUpload(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path=request.getHeader("PATHFILEWB");        
        
        if(path!=null)
        {
            try
            {
                File f=new File(path);                                  
                FileOutputStream fout=new FileOutputStream(f);            
                InputStream in=request.getInputStream();
                byte[] bcont=new byte[8192];
                int ret=in.read(bcont);
                while(ret!=-1)
                {
                    fout.write(bcont,0, ret);
                    ret=in.read(bcont);
                }
                in.close();
                fout.close();                
            }
            catch(Exception e)
            {
                response.sendError(500,e.getMessage());
            }
        }
        else
        {
            response.sendError(500);
        }
    }
    /**
     * @param request, parameters, input data
     * @param response, an answer to the user request
     * @param paramsRequest, a list of objects (Action, user, WebPage, ...)
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     */    
    public void doGateway(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        ServletInputStream in = request.getInputStream();
        Document dom = SWBUtils.XML.xmlToDom(in);
        if (!dom.getFirstChild().getNodeName().equals("req"))
        {
            response.sendError(404, request.getRequestURI());
            return;
        }
        String cmd = null;
        if (dom.getElementsByTagName("cmd").getLength() > 0)
            cmd = dom.getElementsByTagName("cmd").item(0).getFirstChild().getNodeValue();

        if (cmd == null)
        {
            response.sendError(404, request.getRequestURI());
            return;
        }
        String ret="";
        try
        {
            Document res = getService(cmd, dom, paramRequest.getUser(), request, response);
            if (res == null)
            {
                ret = SWBUtils.XML.domToXml(getError(3));
            } else
                ret = SWBUtils.XML.domToXml(res, true);
        }catch(Exception e){log.error(e);}
        out.print(new String(ret.getBytes()));
        
    }
    private Document getService(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response)
    {
        return getDocument(user, src, cmd);        
    }
    private Element addNode(String node, String id, String name, Element parent)
    {
        Element ret=addElement(node,null,parent);
        if(id!=null)ret.setAttribute("id",id);
        if(name!=null)ret.setAttribute("name",name);
        return ret;
    }

    private Element addElement(String name, String value, Element parent)
    {
        Document doc = parent.getOwnerDocument();
        Element ele = doc.createElement(name);
        if (value != null) ele.appendChild(doc.createTextNode(value));
        parent.appendChild(ele);
        return ele;
    }  
    private Document getError(int id)
    {
        Document dom = null;
        try
        {
            dom = SWBUtils.XML.getNewDocument();
            Element res = dom.createElement("res");
            dom.appendChild(res);
            Element err = dom.createElement("err");
            res.appendChild(err);
            addElement("id", "" + id, err);
            if (id == 0)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_loginfail") + "...", err);
            } else if (id == 1)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_nouser") + "...", err);
            } else if (id == 2)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noservice") + "...", err);
            } else if (id == 3)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_serviceprocessfail") + "...", err);
            } else if (id == 4)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_parametersprocessfail") + "...", err);
            } else if (id == 5)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noTopicmap") + "...", err);
            } else if (id == 6)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noTopic") + "...", err);
            } else if (id == 7)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_usernopermiss") + "...", err);
            } else if (id == 8)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_TopicAlreadyexist") + "...", err);
            } else if (id == 9)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_byImplement") + "...", err);
            } else if (id == 10)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_TopicMapAlreadyExist") + "...", err);
            } else if (id == 11)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_FileNotFound") + "...", err);
            } else if (id == 12)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noversions") + "...", err);
            } else if (id == 13)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_xmlinconsistencyversion") + "...", err);
            } else if (id == 14)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_noResourcesinMemory") + "...", err);
            } else if (id == 15)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_noTemplatesinMemory") + "...", err);
            } else if (id == 16)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_TemplatenotRemovedfromFileSystem") + "...", err);
            } else if (id == 17)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_adminUsernotCreated") + "...", err);
            } else
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_errornotfound") + "...", err);
            }
        } catch (Exception e)
        {
            log.error(SWBUtils.TEXT.getLocaleString("locale_Gateway", "error_Gateway_getService_documentError") + "...", e);
        }
        
        return dom;
    }
    /**
     * @param fdir
     * @return
     */    
    public boolean hasSubdirectories(File fdir)
    {
        File[] dirs=fdir.listFiles();
        for(int i=0;i<dirs.length;i++)
        {
            File file=dirs[i];
            if(file.isDirectory())
            {
                return true;
            }
        }
        return false;
    }
    /**
     * @param edir
     * @param fdir
     */    
    public void getDirectories(Element edir,File fdir)
    {
        File[] dirs=fdir.listFiles();
        Arrays.sort(dirs, new FileComprator());
        for(int i=0;i<dirs.length;i++)
        {
            File file=dirs[i];
            if(file.isDirectory())
            {
                Element dir=addNode("dir", "", file.getName(), edir);                
                dir.setAttribute("path",file.getAbsolutePath());
                dir.setAttribute("hasChild",String.valueOf(hasSubdirectories(file)));                
            }
        }
    }
    /**
     * @param res
     * @param src
     */    
    public void getDirectories(Element res,Document src)
    {
        String path=SWBUtils.getApplicationPath();
        if(src.getElementsByTagName("path").getLength()>0)
        {
            Element epath=(Element)src.getElementsByTagName("path").item(0);
            Text etext=(Text)epath.getFirstChild();
            path=etext.getNodeValue();            
        }
        File apppath=new File(path);
        if(apppath.isDirectory())
        {
            Element dir=addNode("dir", "", apppath.getName(), res);
            dir.setAttribute("path",apppath.getAbsolutePath());
            dir.setAttribute("hasChild",String.valueOf(hasSubdirectories(apppath)));                
            getDirectories(dir,apppath); 
        }
    }
    /**
     * @param res
     * @param src
     */    
    public void createDir(Element res,Document src)
    {
        if(src.getElementsByTagName("path").getLength()>0)
        {
            Element epath=(Element)src.getElementsByTagName("path").item(0);
            Text etext=(Text)epath.getFirstChild();
            String path=etext.getNodeValue();                         
            File f=new File(path);                        
            if(f.mkdirs())
            {
                addElement("create", "true", res);
                return;
            }
        }
        addElement("create", "false", res);
    }
    /**
     * @param res
     * @param src
     */    
    public void rename(Element res,Document src)
    {
        if(src.getElementsByTagName("path").getLength()>0 && src.getElementsByTagName("newpath").getLength()>0)
        {
            Element epath=(Element)src.getElementsByTagName("path").item(0);
            Text etext=(Text)epath.getFirstChild();
            String path=etext.getNodeValue();             
            
            Element ename=(Element)src.getElementsByTagName("newpath").item(0);
            etext=(Text)ename.getFirstChild();
            String newname=etext.getNodeValue();
            File newfile=new File(newname);           
            File f=new File(path);            
            if(!isProtected(f))
            {
                if(f.renameTo(newfile))
                {
                    addElement("rename", "true", res);
                    return;
                }
            }
            else
            {
                addElement("err", java.util.ResourceBundle.getBundle("org/semanticwb/org/admin/resources/SWBAFTP").getString("msg"), res);
            }
        }
        addElement("rename", "false", res);
    }
    /**
     * @param res
     * @param src
     */    
    public void exists(Element res,Document src)
    {
        if(src.getElementsByTagName("path").getLength()>0)
        {
            Element epath=(Element)src.getElementsByTagName("path").item(0);
            Text etext=(Text)epath.getFirstChild();
            String path=etext.getNodeValue();            
            File f=new File(path);            
            if(f.exists())
            {
                addElement("exists", "true", res);
                return;
            }
            else
            {
                addElement("exists", "false", res);
                return;
            }
        }
        addElement("exists", "false", res);
    }
    /**
     * @param f
     * @return
     */    
    public boolean isProtected(File f)
    {
        boolean isProtected=false;
        try
        {         
            
            DataInputStream in=new DataInputStream(this.getClass().getResourceAsStream("/ftp.txt"));
            String linea=in.readLine();
            while(linea!=null)
            {
                String path=SWBUtils.getApplicationPath()+"/"+linea;
                File fp=new File(path);
                if(fp.equals(f))
                {
                    isProtected=true;
                }
                linea=in.readLine();
            }
            in.close();
        }
        catch(Exception e)
        {
           e.printStackTrace(System.out);
           log.error(e);
        }
        return isProtected;
    }
    
    /**
     * @param res
     * @param src
     */    
    public void delete(Element res,Document src)
    {
        if(src.getElementsByTagName("path").getLength()>0)
        {
            Element epath=(Element)src.getElementsByTagName("path").item(0);
            Text etext=(Text)epath.getFirstChild();
            String path=etext.getNodeValue();                                                
            File f=new File(path);                        
            if(!isProtected(f))
            {                
                if(f.delete())
                {
                    addElement("delete", "true", res);
                    return;
                }
            }
            else
            {
                addElement("err", java.util.ResourceBundle.getBundle("org/semanticwb/portal/admin/resources/SWBAFTP").getString("msg"), res);
            }
        }
        addElement("delete", "false", res);
    }
    /**
     * @param res
     * @param src
     */    
    public void getFiles(Element res,Document src)
    {
        String path=SWBUtils.getApplicationPath();
        if(src.getElementsByTagName("path").getLength()>0)
        {
            Element epath=(Element)src.getElementsByTagName("path").item(0);
            Text etext=(Text)epath.getFirstChild();
            path=etext.getNodeValue();            
        }
        java.text.SimpleDateFormat df=new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        File apppath=new File(path);
        if(apppath.isDirectory())
        {
            File[] files=apppath.listFiles();
            Vector vfiles=new Vector();
            for(int i=0;i<files.length;i++)
            {
                vfiles.add(files[i]);
            }
            Collections.sort(vfiles);
            Iterator itfiles=vfiles.iterator();
            while(itfiles.hasNext())
            {
                File file=(File)itfiles.next();
                if(file.isFile())
                {
                    Element efile=addNode("file", "", file.getName(), res);
                    efile.setAttribute("path",file.getAbsolutePath());
                    efile.setAttribute("size",String.valueOf(file.length()));
                    java.sql.Date date=new java.sql.Date(file.lastModified());
                    efile.setAttribute("lastupdate",df.format(date));
                }
            }
        }
    }
    /**
     * @param user
     * @param src
     * @param cmd
     * @return
     */    
    public Document getDocument(User user, Document src, String cmd)
    {
        Document dom = null;
        try
        {
                       
            dom = SWBUtils.XML.getNewDocument();
            Element res = dom.createElement("res");
            dom.appendChild(res);           
            
            if(cmd.equals("getDirectories"))
            {
                getDirectories(res,src);
            }
            else if(cmd.equals("getFiles"))
            {
                getFiles(res,src);
            }
            else if(cmd.equals("delete"))
            {
                delete(res,src);
            }
            else if(cmd.equals("createDir"))
            {
                createDir(res,src);
            }
            else if(cmd.equals("rename"))
            {
                rename(res,src);
            }
            else if(cmd.equals("exists"))
            {
                exists(res,src);
            }
            /*else if(cmd.equals("getcatUsers"))
            {
                getCatalogUsers(res,tm);
            }   
            else if(cmd.equals("getWorkflow"))
            {                
                getWorkflow(res,tm,src);
            }
            else if(cmd.equals("update"))
            {
                update(res,src,user,tm);
            }  */ 
        } catch (Exception e)
        {
            log.error(e);
            return getError(3);
        }
        return dom;
    }

    /**
     * @param request, parameters, input data
     * @param response, an answer to the user request
     * @param paramsRequest, a list of objects (Action, user, WebPage, ...)
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     */    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        User user=paramRequest.getUser();
        PrintWriter out=response.getWriter();        
        String act="view";
        if(request.getParameter("act")!=null)
        {
            act=request.getParameter("act");
        }
        if(act.equals("view"))
        {
            out.println("<div class=\"swbform\">");
            out.println("<fieldset>");
            out.println("<div class=\"applet\">");
            out.println("<APPLET id=\"ftp\" name=\"ftp\" code=\"applets.ftp.ftp.class\" codebase=\""+SWBPlatform.getContextPath()+"/\" ARCHIVE=\"swbadmin/lib/SWBAplFtp.jar, swbadmin/lib/SWBAplCommons.jar\" width=\"100%\" height=\"100%\">");
            SWBResourceURL url=paramRequest.getRenderUrl();
            url.setMode("gateway");
            url.setCallMethod(url.Call_DIRECT);            
            out.println("<PARAM NAME =\"locale\" VALUE=\""+user.getLanguage()+"\">");
            out.println("<PARAM NAME =\"cgipath\" VALUE=\""+url+"\">");
            url.setMode("upload");
            url.setCallMethod(url.Call_DIRECT);            
            out.println("<PARAM NAME =\"uploadpath\" VALUE=\""+url+"\">"); 
            url.setMode("download");
            url.setCallMethod(url.Call_DIRECT);  
            out.println("<PARAM NAME =\"downloadpath\" VALUE=\""+url+"\">");
            //out.println("<PARAM NAME =\"jsess\" VALUE=\""+request.getSession().getId()+"\">");            
            out.println("</APPLET>");
            out.println("</div>");
            out.println("</fieldset>");
            out.println("</div>");
        }
    }
    
}

class FileComprator implements Comparator
{

    public int compare(Object o1, Object o2)
    {
        if(o1 instanceof File && o2 instanceof File)
        {
            return ((File)o1).getName().compareToIgnoreCase(((File)o2).getName());
        }
        return 0;
    }

}
