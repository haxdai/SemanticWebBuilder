<%-- 
    Document   : mobile
    Created on : 30/09/2014, 03:24:42 PM
    Author     : jorge.jimenez
--%>
<%@page import="org.semanticwb.social.admin.resources.util.SWBSocialResUtil"%>
<%@page import="org.semanticwb.social.PostIn"%>
<%@page import="org.semanticwb.social.SWBSocial"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.social.Stream"%>
<%@page import="org.semanticwb.social.SocialSite,java.util.*,org.semanticwb.social.SocialTopic,org.semanticwb.model.WebSite,org.semanticwb.model.User,org.semanticwb.platform.SemanticObject,org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.model.AdminFilter"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%> 
<%@page import="org.json.*"%>

<%
    //Servicio de autenticación
    //System.out.println("getLocalAddr():"+request.getLocalAddr()+",LocalName:"+request.getLocalName()+",port:"+request.getLocalPort());
    System.out.println("UserName:"+request.getParameter("username"));
    System.out.println("password:"+request.getParameter("password"));
    String userId=request.getParameter("username");
    String passw=request.getParameter("password");

    User user=SWBContext.getAdminRepository().getUserByLogin(userId);  
    System.out.println("user en Jsp:"+user);
    if(user!=null && request.getParameter("action")!=null)
    {
        String protocol="http";
        if(request.getProtocol()!=null)
        {
            int post=request.getProtocol().indexOf("/");
            if(post>-1)
            {
                protocol=request.getProtocol().substring(0,post);
            }
        }
        protocol+="://";
        //String basePath=protocol.toLowerCase()+request.getLocalAddr()+":"+request.getLocalPort();
        String basePath="http://swbsocial.infotec.com.mx";
        
        
        if(request.getParameter("action").equals("login"))
        {
            out.println(isSWBSocialUser(user));        
        }else if(request.getParameter("action").equals("userBrands"))
        {
            out.println(getUserBrands(user, basePath));
        }else if(request.getParameter("action").equals("brandStreams"))
        {
            System.out.println("Va a traer los streams de la marca:"+request.getParameter("brandID"));
            out.println(getBrandStreams(request.getParameter("brandID"), user, basePath));
        }else if(request.getParameter("action").equals("streamInfo"))
        {
            System.out.println("Va a traer los datos del stream:"+request.getParameter("streamID"));
            String streamID=request.getParameter("streamID");
            
            int pos=streamID.indexOf("-SWB-");
            if(pos>-1)
            {
                String brandId=streamID.substring(0, pos);
                System.out.println("brandId:"+brandId);
                SocialSite socialSite=SocialSite.ClassMgr.getSocialSite(brandId);
                if(socialSite!=null)
                {
                    String streamId=streamID.substring(pos+5);
                    System.out.println("streamId:"+streamId);
                    Stream stream=socialSite.getStream(streamId);
                    if(stream!=null)
                    {
                         out.println(getStreamInfo(stream, user, basePath));
                    }
                }
            }
        }
    }
%>

