<%-- 
    Document   : generalData
    Created on : 21/10/2014, 03:56:43 PM
    Author     : jorge.jimenez
--%>
<%@page import="javax.swing.colorchooser.ColorSelectionModel"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="org.semanticwb.social.Country"%>
<%@page import="org.semanticwb.model.Collection"%>
<%@page import="org.semanticwb.social.util.SWBSocialUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="/swbadmin/js/jquery/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="/swbadmin/js/jquery/jquery.ui.draggable.js" type="text/javascript"></script>

<!-- Core files -->
<script src="/swbadmin/js/jquery/jquery.alerts.mod.js" type="text/javascript"></script>
<link href="/swbadmin/js/jquery/" rel="stylesheet" type="text/css" media="screen" />
<style>
    #chart {
              height: 100%;
              width: 100%;
            }
    
   
</style>
<%
    if(request.getParameter("semObj")==null) return;
    
    SemanticObject semObj=SemanticObject.getSemanticObject(request.getParameter("semObj"));
    Stream stream=null;
    try{
        stream=(Stream) semObj.getGenericInstance();
        if(stream==null) return; 
    }catch(Exception e){
        e.printStackTrace();
        %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Oops, parece que ha sucedido un error: Stream No encontrado</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
        <%
    }
    User user=paramRequest.getUser();
    long streamPostIns = Integer.parseInt(getAllPostInStream_Query(stream));
    
    SWBResourceURL urlAction=paramRequest.getActionUrl();
    urlAction.setAction(SWBResourceURL.Action_EDIT);

    //node.put("streamMsgNum", streamPostIns); 

    HashMap hmapSocialNets=new HashMap(); //For 2ond Chart
    HashMap hmapSocialNetsSentiment=new HashMap(); //For 2ond Chart
    HashMap hmapMxStates = new HashMap();   //For 3er Chart
    HashMap hmapMxStatesSentiment=new HashMap(); //For 3er Chart
    HashMap hmapUsStates = new HashMap();   //For 4th Chart
    HashMap hmapUsStatesSentiment=new HashMap(); //For 4th Chart
    int neutrals = 0, positives = 0, negatives = 0;
    Iterator<PostIn> itObjPostIns = stream.listPostInStreamInvs();
    while (itObjPostIns.hasNext()) {
        PostIn postIn = itObjPostIns.next();
        if (postIn != null) {
            //for 1ers Chart
            int sentimentType=postIn.getPostSentimentalType(); 
            if (sentimentType == 0) {
                neutrals++;
            } else if (sentimentType == 1) {
                positives++;
            } else if (sentimentType == 2) {
                negatives++;
            }
            //for 2ond Chart (socialNetworks char)
            if(hmapSocialNets.get(postIn.getPostInSocialNetwork().getURI())!=null)  //Ya existe 
            {
                String snumber=(String)hmapSocialNets.get(postIn.getPostInSocialNetwork().getURI());
                hmapSocialNets.remove(postIn.getPostInSocialNetwork().getURI());
                int snNumber=Integer.parseInt(snumber)+1;
                hmapSocialNets.put(postIn.getPostInSocialNetwork().getURI(), ""+snNumber);
            }else{
                hmapSocialNets.put(postIn.getPostInSocialNetwork().getURI(), "1");
            }
            if(hmapSocialNetsSentiment.get(postIn.getPostInSocialNetwork().getURI())!=null)  //Ya existe 
            {
                HashMap hmapSentiments=(HashMap)hmapSocialNetsSentiment.get(postIn.getPostInSocialNetwork().getURI());
                hmapSocialNetsSentiment.remove(postIn.getPostInSocialNetwork().getURI());
                if(sentimentType==0){
                    int posit=Integer.parseInt((String)hmapSentiments.get("neutro"))+1;
                    hmapSentiments.remove("neutro");
                    hmapSentiments.put("neutro", ""+posit);
                }else if(sentimentType==1){
                    int posit=Integer.parseInt((String)hmapSentiments.get("posit"))+1;
                    hmapSentiments.remove("posit");
                    hmapSentiments.put("posit", ""+posit);
                }else if(sentimentType==2){
                    int posit=Integer.parseInt((String)hmapSentiments.get("negat"))+1;
                    hmapSentiments.remove("negat");
                    hmapSentiments.put("negat", ""+posit);
                }
                hmapSocialNetsSentiment.put(postIn.getPostInSocialNetwork().getURI(), hmapSentiments);
            }else{
                HashMap hmapSentiments=new HashMap();
                if(sentimentType==0){
                      hmapSentiments.put("neutro", ""+1);
                }else hmapSentiments.put("neutro", ""+0);
                if(sentimentType==1){
                      hmapSentiments.put("posit", ""+1);
                }else hmapSentiments.put("posit", ""+0);
                if(sentimentType==2){
                      hmapSentiments.put("negat", ""+1);
                }else hmapSentiments.put("negat", ""+0);
            
                hmapSocialNetsSentiment.put(postIn.getPostInSocialNetwork().getURI(), hmapSentiments);
            }
            //ends for socialNetworks chart
            //for 3er Chart (Localization in Mexico)
            CountryState state = postIn.getGeoStateMap();
            if (state != null) { // este puede venir nulo           
                Country country = state.getCountry();
                if (country.getId().equals("MX")) {
                    String stateUri = replace(state.getTitle());
                    //hmapMxStates.put(stateUri, hmapMxStates.containsKey(stateUri) ? addArray(hmapMxStates.get(stateUri), postIn) : new ArrayList<PostIn>());
                    if(hmapMxStates.get(stateUri)!=null)  //Ya existe 
                    {
                        String snumber=(String)hmapMxStates.get(stateUri);
                        hmapMxStates.remove(stateUri);
                        int snNumber=Integer.parseInt(snumber)+1;
                        hmapMxStates.put(stateUri, ""+snNumber);
                    }else{
                        hmapMxStates.put(stateUri, "1");
                    }
                    if(hmapMxStatesSentiment.get(stateUri)!=null)  //Ya existe 
                    {
                        HashMap hmapSentiments=(HashMap)hmapMxStatesSentiment.get(stateUri);
                        hmapMxStatesSentiment.remove(stateUri);
                        if(sentimentType==0){
                            int posit=Integer.parseInt((String)hmapSentiments.get("neutro"))+1;
                            hmapSentiments.remove("neutro");
                            hmapSentiments.put("neutro", ""+posit);
                        }else if(sentimentType==1){
                            int posit=Integer.parseInt((String)hmapSentiments.get("posit"))+1;
                            hmapSentiments.remove("posit");
                            hmapSentiments.put("posit", ""+posit);
                        }else if(sentimentType==2){
                            int posit=Integer.parseInt((String)hmapSentiments.get("negat"))+1;
                            hmapSentiments.remove("negat");
                            hmapSentiments.put("negat", ""+posit);
                        }
                        hmapMxStatesSentiment.put(stateUri, hmapSentiments);
                    }else{
                        HashMap hmapSentiments=new HashMap();
                        if(sentimentType==0){
                              hmapSentiments.put("neutro", ""+1);
                        }else hmapSentiments.put("neutro", ""+0);
                        if(sentimentType==1){
                              hmapSentiments.put("posit", ""+1);
                        }else hmapSentiments.put("posit", ""+0);
                        if(sentimentType==2){
                              hmapSentiments.put("negat", ""+1);
                        }else hmapSentiments.put("negat", ""+0);

                        hmapMxStatesSentiment.put(stateUri, hmapSentiments);
                    }
                }else if (country.getId().equals("US")) {
                     String stateUri = replace(state.getTitle());
                    //hmapMxStates.put(stateUri, hmapMxStates.containsKey(stateUri) ? addArray(hmapMxStates.get(stateUri), postIn) : new ArrayList<PostIn>());
                    if(hmapUsStates.get(stateUri)!=null)  //Ya existe 
                    {
                        String snumber=(String)hmapUsStates.get(stateUri);
                        hmapUsStates.remove(stateUri);
                        int snNumber=Integer.parseInt(snumber)+1;
                        hmapUsStates.put(stateUri, ""+snNumber);
                    }else{
                        hmapUsStates.put(stateUri, "1");
                    }
                    if(hmapUsStatesSentiment.get(stateUri)!=null)  //Ya existe 
                    {
                        HashMap hmapSentiments=(HashMap)hmapUsStatesSentiment.get(stateUri);
                        hmapUsStatesSentiment.remove(stateUri);
                        if(sentimentType==0){
                            int posit=Integer.parseInt((String)hmapSentiments.get("neutro"))+1;
                            hmapSentiments.remove("neutro");
                            hmapSentiments.put("neutro", ""+posit);
                        }else if(sentimentType==1){
                            int posit=Integer.parseInt((String)hmapSentiments.get("posit"))+1;
                            hmapSentiments.remove("posit");
                            hmapSentiments.put("posit", ""+posit);
                        }else if(sentimentType==2){
                            int posit=Integer.parseInt((String)hmapSentiments.get("negat"))+1;
                            hmapSentiments.remove("negat");
                            hmapSentiments.put("negat", ""+posit);
                        }
                        hmapUsStatesSentiment.put(stateUri, hmapSentiments);
                    }else{
                        HashMap hmapSentiments=new HashMap();
                        if(sentimentType==0){
                              hmapSentiments.put("neutro", ""+1);
                        }else hmapSentiments.put("neutro", ""+0);
                        if(sentimentType==1){
                              hmapSentiments.put("posit", ""+1);
                        }else hmapSentiments.put("posit", ""+0);
                        if(sentimentType==2){
                              hmapSentiments.put("negat", ""+1);
                        }else hmapSentiments.put("negat", ""+0);

                        hmapUsStatesSentiment.put(stateUri, hmapSentiments);
                    }                  
                }
            }
            //ends 3er Chart (Localization in Mexico)
        }
    }
    
    NumberFormat nf=new DecimalFormat("#,###,###,###");    
    
    float intPost = positives + negatives + neutrals;
    String strTotPost=nf.format(intPost); 

