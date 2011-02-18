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
public class RegistroAusencias extends GenericAdmResource {

    private Logger log = SWBUtils.getLogger(RegistroAusencias.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        User user = paramsRequest.getUser();
        WebSite ws = paramsRequest.getWebPage().getWebSite();

        String act = paramsRequest.getAction();
        
        if(null==act) act="";


        if(user.isSigned())
        {
            out.println("<fieldset>");
            out.println("<legend>Registra tu Ausencia");
            out.println("</legend>");
            out.println("</fieldset>");
            if(!"show".equals(act))
            {
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
            out.println("<p align=\"center\"><a href=\""+urls+"\">ver mis ausencias</a></p>");
            out.println("</div>");
            } else {

            out.println("<div>");

            out.println("<fieldset>");
            out.println("<table width=\"100%\">");

            out.println("<tr>");
            out.println("<th>");
            out.println("&nbsp;");
            out.println("</th>");
            out.println("<th>");
            out.println("Tipo");
            out.println("</th>");
            out.println("<th>");
            out.println("Descripción");
            out.println("</th>");
            out.println("<th>");
            out.println("Fecha Inicial");
            out.println("</th>");
            out.println("<th>");
            out.println("Fecha Final");
            out.println("</th>");
            out.println("<th>");
            out.println("Creada");
            out.println("</th>");
            out.println("</tr>");

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm");

            Iterator<Ausencia> ite = Ausencia.ClassMgr.listAusenciaByCreator(user, ws);
            while (ite.hasNext()) {

                Ausencia ausencia = ite.next();

                out.println("<tr>");
                out.println("<td>");
                SWBResourceURL urladel = paramsRequest.getActionUrl();
                urladel.setAction("delete");
                urladel.setParameter("uri", ausencia.getURI());
                out.println("<a href=\"#\" onclick=\"if(confirm('Estás seguro de eliminar esta Ausencia?')){window.location='"+urladel+"';return false;} else return false;\">eliminar</a>");
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
                out.println(null!=date?sdf.format(date):"sin fecha");
                out.println("</td>");
                out.println("<td>");
                date = ausencia.getFechaFin();
                out.println(null!=date?sdf.format(date):"sin fecha");
                out.println("</td>");
                out.println("<td>");
                date = ausencia.getCreated();
                out.println(null!=date?sdf.format(date):"sin fecha");
                out.println("</td>");
                out.println("</tr>");

            }
            out.println("</table>");
            out.println("<p>");
            SWBResourceURL urlb = paramsRequest.getRenderUrl();
            urlb.setAction("");
            out.println("<a href=\""+urlb+"\">regresar</a>");
            out.println("</p>");
            out.println("</fieldset>");
            out.println("</div>");
            }


        } else
            {
                out.println("<fieldset>");
                out.println("<legend>Para Registrar tu Ausencia, debes de estar registrado en el sitio.");
                out.println("</legend>");
                out.println("</fieldset>");
            }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebSite ws = response.getWebPage().getWebSite();
        if(null==action) action="";

        if("new".equals(action))
        {
            //System.out.println("Creando Ausencia...");

            try{
            SWBFormMgr mgr = new SWBFormMgr(Ausencia.info_Ausencia, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
            SemanticObject sonew = mgr.processForm(request);
                //System.out.println("sonew: "+sonew.getURI());
            }
            catch(Exception e)
            {
                log.error("Error al procesar la forma al agregar una Ausencia", e);
            }
        } else if("delete".equals(action))
        {
            String uri = request.getParameter("uri");
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject so = ont.getSemanticObject(uri);
            if(null!=so) so.remove();

            response.setAction("show");

        }

    }





}
