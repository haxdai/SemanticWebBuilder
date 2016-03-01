<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.TreeSet"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.Attachment"%>
<%@page import="org.semanticwb.model.GenericIterator"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.Post"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.SWBForum"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.Thread"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
WebPage webpage = paramRequest.getWebPage();
Resource base = paramRequest.getResourceBase();
SWBForum oforum = (SWBForum) SWBPortal.getResourceMgr().getResource(base);
String flag = request.getAttribute("flag") != null ? request.getAttribute("flag").toString() : "";
WebSite website = webpage.getWebSite();
SWBResourceURL urlthread = paramRequest.getRenderUrl();
SWBResourceURL url = paramRequest.getRenderUrl();
SWBResourceURL actionURL = paramRequest.getActionUrl();
User user = paramRequest.getUser();

boolean acceptguesscomments = oforum.isAcceptGuessUsers();
boolean onlyAdminCreate = oforum.isOnlyAdminCreateThreads();
boolean isforumAdmin = user.hasRole(oforum.getAdminRole());
boolean showThreadBody = oforum.isShowThreadBody();
boolean showCaptcha = oforum.isCaptcha();

String lang = user.getLanguage();
String action = paramRequest.getAction();
String autor = "";

//View post detail
if (action != null && action.equals("viewPost")) {
    Thread thread = (Thread)SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("threadUri"));
    if (null == thread) return; //Fail quick if no thread uri
    
    if (request.getParameter("addView") != null) {
        thread.setViewCount(thread.getViewCount() + 1);
    }
    
    String body = thread.getBody() != null ? thread.getBody() : "";
    url.setParameter("threadUri", thread.getURI());
    //urlRemovePost.setParameter("threadUri", thread.getURI());
    urlthread.setMode("addThread");
    boolean isTheAuthor = false;
    if (thread.getCreator() != null) {
        autor = thread.getCreator().getFullName();
        isTheAuthor = thread.getCreator().getURI().equals(user.getURI());
    }
    %>
    <div class="row swb-pad">
        <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
            <a href="<%=paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW)%>" class="btn btn-block swbp-btn-block">Regresar al foro</a>
        </div>
    </div>
    <hr/>
    <div class="panel panel-default swbp-panel-foro">
        <div class="panel-heading">
            <div class="row hidden-margin">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 text-center swbp-comment-user">
                    <img src="<%= SWBPortal.getContextPath() %>/swbadmin/jsp/process/commons/css/images/usuario-3.png" class="img-circle"/>
                </div>
                <div class="col-lg-11 col-md-11 col-sm-11 hidden-padding">
                    <h2><%= thread.getTitle() %></h2>
                    <div class="col-xs-12 property-user">
                        Por <span><%= autor %></span> el <%=SWBUtils.TEXT.getStrDate(thread.getCreated(), user.getLanguage())%>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <%
            if (!flag.equals("")) {
                %>
                <div class="alert alert-warning alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <strong>Aviso!</strong> <%=paramRequest.getLocaleString(flag)%>.
                </div>
                <%
            }%>
            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-12 pull-right hidden-padding">
                <p><%=SWBUtils.TEXT.replaceAll(body, "\n", "<br>")%></p>
            </div>
        </div>
        <%
        if (isTheAuthor || isforumAdmin) {
            urlthread.setMode("editThread");
            %>
            <div class="panel-footer">
                <div class="col-lg-2 col-lg-offset-8 col-md-2 col-md-offset-8 col-sm-3 col-sm-offset-6 col-xs-6 swbp-panel-foro-button">
                    <a href="<%=urlthread.setParameter("threadUri", thread.getURI())%>" class="btn btn-block" role="button">
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-pencil icon"></div>
                        <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text">Editar</div>
                    </a>
                </div>
                <%
                url.setAction("removePost");
                url.setParameter("isthread", "1");
                actionURL.setAction("removeThread");
                actionURL.setParameter("forumUri", request.getParameter("forumUri"));
                %>
                <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6 swbp-panel-foro-button">
                    <a href="<%=actionURL.setParameter("threadUri", thread.getURI())%>" onclick="if (!confirm('<%=paramRequest.getLocaleString("remove")%> <%=thread.getTitle()%>?')) return false;" class="btn btn-block" role="button">
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-trash-o icon"></div>
                        <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text">Eliminar</div>
                    </a>
                </div>
            </div>
            <%
        }
        %>
    </div>
    <%
    if (thread.getReplyCount() > 0) {
        %>
        <div class="row hidden-margin">
            <div class="col-xs-12 hidden-padding">
                <h1><span><%= thread.getReplyCount() %></span> comentarios</h1>
            </div>
        </div>
        <%
    }
    //Comment box
    if ((user != null && user.isRegistered()) || acceptguesscomments) {
        SWBFormMgr mgr = new SWBFormMgr(Post.frm_Post, thread.getSemanticObject(), null);
        //String photo = SWBPortal.getContextPath()+"/work/models/"+website.getId()+"/images/usuario-3.png";
        actionURL.setParameter("threadUri", thread.getURI());
        actionURL.setAction("replyPost");
        lang = user.getLanguage();
        %>
        <div class="row hidden-margin swbp-foro-post-comment">
            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-12 hidden-padding pull-right">
                <form method="post" action="<%=actionURL%>" id="formSavePost">
                    <%= mgr.getFormHiddens() %>
                    <div class="form-group" id="div<%=Post.frm_pstBody.getName()%>">
                        <label for="">
                            <h6><%= paramRequest.getLocaleString("lblLeaveMessage") %></h6>
                        </label>
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
                                    <input type="text" required name="cmnt_seccode">
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
    //Thread comments
    Iterator<Post> itPost = SWBComparator.sortByCreated(thread.listPosts(), false);
    while (itPost.hasNext()) {
        String photo = SWBPortal.getContextPath()+"/swbadmin/jsp/process/commons/css/images/usuario-3.png";
        Post post = itPost.next();
        url.setParameter("postUri", post.getURI());
        //urlRemovePost.setParameter("postUri", post.getURI());
        String postCreator = "Anonimo";
        String postBody = post.getBody() != null ? post.getBody() : "";

        isTheAuthor = post.getCreator().getURI().equals(user.getURI());
        if (post.getCreator() != null) {
            postCreator = post.getCreator().getFullName();
            if (post.getCreator().getPhoto() != null) {
                photo = SWBPortal.getWebWorkPath() + post.getCreator().getPhoto();
            }
        }

        urlthread.setParameter("postUri", post.getURI());
        urlthread.setParameter("threadUri", thread.getURI());
        %>
        <div class="row swbp-comment">
            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 text-center swbp-comment-user">
                <img src="<%= SWBPortal.getContextPath() %>/swbadmin/jsp/process/commons/css/images/usuario-3.png" class="img-circle"/>
            </div>
            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-10 hidden-padding">
                <h6><%= postCreator %></h6>
                <div class="property-user">
                    <span><%=SWBUtils.TEXT.getStrDate(post.getCreated(), user.getLanguage())%></span>
                </div>
                <p><%=SWBUtils.TEXT.replaceAll(postBody, "\n", "<br>")%></p>
                <div class="row hidden-margin">
                    <%
                    if (isTheAuthor || isforumAdmin) {
                        %>
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-4 pull-right swbp-panel-foro-button">
                            <a href="<%= actionURL.setAction("removePost") %>" onclick="if (!confirm('<%=paramRequest.getLocaleString("remove")%> <%=post.getBody()%>?')) return false;" class="btn btn-block" role="button">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-trash-o icon"></div>
                                <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text"><%=paramRequest.getLocaleString("remove")%></div>
                            </a>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-4 pull-right swbp-panel-foro-button">
                            <a href="<%= urlthread.setMode("editPost") %>" class="btn btn-block" role="button">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-pencil icon"></div>
                                <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text"><%=paramRequest.getLocaleString("edit")%></div>
                            </a>
                        </div>
                        <%
                    }
                    if ((user != null && user.isRegistered()) || acceptguesscomments) {
                        %>
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-4 pull-right swbp-panel-foro-button">
                            <a href="<%=urlthread.setMode("replyPost")%>" class="btn btn-block" role="button">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 fa fa-comment icon"></div>
                                <div class="col-lg-8 col-md-8 col-sm-8 hidden-xs text"><%=paramRequest.getLocaleString("comment")%></div>
                            </a>
                        </div>
                        <%
                    }
                    %>
                </div>
            </div>
        </div>
        <%
    }
} else {
    %>
    <div class="row swb-pad">
        <%
        if (!onlyAdminCreate || isforumAdmin) {
            if (user != null && user.isRegistered()) {
                %>
                <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
                    <a href="<%= paramRequest.getRenderUrl().setMode("addThread") %>" class="btn btn-block swbp-btn-block">Agregar entrada</a>
                </div>
                <%
            }
        }
        %>
    </div>
    <hr/>
    <%
    if (!flag.equals("")) {
        %>
        <div class="alert alert-warning alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Aviso!</strong> <%=paramRequest.getLocaleString(flag)%>.
        </div>
        <%
    }
    autor = "";
    url.setMode(url.Mode_VIEW);
    url.setAction("viewPost");
    TreeSet<Thread> treeSet = new TreeSet(new Comparator() {
    public int compare(Object o1, Object o2) {
            Thread ob1 = (Thread) (o1);
            Thread ob2 = (Thread) (o2);
            int ret = -1;
            if (ob1.getLastPostDate() != null && ob2.getLastPostDate() != null) {
                ret = ob1.getLastPostDate().after(ob2.getLastPostDate()) ? -1 : 1;
            }
            return ret;
        }
    });

    Iterator<Thread> iterator = request.getAttribute(SWBForum.ATT_THREADS) != null ? ((List<Thread>) request.getAttribute(SWBForum.ATT_THREADS)).iterator() : null;
    Iterator<WebPage> itThreads = webpage.listChilds(null, null, false, null, null);

    while (itThreads.hasNext()) {
        WebPage wp = itThreads.next();
        if (wp != null && wp instanceof Thread) {
            treeSet.add((Thread) wp);
        }
    }
    
    Iterator<Thread> itThreads2 = request.getAttribute(SWBForum.ATT_THREADS) != null ? ((List<Thread>) request.getAttribute(SWBForum.ATT_THREADS)).iterator() : null;
    if (itThreads2.hasNext()) {
        int i = 0;
        while (itThreads2.hasNext()) {
            Thread thread = itThreads2.next();
            url.setParameter("threadUri", thread.getURI());
            if (thread.getCreator() != null) {
                autor = thread.getCreator().getFullName();
            }
            %>
            <div class="panel panel-default swbp-panel-foro">
                <div class="panel-heading">
                    <div class="row hidden-margin">
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 text-center swbp-comment-user">
                            <img src="<%= SWBPortal.getContextPath() %>/swbadmin/jsp/process/commons/css/images/usuario-3.png" class="img-circle"/>
                        </div>
                        <div class="col-lg-11 col-md-11 col-sm-11 hidden-padding">
                            <h2><%= thread.getTitle() %></h2>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 property-user">
                                Por <span><%= autor %></span> el <%=SWBUtils.TEXT.getStrDate(thread.getCreated(), user.getLanguage())%>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center property fa fa-comment">
                                <span><%= thread.getReplyCount()%></span> <span class="hidden-sm hidden-xs"><%=paramRequest.getLocaleString("responses")%></span>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center property fa fa-eye">
                                <span><%= thread.getViewCount() %></span> <span class="hidden-sm hidden-xs"><%=paramRequest.getLocaleString("visites")%></span>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                if (oforum.isShowThreadBody()) {
                    String text = thread.getBody() != null ? thread.getBody() : "";
                    %>
                    <div class="panel-body">
                        <div class="col-lg-11 col-md-11 col-sm-11 col-xs-12 pull-right hidden-padding">
                            <p><%=SWBUtils.TEXT.replaceAll(text, "\n", "<br>")%></p>
                            <%
                            if (thread.getReplyCount() > 0) {
                                Iterator<Post> itPost = SWBComparator.sortByCreated(thread.listPosts(), false);
                                Post lastComment = itPost.next();
                                String lastCommentBody = lastComment.getBody() != null ? lastComment.getBody() : "";
                                %>
                                <div class="row hidden-margin">
                                    <div class="col-xs-12 hidden-padding">
                                        <h1><%=paramRequest.getLocaleString("lastcomment")%></h1>
                                    </div>
                                </div>
                                <div class="row swbp-comment">
                                    <div class="col-lg-1 col-md-1 col-sm-2 col-xs-3 text-center swbp-comment-user swbp-comment-user-foro">
                                        <img src="<%= SWBPortal.getContextPath() %>/swbadmin/jsp/process/commons/css/images/usuario-3.png" class="img-circle"/>
                                    </div>
                                    <div class="col-lg-11 col-md-11 col-sm-10 col-xs-9 hidden-padding">
                                        <h6><%= (lastComment.getCreator() != null ? lastComment.getCreator().getFullName() : "") %></h6>
                                        <div class="property-user prouser-xs">
                                            <span><%=SWBUtils.TEXT.getStrDate(lastComment.getCreated(), user.getLanguage())%></span>
                                        </div>
                                        <p><%=SWBUtils.TEXT.replaceAll(lastCommentBody, "\n", "<br>")%></p>
                                    </div>
                                </div>
                                <%
                            }
                            %>
                        </div>
                    </div>
                    <%
                }
                %>
                <div class="panel-footer">
                    <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-panel-foro-button">
                        <a href="<%=url%>" class="btn btn-block" role="button">Ver comentarios</a>
                    </div>
                </div>
            </div>
            <%
        }
        %>
        <jsp:include page="/swbadmin/jsp/process/commons/pagination.jsp" flush="true"/>
        <script>
            $('#btnTheme').click(function() {
                var $inputs = $('#saveTheme :input');
                var cont = 0;
                $inputs.each(function() {
                    if (this.required) {
                        var diverror = $('#div' + this.name);
                        if ($(this).val().length === 0) {
                            diverror.addClass('has-error');
                            cont++;
                        } else {
                            diverror.removeClass('has-error');
                        }
                    }
                });
                if (cont === 0) {
                    submitFormTheme('saveTheme');
                    var forma = document.getElementById('saveTheme');
                    forma.submit();
                    return false;
                }
                return false;
            });
        </script>
        <%
    } else {
        %>
        <!--div class="row swbp-pad">
            <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
                <a href="<%=paramRequest.getWebPage().getParent().getUrl(lang)%>" class="btn btn-block swbp-btn-block" data-toggle="tooltip" data-placement="bottom" data-original-title="Regresar a la página de colaboración" title="Regresar a la página de colaboración">
                    Regresar a la página de colaboración
                </a>
            </div>
        </div>
        <hr-->
        <div class="alert alert-block alert-warning fade in">
            No hay entradas en el foro
        </div>
        <%
    }
}
%>

