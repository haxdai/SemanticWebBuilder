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
import org.semanticwb.sieps.Empresa;
import org.semanticwb.sieps.Producto;

/**
 * Class for NL search of products and companies.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class NLSearcher {
    private Logger log = SWBUtils.getLogger(NLSearcher.class);
    private String lng = "";
    private SWBDictionary lex = null;
    private SWBSparqlTranslator tr;
    private ArrayList<Rule> rules;
    private String []determiners = {"el","la","los","las"};
    private HashMap<String, String> contractions;
    private String lastSearchType = "";
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
        rules.add(new Rule("rule4", "\\s*que\\s*su\\s*actividad\\s*[s]?e[s|ea]\\s*", "$1 con actividad = \"$2\"", 1));
        rules.add(new Rule("rule5", "\\s*cuy[a|o]\\s*actividad\\s*[s]?e[s|ea]\\s*", "$1 con (clase con actividad como \"$2\")", 1));
        //rules.add(new Rule("rule5", "\\s*que\\s*su\\s*actividad\\s*[s]?e[s|ea]\\s*", "$1 con (clase con actividad como \"$2\")", 1));
        rules.add(new Rule("rule6", "\\s*cuy[o|a]\\s*código\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule7", "\\s*que\\s*su\\s*código\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule8", "\\s*cuy[a|o]\\s*clave\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule9", "\\s*que\\s*su\\s*clave\\s*[s]?e[s|ea]\\s*", "$1 con (categoría con código = \"$2\")", 1));
        rules.add(new Rule("rule10", "\\s*cuy[a|o]\\s*clave\\s*scian\\s*[s]?e[s|ea]\\s*", "$1 con (clase con código = \"$2\")", 1));
        rules.add(new Rule("rule11", "\\s*que\\s*su\\s*clave\\s*scian\\s*[s]?e[s|ea]\\s*", "$1 con (clase con código = \"$2\")", 1));
        rules.add(new Rule("rule12", "\\s*que\\s*se\\s*encuentra[n]?\\s*en\\s*la\\s*categoría\\s*de\\s*", "$1 con (categoría con nombre como \"$2\")", 1));
        rules.add(new Rule("rule13", "\\s*que\\s*su\\s*categoria\\s*[s]?e[s|ea]\\s*", "$1 con categoria = \"$2\"", 1));
        rules.add(new Rule("rule14", "\\s*[d]?e[n]?\\s*el\\s*estado\\s*de\\s*", "$1 con estado como \"$2\"", 2));
        rules.add(new Rule("rule15", "\\s*cuy[a|o]\\s*estado\\s*[s]?e[s|ea]\\s*", "$1 con estado como \"$2\"", 2));
        rules.add(new Rule("rule16", "\\s*que\\s*su\\s*estado\\s*[s]?e[s|ea]\\s*", "$1 con estado como \"$2\"", 2));
        rules.add(new Rule("rule17", "\\s*[d]?e[n]?\\s*la\\s*colonia\\s*", "$1 con colonia como \"$2\"", 2));
        rules.add(new Rule("rule18", "\\s*cuy[a|o]\\s*colonia\\s*[s]?e[s|ea]\\s*", "$1 con colonia como \"$2\"", 2));
        rules.add(new Rule("rule19", "\\s*que\\s*su\\s*colonia\\s*[s]?e[s|ea]\\s*", "$1 con colonia como \"$2\"", 2));
        rules.add(new Rule("rule20", "\\s*[d]?e[n]?\\s*el\\s*municipio\\s*de\\s*", "$1 con municipio como \"$2\"", 2));
        rules.add(new Rule("rule21", "\\s*cuy[a|o]\\s*municipio\\s*[s]?e[s|ea]\\s*", "$1 con municipio como \"$2\"", 2));
        rules.add(new Rule("rule22", "\\s*que\\s*su\\s*municipio\\s*[s]?e[s|ea]\\s*", "$1 con municipio como \"$2\"", 2));
        rules.add(new Rule("rule23", "\\s*que\\s*su\\s*sector\\s*[s]?e[s|ea]\\s*", "$1 con sector = \"$2\"", 2));
        rules.add(new Rule("rule24", "\\s*que\\s*su\\s*subsector\\s*[s]?e[s|ea]\\s*", "$1 con subsector = \"$2\"", 2));
        rules.add(new Rule("rule25", "\\s*que\\s*su\\s*rama\\s*[s]?e[s|ea]\\s*", "$1 con rama = \"$2\"", 2));
        rules.add(new Rule("rule26", "\\s*que\\s*su\\s*subrama\\s*[s]?e[s|ea]\\s*", "$1 con subrama = \"$2\"", 2));
        rules.add(new Rule("rule27", "\\s*que\\s*su\\s*familia\\s*[s]?e[s|ea]\\s*", "$1 con familia = \"$2\"", 2));
        rules.add(new Rule("rule28", "\\s*que\\s*su\\s*segmento\\s*[s]?e[s|ea]\\s*", "$1 con segmento = \"$2\"", 2));
        rules.add(new Rule("rule29", "\\s*que\\s*su\\s*clase\\s*[s]?e[s|ea]\\s*", "$1 con clase = \"$2\"", 2));
        rules.add(new Rule("rule30", "\\s*que\\s*su\\s*nombre\\s*[s]?e[s|ea]\\s*", "$1 con nombre como \"$2\"", 1));
        rules.add(new Rule("rule31", "\\s*que\\s*su\\s*razón\\s*social\\s*[s]?e[s|ea]\\s*", "$1 con [razón social] como \"$2\"", 1));
        //rules.add(new Rule("rule32", "\\s*que\\s*su\\s*clase\\s*[s]?e[s|ea]\\s*", "$1 con clase = \"$2\"", 1));

        contractions = new HashMap<String, String>();
        contractions.put("del", "de el");
        contractions.put("al", "a el");

//        Iterator<Word> words = lex.getDefaultLexicon().listWords();
//        while(words.hasNext()) {
//            Word w = words.next();
//            System.out.println("::" + w.getLexicalForm());
//        }
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

    /**
     * Tries to correct query spelling.
     * @param query Query.
     * @return Corrected query.
     */
    public String correctSpell(String query) {
        String res = "";
        String []words = query.split(" ");        
        
        for (int i = 0; i < words.length; i++) {
            res += getMostSimilarWord(words[i]) + " ";
        }
        return res.trim();
    }

    /**
     * Gets the most similar word to w in the lexicon using Damerau-Levenshtein
     * distance.
     * @param w Word.
     * @return Most similar word to w.
     */
    private String getMostSimilarWord(String w) {
        String res = w;
        int mindistance = 99999;
        Iterator<Word> wit = lex.getDefaultLexicon().listWords();
        while(wit.hasNext()) {
            Word wd = wit.next();
            int d = caulculateDistance(wd.getLexicalForm(), w);
            if (d < mindistance) {
                mindistance = d;
                res = wd.getLexicalForm();
            }
        }
        return res;
    }

    /**
     * Calculates Damerau-Levenshtein distance between two words.
     * @param s1 Word 1.
     * @param s2 Word 2.
     * @return Damerau-Levenshtein distance between word 1 and word 2.
     */
    private int caulculateDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int [][]d = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            d[i][0] = i; //insertion
        }

        for (int i = 0; i <= n; i++) {
            d[0][i] = i; //deletion
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = minimum(d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1] + ((s1.charAt(i-1) == s2.charAt(j-1))?0:1));
            }
        }

        return d[m][n];
    }

    /**
     * Finds the minimum of three numbers.
     * @param a
     * @param b
     * @param c
     * @return Minimum of a,b,c
     */
    private int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    /**
     * Tokenizes query string using given rules.
     * @param query Query.
     * @return Restructured query if any rule matches, the same query otherwise.
     */
    private String preprocessQuery (String query) {
        String res = query;
        boolean matched = false;
        String finalquery = "";
        int matches = 0;

        //System.out.println(":::::::" + correctSpell(query));

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
//            System.out.println("--" + queries.length + " queries found");
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
                        String parts[] = tquery.split(rule.getRegexp());
//                        System.out.println("::Splitting by " + rule.getRegexp());
//
//                        System.out.println("::" + parts.length + " parts found");

//                        for (int j = 0; j < parts.length; j++) {
//                            System.out.println("::P" + j + ": \"" + parts[j] + "\"");
//                        }

                        //If tokenized correctly, replace query string
                        if (parts.length == 2) {
                            matches++;
                            matched = true;
                            res = rule.getResult().replace("$1", parts[0]);
                            res = res.replace("$2", parts[1]);
                            //System.out.println("--Rewritten query: " + res);
                            if (matches > 1) {
                                res = res.replaceFirst("con", "");
                            }
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

        //System.out.println("::original query: " + query);
        //Preprocess query
        sparqlQuery = preprocessQuery(query);
        //System.out.println("--Externally called result: " + sparqlQuery);

        //Query was processed, thus, it is allowed
        if (!query.equals(sparqlQuery) || query.split(" ").length == 1) {
            allowed = true;
        }

        //Translate query to SPARQL
        sparqlQuery = lex.getLexicon(lng).getPrefixString() + "\n" + tr.translateSentence(sparqlQuery, false);

        //If query translated correctly, and it is allowed, execute it
        if (tr.getErrCode() == 0 && allowed) {
            lastSearchType = "SPARQL";
//            System.out.println("--Translated query:" + query);
//            System.out.println("---SPARQL QUERY:---");
//            System.out.println(sparqlQuery);

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
            ArrayList<SemanticObject> r1 = iterativeSearch(query);
            res = luceneSearch(query, site, user, null);
            if (r1 != null && !r1.isEmpty()) {
                res.addAll(r1);
            }
            lastSearchType = "LUCENE";
        }

        /*System.out.println("--" + res.size() + " results found:");
        Iterator<SemanticObject> itres = res.iterator();
        while(itres.hasNext()) {
            SemanticObject so = itres.next();
            System.out.println(":::" + so.getURI());
        }*/
        return res.iterator();
    }

    public ArrayList<SemanticObject> iterativeSearch(String query) {
        ArrayList<SemanticObject> res = new ArrayList<SemanticObject>();
        String tokens[] = query.toLowerCase().split(" ");

        Iterator<Empresa> eit = Empresa.ClassMgr.listEmpresas();
        while (eit.hasNext()) {
            Empresa e = eit.next();
            for (int i = 0; i < tokens.length; i++) {
                String name = e.getName() == null?"":e.getName().toLowerCase();
                String desc = e.getDescripcion() == null?"":e.getDescripcion().toLowerCase();
                if(name.contains(tokens[i]) || desc.contains(tokens[i])) {
                    if(!res.contains(e.getSemanticObject())) {
                        res.add(e.getSemanticObject());
                    }
                }
            }
        }

        Iterator<Producto> pit = Producto.ClassMgr.listProductos();
        while (pit.hasNext()) {
            Producto p = pit.next();
            for (int i = 0; i < tokens.length; i++) {
                String name = p.getPname() == null?"":p.getPname().toLowerCase();
                String desc = p.getDescription() == null?"":p.getDescription().toLowerCase();
                if(name.contains(tokens[i]) || desc.contains(tokens[i])) {
                    if(!res.contains(p.getSemanticObject())) {
                        res.add(p.getSemanticObject());
                    }
                }
            }
        }
        return res;
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
        //tquery.addTerm(new SearchTerm(EmpresaParser.ATT_NAME, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_TITLE, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_DESCRIPTION, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_TAGS, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(SWBIndexer.ATT_DATA, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm("name", query, SearchTerm.OPER_OR));
        /*tquery.addTerm(new SearchTerm(EmpresaParser.ATT_CCLASE, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_CLASE, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_CRAMA, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_CSECTOR, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_CSUBRAMA, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_CSUBSECTOR, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_RAMA, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_SECTOR, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_SUBRAMA, query, SearchTerm.OPER_OR));
        tquery.addTerm(new SearchTerm(EmpresaParser.ATT_SUBSECTOR, query, SearchTerm.OPER_OR));*/

        if(site != null) {
            q.addTerm(new SearchTerm(SWBIndexer.ATT_MODEL, site.getId(), SearchTerm.OPER_AND));
        }

        if(category != null && !category.trim().equals("")) {
            q.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, category, SearchTerm.OPER_AND));
        }

        SWBIndexer indexer=SWBPortal.getIndexMgr().getDefaultIndexer();

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

    public String getLastSearchType() {
        return lastSearchType;
    }
}