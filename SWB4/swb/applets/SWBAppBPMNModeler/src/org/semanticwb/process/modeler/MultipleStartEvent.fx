/*
 * MultipleStartEvent.fx
 *
 * Created on 13/02/2010, 10:55:36 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;

/**
 * @author javier.solis
 */

public class MultipleStartEvent extends StartEvent
{
    override public function create(): Node
    {
        type=CATCH_MULTIPLE;
        return super.create();
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