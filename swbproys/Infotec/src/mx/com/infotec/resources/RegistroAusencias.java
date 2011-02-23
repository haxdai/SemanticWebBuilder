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
import mx.com.infotec.model.Ausencia;
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
public class RegistroAusencias extends GenericResource {

    private Logger log = SWBUtils.getLogger(RegistroAusencias.class);

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
            act = "show";
        }


        int usrlevel = getLevelUser(user);

        if (usrlevel > 0) {

            if ("addNew".equals(act)) {
                out.println("<p >");
                out.println("<h2>Registra tu Ausencia");
                out.println("</h2>");
                out.println("</p>");
                out.println("<div>");

                SWBFormMgr mgr = new SWBFormMgr(Ausencia.info_Ausencia, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
                mgr.setType(SWBFormMgr.TYPE_DOJO);

                SWBResourceURL urla = paramsRequest.getActionUrl();
                urla.setAction("new");

                mgr.setAction(urla.toString());
                mgr.addButton(SWBFormButton.newSaveButton());
                mgr.addButton(SWBFormButton.newCancelButton());

                out.println(mgr.renderForm(request));

                SWBResourceURL urls = paramsRequest.getRenderUrl();
                urls.setAction("show");
                out.println("<p align=\"center\"><a href=\"" + urls + "\">Cancelar</a></p>");
                out.println("</div>");
            } else {

                out.println("<p >");
                out.println("<h2>Mis Ausencias");
                out.println("</h2>");
                out.println("</p>");

                out.println("<div>");

                out.println("<fieldset>");
                out.println("<table width=\"100%\">");

                out.println("<tr>");
                out.println("<th>");
                out.println("&nbsp;");
                out.println("</th>");
                out.println("<th>");
                out.println(Ausencia.info_tipo.getDisplayName(user.getLanguage()));
                out.println("</th>");
                out.println("<th>");
                out.println(Ausencia.info_descripcion.getDisplayName(user.getLanguage()));
                out.println("</th>");
                out.println("<th>");
                out.println(Ausencia.info_fechaInicial.getDisplayName(user.getLanguage()));
                out.println("</th>");
                out.println("<th>");
                out.println(Ausencia.info_fechaFin.getDisplayName(user.getLanguage()));
                out.println("</th>");
                out.println("<th>");
                out.println(Traceable.swb_created.getDisplayName(user.getLanguage()));
                out.println("</th>");
                out.println("<th colspan=\"2\">");
                out.println(Ausencia.info_autorizado.getDisplayName(user.getLanguage()));
                out.println("</th>");
                out.println("</tr>");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

                Iterator<Ausencia> ite = Ausencia.ClassMgr.listAusenciaByCreator(user, ws);

                while (ite.hasNext()) {

                    Ausencia ausencia = ite.next();

                    out.println("<tr>");
                    out.println("<td>");

                    SWBResourceURL urladel = paramsRequest.getActionUrl();
                    urladel.setAction("delete");
                    urladel.setParameter("uri", ausencia.getURI());

                    if ((usrlevel >= 1 && !ausencia.isAutorizado())) //&&!user.equals(ausencia.getCreator())
                    {
                        out.println("<a href=\"#\" onclick=\"if(confirm('Estás seguro de eliminar esta Ausencia?')){window.location='" + urladel + "';return false;} else return false;\">eliminar</a>");
                    }

                    out.println("</td>");
                    out.println("<td>");
                    out.println(ausencia.getTipoAusencia());
                    out.println("</td>");
                    out.println("<td>");
                    String descripcion = ausencia.getDescripcion();
                    out.println(descripcion);
                    out.println("</td>");
                    out.println("<td>");
                    Date date = ausencia.getFechaInicial();
                    out.println(null != date ? sdf.format(date) : "sin fecha");
                    out.println("</td>");
                    out.println("<td>");
                    date = ausencia.getFechaFin();
                    out.println(null != date ? sdf.format(date) : "sin fecha");
                    out.println("</td>");
                    out.println("<td>");
                    date = ausencia.getCreated();
                    out.println(null != date ? sdf.format(date) : "sin fecha");
                    out.println("</td>");
                    out.println("<td>");
                    boolean autorized = ausencia.isAutorizado();
                    out.println(autorized ? "Autorizado" : "Pendiente por autorizar");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("&nbsp;");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<p>");
                SWBResourceURL urlb = paramsRequest.getRenderUrl();
                urlb.setAction("addNew");
                out.println("<a href=\"" + urlb + "\">Agregar nueva Ausencia</a>");
                out.println("</p>");
                out.println("</fieldset>");

                if (usrlevel >= 2) {
                    out.println("<p >");
                    out.println("<h2>Listado de ausencias: Autorizadas / Por Autorizar");
                    out.println("</h2>");
                    out.println("</p>");

                    out.println("<div>");

                    SWBResourceURL urlautorize = paramsRequest.getActionUrl();
                    urlautorize.setAction("autorize");


                    out.println("<form action=\"" + urlautorize + "\" method=\"post\">");
                    out.println("<fieldset>");
                    out.println("<table width=\"100%\">");

                    out.println("<tr>");
                    out.println("<th>");
                    out.println("&nbsp;");
                    out.println("</th>");
                    out.println("<th>");
                    out.println(Ausencia.info_tipo.getDisplayName(user.getLanguage()));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(Ausencia.info_descripcion.getDisplayName(user.getLanguage()));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(Ausencia.info_fechaInicial.getDisplayName(user.getLanguage()));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(Ausencia.info_fechaFin.getDisplayName(user.getLanguage()));
                    out.println("</th>");

                    out.println("<th>");
                    out.println(Traceable.swb_created.getDisplayName(user.getLanguage()));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(Ausencia.info_autorizado.getDisplayName(user.getLanguage()));
                    out.println("</th>");
                    out.println("<th colspan=\"2\">");
                    out.println(Traceable.swb_creator.getDisplayName(user.getLanguage()));
                    out.println("</th>");
                    out.println("</tr>");

                    boolean showBtn = false;

                    ite = Ausencia.ClassMgr.listAusencias(ws);

                    while (ite.hasNext()) {

                        Ausencia ausencia = ite.next();

                        if (user.equals(ausencia.getCreator())) {
                            continue;
                        }

                        out.println("<tr>");
                        out.println("<td>");

                        if (usrlevel > 2) {
                            SWBResourceURL urladel = paramsRequest.getActionUrl();
                            urladel.setAction("delete");
                            urladel.setParameter("uri", ausencia.getURI());
                            out.println("<a href=\"#\" onclick=\"if(confirm('Estás seguro de eliminar esta Ausencia?')){window.location='" + urladel + "';return false;} else return false;\">eliminar</a>");
                        } else {
                            out.println("&nbsp;");
                        }
                        out.println("</td>");
                        out.println("<td>");
                        out.println(ausencia.getTipoAusencia());
                        out.println("</td>");
                        out.println("<td>");
                        String descripcion = ausencia.getDescripcion();
                        out.println(descripcion);
                        out.println("</td>");
                        out.println("<td>");
                        Date date = ausencia.getFechaInicial();
                        out.println(null != date ? sdf.format(date) : "sin fecha");
                        out.println("</td>");
                        out.println("<td>");
                        date = ausencia.getFechaFin();
                        out.println(null != date ? sdf.format(date) : "sin fecha");
                        out.println("</td>");
                        out.println("<td>");
                        date = ausencia.getCreated();
                        out.println(null != date ? sdf.format(date) : "sin fecha");
                        out.println("</td>");
                        out.println("<td>");
                        boolean autorized = ausencia.isAutorizado();
                        out.println(autorized ? "Autorizado" : "Pendiente por autorizar");
                        out.println("</td>");
                        out.println("<td>");
                        out.println(ausencia.getCreator().getFullName());
                        out.println("</td>");
                        out.println("<td>");
                        if (!ausencia.isAutorizado()) {
                            showBtn = true;
                            out.println("<input type=\"checkbox\" name=\"vals\" value=\"" + ausencia.getURI() + "\"> ");
                        } else {
                            out.println("<input type=\"hidden\" name=\"vals\" > ");
                        }
                        out.println("</td>");

                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("</fieldset>");


                    if (showBtn) {
                        out.println("<fieldset>");

                        out.println("<button dojoType=\"dijit.form.Button\" type=\"button\"  onclick=\"selectAll('vals',true);\">Seleccionar todos</button>"); //submitUrl('" + url + "',this);
                        out.println("<button dojoType=\"dijit.form.Button\" type=\"button\"  onclick=\"selectAll('vals',false);\">Deseleccionar todos</button>"); //submitUrl('" + url + "',this);
                        out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"btnSend\">Autorizar</button>");

                        out.println("</fieldset>");
                    }
                }
                out.println("</form>");
                out.println("</div>");
            }


        } else {
            out.println("<fieldset>");
            out.println("<h2>Para Registrar tu Ausencia, debes de estar registrado en el sitio.");
            out.println("</h2>");
            out.println("</fieldset>");
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebSite ws = response.getWebPage().getWebSite();
        if (null == action) {
            action = "";
        }

        if ("new".equals(action)) {
            //System.out.println("Creando Ausencia...");

            try {
                SWBFormMgr mgr = new SWBFormMgr(Ausencia.info_Ausencia, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
                SemanticObject sonew = mgr.processForm(request);
                //System.out.println("sonew: "+sonew.getURI());
            } catch (Exception e) {
                log.error("Error al procesar la forma al agregar una Ausencia", e);
            }
        } else if ("autorize".equals(action)) {
            String[] uri = request.getParameterValues("vals");
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = null;

            if (uri.length > 0) {
                for (int i = 0; i < uri.length; i++) {
                    so = ont.getSemanticObject(uri[i]);
                    if (null != so) {
                        so.setBooleanProperty(Ausencia.info_autorizado, true);
                    }
                }
            }

            //response.setAction("show");

        } else if ("delete".equals(action)) {
            String uri = request.getParameter("uri");
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(uri);
            if (null != so) {
                so.remove();
            }

            response.setAction("show");

        } else if ("admin_update".equals(action)) {

            //System.out.println("Actualizando....");

            String viewrole = request.getParameter("ver");
            String modifyrole = request.getParameter("modificar");
            String adminrole = request.getParameter("administrar");

            Resource base = getResourceBase();

            if (viewrole != null && viewrole.equals("0")) {
                base.setAttribute("see", viewrole);
            } else {
                base.removeAttribute("see");
            }
            if (modifyrole != null && modifyrole.equals("0")) {
                base.setAttribute("supervisor", modifyrole);
            } else {
                base.removeAttribute("supervisor");
            }
            if (adminrole != null && adminrole.equals("0")) {
                base.setAttribute("admin", adminrole);
            } else {
                base.removeAttribute("admin");
            }

            try {
                getResourceBase().updateAttributesToDB();
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
