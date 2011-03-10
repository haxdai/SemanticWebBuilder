/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm;

import java.util.Iterator;
import java.util.Map;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author jorge.jimenez
 */
public class EventParser extends GenericParser {
    public final static String ATT_LOCALITY = "locality";
    public final static String ATT_STATE = "state";
    public final static String ATT_EXPERIENCE = "experience";
    public final static String ATT_ACTIVITY = "activity";



    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Evento";
    }

    @Override
    public String getType(Searchable gen) {
        return "Event";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Event) gen).getDescription();
    }

    @Override
    public String getUrl(Searchable gen) {
        String ret = "#";
        Event event = (Event)gen;
        WebPage wpFicha = event.getCPTMWebSite().getWebPage("Mostrar_Evento");
        if(wpFicha!=null){
            ret=wpFicha.getUrl()+"?id="+event.getId()+"&show=event";
        }
        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Event) gen).getDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((Event) gen).getTags();
    }

    @Override
    public String getImage(Searchable gen) {
        Event event = (Event)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_event.png";
        if(event.getPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + event.getWorkPath() + "/" + event.cptm_photo.getName() + "_" + event.getId()+"_"+event.getPhoto();
        }
        return ret;
    }

   
    public String getEventExperiences(Searchable gen) {
        String ret = "";
         Event event = (Event)gen;
        Iterator<Experience> it_exp = event.listEventExperiences();
        while (it_exp.hasNext()) {
            Experience exp = it_exp.next();
            ret += " " + exp.getTitle();
        }
        return ret.trim();
    }

    public String getEventActivities(Searchable gen) {
        String ret = "";
        Event event = (Event)gen;
        Iterator<Activity> it_act = event.listEventActivityRefs();
        while (it_act.hasNext()) {
            Activity act = it_act.next();
            ret += " " + act.getTitle();
        }
        return ret.trim();
    }

    public String getEventLocalities(Searchable gen) {
        String ret = "";
        Event event = (Event)gen;
        Iterator<LocalityInt> it_ev = event.listEventLocalities();
        while (it_ev.hasNext()) {
            LocalityInt locality = it_ev.next();
            ret += " " + locality.getId();
        }
        return ret.trim();
    }

    public String getEventStates(Searchable gen) {
        String ret = "";
        Event event = (Event)gen;
        Iterator<State> it_ev = event.listEventStates();
        while (it_ev.hasNext()) {
            State state = it_ev.next();
            ret += " " + state.getTitle();
        }
        return ret.trim();
    }


    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Map map = super.getIndexTerms(gen);
        map.put(ATT_EXPERIENCE, new IndexTerm(ATT_EXPERIENCE, getEventExperiences(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_ACTIVITY, new IndexTerm(ATT_ACTIVITY, getEventActivities(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_LOCALITY, new IndexTerm(ATT_LOCALITY, getEventLocalities(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_STATE, new IndexTerm(ATT_STATE, getEventStates(gen), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }

}
