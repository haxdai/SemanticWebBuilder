/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.sieps.search;

/**
 * Tokenization rule for query preprocessing.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class Rule {
    private String name;
    private String regexp;
    private String result;

    /**
     * Creates a new preprocessing rule with the given name, expression and
     * result.
     * @param nam Name of the rule.
     * @param exp Regular expression for tokenization.
     * @param res Replacement for matching rule.
     */
    public Rule(String nam, String exp, String res) {
        name = nam;
        regexp = exp;
        result = res;
    }

    /**
     * Gets the name of a preprocessing rule.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the regular expression of a preprocessing rule.
     * @return
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * Gets the String replacement of a preprocessing rule.
     * @return
     */
    public String getResult() {
        return result;
    }
}