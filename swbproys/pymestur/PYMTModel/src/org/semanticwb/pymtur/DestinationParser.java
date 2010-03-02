/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author hasdai
 */
public class DestinationParser extends GenericParser {
    public final static String ATT_EVENT = "events";
    public final static String ATT_EXPERIENCE = "experience";
    public final static String ATT_ACTIVITY = "activity";
    public final static String ATT_TOURTYPE = "tourismType";

    @Override
    public String getType(Searchable gen) {
        return "Destination";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Destination)gen).getDescription();
    }

    @Override
    public String getUrl(Searchable gen) {
        return ((Destination)gen).getUrl();
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        WebPage page = (Destination)gen;
        ret = page.getPath(arg);

        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Destination)gen).getDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((Destination)gen).getTags();
    }    

    private WebPage getWebPage(Searchable gen) {
        return (WebPage)gen;
    }

    @Override
    public String getIndexCategory(Searchable gen)
    {
        String ret="";
        WebPage page=getWebPage(gen);
        if(page!=null)
        {
            ret=super.getIndexCategory(page);
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
        map.put(ATT_EVENT, new IndexTerm(ATT_EVENT, getDestinationExperiences(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_ACTIVITY, new IndexTerm(ATT_ACTIVITY, getDestinationActivities(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_TOURTYPE, new IndexTerm(ATT_TOURTYPE, getDestinationTourismTypes(gen), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }
}
