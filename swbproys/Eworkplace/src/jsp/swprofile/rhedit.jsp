<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="org.semanticwb.Logger" %>
<%@page import="org.semanticwb.SWBException" %>
<%@page import="org.semanticwb.SWBPlatform" %>
<%@page import="org.semanticwb.SWBPortal" %>
<%@page import="org.semanticwb.SWBUtils" %>
<%@page import="org.semanticwb.model.Country" %>
<%@page import="org.semanticwb.model.Resource" %>
<%@page import="rg.semanticwb.model.Role" %>
<%@page import="org.semanticwb.model.User" %>
<%@page import="org.semanticwb.model.UserRepository" %>
<%@page import="org.semanticwb.model.WebSite" %>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    WebSite site = paramRequest.getWebPage().getWebSite();
    UserRepository ur = site.getUserRepository();
    Role role = ur.getRole(RH_Role);
    if(user.hasRole(role)) {

    }
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
<div class="perfil divisor">
<h3>Mi perfil</h3>
<div class="foto"><img src="forms_files/user.jpg" alt="">        <a href="#">Cambiar foto</a></div>
<div class="usuario">
<p class="name">Rosy Hernández Flores</p>
</div>
<p class="mas_deMi"><a href="#">Más acerca de mí</a></p>
<div class="datos">
<div id="acercade_mi">
<div class="text_editor">
<h3>Mi personalidad</h3>
<img src="forms_files/editor.gif" alt=""></div>
<div class="text_editor">
<h3>Mis gustos e intereses</h3>
<img src="forms_files/editor.gif" alt=""></div>
<a href="#">Cerrar editor</a></div>
<p class="tercio"><label>Dirección de adscripción</label><select>
<option selected="selected">Competitividad</option>
</select></p>
<p class="tercio"><label>Área</label><select>
<option selected="selected">Modelado de portales</option>
</select></p>
<p class="tercio"><label>Cargo o nombre del puesto designado</label><select>
<option selected="selected">Consultor en portales</option>
</select></p>
<p class="status entero"><label>¿Qué haces o piensas?</label><input type="text"></p>
</div>
<div class="clearer">&nbsp;</div>
</div>
<div class="contacto_interno divisor">
<h3>Contacto interno</h3>
<p class="medio"><label>Extensión</label> <input type="text"></p>
<p class="medio"><label>Extensión de tu Dirección Adjunta</label> <input type="text"></p>
<p class="entero"><label>Correo electrónico institucional</label> <input type="text"></p>
<p class="entero"><label>Ubicación física de tu lugar u oficina</label><br>
<input type="textarea"></p>
<div class="clearer">&nbsp;</div>
</div>
<div class="contacto_externo divisor">
<h3>Contacto externo</h3>
<p>Esta información es para uso exclusivo de la institución, no aparecerá en tu perfil</p>
<p class="tercio"><label>País</label> <select>
<option selected="selected">México</option>
</select></p>
<p class="tercio"><label>C.P.</label> <input type="text"></p>
<p class="tercio"><label>Delegación</label> <select>
<option selected="selected">Magdalena Contreras</option>
</select></p>
<p class="medio">Colonia <select>
<option selected="selected">San Jerónimo</option>
</select></p>
<p class="medio">Calle y número <input type="text"></p>
<div class="clearer">&nbsp;</div>
</div>
<div class="experiencia divisor">
<h3>Experiencia en Infotec</h3>
<p class="entero">Cliente <select>
<option selected="selected">Secretaría del Trabajo y Previsión Social</option>
</select></p>
<p class="entero">Describe brevemente tus actividades relevantes en el proyecto. (Máximo 500 caracteres)</p>
<div class="text_editor"><img src="forms_files/editor.gif" alt=""></div>
<div class="clearer">&nbsp;</div>
<p><a href="#">Agregar</a></p>
</div>
<div class="conocimientos divisor">
<h3>Conocimientos</h3>
<ol>
    <li>
    <p class="tercio">Conocimiento <br>
    <input type="text"></p>
    <p class="tercio">Experiencia <br>
    <select>
    <option selected="selected">3 años</option>
    </select></p>
    <p class="tercio">Domino <br>
    <select>
    <option selected="selected">Avanzado</option>
    </select></p>
    <p class="entero"><input value="Eliminar" type="button"></p>
    <div class="clearer">&nbsp;</div>
    </li>
    <li>
    <p class="tercio">Conocimiento <br>
    <input type="text"></p>
    <p class="tercio">Experiencia <br>
    <select>
    <option selected="selected">3 años</option>
    </select></p>
    <p class="tercio">Domino <br>
    <select>
    <option selected="selected">Avanzado</option>
    </select></p>
    <p class="entero"><input value="Eliminar" type="button"></p>
    <div class="clearer">&nbsp;</div>
    </li>
    <li>
    <p class="tercio">Conocimiento <br>
    <input type="text"></p>
    <p class="tercio">Experiencia <br>
    <select>
    <option selected="selected">3 años</option>
    </select></p>
    <p class="tercio">Domino <br>
    <select>
    <option selected="selected">Avanzado</option>
    </select></p>
    <p class="entero"><input value="Eliminar" type="button"></p>
    <div class="clearer">&nbsp;</div>
    </li>
</ol>
<p><a href="#">Agregar</a></p>
</div>
<div class="habilidades divisor">
<h3>Habilidades</h3>
<ol>
    <li>
    <p class="tercio">Habilidad <br>
    <input type="text"></p>
    <p class="tercio">Experiencia <br>
    <select>
    <option selected="selected">3 años</option>
    </select></p>
    <p class="tercio">Domino <br>
    <select>
    <option selected="selected">Avanzado</option>
    </select></p>
    <p class="entero"><input value="Eliminar" type="button"></p>
    <div class="clearer">&nbsp;</div>
    </li>
    <li>
    <p class="tercio">Habilidad <br>
    <input type="text"></p>
    <p class="tercio">Experiencia <br>
    <select>
    <option selected="selected">3 años</option>
    </select></p>
    <p class="tercio">Domino <br>
    <select>
    <option selected="selected">Avanzado</option>
    </select></p>
    <p class="entero"><input value="Eliminar" type="button"></p>
    <div class="clearer">&nbsp;</div>
    </li>
    <li>
    <p class="tercio">Habilidad <br>
    <input type="text"></p>
    <p class="tercio">Experiencia <br>
    <select>
    <option selected="selected">3 años</option>
    </select></p>
    <p class="tercio">Domino <br>
    <select>
    <option selected="selected">Avanzado</option>
    </select></p>
    <p class="entero"><input value="Eliminar" type="button"></p>
    <div class="clearer">&nbsp;</div>
    </li>
</ol>
<p><a href="#">Agregar</a></p>
</div>
<div class="de_interes divisor">
<h3>Temas de tu interés</h3>
<p>El sistema te ofrecerá contenidos acordes con tus temas de interés</p>
<ul>
    <li class="tercio"><input type="checkbox"><label for="checkbox">Tecnología</label></li>
    <li class="tercio"><input type="checkbox"><label for="checkbox">Servicios internos</label></li>
    <li class="tercio"><input type="checkbox"><label for="checkbox">Normatividad interna</label></li>
    <li class="tercio"><input type="checkbox"><label for="checkbox">Capacitación</label></li>
    <li class="tercio"><input type="checkbox"><label for="checkbox">Noticias Infotec</label></li>
    <li class="tercio"><input type="checkbox"><label for="checkbox">Proyectos de Infotec</label></li>
</ul>
<div class="clearer">&nbsp;</div>
</div>
<div class="guardar"><input value="Guardar" type="button"></div>
</div>