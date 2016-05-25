<%-- 
    Document   : upload
    Created on : 20/01/2015, 12:17:12 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    try {
        if (ServletFileUpload.isMultipartContent(request)) {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : multiparts) {
                if (!item.isFormField()) {
                    String fname = new File(item.getName()).getName();
                    if (fname.contains("\\")) {
                        fname = fname.substring(fname.lastIndexOf("\\") + 1);
                    } else if (fname.contains("/")) {
                        fname = fname.substring(fname.lastIndexOf("/") + 1);
                    }

                    //Replace special characters in file name to avoid 404 when linking directly to file
                    if (fname.lastIndexOf(".") > -1) {
                        String tfname = fname.substring(0, fname.lastIndexOf("."));
                        String tfext = fname.substring(fname.lastIndexOf("."), fname.length());

                        fname = SWBUtils.TEXT.replaceSpecialCharacters(tfname, true) + tfext;
                    }
                    item.write(new File(SWBPortal.getWorkPath() + "/models/documenter/uploader/" + File.separator + fname));
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
