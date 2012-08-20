<%--   
    Document   : view Recurso GradoAcademicoResource
    Created on : 08/02/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.eworkplace.swb.Persona"%>
<%@page import="com.infotec.eworkplace.swb.base.PersonaBase"%>
<%@page import="com.infotec.cvi.swb.SituacionAcademica"%>
<%@page import="com.infotec.cvi.swb.Carrera"%>
<%@page import="com.infotec.cvi.swb.Grado"%>
<%@page import="com.infotec.cvi.swb.base.GradoBase"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.GradoAcademico"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.util.Set"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.Resource"%> 
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBUtils"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;

    CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
    if (cv == null) {
        cv = CV.ClassMgr.createCV(usr.getId(), wsite);
        cv.setPropietario(usr);

    }

    Academia aca = cv.getAcademia();
    if (aca == null) {
        aca = Academia.ClassMgr.createAcademia(wsite);
        cv.setAcademia(aca);
    }

    long intSize = SWBUtils.Collections.sizeOf(aca.listGradoAcademicos());
    Iterator<GradoAcademico> itga = aca.listGradoAcademicos();
    Resource base = paramRequest.getResourceBase();
    String strNumItems = base.getAttribute("numPageItems", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String action = request.getParameter("act");

    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    //if (orderby == null) {
    //    orderby = "date";
    //}

    if (action == null) {
        action = "";
    }

    //SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));

    //Set<GradoAcademico> list = null;

    //String strOrder = "";

    //todo: ordenamiento
//            list=SWBComparator.sortByCreatedSet(GradoAcademico.ClassMgr.listG(usuario, wsite),false);



    if (request.getParameter("alertmsg") != null) {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br>", "\\n\\r");
%>
<script type="text/javascript">
    alert('<%=strMsg%>');
</script>
<%
    }
%>
<div >  
    <div id="icv">
        <%@include file="../menucvi.jsp" %>

        <div id="icv-data">
            <%
                if (action.equals("")) {

                    //SWBResourceURL urlorder = paramRequest.getRenderUrl();

            %>
            <table class="icv-table">
                <thead>
                    <tr>
                        <th width="7%" >&nbsp;</th>
                        <th width="23%" >Grado académico</th>
                        <th width="26%" >Carrera o especialidad</th>
                        <th width="24%" >Institución</th>
                        <th width="13%" >Situación</th>
                        <th width="7%" >Años</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        //PAGINACION
                        int ps = numPages;
                        long l = intSize;

                        int p = 0;
                        if (npage != null) {
                            p = Integer.parseInt(npage);
                        }
                        int x = 0;
                        if (l == 0) {
                    %>
                    <tr >
                        <td colspan="6" >No se encontraron registros</td>
                    </tr>
                    <%    } else {

                        //Iterator<GradoAcademico> itcec = itga.iterator();
                        while (itga.hasNext()) {
                            GradoAcademico ga = itga.next();

                            //PAGINACION ////////////////////
                            if (x < p * ps) {
                                x++;
                                continue;
                            }
                            if (x == (p * ps + ps) || x == l) {
                                break;
                            }
                            x++;
                            /////////////////////////////////

                            String strGrado = "<center>---</center>";
                            String strCarrera = "<center>---</center>";
                            String strInstitucion = "<center>---</center>";
                            String strSituacion = "<center>---</center>";
                            int strPeriodo = ga.getPeriodoYears();

                            if (ga.getGrado() != null && ga.getGrado().getTitle() != null) {
                                strGrado = ga.getGrado().getTitle();
                            }
                            if (ga.getSituacionAcademica() != null && ga.getSituacionAcademica().getTitle() != null) {
                                strSituacion = ga.getSituacionAcademica().getTitle();
                            }
                            if (ga.getCarrera() != null && ga.getCarrera().getTitle() != null) {
                                strCarrera = ga.getCarrera().getTitle();
                            }
                            if (ga.getNombreInstitucion() != null) {
                                strInstitucion = ga.getNombreInstitucion();
                            }

                            SWBResourceURL urldel = paramRequest.getActionUrl();
                            urldel.setAction(SWBResourceURL.Action_REMOVE);
                            urldel.setParameter("id", ga.getId());

                            SWBResourceURL urledit = paramRequest.getRenderUrl();
                            urledit.setParameter("act", SWBResourceURL.Action_EDIT);
                            urledit.setParameter("id", ga.getId());
                    %>
                    <tr>
                        <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">&nbsp;</a></span>
                            <span class="icv-editar"><a href="#" onclick="window.location='<%=urledit%>';">&nbsp;</a></span></td>
                        <td><%=strGrado%></td>
                        <td><%=strCarrera%></td>
                        <td><%=strInstitucion%></td>
                        <td><%=strSituacion%></td>
                        <td><%=strPeriodo%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>

            <div class="paginar">
                <p>
                    <%
                        if (p > 0 || x < l) //Requiere paginacion
                        {

                            int pages = (int) (l / ps);
                            if ((l % ps) > 0) {
                                pages++;
                            }

                            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                            int inicia = 0;
                            int finaliza = pages;


                            int rangoinicial = p - 5;
                            int rangofinal = p + 5;
                            if (pages <= 10) {
                                inicia = 0;
                                finaliza = pages;
                            } else {
                                if (rangoinicial < 0) {
                                    inicia = 0;
                                    finaliza = Math.abs(rangoinicial) + rangofinal;
                                } else if (rangofinal > pages) {
                                    inicia = pages - 10;
                                    finaliza = pages;
                                } else {
                                    inicia = rangoinicial;
                                    finaliza = rangofinal;
                                }
                            }

                            if (pages > 10) {
                                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                                urlNext.setParameter("page", "" + 0);
                                out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al inicio</a> ");
                            }

                            for (int z = inicia; z < finaliza; z++) {
                                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                                urlNext.setParameter("page", "" + z);

                                if (z != p) {
                                    out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">" + (z + 1) + "</a> ");
                                } else {
                                    out.println((z + 1) + " ");
                                }

                            }
                            if (pages > 10) {
                                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                                urlNext.setParameter("page", "" + (pages - 1));
                                out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al final</a> ");
                            }

                        }

                        SWBResourceURL urladd = paramRequest.getRenderUrl();
                        urladd.setParameter("act", SWBResourceURL.Action_ADD);
                    %>
                </p></div>
            <p class="icv-txt"><a href="<%=urladd%>">Agregar</a></p>    


            <%
            } else if (SWBResourceURL.Action_ADD.equals(action)) {
                String wptitle = wpage.getDisplayName(usr.getLanguage());
                SWBResourceURL urladd = paramRequest.getActionUrl();
                urladd.setAction(SWBResourceURL.Action_ADD);
            %>         
            <h3><%=wptitle%></h3>
            <script type="text/javascript">
                <!--
                dojo.require("dijit.layout.ContentPane");
                dojo.require("dijit.form.Form");
                dojo.require("dijit.form.ValidationTextBox");
                dojo.require("dijit.form.Button");
                dojo.require("dijit.form.FilteringSelect");
                dojo.require("dojo.data.ItemFileReadStore");    

                function enviar() {
                    var objd=dijit.byId('form1ga');

                    if(objd.validate())
                    {
                        return true;
                    }else {
                        alert("Datos incompletos o erroneos");
                    }
                    return false;
                }
                -->
            </script>

            <form id="form1ga" name="form1ga" method="post" action="<%=urladd%>" dojoType="dijit.form.Form" >
                <!-- input type="hidden" name="" value="" / --> 
                <div class="icv-div-grupo">
                    <p class="icv-3col">
                        <label for="idgrado"><b>*</b>Grado Académico</label>
                        <select name="idgrado" id="idgrado" dojoType="dijit.form.FilteringSelect" required="true">
                            <option value="" selected="selected">Seleccione...</option>
                            <%
                                Iterator<Grado> itgrado = Grado.ClassMgr.listGrados(wsite);
                                while (itgrado.hasNext()) {
                                    Grado grado = itgrado.next();
                            %>
                            <option value="<%=grado.getId()%>"><%=grado.getDisplayTitle(usr.getLanguage())%></option>
                            <%
                                }
                            %>
                        </select>
                    </p>
                    <p class="icv-3col">
                        <label for="txtInstitucion"><b>*</b>Institución</label>
                        <input type="text" name="txtInstitucion" id="txtInstitucion" maxlength="150" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese institución" />
                    </p>
                    <p class="icv-3col">
                        <label for="idsituacion"><b>*</b>Situación Académica</label>
                        <select name="idsituacion" id="idsituacion" dojoType="dijit.form.FilteringSelect" required="true">
                            <option value="" selected="selected">Seleccione...</option>
                            <%
                                Iterator<SituacionAcademica> itsit = SituacionAcademica.ClassMgr.listSituacionAcademicas(wsite);
                                while (itsit.hasNext()) {
                                    SituacionAcademica situacionAcademica = itsit.next();
                            %>
                            <option value="<%=situacionAcademica.getId()%>"><%=situacionAcademica.getDisplayTitle(usr.getLanguage())%></option>
                            <%
                                }
                            %>
                        </select>
                    </p>
                    <div class="clearer">&nbsp;</div>
                </div>
                <div class="icv-div-grupo">
                    <%
                        SWBResourceURL url = paramRequest.getRenderUrl();
                        url.setCallMethod(SWBResourceURL.Call_DIRECT);
                    %>
                    <div dojoType="dojo.data.ItemFileReadStore" jsId="tipoCarreraStore<%=base.getId()%>" url="<%=url.setMode("mod_tipo")%>"></div>
                    <div dojoType="dojo.data.ItemFileReadStore" jsId="areaCarreraStore<%=base.getId()%>" url="<%=url.setMode("mod_area")%>"></div>
                    <div dojoType="dojo.data.ItemFileReadStore" jsId="carreraStore<%=base.getId()%>" url="<%=url.setMode("mod_carrera")%>"></div>
                    <p class="icv-3col">           
                        <label for="sel_Tipo">Disciplina</label>             
                        <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" required="false" store="tipoCarreraStore<%=base.getId()%>" name="sel_Tipo" id="sel_Tipo<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').query.tipo = this.value || '*';" />        
                    </p>
                    <p class="icv-3col">
                        <label for="sel_Area">Área</label>
                        <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" required="false" store="areaCarreraStore<%=base.getId()%>" name="sel_Area" id="sel_Area<%=base.getId()%>" onChange="dijit.byId('sel_Carrera<%=base.getId()%>').query.area = this.value || '*'; dijit.byId('sel_Tipo<%=base.getId()%>').attr('value', (dijit.byId('sel_Area<%=base.getId()%>').item || {tipo: ''}).tipo);" />          <!-- dijit.byId('sel_Carrera<%//=base.getId()%>').attr('value',''); -->
                    </p>
                    <p class="icv-3col">
                        <label for="sel_Carrera">Carrera</label>
                        <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" required="false" store="carreraStore<%=base.getId()%>" name="sel_Carrera" id="sel_Carrera<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').attr('value', (dijit.byId('sel_Carrera<%=base.getId()%>').item || {area: ''}).area);" />       
                    </p>

                    <div class="clearer">&nbsp;</div>
                </div>
                <div class="icv-div-grupo">  

                    <!-- p class="icv-3col">
                    <label for="idcarrera"><b>*</b>Carrera o Especialidad</label>
                    <select name="idcarrera" id="idcarrera" dojoType="dijit.form.FilteringSelect" required="true">
                      <option value="" selected="selected">Seleccione...</option>
                    <%
                        //Iterator<Carrera> itcarrera = Carrera.ClassMgr.listCarreras(wsite); 
                        //    while (itcarrera.hasNext()) {
                        //        Carrera carrera = itcarrera.next();
                    %>
                                                    <option value="<%//=carrera.getId()%>"><%//=carrera.getDisplayTitle(usr.getLanguage())%></option>
                    <%
                        //     }
%>
                        </select>
                      </p>
                    -->


                    <p class="icv-3col">
                        <label for="periodo"><b>*</b>Periodo en años</label>
                        <input type="text" name="periodo" id="periodo" maxlength="2" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese periodo en años" regExp="\d{1,2}" />
                    </p>
                    <div class="clearer">&nbsp;</div>
                </div>

                <div class="centro">
                    <%
                        SWBResourceURL urlBack = paramRequest.getRenderUrl();
                        urlBack.setParameter("act", "");
                    %>
                    <input type="button" name="regresar" id="regresar" value="Regresar" onclick="window.location='<%=urlBack%>'; return false;"/>
                    <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()"/>
                </div>
            </form>   
            <%
            } else if (SWBResourceURL.Action_EDIT.equals(action)) {
                String id = request.getParameter("id");

                String wptitle = wpage.getDisplayName(usr.getLanguage());
                SWBResourceURL urladd = paramRequest.getActionUrl();
                urladd.setAction(SWBResourceURL.Action_EDIT);
                GradoAcademico gradoAca = GradoAcademico.ClassMgr.getGradoAcademico(id, wsite);
            %>         
            <h3><%=wptitle%></h3>
            <script type="text/javascript">
                <!--
                dojo.require("dijit.layout.ContentPane");
                dojo.require("dijit.form.Form");
                dojo.require("dijit.form.ValidationTextBox");
                dojo.require("dijit.form.Button");
                dojo.require("dijit.form.FilteringSelect");
                dojo.require("dojo.data.ItemFileReadStore"); 

                function enviar() {
                    var objd=dijit.byId('form2ga');
                    if(objd.validate())
                    {
                        return true;
                    }else {
                        alert("Datos incompletos o erroneos");
                    }
                    return false;
                }
                -->
            </script>

            <form id="form2ga" name="form1ga" method="post" action="<%=urladd%>" dojoType="dijit.form.Form" >
                <input type="hidden" name="id" value="<%=id%>" /> 
                <div class="icv-div-grupo">
                    <p class="icv-3col">
                        <label for="idgrado"><b>*</b>Grado Académico</label>
                        <select name="idgrado" id="idgrado" dojoType="dijit.form.FilteringSelect" required="true">
                            <option value="" selected="selected">Seleccione...</option>
                            <%
                                Iterator<Grado> itgrado = Grado.ClassMgr.listGrados(wsite);
                                while (itgrado.hasNext()) {
                                    Grado grado = itgrado.next();
                                    String strSelected = "";
                                    if (grado.equals(gradoAca.getGrado())) {
                                        strSelected = "selected";
                                    }
                            %>
                            <option value="<%=grado.getId()%>" <%=strSelected%> ><%=grado.getDisplayTitle(usr.getLanguage())%></option>
                            <%
                                }
                            %>
                        </select>
                    </p>
                    <p class="icv-3col">
                        <label for="txtInstitucion"><b>*</b>Institución</label>
                        <input type="text" name="txtInstitucion" id="txtInstitucion" maxlength="150" value="<%=gradoAca.getNombreInstitucion()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese institución"  />
                    </p>
                    <p class="icv-3col">
                        <label for="idsituacion"><b>*</b>Situación Académica</label>
                        <select name="idsituacion" id="idsituacion" dojoType="dijit.form.FilteringSelect" required="true">
                            <option value="" selected="selected">Seleccione...</option>
                            <%
                                Iterator<SituacionAcademica> itsit = SituacionAcademica.ClassMgr.listSituacionAcademicas(wsite);
                                while (itsit.hasNext()) {
                                    SituacionAcademica situacionAcademica = itsit.next();
                                    String strSelected = "";
                                    if (situacionAcademica.equals(gradoAca.getSituacionAcademica())) {
                                        strSelected = "selected";
                                    }
                            %>
                            <option value="<%=situacionAcademica.getId()%>" <%=strSelected%> ><%=situacionAcademica.getDisplayTitle(usr.getLanguage())%></option>
                            <%
                                }
                            %>
                        </select>
                    </p>
                    <div class="clearer">&nbsp;</div>
                </div>

                <div class="icv-div-grupo">
                    <%
                        SWBResourceURL url = paramRequest.getRenderUrl();
                        url.setCallMethod(SWBResourceURL.Call_DIRECT);
                        String idCarrera = gradoAca.getCarrera() != null ? gradoAca.getCarrera().getId() : "";
                        String idArea = gradoAca.getCarrera() != null ? gradoAca.getCarrera().getAreaCarrera().getId() : "";
                        String idTipo = gradoAca.getCarrera() != null ? gradoAca.getCarrera().getAreaCarrera().getTipoCarreraInv().getId() : "";
                    %>
                    <div dojoType="dojo.data.ItemFileReadStore" jsId="tipoCarreraStore<%=base.getId()%>" url="<%=url.setMode("mod_tipo")%>"></div>
                    <div dojoType="dojo.data.ItemFileReadStore" jsId="areaCarreraStore<%=base.getId()%>" url="<%=url.setMode("mod_area")%>"></div>
                    <div dojoType="dojo.data.ItemFileReadStore" jsId="carreraStore<%=base.getId()%>" url="<%=url.setMode("mod_carrera")%>"></div>
                    <p class="icv-3col">           
                        <label for="sel_Tipo">Disciplina</label>             
                        <input dojoType="dijit.form.FilteringSelect" value="<%=idTipo%>" autoComplete="true" required="false" store="tipoCarreraStore<%=base.getId()%>" name="sel_Tipo" id="sel_Tipo<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').query.tipo = this.value || '*';" />        
                    </p>
                    <p class="icv-3col">
                        <label for="sel_Area">Área</label>
                        <input dojoType="dijit.form.FilteringSelect" value="<%=idArea%>" autoComplete="true" required="false" store="areaCarreraStore<%=base.getId()%>" name="sel_Area" id="sel_Area<%=base.getId()%>" onChange="dijit.byId('sel_Carrera<%=base.getId()%>').query.area = this.value || '*'; dijit.byId('sel_Tipo<%=base.getId()%>').attr('value', (dijit.byId('sel_Area<%=base.getId()%>').item || {tipo: ''}).tipo);" />          <!-- dijit.byId('sel_Carrera<%//=base.getId()%>').attr('value',''); -->
                    </p>
                    <p class="icv-3col">
                        <label for="sel_Carrera">Carrera</label>
                        <input dojoType="dijit.form.FilteringSelect" value="<%=idCarrera%>" autoComplete="true" required="false" store="carreraStore<%=base.getId()%>" name="sel_Carrera" id="sel_Carrera<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').attr('value', (dijit.byId('sel_Carrera<%=base.getId()%>').item || {area: ''}).area);" />       
                    </p>

                    <div class="clearer">&nbsp;</div>
                </div>
                <div class="icv-div-grupo">

                    <p class="icv-3col">
                        <label for="periodo"><b>*</b>Periodo en años</label>
                        <input type="text" name="periodo" id="periodo" maxlength="2" value="<%=gradoAca.getPeriodoYears()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese periodo en años" regExp="\d{1,2}" />
                    </p>
                    <div class="clearer">&nbsp;</div>
                </div>

                <div class="centro">
                    <%
                        SWBResourceURL urlBack = paramRequest.getRenderUrl();
                        urlBack.setParameter("act", "");
                    %>
                    <input type="button" name="regresar" id="regresar" value="Regresar" onclick="window.location='<%=urlBack%>'; return false;"/>
                    <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()"/>
                </div>
            </form>   
            <%
            }
            %>
        </div><!-- icv-data -->  
    </div>
</div>

