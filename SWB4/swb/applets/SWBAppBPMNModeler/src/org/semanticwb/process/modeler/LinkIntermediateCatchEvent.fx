/*
 * LinkIntermediateCatchEvent.fx
 *
 * Created on 13/02/2010, 11:19:11 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;

/**
 * @author javier.solis
 */

public class LinkIntermediateCatchEvent extends IntermediateCatchEvent
{
    public override function create(): Node
    {
        type=CATCH_LINK;
        return super.create();
    }

    public override function canEndLink(link:ConnectionObject) {
        return false;
    }

    public override function canStartLink(link:ConnectionObject) {
        var ret = super.canStartLink(link);
        if (link instanceof MessageFlow) {
            ret = false;
            ModelerUtils.setErrorMessage("LinkEvent cannot have outgoing MessageFlow");
        }
        return ret;
    }

    public override function canAttach(parent:GraphicalElement) : Boolean {
        var ret = super.canAttach(parent);

        if (parent instanceof Activity) {
            ret = false;
            ModelerUtils.setErrorMessage("LinkEvent cannot be attached to activities");
        }
        return ret;
    }

}
