<%-- 
    Document   : cargaUsuariosNominales
    Created on : 24-abr-2012, 12:00:05
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="org.semanticwb.portal.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>carga de jefes inmediatos</title>
</head>
<body>
<%
    out.println("<p><br/><br/><hr/></p>");
    final String siteid = "eworkplace3";
try{
    final WebSite wsite = WebSite.ClassMgr.getWebSite(siteid);
    if(wsite != null)
    {
        User user;
        String email;
        final UserRepository ur = wsite.getUserRepository();
        //---------------
        email = "julio.aguilar@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Director");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "mario.alvarado@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAIC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "alejandro.arestegui@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("OIC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Director");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "victor.aupart@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DADT");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "patricia.avila@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAIC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "fausto.beltran@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAA");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Director");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "alfredo.burgos@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DADT");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Director");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "sergio.carrera@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DE");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Director");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "everardo.cisneros@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DADT");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "alejandro.delossantos@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAA");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "raymundo.garcia@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAIC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "israel.garrido@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DADT");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "jose.gonzalez@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAA");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "patricia.guerrero@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("OIC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "maria.luna@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DADT");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "salvador.mar@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAA");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "junior.marin@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DADT");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "pedro.martinez@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAA");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "pedro.meza@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAA");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "armando.peralta@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAAP");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Director");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "jorge.pi@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAIC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "juan.pineda@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAAP");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "gabriel.riancho@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DADT");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "carlos.ricano@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "jesus.rios@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "rebeca.rojas@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAA");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "jafet.sanchez@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAAP");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Subgerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "javier.solis@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "juan.tellez@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAIC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Director");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
        email = "eduardo.zapien@infotec.com.mx";
        if(SWBUtils.EMAIL.isValidEmailAddress(email)) {
            user = ur.getUserByEmail(email);
            if(user==null) {
                out.print("<p style=\"color:red\">el usuario con email "+email+" no existe</p>");
            }else {
                if(user.isValid() && user.isActive()) {
                    out.print("<p>procesando usuario <strong>"+user.getFullName()+"<strong>....");
                    UserGroup ug = ur.getUserGroup("DAC");
                    if(user.hasUserGroup(ug)) {
                        out.print("<span style=\"color:#C39\"> ya tiene el grupo "+ug+"</span>");
                    }else {
                        user.addUserGroup(ug);
                        out.print("<span style=\"color:green\">listo grupo.</span>");
                    }
                    Role role = ur.getRole("Gerente");
                    if(user.hasRole(role)) {
                        out.print("<span style=\"color:blue\"> ya tiene el role "+role+"</span>");
                    }else {
                        user.addRole(role);
                        out.print("<span style=\"color:green\">listo role.</span>");
                    }
                    out.println("</p>");
                }else {
                    out.print("<p style=\"color:red\">el usuario "+user.getFullName()+" es inválido</p>");
                }
            }
        }else {
            out.print("<p style=\"color:red\">el email "+email+" no es válido</p>");        
        }
        //---------------
    }else {
        out.print("<p>sitio nulo</p>");
    }
}catch(Exception e) {
    e.printStackTrace(System.out);
}
    out.flush();
%>
</body>
</html>