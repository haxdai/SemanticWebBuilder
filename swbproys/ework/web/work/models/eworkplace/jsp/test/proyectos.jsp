<%@page import="java.util.Date" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.text.ParseException" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="org.semanticwb.model.WebSite" %>
<%@page import="org.semanticwb.SWBUtils" %>
<%@page import="org.semanticwb.Logger" %>
<%@page import="org.semanticwb.base.db.DBConnectionPool" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>proyectos</title>
    </head>
    <body>
        <h3>proyectos!</h3>
<%
try {
    out.println("1 ");
    DBConnectionPool cp = SWBUtils.DB.getPool("ps");
    if(cp==null) {
        out.println("pool nulo");
        return;
    }
    out.println("2 ");
    Connection con = cp.getConnection();
    if(con==null){
        out.println("conexion nula");
        return;
    }
    out.println("3 ");
    Statement stmt = null;
    ResultSet rs = null;
    out.println("4 ");
    try
    {
        stmt = con.createStatement();
        out.println("5 ");
        if(stmt==null) {
            out.println("sentencia nula");
            return;
        }
        out.println("6 ");
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("proj.ProjectName ");
        query.append("FROM ProjectServer_Reporting_4.dbo.MSP_EpmProject_UserView AS proj ");
        
        out.println("<ul>");
        rs = stmt.executeQuery(query.toString());
        out.println("7 ");
        while (rs.next()) {
            out.println("<li>");
            out.println(rs.getString("ProjectName"));
            out.println("</li>");
        }
        out.println("</ul>");
    }
    catch(Exception e)
    {
        out.println("66666. ");
        out.println(e);
    }
    finally
    {
        if(rs!=null)
        {
            try {
                rs.close();                
            }catch(Exception e) {
                out.println("77777. ");
                out.println(e);
            }
            rs = null;
        }
        if(stmt!=null)
        {
            try {
                stmt.close();                
            }catch(Exception e) {
                out.println("88888. ");
                out.println(e);
            }
            stmt = null;
        }
    }
}catch(Exception e) {
    out.println("\n\n+++++++++++++++++ un error "+e);
}
%>
    </body>
</html>
