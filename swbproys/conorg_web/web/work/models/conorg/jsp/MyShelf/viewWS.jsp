<%--   
Document   : view WorkSpaces recurso MyShelf
Created on : 19/06/2012
Author     : juan.fernandez y rene.jara
--%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="com.infotec.conorg.resources.MyShelf"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="com.infotec.conorg.*"%>
<%@page import="com.infotec.conorg.Topic"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    org.semanticwb.model.Resource base = paramRequest.getResourceBase();
    WebPage wpwscontent = wsite.getWebPage(base.getAttribute("wpworkspace", wpage.getId()));
    int nummem;
    int numtil;
    String wsid = request.getParameter("wsid");
    String confClass = base.getAttribute(MyShelf.RES_CONF, "http://www.infotec.com/conorg.owl#Shelf");
    String path = SWBPlatform.getContextPath() + "/swbadmin/images/repositoryfile/";

    String actType = request.getParameter("type");
    if (null == actType) {
        actType = "";
    }

    int luser = 1;
    boolean isShelf = Boolean.FALSE;

    if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
        isShelf = Boolean.TRUE;
    } else if (confClass.equals(WorkSpace.conorg_WorkSpace.getURI())) {
        isShelf = Boolean.FALSE;
    }

    long intSize = 0;

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

    //SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm a", new Locale("es"));


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

</script>
<%

    ArrayList alwsp = null;
    Iterator<WorkSpace> itperws = null;
    Iterator<WorkSpace> itpubws = null;

    Role rol = wsite.getUserRepository().getRole(base.getAttribute(MyShelf.ROL_ADMIN_ATRIBUTTE, "0"));
    WebPage wpconfig = wsite.getWebPage(base.getAttribute("wpworkspace", wpage.getId()));
    if (usr.hasRole(rol)) {


        SWBResourceURLImp urladd = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
        urladd.setParameter("act", SWBResourceURL.Action_ADD);
        urladd.setParameter("type", "addworkspace");
        //if (request.getParameter("wsid") != null) {
        //    urladd.setParameter("wsid", request.getParameter("wsid"));
        //}

%>



<div id="conorg-add">
    <form dojoType="dijit.form.Form" action="<%=urladd%>" method="post"> 
        <button dojoType="dijit.form.Button" type="submit" name="addButton" >Añadir Espacio de trabajo</button>
    </form>
</div>
<%
    if (action.equals(SWBResourceURL.Action_ADD) && actType.equals("addworkspace")) { //

        SWBResourceURL urlupdate = paramRequest.getActionUrl();
        urlupdate.setAction(SWBResourceURL.Action_ADD);
        urlupdate.setMode(SWBResourceURL.Mode_VIEW);
        urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);
        SWBFormMgr frmgr = new SWBFormMgr(WorkSpace.conorg_WorkSpace, wsite.getSemanticObject().getModel().getModelObject(), SWBFormMgr.MODE_CREATE);
        frmgr.addHiddenParameter("classid", WorkSpace.conorg_WorkSpace.getURI());
        //frmgr.setType(SWBFormMgr.TYPE_DOJO);
        frmgr.setAction(urlupdate.toString());
        frmgr.setLang("es");
        String boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Cancelar</button>";
        frmgr.addButton(boton);
        boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\" >Guardar</button>";
        frmgr.addButton(boton);
        //frmgr.addButton(SWBFormButton.newSaveButton());
%>        
<%=frmgr.renderForm(request)%>  
<%

        }
    }
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
                if (!wspace.hasMember(wsmember)) {
                    wspace.addMember(wsmember);
                }
            }
        } else {
            //System.out.println("Miembro sin WS ...");
        }
    }
    // no hay ws seleccionado, muestra lista de ws por miembro
    if ((wsid == null || wsid.equals("")) && !actType.equals("addworkspace")) {
        alwsp = new ArrayList();
        String mpage = request.getParameter("mpage");
        String ppage = request.getParameter("ppage");
//System.out.println("mpage:"+mpage+" ppage"+ppage);
        try {
            nummem = Integer.parseInt(base.getAttribute("nummem", "5"));
        } catch (Exception ignored) {
            nummem = 5;
        }
        try {
            numtil = Integer.parseInt(base.getAttribute("numtil", "5"));
        } catch (Exception ignored) {
            numtil = 5;
        }
        itperws = WorkSpace.ClassMgr.listWorkSpaces(wsite);
%>
<div>
    <p class="ws-mios">Mis Espacios de trabajo</p>
    <%
        int ps = numPages;
        long l = 0;// = intSize;
        int p = 0;
        int e = 0;
        if (mpage != null) {
            p = Integer.parseInt(mpage);
        }
        int x = 0;
        while (itperws.hasNext()) {
            WorkSpace workSpace = itperws.next();
            if (hmmem.get(workSpace) != null) { // revisando si es miembro del ws

                alwsp.add(workSpace);
                x++;
                if (x > (ps * p) && !(x > (ps * (p + 1)))) {
    %>
    <div class="workspace-prevista">
        <h3><a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><strong><%=workSpace.getTitle()%></strong></a></h3>
        <p><%=workSpace.getDescription() != null ? workSpace.getDescription() : ""%></p> 
        <ul>
            <li><strong>Temas:</strong>
                <ul>
                    <%
                        Iterator<com.infotec.conorg.Topic> itto = workSpace.listTopics();
                        while (itto.hasNext()) {
                            com.infotec.conorg.Topic topic = itto.next();
                    %>
                    <li><%=topic.getTitle()%></li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <li><strong>Participantes:</strong>
                <ul>
                    <%
                        Iterator<Member> itme = workSpace.listMembers();
                        int count = 0;
                        while (itme.hasNext()) {
                            Member mem = itme.next();
                            count++;
                            if (count <= nummem) {
                    %>
                    <li>
                        <%=mem.getUser().getFullName() + " - " + mem.getMemberType()%>
                    </li>
                    <%
                    } else {
                    %>
                    <li>
                        <a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>">Ver más</a>
                    </li>
                    <%
                                break;
                            }
                        }
                    %>
                </ul>
            </li>
            <li><strong>Azulejos</strong>:
                <ul>
                    <%
                        Iterator<Tile> itti = workSpace.listTiles();
                        count = 0;
                        while (itti.hasNext()) {
                            Tile tile = itti.next();
                            count++;
                            if (count <= numtil) {
                    %>
                    <li>
                        <%=tile.getTitle()%>
                    </li>
                    <%
                    } else {
                    %>
                    <li>
                        <a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>">Ver más</a>
                    </li>
                    <%
                                break;
                            }
                        }
                    %>
                </ul>
            </li>
        </ul>
    </div>

    <%
                } else if (x > (ps * (p + 1))) {
                    e++;
                }
            }
        }
        l = x;
        x -= e;
    %>
</div>
<div class="paginar">
    <p>
        <%
            if ((p > 0 || x < l))// && (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT)) //Requiere paginacion
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
                    urlNext.setParameter("mpage", "" + 0);
                    if (null != wsid) {
                        urlNext.setParameter("wsid", wsid);
                    }
                    if (null != ppage) {
                        urlNext.setParameter("ppage", ppage);
                    }
        %>
        <a href="#" onclick="window.location='<%=urlNext%>';">Ir al inicio</a>
        <%
            }

            for (int z = inicia; z < finaliza; z++) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                urlNext.setParameter("mpage", "" + z);
                if (null != wsid) {
                    urlNext.setParameter("wsid", wsid);
                }
                if (null != ppage) {
                    urlNext.setParameter("ppage", ppage);
                }
                if (z != p) {
        %>
        <a href="#" onclick="window.location='<%=urlNext%>';"><%=(z + 1)%></a>
        <%
        } else {
        %>
        <%=(z + 1) + " "%>
        <%
                }
            }
            if (pages > 10) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                urlNext.setParameter("mpage", "" + (pages - 1));
                if (null != wsid) {
                    urlNext.setParameter("wsid", wsid);
                }
                if (null != ppage) {
                    urlNext.setParameter("ppage", ppage);
                }

        %>
        <a href="#" onclick="window.location='<%=urlNext%>';">Ir al final</a>
        <%
                }
            }
        %>
    </p></div>
    <%
        itpubws = WorkSpace.ClassMgr.listWorkSpaces(wsite);
    %>
