<%--
Document   : view Shelf Recurso Shelf
    Created on : 19/06/2012
    Author     : juan.fernandez
--%>

<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="com.infotec.conorg.Topicable"%>
<%@page import="org.semanticwb.model.Tagable"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="com.infotec.conorg.Colleague"%>
<%@page import="org.semanticwb.model.PropertyGroup"%>
<%@page import="java.util.TreeSet"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<%@page import="org.semanticwb.model.Versionable"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="com.infotec.conorg.WorkSpace"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="com.infotec.conorg.resources.MyShelf"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="com.infotec.conorg.Topic"%>
<%@page import="com.infotec.conorg.Video"%>
<%@page import="com.infotec.conorg.Report"%>
<%@page import="com.infotec.conorg.Reference"%>
<%@page import="com.infotec.conorg.Presentation"%>
<%@page import="com.infotec.conorg.Document"%>
<%@page import="com.infotec.conorg.Manual"%>
<%@page import="com.infotec.conorg.Member"%>
<%@page import="com.infotec.conorg.Image"%>
<%@page import="com.infotec.conorg.Book"%>
<%@page import="com.infotec.conorg.ChapterBook"%>
<%@page import="com.infotec.conorg.Audio"%>
<%@page import="com.infotec.conorg.Article"%>
<%@page import="com.infotec.conorg.URL"%>
<%@page import="com.infotec.conorg.Mosaic"%>
<%@page import="com.infotec.conorg.Contact"%>
<%@page import="com.infotec.conorg.Tile"%>
<%@page import="com.infotec.conorg.Shelf"%>
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
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    String wsid = request.getParameter("wsid");
    String suri = request.getParameter("suri");
    Role role = null;
    Resource base = paramRequest.getResourceBase();

    String confClass = base.getAttribute(MyShelf.RES_CONF, "http://www.infotec.com/conorg.owl#Shelf");
    String path = SWBPlatform.getContextPath() + "/swbadmin/images/repositoryfile/";

    int luser = 1;
    boolean isShelf = Boolean.FALSE;

    if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
        isShelf = Boolean.TRUE;
    } else if (confClass.equals(WorkSpace.conorg_WorkSpace.getURI())) {
        isShelf = Boolean.FALSE;
    }

    String actType = request.getParameter("type");
    if (null == actType) {
        actType = "";
    }

    WebPage wpconfig = isShelf ? wsite.getWebPage(base.getAttribute("wpshelf", wpage.getId())) : wsite.getWebPage(base.getAttribute("wpworkspace", wpage.getId()));


    Shelf shelf = null;
    WorkSpace workSpace = null;
    long intSize = 0;
    if (isShelf) {
        shelf = Shelf.ClassMgr.getShelf(usr.getId(), wsite);
        if (shelf == null) {
            shelf = Shelf.ClassMgr.createShelf(usr.getId(), wsite);
            shelf.setOwner(usr);
        }
        intSize = SWBUtils.Collections.sizeOf(shelf.listTiles());
    }

    Iterator<Tile> ittil = shelf.listTiles();

    String strNumItems = base.getAttribute("numpag", "10");
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

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm", new Locale("es"));


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
<script type="text/javascript">
    <!--
    // scan page for widgets and instantiate them
    dojo.require("dojo.parser");
    dojo.require("dijit._Calendar");
    dojo.require("dijit.ProgressBar");
    dojo.require("dijit.TitlePane");

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
    dojo.require("dijit.form.Select");
    dojo.require("dijit.form.NumberTextBox");
    
    -->
</script>
<%
    if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
%>
<div class="tabs tab-estante">
    <h2>Estante</h2>
    <%
        wpconfig = isShelf ? wsite.getWebPage(base.getAttribute("wpshelf", wpage.getId())) : wsite.getWebPage(base.getAttribute("wpworkspace", wpage.getId()));

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
            int numtiles = 0;


            while (ittil.hasNext()) {
                Tile tile = ittil.next();

                    if (numtiles == numele) {
                        break;
                    }
                

                /////////////////////////////////

                String strTitle = "---";


                if (tile.getDisplayTitle("es") != null) {
                    strTitle = tile.getDisplayTitle("es");
                }

                SWBResourceURLImp urledit = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
                //SWBResourceURL urledit = paramRequest.getRenderUrl();
                urledit.setParameter("act", SWBResourceURL.Action_EDIT);
                urledit.setParameter("id", tile.getId());
                urledit.setParameter("suri", tile.getURI());
                if (request.getParameter("wsid") != null) {
                    urledit.setParameter("wsid", request.getParameter("wsid"));
                }
        %>


        <li class="<%=MyShelf.getClassIconTile(tile)%>"><a href="<%=urledit%>"><%=strTitle%></a></li>


        <%

                numtiles++;
            }
        %>
    </ul>
    <p class="vertodos"><a href="<%=urlall%>">Ver todos</a></p>
