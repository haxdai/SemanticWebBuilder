/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import com.infotec.conorg.*;
import java.io.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.*;
import org.semanticwb.model.Resource;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;

/**
 *
 * @author juan.fernandez
 */
public class MyShelf extends GenericAdmResource {

    public static final Logger log = SWBUtils.getLogger(MyShelf.class);
    public static final SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yy hh:mm");
    public static final String Mode_AJAX = "ajax";
    public static final String RES_CONF = "resconf";
    public static final String MODE_GETFILE = "getFile";
    public static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    public static final String USRLEVEL_NO_MIEMBRO = "No miembro";
    public static final String USRLEVEL_INVITADO = "Invitado";
    public static final String USRLEVEL_MIEMBRO = "Miembro";
    public static final String USRLEVEL_COORDINADOR = "Coordinador";
    public static final String USRLEVEL_ADMINISTRADOR = "Administrador";
    public static final String ROL_ADMIN_ATRIBUTTE = "rolworkspace";
    public static final NumberFormat numf = NumberFormat.getNumberInstance();

    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        Resource base = getResourceBase();
        String confClass = base.getAttribute(MyShelf.RES_CONF, "http://www.infotec.com/conorg.owl#Shelf");

        String path = basePath + "view.jsp";

        if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
            path = basePath + "viewShelf.jsp";
        } else if (confClass.equals(WorkSpace.conorg_WorkSpace.getURI())) {
            path = basePath + "viewWS.jsp";
        }

        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);

            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    public void doGetFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        User user = paramRequest.getUser();
        String fid = request.getParameter("fid");
        String verNumber = request.getParameter("verNum");
        int intVer = 1;
        if (verNumber != null) {
            intVer = Integer.parseInt(verNumber);
        }

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = null;
        GenericObject gobj = null;
        if (null != fid) {
            obj = ont.getSemanticObject(fid);
        }
        if (obj != null) {
            gobj = obj.createGenericInstance();
        }

        Document doc = null;
        if (gobj instanceof Document) {
            doc = (Document) gobj;
        }
        if (doc != null) {


            VersionInfo ver = null;
            VersionInfo vl = doc.getLastVersion();
            if (null != vl) {
                ver = vl;
                while (ver.getPreviousVersion() != null) { //
                    if (ver.getVersionNumber() == intVer) {
                        break;
                    }
                    ver = ver.getPreviousVersion();
                }
            }
            try {
                response.setContentType(DEFAULT_MIME_TYPE);
                response.setHeader("Content-Disposition", "attachment; filename=\"" + ver.getVersionFile() + "\";");

                OutputStream out = response.getOutputStream();
                SWBUtils.IO.copyStream(new FileInputStream(SWBPortal.getWorkPath() + doc.getWorkPath() + "/" + verNumber + "/" + ver.getVersionFile()), out);
            } catch (Exception e) {
                log.error("Error al obtener el archivo del Repositorio de documentos.", e);
            }
        }
    }

    public void doAjax(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        RequestDispatcher dis = request.getRequestDispatcher(basePath + "ajax.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (Mode_AJAX.equals(mode)) {
            doAjax(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(MODE_GETFILE)) {
            doGetFile(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        String id = request.getParameter("id");
        String suri = request.getParameter("suri");
        String wsid = request.getParameter("wsid");
        String classid = request.getParameter("classid");
        if (null == action) {
            action = "";
        }

        String confClass = getResourceBase().getAttribute(MyShelf.RES_CONF, "http://www.infotec.com/conorg.owl#Shelf");
        boolean isShelf = Boolean.TRUE;
        if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
            isShelf = Boolean.TRUE;
        } else if (confClass.equals(WorkSpace.conorg_WorkSpace.getURI())) {
            isShelf = Boolean.FALSE;
        }

        User usr = response.getUser();
        WebSite wsite = response.getWebPage().getWebSite();
        String eventid = request.getParameter("idevent");
        String page = request.getParameter("page");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = null;
        if (null != id) {
            obj = ont.getSemanticObject(id);
        }
        SemanticClass cls = null;
        if (null != obj) {
            cls = obj.getSemanticClass();
        }

        String msg = "";
        if (SWBResourceURL.Action_ADD.equals(action) || SWBResourceURL.Action_EDIT.equals(action)) {

            SWBFormMgr frmgr = null;

            if (classid != null) {
                try {
                    SemanticObject nso = null;
                    SemanticObject sobj = ont.getSemanticObject(classid);
                    SemanticClass scls = sobj.transformToSemanticClass();
                    String strTitle = request.getParameter("elemTitle");
                    if (strTitle != null && SWBResourceURL.Action_ADD.equals(action)) {
                        if (scls.isAutogenId()) {
                            long lid = wsite.getSemanticObject().getModel().getCounter(scls);
                            String str_lid = "" + lid;
                            nso = wsite.getSemanticObject().getModel().createSemanticObject(wsite.getSemanticObject().getModel().getObjectUri(str_lid, scls), scls);
                            nso.setProperty(Descriptiveable.swb_title, strTitle);
                        }
                    } else {
                        frmgr = new SWBFormMgr(scls, wsite.getSemanticObject().getModel().getModelObject(), SWBFormMgr.MODE_CREATE);
                        nso = frmgr.processForm(request);
                    }

                    if (nso != null) {
                        if (isShelf) {
                            Shelf myshelf = Shelf.ClassMgr.getShelf(usr.getId(), wsite);
                            if (myshelf == null) {
                                myshelf = Shelf.ClassMgr.createShelf(usr.getId(), wsite);
                                myshelf.setOwner(usr);
                            }
                            myshelf.addTile((Tile) (nso.createGenericInstance()));
                            response.setRenderParameter("act", SWBActionResponse.Action_EDIT);
                            response.setRenderParameter("id", nso.getURI());
                            response.setRenderParameter("suri", nso.getURI());
                            if (wsid != null) {
                                response.setRenderParameter("wsid", wsid);
                            }
                        } else {

                            if (nso.createGenericInstance() instanceof WorkSpace) {
                                //System.out.println("Creando workspace");
                                //                                System.out.println("Creando miembro del ws");
                                Member member = Member.ClassMgr.createMember(wsite);
                                member.setUser(usr);
                                member.setMemberType(USRLEVEL_ADMINISTRADOR);
                                member.setWorkspace((WorkSpace) nso.createGenericInstance());

                                //                                System.out.println("Agregando Membre al workSpace ....");
                                ((WorkSpace) nso.createGenericInstance()).addMember(member);
                                response.setRenderParameter("wsid", ((WorkSpace) nso.createGenericInstance()).getId());
                                response.setAction("");
                                response.setRenderParameter("act", "");
                                //response.setRenderParameter("id", nso.getURI());
                                //response.setRenderParameter("suri", nso.getURI());
                                //                                System.out.println(".... member agregado");
                            } else {

                                //                                System.out.println("Agregando azulejo al WorkSpace");
                                // agregar el tile al workspace
                                WorkSpace workSpace = WorkSpace.ClassMgr.getWorkSpace(wsid, wsite);
                                if (null != workSpace) {

                                    workSpace.addTile((Tile) (nso.createGenericInstance()));
                                    //                                    System.out.println("Tile added.....");
                                }
                                response.setAction(SWBActionResponse.Action_EDIT);
                                response.setRenderParameter("act", SWBActionResponse.Action_EDIT);
                                response.setRenderParameter("id", nso.getURI());
                                response.setRenderParameter("suri", nso.getURI());
                                if (wsid != null) {
                                    response.setRenderParameter("wsid", wsid);
                                }
                            }
                        }
                    }
                    //}
                    msg = "Se creó " + classid.substring(classid.indexOf("#") + 1) + " satisfactoriamente.";
                } catch (Exception e) {
                    log.error("Error al agregar el elemento", e);
                    msg = "Error al crear " + classid.substring(classid.indexOf("#") + 1);
                }

                response.setRenderParameter("alertmsg", msg);
            } else if (id != null || suri != null) {
                try {
                    if (id == null) {
                        id = suri;
                    }
                    SemanticObject sobj = ont.getSemanticObject(id);
                    SemanticClass scls = sobj.getSemanticClass();
                    classid = scls.getClassId();
                    frmgr = new SWBFormMgr(sobj, SWBFormMgr.MODE_EDIT, SWBFormMgr.MODE_EDIT);

                    GenericObject gobj = sobj.createGenericInstance();

                    if (gobj instanceof WorkSpace) {
                        frmgr.clearProperties();
                        frmgr.addProperty(Descriptiveable.swb_title);
                        frmgr.addProperty(Descriptiveable.swb_description);
                        frmgr.addProperty(Tagable.swb_tags);
                        //frmgr.addProperty(Activeable.swb_active);
                        frmgr.addProperty(Traceable.swb_created);
                        frmgr.addProperty(Traceable.swb_creator);
                        frmgr.addProperty(Traceable.swb_modifiedBy);
                        frmgr.addProperty(Traceable.swb_updated);
                        frmgr.addProperty(WorkSpace.conorg_hasTopic);
                    }

                    SemanticObject nso = frmgr.processForm(request);

                    System.out.println("Resumen: " + request.getParameter("documentAbstract"));


                    if (nso.createGenericInstance() instanceof WorkSpace) {
                        wsid = ((WorkSpace) nso.createGenericInstance()).getId();
                        response.setRenderParameter("act", "");
                        response.setAction("");
                    } else {
                        response.setRenderParameter("act", "");
                        response.setAction(SWBActionResponse.Action_EDIT);
                    }
                    msg = "Se actualizó " + classid.substring(classid.indexOf("#") + 1) + " satisfactoriamente.";
                } catch (Exception e) {
                    log.error("Error al actulizar el elemento", e);
                    msg = "Error al actualizar " + classid.substring(classid.indexOf("#") + 1);
                }

                response.setRenderParameter("alertmsg", msg);

                response.setRenderParameter("id", id);
                response.setRenderParameter("suri", id);
                if (null != wsid) {
                    response.setRenderParameter("wsid", wsid);
                }

            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se recibieron parámetros válidos.");
            }
            response.setMode(SWBActionResponse.Mode_VIEW);

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            //String suri = request.getParameter("suri");
            if (suri != null) {
                try {
                    SemanticObject sobj = ont.getSemanticObject(suri);
                    SemanticClass sclass = sobj.getSemanticClass();
                    classid = sclass.getClassName();
                    sobj.remove();
                    msg = "Se eliminó " + classid.substring(classid.indexOf("#") + 1) + " satisfactoriamente.";
                } catch (Exception e) {
                    log.error("Error al eliminar el elemento", e);
                    msg = "Error al eliminar " + classid.substring(classid.indexOf("#") + 1);
                }
            }
        } else if ("newfile".equals(action)) {
            org.semanticwb.portal.util.FileUpload fup = new org.semanticwb.portal.util.FileUpload();
            fup.getFiles(request, null);
            String fname = fup.getFileName("ffile");
            String fcomment = fup.getValue("fcomment");

            String fid = fup.getValue("fid");
            wsid = request.getParameter("wsid");

//            System.out.println("fid: " + fid);
//            System.out.println("wsid: " + wsid);

            byte[] bcont = fup.getFileData("ffile");

            SemanticObject so = ont.getSemanticObject(fid);
            GenericObject go = so.createGenericInstance();

            WebPage wpage = response.getWebPage();
            Document doc = null;
            boolean incremento = Boolean.FALSE;
            if (fid != null && go instanceof Document) {
                doc = (Document) go;
                incremento = Boolean.TRUE;
            }

            if (fname.lastIndexOf('/') != -1) {
                int pos = fname.lastIndexOf('/');
                fname = fname.substring(pos + 1);
            }
            if (fname.lastIndexOf('\\') != -1) {
                int pos = fname.lastIndexOf('\\');
                fname = fname.substring(pos + 1);
            }

            if (doc != null) {
                storeFile(fname, new ByteArrayInputStream(bcont), fcomment, incremento, doc, wsite);
            }

            response.setRenderParameter("wsid", wsid);
            response.setRenderParameter("fid", fid);
            response.setAction(SWBActionResponse.Action_EDIT);
            response.setRenderParameter("act", SWBActionResponse.Action_EDIT);
            response.setRenderParameter("id", fid);
            response.setRenderParameter("suri", fid);
        } else if ("addmember".equals(action)) {
            WorkSpace ws = WorkSpace.ClassMgr.getWorkSpace(wsid, wsite);
            String usrid = request.getParameter("usrid");
            String mbrtype = request.getParameter("mbrtype");
            User usrparam = wsite.getUserRepository().getUser(usrid);
            if (usrparam != null && ws != null && mbrtype != null) {
                Member mbr = Member.ClassMgr.createMember(wsite);
                mbr.setUser(usrparam);
                mbr.setWorkspace(ws);
                mbr.setMemberType(mbrtype);

                ws.addMember(mbr);
                response.setRenderParameter("alertmsg", "Se agregó correctamente participante al Espacio de trabajo.");
                response.setRenderParameter("wsid", wsid);
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos y/o incompletos, no se recibieron parámetros válidos.");
            }
        } else if ("delmember".equals(action)) {
            WorkSpace ws = WorkSpace.ClassMgr.getWorkSpace(wsid, wsite);


            String mbrid = request.getParameter("mbrid");
            Member mbr = Member.ClassMgr.getMember(mbrid, wsite);
            String usrid = request.getParameter("usrid");

            User usrparam = wsite.getUserRepository().getUser(usrid);
            if (usrparam != null && ws != null && mbr != null) {
                int intadmin = 0;
                Iterator<Member> itmbr = ws.listMembers();
                while (itmbr.hasNext()) {
                    Member member = itmbr.next();
                    if (member.getMemberType() != null && getLevelMember(member) == 4) {
                        intadmin++;
                    }
                }
                if ((getLevelMember(mbr) == 4 && intadmin > 1) || getLevelMember(mbr) < 4) { // se puede eliminar el miembro 
                    ws.removeMember(mbr);
                    mbr.remove();
                    response.setRenderParameter("alertmsg", "Se eliminó correctamente el participante del Espacio de trabajo.");
                    response.setRenderParameter("wsid", wsid);
                } else if ((getLevelMember(mbr) == 4 && intadmin == 1)) {
                    response.setRenderParameter("alertmsg", "No se eliminó el participante del Espacio de trabajo. Debe de haber por lo menos un participante Administrador");
                    response.setRenderParameter("wsid", wsid);
                }
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos y/o incompletos, no se recibieron parámetros válidos.");
                response.setRenderParameter("wsid", wsid);
            }
        } else if ("updmbr".equals(action)) {
            WorkSpace ws = WorkSpace.ClassMgr.getWorkSpace(wsid, wsite);
            //System.out.println("update member tipo-miembro "+ws.getId());

            String mbrid = request.getParameter("mbrid");
            String mbrtype = request.getParameter("mbrtype");
            Member mbr = Member.ClassMgr.getMember(mbrid, wsite);

            if (ws != null && mbr != null) {
                //System.out.println("ws !=null y mbr!=null");
                int intadmin = 0;
                Iterator<Member> itmbr = ws.listMembers();
                while (itmbr.hasNext()) {
                    Member member = itmbr.next();
                    if (member != null && member.getMemberType() != null && getLevelMember(member) == 4) {
                        intadmin++;
                    }
                }
                if ((getLevelMember(mbr) == 4 && intadmin > 1 && !mbrtype.equals(MyShelf.USRLEVEL_ADMINISTRADOR)) || (getLevelMember(mbr) < 4)) { // se puede eliminar el miembro 
                    mbr.setMemberType(mbrtype);

                    response.setRenderParameter("alertmsg", "Se actualió correctamente el tipo de miembro.");
                    response.setRenderParameter("wsid", wsid);
                } else if ((getLevelMember(mbr) == 4 && intadmin == 1)) {
                    response.setRenderParameter("alertmsg", "No se pudo actualizar el tipo de miembro. Debe de haber por lo menos un miembro Administrador");
                    response.setRenderParameter("wsid", wsid);
                }
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos y/o incompletos, no se recibieron parámetros válidos.");
                response.setRenderParameter("wsid", wsid);
            }
        } else if (action.equals("share")) {
            //workspaceid lista de wrkspcs a los cuales se les compartirá el azulejo
            //tileuri azulejo que se compartira
            //contactid lista de usuarios a los cuales se les compartirá el azulejo
            String[] listwrkspcs = request.getParameterValues("workspaceid");
            String[] listcontact = request.getParameterValues("contactid");
            String tileuri = request.getParameter("tileuri");
            GenericObject go = ont.getGenericObject(tileuri);
            GenericObject goparam = null;
            User usrparam = null;
            Shelf usrShelf = null;
            WorkSpace wrkspc = null;
            if (go != null && go instanceof Tile) {
                Tile tile = (Tile) go;
                if (listwrkspcs != null) {
                    for (int i = 0; i < listwrkspcs.length; i++) {
                        goparam = ont.getGenericObject(listwrkspcs[i]);
                        if (goparam != null && goparam instanceof WorkSpace) {
                            wrkspc = (WorkSpace) goparam;
                            if(!wrkspc.hasTile(tile)) wrkspc.addTile(tile);
                        }
                    }
                }
                if (listcontact != null) {
                    UserRepository userrep = wsite.getUserRepository();
                    for (int i = 0; i < listcontact.length; i++) {
                        usrparam = userrep.getUser(listcontact[i]);
                        if (usrparam != null) {
                            usrShelf = Shelf.ClassMgr.getShelf(usrparam.getId(), wsite);
                            if (usrShelf == null && usrparam != null) {
                                //crear el shelf del usuario al cual se le va a compartir el azulejo
                                usrShelf = Shelf.ClassMgr.createShelf(usrparam.getId(), wsite);
                                usrShelf.setOwner(usrparam);
                            }
                            if(!usrShelf.hasTile(tile)) usrShelf.addTile(tile);
                        }
                    }
                }
            }


            response.setRenderParameter("act", "");
        } else if (action.equals("copy2shelf")) {
            // copiar azulejo del WS al Shelf
            //workspaceid lista de wrkspcs a los cuales se les compartirá el azulejo
            //tileuri azulejo que se compartira
            //contactid lista de usuarios a los cuales se les compartirá el azulejo
            GenericObject go = ont.getGenericObject(suri);
            Shelf usrShelf = null;
            if (go != null && go instanceof Tile) {
                Tile tile = (Tile) go;
                usrShelf=Shelf.ClassMgr.getShelf(usr.getId(), wsite);
                if(usrShelf==null){
                    usrShelf = Shelf.ClassMgr.createShelf(usr.getId(), wsite);
                    usrShelf.setOwner(usr);
                }
                if(!usrShelf.hasTile(tile)) usrShelf.addTile(tile);
            }


            response.setRenderParameter("act", "");
            if(wsid!=null)response.setRenderParameter("wsid", wsid);
        }

        if (id != null) {
            response.setRenderParameter("id", id);
        }
        if (page != null) {
            response.setRenderParameter("page", page);
        }

    }

    public OutputStream storeFile(String name, String comment, boolean bigVersionInc, Document doc, WebSite wsite) throws FileNotFoundException {
        VersionInfo v = VersionInfo.ClassMgr.createVersionInfo(wsite);
        v.setVersionFile(name);

        numf.setMaximumFractionDigits(1);

        if (comment != null) {
            v.setVersionComment(comment);
        }
        VersionInfo vl = doc.getLastVersion();
        String sver = "1.0";
        int ver = 1;
        if (vl != null) {
            vl.setNextVersion(v);
            v.setPreviousVersion(vl);
            ver = vl.getVersionNumber();
            sver = vl.getVersionValue();

            double f = Double.parseDouble(sver);

            if (bigVersionInc) {
                f = (int) f + 1;
                sver = "" + (float) f;
            } else {
                f = f + 0.10D;

                String sfver = numf.format(f);
                if (sfver.indexOf(".") == -1) {
                    sfver = "" + (float) f;
                }
                sver = sfver;
            }
            ver++;
        }
        v.setVersionNumber(ver);
        v.setVersionValue(sver);
        doc.setActualVersion(v);
        doc.setLastVersion(v);

        File file = new File(SWBPortal.getWorkPath() + doc.getWorkPath() + "/" + ver);
        file.mkdirs();
        return new FileOutputStream(SWBPortal.getWorkPath() + doc.getWorkPath() + "/" + ver + "/" + name);
    }

    /**
     * Almacena el archivo en la ruta predefinida del RepositoryFile, Si no
     * existe ninguna version crea una nueva Si existe una version anterior
     * agrega una nueva versión
     *
     * @param name
     * @param out
     * @param comment
     * @param bigVersionInc
     */
    public void storeFile(String name, InputStream in, String comment, boolean bigVersionInc, Document doc, WebSite wsite) {
        try {
            OutputStream out = storeFile(name, comment, bigVersionInc, doc, wsite);
            SWBUtils.IO.copyStream(in, out);
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static String getFileType(String filename) {
        String file = "Document";
        String type = filename.toLowerCase();
        if (type.indexOf(".bmp") != -1) {
            file = "Image";
        } else if (type.indexOf(".pdf") != -1) {
            file = "Adobe Acrobat";
        } else if (type.indexOf(".xls") != -1 || type.indexOf(".xlsx") != -1) {
            file = "Microsoft Excel";
        } else if (type.indexOf(".html") != -1 || type.indexOf(".htm") != -1) {
            file = "HTML file";
        } else if (type.indexOf("jpg") != -1 || type.indexOf("jpeg") != -1) {
            file = "Image";
        } else if (type.indexOf(".ppt") != -1 || type.indexOf(".pptx") != -1) {
            file = "Microsoft Power Point";
        } else if (type.indexOf(".vsd") != -1) {
            file = "Microsoft Visio";
        } else if (type.indexOf(".mpp") != -1) {
            file = "Microsoft Project";
        } else if (type.indexOf(".mmap") != -1) {
            file = "Mind Manager";
        } else if (type.indexOf(".exe") != -1) {
            file = "Application";
        } else if (type.indexOf(".txt") != -1) {
            file = "Text file";
        } else if (type.indexOf(".properties") != -1) {
            file = "Properties file";
        } else if (type.indexOf(".doc") != -1 || type.indexOf(".docx") != -1) {
            file = "Microsoft Word";
        } else if (type.indexOf(".xml") != -1) {
            file = "XML file";
        } else if (type.indexOf(".gif") != -1 || type.indexOf(".png") != -1) {
            file = "Image";
        } else if (type.indexOf(".avi") != -1) {
            file = "Media file";
        } else if (type.indexOf(".mp3") != -1) {
            file = "Audio file";
        } else if (type.indexOf(".wav") != -1) {
            file = "Audio file";
        } else if (type.indexOf(".xsl") != -1) {
            file = "XSLT file";
        }
        return file;
    }

    public static String getFileName(String filename) {
        String file = "ico_default2.gif";
        String type = filename.toLowerCase();
        if (type.indexOf(".bmp") != -1) {
            file = "ico_bmp.gif";
        } else if (type.indexOf(".pdf") != -1) {
            file = "ico_acrobat.gif";
        } else if (type.indexOf(".xls") != -1 || type.indexOf(".xlsx") != -1) {
            file = "ico_excel.gif";
        } else if (type.indexOf(".html") != -1 || type.indexOf(".htm") != -1) {
            file = "ico_html.gif";
        } else if (type.indexOf("jpg") != -1 || type.indexOf("jpeg") != -1) {
            file = "ico_jpeg.gif";
        } else if (type.indexOf(".ppt") != -1 || type.indexOf(".pptx") != -1) {
            file = "ico_powerpoint.gif";
        } else if (type.indexOf(".exe") != -1) {
            file = "ico_program.gif";
        } else if (type.indexOf(".txt") != -1 || type.indexOf(".properties") != -1) {
            file = "ico_text.gif";
        } else if (type.indexOf(".doc") != -1 || type.indexOf(".docx") != -1) {
            file = "ico_word.gif";
        } else if (type.indexOf(".xml") != -1 || type.indexOf(".xsl") != -1) {
            file = "ico_xml.gif";
        } else if (type.indexOf(".mmap") != -1) {
            file = "ico_mindmanager.GIF";
        } else if (type.indexOf(".gif") != -1) {
            file = "ico_gif.gif";
        } else if (type.indexOf(".avi") != -1) {
            file = "ico_video.gif";
        } else if (type.indexOf(".mp3") != -1) {
            file = "ico_audio.gif";
        } else if (type.indexOf(".wav") != -1) {
            file = "ico_audio.gif";
        }
        return file;
    }

    public static String getTileTypeName(Tile tile) {

        String ret = "Azulejo";
        if (tile instanceof Contact) {
            ret = "Contacto";
        } else if (tile instanceof Mosaic) {
            ret = "Mosaico";
        } else if (tile instanceof com.infotec.conorg.Resource) {
            ret = "Recurso";
        } else if (tile instanceof URL) {
            ret = "URL";
        } else if (tile instanceof Article) {
            ret = "Articulo";
        } else if (tile instanceof Audio) {
            ret = "Audio";
        } else if (tile instanceof Book) {
            ret = "Libro";
        } else if (tile instanceof ChapterBook) {
            ret = "Capitulo";
        } else if (tile instanceof Image) {
            ret = "Imagen";
        } else if (tile instanceof Manual) {
            ret = "Manual";
        } else if (tile instanceof Presentation) {
            ret = "Presentación";
        } else if (tile instanceof com.infotec.conorg.Reference) {
            ret = "Referencia";
        } else if (tile instanceof Report) {
            ret = "Reporte";
        } else if (tile instanceof Video) {
            ret = "Video";
        } else if (tile instanceof Document) {
            ret = "Documento";
        }
        return ret;
    }

    public static int getLevelMember(Member member) {
        int usrlvl = 0;

        if (member.getMemberType() == null) {
            usrlvl = 0;
        } else if (member.getMemberType().equals(USRLEVEL_NO_MIEMBRO)) {
            usrlvl = 0;
        } else if (member.getMemberType().equals(USRLEVEL_INVITADO)) {
            usrlvl = 1;
        } else if (member.getMemberType().equals(USRLEVEL_MIEMBRO)) {
            usrlvl = 2;
        } else if (member.getMemberType().equals(USRLEVEL_COORDINADOR)) {
            usrlvl = 3;
        } else if (member.getMemberType().equals(USRLEVEL_ADMINISTRADOR)) {
            usrlvl = 4;
        }

        return usrlvl;
    }

    public static String getSelecTypeMember(String membertype, String options) {
        StringBuffer ret = new StringBuffer();
        ret.append("<select dojoType=\"dijit.form.FilteringSelect\" name=\"mbrtype\" " + options + ">");
        ret.append("<option value=\"" + USRLEVEL_MIEMBRO + "\"");
        if (membertype.equals(USRLEVEL_NO_MIEMBRO)) {
            ret.append("selected");
        }
        ret.append(">" + USRLEVEL_NO_MIEMBRO + "</option>");
        ret.append("<option value=\"" + USRLEVEL_INVITADO + "\"");
        if (membertype.equals(USRLEVEL_INVITADO)) {
            ret.append("selected");
        }
        ret.append(">" + USRLEVEL_INVITADO + "</option>");
        ret.append("<option value=\"" + USRLEVEL_MIEMBRO + "\"");
        if (membertype.equals(USRLEVEL_MIEMBRO)) {
            ret.append("selected");
        }
        ret.append(">" + USRLEVEL_MIEMBRO + "</option>");
        ret.append("<option value=\"" + USRLEVEL_COORDINADOR + "\"");
        if (membertype.equals(USRLEVEL_COORDINADOR)) {
            ret.append("selected");
        }
        ret.append(">" + USRLEVEL_COORDINADOR + "</option>");
        ret.append("<option value=\"" + USRLEVEL_ADMINISTRADOR + "\"");
        if (membertype.equals(USRLEVEL_ADMINISTRADOR)) {
            ret.append("selected");
        }
        ret.append(">" + USRLEVEL_ADMINISTRADOR + "</option>");
        ret.append("</select>");

        //System.out.print(ret.toString());


        return ret.toString();
    }

    public static String getClassIconTile(Tile tile) {
        String ret = "doc";
        if (tile instanceof Contact) {
            ret = "con";
        } else if (tile instanceof Mosaic) {
            ret = "mos";
        } else if (tile instanceof com.infotec.conorg.Resource) {
            ret = "rec";
        } else if (tile instanceof URL) {
            ret = "url";
        } else if (tile instanceof Article) {
            ret = "art";
        } else if (tile instanceof Audio) {
            ret = "aud";
        } else if (tile instanceof Book) {
            ret = "lib";
        } else if (tile instanceof ChapterBook) {
            ret = "cap";
        } else if (tile instanceof Image) {
            ret = "img";
        } else if (tile instanceof Manual) {
            ret = "man";
        } else if (tile instanceof Presentation) {
            ret = "pre";
        } else if (tile instanceof com.infotec.conorg.Reference) {
            ret = "ref";
        } else if (tile instanceof Report) {
            ret = "rep";
        } else if (tile instanceof Video) {
            ret = "vid";
        } else if (tile instanceof Document) {
            ret = "doc";
        }
        return ret;
    }
}
