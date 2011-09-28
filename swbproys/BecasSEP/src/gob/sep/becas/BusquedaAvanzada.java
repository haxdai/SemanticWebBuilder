/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.sep.becas;

import com.hp.hpl.jena.query.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author adriana.rodriguez
 */
public class BusquedaAvanzada extends GenericResource {

    static Logger log = SWBUtils.getLogger(BusquedaAvanzada.class);

    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        SWBResourceURL searchUrl = paramRequest.getRenderUrl().setMode("search");
        response.setContentType("text/html");
        Iterator<Institucion> insts = Institucion.ClassMgr.listInstitucions(paramRequest.getWebPage().getWebSite());
        Iterator<NivelEstudio> nivelEst = NivelEstudio.ClassMgr.listNivelEstudios(paramRequest.getWebPage().getWebSite());
        Iterator<Genero> genero = Genero.ClassMgr.listGeneros(paramRequest.getWebPage().getWebSite());

        PrintWriter out = response.getWriter();
        StringBuilder busquedaAva = new StringBuilder();
        busquedaAva.append("<form method=\"post\" action=\"" + searchUrl + "\" class=\"avanzada\"><p><label for=\"institucion\">Institución:</label>").append("<select name=\"institucion\" size=\"1\" class=\"inputPop\" id=\"institucion\"/>").append("<option value=\"0\"></option>");
        while (insts.hasNext()) {
            Institucion inst = insts.next();
            //System.out.println("ID:" + inst.getId() + " Titulo:" + inst.getTitle());
            busquedaAva.append("<option value=\"").append(inst.getId()).append("\" >").append(inst.getTitle()).append("</option>");
        }
        busquedaAva.append("</select>").append("</p><p><label for=\"nivelEst\">Nivel de Estudios:</label>").append("<select name=\"nivelEst\" size=\"1\" id=\"nivelEst\" \">").append("<option value=\"0\"></option>");

        //HashMap<String, String> nivelEs = new HashMap<String, String>();
        while (nivelEst.hasNext()) {
            NivelEstudio nEst = nivelEst.next();
            //nivelEs.put(nEst.getId(), nEst.getTitle());
            //System.out.println("ID:" + nEst.getId() + " Titulo:" + nEst.getTitle());
            busquedaAva.append("<option value=\"").append(nEst.getId()).append("\" >").append(nEst.getTitle()).append("</option>");
        }
        busquedaAva.append("</select>").append("</p><p><label for=\"genero\">Genero:</label>").append("<select name=\"genero\" size=\"1\" class=\"inputPop\" id=\"genero\" \">").append("<option value=\"0\"></option>");

        // HashMap<String, String> gener = new HashMap<String, String>();
        while (genero.hasNext()) {
            Genero gen = genero.next();
            busquedaAva.append("<option value=\"").append(gen.getId()).append("\" >").append(gen.getTitle()).append("</option>");
            //System.out.println("ID:" + gen.getId() + " Titulo:" + gen.getTitle());
            //gener.put(gen.getId(), gen.getTitle());
        }
        busquedaAva.append("</select><p><button type=\"submit\">Buscar</button></p></form>");
        out.print(busquedaAva);
    }

    public void doSearch(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        PrintWriter out = response.getWriter();
        //Parametros
        String institucion = request.getParameter("institucion");
        String nEstudios = request.getParameter("nivelEst");
        String generc = request.getParameter("genero");
        //Clases
        Institucion insti = Institucion.ClassMgr.getInstitucion(institucion, paramRequest.getWebPage().getWebSite());
        NivelEstudio nivelEsts = NivelEstudio.ClassMgr.getNivelEstudio(nEstudios, paramRequest.getWebPage().getWebSite());
        Genero gener = Genero.ClassMgr.getGenero(generc, paramRequest.getWebPage().getWebSite());


//        System.out.println("Institucion " + institucion + " Nivel educativo " + nEstudios + " Genero " + generc);
        StringBuilder resultadoBusqueda = new StringBuilder();
        resultadoBusqueda.append("<div class=\"busquedaAvan\">");
        /*
         * Declaración de prefix
         */
        String prolog = "PREFIX swb: <http://www.semanticwebbuilder.org/swb4/ontology#>\n";
        prolog += "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n";
        prolog += "PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n";
        prolog += "PREFIX becas: <http://www.semanticwebbuilder.org/swb4/sep/becas.owl#>\n";

        String queryString = prolog + " SELECT ?x WHERE {"
                + "?x rdf:type swb:WebPage."
                + "?x swb:hasResource ?y."
                + "?y rdf:type swb:Resource."
                + "?y swb:resourceData ?z."
                + "?z rdf:type becas:BecasContent.";

        if (insti != null) {
            queryString += "?z becas:bcInstitucion <" + insti.getURI() + ">.";
        }
        if (nivelEsts != null) {
            queryString += "?z becas:bcNivelEstudios <" + nivelEsts.getURI() + ">.";
        }
        if (gener != null) {
//            System.out.println("\n\n\nElección del genero:" + gener.getId() + "\n\n\n");
            if (gener.getId().equals("1") || gener.getId().equals("2")) {
                queryString += "{?z becas:bcGenero <" + gener.getURI() + ">}"
                        + " UNION "
                        + "{?z becas:bcGenero <http://www.Beca_SEP.swb#becas_Genero:3>}";
                /*{?z becas:bcGenero
                <http://www.Beca_SEP.swb#becas_Genero:2>}
                UNION
                {?z becas:bcGenero
                <http://www.Beca_SEP.swb#becas_Genero:3>}*/
            } else {
                queryString += "?z becas:bcGenero <" + gener.getURI() + ">";
            }
        }
        queryString += "}";
        Query query = QueryFactory.create(queryString);
//        System.out.println("\n  Query: "+queryString+"\n\n");
        QueryExecution qexec = QueryExecutionFactory.create(query, paramRequest.getWebPage().getSemanticObject().getModel().getRDFModel());
        resultadoBusqueda.append("<ul>");
        try {
            ResultSet rs = qexec.execSelect();
            if (!rs.hasNext()) {
                resultadoBusqueda.append("<li> No se obtuvieron resultados</li>");
            }
            while (rs.hasNext()) {
                QuerySolution rb = rs.nextSolution();
                String current = rb.get("x").toString();//WebPage
                WebPage wp = (WebPage) paramRequest.getWebPage().getWebSite().getSemanticModel().getGenericObject(current);
                resultadoBusqueda.append("<li>").append("<a href=\"").append(wp.getRealUrl()).append("\">").append(wp.getTitle()).append("</a>").append("</li>");
//                System.out.println("Titulo de la consulta " + wp.getTitle() + " URL:" + wp.getRealUrl());
                wp.getRealUrl();//Url más completo
            }
            resultadoBusqueda.append("</ul>");
        } catch (Exception e) {
            log.error("do Search", e);
        } finally {
            qexec.close();
        }
        resultadoBusqueda.append("</div>");
        out.println(resultadoBusqueda);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest) throws
            SWBResourceException, IOException {
        if (paramRequest.getMode().equals("search")) {
            doSearch(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
}
