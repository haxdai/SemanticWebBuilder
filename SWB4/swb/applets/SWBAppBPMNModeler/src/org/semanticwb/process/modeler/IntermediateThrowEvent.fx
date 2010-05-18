/*
 * IntermediateThrowEvent.fx
 *
 * Created on 13/02/2010, 11:30:48 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.Cursor;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 * @author javier.solis
 */

public class IntermediateThrowEvent extends ThrowEvent
{
    public override function create(): Node
    {
        initializeCustomNode();
        stroke=Color.web(Styles.color_interEvent);
        cursor=Cursor.HAND;
        w=30;
        h=30;
        stkw=2;
        stkwo=2;
        scaleOff=-0.1;

        colorAdjust.hue=-0.83;
        colorAdjust.brightness=-0.07;
        colorAdjust.contrast=0.25;
        colorAdjust.saturation=1;

        shape= Circle
        {
            centerX: bind x
            centerY: bind y
            radius: bind w/2
            //styleClass: "event"
            style: Styles.style_event
            //smooth:true;
        };

        setType(type);

        return Group
        {
            content: [
                shape,
                //text,
                Circle
                {
                    centerX: bind x
                    centerY: bind y
                    radius: bind w/2-3
                    stroke: bind shape.stroke
                    //styleClass: "event"
                    style: Styles.style_event
                    //smooth:true;
                },
                message
            ]
            scaleX: bind s;
            scaleY: bind s;
            opacity: bind o;
            effect: Styles.dropShadow
            visible: bind canView()
        };
    }

    public override function canAttach(parent:GraphicalElement):Boolean
    {
        var ret=false;
        if(parent instanceof Pool or parent instanceof Lane)
        {
            ret=true;
        }
        return ret;
    }

    public override function canEndLink(link:ConnectionObject) : Boolean {
        var ret = true;
        //Un evento intermedio tipo throw sólo puede tener un flujo de secuencia entrante
        if (link instanceof SequenceFlow) {
            var c = sizeof getInputConnectionObjects();
            if (c != 0) {
                ret = false;
            }
        }
        return ret;
    }

    public override function canStartLink(link:ConnectionObject) : Boolean {
        var ret = true;
        //Un evento intermedio tipo throw sólo puede tener un flujo de secuencia de salida
        if (link instanceof SequenceFlow) {
            var c = sizeof getOutputConnectionObjects();
            if (c != 0) {
                ret = false;
            }
        }
        return ret;
    }
}



