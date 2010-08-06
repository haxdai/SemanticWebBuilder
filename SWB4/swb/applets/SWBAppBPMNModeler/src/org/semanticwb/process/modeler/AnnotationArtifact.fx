/*
 * AnnotationArtifact.fx
 *
 * Created on 13/02/2010, 10:55:36 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.Cursor;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Rectangle;

/**
 * @author javier.solis
 */

public class AnnotationArtifact extends Artifact
{
    override public function create(): Node
    {
        resizeable=true;
        cursor=Cursor.HAND;
        w=80;
        h=60;
        stkw=2;
        stkwo=2;
        text=EditableText
        {
            text: bind title with inverse
            x:bind x
            y:bind y
            width: bind w-6
            height: bind h
        }

        shape=Path
        {
            elements: [
                MoveTo { x: bind w/4  y: 0 },
                LineTo { x: 0  y: 0 },
                LineTo { x: 0  y: bind h },
                LineTo { x: bind w/4  y: bind h },
            ]
            style:Styles.style_artifact
            translateX:bind x-w/2
            translateY:bind y-h/2
        }

        setType(type);

        return Group
        {
            content: [
                Rectangle{
                    x:bind x-w/2
                    y:bind y-h/2
                    width:bind w
                    height:bind h
                    //style:Styles.style_artifact
                    fill:null
                }
                ,shape,text
            ]
            scaleX: bind s;
            scaleY: bind s;
            opacity: bind o;
            effect: Styles.dropShadow
            visible: bind canView()
        };
    }

    public override function canStartLink(link:ConnectionObject) : Boolean {
        var ret = super.canStartLink(link);

        if (link instanceof DirectionalAssociation) {
            ret = false;
            ModelerUtils.setErrorMessage(ModelerUtils.getLocalizedString("msgError2"));
        }        
        return ret;
    }

    public override function canEndLink(link:ConnectionObject) : Boolean {
        var ret = super.canEndLink(link);

        if (link instanceof DirectionalAssociation) {
            ret = false;
            ModelerUtils.setErrorMessage(ModelerUtils.getLocalizedString("msgError2"));
        }
        return ret;
    }
}