/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur;

import java.util.HashMap;
import java.util.Map;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author hasdai
 */
public class ServiceProviderParser extends GenericParser {
    public static final String ATT_DESTINATION = "destination";

    @Override
    public String getType(Searchable gen) {
        return "ServiceProvider";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((ServiceProvider)gen).getDescription();
    }

    @Override
    public String getUrl(Searchable gen) {
        return ((ServiceProvider)gen).getWebPage().getUrl();// + "?act=detail&uri=" +gen.getSemanticObject().getEncodedURI();
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        WebPage page=((ServiceProvider)gen).getWebPage();
        ret=page.getPath(arg);

        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        return ((ServiceProvider)gen).getDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((ServiceProvider)gen).getTags();
    }

    @Override
    public String getImage(Searchable gen) {
        return SWBPortal.getWebWorkPath() + "/" +
                gen.getSemanticObject().getWorkPath() + "/" +
                gen.getSemanticObject().getProperty(ServiceProvider.pymtur_PhotoLogo);
    }

    private WebPage getWebPage(Searchable gen) {
        return ((ServiceProvider)gen).getWebPage();
    }

    @Override
    public String getIndexCategory(Searchable gen)
    {
        ServiceProvider sp = (ServiceProvider) gen;
        String ret="";
        WebPage page = getWebPage(gen);
        if(page != null)
        {
            ret = super.getIndexCategory(page);
        }
        //System.out.println("===" + sp.getTitle() + "[" + ret + "]" + sp.getURI());
        return ret;        
    }

    public String getDestination(Searchable gen) {
        String ret = "";
        if (((ServiceProvider)gen).getDestination() != null) {
            ret = ((ServiceProvider)gen).getDestination().getTitle();
            //System.out.println(" === " + ret);
        }
        return ret;
    }

    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Map map = super.getIndexTerms(gen);
        map.put(ATT_DESTINATION, new IndexTerm(ATT_DESTINATION, getDestination(gen), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }
}