<%!
    private String getPostAndAttachments(Post post, String posattach) {
        String[] posattachX = posattach.split("/");
        int postCount = Integer.parseInt(posattachX[0]);
        int AttachCount = Integer.parseInt(posattachX[1]);
        GenericIterator<Attachment> gitAttach = post.listAttachmentses();
        while (gitAttach.hasNext()) {
            gitAttach.next();
            AttachCount++;
        }
        posattach = postCount + "/" + AttachCount;
        GenericIterator<Post> gitPost = post.listchildPosts();
        while (gitPost.hasNext()) {
            posattachX = posattach.split("/");
            postCount = Integer.parseInt(posattachX[0]) + 1;
            AttachCount = Integer.parseInt(posattachX[1]);
            posattach = getPostAndAttachments(gitPost.next(), postCount + "/" + AttachCount);
        }
        return posattach;
    }

    private int getTotAttachments(Post post, int attchCount) {
        GenericIterator<Attachment> gitAttach = post.listAttachmentses();
        while (gitAttach.hasNext()) {
            gitAttach.next();
            attchCount++;
        }
        GenericIterator<Post> gitPost = post.listchildPosts();
        while (gitPost.hasNext()) {
            attchCount = getTotAttachments(gitPost.next(), attchCount);
        }
        return attchCount;
    }
%>