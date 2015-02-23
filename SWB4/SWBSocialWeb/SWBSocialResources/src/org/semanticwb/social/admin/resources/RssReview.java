/**  
* SWB Social es una plataforma que descentraliza la publicación, seguimiento y monitoreo hacia las principales redes sociales. 
* SWB Social escucha y entiende opiniones acerca de una organización, sus productos, sus servicios e inclusive de su competencia, 
* detectando en la información sentimientos, influencia, geolocalización e idioma, entre mucha más información relevante que puede ser 
* útil para la toma de decisiones. 
* 
* SWB Social, es una herramienta basada en la plataforma SemanticWebBuilder. SWB Social, como SemanticWebBuilder, es una creación original 
* del Fondo de Información y Documentación para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SWB Social a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarla en las mismas condiciones con que INFOTEC la ha diseñado y puesto a su disposición; 
* aprender de élla; distribuirla a terceros; acceder a su código fuente y modificarla, y combinarla o enlazarla con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. y SWB Social 1.0
* 
* INFOTEC no otorga garantía sobre SWB Social, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder o SWB Social, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.social.Rss;
import org.semanticwb.social.RssSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.semanticwb.social.util.CommunityNews;

/**
 *
 * @author jorge.jimenez
 */
public class RssReview extends GenericResource{
   
    private Logger log = SWBUtils.getLogger(StreamInBox.class);
    
    /**
     * Gets the dom.
     * 
     * @param request the request
     * @param response the response
     * @param paramReq the param req
     * @return the dom
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SWBResourceException the sWB resource exception
     */
    public org.w3c.dom.Document getDom(RssSource rssSource) throws SWBResourceException, IOException
    {
        
        try
        {
            URL url = new URL(rssSource.getRss_URL().trim());
            URLConnection urlconn = url.openConnection();
            InputStream is = urlconn.getInputStream();
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            //String rssStr=SWBUtils.IO.readInputStream(is);
            //rssStr=rssStr.replaceAll("~", "");
            //System.out.println("rssStr:"+rssStr);
            //Document dom = SWBUtils.XML.xmlToDom(rssStr);
            return doc;
        }
        catch (Exception e) {
            log.error("Error while generating DOM in resource: "+rssSource, e);
        }
        return null;
    }
    
    /**
     * Do view.
     * 
     * @param request the request
     * @param response the response
     * @param paramReq the param req
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SWBResourceException the sWB resource exception
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramReq) throws SWBResourceException, java.io.IOException
    {
        String lang=paramReq.getUser().getLanguage();
        String suri=request.getParameter("suri");
        if(suri==null) return;
        
        SemanticObject semObj=SemanticObject.getSemanticObject(suri);
        
        Rss rss=null;
        try{
            rss=(Rss)semObj.getGenericInstance();
        }catch(Exception ignored)
        {
            return;
        }
        if(rss==null || !rss.listRssSourceses().hasNext() || rss.getTags()==null || rss.getTags().trim().length()==0) return;
        
        ArrayList<String> amsgWords=new ArrayList();
        String[] msgWords=rss.getTags().split(",");
        for(int i=0;i<msgWords.length;i++)
        {
            String msgWord=msgWords[i];
            if(msgWord!=null && msgWord.length()>0)
            {
                amsgWords.add(msgWord.toLowerCase());
            }
        }
        
        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        try
        {
            Iterator<RssSource> itRssSource=rss.listRssSourceses();
            while(itRssSource.hasNext())
            {
                RssSource rssSource=itRssSource.next();
                if(!rssSource.isActive()) continue;                
                Document dom = SWBUtils.XML.getNewDocument();
                dom=getDom(rssSource);
                if(dom != null) 
                {
                    ArrayList swbNews=new ArrayList();
                    NodeList nListItems=dom.getElementsByTagName("item");
                    for(int i=0;i<nListItems.getLength();i++){  //Theorically, nListItems.getLength() must be allways equal to 1
                        NodeList nListItemChilds=nListItems.item(i).getChildNodes();
                        boolean createCommunityNew=false;
                        for(int j=0;j<nListItemChilds.getLength();j++)
                        {
                            Node node=nListItemChilds.item(j);
                            if(node.getNodeName().equalsIgnoreCase("title") || node.getNodeName().equalsIgnoreCase("description"))
                            {
                                for(int k=0;k<amsgWords.size();k++)
                                {
                                    String word=amsgWords.get(k);
                                    System.out.println("Entra a RssListenerTask/run-5:"+word);
                                    if(node.getFirstChild()!=null && node.getFirstChild().getNodeValue().toLowerCase().indexOf(word)>-1)
                                    {
                                        createCommunityNew=true;
                                        break;
                                    }
                                }
                            }
                            if(createCommunityNew) break;
                        }
                        if(createCommunityNew)
                        {
                            System.out.println("Entra a RssListenerTask/run-6");
                            CommunityNews comNews=new CommunityNews();
                            comNews.setNode(nListItems.item(i));
                            swbNews.add(comNews);
                        }
                    }
                    out.println("<div class=\"rssContent\">");
                    out.println("<p class=\"rssResult\"><em>Resultados en:</em>"+rssSource.getDisplayTitle(lang)+"</p>");
                    out.println("<p class=\"rssResult\"><em>URL:</em>"+rssSource.getRss_URL()+"</p>");
                    out.println("<p class=\"rssWords\"><em>Con las palabras:</em><strong>"+rss.getTags()+"</strong></p>");
                    out.println("<ul>");    
                    Iterator <CommunityNews> itNews=swbNews.iterator();
                    if(!itNews.hasNext())
                    {
                        out.println("<br><br><br>NO SE ENCONTRARON RESULTADOS");
                    }
                    while(itNews.hasNext()){
                        CommunityNews comNew=itNews.next();
                        out.println("<li>");
                        String pubDate="";
                        if(comNew.getPubDate()!=null && comNew.getPubDate().trim().length()>0) pubDate=comNew.getPubDate();
                        if(comNew.getTitle()!=null) out.println("<span class=\"rssTitle\"><em>"+pubDate+"</em> "+SWBUtils.TEXT.encode(comNew.getTitle(), "iso8859-1")+"</span>");
                        if(comNew.getDescription()!=null) out.println("<span class=\"rssDescr\">"+SWBUtils.TEXT.encode(comNew.getDescription(), "iso8859-1")+"</span>");
                        if(comNew.getLink()!=null) out.println("<span class=\"rssLink\"><a target=\"_new\" href=\""+comNew.getLink()+"\">"+comNew.getLink()+"</a></span>");
                        //if(comNew.getGuid()!=null) out.println("<span class=\"rssGuid\"><a target=\"_new\" href=\""+comNew.getGuid()+"\">"+comNew.getGuid()+"</a></span>");
                        if(comNew.getMediaContent()!=null) out.println("<span class=\"mediaContent\"><img src=\""+comNew.getMediaContent()+"\"/></span>");
                        out.println("</li>");
                    }
                    out.println("</ul>");
                    out.println("</div>");
                }
            }
        }catch (Exception e) {
            log.error("Error while processing RSS for: "+rss, e);
        }
    }
   
}
