/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.opensocial.model.data;

import org.json.JSONObject;
import org.semanticwb.opensocial.util.Scape;

/**
 *
 * @author victor.lorenzana
 */
public interface JSONConvertible {

    public JSONObject toJSONObject(Scape scape);
}
