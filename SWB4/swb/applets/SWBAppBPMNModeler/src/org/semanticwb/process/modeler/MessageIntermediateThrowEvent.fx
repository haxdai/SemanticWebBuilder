/*
 * MessageIntermediateThrowEvent.fx
 *
 * Created on 13/02/2010, 11:19:11 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;

/**
 * @author javier.solis
 */

public class MessageIntermediateThrowEvent extends IntermediateThrowEvent
{
    public override function create(): Node
    {
        type=THROW_MESSAGE;
        return super.create();
    }

    public override function canStartLink(link:ConnectionObject) : Boolean {
        var ret = super.canStartLink(link);
        var c = 0;

        for(ele in getOutputConnectionObjects()) {
            if(ele instanceof MessageFlow) {
                c++;
            }
        }

        if (link instanceof MessageFlow and c != 0) {
            ret = false;
            ModelerUtils.setErrorMessage("MessageIntermediateThrowEvent can have only one outgoing MessageFlow");
        }
        return ret;
    }

    public override function canEndLink(link:ConnectionObject) : Boolean {
        var ret = super.canEndLink(link);

        if (link instanceof MessageFlow) {
            ret = false;
            ModelerUtils.setErrorMessage("MessageIntermediateThrowEvent cannot have incoming MessageFlow");
        }
        return ret;
    }
}
