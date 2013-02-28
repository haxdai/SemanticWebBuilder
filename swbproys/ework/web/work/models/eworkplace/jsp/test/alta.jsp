<%-- 
    Document   : services
    Created on : 17-oct-2012, 15:59:16
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.semanticwb.*"%>
<%@page import="mx.com.infotec.intranet.login.Services" %>
<%@page import="mx.com.infotec.intranet.login.UserInformation" %>
<%@page import="java.io.*" %>
<%


    StringBuilder csv = new StringBuilder();
    csv.append(sr.fechaInicioContrato);
    csv.append(",");
    
    csv.append(",");
    csv.append(",");
    csv.append(",");
    csv.append(",");
    csv.append(",");
    csv.append(",");








    Services s = new Services();
    UserInformation userInformation;
    String login = "victor.lorenzana";
    userInformation = s.getUserInformation(login);
    out.println("apelldio 1:"+userInformation.getPApellido());
    out.println("apellido 2:"+userInformation.getSApellido());
    out.println("nombre:"+userInformation.getPrimerNombre());
    out.println("nombre:"+userInformation.getSegundoNombre());
    out.println("email:"+userInformation.getEmail());
    out.println("genero:"+userInformation.getGenero());
    out.println("rfc"+userInformation.getRFC());
    out.println(s.getCNFromLogin(login));
    
    
   userInformation.getArea()
    
    
    s.modifyPrimerNombre(login, "vic");
    s.modifyApellidoPaterno(login, "Lorencito");
    s.modifyApellidoMaterno(login, "Gonza");
    s.modifyEmail(login, "victorl@infotec.com.mx");
    //rfcLOGV7312187C8
    s.modifyRFC(login, "logv7312187D8".toUpperCase());
    
    
    userInformation = s.getUserInformation(login);
    out.println("<hr/>");
    out.println("apelldio 1:"+userInformation.getPApellido());
    out.println("apellido 2:"+userInformation.getSApellido());
    out.println("nombre:"+userInformation.getPrimerNombre());
    out.println("nombre:"+userInformation.getSegundoNombre());
    out.println("email:"+userInformation.getEmail());
    out.println("genero:"+userInformation.getGenero());
    out.println("rfc"+userInformation.getRFC());
    
    out.println("<hr/><br/>");
    out.println("getApplicationPath="+SWBUtils.getApplicationPath()+"/work/models/"+"eworkplace/"+"datos/procesos/contratos/");
    out.println("<br/>");
    
    
    String path = SWBUtils.getApplicationPath()+"/work/models/"+"eworkplace/"+"data/procesos/contratos/";
    //String path = SWBUtils.getApplicationPath()+"/work/models/"+instance.getWebSite().getId()+"data/procesos/contratos/";
    BufferedWriter bfw = null;
    try
    {
        File fichero = new File(path+"f1.csv");
        FileWriter fstream = new FileWriter(fichero);
        bfw = new BufferedWriter(fstream);
        bfw.write("Hello Java");
    }
    catch (Exception e)
    {
        System.err.println("Error: " + e.getMessage());
        out.println(e);
    }
    finally {
        try
        {
            if(bfw != null)
            {
                bfw.flush();
                bfw.close();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            out.println(ex);
        }
    }
%>