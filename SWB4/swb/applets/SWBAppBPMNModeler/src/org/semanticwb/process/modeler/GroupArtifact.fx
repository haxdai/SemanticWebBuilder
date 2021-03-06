/*
 * GroupArtifact.fx
 *
 * Created on 13/02/2010, 10:55:36 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.input.MouseEvent;

/**
 * @author javier.solis
 */

public class GroupArtifact extends Artifact
{
    public override var over on replace {
        if (over and not selected) {
            shape.styleClass = "artifactHover";
        } else if (not selected) {
            shape.styleClass = "artifact";
        }
    }

    public override var selected on replace {
        if (selected) {
            shape.styleClass = "artifactFocused";
        } else {
            shape.styleClass = "artifact";
        }
    }

    override public function create(): Node
    {
        blocksMouse = true;
        setCommonMenuOptions();
        resizeable=true;
        w=150;
        h=150;
        minW = w;
        minH = h;
        
        text=EditableText
        {
            text: bind title with inverse
            x:bind shape.boundsInParent.minX + text.boundsInLocal.width / 2 + (shape.boundsInParent.width - text.boundsInLocal.width) / 2
            y:bind shape.boundsInParent.minY + 15
            width: bind w-6
            height: bind h
        }

        shape=Path
        {
            elements: [
                MoveTo { x: 0  y: 0 },
                LineTo { x: 0  y: bind h },
                LineTo { x: bind w y: bind h },
                LineTo { x: bind w  y: 0 },
                LineTo { x: 0  y: 0 }
            ]
            styleClass: "connObject"
            translateX:bind x-w/2
            translateY:bind y-h/2
            strokeDashArray: [20,5,3,5]
            onKeyPressed: onKeyPressed
            onKeyReleased: onKeyReleased

        };

        var actions: MenuItem[] = [
            MenuItem {
                caption: ##"actCopy"
                action: function(e: MouseEvent) {
                    ModelerUtils.popup.hide();
                    var t = copy();
                    modeler.setCopyNode(t);
                }
            },
            MenuItem {
                caption: ##"actCut"
                action: function(e: MouseEvent) {
                    ModelerUtils.popup.hide();
                    var t = cut();
                    modeler.setCopyNode(t);
                    ModelerUtils.setResizeNode(null);
                }
            }
        ];
        insert actions before menuOptions[0];

        setType(TYPE_GROUP);

        return Group
        {
            content: [
                shape,text
            ]
            scaleX: bind s;
            scaleY: bind s;
            visible: bind canView()
        };
    }

    public override function canStartLink(link:ConnectionObject) : Boolean {
        ModelerUtils.setErrorMessage(##"msgError46");
        return false;
    }

    public override function canEndLink(link:ConnectionObject) : Boolean {
        ModelerUtils.setErrorMessage(##"msgError46");
        return false;
    }

    override public function copy() : GraphicalElement {
        var t = GroupArtifact {
            title: this.title
            type: this.type
            modeler: this.modeler
            isLoop: this.isLoop
            isForCompensation: this.isForCompensation
            isMultiInstance: this.isMultiInstance
            container: this.container
            x: this.x + 10
            y: this.y + 10
            uri: "new:{type}:{modeler.toolBar.counter++}"
        }
        return t;
    }
}