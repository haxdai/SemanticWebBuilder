/*
 * MessageStartEvent.fx
 *
 * Created on 13/02/2010, 10:55:36 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import org.semanticwb.process.modeler.ModelerUtils;

/**
 * @author javier.solis
 */

public class MessageStartEvent extends StartEvent
{
    override public function create(): Node
    {
        type=CATCH_MESSAGE;
        return super.create();
    }

    override public function canEndLink(link:ConnectionObject) : Boolean
    {
        var ret = super.canEndLink(link);

        if(link instanceof MessageFlow) {
            var c = sizeof getInputConnectionObjects();
            if(c == 0) {
                ret = true;
            } else {
                ModelerUtils.setErrorMessage(ModelerUtils.getLocalizedString("msgError36"));
            }
        }
        return ret;
    }

    override public function canAddToDiagram(): Boolean {
        var ret = true;
        var c = 0;
        if (modeler.containerElement instanceof EventSubProcess) {
            for (child in modeler.containerElement.containerChilds) {
                if (child instanceof StartEvent) {
                    c++;
                }
            }

            if (c != 0) {
                ret = false;
                ModelerUtils.setErrorMessage(ModelerUtils.getLocalizedString("msgError44"));
            }
        }

        return ret;
    }
}