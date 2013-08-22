<%-- 
    Document   : streamMap
    Created on : 11-jul-2013, 16:25:27
    Author     : jorge.jimenez
--%>
<%@page import="org.semanticwb.social.util.SWBSocialUtil"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.SWBPortal"%> 
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<%
    String apiKey=SWBSocialUtil.Util.getModelPropertyValue(SWBContext.getAdminWebSite(), "GoogleMapsApiKey");
    if(apiKey==null){
        out.println("Error:No se puede mostrar el mapa debido a que la llave de Google Maps no esta configurada(GoogleMapsApiKey), contactese con su administrador");
        return; 
    }
    String suri=request.getParameter("suri");
    if(suri==null) {
        return;
    }
    SemanticObject semObj=SemanticObject.getSemanticObject(suri);
    if(semObj==null) return;
    WebSite wsite=WebSite.ClassMgr.getWebSite(semObj.getModel().getName());  
    User user=paramRequest.getUser(); 
    
    String stateMsg=SWBSocialUtil.Util.getStringFromGenericLocale("state", user.getLanguage());
    String positivesMsg=SWBSocialUtil.Util.getStringFromGenericLocale("positives", user.getLanguage());
    String negativesMsg=SWBSocialUtil.Util.getStringFromGenericLocale("negatives", user.getLanguage());
    
    int streamMapView=Integer.parseInt(paramRequest.getResourceBase().getAttribute("streamMapView", "1"));
    
    SWBResourceURL urlDetails = paramRequest.getRenderUrl().setMode("showMarkDet");
    urlDetails.setCallMethod(SWBResourceURL.Call_DIRECT);
    
%>


