/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.sieps.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.nlp.SWBDictionary;
import org.semanticwb.nlp.SWBLocaleLexicon;
import org.semanticwb.nlp.translation.SWBSparqlTranslator;
import org.semanticwb.platform.SemanticObject;

/**
 * Class for NL search of products and companies.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class NLSearcher {
    private Logger log = SWBUtils.getLogger(NLSearcher.class);
    private String lng = "";
    private SWBDictionary lex = null;
    private SWBSparqlTranslator tr;
    private NLSearcher instance = null;
    private String lastQuery = "";
    private HashMap<String, Rule> rules;

    /**
     * Creates a new Searcher with predefined rules.
     * @param lang
     */
    public NLSearcher(String lang) {
        //Create lexicon for NLP
        lex = SWBDictionary.getInstance();

        //Set language for the lexicon
        lng = lang;

        //Add lexicon for user's language
        lex.addLexicon(new SWBLocaleLexicon(lng, SWBDictionary.getLanguageName(lng)));

        //Set lexicon's default language
        lex.setLocale(lng);

        //Create NL to SPARQL translator
        tr = new SWBSparqlTranslator(lex);

        //Create set of preprocessing rules
        rules = new HashMap<String, Rule>();
        rules.put("rule1", new Rule("rule1", "\\s*que\\s*produce[n]?\\s*", "$1 con producto con nombre como \"$2\""));
        rules.put("rule2", new Rule("rule2", "\\s*cuya\\s*actividad\\s*sea\\s*", "$1 con scian con nombre como \"$2\""));
        rules.put("rule3", new Rule("rule3", "\\s*cuya\\s*clave\\s*sea\\s*", "$1 con unspsc con código = \"$2\""));
        rules.put("rule4", new Rule("rule4", "\\s*cuya\\s*clave\\s*scian\\s*sea\\s*", "$1 con scian con código = \"$2\""));
        rules.put("rule5", new Rule("rule5", "\\s*que\\s*se\\s*encuentra[n]?\\s*en\\s*la\\s*categoría\\s*de\\s*", "$1 con unspsc con nombre como \"$2\""));
    }

    /**
     * Adds a new tokenization rule to the searcher.
     * @param r Tokenization rule.
     */
    public void addRule(Rule r) {
        rules.put(r.getName(), r);
    }

    /**
     * Tokenizes query string using given rules.
     * @param query Query.
     * @return Restructured query if any rule matches, the same query otherwise.
     */
    private String preprocessQuery (String query) {
        String res = query;
        boolean matched = false;

        //Check all preprocessing rules
        Iterator<String> keys = rules.keySet().iterator();
        while (keys.hasNext() && !matched) {
            String key = keys.next();
            Rule rule = rules.get(key);
            Pattern pattern = Pattern.compile(rule.getRegexp());
            Matcher matcher = pattern.matcher(query.toLowerCase());

            //Rule matched, get parts
            if (matcher.find()) {
                String parts[] = query.split(rule.getRegexp());

                //If tokenized correctly, replace query string
                if (parts.length == 2) {
                    res = rule.getResult().replace("$1", parts[0]);
                    res = res.replace("$2", parts[1]);
                    lastQuery = query;
                    matched = true;
                }
            }
        }        
        return res;
    }

    /**
     * Executes a NL Search query.
     * @param query Query.
     * @return Iterator to List of results.
     */
    public Iterator<SemanticObject> search(String query) {
        ArrayList<SemanticObject> res = new ArrayList<SemanticObject>();
        String sparqlQuery = lex.getLexicon(lng).getPrefixString() + "\n" + tr.translateSentence(preprocessQuery(query), false);

        if (tr.getErrCode() == 0) {
            lastQuery = query;
            System.out.println("---SPARQL QUERY:---");
            System.out.println(sparqlQuery);
        }
        return res.iterator();
    }
}
