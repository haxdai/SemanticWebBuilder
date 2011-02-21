/*
 * StartEvent.fx
 *
 * Created on 13/02/2010, 11:29:53 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import org.semanticwb.process.modeler.AdhocSubProcess;
import org.semanticwb.process.modeler.MultipleStartEvent;
import javafx.scene.input.MouseEvent;

/**
 * @author javier.solis
 */

public class StartEvent extends CatchEvent
{
    public override function create(): Node
    {
         var ret=super.create();
         colorAdjust.hue=0.52;
         colorAdjust.brightness=-0.19;
         colorAdjust.contrast=0.25;
         colorAdjust.saturation=1;
         shape.styleClass = "startEvent";

        var actions : MenuItem[] = [
            MenuItem {isSeparator: true},
            MenuItem {
                caption: ##"actCopy"
                action: function(e: MouseEvent) {
                    var t = copy();
                    modeler.copyNode = t;
                    ModelerUtils.popup.hide();
                }
            }
        ];

        insert actions before menuOptions[0];

        return ret;
    }

    override public function canEndLink(link:ConnectionObject) : Boolean
    {
        var ret = super.canEndLink(link);

        if (link instanceof SequenceFlow) {
            ret = false;
            ModelerUtils.setErrorMessage(##"msgError33");
        }

        if (link instanceof MessageFlow and not (this instanceof MultipleStartEvent)) {
            ModelerUtils.setErrorMessage(##"msgError34");
            ret = false;
        }
        return ret;
    }

    override public function canStartLink(link:ConnectionObject) : Boolean
    {
        var ret = super.canStartLink(link);
        
        if(link instanceof MessageFlow) {
            ret = false;
            ModelerUtils.setErrorMessage(##"msgError35");
        }
        return ret;
    }

    override public function canAddToDiagram(): Boolean {
        var ret = super.canAddToDiagram();
        var c = 0;
        
        if (modeler.containerElement != null) {
            for (child in modeler.containerElement.containerChilds) {
                if (child instanceof StartEvent) {
                    c++;
                }
            }
            
            if (modeler.containerElement instanceof EventSubProcess) {
                ret = false;
                if (c != 0) {
                    ModelerUtils.setErrorMessage(##"msgError44");
                } else {
                    ModelerUtils.setErrorMessage(##"msgError41");
                }
            } else if (modeler.containerElement instanceof AdhocSubProcess) {
                ret = false;
                ModelerUtils.setErrorMessage(##"msgError48");
            } else if (c != 0) {
                ret = false;
                ModelerUtils.setErrorMessage(##"msgError44");
            }
        }
        return ret;
    }

    override public function copy() : GraphicalElement {
        var t = StartEvent {
            title: this.title
            type: this.type
            modeler: this.modeler
            container: this.container
        }
        t.uri = "new:event:{modeler.toolBar.counter++}";
        return t;
    }
}