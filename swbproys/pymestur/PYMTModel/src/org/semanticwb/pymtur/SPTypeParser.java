/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur;

import org.semanticwb.model.Searchable;
import org.semanticwb.portal.indexer.parser.WebPageParser;

/**
 * Parser for {@link Searchable} Service Provider Type Pages.
 * <p>
 * Parser para páginas Web de Tipos de Proveedores de Servicios.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class SPTypeParser extends WebPageParser {
    
    @Override
    public String getType(Searchable gen) {
        return "SPType";
    }

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Tipo de empresa";
    }
}
