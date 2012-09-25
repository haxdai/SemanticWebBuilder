<%--
    Document   : view Recurso MyShelf
    Created on : 19/06/2012
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

<%

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;
    Resource base = paramRequest.getResourceBase();
    String path = SWBPlatform.getContextPath() + "/swbadmin/images/repositoryfile/";

    int luser = 1;

    String confClass = base.getAttribute(MyShelf.RES_CONF, "http://www.infotec.com/conorg.owl#Shelf");

    boolean isShelf = Boolean.FALSE;

    if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
        isShelf = Boolean.TRUE;
    } else if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
        isShelf = Boolean.FALSE;
    }

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
    } else {
        //intSize = WorkSpace.ClassMgr.l
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

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));


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
            } else if (action.equals(SWBResourceURL.Action_EDIT)) {
                String id = request.getParameter("id");
                String suri = request.getParameter("suri");

                System.out.println("EDIT:" + id);
                String wptitle = wpage.getDisplayName(usr.getLanguage());
                SWBResourceURL urladd = paramRequest.getActionUrl();
                urladd.setAction(SWBResourceURL.Action_EDIT);

                //Tile tile = Tile.ClassMgr.getTile(id, wsite);

            %>  
            <script type="text/javascript">
                <!--
                dojo.require("dijit.layout.ContentPane");
                dojo.require("dijit.form.Form");
                dojo.require("dijit.form.ValidationTextBox");
                dojo.require("dijit.form.Button");
                dojo.require("dijit.form.NumberTextBox");

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
            <h3><%=wptitle%></h3>
            <%

                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                SemanticObject so = ont.getSemanticObject(suri);
                out.println("<h4>" + getTileTypeName((Tile) (so.createGenericInstance())) + "</h4>");
                if (so != null) {
                    SWBResourceURL urlupdate = paramRequest.getActionUrl();
                    urlupdate.setAction(SWBResourceURL.Action_EDIT);
                    urlupdate.setMode(SWBResourceURL.Mode_VIEW);
                    urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);


                    SWBFormMgr frmgr = new SWBFormMgr(so, null, SWBFormMgr.MODE_EDIT);


                    frmgr.addProperty(VersionInfo.swb_versionComment);
                    frmgr.addProperty(VersionInfo.swb_versionFile);

                    frmgr.addHiddenParameter("id", suri);

                    frmgr.setType(SWBFormMgr.TYPE_DOJO);
                    frmgr.setAction(urlupdate.toString());
                    frmgr.setLang("es");

                    //frmgr.setOnSubmit("enviar('" + suri + "/form');");
                    String boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + "';return false;\">Cancelar</button>";
                    frmgr.addButton(boton);
                    frmgr.addButton(SWBFormButton.newSaveButton());
            %>        
            <%=frmgr.renderForm(request)%>  
            <%
                    }
                    if (so.createGenericInstance() instanceof Versionable) {
                        out.println("<h1>Archivo asociado:</h1>");
                        Document doc = null;
                        VersionInfo vl = null;
                        VersionInfo ver = null;

                        GenericObject go = so.createGenericInstance();
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
                                out.println("Creado por");
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
                                        urlview.setParameter("fid", doc.getId());
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


                            if (vl != null) {
                                //No hay archivo asociado al registro; se debe de mostrar forma de captura de archivo

                                SWBResourceURL urlnew = paramRequest.getActionUrl();
                                urlnew.setAction("newfile");
                                urlnew.setParameter("id", doc.getURI());
                                urlnew.setParameter("act", "newfile");

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
                                out.println("</tr>");

                                out.println("<tr>");
                                out.println("<td align=\"right\">");
                                out.println("Archivo:");
                                out.println("</td>");
                                out.println("<td>");
                                out.println("<input type=\"file\" name=\"ffile\">");
                                out.println("</td>");
                                out.println("</tr>");

                                out.println("</tbody>");
                                out.println("<tfoot>");
                                out.println("<tr>");
                                out.println("<td colspan=\"2\" align=\"right\">");
                                out.println("<button type=\"submit\" >Agregar</button>");
                                out.println("</td>");
                                out.println("</tr>");
                                out.println("</tbody>");
                                out.println("</table>");
                                out.println("</form>");
                                out.println("</div>");

                            }
                        }


                    }
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