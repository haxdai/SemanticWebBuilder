<%-- 
    Document   : upload
    Created on : 20/01/2015, 12:17:12 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    try {
        if (ServletFileUpload.isMultipartContent(request)) {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : multiparts) {
                if (!item.isFormField()) {
                    String name = new File(item.getName()).getName();
                    item.write(new File(SWBPortal.getWorkPath() + "/models/documenter/uploader/" + File.separator + name));
%>
<script language="javascript" type="text/javascript">
    window.parent.window.jbImagesDialog.uploadFinish({
        filename: '<%= "/work/models/documenter/uploader/" + item.getName()%>',
        result: '<%= "OK"%>',
        resultCode: '<%= item.getFieldName()%>'
    });
</script>
<%
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
