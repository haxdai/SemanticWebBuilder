/*
 * Tooltip.fx
 *
 * Created on 5/03/2010, 01:46:17 PM
 */

package org.semanticwb.process.modeler;

import javafx.scene.CustomNode;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;

/**
 * @author victor.lorenzana
 * @modified by Hasdai Pacheco {haxdai@gmail.com}
 */

public def TOOLTIP_ERROR = "error";
public def TOOLTIP_WARNING = "warning";
public def TOOLTIP_NORMAL = "normal";

public class ToolTip extends CustomNode {
    public var x:Number;
    public var y:Number;
    public var text:String;
    public var error:Boolean;
    var _root: Group;
    var t:Text;
    var r:Rectangle;
    var p: Polygon;
    
    override var opacity = 0.0;
    def timeLine: Timeline = Timeline {
        keyFrames: [
            at (0s) {
                opacity => 0.0;
            },
            at (800ms) {
                opacity => 1.0 tween Interpolator.EASEBOTH;
            }
        ]
    }

    def lightGrad = LinearGradient {
        startX: 0.0
        startY: 0.0
        endX: 0.0
        endY:1.0
        stops: [
            Stop {
                offset: 0.0
                color: Color.color(Color.WHITE.red, Color.WHITE.green, Color.WHITE.blue, .2)
            }
            Stop {
                offset: 1.0
                color: Color.color(Color.WHITE.red, Color.WHITE.green, Color.WHITE.blue, .8)
            }
        ]
    }


    function initializeCustomNode(): Void
    {
        _root = Group {
            content: [
                r = Rectangle {
                    x: bind x
                    y: bind y
                    arcWidth: 10
                    arcHeight: 10
                //Bind the rectangle width with the Text width.
                    width: bind t.boundsInParent.width+5
                    height: bind t.boundsInParent.height+5
                    styleClass: bind if (error) "ToolTipError" else "ToolTip"
                    id: "border"
                },
                Rectangle {
                        x: bind x + 1
                        y: bind y + 1
                        width: bind r.width - 2
                        height: bind r.height - 2
                        styleClass: bind if (error) "ToolTipError" else "ToolTip"
                        id: "rect"
                },
                Rectangle {
                        x: bind r.x + 2
                        y: bind r.y + r.height - (r.height / 4) - 2
                        arcWidth: 2
                        arcHeight: 2
                        width: bind r.width - 4
                        height: bind r.height / 4
                        fill: lightGrad
                },
                p = Polygon {
                    points: bind [r.x + 10, r.y+2, r.x + 15, r.y - 8, r.x+20, r.y+2]
                    styleClass: bind if (error) "ToolTipError" else "ToolTip"
                    id: "triangle"
                    visible: bind (not error)
                },                
                Polyline {
                    points: bind [r.x + 10, r.y, r.x + 16, r.y - 7, r.x+20, r.y]
                    styleClass: bind if (error) "ToolTipError" else "ToolTip"
                    id: "triangleBorder"
                    visible: bind (not error)
                },
                t = Text {
                    x:bind r.x+4;
                    y:bind r.y+12;
                    content:bind text
                    font: Font {
                        size:10
                        name:"Verdana"
                    }
                }
            ]
        }

    }
    protected override function create() : Node {
        if (_root == null) {
            initializeCustomNode();
        }
        return _root;
    }

    public function show(): Void {
        this.visible = true;
        timeLine.playFromStart();
    }

    public function hide(): Void {
        if (timeLine.running) {
            timeLine.stop();
        }
        this.visible = false;
    }

    public function setType(type: String): Void {
        if (type == TOOLTIP_ERROR) {
            error = true;
        } else if (type == TOOLTIP_WARNING or type == TOOLTIP_NORMAL) {
            error = false;
        }
    }
}