%>

<script type="text/javascript">
      // Load the Visualization API and the piechart package.
      google.load('visualization', '1', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create our data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        <%if(positives>0 || negatives>0 || neutrals>0){%>
            data.addRows([
              ['Positivos', <%=positives%>],
              ['Negativos', <%=negatives%>],
              ['Neutros', <%=neutrals%>]
            ]);
         <%}%>

        // Set chart options
        var options = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       'colors':['#008000','#FF0000','#838383'],
                       is3D: true
                   };
					   

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        google.visualization.events.addListener(chart, 'select', selectHandler);
        chart.draw(data, options);
        
        ///////////////// 2od. Chart ////////////////
        
        var data1 = new google.visualization.DataTable();
        data1.addColumn('string', 'SocialNetwork');
        data1.addColumn('number', 'postInSocialNet');
        data1.addRows([
        <%    
            ArrayList arrColors=new ArrayList();
            Iterator<String> socialNets=hmapSocialNets.keySet().iterator();
            while(socialNets.hasNext())
            {
                String socialNetUri=socialNets.next();
                int postNumber=Integer.parseInt((String)hmapSocialNets.get(socialNetUri));
                SemanticObject semObjSocialNet=SemanticObject.getSemanticObject(socialNetUri);  
                SocialNetwork socialNetwork=(SocialNetwork)semObjSocialNet.getGenericInstance();
                %>
                   ['<%=socialNetwork.getDisplayTitle(user.getLanguage())%>', <%=postNumber%>]<%if(socialNets.hasNext()){%>,
               <%}
                int positives1=0;
                int negatives1=0;  
                int neutrals1=0;
                HashMap hMapSentiColors=(HashMap)hmapSocialNetsSentiment.get(socialNetwork.getURI()); 
                Iterator<String> itSentiments=hMapSentiColors.keySet().iterator();
                while(itSentiments.hasNext())
                {
                    String sentiment=itSentiments.next();
                    if(sentiment.equals("neutro")) neutrals1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                    else if(sentiment.equals("posit")) positives1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                    else if(sentiment.equals("negat")) negatives1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                }
                if((positives1>negatives1) && (positives1>neutrals1)) {arrColors.add("008000");} 
                else if((negatives1>positives1) && (negatives1>neutrals1)) {arrColors.add("FF0000");} 
                else if((neutrals1>positives1) && (neutrals1>negatives1)) {arrColors.add("838383");}
                else if((positives1==negatives1) || (positives1==neutrals1) || (negatives1==neutrals1)) {arrColors.add("838383");}
            }%>
        ]); 
        
        <%
            StringBuilder strbColors=new StringBuilder(); 
            if(arrColors.size()>0){
                boolean isFirstTime=true;
                Iterator<String> itColors=arrColors.iterator(); 
                while(itColors.hasNext())
                {
                    String color=itColors.next();
                    if(isFirstTime) isFirstTime=false;
                    else strbColors.append(",");
                    strbColors.append("'#"+color+"'");
                }                
            }          
        %>
        
        
        // Set chart options
        var options1;
        <%if(!strbColors.toString().isEmpty()){%>
        options1 = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       'colors':[<%=strbColors.toString()%>],
                       is3D: true
                   };
        <%}else{%>
            options1 = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       is3D: true
                   };
         <%}%>
        
        
         // Instantiate and draw our chart, passing in some options.
        var chart1 = new google.visualization.PieChart(document.getElementById('chart_div1'));
        google.visualization.events.addListener(chart1, 'select', selectHandler1);
        chart1.draw(data1, options1);  
        /////////////////	
        
        
        ///////////////// 3er. Chart ////////////////
        
        var dataStates = new google.visualization.DataTable();
        dataStates.addColumn('string', 'State');
        dataStates.addColumn('number', 'PostNumber');
        dataStates.addRows([
        <%    
            ArrayList arrColorsStates=new ArrayList();
            Iterator<String> itStates=hmapMxStates.keySet().iterator(); 
            SortedSet<String> states = new TreeSet<String>(hmapMxStates.keySet());
            for (String countryStateUri : states) { 
                //String countryStateUri = (String)hmapMxStates.get(state);  
                itStates.next();
                //String countryStateUri=itStates.next();
                int postNumber=Integer.parseInt((String)hmapMxStates.get(countryStateUri));
                //SemanticObject semObjSocialNet=SemanticObject.getSemanticObject(countryStateUri);  
                //CountryState countryState=(CountryState)semObjSocialNet.getGenericInstance();
                boolean isThereMore=itStates.hasNext();
                //System.out.println("countryStateUri:"+countryStateUri+",postNumber"+postNumber+",isThereMore:"+isThereMore); 
                %>
                   ['<%=countryStateUri%>', <%=postNumber%>]<%if(isThereMore){%>,
               <%}
                int positives1=0;
                int negatives1=0;  
                int neutrals1=0;
                HashMap hMapSentiColors=(HashMap)hmapMxStatesSentiment.get(countryStateUri); 
                Iterator<String> itSentiments=hMapSentiColors.keySet().iterator();
                while(itSentiments.hasNext())
                {
                    String sentiment=itSentiments.next();
                    //System.out.println("countryStateUri:"+countryStateUri+",sentiment:"+sentiment+",Number:"+Integer.parseInt((String)hMapSentiColors.get(sentiment)));
                    if(sentiment.equals("neutro")) neutrals1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                    else if(sentiment.equals("posit")) positives1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                    else if(sentiment.equals("negat")) negatives1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                }
                if((positives1>negatives1) && (positives1>neutrals1)) {arrColorsStates.add("008000");} //Lo pinta de verde (Positivo)
                else if((negatives1>positives1) && (negatives1>neutrals1)) {arrColorsStates.add("FF0000");} //Lo pinta de rojo (Negativo)
                else if((neutrals1>positives1) && (neutrals1>negatives1)) {arrColorsStates.add("838383");} //Lo pinta de gris (Neutro)
                else if((positives1==negatives1) || (positives1==neutrals1) || (negatives1==neutrals1)) {arrColorsStates.add("838383");} //Lo pinta de gris (Neutro)
            }%>
        ]); 
        
        <%
            StringBuilder strbColorsStates=new StringBuilder();  
            if(arrColorsStates.size()>0){
                boolean isFirstTime=true;
                Iterator<String> itColors=arrColorsStates.iterator(); 
                while(itColors.hasNext())
                {
                    String color=itColors.next();
                    if(isFirstTime) isFirstTime=false;
                    else strbColorsStates.append(",");
                    strbColorsStates.append("'#"+color+"'");
                }                
            }          
        %>
        
        
        // Set chart options
        var optionsStates;
        <%if(!strbColorsStates.toString().isEmpty()){%>
        optionsStates = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       'colors':[<%=strbColorsStates.toString()%>],
                       is3D: true
                   };
        <%}else{%>
            optionsStates = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       is3D: true
                   };
         <%}%>
        
        //console.log("dataStates:"+JSON.stringify(dataStates));
        //console.log("optionsStates:"+JSON.stringify(optionsStates));
         // Instantiate and draw our chart, passing in some options.
        var chartStates = new google.visualization.PieChart(document.getElementById('chart_divStates'));
        google.visualization.events.addListener(chartStates, 'select', selectHandlerStates);
        chartStates.draw(dataStates, optionsStates);  
        /////////////////	
        
        
        ///////////////// 4th. Chart ////////////////
        
        var dataUsStates = new google.visualization.DataTable();
        dataUsStates.addColumn('string', 'UsState');
        dataUsStates.addColumn('number', 'UsPostNumber');
        dataUsStates.addRows([
        <%    
            ArrayList arrColorsUsStates=new ArrayList();
            Iterator<String> itUsStates=hmapUsStates.keySet().iterator(); 
            SortedSet<String> usStates = new TreeSet<String>(hmapUsStates.keySet());
            for (String countryStateUri : usStates) { 
                //String countryStateUri=itUsStates.next();
                itUsStates.next();
                int postNumber=Integer.parseInt((String)hmapUsStates.get(countryStateUri)); 
                //SemanticObject semObjSocialNet=SemanticObject.getSemanticObject(countryStateUri);  
                //CountryState countryState=(CountryState)semObjSocialNet.getGenericInstance();
                boolean isThereMore=itUsStates.hasNext();
                %>
                   ['<%=countryStateUri%>', <%=postNumber%>]<%if(isThereMore){%>,
               <%}
                int positives1=0;
                int negatives1=0;  
                int neutrals1=0;
                HashMap hMapSentiColors=(HashMap)hmapUsStatesSentiment.get(countryStateUri); 
                Iterator<String> itSentiments=hMapSentiColors.keySet().iterator();
                while(itSentiments.hasNext())
                {
                    String sentiment=itSentiments.next();
                    if(sentiment.equals("neutro")) neutrals1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                    else if(sentiment.equals("posit")) positives1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                    else if(sentiment.equals("negat")) negatives1=Integer.parseInt((String)hMapSentiColors.get(sentiment)); 
                }
                if((positives1>negatives1) && (positives1>neutrals1)) {arrColorsUsStates.add("008000");} 
                else if((negatives1>positives1) && (negatives1>neutrals1)) {arrColorsUsStates.add("FF0000");} 
                else if((neutrals1>positives1) && (neutrals1>negatives1)) {arrColorsUsStates.add("838383");}
                else if((positives1==negatives1) || (positives1==neutrals1) || (negatives1==neutrals1)) {arrColorsUsStates.add("838383");}
            }%>
        ]); 
        
        <%
            StringBuilder strbColorsUsStates=new StringBuilder();  
            if(arrColorsUsStates.size()>0){
                boolean isFirstTime=true;
                Iterator<String> itColors=arrColorsUsStates.iterator(); 
                while(itColors.hasNext())
                {
                    String color=itColors.next();
                    if(isFirstTime) isFirstTime=false;
                    else strbColorsUsStates.append(",");
                    strbColorsUsStates.append("'#"+color+"'");
                }                
            }          
        %>
        
        
        // Set chart options
        var optionsUsStates;
        <%if(!strbColorsUsStates.toString().isEmpty()){%>
        optionsUsStates = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       'colors':[<%=strbColorsUsStates.toString()%>],
                       is3D: true
                   };
        <%}else{%>
            optionsUsStates = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       is3D: true
                   };
         <%}%>
        
        
         // Instantiate and draw our chart, passing in some options.
        var chartUsStates = new google.visualization.PieChart(document.getElementById('chart_divUsStates'));
        google.visualization.events.addListener(chartUsStates, 'select', selectHandlerUsStates);
        chartUsStates.draw(dataUsStates, optionsUsStates);  
        /////////////////	
        
        
        function resizeHandler () {
            //console.log("Repinta..");
            chart.draw(data, options);
            chart1.draw(data1, options1);
            chartStates.draw(dataStates, optionsStates);  
            chartUsStates.draw(dataUsStates, optionsUsStates);  
        }
        if (window.addEventListener) {
            window.addEventListener('resize', resizeHandler, false);
        }else if (window.attachEvent) {
            window.attachEvent('onresize', resizeHandler);
        }
        
        function selectHandler() { 
          var selectedItem = chart.getSelection()[0];
          var value = data.getValue(selectedItem.row, 0);
          var value1 = data.getValue(selectedItem.row, 1);
          //alert(value+":"+value1);
          jAlert("<pre align=\"center\"><strong>"+value1.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") +"</strong> Mensajes</pre>", value);
        }  

        function selectHandler1() {
          var selectedItem = chart1.getSelection()[0];
          var value = data1.getValue(selectedItem.row, 0);
          var value1 = data1.getValue(selectedItem.row, 1);
          jAlert("<pre align=\"center\"><strong>"+value1.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") +"</strong> Mensajes</pre>", value);
        } 
        
        function selectHandlerStates() {
          var selectedItem = chartStates.getSelection()[0];
          var value = dataStates.getValue(selectedItem.row, 0);
          var value1 = dataStates.getValue(selectedItem.row, 1);
          jAlert("<pre align=\"center\"><strong>"+value1.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") +"</strong> Mensajes</pre>", value);
        } 
        
        function selectHandlerUsStates() {
          var selectedItem = chartUsStates.getSelection()[0];
          var value = dataUsStates.getValue(selectedItem.row, 0);
          var value1 = dataUsStates.getValue(selectedItem.row, 1);
          jAlert("<pre align=\"center\"><strong>"+value1.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") +"</strong> Mensajes</pre>", value);
        } 
        
      }
      
      function changeValue(field){
          if(field.checked) {document.getElementById("strAct").value="1";}
          else {document.getElementById("strAct").value="0";}
          document.getElementById("streamUri").value="<%=stream.getURI()%>";
          field.form.action="<%=urlAction%>";
          field.form.submit();
      }
      
</script>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-fw"></i> Datos Generales
                    <%if(stream.getStream_logo()!=null){%>
                    <img src="<%=SWBPortal.getWebWorkPath()+stream.getWorkPath()+"/"+stream.getStream_logo()%>" width="50" height="50"/>
                    <%}else{%>
                        <img class="swbIconStream<%=!stream.isActive()?"U":""%>" src="/swbadmin/js/dojo/dojo/resources/blank.gif">
                    <%}%>
                </div>
                <div class="panel-body">
                    <form name="streamGrlData" action=""> 
                        <p>
                        Nombre de Stream:<%=stream.getDisplayTitle(user.getLanguage())%>
                        </p>
                        <p>
                        <%if(stream.getDisplayDescription(user.getLanguage())!=null){%>
                        <%=stream.getDisplayDescription(user.getLanguage())%>
                        </p>
                        <%}%>
                        <%if(stream.isActive()) {%><label for = "streamActive0">Activo</label><input type="checkbox" id="streamActive0" name="streamActive" value="0" checked onChange="changeValue(this);"><%
                        }else {%><label for = "streamActive1">Activo</label><input type="checkbox" id="streamActive1" name="streamActive" value="1" onChange="changeValue(this);"> <%}
                        %>
                        <input type="hidden" name="active" id="strAct" value=""/>
                        <input type="hidden" name="streamUri" id="streamUri" value=""/>
                        <p>
                        Total de Post:<%=strTotPost%>
                        </p>
                        <!--a href="#" class="btn btn-default btn-block">View Details</a-->
                        <p>
                            Palabras monitoreadas:
                        </p>
                        <div class="panel panel-default">
                            <%if(stream.getPhrase()!=null && !stream.getPhrase().isEmpty()){%><p>Cualquiera de estas palabras (OR):<%=stream.getPhrase()%></p><%}%>
                            <%if(stream.getStream_exactPhrase()!=null && !stream.getStream_exactPhrase().isEmpty()){%><p>Exactamente estas palabras:<%=stream.getStream_exactPhrase()%></p><%}%>
                            <%if(stream.getStream_notPhrase()!=null && !stream.getStream_notPhrase().isEmpty()){%><p>Ninguna de estas palabras:<%=stream.getStream_notPhrase()%></p><%}%>
                            <%if(stream.getStream_allPhrases()!=null && !stream.getStream_allPhrases().isEmpty()){%><p>Todas estas palabras:<%=stream.getStream_allPhrases()%></p><%}%>
                            <%if(stream.getStream_fromAccount()!=null && !stream.getStream_fromAccount().isEmpty()){%><p>En estas cuentas:<%=stream.getStream_fromAccount()%></p><%}%>
                        </div>   
                    </form>    
                </div>
         </div>
        <!-- /.panel-body -->
    </div>
    <!-- First Pair of Charts -->
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i> Cantidad de Mensajes por sentimiento
                </div>
                <div class="panel-body">
                    <div id="chart_div" class="chart"></div>
                    <a href="#" class="btn btn-default btn-block">View Details</a>
                </div>
         </div>
        <!-- /.panel-body -->
    </div>
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
           <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> Cantidad de Mensajes por cuenta de red social y sentimiento
            </div>
            <div class="panel-body">
                <div id="chart_div1" class="chart"></div>
                <a href="#" class="btn btn-default btn-block">View Details</a>
            </div>
            <!-- /.panel-body -->
         </div>
    </div>   
    <!-- Second Pair of Charts -->
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i> Cantidad de Mensajes por estado en M&eacute;xico
                </div>
                <div class="panel-body">
                    <div id="chart_divStates" class="chart"></div>
                    <a href="#" class="btn btn-default btn-block">View Details</a>
                </div>
         </div>
        <!-- /.panel-body -->
    </div>
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
           <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> Cantidad de Mensajes por estado en USA
            </div>
            <div class="panel-body">
                <div id="chart_divUsStates" class="chart"></div>
                <a href="#" class="btn btn-default btn-block">View Details</a>
            </div>
            <!-- /.panel-body -->
         </div>
    </div>   
    
    
</div>
<%!
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
     
    public double round(float number) {
        return Math.rint(number * 100) / 100;
    }

    public ArrayList addArray(Object lista, PostIn postIn) {
        if (lista == null) {
            lista = new ArrayList<PostIn>();
        }
        ArrayList l = (ArrayList) lista;
        l.add(postIn);
        return l;

    }

    public String replace(String cadena) {
        String original = "??????????????u???????????????????";
        // Cadena de caracteres ASCII que reemplazar?n los originales.
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String output = cadena;
        for (int i = 0; i < original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i

        return output;
    }

%>