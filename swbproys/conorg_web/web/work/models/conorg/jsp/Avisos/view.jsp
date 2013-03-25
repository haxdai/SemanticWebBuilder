<%--
    Document   : view Recurso Avisos
    Created on : 06/08/2012
    Author     : juan.fernandez
--%>
<%@page import="com.infotec.conorg.Colleague"%>
<%@page import="com.infotec.conorg.resources.Avisos"%>
<%@page import="com.infotec.conorg.utils.MessageUtils"%>
<%@page import="com.infotec.conorg.Aviso"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.model.Versionable"%>
<%@page import="com.infotec.conorg.WorkSpace"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="com.infotec.conorg.resources.MyShelf"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.model.WebPage"%>
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
<!DOCTYPE html>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Resource base = paramRequest.getResourceBase();
    String roladmin = base.getAttribute("rolid", "");
    Role role = wsite.getUserRepository().getRole(roladmin);

    String path = SWBPlatform.getContextPath() + "/swbadmin/images/repositoryfile/";

    int luser = 1;

    long intSize = 0;

    Iterator<Aviso> it = MessageUtils.getAllUserMessages(usr, wsite);
    intSize = SWBUtils.Collections.sizeOf(it);
    it = MessageUtils.getAllUserMessages(usr, wsite);

    String strNumItems = base.getAttribute("numpag", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String direction = request.getParameter("direction");
    String action = request.getParameter("act");

    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (orderby == null) {
        orderby = "date";
    }
    if (direction == null) {
        direction = "up";
    }

    Iterator<Aviso> ittil = it;
    if ("date".equals(orderby)) {
        if ("up".equals(direction)) {
            ittil = MessageUtils.getOrderedMessagesByCreated(it, Boolean.FALSE);
        } else {
            ittil = MessageUtils.getOrderedMessagesByCreated(it, Boolean.TRUE);
        }
    } else if ("title".equals(orderby)) {
        ittil = MessageUtils.getOrderedMessagesByTitle(it, "es");
    }

    if (action == null) {
        action = "";
    }

    //12 Jun 2012, 11:35
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, h:mm a", new Locale("es"));

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
<script type="text/javascript">
    <!--
    // scan page for widgets and instantiate them
    dojo.require("dojo.parser");
    dojo.require("dijit._Calendar");
    dojo.require("dijit.ProgressBar");
    dojo.require("dijit.TitlePane");
    dojo.require("dijit.TooltipDialog");
    dojo.require("dijit.Dialog");
    // editor:
    dojo.require("dijit.Editor");

    // various Form elemetns
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.CheckBox");
    dojo.require("dijit.form.Textarea");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dijit.form.TextBox");
    dojo.require("dijit.form.DateTextBox");
    dojo.require("dijit.form.TimeTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberSpinner");
    dojo.require("dijit.form.Slider");
    dojo.require("dojox.form.BusyButton");
    dojo.require("dojox.form.TimeSpinner");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.layout.ContentPane");
    //dojo.require("dijit.form.Select");
    dojo.require("dijit.form.NumberTextBox");
    dojo.require("dijit.form.DropDownButton");
    
    -->
</script>
<%
    if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
%>

<div id="avisos" class="avisos">
    <h3>Avisos</h3>
    <%
        WebPage wpconfig = wsite.getWebPage(base.getAttribute("wpavisos", wpage.getId()));

        SWBResourceURLImp urlall = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);

        //SWBResourceURLImp urladd = paramRequest.getRenderUrl();
        urlall.setParameter("act", "");
        if (request.getParameter("wsid") != null) {
            urlall.setParameter("wsid", request.getParameter("wsid"));
        }

    %>

    <ul>
        <%

            int numele = 5;
            try {
                numele = Integer.parseInt(base.getAttribute("numele"));
            } catch (Exception e) {
            }
            int numavisos = 0;


            //ittil = MessageUtils.getOrderedMessagesByCreated(MessageUtils.getAllUserMessages(usr, wsite),Boolean.FALSE);
            while (ittil.hasNext()) {
                Aviso aviso = ittil.next();

                if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
                    if (numavisos == numele) {
                        break;
                    }
                }

                /////////////////////////////////

                String strTitle = "---";
                if (aviso.getTitle() != null) {
                    strTitle = aviso.getTitle();
                }
                String strDate = "---";
                if (aviso.getCreated() != null) {
                    strDate = sdf.format(aviso.getCreated());
                }
                String strFrom = "";
                if (aviso.getFromUser() != null) {
                    strFrom = aviso.getFromUser().getFullName();
                }
                String strDescrip = "";
                if (aviso.getDescription() != null) {
                    strDescrip = aviso.getDescription();
                }

                strTitle = strTitle +" : "+ strDescrip;
                if (strDescrip.length() > 50) {
                    strTitle = strTitle.substring(0, 50) + "...";
                }
                SWBResourceURLImp urledit = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
                urledit.setParameter("act", SWBResourceURL.Action_ADD);
                urledit.setParameter("msgid", aviso.getId());
                if (aviso.getFromUser() != null) {
                    urledit.setParameter("usrid", aviso.getFromUser().getId());
                }
                urledit.setParameter("suri", aviso.getURI());
                if (request.getParameter("wsid") != null) {
                    urledit.setParameter("wsid", request.getParameter("wsid"));
                }
        %>

        <li class="<%=Avisos.getClassIconMessage(aviso)%>"><strong><%=strDate%> - <%=strFrom%>:</strong><br />
            <%=strTitle%><br />
            <a href="<%=urledit%>">Responder</a><br />
        </li>
        <%
                numavisos++;
            }
        %>
        <li class="avisostodos"><a href="<%=urlall%>" >Ver todos los mensajes</a></li>
    </ul>
