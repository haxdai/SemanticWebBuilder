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

package org.semanticwb.pymtur;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 * Parser para el indexado de destinos en el proyecto de PyMEs.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class DestinationParser extends GenericParser {
    public final static String ATT_EVENT = "event";
    public final static String ATT_EXPERIENCE = "experience";
    public final static String ATT_ACTIVITY = "activity";
    public final static String ATT_TOURTYPE = "tourismType";

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Destino";
    }

    @Override
    public String getType(Searchable gen) {
        return "Destination";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Destination) gen).getDescription();
    }

    @Override
    public String getUrl(Searchable gen) {
        return ((Destination) gen).getUrl();
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        WebPage page = (Destination) gen;
        ret = page.getPath(arg);

        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Destination) gen).getDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((Destination) gen).getTags();
    }    

    @Override
    public String getImage(Searchable gen) {
        String ret = super.getImage(gen);
        Destination dest = (Destination) gen;
        if (dest.getDestPrincipalPhoto() != null) {
            ret = SWBPortal.getWebWorkPath() + dest.getWorkPath() + "/" + dest.pymtur_destPrincipalPhoto.getName() + "_" + dest.getDestPrincipalPhoto();
        }
        return ret;
    }

    private WebPage getWebPage(Searchable gen) {
        return (WebPage)gen;
    }

    @Override
    public String getIndexCategory(Searchable gen)
    {
        String ret = "";
        WebPage page = getWebPage(gen);
        if(page != null)
        {
            ret = super.getIndexCategory(page);
        }
        return ret;
    }

    public String getDestinationExperiences(Searchable gen) {
        String ret = "";
        Destination dest = (Destination)gen;
        Iterator<Experience> it_exp = dest.listDestinationExperiences();
        while (it_exp.hasNext()) {
            Experience exp = it_exp.next();
            ret += " " + exp.getTitle();
        }
        return ret.trim();
    }

    public String getDestinationEvents(Searchable gen) {
        String ret = "";
        Destination dest = (Destination)gen;
        Iterator<Event> it_ev = dest.listEvents();
        while (it_ev.hasNext()) {
            Event evt = it_ev.next();
            ret += " " + evt.getTitle();
        }
        return ret.trim();
    }

    public String getDestinationActivities(Searchable gen) {
        String ret = "";
        Destination dest = (Destination)gen;
        Iterator<Activity> it_act = dest.listDestinationActivities();
        while (it_act.hasNext()) {
            Activity act = it_act.next();
            ret += " " + act.getTitle();
        }
        return ret.trim();
    }

    public String getDestinationTourismTypes(Searchable gen) {
        String ret = "";
        Destination dest = (Destination)gen;
        Iterator<TourismType> it_tt = dest.listTourismTypes();
        while (it_tt.hasNext()) {
            TourismType tt = it_tt.next();
            ret += " " + tt.getTitle();
        }
        return ret.trim();
    }

    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Map map = super.getIndexTerms(gen);
        map.put(ATT_EXPERIENCE, new IndexTerm(ATT_EXPERIENCE, getDestinationExperiences(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_EVENT, new IndexTerm(ATT_EVENT, getDestinationEvents(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_ACTIVITY, new IndexTerm(ATT_ACTIVITY, getDestinationActivities(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_TOURTYPE, new IndexTerm(ATT_TOURTYPE, getDestinationTourismTypes(gen), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }
}