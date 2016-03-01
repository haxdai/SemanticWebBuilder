<%-- 
    Document   : uploader
    Created on : 3/02/2015, 09:35:47 AM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String urlact = request.getParameter("urlact");
    String modelid = request.getParameter("modelid");
%>
<link href="/swbadmin/css/bootstrap/bootstrap.css" rel="stylesheet">
<link href="/swbadmin/css/fontawesome/font-awesome.css" rel="stylesheet">
<link href="/work/models/documenter/css/swbp.css" rel="stylesheet">
<script src="/swbadmin/js/jquery/jquery.js"></script>
<div class="container">
    <style>
        .shortcut .swbp-menu-vertical {
            width: 150px;
        }
        .shortcut {
            padding-top: 5px;
        }
    </style>
    <div class="swbp-content"> 
        <form id="uploadImg" class="form-horizontal" onsubmit="uploadOk();" action="<%= urlact%>" method="post" enctype="multipart/form-data">
            <div class="panel-body">
              
                <%
                    String basePath = SWBPortal.getWorkPath() + "/models/" + modelid + "/swp_DocumentationImage/";
                    File dir = new File(basePath);
                    if (dir.exists()) {
                %>
                <div class="row text-center">
                    <%
                        int i = 0;
                        for (File file : dir.listFiles()) {
                    %>
                    <a class="btn btn-default shortcut" onclick="selectImage('image_<%= i %>')">
                        <img id="image_<%= i %>" width="40" height="40" src="<%= SWBPortal.getWebWorkPath() %>/models/<%= modelid%>/swp_DocumentationImage/<%= file.getName() %>">
                        <span class="swbp-menu-vertical"><%= file.getName()%></span>
                    </a>
                    <%
                            i++;
                        }
                    %>
                </div>
                <%
                    }
                %>
                
                <br><br>
                <div class="input-group">
                    <span class="input-group-btn">
                        <span class="btn btn-default btn-file">
                            <span class="fa fa-cloud-upload"></span>
                            Seleccionar
                            <input required type="file" accept="image/jpg,image/png,image/jpeg,image/gif" name="fupload" id="fupload" class="form-control" />
                        </span>
                    </span>
                    <input type="text" id="nameLogo" class="form-control" disabled/>
                </div>
            </div>
            <div class="col-lg-12">
                <img id="thumbnil" style="width:20%; margin-top:10px;"/>
            </div>
            <div class="col-lg-12" id="spSave">
            </div>
                <input type="hidden" id="urise" name="urise">
            <div class="panel-footer">
                <button type="submit" class="btn btn-default"><span class="fa fa-save"></span> Guardar</button>
            </div>
        </form>
        <script type="text/javascript">
            function selectImage(element) {
                var a = $('#' + element);
                top.tinymce.activeEditor.windowManager.getParams().oninsert(window.location.origin + a.attr('src'), false);
                if(top.tinymce.activeEditor.id.indexOf('http') == 0){
                    top.tinymce.activeEditor.windowManager.close();
                }
                //top.tinymce.activeEditor.windowManager.getParams().oninsert(window.location.origin + '/work/models/<%= modelid%>/swp_DocumentationImage/' + element);
            }
            function uploadOk() {
                top.tinymce.activeEditor.windowManager.getParams().oninsert(window.location.origin + '/work/models/<%= modelid%>/swp_DocumentationImage/' + $('#nameLogo').val(),true);
                return true;
            }
            $(document).ready(function() {

                $('#fupload').on('change', function() {
                    var file = this.files[0];
                    console.log(file);
                    $('#nameLogo').val(file.name);
                    var img = document.getElementById("thumbnil");
                    img.file = file;
                    var reader = new FileReader();
                    reader.onload = (function(aImg) {
                        return function(e) {
                            aImg.src = e.target.result;
                            $('#spSave').empty();
                            console.log(e);
                            console.log(e.target);
                        };
                    })(img);
                    reader.readAsDataURL(file);
                });
            });
        </script>
    </div>
</div>