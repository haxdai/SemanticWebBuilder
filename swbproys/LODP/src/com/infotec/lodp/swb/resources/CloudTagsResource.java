/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.Tag;
import static com.infotec.lodp.swb.resources.CommentsViewResource.log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author Sabino
 */
public class CloudTagsResource extends GenericAdmResource{

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, 
        SWBParamRequest paramsRequest) throws SWBResourceException, IOException {        
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() 
                + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        request.setAttribute("paramRequest", paramsRequest);
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
        
    }
    /**
     * Obtiene los tags y su ponderación para el Cloud 
     *
     * @param listTags Iterador de Tags del Sitio
     * @param listDataset Iterador de DataSets del Sitio
     * @return Iterador de Tags con peso para el Cluod
     */
    public static Iterator<Tag> getCloudTags (Iterator<Tag> listTags, Iterator<Dataset> listDataset, int maxTags){
        List<Tag> cloudTags = getTagsSet(listTags);
        while(listDataset.hasNext()){
            Dataset ds = listDataset.next();
            Iterator dsTags = ds.listTags();
            long numView = ds.getViews();            
            while(dsTags.hasNext()){
                Tag dsTag = (Tag) dsTags.next();
                Iterator<Tag> itCloud = cloudTags.iterator();
                while(itCloud.hasNext()){ 
                    Tag cloudtag = itCloud.next();                    
                    if(cloudtag.getTagName().equals(dsTag.getTagName())){
                        String weight = cloudtag.getProperty("weight");
                        if(!(weight.contains("0"))){
                            long peso = Long.parseLong(weight) + numView;
                            cloudtag.setProperty("weight", String.valueOf(peso));
                        }else{
                            cloudtag.setProperty("weight", String.valueOf(numView));
                        }
                        break;
                    }
                }                
            }            
        }
        Set<Tag> cloudTagsTop = orderedTagsSet(cloudTags.iterator());
        Set<Tag> cloudTagsTopOrdered = getTagsSetOrdered(cloudTagsTop.iterator(),maxTags);
        return cloudTagsTopOrdered.iterator();
    }
    
    private static List<Tag> getTagsSet(Iterator<Tag> listTags){
        List<Tag> cloudTags = new ArrayList();
        while(listTags.hasNext()){
            Tag tag = listTags.next();
            tag.setProperty("weight", String.valueOf(0L));
            cloudTags.add(tag);            
        } 
        return cloudTags;
    }
    private static Set orderedTagsSet(Iterator<Tag> listTags){
        TreeSet cloudTags = new TreeSet(new Comparator() {
            public int compare(Object o1, Object o2) {
                long d1  = Long.parseLong(((Tag) o1).getProperty("weight"));
                long d2  = Long.parseLong(((Tag) o2).getProperty("weight"));
                int ret = d1 > d2 ? -1 : 1;
                return ret;
            }
        });
        while(listTags.hasNext()){
            Tag tag = listTags.next();            
            cloudTags.add(tag);            
        }
        return cloudTags;
    }
    
    private static Set getTagsSetOrdered(Iterator<Tag> listTags, int maxTags){
        List cloudTags  = new ArrayList();        
        int count = 0;
        int rango = maxTags / 5; //5 = Número de clases CSS
        while(listTags.hasNext() && count < maxTags){
            Tag tag = listTags.next();
            tag.setProperty("classCSS", "class0"+String.valueOf((count+rango)/rango));
            cloudTags.add(tag);
            count++;
        }
        TreeSet cloudTagsTop = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String d1  = ((Tag) o1).getTagName();
                String d2  = ((Tag) o2).getTagName();
                int ret = d1.compareTo(d2);
                return ret;
            }
        });
        Iterator itCloudTags = cloudTags.iterator();
        while(itCloudTags.hasNext()){
            cloudTagsTop.add(itCloudTags.next());            
        }
        return cloudTagsTop;
    }
}
