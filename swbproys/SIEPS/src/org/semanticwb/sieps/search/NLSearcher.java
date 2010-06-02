/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.sieps.search;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.nlp.SWBDictionary;
import org.semanticwb.nlp.SWBLocaleLexicon;
import org.semanticwb.nlp.translation.SWBSparqlTranslator;
import org.semanticwb.platform.SemanticModel;
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
        rules.put("rule2", new Rule("rule2", "\\s*cuya\\s*actividad\\s*sea\\s*", "$1 con clase con nombre como \"$2\""));
        rules.put("rule3", new Rule("rule3", "\\s*cuya\\s*clave\\s*sea\\s*", "$1 con categoría con código = \"$2\""));
        rules.put("rule4", new Rule("rule4", "\\s*cuya\\s*clave\\s*scian\\s*sea\\s*", "$1 con clase con código = \"$2\""));
        rules.put("rule5", new Rule("rule5", "\\s*que\\s*se\\s*encuentra[n]?\\s*en\\s*la\\s*categoría\\s*de\\s*", "$1 con categoría con nombre como \"$2\""));
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
        String sparqlQuery = "";
        boolean allowed = false;

        //Preprocess query
        sparqlQuery = preprocessQuery(query);

        //Query was processed, thus, it is allowed
        if (!query.equals(sparqlQuery)) {
            allowed = true;
        }

        //Translate query to SPARQL
        sparqlQuery = lex.getLexicon(lng).getPrefixString() + "\n" + tr.translateSentence(sparqlQuery, false);

        //If query translated correctly, and it is allowed, execute it
        if (tr.getErrCode() == 0 && allowed) {
            lastQuery = query;
            System.out.println("---SPARQL QUERY:---");
            System.out.println(sparqlQuery);

            try {
                Model model = SWBPlatform.getSemanticMgr().getOntology().getRDFOntModel();
                SemanticModel mod = new SemanticModel("local", model);
                QueryExecution qexec = mod.sparQLQuery(sparqlQuery);

                try {
                    //Execute query
                    ResultSet rs = qexec.execSelect();

                    //Iterate trough results
                    while (rs.hasNext()) {
                        //Get next solution
                        QuerySolution rb = rs.nextSolution();

                        //Assume it only returns a variable because we are looking for objects
                        RDFNode x = rb.get(rs.getResultVars().get(0));

                        //Validate the resource to check if its literal
                        if (x != null && !x.isLiteral()) {
                            //Try to ge a semantic object
                            SemanticObject so = SemanticObject.createSemanticObject(x.toString());

                            //Semantic object can be created from RDF Resource, add it to results
                            if (so != null) {
                                res.add(so);
                            }
                        }
                    }                    
                } finally {
                    //Close query executor
                    qexec.close();
                }
            } catch (Exception e) {
                log.error("ERROR in class NLSearcher" + e);
            }
        }
        return res.iterator();
    }
}
