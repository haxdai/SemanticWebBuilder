/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.infotec.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.infotec.model.Proyecto;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.Traceable;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author juan.fernandez
 */
public class RegistroProyectos extends GenericResource {

    private Logger log = SWBUtils.getLogger(RegistroProyectos.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        User user = paramsRequest.getUser();
        WebSite ws = paramsRequest.getWebPage().getWebSite();

        String act = paramsRequest.getAction();

        if (null == act) {
            act = "";
        }



        int usrlev = getLevelUser(user);

        //System.out.println("nivel usr: "+usrlev);

        if (user.isSigned()) {

            if ("new".equals(act)) {

                out.println("<h2>Nuevo Proyecto</h2>");

                SWBFormMgr mgr = new SWBFormMgr(Proyecto.info_Proyecto, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
                mgr.setType(SWBFormMgr.TYPE_DOJO);

                SWBResourceURL urla = paramsRequest.getActionUrl();
                urla.setAction("new");

                mgr.setAction(urla.toString());
                mgr.addButton(SWBFormButton.newSaveButton());

                SWBResourceURL urlb = paramsRequest.getRenderUrl();
                urlb.setAction("");
                mgr.addButton("<button dojoType=\"dijit.form.Button\" onclick=\"window.location='"+urlb+"'; return false;\" class=\"boton\">Cancelar</button>");
                out.println("<div class=\"formulario\">");
                out.println(mgr.renderForm(request));
                out.println("</div>");

            } if ("detail".equals(act)) {

                String sval = request.getParameter("suri");

                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                SemanticObject so = ont.getSemanticObject(sval);

                Proyecto proy = (Proyecto) so.getGenericInstance();

                out.println("<h2>Detalle Proyecto</h2>");

                String frmMode = SWBFormMgr.MODE_VIEW;

                boolean edit=false;
                if(null!=proy.getCreator()&&user.equals(proy.getCreator())||usrlev==3)  {

                    edit = true;
                    frmMode = SWBFormMgr.MODE_EDIT;
                }


                SWBFormMgr mgr = new SWBFormMgr(so, frmMode, frmMode);

                mgr.setType(SWBFormMgr.TYPE_DOJO);

                SWBResourceURL urla = paramsRequest.getActionUrl();
                urla.setAction("update");

                mgr.setAction(urla.toString());
                

                if(edit){
                    mgr.addHiddenParameter("suri", sval);
                    mgr.addButton(SWBFormButton.newSaveButton());
                }
                SWBResourceURL urlb = paramsRequest.getRenderUrl();
                urlb.setAction("");
                mgr.addButton("<button dojoType=\"dijit.form.Button\" onclick=\"window.location='"+urlb+"'; return false;\" class=\"boton\">Cancelar</button>");
                out.println("<div class=\"formulario\">");
                out.println(mgr.renderForm(request));
                out.println("</div>");

            } else {

                out.println("<h2>Lista de Proyectos</h2>");
               
                out.println("<table width=\"100%\">");

                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>");
                out.println("&nbsp;");
                out.println("</th>");
                out.println("<th>");
                out.println("Id");
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_numProyecto.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_apResponsable.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_cliente.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_proyecto.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_situacionContractual.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_situacionCobro.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_situacionFacturacion.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Proyecto.info_statusGralProyecto.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Traceable.swb_created.getLabel());
                out.println("</th>");
                out.println("<th>");
                out.println(Traceable.swb_updated.getLabel());
                out.println("</th>");
                out.println("</tr>");
                out.println("</thead>");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

                out.println("<tbody>");
                Iterator<Proyecto> ite = Proyecto.ClassMgr.listProyectos(ws);
                while (ite.hasNext()) {

                    Proyecto proy = ite.next();

                    out.println("<tr>");

                    out.println("<td>");

                    SWBResourceURL urledit = paramsRequest.getRenderUrl();
                    urledit.setAction("detail");
                    urledit.setParameter("suri", proy.getURI());
                    String srtMsg = "<a href=\"#\" onclick=\"window.location='" + urledit + "';return false;\" class=\"detalle\" title=\"detalle\">detalle</a>";

                    if(proy.getCreator()!=null&&proy.getCreator().equals(user)||usrlev>=2)
                    {
                        srtMsg = "<a href=\"#\" onclick=\"window.location='" + urledit + "';return false;\" class=\"editar\" title=\"editar\">editar</a>";
                    }
                    
                    out.println(srtMsg);

                    if(proy.getCreator()!=null&&proy.getCreator().equals(user)||usrlev==3)
                    {
                        SWBResourceURL urladel = paramsRequest.getActionUrl();
                        urladel.setAction("delete");
                        urladel.setParameter("uri", proy.getURI());
                        out.println("<a href=\"#\" onclick=\"if(confirm('¿Estás seguro de querer eliminar este Proyecto?')){window.location='" + urladel + "';return false;} else return false;\" class=\"borrar\" title=\"eliminar\">borrar</a>");
                    } else {
                        out.println("&nbsp;&nbsp;");
                    }
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getId());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getNumProyecto()!=null?proy.getNumProyecto():"--");
                    out.println("</td>");
                    out.println("<td>");

                    User usrResp = proy.getApResponsable();

                    out.println(usrResp!=null?usrResp.getFullName():"No asignado");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getCliente()!=null?proy.getCliente():"--");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getProyecto()!=null?proy.getProyecto():"--");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getSituacionContractual());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getSituacionCobro());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getSituacionFacturacion());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getStatusGralProyecto());
                    out.println("</td>");
                    out.println("<td>");
                    Date date = proy.getCreated();
                    out.println(null != date ? sdf.format(date) : "sin fecha");
                    out.println("</td>");
                    out.println("<td>");
                    date = proy.getUpdated();
                    out.println(null != date ? sdf.format(date) : "sin fecha");
                    out.println("</td>");
                    out.println("</tr>");

                }
                out.println("</tbody>");
                out.println("</table>");

                if(usrlev>0)
                {
                    SWBResourceURL urls = paramsRequest.getRenderUrl();
                    urls.setAction("new");

                    out.println("<hr>");
                    out.println("<h2 ><a href=\"" + urls + "\" class=\"ico-proy\">Agregar proyecto</a></h2>");

                }
            }


        } else {

            out.println("<h3>Para consultar los Proyectos, debes de estar registrado en el sitio.</h3>");

        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebSite ws = response.getWebPage().getWebSite();
        User user = response.getUser();
        if (null == action) {
            action = "";
        }

        if ("new".equals(action)) {
            try {
                SWBFormMgr mgr = new SWBFormMgr(Proyecto.info_Proyecto, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
                SemanticObject sonew = mgr.processForm(request);


                if(sonew!=null&&sonew.createGenericInstance() instanceof Proyecto)
                {
                    response.setMode(SWBActionResponse.Mode_VIEW);
                    response.setAction("detail");
                    response.setRenderParameter("suri", sonew.getURI());

                    Proyecto proy = (Proyecto)sonew.createGenericInstance();
                    proy.setApResponsable(user);
                }
            } catch (Exception e) {
                log.error("Error al procesar la forma al agregar un Proyecto", e);
            }

        } else if ("update".equals(action)) {
            String uri = request.getParameter("suri");
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(uri);
            try {
                SWBFormMgr mgr = new SWBFormMgr(so, SWBFormMgr.MODE_EDIT, SWBFormMgr.MODE_EDIT);
                SemanticObject sonew = mgr.processForm(request);
            } catch (Exception e) {
                log.error("Error al procesar la forma al actualizar un Proyecto", e);
            }

        } else if ("delete".equals(action)) {
            String uri = request.getParameter("uri");
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(uri);
            if (null != so) {
                so.remove();
            }

            response.setAction("show");

        } else if ("admin_update".equals(action)) {

            String viewrole = request.getParameter("ver");
            String modifyrole = request.getParameter("modificar");
            String adminrole = request.getParameter("administrar");

            Resource base = getResourceBase();

            if (viewrole != null && !viewrole.equals("0")) {
                base.setAttribute("see", viewrole);
            } else {
                base.removeAttribute("see");
            }
            if (modifyrole != null && !modifyrole.equals("0")) {
                base.setAttribute("supervisor", modifyrole);
            } else {
                base.removeAttribute("supervisor");
            }
            if (adminrole != null && !adminrole.equals("0")) {
                base.setAttribute("admin", adminrole);
            } else {
                base.removeAttribute("admin");
            }

            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error("Error al actualizar los roles de Ausencias.", e);
            }

            response.setMode(SWBActionResponse.Mode_ADMIN);
            response.setAction("edit");

        }

    }


    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        String id = getResourceBase().getId();

        PrintWriter out = response.getWriter();
        String accion = paramsRequest.getAction();
        if (accion == null) {
            accion = "";
        }

        WebPage wpage = paramsRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();

        out.println("<div class=\"swbform\">");

        if (accion.equals("edit")) {

            SWBResourceURL urlA = paramsRequest.getActionUrl();
            urlA.setAction("admin_update");

            out.println("<form id=\"" + id + "_myform_repfile\"  name=\"" + id + "_myform_repfile\" action=\"" + urlA.toString() + "\" method=\"post\" onsubmit=\"submitForm('" + id + "_myform_repfile');return false;\">");

            out.println("<fieldset>");
            out.println("<legend>");
            out.println("Administrar permisos para el registro de Ausencias");
            out.println("</legend>");

            out.println("<table width=\"100%\" border=\"0\" >");
            out.println("<tr><td colspan=\"2\"><B>" + paramsRequest.getLocaleString("msgRolesDefinitionLevel") + "</b></td></tr>");
            out.println("<tr><td align=\"right\" width=150>" + paramsRequest.getLocaleString("msgView") + ":</td>");
            out.println("<td><select name=\"ver\">" + getSelectOptions("ver", wsite, paramsRequest) + "</select></td></tr>");
            out.println("<tr><td align=\"right\" width=150>" + paramsRequest.getLocaleString("msgModify") + ":</td>");
            out.println("<td><select name=\"modificar\">" + getSelectOptions("modificar", wsite, paramsRequest) + "</select></td></tr>");
            out.println("<tr><td align=\"right\"  width=150>" + paramsRequest.getLocaleString("msgAdministrate") + ":</td>");
            out.println("<td><select name=\"administrar\">" + getSelectOptions("administrar", wsite, paramsRequest) + "</select></td></tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<fieldset>");
            out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" id=\"" + id + "btn\" name=\"btn\" >" + paramsRequest.getLocaleString("msgBTNAccept"));
            out.println("</button>");

            out.println("</fieldset>");
            out.println("</form>");

        }

        out.println("</div>");
    }

    public String getSelectOptions(String type, WebSite wsite, SWBParamRequest paramsRequest) {

        Resource base = getResourceBase();

        UserRepository userRep = base.getWebSite().getUserRepository();

        String strTemp = "";
        try {

            User user = paramsRequest.getUser();

            String selectedItem = "";
            if (type.equals("ver")) {
                selectedItem = base.getAttribute("see", "");
            } else if (type.equals("modificar")) {
                selectedItem = base.getAttribute("supervisor", "");

            } else if (type.equals("administrar")) {
                selectedItem = base.getAttribute("admin", "");
            }

            strTemp = "<option value=\"-1\">" + paramsRequest.getLocaleString("msgNoRolesAvailable") + "</option>";


            Iterator<Role> iRoles = userRep.listRoles();
            StringBuffer strRules = new StringBuffer("");
            strRules.append("\n<option value=\"0\">" + paramsRequest.getLocaleString("msgSelNone") + "</option>");
            strRules.append("\n<optgroup label=\"Roles\">");
            while (iRoles.hasNext()) {
                Role oRole = iRoles.next();
                strRules.append("\n<option value=\"" + oRole.getURI() + "\" " + (selectedItem.equals(oRole.getURI()) ? "selected" : "") + ">" + oRole.getDisplayTitle(user.getLanguage()) + "</option>");
            }
            strRules.append("\n</optgroup>");

            strRules.append("\n<optgroup label=\"User Groups\">");
            Iterator<UserGroup> iugroups = userRep.listUserGroups();
            while (iugroups.hasNext()) {
                UserGroup oUG = iugroups.next();
                strRules.append("\n<option value=\"" + oUG.getURI() + "\">" + oUG.getDisplayTitle(user.getLanguage()) + "</option>");
            }
            strRules.append("\n</optgroup>");
            if (strRules.toString().length() > 0) {
                strTemp = strRules.toString();
            }

        } catch (Exception e) {
            log.error("Error al cargar los roles y grupos de usuario.", e);
        }



        return strTemp;
    }

    public int getLevelUser(User user) {

        Resource base = getResourceBase();
        int level = 0;

        if (null == user) {
            return level;
        }

        String uriView = base.getAttribute("see", "0");
        String uriModify = base.getAttribute("supervisor", "0");
        String uriAdmin = base.getAttribute("admin", "0");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject gobj = null;
        try {
            gobj = ont.getGenericObject(uriAdmin);
        } catch (Exception e) {
            //log.error("Errror getLevelUser()",e);
        }

        UserGroup ugrp = null;
        Role urole = null;

        if (!uriAdmin.equals("0")) {
            if (gobj != null) {
                if (gobj instanceof UserGroup) {
                    ugrp = (UserGroup) gobj;
                    if (user.hasUserGroup(ugrp)) {
                        level = 3;
                    }
                } else if (gobj instanceof Role) {
                    urole = (Role) gobj;
                    if (user.hasRole(urole)) {
                        level = 3;
                    }
                }
            } else {
                level = 3;
            }
        } else {
            level = 3;
        }

        if (level == 0) {
            if (!uriModify.equals("0")) {
                gobj = ont.getGenericObject(uriModify);
                if (gobj != null) {
                    if (gobj instanceof UserGroup) {
                        ugrp = (UserGroup) gobj;
                        if (user.hasUserGroup(ugrp)) {
                            level = 2;
                        }
                    } else if (gobj instanceof Role) {
                        urole = (Role) gobj;
                        if (user.hasRole(urole)) {
                            level = 2;
                        }
                    }
                } else {
                    level = 2;
                }
            } else {
                level = 2;
            }
        }

        if (level == 0) {
            if (!uriView.equals("0")) {
                gobj = ont.getGenericObject(uriView);
                if (gobj != null) {
                    if (gobj instanceof UserGroup) {
                        ugrp = (UserGroup) gobj;
                        if (user.hasUserGroup(ugrp)) {
                            level = 1;
                        }
                    } else if (gobj instanceof Role) {
                        urole = (Role) gobj;
                        if (user.hasRole(urole)) {
                            level = 1;
                        }
                    }
                } else {
                    level = 1;
                }
            } else {
                level = 1;
            }
        }

        return level;
    }

}
