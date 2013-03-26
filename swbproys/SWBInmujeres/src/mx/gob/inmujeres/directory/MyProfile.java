package mx.gob.inmujeres.directory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class MyProfile extends GenericResource
{

    static Logger log = SWBUtils.getLogger(MyProfile.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        // vista de usuario
        try
        {
            boolean showDocuments = Directorio.showDocuments(paramRequest.getUser().getLogin(), paramRequest.getUser(), paramRequest.getWebPage().getWebSite().getUserRepository());
            Directorio.vistaDetalle(paramRequest, paramRequest.getUser().getLogin(), request, response, Directorio.isRHUser(paramRequest.getUser(), paramRequest.getWebPage().getWebSite().getUserRepository()), showDocuments);
        }
        catch (Exception e)
        {
            log.error(e);
        }

    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if ("AddDocument".equals(paramRequest.getMode()))
        {
            Directorio.doAddDocument(request, response, paramRequest);
        }
        else if(SWBParamRequest.Mode_VIEW.equals(paramRequest.getMode()))
        {
            doView(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if ("deleteDoc".equals(response.getMode()))
        {
            String siteId = response.getWebPage().getWebSiteId();
            response.setMode(response.Mode_VIEW);
            String user = request.getParameter("user");
            if (user != null)
            {
                String id = request.getParameter("id");
                if (id != null)
                {
                    try
                    {
                        String login = user;
                        String path = SWBUtils.getApplicationPath() + "/work/models/" + siteId + "/jsp/" + login + "/" + id;
                        Directorio.borraArchivo(user, id);
                        File file = new File(path);
                        if (file.exists())
                        {
                            file.delete();
                        }
                    }
                    catch (Exception e)
                    {
                        log.error(e);
                    }
                }
                response.setRenderParameter("user", user);
            }
            return;
        }
        String siteId = response.getWebPage().getWebSiteId();
        String msgError = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fu = new ServletFileUpload(factory);
        java.util.List<FileItem> items = null;
        try
        {
            items = fu.parseRequest(request);
        }
        catch (Exception e)
        {
            log.error(e);
            msgError = "(Ver log de errores)Error al insertar documento:" + e.getMessage();
        }
        String titulo = null;
        String login = null;
        FileItem file = null;
        for (FileItem item : items)
        {
            if (item.getFieldName().equals("titulo"))
            {
                titulo = item.getString();
            }
            if (item.getFieldName().equals("user"))
            {
                login = item.getString();
            }
            if (item.getFieldName().equals("doc"))
            {
                file = item;
            }

        }
        if (login != null && titulo != null && file != null)
        {
            if (!Directorio.isRHUser(response.getUser(), response.getUser().getUserRepository()))
            {
                msgError = "Solo un usuario de RH puede agregar documentos";
            }
            else
            {

                if (login.trim().isEmpty() || titulo.trim().isEmpty())
                {
                    msgError = "El valor de título o usuario es vácio";
                }
                else
                {
                    if (Directorio.existe(login))
                    {
                        try
                        {

                            String extension = "";
                            String name = file.getName();
                            int pos = name.lastIndexOf(".");
                            String finalName = name;
                            if (pos != -1)
                            {
                                extension = name.substring(pos);
                            }
                            Integer id = Directorio.insertDocument(login, titulo, response.getUser().getLogin(), extension);
                            String path = SWBUtils.getApplicationPath() + "/work/models/" + siteId + "/jsp/" + login + "/";
                            File dir = new File(path);
                            dir.mkdirs();
                            path += id + extension;
                            Directorio.saveFile(file, path);
                        }
                        catch (Exception e)
                        {
                            log.error(e);
                            msgError = "Error al registrar documento (vease log): " + e.getMessage();
                        }
                    }
                    else
                    {
                        // error
                        msgError = "El valor de título o usuario es nulo";
                    }
                }

            }

        }
        else
        {
            msgError = "Los datos son incorrectos, vuelva a intentar";
        }
        if (msgError != null)
        {
            // manda pantalla de error;
            response.setMode("error");
        }
        else
        {
            response.setRenderParameter("user", login);
            response.setMode(response.Mode_VIEW);
        }




    }
}