</div>
<%
} else { // call content
%>
<div >
    <div>
        <%

            if (action.equals("")) {

                wpconfig = isShelf ? wsite.getWebPage(base.getAttribute("wpshelf", wpage.getId())) : wsite.getWebPage(base.getAttribute("wpworkspace", wpage.getId()));

                // SWBResourceURLImp urladd = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);

                //SWBResourceURLImp urladd = paramRequest.getRenderUrl();
                //urladd.setParameter("act", SWBResourceURL.Action_ADD);
                //if (request.getParameter("wsid") != null) {
                //    urladd.setParameter("wsid", request.getParameter("wsid"));
                //}

        %>

        <!-- div id="conorg-add">
            <form action="<%//=urladd%>" method="post">
                <button dojoType="dijit.form.Button" type="submit" id="addButton" name="addButton">Añadir Elemento</button>
            </form>
        </div -->
        <%
            if (null == wsid) {
                wsid = "";
            }
            //String ajaxUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(MyShelf.Mode_AJAX).toString() + "?wsid=" + wsid + "&mode=tile";

            //String wptitle = wpage.getDisplayName(usr.getLanguage());
            SWBResourceURL urladd = paramRequest.getActionUrl();
            urladd.setAction(SWBResourceURL.Action_ADD);
            HashMap<String, SemanticClass> hmscdocs = new HashMap<String, SemanticClass>();
            HashMap<String, SemanticClass> hmsctile = new HashMap<String, SemanticClass>();
            Iterator<SemanticClass> itsc = Document.conorg_Document.listSubClasses();
            while (itsc.hasNext()) {
                SemanticClass sc = itsc.next();
                hmscdocs.put(sc.getURI(), sc);
            }
            itsc = Tile.conorg_Tile.listSubClasses();
            while (itsc.hasNext()) {
                SemanticClass sc = itsc.next();
                if (hmscdocs.get(sc.getURI()) == null && !sc.getURI().equals(Document.conorg_Document.getURI())) {
                    hmsctile.put(sc.getURI(), sc);
                }
            }
        %>         
        <script type="text/javascript">
            <!--

            function enviar(valor) {
                //alert("onsubmit("+encodeURI(valor)+")");
                var objd=dijit.byId(encodeURI(valor));
                if(objd.validate())
                {
                    return true;
                }else {
                    alert("Datos incompletos o erroneos");
                }
                return false;
            }
                
            function loadForm(urlval){
                getHtml(urlval, "mgrform",true, true);
            }
    
            -->
        </script>
        <form  id="form1sc" name="form1ct" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
            <label for="">Tipo de elemento tile(azulejo) a añadir:</label>
            <select name="classid" _onchange="loadForm('<%//=ajaxUrl%>&classid='+this.value)" >
                <option value="-1">Selecciona....</option>
                <optgroup title="Documento" label="Documento">
                    <%
                        itsc = hmscdocs.values().iterator();
                        while (itsc.hasNext()) {
                            SemanticClass sc = itsc.next();
                    %>
                    <option value="<%=sc.getURI()%>"><%=sc.getDisplayName("es")%></option>
                    <%
                        }
                    %>
                </optgroup>
                <%
                    itsc = hmsctile.values().iterator();
                    while (itsc.hasNext()) {
                        SemanticClass sc = itsc.next();
                %>
                <option value="<%=sc.getURI()%>"><%=sc.getDisplayName("es")%></option>
                <%
                    }
                %>
            </select>
            &nbsp;Título: <input type="text" name="elemTitle"/>
            <button dojoType="dijit.form.Button" type="submit">Agregar</button>
        </form>
        <div id="classform">
            <span id="mgrform">
                &nbsp;
            </span>
        </div>

        <table class="conorg-table estante-vista">

            <thead>
                <tr>

                    <th class="titulo" >Título</th>
                    <th class="fecha" >Fecha</th>
                    <th class="tipo" >Tipo</th>
                    <th class="tema" >Tema</th>
                    <th class="accion">&nbsp;</th>
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
                    <td colspan="5" >No se encontraron registros</td>
                </tr>
                <%    } else {

                    int numele = 5;
                    try {
                        numele = Integer.parseInt(base.getAttribute("numele"));
                    } catch (Exception e) {
                    }
                    int numtiles = 0;


                    while (ittil.hasNext()) {
                        Tile tile = ittil.next();

                        if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
                            if (numtiles == numele) {
                                break;
                            }
                        }


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

                        String strTitle = "<center>---</center>";
                        String strDate = "<center>---</center>";
                        String strType = "<center>---</center>";
                        String strTopic = "<center>---</center>";


                        if (tile.getDisplayTitle("es") != null) {
                            strTitle = tile.getDisplayTitle("es");
                        }
                        if (tile.getCreated() != null) {
                            strDate = sdf.format(tile.getCreated());
                        }
                        if (tile.listTopics().hasNext()) {
                            strTopic = "";
                            Iterator<Topic> ittopic = tile.listTopics();
                            while (ittopic.hasNext()) {
                                Topic topic = ittopic.next();
                                if (null != topic) {
                                    strTopic = strTopic + topic.getTitle();
                                }
                                if (ittopic.hasNext()) {
                                    strTopic = strTopic + ", ";
                                }
                            }
                        }

                        strType = MyShelf.getTileTypeName(tile);

                        SWBResourceURLImp urldel = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_ACTION);
                        //SWBResourceURL urldel = paramRequest.getActionUrl();
                        urldel.setAction(SWBResourceURL.Action_REMOVE);
                        urldel.setParameter("id", tile.getId());
                        urldel.setParameter("suri", tile.getURI());
                        if (request.getParameter("wsid") != null) {
                            urldel.setParameter("wsid", request.getParameter("wsid"));
                        }

                        SWBResourceURLImp urledit = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
                        //SWBResourceURL urledit = paramRequest.getRenderUrl();
                        urledit.setParameter("act", SWBResourceURL.Action_EDIT);
                        urledit.setParameter("id", tile.getId());
                        urledit.setParameter("suri", tile.getURI());
                        if (request.getParameter("wsid") != null) {
                            urledit.setParameter("wsid", request.getParameter("wsid"));
                        }
                        SWBResourceURLImp urlshare = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
                        //SWBResourceURL urledit = paramRequest.getRenderUrl();
                        urlshare.setParameter("act", "share");
                        urlshare.setParameter("id", tile.getId());
                        urlshare.setParameter("suri", tile.getURI());
                        if (request.getParameter("wsid") != null) {
                            urlshare.setParameter("wsid", request.getParameter("wsid"));
                        }
                %>
                <tr>

                    <td class="<%=MyShelf.getClassIconTile(tile)%>"><%=strTitle%></td>
                    <td><%=strDate%></td>
                    <td><%=strType%></td>
                    <td><%=strTopic%></td>
                    <td>
                        <%
                        if(tile.getCreator().equals(usr)){
                        %>
                        <span class="icv-compartir"><a href="#" title="compartir" onclick="window.location='<%=urlshare%>';">C&nbsp;</a></span>
                        <%
                         } else {
                        %>
                        <span class="icv-vacio"></span>
                        <%
                         }
                        %>
                        <span class="icv-editar"><a href="#" title="editar" onclick="window.location='<%=urledit%>';">E&nbsp;</a></span>
                        <span class="icv-borrar"><a href="#" title="borrar" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">B&nbsp;</a></span></td>

                </tr>
                <%
                            if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
                                numtiles++;
                            }

                        }
                    }
                %>
            </tbody>
        </table>

        <div class="paginar">
            <p>
                <%
                    if ((p > 0 || x < l) && (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT)) //Requiere paginacion
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
                            if (null != wsid) {
                                urlNext.setParameter("wsid", wsid);
                            }
                            out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al inicio</a> ");
                        }

                        for (int z = inicia; z < finaliza; z++) {
                            SWBResourceURL urlNext = paramRequest.getRenderUrl();
                            urlNext.setParameter("page", "" + z);
                            if (null != wsid) {
                                urlNext.setParameter("wsid", wsid);
                            }

                            if (z != p) {
                                out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">" + (z + 1) + "</a> ");
                            } else {
                                out.println((z + 1) + " ");
                            }

                        }
                        if (pages > 10) {
                            SWBResourceURL urlNext = paramRequest.getRenderUrl();
                            urlNext.setParameter("page", "" + (pages - 1));
                            if (null != wsid) {
                                urlNext.setParameter("wsid", wsid);
                            }
                            out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al final</a> ");
                        }

                    }


                %>
            </p></div>

        <%
        } else if (action.equals(SWBResourceURL.Action_ADD)) {

            if (null == wsid) {
                wsid = "";
            }
            String ajaxUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(MyShelf.Mode_AJAX).toString() + "?wsid=" + wsid + "&mode=tile";

            String wptitle = wpage.getDisplayName(usr.getLanguage());
            SWBResourceURL urladd = paramRequest.getActionUrl();
            urladd.setAction(SWBResourceURL.Action_ADD);
            HashMap<String, SemanticClass> hmscdocs = new HashMap<String, SemanticClass>();
            HashMap<String, SemanticClass> hmsctile = new HashMap<String, SemanticClass>();
            Iterator<SemanticClass> itsc = Document.conorg_Document.listSubClasses();
            while (itsc.hasNext()) {
                SemanticClass sc = itsc.next();
                hmscdocs.put(sc.getURI(), sc);
            }
            itsc = Tile.conorg_Tile.listSubClasses();
            while (itsc.hasNext()) {
                SemanticClass sc = itsc.next();
                if (hmscdocs.get(sc.getURI()) == null && !sc.getURI().equals(Document.conorg_Document.getURI())) {
                    hmsctile.put(sc.getURI(), sc);
                }
                //out.println(sc.getClassCodeName()+", "+sc.getName()+", "+sc.getDisplayName("es")+"<br/>"); 
            }
        %>         
        <script type="text/javascript">
            <!--

            function enviar(valor) {
                //alert("onsubmit("+encodeURI(valor)+")");
                var objd=dijit.byId(encodeURI(valor));
                if(objd.validate())
                {
                    return true;
                }else {
                    alert("Datos incompletos o erroneos");
                }
                return false;
            }
                
            function loadForm(urlval){
                getHtml(urlval, "mgrform",true, true);
            }
    
            -->
        </script>
        <form  id="form1sc" name="form1ct" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
            <label for="">Tipo de elemento tile(azulejo) a añadir:</label>
            <select name="sclass" onchange="loadForm('<%=ajaxUrl%>&classid='+this.value)" >
                <option value="-1">Selecciona....</option>
                <optgroup title="Documento" label="Documento">
                    <%
                        itsc = hmscdocs.values().iterator();
                        while (itsc.hasNext()) {
                            SemanticClass sc = itsc.next();
                    %>
                    <option value="<%=sc.getEncodedURI()%>"><%=sc.getDisplayName("es")%></option>
                    <%
                        }
                    %>
                </optgroup>
                <%
                    itsc = hmsctile.values().iterator();
                    while (itsc.hasNext()) {
                        SemanticClass sc = itsc.next();
                %>
                <option value="<%=sc.getEncodedURI()%>"><%=sc.getDisplayName("es")%></option>
                <%
                    }
                %>
            </select>
        </form>
        <div id="classform">
            <span id="mgrform">
                &nbsp;
            </span>
        </div>
        <%
        } else if (action.equals(SWBResourceURL.Action_ADD) && actType.equals("workspace")) {

            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(suri);
            out.println("<h4>" + MyShelf.getTileTypeName((Tile) (so.createGenericInstance())) + "</h4>");

            SWBResourceURL urlupdate = paramRequest.getActionUrl();
            urlupdate.setAction(SWBResourceURL.Action_EDIT);
            urlupdate.setMode(SWBResourceURL.Mode_VIEW);
            urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);


            SWBFormMgr frmgr = new SWBFormMgr(so, null, SWBFormMgr.MODE_EDIT);


            frmgr.addHiddenParameter("id", suri);
            if (null != wsid) {
                frmgr.addHiddenParameter("wsid", wsid);
            }
            //frmgr.setType(SWBFormMgr.TYPE_DOJO);
            frmgr.setAction(urlupdate.toString());
            frmgr.setLang("es");

            //frmgr.setOnSubmit("enviar('" + suri + "/form');");
            String boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Cancelar</button>";
            frmgr.addButton(boton);
            //frmgr.addButton(SWBFormButton.newCancelButton());
            boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\">Guardar</button>";
            frmgr.addButton(boton);
            //frmgr.addButton(SWBFormButton.newSaveButton());
