/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.segob.pressroom.resources;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.resources.sem.pressroom.Category;
import org.semanticwb.portal.resources.sem.pressroom.Content;
import org.semanticwb.portal.resources.sem.pressroom.Files;
import org.semanticwb.portal.resources.sem.pressroom.Photos;
import org.semanticwb.servlet.internal.UploadFormElement;
import org.apache.commons.fileupload.FileItem;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.resources.sem.pressroom.ContentPriority;
import org.semanticwb.portal.resources.sem.pressroom.Profile;

/**
 *
 * @author jorge.jimenez
 */
public class ContentMgr extends GenericResource {

    public static Logger log = SWBUtils.getLogger(ContentMgr.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Iterator<Category> categoryIterator = null;
        User user = paramRequest.getUser();
        boolean read = false;
        boolean write = false;
        boolean publish = false;
        boolean delete = false;
        boolean admin = false;
        if (user != null) {
            SemanticProperty semProp = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#profile");
            if (semProp != null) {
                SemanticObject semObj = user.getSemanticObject().getObjectProperty(semProp);
                if (semObj != null) {
                    Profile profile = (Profile) semObj.createGenericInstance();
                    categoryIterator = profile.listCategories();
                    admin = profile.isAdministration();
                    write = profile.isWite();
                    read = profile.isRead();
                    publish = profile.isPublish();
                    delete = profile.isDelete();
                }
            }
        }

        List<Content> allNoticias = new ArrayList<Content>();
        if (categoryIterator != null && (read || write || publish || delete || admin)) {
            while (categoryIterator.hasNext()) {
                Category categoria = categoryIterator.next();
                Iterator<Content> it = categoria.listContents();
                while (it.hasNext()) {
                    Content noticia = it.next();
                    allNoticias.add(noticia);
                }
            }
            // ordenarlas descendentemente por fecha de inicio de publicacion
            Collections.sort(allNoticias, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Content p1 = (Content) o1;
                    Content p2 = (Content) o2;
                    return -(new Long(p1.getStartDate().getTime()).compareTo(new Long(p2.getStartDate().getTime())));
                }
            });
        } 
        // JFMR paginacion -----------------------------------------------------------------------------------------------------------------------------------------
        int pages2show = 7; // cuantas paginas mostrar a cada lado de la current page
        int pageLen = 20; // cuantos registros por pagina mostrar
        int idx = 0;
        int page = 1;
        int totPages = (int) Math.ceil((double) allNoticias.size() / (double) pageLen);
        if (request.getParameter("page") == null) {
            Object prcp = request.getSession().getAttribute("PRContentCurrentPage");
            if (prcp != null) {
                page = ((Integer) prcp).intValue();
            }
        } else {
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                //e.printStackTrace();
                //log.error("Error in CategoryMgr's view mode", e);
            }
        }
        if (page < 1 || page > totPages) {
            page = 1;
        }
        idx = (page - 1) * pageLen;
        int idxEnd = idx + pageLen;
        int i = 0;
        List<Content> noticiasPaginadas = new ArrayList<Content>();
        for (Content noticia : allNoticias) {
            if (i >= idx && i < idxEnd) {
                noticiasPaginadas.add(noticia);
            }
            if (i >= idxEnd) {
                break;
            }
            i++;
        }
        Iterator<Content> noticiasPaginadasIterator = noticiasPaginadas.iterator();
        request.getSession().setAttribute("PRContentCurrentPage", new Integer(page));
        request.setAttribute("pag_pages2show", new Integer(pages2show));
        request.setAttribute("pag_totPages", new Integer(totPages));
        request.setAttribute("pag_curPage", new Integer(page));
        request.setAttribute("noticiasPaginadasIterator", noticiasPaginadasIterator);
        // JFMR paginacion -----------------------------------------------------------------------------------------------------------------------------------------
        Iterator<ContentPriority> it = ContentPriority.ClassMgr.listContentPriorities();
        if (it.hasNext()) {
            request.setAttribute("contentPrincipal", it.next().getContentPriority());
        } else {
            request.setAttribute("contentPrincipal", null);
        }
        String path = "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/pressroom/ContentMgr/ListContent.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            // System.out.println("e.getMessage(): " + e.getMessage());
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if (action.equals("add")) {
            try {
                String categoria = request.getParameter("Category");
                SemanticObject objCat = SemanticObject.createSemanticObject(categoria);
                Category cat = (Category) objCat.createGenericInstance();
                Content conte = Content.ClassMgr.createContent(response.getWebPage().getWebSite());
                conte.setCategory(cat);
                int numCon = 0;
                String a = request.getParameter("numConsecutivo");
                if (a != null && !a.equals("")) {
                    numCon = Integer.parseInt(request.getParameter(Content.swbpress_numConsecutivo.getName()));
                }
                conte.setNumConsecutivo(numCon);
                if (numCon != 0) {
                    int numcat = cat.getCatNumConsecutivo();
                    if (numCon > numcat) {
                        cat.setCatNumConsecutivo(numCon);
                    }
                }
                conte.setTitle(request.getParameter(Content.swb_title.getName()));
                conte.setPlace(request.getParameter(Content.swbpress_place.getName()));
                conte.setCreator(response.getUser());
                conte.setCreated(new Timestamp(new Date().getTime()));
                conte.setDescription(request.getParameter(Content.swb_description.getName()));
                String contenido=request.getParameter(Content.swbpress_content.getName());
                //contenido = contenido.replace("<br />", " ");
                //contenido=contenido.replace("<p />", " ");
                //contenido=contenido.replace("<o:p />", " ");
                int ult = contenido.lastIndexOf("endif]-->");
                if(ult>-1){
                    ult = ult + 9;
                    contenido = contenido.substring(ult, contenido.length());
                }
                conte.setContent(contenido);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = request.getParameter(Content.swbpress_startDate.getName());
                Date di = sdf.parse(date);
                conte.setStartDate(di);
                date = request.getParameter(Content.swbpress_endDate.getName());
                Calendar cdf = Calendar.getInstance();
                cdf.setTime(di);
                cdf.add(Calendar.YEAR, 5);
                Date df = cdf.getTime();
                conte.setEndDate(df);
                cat.addContent(conte);
                processFiles(request, response.getWebPage().getWebSite(), conte.getSemanticObject());
                conte.setWebPage(response.getWebPage().getWebSite().getWebPage("Sintesis_Informativa"));
            } catch (Exception e) {
                log.event(e);
            }
        } else if (action.equals("edit") && request.getParameter("uriCat") != null && request.getParameter("uriCont") != null) {
            SemanticObject obj = SemanticObject.createSemanticObject(URLDecoder.decode(request.getParameter("uriCont")));
            Content conte = (Content) obj.createGenericInstance();
            String categoris = request.getParameter("uriCat");//uri de la categoria anterior
            try {
                String categoria = request.getParameter("Category");
                SemanticObject objCat = SemanticObject.createSemanticObject(categoria);
                Category cat = (Category) objCat.createGenericInstance();//categoria elegida
                conte.setCategory(cat);
                conte.setTitle(request.getParameter(Content.swb_title.getName()));
                conte.setPlace(request.getParameter(Content.swbpress_place.getName()));
                conte.setUpdated(new Timestamp(new Date().getTime()));
                conte.setModifiedBy(response.getUser());
                conte.setDescription(request.getParameter(Content.swb_description.getName()));
                conte.setContent(request.getParameter(Content.swbpress_content.getName()));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = request.getParameter(Content.swbpress_startDate.getName());
                Date di = sdf.parse(date);
                conte.setStartDate(di);
                date = request.getParameter(Content.swbpress_endDate.getName());
                Calendar cdf = Calendar.getInstance();
                cdf.setTime(di);
                cdf.add(Calendar.YEAR, 5);
                Date df = cdf.getTime();
                conte.setEndDate(df);
                processFiles(request, response.getWebPage().getWebSite(), conte.getSemanticObject());
                if (!categoris.equals(cat.getURI())) {
                    SemanticObject objcatan = SemanticObject.createSemanticObject(categoris);
                    Category cat1 = (Category) objcatan.createGenericInstance();//categoria anterior
                    Iterator<Content> itn = cat1.listContents();
                    int numCon = 0;
                    String a = request.getParameter("numConsecutivo");
                    if (a != null && !a.equals("")) {
                        numCon = Integer.parseInt(request.getParameter(Content.swbpress_numConsecutivo.getName()));
                    }
                    conte.setNumConsecutivo(numCon);
                    if (numCon != 0) {
                        int numcat = cat.getCatNumConsecutivo();
                        if (numCon > numcat) {
                            cat.setCatNumConsecutivo(numCon);
                        }
                    }
                    int conse = 0;
                    while (itn.hasNext()) {
                        Content cont = (Content) itn.next();
                        if (!cont.equals(conte)) {
                            if (conse < cont.getNumConsecutivo()) {
                                conse = cont.getNumConsecutivo();
                            }
                        }
                    }
                    cat1.setCatNumConsecutivo(conse);
                    Content conte2 = (Content) obj.cloneObject().createGenericInstance();
                    cat.addContent(conte2);
                    SWBUtils.IO.createDirectory(SWBPortal.getWorkPath() + conte2.getWorkPath());
                    Iterator it = conte.listPhotos();
                    while (it.hasNext()) {
                        Photos phot = (Photos) it.next();
                        String photo = phot.getNamePhoto();
                        SWBUtils.IO.copy(SWBPortal.getWorkPath() + conte.getWorkPath() + "/" + photo, SWBPortal.getWorkPath() + conte2.getWorkPath() + "/" + photo, false, null, null);
                    }
                    it = conte.listFiles();
                    while (it.hasNext()) {
                        Files fil = (Files) it.next();
                        String file = fil.getNameFile();
                        SWBUtils.IO.copy(SWBPortal.getWorkPath() + conte.getWorkPath() + "/" + file, SWBPortal.getWorkPath() + conte2.getWorkPath() + "/" + file, false, null, null);
                    }
                    cat1.removeContent(conte);
                    SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + conte.getWorkPath());
                }
                conte.setWebPage(response.getWebPage().getWebSite().getWebPage("Sintesis_Informativa"));
            } catch (Exception e) {
                log.event(e);
            }
        } else if (action.equals("delete") && request.getParameter("uri") != null) {
            String uri = URLDecoder.decode(request.getParameter("uri"));
            if (uri != null) {
                SemanticObject obj = SemanticObject.createSemanticObject(uri);
                Content conte = (Content) obj.createGenericInstance();
                conte.removeCategory();
                conte.remove();
            }
        } else if (action.equals("estatus") && request.getParameter("uri") != null) {
            String uri = URLDecoder.decode(request.getParameter("uri"));
            if (uri != null) {
                SemanticObject obj = SemanticObject.createSemanticObject(uri);
                Content conte = (Content) obj.createGenericInstance();
                boolean estatus = conte.isActive();
                if (estatus) {
                    conte.setActive(false);
                } else {
                    conte.setActive(true);
                }
            }
        } else if (action.equals("prioridad") && request.getParameter("uri") != null) {
            String uri = URLDecoder.decode(request.getParameter("uri"));
            if (uri != null) {
                SemanticObject obj = SemanticObject.createSemanticObject(uri);
                Content conte = (Content) obj.createGenericInstance();
                Iterator<ContentPriority> it = ContentPriority.ClassMgr.listContentPriorities();
                if (!it.hasNext()) {
                    ContentPriority cp = ContentPriority.ClassMgr.createContentPriority(response.getWebPage().getWebSite());
                    cp.setContentPriority(conte);
                } else {
                    ContentPriority cp = it.next();
                    Content actual = cp.getContentPriority();
                    if (conte.equals(actual)) {
                        ContentPriority.ClassMgr.removeContentPriority(cp.getId(), response.getWebPage().getWebSite());
                    } else {
                        cp.setContentPriority(conte);
                    }
                }
            }
        }
        response.setMode(response.Mode_VIEW);
    }

    public void doAddCont(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/pressroom/ContentMgr/AddContent.jsp";
        org.semanticwb.platform.SemanticObject ret = null;
        ret = Content.sclass.getSemanticObject();
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("sobj", ret);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void doEditCont(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/pressroom/ContentMgr/EditContent.jsp";
        org.semanticwb.platform.SemanticObject ret = null;
        ret = Content.sclass.getSemanticObject();
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("sobj", ret);
            request.setAttribute("uri", request.getParameter("uri"));
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (mode.equals("addCont")) {
            doAddCont(request, response, paramRequest);
        } else if (mode.equals("editCont")) {
            doEditCont(request, response, paramRequest);
        } else if (mode.equals("change")) {
            doChange(request, response, paramRequest);
        } else if (mode.equals("file")) {
            doFile(request, response, paramRequest);
        } else {
            try {
                super.processRequest(request, response, paramRequest);
            } catch (Exception e) {
            }
        }
    }

    public void doFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String uriCont = request.getParameter("uriCont");
            String phot = request.getParameter("phot");
            String file = request.getParameter("fil");
            String fname = request.getParameter("fname");
            SemanticObject objCont = SemanticObject.createSemanticObject(uriCont);
            Content cont = (Content) objCont.createGenericInstance();
            if (phot != null) {
                SemanticObject objPhoto = SemanticObject.createSemanticObject(phot);
                Photos photo = (Photos) objPhoto.createGenericInstance();
                cont.removePhoto(photo);

                File arc = new File(SWBPortal.getWorkPath() + cont.getWorkPath() + "/" + fname);
                if (arc.exists()) {
                    arc.delete();
                }
                arc = new File(SWBPortal.getWorkPath() + cont.getWorkPath() + "/thumb___" + fname);
                if (arc.exists()) {
                    arc.delete();
                }
            }
            if (file != null) {
                SemanticObject objFile = SemanticObject.createSemanticObject(file);
                Files fil = (Files) objFile.createGenericInstance();
                cont.removeFile(fil);
                File arc = new File(SWBPortal.getWorkPath() + cont.getWorkPath() + "/" + fname);
                if (arc.exists()) {
                    arc.delete();
                }
            }
            out.print("OK");
        } catch (Exception e) {
            out.print("Not OK");
        }
    }

    public void doChange(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String uri = request.getParameter("cat");
        int num = 0;
        if (uri != null && !uri.equals("") && !uri.equals("_blank")) {
            SemanticObject obj = SemanticObject.createSemanticObject(uri);
            Category cat = (Category) obj.createGenericInstance();
            num = cat.getCatNumConsecutivo();
            num = num + 1;
            out.println(num);
        } else {
            out.println("");
        }
    }

    private void processFiles(HttpServletRequest request, WebSite website, SemanticObject sobj) {
        String basepath = SWBPortal.getWorkPath() + sobj.getWorkPath() + "/";
        if (request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED) != null) {
            Iterator itfilesUploaded = ((List) request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED)).iterator();
            while (itfilesUploaded.hasNext()) {
                FileItem item = (FileItem) itfilesUploaded.next();
                if (!item.isFormField()) { //Es un campo de tipo file
                    int fileSize = ((Long) item.getSize()).intValue();
                    String value = item.getName();

                    if (value != null && value.trim().length() > 0) {
                        value = value.replace("\\", "/");
                        int pos = value.lastIndexOf("/");
                        if (pos > -1) {
                            value = value.substring(pos + 1);
                        }
                        File fichero = new File(basepath);
                        if (!fichero.exists()) {
                            fichero.mkdirs();
                        }
                        fichero = new File(basepath + value);

                        String ext = "";
                        pos = -1;
                        pos = value.lastIndexOf(".");
                        if (pos > -1) {
                            ext = value.substring(pos + 1);
                        }


                        Content dirObj = (Content) sobj.createGenericInstance();
                        if (item.getFieldName().startsWith("namePhoto")) {
                            Photos photo = Photos.ClassMgr.createPhotos(website);
                            photo.setNamePhoto(value);
                            try {
                                if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("gif") || ext.equalsIgnoreCase("png")) {
                                    String idx = item.getFieldName().replaceAll("[namePhoto]", "");
                                    String pie = request.getParameter("pieDeFoto" + idx);
                                    if (pie != null) {
                                        photo.setPFooter(pie);
                                    }
                                    dirObj.addPhoto(photo);
                                    item.write(fichero);
                                    File thumbnail = new File(basepath + "thumb___" + value);
                                    ImageResizer.shrinkTo(fichero, 255, 10000, thumbnail, "jpg");
                                    ImageResizer.shrinkTo(fichero, 720, 550, fichero, "jpg");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                log.debug(e);
                            }
                        } else if (item.getFieldName().startsWith("nameFile")) {
                            Files file = Files.ClassMgr.createFiles(website);
                            file.setNameFile(value);
                            try {
                                if (ext.equalsIgnoreCase("doc") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("xls") || ext.equalsIgnoreCase("xlsx") || ext.equalsIgnoreCase("ppt") || ext.equalsIgnoreCase("pptx") || ext.equalsIgnoreCase("zip") || ext.equalsIgnoreCase("rar") || ext.equals("pdf")) {
                                    dirObj.addFile(file);
                                    item.write(fichero);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                log.debug(e);
                            }
                        }
                    }
                }
            }
            request.getSession().setAttribute(UploadFormElement.FILES_UPLOADED, null);
        }

        String principal = request.getParameter("principal");
        if (principal != null && !principal.isEmpty()) {
            Content dirObj = (Content) sobj.createGenericInstance();
            Iterator itz = dirObj.listPhotos();
            while (itz.hasNext()) {
                Photos photo = (Photos) itz.next();
                if (photo.getNamePhoto().equals(principal)) {
                    photo.setPPrincipal(true);
                } else {
                    photo.setPPrincipal(false);
                }
            }
        }
    }
}