<%!
    /*
    *   Metodo de authenticación
    * */  
    JSONObject isSWBSocialUser(User user) throws Exception 
    {
        //JSONArray node = new JSONArray();
        JSONObject nodeResponse = new JSONObject();
        nodeResponse.put("isSocialUser", "true");
        //node.put(node1);
        System.out.println("node:"+nodeResponse);
        return nodeResponse;
    }
    
    
    /*
    *   Metodo de authenticación
    * */  
    JSONArray getUserBrands(User user, String basePath) throws Exception 
    {
        String defaultStreamImage=basePath+"/swbadmin/css/images/";
        //SocialSite.ClassMgr.lisSocialS
        ArrayList<SocialSite> aListSites=new ArrayList(); 
        
        
        JSONArray jsonArray = new JSONArray();
        
        UserGroup userSuperAdminGrp = SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
        if(user.hasUserGroup(userSuperAdminGrp)){//is super user-> can see everything
            Iterator<SocialSite> itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage());
            while(itSocialSites.hasNext())
            {
                SocialSite socialSite=itSocialSites.next();
                if(!socialSite.isDeleted())
                {
                    aListSites.add(socialSite);
                }
            }
        }else{
            Iterator<SocialSite> itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage());  
            while(itSocialSites.hasNext())
            {
                SocialSite socialSite=itSocialSites.next();
                if(!socialSite.isDeleted())
                {
                    Iterator<AdminFilter> userAdmFilters=user.listAdminFilters();
                    while(userAdmFilters.hasNext())
                    {
                        AdminFilter userAdmFilter=userAdmFilters.next();
                        if(userAdmFilter.haveTreeAccessToSemanticObject(socialSite.getSemanticObject()))
                        {
                            aListSites.add(socialSite);
                        }
                    }
                }
            }
            
            if(aListSites.isEmpty() && (!user.listAdminFilters().hasNext())){//User has not admin filters and the data is Empty
                itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage());
                while(itSocialSites.hasNext())
                {
                    SocialSite socialSite=itSocialSites.next();
                     if(!socialSite.isDeleted() && user.haveAccess(socialSite))
                    {
                        aListSites.add(socialSite);
                    }
                }
            }
        }
        Iterator<SocialSite> itSocialSites2=SWBComparator.sortByDisplayName(aListSites.iterator(), user.getLanguage());
        while(itSocialSites2.hasNext())
        {
            SocialSite socialSite=itSocialSites2.next();  
            JSONObject node = new JSONObject();
            node.put("brandID", socialSite.getId());
            node.put("brandName", socialSite.getDisplayTitle(user.getLanguage()));
            if(socialSite.isActive())
            {
                node.put("brandImg", defaultStreamImage+"social-siteOn.png");
            }else{
                node.put("brandImg", defaultStreamImage+"social-siteOff.png");
            }            
            jsonArray.put(node);
        }
        //System.out.println("jsonArray-Brands:"+jsonArray);
        return jsonArray;
    }
    
    JSONArray getBrandStreams(String brandID, User user, String basePath) throws Exception 
    {
        String defaultStreamImage=basePath+"/swbadmin/css/images/";
        JSONArray jsonArray = new JSONArray();
        SocialSite socialSite=SocialSite.ClassMgr.getSocialSite(brandID);
        Iterator<Stream> itStreams=SWBComparator.sortByDisplayName(socialSite.listStreams(), user.getLanguage());
        while(itStreams.hasNext())
        {
            Stream stream=itStreams.next();
            if(!stream.isDeleted())
            {
                JSONObject node = new JSONObject();
                node.put("streamID", socialSite.getId()+"-SWB-"+stream.getId());
                node.put("streamName", stream.getDisplayTitle(user.getLanguage())); 
                System.out.println("Stream Name:"+stream.getDisplayTitle(user.getLanguage())+",logo:"+basePath+SWBPortal.getWebWorkPath()+stream.getWorkPath()+"/"+stream.getStream_logo()); 
                if(stream.isActive())
                {
                    node.put("streamImg", defaultStreamImage+"social-streamOn.png");
                }else {
                    node.put("streamImg", defaultStreamImage+"social-streamOff.png");    
                }
                jsonArray.put(node);
            }
        }
         //System.out.println("jsonArray-Streams:"+jsonArray);
         return jsonArray;
     }
    
    JSONArray getStreamInfo(Stream stream, User user, String basePath) throws Exception
    {
        System.out.println("En getStreamInfo-1");
        JSONArray jsonArray = new JSONArray();
        String defaultStreamImage=basePath+"/swbadmin/css/images/";
        if(stream.isActive()) {
            defaultStreamImage+="social-streamOn.png";
        }else defaultStreamImage+="social-streamOff.png";
        
        /*
        JSONObject node = new JSONObject();
        if(stream.getStream_logo()!=null)
        {
            node.put("streamLogo", basePath+SWBPortal.getWebWorkPath()+stream.getWorkPath()+"/"+stream.getStream_logo());
        }else {
            node.put("streamLogo", defaultStreamImage);    
        }
        */
        //node.put("streamName", stream.getDisplayTitle(user.getLanguage())); 
        
        long streamPostIns = Integer.parseInt(getAllPostInStream_Query(stream));
        
        //node.put("streamMsgNum", streamPostIns); 
        
        int neutrals = 0, positives = 0, negatives = 0;
        Iterator<PostIn> itObjPostIns = stream.listPostInStreamInvs();
        while (itObjPostIns.hasNext()) {
            PostIn postIn = itObjPostIns.next();
            if (postIn != null) {
                if (postIn.getPostSentimentalType() == 0) {
                    neutrals++;
                } else if (postIn.getPostSentimentalType() == 1) {
                    positives++;
                } else if (postIn.getPostSentimentalType() == 2) {
                    negatives++;
                }
            }
        }
        
        //jsonArray.put(node);
        
        float intTotalVotos = positives + negatives + neutrals;

        //Positivo
        float intPorcentajePositive = ((float) positives * 100) / (float) intTotalVotos;

        //System.out.println("Votos Positivos:"+positives+", porcentaje:"+intPorcentajePositive); 

        //Negativo
        float intPorcentajeNegative = ((float) negatives * 100) / (float) intTotalVotos;

        //System.out.println("Votos negatives"+negatives+", porcentaje:"+intPorcentajeNegative); 

        //Neutro
        float intPorcentajeNeutral = ((float) neutrals * 100) / (float) intTotalVotos;

        //System.out.println("Votos neutrals"+neutrals+", porcentaje:"+intPorcentajeNeutral);         

        JSONArray jsonCharArray = new JSONArray();
        if (intPorcentajePositive > 0) {
            JSONObject node1 = new JSONObject();

            node1.put("label", "" + SWBSocialResUtil.Util.getStringFromGenericLocale("positives", user.getLanguage()));
            node1.put("value1", "" + positives);
            node1.put("value2", "" + round(intPorcentajePositive));
            node1.put("color", "#008000");
            node1.put("chartclass", "possClass");
            
            /*
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + positives);
            joc.put("negativos", "" + negatives);
            joc.put("neutros", "" + neutrals);
            node1.put("valor", joc);
            * */
            jsonCharArray.put(node1);
        }
        if (intPorcentajeNegative > 0) {
            JSONObject node2 = new JSONObject();
            node2.put("label", "" + SWBSocialResUtil.Util.getStringFromGenericLocale("negatives", user.getLanguage()));
            node2.put("value1", "" + negatives);
            node2.put("value2", "" + round(intPorcentajeNegative));
            node2.put("color", "#FF0000");
            node2.put("chartclass", "negClass");
            
            /*
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + positives);
            joc.put("negativos", "" + negatives);
            joc.put("neutros", "" + neutrals);
            node2.put("valor", joc);
            * */
            jsonCharArray.put(node2);
        }
        if (intPorcentajeNeutral > 0) {
            JSONObject node3 = new JSONObject();
            node3.put("label", "" + SWBSocialResUtil.Util.getStringFromGenericLocale("neutral", user.getLanguage()));
            node3.put("value1", "" + neutrals);
            node3.put("value2", "" + round(intPorcentajeNeutral));
            node3.put("color", "#838383");
            node3.put("chartclass", "neuClass");
            
            /*
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + positives);
            joc.put("negativos", "" + negatives);
            joc.put("neutros", "" + neutrals);
            node3.put("valor", joc);
            * */
            jsonCharArray.put(node3);
        }

        if (positives == 0 && negatives == 0 && neutrals == 0) {
            //System.out.println("Entra a ObSentData TODOS 0");
            JSONObject node3 = new JSONObject();
            node3.put("label", "Sin datos");
            node3.put("value1", "0");
            node3.put("value2", "100");
            node3.put("color", "#eae8e3");
            node3.put("chartclass", "neuClass");
            
            /*
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + 0);
            joc.put("negativos", "" + 0);
            joc.put("neutros", "" + 0);
            node3.put("valor", joc);
            * */
            jsonCharArray.put(node3);
        }
        
        jsonArray.put(jsonCharArray);
        
        JSONArray jsonGDArray = new JSONArray();
        
        JSONObject jsongralDataNode = new JSONObject();
        if(stream.getStream_logo()!=null)
        {
            jsongralDataNode.put("streamLogo", basePath+SWBPortal.getWebWorkPath()+stream.getWorkPath()+"/"+stream.getStream_logo());
        }else {
            jsongralDataNode.put("streamLogo", defaultStreamImage);     
        }
        jsongralDataNode.put("streamName", stream.getDisplayTitle(user.getLanguage())); 
        jsongralDataNode.put("streamMsgNum", ""+streamPostIns); 

        jsongralDataNode.put("streamMsgPostNum", ""+positives); 
        jsongralDataNode.put("streamMsgNegNum", ""+negatives); 
        jsongralDataNode.put("streamMsgNeuNum", ""+neutrals); 
        
        jsonGDArray.put(jsongralDataNode);
        
        jsonArray.put(jsonGDArray); 
        
        System.out.println("jsonArray-StreamInfo:"+jsonArray);
                
        return jsonArray;
   }
    
    public double round(float number) {
        return Math.rint(number * 100) / 100;
    }
       
%>


<%!

    /**
     * Sort by display name set.
     *
     * @param it the it
     * @param lang the lang
     * @return the sets the
     */
    public static Iterator sortByDisplayNameSet(Iterator it, String lang) {
        TreeSet set = new TreeSet(new SWBComparator(lang)); 

        while (it.hasNext()) {
            set.add(it.next());
        }        

        return set.descendingSet().iterator();
    }
    
     private String getAllPostInStream_Query(Stream stream) {
        String query =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX social: <http://www.semanticwebbuilder.org/swb4/social#>"
                + "\n";
        //query+="select count(*)\n";    
        query += "select DISTINCT (COUNT(?postUri) AS ?c1) \n";    //Para Gena
        query +=
                "where {\n"
                + "  ?postUri social:postInStream <" + stream.getURI() + ">. \n"
                + "  }\n";
        ////System.out.println("query:"+query);
        WebSite wsite = WebSite.ClassMgr.getWebSite(stream.getSemanticObject().getModel().getName());
        query = SWBSocial.executeQuery(query, wsite);
        return query;
    }

%>