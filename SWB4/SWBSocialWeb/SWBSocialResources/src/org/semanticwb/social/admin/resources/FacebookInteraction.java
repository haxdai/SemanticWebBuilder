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
 
package org.semanticwb.social.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.Facebook;

/**
 *
 * @author francisco.jimenez
 */
public class FacebookInteraction extends GenericResource {
    
    public static Logger log = SWBUtils.getLogger(FacebookInteraction.class);
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        if (request.getParameter("doView") == null) {
            doEdit(request, response, paramRequest);
            return;
        }
        
        final String myPath = SWBPlatform.getContextPath() + "/work/models/" +
                paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookInteraction.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(myPath);
        if (dis != null) {
            try {
                request.setAttribute("paramRequest", paramRequest);
                request.setAttribute("suri", request.getParameter("suri"));
                dis.include(request, response);
            } catch (Exception ex) {
                FacebookInteraction.log.error(ex);
            }
        }
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String suri = request.getParameter("suri");
        String loading = "<BR/><center><img src='" + SWBPlatform.getContextPath() +
                         "/swbadmin/images/loading.gif'/></center>";
        out.println("<iframe width=\"100%\" height=\"100%\" src=\"" +
                paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).
                        setCallMethod(SWBResourceURL.Call_DIRECT).
                        setParameter("doView", "1").
                        setParameter("suri", suri) +
                "\"></iframe> ");
