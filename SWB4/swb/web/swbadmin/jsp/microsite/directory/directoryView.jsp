<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.portal.community.*"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>

<%!
private final int I_PAGE_SIZE = 20;
%>

<%
Resource base=paramRequest.getResourceBase();
User user=paramRequest.getUser();
WebPage wpage=paramRequest.getWebPage();
String perfilPath=wpage.getWebSite().getWebPage("perfil").getUrl();
Iterator<DirectoryObject> itObjs=(Iterator)request.getAttribute("itDirObjs");
SemanticObject sobj = (SemanticObject) request.getAttribute("sobj");
SemanticClass cls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(sobj.getURI());

if (sobj != null) {
SWBResourceURL url=paramRequest.getRenderUrl();
url.setParameter("uri", sobj.getURI());
%>

       <%url.setParameter("act","add");%>
       <div class="editarInfo1">
            <p>
                <%if(user.isRegistered() && user.isSigned()){%>
                    <a href="<%=url%>">Agregar elemento al directorio</a>
               <%}else{%>
                    Registrese para publicar
               <%}%>
            </p>
       </div>
       <div class="clear">&nbsp;</div>
 <div id="entriesList">
        <%
        //Empieza paginaci�n
        SWBResourceURL urlPag=paramRequest.getRenderUrl();
        int actualPage = 1;
        if (request.getParameter("actualPage") != null) {
            actualPage = Integer.parseInt(request.getParameter("actualPage"));
        }

        Set setResult=null;
        SemanticProperty semPropOrder=DirectoryObject.swb_title;
        if(request.getParameter("orderBy")!=null && request.getParameter("orderBy").equals("date"))
        {
            urlPag.setParameter("orderBy", "date");
            setResult=SWBComparator.sortByCreatedSet(itObjs, false);
        }else {
            setResult=SWBComparator.sortByDisplayNameSet(itObjs, user.getLanguage());
        }

        String pagination = getPageRange(setResult.size(), actualPage);
        int iIniPage = 0;
        int iFinPage = 0;
        int iTotPage = 0;
        int contTokens=0;
        StringTokenizer strTokens=new StringTokenizer(pagination,"|");
        while(strTokens.hasMoreTokens()){
            String token=strTokens.nextToken();
            contTokens++;
            if(contTokens==1) iIniPage=Integer.parseInt(token);
            else if(contTokens==2) iFinPage=Integer.parseInt(token);
            else if(contTokens==3) iTotPage=Integer.parseInt(token);
        }
        
        %>
        <p align="center">
        <%
        if(iTotPage>1)%>P�gina(<%
        if (actualPage > 1) {
             int gotop = (actualPage - 1);
             urlPag.setParameter("actualPage", ""+gotop);

             %>
                <a class="link" href="<%=urlPag%>"><<</a>&nbsp;
             <%
        }
        if(iTotPage>1){
            for (int i = 1; i <= iTotPage; i++) {
                if (i == actualPage) {
                    %><strong><%=i%></strong><%;
                } else {
                    urlPag.setParameter("actualPage", "" + i);
                    %>
                        <a href="<%=urlPag%>"><%=i%></a>
                    <%
                }
            }
        }
        if (actualPage > 0 && (actualPage + 1 <= iTotPage)) {
             int gotop = (actualPage + 1);
             urlPag.setParameter("actualPage", ""+gotop);
             %>
                <a class="link" href="<%=urlPag%>">>></a>&nbsp;
             <%
        }
        if(iTotPage>1)%>)
        </p>
        <%
        //Termina paginaci�n
        //Comienza criterios de busqueda y ordenamiento
        SWBResourceURL urlOrder=paramRequest.getRenderUrl();
        String dirPhotoCheck="";
        if(request.getParameter("dirPhoto")!=null) dirPhotoCheck="checked";
        %>            
        <form action="<%=urlOrder.setAction("filter")%>" method="post">
        <table align="center">
        <tr><td><b>Buscar con los siguientes criterios:</b></td></tr>
        <tr><td>
        Solo anuncios con foto  </td><td><input type="checkbox" name="dirPhoto" <%=dirPhotoCheck%>></td>
        <input type="hidden" name="swbdirParam_dirPhoto" value="1">
        </tr>
        <%
        SWBFormMgr mgr = new SWBFormMgr(cls, wpage.getSemanticObject(), null);
        mgr.setFilterRequired(false);
        Iterator<SemanticProperty> itProps=cls.listProperties();
        while(itProps.hasNext()){
             SemanticProperty semProp1=itProps.next();
             if(semProp1.isBoolean()){
                %>
                <tr><td>
                <%=semProp1.getDisplayName(user.getLanguage())%>  </td><td><%=mgr.renderElement(request, semProp1,mgr.MODE_CREATE)%></td>
                    <input type="hidden" name="swbdirParam_<%=semProp1.getName()%>" value="1">
                </tr>
                <%
              }
             FormElement element=mgr.getFormElement(semProp1);
             if(element!=null && element.getId()!=null){
                if(element.getId().indexOf("selectOne")>-1){
                    mgr.setType(mgr.TYPE_XHTML);
                    %>
                     <tr><td><%=semProp1.getDisplayName(user.getLanguage())%></td><td><%=mgr.renderElement(request, semProp1,mgr.MODE_CREATE)%></td>
                    <input type="hidden" name="swbdirParam_<%=semProp1.getName()%>" value="1">
                    </tr>
                   <%
                   continue;
                }
             }
        }
        %>
        <tr><td colspan="2" align="center"><input type="submit" value="Buscar"></td></tr>
        </table>
        </form>
        <p align="right"><a href="<%=urlOrder.setParameter("orderBy", "title")%>">Por Nombre</a> | <a href="<%=urlOrder.setParameter("orderBy", "date")%>">por fecha</a></p>
        <!--Termina ordenamiento-->
        <%
        //Terminan Filtros de busqueda
         SWBResourceURL urlDetail=paramRequest.getRenderUrl();
         SWBResourceURL urlEdit=paramRequest.getRenderUrl();
         SWBResourceURL urlRemove=paramRequest.getRenderUrl();

         urlDetail.setParameter("act", "detail");
         urlEdit.setParameter("act", "edit");
         urlRemove.setParameter("act", "detail");

         //Leer parametros que se env�an para filtrado
         HashMap hdirParams=new HashMap();
         Map mParams=request.getParameterMap();
         Iterator itParams=mParams.keySet().iterator();
         while(itParams.hasNext()){
             String pname=(String)itParams.next();
             if(pname.startsWith("swbdirParam_"))
             {
                 String param=pname.substring(12);
                 if(request.getParameter(param)!=null){
                     hdirParams.put(param, request.getParameter(param));
                 }
             }
         }
         //System.out.println("PARAMS SIZE:"+hdirParams.size());
         //Termina leida de parametros para filtrar
        
         int cont=0;
         boolean exist=false;
         HashMap map=new HashMap();
         map.put("separator", "-");
         Iterator itResult=setResult.iterator();
         while(itResult.hasNext())
         {
            ArrayList alFilter=new ArrayList();
            cont++;
            DirectoryObject dirObj=(DirectoryObject)itResult.next();
            if(cont<=iIniPage) continue;
            else if(cont>iFinPage) break;
            exist=true;
            String img="", title="", description="", tags="", price=null, creator="", created="";
            urlDetail.setParameter("uri", dirObj.getURI());
            urlEdit.setParameter("uri", dirObj.getURI());
            urlRemove.setParameter("uri", dirObj.getURI());
            User userObj=null;
            SemanticObject semObject = dirObj.getSemanticObject();
            mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_VIEW);
            Iterator<SemanticProperty> ipsemProps=semObject.listProperties();
            while(ipsemProps.hasNext())
            {
               SemanticProperty semProp=ipsemProps.next();
               if(semProp.isDataTypeProperty()){
                   String propValue=semObject.getProperty(semProp);
                   if(propValue!=null && !propValue.equals("null")){
                        if(hdirParams.containsKey(semProp.getName())) //Filtrado
                        {
                            if(semProp.getName().equals("dirPhoto")) //La foto x ser de tipo text,no se puede controlar dinamicamente
                            {
                                alFilter.add(semProp.getName());
                            }else if(semProp.isBoolean() && propValue.equals("true")){
                                 //System.out.println("***Boolean-->semProp:"+semProp+",valor:"+propValue);
                                 alFilter.add(semProp.getName());
                            }else {
                                 FormElement element=mgr.getFormElement(semProp);
                                 if(element!=null && element.getId()!=null){
                                    if(element.getId().indexOf("selectOne")>-1){
                                        if(request.getParameter(semProp.getName())!=null && request.getParameter(semProp.getName()).equals(propValue)){
                                            //System.out.println("***selectOne-->semProp:"+semProp+",valor:"+propValue);
                                            alFilter.add(semProp.getName());
                                        }
                                    }
                                 }
                            }
                        }
                        if(semProp==DirectoryObject.swbcomm_dirPhoto)
                        {
                            img="<img src=\""+SWBPlatform.getWebWorkPath()+base.getWorkPath()+"/"+semObject.getId()+"/"+propValue+ "\" width=\"90\" height=\"90\">";
                        }if(semProp==DirectoryObject.swb_title) {
                             title=propValue;
                        }else if(semProp==DirectoryObject.swb_description){
                             description=propValue;
                        }else if(semProp==DirectoryObject.swb_tags){
                             tags=propValue;
                        }else if(semProp==ClasifiedBuySell.swbcomm_Price){
                             price=propValue;
                        }else if(semProp==DirectoryObject.swb_created){
                            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                            Date date=new Date();
                            date=formatoDelTexto.parse(propValue);
                            propValue= SWBUtils.TEXT.getTimeAgo(date, user.getLanguage());
                            created=propValue;
                        }
                    }
                }else if(semProp==DirectoryObject.swb_creator){
                        SemanticObject semUser=semObject.getObjectProperty(DirectoryObject.swb_creator);
                        if(semUser!=null){
                            userObj=(User)semUser.createGenericInstance();
                            creator="<a href=\""+perfilPath+"?user="+userObj.getEncodedURI()+"\">"+userObj.getFullName()+"</a>";
                         }
                }
            }
            if(alFilter.size()==hdirParams.size())
            {
            %>
              <div class="listEntry" onmouseover="this.className='listEntryHover'" onmouseout="this.className='listEntry'">
              <%if(!img.equals("")){%><%=img%><%}else{%><img src="<%=SWBPlatform.getContextPath()%>/swbadmin/images/noDisponible.gif"/><%}%>
              <div class="listEntryInfo">
                    <p class="tituloNaranja">
                        <%=title%>
                    </p>
                        <%=wpage.getPath(map)%>
                    <p>
                        <%=description%>
                    </p><br/>
                    <%if(price!=null && price.trim().length()>0 && !price.equals("null")){%><p class="tituloNaranja">-Precio:<%=price%></p><%}%>
                    <p>-Palabras clave:<%=tags%></p>
                    <p>-Creado por:<%=creator%></p>
                    <p>-Creado:<%=created%></p>

                    <div class="vermasFloat"><p class="tituloNaranja"><p class="vermas"><a href="<%=urlDetail%>"><%=paramRequest.getLocaleString("seeMore")%></a></p></div>
                    <%
                    if(user.isRegistered() && user.isSigned()){
                        UserGroup group=user.getUserRepository().getUserGroup("admin");
                        if((userObj!=null && userObj.getURI().equals(user.getURI())) || group!=null && user.hasUserGroup(group)){
                    %>
                        <div class="editarInfo"><p><a href="<%=urlEdit%>"><%=paramRequest.getLocaleString("editInfo")%></a></p></div>
                        <div class="editarInfo"><p><a href="<%=urlRemove.setAction(urlRemove.Action_REMOVE)%>"><%=paramRequest.getLocaleString("remove")%></a></p></div>
                    <%  }
                    }
                    %>
                    <div class="clear">&nbsp;</div>
              </div>
             </div>
            <%
             }  
            }
            if(!exist){
                %>
                <div class="listEntry" onmouseover="this.className='listEntryHover'" onmouseout="this.className='listEntry'">
                    <img src="<%=SWBPlatform.getContextPath()%>/swbadmin/images/anunciate.gif">
                    <div class="listEntryInfo">
                        <p class="tituloNaranja">
                            T�tulo de tu anuncio
                        </p>
                            <%=wpage.getPath(map)%>
                        <p>
                            description de tu anuncio
                        </p><br/>
                        <p>-Palabras clave:</p>
                        <p>-Creado por:Tu nombre aqu�</p>
                        <p>-creado:Fecha de creaci�n de anuncio</p>

                        <div class="vermasFloat"><p class="tituloNaranja"><p class="vermas"><%=paramRequest.getLocaleString("seeMore")%></p></div>
                        <div class="editarInfo"><p><%=paramRequest.getLocaleString("editInfo")%></p></div>
                        <div class="editarInfo"><p><%=paramRequest.getLocaleString("remove")%></p></div>
                        <div class="clear">&nbsp;</div>
                   </div>
                </div>
                <%
            }
            %>
      </div>
<%
 }
%>

<%!
    private String getPageRange(int iSize, int iPageNum) {
        int iTotPage = 0;
        int iPage = 1;
        if (iPageNum > 1) {
            iPage = iPageNum;
        }
        if (iSize > I_PAGE_SIZE) {
            iTotPage = iSize / I_PAGE_SIZE;
            int i_ret = iSize % I_PAGE_SIZE;
            if (i_ret > 0) {
                iTotPage = iTotPage + 1;
            }
        } else {
            iTotPage = 1;
        }
        int iIniPage = (I_PAGE_SIZE * iPage) - I_PAGE_SIZE;
        int iFinPage = I_PAGE_SIZE * iPage;
        if (iSize < I_PAGE_SIZE * iPage) {
            iFinPage = iSize;
        }
        return iIniPage + "|" + iFinPage + "|" + iTotPage;
    }
%>
