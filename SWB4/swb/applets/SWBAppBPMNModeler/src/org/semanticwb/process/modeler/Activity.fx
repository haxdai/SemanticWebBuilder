/*
 * Activity.fx
 *
 * Created on 13/02/2010, 10:51:55 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * @author javier.solis
 */

public def TYPE_LOOP="loop";
public def TYPE_COMPENSATION="compensation";
public def TYPE_MULTIPLE="multiple";
public def TYPE_MULTIPLE_SEQUENTIAL="sequential";
public class Activity extends FlowNode
{
    public override var over on replace {
        if (over and not selected) {
            shape.styleClass = "taskHover";
        } else if (not selected) {
            shape.styleClass = "task";
        }
    }

    public override var selected on replace {
        if (selected) {
            shape.styleClass = "taskFocused";
        } else {
            shape.styleClass = "task";
        }
    }

    public override function create(): Node
    {
        var ret=super.create();
        return ret;
    }

    override public function mousePressed( e: MouseEvent )
    {
        super.mousePressed(e);
        updateAttachedEventsPosition();
    }

    override public function mouseDragged( e: MouseEvent )
    {
        if (not modeler.isLocked()) {
            var ax=dx+e.sceneX;
            var ay=dy+e.sceneY;
            if(ax-w/2>0)x=ax else x=w/2;
            if(ay-h/2>0)y=ay else y=h/2;
            updateAttachedEventsPosition();
        }
    }

    override public function mouseReleased( e: MouseEvent )
    {
        if (not modeler.isLocked()) {
            var overNode: GraphicalElement = getOverNode();
            setGraphParent(overNode);
            snapToGrid();
            updateAttachedEventsPosition();
        }
    }

    public override function canEndLink(link:ConnectionObject) : Boolean {
        var ret = super.canEndLink(link);

        if (link instanceof DirectionalAssociation and link.ini instanceof CompensationIntermediateCatchEvent) {
            ret = true;            
        } else if (link.ini instanceof ExclusiveIntermediateEventGateway) {
            ret = false;
            ModelerUtils.setErrorMessage(##"msgError1");
        }
        return ret;
    }

    public override function canStartLink(link: ConnectionObject) : Boolean {
        var ret = super.canStartLink(link);

        if (link instanceof DefaultFlow) {
            ModelerUtils.setErrorMessage(##"msgError2");
            ret = false;
        }
        return ret;
    }

    public function updateAttachedEventsPosition() : Void {
        for (evt in graphChilds) {
            evt.y = y + h /2 ;
            modeler.moveFront(evt, this);
        }
    }

    override public function getBoundsStart() : Point {
        return Point {
            x: x - w / 2
            y: y - h / 2
        }
    }

    override public function getBoundsEnd() : Point {
        return Point {
            x: x - w / 2 +w
            y: y - h / 2 +h
        }
    }
}