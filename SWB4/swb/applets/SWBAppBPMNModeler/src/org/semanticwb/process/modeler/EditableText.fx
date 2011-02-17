/*
 * EditableText.fx
 *
 * Created on 13/02/2010, 10:31:11 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.CustomNode;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.control.TextBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextOrigin;

/**
 * @author javier.solis
 */

public class EditableText extends CustomNode
{
    public var x : Number;
    public var y : Number;
    public var width : Number;
    public var owner: Node;
    public var autoSizeParent:Boolean=false;
    public var size:Number = 10;
    public var height : Number;
    public var text : String;
    public var fill : Boolean;
    var textb : TextBox;
    var textl : Text;

    var first : Boolean =true;

    var f=bind textb.focused on replace
    {
        if(not f)
        {
            if(first)
            {
                //textb.text=text;
                first=false;
            }else
            {
                stopEditing();
            }
        }
    }

    public function stopEditing() :Void
    {
        textb.commit();
        text=textb.text;
        cancelEditing();
    }

    public function cancelEditing() :Void
    {
        textb.visible=false;        
        textl.visible=true;
        if (autoSizeParent and owner instanceof GraphicalElement) {
            var t = owner as GraphicalElement;
            t.setWidth(textl.boundsInLocal.width + 5);
            t.setHeight(textl.boundsInLocal.height + 5);
        }
    }

    public function startEditing() :Void
    {
        textb.text=text;
        textl.visible=false;
        textb.visible=true;
        textb.selectAll();
        textb.requestFocus();
    }

    public override function create(): Node
    {
        textl= Text
        {
             content: bind "{text}\r"
             //style: Styles.style_task_text
             font: Font {
                name: "Verdana"
                embolden: true
                size: size
             }
             textOrigin: TextOrigin.TOP
             textAlignment: TextAlignment.CENTER
             wrappingWidth: bind width
             translateX:bind x-(textl.boundsInLocal.width)/2+2
             translateY:bind y-(textl.boundsInLocal.height)/2
             boundsType:TextBoundsType.VISUAL
             visible: true
        };

        var back;
        if(text!=null and fill)
        {
            back=Rectangle
            {
                x:bind textl.translateX-2
                y:bind textl.translateY-2
                width:bind textl.boundsInLocal.width
                height:bind textl.boundsInLocal.height
                style: Styles.style_tooltip
            };
        }

        textb= TextBox
        {
             text: text
             font: bind textl.font
             //style: Styles.style_task_textbox
             translateX:bind x - width/2
             translateY:bind y -10
             width:bind width
             height: 20
             visible: false
             selectOnFocus:true
             //tooltip:Tooltip{text:bind text}
             //multiline:true
             onKeyTyped:function(k:KeyEvent)
             {
                 //if(k.char=="\n")stopEditing();
                 var c=0+k.char.charAt(0);
                 if(c==27)cancelEditing();
                 //println(c);
             }
             action: function() {
                stopEditing();
             }
        };
        return Group
        {
            content: [
               back,textl,textb
            ]
        };
    }

    public function setSize(txtsize: Number) {
        this.size = txtsize;
        this.textl.font = Font {
            name:"Verdana"
            embolden:true
            size:size
        }
    }

    public function getSize(): Number {
        return this.size;
    }
}
