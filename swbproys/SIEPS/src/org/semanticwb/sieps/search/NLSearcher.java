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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.nlp.SWBDictionary;
import org.semanticwb.nlp.SWBLocaleLexicon;
import org.semanticwb.nlp.Word;
import org.semanticwb.nlp.translation.SWBSparqlTranslator;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.searcher.SearchDocument;
import org.semanticwb.portal.indexer.searcher.SearchQuery;
import org.semanticwb.portal.indexer.searcher.SearchResults;
import org.semanticwb.portal.indexer.searcher.SearchTerm;

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
    private ArrayList<Rule> rules;
    private String []determiners = {"el","la","los","las"};
    private HashMap<String, String> contractions;
    private Comparator pComp = new Comparator() {
            public int compare(Object o1, Object o2) {
                int res = 0;
                Rule r1 = (Rule)o1;
                Rule r2 = (Rule)o2;
                if (r1.getPriority() < r2.getPriority()) {
                    res = -1;
                } else if (r1.getPriority() > r2.getPriority()) {
                    res = 1;
                }
                return res;
            }
        };

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
        rules = new ArrayList<Rule>();
        rules.add(new Rule("rule1", "\\s*que\\s*produce[n]?\\s*", "$1 con (producto con nombre como \"$2\")", 1));
        rules.add(new Rule("rule2", "\\s*que\\s*fabrica[n]?\\s*", "$1 con (producto con nombre como \"$2\")", 1));
        rules.add(new Rule("rule3", "\\s*que\\s*elabora[n]?\\s*", "$1 con (producto con nombre como \"$2\")", 1));
        rules.add(new Rule("rule4", "\\s*cuy[a|o]\\s*actividad\\s*[s]?e[s|ea]\\s*", "$1 con (clase con nombre como \"$2\")", 1));
        rules.add(new Rule("rule5", "\\s*que\\s*su\\s*actividad\\s*[s]?e[s|ea]\\s*", "$1 con (clase con nombre como \"$2\")", 1));
        rules.add(new Rule("rule6", "\\s*cuy[o|a]\\s*código\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule7", "\\s*que\\s*su\\s*código\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule8", "\\s*cuy[a|o]\\s*clave\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule9", "\\s*que\\s*su\\s*clave\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule10", "\\s*cuy[a|o]\\s*clave\\s*scian\\s*[s]?e[s|ea]\\s*", "$1 con (clase con código = \"$2\")", 1));
        rules.add(new Rule("rule11", "\\s*que\\s*su\\s*clave\\s*scian\\s*[s]?e[s|ea]\\s*", "$1 con (clase con código = \"$2\")", 1));
        rules.add(new Rule("rule12", "\\s*que\\s*se\\s*encuentra[n]?\\s*en\\s*la\\s*categoría\\s*de\\s*", "$1 con (categoría con nombre como \"$2\")", 1));
        rules.add(new Rule("rule13", "\\s*que\\s*su\\s*categoría\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con nombre como \"$2\")", 1));
        rules.add(new Rule("rule14", "\\s*[de|en]\\s*el\\s*estado\\s*de\\s*", "$1 con estado como \"$2\"", 2));
        rules.add(new Rule("rule15", "\\s*cuy[a|o]\\s*estado\\s*[s]?e[s|ea]\\s*", "$1 con estado como \"$2\"", 2));
        rules.add(new Rule("rule16", "\\s*que\\s*su\\s*estado\\s*[s]?e[s|ea]\\s*", "$1 con estado como \"$2\"", 2));
        rules.add(new Rule("rule17", "\\s*[de|en]\\s*la\\s*colonia\\s*", "$1 con colonia como \"$2\"", 2));
        rules.add(new Rule("rule18", "\\s*cuy[a|o]\\s*colonia\\s*[s]?e[s|ea]\\s*", "$1 con colonia como \"$2\"", 2));
        rules.add(new Rule("rule19", "\\s*que\\s*su\\s*colonia\\s*[s]?e[s|ea]\\s*", "$1 con colonia como \"$2\"", 2));
        rules.add(new Rule("rule20", "\\s*[en|de]\\s*el\\s*municipio\\s*de\\s*", "$1 con municipio como \"$2\"", 2));
        rules.add(new Rule("rule21", "\\s*cuy[a|o]\\s*municipio\\s*[s]?e[s|ea]\\s*", "$1 con municipio como \"$2\"", 2));
        rules.add(new Rule("rule22", "\\s*que\\s*su\\s*municipio\\s*[s]?e[s|ea]\\s*", "$1 con municipio como \"$2\"", 2));

        contractions = new HashMap<String, String>();
        contractions.put("del", "de el");
        contractions.put("al", "a el");

        Iterator<Word> words = lex.getDefaultLexicon().listWords();
        while(words.hasNext()) {
            Word w = words.next();
            System.out.println("::" + w.getLexicalForm());
        }
    }

    /**
     * Adds a new tokenization rule to the searcher.
     * @param r Tokenization rule.
     */
    public void addRule(Rule r) {
        rules.add(r);
        //Sort rules according to priority
        Collections.sort(rules, pComp);
    }

    /*public String correctSpell(String query) {
        String res = "";
        String []words = query.split(" ");
        SWBSpellChecker chk = new SWBSpellChecker(SWBPortal.getIndexMgr().getDefaultIndexer().getIndexPath(), SWBIndexer.ATT_CLASS);
        
        for (int i = 0; i < words.length; i++) {
            res += chk.suggestSimilar(words[i]) + " ";
        }

        return res.trim();
    }*/

    /*private int CaulculateDistance(String s1, String s2) {
        int res = 0;
        int m = s1.length();
        int n = s2.length();

        int [][]d = new int[m][n];
        for (int i = 0; i < m; i++) {
            d[i][0] = i; //insertion
        }

        for (int i = 0; i < n; i++) {
            d[0][i] = i; //deletion
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = minimum(d[i-1][j] + 1, d[i][j-1]+ 1, d[i-1][j-1]+1);
                }
            }
        }
        return res;
    }*/

    /**
     * Tokenizes query string using given rules.
     * @param query Query.
     * @return Restructured query if any rule matches, the same query otherwise.
     */
    private String preprocessQuery (String query) {
        String res = query;
        boolean matched = false;
        String subject = "";
        String finalquery = "";

        //If more than a word, processing needed
        if (query.split(" ").length > 1) {
            //Expand contractions
            Iterator<String> keys = contractions.keySet().iterator();
            while(keys.hasNext()) {
                String key = keys.next();
                String re = "\\s*" + key + "\\s*";
                res = query.replaceAll(re, contractions.get(key));
            }

            //if complex query, separate it
            String []queries = query.split(",");
            System.out.println("--" + queries.length + " queries found");
            for (int i = 0; i < queries.length; i++) {
                matched = false;
                String tquery = queries[i].trim();
                //Check all preprocessing rules
//                System.out.println("--Query " + i + ": " + tquery);
                Iterator<Rule> rit = rules.iterator();
                while (rit.hasNext() && !matched) {
                    Rule rule = rit.next();
                    Pattern pattern = Pattern.compile(rule.getRegexp());
                    Matcher matcher = pattern.matcher(tquery.toLowerCase());

                    //Rule matched, get parts
                    if (matcher.find()) {
                        //First rule over first query gives the subject
                        if (i == 0) {
                            subject = tquery.substring(0, matcher.start());
//                            System.out.println("-- subject found: " + subject);
                        }
                        //System.out.println("--Rule " + rule.getName() + " matched");
                        String parts[] = tquery.split(rule.getRegexp());
//                        System.out.println("::Splitting by " + rule.getRegexp());
//
//                        System.out.println("::" + parts.length + " parts found");

//                        for (int j = 0; j < parts.length; j++) {
//                            System.out.println("::P" + j + ": \"" + parts[j] + "\"");
//                        }

                        //If tokenized correctly, replace query string
                        if (parts.length == 2) {
                            res = rule.getResult().replace("$1", parts[0]);
                            res = res.replace("$2", parts[1]);
                            //System.out.println("--Rewritten query: " + res);
                            matched = true;
                        }
                    }
                }
                finalquery += "," + res;
            }
        } else {
                finalquery = query;
            }
        return finalquery.replaceFirst(",", "");
    }

    /*private int minimum(int a, int b, int c) {
        int res = a;
        
        if (res > b) res = b;
        if (res > c) res = c;
        return res;
    }*/

    /**
     * Executes a restricted Natural Language query.
     * @param query Query.
     * @param site WebSite.
     * @param user User.
     * @return Iterator to search results as SemanticObjects.
     */
    public Iterator<SemanticObject> search(String query, WebSite site, User user) {
        ArrayList<SemanticObject> res = new ArrayList<SemanticObject>();
        String sparqlQuery = "";
        boolean allowed = false;

        System.out.println("::original query: " + query);
        //Preprocess query
        sparqlQuery = preprocessQuery(query);
        System.out.println("--Externally called result: " + sparqlQuery);

        //Query was processed, thus, it is allowed
        if (!query.equals(sparqlQuery) || query.split(" ").length == 1) {
            allowed = true;
        }

        //Translate query to SPARQL
        sparqlQuery = lex.getLexicon(lng).getPrefixString() + "\n" + tr.translateSentence(sparqlQuery, false);

        //If query translated correctly, and it is allowed, execute it
        if (tr.getErrCode() == 0 && allowed) {
            lastQuery = query;
            System.out.println("--Translated query:" + query);
            System.out.println("---SPARQL QUERY:---");
            System.out.println(sparqlQuery);

            try {
                Model model = SWBPlatform.getSemanticMgr().getSchema().getRDFOntModel();
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

        if (res.isEmpty()) { //Translation failed or no results found, execute normal search
            res = luceneSearch(query, site, user, null);
        }
        System.out.println("--" + res.size() + " results found:");
        Iterator<SemanticObject> itres = res.iterator();
        while(itres.hasNext()) {
            SemanticObject so = itres.next();
            System.out.println(":::" + so.getURI());
        }
        return res.iterator();
    }

    /**
     * Executes a search over the lucene indexed objects.
     * @param query Query.
     * @param model WebSite to search in.
     * @param user User.
     * @param category Category to start searching.
     * @return List of search result as SemanticObjects
     */
    public ArrayList<SemanticObject> luceneSearch(String query, WebSite site, User user, String category) {
        ArrayList<SemanticObject> res = new ArrayList<SemanticObject>();
    
        SearchQuery q = new SearchQuery();
        SearchQuery tquery=new SearchQuery(SearchQuery.OPER_AND);
        q.addQuery(tquery);
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_TITLE, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_DESCRIPTION, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_TAGS, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_DATA, query, SearchTerm.OPER_OR));

        if(site != null) {
            q.addTerm(new SearchTerm(SWBIndexer.ATT_MODEL, site.getId(), SearchTerm.OPER_AND));
        }

        if(category != null && !category.trim().equals("")) {
            q.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, category, SearchTerm.OPER_AND));
        }

        SWBIndexer indexer=SWBPortal.getIndexMgr().getModelIndexer(site);

        if(indexer != null) {
            SearchResults results=indexer.search(q, user);

            Iterator<SearchDocument>it=results.listDocuments();
            while(it.hasNext()) {
                SearchDocument obj=it.next();
                Searchable srch=obj.getSearchable();
                res.add(srch.getSemanticObject());
            }
        }
        return res;
    }
}