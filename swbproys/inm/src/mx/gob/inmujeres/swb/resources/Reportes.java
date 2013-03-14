/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.inmujeres.swb.Desempenio;
import mx.gob.inmujeres.swb.MetaEvaluacion;
import mx.gob.inmujeres.swb.UserExtended;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class Reportes extends GenericResource
{

    public static final String MODE_REPORTE_RETRO = "retro";
    public static final String MODE_REPORTE_METAS = "metas";
    public static final String MODE_REPORTE_DNC = "dnc";
    public static final String MODE_REPORTE_CUESTIONARIO = "cuestionario";
    public static final String MODE_REPORTE_STATUS = "status";
    public static final String MODE_REPORTE_FILTRO = "filtro";
    public static final String MODE_REPORTE_MENU = "menu";
    public static final String MODE_LIST_SUBORDINADOS = "subordinados";
    public static final String MODE_REPORTE_DNC_GENERAL = "dncgeneral";
    public static final String MODE_REPORTE_EVAL_METAS_ANT = "metasant";
    public static final String MODE_REPORTE_METAS_EXCEL = "metasexcel";
    static Logger log = SWBUtils.getLogger(Survey.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html");
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String mode = MODE_REPORTE_MENU;
        if (paramRequest.getMode() != null)
        {
            mode = paramRequest.getMode();
        }
        String jsp = "/work/models/" + siteId + "/jsp/" + Reportes.class.getSimpleName() + "/" + mode + ".jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        request.setAttribute("paramRequest", paramRequest);

        try
        {
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public void listSubordinados(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        String iduser = request.getParameter("user");
        out.println("<p>Evaluado:</p><select name=\"evaluado\">");
        if (iduser != null)
        {

            WebSite site = paramRequest.getWebPage().getWebSite();
            User user = site.getUserRepository().getUser(iduser);
            UserExtended ext = UserExtended.ClassMgr.getUserExtended(user.getId(), user.getUserRepository());
            Iterator<User> subordinados = ext.listSubordinados();


            while (subordinados.hasNext())
            {
                User subordinado = subordinados.next();
                out.println("<option value=\"" + subordinado.getId() + "\">" + subordinado.getFullName() + "</option>");
            }

        }
        out.println("</select>");
        //out.close();
    }

    public void doExcel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        String sanio = request.getParameter("anio");
        String siteId = paramRequest.getWebPage().getWebSiteId();
        if (sanio == null)
        {
            String jsp = "/work/models/" + siteId + "/jsp/" + Reportes.class.getSimpleName() + "/filtro.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            request.setAttribute("paramRequest", paramRequest);

            try
            {
                rd.include(request, response);
                return;
            }
            catch (Exception e)
            {
                log.error(e);
                return;
            }
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"metas.csv\"");

        WebSite site = paramRequest.getWebPage().getWebSite();
        try
        {
            int ianio = Integer.parseInt(sanio);
            List<List<String>> renglones = new ArrayList<List<String>>();
            Iterator<Desempenio> evaluaciones = Desempenio.ClassMgr.listDesempenios(site);
            while (evaluaciones.hasNext())
            {
                Desempenio desempenio = evaluaciones.next();
                if (desempenio.getAnio() == ianio)
                {
                    User evaluado = desempenio.getEvaluado();
                    User evaluador = desempenio.getEvaluador();
                    UserExtended ext = UserExtended.ClassMgr.getUserExtended(evaluado.getId(), evaluado.getUserRepository());
                    UserExtended extJefe = UserExtended.ClassMgr.getUserExtended(evaluador.getId(), evaluador.getUserRepository());

                    if (ext != null)
                    {
                        String aPaterno = evaluado.getLastName();
                        String pMaterno = evaluado.getSecondLastName();
                        String nombre = evaluado.getName();
                        String noEmpleado = ext.getNoEmpleado();
                        String puesto = ext.getPuesto();
                        String rfc = ext.getRfc();
                        String sector = "06  SHCP";
                        String noEmpleadoJefe = extJefe.getNoEmpleado();
                        String cc = ext.getCc();
                        if ("1".equals(cc))
                        {
                            cc = "PRESIDENCIA";
                        }
                        if ("2".equals(cc))
                        {
                            cc = "INSTITUCIONALIZACIÓN";
                        }
                        if ("3".equals(cc))
                        {
                            cc = "TRANSVERSALIZACIÓN";
                        }
                        if ("4".equals(cc))
                        {
                            cc = "EVALUACIÓN Y D. ESTADISTICO";
                        }
                        if ("5".equals(cc))
                        {
                            cc = "ADMINISTRACIÓN Y FINANZAS";
                        }
                        if ("6".equals(cc))
                        {
                            cc = "ASUNTOS INTERNACIONALES";
                        }
                        if ("7".equals(cc))
                        {
                            cc = "COMUNICACIÓN SOCIAL Y CAMBIO CULTURAL";
                        }
                        if ("8".equals(cc))
                        {
                            cc = "CONTRALORÍA";
                        }
                        if ("9".equals(cc))
                        {
                            cc = "JUNTA DE GOBIERNO";
                        }
                        Iterator<MetaEvaluacion> metas = desempenio.listMetases();
                        List<String> datos = new ArrayList<String>();
                        renglones.add(datos);
                        int imeta = 1;
                        while (metas.hasNext())
                        {
                            MetaEvaluacion meta = metas.next();
                            datos.add(aPaterno);
                            datos.add(pMaterno);
                            datos.add(nombre);
                            datos.add(noEmpleado);
                            datos.add(puesto);
                            datos.add(rfc);
                            datos.add(sector);
                            datos.add(noEmpleadoJefe);
                            datos.add(cc);
                            String objetivo = meta.getDescription();
                            datos.add(objetivo);
                            String medida = meta.getMedida().getTitle("es");
                            datos.add(medida);
                            String peso = meta.getPesoMeta();
                            datos.add(peso);
                            String instrumento = meta.getInstrumentog().getTitle("es");
                            datos.add(instrumento);
                            String temas = meta.getTemasPrograma().getTitle("es");
                            datos.add(temas);
                            String sobresaliente = meta.getPSobresaliente();
                            datos.add(sobresaliente);
                            String satisfactorio = meta.getPSatisfactorio();
                            datos.add(satisfactorio);
                            String minimoaceptable = meta.getPMinimoaceptable();
                            datos.add(minimoaceptable);
                            String noSatisfactorio = meta.getPNoSatisfactorio();
                            datos.add(noSatisfactorio);
                            imeta++;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (List<String> renglon : renglones)
            {
                for (String dato : renglon)
                {
                    sb.append(dato.replace(',', ' '));
                    sb.append(",");
                }
                sb.append("\r\n");
            }
            ServletOutputStream out = response.getOutputStream();
            out.write(sb.toString().getBytes());
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            log.error(e);
        }

    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (MODE_LIST_SUBORDINADOS.equals(paramRequest.getMode()))
        {
            listSubordinados(request, response, paramRequest);
            return;
        }
        if (MODE_REPORTE_METAS_EXCEL.equals(paramRequest.getMode()))
        {
            doExcel(request, response, paramRequest);
            return;
        }
        else if (MODE_REPORTE_EVAL_METAS_ANT.equals(paramRequest.getMode()) || MODE_REPORTE_DNC_GENERAL.equals(paramRequest.getMode()) || MODE_REPORTE_STATUS.equals(paramRequest.getMode()) || MODE_REPORTE_RETRO.equals(paramRequest.getMode()) || MODE_REPORTE_METAS.equals(paramRequest.getMode()) || MODE_REPORTE_MENU.equals(paramRequest.getMode()) || MODE_REPORTE_FILTRO.equals(paramRequest.getMode()) || MODE_REPORTE_DNC.equals(paramRequest.getMode()) || MODE_REPORTE_CUESTIONARIO.equals(paramRequest.getMode()))
        {
            doView(request, response, paramRequest);
            return;
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }

    }
}
