/**
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
*
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
* del SemanticWebBuilder 4.0.
*
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
* de la misma.
*
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
* dirección electrónica:
*  http://www.semanticwebbuilder.org
**/
package org.semanticwb.pymtur.microsites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.Cupon;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author carlos.ramos
 */
public class CuponManager extends GenericResource {
    private static Logger log = SWBUtils.getLogger(CuponManager.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        String path = "";
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId();

        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }

        String siteUri = ((MicroSitePyme) community).getType().getURI();

        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
            path = siteWorkDir + "/jsp/" + community.getWebSiteId() + "/microsite/spCupons.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            path = siteWorkDir + "/jsp/" + community.getWebSiteId() + "/premier/spCupons.jsp";
        }

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("canEdit", userCanEdit(paramRequest.getUser()));
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException  {
        Resource base = getResourceBase();
        String action = response.getAction();
        final String realpath = SWBPortal.getWorkPath();
        final String path = base.getWorkPath() + "/";

        response.setRenderParameter("uri", request.getParameter("uri"));
        response.setRenderParameter("sprovider", request.getParameter("sprovider"));

        if( "add_cupon".equalsIgnoreCase(action) ) {
            response.setAction("addNewCupon");
            HashMap<String, String> params = upload(request);
            if( !isValidValue(params.get("title")) ) {
                response.setRenderParameter("msgErrTitle", "El título es requerido.");
                return;
            }
            if( !isValidValue(params.get("description"))) {
                response.setRenderParameter("msgErrDesc", "La descripción es requerida.");
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date;
            Date di, df;
            try {
                date = params.get("datei");
                di = sdf.parse(date);
            }catch(ParseException pe) {
                response.setRenderParameter("msgErrDateS", "El inicio de la vigencia es inválida.");
                return;
            }
            try {
                date = params.get("datef");
                df = sdf.parse(date);
            }catch(ParseException pe) {
                response.setRenderParameter("msgErrDateE", "El fin de la vigencias es inválida.");
                return;
            }
            if(di.after(df)) {
                response.setRenderParameter("msgErrDateS", "La fecha inicial de vigencia no puede ser mayor a la final.");
                return;
            }
            try {
                params.get("is").trim();
            }catch(Exception e) {
                response.setRenderParameter("msgErrCuponType", "El tipo de cupón es requerido.");
                return;
            }
            try {
                params.get("pimg").trim();
            }catch(Exception e) {
                response.setRenderParameter("msgErrCuponImg", "La imagen del cupón es requerida.");
                return;
            }
            if( !isValidValue(params.get("deftv")) ) {
                response.setRenderParameter("msgErrDEftv", "La dirección para hacer válido el cupón es requerida.");
                return;
            }
            response.setAction(null);
            Cupon cupon = Cupon.ClassMgr.createCupon(response.getWebPage().getWebSite());
            cupon.setTitle(params.get("title"));
            String description = params.get("description");
            if(description.length()>1000)
            {
                description = description.substring(0, 999);
            }
            cupon.setDescription(description);
            cupon.setCuponPeriodIni(di);
            cupon.setCuponPeriodFin(df);
            cupon.setCuponType(params.get("is"));
            cupon.setCuponImg( (params.get("pimg")!=null&&params.get("pimg").length()>0?params.get("pimg"):null) );
            cupon.setCuponConditions( params.get("constraint")==null?"":params.get("constraint") );
            cupon.setCuponAddress(params.get("deftv"));
            if( params.containsKey("partner") ) {
                File file = new File(realpath+path+params.get("partner"));
                if( file.exists() ) {
                    FileInputStream in = new FileInputStream(file);
                    String filename = file.getName();
                    String finalpath = cupon.getWorkPath() + "/";
                    String target = realpath + finalpath + filename;
                    File ftarget = new File(target);
                    ftarget.getParentFile().mkdirs();
                    FileOutputStream out = new FileOutputStream(ftarget);
                    SWBUtils.IO.copyStream(in, out);
                    file.delete();
                    params.put("partner", finalpath + filename);
                    cupon.setCuponPartnerImage(params.get("partner"));
                }
            }
            try {
                SemanticObject semObject = SemanticObject.createSemanticObject(params.get("sprovider"));
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                serviceProv.addCupon(cupon);
                serviceProv.setSpTotCupones(serviceProv.getSpTotCupones()+1);
                if( params.containsKey("cmts")&&isValidValue(params.get("cmts")) )
                    serviceProv.setSpCuponsComment((serviceProv.getSpCuponsComment()==null?"":serviceProv.getSpCuponsComment())+params.get("cmts"));
            }catch(Exception e) {
                log.error(e);
            }
        }
        else if( "edit_cupon".equalsIgnoreCase(action) ) {
            response.setAction("editCupon");
            HashMap<String, String> params = upload(request);
            if( params.containsKey("title")&&!isValidValue(params.get("title")) ) {
                response.setRenderParameter("msgErrTitle", "El título es requerido.");
                return;
            }
            if( params.containsKey("description")&&!isValidValue(params.get("description"))) {
                response.setRenderParameter("msgErrDesc", "La descripción es requerida.");
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date;
            Date di, df;
            try {
                date = params.get("datei");
                di = sdf.parse(date);
            }catch(ParseException pe) {
                response.setRenderParameter("msgErrDateS", "El inicio de la vigencia es inválida.");
                return;
            }
            try {
                date = params.get("datef");
                df = sdf.parse(date);
            }catch(ParseException pe) {
                response.setRenderParameter("msgErrDateE", "El fin de la vigencias es inválida.");
                return;
            }
            if(di.after(df)) {
                response.setRenderParameter("msgErrDateS", "La fecha inicial de vigencia no puede ser mayor a la final.");
                return;
            }
            try {
                params.get("is").trim();
            }catch(Exception e) {
                response.setRenderParameter("msgErrCuponType", "El tipo de cupón es requerido.");
                return;
            }
            try {
                params.get("pimg").trim();
            }catch(Exception e) {
                response.setRenderParameter("msgErrCuponImg", "La imagen del cupón es requerida.");
                return;
            }
            if( !isValidValue(params.get("deftv")) ) {
                response.setRenderParameter("msgErrDEftv", "La dirección para hacer válido el cupón es requerida.");
                return;
            }
            response.setAction(null);
            SemanticObject semObject = SemanticObject.createSemanticObject(params.get("cupon"));
            Cupon cupon = (Cupon) semObject.createGenericInstance();
            cupon.setTitle(params.get("title"));
            String description = params.get("description");
            if(description.length()>1000)
            {
                description = description.substring(0, 999);
                
            }
            cupon.setDescription(description);
            cupon.setCuponPeriodIni(di);
            cupon.setCuponPeriodFin(df);
            cupon.setCuponType(params.get("is"));
            cupon.setCuponImg( (params.get("pimg")!=null&&params.get("pimg").length()>0?params.get("pimg"):null) );
            cupon.setCuponConditions( params.get("constraint")==null?"":params.get("constraint") );
            cupon.setCuponAddress(params.get("deftv"));
            if( params.containsKey("partner") ) {
                File file = new File(realpath+path+params.get("partner"));
                if( file.exists() ) {
                    FileInputStream in = new FileInputStream(file);
                    String filename = file.getName();
                    String finalpath = cupon.getWorkPath() + "/";
                    String target = realpath + finalpath + filename;
                    File ftarget = new File(target);
                    ftarget.getParentFile().mkdirs();
                    FileOutputStream out = new FileOutputStream(ftarget);
                    SWBUtils.IO.copyStream(in, out);
                    file.delete();
                    params.put("partner", finalpath + filename);
                    cupon.setCuponPartnerImage(params.get("partner"));
                }
            }
            if( params.containsKey("cmts")&&isValidValue(params.get("cmts")) ) {
                semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                serviceProv.setSpCuponsComment((serviceProv.getSpCuponsComment()==null?"":serviceProv.getSpCuponsComment())+params.get("cmts"));
            }
        }
        else if( "remove_cupon".equalsIgnoreCase(action) ) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            Cupon cupon = (Cupon) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removeCupon(cupon);
            serviceProv.setSpTotCupones(serviceProv.getSpTotCupones()-1);
            semObject.remove();
        }
    }

    private HashMap<String, String> upload(HttpServletRequest request) {
        final String realpath = SWBPortal.getWorkPath() + getResourceBase().getWorkPath() + "/";
        //final String path = getResourceBase().getWorkPath() + "/";

        HashMap<String, String> params = new HashMap<String, String>();
        try
        {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart)
            {
                File tmpwrk = new File(SWBPortal.getWorkPath() + "/tmp");
                if (!tmpwrk.exists())
                {
                    tmpwrk.mkdirs();
                }
                FileItemFactory factory = new DiskFileItemFactory(1 * 1024 * 1024, tmpwrk);
                ServletFileUpload upload = new ServletFileUpload(factory);
                ProgressListener progressListener = new ProgressListener()
                {

                    private long kBytes = -1;

                    public void update(long pBytesRead, long pContentLength, int pItems)
                    {
                        long mBytes = pBytesRead / 10000;
                        if (kBytes == mBytes)
                        {
                            return;
                        }
                        kBytes = mBytes;
                        int percent = (int) (pBytesRead * 100 / pContentLength);
                    }
                };
                upload.setProgressListener(progressListener);
                List items = upload.parseRequest(request); /* FileItem */
                //FileItem currentFile = null;
                Iterator iter = items.iterator();
                while (iter.hasNext())
                {
                    FileItem item = (FileItem) iter.next();

                    if (item.isFormField())
                    {
                        String name = item.getFieldName();
                        String value = item.getString();
                        params.put(name, value);
                    }else
                    {
                        long serial = (new Date()).getTime();
                        if(item.getName().trim().length()==0)
                            continue;

                        String filename = serial + "_" + item.getFieldName() + item.getName().substring(item.getName().lastIndexOf("."));
                        
                        File image = new File(realpath);
                        if( !image.exists() ) {
                            image.mkdir();
                        }
                        image = new File(realpath + filename);
                        
                        File shrink = new File(realpath +"_"+ filename);
                        boolean shrinked = false;
                        try {
                            item.write(image);
                            shrinked = ImageResizer.shrinkTo(image, 101, 101, shrink, "jpeg");
                        }catch(Exception e) {
                            log.error("Error while writting file in resource instance CuponManager. ", e);
                        }
                        if(shrinked) {
                            image.delete();
                            shrink.renameTo(image);
                            image = shrink;
                        }
                        //params.put("partner", path + filename);
                        params.put("partner", filename);
                    }
                }
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
//        return null;
        return params;
    }

    private boolean isValidValue(String param) {
        try {
            if( (param=param.trim()).length()>0 )
                return true;
        }catch(Exception e) {
            return false;
        }
        return false;
    }

    private boolean isValidNumber(String param) {
        boolean validValue = false;
        if( param!=null && param.trim().length()>0 )
            try {
                Double.parseDouble(param);
                validValue = true;
            }catch(NumberFormatException  nfe) {
                validValue = false;
            }
        return validValue;
    }

    private boolean userCanEdit(final User user) {
        boolean access = false;
        Role superAdm = user.getUserRepository().getRole("superAdmProviders");
        if( user.hasRole(superAdm) ) {
            access = true;
        }
//        boolean access = false;
//
//        String roleName = getResourceBase().getAttribute("editRole");
//        if( user!=null && roleName!=null ) {
//            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
//            GenericObject gobj = null;
//            gobj = ont.getGenericObject(roleName);
//
//            if( gobj!=null ) {
//                UserGroup ugrp = null;
//                Role urole = null;
//
//                if(gobj instanceof UserGroup) {
//                    ugrp = (UserGroup) gobj;
//                    if(user.hasUserGroup(ugrp)) {
//                        access = true;
//                    }
//                }else if(gobj instanceof Role) {
//                    urole = (Role) gobj;
//                    if(user.hasRole(urole)) {
//                        access = true;
//                    }
//                }
//            }
//        }
        return access ;
    }
}