<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>SWBSocial Sentiment Analysis Map</title>
    <!--AIzaSyA_8bWaWXaKlJV2XgZt-RYwRAsp6S0J7iw-->
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?sensor=false&key="+apiKey>  
    </script>
    <script type="text/javascript">
      document.write('<script type="text/javascript" src="<%=SWBPortal.getContextPath()%>/swbadmin/js/markermanager.js"><' + '/script>');
    </script>
    <script type="text/javascript">
    //<![CDATA[

    var ICONS = [];
    var map = null;
    var mgr = null;
    var geocoder;
    
    function setupMap() {
      geocoder=new google.maps.Geocoder();   
      var myOptions = {
        zoom: 5,
        //center: new google.maps.LatLng(48.25, 11.00),
        center: new google.maps.LatLng(25, -99),
        mapTypeId: google.maps.MapTypeId.HYBRID
      };
      map = new google.maps.Map(document.getElementById('map'), myOptions);

      showMarkers();
            
    }

    function getMarkers(n) {
      var batch = [];
      <%
        ArrayList aPostInsNotInStates=new ArrayList();
        HashMap<String, HashMap> hmapPoints=new HashMap();
        Iterator <PostIn> itPostIns=null;  
        if(semObj.getGenericInstance() instanceof Stream) 
        {
            Stream stream=(Stream)semObj.getGenericInstance();
            itPostIns=stream.listPostInStreamInvs();  
        }else if(semObj.getGenericInstance() instanceof SocialTopic) {
            SocialTopic socialTopic=(SocialTopic) semObj.getGenericInstance();
            itPostIns=PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
        }
        //System.out.println("streamMapView:"+streamMapView);
        while(itPostIns.hasNext())
        {
            PostIn postIn=itPostIns.next();
            //System.out.println("postIn/lat:"+postIn.getLatitude()+",lng:"+postIn.getLongitude());
            if(postIn.getGeoStateMap()!=null && (streamMapView==1 || streamMapView==3 || streamMapView==4))
            {
                if(!hmapPoints.containsKey(postIn.getGeoStateMap().getId())) 
                {
                    //System.out.println("Entra a hmapPoints-1.1:"+postIn.getMsg_Text()); 
                    HashMap<String, Integer> sentimentHash=new HashMap();
                    //System.out.println("Entra a hmapPoints-1.2:"+postIn.getPostSentimentalType());
                    if(postIn.getPostSentimentalType()==1) {
                        sentimentHash.put("P", new Integer(1));
                    }  //Con sentimiento Positivo
                    else if(postIn.getPostSentimentalType()==2) {
                        sentimentHash.put("N", new Integer(1)); 
                    } //Con sentimiento Negativo
                    if(!sentimentHash.isEmpty())
                    {
                        //System.out.println("sentimentHash PRIMERO:"+sentimentHash);
                        hmapPoints.put(postIn.getGeoStateMap().getId(), sentimentHash);
                        //System.out.println("Entra a hmapPoints-2:"+hmapPoints);
                    }
                }else{  //Si ya contiene el estado en el HashMap
                    HashMap sentimentHash=hmapPoints.get(postIn.getGeoStateMap().getId());
                    if(postIn.getPostSentimentalType()==1)
                    {
                        if(sentimentHash.containsKey("P"))
                        {
                            //System.out.println("Entra a hmapPoints-5.1:"+postIn.getMsg_Text()); 
                            //System.out.println("Valor:"+sentimentHash.get("P"));
                            int positiveSentimentNumber=((Integer)sentimentHash.get("P")).intValue()+1;
                            //System.out.println("Entra a hmapPoints-5.2:"+positiveSentimentNumber); 
                            sentimentHash.remove("P");
                            sentimentHash.put("P", new Integer(positiveSentimentNumber));
                            hmapPoints.remove(postIn.getGeoStateMap().getId());
                            hmapPoints.put(postIn.getGeoStateMap().getId(), sentimentHash);
                            
                        }else{
                            sentimentHash.put("P", new Integer(1)); 
                            hmapPoints.remove(postIn.getGeoStateMap().getId());
                            hmapPoints.put(postIn.getGeoStateMap().getId(), sentimentHash);
                        }
                    }else if(postIn.getPostSentimentalType()==2) 
                    {
                        if(sentimentHash.containsKey("N"))
                        {
                            int negativeSentimentNumber=((Integer)sentimentHash.get("N")).intValue()+1;
                            sentimentHash.remove("N");
                            sentimentHash.put("N", new Integer(negativeSentimentNumber));
                            hmapPoints.remove(postIn.getGeoStateMap().getId());
                            hmapPoints.put(postIn.getGeoStateMap().getId(), sentimentHash);
                        }else{
                            sentimentHash.put("N", new Integer(1)); 
                            hmapPoints.remove(postIn.getGeoStateMap().getId());
                            hmapPoints.put(postIn.getGeoStateMap().getId(), sentimentHash);
                        }
                    }
                }
                if(streamMapView==3 || streamMapView==4)
                {
                    aPostInsNotInStates.add(postIn);
                }
            }else{
                aPostInsNotInStates.add(postIn);
            }
        }
        Iterator<String> itMapStates=hmapPoints.keySet().iterator();
        while(itMapStates.hasNext())
        {
            String state=itMapStates.next();
            CountryState countryState=CountryState.ClassMgr.getCountryState(state, SWBContext.getAdminWebSite());
            //System.out.println("countryState J:"+countryState.getId());
            if(countryState!=null)
            {
                //System.out.println("countryState J-1/state:"+state);
                
                HashMap<String, Integer> sentimentHash=hmapPoints.get(state); 
                
                int positiveNumber=0;
                int negativeNumber=0;
                if(sentimentHash.containsKey("P"))
                {
                    positiveNumber=((Integer)sentimentHash.get("P")).intValue(); 
                }
                if(sentimentHash.containsKey("N"))
                {
                    negativeNumber=((Integer)sentimentHash.get("N")).intValue();
                }
                if(positiveNumber>negativeNumber)
                {
                    %>
                    //var tmpIcon = new google.maps.MarkerImage('/images/glad.png');
                    //alert("tmpIcon:"+tmpIcon);
                    batch.push(new google.maps.Marker({
                        position: new google.maps.LatLng(<%=countryState.getCapitalLatitude()%>,<%=countryState.getCapitalLongitude()%>),
                        icon: new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/greenPoint.png', new google.maps.Size(15, 15), new google.maps.Point(15,15)),
                        title: '<%=stateMsg%>:<%=countryState.getDisplayTitle(user.getLanguage())%>, <%=positivesMsg%>:'+<%=positiveNumber%>+', <%=negativesMsg%>:<%=negativeNumber%>'
                    })
                    );
                    <%    
                }else if(negativeNumber>positiveNumber)
                {
                    %>
                    //var tmpIcon = getSentimentIcon("sad");
                    batch.push(new google.maps.Marker({
                        position: new google.maps.LatLng(<%=countryState.getCapitalLatitude()%>,<%=countryState.getCapitalLongitude()%>),
                        icon: new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/redPoint.png', new google.maps.Size(15, 15), new google.maps.Point(15,15)),
                        title: '<%=stateMsg%>:<%=countryState.getDisplayTitle(user.getLanguage())%>, <%=positivesMsg%>:'+<%=positiveNumber%>+', <%=negativesMsg%>:<%=negativeNumber%>'
                    })
                    );
                    <%  
                 }else if(positiveNumber==negativeNumber)
                 {
                    %>
                    //var tmpIcon = getSentimentIcon("sad");
                    batch.push(new google.maps.Marker({
                        position: new google.maps.LatLng(<%=countryState.getCapitalLatitude()%>,<%=countryState.getCapitalLongitude()%>),
                        icon: new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/yellowPoint.png', new google.maps.Size(15, 15), new google.maps.Point(15,15)),
                        title: '<%=stateMsg%>:<%=countryState.getDisplayTitle(user.getLanguage())%>, <%=positivesMsg%>:'+<%=positiveNumber%>+', <%=negativesMsg%>:<%=negativeNumber%>'
                    })
                    );
                    <%  
                 }
            }
        }
      %>
      //alert("batch de regreso:"+batch.length);        
      
      //Traer el resto de PostIns, es decir, los que no tienen una instancia de CountryState asociada
      <%
        int cont1=0, cont2=0;        
        Iterator<PostIn> restOfPostIns=aPostInsNotInStates.iterator();
        while(restOfPostIns.hasNext())
        {
            PostIn postIn=restOfPostIns.next();
            //System.out.println("postIn Msg Todos:"+postIn.getMsg_Text()+":"+postIn.getPostInSocialNetworkUser().getSnu_profileGeoLocation());
             //Para los PostIns que tienen un sentimiento positivo o negativo y ademas tienen latitud y longitud asociada
            if(postIn.getLatitude()!=0 && postIn.getLongitude()!=0 && ((streamMapView==3 && postIn.getPostSentimentalType()>0) || streamMapView==2 || streamMapView==4))
            {
                 cont1++;
                 String msg=replaceSpecialCharacters(postIn.getMsg_Text().replaceAll("'", ""), false);
            
                %>
                       var tmpIcon;
                        <%        
                        if(postIn.getPostSentimentalType()==1)
                        {
                            %>
                               tmpIcon = new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/greenGMapMarker.png');
                            <%
                        }else if(postIn.getPostSentimentalType()==2)
                        { 
                            %>
                                tmpIcon = new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/redGMapMarker.png');
                            <%
                        }else if(postIn.getPostSentimentalType()==0)
                        {
                        %>
                                tmpIcon = new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/whiteGMapMarker.png');
                        <%
                        } 
                        %>
                       var marker = new google.maps.Marker({
                       position: new google.maps.LatLng(<%=postIn.getLatitude()%>,<%=postIn.getLongitude()%>),
                       icon: tmpIcon, 
                       title: '<%=msg%>',
                       map: map
                       });
                       associateInfoWindows(marker, '<%=postIn.getEncodedURI()%>');
                       batch.push(marker);  
                <%         
            }else if(postIn.getPostInSocialNetworkUser()!=null && postIn.getPostInSocialNetworkUser().getSnu_profileGeoLocation()!=null && ((streamMapView==3 && postIn.getPostSentimentalType()>0) || streamMapView==2 || streamMapView==4)){ 
                cont2++; 
                %>
                        var tmpIcon;
                        <%        
                        if(postIn.getPostSentimentalType()==1)
                        {
                            %>
                               tmpIcon = new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/greenGMapMarker.png');
                            <%
                        }else if(postIn.getPostSentimentalType()==2)
                        {
                            %>
                                tmpIcon = new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/redGMapMarker.png');
                            <%
                        }else if(postIn.getPostSentimentalType()==0)
                        {
                        %>
                                tmpIcon = new google.maps.MarkerImage('<%=SWBPortal.getContextPath()%>/swbadmin/css/images/whiteGMapMarker.png');
                        <%
                        } 
                        %>
                        var postLocation='<%=replaceSpecialCharacters(postIn.getPostInSocialNetworkUser().getSnu_profileGeoLocation().replaceAll("'", ""), false)%>';
                        var title='<%=postIn.getMsg_Text()!=null?replaceSpecialCharacters(postIn.getMsg_Text().replaceAll("'", ""), false):postIn.getDescription()!=null?
                            replaceSpecialCharacters(postIn.getDescription().replaceAll("'", ""), false):postIn.getTags()!=null?replaceSpecialCharacters(postIn.getTags().replaceAll("'", ""), false):"Sin Mensaje.."%>';
                         geocoder.geocode( { 'address': postLocation}, function(results, status) { 
                            if(status==google.maps.GeocoderStatus.OK){
                                var marker =new google.maps.Marker({
                                map: map,
                                position: new google.maps.LatLng(results[0].geometry.location.lat(),results[0].geometry.location.lng()),
                                icon: tmpIcon,
                                title: 'By GeoUser Profile:'+title
                                 });
                                associateInfoWindows(marker, '<%=postIn.getEncodedURI()%>');
                                batch.push(marker);  
                            }//else{
                               // alert("Esa direcci�n no existe:"+postLocation);
                            //}
                        });
                <%        
            }
        }
        System.out.println("cont1:"+cont1+",cont2:"+cont2);
      %>          
      //
      
      return batch;
    }
    
    //Crea los escuchas de los eventos "click", para cada marcador del mapa
    function associateInfoWindows(marker, postInUri) {
        google.maps.event.addListener(marker, 'click', function() {
            var infoWin = null;
            var request = false;
            if (window.XMLHttpRequest) {
                request = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            }
            var url = "<%=urlDetails%>";
            url += "?postUri=" + postInUri;
            request.open('POST', url, true);
            request.onreadystatechange = function() {
                if ((request.readyState == 4) && (request.status == 200)) {
                    infoWin = new google.maps.InfoWindow({
                        content: request.responseText
                    });
                    infoWin.open(map, marker);
                }
            }
            request.send();
        });

    }

    function showMarkers() {
      mgr = new MarkerManager(map);
      
      google.maps.event.addListener(mgr, 'loaded', function(){
          mgr.addMarkers(getMarkers(), 18);
          mgr.addMarkers(getMarkers(), 3);
          mgr.addMarkers(getMarkers(), 0);
          mgr.refresh();          
      });      
    }
    //]]>
    </script>
  </head>

    <body onload="setupMap()">
    <div id="map" style="margin: 5px auto; width: 100%; height: 100%"></div>
    <div style="text-align: center; font-size: large;">
      SWBSocial Sentiment Analysis Map
    </div>
  </body>
