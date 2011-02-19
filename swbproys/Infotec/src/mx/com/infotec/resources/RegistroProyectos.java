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
import mx.com.infotec.model.Proyecto;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Traceable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author juan.fernandez
 */
public class RegistroProyectos extends GenericAdmResource {

    private Logger log = SWBUtils.getLogger(RegistroProyectos.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        User user = paramsRequest.getUser();
        WebSite ws = paramsRequest.getWebPage().getWebSite();

        String act = paramsRequest.getAction();

        if (null == act) {
            act = "";
        }


        if (user.isSigned()) {
            out.println("<p >");
            out.println("<h2>Proyectos");
            out.println("</h2>");
            out.println("</p>");
            if ("new".equals(act)) {
                out.println("<div>");

                out.println("<p >");
                out.println("<h2>Nuevo Proyecto");
                out.println("</h2>");
                out.println("</p>");

                SWBFormMgr mgr = new SWBFormMgr(Proyecto.info_Proyecto, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
                mgr.setType(SWBFormMgr.TYPE_DOJO);



                SWBResourceURL urla = paramsRequest.getActionUrl();
                urla.setAction("new");

                mgr.setAction(urla.toString());
                mgr.addButton(SWBFormButton.newSaveButton());
                mgr.addButton(SWBFormButton.newCancelButton());

                out.println(mgr.renderForm(request));

                out.println("<p>");
                SWBResourceURL urlb = paramsRequest.getRenderUrl();
                urlb.setAction("");
                out.println("<a href=\"" + urlb + "\">regresar</a>");
                out.println("</p>");
                out.println("</div>");
            } if ("detail".equals(act)) {

                String sval = request.getParameter("suri");

                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                SemanticObject so = ont.getSemanticObject(sval);

                Proyecto proy = (Proyecto) so.getGenericInstance();

                out.println("<div>");

                out.println("<p >");
                out.println("<h2>Detalle Proyecto");
                out.println("</h2>");
                out.println("</p>");

                String frmMode = SWBFormMgr.MODE_VIEW;

                if(user.equals(proy.getApResponsable()))  frmMode = SWBFormMgr.MODE_EDIT;


                SWBFormMgr mgr = new SWBFormMgr(so, frmMode, frmMode);
                mgr.setType(SWBFormMgr.TYPE_DOJO);

                SWBResourceURL urla = paramsRequest.getActionUrl();
                urla.setAction("new");

                mgr.setAction(urla.toString());
                mgr.addButton(SWBFormButton.newSaveButton());
                mgr.addButton(SWBFormButton.newCancelButton());

                out.println(mgr.renderForm(request));


                out.println("</div>");
                out.println("<p>");
                SWBResourceURL urlb = paramsRequest.getRenderUrl();
                urlb.setAction("");
                out.println("<a href=\"" + urlb + "\">regresar</a>");
                out.println("</p>");
            } else {

                out.println("<div>");

                out.println("<p >");
                out.println("<h2>Lista de Proyectos");
                out.println("</h2>");
                out.println("</p>");

                out.println("<fieldset>");
                out.println("<table width=\"100%\">");

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

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

                Iterator<Proyecto> ite = Proyecto.ClassMgr.listProyectos(ws);
                while (ite.hasNext()) {

                    Proyecto proy = ite.next();

                    out.println("<tr>");

                    out.println("<td>");
                    SWBResourceURL urledit = paramsRequest.getRenderUrl();
                    urledit.setAction("edit");
                    urledit.setParameter("uri", proy.getURI());
                    out.println("<a href=\"#\" onclick=\"window.location='" + urledit + "';return false;\">editar</a>");

                    SWBResourceURL urladel = paramsRequest.getActionUrl();
                    urladel.setAction("delete");
                    urladel.setParameter("uri", proy.getURI());
                    out.println("<a href=\"#\" onclick=\"if(confirm('Estás seguro de eliminar este Proyecto?')){window.location='" + urladel + "';return false;} else return false;\">eliminar</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getId());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getNumProyecto());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getApResponsable().getName());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getCliente());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(proy.getProyecto());
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
                out.println("</table>");

                out.println("</fieldset>");
                SWBResourceURL urls = paramsRequest.getRenderUrl();
                urls.setAction("new");
                out.println("<p align=\"center\"><a href=\"" + urls + "\">Agregar proyectos</a></p>");
                out.println("</div>");
            }


        } else {
            out.println("<fieldset>");
            out.println("<h2>Para Registrar tu Proyecto, debes de estar registrado en el sitio.");
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
                SWBFormMgr mgr = new SWBFormMgr(Proyecto.info_Proyecto, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
                SemanticObject sonew = mgr.processForm(request);
                //System.out.println("sonew: "+sonew.getURI());
            } catch (Exception e) {
                log.error("Error al procesar la forma al agregar un Proyecto", e);
            }
        } else if ("update".equals(action)) {
            String uri = request.getParameter("uri");
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(uri);
            try {
                SWBFormMgr mgr = new SWBFormMgr(so, SWBFormMgr.MODE_EDIT, SWBFormMgr.MODE_EDIT);
                SemanticObject sonew = mgr.processForm(request);
                //System.out.println("sonew: "+sonew.getURI());
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

        }

    }
}
