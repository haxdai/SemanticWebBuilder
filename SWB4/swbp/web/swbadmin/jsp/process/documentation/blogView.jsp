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
    String body = SWBUtils.TEXT.replaceAll(thread.getBody(),"\n","<br>");
    %>
    <div class="row no-margin swbp-button-ribbon text-right">
        <a href="<%= paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW) %>" class="btn btn-swbp-action" >Regresar al blog</a>
    </div>
    <hr/>
    <div class="panel swbp-input-tray">
        <div class="panel-body">
            <div class="media">
                <div class="media-body">
                    <h4 class="media-heading"><%= thread.getDisplayTitle(lang) %></h4>
                    <small><i><%= autor %></i> - <%=SWBUtils.TEXT.getStrDate(thread.getCreated(),lang, "dd/mm/yyyy - hh:mm:ss")%></small>
                    <hr>
                    <p><%= body %></p>
                </div>
            </div>
        </div>
        <%
        if (isTheAuthor || isforumAdmin) {
            actionURL.setAction("removeThread");
            actionURL.setParameter("threadUri", thread.getURI());
            %>
            <div class="panel-footer">
                <div class="row no-margin">
                    <a class="btn btn-default col-xs-6" href="<%=urlthread.setMode("editThread")%>" role="button">
                        <span class="col-lg-6 col-md-6 col-sm-12 col-xs-12 fa fa-pencil"></span>
                        <span class="col-lg-6 col-md-6 hidden-sm hidden-xs text-left">Editar</span>
                    </a>
                    <a class="btn btn-default col-xs-6" onclick="if (!confirm('¿Está seguro de querer eliminar la entrada?')) return false;" href="<%=actionURL%>" role="button">
                        <span class="col-lg-6 col-md-6 col-sm-12 col-xs-12 fa fa-trash-o"></span>
                        <span class="col-lg-6 col-md-6 hidden-sm hidden-xs text-left">Eliminar</span>
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
        <div class="row hidden-margin text-right">
            <div class="col-xs-12 no-padding">
                <h6><%= thread.getReplyCount() %> Comentarios</h6>
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
        <div class="panel swbp-input-tray no-margin">
            <form method="post" class="swbp-form" action="<%=actionURL%>" id="formSavePost">
                <%=mgr.getFormHiddens()%>
                <div class="panel-body">
                    <div class="form-group" id="div<%=Post.frm_pstBody.getName()%>">
                        <label for="" class="col-sm-10 col-sm-offset-1 control-label"><h6>Deja un comentario</h6></label>
                        <div class="col-sm-10 col-sm-offset-1">
                        <%
                        String inputfm = mgr.renderElement(request, Post.frm_pstBody, SWBFormMgr.MODE_CREATE);
                        inputfm = inputfm.replaceFirst(">", " required class=\"form-control\" >");
                        inputfm = inputfm.replace(inputfm.substring(inputfm.indexOf("style"), (inputfm.indexOf("px;\"") + 4)), "");
                        out.println(inputfm);
                        %>
                        </div>
                    </div>
                    <%
                    if (showCaptcha) {
                        %>
                        <div class="form-group">
                            <label for="" class="col-sm-10 col-sm-offset-1"><h6>Captcha *</h6></label>
                            <div class="col-sm-10 col-sm-offset-1">
                                <img src="<%= SWBPlatform.getContextPath() + "/swbadmin/jsp/securecode.jsp" %>" alt="" id="imgseccode" width="155" height="65"/>
                                <input type="text" required name="cmnt_seccode" class="form-control" id="cmnt_seccode">
                            </div>
                        </div>
                        <%
                        out.print(SWBForum.getScriptValidator("saveForm", "formSavePost"));
                    }
                    %>
                </div>
                <div class="panel-footer text-right">
                    <button id="saveForm" type="submit" class="btn btn-default"><%=paramRequest.getLocaleString("send")%></button>
                </div>
            </form>
        </div>
        <%
    }
    //Comment thread
    if (thread.getReplyCount() > 0) {
        Iterator<Post> itPost = SWBComparator.sortByCreated(thread.listPosts(),false);
        while (itPost.hasNext()) {
            isTheAuthor = false;
            Post post = itPost.next();
            String creator = "Anónimo";
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
                                <a class="btn btn-block" onclick="if (!confirm('¿Está seguro de querer eliminar el comentario?')) return false;" href="<%=actionURL%>" role="button">
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
    if (isforumAdmin || !onlyAdminCreate) {
        urlthread.setMode("addThread");
        %>
        <div class="row no-margin swbp-button-ribbon text-right">        
            <a href="<%= urlthread %>" class="btn btn-swbp-action">Agregar entrada</a>
        </div>
        <hr>
        <%
    } else {
        %><br><%
    }

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
                <div class="panel swbp-input-tray">
                    <div class="panel-body">
                        <div class="media">
                            <div class="media-body">
                                <h4 class="media-heading"><%= title %></h4>
                                <small><i><%=autor%></i> - <%=SWBUtils.TEXT.getStrDate(thread.getCreated(),lang, "dd/mm/yyyy - hh:mm:ss")%></small>
                                <%
                                if(showThreadBody) {
                                    String body = SWBUtils.TEXT.replaceAll(thread.getBody(),"\n","<br>");
                                    if (body.length() > 300) {
                                        body = SWBUtils.TEXT.cropText(body, 600);
                                    }
                                    %>
                                    <hr>
                                    <p><%=body%></p>
                                    <%
                                }
                                %>
                                <p class="text-right">
                                    <span class="fa fa-comment-o fa-fw"></span><%=thread.getReplyCount()%>
                                    <span class="fa fa-eye fa-fw"></span><%= thread.getViewCount() %>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="row no-margin">
                            <a class="btn btn-default col-xs-12" href="<%=url%>" role="button">Seguir leyendo</a>
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