<div >
    <p class="ws-otros">Otros Espacios de trabajo</p>
    <%
        //ps = numPages;
        l = 0;// = intSize;
        p = 0;
        e = 0;
        if (ppage != null) {
            p = Integer.parseInt(ppage);
        }
        x = 0;

        // lista de workspace de la comunidad
        while (itpubws.hasNext()) {
            WorkSpace workSpace = itpubws.next();
            if (!alwsp.contains(workSpace)) {
                x++;
                if (x > (ps * p) && !(x > (ps * (p + 1)))) {

    %>
    <div class="workspace-prevista">
        <h3><a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><strong><%=workSpace.getTitle()%></strong></a></h3>
        <p><%=workSpace.getDescription() != null ? workSpace.getDescription() : ""%></p> 
    </div>
    <%
                } else if (x > (ps * (p + 1))) {
                    e++;
                }

            }
        }
        l = x;
        x -= e;
    %>
</div>
<div class="paginar">
    <p>
        <%
            if ((p > 0 || x < l))// && (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT)) //Requiere paginacion
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
                    urlNext.setParameter("ppage", "" + 0);
                    if (null != wsid) {
                        urlNext.setParameter("wsid", wsid);
                    }
                    if (null != mpage) {
                        urlNext.setParameter("mpage", mpage);
                    }

        %>
        <a href="#" onclick="window.location='<%=urlNext%>';">Ir al inicio</a>
        <%
            }

            for (int z = inicia; z < finaliza; z++) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                urlNext.setParameter("ppage", "" + z);
                if (null != wsid) {
                    urlNext.setParameter("wsid", wsid);
                }
                if (null != mpage) {
                    urlNext.setParameter("mpage", mpage);
                }

                if (z != p) {
        %>
        <a href="#" onclick="window.location='<%=urlNext%>';"><%=(z + 1)%></a>
        <%
        } else {
        %>
        <%=(z + 1) + " "%>
        <%
                }
            }
            if (pages > 10) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                urlNext.setParameter("ppage", "" + (pages - 1));
                if (null != wsid) {
                    urlNext.setParameter("wsid", wsid);
                }
                if (null != mpage) {
                    urlNext.setParameter("mpage", mpage);
                }
        %>
        <a href="#" onclick="window.location='<%=urlNext%>';">Ir al final</a>
        <%
                }
            }
        %>
    </p></div>
    <%
    } else if (wsid != null) {    //MOSTRANDO DETALLE DEL ESPACIO DE TRABAJO
        // con wsid != null

        //System.out.println("===================================================================");
        WorkSpace workSpace = WorkSpace.ClassMgr.getWorkSpace(wsid, wsite);

        if (workSpace.getParent() == null) {
            if (!workSpace.isActive()) {
                workSpace.setActive(Boolean.TRUE);
            }
            WebPage wpparent = wsite.getWebPage("workspace");
            if (wpparent != null) {
                workSpace.setParent(wpparent);
            }
        }

        intSize = SWBUtils.Collections.sizeOf(workSpace.listTiles());
        Iterator<Tile> ittil = workSpace.listTiles();

        if (workSpace != null) {
            int usrlevel = 0;

            Member wsmember = hmmem.get(workSpace);
            if (wsmember != null) {
                usrlevel = MyShelf.getLevelMember(wsmember);
            }

            SWBResourceURL urlupdate = paramRequest.getActionUrl();
            urlupdate.setAction(SWBResourceURL.Action_EDIT);
            urlupdate.setMode(SWBResourceURL.Mode_VIEW);
            urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);

            boolean editMode = Boolean.FALSE;
            String formMode = SWBFormMgr.MODE_VIEW;

            if (usrlevel == 4) {
                editMode = Boolean.TRUE;
                formMode = SWBFormMgr.MODE_EDIT;
            }

            SemanticObject so = workSpace.getSemanticObject();
            SemanticClass scls = so.getSemanticClass();

            SWBFormMgr frmgr = new SWBFormMgr(so, formMode, formMode);

            frmgr.clearProperties();
            frmgr.addProperty(Descriptiveable.swb_title);
            frmgr.addProperty(Descriptiveable.swb_description);
            frmgr.addProperty(Tagable.swb_tags);
            //frmgr.addProperty(Activeable.swb_active);
            //frmgr.addProperty(Traceable.swb_created);
            //frmgr.addProperty(Traceable.swb_creator);
            //frmgr.addProperty(Traceable.swb_modifiedBy);
            //frmgr.addProperty(Traceable.swb_updated);
            frmgr.addProperty(WorkSpace.conorg_hasTopic);
            if (null != wsid) {
                frmgr.addHiddenParameter("wsid", wsid);
            }
            //frmgr.setType(SWBFormMgr.TYPE_DOJO);
            frmgr.setAction(urlupdate.toString());
            frmgr.setLang("es");
            String boton = "";

            //if (editMode) {
            //    boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + "';return false;\">Cancelar</button>";
            //    frmgr.addButton(boton);
            //    boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\" >Guardar</button>";
            //    frmgr.addButton(boton); //SWBFormButton.newSaveButton()
            //} else {
            //    boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + "';return false;\">Regresar</button>";
            //    frmgr.addButton(boton);
            //}
            WebPage wp_wiki = wsite.getWebPage(workSpace.getId() + "_wiki");
            WebPage wp_foro = wsite.getWebPage(workSpace.getId() + "_forum");

//revisar nivel de usuario del espacio de trabajo para que pueda activar el wiki o el foro, y nivel de usuario para utilizarlo                  
            if (usrlevel >= 2) {

                if (wp_wiki != null || wp_foro != null || usrlevel >= 3) {
    %>
<div class="wikiforo">
    <%       }
        if (wp_wiki != null) {
    %>  
    <div class="wiki">
        <a href="<%=wp_wiki.getUrl()%>" >Wiki</a>
    </div>
    <%
    } else if (usrlevel >= 3) {
        SWBResourceURL url = null;

        url = paramRequest.getActionUrl();
        url.setParameter("wsid", workSpace.getId());
        url.setAction("addWiki");

    %>
    <div class="wiki">
        <a href="<%=url.toString()%>" >Wiki</a> 
    </div>
    <%
        }
        if (wp_foro != null) {
    %>   
    <div class="foro">
        <a href="<%=wp_foro.getUrl()%>" >Foro</a>
    </div>
    <%
    } else if (usrlevel >= 3) {
        SWBResourceURL urlf = null;
        urlf = paramRequest.getActionUrl();
        urlf.setParameter("wsid", workSpace.getId());
        urlf.setAction("addForo");
    %>
    <div class="foro">     
        <a href="<%=urlf.toString()%>" >Foro</a> 
    </div>
    <%
        }
        if (wp_wiki != null || wp_foro != null || usrlevel >= 3) {
    %>
</div>
<%        }
    }    // nivel de usuario
%>
<form id="<%=so.getURI()%>/form" class="swbform" action="<%=urlupdate.toString()%>" method="post">
    <input type="hidden" name="suri" value="<%=so.getURI()%>"/>
    <input type="hidden" name="scls" value="<%=scls.getURI()%>"/>
    <input type="hidden" name="smode" value="<%=editMode ? "edit" : "view"%>"/>   
    <%
        if (null != wsid) {
    %>
    <input type="hidden" name="wsid" value="<%=wsid%>"/> 
    <%
        }
    %>
    <fieldset >
        <legend></legend>
        <table>
            <%
                HashMap<PropertyGroup, TreeSet> hmgroup = frmgr.getGroups();
                HashMap<String, SemanticProperty> hmorder = new HashMap<String, SemanticProperty>();
                Iterator<PropertyGroup> itpg = hmgroup.keySet().iterator();

                while (itpg.hasNext()) {
                    PropertyGroup pg = itpg.next();

                    //out.println(pg.getId() + "<br/>");
                    Iterator<SemanticProperty> it = hmgroup.get(pg).iterator();
                    while (it.hasNext()) {
                        SemanticProperty prop = it.next();
                        DisplayProperty dp = (DisplayProperty) (prop.getDisplayProperty().createGenericInstance());
                        if (dp != null) {
                            //out.println(dp.getIndex()+ " - "+dp.getPromptMessage());
                            hmorder.put("" + dp.getIndex(), prop);
                        }
                    }
                }

                ArrayList<String> list = new ArrayList(hmorder.keySet());
                Collections.sort(list);
                Iterator<String> itstr = list.iterator();
                while (itstr.hasNext()) {
                    String key = itstr.next();
                    SemanticProperty semprop = hmorder.get(key);
            %>
            <tr><td width="200px" align="right">
                    <%=frmgr.renderLabel(request, semprop, editMode ? SWBFormMgr.MODE_EDIT : SWBFormMgr.MODE_VIEW)%>
                </td><td>
                    <%=frmgr.renderElement(request, semprop, editMode ? SWBFormMgr.MODE_EDIT : SWBFormMgr.MODE_VIEW)%>
                </td></tr>
                <%
                    }
                %>
        </table>
    </fieldset>
    <fieldset><span align="center">
            <%
                if (editMode) {
                    boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + "';return false;\">Cancelar</button>";
                    out.println(boton);
                    boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\" >Guardar</button>";
                    out.println(boton); //SWBFormButton.newSaveButton()
                } else {
                    boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + "';return false;\">Regresar</button>";
                    out.println(boton);
                }


            %>
        </span></fieldset>
</form>
<%//=frmgr.renderForm(request)%>  
<div>
    <div id="participantes<%=wsid%>" dojoType="dijit.TitlePane" title="Participantes" class="admViewProperties" open="false" duration="150" minSize_="20" splitter_="true" region="bottom">
        <%
            Iterator<Member> itme = workSpace.listMembers();

            itme = workSpace.listMembers();
            if (usrlevel >= 3) {
        %>
        <div>
            <%


                HashMap<User, Member> hmusrmbr = new HashMap<User, Member>();
                Iterator<Member> itmbr = workSpace.listMembers();
                while (itmbr.hasNext()) {
                    Member mbr = itmbr.next();
                    hmusrmbr.put(mbr.getUser(), mbr);
                }

                SWBResourceURL urlupdmbr = paramRequest.getActionUrl();
                urlupdmbr.setAction("addmember");
                urlupdmbr.setMode(SWBResourceURL.Mode_VIEW);
                urlupdmbr.setCallMethod(SWBResourceURL.Call_CONTENT);

            %>
            <script type="text/javascript">
                <!--
  
                function loadForm2(urlval){
                    getHtml(urlval, "mgrmbr",true, true);
                }
    
                function enviar2() {
                    //alert("revisando selects...");
                    var forma = document.getElementById("form2mbr");
                    var selusr = forma.usrid;
                    if(selusr.value=='-1')
                    {
                        alert('Selecciona usuario de la lista.');
                        return false;
                    }
                    
                    var objd2=forma.mbrtype;
                    if(objd2.value=='-1')
                    {
                        alert('Selecciona tipo de miembro de la lista.');
                        return false;
                    }

                    if(null!=forma){
                        //alert("enviando forma...");
                        forma.submit();
                    }
                    return false;
                }
                -->
            </script>
            <form  dojoType="dijit.form.Form" id="form2mbr" name="form2mbr" method="post" action="<%=urlupdmbr%>">
                <input type="hidden" name="wsid" value="<%=wsid%>"/>
                <label for="usrid">Añadir participante:</label>
                <select name="usrid" dojoType="dijit.form.FilteringSelect">
                    <option value="-1">Selecciona....</option>
                    <%
                        Iterator<User> itusr = wsite.getUserRepository().listUsers();
                        itusr = SWBComparator.sortSermanticObjects(new orderByFullName(), itusr);

                        while (itusr.hasNext()) {
                            User user = itusr.next();
                            if (hmusrmbr.get(user) != null) {
                                continue;
                            }

                    %>
                    <option value="<%=user.getId()%>"><%=user.getFullName()%></option>
                    <%
                        }
                    %>
                </select>
                <label for="mbrtype">Tipo:</label>
                <select dojoType="dijit.form.FilteringSelect" name="mbrtype" >
                    <option value="-1">Selecciona....</option>
                    <option value="No miembro">No miembro</option>
                    <option value="Invitado">Invitado</option>
                    <option value="Miembro">Miembro</option>
                    <option value="Coordinador">Coordinador</option>
                    <option value="Administrador">Administrador</option>
                </select>
                <button dojoType="dijit.form.Button" onclick="enviar2();return false;">Agregar</button>
            </form>

            <table class="conorg-table estante-vista">

                <thead>
                    <tr>

                        <th class="titulo" >Miembro</th>
                        <th class="tema" >Tipo membresía</th>
                        <th class="accion">&nbsp;</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        String wpidconfig = base.getAttribute("idwpavisos", "Avisos");
                        WebPage wpavisos = wsite.getWebPage(wpidconfig);

                        String urlaviso = wpavisos.getUrl() + "?act=" + SWBResourceURL.Action_ADD;


                        String ajaxUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(MyShelf.Mode_AJAX).toString() + "?wsid=" + wsid + "&mode=member";
                        while (itme.hasNext()) {
                            Member mem = itme.next();
                            String membername = mem.getUser().getFullName();
                            String mbrtype = mem.getMemberType();

                            SWBResourceURL urldel = paramRequest.getActionUrl();
                            urldel.setAction("delmember");
                            urldel.setParameter("wsid", wsid);
                            urldel.setParameter("usrid", mem.getUser().getId());
                            urldel.setParameter("mbruri", mem.getURI());
                            urldel.setParameter("mbrid", mem.getId());
                    %>
                    <tr>

                        <td><%=membername%></td>
                        <%
                            SWBResourceURL urlupdmbr2 = paramRequest.getActionUrl();
                            urlupdmbr2.setAction("updmbr");
                            urlupdmbr2.setParameter("wsid", wsid);
                            urlupdmbr2.setParameter("usrid", mem.getUser().getId());
                            urlupdmbr2.setParameter("mbrid", mem.getId());
                            String options = "id=\"" + mem.getId() + "\" onchange=\"window.location='" + urlupdmbr2.toString() + "&mbrtype='+this.value;return false;\"";
                            String strSelect = MyShelf.getSelecTypeMember(mbrtype, options);
                        %>
                        <td><%=strSelect%></td>
                        <td>
                            <%

                                String urlDirectorio = "/es_mx/conorg/Directorio/_aid/10/_act/add/?idco=" + mem.getUser().getId();
                            %>
                            <span class="icv-compartir"><a href="#" title="agregar colega a mi directorio" onclick="window.location='<%=urlDirectorio%>';">add</a></span>
                            <span class="icv-mensaje">
                                <%if (null == wpavisos) {%>
                                &nbsp;
                                <% } else {%>
                                <a href="<%=urlaviso%>&usrid=<%=mem.getUser().getId()%>">msg</a>
                                <% }%>
                            </span>
                            <span class="icv-borrar">
                                <a href="#" title="Borrar" onclick="if(confirm('¿Deseas eliminar este participante?')){window.location='<%=urldel%>';}">B&nbsp;</a>
                            </span>
                        </td>
                    </tr>

                    <%
                        }
                    %>
                </tbody>
            </table>

        </div>
        <%

        } else {
        %>
        <div>
            <table><tbody>
                    <%
                        while (itme.hasNext()) {
                            Member mem = itme.next();

                    %>
                    <tr>
                        <td>
                            <%=mem.getUser().getFullName() + " - " + mem.getMemberType()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <%
            }
        %>
        <script type="dojo/method" event="postCreate" args="" >
            if(!this.open){
            this.hideNode.style.display=this.wipeNode.style.display="none";
            }
            this._setCss();
            dojo.setSelectable(this.titleNode,false);
            dijit.setWaiState(this.containerNode,"labelledby",this.titleNode.id);
            dijit.setWaiState(this.focusNode,"haspopup","true");
            var _1=this.hideNode,_2=this.wipeNode;
            this._wipeIn=dojo.fx.wipeIn({
            node:this.wipeNode,
            duration:this.duration,
            beforeBegin:function(){
            _1.style.display="";
            },
            onEnd:function(){
            //alert("open");
            dijit.byId("leftSplit").layout();
            }
            });
            this._wipeOut=dojo.fx.wipeOut({
            node:this.wipeNode,
            duration:this.duration,
            onEnd:function(){
            _1.style.display="none";
            //alert("close");");
            dijit.byId("leftSplit").layout();
            }
            });
            //this.inherited(arguments);
        </script>
    </div>
    <div id="azulejos<%=wsid%>" dojoType="dijit.TitlePane" title="Azulejos" class="admViewProperties" open="true" duration="150" minSize_="20" splitter_="true" region="bottom">
        <%
            if (usrlevel < 2) {
                Iterator<Tile> itti = workSpace.listTiles();
        %>

        <div>
            <table>
                <%
                    while (itti.hasNext()) {
                        Tile tile = itti.next();
                %>
                <tr>
                    <td class="<%=MyShelf.getClassIconTile(tile)%>">
                        <%=tile.getTitle()%>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <%
        } else if (usrlevel >= 2) {
        %>
        <div id="conorg-data">
            <%


                if (action.equals("")) {

                    wpconfig = isShelf ? wsite.getWebPage(base.getAttribute("wpshelf", wpage.getId())) : wsite.getWebPage(base.getAttribute("wpworkspace", wpage.getId()));

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
                <%
                    if (request.getParameter("wsid") != null) {
                %>
                <input type="hidden" name="wsid" value="<%=request.getParameter("wsid")%>"/>
                <%
                    }
                %> 

                <label for="">Tipo de elemento Azulejo a añadir:</label>
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
            <%
                SWBResourceURLImp urlsus = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_ACTION);
                urlsus.setAction("suscribe");
                if (request.getParameter("wsid") != null) {
                    urlsus.setParameter("wsid", request.getParameter("wsid"));
                }

                String isSuscribe = "";
                if (workSpace.hasSubscribers(usr)) {
                    isSuscribe = "checked";
                }
            %>
            <script type="text/javascript">
                <!--
                function sendSus() {
                    var objd=dojo.byId("isSuscribe");
                    if(objd.checked)
                    {
                        window.location='<%=urlsus%>&isSuscribe=1';
                    }else {
                        window.location='<%=urlsus%>';
                    }
                    return false;
                }
                -->
            </script>
            <div class="suscribir"><label for="isSuscribe">Suscribirme a este Espacio de trabajo</label><input name="isSuscribe" id="isSuscribe" type="checkbox" onclick="sendSus();return false;" value="1" <%=isSuscribe%>/></div>
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
                        <td colspan="6" >No se encontraron registros</td>
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

                            SWBResourceURLImp urlshare = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_ACTION);
                            //SWBResourceURL urledit = paramRequest.getRenderUrl();
                            urlshare.setAction("copy2shelf");
                            urlshare.setParameter("id", tile.getId());
                            urlshare.setParameter("suri", tile.getURI());
                            if (request.getParameter("wsid") != null) {
                                urlshare.setParameter("wsid", request.getParameter("wsid"));
                            }
                    %>

                    <tr>
                        <%
                        String urllast="";
                        if (usrlevel >= 2) {
                            if(tile instanceof Versionable && tile instanceof Document){
        //                        Document doc = null;
                                VersionInfo vl = null;
                                VersionInfo ver = null;
                                vl = ((Document)tile).getLastVersion();
                                if (null != vl) {
                                ver = vl;
                                    /*while (ver.getPreviousVersion() != null) { //
                                        ver = ver.getPreviousVersion();
                                    }*/
                                    //if (ver != null) {
                                        SWBResourceURL urlview = paramRequest.getRenderUrl();
                                        urlview.setCallMethod(SWBResourceURL.Call_DIRECT);
                                        urlview.setParameter("fid", ((Document)tile).getURI());
                                        urlview.setMode(MyShelf.MODE_GETFILE);
                                        urlview.setParameter("verNum", "" + ver.getVersionNumber());
                                        urllast=urlview.toString();
                                    //}
                                }
                            }
                        }
                        if(!urllast.equals("")){
                        %>
                        <td class="<%=MyShelf.getClassIconTile(tile)%>" onclick="window.location='<%=urllast%>';"><%=strTitle%></td>
                        <td onclick="window.location='<%=urllast%>';"><%=strDate%></td>
                        <td onclick="window.location='<%=urllast%>';"><%=strType%></td>
                        <td onclick="window.location='<%=urllast%>';"><%=strTopic%></td>
                        <% } else {
                        %>
                        <td class="<%=MyShelf.getClassIconTile(tile)%>"><%=strTitle%></td>
                        <td><%=strDate%></td>
                        <td><%=strType%></td>
                        <td><%=strTopic%></td>
                        <% }
                        %>
                        <td>
                            <% if (usrlevel >= 2) {
                            %>
                            <span class="icv-compartir"><a href="#" title="Copiar referencia al estante" onclick="if(confirm('¿Deseas copiarlo a tú estante?')){window.location='<%=urlshare%>';} else return false;">C&nbsp;</a></span>
                            <span class="icv-editar"><a href="#" title="Editar" onclick="window.location='<%=urledit%>';">E&nbsp;</a></span>
                            <%
                                if (usrlevel == 4 || usr.equals(tile.getCreator())) {
                            %>
                            <span class="icv-borrar"><a href="#" title="Borrar" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';} else return false;">B&nbsp;</a></span>
                            <%
                                    } else {
                                        out.println("<span class=\"icv-vacio\"></span>");
                                    }

                                } else {
                                    out.println("<span class=\"icv-vacio\"></span><span class=\"icv-vacio\"></span><span class=\"icv-vacio\"></span>");
                                }
                            %>
                        </td>

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
            } else if (action.equals(SWBResourceURL.Action_ADD) && actType.equals("")) {


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
                //dojo.require("dijit.layout.ContentPane");
                //dojo.require("dijit.form.Form");
                //dojo.require("dijit.form.ValidationTextBox");
                //dojo.require("dijit.form.Button");
                //dojo.require("dijit.form.NumberTextBox");

                //var objff=dijit.byId('fechafin');
                // dojo.mixin(objff.constraints, {min: dijit.byId("fechaini").attr("value")});

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
            <!-- h3>< % =wptitle%></h3 -->
            <form  dojoType="dijit.form.Form" id="form1sc" name="form1sc" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
                <label for="">Tipo de elemento Azulejo a añadir:</label>
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
            } else if (action.equals(SWBResourceURL.Action_EDIT)) {
                String id = request.getParameter("id");
                String suri = request.getParameter("suri");
                //wsid = request.getParameter("wsid");

                //System.out.println("EDIT:" + id);
                String wptitle = wpage.getDisplayName(usr.getLanguage());
                SWBResourceURL urladd = paramRequest.getActionUrl();
                urladd.setAction(SWBResourceURL.Action_EDIT);

                //Tile tile = Tile.ClassMgr.getTile(id, wsite);

            %>  
            <script type="text/javascript">
                <!--
                //dojo.require("dijit.layout.ContentPane");
                //dojo.require("dijit.form.Form");
                //dojo.require("dijit.form.ValidationTextBox");
                //dojo.require("dijit.form.Button");
                //dojo.require("dijit.form.NumberTextBox");

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
            <!-- h3>< % =wptitle%></h3 -->
            <%
                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                so = ont.getSemanticObject(suri);
                GenericObject go = so.createGenericInstance();
                Tile tile = (Tile) so.createGenericInstance();
                out.println("<h4>" + MyShelf.getTileTypeName((Tile) (so.createGenericInstance())) + "</h4>");
                if (tile != null) {

                    urlupdate = paramRequest.getActionUrl();
                    urlupdate.setAction(SWBResourceURL.Action_EDIT);
                    urlupdate.setMode(SWBResourceURL.Mode_VIEW);
                    urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);

                    String frmMode = SWBFormMgr.MODE_VIEW;
                    if (usrlevel == 4 || usr.equals(tile.getCreator())) {
                        frmMode = SWBFormMgr.MODE_EDIT;
                    }

                    frmgr = new SWBFormMgr(so, null, frmMode);
                    //frmgr.clearProperties();
                    //frmgr.addProperty(Descriptiveable.swb_title);
                    //frmgr.addProperty(Descriptiveable.swb_description);
                    //frmgr.addProperty(Tagable.swb_tags);
                    //frmgr.addProperty(Traceable.swb_created);
                    //frmgr.addProperty(Traceable.swb_creator);
                    //frmgr.addProperty(Traceable.swb_modifiedBy);
                    //frmgr.addProperty(Traceable.swb_updated);
                    //frmgr.addProperty(Tile.conorg_hasTopic);

                    frmgr.clearProperties();
                    if (go instanceof Tile) {
                        frmgr.addProperty(Descriptiveable.swb_title);
                        frmgr.addProperty(Descriptiveable.swb_description);
                        frmgr.addProperty(Tagable.swb_tags);
                        frmgr.addProperty(Topicable.conorg_hasTopic);
                    }

                    if (go instanceof Document) {
                        frmgr.addProperty(Document.conorg_documentAbstract);
                        frmgr.addProperty(Document.conorg_documentCity);
                        frmgr.addProperty(Document.conorg_documentCountry);
                        frmgr.addProperty(Document.conorg_documentEdition);
                        frmgr.addProperty(Document.conorg_documentFormat);
                        frmgr.addProperty(Document.conorg_documentPages);
                        frmgr.addProperty(Document.conorg_documentPublisher);
                        frmgr.addProperty(Document.conorg_documentURL);
                        frmgr.addProperty(Document.conorg_documentYear);
                        frmgr.addProperty(Document.conorg_author);
                        frmgr.addProperty(Document.conorg_editors);

                    }

                    if (go instanceof Contact) {
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

                    if (go instanceof URL) {
                        frmgr.addProperty(URL.conorg_url);
                    }

                    if (go instanceof Article) {
                        frmgr.addProperty(Article.conorg_articleISSN);
                        frmgr.addProperty(Article.conorg_articleIssue);
                        frmgr.addProperty(Article.conorg_articleJournal);
                        frmgr.addProperty(Article.conorg_articleNumber);
                        frmgr.addProperty(Article.conorg_articleVolume);
                    }

                    if (go instanceof ChapterBook) {
                        frmgr.addProperty(ChapterBook.conorg_chaptherBookTitle);
                    }

                    if (go instanceof Image) {
                        frmgr.addProperty(Image.conorg_imageRights);
                    }

                    if (go instanceof Manual) {
                        frmgr.addProperty(Manual.conorg_manualVersion);
                    }

                    if (go instanceof Presentation) {
                        frmgr.addProperty(Presentation.conorg_presentationVersion);
                    }

                    if (go instanceof Report) {
                        frmgr.addProperty(Report.conorg_reportVersion);
                    }

                    if (go instanceof Video) {
                        frmgr.addProperty(Video.conorg_videoRights);
                    }



                    frmgr.addHiddenParameter("id", suri);
                    if (null != wsid) {
                        frmgr.addHiddenParameter("wsid", wsid);
                    }
                    //frmgr.setType(SWBFormMgr.TYPE_DOJO);
                    frmgr.setLang("es");

                    if (usrlevel == 4 || usr.equals(tile.getCreator())) {
                        frmgr.setAction(urlupdate.toString());
                        boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Cancelar</button>";
                        frmgr.addButton(boton);
                        boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\">Guardar</button>";
                        frmgr.addButton(boton);
                        //frmgr.addButton(SWBFormButton.newSaveButton());
                    } else {
                        boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Regresar</button>";
                        frmgr.addButton(boton);
                    }

                    String frmAction = "";
                    String frmSMODE = "view";
                    if (usrlevel == 4 || usr.equals(tile.getCreator())) {
                        frmAction = urlupdate.toString();
                        frmSMODE = "edit";
                    }

            %>        
            <%//=frmgr.renderForm(request)%>  
            <form id="<%=so.getURI()%>/form" class="swbform" action="<%=frmAction%>" method="post">
                <input type="hidden" name="suri" value="<%=so.getURI()%>"/>
                <input type="hidden" name="scls" value="<%=scls.getURI()%>"/>
                <input type="hidden" name="smode" value="<%=frmSMODE%>"/>
                <input type="hidden" name="id" value="<%=so.getURI()%>"/>
                <%
                    if (null != wsid) {

                %>
                <input type="hidden" name="wsid" value="<%=wsid%>"/> 
                <%
                    }

                %>

                <fieldset >
                    <legend></legend>
                    <table>
                        <%



                            hmgroup = frmgr.getGroups();
                            hmorder = new HashMap<String, SemanticProperty>();
                            itpg = hmgroup.keySet().iterator();

                            while (itpg.hasNext()) {
                                PropertyGroup pg = itpg.next();

                                //out.println(pg.getId() + "<br/>");
                                Iterator<SemanticProperty> it = hmgroup.get(pg).iterator();
                                while (it.hasNext()) {
                                    SemanticProperty prop = it.next();
                                    DisplayProperty dp = (DisplayProperty) (prop.getDisplayProperty().createGenericInstance());
                                    if (dp != null) {
                                        //out.println(dp.getIndex()+ " - "+dp.getPromptMessage());
                                        hmorder.put("" + dp.getIndex(), prop);
                                    }
                                }
                            }

                            list = new ArrayList(hmorder.keySet());
                            Collections.sort(list);
                            itstr = list.iterator();
                            while (itstr.hasNext()) {
                                String key = itstr.next();
                                SemanticProperty semprop = hmorder.get(key);
                        %>
                        <tr><td width="200px" align="right">
                                <%=frmgr.renderLabel(request, semprop, SWBFormMgr.MODE_EDIT)%>
                            </td><td>
                                <%=frmgr.renderElement(request, semprop, SWBFormMgr.MODE_EDIT)%>
                            </td></tr>
                            <%
                                }
                            %>
                    </table>
                </fieldset>
                <fieldset><span align="center">
                        <%


                            if (usrlevel == 4 || usr.equals(tile.getCreator())) {
                                //frmgr.setAction(urlupdate.toString());
                                boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Cancelar</button>";
                                out.println(boton);
                                boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\">Guardar</button>";
                                out.println(boton);
                                //frmgr.addButton(SWBFormButton.newSaveButton());
                            } else {
                                boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + paramRequest.getRenderUrl() + (null != wsid ? "?wsid=" + wsid : "") + "';return false;\">Regresar</button>";
                                out.println(boton);
                            }
                        %>
                    </span></fieldset>
            </form>
            <%
                if (tile instanceof Mosaic) {
                    String addtiurl = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD).toString();

                    SWBResourceURL urlrem = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_ACTION);
                    //SWBResourceURL urlrem = paramRequest.getActionUrl();
                    urlrem.setAction("remTile");
                    urlrem.setParameter("id", tile.getId());
                    urlrem.setParameter("suri", tile.getURI());
                    if (request.getParameter("wsid") != null) {
                        urlrem.setParameter("wsid", request.getParameter("wsid"));
                    }
                    SWBResourceURLImp urledit = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_RENDER);
                    //SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urledit.setParameter("act", SWBResourceURL.Action_EDIT);
                    //urledit.setParameter("id", tile.getId());
                    //urledit.setParameter("suri", tile.getURI());
                    if (request.getParameter("wsid") != null) {
                        urledit.setParameter("wsid", request.getParameter("wsid"));
                    }

                    SWBResourceURLImp urlshare = new SWBResourceURLImp(request, base, wpconfig, SWBResourceURLImp.UrlType_ACTION);
                    //SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urlshare.setAction("copy2shelf");
                    //urlshare.setParameter("id", tile.getId());
                    //urlshare.setParameter("suri", tile.getURI());
                    if (request.getParameter("wsid") != null) {
                        urlshare.setParameter("wsid", request.getParameter("wsid"));
                    }

                    if (wsid != null && !wsid.equals("")) {

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
                <label for="">Azulejo del Espacio de trabajo a añadir:</label>
                <select name="tiid">
                    <option value="-1">Selecciona....</option>
                    <%

                        Iterator<Tile> itti = workSpace.listTiles();
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
            <%
                }
            %>
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
                            urlshare.setParameter("id", ltile.getId());
                            urlshare.setParameter("suri", ltile.getURI());
                            urledit.setParameter("id", ltile.getId());
                            urledit.setParameter("suri", ltile.getURI());
                    %>
                    <tr>
                        <%
                        String urllast="";
                        if (usrlevel >= 2) {
                            if(tile instanceof Versionable && tile instanceof Document){
        //                        Document doc = null;
                                VersionInfo vl = null;
                                VersionInfo ver = null;
                                vl = ((Document)tile).getLastVersion();
                                if (null != vl) {
                                ver = vl;
                                    /*while (ver.getPreviousVersion() != null) { //
                                        ver = ver.getPreviousVersion();
                                    }*/
                                    //if (ver != null) {
                                        SWBResourceURL urlview = paramRequest.getRenderUrl();
                                        urlview.setCallMethod(SWBResourceURL.Call_DIRECT);
                                        urlview.setParameter("fid", ((Document)tile).getURI());
                                        urlview.setMode(MyShelf.MODE_GETFILE);
                                        urlview.setParameter("verNum", "" + ver.getVersionNumber());
                                        urllast=urlview.toString();
                                    //}
                                }
                            }
                        }
                        if(!urllast.equals("")){
                        %>
                        <td class="<%=MyShelf.getClassIconTile(ltile)%>" onclick="window.location='<%=urllast%>';"><%=strTitle%></td>
                        <td onclick="window.location='<%=urllast%>';"><%=strDate%></td>
                        <td onclick="window.location='<%=urllast%>';"><%=strType%></td>
                        <td onclick="window.location='<%=urllast%>';"><%=strTopic%></td>
                        <% } else {
                        %>
                        <td class="<%=MyShelf.getClassIconTile(ltile)%>"><%=strTitle%></td>
                        <td><%=strDate%></td>
                        <td><%=strType%></td>
                        <td><%=strTopic%></td>
                        <% }
                        %>
                        <td>
                            <% if (usrlevel >= 2) {
                            %>
                            <span class="icv-compartir"><a href="#" title="copiar referencia al estante" onclick="if(confirm('¿Deseas copiarlo a tú estante?')){window.location='<%=urlshare%>';} else return false;">C&nbsp;</a></span>
                            <span class="icv-editar"><a href="#" title="Editar" onclick="window.location='<%=urledit%>';">E&nbsp;</a></span>
                            <%
                                if (usrlevel == 4 || usr.equals(tile.getCreator())) {
                                    urlrem.setParameter("tiid", ltile.getURI());
                            %>
                            <span class="icv-borrar"><a href="#" title="Borrar" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urlrem%>';} else return false;">B&nbsp;</a></span>
                            <%  } else {
                                        out.println("<span class=\"icv-vacio\"></span>");
                                    }

                                } else {
                                    out.println("<span class=\"icv-vacio\"></span><span class=\"icv-vacio\"></span><span class=\"icv-vacio\"></span>");
                                }
                            %>
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
                        out.println("<form dojoType=\"dijit.form.Form\" id=\"frmnewdoc\" name=\"frmnewdoc\" method=\"post\" action=\"" + urlnew + "\"  enctype=\"multipart/form-data\" onsubmit=\"valida();return false;\">");
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
                        out.println("<td align=\"right\">");
                        out.println("Archivo:");
                        out.println("</td>");
                        out.println("<td>");
                        out.println("<input type=\"file\" name=\"ffile\">");
                        out.println("</td>");
                        out.println("<td colspan=\"2\" align=\"right\">");
                        out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" >Agregar</button>");
                        out.println("</td>");
                        out.println("</tr>");

                        out.println("</tbody>");

                        out.println("</tbody>");
                        out.println("</table>");
                        out.println("</form>");
                        out.println("</div>");

                    }

                }  // fin versionable
                String fcreated = (tile.getCreated() != null ? sdf.format(tile.getCreated()) : "---");
                String fcreator = (tile.getCreator() != null && tile.getCreator().getFullName() != null ? tile.getCreator().getFullName() : "---");
                String fmod = (tile.getUpdated() != null ? sdf.format(tile.getUpdated()) : "---");
                String fusrmod = (tile.getModifiedBy() != null && tile.getModifiedBy().getFullName() != null ? tile.getModifiedBy().getFullName() : "---");
            %>
            <p>Documento Creado:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=fcreated%>  por <%=fcreator%></p>
            <p>Documento Modificado:&nbsp;<%=fmod%>  por <%=fusrmod%></p> 
            <%
                }
            %>

        </div>
        <script type="dojo/method" event="postCreate" args="" >
            if(!this.open){
            this.hideNode.style.display=this.wipeNode.style.display="none";
            }
            this._setCss();
            dojo.setSelectable(this.titleNode,false);
            dijit.setWaiState(this.containerNode,"labelledby",this.titleNode.id);
            dijit.setWaiState(this.focusNode,"haspopup","true");
            var _1=this.hideNode,_2=this.wipeNode;
            this._wipeIn=dojo.fx.wipeIn({
            node:this.wipeNode,
            duration:this.duration,
            beforeBegin:function(){
            _1.style.display="";
            },
            onEnd:function(){
            //alert("open");
            dijit.byId("leftSplit").layout();
            }
            });
            this._wipeOut=dojo.fx.wipeOut({
            node:this.wipeNode,
            duration:this.duration,
            onEnd:function(){
            _1.style.display="none";
            //alert("close");");
            dijit.byId("leftSplit").layout();
            }
            });
            //this.inherited(arguments);
        </script>
    </div>

    <%
        }
    %>

</div>
<%

    String fcreated = (workSpace.getCreated() != null ? sdf.format(workSpace.getCreated()) : "---");
    String fcreator = (workSpace.getCreator() != null && workSpace.getCreator().getFullName() != null ? workSpace.getCreator().getFullName() : "---");
    String fmod = (workSpace.getUpdated() != null ? sdf.format(workSpace.getUpdated()) : "---");
    String fusrmod = (workSpace.getModifiedBy() != null && workSpace.getModifiedBy().getFullName() != null ? workSpace.getModifiedBy().getFullName() : "---");
%>
<p>Creado:     <%=fcreated%>  por <%=fcreator%></p>
<p>Modificado: <%=fmod%>  por <%=fusrmod%></p> 
<%
        }
    }
%>
<%!
    class orderByFullName implements Comparator<org.semanticwb.model.User> {

        public int compare(org.semanticwb.model.User u1, org.semanticwb.model.User u2) {
            String n1, n2;
            n1 = u1.getFullName();
            n2 = u2.getFullName();
            return n1.compareTo(n2);
        }
    }
%>