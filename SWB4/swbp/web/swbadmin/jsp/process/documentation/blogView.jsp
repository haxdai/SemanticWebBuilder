<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.Post"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.Thread"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.SWBForum"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="java.util.Comparator"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
WebPage webpage = paramRequest.getWebPage();
Resource base = paramRequest.getResourceBase();
SWBForum oforum=(SWBForum)SWBPortal.getResourceMgr().getResource(base);

SWBResourceURL urlthread = paramRequest.getRenderUrl();
SWBResourceURL url = paramRequest.getRenderUrl();
SWBResourceURL urlRemovePost = paramRequest.getRenderUrl();
SWBResourceURL actionURL = paramRequest.getActionUrl();

String lang = "es";
User user = paramRequest.getUser();
if (user != null && user.getLanguage() != null) lang = user.getLanguage();

boolean acceptguesscomments = oforum.isAcceptGuessUsers();
boolean onlyAdminCreate = oforum.isOnlyAdminCreateThreads();
boolean isforumAdmin = user.hasRole(oforum.getAdminRole());
boolean showThreadBody = oforum.isShowThreadBody();
boolean showCaptcha = oforum.isCaptcha();

String action = paramRequest.getAction();

if (action != null && action.equals("viewPost")) {
    String autor = "";
    Thread thread = (Thread) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("threadUri"));
    if(request.getParameter("addView")!=null) thread.setViewCount(thread.getViewCount() + 1);
    urlthread.setParameter("threadUri", thread.getURI());
    
    urlRemovePost.setParameter("threadUri", thread.getURI());
    urlthread.setMode(SWBResourceURL.Mode_VIEW);
    boolean isTheAuthor = false;
    if (thread.getCreator() != null) {
        autor = thread.getCreator().getFullName();
        isTheAuthor = thread.getCreator().getURI().equals(user.getURI());
    }
    %>
    <div class="row swbp-pad">
        <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
            <a href="<%= paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW) %>" class="btn btn-block swbp-btn-block" >Regresar al blog</a>
        </div>
    </div>
    <hr/>
    <div class="panel panel-default swbp-panel-blog">
        <div class="panel-heading">
            <h2><%=thread.getDisplayTitle(lang)%></h2>
            <div class="row hidden-margin"> 
                <div class="col-xs-12 property-user">
                    Por <span><%=autor%></span> el <%=SWBUtils.TEXT.getStrDate(thread.getCreated(),lang, "dd/mm/yyyy - hh:mm:ss")%>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <p>
            <%=SWBUtils.TEXT.replaceAll(thread.getBody(),"\n","<br>")%>
            </p>
        </div>
        <%
        if (isTheAuthor || isforumAdmin) {
            actionURL.setAction("removeThread");
            actionURL.setParameter("threadUri", thread.getURI());
            %>
            <div class="panel-footer">
                <div class="col-lg-2 col-lg-offset-8 col-md-2 col-md-offset-8 col-sm-3 col-sm-offset-6 col-xs-6 swbp-panel-blog-button">
                    <a class="btn btn-block" href="<%=urlthread.setMode("editThread")%>" role="button">
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-pencil icon"></div>
                        <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text">Editar</div>
                    </a>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6 swbp-panel-blog-button">
                    <a class="btn btn-block" onclick="if (!confirm('�Est� seguro de querer eliminar la entrada?')) return false;" href="<%=actionURL%>" role="button">
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-trash icon"></div>
                        <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text">Eliminar</div>
                    </a>
                </div>
            </div>  
            <%
        }
        %>
    </div>
    <%
    //Comments count
    if (thread.getReplyCount() > 0) {
        %>
        <div class="row hidden-margin">
            <div class="col-xs-12 hidden-padding">
                <h1><span><%= thread.getReplyCount() %></span> Comentarios</h1>
            </div>
        </div>
        <%
    }
    //Comments box
    if ((user != null && user.isRegistered()) || acceptguesscomments) {
        SWBFormMgr mgr = new SWBFormMgr(Post.frm_Post, thread.getSemanticObject(), null);
        actionURL.setParameter("threadUri", thread.getURI());
        actionURL.setAction("replyPost");
        %>
        <div class="row hidden-margin swbp-blog-post-comment">
            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-12 hidden-padding pull-right">
                <form method="post" action="<%=actionURL%>" id="formSavePost">
                    <%=mgr.getFormHiddens()%>
                    <div class="form-group" id="div<%=Post.frm_pstBody.getName()%>">
                        <label for=""><h6>Deja un comentario</h6></label>
                        <%
                        String inputfm = mgr.renderElement(request, Post.frm_pstBody, SWBFormMgr.MODE_CREATE);
                        inputfm = inputfm.replaceFirst(">", " required class=\"form-control swbp-form-control\" rows=\"3\">");
                        inputfm = inputfm.replace(inputfm.substring(inputfm.indexOf("style"), (inputfm.indexOf("px;\"") + 4)), "");
                        out.println(inputfm);
                        %>
                    </div>
                    <%
                    if (showCaptcha) {
                        %>
                        <div class="row hidden-margin">
                            <div class="col-lg-8 col-md-8 col-sm-12 swbp-captcha">
                                <div class="col-lg-5 col-md-7 col-sm-6 col-xs-12 hidden-padding" id="divcmnt_seccode">
                                    <label for=""><h6>Captcha *</h6></label>
                                    <img src="<%= SWBPlatform.getContextPath() + "/swbadmin/jsp/securecode.jsp" %>" alt="" id="imgseccode" width="155" height="65"/>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 hidden-padding">
                                    <input type="text" required name="cmnt_seccode" id="cmnt_seccode">
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 pull-right swbp-panel-foro-button">
                                <button id="saveForm" type="submit" class="btn btn-block"><%=paramRequest.getLocaleString("send")%></button>
                            </div>
                        </div>
                        <%
                        out.print(SWBForum.getScriptValidator("saveForm", "formSavePost"));
                    }
                    %>
                </form>
            </div>
        </div>
        <%
    }
    //Comment thread
    if (thread.getReplyCount() > 0) {
        Iterator<Post> itPost = SWBComparator.sortByCreated(thread.listPosts(),false);
        while (itPost.hasNext()) {
            isTheAuthor = false;
            Post post = itPost.next();
            String creator = "An�nimo";
            if (null != post.getCreator()) {
                creator = post.getCreator().getFullName();
                isTheAuthor = post.getCreator().getURI().equals(user.getURI());
            }
            %>
            <div class="row swbp-comment">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 text-center swbp-comment-user">
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/jsp/process/commons/css/images/usuario-3.png" class="img-circle" alt="<%= creator %>"/>
                </div>
                <div class="col-lg-11 col-md-11 col-sm-11 col-xs-10 hidden-padding">
                    <h6><%= creator %></h6>
                    <div class="property-user">
                        <span><%=SWBUtils.TEXT.getStrDate(thread.getCreated(),lang, "dd/mm/yyyy - hh:mm:ss")%></span>
                    </div>
                    <p><%= post.getBody().replaceAll("\n","<br>") %></p>
                    <%
                    if (isTheAuthor || isforumAdmin) {
                        urlthread.setParameter("postUri", post.getURI());
                        actionURL.setAction("removePost");
                        actionURL.setParameter("threadUri", thread.getURI());
                        actionURL.setParameter("postUri", post.getURI());
                        %>
                        <div class="row hidden-margin">
                            <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6 pull-right swbp-panel-blog-button">
                                <a class="btn btn-block" onclick="if (!confirm('�Est� seguro de querer eliminar el comentario?')) return false;" href="<%=actionURL%>" role="button">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-trash-o icon"></div>
                                    <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text">Eliminar</div>
                                </a>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6 pull-right swbp-panel-blog-button">
                                <a class="btn btn-block" href="<%=urlthread.setMode("editPost")%>" role="button">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-pencil icon"></div>
                                    <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text">Editar</div>
                                </a>
                            </div>
                        </div>
                        <%
                    }
                    %>
                </div>
            </div>
            <%
        }
    }
} else {
    %>
    <div class="row swbp-pad">
        <!--div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
            <a href="<%=paramRequest.getWebPage().getParent().getUrl(lang)%>" class="btn btn-block swbp-btn-block" data-toggle="tooltip" data-placement="bottom" data-original-title="Regresar a la p�gina de colaboraci�n" title="Regresar a la p�gina de colaboraci�n">
                Regresar a la p�gina de colaboraci�n
            </a>
        </div-->
        <%
        if (isforumAdmin || !onlyAdminCreate) {
            urlthread.setMode("addThread");
            %>
            <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
                <a href="<%= urlthread %>" class="btn btn-block swbp-btn-block" data-toggle="tooltip" data-placement="bottom" data-original-title="Agregar entrada" title="Agregar entrada">Agregar entrada</a>
            </div>
            <%
        }
        %>
    </div>
    <hr>
    <%
    url.setMode(url.Mode_VIEW);
    url.setAction("viewPost");
    url.setParameter("addView", "1");
    String autor = "";

    TreeSet<Thread> treeSet=new TreeSet(new Comparator() {
        public int compare(Object o1, Object o2) {
            Thread ob1 = (Thread) (o1);
            Thread ob2 = (Thread) (o2);
            int ret=-1;
            if(ob1.getLastPostDate()!=null && ob2.getLastPostDate()!=null) {
                ret=ob1.getLastPostDate().after(ob2.getLastPostDate())? -1 : 1;
            }
            return ret;
        }
    });

    Iterator<WebPage> itThreads = webpage.listChilds(lang, null, false, null, null, false);
    if (itThreads.hasNext()) {
        while (itThreads.hasNext()) {
            WebPage wp = itThreads.next();
            //System.out.println("treeSet:"+treeSet+" "+wp);
            if(wp!=null && wp instanceof Thread)
            {
                treeSet.add((Thread)wp);
            }
        }

        Iterator<Thread> itThreads2 = treeSet.iterator();
        while (itThreads2.hasNext()) {
            Thread thread = itThreads2.next();
            SWBForum forum = thread.getForum();
            if (forum.getId().equals(base.getId())) {
                url.setParameter("threadUri", thread.getURI());
                if (thread.getCreator() != null) {
                    autor = thread.getCreator().getFullName();
                }

                String title = thread.getDisplayTitle(lang);
                if (title == null) title = "--";
                %>
                <div class="panel panel-default swbp-panel-blog">
                    <div class="panel-heading">
                        <h2 class="panel-title"><%=title%></h2>
                        <div class="row hidden-margin">
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 property-user">
                                Por <span><%=autor%></span> el <%=SWBUtils.TEXT.getStrDate(thread.getCreated(),lang, "dd/mm/yyyy - hh:mm:ss")%>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center property fa fa-comment">
                                <span><%=thread.getReplyCount()%></span> <span class="hidden-sm hidden-xs">comentarios</span>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center property fa fa-eye">
                                <span><%= thread.getViewCount() %></span> <span class="hidden-sm hidden-xs">vistas</span>
                            </div>
                        </div>
                    </div>
                    <%
                    if(showThreadBody) {
                        %>
                        <div class="panel-body">
                            <%
                            String body = SWBUtils.TEXT.replaceAll(thread.getBody(),"\n","<br>");
                            if (body.length() > 300) {
                                body = SWBUtils.TEXT.cropText(body, 600);
                            }
                            %>
                            <p><%=body%></p>
                        </div>
                        <%
                    }
                    %>
                    <div class="panel-footer">
                        <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-panel-blog-button">
                            <a class="btn btn-block" href="<%=url%>" role="button">Continuar leyendo</a>
                        </div>
                    </div>
                </div>
            <%
            }
        }
    } else {
        %>
        <div class="alert alert-block alert-warning fade in">
            No hay entradas en el blog
        </div>
        <%
    }
}
%>