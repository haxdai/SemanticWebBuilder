<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.GenericIterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Vector"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.model.FormElement"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.portal.community.*"%>


<%
    HashMap map=new HashMap();
    map.put("separator", "-");
    WebPage wpage=paramRequest.getWebPage();
    Resource base=paramRequest.getResourceBase();
    String perfilPath=wpage.getWebSite().getWebPage("perfil").getUrl();
    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
    DirectoryObject dirObj=(DirectoryObject)semObject.createGenericInstance();
    SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_VIEW);
    String path=SWBPlatform.getWebWorkPath()+base.getWorkPath()+"/"+semObject.getId()+"/";
    //Obtener valores de propiedades genericas
    String dirPhoto=semObject.getProperty(dirObj.swbcomm_dirPhoto);
    String title=semObject.getProperty(dirObj.swb_title);
    String description=semObject.getProperty(dirObj.swb_description);
    String tags=semObject.getProperty(dirObj.swb_tags);
    String creator="";
    SemanticObject semUser=semObject.getObjectProperty(DirectoryObject.swb_creator);
    if(semUser!=null){
        User userObj=(User)semUser.createGenericInstance();
        creator="<a href=\""+perfilPath+"?user="+userObj.getEncodedURI()+"\">"+userObj.getFullName()+"</a>";
    }
    String created=semObject.getProperty(dirObj.swb_created);
    String mapa=null;
    Iterator<SemanticProperty> itProps=semObject.listProperties();
    while(itProps.hasNext()){
         SemanticProperty semProp=itProps.next();
         if(semProp==Geolocalizable.swb_latitude){
            mapa=mgr.renderElement(request, semProp.getName());
            break;
         }
    }
%>

<div id="contenidoDetalle">
    <div class="detalle">
        <div class="detalleImagen">
         <img src="<%=path%><%=dirPhoto%>">
        </div>
        <div class="productInfo">
            <p class="tituloNaranja"><%=title%></p>
            <p><%=wpage.getPath(map)%></p>
            <%if(tags!=null){%><p>Palabras clave:<strong><%=tags%></strong></p><%}%>
            <%if(creator!=null){%><p>Creado por:<strong><%=creator%></strong></p><%}%>
            <%if(created!=null){%><p>Fecha de publicaci�n:<strong><%=created%></strong></p><%}%>
         </div>
     </div>
     <div class="descripcion">
        <h3>Descripci�n</h3>
        <%if(description!=null){%><p><%=description%></p><%}%>
        <%if(mapa!=null){%><p><%=mapa%><%}%></p><br/>
      </div>
</div>
    
   

