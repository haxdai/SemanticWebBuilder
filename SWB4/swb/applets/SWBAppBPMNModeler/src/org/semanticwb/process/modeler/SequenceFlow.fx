/*
 * SequenceFlow.fx
 *
 * Created on 13/02/2010, 10:51:55 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Clase que representa un flujo de secuencia en un diagrama BPMN 2.0
 * @author javier.solis
 */

public class SequenceFlow extends ConnectionObject
{
    public override function create(): Node
    {
        arrowType=ARROW_TYPE_SEQUENCE;
        var ret=super.create();
        return ret;
    }

    public override var onMouseClicked = function (e: MouseEvent) {
        if (e.button == e.button.SECONDARY) {
            var p = Point {
                x: e.sceneX
                y: e.sceneY
            };
            addLineHandler(p);
        }
    }

    public override function copy() : ConnectionObject {
        var t = SequenceFlow {
            ini: this.ini
            end: this.end
            modeler: this.modeler
            strokeDash: this.strokeDash
            //cubicCurve: this.cubicCurve
            uri:"new:sequenceflow:{modeler.toolBar.counter++}"
        }

        for (handle in handles) {
            t.addLineHandler(handle.getPoint());
        }
        return t;
    }
}
