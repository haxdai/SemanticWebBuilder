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
 
package org.semanticwb.portal.integration.lucene.analyzer;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.analysis.snowball.*;

import java.io.Reader;
import java.util.Set;

/** Filters {@link StandardTokenizer} with {@link StandardFilter}, {@link
 * LowerCaseFilter} and {@link StopFilter}. */
public class LocaleAnalyzer extends Analyzer
{
    private Set stopTable;

    /** An array containing some common English words that are usually not
     useful for searching. */
    public static final String[] STOP_WORDS = {
        "a", "and", "are", "as", "at", "be", "but", "by",
        "for", "if", "in", "into", "is", "it",
        "no", "not", "of", "on", "or", "s", "such",
        "t", "that", "the", "their", "then", "there", "these",
        "they", "this", "to", "was", "will", "with",
        "y", "para", "por", "con", "de",
        "en", "un", "es", "el",
        "o", "que", "los", "lo", "este", "ese",
        "esos"
    };

    private String name = "Spanish";

    /** Builds an analyzer. */
    public LocaleAnalyzer()
    {
        this(STOP_WORDS);
    }

    public LocaleAnalyzer(String name)
    {
        this(STOP_WORDS);
        this.name = name;
    }

    public LocaleAnalyzer(String name, String[] stopWords)
    {
        this.name = name;
        stopTable = StopFilter.makeStopSet(stopWords);
    }


    /** Builds an analyzer with the given stop words. */
    public LocaleAnalyzer(String[] stopWords)
    {
        stopTable = StopFilter.makeStopSet(stopWords);
    }

    /** Constructs a {@link StandardTokenizer} filtered by a {@link
     StandardFilter}, a {@link LowerCaseFilter} and a {@link StopFilter}. */
    public final TokenStream tokenStream(String fieldName, Reader reader)
    {
        TokenStream result = new StandardTokenizer(reader);
        result = new StandardFilter(result);
        //result = new LowerCaseFilter(result);
        result = new LocaleTokenizer(reader);
        result = new StopFilter(result, stopTable);
        result = new SnowballFilter(result, name);
        return result;
    }
}
