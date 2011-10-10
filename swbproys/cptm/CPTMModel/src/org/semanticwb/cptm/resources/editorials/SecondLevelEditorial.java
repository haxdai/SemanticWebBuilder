/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources.editorials;


import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.EditNote;
import org.semanticwb.cptm.EditNoteType;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;


/**
 * Obtiene 3 Notas editoriales de tipo 2 y una de tipo 3 para mostrarlas,
 * actualmente en el Home del sitio.
 * @author jose.jimenez
 */
public class SecondLevelEditorial extends GenericResource {


    /**
     * Realiza las operaciones de escritura en la bitácora configurada para la instancia de SWB.
     */
    private static Logger log = SWBUtils.getLogger(SecondLevelEditorial.class);


    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
        } catch (Exception e) {
            log.error("Error while setting resource base: " + base.getId() + "-" + base.getTitle(), e);
        }
    }

    /**
     * Realiza la obtenci&oacute;n de los objetos {@code EditNote} necesarios para mostrarlos
     * en pantalla y a trav&eacute;s de una JSP se da la presentaci&oacute;n requerida.
     * @param request el objeto HttpServletRequest a atender
     * @param response el objeto HttpServletResponse de la respuesta a la petici&oacute;n Http
     * @param paramsRequest el objeto SWBParamRequest con m&aacute;s datos de la petici&oacute;n
     * @throws SWBResourceException la excepci&oacute;n arrojada en caso de error de ejecuci&oacute;n
     * @throws IOException la excepci&oacute;n arrojada en case de error de I/O
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        WebSite site = paramsRequest.getWebPage().getWebSite();
        Iterator<EditNote> it = null;
        Resource base = getResourceBase();
        TreeMap<Integer, EditNote> map = new TreeMap<Integer, EditNote>();
        String viewPath = SWBPortal.getWebWorkPath() + "/models/"
                + base.getWebSiteId() + "/jsp/SecondLevelEditorials.jsp";
//        boolean showHomeDisplay = webPage.getId().equalsIgnoreCase("home") ? true : false;
//        boolean showCanalDisplay = false;
        User user = paramsRequest.getUser();
        EditNote editorialTipo3 = null;
        EditNoteType noteType2 = null;
        EditNoteType noteType3 = null;
        int cont = 0;

        noteType2 = EditNoteType.ClassMgr.getEditNoteType("T2", site);
        noteType3 = EditNoteType.ClassMgr.getEditNoteType("T3", site);

        try {
            if (noteType2 != null) {
                //Se obtienen solo las notas de segundo nivel
                it = EditNote.ClassMgr.listEditNoteByNoteType(noteType2, site);
            }
        } catch (Exception e) {
            SecondLevelEditorial.log.error("Error while getting list of Type2 EditNotes.", e);
        }

        if (it != null) {
            //Se extraen las 3 notas a mostrar
            while (it.hasNext()) {
                EditNote editorial = it.next();

                if (editorial != null && editorial.isActive() && editorial.getNoteHomeIndex() < 4 && user.haveAccess(editorial) && map.size() < 3) {
                    cont++;
                    map.put(Integer.valueOf(editorial.getNoteHomeIndex()), editorial);
                } else if (map.size() >= 3) {
                    break;
                }
            }
        }

        try {
            if (noteType3 != null) {
                //Se obtienen solo las notas de tercer nivel
                it = EditNote.ClassMgr.listEditNoteByNoteType(noteType3, site);
            }
        } catch (Exception e) {
            SecondLevelEditorial.log.error("Error while getting list of Type3 EditNotes.", e);
        }
        if (it != null) {
            //Se extrae la nota a mostrar de tipo 3
            while (it.hasNext()) {
                EditNote editorial = it.next();

                if (editorial != null && editorial.isActive() && editorial.getNoteHomeIndex() < 2 && user.haveAccess(editorial)) {
                    editorialTipo3 = editorial;
                    break;
                }
            }
        }
        it = null;

        request.setAttribute("editorials", map);
        request.setAttribute("editorialTipo3", editorialTipo3);
        request.setAttribute("paramsRequest", paramsRequest);
        try {
            request.getRequestDispatcher(viewPath).include(request, response);
        } catch (ServletException se) {
            SecondLevelEditorial.log.error("Error at including JSP in request dispatching.", se);
        }

    }

}
