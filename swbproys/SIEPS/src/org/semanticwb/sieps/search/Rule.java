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
    private int priority;

    /**
     * Creates a new preprocessing rule with the given name, expression and
     * result.
     * @param nam Name of the rule.
     * @param exp Regular expression for tokenization.
     * @param res Replacement for matching rule.
     * @param pri Priority of application.
     */
    public Rule(String nam, String exp, String res, int pri) {
        name = nam;
        regexp = exp;
        result = res;
        priority = pri;
    }

    /**
     * Gets the application priority of the preprocessing rule.
     * @return priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the application priority for the preprocessing rule.
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Gets the name of the preprocessing rule.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the regular expression of the preprocessing rule.
     * @return
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * Gets the String replacement of the preprocessing rule.
     * @return
     */
    public String getResult() {
        return result;
    }
}