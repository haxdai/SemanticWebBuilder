/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.applicate.ProfileCompany;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author gabriela.rosales
 */
public class AdminProfileCompany extends GenericResource {

    private static Logger log = SWBUtils.getLogger(AdminProfileCompany.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            String path = "/swbadmin/jsp/Applicate/registroEmpresa.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException ex) {
            log.error("Error in AdminProfileCompany : " + ex);
        }


    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();


        if ("addCompany".equals(action)) {

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

            FileItem currentFile = null;
            String name1 = null;
            final Percentage per = new Percentage();

            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    for (FileItem item : multiparts) {

                        if (!item.isFormField()) {
                            InputStream is = item.getInputStream();
                            currentFile = item;
                            if (!currentFile.getName().equals("")) {
                                name1 = currentFile.getName().substring(currentFile.getName().lastIndexOf("."));
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
                                List<String> a = new ArrayList<String>();
                                a.add(servi);
                                service = new String[a.size()];
                                a.toArray(service);
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
                    //user.setRequestChangePassword(true);
                    user.setEmail(email);
                    user.setLogin(email);
                    user.setPassword(password);

                    String path = SWBPortal.getWorkPath() + "/tmp";
                    System.out.println("path" + path);
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdirs();
                    }

                    String photoName = path + "/" + name1;
                    currentFile.write(new File(photoName));
                    path = user.getWorkPath();
                    user.setPhoto(path + "/" + name);
                    per.setPercentage(100);
                    File f = new File(photoName);

                    WebSite ws = response.getWebPage().getWebSite();

                    ProfileCompany profileCompany = ProfileCompany.ClassMgr.createProfileCompany(ws);

                    profileCompany.setAntiguedad(old);
                    profileCompany.setGiroActividad(activity);
                    profileCompany.setImagenCompany(imagen);
                    profileCompany.setNombreEmpresa(name);
                    int numberEmployyeN = Integer.parseInt(numberEmployee);
                    profileCompany.setNumeroEmpleados(numberEmployyeN);

                    for (int i = 0; i < service.length; i++) {
                        String string = service[i];
                        profileCompany.addProductosServicios(string);
                    }

                    String body;

                    body = "Este es un correo de verificación \n"
                            + "Gracias por escribirse a Applicate.mx \n"
                            + "Porfavor haga click en el siguiente enlace\n"
                            + "para seguir con la verificacion de sus datos \n"
                            + " <a href=\"http://localhost:8080/swbadmin/jsp/Applicate/confirmacionUsuario.jsp?name=" + name + "\">Enlace</a>";
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
