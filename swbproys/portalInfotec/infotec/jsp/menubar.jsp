<%@page import="java.util.ArrayList"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchTerm"%><%@page import="org.semanticwb.model.Resourceable"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchDocument"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchResults"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchQuery"%><%@page import="org.semanticwb.portal.indexer.SWBIndexer"%><%@page import="java.util.HashMap"%><%@page import="org.semanticwb.model.User"%><%@page import="org.semanticwb.model.WebPage"%><%@page import="org.semanticwb.SWBPortal"%><%@page import="org.semanticwb.portal.util.SWBPriorityComparator"%><%@page import="org.semanticwb.model.SWBComparator"%><%@page import="java.util.*"%><%@page import="org.semanticwb.model.Resource"%><%@page import="org.semanticwb.model.ResourceSubType"%><%@page import="org.semanticwb.model.WebSite"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%!
    class Columna
    {

        final ArrayList<WebPage> pages = new ArrayList<WebPage>();
    }
%>
<%

            User user = (User) paramRequest.getUser();
            String lang = user.getLanguage();

            WebPage topic = (WebPage) paramRequest.getWebPage();
            WebSite site = topic.getWebSite();
            WebPage home = site.getHomePage();
%>
<div id="navegacion">
    <ul id="MenuBar1" class="MenuBarHorizontal">
        <%

                    Iterator<WebPage> channels = home.listChilds(lang, true, false, false, true);
                    while (channels.hasNext())
                    {
                        WebPage channel = channels.next();
                        String titlechannel = channel.getDisplayName(lang);
                        String urlchannel = channel.getRealUrl();
        %>
        <li>
            <a class="MenuBarItemSubmenu" href="<%=urlchannel%>" ><%=titlechannel%></a>
            <%
                                    Columna[] columnas =
                                    {
                                        new Columna(), new Columna(), new Columna()
                                    };
                                    int i = 0;
                                    Iterator<WebPage> childs = channel.listChilds(lang, true, false, false, true);
                                    if (childs.hasNext())
                                    {
            %>
            <ul>
                <%
                                                        while (childs.hasNext())
                                                        {
                                                            i++;
                                                            WebPage child = childs.next();
                                                            int columna = i % 3;
                                                            columnas[columna].pages.add(child);
                                                        }
                                                        for (WebPage child : columnas[0].pages)
                                                        {
                                                            String titlechild = child.getDisplayName(lang);
                                                            String urlchild = child.getRealUrl();
                %>
                <li><h3><%=titlechild%></h3></li>
                <%
                                                        }
                                                        for (WebPage child : columnas[1].pages)
                                                        {
                                                            String titlechild = child.getDisplayName(lang);
                                                            String urlchild = child.getRealUrl();
                %>
                <li><h3><%=titlechild%></h3></li>
                <%
                                                        }
                                                        for (WebPage child : columnas[2].pages)
                                                        {
                                                            String titlechild = child.getDisplayName(lang);
                                                            String urlchild = child.getRealUrl();
                %>
                <li><h3><%=titlechild%></h3></li>
                <%
                                                        }
                %>
            <li>
            <div id="video">
      	<div class="holder"></div>
      	<h3>Liga promo</h3>
              <p>Sed semper ultrices odio, eget mattis turpis hendrerit in.</p>
              <a class="ver_video" href="#" >Ir a video</a>
            </div>
            </li></ul>
            <%
                                    }
            %>
        </li>
        <%
                    }
        %>


        <!-- <li>
          <a class="MenuBarItemSubmenu" href="#" >Acerca de Infotec</a>
          <ul>
            <li>

                  <p><a class="item" >Misi�n y Visi�n</a>
                  <a class="item" >Nuestra historia</a></p>
                  <h3>�C�mo nos organizamos?</h3>
                  <p><a class="item" >Direcci�n Adjunta de Innovaci�n y Conocimiento</a>
                  <a class="item" >Direcci�n Adjunta de Administraci�n</a>
                  <a class="item" >Direcci�n Adjunta de Desarrollo Tecnol�gico Direcci�n Adjunta de Competitividad</a></p>
            </li>
            <li>
                  <h3>Compromiso Social</h3>
                  <p><a class="item" >Eventos</a>
                  <a class="item" >Colaboraci�n en Iniciativas de ayuda</a>
                  <a class="item" >Alianzas para proyectos de</a>
                  <a class="item" >beneficio social</a>
                  <a class="item" >Alianzas estrat�gicas</a>
                  <a class="item" >Premios Infotec</a></p>
                  <h3>Trabajar en Infotec</h3>
                  <p><a class="item" >La experiencia de nuestro personal</a>
                  <a class="item" >Vacantes disponibles</a>
                  <a class="item" >Programa Plata</a></p>
            </li>
            <li>
                  <h3>Nuestra experiencia</h3>
                  <p><a class="item" >Testimoniales</a>
                  <a class="item" >Certificaciones</a>
                  <a class="item" >Reconocimientos</a>
                  <a class="item" >Alumnos de Infotec</a></p>
                  <h3>Herramientas de secci�n</h3>
                  <p><a class="item" >Blog institucional</a>
                  <a class="item" >Directorio</a>
                  <a class="item" >Galer�a multimedia</a>
                  <a class="item" >Sigue a los directores</a>
                  <a class="item" >Publica tu CV</a>
                  <a class="item" >Contacto</a>
                  <a class="item" >Conferencias</a>
                  <a class="item" >Recorrido virtual del INFOTEC</a>
                  <a class="item" >Calendario de eventos</a></p>
            </li>
            <li>
            <div id="video">
      	<div class="holder"></div>
      	<h3>Liga promo</h3>
              <p>Sed semper ultrices odio, eget mattis turpis hendrerit in.</p>
              <a class="ver_video" href="#" >Ir a video</a>
            </div>
            </li>
          </ul>
        </li>
        <li><a class="MenuBarItemSubmenu" href="#" >Servicios</a>
          <ul>
            <li>
                  <h3>�Qui�nes somos?</h3>
                  <p><a class="item" >Misi�n y Visi�n</a>
                  <a class="item" >Nuestra historia</a></p>
                  <h3>�C�mo nos organizamos?</h3>
                  <p><a class="item" >Direcci�n Adjunta de Innovaci�n y Conocimiento</a>
                  <a class="item" >Direcci�n Adjunta de Administraci�n</a>
                  <a class="item" >Direcci�n Adjunta de Desarrollo Tecnol�gico Direcci�n Adjunta de Competitividad</a></p>
            </li>
            <li>
                  <h3>Compromiso Social</h3>
                  <p><a class="item" >Eventos</a>
                  <a class="item" >Colaboraci�n en Iniciativas de ayuda</a>
                  <a class="item" >Alianzas para proyectos de</a>
                  <a class="item" >beneficio social</a>
                  <a class="item" >Alianzas estrat�gicas</a>
                  <a class="item" >Premios Infotec</a></p>
                  <h3>Trabajar en Infotec</h3>
                  <p><a class="item" >La experiencia de nuestro personal</a>
                  <a class="item" >Vacantes disponibles</a>
                  <a class="item" >Programa Plata</a></p>
            </li>
            <li>
                  <h3>Nuestra experiencia</h3>
                  <p><a class="item" >Testimoniales</a>
                  <a class="item" >Certificaciones</a>
                  <a class="item" >Reconocimientos</a>
                  <a class="item" >Alumnos de Infotec</a></p>
                  <h3>Herramientas de secci�n</h3>
                  <p><a class="item" >Blog institucional</a>
                  <a class="item" >Directorio</a>
                  <a class="item" >Galer�a multimedia</a>
                  <a class="item" >Sigue a los directores</a>
                  <a class="item" >Publica tu CV</a>
                  <a class="item" >Contacto</a>
                  <a class="item" >Conferencias</a>
                  <a class="item" >Recorrido virtual del INFOTEC</a>
                  <a class="item" >Calendario de eventos</a></p>
            </li>
            <li>
            <div id="video">
      	<div class="holder"></div>
      	<h3>Liga promo</h3>
              <p>Sed semper ultrices odio, eget mattis turpis hendrerit in.</p>
              <a class="ver_video" href="#" >Ir a video</a>
            </div>
            </li>
          </ul>
        </li>
        <li><a class="MenuBarItemSubmenu" href="#" >Soluciones integrales</a>
          <ul>
            <li>
                  <h3>�Qui�nes somos?</h3>
                  <p><a class="item" >Misi�n y Visi�n</a>
                  <a class="item" >Nuestra historia</a></p>
                  <h3>�C�mo nos organizamos?</h3>
                  <p><a class="item" >Direcci�n Adjunta de Innovaci�n y Conocimiento</a>
                  <a class="item" >Direcci�n Adjunta de Administraci�n</a>
                  <a class="item" >Direcci�n Adjunta de Desarrollo Tecnol�gico Direcci�n Adjunta de Competitividad</a></p>
            </li>
            <li>
                  <h3>Compromiso Social</h3>
                  <p><a class="item" >Eventos</a>
                  <a class="item" >Colaboraci�n en Iniciativas de ayuda</a>
                  <a class="item" >Alianzas para proyectos de</a>
                  <a class="item" >beneficio social</a>
                  <a class="item" >Alianzas estrat�gicas</a>
                  <a class="item" >Premios Infotec</a></p>
                  <h3>Trabajar en Infotec</h3>
                  <p><a class="item" >La experiencia de nuestro personal</a>
                  <a class="item" >Vacantes disponibles</a>
                  <a class="item" >Programa Plata</a></p>
            </li>
            <li>
                  <h3>Nuestra experiencia</h3>
                  <p><a class="item" >Testimoniales</a>
                  <a class="item" >Certificaciones</a>
                  <a class="item" >Reconocimientos</a>
                  <a class="item" >Alumnos de Infotec</a></p>
                  <h3>Herramientas de secci�n</h3>
                  <p><a class="item" >Blog institucional</a>
                  <a class="item" >Directorio</a>
                  <a class="item" >Galer�a multimedia</a>
                  <a class="item" >Sigue a los directores</a>
                  <a class="item" >Publica tu CV</a>
                  <a class="item" >Contacto</a>
                  <a class="item" >Conferencias</a>
                  <a class="item" >Recorrido virtual del INFOTEC</a>
                  <a class="item" >Calendario de eventos</a></p>
            </li>
            <li>
            <div id="video">
      	<div class="holder"></div>
      	<h3>Liga promo</h3>
              <p>Sed semper ultrices odio, eget mattis turpis hendrerit in.</p>
              <a class="ver_video" href="#" >Ir a video</a>
            </div>
            </li>
          </ul>
        </li>
        <li><a class="MenuBarItemSubmenu" href="#" >Oferta educativa</a>
          <ul>
            <li>
                  <h3>�Qui�nes somos?</h3>
                  <p><a class="item" >Misi�n y Visi�n</a>
                  <a class="item" >Nuestra historia</a></p>
                  <h3>�C�mo nos organizamos?</h3>
                  <p><a class="item" >Direcci�n Adjunta de Innovaci�n y Conocimiento</a>
                  <a class="item" >Direcci�n Adjunta de Administraci�n</a>
                  <a class="item" >Direcci�n Adjunta de Desarrollo Tecnol�gico Direcci�n Adjunta de Competitividad</a></p>
            </li>
            <li>
                  <h3>Compromiso Social</h3>
                  <p><a class="item" >Eventos</a>
                  <a class="item" >Colaboraci�n en Iniciativas de ayuda</a>
                  <a class="item" >Alianzas para proyectos de</a>
                  <a class="item" >beneficio social</a>
                  <a class="item" >Alianzas estrat�gicas</a>
                  <a class="item" >Premios Infotec</a></p>
                  <h3>Trabajar en Infotec</h3>
                  <p><a class="item" >La experiencia de nuestro personal</a>
                  <a class="item" >Vacantes disponibles</a>
                  <a class="item" >Programa Plata</a></p>
            </li>
            <li>
                  <h3>Nuestra experiencia</h3>
                  <p><a class="item" >Testimoniales</a>
                  <a class="item" >Certificaciones</a>
                  <a class="item" >Reconocimientos</a>
                  <a class="item" >Alumnos de Infotec</a></p>
                  <h3>Herramientas de secci�n</h3>
                  <p><a class="item" >Blog institucional</a>
                  <a class="item" >Directorio</a>
                  <a class="item" >Galer�a multimedia</a>
                  <a class="item" >Sigue a los directores</a>
                  <a class="item" >Publica tu CV</a>
                  <a class="item" >Contacto</a>
                  <a class="item" >Conferencias</a>
                  <a class="item" >Recorrido virtual del INFOTEC</a>
                  <a class="item" >Calendario de eventos</a></p>
            </li>
            <li>
            <div id="video">
      	<div class="holder"></div>
      	<h3>Liga promo</h3>
              <p>Sed semper ultrices odio, eget mattis turpis hendrerit in.</p>
              <a class="ver_video" href="#" >Ir a video</a>
            </div>
            </li>
          </ul>
        </li>
          <li><a class="MenuBarItemSubmenu" href="#" >Innovaci�n</a>
          <ul>
            <li>
                  <h3>�Qui�nes somos?</h3>
                  <p><a class="item" >Misi�n y Visi�n</a>
                  <a class="item" >Nuestra historia</a></p>
                  <h3>�C�mo nos organizamos?</h3>
                  <p><a class="item" >Direcci�n Adjunta de Innovaci�n y Conocimiento</a>
                  <a class="item" >Direcci�n Adjunta de Administraci�n</a>
                  <a class="item" >Direcci�n Adjunta de Desarrollo Tecnol�gico Direcci�n Adjunta de Competitividad</a></p>
            </li>
            <li>
                  <h3>Compromiso Social</h3>
                  <p><a class="item" >Eventos</a>
                  <a class="item" >Colaboraci�n en Iniciativas de ayuda</a>
                  <a class="item" >Alianzas para proyectos de</a>
                  <a class="item" >beneficio social</a>
                  <a class="item" >Alianzas estrat�gicas</a>
                  <a class="item" >Premios Infotec</a></p>
                  <h3>Trabajar en Infotec</h3>
                  <p><a class="item" >La experiencia de nuestro personal</a>
                  <a class="item" >Vacantes disponibles</a>
                  <a class="item" >Programa Plata</a></p>
            </li>
            <li>
                  <h3>Nuestra experiencia</h3>
                  <p><a class="item" >Testimoniales</a>
                  <a class="item" >Certificaciones</a>
                  <a class="item" >Reconocimientos</a>
                  <a class="item" >Alumnos de Infotec</a></p>
                  <h3>Herramientas de secci�n</h3>
                  <p><a class="item" >Blog institucional</a>
                  <a class="item" >Directorio</a>
                  <a class="item" >Galer�a multimedia</a>
                  <a class="item" >Sigue a los directores</a>
                  <a class="item" >Publica tu CV</a>
                  <a class="item" >Contacto</a>
                  <a class="item" >Conferencias</a>
                  <a class="item" >Recorrido virtual del INFOTEC</a>
                  <a class="item" >Calendario de eventos</a></p>
            </li>
            <li>
            <div id="video">
      	<div class="holder"></div>
      	<h3>Liga promo</h3>
              <p>Sed semper ultrices odio, eget mattis turpis hendrerit in.</p>
              <a class="ver_video" href="#" >Ir a video</a>
            </div>
            </li>
          </ul>
        </li> -->
    </ul>
</div>