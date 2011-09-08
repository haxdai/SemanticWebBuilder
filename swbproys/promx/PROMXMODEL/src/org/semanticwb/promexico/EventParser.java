/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico;

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
    public final static String ATT_OFFICE = "office";
    public final static String ATT_SECTOR = "sector";


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
        return ((Event) gen).getProSearchDescription(lang);
    }

    @Override
    public String getUrl(Searchable gen) {
        String ret = "#";
        Event event = (Event)gen;
        WebPage wpFicha = event.getProMexico().getWebPage("showEvents");
        if(wpFicha!=null){
            ret=wpFicha.getUrl()+"?id="+event.getId()+"&show=event";
        }
        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Event) gen).getProSearchDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((Event) gen).getTags();
    }

    @Override
    public String getImage(Searchable gen) {
        Event event = (Event)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/gen_event.png";
        if(event.getEventPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + event.getWorkPath() + "/" + event.promx_eventPhoto.getName() + "_" + event.getId()+"_"+event.getEventPhoto();
        }
        return ret;
    }


    public String getEventOffices(Searchable gen) {
        String ret = "";
        Event event = (Event)gen;
        Iterator<Office> it_exp = event.listOffices();
        while (it_exp.hasNext()) {
            Office exp = it_exp.next();
            ret += " " + exp.getTitle();
        }
        return ret.trim();
    }

    public String getEventSectores(Searchable gen) {
        String ret = "";
        Event event = (Event)gen;
        Iterator<Sector> it_act = event.listSectoreses();
        while (it_act.hasNext()) {
            Sector act = it_act.next();
            ret += " " + act.getTitle();
        }
        return ret.trim();
    }

   
    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Map map = super.getIndexTerms(gen);
        map.put(ATT_OFFICE, new IndexTerm(ATT_OFFICE, getEventOffices(gen), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_SECTOR, new IndexTerm(ATT_SECTOR, getEventSectores(gen), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }

}
