/*
 * FlowObject.fx
 *
 * Created on 26/02/2010, 12:28:31 PM
 */

package org.semanticwb.publishflow;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import java.lang.Math;
/**
 * @author victor.lorenzana
 */

public class FlowObject extends GraphElement
{
    public-read  var connectionPoints : ConnectionPoint[];
    //public var pool : Pool;
    public var dpx : Number;                        //diferencia de pool
    public var dpy : Number;                        //diferencia de pool

    override public function create(): Node
    {
        zindex=2;
        text=EditableText
        {
            text: bind title with inverse
            width: bind w;
            height: bind h;
        }
        connectionPoints=[
                ConnectionPoint
                {
                    x: bind {x}+w/2;
                    y:bind {y};
                },
                ConnectionPoint
                {
                    x:bind {x}-w/2;
                    y:bind {y};
                    
                },
                ConnectionPoint
                {
                    x: bind {x};
                    y:bind {y}+h/2;
                },
                ConnectionPoint
                {
                    x:bind {x};
                    y:bind {y}-h/2;
                }
                ];
        return text;

    }
    public function getAvailablePoint(point : Point) : ConnectionPoint
    {
        var pointToReturn : ConnectionPoint;
        for(cpoint in connectionPoints)
        {
            if(cpoint.connectionObject==null)
            {
                if(pointToReturn==null)
                {
                    pointToReturn=cpoint;
                }
                else
                {
                    var d1:Number;
                    var d2:Number;
                    d1=Math.sqrt(Math.pow(point.x-cpoint.x, 2)+Math.pow(point.y-cpoint.y, 2));
                    d2=Math.sqrt(Math.pow(point.x-pointToReturn.x, 2)+Math.pow(point.y-pointToReturn.y, 2));
                    if(d1<d2)
                    {
                        pointToReturn=cpoint;
                    }
                }
            }
        }
        return pointToReturn;
    }

    public function getConnectionPoint(point : FlowObject) : ConnectionPoint
    {
        var pointToReturn : ConnectionPoint;
        for(cpoint in connectionPoints)
        {
            if(cpoint.connectionObject==null)
            {
                if(pointToReturn==null)
                {
                    pointToReturn=cpoint;
                }
                else
                {
                    var d1:Number;
                    var d2:Number;
                    d1=cpoint.getDistance(point);
                    d2=pointToReturn.getDistance(point);
                    if(d1<d2)
                    {
                        pointToReturn=cpoint;
                    }
                }
            }
        }
        return pointToReturn;

    }

    

    

    /*var px = bind pool.x on replace
    {
        if(pool!=null)x=px+dpx;
    }
    var py = bind pool.y on replace
    {
        if(pool!=null)y=py+dpy;
    }*/


    override public function mousePressed( e: MouseEvent )
    {
        super.mousePressed(e);
    }

    override public function mouseReleased( e: MouseEvent )
    {
        //println("FlowObject mouseReleased:{e} {modeler.overNode}");
        super.mouseReleased(e);
        /*if(modeler.overPool instanceof Pool)
        {
            dpx=x-modeler.overPool.x;
            dpy=y-modeler.overPool.y;
            pool=modeler.overPool as Pool;
        }else
        {
            pool=null;
        }*/
        super.mouseReleased(e);
//        if(pool!=null)
//        {
//        }
    }

    override public function remove()
    {
        super.remove();
    }
}
