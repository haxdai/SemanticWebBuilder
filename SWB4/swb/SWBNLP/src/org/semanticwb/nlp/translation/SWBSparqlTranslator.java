/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.nlp.translation;

import org.semanticwb.nlp.analysis.SimpleLexer;
import org.semanticwb.nlp.analysis.ComplexParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.apache.lucene.index.CorruptIndexException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.nlp.Lexicon;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticProperty;


/**
 * A natural language to SparQl query translator. Uses the Abstract Sintax Tree
 * (AST) of a sentence obtained with the antlr generated parser ({@link ComplexParser})
 * in order to build a structured SparQl query.
 *
 * Un traductor de consultas en lenguaje natural a consultas SparQl. Usa el árbol
 * de sintaxis abstracta (AST) de una oración obtenido con el analizador generado
 * por antlr ({@link ComplexParser}) para construir una consulta SparQl
 * estructurada.
 *
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class SWBSparqlTranslator {

    private ComplexParser parser;     //ANTLR parser
    private SimpleLexer tokenizer;   //ANTLR tokenizer
    private Lexicon lex;        //Dictionary
    private CommonTokenStream tokens;   //TokenStream for parsing
    private ANTLRStringStream input;    //StringStream to parse
    private String nodeLabels = "SELECT|PRECON|PREDE|ASIGN|COMPL|COMPG|COMPLE|COMPGE|OFFSET|LIMIT|ORDER";
    private String eLog = "";   //Error log
    private int errCode = 0;    //Last error code

    /**
     * Creates a new instance of SWBSparqlTranslator with the given Lexicon.
     * Crea un SWBSparqlTranslator con el diccionario especificado.
     * @param dict Lexicon for the new translator. Diccionario para el traductor.
     */
    public SWBSparqlTranslator (Lexicon dict) {
        lex = dict;
    }

    /**
     * Transforms a Natural Language query to a SparQL query. Using an antlr 
     * (http://www.antlr.org) parser, this method builds an AST
     * (Abstract Sintax Tree) and traverses it to generate the SparQL query.
     *
     * Transforma una consulta en lenguaje natural a una consulta en SparQl.
     * Usando un analizador generado por antlr (http://www.antlr.org), el método
     * construye un AST (Árbol de sintáxis abstracta) y lo recorre para generar
     * la consulta SparQl.
     * 
     * @param sent Rescticted-Natural Language sentence for the query.
     * Oración en lenguaje natural restringido para la consulta.
     * @return SparQL query sentence. Sentencia de la consulta SparQl.
     */
    public String translateSentence(String sent) throws CorruptIndexException, IOException {
        String res = "";
        CommonTree sTree = null;
        input = new ANTLRStringStream(sent);
        tokenizer = new SimpleLexer(input);
        tokens = new CommonTokenStream(tokenizer);
        parser = new ComplexParser(tokens);

        try {
            ComplexParser.squery_return qres = (ComplexParser.squery_return) parser.squery();
            if (parser.getErrorCount() == 0) {
                sTree = (CommonTree) qres.getTree();
                fixNames(sTree);
                //traverseAST(sTree, "");
                res += processSelectQuery(sTree, parser.hasPrecon(), parser.hasPrede());
                //System.out.println(res);
                return res;
            } else {
                errCode = 2;
                eLog += "no se pudo obtener AST.\n";
                return "";
            }
        } catch (org.antlr.runtime.RecognitionException ex) {
            errCode = 2;
            eLog += "No se ha podido traducir la consulta.\n";
            return "";
        }
    }

    /**
     * Transforms a SELECT node in the AST to a SparQL query fragment.
     * Transforma un nodo SELECT en el AST en un fragmento de la consulta SparQl.
     * @param root SELECT node to transform. Nodo SELECT a transformar.
     * @param hasPrecon wheter or not the AST has a PRECON node.
     * Indica si el AST contiene una preposición CON.
     * @param hasPrede wheter or not the AST has a PREDE node.
     * Indica si el AST contiene una preposición DE.
     * @return String of a SparQL query fragment. Fragmento de consulta SparQl.
     */
    private String processSelectQuery(CommonTree root, boolean hasPrecon, boolean hasPrede) throws CorruptIndexException, IOException {
        String limitoff = "";
        String order = "";
        String res = "";
        String varList = "";

        List<CommonTree> child = root.getChildren();
        if (child != null) {
            res = "SELECT DISTINCT ";
            Iterator<CommonTree> cit = child.iterator();
            while (cit.hasNext()) {
                CommonTree t = cit.next();

                if (t.getText().equals("LIMIT")) {
                    limitoff = limitoff + " LIMIT " + t.getChild(0).getText() + "\n";
                } else if (t.getText().equals("ORDER")) {
                    order += " ORDER BY ";
                    Iterator<CommonTree> oit = t.getChildren().iterator();
                    while (oit.hasNext()) {
                        order = order + "?" + oit.next().getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") + " ";
                    }
                    order = order.trim() + "\n";
                } else if (t.getText().equals("OFFSET")) {
                    limitoff = limitoff + " OFFSET " + t.getChild(0).getText() + "\n";
                } else {
                    if (hasPrede) {
                        if (hasPrecon) {
                            varList += getVarList((CommonTree)t.getChild(1), t.getText());
                        } else {
                            varList += getVarList((CommonTree)t.getChild(0), t.getText());
                        }
                    } else {
                        varList = varList + "?" + t.getText().replace(" ", "_").replaceAll("[\\(|\\)]", "");
                    }
                    res = res + varList + "\nWHERE \n{\n";
                    String etype = lex.getObjWordTag(t.getText()).getType();
                    if(!etype.equals("")) {
                        res = res + "?" + t.getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") + " rdf:type " + etype
                            + ".\n";
                        res += startParsing(t);
                    } else {
                        errCode = 2;
                        eLog = eLog + t.getText() + " no es una clase.";
                    }
                }
            }
        }
        return res + "}" + order + limitoff;
    }

    /**
     * Starts deep parsing of the AST.
     * Inicia el análisis a profundidad del AST.
     * @param root root node to start parsing (usually child of SELECT node).
     * Nodo raíz (usualmente hijo del nodo SELECT) para el análisis.
     * @return String with a SParQL query fragment.
     * Cadena con un fragmento de consulta SparQl.
     */
    private String startParsing(CommonTree root) throws CorruptIndexException, IOException {
        String res = "";
        List<CommonTree> child = root.getChildren();

        if (child != null) {
            Iterator<CommonTree> cit = child.iterator();
            while (cit.hasNext()) {
                CommonTree t = cit.next();
                res += processNode(t, root.getText(), root.getText());
            }
        }
        return res;
    }

    /**
     * Transforms an AST node into a SparQL query fragment.
     * Transforma un AST en un fragmento de la consulta SparQl.
     * @param root AST node to transform.
     * @param parent name of the parent object of the node (for searching properties).
     * @param parentLabel name of the parent object of the node (for ataching properties).
     * @return a SparQL query fragment for the AST node.
     */
    private String processNode(CommonTree root, String parent, String parentLabel) throws CorruptIndexException, IOException {
        String res = "";
        List<CommonTree> child = root.getChildren();
        String nname = root.getText();

        //System.out.println(nname + "[ " + parent + ", " + parentLabel + "]");
        if (nname.equals("PRECON")) {
            //Procesar los hijos con el padre del actual
            if (child != null) {
                Iterator<CommonTree> cit = child.iterator();
                while (cit.hasNext()) {
                    CommonTree t = cit.next();

                    res += processNode(t, parent, parentLabel);
                }
            }
        } else if (nname.equals("ASIGN") || nname.equals("COMPG") || nname.equals("COMPL") ||
                    nname.equals("COMPLE") || nname.equals("COMPGE")) {
                    res = res + processStatement(root, parent, parentLabel);
        } else if (nname.equals("PREDE")) {
            if (!root.getChild(0).getText().equals("MODTO")) {
                if (child != null) {
                    Iterator<CommonTree> cit = child.iterator();
                    while (cit.hasNext()) {
                        CommonTree t = cit.next();
                        String cname = t.getText();

                        res = res + "?" + parent.replace(" ", "_").replaceAll("[\\(|\\)]", "") + " " +
                                assertPropertyType(cname, parent) + " ?" +
                                cname.replace(" ", "_").replaceAll("[\\(|\\)]", "") + ".\n";
                    }
                }
            } else {
                res = res + "?" + parent.replace(" ", "_").replaceAll("[\\(|\\)]", "") + " ?prop ?val.\n";
            }
        } else {
            if (child != null) {
                String rangeType = assertPropertyRangeType(nname, parent);
                if (!rangeType.equals("")) {
                    SemanticClass scl = assertPropertyRangeClass(nname, parent);
                    res = res + "?" + nname.replace(" ","_").replaceAll("[\\(|\\)]", "") + " rdf:type " + rangeType + ".\n";
                    String pName = assertPropertyType(nname, parent);
                    if (!pName.equals("")) {
                        res = res + "?" + parent.replace(" ","_").replaceAll("[\\(|\\)]", "") + " " + pName + " ?" +
                                nname.replace(" ", "_").replaceAll("[\\(|\\)]", "") + ".\n";
                    }
                    if (scl != null) {
                        String cName = scl.getDisplayName(lex.getLanguage());
                        Iterator<CommonTree> cit = child.iterator();
                        while (cit.hasNext()) {
                            CommonTree t = cit.next();
                            res += processNode(t, cName, nname);
                        }
                    }
                }
            } else {
                String pName = assertPropertyType(nname, parent);
                if (!pName.equals("")) {
                    if (!parentLabel.equals("")) {
                        res = res + "?" + parentLabel.replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            " " + pName + " ?" + nname.replace(" ", "_").replaceAll("[\\(|\\)]", "") + ".\n";
                    } else {
                        res = res + "?" + parent.replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            " " + pName + " ?" + nname.replace(" ", "_").replaceAll("[\\(|\\)]", "") + ".\n";
                    }
                }
            }
        }
        return res;
    }

    /**
     * Transforms a PREDE node into a SparQL query fragment. If PREDE's first
     * child is a MODTO node, an '*' is added to the varList of the SELECT clause
     * for the query. Otherwise, varList consists of the names of all child
     * nodes of PREDE.
     * @param root the PREDE node.
     * @param parent name of the parent object of PREDE node.
     * @return a SparQL query fragment, specifically a varList for the SelecQuery
     * production of the SparQL query language grammar.
     */
    private String getVarList(CommonTree root, String parent) {
        String res = "";

        if (root.getChild(0).getText().equals("MODTO")) {
            return "?" + parent.replace(" ", "_").replaceAll("[\\(|\\)]", "") + " ?prop ?val";
        }

        List<CommonTree> child = root.getChildren();
        if (child != null) {
            Iterator<CommonTree> cit = child.iterator();
            while (cit.hasNext()) {
                CommonTree t = cit.next();
                res = res + "?" + t.getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") + " ";
            }
        }
        return res.trim();
    }

    /**
     * Transforms an ASIGN, COMPL, COMPG, COMPLE or COMPGE node into a SparQL
     * query fragment. The last four nodes generate a FILTER clause in the
     * resulting fragment.
     * @param root one of the above nodes.
     * @param parent name of the parent object of the statement node (for searching).
     * @param parentLabel name of the parent object of the statement node (for attaching).
     * @return a SparQL query fragment, specifically a triple for an ASIGN node
     * or a triple and a FILTER clause for the node.
     */
    private String processStatement(CommonTree root, String parent, String parentLabel) throws CorruptIndexException, IOException {
        String res = "";
        String pName = assertPropertyType(root.getChild(0).getText(), parent);
        System.out.println("verificando " + root.getChild(0).getText() + " de " + parent + " con etiqueta " + parentLabel);
        if (root.getText().equals("ASIGN")) {
            if (!pName.equals("")) {
                res = res + "?" + parentLabel.replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                        " " + pName + " " + root.getChild(1).getText() + ".\n";
            }
        } else if (root.getText().equals("COMPL")) {
                if (!pName.equals("")) {
                    res = res + "?" + parentLabel.replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            " " + pName + " ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            ".\n";
                    res = res + "FILTER ( ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            " < " + root.getChild(1).getText() + ").\n";
                }
            } else if (root.getText().equals("COMPG")) {
                if (!pName.equals("")) {
                    res = res + "?" + parentLabel.replace(" ", "_").replaceAll("[\\(|\\)]", "") + " " + pName +
                            " ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") + ".\n";
                    res = res + "FILTER ( ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            " > " + root.getChild(1).getText() + ").\n";
                }
            } else if (root.getText().equals("COMPLE")) {
                if (!pName.equals("")) {
                    res = res + "?" + parentLabel.replace(" ", "_").replaceAll("[\\(|\\)]", "") + " " + pName +
                            " ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") + ".\n";
                    res = res + "FILTER ( ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            " <= " + root.getChild(1).getText() + ").\n";
                }
            } else if (root.getText().equals("COMPGE")) {
                if (!pName.equals("")) {
                    res = res + "?" + parentLabel.replace(" ", "_").replaceAll("[\\(|\\)]", "") + " " + pName +
                            " ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            ".\n";
                    res = res + "FILTER ( ?v_" + root.getChild(0).getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") +
                            " >= " + root.getChild(1).getText() + ").\n";
                }
            } else {
                if (!pName.equals("")) {
                    res = res + "?" + parentLabel.replace(" ", "_").replaceAll("[\\(|\\)]", "") + " " + pName + " ?" +
                            root.getText().replace(" ", "_").replaceAll("[\\(|\\)]", "") + ".\n";
                }
            }
        return res;
    }

    /**
     * Validates if propertyName is a property of className in the
     * SemanticVocabulary.
     * @param propertyName name of the property to get type for.
     * @param className name of the class which contains the propertyName.
     * @return the RDF type of propertyName if it's a propery of className,
     * empty String otherwise.
     */
    private String assertPropertyType(String propertyName, String className) throws CorruptIndexException, IOException {
        String res = "";
        String name = lex.getObjWordTag(className).getObjId();
        boolean found = false;
        SemanticProperty sp = null;
        Iterator<SemanticProperty> sit;
        //System.out.println(">verificando " + propertyName + " de " + className);
        SemanticClass sc = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClassById(name);
        if (sc != null) {
            sit = sc.listProperties();
            while (sit.hasNext() && !found) {
                sp = sit.next();
                if (sp.getDisplayName(lex.getLanguage()).toLowerCase().equals(propertyName.toLowerCase())) {
                    res = res + sp.getPrefix() + ":" + sp.getName();
                    found = true;
                }
            }
            if (!found) {
                eLog += "La clase " + sc.getDisplayName(lex.getLanguage()) + " no tiene una propiedad llamada ";
                if (sit.hasNext()) {
                    sp = sit.next();
                    eLog += sp.getDisplayName(lex.getLanguage()) + "\n";
                } else {
                    eLog += propertyName + "\n";
                }
                errCode = 3;
            }
        }
        return res;
    }

    /**
     * Gets the range class (as a SemanticClass) of an object property.
     * @param propertyName name of the property to assert.
     * @param className name of the SemanticClass with the specified property.
     * @return a SemanticClass which is the range class of the object property. Null otherwise.
     */
    public SemanticClass assertPropertyRangeClass(String propertyName, String className) throws CorruptIndexException, IOException {
        String name = lex.getObjWordTag(className).getObjId();
        boolean found = false;
        SemanticProperty sp = null;
        Iterator<SemanticProperty> sit;

        SemanticClass sc = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClassById(name);
        if (sc != null) {
            sit = sc.listProperties();
            while (sit.hasNext() && !found) {
                sp = sit.next();
                if (sp.getDisplayName(lex.getLanguage()).toLowerCase().equals(propertyName.toLowerCase())) {
                    found = true;
                    if (sp.isObjectProperty()) {
                        StringBuffer bf = new StringBuffer();
                        bf.append(sp.getRangeClass());

                        SemanticClass rg = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(bf.toString());
                        if (rg != null) {
                            return rg;
                        }
                    }
                    else {
                        errCode = 3;
                        eLog += "La propiedad " + sp.getDisplayName(lex.getLanguage()) + "no es de tipo Objeto.\n";
                    }
                }
            }

            if (!found) {
                eLog += "La clase " + sc.getDisplayName(lex.getLanguage()) + " no tiene una propiedad llamada ";
                if (sit.hasNext()) {
                    sp = sit.next();
                    eLog += sp.getDisplayName(lex.getLanguage()) + "\n";
                } else {
                    eLog += propertyName + "\n";
                }
                errCode = 3;
            }
        }
    return null;
    }

    /**
     * Gets the type (prefix + name) of the range class for an object property.
     * @param propertyName name of the property to assert.
     * @param className name of the SemanticClass with the specified property.
     * @return prefix + name of the property, empty String if propertyName is
     *         not a SemanticProperty of className.
     */
    public String assertPropertyRangeType(String propertyName, String className) throws CorruptIndexException, IOException {
        String res = "";
        String name = lex.getObjWordTag(className).getObjId();
        boolean found = false;
        SemanticProperty sp = null;
        Iterator<SemanticProperty> sit;

        SemanticClass sc = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClassById(name);
        if (sc != null) {
            sit = sc.listProperties();
            while (sit.hasNext() && !found) {
                sp = sit.next();
                if (sp.getDisplayName(lex.getLanguage()).toLowerCase().equals(propertyName.toLowerCase())) {
                    found = true;
                    if (sp.isObjectProperty()) {
                        StringBuffer bf = new StringBuffer();
                        bf.append(sp.getRangeClass());

                        SemanticClass rg = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(bf.toString());
                        if (rg != null) {
                            res = res + lex.getObjWordTag(rg.getDisplayName(lex.getLanguage())).getType();
                        }
                    }
                    else {
                        errCode = 3;
                        eLog += "La propiedad " + sp.getDisplayName(lex.getLanguage()) + "no es de tipo Objeto.\n";
                    }
                }
            }

            if (!found) {
                eLog += "La clase " + sc.getDisplayName(lex.getLanguage()) + " no tiene una propiedad llamada ";
                if (sit.hasNext()) {
                    sp = sit.next();
                    eLog += sp.getDisplayName(lex.getLanguage()) + "\n";
                } else {
                    eLog += propertyName + "\n";
                }
                errCode = 3;
            }
        }
    return res ;
}

    /**
     * Fixes node names in the AST. Removes brackets in NAME nodes.
     * @param tree AST to fix.
     */
    private void fixNames(CommonTree tree) {
        //If the node is the root of a NAME
        if (nodeLabels.indexOf(tree.getText()) == -1) {
            //Set the current node's text to be the child text
            tree.token.setText(tree.getText().replaceAll("[\\[|\\]]", ""));
        }

        //Process all children of current node
        List<CommonTree> child = tree.getChildren();
        if (child != null) {
            Iterator<CommonTree> cit = tree.getChildren().iterator();
            while (cit.hasNext()) {
                fixNames(cit.next());
            }
        }
    }

    /**
     * Prints the given AST with indentation.
     * @param root AST to print.
     * @param indent indentation string.
     */
    private void traverseAST(CommonTree root, String indent) {
        System.out.println(indent + root.getText());
        List<CommonTree> chil = null;

        if (root.getChildCount() > 0) {
            chil = root.getChildren();
        }
        if (chil != null) {
            Iterator<CommonTree> cit = chil.iterator();
            while (cit.hasNext()) {
                CommonTree t = cit.next();
                traverseAST(t, indent + "  ");
            }
        }
    }

    /**
     * Gets the code of the last error occured.
     */
    public int getErrCode () {
        return errCode;
    }

    /**
     * Gets the error log for a parsing task.
     */
    public String getErrors () {
        return eLog;
    }
}