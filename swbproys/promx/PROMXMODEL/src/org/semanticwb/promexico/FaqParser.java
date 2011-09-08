/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico;

import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author jorge.jimenez
 */
public class FaqParser extends GenericParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Pregunta Frecuente";
    }

    @Override
    public String getType(Searchable gen) {
        return "Faq";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Faq) gen).getProSearchDescription(lang);
    }


    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Faq) gen).getProSearchDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((Faq) gen).getTags();
    }

    @Override
    public String getUrl(Searchable gen) {
        String ret = "#";
        Faq faq = (Faq)gen;
        WebPage wpFaq = faq.getProMexico().getWebPage("Faq");
        if(wpFaq!=null){
            ret=wpFaq.getUrl()+"?id="+faq.getId();
        }
        return ret;
    }

}
