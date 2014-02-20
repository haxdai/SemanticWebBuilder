/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.admin;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
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
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.semanticwb.applicate.ListEmail;

/**
 *
 * @author gabriela.rosales
 */
public class AdminProfileDevelop extends GenericResource {

    private static Logger log = SWBUtils.getLogger(AdminProfileDevelop.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = "/swbadmin/jsp/Applicate/registroDesarrollador.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
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
                                List<String> a = new ArrayList<String>();
                                System.out.println("--->area" + area);
                                a.add(area);
                                areas = new String[a.size()];
                                a.toArray(areas);
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

                     fecha = new Date(strFecha);
                     System.out.println("FEcha"+fecha);

                    String path = SWBPortal.getWorkPath() + "/tmp";
                    System.out.println("path" + path);
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdirs();
                    }

                    String photoName = path + "/" + name1;

                    if (securCodeCreated != null && securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                        System.out.println("si son iguales");

                        UserRepository usrep = SWBContext.getDefaultRepository();
                        User user = usrep.createUser();
                        user.setFirstName(name);
                        user.setLastName(apePat);
                        user.setSecondLastName(apeMat);
                        user.setActive(false);
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setLogin(email);


                        currentFile.write(new File(photoName));
                        path = user.getWorkPath();
                        user.setPhoto(path + "/" + name);
                        per.setPercentage(100);
                        File f = new File(photoName);
                        ProfileDevelop profileDevelop = ProfileDevelop.ClassMgr.createProfileDevelop(response.getWebPage().getWebSite());
                        profileDevelop.setUserProfileDevelop(user);
                        profileDevelop.setBio(bio);
                        profileDevelop.setFechanacimiento(fecha);
                        profileDevelop.setGenero(gender);
                        profileDevelop.setSuscripcion(suscripcion);
                        profileDevelop.setPais(pais);
                        profileDevelop.setPais(state);

                        for (int i = 0; i < areas.length; i++) {

                            String area = areas[i];
                            System.out.println("--->area" + area);
                            profileDevelop.addAreasExpertiseDevelop(area);

                        }

                        String body;
                        System.out.println("antes del email");
                        body = "Este es un correo de verificación \n"
                                + "Gracias por escribirse a Applicate.mx \n"
                                + "Porfavor haga click en el siguiente enlace\n"
                                + "para seguir con la verificacion de sus datos \n"
                                + " <a href=\"http://localhost:8080/swbadmin/jsp/Applicate/confirmacionUsuario.jsp?name=" + user.getId() + "\">Enlace</a>";
                        SWBUtils.EMAIL.sendMail(email, "Confirmación de cuenta", "hola");

                        System.out.println("despues del email");
                        Boolean addSucription = Boolean.parseBoolean(suscription);
                        if (addSucription) {
                            ListEmail listemail = null;

                            listemail = ListEmail.ClassMgr.createListEmail(response.getWebPage().getWebSite());
                            listemail.setEmail(email);
                            listemail.setVerificacion(false);
                            body = "Este es un correo de verificación \n"
                                    + "Gracias por escribirse al Newslatter de  Applicate.mx \n"
                                    + "Porfavor haga click en el siguiente enlace\n"
                                    + "para seguir con la verificacion de sus datos \n"
                                    + " <a href=\"http://localhost:8080/swbadmin/jsp/Applicate/confirmacionNewslatter.jsp?name=" + user.getId() + "\">Enlace</a>";
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
