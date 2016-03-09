<%-- 
    Document   : repoitoryAddFile.jsp
    Created on : 3/09/2013, 11:41:28 AM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>

<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.model.ItemAwareStatus"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.process.model.RepositoryFile"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
String validFiles = (String) request.getAttribute(ProcessFileRepository.VALID_FILES);
WebSite site = paramRequest.getWebPage().getWebSite();
User user = paramRequest.getUser();
RepositoryElement re = null;
String lang ="es";
String actualStatus ="";

if (user != null && user.getLanguage() != null) lang = user.getLanguage();

String type = request.getParameter("type");
VersionInfo vi = null;

if ("url".equals(type)) {
    re = RepositoryURL.ClassMgr.getRepositoryURL(request.getParameter("fid"), site);
} else if ("file".equals(type)) {
    re = RepositoryFile.ClassMgr.getRepositoryFile(request.getParameter("fid"), site);
} else {
    type = "";
}

if (re != null) {
    vi = re.getLastVersion();
    actualStatus = re.getStatus()!=null?re.getStatus().getId():"";
}

if (!user.isSigned()) {
    if (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT) {
        %>
        <div class="alert alert-block alert-danger fade in">
            <h4><span class="fa fa-ban"></span> <%=paramRequest.getLocaleString("msgNoAccessTitle")%></h4>
            <p><%=paramRequest.getLocaleString("msgNoAccess")%></p>
            <p>
                <a class="btn btn-default" href="/login/<%=site.getId()%>/<%=paramRequest.getWebPage().getId()%>"><%=paramRequest.getLocaleString("btnLogin")%></a>
            </p>
        </div>
        <%
    }
} else {
    SWBResourceURL createURL = paramRequest.getActionUrl().setAction(ProcessFileRepository.ACT_NEWFILE);
    
    String comments = "";
    String description = "";
    if (re != null && vi.getVersionComment() != null) {
        comments = vi.getVersionComment();
    }
    
    if (re != null && re.getDisplayDescription(lang) != null) description = re.getDisplayDescription(lang);
    %>
    <div class="modal-dialog">
        <div class="modal-content swbp-modal">
            <div class="modal-header">
                <h4 class="modal-title"><%=paramRequest.getLocaleString("msgAdd")%>&nbsp;<%=re != null?paramRequest.getLocaleString("msgVersionOf")+" ":""%> <%=(re != null && re instanceof RepositoryURL)?paramRequest.getLocaleString("msgDocLink"):paramRequest.getLocaleString("msgFile")%></h4>
            </div>
            <form class="form-horizontal" id="fileForm" role="form" action="<%=createURL%>" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <%
                    if (re != null) {
                        %><input type="hidden" name="fid" value="<%= re.getURI() %>"/><%
                    }%>
                    <div class="form-group">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for=""><%=paramRequest.getLocaleString("msgTitle")%> *</label>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                            <input type="text" name="ftitle" id="ftitle" required value="<%=(re != null)?re.getDisplayTitle(lang):""%>" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for=""><%=paramRequest.getLocaleString("msgDescription")%> *</label>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12 swbp-modal-textarea">
                            <textarea name="fdescription" id="fdescription" required rows="2" class="form-control swbp-form-control"><%=description%></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for=""><%=paramRequest.getLocaleString("msgComments")%></label>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12 swbp-modal-textarea">
                            <textarea name="fcomment" id="fcomment" rows="2" class="form-control swbp-form-control"><%=comments%></textarea>
                        </div>
                    </div>
                    <%
                    if (re == null) {
                        %>
                        <div class="form-group">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                            <label><%=paramRequest.getLocaleString("msgFileType")%></label>
                            </div>
                            <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                      <input class="css-checkbox" type="radio" id="fileToggleRadio" checked name="hftype" value="file">
                                      <label class="css-label" for="fileToggleRadio"><span><%=paramRequest.getLocaleString("msgFile")%></span></label>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                      <input class="css-checkbox" type="radio" id="urlToggleRadio" name="hftype" value="url"> 
                                      <label class="css-label" for="urlToggleRadio"><%=paramRequest.getLocaleString("lblLink")%></label>
                                </div>
                            </div>
                        </div>
                        <%
                    } else {
                        %><input type="hidden" name="hftype" id="hftype" value="<%=type%>"/><%
                    }

                    if (re == null || (re != null && re instanceof RepositoryFile)) {
                        %>
                        <div id="fileSelect" class="form-group">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                <label for=""><%=paramRequest.getLocaleString("msgFile")%> *</label>
                            </div>
                            <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                <input type="file" name="ffile" id="ffile" class="form-control" />
                            </div>
                        </div>
                        <%
                    }

                    if (re == null || (re != null && re instanceof RepositoryURL)) {
                        String val = "";
                        if (re != null) {
                            val = vi.getVersionFile();//vi.getVersionFile().startsWith("http://")?vi.getVersionFile().replace("http://", ""):vi.getVersionFile();
                        }
                        %>
                        <div id="linkSelect" class="row form-group">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                <label for=""><%=paramRequest.getLocaleString("lblLink")%> *</label>
                            </div>
                            <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                <input type="text" name="extfile" id="extfile" value="<%=val%>" class="form-control" placeholder="http://"/>
                            </div>
                        </div>
                        <%
                    }

                    Iterator<ItemAwareStatus> ititwstst = SWBComparator.sortByDisplayName(ItemAwareStatus.ClassMgr.listItemAwareStatuses(site), lang);
                    if (ititwstst.hasNext()) {
                        %>
                        <div class="form-group">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                <label for=""><%=paramRequest.getLocaleString("msgTHStatus")%></label>
                            </div>
                            <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">            
                                <select name="itemAwStatus" id="itemAwStatus" class="form-control">
                                    <option value="" <%=(actualStatus.equals("")?"selected":"")%>><%=paramRequest.getLocaleString("msgSelNone")%></option>
                                    <%
                                    while (ititwstst.hasNext()) {
                                        ItemAwareStatus itemAwareStatus = ititwstst.next();
                                        %>
                                        <option value="<%=itemAwareStatus.getId()%>" <%=(actualStatus.equals(itemAwareStatus.getId())?"selected":"")%>><%=itemAwareStatus.getDisplayTitle(lang)%></option>
                                        <%
                                    }
                                    %>
                                </select>
                            </div>
                        </div>
                        <%
                    }

                    if (re != null) {
                        %>
                        <div class="form-group">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                <label for="" ><%=paramRequest.getLocaleString("msgVersion")%> *</label>
                            </div>
                            <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">  
                                <select name="newVersion" id="itemAwStatus" class="form-control">
                                    <%
                                    float fver = Float.parseFloat(vi.getVersionValue());
                                    fver = fver + 0.1F;

                                    int iver = (int) fver;
                                    iver = iver + 1;
                                    %>
                                    <option value="fraction"><%=fver%></option>
                                    <option value="nextInt"><%=(float)iver%></option>
                                </select>
                            </div>
                        </div>
                        <%
                    }%>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6"><span class="fa fa-plus fa-fw"></span><%=paramRequest.getLocaleString("msgAdd")%></button>
                    <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("msgBTNCancel")%></button>
                </div>
            </form>
        </div>
    </div>
    <iframe style="display:none;" name="fUploadFrame" id="fUploadFrame"></iframe>
    <script>
        (function () {
            var isFile = true;
            
            var isFileType = function(pFile) {
                if (pFile && pFile.length && pFile.lastIndexOf(".") === -1) return false;
                var exts = '<%= validFiles %>', valid = false, fext;

                if (exts.indexOf('|') > -1) {
                    exts = exts.split("|");
                }

                if (!exts.length) return true;
                
                fext = pFile && pFile.length && pFile.slice(pFile.lastIndexOf(".")+1, pFile.length);
                
                if (pFile && pFile.length > 0) {
                    if (exts.forEach) {
                        exts.forEach(function(e) {
                           if (fext.toLowerCase() === e) valid = true;
                        });
                    } else if (exts === fext.toLowerCase()) {
                        valid = true;
                    }
                }
                return valid;
            };
            
            $(document).ready(function() {
                var theForm = document.getElementById('fileForm');
                var theType = document.getElementById('hftype');
                if (theType) isFile = ("url" !== theType.value);
                
                var isElementValid = function(element) {
                    if (element.required) {
                        return !element.validity.valueMissing;
                    } else {
                        return element.value && element.value !== "";
                    }
                };
                
                var isFileValid = function(element) {
                    return (element.value && element.value.length > 0 && isFileType(element.value));
                };
                
                if (null !== theForm) {
                    $(theForm).on("submit", function(evt) {
                        var isValid = isElementValid(theForm['ftitle']) && isElementValid(theForm['fdescription']);
                        if (!isFile) {
                            isValid = isValid && isElementValid(theForm['extfile']);
                            
                            //submit form ajax
                            $.ajax({
                                url: $(theForm).attr('action'),
                                cache: false,
                                data: $(theForm).serialize(),
                                type: 'POST',
                                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                                success: function(data) {
                                    if (data.status === "ok") {
                                        var loc = '<%= paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_CONTENT).setMode(SWBResourceURL.Mode_VIEW) %>';
                                        window.location = loc;
                                    }
                                }
                            });
                        } else {
                            var fup = document.getElementById('ffile');
                            isValid = isFileValid(fup);
                            
                            $("#fUploadFrame").on("load", function() {
                                var data = JSON.parse($("#fUploadFrame").contents().text());
                                if (data && data.status === "ok") {
                                    window.top.location.reload();
                                }
                            });
                            
                            //submit form files
                            if (isValid) {
                                theForm.target = "fUploadFrame";
                                theForm.submit();
                            } else {
                                $(fup).closest(".form-group").addClass("has-error");
                            }
                        }
                        evt.preventDefault();
                        return false;
                    });
                    
                    if (theForm['ffile']) {
                        theForm['ffile'].addEventListener("change", function(evt) {
                            if (isFileValid(evt.target)) {
                                $(evt.target).closest(".form-group").removeClass("has-error");
                            } else {
                                $(evt.target).closest(".form-group").addClass("has-error");
                            }
                        });
                    }
                    theForm['ftitle'].addEventListener("keyup", function(evt) {
                        if (isElementValid(evt.target)) {
                            $(evt.target).closest(".form-group").removeClass("has-error");
                        } else {
                            $(evt.target).closest(".form-group").addClass("has-error");
                        }
                    });
                    theForm['fdescription'].addEventListener("keyup", function(evt) {
                        if (isElementValid(evt.target)) {
                            $(evt.target).closest(".form-group").removeClass("has-error");
                        } else {
                            $(evt.target).closest(".form-group").addClass("has-error");
                        }
                    });
                    if (theForm['extfile']) {
                        theForm['extfile'].addEventListener("keyup", function(evt) {
                            if (isElementValid(evt.target)) {
                                $(evt.target).closest(".form-group").removeClass("has-error");
                            } else {
                                $(evt.target).closest(".form-group").addClass("has-error");
                            }
                        });
                    }
                }
                
                $("#fileToggleRadio").on("click", function(evt) {
                    $("#fileSelect").show();
                    $("#linkSelect").hide();
                    $("#extfile").attr("required", false);
                    $("#ffile").attr("required", true);
                    isFile = true;
                });
                
                $("#urlToggleRadio").on("click", function(evt) {
                    $("#fileSelect").hide();
                    $("#linkSelect").show();
                    $("#extfile").attr("required", true);
                    $("#ffile").attr("required", false);
                    isFile = false;
                });
                
                $("#fileSelect").show();
                $("#linkSelect").hide();
                isFile && $("#ffile").attr("required", true);
            });
        })();
    </script>
    <%
}
%>