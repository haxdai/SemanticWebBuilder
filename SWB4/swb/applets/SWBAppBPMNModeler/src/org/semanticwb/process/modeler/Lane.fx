/*
 * Pool.fx
 *
 * Created on 13/02/2010, 10:55:36 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Cursor;
import javafx.scene.shape.Line;

/**
 * @author javier.solis
 */

public class Lane extends GraphElement
{
    var xh=bind h on replace
    {
        //y=getGraphParent().y-getGraphParent().h/2+boundsInParent.minY+h/2;
        getGraphParent().updateSize();
    };

    override public function create(): Node
    {
        stkw=1;
        stkwo=1;
        resizeable=true;
        resizeType=ResizeNode.RESIZE_V;
        cursor=Cursor.HAND;
        //w=600;
        h=200;
        useGrid=false;
        text=EditableText
        {
            text: bind title with inverse
            x:bind x-w/2+10
            y:bind y
            width: bind h
            height: 20
            rotate: -90
        }

        shape= Rectangle
        {
            x: bind x-w/2
            y: bind y-h/2+1
            width: bind w-20
            height: bind h-1
            style: Styles.style_pool
            //smooth:true;
        };

        return Group
        {
            content: [
                shape,Line
                {
                    startX: bind x-w/2+20
                    startY: bind y-h/2+1
                    endX: bind x-w/2+20
                    endY: bind y+h/2-1
                    style: Styles.style_pool_line
                    stroke: bind shape.stroke
                },text
            ]
            scaleX: bind s;
            scaleY: bind s;
            opacity: bind o;
            effect: Styles.dropShadow
            visible: bind canView()
        };
    }

    override public function mouseEntered( e: MouseEvent )
    {
        super.mouseEntered(e);
    }

    override public function mouseExited( e: MouseEvent )
    {
        super.mouseExited(e);
    }

    override public function mousePressed( e: MouseEvent )
    {
        super.mousePressed(e);
        if(getGraphParent()!=null)
        {
            dx=getGraphParent().x-e.sceneX;
            dy=getGraphParent().y-e.sceneY;
        }
    }

    public function getPool():Pool
    {
        var ret:Pool;
        var a=getGraphParent();
        while(a!=null and not (a instanceof Pool))
        {
            a=a.getGraphParent();
        }
        if(a!=null)ret=a as Pool;
        return ret;
    }
    


    override public function mouseDragged( e: MouseEvent )
    {
        var p=getGraphParent();
        if(p!=null)
        {
            var ax=dx+e.sceneX;
            var ay=dy+e.sceneY;
            if(ax-p.w/2>0)p.x=ax else p.x=p.w/2;
            if(ay-p.h/2>0)p.y=ay else p.y=p.h/2;
        }else
        {
            super.mouseDragged(e);
        }
    }    

    override public function mouseReleased( e: MouseEvent )
    {
        super.mouseReleased(e);
        var p=getGraphParent();
        p.snapToGrid();
    }


    override public function remove()
    {
       //println("remove lane {getGraphParent()}");
       super.remove();
       if(getGraphParent() instanceof Pool)
       {
           var pool=getGraphParent() as Pool;
           pool.removeLane(this);
       }
       
    }

    override public function canIniLink(link:ConnectionObject) : Boolean
    {
        return false;
    }

    override public function canEndLink(link:ConnectionObject) : Boolean
    {
        return false;
    }

    public override function canAttach(parent:GraphElement):Boolean
    {
        var ret=false;
        if(parent instanceof Pool or parent instanceof Lane)
        {
            ret=true;
        }
        return ret;
    }

    public override function onParentXChange()
    {
        if(getGraphParent()!=null)x=getGraphParent().x+20
    }

    public override function onParentYChange()
    {
        //The parent change in function of childs
    }


}