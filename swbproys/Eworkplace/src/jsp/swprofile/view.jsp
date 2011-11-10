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
<div id="formPerfil">
    <div id="menu_perfil">
        <ul>
            <li><a href="#">Editar mi perfil</a></li>
            <li><a href="#">Mis favoritos</a></li>
            <li><a href="#">Mis solicitudes</a></li>
            <li><a href="#">Mi perfil</a></li>
        </ul>
    </div>
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
        <a href="#" class="pCM">Conoce m&aacute;s de <%=user.getFirstName()%></a>
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
    <div class="pModulos">
      <div class="pColumnsx">
        <p class="pOcupacion">Experiencia en infotec</p>
        <p>&nbsp;</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at   libero a elit sollicitudin sollicitudin. Aenean sem felis, mattis quis   elementum lacinia, consectetur ac lacus. Vestibulum facilisis tortor   quis mi facilisis tempus. Donec laoreet enim in justo lacinia   consectetur.</p>
        <p>&nbsp;</p>
        <p class="pSubP"><span class="pOcupacion">Ha participado en</span></p>
        <p>&nbsp;</p>
        <p>Vivamus tempor tortor</p>
        <p>Vel libero varius viverra</p>
        <p>Maecenas   ullamcorper</p>
        <p> Ligula vel interdum ultricies</p>
        <p>&nbsp;</p>
        <p><a href="#">Seguir leyendo</a></p>
      </div>
      <div class="pColumnsx">
        <p class="pOcupacion">Habilidades</p>
        <p>&nbsp;</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at   libero a elit sollicitudin sollicitudin. Aenean sem felis, mattis quis   elementum lacinia, consectetur ac lacus. Vestibulum facilisis tortor   quis mi facilisis tempus. Donec laoreet enim in justo lacinia   consectetur.</p>
        <p>&nbsp;</p>
        <p><span class="pOcupacion">Conocimientos</span></p>
        <p>&nbsp;</p>
        <p>Vivamus tempor tortor</p>
        <p>Vel libero varius viverra</p>
        <p>Maecenas   ullamcorper</p>
        <p> Ligula vel interdum ultricies</p>
        <p>&nbsp;</p>
        <p><a href="#">Seguir leyendo</a></p>
      </div>
    </div>
    <br class="clear" />
</div>
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