%>        
        <%=frmgr.renderForm(request)%>  
        <%


        } else if (action.equals(SWBResourceURL.Action_EDIT)) {
            String id = request.getParameter("id");
            //String suri = request.getParameter("suri");
            //wsid = request.getParameter("wsid");

            //System.out.println("EDIT:" + id);
            String wptitle = wpage.getDisplayName(usr.getLanguage());
            SWBResourceURL urladd = paramRequest.getActionUrl();
            urladd.setAction(SWBResourceURL.Action_EDIT);

            //Tile tile = Tile.ClassMgr.getTile(id, wsite);

        %>  
        <script type="text/javascript">
            <!--
            

            function enviar() {
                var objd=dijit.byId('form2ct');

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

        <%
            //<h3>< %=wptitle% ></h3>

            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(suri);
            out.println("<h4>" + MyShelf.getTileTypeName((Tile) (so.createGenericInstance())) + "</h4>");
            if (so != null) {
                SWBResourceURL urlupdate = paramRequest.getActionUrl();
                urlupdate.setAction(SWBResourceURL.Action_EDIT);
                urlupdate.setMode(SWBResourceURL.Mode_VIEW);
                urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);

                String editMode = SWBFormMgr.MODE_VIEW;
                Tile tile = (Tile) (so.createGenericInstance());
                if(tile.getCreator()!=null&&tile.getCreator().equals(usr)){
                    editMode = SWBFormMgr.MODE_EDIT;
                }
                

                SWBFormMgr frmgr = new SWBFormMgr(so, null, editMode);

                GenericObject go = so.createGenericInstance();
                
                frmgr.clearProperties();
                if(go instanceof Tile){
                    frmgr.addProperty(Descriptiveable.swb_title);
                    frmgr.addProperty(Descriptiveable.swb_description);
                    frmgr.addProperty(Tagable.swb_tags);
                    frmgr.addProperty(Topicable.conorg_hasTopic); 
                }
                
                if(go instanceof Document){
                    frmgr.addProperty(Document.conorg_documentAbstract);
                    frmgr.addProperty(Document.conorg_documentCity);
                    frmgr.addProperty(Document.conorg_documentCountry);
                    frmgr.addProperty(Document.conorg_documentEdition);
                    frmgr.addProperty(Document.conorg_documentFormat);
                    frmgr.addProperty(Document.conorg_documentPages);
                    frmgr.addProperty(Document.conorg_documentPublisher);
                    frmgr.addProperty(Document.conorg_documentURL);
                    frmgr.addProperty(Document.conorg_documentYear);
                   
                }
                
                if(go instanceof Contact){
                    frmgr.addProperty(Contact.conorg_contactAddress);
                    frmgr.addProperty(Contact.conorg_contactDegree);
                    frmgr.addProperty(Contact.conorg_contactEmail);
                    frmgr.addProperty(Contact.conorg_contactExperienceArea);
                    frmgr.addProperty(Contact.conorg_contactFirstName);
                    frmgr.addProperty(Contact.conorg_contactHomePhone);
                    frmgr.addProperty(Contact.conorg_contactLastName);
                    frmgr.addProperty(Contact.conorg_contactMobilePhone);
                    frmgr.addProperty(Contact.conorg_contactOfficePhone);
                    frmgr.addProperty(Contact.conorg_contactOrganization);
                    frmgr.addProperty(Contact.conorg_contactOrganizationArea); 
                    frmgr.addProperty(Contact.conorg_contactOrganizationPosition);
                    frmgr.addProperty(Contact.conorg_contactSocialNetworkId);
                    frmgr.addProperty(Contact.conorg_contactURL);
                }
                
                if(go instanceof URL){
                    frmgr.addProperty(URL.conorg_url);
                }
                
                if(go instanceof Article){
                    frmgr.addProperty(Article.conorg_articleISSN);
                    frmgr.addProperty(Article.conorg_articleIssue);
                    frmgr.addProperty(Article.conorg_articleJournal);
                    frmgr.addProperty(Article.conorg_articleNumber );
                    frmgr.addProperty(Article.conorg_articleVolume );
                }
                
                if(go instanceof ChapterBook){
                    frmgr.addProperty(ChapterBook.conorg_chaptherBookTitle );
                }
                
                if(go instanceof Image){
                    frmgr.addProperty(Image.conorg_imageRights );
                }
                
                if(go instanceof Manual){
                    frmgr.addProperty(Manual.conorg_manualVersion );
                }
                
                if(go instanceof Presentation){
                    frmgr.addProperty(Presentation.conorg_presentationVersion );
                }
                
                if(go instanceof Report){
                    frmgr.addProperty(Report.conorg_reportVersion );
                }
                
                if(go instanceof Video){
                    frmgr.addProperty(Video.conorg_videoRights );
                }
                
                
                
                HashMap<PropertyGroup, TreeSet> hmgroup = frmgr.getGroups();
                Iterator<PropertyGroup> itpg = hmgroup.keySet().iterator();

                while (itpg.hasNext()) {
                    PropertyGroup pg = itpg.next();
                    out.println(pg.getId() + "<br/>");
                }


                frmgr.addHiddenParameter("id", suri);
                if (null != wsid) {
                    frmgr.addHiddenParameter("wsid", wsid);
                }
                //frmgr.setType(SWBFormMgr.TYPE_DOJO);
                frmgr.setAction(urlupdate.toString());
                frmgr.setLang("es");

                //frmgr.setOnSubmit("enviar('" + suri + "/form');");
                String boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Cancelar</button>";
                if(editMode.equals(SWBFormMgr.MODE_VIEW)){
                    boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Regresar</button>";
                }
                frmgr.addButton(boton);
                //frmgr.addButton(SWBFormButton.newCancelButton());
                if(editMode.equals(SWBFormMgr.MODE_EDIT)){
                boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\">Guardar</button>";
                frmgr.addButton(boton);
}
        %>        
        <%=frmgr.renderForm(request)%>  
        <%

            if (so.createGenericInstance() instanceof Versionable) {
                out.println("<h3>Archivo asociado:</h3>");
                Document doc = null;
                VersionInfo vl = null;
                VersionInfo ver = null;

                go = so.createGenericInstance();
                if (go instanceof Document) {
                    doc = (Document) go;
                }

                if (doc != null) {  //Es documento y versionable
                    //revisando si existe archivo asociado                            
                    vl = doc.getLastVersion();

                    if (null != vl) {
                        ver = vl;
                        while (ver.getPreviousVersion() != null) { //
                            ver = ver.getPreviousVersion();
                        }
                    }
                    if (ver != null) {
                        out.println("<div id=\"ProcessFileRepository\">");
                        out.println("<table width=\"100%\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<td align=\"right\">");
                        out.println("Archivo:");
                        out.println("</td>");
                        out.println("<td>");
                        out.println(ver.getVersionFile());
                        out.println("</td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<th>");
                        out.println("&nbsp;");// espacio para liga ver archivo
                        out.println("</th>");
                        out.println("<th>");
                        out.println("Versión");
                        out.println("</th>");
                        out.println("<th>");
                        out.println("Fecha versión");
                        out.println("</th>");
                        out.println("<th>");
                        out.println("Actualizado por");
                        out.println("</th>");
                        out.println("<th>");
                        out.println("Comentario");
                        out.println("</th>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        while (ver != null) {
                            //lista de las versiones del archivo

                            out.println("<tr>");
                            out.println("<td align=\"center\" >");

                            String file = "";
                            String type = "";

                            if (ver != null && ver.getVersionFile() != null) {
                                file = ver.getVersionFile();
                                type = MyShelf.getFileName(file);
                            }


                            if (luser > 0) {
                                SWBResourceURL urlview = paramRequest.getRenderUrl();
                                urlview.setCallMethod(SWBResourceURL.Call_DIRECT);
                                urlview.setParameter("fid", doc.getURI());
                                urlview.setMode(MyShelf.MODE_GETFILE);
                                urlview.setParameter("verNum", "" + ver.getVersionNumber());

                                out.println("<a href=\"" + urlview + "\">");
                                out.println("<img border=0 src='" + path + "" + type + "' alt=\"" + MyShelf.getFileType(file) + "\" />");
                                out.println("</a>");
                            } else {
                                out.println("<img border=0 src='" + path + "" + type + "' alt=\"" + MyShelf.getFileType(file) + "\" />");
                            }

                            out.println("</td>");
                            out.println("<td align=\"center\">");
                            out.println(ver.getVersionValue());
                            out.println("</td>");
                            out.println("<td>");
                            out.println(ver.getCreated() != null ? MyShelf.format.format(ver.getCreated()) : "--");
                            out.println("</td>");
                            out.println("<td>");
                            out.println(ver.getCreator() != null ? ver.getCreator().getFullName() : "--");

                            out.println("</td>");
                            out.println("<td>");
                            out.println(ver.getVersionComment() != null ? ver.getVersionComment() : "--");

                            out.println("</td>");
                            out.println("</tr>");

                            ver = ver.getNextVersion();

                        }
                        out.println("</tbody>");
                        out.println("</table>");
                        out.println("</div>");
                    }

                    //No hay archivo asociado al registro; se debe de mostrar forma de captura de archivo

                    SWBResourceURL urlnew = paramRequest.getActionUrl();
                    urlnew.setAction("newfile");
                    urlnew.setParameter("id", doc.getURI());
                    urlnew.setParameter("act", "newfile");
                    if (null != wsid) {
                        urlnew.setParameter("wsid", wsid);
                    }

                    out.println("<script type=\"text/javascript\" >");
                    out.println("function valida() ");
                    out.println("{ ");
                    out.println("   if(document.frmnewdoc.ffile.value=='') ");
                    out.println("     { ");
                    out.println("         alert('Defina un archivo'); ");
                    out.println("         return; ");
                    out.println("     } ");

                    if (null != vl) {
                        out.println("   var filename = document.frmnewdoc.ffile.value;");
                        out.println("   if(filename.indexOf('" + vl.getVersionFile() + "')==-1) ");
                        out.println("     { ");
                        out.println("         alert('Archivo seleccionado inválido. Debe ser " + vl.getVersionFile() + "'); ");
                        out.println("         return; ");
                        out.println("     } ");
                    }

                    out.println("   document.frmnewdoc.submit();");
                    out.println("} ");
                    out.println("</script>");

                    out.println("<div id=\"ProcessFile\">");
                    out.println("<form id=\"frmnewdoc\" name=\"frmnewdoc\" method=\"post\" action=\"" + urlnew + "\"  enctype=\"multipart/form-data\" onsubmit=\"valida();return false;\">");
                    out.println("<input type=\"hidden\" name=\"fid\" value=\"" + doc.getURI() + "\">");

                    out.println("<table>");
                    out.println("<tbody>");
                    out.println("<tr>");
                    out.println("<td align=\"right\">");
                    out.println("Comentario:");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<textarea name=\"fcomment\"></textarea>");
                    out.println("</td>");
                    //out.println("</tr>");

                    //out.println("<tr>");
                    out.println("<td align=\"right\">");
                    out.println("Archivo:");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"file\" name=\"ffile\">");
                    out.println("</td>");
                    out.println("<td colspan=\"2\" align=\"right\">");
                    out.println("<button type=\"submit\" >Agregar</button>");
                    out.println("</td>");
                    out.println("</tr>");

                    out.println("</tbody>");
                    //out.println("<tfoot>");
                    //out.println("<tr>");
                    //out.println("<td colspan=\"2\" align=\"right\">");
                    //out.println("<button type=\"submit\" >Agregar</button>");
                    //out.println("</td>");
                    //out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    out.println("</form>");
                    out.println("</div>");
                }
            }

            if (so.createGenericInstance() instanceof Tile) {

                tile = (Tile) so.createGenericInstance();
                String fcreated = (tile.getCreated() != null ? sdf.format(tile.getCreated()) : "---");
                String fcreator = (tile.getCreator() != null && tile.getCreator().getFullName() != null ? tile.getCreator().getFullName() : "---");
                String fmod = (tile.getUpdated() != null ? sdf.format(tile.getUpdated()) : "---");
                String fusrmod = (tile.getModifiedBy() != null && tile.getModifiedBy().getFullName() != null ? tile.getModifiedBy().getFullName() : "---");
        %>
        <p>Creado:     <%=fcreated%>  por <%=fcreator%></p>
        <p>Modificado: <%=fmod%>  por <%=fusrmod%></p> 
        <%
            }
            if (tile instanceof Mosaic) {
                String addtiurl = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD).toString();
                SWBResourceURL urlrem = paramRequest.getActionUrl();
                urlrem.setAction("remTile");
                urlrem.setParameter("id", tile.getId());
                urlrem.setParameter("suri", tile.getURI());
                if (request.getParameter("wsid") != null) {
                    urlrem.setParameter("wsid", request.getParameter("wsid"));
                }
                urlrem.setParameter("msid", "");
        %>
        <form  id="formmos" name="formmos" method="post" dojoType="dijit.form.Form" action="<%=addtiurl%>">
            <%
                if (request.getParameter("wsid") != null) {
            %>
            <input type="hidden" name="wsid" value="<%=request.getParameter("wsid")%>"/>
            <%
                }
            %>
            <input type="hidden" name="suri" value="<%=tile.getURI()%>"/>
            <input type="hidden" name="msid" value=""/>

            <label for="">Tile(azulejo) del estante a añadir:</label>
            <select name="tiid">
                <option value="-1">Selecciona....</option>
                <%
                    Iterator<Tile> itti = shelf.listTiles();
                    while (itti.hasNext()) {
                        Tile ltile = itti.next();
                        if (!ltile.equals(tile)) {
                %>
                <option value="<%=ltile.getURI()%>"><%=ltile.getTitle()%></option>
                <%
                        }
                    }
                %>
            </select>
            <button dojoType="dijit.form.Button" type="submit">Agregar</button>
        </form>
        <div id="classform">
            <span id="mgrform">
                &nbsp;
            </span>
        </div>
        <table class="conorg-table estante-vista">
            <thead>
                <tr>
                    <th class="titulo" >Título</th>
                    <th class="fecha" >Fecha</th>
                    <th class="tipo" >Tipo</th>
                    <th class="tema" >Tema</th>
                    <th class="accion">&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <%

                    Mosaic mosaic = (Mosaic) tile;
                    if (SWBUtils.Collections.sizeOf(mosaic.listTiles()) == 0) {
                %>
                <tr >
                    <td colspan="6" >No se encontraron registros</td>
                </tr>
                <%} else {
                    Iterator<Tile> itmt = mosaic.listTiles();
                    while (itmt.hasNext()) {
                        Tile ltile = itmt.next();
                        String strTitle = "<center>---</center>";
                        String strDate = "<center>---</center>";
                        String strType = "<center>---</center>";
                        String strTopic = "<center>---</center>";
                        if (ltile.getDisplayTitle("es") != null) {
                            strTitle = ltile.getDisplayTitle("es");
                        }
                        if (ltile.getCreated() != null) {
                            strDate = sdf.format(ltile.getCreated());
                        }
                        if (ltile.listTopics().hasNext()) {
                            strTopic = "";
                            Iterator<Topic> ittopic = ltile.listTopics();
                            while (ittopic.hasNext()) {
                                Topic topic = ittopic.next();
                                if (null != topic) {
                                    strTopic = strTopic + topic.getTitle();
                                }
                                if (ittopic.hasNext()) {
                                    strTopic = strTopic + ", ";
                                }
                            }
                        }
                        urlrem.setParameter("tiid", ltile.getURI());
                %>
                <tr>
                    <td class="<%=MyShelf.getClassIconTile(ltile)%>"><%=strTitle%></td>
                    <td><%=strDate%></td>
                    <td><%=strType%></td>
                    <td><%=strTopic%></td>
                    <td>
                        <span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urlrem%>';} else return false;">B&nbsp;</a></span>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <%
                }
            }
        } else if (action.equals("share")) {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(suri);
            //out.println("<h4>" + MyShelf.getTileTypeName((Tile) (so.createGenericInstance())) + "</h4>");
            Tile tile = so!=null&&so.createGenericInstance() instanceof Tile?(Tile)so.createGenericInstance():null; 
            if (null != tile) {
                // membresias del usuario a los diferentes ws
                Iterator<Member> itmem = Member.ClassMgr.listMemberByUser(usr, wsite);
                HashMap<WorkSpace, Member> hmmem = new HashMap<WorkSpace, Member>();

                while (itmem.hasNext()) {
                    Member wsmember = itmem.next();
                    WorkSpace wspace = wsmember.getWorkspace();
                    if (wspace != null && wsmember.getUser() != null && usr.equals(wsmember.getUser())) {
                        //System.out.println(wsmember.getMemberType()+" de: "+wsmember.getWorkspace().getTitle());
                        int usrlevel = MyShelf.getLevelMember(wsmember);
                        if (usrlevel > 0) {  //MyShelf.USRLEVEL_NO_MIEMBRO 
                            hmmem.put(wspace, wsmember);

                            //if (!wspace.hasMember(wsmember)) {
                            //    wspace.addMember(wsmember);
                            //}
                        }
                    }
                }
                String strtitle = tile.getTitle() != null ? tile.getTitle() : "Sín título";
                String strdesc = tile.getDescription() != null ? tile.getDescription() : "---";

        %>
        <div> <h3>Compartir azulejo</h3>
            <div>
                <%
                    SWBResourceURL urlback = paramRequest.getRenderUrl();
                    urlback.setParameter("act", "");

                    Colleague colleague = Colleague.ClassMgr.getColleague(usr.getId(), wsite);
                    Iterator<User> itcol = colleague.listColleagueses();
                    
                    
                    Iterator<WorkSpace> itwspace = hmmem.keySet().iterator();
                    if (itwspace.hasNext() || itcol.hasNext()) {
                        SWBResourceURL urlshare = paramRequest.getActionUrl();
                        urlshare.setAction("share");
                        urlshare.setParameter("act", "share");
                        

                %>
                <script type="text/javascript">
                    function shareSelect(forma){
                       
                        var valid = false; 
                        var valid1 = false; 
                        var hayws = false;
                        var valid2 = false;
                        var haycol = false;
                        <%
                        // validación si existen workspaces
                        if(itwspace.hasNext()){
                        %>
                            hayws = true;
                            for(var i = 0; i < forma.workspaceid.options.length; i++) {  
                                if(forma.workspaceid.options[i].selected) {  
                                    valid1 = true;  
                                    break;  
                                }  
                            }  
                        <%
                        }
                        // validación si existen colegas
                        if(itcol.hasNext()){
                        %>
                            haycol = true;
                            for(var i = 0; i < forma.contactid.options.length; i++) {  
                                if(forma.contactid.options[i].selected) {  
                                    valid2 = true;  
                                    break;  
                                }  
                            }
                        <%
                        }
                        %>
                        if(valid1 || valid2){
                            valid = true;
                        } else {
                            if(!valid1&&hayws){
                                alert('Debes de seleccionar por lo menos un Espacio de trabajo para poder compartir.');                                
                            }
                            if(!valid2&&haycol){
                                alert('Debes de seleccionar por lo menos un colega para poder compartir.');                                
                            }
                            valid = false;
                        }
                        
                        return valid;  
 

                    }
                </script>
                <form method="post" action="<%=urlshare%>" onsubmit="shareSelect(this);">
                    <input type="hidden" name="tileuri" value="<%=suri%>">
                    <table>
                        <tr>
                            <td >Título: </td>
                            <td class="<%=MyShelf.getClassIconTile(tile)%>"><%=strtitle%></td>
                            
                        </tr>
                        <tr>
                            <td>Descripción:</td>
                            <td><%=strdesc%></td>
                            
                        </tr>
                        <tr>
                            <td><label for="workspaceid">Espacios de trabajo:</label></td>
                            <td>
                                <select name="workspaceid" multiple size="5">
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
                                <select name="contactid" multiple size="5">
                                    <%
                                    
                                        while (itcol.hasNext()) {
                                            User usrcol = itcol.next();
                                    %>
                                    <option value="<%=usrcol.getId()%>"><%=usrcol.getFullName()%></option> 
                                    <%
                                        } 
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button dojoType="dijit.form.Button" type="button" onclick="window.location='<%=urlback%>';return false;">Cancelar</button>
                                <button dojoType="dijit.form.Button" type="submit" >Compartir</button>
                            </td>
                        </tr>
                    </table>
                </form>
                <%
                } else {

                %>
                <p>No cuentas con espacios de trabajo para compartir y no tienes colegas en tu directorio.</p>
                <button dojoType="dijit.form.Button" type="button">Regresar</button>
                <%                                }
                %>
            </div>
        </div>    
        <%

                }
            }
        %>

    </div>
</div>
<%

    }
%>

