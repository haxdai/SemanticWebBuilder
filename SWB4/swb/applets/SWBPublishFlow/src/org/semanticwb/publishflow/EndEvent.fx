/*
 * EndEvent.fx
 *
 * Created on 26/02/2010, 12:50:06 PM
 */

package org.semanticwb.publishflow;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import org.semanticwb.publishflow.AuthorizeLink;
import org.semanticwb.publishflow.NoAuthorizeLink;
/**
 * @author victor.lorenzana
 */

public class EndEvent extends Event
{
    public override function create(): Node
    {
         var ret=super.create();
         title="Terminar flujo";
         stroke=Color.web(Styles.color_endEvent);
         shape.strokeWidth=4;
         stkw=4;
         stkwo=5;
         return ret;
    }

    override public function canEndLink(link: ConnectionObject): Boolean {
        if(link instanceof AuthorizeLink or link instanceof NoAuthorizeLink)
        {
            return true;
        }
        return false;

    }

    override public function canIniLink(link:ConnectionObject) : Boolean
    {
        return false;
    }
}
