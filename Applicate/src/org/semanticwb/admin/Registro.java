/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.applicate.ListEmail;
import org.semanticwb.applicate.ProfileCompany;
import org.semanticwb.applicate.ProfileDevelop;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author gabriela.rosales
 */
public class Registro extends GenericResource {

    private static Logger log = SWBUtils.getLogger(Registro.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            String path = "/swbadmin/jsp/Applicate/registro.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException ex) {
            log.error("Error in AdminNewslatter : " + ex);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (mode.equals(SWBResourceURL.Mode_VIEW)) {
            doView(request, response, paramRequest);
        } else if (mode.equals("addDevelop")) {
            try {
                String path = "/swbadmin/jsp/Applicate/registroDesarrollador.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(path);
                request.setAttribute("paramRequest", paramRequest);
                rd.include(request, response);
            } catch (ServletException ex) {
                log.error("Error in AdminNewslatter : " + ex);
            }

        } else if (mode.equals("addCompany")) {

            try {
                String path = "/swbadmin/jsp/Applicate/registroEmpresa.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(path);
                request.setAttribute("paramRequest", paramRequest);
                rd.include(request, response);
            } catch (ServletException ex) {
                log.error("Error in AdminNewslatter : " + ex);
            }

        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebSite ws = response.getWebPage().getWebSite();

        if ("addDevelop".equals(action)) {
            System.out.println("entro en addDevelop");
            String securCodeSent = "";
            String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
            String name = "";
            String apePat = "";
            String apeMat = "";
            String email = "";
            String pais = "";
            String state = "";
            String strFecha = "";// "05-12-1986"; //;request.getParameter("date") == null ? "" : request.getParameter("date"); //dd-mm-yyyy
            Date fecha = null;
            String bio = "";
            String[] areas = null;
            String gender = "";
            String nameUser = "";
            String password = "";
            boolean suscripcion = false;
            FileItem currentFile = null;
            String name1 = null;
            String suscription = "";
            final Registro.Percentage per = new Registro.Percentage();
            List<String> a = new ArrayList<String>();

            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    for (FileItem item : multiparts) {

                        if (!item.isFormField()) {
                            InputStream is = item.getInputStream();
                            currentFile = item;
                            if (!currentFile.getName().equals("")) {
                                name1 = currentFile.getName(); //currentFile.getName().substring(currentFile.getName().lastIndexOf("."));
                            }
                        } else {
                            String fieldName = item.getFieldName();
                            String fieldValue = item.getString();
                            System.out.println("NNOMBRE DE LA PROPIEDAD: " + fieldName);
                            if (fieldName.equals("cmnt_seccode")) {
                                securCodeSent = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("name")) {
                                name = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("apePat")) {
                                apePat = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("apeMat")) {
                                apeMat = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("email")) {
                                email = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("country")) {
                                pais = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("state")) {
                                state = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("date")) {
                                System.out.println("es iguala fecha");
                                strFecha = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                                System.out.println("strFecha" + strFecha);
                            } else if (fieldName.equals("bio")) {

                                bio = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("areaExpertise")) {
                                String area = SWBUtils.TEXT.decode(fieldValue, "UTF-8");

                                System.out.println("--->area" + area);
                                a.add(area);

                            } else if (fieldName.equals("gender")) {
                                gender = SWBUtils.TEXT.decode(fieldValue, "UTF-8");
                            } else if (fieldName.equals("nameUser")) {
                                nameUser = SWBUtils.TEXT.decode(fieldValue, "UTF-8");
                            } else if (fieldName.equals("password")) {
                                password = SWBUtils.TEXT.decode(fieldValue, "UTF-8");
                            } else if (fieldName.equals("suscription")) {
                                suscription = SWBUtils.TEXT.decode(fieldValue, "UTF-8");

                            }

                        }
                    }




                    if (securCodeCreated != null && securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                        System.out.println("si son iguales");

                        fecha = new Date(strFecha);
                        System.out.println("FEcha" + fecha);


                        String path = SWBPortal.getWorkPath() + "/models/Applicate/images"; //C:\SWB4\swb\build\web\work\models\Applicate\images
                        System.out.println("path" + path);
                        File file = new File(path);
                        if (!file.exists()) {
                            file.mkdirs();
                        }

                        String photoName = path + "/" + name1;
                        currentFile.write(new File(photoName));
                        File f = new File(photoName);

                        UserRepository usrep = SWBContext.getDefaultRepository();
                        User user = usrep.createUser();
                        user.setFirstName(name);
                        user.setLastName(apePat);
                        user.setSecondLastName(apeMat);
                        user.setActive(false);
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setLogin(email);

                        ProfileDevelop profileDevelop = ProfileDevelop.ClassMgr.createProfileDevelop(response.getWebPage().getWebSite());
                        profileDevelop.setUserProfileDevelop(user);
                        profileDevelop.setBio(bio);
                        profileDevelop.setFechanacimiento(fecha);
                        profileDevelop.setGenero(gender);
                        Boolean addSucription = Boolean.parseBoolean(suscription);
                        profileDevelop.setSuscripcion(addSucription);
                        profileDevelop.setPais(pais);
                        profileDevelop.setEstado(state);
                        profileDevelop.setImagenProfileDevelop(photoName);


                        if (!a.isEmpty()) {
                            areas = new String[a.size()];
                            a.toArray(areas);
                        }
                        for (int i = 0; i < areas.length; i++) {
                            String area = areas[i];
                            profileDevelop.addAreasExpertiseDevelop(area);
                        }

                        String body;
                        System.out.println("antes del email");
                        body = "Este es un correo de verificación \n"
                                + "Gracias por escribirse a Applicate.mx \n"
                                + "Porfavor haga click en el siguiente enlace\n"
                                + "para seguir con la verificacion de sus datos \n"
                                + " <a href=\"http://localhost:8080/swbadmin/jsp/Applicate/confirmacionUsuario.jsp?userId=" + user.getId() + "\">Enlace</a>";
                        SWBUtils.EMAIL.sendMail(email, "Confirmación de cuenta", "hola");

                        System.out.println("despues del email");

                        if (addSucription) {
                            ListEmail listemail = null;

                            listemail = ListEmail.ClassMgr.createListEmail(response.getWebPage().getWebSite());
                            listemail.setEmail(email);
                            listemail.setVerificacion(false);
                            body = "Este es un correo de verificación \n"
                                    + "Gracias por escribirse al Newslatter de  Applicate.mx \n"
                                    + "Porfavor haga click en el siguiente enlace\n"
                                    + "para seguir con la verificacion de sus datos \n"
                                    + " <a href=\"http://localhost:8080/swbadmin/jsp/Applicate/confirmacionNewslatter.jsp?userId=" + user.getId() + "\">Enlace</a>";
                            SWBUtils.EMAIL.sendMail(email, "Confirmación de cuenta", "hola");



                        }
                        response.setRenderParameter("msg", "Por favor revise su correo.");
                        response.setMode(SWBResourceURL.Mode_VIEW);
                    } else {
                        response.setRenderParameter("msg", "El texto de la imagen no coincide con el capturado. Por favor escribalo nuevamente.");
                        response.setMode(response.Mode_VIEW);
                        response.setCallMethod(response.Call_CONTENT);
                    }
                } catch (Exception e) {
                }
            }
        } else if ("addCompany".equals(action)) {

            String securCodeSent = "";
            String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
            String nameCompany = "";
            String name = "";
            String apePat = "";
            String apeMat = "";
            String imagen = "";
            String activity = "";
            String year = "";
            String month = "";
            String old = "";
            String numberEmployee = "";
            String servi = "";
            String service[] = null;
            String email = "";
            String password = "";
            List<String> a = new ArrayList<String>();

            FileItem currentFile = null;
            String name1 = null;
            final Registro.Percentage per = new Registro.Percentage();

            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    for (FileItem item : multiparts) {

                        if (!item.isFormField()) {
                            InputStream is = item.getInputStream();
                            currentFile = item;
                            if (!currentFile.getName().equals("")) {
                                name1 = currentFile.getName();// currentFile.getName().substring(currentFile.getName().lastIndexOf("."));
                            }
                        } else {
                            String fieldName = item.getFieldName();
                            String fieldValue = item.getString();
                            if (fieldName.equals("cmnt_seccode")) {
                                securCodeSent = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("nameCompany")) {
                                nameCompany = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("name")) {
                                name = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("apePat")) {
                                apePat = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("apeMat")) {
                                apeMat = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("activity")) {
                                activity = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("year")) {
                                year = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("month")) {
                                month = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("numberEmployee")) {
                                numberEmployee = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("service")) {
                                servi = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                                System.out.println("service" + servi);
                                a.add(servi);
                            } else if (fieldName.equals("email")) {
                                email = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            } else if (fieldName.equals("password")) {
                                password = SWBUtils.TEXT.decode(fieldValue, "UTF-8").trim();
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }

            if (securCodeCreated != null && securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                try {


                    UserRepository usrep = SWBContext.getDefaultRepository();
                    User user = usrep.createUser();
                    user.setFirstName(name);
                    user.setLastName(apePat);
                    user.setSecondLastName(apeMat);
                    user.setActive(false);
                    user.setEmail(email);
                    user.setLogin(email);
                    user.setPassword(password);

                    String path = SWBPortal.getWorkPath() + "/models/Applicate/images"; //C:\SWB4\swb\build\web\work\models\Applicate\images
                    System.out.println("path" + path);
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdirs();
                    }

                    String photoName = path + "/" + name1;
                    currentFile.write(new File(photoName));
                    File f = new File(photoName);

                    ProfileCompany profileCompany = ProfileCompany.ClassMgr.createProfileCompany(ws);
                    old = year + "|" + month;
                    profileCompany.setAntiguedad(old);
                    profileCompany.setGiroActividad(activity);
                    profileCompany.setImagenCompany(imagen);
                    profileCompany.setNombreEmpresa(name);
                    int numberEmployyeN = Integer.parseInt(numberEmployee);
                    profileCompany.setNumeroEmpleados(numberEmployyeN);
                    profileCompany.setImagenCompany(photoName);
                    if (!a.isEmpty()) {
                        service = new String[a.size()];
                        a.toArray(service);
                    }
                    for (int i = 0; i < service.length; i++) {
                        String string = service[i];
                        profileCompany.addProductosServicios(string);
                    }


                    String body;

                    body = "Este es un correo de verificación \n"
                            + "Gracias por escribirse a Applicate.mx \n"
                            + "Porfavor haga click en el siguiente enlace\n"
                            + "para seguir con la verificacion de sus datos \n"
                            + " <a href=\"http://localhost:8080/swbadmin/jsp/Applicate/confirmacionUsuario.jsp?userId=" + name + "\">Enlace</a>";
                    SWBUtils.EMAIL.sendMail(email, "Confirmación de cuenta", "hola");
                    response.setRenderParameter("msg", "Por favor revise su correo.");

                    response.setMode(SWBResourceURL.Mode_VIEW);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(AdminProfileCompany.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                response.setRenderParameter("msg", "No coincide el texto de la imagen con el capturado. Escribirlo nuevamente.");
                response.setMode(response.Mode_VIEW);
                response.setCallMethod(response.Call_CONTENT);
            }


        }
    }

    private class Percentage {

        int per = 0;

        public void setPercentage(int per) {
            this.per = per;
        }

        public int getPercentage() {
            return per;
        }
    }
}