//        out.println("<div class=\"pub-redes\" style=\"width: 100%; height:100%;\" id=\"recentAct" +
//                suri + "\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
//                "Actividad Reciente" + "\" refreshOnShow=\"" + "false" +
//                "\" href=\"" + paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).
//                        setParameter("doView", "1").
//                        setParameter("suri", suri) + "\" _loadingMessage=\"" + loading +
//                "\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
//        out.println("</div>");
    }
    
    public void doChartData(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        response.setContentType("application/json; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        String suri = request.getParameter("suri");
        Facebook fb = (Facebook) SemanticObject.createSemanticObject(suri).createGenericInstance();
        int chartCurrentMonth[] = null;
        Calendar currentCalendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println("\n\n**currentCalendar:" + currentCalendar.getTime() + "\n**");
        Date currentDate = null;
        JSONArray historicData = new JSONArray();
        ArrayList<JSONObject> jsonValues = new ArrayList<JSONObject>();
        
        JSONArray monthlyData = getAllPostFromLastMonth(fb, historicData);        
        chartCurrentMonth = getChartValues(monthlyData, currentCalendar);
        currentDate = currentCalendar.getTime();//sdf.parse("" + currentCalendar.get(Calendar.YEAR) + "-" + (currentCalendar.get(Calendar.MONTH)+1) + "-" + currentCalendar.get(Calendar.DAY_OF_MONTH));
        //System.out.println("EL CALENDARIO ACTUAL: " + currentCalendar.getTime());
        //System.out.println("---->" + historicData);
        System.out.println("Entries recovered::::" + historicData.length());
        try {
            Calendar recentPost = Calendar.getInstance();
            Calendar olderPost = Calendar.getInstance();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));

            if (historicData.length() > 0) {
                if (!historicData.getJSONObject(0).isNull("created_time")) {
                    Date postTime = formatter.parse(historicData.getJSONObject(0).getString("created_time"));
                    recentPost.setTime(postTime);
                }
                if (!historicData.getJSONObject(historicData.length()-1).isNull("created_time")) {
                    Date postTime = formatter.parse(historicData.getJSONObject(historicData.length()-1).getString("created_time"));
                    olderPost.setTime(postTime);
                }
            }
            
            for (int i = 0; i < historicData.length(); i++) {
               jsonValues.add(historicData.getJSONObject(i));
            }
            Collections.sort(jsonValues, new OrderByLikesComparator());
            
            
            
        } catch (Exception e) {
            System.out.println("\n\n\n\n" + "EEEERRRRORRRR");
            e.printStackTrace();
        }
        
        PrintWriter out = response.getWriter();
        out.print("[{");
        out.print("  chartData: [");
        out.print("  {");
        //key is year_month(1-12)
        out.print("    key: '" + currentCalendar.get(Calendar.YEAR) + "_" +
                (currentCalendar.get(Calendar.MONTH)) + "',");
        out.print("    values: [");
        //SimpleDateFormat month = new SimpleDateFormat("MMMM", new Locale("es", "MX"));
        
        for (int i = 0; i < chartCurrentMonth.length; i++ ) {
            Calendar byDay = Calendar.getInstance();
            Date date = null;
            try {
                //Dia del mes actual
                date = sdf.parse(currentCalendar.get(Calendar.YEAR) + "-" +
                        (currentCalendar.get(Calendar.MONTH) + 1) + "-" + (i + 1));
                byDay.setTime(date);
            } catch (ParseException pe) {
                byDay.set(Calendar.YEAR, currentCalendar.get(Calendar.YEAR));
                byDay.set(Calendar.MONTH, currentCalendar.get(Calendar.MONTH) + 1);
                byDay.set(Calendar.DAY_OF_MONTH, i + 1);
            }
            //String dayStr = getDayOfWeek(byDay.get(Calendar.DAY_OF_WEEK));
            SimpleDateFormat output = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy", new Locale("es", "MX"));
            out.print("      {");
            out.print("        label: " + (i + 1) + ",");
            out.print("        value: " + chartCurrentMonth[i] + ",");
            out.print("        dayOfMonth: '" + output.format(date) + "'");
            out.print("      }");
            if (i < (chartCurrentMonth.length - 1)) {
                out.print(",");
            }
        }
        out.print("    ]");
        out.print("  }");
        out.print("],");
        
        
        out.print("likesTable : [");
        int count = 0;
        for (int i = 0; i < jsonValues.size(); i++) {
            try {
                int likes = 0;
                if (!jsonValues.get(i).isNull("likes") &&
                        !jsonValues.get(i).getJSONObject("likes").isNull("summary") && 
                        !jsonValues.get(i).getJSONObject("likes").getJSONObject("summary").isNull("total_count")) {
                    likes = jsonValues.get(i).getJSONObject("likes").getJSONObject("summary").getInt("total_count");
                }
                String msgText = "";
                if (!jsonValues.get(i).isNull("story")) {
                    msgText = jsonValues.get(i).getString("story");
                } else if (!jsonValues.get(i).isNull("message")) {
                    msgText = jsonValues.get(i).getString("message");
                }
                if (msgText.length() > 200) {
                    msgText = msgText.substring(0, 200) + "...";
                }
                String postId = getLinkFromId(jsonValues.get(i).getString("id"));
                if (likes > 0) {
                    count++;
                    out.print("  {");
                    out.print("    index : " + count + ",");
                    out.print("    msgTxt : \"" + msgText + "\",");
                    out.print("    link : \"" + postId + "\",");
                    out.print("    likes : " + likes);
                    out.print("  }");
                    if (count == 10) {
                        break;
                    } else {
                        out.print(",");
                    }
                }
            } catch (JSONException je) {
                
            }
        }
        out.print("],");
        Collections.sort(jsonValues, new OrderByCommentsComparator());
        out.print("commentsTable : [");
        count = 0;
        for (int i = 0; i < jsonValues.size(); i++) {
            try {
                int comments = 0;
                if (!jsonValues.get(i).isNull("comments") &&
                        !jsonValues.get(i).getJSONObject("comments").isNull("summary") && 
                        !jsonValues.get(i).getJSONObject("comments").getJSONObject("summary").isNull("total_count")) {
                    comments = jsonValues.get(i).getJSONObject("comments").getJSONObject("summary").getInt("total_count");
                }
                String msgText = "";
                if (!jsonValues.get(i).isNull("story")) {
                    msgText = jsonValues.get(i).getString("story");
                } else if (!jsonValues.get(i).isNull("message")) {
                    msgText = jsonValues.get(i).getString("message");
                }
                if (msgText.length() > 200) {
                    msgText = msgText.substring(0, 200) +"...";
                }
                String postId = jsonValues.get(i).getString("id");
                if (comments > 0) {
                    count++;
                    out.print("  {");
                    out.print("    index : " + count + ",");
                    out.print("    msgTxt : \"" + msgText + "\",");
                    out.print("    link : \"" + postId + "\",");
                    out.print("    comments : " + comments);
                    out.print("  }");
                    if (count == 10) {
                        break;
                    } else {
                        out.print(",");
                    }
                }
            } catch (JSONException je) {
                
            }
        }
        
        out.print("]");
        out.print("}]");
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String mode = paramRequest.getMode();
        
        if (mode.equals("chartData")) {
            doChartData(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    public JSONArray getAllPostFromLastMonth(Facebook facebook, JSONArray historicData) {
        
        HashMap<String, String> paramsFb = new HashMap<String, String>(4);
        paramsFb.put("access_token", facebook.getAccessToken());
        paramsFb.put("limit", "100");
        paramsFb.put("fields", "id,from,to,message,message_tags,story,story_tags,picture,caption,link,object_id,application,source,name,description,properties,icon,actions,privacy,type,status_type,created_time,likes.summary(true),comments.limit(5).summary(true),place");

        //Genera la primera peticion de posts
        //Solo se deben obtener estadisticas del ultimo mes        
        boolean endOfMonth = false;//get all posts of the last month with activity
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
        Calendar lastPostDate = null;
        JSONArray monthlyData = new JSONArray();
        
        try {
            do {
                JSONObject myPosts = null;
                String fbResponse = facebook.getRequest(paramsFb, Facebook.FACEBOOKGRAPH + "me/posts",
                                Facebook.USER_AGENT);
                try {
                    myPosts = new JSONObject(fbResponse);
                } catch (Exception e) {
                    endOfMonth = true;
                    myPosts = new JSONObject();
                    break;
                }
                //System.out.println(myPosts);
                if (!myPosts.isNull("data")) {
                    JSONArray postsData = myPosts.getJSONArray("data");
                    
                    //Store the month of the last post. Do this once!
                    if (postsData.length() > 0 && lastPostDate == null) {
                        if (!postsData.getJSONObject(0).isNull("created_time")) {
                            Date postTime = formatter.parse(postsData.getJSONObject(0).getString("created_time"));
                            Calendar calendar = GregorianCalendar.getInstance();
                            calendar.setTime(postTime);
                            lastPostDate = calendar;
                        }
                    }
                    
                    if (postsData.length() > 0 ) {
                        for (int i = 0; i < postsData.length(); i++) {
                            Date postTime = formatter.parse(postsData.getJSONObject(i).getString("created_time"));
                            Calendar monthPost = GregorianCalendar.getInstance();
                            monthPost.setTime(postTime);
                            //If the post was created the same year and month
                            if (monthPost.get(Calendar.YEAR) == lastPostDate.get(Calendar.YEAR) &&
                                    monthPost.get(Calendar.MONTH) == lastPostDate.get(Calendar.MONTH)) {
                                    monthlyData.put( postsData.getJSONObject(i));
                                    historicData.put( postsData.getJSONObject(i));
                            } else {//The wall is from newest to oldests
                               historicData.put( postsData.getJSONObject(i));
                               if (historicData.length() >= 200) {
                                   endOfMonth = true;
                                   break;
                               }
                            }
                        }
                    } else {
                        endOfMonth = true;
                    }
                    
                    //Get more posts because its the same month
                    if (!myPosts.isNull("paging") && endOfMonth == false) {
                        if (!myPosts.getJSONObject("paging").isNull("next")) {
                            String until = null;
                            try {
                                String paging = myPosts.getJSONObject("paging").getString("next");

                                if (paging.contains("?")) {
                                    paging = paging.split("\\?")[1];
                                    String paramsUrl[] = paging.split("&");
                                    for (int i = 0; i < paramsUrl.length; i++) {
                                        if (paramsUrl[i].contains("until")) {
                                            until = paramsUrl[i].substring(paramsUrl[i].lastIndexOf("=") + 1);
                                            break;
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                //System.out.println("NEXT PARAM" +e.getMessage());
                            }

                            if (until != null && isNumeric(until)) {
                                paramsFb.put("until",until);
                            } else {
                                endOfMonth = true;
                            }
                        }
                    }
                } else {
                    endOfMonth = true;
                }
            } while(endOfMonth == false);
        } catch (Exception e) {
            System.out.println("ERROR--->:" + e.getMessage());
            e.printStackTrace();
        }
        return monthlyData;
    }
    
    public boolean isNumeric(String number) {
        
        boolean numeric = false;
        try {
            Integer.parseInt(number);
            numeric = true;
        } catch (NumberFormatException nfe) {
            numeric = false;
        }
        return numeric;
    }
    
    public static int[] getChartValues(JSONArray data, Calendar currentCalendar) {
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
        int postsByDay[] = null;
        if (data.length() > 0 ) {
            Calendar monthPost = GregorianCalendar.getInstance();
            try {
                Date postTime = formatter.parse(data.getJSONObject(0).getString("created_time"));                
                monthPost.setTime(postTime);  
                currentCalendar.setTime(postTime); ;
                postsByDay = new int[monthPost.getActualMaximum(Calendar.DAY_OF_MONTH)];
            } catch (Exception e) {}
            
            try {
                for (int i = 0; i < data.length(); i++) {
                    JSONObject currentPost = data.getJSONObject(i);
                    if (!currentPost.isNull("created_time")) {
                        Date postTime = formatter.parse(currentPost.getString("created_time"));
                        Calendar calendar = GregorianCalendar.getInstance();
                        calendar.setTime(postTime);
                        postsByDay[calendar.get(Calendar.DAY_OF_MONTH)-1]++;
                    }
                }

            } catch (Exception e) {}
        }
        return postsByDay;
    }
    
    public String getLinkFromId(String id){
        String link = "#";
            if(id.contains("_")){
                String user = id.split("_")[0];
                String post = id.split("_")[1];
                link = "https://facebook.com/" + user + "/posts/" + post;
            }
        return link;
    }
    
    
    class OrderByLikesComparator implements Comparator<JSONObject> {

        @Override
        public int compare(JSONObject a, JSONObject b) {
            //throw new UnsupportedOperationException("Not supported yet.");
            int response = 0;
            try {
                int alikes = 0;
                int blikes = 0;
                if (!a.isNull("likes")) {
                    if (!a.getJSONObject("likes").isNull("summary")) {
                        if (!a.getJSONObject("likes").getJSONObject("summary").isNull("total_count")) {
                            alikes = a.getJSONObject("likes").getJSONObject("summary").getInt("total_count");
                        }
                    }
                }
                if (!b.isNull("likes")) {
                    if (!b.getJSONObject("likes").isNull("summary")) {
                        if (!b.getJSONObject("likes").getJSONObject("summary").isNull("total_count")) {
                            blikes = b.getJSONObject("likes").getJSONObject("summary").getInt("total_count");
                        }
                    }
                }
                //System.out.print("a:"+ alikes + "vs" + "b:" + blikes +"...");
                //Mos likes first
                if (alikes > blikes) {
                    response = -1;
                }
                if (alikes < blikes) {
                    response =  1;
                }
                //return 0; 
                //return a.compareTo(b);
            } catch (Exception e) {
                System.out.print("e");
            }
            return response;
        }                
    }
    
    class OrderByCommentsComparator implements Comparator<JSONObject> {

        @Override
        public int compare(JSONObject a, JSONObject b) {
            //throw new UnsupportedOperationException("Not supported yet.");
            int response = 0;
            try {
                int acomments = 0;
                int bcomments = 0;
                if (!a.isNull("comments")) {
                    if (!a.getJSONObject("comments").isNull("summary")) {
                        if (!a.getJSONObject("comments").getJSONObject("summary").isNull("total_count")) {
                            acomments = a.getJSONObject("comments").getJSONObject("summary").getInt("total_count");
                        }
                    }
                }
                if (!b.isNull("comments")) {
                    if (!b.getJSONObject("comments").isNull("summary")) {
                        if (!b.getJSONObject("comments").getJSONObject("summary").isNull("total_count")) {
                            bcomments = b.getJSONObject("comments").getJSONObject("summary").getInt("total_count");
                        }
                    }
                }
                //System.out.print("a:"+ alikes + "vs" + "b:" + blikes +"...");
                //Mos likes first
                if (acomments > bcomments) {
                    response = -1;
                }
                if (acomments < bcomments) {
                    response =  1;
                }
                //return 0; 
                //return a.compareTo(b);
            } catch (Exception e) {
                System.out.print("e");
            }
            return response;
        }
    }
    
    
}
