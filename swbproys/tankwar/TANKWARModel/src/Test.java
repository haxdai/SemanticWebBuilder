
import java.util.Iterator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebSite;
import org.semanticwb.tankwar.base.TankBase;
import org.semanticwb.tankwar.Tank;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javier.solis.g
 */
public class Test {
    
    public void main()
    {
        WebSite site=SWBContext.getWebSite("TankWar");
        Iterator<Tank> it=Tank.ClassMgr.listTanks(site);
        while (it.hasNext()) {
            Tank tank = it.next();
            tank.setScore(0);
            tank.setTieGames(0);
            tank.setWonGames(0);
            tank.setLostGames(0);
        }
        
        Tank tank=Tank.ClassMgr.getTank("15", site);
        tank.setScore(10);
        tank=Tank.ClassMgr.getTank("15", site);
        tank.setScore(20);
        tank=Tank.ClassMgr.getTank("7", site);
        tank.setScore(30);
        tank=Tank.ClassMgr.getTank("14", site);
        tank.setScore(40);
        
    }
    
}
