/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal.resources.sem.pressroom;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class ContentParser extends GenericParser {

    @Override
    public String getType(Searchable gen) {
        return "NewsResource";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Content)gen).getDescription();
    }

    @Override
    public String getUrl(Searchable gen) {
        Content c = (Content)gen;
        //c.setWebPage(response.getWebPage().getWebSite().getWebPage("Sintesis_Informativa"));
        return c.getWebPage().getUrl().toString() + "?uri=" + c.getEncodedURI() + "&cat=" + c.getCategory().getEncodedURI();
        //return "/es/SEGOB/Sintesis_Informativa" + "?uri=" + c.getEncodedURI() + "&cat=" + c.getCategory().getEncodedURI();
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        WebPage page=((Content)gen).getWebPage();
        ret=page.getPath(arg);

        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Content)gen).getDescription();
    }

    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Map map = super.getIndexTerms(gen);
        try {
            map.put(SWBIndexer.ATT_DATA, new IndexTerm(SWBIndexer.ATT_DATA, getIndexContent(gen), false, IndexTerm.INDEXED_ANALYZED));
        } catch (Exception e) {
        }       //Error de parseo no se registra
        return map;
    }

    public String getIndexContent(Searchable gen) {
        return ((Content)gen).getContent();
    }

    @Override
    public String getIndexLastUpdated(Searchable gen) {
        return ((Content)gen).getUpdated().toString();
    }

    @Override
    public String getUpdated(Searchable gen) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(((Content)gen).getUpdated());
    }
}
