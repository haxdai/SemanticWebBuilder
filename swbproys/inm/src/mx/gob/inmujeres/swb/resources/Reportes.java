/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.inmujeres.swb.Desempenio;
import mx.gob.inmujeres.swb.MetaEvaluacion;
import mx.gob.inmujeres.swb.UserExtended;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
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
    public static final String MODE_REPORTE_EVAl_METAS_EXCEL = "evalmetasexcel";
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

    public void doEvalMetasExcel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"evalmetas.xls\"");
        Workbook wb = new HSSFWorkbook();
        WebSite site = paramRequest.getWebPage().getWebSite();
        try
        {
            int ianio = Calendar.getInstance().get(Calendar.YEAR) - 1;
            Iterator<Desempenio> evaluaciones = Desempenio.ClassMgr.listDesempenios(site);
            while (evaluaciones.hasNext())
            {
                Desempenio desempenio = evaluaciones.next();
                int irow = 0;
                if (desempenio.getAnio() == ianio)
                {
                    User evaluado = desempenio.getEvaluado();
                    User evaluador = desempenio.getEvaluador();
                    UserExtended ext = UserExtended.ClassMgr.getUserExtended(evaluado.getId(), evaluado.getUserRepository());
                    UserExtended extJefe = UserExtended.ClassMgr.getUserExtended(evaluador.getId(), evaluador.getUserRepository());
                    String sheetName = desempenio.getEvaluado().getFullName();
                    Sheet sheet = wb.createSheet(sheetName);
                    Row row = sheet.createRow(irow++);
                    Cell cell = row.createCell(0);
                    cell.setCellValue("EVALUACIÓN DE METAS " + ianio);
                    row = sheet.createRow(irow++);
                    row = sheet.createRow(irow++);
                    cell = row.createCell(0);
                    cell.setCellValue("Persona que Evalúa");

                    row = sheet.createRow(irow++);
                    cell = row.createCell(0);
                    cell.setCellValue(extJefe.getPuesto());
                    cell = row.createCell(1);
                    cell.setCellValue(desempenio.getEvaluador().getFullName());

                    row = sheet.createRow(irow++);
                    cell = row.createCell(0);
                    cell.setCellValue("EVALUADA(O)");


                    row = sheet.createRow(irow++);
                    cell = row.createCell(0);
                    cell.setCellValue(ext.getPuesto());
                    cell = row.createCell(1);
                    cell.setCellValue(desempenio.getEvaluado().getFullName());


                    row = sheet.createRow(irow++);
                    row = sheet.createRow(irow++);
                    cell = row.createCell(0);
                    cell.setCellValue("# META");

                    cell = row.createCell(1);
                    cell.setCellValue("Descripción de la Función, Objetivo y/o  Meta");

                    cell = row.createCell(2);
                    cell.setCellValue("Unidad de Medida de la Función, Objetivo y/o Meta");

                    cell = row.createCell(3);
                    cell.setCellValue("Peso de la Función, Objetivo y/o  Meta");

                    cell = row.createCell(4);
                    cell.setCellValue("Instrumento de Gestión del Rendimiento de Origen");

                    cell = row.createCell(5);
                    cell.setCellValue("Temas de Programa Estratégico");

                    cell = row.createCell(6);
                    cell.setCellValue("SOBRESALIENTE");

                    cell = row.createCell(7);
                    cell.setCellValue("SATISFACTORIO");

                    cell = row.createCell(8);
                    cell.setCellValue("ACEPTABLE");

                    cell = row.createCell(9);
                    cell.setCellValue("NO ACEPTABLE");

                    cell = row.createCell(10);
                    cell.setCellValue("GRADO DE CUMPLIMIENTO");

                    cell = row.createCell(11);
                    cell.setCellValue("JUSTIFICACIÓN SOBRE LO EVALUADO");

                    cell = row.createCell(12);
                    cell.setCellValue("SERVIDOR(A)");

                    cell = row.createCell(13);
                    cell.setCellValue("SUPERIOR INMEDIATO");

                    Iterator<MetaEvaluacion> metas = desempenio.listMetases();
                    int imeta = 0;
                    while (metas.hasNext())
                    {
                        imeta++;
                        MetaEvaluacion meta = metas.next();
                        int icell = 0;
                        row = sheet.createRow(irow++);
                        cell = row.createCell(icell++);
                        cell.setCellValue(imeta);
                        String descripcion = meta.getMeta();
                        cell = row.createCell(icell++);
                        cell.setCellValue(descripcion);

                        String medida = meta.getMedida().getDisplayTitle("es");
                        cell = row.createCell(icell++);
                        cell.setCellValue(medida);

                        String peso = meta.getPesoMeta();
                        cell = row.createCell(icell++);
                        cell.setCellValue(peso);

                        String instrumento = meta.getInstrumentog().getDisplayTitle("es");
                        cell = row.createCell(icell++);
                        cell.setCellValue(instrumento);

                        String temas = meta.getTemasPrograma().getDisplayTitle("es");
                        cell = row.createCell(icell++);
                        cell.setCellValue(temas);

                        String sobresaliente = meta.getPSobresaliente();
                        cell = row.createCell(icell++);
                        cell.setCellValue(sobresaliente);

                        String satisfactorio = meta.getPSatisfactorio();
                        cell = row.createCell(icell++);
                        cell.setCellValue(satisfactorio);

                        String aceptable = meta.getPMinimoaceptable();
                        cell = row.createCell(icell++);
                        cell.setCellValue(aceptable);

                        String noSatisfactorio = meta.getPNoSatisfactorio();
                        cell = row.createCell(icell++);
                        cell.setCellValue(noSatisfactorio);

                        int grado = meta.getEvaluacion();
                        switch (grado)
                        {
                            case 100:
                                cell = row.createCell(icell++);
                                cell.setCellValue("Sobresaliente");
                                break;
                            case 89:
                                cell = row.createCell(icell++);
                                cell.setCellValue("Satisfactorio");
                                break;
                            case 79:
                                cell = row.createCell(icell++);
                                cell.setCellValue("Aceptable");
                                break;
                            case 69:
                                cell = row.createCell(icell++);
                                cell.setCellValue("No aceptable");
                                break;
                            default:
                                cell = row.createCell(icell++);
                                cell.setCellValue("");
                        }
                        String comenatarios = meta.getComentarios();
                        if (comenatarios == null)
                        {
                            comenatarios = "";
                        }
                        cell = row.createCell(icell++);
                        cell.setCellValue(comenatarios);

                        cell = row.createCell(icell++);
                        cell.setCellValue("");

                        cell = row.createCell(icell++);
                        cell.setCellValue("");

                    }

                }
            }
        }
        catch (Exception e)
        {
            log.error(e);

        }
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
    }

    public void doMetasExcel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {




        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"metas.xls\"");
        Workbook wb = new HSSFWorkbook();
        Sheet s = wb.createSheet();
        int irow = 0;
        Row row = s.createRow(irow++);
        Cell cell = row.createCell(0);
        cell.setCellValue("NÚMERO DE EMPLEADA(O)");

        cell = row.createCell(1);
        cell.setCellValue("APELLIDO PATERNO");

        cell = row.createCell(2);
        cell.setCellValue("APELLIDO MATERNO");

        cell = row.createCell(3);
        cell.setCellValue("NOMBRE(S)");

        cell = row.createCell(4);
        cell.setCellValue("R. F. C.");

        cell = row.createCell(5);
        cell.setCellValue("PUESTO");

        cell = row.createCell(6);
        cell.setCellValue("No. EMPLEADO DEL JEFE SUPERIOR INMEDIATO");

        cell = row.createCell(7);
        cell.setCellValue("SECTOR CENTRAL");

        cell = row.createCell(8);
        cell.setCellValue("CENTRO DE COSTO");

        cell = row.createCell(9);
        cell.setCellValue("# META");

        cell = row.createCell(10);
        cell.setCellValue("Descripción de la Función, Objetivo y/o  Meta");

        cell = row.createCell(11);
        cell.setCellValue("Unidad de Medida de la Función, Objetivo y/o Meta");

        cell = row.createCell(12);
        cell.setCellValue("Peso de la Función, Objetivo y/o  Meta");

        cell = row.createCell(13);
        cell.setCellValue("Instrumento de Gestión del Rendimiento de Origen");

        cell = row.createCell(14);
        cell.setCellValue("Temas de Programa Estratégico");

        cell = row.createCell(15);
        cell.setCellValue("SOBRESALIENTE");


        cell = row.createCell(16);
        cell.setCellValue("SATISFACTORIO");

        cell = row.createCell(17);
        cell.setCellValue("ACEPTABLE");

        cell = row.createCell(18);
        cell.setCellValue("NO ACEPTABLE");

        cell = row.createCell(19);
        cell.setCellValue("SERVIDOR(A)");

        cell = row.createCell(20);
        cell.setCellValue("SUPERIOR INMEDIATO");


        WebSite site = paramRequest.getWebPage().getWebSite();
        try
        {
            int ianio = Calendar.getInstance().get(Calendar.YEAR);

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

                        int imeta = 1;
                        while (metas.hasNext())
                        {
                            row = s.createRow(irow++);
                            int icell = 0;
                            MetaEvaluacion meta = metas.next();
                            cell = row.createCell(icell++);
                            cell.setCellValue(noEmpleado);
                            cell = row.createCell(icell++);
                            cell.setCellValue(aPaterno);
                            cell = row.createCell(icell++);
                            cell.setCellValue(pMaterno);
                            cell = row.createCell(icell++);
                            cell.setCellValue(nombre);
                            cell = row.createCell(icell++);
                            cell.setCellValue(rfc);
                            cell = row.createCell(icell++);
                            cell.setCellValue(puesto);
                            cell = row.createCell(icell++);
                            cell.setCellValue(sector);
                            cell = row.createCell(icell++);
                            cell.setCellValue(noEmpleadoJefe);
                            cell = row.createCell(icell++);
                            cell.setCellValue(cc);

                            cell = row.createCell(icell++);
                            cell.setCellValue(imeta);

                            String objetivo = meta.getMeta();
                            cell = row.createCell(icell++);
                            cell.setCellValue(objetivo);
                            String medida = meta.getMedida().getDisplayTitle("es");
                            cell = row.createCell(icell++);
                            cell.setCellValue(medida);

                            String peso = meta.getPesoMeta();
                            cell = row.createCell(icell++);
                            cell.setCellValue(peso);
                            String instrumento = meta.getInstrumentog().getDisplayTitle("es");
                            cell = row.createCell(icell++);
                            cell.setCellValue(instrumento);
                            String temas = meta.getTemasPrograma().getDisplayTitle("es");
                            cell = row.createCell(icell++);
                            cell.setCellValue(temas);
                            String sobresaliente = meta.getPSobresaliente();
                            cell = row.createCell(icell++);
                            cell.setCellValue(sobresaliente);
                            String satisfactorio = meta.getPSatisfactorio();
                            cell = row.createCell(icell++);
                            cell.setCellValue(satisfactorio);
                            String minimoaceptable = meta.getPMinimoaceptable();
                            cell = row.createCell(icell++);
                            cell.setCellValue(minimoaceptable);
                            String noSatisfactorio = meta.getPNoSatisfactorio();
                            cell = row.createCell(icell++);
                            cell.setCellValue(noSatisfactorio);
                            cell = row.createCell(icell++);
                            cell.setCellValue("");
                            cell = row.createCell(icell++);
                            cell.setCellValue("");
                            imeta++;
                        }
                    }
                }

            }
            OutputStream out = response.getOutputStream();
            wb.write(out);
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
            doMetasExcel(request, response, paramRequest);
            return;
        }
        if (MODE_REPORTE_EVAl_METAS_EXCEL.equals(paramRequest.getMode()))
        {
            doEvalMetasExcel(request, response, paramRequest);
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

    public static void main(String args[])
    {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet s = wb.createSheet("demo");
        try
        {
            int irow = 0;
            Row row = s.createRow(irow++);

            Cell cell = row.createCell(1);
            CellStyle style=wb.createCellStyle();
            style.setFillForegroundColor((short)Color.CYAN.getRGB());
            
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell = row.createCell(3);

            int region=s.addMergedRegion(new CellRangeAddress(1, 1, 1, 9));
            


            row = s.createRow(irow++);
            
            cell = row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue("NÚMERO DE EMPLEADA(O)");

            cell = row.createCell(2);
            cell.setCellValue("APELLIDO PATERNO");

            cell = row.createCell(3);
            cell.setCellValue("APELLIDO MATERNO");

            cell = row.createCell(4);
            cell.setCellValue("NOMBRE(S)");

            cell = row.createCell(5);
            cell.setCellValue("R. F. C.");

            cell = row.createCell(6);
            cell.setCellValue("PUESTO");

            cell = row.createCell(7);
            cell.setCellValue("No. EMPLEADO DEL JEFE SUPERIOR INMEDIATO");

            cell = row.createCell(8);
            cell.setCellValue("SECTOR CENTRAL");

            cell = row.createCell(9);
            cell.setCellValue("CENTRO DE COSTO");

            cell = row.createCell(10);
            cell.setCellValue("# META");

            cell = row.createCell(11);
            cell.setCellValue("Descripción de la Función, Objetivo y/o  Meta");

            cell = row.createCell(12);
            cell.setCellValue("Unidad de Medida de la Función, Objetivo y/o Meta");

            cell = row.createCell(13);
            cell.setCellValue("Peso de la Función, Objetivo y/o  Meta");

            cell = row.createCell(14);
            cell.setCellValue("Instrumento de Gestión del Rendimiento de Origen");

            cell = row.createCell(15);
            cell.setCellValue("Temas de Programa Estratégico");

            cell = row.createCell(16);
            cell.setCellValue("SOBRESALIENTE");


            cell = row.createCell(17);
            cell.setCellValue("SATISFACTORIO");

            cell = row.createCell(18);
            cell.setCellValue("ACEPTABLE");

            cell = row.createCell(19);
            cell.setCellValue("NO ACEPTABLE");

            cell = row.createCell(20);
            cell.setCellValue("SERVIDOR(A)");

            cell = row.createCell(21);

            cell.setCellValue("SUPERIOR INMEDIATO");
            FileOutputStream out = new FileOutputStream("c:\\demo.xls");
            wb.write(out);
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
