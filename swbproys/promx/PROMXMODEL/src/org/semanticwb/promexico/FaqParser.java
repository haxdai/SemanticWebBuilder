/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico;

import org.semanticwb.model.Searchable;
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
        return ((Faq) gen).getDescription();
    }


    @Override
    public String getIndexDescription(Searchable gen) {
        return ((Faq) gen).getDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((Faq) gen).getTags();
    }

}
