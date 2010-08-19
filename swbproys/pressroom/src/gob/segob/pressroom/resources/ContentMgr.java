/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.segob.pressroom.resources;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
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

import org.semanticwb.servlet.internal.UploadFormElement;
import org.apache.commons.fileupload.FileItem;
import org.semanticwb.portal.resources.sem.pressroom.Files;
import org.semanticwb.portal.resources.sem.pressroom.Photos;

/**
 *
 * @author martha.jimenez
 */
public class ContentMgr extends GenericResource{
    public static Logger log = SWBUtils.getLogger(ContentMgr.class);
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

         String path="/work/models/pressroom/jsp/ContentMgr/ListContent.jsp";
         RequestDispatcher dis = request.getRequestDispatcher(SWBPlatform.getContextPath()+path);
         try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
         }catch(Exception e){
            log.error(e);
         }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action=response.getAction();
        if(action.equals("add")){
            try{
                String categoria =request.getParameter("Category");
                SemanticObject objCat = SemanticObject.createSemanticObject(categoria);
                Category cat = (Category)objCat.createGenericInstance();
                Content conte = Content.ClassMgr.createContent(response.getWebPage().getWebSite());
                //conte.setCategory(cat);
                int numCon = 0;
                String a = request.getParameter("numConsecutivo");
                if(a!=null&&!a.equals("")){
                     numCon = Integer.parseInt(request.getParameter(Content.swbpress_numConsecutivo.getName()));
                }
                conte.setNumConsecutivo(numCon);
                if(numCon!=0){
                    int numcat = cat.getCatNumConsecutivo();
                    if(numCon>numcat)
                        cat.setCatNumConsecutivo(numCon);
                }
                conte.setTitle(request.getParameter(Content.swb_title.getName()));
                conte.setDescription(request.getParameter(Content.swb_description.getName()));
                conte.setContent(request.getParameter(Content.swbpress_content.getName()));
                System.out.println("Parametro: " + Content.swbpress_content.getName()
                        + "\nValor: " + request.getParameter(Content.swbpress_content.getName()));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = request.getParameter(Content.swbpress_startDate.getName());
                Date di = sdf.parse(date);
                conte.setStartDate(di);
                date = request.getParameter(Content.swbpress_endDate.getName());
                Date df = sdf.parse(date);
                conte.setEndDate(df);
                cat.addContent(conte);
                processFiles(request, response.getWebPage().getWebSite(), conte.getSemanticObject());
            }catch(Exception e){
                log.event(e);
            }
        }else if(action.equals("edit")&&request.getParameter("uriCat")!=null&&request.getParameter("uriCont")!=null){
            SemanticObject obj = SemanticObject.createSemanticObject(URLDecoder.decode(request.getParameter("uriCont")));
            Content conte = (Content)obj.createGenericInstance();
           
           
            String categoris= request.getParameter("uriCat");//uri de la categoria anterior
            try{
                String categoria =request.getParameter("Category");
                SemanticObject objCat = SemanticObject.createSemanticObject(categoria);
                Category cat = (Category)objCat.createGenericInstance();//categoria elegida

                //conte.setCategory(cat);
                conte.setTitle(request.getParameter(Content.swb_title.getName()));
                conte.setDescription(request.getParameter(Content.swb_description.getName()));
                conte.setContent(request.getParameter(Content.swbpress_content.getName()));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = request.getParameter(Content.swbpress_startDate.getName());
                Date di = sdf.parse(date);
                conte.setStartDate(di);
                date = request.getParameter(Content.swbpress_endDate.getName());
                Date df = sdf.parse(date);
                conte.setEndDate(df);

                processFiles(request, response.getWebPage().getWebSite(), conte.getSemanticObject());
                if(!categoris.equals(cat.getURI())){
                    SemanticObject objcatan = SemanticObject.createSemanticObject(categoris);
                    Category cat1 = (Category)objcatan.createGenericInstance();//categoria anterior
                    Iterator<Content> itn = cat1.listContents();
                    int numCon = 0;
                    String a = request.getParameter("numConsecutivo");
                    if(a!=null&&!a.equals("")){
                         numCon = Integer.parseInt(request.getParameter(Content.swbpress_numConsecutivo.getName()));
                    }
                    conte.setNumConsecutivo(numCon);
                    if(numCon!=0){
                        int numcat = cat.getCatNumConsecutivo();
                        if(numCon>numcat)
                            cat.setCatNumConsecutivo(numCon);
                    }
                    int conse = 0;
                    while(itn.hasNext()){
                        Content cont = (Content)itn.next();
                        if(!cont.equals(conte)){
                            if(conse<cont.getNumConsecutivo())
                                conse = cont.getNumConsecutivo();
                        }
                    }
                    cat1.setCatNumConsecutivo(conse);
                    Content conte2= (Content)obj.cloneObject().createGenericInstance();
                    cat.addContent(conte2);
                    System.out.println("Conte: "+SWBPortal.getWorkPath() + conte.getWorkPath());;//getWorkPath()
                    System.out.println("Conte2: "+SWBPortal.getWorkPath() + conte2.getWorkPath());;//getWorkPath()
                    SWBUtils.IO.createDirectory(SWBPortal.getWorkPath() + conte2.getWorkPath());
                    Iterator it=conte.listPhotos();
                    while(it.hasNext()){
                        Photos phot = (Photos)it.next();
                        String photo = phot.getNamePhoto();
                        SWBUtils.IO.copy(SWBPortal.getWorkPath() + conte.getWorkPath()+"/"+photo, SWBPortal.getWorkPath() + conte2.getWorkPath()+"/"+photo, false, null, null);
                        System.out.println(""+photo);
                    }
                    it=conte.listFiles();
                    while(it.hasNext()){
                        Files fil = (Files)it.next();
                        String file = fil.getNameFile();
                        SWBUtils.IO.copy(SWBPortal.getWorkPath() + conte.getWorkPath()+"/"+file, SWBPortal.getWorkPath() + conte2.getWorkPath()+"/"+file, false, null, null);
                        System.out.println(""+file);
                    }
                    cat1.removeContent(conte);
                }
            }catch(Exception e){
                log.event(e);
            }

        }else if(action.equals("delete")&&request.getParameter("uri")!=null){
            String uri = URLDecoder.decode(request.getParameter("uri"));
            if(uri!=null){
                SemanticObject obj= SemanticObject.createSemanticObject(uri);
                Content conte = (Content)obj.createGenericInstance();
                conte.removeCategory();
                conte.remove();
            }
        }else if(action.equals("estatus")&&request.getParameter("uri")!=null){
            String uri = URLDecoder.decode(request.getParameter("uri"));
            if(uri!=null){
                SemanticObject obj = SemanticObject.createSemanticObject(uri);
                Content conte = (Content)obj.createGenericInstance();
                boolean estatus = conte.isActive();
                if(estatus)
                    conte.setActive(false);
                else
                    conte.setActive(true);
            }
        }else if(action.equals("prioridad")&&request.getParameter("uri")!=null){
            String uri = URLDecoder.decode(request.getParameter("uri"));
            if(uri!=null){
                SemanticObject obj = SemanticObject.createSemanticObject(uri);
                Content conte = (Content)obj.createGenericInstance();
                int priority = conte.getPriority();
                Iterator<Content> it = Content.ClassMgr.listContents(response.getWebPage().getWebSite());
                while(it.hasNext()){
                    Content conte1 =it.next();
                    if(conte.equals(conte1)){
                        if(priority==1)
                            conte.setPriority(0);
                        else
                            conte.setPriority(1);
                    }else{
                        conte1.setPriority(0);
                    }
                }
            }
        }
        response.setMode(response.Mode_VIEW);
    }

    public void doAddCont(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
         String path="/work/models/pressroom/jsp/ContentMgr/AddContent.jsp";
         org.semanticwb.platform.SemanticObject ret=null;
         ret=Content.sclass.getSemanticObject();
         RequestDispatcher dis = request.getRequestDispatcher(SWBPlatform.getContextPath()+path);
         try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("sobj", ret);
            dis.include(request, response);
         }catch(Exception e){
            log.error(e);
         }
    }
    public void doEditCont(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
         String path="/work/models/pressroom/jsp/ContentMgr/EditContent.jsp";
         RequestDispatcher dis = request.getRequestDispatcher(SWBPlatform.getContextPath()+path);
         try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("uri", request.getParameter("uri"));
            dis.include(request, response);
         }catch(Exception e){
            log.error(e);
         }
    }
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if(mode.equals("addCont"))
            doAddCont(request, response, paramRequest);
        else if(mode.equals("editCont"))
            doEditCont(request, response, paramRequest);
        else if(mode.equals("change"))
            doChange(request, response, paramRequest);
        else if(mode.equals("file"))
            doFile(request,response,paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }
    public void doFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        try{
            String uriCont =request.getParameter("uriCont");
            String phot=request.getParameter("phot");
            String file =request.getParameter("fil");

            SemanticObject objCont = SemanticObject.createSemanticObject(uriCont);
            Content cont = (Content)objCont.createGenericInstance();
            if(phot!=null){
                SemanticObject objPhoto = SemanticObject.createSemanticObject(phot);
                Photos photo = (Photos)objPhoto.createGenericInstance();
                cont.removePhoto(photo);
            }
            if(file!=null){
                SemanticObject objFile = SemanticObject.createSemanticObject(file);
                Files fil = (Files)objFile.createGenericInstance();
                cont.removeFile(fil);
            }
            out.print("OK");
        }catch(Exception e){
            System.out.println("Exception en:" + e);
            out.print("Not OK");
        }

    }
    public void doChange(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String uri = request.getParameter("cat");
        int num = 0;
        if(uri!=null&&!uri.equals("")&&!uri.equals("_blank")){
            SemanticObject obj= SemanticObject.createSemanticObject(uri);
            Category cat = (Category)obj.createGenericInstance();
            num = cat.getCatNumConsecutivo();
            num=num+1;
            out.println(num);
        }else{
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
                        pos = value.indexOf(".");
                        if (pos > -1) {
                            ext = value.substring(pos + 1);
                        }


                        Content dirObj = (Content) sobj.createGenericInstance();
                        if (item.getFieldName().startsWith("namePhoto")) {
                            Photos photo = Photos.ClassMgr.createPhotos(website);
                            photo.setNamePhoto(value);
                            dirObj.addPhoto(photo);
                            System.out.println("Agrega archivo: " + fichero.getPath()
                                    + "\nEn objeto: " + dirObj.getURI());
                            try {
                                item.write(fichero);
                            } catch (Exception e) {
                                e.printStackTrace();
                                log.debug(e);
                            }
                        } else if (item.getFieldName().startsWith("nameFile")) {
                            Files file = Files.ClassMgr.createFiles(website);
                            file.setNameFile(value);
                            dirObj.addFile(file);
                            System.out.println("Agrega archivo: " + fichero.getPath()
                                    + "\nEn objeto: " + dirObj.getURI());
                            try {
                                item.write(fichero);
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
    }

}
