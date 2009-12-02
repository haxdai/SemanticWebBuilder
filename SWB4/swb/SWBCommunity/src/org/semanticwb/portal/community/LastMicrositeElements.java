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
package org.semanticwb.portal.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class LastMicrositeElements extends GenericAdmResource
{

    private static Logger log = SWBUtils.getLogger(LastMicrositeElements.class);
    private static final String NL = "\r\n";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
       // long lastTime = System.currentTimeMillis();
        int limit = 3;
        String slimit = this.getResourceBase().getAttribute("limit", "3");
        try
        {
            limit = Integer.parseInt(slimit);
        }
        catch (NumberFormatException nfe)
        {
            log.error(nfe);

        }
        ArrayList<MicroSiteElement> elements = new ArrayList<MicroSiteElement>();
        /*StringBuilder prefixStatement = new StringBuilder();
        prefixStatement.append(" PREFIX swb: <http://www.semanticwebbuilder.org/swb4/ontology#>" + NL);
        prefixStatement.append(" PREFIX swbcomm: <http://www.semanticwebbuilder.org/swb4/community#>" + NL);
        prefixStatement.append(" PREFIX rdf: <" + SemanticVocabulary.RDF_URI + "> " + NL);
        prefixStatement.append(" PREFIX rdfs: <" + SemanticVocabulary.RDFS_URI + "> " + NL);
        //prefixStatement.append("SELECT ?x ?date WHERE {?x swb:created ?date . ?x rdf:type swbcomm:MicroSiteElement} ORDER BY DESC(?date) LIMIT " + limit);
        //prefixStatement.append("SELECT DISTINCT ?x ?date WHERE { ?x a swbcomm:MicroSiteElement . ?x swb:created ?date . FILTER(!regex(str(?x),\"^" + NewsElement.sclass.getURI() + "\")) } ORDER BY DESC(?date) LIMIT " + limit);
        prefixStatement.append("SELECT DISTINCT ?x ?date WHERE { ?x a swbcomm:MicroSiteElement . ?x swb:created ?date } ORDER BY DESC(?date) LIMIT " + limit);
        QueryExecution qe = paramRequest.getWebPage().getSemanticObject().getModel().sparQLOntologyQuery(prefixStatement.toString());
        ResultSet rs = qe.execSelect();
        while (rs.hasNext())
        {
            QuerySolution rb = rs.nextSolution();
            if (rb.get("?x") != null && rb.get("?x").isResource())
            {
                Resource res = rb.getResource("?x");
                SemanticObject obj = SemanticObject.createSemanticObject(res.getURI());
                MicroSiteElement element = (MicroSiteElement) obj.createGenericInstance();
                elements.add(element);
            }
        }*/
        WebSite site=paramRequest.getWebPage().getWebSite();
        Iterator<SemanticObject> oelements=site.getSemanticObject().getModel().listInstancesOfClass(MicroSiteElement.sclass, true);
//        System.out.println("Iterador Inicial:"+(System.currentTimeMillis()-lastTime));
//        lastTime = System.currentTimeMillis();
        TreeSet<SemanticObject> setVals=new TreeSet<SemanticObject>(new Comparator() {

            public int compare(Object arg0, Object arg1)
            {
                SemanticObject obj0 = (SemanticObject) arg0;
                SemanticObject obj1 = (SemanticObject) arg1;
                return obj1.getProperty(org.semanticwb.model.comm.MicroSite.swb_created).compareTo(obj0.getProperty(org.semanticwb.model.comm.MicroSite.swb_created));
            }
        });
        while (oelements.hasNext()){
            setVals.add(oelements.next());
        }
        Iterator<SemanticObject> itElements = setVals.iterator();
        int i = 0;
        elements = new ArrayList<MicroSiteElement>();
        while(itElements.hasNext())
        {
            MicroSiteElement element=(MicroSiteElement)itElements.next().createGenericInstance();;
            elements.add(element);
            i++;
            if(i==limit)
            {
                break;
            }
        }

/*        while(oelements.hasNext())
        {
            SemanticObject obj=oelements.next();
            MicroSiteElement element=(MicroSiteElement) obj.createGenericInstance();
            elements.add(element);
        }
        System.out.println("Instancias Genericas:"+(System.currentTimeMillis()-lastTime));
        lastTime = System.currentTimeMillis();
        Iterator itElements=SWBComparator.sortByCreated(elements.iterator(), false);
        System.out.println("Sorting:"+(System.currentTimeMillis()-lastTime));
        lastTime = System.currentTimeMillis();
        elements = new ArrayList<MicroSiteElement>();
        int i=0;
        while(itElements.hasNext())
        {
            MicroSiteElement element=(MicroSiteElement)itElements.next();
            elements.add(element);
            i++;
            if(i==limit)
            {
                break;
            }
        }
*/
//        System.out.println("tengo lista:"+(System.currentTimeMillis()-lastTime));
//        lastTime = System.currentTimeMillis();
        String path = "/swbadmin/jsp/microsite/LastMicrositeElements/LastMicrositeElementsView.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("elements", elements);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
//        System.out.println("procece vista:"+(System.currentTimeMillis()-lastTime));
//        lastTime = System.currentTimeMillis();


    }
}
