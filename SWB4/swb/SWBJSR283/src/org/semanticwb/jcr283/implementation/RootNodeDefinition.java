/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.jcr283.implementation;

import javax.jcr.version.OnParentVersionAction;

/**
 *
 * @author victor.lorenzana
 */
public class RootNodeDefinition extends NodeDefinitionImp  {

    public RootNodeDefinition(NodeTypeImp nodeType,NodeTypeImp defaultPrimaryType)
    {
        super("", true, true, OnParentVersionAction.VERSION, nodeType, true, false, defaultPrimaryType);
    }
}