</div>
<%
} else {
    // llamado como contenido
%>
<div >
    <div id="conorg">
        <div id="conorg-data">
            <%
                if (action.equals("")) {

                    WebPage wpconfig = wsite.getWebPage(base.getAttribute("wpavisos", wpage.getId()));

                    SWBResourceURLImp urladd = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
                    urladd.setParameter("act", SWBResourceURL.Action_ADD);

                    SWBResourceURLImp urlorder = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
                    urlorder.setParameter("act", "");
                    if(npage!=null)urlorder.setParameter("page", npage); 

            %>

            <div id="conorg-add">
                <form action="<%=urladd%>" method="post">
                    <button dojoType="dijit.form.Button" type="submit" id="addButton" name="addButton" >Nuevo Aviso</button>
                </form>
            </div>

            <table class="conorg-table avisos-vista">

                <thead>
                    <tr>
                        <th class="remite"><strong>Remitente</strong></th>
                        <th class="aunto">
                            <% if (!orderby.equals("title")) {%>
                            <a href="<%=urlorder%>&order=title">Asunto</a>
                            <% } else {%>
                            <strong>Asunto</strong>
                            <% }%>
                        </th>
                        <th class="fecha">
                            <% if (orderby.equals("date")&&"down".equals(direction)) {%>
                            <strong><a href="<%=urlorder%>&order=date&direction=up">Fecha</a></strong>
                            <% } else {%>
                            <strong><a href="<%=urlorder%>&order=date&direction=down">Fecha</a></strong>
                            <% }%>
                        </th>
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
                        <td colspan="6" >No se encontraron avisos</td>
                    </tr>
                    <%    } else {

                        int numele = 5;
                        try {
                            numele = Integer.parseInt(base.getAttribute("numele"));
                        } catch (Exception e) {
                        }

                       
                        while (ittil.hasNext()) {
                            Aviso aviso = ittil.next();

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


                            String strTitle = "---";
                            if (aviso.getTitle() != null) {
                                strTitle = aviso.getTitle();
                            }
                            String strDate = "---";
                            if (aviso.getCreated() != null) {
                                strDate = sdf.format(aviso.getCreated());
                            }
                            String strFrom = "";
                            if (aviso.getFromUser() != null) {
                                strFrom = aviso.getFromUser().getFullName();
                            }
                            String strDescrip = "";
                            if (aviso.getDescription() != null) {
                                strDescrip = aviso.getDescription();
                            }

                            if (aviso.getDisplayTitle("es") != null) {
                                strTitle = aviso.getDisplayTitle("es");
                                if(strTitle.trim().length()>55){
                                    strTitle = strTitle.substring(0, 55)+ "...";
                                }
                            }
                            if (aviso.getCreated() != null) {
                                strDate = sdf.format(aviso.getCreated());
                            }

                            SWBResourceURL urlsnd = paramRequest.getRenderUrl();
                            urlsnd.setAction(SWBResourceURL.Action_ADD);
                            urlsnd.setParameter("msgid", aviso.getId());
                            urlsnd.setParameter("suri", aviso.getURI());
                            if (aviso.getFromUser() != null) {
                                urlsnd.setParameter("usrid", aviso.getFromUser().getId());
                            }
                            urlsnd.setParameter("act", SWBResourceURL.Action_ADD);

                    %>
                    <tr>

                        <td><a href="<%=urlsnd%>"  title="responder"><%=strFrom%></a></td>
                        <td class="<%=Avisos.getClassIconMessage(aviso)%>" onclick="dijit.byId('msg<%=aviso.getId()%>').show()" title="ver mensaje">
                                <span><%=strTitle%></span>
                                <div  dojoType="dijit.Dialog"  id="msg<%=aviso.getId()%>" execute="" title="Asunto: <%=strTitle%> ">
                                    <table>
                                        <tr>
                                        <td><label for="name">Mensaje: </label></td>
                                        <td><textarea dojoType="dijit.form.Textarea" type="text" name="name" rows="10" cols="50" readonly><%=strDescrip%></textarea></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                            <button dojoType="dijit.form.Button" type="submit">Cerrar</button></td>
                                        </tr>
                                    </table>
                                </div>                       
                        </td>
                        <td><%=strDate%></td>
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
                                if(null!=orderby)urlNext.setParameter("order", orderby); 
                                if(null!=direction)urlNext.setParameter("direction", direction);
                                
                                out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al inicio</a> ");
                            }

                            for (int z = inicia; z < finaliza; z++) {
                                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                                urlNext.setParameter("page", "" + z);
                                if(null!=orderby)urlNext.setParameter("order", orderby); 
                                if(null!=direction)urlNext.setParameter("direction", direction);

                                if (z != p) {
                                    out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">" + (z + 1) + "</a> ");
                                } else {
                                    out.println((z + 1) + " ");
                                }

                            }
                            if (pages > 10) {
                                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                                urlNext.setParameter("page", "" + (pages - 1));
                                if(null!=orderby)urlNext.setParameter("order", orderby); 
                                if(null!=direction)urlNext.setParameter("direction", direction);
                                out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al final</a> ");
                            }

                        }


                    %>
                </p></div>

            <%
            } else if (action.equals(SWBResourceURL.Action_ADD)) {

                String usrid = request.getParameter("usrid");
                String suri = request.getParameter("suri");
                String msgid = request.getParameter("msgid");

                Aviso aviso = Aviso.ClassMgr.getAviso(msgid, wsite);

                String strTitle = "";
                String strDescrip = "";
                
                if(aviso!=null){
                    if(aviso.getTitle()!=null&&aviso.getTitle().trim().length()>0){
                        if(!aviso.getTitle().startsWith("RE:"))
                            strTitle = "RE:";
                        strTitle = strTitle+aviso.getTitle();
                    }
                    if(aviso.getDescription()!=null&&aviso.getDescription().trim().length()>0){
                        strDescrip = "\n\r---------------------------\n\r"+aviso.getDescription();
                    }
                }

                User usrTO = null;
                if(usrid!=null) usrTO=wsite.getUserRepository().getUser(usrid);

                SWBResourceURL urladd = paramRequest.getActionUrl();
                urladd.setAction(SWBResourceURL.Action_ADD);
            %>         
            <div> <h3>Nuevo Aviso</h3>
                <div>
                    <%
                        SWBResourceURL urlback = paramRequest.getRenderUrl();
                        urlback.setParameter("act", "");

                        Colleague colleague = Colleague.ClassMgr.getColleague(usr.getId(), wsite);
                        
                        HashMap<String, User> hmcol = new HashMap<String, User>();
                        Iterator<User> itcol = colleague.listColleagueses();
                        while(itcol.hasNext()){
                            User usrcoll = itcol.next();
                            hmcol.put(usrcoll.getId(), usrcoll);
                        }
                        
                        String strChkdWS = "checked";
                        String strDsbdWS = "";
                        String strChkdUSR = "";
                        String strDsbdUSR = "disabled=\"disabled\"";
                        
                        if(usrTO!=null){ //&&!colleague.hasColleagues(usrTO)
                            hmcol.put(usrTO.getId(), usrTO);
                            strChkdUSR = "checked";
                            strDsbdUSR = "";
                            strChkdWS = "";
                            strDsbdWS = "disabled=\"disabled\"";
                        }

                        
                        
                        itcol = hmcol.values().iterator();
                        
                        boolean isAdmin = Boolean.FALSE;

                        if (usr.hasRole(role)) {
                            isAdmin = Boolean.TRUE;
                        }

                        Iterator<WorkSpace> itwspace = MessageUtils.getUserWorkSpaces(usr, wsite);
                        if (itwspace.hasNext() || itcol.hasNext()) {
                            SWBResourceURL urlshare = paramRequest.getActionUrl();
                            urlshare.setAction("add");
                            urlshare.setParameter("act", "share");


                    %>
                    <script type="text/javascript">
                        function chkNuevoAviso(){
                       
                            var forma = document.forms['frmAviso'];
                            var valid = false; 
                            var strtmp = new String(forma.msgasunto.value);
                            var newtmp = strtmp.replace(/ /g, '');
                            strtmp = new String(forma.msgdescrip.value);
                            var newtmp2 = strtmp.replace(/ /g, '');
                            if(newtmp.length==0){
                                alert('Falta poner el asunto del aviso.');
                                forma.msgasunto.value='';
                                forma.msgasunto.focus();
                                valid = false;
                            } else if(newtmp2.length==0){
                                alert('Falta poner el mensaje del aviso.');
                                forma.msgdescrip.value='';
                                forma.msgdescrip.focus();
                                valid = false;
                            } else { valid=true;}
 
                            if(!valid) return valid;
                            //var valtipo=forma.tipomsg[0].checked;
                            //alert(valtipo);
                            valid=false;
                        <%if (isAdmin) {%>
                                if(forma.tipomsg[2].checked == true){
                                    valid = true;
                                } 
                        <%}%>
                                //alert(forma.workspaceid.selectedIndex);
                                if(forma.tipomsg[0].checked == true){
                                    //alert(forma.workspaceid.selectedIndex);
                                    if(forma.workspaceid.options[forma.workspaceid.selectedIndex].value != '0') {  
                                        valid = true;   
                                    }  

                                    if(!valid) {
                                        alert('Selecciona un espacio de trabajo de la lista.');
                                        forma.workspaceid.focus();
                                    }
                                } else if(forma.tipomsg[1].checked == true){
                                    for(var i = 0; i < forma.contactid.options.length; i++) {  
                                        if(forma.contactid.options[i].selected) {  
                                            valid = true;  
                                            break;  
                                        }  
                                    }
                                    if(!valid) {
                                        alert('Selecciona uno o varios colegas de la lista.');
                                        forma.contactid.focus();
                                    }
                                }
                        
                                if(valid) forma.submit();
                                else return valid;  
 
                            }
                            
                            function chkmsgType(valor){
                                if(valor=='wrkspc'){
                                    document.forms['frmAviso'].workspaceid.disabled='';
                                    document.forms['frmAviso'].contactid.disabled='true';                                    
                                } else if(valor=='users'){
                                    document.forms['frmAviso'].workspaceid.disabled='true';
                                    document.forms['frmAviso'].contactid.disabled='';                                    
                                } else if(valor=='all'){
                                    document.forms['frmAviso'].workspaceid.disabled='true';
                                    document.forms['frmAviso'].contactid.disabled='true';                                    
                                }  
                            }
                    </script>
                    <form name="frmAviso" method="post" action="<%=urlshare%>" >
                        <table>
                            <tbody>
                                <tr>
                                    <td >Asunto: </td>
                                    <td ><input type="text" size="30" name="msgasunto" value="<%=strTitle%>" /></td>

                                </tr>
                                <tr>
                                    <td>Mensaje:</td>
                                    <td><textarea rows="5" cols="30" name="msgdescrip"><%=strDescrip%></textarea></td> 

                                </tr>
                                <tr>
                                    <td>Tipo de aviso:</td>
                                    <td><input type="radio" name="tipomsg" id="chk1" value="wrkspc" onclick="chkmsgType('wrkspc');" <%=strChkdWS%> /><label for="chk1"> Espacio trabajo</label><br/>
                                        <input type="radio" name="tipomsg" id="chk2" value="users" onclick="chkmsgType('users');" <%=strChkdUSR%> /><label for="chk2"> Usuarios</label><br/>
                                        <%
                                            if (isAdmin) {
                                        %>
                                        <input type="radio" name="tipomsg" id="chk3" value="all" onclick="chkmsgType('all');"/><label for="chk3"> Para todos</label>                                                                  
                                        <%                                    }
                                        %>
                                    </td>
                                </tr>
                                <tr>
                                    <td><label for="workspaceid">Espacios de trabajo:</label></td>
                                    <td>
                                        <select name="workspaceid" <%=strDsbdWS%>>
                                            <option value="0">Selecciona...</option>
                                            <%
                                                while (itwspace.hasNext()) {
                                                    WorkSpace wrkspc = itwspace.next();
                                            %>
                                            <option value="<%=wrkspc.getURI()%>"><%=wrkspc.getTitle()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><label for="contactid">Contactos:</label></td>
                                    <td>
                                        <select name="contactid" multiple size="5" <%=strDsbdUSR%>> 
                                            <%
                                            
                                                String usrselected = "";
                                                while (itcol.hasNext()) {
                                                    User usrcol = itcol.next();
                                                    usrselected = "";
                                                    if (usrid != null && !usrid.equals("")) {
                                                        if (usrcol.getId().equals(usrid)) {
                                                            usrselected = "selected";
                                                        }
                                                    }

                                            %>
                                            <option value="<%=usrcol.getId()%>" <%=usrselected%> ><%=usrcol.getFullName()%></option> 
                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <button dojoType="dijit.form.Button" type="button" onclick="window.location='<%=urlback%>';return false;">Cancelar</button>
                                        <button dojoType="dijit.form.Button" type="button" onclick="if(chkNuevoAviso()){this.form.submit();} else { return false;};">Crear</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <%
                    } else {

                    %>
                    <p>No cuentas con espacios de trabajo para avisos y no tienes colegas en tu directorio.</p>
                    <button dojoType="dijit.form.Button" type="button">Regresar</button>
                    <%                                }
                    %>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
<%
    }
%>


