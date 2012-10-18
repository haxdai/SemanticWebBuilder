<%--
    Document   : view Recurso SearchTiles
    Created on : 17/10/2012
    Author     : juan.fernandez
--%>
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
<%@page import="com.infotec.conorg.Topic"%>
<%@page import="com.infotec.conorg.Video"%>
<%@page import="com.infotec.conorg.Report"%>
<%@page import="com.infotec.conorg.Reference"%>
<%@page import="com.infotec.conorg.Presentation"%>
<%@page import="com.infotec.conorg.Document"%>
<%@page import="com.infotec.conorg.Manual"%>
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<jsp:useBean id="res" scope="request" type="com.infotec.conorg.resources.SearchTiles" />

<%

    // res = resource de tipo SearchTiles
    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;
    Resource base = paramRequest.getResourceBase();
    String path = SWBPlatform.getContextPath() + "/swbadmin/images/repositoryfile/";

    int luser = 1;

    Shelf shelf = null;
    WorkSpace workSpace = null;
    long intSize = SWBUtils.Collections.sizeOf(shelf.listTiles());

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

    if (action == null) {
        action = "";
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));

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
    <div id="conorg">
        <div id="conorg-data">
            <%
                if (action.equals("")) {

                    WebPage wpconfig = wsite.getWebPage(base.getAttribute("wpshelf",wpage.getId()));
                    
                    SWBResourceURLImp urladd = new SWBResourceURLImp(request,base,wpconfig,SWBResourceURLImp.UrlType_RENDER);
                    
                    
                    
                    //SWBResourceURL urladd = paramRequest.getRenderUrl();
                    urladd.setParameter("act", SWBResourceURL.Action_ADD);

            %>

            <div id="conorg-add">
                <form action="<%=urladd%>" method="post">
                    <input type="submit" id="addButton" name="addButton" value="Añadir Elemento" />
                </form>
            </div>

            <table class="conorg-table">

                <thead>
                    <tr>
                        <th width="7%" >&nbsp;</th>
                        <th width="25%" >Título</th>
                        <th width="25%" >Fecha</th>
                        <th width="20%" >Tipo</th>
                        <th width="23%" >Tema</th>
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

                        int numele = 5;
                        try {
                            numele = Integer.parseInt(base.getAttribute("numele"));
                        } catch (Exception e) {
                        }
                        int numtiles = 0;
                        
                        //Iterator<GradoAcademico> itcec = itga.iterator();
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

                            strType = getTileTypeName(tile);

                            SWBResourceURL urldel = paramRequest.getActionUrl();
                            urldel.setAction(SWBResourceURL.Action_REMOVE);
                            urldel.setParameter("id", tile.getId());
                            urldel.setParameter("suri", tile.getURI());

                            SWBResourceURL urledit = paramRequest.getRenderUrl();
                            urledit.setParameter("act", SWBResourceURL.Action_EDIT);
                            urledit.setParameter("id", tile.getId());
                            urledit.setParameter("suri", tile.getURI());
                    %>
                    <tr>
                        <td>
                            <span class="icv-borrar"><a href="#" title="Borrar" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">B&nbsp;</a></span>
                            <span class="icv-editar"><a href="#" title="Editar" onclick="window.location='<%=urledit%>';">E&nbsp;</a></span></td>
                        <td><%=strTitle%></td>
                        <td><%=strDate%></td>
                        <td><%=strType%></td>
                        <td><%=strTopic%></td>

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


                    %>
                </p></div>

            <%
            } else if (action.equals(SWBResourceURL.Action_ADD)) {

                String ajaxUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(MyShelf.Mode_AJAX).toString();

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
                dojo.require("dijit.layout.ContentPane");
                dojo.require("dijit.form.Form");
                dojo.require("dijit.form.ValidationTextBox");
                dojo.require("dijit.form.Button");
                dojo.require("dijit.form.NumberTextBox");

                function enviar(valor) {
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
            <h3><%=wptitle%></h3>
            <form  id="form1sc" name="form1ct" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
                <label for="">Tipo de elemento azulejo (tile) a añadir:</label>
                <select name="sclass" onchange="loadForm('<%=ajaxUrl%>?classid='+this.value)" >
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
            } 
            %>
        </div><!-- icv-data -->  
    </div>
</div>

<%!
    public String getTileTypeName(Tile tile) {

        String ret = "Azulejo";
        if (tile instanceof Contact) {
            ret = "Contacto";
        } else if (tile instanceof Mosaic) {
            ret = "Mosaico";
        } else if (tile instanceof com.infotec.conorg.Resource) {
            ret = "Recurso";
        } else if (tile instanceof URL) {
            ret = "URL";
        } else if (tile instanceof Article) {
            ret = "Articulo";
        } else if (tile instanceof Audio) {
            ret = "Audio";
        } else if (tile instanceof Book) {
            ret = "Libro";
        } else if (tile instanceof ChapterBook) {
            ret = "Capitulo";
        } else if (tile instanceof Image) {
            ret = "Imagen";
        } else if (tile instanceof Manual) {
            ret = "Manual";
        } else if (tile instanceof Presentation) {
            ret = "Presentación";
        } else if (tile instanceof Reference) {
            ret = "Referencia";
        } else if (tile instanceof Report) {
            ret = "Reporte";
        } else if (tile instanceof Video) {
            ret = "Video";
        } else if (tile instanceof Document) {
            ret = "Documento";
        }
        return ret;
    }

%>