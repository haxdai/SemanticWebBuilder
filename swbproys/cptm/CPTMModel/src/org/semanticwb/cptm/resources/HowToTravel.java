/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author martha.jimenez
 */
public class HowToTravel extends GenericResource{
    private static Logger log = SWBUtils.getLogger(HowToTravel.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = SWBPortal.getWebWorkPath() +"/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/howToTravel.jsp" ;
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest",paramRequest);
            rd.include(request, response);
        }catch(Exception e) {
            log.error(e);
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = SWBPortal.getWebWorkPath() +"/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/adminHowToTravel.jsp" ;
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest",paramRequest);
            rd.include(request, response);
        }catch(Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        Resource base = response.getResourceBase();
        if(action.equals("save")) {
            int mapsiz= Integer.parseInt(request.getParameter("iden"));//request.getParameterMap().size();
            int i =0;
            HashMap how = new HashMap();
            while(i<=mapsiz)//(mapsiz/2)
            {
                String valIn = request.getParameter("input"+i);
                String valColum = request.getParameter("column"+ i);
                int valCol = -1;
                if(validateRegExp(valColum, "^[\\d]{1,3}$")) {
                    valCol = Integer.parseInt(valColum);
                }
                if(!valIn.equals("")&&valCol!=-1) {
                    if(!how.containsKey(valCol)) {
                        how.put(valCol, valIn);
                    }
                }
                i=i+1;
            }

            List keys = new ArrayList(how.keySet());
            Collections.sort(keys, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Integer k1 = (Integer) o1;
                    Integer k2 = (Integer) o2;
                    return -(new Integer(k2).compareTo(new Integer(k1)));
                }
            });

            Document doc = null;
            try {
                doc = SWBUtils.XML.getNewDocument();
                Element root = doc.createElement("HowToTravel");
                doc.appendChild(root);
                //Element title = doc.createElement("Title");
                //root.appendChild(title);
                //title.setTextContent(request.getParameter("title")==null?"":request.getParameter("title"));
                Iterator itk = keys.listIterator(0);
                while(itk.hasNext()) {
                    Object key = itk.next();
                    Object data = how.get(key);
                    Element ele = doc.createElement("Element");
                    root.appendChild(ele);
                    Element id = doc.createElement("Id");
                    ele.appendChild(id);
                    id.setTextContent(data.toString());
                    Element column = doc.createElement("Column");
                    ele.appendChild(column);
                    column.setTextContent(key.toString());
                }
                base.setData(SWBUtils.XML.domToXml(doc));
            } catch (Exception e) {
                throw new SWBResourceException("Error al generar el documento XML de HowToTravel", e);
            }

        }
    }

    private static boolean validateRegExp(String textSource, String regExp) {
        Pattern p = Pattern.compile(regExp);//regular expression
        Matcher m = p.matcher(textSource); // the text source
        return m.find();
    }
}