</html>
      
      
<%!

  /**
  *  Reemplaza caracteres especiales, tal como lo hace la misma funci�n desde el 
  *  SWBUtils, solo que esta funci�n si deja los espacios en blanco, cosa que la 
  *  del SWBUtils no hace., de hecho me parece que es un bug., decirle a Javier despues.
  */
  public static String replaceSpecialCharacters(String txt, boolean replaceSpaces)
        {
            StringBuffer ret = new StringBuffer();
            String aux = txt;
            //aux = aux.toLowerCase();
            aux = aux.replace('�', 'A');
            aux = aux.replace('�', 'A');
            aux = aux.replace('�', 'A');
            aux = aux.replace('�', 'A');
            aux = aux.replace('�', 'A');
            aux = aux.replace('�', 'A');

            aux = aux.replace('�', 'E');
            aux = aux.replace('�', 'E');
            aux = aux.replace('�', 'E');
            aux = aux.replace('�', 'E');

            aux = aux.replace('�', 'I');
            aux = aux.replace('�', 'I');
            aux = aux.replace('�', 'I');
            aux = aux.replace('�', 'I');

            aux = aux.replace('�', 'O');
            aux = aux.replace('�', 'O');
            aux = aux.replace('�', 'O');
            aux = aux.replace('�', 'O');
            aux = aux.replace('�', 'O');

            aux = aux.replace('�', 'U');
            aux = aux.replace('�', 'U');
            aux = aux.replace('�', 'U');
            aux = aux.replace('�', 'U');

            aux = aux.replace('�', 'N');


            aux = aux.replace('�', 'C');
            aux = aux.replace('�', 'Y');

            aux = aux.replace('�', 'a');
            aux = aux.replace('�', 'a');
            aux = aux.replace('�', 'a');
            aux = aux.replace('�', 'a');
            aux = aux.replace('�', 'a');
            aux = aux.replace('�', 'a');

            aux = aux.replace('�', 'e');
            aux = aux.replace('�', 'e');
            aux = aux.replace('�', 'e');
            aux = aux.replace('�', 'e');

            aux = aux.replace('�', 'i');
            aux = aux.replace('�', 'i');
            aux = aux.replace('�', 'i');
            aux = aux.replace('�', 'i');

            aux = aux.replace('�', 'o');
            aux = aux.replace('�', 'o');
            aux = aux.replace('�', 'o');
            aux = aux.replace('�', 'o');
            aux = aux.replace('�', 'o');

            aux = aux.replace('�', 'u');
            aux = aux.replace('�', 'u');
            aux = aux.replace('�', 'u');
            aux = aux.replace('�', 'u');

            aux = aux.replace('�', 'n');

            aux = aux.replace('�', 'c');
            aux = aux.replace('�', 'y');
            aux = aux.replace('�', 'y');

            if (replaceSpaces)
            {
                aux = aux.replace(' ', '_');
            }
            int l = aux.length();
            for (int x = 0; x < l; x++)
            {
                char ch = aux.charAt(x);
                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')
                        || (ch >= 'A' && ch <= 'Z') || ch == '_' || ch == ' ')
                {
                    ret.append(ch);
                }
            }
            aux = ret.toString();
            return aux;
        }
%>     


