<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="org.semanticwb.Logger" %>
<%@page import="org.semanticwb.SWBException" %>
<%@page import="org.semanticwb.SWBPlatform" %>
<%@page import="org.semanticwb.SWBPortal" %>
<%@page import="org.semanticwb.SWBUtils" %>
<%@page import="org.semanticwb.model.Country" %>
<%@page import="org.semanticwb.model.Resource" %>
<%@page import="org.semanticwb.model.Role" %>
<%@page import="org.semanticwb.model.User" %>
<%@page import="org.semanticwb.model.UserRepository" %>
<%@page import="org.semanticwb.model.WebSite" %>
<%@page import="org.semanticwb.platform.SemanticProperty" %>
<%@page import="com.infotec.eworkplace.swb.SWProfile" %>
<%@page import="static com.infotec.eworkplace.swb.resources.SWProfileManager.RH_Role" %>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    Resource base = paramRequest.getResourceBase();
    WebSite wsite = base.getWebSite();
    User user = paramRequest.getUser();
    SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
    
    if(user.isSigned()) {
        final String pimg;
        if(user.getPhoto()==null)
            pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
        else
            pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();
        SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#extension");
        
        if( user.equals(profile.getCreator()) )
        {
%>        
<div class="pBase">
    <div class="pModulos">
        <h3>Mi perfil</h3>
        <div class="foto2">
            <img src="<%=pimg%>" alt="<%=user.getFullName()%>" />
        </div>
        <div class="usuario2">
            <p class="pName"><%=user.getFullName()%></p>
            <p class="pOcupacion">Modelado de Portales</p>
            <p>Consultor de portales Web</p>
        </div>
        <a href="#" class="pCM">Conoce m&aacute;s de <%=user.getName()%></a>
    </div>

    <div class="pModulos">
      <div class="pColumnsx">
        <p class="pOcupacion">Contacto Interno</p>
        <p>&nbsp;</p>
        <p>Ext. <%=(user.getExtendedAttribute(ext)==null?"":user.getExtendedAttribute(ext))%></p>
        <p>e-mail: <a href="#"><%=user.getEmail()%></a></p>
        <p>&nbsp;</p>
        <p>
            <abbr title="Avenida">Av.</abbr> San Fernando 37, 
            <abbr title="Colonia">Col.</abbr> Toriello Guerra, Tlalpan, 
            <abbr title="C&oacute;digo Postal">C.P.</abbr> 14050, M&eacute;xico 
            <abbr title="Distrito Federal">D.F.</abbr>
        </p>
      </div>
      <div class="pColumnsx">
        <p class="pOcupacion">Colaboradores Asociados</p>
        <p>&nbsp;</p>
        <p>Pendiente</p>
        <p>Pendiente</p>
        <p>Pendiente</p>
        <p>Pendiente</p>
        <p>Pendiente</p>
        <p>&nbsp;</p>
        <p>
            <a href="#">Ver todos</a>
        </p>
      </div>
    </div>
    <br class="clear" />
</div>
<%        

        }
        else {

        }
    }



    
    UserRepository ur = wsite.getUserRepository();
    Role role = ur.getRole(RH_Role);
    if( user.hasRole(role) ) {

    }
%>





